package com.chartboost.sdk.Tracking;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Networking.requests.models.MediationModel;
import com.chartboost.sdk.Privacy.model.CCPA;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;
import java.util.Locale;

/* renamed from: com.chartboost.sdk.Tracking.b */
public class C1261b {

    /* renamed from: A */
    private int f2900A;

    /* renamed from: B */
    private long f2901B;

    /* renamed from: C */
    private long f2902C;

    /* renamed from: D */
    private int f2903D;

    /* renamed from: E */
    private int f2904E;

    /* renamed from: F */
    private int f2905F;

    /* renamed from: G */
    private long f2906G;

    /* renamed from: a */
    private String f2907a;

    /* renamed from: b */
    private int f2908b;

    /* renamed from: c */
    private String f2909c;

    /* renamed from: d */
    private String f2910d;

    /* renamed from: e */
    private boolean f2911e;

    /* renamed from: f */
    private String f2912f;

    /* renamed from: g */
    private String f2913g;

    /* renamed from: h */
    private String f2914h;

    /* renamed from: i */
    private String f2915i;

    /* renamed from: j */
    private String f2916j;

    /* renamed from: k */
    private String f2917k;

    /* renamed from: l */
    private String f2918l;

    /* renamed from: m */
    private String f2919m;

    /* renamed from: n */
    private String f2920n;

    /* renamed from: o */
    private String f2921o;

    /* renamed from: p */
    private String f2922p;

    /* renamed from: q */
    private String f2923q;

    /* renamed from: r */
    private String f2924r;

    /* renamed from: s */
    private String f2925s;

    /* renamed from: t */
    private String f2926t;

    /* renamed from: u */
    private String f2927u;

    /* renamed from: v */
    private String f2928v;

    /* renamed from: w */
    private int f2929w;

    /* renamed from: x */
    private boolean f2930x;

    /* renamed from: y */
    private int f2931y;

    /* renamed from: z */
    private boolean f2932z;

    /* renamed from: com.chartboost.sdk.Tracking.b$b */
    private static class C1263b {

        /* renamed from: a */
        public int f2933a;

        /* renamed from: b */
        public boolean f2934b;

        private C1263b() {
        }
    }

    /* renamed from: D */
    private static String m3127D() {
        return "Amazon".equalsIgnoreCase(Build.MANUFACTURER) ? "Amazon" : "Android";
    }

    /* renamed from: K */
    private static String m3128K() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0).getLanguage();
        }
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: A */
    public String mo10185A() {
        return this.f2919m;
    }

    /* renamed from: B */
    public String mo10186B() {
        return this.f2921o;
    }

    /* renamed from: C */
    public String mo10187C() {
        return this.f2920n;
    }

    /* renamed from: E */
    public int mo10188E() {
        return this.f2908b;
    }

    /* renamed from: F */
    public long mo10189F() {
        return this.f2906G;
    }

    /* renamed from: G */
    public String mo10190G() {
        return this.f2907a;
    }

    /* renamed from: H */
    public int mo10191H() {
        return this.f2905F;
    }

    /* renamed from: I */
    public int mo10192I() {
        return this.f2903D;
    }

    /* renamed from: J */
    public int mo10193J() {
        return this.f2904E;
    }

    /* renamed from: a */
    public String mo10194a() {
        return this.f2909c;
    }

    /* renamed from: b */
    public void mo10201b(String str) {
        this.f2913g = str;
    }

    /* renamed from: c */
    public boolean mo10207c() {
        return this.f2911e;
    }

    /* renamed from: d */
    public void mo10209d(int i) {
        this.f2908b = i;
    }

    /* renamed from: e */
    public String mo10211e() {
        return this.f2912f;
    }

    /* renamed from: f */
    public String mo10214f() {
        return this.f2910d;
    }

    /* renamed from: g */
    public void mo10219g(String str) {
        this.f2914h = str;
    }

    /* renamed from: h */
    public void mo10221h(String str) {
        this.f2925s = str;
    }

    /* renamed from: i */
    public void mo10222i(String str) {
        this.f2915i = str;
    }

    /* renamed from: j */
    public String mo10224j() {
        return this.f2927u;
    }

    /* renamed from: k */
    public void mo10227k(String str) {
        this.f2916j = str;
    }

    /* renamed from: l */
    public String mo10228l() {
        return this.f2914h;
    }

    /* renamed from: m */
    public String mo10230m() {
        return this.f2925s;
    }

    /* renamed from: n */
    public long mo10232n() {
        return this.f2902C;
    }

    /* renamed from: o */
    public String mo10234o() {
        return this.f2915i;
    }

    /* renamed from: p */
    public boolean mo10237p() {
        return this.f2932z;
    }

    /* renamed from: q */
    public String mo10238q() {
        return this.f2928v;
    }

    /* renamed from: r */
    public String mo10240r() {
        return this.f2916j;
    }

    /* renamed from: s */
    public String mo10242s() {
        return this.f2917k;
    }

    /* renamed from: t */
    public void mo10245t(String str) {
        this.f2907a = str;
    }

    public String toString() {
        return "Environment{session_id=" + this.f2907a + ", session_count=" + this.f2908b + '\'' + ", app_id='" + this.f2909c + '\'' + ", chartboost_sdk_version='" + this.f2910d + '\'' + ", chartboost_sdk_autocache_enabled=" + this.f2911e + ", chartboost_sdk_gdpr='" + this.f2912f + '\'' + ", chartboost_sdk_ccpa='" + this.f2913g + '\'' + ", device_id='" + this.f2914h + '\'' + ", device_model='" + this.f2915i + '\'' + ", device_os_version='" + this.f2916j + '\'' + ", device_platform='" + this.f2917k + '\'' + ", device_country='" + this.f2918l + '\'' + ", device_language='" + this.f2925s + '\'' + ", device_timezone='" + this.f2926t + '\'' + ", device_connection_type='" + this.f2927u + '\'' + ", device_orientation='" + this.f2928v + '\'' + ", device_battery_level='" + this.f2929w + '\'' + ", device_charging_status='" + this.f2930x + '\'' + ", device_volume='" + this.f2931y + '\'' + ", device_mute='" + this.f2932z + '\'' + ", device_audio_output=" + this.f2900A + ", device_storage='" + this.f2901B + '\'' + ", device_low_memory_warning='" + this.f2902C + '\'' + ", device_up_time='" + mo10248v() + '\'' + ", session_impression_interstitial_count='" + this.f2903D + '\'' + ", session_impression_rewarded_count='" + this.f2904E + '\'' + ", session_impression_banner_count='" + this.f2905F + '\'' + ", session_duration='" + this.f2906G + '\'' + '}';
    }

    /* renamed from: u */
    public String mo10247u() {
        return this.f2926t;
    }

    /* renamed from: v */
    public long mo10248v() {
        return SystemClock.uptimeMillis();
    }

    /* renamed from: w */
    public int mo10249w() {
        return this.f2931y;
    }

    /* renamed from: x */
    public String mo10250x() {
        return this.f2922p;
    }

    /* renamed from: y */
    public String mo10251y() {
        return this.f2924r;
    }

    /* renamed from: z */
    public String mo10252z() {
        return this.f2923q;
    }

    /* renamed from: a */
    public void mo10197a(String str) {
        this.f2909c = str;
    }

    /* renamed from: b */
    public void mo10199b(int i) {
        this.f2929w = i;
    }

    /* renamed from: c */
    public void mo10205c(String str) {
        this.f2912f = str;
    }

    /* renamed from: d */
    public void mo10210d(String str) {
        this.f2910d = str;
    }

    /* renamed from: e */
    public void mo10213e(String str) {
        this.f2927u = str;
    }

    /* renamed from: f */
    public void mo10216f(String str) {
        this.f2918l = str;
    }

    /* renamed from: g */
    public int mo10217g() {
        return this.f2900A;
    }

    /* renamed from: h */
    public int mo10220h() {
        return this.f2929w;
    }

    /* renamed from: i */
    public boolean mo10223i() {
        return this.f2930x;
    }

    /* renamed from: j */
    public void mo10225j(String str) {
        this.f2928v = str;
    }

    /* renamed from: k */
    public String mo10226k() {
        return this.f2918l;
    }

    /* renamed from: l */
    public void mo10229l(String str) {
        this.f2917k = str;
    }

    /* renamed from: m */
    public void mo10231m(String str) {
        this.f2926t = str;
    }

    /* renamed from: n */
    public void mo10233n(String str) {
        this.f2922p = str;
    }

    /* renamed from: o */
    public void mo10235o(String str) {
        this.f2924r = str;
    }

    /* renamed from: p */
    public void mo10236p(String str) {
        this.f2923q = str;
    }

    /* renamed from: q */
    public void mo10239q(String str) {
        this.f2919m = str;
    }

    /* renamed from: r */
    public void mo10241r(String str) {
        this.f2921o = str;
    }

    /* renamed from: s */
    public void mo10243s(String str) {
        this.f2920n = str;
    }

    /* renamed from: t */
    public long mo10244t() {
        return this.f2901B;
    }

    /* renamed from: a */
    public void mo10198a(boolean z) {
        this.f2911e = z;
    }

    /* renamed from: b */
    public void mo10202b(boolean z) {
        this.f2930x = z;
    }

    /* renamed from: c */
    public void mo10203c(int i) {
        this.f2931y = i;
    }

    /* renamed from: d */
    public String mo10208d() {
        return this.f2913g;
    }

    /* renamed from: e */
    public void mo10212e(int i) {
        this.f2905F = i;
    }

    /* renamed from: f */
    public void mo10215f(int i) {
        this.f2903D = i;
    }

    /* renamed from: g */
    public void mo10218g(int i) {
        this.f2904E = i;
    }

    /* renamed from: d */
    private static C1263b m3135d(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            try {
                BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
                if (batteryManager != null) {
                    int intProperty = batteryManager.getIntProperty(4);
                    boolean z = false;
                    if (i >= 23) {
                        z = batteryManager.isCharging();
                    }
                    C1263b bVar = new C1263b();
                    bVar.f2933a = intProperty;
                    bVar.f2934b = z;
                    return bVar;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: e */
    private static long m3136e(Context context) {
        try {
            String file = context.getCacheDir().toString();
            return new StatFs(file + "/.chartboost").getAvailableBytes();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: f */
    private static boolean m3137f(Context context) {
        AudioManager a = m3129a(context);
        if (a == null || a.getRingerMode() == 2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo10195a(int i) {
        this.f2900A = i;
    }

    /* renamed from: b */
    public void mo10200b(long j) {
        this.f2901B = j;
    }

    /* renamed from: c */
    public void mo10206c(boolean z) {
        this.f2932z = z;
    }

    /* renamed from: b */
    private static int m3132b(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                AudioDeviceInfo[] devices = audioManager.getDevices(2);
                if (devices.length > 0) {
                    AudioDeviceInfo audioDeviceInfo = devices[0];
                    if (audioDeviceInfo.getType() == 2) {
                        return 0;
                    }
                    if (audioDeviceInfo.getType() == 4) {
                        return 1;
                    }
                    return audioDeviceInfo.getType() == 8 ? 2 : 3;
                }
            } else if (audioManager.isSpeakerphoneOn()) {
                return 0;
            } else {
                return 3;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void mo10196a(long j) {
        this.f2902C = j;
    }

    /* renamed from: c */
    public void mo10204c(long j) {
        this.f2906G = j;
    }

    /* renamed from: a */
    public static C1261b m3130a(Context context, C1215d.C1216a aVar, C1268g gVar, String str) {
        String str2;
        int i;
        int i2;
        C1261b bVar = new C1261b();
        if (context == null) {
            return bVar;
        }
        int i3 = -1;
        long j = -1;
        int i4 = 0;
        if (gVar != null) {
            try {
                String e = gVar.mo10263e();
                int c = gVar.mo10261c();
                i4 = gVar.mo10260b(0);
                int b = gVar.mo10260b(1);
                int b2 = gVar.mo10260b(3);
                long d = gVar.mo10262d();
                str2 = e;
                i3 = c;
                int i5 = b2;
                i2 = b;
                j = d;
                i = i5;
            } catch (Exception unused) {
            }
        } else {
            str2 = "";
            i2 = 0;
            i = 0;
        }
        bVar.mo10245t(str2);
        bVar.mo10209d(i3);
        bVar.mo10197a(C1418k.f3540j);
        bVar.mo10210d("8.2.0");
        bVar.mo10198a(C1418k.f3544n);
        DataUseConsent a = C1414j.m3860a(context).mo10667a(CCPA.CCPA_STANDARD);
        if (a != null) {
            bVar.mo10201b(a.getConsent());
        }
        DataUseConsent a2 = C1414j.m3860a(context).mo10667a(GDPR.GDPR_STANDARD);
        if (a2 != null) {
            bVar.mo10205c(a2.getConsent());
        } else {
            bVar.mo10205c("-1");
        }
        C1263b d2 = m3135d(context);
        if (d2 != null) {
            bVar.mo10199b(d2.f2933a);
            bVar.mo10202b(d2.f2934b);
        }
        bVar.mo10219g(m3131a(aVar));
        bVar.mo10216f(Locale.getDefault().getCountry());
        bVar.mo10213e(str);
        bVar.mo10221h(m3128K());
        bVar.mo10222i(Build.MODEL);
        bVar.mo10227k("Android " + Build.VERSION.RELEASE);
        bVar.mo10229l(m3127D());
        bVar.mo10225j(CBUtility.m2922c(context));
        bVar.mo10231m(CBUtility.m2924d());
        bVar.mo10200b(m3136e(context));
        bVar.mo10196a(m3133b());
        bVar.mo10203c(m3134c(context));
        bVar.mo10206c(m3137f(context));
        bVar.mo10195a(m3132b(context));
        Chartboost.CBFramework cBFramework = C1418k.f3535e;
        if (cBFramework != null) {
            bVar.mo10233n(cBFramework.name());
            bVar.mo10235o(C1418k.f3537g);
            bVar.mo10236p(C1418k.f3536f);
        }
        MediationModel mediationModel = C1418k.f3539i;
        if (mediationModel != null) {
            bVar.mo10239q(mediationModel.getMediation());
            bVar.mo10243s(mediationModel.getMediationVersion());
            bVar.mo10241r(mediationModel.getAdapterVersion());
        }
        bVar.mo10215f(i4);
        bVar.mo10218g(i2);
        bVar.mo10212e(i);
        bVar.mo10204c(j);
        return bVar;
    }

    /* renamed from: c */
    private static int m3134c(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return (int) ((((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3))) * 100.0f);
    }

    /* renamed from: b */
    private static long m3133b() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory())) / 1048576;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static String m3131a(C1215d.C1216a aVar) {
        if (aVar == null) {
            return "unknown";
        }
        String str = aVar.f2674d;
        return str == null ? aVar.f2673c : str;
    }

    /* renamed from: a */
    private static AudioManager m3129a(Context context) {
        try {
            return (AudioManager) context.getSystemService("audio");
        } catch (Exception unused) {
            return null;
        }
    }
}
