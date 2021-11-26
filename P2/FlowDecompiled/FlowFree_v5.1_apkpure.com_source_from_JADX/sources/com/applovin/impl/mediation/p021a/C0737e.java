package com.applovin.impl.mediation.p021a;

import android.os.Bundle;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.e */
public class C0737e {

    /* renamed from: a */
    private final JSONObject f770a;

    /* renamed from: b */
    protected final C1062k f771b;

    /* renamed from: c */
    private final JSONObject f772c;

    /* renamed from: d */
    private final Object f773d = new Object();

    /* renamed from: e */
    private final Object f774e = new Object();

    /* renamed from: f */
    private volatile String f775f;

    public C0737e(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.f771b = kVar;
            this.f770a = jSONObject2;
            this.f772c = jSONObject;
        } else {
            throw new IllegalArgumentException("No ad object specified");
        }
    }

    /* renamed from: a */
    private int mo8385a() {
        return mo8462b("mute_state", mo8454a("mute_state", ((Integer) this.f771b.mo9350a(C0964a.f1532J)).intValue()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public JSONObject mo8440G() {
        JSONObject jSONObject;
        synchronized (this.f774e) {
            jSONObject = this.f770a;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public JSONObject mo8441H() {
        JSONObject jSONObject;
        synchronized (this.f773d) {
            jSONObject = this.f772c;
        }
        return jSONObject;
    }

    /* renamed from: I */
    public String mo8442I() {
        return mo8466b("class", (String) null);
    }

    /* renamed from: J */
    public String mo8443J() {
        return mo8466b(MediationMetaData.KEY_NAME, (String) null);
    }

    /* renamed from: K */
    public String mo8444K() {
        return mo8443J().split("_")[0];
    }

    /* renamed from: L */
    public boolean mo8445L() {
        return mo8464b("is_testing", Boolean.FALSE).booleanValue();
    }

    /* renamed from: M */
    public Boolean mo8446M() {
        return mo8461a("huc") ? mo8464b("huc", Boolean.FALSE) : mo8456a("huc", (Boolean) null);
    }

    /* renamed from: N */
    public Boolean mo8447N() {
        return mo8461a("aru") ? mo8464b("aru", Boolean.FALSE) : mo8456a("aru", (Boolean) null);
    }

    /* renamed from: O */
    public Boolean mo8448O() {
        return mo8461a("dns") ? mo8464b("dns", Boolean.FALSE) : mo8456a("dns", (Boolean) null);
    }

    /* renamed from: P */
    public boolean mo8449P() {
        return mo8464b("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    /* renamed from: Q */
    public Bundle mo8450Q() {
        Bundle c = mo8465b("server_parameters") instanceof JSONObject ? C1123j.m2602c(mo8460a("server_parameters", (JSONObject) null)) : new Bundle();
        int a = mo8385a();
        if (a != -1) {
            c.putBoolean("is_muted", a == 2 ? this.f771b.mo9400p().isMuted() : a == 0);
        }
        return c;
    }

    /* renamed from: R */
    public long mo8451R() {
        return mo8463b("adapter_timeout_ms", ((Long) this.f771b.mo9350a(C0964a.f1553l)).longValue());
    }

    /* renamed from: S */
    public long mo8452S() {
        return mo8463b("init_completion_delay_ms", -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo8453a(String str, float f) {
        float a;
        synchronized (this.f773d) {
            a = C1123j.m2565a(this.f772c, str, f, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8454a(String str, int i) {
        int b;
        synchronized (this.f774e) {
            b = C1123j.m2592b(this.f770a, str, i, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo8455a(String str, long j) {
        long a;
        synchronized (this.f774e) {
            a = C1123j.m2566a(this.f770a, str, j, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean mo8456a(String str, Boolean bool) {
        Boolean a;
        synchronized (this.f774e) {
            a = C1123j.m2568a(this.f770a, str, bool, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Float mo8457a(String str, Float f) {
        Float a;
        synchronized (this.f773d) {
            a = C1123j.m2569a(this.f772c, str, f, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8458a(String str, String str2) {
        String b;
        synchronized (this.f774e) {
            b = C1123j.m2594b(this.f770a, str, str2, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONArray mo8459a(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f774e) {
            b = C1123j.m2599b(this.f770a, str, jSONArray, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo8460a(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.f773d) {
            b = C1123j.m2600b(this.f772c, str, jSONObject, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8461a(String str) {
        boolean has;
        synchronized (this.f773d) {
            has = this.f772c.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8462b(String str, int i) {
        int b;
        synchronized (this.f773d) {
            b = C1123j.m2592b(this.f772c, str, i, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo8463b(String str, long j) {
        long a;
        synchronized (this.f773d) {
            a = C1123j.m2566a(this.f772c, str, j, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Boolean mo8464b(String str, Boolean bool) {
        Boolean a;
        synchronized (this.f773d) {
            a = C1123j.m2568a(this.f772c, str, bool, this.f771b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo8465b(String str) {
        Object opt;
        synchronized (this.f773d) {
            opt = this.f772c.opt(str);
        }
        return opt;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo8466b(String str, String str2) {
        String b;
        synchronized (this.f773d) {
            b = C1123j.m2594b(this.f772c, str, str2, this.f771b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray mo8467b(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f773d) {
            b = C1123j.m2599b(this.f772c, str, jSONArray, this.f771b);
        }
        return b;
    }

    /* renamed from: c */
    public void mo8468c(String str) {
        this.f775f = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8469c(String str, long j) {
        synchronized (this.f773d) {
            C1123j.m2601b(this.f772c, str, j, this.f771b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8470c(String str, String str2) {
        synchronized (this.f773d) {
            C1123j.m2584a(this.f772c, str, str2, this.f771b);
        }
    }

    /* renamed from: d */
    public List<String> mo8471d(String str) {
        if (str != null) {
            JSONArray a = mo8459a(str, new JSONArray());
            List list = Collections.EMPTY_LIST;
            List a2 = C1123j.m2573a(a, list);
            List a3 = C1123j.m2573a(mo8467b(str, new JSONArray()), list);
            ArrayList arrayList = new ArrayList(a2.size() + a3.size());
            arrayList.addAll(a2);
            arrayList.addAll(a3);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    /* renamed from: e */
    public String mo8472e(String str) {
        String b = mo8466b(str, "");
        return C1155o.m2673b(b) ? b : mo8458a(str, "");
    }

    public String getPlacement() {
        return this.f775f;
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + mo8442I() + "', adapterName='" + mo8443J() + "', isTesting=" + mo8445L() + '}';
    }
}
