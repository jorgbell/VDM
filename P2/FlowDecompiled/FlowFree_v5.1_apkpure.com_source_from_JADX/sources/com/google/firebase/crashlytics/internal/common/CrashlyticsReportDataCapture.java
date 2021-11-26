package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CrashlyticsReportDataCapture {
    private static final Map<String, Integer> ARCHITECTURES_BY_NAME;
    static final String GENERATOR = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"17.4.1"});
    private final AppData appData;
    private final Context context;
    private final IdManager idManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;

    static {
        HashMap hashMap = new HashMap();
        ARCHITECTURES_BY_NAME = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context2, IdManager idManager2, AppData appData2, StackTraceTrimmingStrategy stackTraceTrimmingStrategy2) {
        this.context = context2;
        this.idManager = idManager2;
        this.appData = appData2;
        this.stackTraceTrimmingStrategy = stackTraceTrimmingStrategy2;
    }

    public CrashlyticsReport captureReportData(String str, long j) {
        CrashlyticsReport.Builder buildReportData = buildReportData();
        buildReportData.setSession(populateSessionData(str, j));
        return buildReportData.build();
    }

    public CrashlyticsReport.Session.Event captureEventData(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        int i3 = this.context.getResources().getConfiguration().orientation;
        Throwable th2 = th;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        String str2 = str;
        builder.setType(str);
        long j2 = j;
        builder.setTimestamp(j);
        builder.setApp(populateEventApplicationData(i3, trimmedThrowableData, thread, i, i2, z));
        builder.setDevice(populateEventDeviceData(i3));
        return builder.build();
    }

    private CrashlyticsReport.Builder buildReportData() {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        builder.setSdkVersion("17.4.1");
        builder.setGmpAppId(this.appData.googleAppId);
        builder.setInstallationUuid(this.idManager.getCrashlyticsInstallId());
        builder.setBuildVersion(this.appData.versionCode);
        builder.setDisplayVersion(this.appData.versionName);
        builder.setPlatform(4);
        return builder;
    }

    private CrashlyticsReport.Session populateSessionData(String str, long j) {
        CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        builder.setStartedAt(j);
        builder.setIdentifier(str);
        builder.setGenerator(GENERATOR);
        builder.setApp(populateSessionApplicationData());
        builder.setOs(populateSessionOperatingSystemData());
        builder.setDevice(populateSessionDeviceData());
        builder.setGeneratorType(3);
        return builder.build();
    }

    private CrashlyticsReport.Session.Application populateSessionApplicationData() {
        CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        builder.setIdentifier(this.idManager.getAppIdentifier());
        builder.setVersion(this.appData.versionCode);
        builder.setDisplayVersion(this.appData.versionName);
        builder.setInstallationUuid(this.idManager.getCrashlyticsInstallId());
        String unityVersion = this.appData.unityVersionProvider.getUnityVersion();
        if (unityVersion != null) {
            builder.setDevelopmentPlatform("Unity");
            builder.setDevelopmentPlatformVersion(unityVersion);
        }
        return builder.build();
    }

    private CrashlyticsReport.Session.OperatingSystem populateSessionOperatingSystemData() {
        CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        builder.setPlatform(3);
        builder.setVersion(Build.VERSION.RELEASE);
        builder.setBuildVersion(Build.VERSION.CODENAME);
        builder.setJailbroken(CommonUtils.isRooted(this.context));
        return builder.build();
    }

    private CrashlyticsReport.Session.Device populateSessionDeviceData() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int deviceArchitecture = getDeviceArchitecture();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(this.context);
        int deviceState = CommonUtils.getDeviceState(this.context);
        String str = Build.MANUFACTURER;
        String str2 = Build.PRODUCT;
        CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        builder.setArch(deviceArchitecture);
        builder.setModel(Build.MODEL);
        builder.setCores(availableProcessors);
        builder.setRam(totalRamInBytes);
        builder.setDiskSpace(blockCount);
        builder.setSimulator(isEmulator);
        builder.setState(deviceState);
        builder.setManufacturer(str);
        builder.setModelClass(str2);
        return builder.build();
    }

    private CrashlyticsReport.Session.Event.Application populateEventApplicationData(int i, TrimmedThrowableData trimmedThrowableData, Thread thread, int i2, int i3, boolean z) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(this.appData.packageName, this.context);
        if (appProcessInfo != null) {
            bool = Boolean.valueOf(appProcessInfo.importance != 100);
        } else {
            bool = null;
        }
        CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        builder.setBackground(bool);
        builder.setUiOrientation(i);
        builder.setExecution(populateExecutionData(trimmedThrowableData, thread, i2, i3, z));
        return builder.build();
    }

    private CrashlyticsReport.Session.Event.Device populateEventDeviceData(int i) {
        BatteryState batteryState = BatteryState.get(this.context);
        Float batteryLevel = batteryState.getBatteryLevel();
        Double valueOf = batteryLevel != null ? Double.valueOf(batteryLevel.doubleValue()) : null;
        int batteryVelocity = batteryState.getBatteryVelocity();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(this.context);
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(this.context);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        builder.setBatteryLevel(valueOf);
        builder.setBatteryVelocity(batteryVelocity);
        builder.setProximityOn(proximitySensorEnabled);
        builder.setOrientation(i);
        builder.setRamUsed(totalRamInBytes);
        builder.setDiskUsed(calculateUsedDiskSpaceInBytes);
        return builder.build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution populateExecutionData(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, int i2, boolean z) {
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        builder.setThreads(populateThreadsList(trimmedThrowableData, thread, i, z));
        builder.setException(populateExceptionData(trimmedThrowableData, i, i2));
        builder.setSignal(populateSignalData());
        builder.setBinaries(populateBinaryImagesList());
        return builder.build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> populateThreadsList(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(populateThreadData(thread, trimmedThrowableData.stacktrace, i));
        if (z) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(populateThreadData(thread2, this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return ImmutableList.from(arrayList);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return populateThreadData(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        builder.setName(thread.getName());
        builder.setImportance(i);
        builder.setFrames(ImmutableList.from(populateFramesList(stackTraceElementArr, i)));
        return builder.build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> populateFramesList(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement populateFrameData : stackTraceElementArr) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
            builder.setImportance(i);
            arrayList.add(populateFrameData(populateFrameData, builder));
        }
        return ImmutableList.from(arrayList);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        return populateExceptionData(trimmedThrowableData, i, i2, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.className;
        String str2 = trimmedThrowableData.localizedMessage;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.cause;
                i4++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        builder.setType(str);
        builder.setReason(str2);
        builder.setFrames(ImmutableList.from(populateFramesList(stackTraceElementArr, i)));
        builder.setOverflowCount(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            builder.setCausedBy(populateExceptionData(trimmedThrowableData2, i, i2, i3 + 1));
        }
        return builder.build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame populateFrameData(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0) : 0;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = (long) stackTraceElement.getLineNumber();
        }
        builder.setPc(max);
        builder.setSymbol(str);
        builder.setFile(fileName);
        builder.setOffset(j);
        return builder.build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> populateBinaryImagesList() {
        return ImmutableList.from((E[]) new CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[]{populateBinaryImageData()});
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage populateBinaryImageData() {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        builder.setBaseAddress(0);
        builder.setSize(0);
        builder.setName(this.appData.packageName);
        builder.setUuid(this.appData.buildId);
        return builder.build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal populateSignalData() {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        builder.setName("0");
        builder.setCode("0");
        builder.setAddress(0);
        return builder.build();
    }

    private static int getDeviceArchitecture() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = ARCHITECTURES_BY_NAME.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }
}
