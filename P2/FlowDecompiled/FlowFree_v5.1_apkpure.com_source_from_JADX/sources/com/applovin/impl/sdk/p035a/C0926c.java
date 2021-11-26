package com.applovin.impl.sdk.p035a;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1155o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.c */
public class C0926c {

    /* renamed from: a */
    private final C1062k f1399a;

    /* renamed from: b */
    private final String f1400b;

    /* renamed from: com.applovin.impl.sdk.a.c$a */
    public enum C0927a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        

        /* renamed from: d */
        private final String f1405d;

        private C0927a(String str) {
            this.f1405d = str;
        }

        public String toString() {
            return this.f1405d;
        }
    }

    public C0926c(String str, C1062k kVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (kVar != null) {
            this.f1400b = str;
            this.f1399a = kVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private String m1533a(C0965b<String> bVar) {
        for (String next : this.f1399a.mo9381b(bVar)) {
            if (this.f1400b.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo8964a() {
        return this.f1400b;
    }

    /* renamed from: b */
    public C0927a mo8965b() {
        return m1533a(C0965b.f1596aU) != null ? C0927a.REGULAR : m1533a(C0965b.f1597aV) != null ? C0927a.AD_RESPONSE_JSON : C0927a.UNSPECIFIED;
    }

    /* renamed from: c */
    public String mo8966c() {
        String a = m1533a(C0965b.f1596aU);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = m1533a(C0965b.f1597aV);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject mo8967d() {
        if (mo8965b() != C0927a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f1400b.substring(mo8966c().length()), 0), "UTF-8"));
                C1107r z = this.f1399a.mo9411z();
                z.mo9584b("AdToken", "Decoded token into ad response: " + jSONObject);
                return jSONObject;
            } catch (JSONException e) {
                C1107r z2 = this.f1399a.mo9411z();
                z2.mo9585b("AdToken", "Unable to decode token '" + this.f1400b + "' into JSON", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            C1107r z3 = this.f1399a.mo9411z();
            z3.mo9585b("AdToken", "Unable to process ad response from token '" + this.f1400b + "'", e2);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0926c)) {
            return false;
        }
        String str = this.f1400b;
        String str2 = ((C0926c) obj).f1400b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f1400b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String a = C1155o.m2665a(32, this.f1400b);
        return "AdToken{id=" + a + ", type=" + mo8965b() + '}';
    }
}
