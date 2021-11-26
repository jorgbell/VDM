package com.applovin.impl.sdk.p035a;

import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import com.applovin.impl.adview.C0651i;
import com.applovin.impl.adview.C0715t;
import com.applovin.impl.adview.C0719w;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1180y;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0973a;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.g */
public abstract class C0934g extends AppLovinAdBase {

    /* renamed from: a */
    private final List<Uri> f1445a = C1117e.m2519a();

    /* renamed from: b */
    private final AtomicBoolean f1446b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f1447c = new AtomicBoolean();

    /* renamed from: d */
    private final AtomicReference<C0962c> f1448d = new AtomicReference<>();

    /* renamed from: e */
    private boolean f1449e;

    /* renamed from: f */
    private List<C0973a> f1450f;

    /* renamed from: g */
    private List<C0973a> f1451g;

    /* renamed from: h */
    private List<C0973a> f1452h;

    /* renamed from: i */
    private List<C0973a> f1453i;

    /* renamed from: j */
    private C0938c f1454j;

    /* renamed from: com.applovin.impl.sdk.a.g$a */
    public enum C0936a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* renamed from: com.applovin.impl.sdk.a.g$b */
    public enum C0937b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* renamed from: com.applovin.impl.sdk.a.g$c */
    public class C0938c {

        /* renamed from: a */
        public final int f1463a;

        /* renamed from: b */
        public final int f1464b;

        /* renamed from: c */
        public final int f1465c;

        /* renamed from: d */
        public final int f1466d;

        /* renamed from: e */
        public final int f1467e;

        private C0938c() {
            this.f1463a = AppLovinSdkUtils.dpToPx(C0934g.this.sdk.mo9334J(), C0934g.this.mo9014W());
            this.f1464b = AppLovinSdkUtils.dpToPx(C0934g.this.sdk.mo9334J(), C0934g.this.mo9015X());
            this.f1465c = AppLovinSdkUtils.dpToPx(C0934g.this.sdk.mo9334J(), C0934g.this.mo9016Y());
            this.f1466d = AppLovinSdkUtils.dpToPx(C0934g.this.sdk.mo9334J(), ((Integer) C0934g.this.sdk.mo9350a(C0965b.f1680bz)).intValue());
            this.f1467e = AppLovinSdkUtils.dpToPx(C0934g.this.sdk.mo9334J(), ((Integer) C0934g.this.sdk.mo9350a(C0965b.f1679by)).intValue());
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.g$d */
    public enum C0939d {
        RESIZE_ASPECT,
        RESIZE_ASPECT_FILL,
        RESIZE
    }

    public C0934g(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, C1062k kVar) {
        super(jSONObject, jSONObject2, bVar, kVar);
    }

    /* renamed from: a */
    private List<C0973a> m1585a(PointF pointF, boolean z) {
        List<C0973a> a;
        synchronized (this.adObjectLock) {
            a = C1160r.m2715a("click_tracking_urls", this.adObject, m1591c(pointF, z), m1587b(pointF, z), mo9051at(), mo9072x(), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    private String m1587b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", (String) null);
        Map<String, String> c = m1591c(pointF, z);
        if (stringFromAdObject != null) {
            return C1155o.m2668a(stringFromAdObject, c);
        }
        return null;
    }

    /* renamed from: c */
    private C0651i.C0652a m1588c(boolean z) {
        return z ? C0651i.C0652a.WHITE_ON_TRANSPARENT : C0651i.C0652a.WHITE_ON_BLACK;
    }

    /* renamed from: c */
    private String mo7824c() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* renamed from: c */
    private Map<String, String> m1591c(PointF pointF, boolean z) {
        Point a = C1119g.m2526a(this.sdk.mo9334J());
        HashMap hashMap = new HashMap(5);
        hashMap.put("{CLCODE}", getClCode());
        hashMap.put("{CLICK_X}", String.valueOf(pointF.x));
        hashMap.put("{CLICK_Y}", String.valueOf(pointF.y));
        hashMap.put("{SCREEN_WIDTH}", String.valueOf(a.x));
        hashMap.put("{SCREEN_HEIGHT}", String.valueOf(a.y));
        hashMap.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        return hashMap;
    }

    /* renamed from: A */
    public String mo8993A() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", (JSONObject) null);
        return jsonObjectFromAdObject != null ? C1123j.m2594b(jsonObjectFromAdObject, "video_button_html", "", this.sdk) : "";
    }

    /* renamed from: B */
    public C0715t mo8994B() {
        return new C0715t(getJsonObjectFromAdObject("video_button_properties", (JSONObject) null), this.sdk);
    }

    /* renamed from: C */
    public boolean mo7812C() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    /* renamed from: D */
    public boolean mo8995D() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    /* renamed from: E */
    public int mo8996E() {
        return getIntFromAdObject("countdown_length", 0);
    }

    /* renamed from: F */
    public int mo8997F() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    /* renamed from: G */
    public int mo8998G() {
        return getColorFromAdObject("graphic_background_color", hasVideoUrl() ? -16777216 : -1157627904);
    }

    /* renamed from: H */
    public C0936a mo8999H() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", (String) null);
        if (C1155o.m2673b(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C0936a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C0936a.DO_NOT_DISMISS;
            }
        }
        return C0936a.UNSPECIFIED;
    }

    /* renamed from: I */
    public List<String> mo9000I() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", (String) null);
        return stringFromAdObject != null ? C1117e.m2521a(stringFromAdObject) : this.sdk.mo9381b(C0965b.f1664bj);
    }

    /* renamed from: J */
    public String mo9001J() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    /* renamed from: K */
    public boolean mo9002K() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    /* renamed from: L */
    public String mo9003L() {
        return getStringFromFullResponse("event_id", (String) null);
    }

    /* renamed from: M */
    public boolean mo9004M() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    /* renamed from: N */
    public int mo9005N() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    /* renamed from: O */
    public int mo9006O() {
        int a;
        synchronized (this.adObjectLock) {
            a = C1160r.m2701a(this.adObject);
        }
        return a;
    }

    /* renamed from: P */
    public int mo9007P() {
        synchronized (this.adObjectLock) {
            int b = C1123j.m2592b(this.adObject, "graphic_completion_percent", -1, (C1062k) null);
            if (b < 0 || b > 100) {
                return 90;
            }
            return b;
        }
    }

    /* renamed from: Q */
    public int mo9008Q() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    /* renamed from: R */
    public int mo9009R() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    /* renamed from: S */
    public boolean mo9010S() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    /* renamed from: T */
    public boolean mo9011T() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    /* renamed from: U */
    public boolean mo9012U() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    /* renamed from: V */
    public C0938c mo9013V() {
        if (this.f1454j == null) {
            this.f1454j = new C0938c();
        }
        return this.f1454j;
    }

    /* renamed from: W */
    public int mo9014W() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.mo9350a(C0965b.f1652bX)).intValue());
    }

    /* renamed from: X */
    public int mo9015X() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.mo9350a(C0965b.f1653bY)).intValue());
    }

    /* renamed from: Y */
    public int mo9016Y() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.mo9350a(C0965b.f1651bW)).intValue());
    }

    /* renamed from: Z */
    public boolean mo9017Z() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.mo9350a(C0965b.f1650bV));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0651i.C0652a mo9018a(int i) {
        return i == 1 ? C0651i.C0652a.WHITE_ON_TRANSPARENT : i == 2 ? C0651i.C0652a.INVISIBLE : C0651i.C0652a.WHITE_ON_BLACK;
    }

    /* renamed from: a */
    public List<C0973a> mo9019a(PointF pointF) {
        return m1585a(pointF, false);
    }

    /* renamed from: a */
    public abstract void mo7815a();

    /* renamed from: a */
    public void mo9020a(C0962c cVar) {
        this.f1448d.set(cVar);
    }

    /* renamed from: a */
    public void mo9021a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aA */
    public List<String> mo9022aA() {
        return C1117e.m2521a(getStringFromAdObject("wlh", (String) null));
    }

    /* renamed from: aB */
    public boolean mo9023aB() {
        return getBooleanFromAdObject("ibbdfs", Boolean.FALSE);
    }

    /* renamed from: aC */
    public boolean mo9024aC() {
        return getBooleanFromAdObject("ibbdfc", Boolean.FALSE);
    }

    /* renamed from: aD */
    public Uri mo9025aD() {
        String stringFromAdObject = getStringFromAdObject("mute_image", (String) null);
        if (C1155o.m2673b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aE */
    public Uri mo9026aE() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (C1155o.m2673b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aF */
    public boolean mo9027aF() {
        return this.f1447c.get();
    }

    /* renamed from: aG */
    public void mo9028aG() {
        this.f1447c.set(true);
    }

    /* renamed from: aH */
    public C0962c mo9029aH() {
        return this.f1448d.getAndSet((Object) null);
    }

    /* renamed from: aI */
    public boolean mo9030aI() {
        Boolean bool = Boolean.FALSE;
        return getBooleanFromAdObject("suep", bool) || (getBooleanFromAdObject("suepfs", bool) && mo7826e());
    }

    /* renamed from: aJ */
    public long mo9031aJ() {
        return getLongFromAdObject("vrsbt_ms", TimeUnit.SECONDS.toMillis(3));
    }

    /* renamed from: aK */
    public boolean mo9032aK() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    /* renamed from: aa */
    public boolean mo9033aa() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.mo9350a(C0965b.f1718cl));
    }

    /* renamed from: ab */
    public long mo9034ab() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    /* renamed from: ac */
    public int mo9035ac() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    /* renamed from: ad */
    public boolean mo9036ad() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    /* renamed from: ae */
    public AtomicBoolean mo9037ae() {
        return this.f1446b;
    }

    /* renamed from: af */
    public boolean mo9038af() {
        return getBooleanFromAdObject("show_nia", Boolean.FALSE);
    }

    /* renamed from: ag */
    public String mo9039ag() {
        return getStringFromAdObject("nia_title", "");
    }

    /* renamed from: ah */
    public String mo9040ah() {
        return getStringFromAdObject("nia_message", "");
    }

    /* renamed from: ai */
    public String mo9041ai() {
        return getStringFromAdObject("nia_button_title", "");
    }

    /* renamed from: aj */
    public boolean mo9042aj() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    /* renamed from: ak */
    public boolean mo9043ak() {
        return this.f1449e;
    }

    /* renamed from: al */
    public boolean mo9044al() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    /* renamed from: am */
    public String mo9045am() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    /* renamed from: an */
    public String mo9046an() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    /* renamed from: ao */
    public String mo9047ao() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    /* renamed from: ap */
    public List<C0973a> mo9048ap() {
        List<C0973a> a;
        List<C0973a> list = this.f1450f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C1160r.m2712a("video_end_urls", this.adObject, getClCode(), mo7824c(), this.sdk);
            this.f1450f = a;
        }
        return a;
    }

    /* renamed from: aq */
    public List<C0973a> mo9049aq() {
        List<C0973a> a;
        List<C0973a> list = this.f1451g;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C1160r.m2712a("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1451g = a;
        }
        return a;
    }

    /* renamed from: ar */
    public List<C0973a> mo9050ar() {
        List<C0973a> a;
        List<C0973a> list = this.f1452h;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C1160r.m2712a("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1452h = a;
        }
        return a;
    }

    /* renamed from: as */
    public List<C0973a> mo7822as() {
        List<C0973a> a;
        List<C0973a> list = this.f1453i;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C1160r.m2714a("imp_urls", this.adObject, getClCode(), C1117e.m2524a("{SOC}", String.valueOf(mo9043ak())), (String) null, mo9051at(), mo9072x(), this.sdk);
            this.f1453i = a;
        }
        return a;
    }

    /* renamed from: at */
    public Map<String, String> mo9051at() {
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.FALSE;
        if (getBooleanFromAdObject("send_webview_http_headers", bool)) {
            hashMap.putAll(C1180y.m2819b());
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", bool)) {
            hashMap.put("User-Agent", C1180y.m2815a());
        }
        return hashMap;
    }

    /* renamed from: au */
    public boolean mo9052au() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    /* renamed from: av */
    public String mo9053av() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    /* renamed from: aw */
    public boolean mo9054aw() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.FALSE);
    }

    /* renamed from: ax */
    public C0719w mo9055ax() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return new C0719w(jsonObjectFromAdObject, this.sdk);
        }
        return null;
    }

    /* renamed from: ay */
    public int mo9056ay() {
        return getIntFromAdObject("whalt", C1160r.m2733a(getSize()) ? 1 : ((Boolean) this.sdk.mo9350a(C0965b.f1793eI)).booleanValue() ? 0 : -1);
    }

    /* renamed from: az */
    public List<String> mo9057az() {
        return C1117e.m2521a(getStringFromAdObject("wls", ""));
    }

    /* renamed from: b */
    public List<C0973a> mo9058b(PointF pointF) {
        List<C0973a> a;
        synchronized (this.adObjectLock) {
            a = C1160r.m2715a("video_click_tracking_urls", this.adObject, m1591c(pointF, true), (String) null, mo9051at(), mo9072x(), this.sdk);
        }
        return a.isEmpty() ? m1585a(pointF, true) : a;
    }

    /* renamed from: b */
    public abstract JSONObject mo7823b();

    /* renamed from: b */
    public void mo9059b(Uri uri) {
        this.f1445a.add(uri);
    }

    /* renamed from: b */
    public void mo9060b(boolean z) {
        this.f1449e = z;
    }

    /* renamed from: c */
    public void mo9061c(Uri uri) {
        synchronized (this.adObjectLock) {
            C1123j.m2583a(this.adObject, "mute_image", (Object) uri, this.sdk);
        }
    }

    /* renamed from: d */
    public abstract String mo7825d();

    /* renamed from: d */
    public void mo9062d(Uri uri) {
        synchronized (this.adObjectLock) {
            C1123j.m2583a(this.adObject, "unmute_image", (Object) uri, this.sdk);
        }
    }

    /* renamed from: e */
    public boolean mo7826e() {
        this.sdk.mo9411z().mo9588e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: g */
    public Uri mo7829g() {
        this.sdk.mo9411z().mo9588e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    /* renamed from: i */
    public Uri mo7834i() {
        this.sdk.mo9411z().mo9588e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: j */
    public Uri mo7835j() {
        this.sdk.mo9411z().mo9588e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: o */
    public boolean mo9063o() {
        return getBooleanFromAdObject("fs_2", Boolean.FALSE);
    }

    /* renamed from: p */
    public C0937b mo9064p() {
        C0937b bVar = C0937b.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", bVar.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C0937b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C0937b.ACTIVITY_LANDSCAPE : bVar;
    }

    /* renamed from: q */
    public String mo9065q() {
        return getStringFromFullResponse("dsp_name", "");
    }

    /* renamed from: r */
    public long mo9066r() {
        return getLongFromAdObject("close_delay", 0);
    }

    /* renamed from: s */
    public long mo9067s() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5));
    }

    /* renamed from: t */
    public long mo9068t() {
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", 0);
        if (!mo9063o()) {
            return longFromAdObject;
        }
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0;
        }
        return longFromAdObject;
    }

    /* renamed from: u */
    public C0651i.C0652a mo9069u() {
        int intFromAdObject = getIntFromAdObject("close_style", -1);
        return intFromAdObject == -1 ? m1588c(hasVideoUrl()) : mo9018a(intFromAdObject);
    }

    /* renamed from: v */
    public C0651i.C0652a mo9070v() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? mo9069u() : mo9018a(intFromAdObject);
    }

    /* renamed from: w */
    public boolean mo9071w() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    /* renamed from: x */
    public boolean mo9072x() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    /* renamed from: y */
    public boolean mo9073y() {
        return getBooleanFromAdObject("html_resources_cached", Boolean.FALSE);
    }

    /* renamed from: z */
    public List<Uri> mo9074z() {
        return this.f1445a;
    }
}
