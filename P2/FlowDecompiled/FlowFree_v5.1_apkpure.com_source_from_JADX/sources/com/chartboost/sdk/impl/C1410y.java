package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1229b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.y */
public class C1410y extends C1228a {

    /* renamed from: u */
    public int f3487u;

    /* renamed from: v */
    private C1300e0 f3488v = null;

    public C1410y(int i, JSONObject jSONObject) throws JSONException {
        this.f3487u = i;
        this.f2709b = 1;
        C1300e0 b = C1291b0.m3384b(jSONObject);
        this.f3488v = b;
        C1294c0 b2 = m3843b(m3844c(b.mo10402d()).mo10409b());
        C1297d0 c = b2.mo10381c();
        m3842a(this.f3488v.mo10399a());
        this.f2710c.put("body", this.f2726s);
        this.f2716i = this.f3488v.mo10401c();
        this.f2715h = b2.mo10380b();
        this.f2724q = c.mo10386c();
        this.f2713f = c.mo10384a();
        this.f2714g = c.mo10385b();
        this.f2722o.put("imptrackers", c.mo10387d());
        m3841a(b2);
    }

    /* renamed from: a */
    private void m3841a(C1294c0 c0Var) {
        String a = m3840a();
        String str = this.f3487u == 0 ? "true" : "false";
        this.f2711d.put("{% encoding %}", "base64");
        this.f2711d.put("{% adm %}", c0Var.mo10379a());
        this.f2711d.put("{{ ad_type }}", a);
        this.f2711d.put("{{ show_close_button }}", str);
        this.f2711d.put("{{ preroll_popup }}", "false");
        this.f2711d.put("{{ post_video_reward_toaster_enabled }}", "false");
        if (this.f3487u == 3) {
            this.f2711d.put("{% is_banner %}", "true");
        }
    }

    /* renamed from: c */
    private C1303f0 m3844c(ArrayList<C1303f0> arrayList) {
        return !arrayList.isEmpty() ? arrayList.get(0) : new C1303f0();
    }

    /* renamed from: b */
    public C1300e0 mo10703b() {
        return this.f3488v;
    }

    /* renamed from: b */
    private C1294c0 m3843b(ArrayList<C1294c0> arrayList) {
        return !arrayList.isEmpty() ? arrayList.get(0) : new C1294c0();
    }

    /* renamed from: a */
    private String m3840a() {
        int i = this.f3487u;
        if (i == 0) {
            return "8";
        }
        if (i != 1) {
            return i != 3 ? "" : "10";
        }
        return "9";
    }

    /* renamed from: a */
    private void m3842a(ArrayList<C1229b> arrayList) {
        if (!arrayList.isEmpty()) {
            this.f2726s = arrayList.get(0);
        } else {
            this.f2726s = new C1229b("", "", "");
        }
    }
}
