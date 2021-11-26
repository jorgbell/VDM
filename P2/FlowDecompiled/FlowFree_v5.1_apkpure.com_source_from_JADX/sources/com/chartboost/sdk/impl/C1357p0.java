package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1285i;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.C1214c;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1243c;
import com.chartboost.sdk.Networking.C1244d;
import com.chartboost.sdk.Networking.C1245e;
import com.chartboost.sdk.Networking.C1246f;
import com.chartboost.sdk.Networking.NetworkHelper;
import com.chartboost.sdk.Networking.requests.models.MediationModel;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.mopub.network.ImpressionData;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.p0 */
public class C1357p0 extends C1243c<JSONObject> {

    /* renamed from: j */
    private final String f3339j;

    /* renamed from: k */
    public JSONObject f3340k = new JSONObject();

    /* renamed from: l */
    public final C1358a f3341l;

    /* renamed from: m */
    public boolean f3342m = false;

    /* renamed from: n */
    protected final C1234g f3343n;

    /* renamed from: com.chartboost.sdk.impl.p0$a */
    public interface C1358a {
        /* renamed from: a */
        void mo10426a(C1357p0 p0Var, CBError cBError);

        /* renamed from: a */
        void mo10427a(C1357p0 p0Var, JSONObject jSONObject);
    }

    public C1357p0(String str, String str2, C1234g gVar, int i, C1358a aVar) {
        super("POST", NetworkHelper.m3082a(str, str2), i, (File) null);
        this.f3339j = str2;
        this.f3343n = gVar;
        this.f3341l = aVar;
    }

    /* renamed from: a */
    public void mo10561a(String str) {
    }

    /* renamed from: c */
    public void mo10564c() {
        C1234g.C1235a d = this.f3343n.mo10120d();
        mo10562a("app", (Object) this.f3343n.f2789l);
        mo10562a("model", (Object) this.f3343n.f2782e);
        mo10562a("device_type", (Object) this.f3343n.f2790m);
        mo10562a("actual_device_type", (Object) this.f3343n.f2791n);
        mo10562a("os", (Object) this.f3343n.f2783f);
        mo10562a(ImpressionData.COUNTRY, (Object) this.f3343n.f2784g);
        mo10562a("language", (Object) this.f3343n.f2785h);
        mo10562a("sdk", (Object) this.f3343n.f2788k);
        mo10562a("user_agent", (Object) C1418k.f3547q);
        mo10562a("timestamp", (Object) String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f3343n.f2781d.mo10066a())));
        mo10562a("session", (Object) Integer.valueOf(this.f3343n.mo10126j()));
        mo10562a("reachability", (Object) Integer.valueOf(this.f3343n.mo10118b()));
        mo10562a("is_portrait", (Object) Boolean.valueOf(this.f3343n.mo10128l()));
        mo10562a("scale", (Object) Float.valueOf(d.f2803e));
        mo10562a("bundle", (Object) this.f3343n.f2786i);
        mo10562a("bundle_id", (Object) this.f3343n.f2787j);
        mo10562a("carrier", (Object) this.f3343n.f2792o);
        mo10562a("custom_id", (Object) C1418k.f3532b);
        MediationModel mediationModel = C1418k.f3539i;
        if (mediationModel != null) {
            mo10562a("mediation", (Object) mediationModel.getMediation());
            mo10562a("mediation_version", (Object) C1418k.f3539i.getMediationVersion());
            mo10562a("adapter_version", (Object) C1418k.f3539i.getAdapterVersion());
        }
        if (C1418k.f3535e != null) {
            mo10562a("framework_version", (Object) C1418k.f3537g);
            mo10562a("wrapper_version", (Object) C1418k.f3533c);
        }
        mo10562a("rooted_device", (Object) Boolean.valueOf(this.f3343n.f2794q));
        mo10562a("timezone", (Object) this.f3343n.f2795r);
        mo10562a("mobile_network", (Object) Integer.valueOf(this.f3343n.mo10116a()));
        mo10562a("dw", (Object) Integer.valueOf(d.f2799a));
        mo10562a("dh", (Object) Integer.valueOf(d.f2800b));
        mo10562a("dpi", (Object) d.f2804f);
        mo10562a("w", (Object) Integer.valueOf(d.f2801c));
        mo10562a("h", (Object) Integer.valueOf(d.f2802d));
        mo10562a("commit_hash", (Object) "f71d6860a00fdbd99288c1173607cbbf70005dbc");
        C1215d.C1216a e = this.f3343n.mo10121e();
        mo10562a("identity", (Object) e.f2672b);
        int i = e.f2671a;
        if (i != -1) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            mo10562a("limit_ad_tracking", (Object) Boolean.valueOf(z));
        }
        mo10562a("pidatauseconsent", (Object) Integer.valueOf(C1380v0.f3390a.getValue()));
        String str = this.f3343n.f2780c.get().f2807a;
        if (!C1406x.m3823b().mo10696a((CharSequence) str)) {
            mo10562a("config_variant", (Object) str);
        }
        mo10562a("privacy", (Object) this.f3343n.mo10124h());
    }

    /* renamed from: d */
    public String mo10565d() {
        String str = "/";
        if (this.f3339j == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3339j.startsWith(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(this.f3339j);
        return sb.toString();
    }

    /* renamed from: e */
    public String mo10566e() {
        return mo10565d();
    }

    /* renamed from: a */
    public void mo10562a(String str, Object obj) {
        C1217e.m2938a(this.f3340k, str, obj);
    }

    /* renamed from: a */
    private void m3668a(C1246f fVar, CBError cBError) {
        Object obj;
        String str;
        C1217e.C1218a[] aVarArr = new C1217e.C1218a[5];
        aVarArr[0] = C1217e.m2935a("endpoint", (Object) mo10565d());
        String str2 = "None";
        if (fVar == null) {
            obj = str2;
        } else {
            obj = Integer.valueOf(fVar.f2861a);
        }
        aVarArr[1] = C1217e.m2935a("statuscode", obj);
        if (cBError == null) {
            str = str2;
        } else {
            str = cBError.getError().toString();
        }
        aVarArr[2] = C1217e.m2935a("error", (Object) str);
        if (cBError != null) {
            str2 = cBError.getErrorDesc();
        }
        aVarArr[3] = C1217e.m2935a("errorDescription", (Object) str2);
        aVarArr[4] = C1217e.m2935a("retryCount", (Object) 0);
        JSONObject a = C1217e.m2937a(aVarArr);
        CBLogging.m2903a("CBRequest", "sendToSessionLogs: " + a.toString());
    }

    /* renamed from: a */
    public C1244d mo10142a() {
        mo10564c();
        String jSONObject = this.f3340k.toString();
        String str = C1418k.f3540j;
        String str2 = C1418k.f3541k;
        String a = C1214c.m2928a(C1214c.m2929b(String.format(Locale.US, "%s %s\n%s\n%s", new Object[]{this.f2847a, mo10566e(), str2, jSONObject}).getBytes()));
        HashMap hashMap = new HashMap();
        hashMap.put("Accept", "application/json");
        hashMap.put("X-Chartboost-Client", CBUtility.m2925e());
        hashMap.put("X-Chartboost-API", "8.2.0");
        hashMap.put("X-Chartboost-App", str);
        hashMap.put("X-Chartboost-Signature", a);
        if (C1285i.f3034a) {
            String b = C1285i.m3347b();
            if (b.length() > 0) {
                hashMap.put("X-Chartboost-Test", b);
            }
            String a2 = C1285i.m3345a();
            if (a2 != null) {
                hashMap.put("X-Chartboost-Test", a2);
            }
        }
        return new C1244d(hashMap, jSONObject.getBytes(), "application/json");
    }

    /* renamed from: a */
    public C1245e<JSONObject> mo10143a(C1246f fVar) {
        try {
            if (fVar.f2862b == null) {
                return C1245e.m3092a(new CBError(CBError.C1227b.INVALID_RESPONSE, "Response is not a valid json object"));
            }
            JSONObject jSONObject = new JSONObject(new String(fVar.f2862b));
            CBLogging.m2908d("CBRequest", "Request " + mo10565d() + " succeeded. Response code: " + fVar.f2861a + ", body: " + jSONObject.toString(4));
            if (this.f3342m) {
                int optInt = jSONObject.optInt("status");
                if (optInt == 404) {
                    return C1245e.m3092a(new CBError(CBError.C1227b.HTTP_NOT_FOUND, "404 error from server"));
                }
                if (optInt < 200 || optInt > 299) {
                    String str = "Request failed due to status code " + optInt + " in message";
                    CBLogging.m2905b("CBRequest", str);
                    return C1245e.m3092a(new CBError(CBError.C1227b.UNEXPECTED_RESPONSE, str));
                }
            }
            return C1245e.m3093a(jSONObject);
        } catch (Exception e) {
            C1266e.m3223e(new C1260a("response_json_serialization_error", e.getMessage(), "", ""));
            CBLogging.m2905b("CBRequest", "parseServerResponse: " + e.toString());
            return C1245e.m3092a(new CBError(CBError.C1227b.MISCELLANEOUS, e.getLocalizedMessage()));
        }
    }

    /* renamed from: a */
    public void mo10145a(JSONObject jSONObject, C1246f fVar) {
        CBLogging.m2908d("CBRequest", "Request success: " + this.f2848b + " status: " + fVar.f2861a);
        C1358a aVar = this.f3341l;
        if (!(aVar == null || jSONObject == null)) {
            aVar.mo10427a(this, jSONObject);
        }
        m3668a(fVar, (CBError) null);
    }

    /* renamed from: a */
    public void mo10144a(CBError cBError, C1246f fVar) {
        if (cBError != null) {
            CBLogging.m2908d("CBRequest", "Request failure: " + this.f2848b + " status: " + cBError.getErrorDesc());
            C1358a aVar = this.f3341l;
            if (aVar != null) {
                aVar.mo10426a(this, cBError);
            }
            m3668a(fVar, cBError);
        }
    }
}
