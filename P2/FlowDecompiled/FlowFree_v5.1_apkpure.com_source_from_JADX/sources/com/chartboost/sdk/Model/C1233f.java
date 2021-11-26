package com.chartboost.sdk.Model;

import android.content.Context;
import android.os.Build;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Networking.C1240a;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;
import com.chartboost.sdk.impl.C1327i1;
import com.mopub.common.AdType;
import com.mopub.network.ImpressionData;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.f */
public class C1233f {

    /* renamed from: j */
    private static final String f2766j = "f";

    /* renamed from: k */
    private static Integer f2767k;

    /* renamed from: l */
    private static final String f2768l = Build.VERSION.RELEASE;

    /* renamed from: a */
    private final JSONObject f2769a = new JSONObject();

    /* renamed from: b */
    private final JSONObject f2770b = new JSONObject();

    /* renamed from: c */
    private final JSONArray f2771c = new JSONArray();

    /* renamed from: d */
    private final JSONObject f2772d = new JSONObject();

    /* renamed from: e */
    private final JSONObject f2773e = new JSONObject();

    /* renamed from: f */
    private final JSONObject f2774f = new JSONObject();

    /* renamed from: g */
    private final C1234g f2775g;

    /* renamed from: h */
    private final C1240a f2776h;

    /* renamed from: i */
    private final Context f2777i;

    public C1233f(Context context, C1234g gVar, C1240a aVar) {
        this.f2777i = context;
        f2767k = C1327i1.m3548b(context);
        this.f2775g = gVar;
        this.f2776h = aVar;
        m3044l();
        m3041i();
        m3042j();
        m3040h();
        m3043k();
        m3045m();
    }

    /* renamed from: a */
    private JSONObject m3034a() {
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, "lat", JSONObject.NULL);
        C1217e.m2938a(jSONObject, "lon", JSONObject.NULL);
        C1217e.m2938a(jSONObject, ImpressionData.COUNTRY, this.f2775g.f2784g);
        C1217e.m2938a(jSONObject, "type", 2);
        return jSONObject;
    }

    /* renamed from: b */
    private int m3035b() {
        C1234g gVar = this.f2775g;
        if (gVar != null) {
            return gVar.mo10122f();
        }
        return 0;
    }

    /* renamed from: c */
    private Collection<DataUseConsent> m3036c() {
        C1234g gVar = this.f2775g;
        if (gVar != null) {
            return gVar.mo10127k();
        }
        return new ArrayList();
    }

    /* renamed from: d */
    private int m3037d() {
        C1234g gVar = this.f2775g;
        if (gVar != null) {
            return gVar.mo10123g();
        }
        return 0;
    }

    /* renamed from: f */
    private String m3038f() {
        int i = this.f2776h.f2841a;
        if (i == 0) {
            CBLogging.m2905b(f2766j, "INTERSTITIAL NOT COMPATIBLE WITH OPENRTB");
            return AdType.INTERSTITIAL;
        } else if (i == 1) {
            CBLogging.m2905b(f2766j, "REWARDED_VIDEO NOT COMPATIBLE WITH OPENRTB");
            return "rewarded";
        } else if (i != 2) {
            return i != 3 ? "" : "banner";
        } else {
            CBLogging.m2905b(f2766j, "IN_PLAY NOT COMPATIBLE WITH OPENRTB");
            return "";
        }
    }

    /* renamed from: g */
    private Integer m3039g() {
        int i = this.f2776h.f2841a;
        if (i == 0 || i == 1) {
            return 1;
        }
        return 0;
    }

    /* renamed from: h */
    private void m3040h() {
        C1217e.m2938a(this.f2772d, "id", this.f2775g.f2789l);
        C1217e.m2938a(this.f2772d, MediationMetaData.KEY_NAME, JSONObject.NULL);
        C1217e.m2938a(this.f2772d, "bundle", this.f2775g.f2787j);
        C1217e.m2938a(this.f2772d, "storeurl", JSONObject.NULL);
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, "id", JSONObject.NULL);
        C1217e.m2938a(jSONObject, MediationMetaData.KEY_NAME, JSONObject.NULL);
        C1217e.m2938a(this.f2772d, "publisher", jSONObject);
        C1217e.m2938a(this.f2772d, "cat", JSONObject.NULL);
        C1217e.m2938a(this.f2769a, "app", this.f2772d);
    }

    /* renamed from: i */
    private void m3041i() {
        C1215d.C1216a c = this.f2775g.f2778a.mo10043c(this.f2777i);
        C1234g.C1235a d = this.f2775g.mo10120d();
        C1217e.m2938a(this.f2770b, "devicetype", f2767k);
        C1217e.m2938a(this.f2770b, "w", Integer.valueOf(d.f2799a));
        C1217e.m2938a(this.f2770b, "h", Integer.valueOf(d.f2800b));
        C1217e.m2938a(this.f2770b, "ifa", c.f2674d);
        C1217e.m2938a(this.f2770b, "osv", f2768l);
        C1217e.m2938a(this.f2770b, "lmt", Integer.valueOf(c.mo10044a().booleanValue() ? 1 : 0));
        C1217e.m2938a(this.f2770b, "connectiontype", Integer.valueOf(this.f2775g.f2779b.mo10151c()));
        C1217e.m2938a(this.f2770b, "os", "Android");
        C1217e.m2938a(this.f2770b, "geo", m3034a());
        C1217e.m2938a(this.f2770b, "ip", JSONObject.NULL);
        C1217e.m2938a(this.f2770b, "language", this.f2775g.f2785h);
        C1217e.m2938a(this.f2770b, "ua", C1418k.f3547q);
        C1217e.m2938a(this.f2770b, "model", this.f2775g.f2782e);
        C1217e.m2938a(this.f2770b, "carrier", this.f2775g.f2793p);
        C1217e.m2938a(this.f2769a, "device", this.f2770b);
    }

    /* renamed from: j */
    private void m3042j() {
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, "id", JSONObject.NULL);
        JSONObject jSONObject2 = new JSONObject();
        C1217e.m2938a(jSONObject2, "w", this.f2776h.f2843c);
        C1217e.m2938a(jSONObject2, "h", this.f2776h.f2842b);
        C1217e.m2938a(jSONObject2, "btype", JSONObject.NULL);
        C1217e.m2938a(jSONObject2, "battr", JSONObject.NULL);
        C1217e.m2938a(jSONObject2, "pos", JSONObject.NULL);
        C1217e.m2938a(jSONObject2, "topframe", JSONObject.NULL);
        C1217e.m2938a(jSONObject2, "api", JSONObject.NULL);
        JSONObject jSONObject3 = new JSONObject();
        C1217e.m2938a(jSONObject3, "placementtype", m3038f());
        C1217e.m2938a(jSONObject3, "playableonly", JSONObject.NULL);
        C1217e.m2938a(jSONObject3, "allowscustomclosebutton", JSONObject.NULL);
        C1217e.m2938a(jSONObject2, "ext", jSONObject3);
        C1217e.m2938a(jSONObject, "banner", jSONObject2);
        C1217e.m2938a(jSONObject, "instl", m3039g());
        C1217e.m2938a(jSONObject, "tagid", this.f2776h.f2844d);
        C1217e.m2938a(jSONObject, "displaymanager", "Chartboost-Android-SDK");
        C1217e.m2938a(jSONObject, "displaymanagerver", this.f2775g.f2788k);
        C1217e.m2938a(jSONObject, "bidfloor", JSONObject.NULL);
        C1217e.m2938a(jSONObject, "bidfloorcur", "USD");
        C1217e.m2938a(jSONObject, "secure", 1);
        this.f2771c.put(jSONObject);
        C1217e.m2938a(this.f2769a, "imp", this.f2771c);
    }

    /* renamed from: k */
    private void m3043k() {
        C1217e.m2938a(this.f2773e, "coppa", 0);
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, GDPR.GDPR_STANDARD, Integer.valueOf(m3037d()));
        for (DataUseConsent next : m3036c()) {
            C1217e.m2938a(jSONObject, next.getPrivacyStandard(), next.getConsent());
        }
        C1217e.m2938a(this.f2773e, "ext", jSONObject);
        C1217e.m2938a(this.f2769a, "regs", this.f2773e);
    }

    /* renamed from: l */
    private void m3044l() {
        C1217e.m2938a(this.f2769a, "id", JSONObject.NULL);
        C1217e.m2938a(this.f2769a, "test", JSONObject.NULL);
        C1217e.m2938a(this.f2769a, "cur", new JSONArray().put("USD"));
        C1217e.m2938a(this.f2769a, "at", 2);
    }

    /* renamed from: m */
    private void m3045m() {
        C1217e.m2938a(this.f2774f, "id", JSONObject.NULL);
        C1217e.m2938a(this.f2774f, "geo", m3034a());
        JSONObject jSONObject = new JSONObject();
        C1217e.m2938a(jSONObject, "consent", Integer.valueOf(m3035b()));
        C1217e.m2938a(jSONObject, "impdepth", Integer.valueOf(this.f2776h.f2845e));
        C1217e.m2938a(this.f2774f, "ext", jSONObject);
        C1217e.m2938a(this.f2769a, "user", this.f2774f);
    }

    /* renamed from: e */
    public JSONObject mo10115e() {
        return this.f2769a;
    }
}
