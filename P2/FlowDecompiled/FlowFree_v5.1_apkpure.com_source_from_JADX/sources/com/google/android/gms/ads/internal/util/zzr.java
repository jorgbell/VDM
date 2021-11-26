package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.impl.R$string;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafo;
import com.google.android.gms.internal.ads.zzagj;
import com.google.android.gms.internal.ads.zzawq;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzeyx;
import com.google.android.gms.internal.ads.zzzy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzr {
    public static final zzebq zza = new zzf(Looper.getMainLooper());
    /* access modifiers changed from: private */
    @GuardedBy("AdUtil.class")
    public static boolean zzd = false;
    private final AtomicReference<Pattern> zzb = new AtomicReference<>((Object) null);
    private final AtomicReference<Pattern> zzc = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public boolean zze = true;
    /* access modifiers changed from: private */
    public final Object zzf = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("userAgentLock")
    public String zzg;
    private boolean zzh = false;
    private boolean zzi = false;
    private final Executor zzj = Executors.newSingleThreadExecutor();

    public static final WebResourceResponse zzA(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzs.zzc().zze(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzbe(context).zzb(0, str2, hashMap, (byte[]) null).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzbbk.zzj("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    public static final String zzB() {
        Resources zzf2 = zzs.zzg().zzf();
        return zzf2 != null ? zzf2.getString(R$string.f4787s7) : "Test Ad";
    }

    public static final zzbh zzC(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbbk.zzf("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbh) {
                return (zzbh) queryLocalInterface;
            }
            return new zzbf(iBinder);
        } catch (Exception e) {
            zzs.zzg().zzg(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzD(Context context, String str) {
        Context zza2 = zzawq.zza(context);
        return Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0;
    }

    public static final boolean zzE(String str) {
        if (!zzbbj.zzj()) {
            return false;
        }
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzde)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzaaa.zzc().zzb(zzaeq.zzdg);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(";")) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzaaa.zzc().zzb(zzaeq.zzdf);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(";")) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(16)
    public static final boolean zzF(Context context) {
        KeyguardManager zzab;
        if (context == null || !PlatformVersion.isAtLeastJellyBean() || (zzab = zzab(context)) == null || !zzab.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public static final boolean zzG(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzbbk.zzg("Error loading class.", th);
            zzs.zzg().zzg(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzH(Context context) {
        boolean z;
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfB)).booleanValue()) {
                synchronized (zzr.class) {
                    z = zzd;
                }
                return z;
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static final boolean zzI(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                return true;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzJ(Context context) {
        Bundle zzae = zzae(context);
        return TextUtils.isEmpty(zzad(zzae)) && !TextUtils.isEmpty(zzae.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    public static final boolean zzK(Context context) {
        Window window;
        if (!(!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null)) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final void zzL(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        for (String zzbo : arrayList) {
            new zzbo(context, str, zzbo).zzb();
        }
    }

    public static final void zzM(Context context, Throwable th) {
        if (context != null) {
            try {
                if (zzagj.zzb.zze().booleanValue()) {
                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static final void zzN(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final int zzO(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzbbk.zzi(sb.toString());
            return 0;
        }
    }

    public static final Map<String, String> zzP(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
        }
        return hashMap;
    }

    public static final WebResourceResponse zzQ(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        zzs.zzc();
        String contentType = httpURLConnection.getContentType();
        String str2 = "";
        if (TextUtils.isEmpty(contentType)) {
            str = str2;
        } else {
            str = contentType.split(";")[0].trim();
        }
        zzs.zzc();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str2 = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str3 = str2;
        Map headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return zzs.zze().zzn(str, str3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static final int[] zzR(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzz();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    protected static final String zzS(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzw();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] zzT(android.app.Activity r6) {
        /*
            android.view.Window r0 = r6.getWindow()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0021
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r4)
            if (r0 == 0) goto L_0x0021
            int[] r4 = new int[r1]
            int r5 = r0.getTop()
            r4[r3] = r5
            int r0 = r0.getBottom()
            r4[r2] = r0
            goto L_0x0025
        L_0x0021:
            int[] r4 = zzz()
        L_0x0025:
            int[] r0 = new int[r1]
            com.google.android.gms.internal.ads.zzbbd r1 = com.google.android.gms.internal.ads.zzzy.zza()
            r5 = r4[r3]
            int r1 = r1.zza(r6, r5)
            r0[r3] = r1
            com.google.android.gms.internal.ads.zzbbd r1 = com.google.android.gms.internal.ads.zzzy.zza()
            r3 = r4[r2]
            int r6 = r1.zza(r6, r3)
            r0[r2] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zzT(android.app.Activity):int[]");
    }

    public static final boolean zzU(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = zzs.zzc().zze || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzt(view);
        if (view.getVisibility() != 0 || !view.isShown()) {
            return false;
        }
        if ((powerManager != null && !powerManager.isScreenOn()) || !z) {
            return false;
        }
        return !((Boolean) zzaaa.zzc().zzb(zzaeq.zzaP)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect());
    }

    @TargetApi(18)
    public static final void zzV(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzu(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzbbk.zzd(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzbbk.zzg("No browser is found.", e);
        }
    }

    public static final int[] zzW(Activity activity) {
        int[] zzR = zzR(activity);
        return new int[]{zzzy.zza().zza(activity, zzR[0]), zzzy.zza().zza(activity, zzR[1])};
    }

    public static final boolean zzX(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zzU(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzab(context));
    }

    private final JSONArray zzY(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zzZ : collection) {
            zzZ(jSONArray, zzZ);
        }
        return jSONArray;
    }

    private final void zzZ(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzf((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zzY((Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object zzZ : (Object[]) obj) {
                zzZ(jSONArray2, zzZ);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    public static int zza(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        StringBuilder sb = new StringBuilder(97);
        sb.append("HTTP timeout too low: ");
        sb.append(i);
        sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        zzbbk.zzi(sb.toString());
        return 60000;
    }

    private final void zzaa(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzf((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zzY((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zzY(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static KeyguardManager zzab(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static boolean zzac(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static String zzad(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    private static Bundle zzae(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zze.zzb("Error getting metadata", e);
            return null;
        }
    }

    public static void zzk(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzbbw.zza.execute(runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzt(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r0
            goto L_0x0013
        L_0x0009:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0007
            android.app.Activity r2 = (android.app.Activity) r2
        L_0x0013:
            r1 = 0
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x002d
            r2 = 1
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zzt(android.view.View):boolean");
    }

    @TargetApi(18)
    public static final void zzu(Context context, Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static final String zzv(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzad(zzae(context));
    }

    static final String zzw() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzx() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    public static final DisplayMetrics zzy(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzz() {
        return new int[]{0, 0};
    }

    public final void zzb(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zza2 = zza(i);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(zza2);
        sb.append(" milliseconds.");
        zzbbk.zzh(sb.toString());
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        httpURLConnection.setRequestProperty("User-Agent", zze(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzc(Context context) {
        if (this.zzh) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzq(this, (zzl) null), intentFilter);
        this.zzh = true;
        return true;
    }

    public final boolean zzd(Context context) {
        if (this.zzi) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzp(this, (zzl) null), intentFilter);
        this.zzi = true;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0039, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[Catch:{ Exception -> 0x00ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zze(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return r1
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.lang.String r5 = zzw()     // Catch:{ all -> 0x00c7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return r5
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzac r1 = com.google.android.gms.ads.internal.zzs.zze()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.zzb(r5)     // Catch:{ Exception -> 0x001b }
            r4.zzg = r1     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ all -> 0x00c7 }
            boolean r1 = com.google.android.gms.internal.ads.zzbbd.zzp()     // Catch:{ all -> 0x00c7 }
            if (r1 != 0) goto L_0x0063
            r1 = 0
            r4.zzg = r1     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzebq r1 = zza     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.ads.internal.util.zzm r2 = new com.google.android.gms.ads.internal.util.zzm     // Catch:{ all -> 0x00c7 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x00c7 }
            r1.post(r2)     // Catch:{ all -> 0x00c7 }
        L_0x0039:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c7 }
            if (r1 != 0) goto L_0x0069
            java.lang.Object r1 = r4.zzf     // Catch:{ InterruptedException -> 0x0043 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0039
        L_0x0043:
            java.lang.String r1 = zzw()     // Catch:{ all -> 0x00c7 }
            r4.zzg = r1     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "Interrupted, use default user agent: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c7 }
            int r3 = r1.length()     // Catch:{ all -> 0x00c7 }
            if (r3 == 0) goto L_0x005a
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x00c7 }
            goto L_0x005f
        L_0x005a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00c7 }
            r1.<init>(r2)     // Catch:{ all -> 0x00c7 }
        L_0x005f:
            com.google.android.gms.internal.ads.zzbbk.zzi(r1)     // Catch:{ all -> 0x00c7 }
            goto L_0x0039
        L_0x0063:
            java.lang.String r1 = zzS(r5)     // Catch:{ all -> 0x00c7 }
            r4.zzg = r1     // Catch:{ all -> 0x00c7 }
        L_0x0069:
            java.lang.String r1 = r4.zzg     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00c7 }
            int r2 = r2.length()     // Catch:{ all -> 0x00c7 }
            int r2 = r2 + 10
            int r3 = r6.length()     // Catch:{ all -> 0x00c7 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r3.<init>(r2)     // Catch:{ all -> 0x00c7 }
            r3.append(r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = " (Mobile; "
            r3.append(r1)     // Catch:{ all -> 0x00c7 }
            r3.append(r6)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00c7 }
            r4.zzg = r6     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x00ad }
            boolean r5 = r5.isCallerInstantApp()     // Catch:{ Exception -> 0x00ad }
            if (r5 == 0) goto L_0x00b7
            java.lang.String r5 = r4.zzg     // Catch:{ Exception -> 0x00ad }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r6 = ";aia"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x00ad }
            r4.zzg = r5     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b7
        L_0x00ad:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbav r6 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.zzg(r5, r1)     // Catch:{ all -> 0x00c7 }
        L_0x00b7:
            java.lang.String r5 = r4.zzg     // Catch:{ all -> 0x00c7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = ")"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x00c7 }
            r4.zzg = r5     // Catch:{ all -> 0x00c7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return r5
        L_0x00c7:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            goto L_0x00cb
        L_0x00ca:
            throw r5
        L_0x00cb:
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzr.zze(android.content.Context, java.lang.String):java.lang.String");
    }

    public final JSONObject zzf(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                zzaa(jSONObject, next, map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject zzg(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return zzh(bundle);
        } catch (JSONException e) {
            zzbbk.zzg("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final JSONObject zzh(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zzaa(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final zzefw<Map<String, String>> zzi(Uri uri) {
        return zzefo.zzc(new zzk(uri), this.zzj);
    }

    public final void zzj(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzs.zzc();
        bundle.putString("device", zzx());
        bundle.putString("eids", TextUtils.join(",", zzaeq.zzc()));
        zzzy.zza();
        zzbbd.zzr(context, str, "gmob-apps", bundle, true, new zzn(this, context, str));
    }

    public final boolean zzl(String str) {
        return zzac(str, this.zzb, (String) zzaaa.zzc().zzb(zzaeq.zzW));
    }

    public final boolean zzm(String str) {
        return zzac(str, this.zzc, (String) zzaaa.zzc().zzb(zzaeq.zzX));
    }

    @TargetApi(26)
    public final void zzn(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfB)).booleanValue()) {
                ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzo(this));
            }
        }
    }

    @TargetApi(18)
    public final int zzs(Context context, Uri uri) {
        int i;
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            zze.zza("Chrome Custom Tabs can only work with version Jellybean onwards.");
            i = 1;
        } else if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            i = 3;
        } else if (!(context instanceof Activity)) {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i = 2;
        } else if (zzeyx.zza(context) == null) {
            zze.zza("Default browser does not support custom tabs.");
            i = 4;
        } else {
            i = 0;
        }
        zzaei zzaei = zzaeq.zzcK;
        zzaei zzaei2 = zzaeq.zzcL;
        if (true == ((Boolean) zzaaa.zzc().zzb(zzaei)).equals(zzaaa.zzc().zzb(zzaei2))) {
            i = 9;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
            zzafo zzafo = new zzafo();
            zzafo.zzd(new zzl(this, zzafo, context, uri));
            zzafo.zze((Activity) context);
        }
        if (!((Boolean) zzaaa.zzc().zzb(zzaei2)).booleanValue()) {
            return 5;
        }
        new CustomTabsIntent.Builder().build().launchUrl(context, uri);
        return 5;
    }
}
