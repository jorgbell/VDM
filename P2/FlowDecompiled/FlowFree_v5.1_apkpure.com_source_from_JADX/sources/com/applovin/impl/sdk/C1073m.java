package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p038d.C0987h;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C0999f;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1153m;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1159q;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mopub.common.Constants;
import com.mopub.network.ImpressionData;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.m */
public class C1073m {

    /* renamed from: h */
    private static String f2241h;

    /* renamed from: i */
    private static int f2242i;

    /* renamed from: a */
    private final C1062k f2243a;

    /* renamed from: b */
    private final C1107r f2244b;

    /* renamed from: c */
    private final Context f2245c;

    /* renamed from: d */
    private final Map<String, Object> f2246d;

    /* renamed from: e */
    private final Object f2247e = new Object();

    /* renamed from: f */
    private final Map<String, Object> f2248f;

    /* renamed from: g */
    private boolean f2249g;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicReference<C1076a> f2250j = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final AtomicReference<Integer> f2251k = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.m$a */
    public static class C1076a {

        /* renamed from: a */
        public boolean f2254a;

        /* renamed from: b */
        public String f2255b = "";
    }

    /* renamed from: com.applovin.impl.sdk.m$b */
    public static class C1077b {

        /* renamed from: a */
        public int f2256a = -1;

        /* renamed from: b */
        public int f2257b = -1;
    }

    protected C1073m(C1062k kVar) {
        if (kVar != null) {
            this.f2243a = kVar;
            this.f2244b = kVar.mo9411z();
            this.f2245c = kVar.mo9334J();
            this.f2246d = m2242m();
            this.f2248f = m2244o();
            m2231H();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: A */
    private boolean m2224A() {
        return this.f2245c.getPackageManager().hasSystemFeature(C1119g.m2531d() ? "android.software.leanback" : "android.hardware.type.television");
    }

    /* renamed from: B */
    private boolean m2225B() {
        SensorManager sensorManager = (SensorManager) this.f2245c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    /* renamed from: C */
    private String m2226C() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2245c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    /* renamed from: D */
    private String m2227D() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2245c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            this.f2244b.mo9585b("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    /* renamed from: E */
    private boolean m2228E() {
        try {
            return m2229F() || m2230G();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: F */
    private boolean m2229F() {
        String str = Build.TAGS;
        return str != null && str.contains(m2239b("lz}$blpz"));
    }

    /* renamed from: G */
    private boolean m2230G() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(m2239b(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: H */
    private void m2231H() {
        this.f2243a.mo9340Q().mo9266a((C0989a) new C0999f(this.f2243a, new C0999f.C1000a() {
            /* renamed from: a */
            public void mo9243a(C1076a aVar) {
                C1073m.this.f2250j.set(aVar);
            }
        }), C1020o.C1022a.ADVERTISING_INFO_COLLECTION);
        this.f2243a.mo9340Q().mo9266a((C0989a) new C1042y(this.f2243a, true, new Runnable() {
            public void run() {
                C1073m.this.f2251k.set(C1073m.this.m2254y());
            }
        }), C1020o.C1022a.CACHING_OTHER);
    }

    /* renamed from: a */
    private String m2232a(int i) {
        if (i == 1) {
            return "receiver";
        }
        if (i == 2) {
            return "speaker";
        }
        if (i == 4 || i == 3) {
            return "headphones";
        }
        if (i == 8) {
            return "bluetootha2dpoutput";
        }
        if (i == 13 || i == 19 || i == 5 || i == 6 || i == 12 || i == 11) {
            return "lineout";
        }
        if (i == 9 || i == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0157 A[SYNTHETIC, Splitter:B:43:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0351  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> m2233a(java.util.Map<java.lang.String, java.lang.Object> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "tds"
            java.lang.String r1 = "fs"
            java.lang.String r2 = "DataCollector"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>(r7)
            android.content.Context r7 = r6.f2245c
            android.graphics.Point r7 = com.applovin.impl.sdk.utils.C1119g.m2526a(r7)
            int r4 = r7.x
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "dx"
            r3.put(r5, r4)
            int r7 = r7.y
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "dy"
            r3.put(r4, r7)
            if (r8 == 0) goto L_0x004a
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.m$a> r7 = r6.f2250j
            java.lang.Object r7 = r7.get()
            com.applovin.impl.sdk.m$a r7 = (com.applovin.impl.sdk.C1073m.C1076a) r7
            if (r7 == 0) goto L_0x0037
            r6.m2231H()
            goto L_0x0054
        L_0x0037:
            boolean r7 = com.applovin.impl.sdk.utils.C1160r.m2744b()
            if (r7 == 0) goto L_0x004a
            com.applovin.impl.sdk.m$a r7 = new com.applovin.impl.sdk.m$a
            r7.<init>()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.lang.String r5 = "inc"
            r3.put(r5, r4)
            goto L_0x0054
        L_0x004a:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.m r7 = r7.mo9343T()
            com.applovin.impl.sdk.m$a r7 = r7.mo9436j()
        L_0x0054:
            java.lang.String r4 = r7.f2255b
            boolean r5 = com.applovin.impl.sdk.utils.C1155o.m2673b(r4)
            if (r5 == 0) goto L_0x0061
            java.lang.String r5 = "idfa"
            r3.put(r5, r4)
        L_0x0061:
            boolean r7 = r7.f2254a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = "dnt"
            r3.put(r4, r7)
            com.applovin.impl.sdk.h$a r7 = com.applovin.impl.sdk.C1048h.m2076b()
            android.content.Context r4 = r6.f2245c
            java.lang.Boolean r7 = r7.mo9308a((android.content.Context) r4)
            if (r7 == 0) goto L_0x007d
            java.lang.String r4 = "huc"
            r3.put(r4, r7)
        L_0x007d:
            com.applovin.impl.sdk.h$a r7 = com.applovin.impl.sdk.C1048h.m2071a()
            android.content.Context r4 = r6.f2245c
            java.lang.Boolean r7 = r7.mo9308a((android.content.Context) r4)
            if (r7 == 0) goto L_0x008e
            java.lang.String r4 = "aru"
            r3.put(r4, r7)
        L_0x008e:
            com.applovin.impl.sdk.h$a r7 = com.applovin.impl.sdk.C1048h.m2078c()
            android.content.Context r4 = r6.f2245c
            java.lang.Boolean r7 = r7.mo9308a((android.content.Context) r4)
            if (r7 == 0) goto L_0x009f
            java.lang.String r4 = "dns"
            r3.put(r4, r7)
        L_0x009f:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p037c.C0965b.f1780dv
            java.lang.Object r7 = r7.mo9350a(r4)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00c9
            com.applovin.impl.sdk.m$b r7 = r6.m2248s()
            int r4 = r7.f2256a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "act"
            r3.put(r5, r4)
            int r7 = r7.f2257b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "acm"
            r3.put(r4, r7)
        L_0x00c9:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p037c.C0965b.f1737dE
            java.lang.Object r7 = r7.mo9350a(r4)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00e6
            boolean r7 = r6.m2228E()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = "adr"
            r3.put(r4, r7)
        L_0x00e6:
            if (r8 == 0) goto L_0x00f1
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r7 = r6.f2251k
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x00f5
        L_0x00f1:
            java.lang.Integer r7 = r6.m2254y()
        L_0x00f5:
            if (r7 == 0) goto L_0x00fc
            java.lang.String r8 = "volume"
            r3.put(r8, r7)
        L_0x00fc:
            android.content.Context r7 = r6.f2245c     // Catch:{ SettingNotFoundException -> 0x011b }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x011b }
            java.lang.String r8 = "screen_brightness"
            int r7 = android.provider.Settings.System.getInt(r7, r8)     // Catch:{ SettingNotFoundException -> 0x011b }
            float r7 = (float) r7     // Catch:{ SettingNotFoundException -> 0x011b }
            r8 = 1132396544(0x437f0000, float:255.0)
            float r7 = r7 / r8
            java.lang.String r8 = "sb"
            r4 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r4
            int r7 = (int) r7     // Catch:{ SettingNotFoundException -> 0x011b }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SettingNotFoundException -> 0x011b }
            r3.put(r8, r7)     // Catch:{ SettingNotFoundException -> 0x011b }
            goto L_0x0123
        L_0x011b:
            r7 = move-exception
            com.applovin.impl.sdk.r r8 = r6.f2244b
            java.lang.String r4 = "Unable to collect screen brightness"
            r8.mo9585b(r2, r4, r7)
        L_0x0123:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1740dH
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0147
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.C1180y.m2820b(r7)
            java.lang.String r7 = com.applovin.impl.sdk.C1180y.m2815a()
            boolean r8 = com.applovin.impl.sdk.utils.C1155o.m2673b(r7)
            if (r8 == 0) goto L_0x0147
            java.lang.String r8 = "ua"
            r3.put(r8, r7)
        L_0x0147:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1782dx
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x018d
            java.io.File r7 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0176 }
            long r7 = r7.getFreeSpace()     // Catch:{ all -> 0x0176 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0176 }
            r3.put(r1, r7)     // Catch:{ all -> 0x0176 }
            java.io.File r7 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0176 }
            long r7 = r7.getTotalSpace()     // Catch:{ all -> 0x0176 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0176 }
            r3.put(r0, r7)     // Catch:{ all -> 0x0176 }
            goto L_0x018d
        L_0x0176:
            r7 = move-exception
            r8 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3.put(r1, r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.put(r0, r8)
            com.applovin.impl.sdk.r r8 = r6.f2244b
            java.lang.String r0 = "Unable to collect total & free space."
            r8.mo9585b(r2, r0, r7)
        L_0x018d:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1783dy
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01dd
            android.content.Context r7 = r6.f2245c
            java.lang.String r8 = "activity"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.app.ActivityManager r7 = (android.app.ActivityManager) r7
            android.app.ActivityManager$MemoryInfo r8 = new android.app.ActivityManager$MemoryInfo
            r8.<init>()
            if (r7 == 0) goto L_0x01dd
            r7.getMemoryInfo(r8)
            long r0 = r8.availMem
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "fm"
            r3.put(r0, r7)
            long r0 = r8.totalMem
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "tm"
            r3.put(r0, r7)
            long r0 = r8.threshold
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "lmt"
            r3.put(r0, r7)
            boolean r7 = r8.lowMemory
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "lm"
            r3.put(r8, r7)
        L_0x01dd:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1784dz
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0214
            android.content.Context r7 = r6.f2245c
            java.lang.String r8 = "android.permission.READ_PHONE_STATE"
            boolean r7 = com.applovin.impl.sdk.utils.C1119g.m2528a(r8, r7)
            if (r7 == 0) goto L_0x0214
            boolean r7 = com.applovin.impl.sdk.utils.C1119g.m2533f()
            if (r7 == 0) goto L_0x0214
            android.content.Context r7 = r6.f2245c
            java.lang.String r8 = "phone"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7
            int r7 = r7.getDataNetworkType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "rat"
            r3.put(r8, r7)
        L_0x0214:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.c r7 = r7.mo9333I()
            com.applovin.impl.sdk.c.b<java.lang.String> r8 = com.applovin.impl.sdk.p037c.C0965b.f1742dJ
            java.lang.Object r7 = r7.mo9121a(r8)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = f2241h
            boolean r8 = r7.equalsIgnoreCase(r8)
            java.lang.String r0 = "wvvc"
            if (r8 != 0) goto L_0x024a
            r8 = 0
            f2241h = r7     // Catch:{ all -> 0x0247 }
            android.content.Context r1 = r6.f2245c     // Catch:{ all -> 0x0247 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0247 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r8)     // Catch:{ all -> 0x0247 }
            int r1 = r7.versionCode     // Catch:{ all -> 0x0247 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0247 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0247 }
            int r7 = r7.versionCode     // Catch:{ all -> 0x0247 }
            f2242i = r7     // Catch:{ all -> 0x0247 }
            goto L_0x0253
        L_0x0247:
            f2242i = r8
            goto L_0x0253
        L_0x024a:
            int r7 = f2242i
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.put(r0, r7)
        L_0x0253:
            android.content.Context r7 = r6.f2245c
            boolean r7 = com.applovin.sdk.AppLovinSdkUtils.isTablet(r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "is_tablet"
            r3.put(r8, r7)
            boolean r7 = r6.m2224A()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "tv"
            r3.put(r8, r7)
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1781dw
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x028e
            java.lang.String r7 = r6.m2251v()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x028e
            java.lang.String r8 = "so"
            r3.put(r8, r7)
        L_0x028e:
            java.lang.String r7 = r6.m2243n()
            java.lang.String r8 = "orientation_lock"
            r3.put(r8, r7)
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1733dA
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x02b4
            boolean r7 = com.applovin.impl.sdk.utils.C1160r.m2752d()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "vs"
            r3.put(r8, r7)
        L_0x02b4:
            boolean r7 = com.applovin.impl.sdk.utils.C1119g.m2531d()
            if (r7 == 0) goto L_0x02d3
            android.content.Context r7 = r6.f2245c
            java.lang.String r8 = "power"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.os.PowerManager r7 = (android.os.PowerManager) r7
            if (r7 == 0) goto L_0x02d3
            boolean r7 = r7.isPowerSaveMode()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "lpm"
            r3.put(r8, r7)
        L_0x02d3:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1743dK
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x02fe
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.utils.n r7 = r7.mo9373ah()
            if (r7 == 0) goto L_0x02fe
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.utils.n r7 = r7.mo9373ah()
            float r7 = r7.mo9656c()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.String r8 = "da"
            r3.put(r8, r7)
        L_0x02fe:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p037c.C0965b.f1744dL
            java.lang.Object r7 = r7.mo9350a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0329
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.utils.n r7 = r7.mo9373ah()
            if (r7 == 0) goto L_0x0329
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.utils.n r7 = r7.mo9373ah()
            float r7 = r7.mo9655b()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.String r8 = "dm"
            r3.put(r8, r7)
        L_0x0329:
            com.applovin.impl.sdk.k r7 = r6.f2243a
            com.applovin.impl.sdk.f r7 = r7.mo9374ai()
            int r7 = r7.mo9297a()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "mute_switch"
            r3.put(r8, r7)
            com.applovin.impl.sdk.k r7 = r6.f2243a
            java.lang.String r7 = com.applovin.impl.sdk.utils.C1120h.m2552f(r7)
            java.lang.String r8 = "network"
            r3.put(r8, r7)
            java.lang.String r7 = r6.m2252w()
            boolean r8 = com.applovin.impl.sdk.utils.C1155o.m2673b(r7)
            if (r8 == 0) goto L_0x0356
            java.lang.String r8 = "kb"
            r3.put(r8, r7)
        L_0x0356:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1073m.m2233a(java.util.Map, boolean):java.util.Map");
    }

    /* renamed from: a */
    private void m2235a(Map<String, Object> map) {
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1734dB)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(m2249t()));
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1735dC)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(m2250u()));
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1741dI)).booleanValue()) {
            C1180y.m2822c(this.f2243a);
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1740dH)).booleanValue()) {
            C1180y.m2820b(this.f2243a);
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1739dG)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1736dD)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(m2245p()));
        }
        map.put("htn", Boolean.valueOf(m2253x()));
    }

    /* renamed from: a */
    private boolean m2236a(String str) {
        try {
            return Settings.Secure.getInt(this.f2245c.getContentResolver(), str) == 1;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2237a(String str, String str2) {
        for (String startsWith : C1117e.m2521a(str2)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m2239b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* renamed from: l */
    private Map<String, String> m2241l() {
        return C1160r.m2719a(mo9426a((Map<String, String>) null, true, false));
    }

    /* renamed from: m */
    private Map<String, Object> m2242m() {
        Map<String, String> a;
        HashMap hashMap = new HashMap(32);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(mo9437k()));
        hashMap.put("aida", Boolean.valueOf(m2247r()));
        hashMap.put("locale", Locale.getDefault().toString());
        hashMap.put("model", Build.MODEL);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("platform", Constants.ANDROID_PLATFORM);
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(m2255z()));
        hashMap.put("gy", Boolean.valueOf(m2225B()));
        hashMap.put("country_code", m2226C());
        hashMap.put("carrier", m2227D());
        DisplayMetrics displayMetrics = this.f2245c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point a2 = C1119g.m2526a(this.f2245c);
            double sqrt = Math.sqrt(Math.pow((double) a2.x, 2.0d) + Math.pow((double) a2.y, 2.0d));
            double d = (double) displayMetrics.xdpi;
            Double.isNaN(d);
            hashMap.put("screen_size_in", Double.valueOf(sqrt / d));
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        if (this.f2243a.mo9391g() && (a = C1160r.m2718a(this.f2243a.mo9400p())) != null) {
            String str = a.get("GraphicsMemorySizeMegabytes");
            if (C1155o.m2673b(str)) {
                try {
                    hashMap.put("gms_mb", Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                    C1107r rVar = this.f2244b;
                    rVar.mo9588e("DataCollector", "Graphics memory size megabytes couldn't be parsed to an integer: " + str);
                }
            }
        }
        m2235a((Map<String, Object>) hashMap);
        return hashMap;
    }

    /* renamed from: n */
    private String m2243n() {
        int b = C1160r.m2737b(this.f2245c);
        return b == 1 ? "portrait" : b == 2 ? "landscape" : "none";
    }

    /* renamed from: o */
    private Map<String, Object> m2244o() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap(20);
        PackageManager packageManager = this.f2245c.getPackageManager();
        ApplicationInfo applicationInfo = this.f2245c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f2245c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        hashMap.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        hashMap.put(ImpressionData.APP_VERSION, packageInfo != null ? packageInfo.versionName : "");
        hashMap.put("package_name", applicationInfo.packageName);
        hashMap.put("vz", C1155o.m2680h(applicationInfo.packageName));
        if (str == null) {
            str = "";
        }
        hashMap.put("installer_name", str);
        hashMap.put("tg", C1159q.m2693a(this.f2243a));
        hashMap.put("debug", Boolean.valueOf(C1160r.m2756e(this.f2243a.mo9334J())));
        hashMap.put("ia", Long.valueOf(lastModified));
        C1062k kVar = this.f2243a;
        C0967d dVar = C0967d.f1849d;
        Long l = (Long) kVar.mo9351a(dVar);
        if (l != null) {
            hashMap.put("ia_v2", l);
        } else {
            this.f2243a.mo9357a(dVar, Long.valueOf(lastModified));
        }
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("build", 131);
        hashMap.put("api_did", this.f2243a.mo9350a(C0965b.f1569U));
        hashMap.put("first_install", Boolean.valueOf(this.f2243a.mo9337N()));
        hashMap.put("first_install_v2", Boolean.valueOf(!this.f2243a.mo9338O()));
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        hashMap.put("epv", Integer.valueOf(C1160r.m2763h()));
        return hashMap;
    }

    /* renamed from: p */
    private boolean m2245p() {
        ConnectivityManager connectivityManager;
        if (C1119g.m2533f() && (connectivityManager = (ConnectivityManager) this.f2245c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f2243a.mo9411z().mo9585b("DataCollector", "Unable to collect constrained network info.", th);
            }
        }
        return false;
    }

    /* renamed from: q */
    private C1076a m2246q() {
        if (m2247r()) {
            try {
                C1076a aVar = new C1076a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f2245c);
                aVar.f2254a = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.f2255b = advertisingIdInfo.getId();
                return aVar;
            } catch (Throwable th) {
                this.f2244b.mo9585b("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
            }
        } else {
            C1107r.m2484i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return new C1076a();
        }
    }

    /* renamed from: r */
    private boolean m2247r() {
        return C1160r.m2753d("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* renamed from: s */
    private C1077b m2248s() {
        C1077b bVar = new C1077b();
        Intent registerReceiver = this.f2245c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            bVar.f2257b = -1;
        } else {
            bVar.f2257b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        bVar.f2256a = i;
        return bVar;
    }

    /* renamed from: t */
    private long m2249t() {
        List asList = Arrays.asList(C1155o.m2675c(Settings.Secure.getString(this.f2245c.getContentResolver(), "enabled_accessibility_services")).split(":"));
        long j = asList.contains("AccessibilityMenuService") ? 256 : 0;
        if (asList.contains("SelectToSpeakService")) {
            j |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j |= 4;
        }
        if ((this.f2245c.getResources().getConfiguration().uiMode & 48) == 32) {
            j |= 1024;
        }
        if (m2236a("accessibility_enabled")) {
            j |= 8;
        }
        if (m2236a("touch_exploration_enabled")) {
            j |= 16;
        }
        if (!C1119g.m2531d()) {
            return j;
        }
        if (m2236a("accessibility_display_inversion_enabled")) {
            j |= 32;
        }
        return m2236a("skip_first_use_hints") ? j | 64 : j;
    }

    /* renamed from: u */
    private float m2250u() {
        try {
            return Settings.System.getFloat(this.f2245c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            this.f2244b.mo9585b("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    /* renamed from: v */
    private String m2251v() {
        AudioManager audioManager = (AudioManager) this.f2245c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (C1119g.m2532e()) {
            for (AudioDeviceInfo type : audioManager.getDevices(2)) {
                String a = m2232a(type.getType());
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a);
                    sb.append(",");
                }
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("headphones");
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append("bluetootha2dpoutput");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            this.f2244b.mo9584b("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    /* renamed from: w */
    private String m2252w() {
        if (!C1119g.m2533f()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.f2245c.getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                sb.append(locales.get(i));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0 = (r0 = (r0 = (r0 = r2.f2243a.mo9378am()).getWindow()).getDecorView().getRootWindowInsets()).getDisplayCutout();
     */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2253x() {
        /*
            r2 = this;
            boolean r0 = com.applovin.impl.sdk.utils.C1119g.m2534g()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.applovin.impl.sdk.k r0 = r2.f2243a
            android.app.Activity r0 = r0.mo9378am()
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L_0x0018
            return r1
        L_0x0018:
            android.view.View r0 = r0.getDecorView()
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 != 0) goto L_0x0023
            return r1
        L_0x0023:
            android.view.DisplayCutout r0 = r0.getDisplayCutout()
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r0 = r0.getSafeInsetTop()
            if (r0 <= 0) goto L_0x0031
            r1 = 1
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1073m.m2253x():boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public Integer m2254y() {
        AudioManager audioManager = (AudioManager) this.f2245c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Integer.valueOf((int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f2243a.mo9350a(C0965b.f1738dF)).floatValue()));
    }

    /* renamed from: z */
    private double m2255z() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9425a() {
        String encodeToString = Base64.encodeToString(new JSONObject(m2241l()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.f2243a.mo9350a(C0965b.f1819el)).booleanValue()) {
            return encodeToString;
        }
        return C1153m.m2648a(encodeToString, this.f2243a.mo9409x(), C1160r.m2702a(this.f2243a));
    }

    /* renamed from: a */
    public Map<String, Object> mo9426a(Map<String, String> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap(64);
        Map<String, Object> a = mo9427a(z);
        Map<String, Object> g = mo9433g();
        Map<String, Object> i = mo9435i();
        if (z2) {
            hashMap.put("device_info", a);
            hashMap.put("app_info", g);
            if (i != null) {
                hashMap.put("connection_info", i);
            }
            if (map != null) {
                hashMap.put("ad_info", map);
            }
        } else {
            hashMap.putAll(a);
            hashMap.putAll(g);
            if (i != null) {
                hashMap.putAll(i);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put("format", "json");
        C1160r.m2724a("mediation_provider", this.f2243a.mo9403s(), (Map) hashMap);
        C1160r.m2724a("plugin_version", (String) this.f2243a.mo9350a(C0965b.f1779du), (Map) hashMap);
        if (!((Boolean) this.f2243a.mo9350a(C0965b.f1818ek)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2243a.mo9409x());
        }
        hashMap.putAll(mo9434h());
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1750dR)).booleanValue()) {
            C0987h R = this.f2243a.mo9341R();
            hashMap.put("li", Long.valueOf(R.mo9202b(C0986g.f1955b)));
            hashMap.put("si", Long.valueOf(R.mo9202b(C0986g.f1957d)));
            hashMap.put("pf", Long.valueOf(R.mo9202b(C0986g.f1961h)));
            hashMap.put("mpf", Long.valueOf(R.mo9202b(C0986g.f1968o)));
            hashMap.put("gpf", Long.valueOf(R.mo9202b(C0986g.f1962i)));
            hashMap.put("asoac", Long.valueOf(R.mo9202b(C0986g.f1966m)));
        }
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    /* renamed from: a */
    public Map<String, Object> mo9427a(boolean z) {
        HashMap hashMap;
        synchronized (this.f2247e) {
            hashMap = new HashMap(this.f2246d);
        }
        return m2233a((Map<String, Object>) hashMap, z);
    }

    /* renamed from: b */
    public Map<String, Object> mo9428b() {
        return new HashMap(this.f2246d);
    }

    /* renamed from: c */
    public Map<String, Object> mo9429c() {
        return new HashMap(this.f2248f);
    }

    /* renamed from: d */
    public Map<String, Object> mo9430d() {
        return mo9427a(false);
    }

    /* renamed from: e */
    public void mo9431e() {
        synchronized (this.f2247e) {
            m2235a(this.f2246d);
        }
    }

    /* renamed from: f */
    public boolean mo9432f() {
        return this.f2249g;
    }

    /* renamed from: g */
    public Map<String, Object> mo9433g() {
        HashMap hashMap = new HashMap(this.f2248f);
        hashMap.put("test_ads", Boolean.valueOf(this.f2249g));
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1772dn)).booleanValue()) {
            C1160r.m2724a("cuid", this.f2243a.mo9397m(), (Map) hashMap);
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1775dq)).booleanValue()) {
            hashMap.put("compass_random_token", this.f2243a.mo9398n());
        }
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1777ds)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f2243a.mo9399o());
        }
        String name = this.f2243a.mo9401q().getName();
        if (C1155o.m2673b(name)) {
            hashMap.put("user_segment_name", name);
        }
        return hashMap;
    }

    /* renamed from: h */
    public Map<String, Object> mo9434h() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("sc", this.f2243a.mo9350a(C0965b.f1574Z));
        hashMap.put("sc2", this.f2243a.mo9350a(C0965b.f1602aa));
        hashMap.put("sc3", this.f2243a.mo9350a(C0965b.f1603ab));
        hashMap.put("server_installed_at", this.f2243a.mo9350a(C0965b.f1604ac));
        C1160r.m2724a("persisted_data", (String) this.f2243a.mo9351a(C0967d.f1871z), (Map) hashMap);
        return hashMap;
    }

    /* renamed from: i */
    public Map<String, Object> mo9435i() {
        C1081a.C1083b a = this.f2243a.mo9339P().mo9448a();
        if (a == null) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("lrm_ts_ms", Long.valueOf(a.mo9452a()));
        hashMap.put("lrm_url", a.mo9453b());
        hashMap.put("lrm_ct_ms", Long.valueOf(a.mo9455d()));
        hashMap.put("lrm_rs", Long.valueOf(a.mo9454c()));
        return hashMap;
    }

    /* renamed from: j */
    public C1076a mo9436j() {
        C1076a q = m2246q();
        if (((Boolean) this.f2243a.mo9350a(C0965b.f1771dm)).booleanValue()) {
            if (q.f2254a && !((Boolean) this.f2243a.mo9350a(C0965b.f1770dl)).booleanValue()) {
                q.f2255b = "";
            }
            this.f2250j.set(q);
        } else {
            q = new C1076a();
        }
        this.f2249g = C1155o.m2673b(q.f2255b) ? this.f2243a.mo9400p().getTestDeviceAdvertisingIds().contains(q.f2255b) : false;
        return q;
    }

    /* renamed from: k */
    public boolean mo9437k() {
        return m2237a(Build.DEVICE, "goldfish,vbox") || m2237a(Build.HARDWARE, "ranchu,generic,vbox") || m2237a(Build.MANUFACTURER, "Genymotion") || m2237a(Build.MODEL, "Android SDK built for x86");
    }
}
