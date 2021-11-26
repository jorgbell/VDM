package com.flurry.sdk;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.by */
public final class C1605by {

    /* renamed from: b */
    private static String f4038b;

    /* renamed from: c */
    private static String f4039c;

    /* renamed from: a */
    C1606a f4040a;

    /* renamed from: d */
    private Object f4041d;

    /* renamed from: com.flurry.sdk.by$a */
    public enum C1606a {
        String("string"),
        Locale("localizedString"),
        Tombstone("tombstone");
        
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f4046d;

        private C1606a(String str) {
            this.f4046d = str;
        }

        public final String toString() {
            return this.f4046d;
        }
    }

    public C1605by(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        C1606a aVar = C1606a.String;
        if (aVar.f4046d.equals(optString)) {
            this.f4040a = aVar;
            this.f4041d = jSONObject.optString("value");
            return;
        }
        C1606a aVar2 = C1606a.Locale;
        if (aVar2.f4046d.equals(optString)) {
            this.f4040a = aVar2;
            this.f4041d = jSONObject.optJSONObject("value");
            return;
        }
        C1606a aVar3 = C1606a.Tombstone;
        if (aVar3.f4046d.equals(optString)) {
            this.f4040a = aVar3;
        } else {
            C1648cy.m4325b("ConfigItem", "Unknown ConfigItem type: ".concat(String.valueOf(optString)));
        }
    }

    /* renamed from: a */
    public final String mo11362a() {
        Object obj = this.f4041d;
        if (obj == null) {
            return null;
        }
        if (this.f4040a != C1606a.Locale) {
            return (String) obj;
        }
        if (f4038b == null) {
            f4038b = Locale.getDefault().toString();
            f4039c = Locale.getDefault().getLanguage();
        }
        JSONObject jSONObject = (JSONObject) this.f4041d;
        String optString = jSONObject.optString(f4038b, (String) null);
        if (optString == null) {
            optString = jSONObject.optString(f4039c, (String) null);
        }
        return optString == null ? jSONObject.optString("default") : optString;
    }

    /* renamed from: a */
    public final JSONObject mo11363a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationMetaData.KEY_NAME, str);
            jSONObject.put("type", this.f4040a.toString());
            jSONObject.put("value", this.f4041d);
            return jSONObject;
        } catch (JSONException e) {
            C1648cy.m4320a("ConfigItem", "Error to create JSON object.", (Throwable) e);
            return null;
        }
    }
}
