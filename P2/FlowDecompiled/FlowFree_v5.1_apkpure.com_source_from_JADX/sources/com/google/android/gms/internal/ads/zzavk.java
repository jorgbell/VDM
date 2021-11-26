package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.mopub.common.Constants;
import com.mopub.mobileads.GooglePlayServicesRewardedVideo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzavk implements zzavm {
    static zzavm zza;
    static zzavm zzb;
    private static final Object zzc = new Object();
    private final Object zzd = new Object();
    private final Context zze;
    private final WeakHashMap<Thread, Boolean> zzf = new WeakHashMap<>();
    private final ExecutorService zzg;
    private final zzbbq zzh;

    protected zzavk(Context context, zzbbq zzbbq) {
        zzebp.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzbbq;
    }

    public static zzavm zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (zzagj.zze.zze().booleanValue()) {
                    if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeZ)).booleanValue()) {
                        zza = new zzavk(context, zzbbq.zza());
                    }
                }
                zza = new zzavl();
            }
        }
        return zza;
    }

    public static zzavm zzb(Context context, zzbbq zzbbq) {
        synchronized (zzc) {
            if (zzb == null) {
                if (zzagj.zze.zze().booleanValue()) {
                    if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeZ)).booleanValue()) {
                        zzavk zzavk = new zzavk(context, zzbbq);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzavk.zzd) {
                                zzavk.zzf.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzavj(zzavk, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzavi(zzavk, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzavk;
                    }
                }
                zzb = new zzavl();
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzc(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzbbd.zzi(stackTraceElement.getClassName());
                    z2 |= zzavk.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                zze(th, "", 1.0f);
            }
        }
    }

    public final void zzd(Throwable th, String str) {
        zze(th, str, 1.0f);
    }

    public final void zze(Throwable th, String str, float f) {
        boolean z;
        String str2;
        if (zzbbd.zzg(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzerm.zzc(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            double d = (double) f;
            double random = Math.random();
            int i = f > 0.0f ? (int) (1.0f / f) : 1;
            if (random < d) {
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    z = Wrappers.packageManager(this.zze).isCallerInstantApp();
                } catch (Throwable th2) {
                    zzbbk.zzg("Error fetching instant app info", th2);
                    z = false;
                }
                try {
                    str2 = this.zze.getPackageName();
                } catch (Throwable unused) {
                    zzbbk.zzi("Cannot obtain package name, proceeding.");
                    str2 = "unknown";
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme(Constants.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str3 = Build.MANUFACTURER;
                String str4 = Build.MODEL;
                if (!str4.startsWith(str3)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
                    sb.append(str3);
                    sb.append(" ");
                    sb.append(str4);
                    str4 = sb.toString();
                }
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str4).appendQueryParameter("js", this.zzh.zza).appendQueryParameter(GooglePlayServicesRewardedVideo.KEY_EXTRA_APPLICATION_ID, str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", stringWriter2).appendQueryParameter("eids", TextUtils.join(",", zzaeq.zzc())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "367272508").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzagj.zzc.zze()));
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaV)).booleanValue()) {
                    appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze))).appendQueryParameter("lite", true != this.zzh.zze ? "0" : "1");
                }
                arrayList.add(appendQueryParameter2.toString());
                for (String zzavh : arrayList) {
                    this.zzg.execute(new zzavh(new zzbbp((String) null), zzavh));
                }
            }
        }
    }
}
