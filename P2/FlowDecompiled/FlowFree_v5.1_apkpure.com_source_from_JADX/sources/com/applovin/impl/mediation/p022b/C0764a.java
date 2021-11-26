package com.applovin.impl.mediation.p022b;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.a */
public class C0764a extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f848a;

    public C0764a(Activity activity, C1062k kVar) {
        super("TaskAutoInitAdapters", kVar, true);
        this.f848a = activity;
    }

    /* renamed from: a */
    private List<C0737e> m1029a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0737e(C1123j.m2581a(jSONArray, i, (JSONObject) null, this.f1980b), jSONObject, this.f1980b));
        }
        return arrayList;
    }

    public void run() {
        String str;
        String str2 = (String) this.f1980b.mo9351a(C0967d.f1870y);
        if (C1155o.m2673b(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                List<C0737e> a = m1029a(C1123j.m2599b(jSONObject, this.f1980b.mo9332H().mo8729a() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray(), this.f1980b), jSONObject);
                if (a.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Auto-initing ");
                    sb.append(a.size());
                    sb.append(" adapters");
                    sb.append(this.f1980b.mo9332H().mo8729a() ? " in test mode" : "");
                    sb.append("...");
                    mo9211a(sb.toString());
                    if (TextUtils.isEmpty(this.f1980b.mo9403s())) {
                        this.f1980b.mo9386c(AppLovinMediationProvider.MAX);
                    } else if (!this.f1980b.mo9390f()) {
                        C1107r.m2484i("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f1980b.mo9403s());
                    }
                    if (this.f848a == null) {
                        C1107r.m2484i("AppLovinSdk", "\n**********\nFailed to initialize 3rd-party SDKs. Please make sure to initialize the AppLovin SDK with an Activity context.\n**********\n");
                        this.f1980b.mo9341R().mo9204b(C0986g.f1969p, 1);
                        return;
                    }
                    for (final C0737e next : a) {
                        this.f1980b.mo9340Q().mo9270b().execute(new Runnable() {
                            public void run() {
                                C0764a aVar = C0764a.this;
                                aVar.mo9211a("Auto-initing adapter: " + next);
                                C0764a.this.f1980b.mo9326B().mo8741a(next, C0764a.this.f848a);
                            }
                        });
                    }
                }
            } catch (JSONException e) {
                th = e;
                str = "Failed to parse auto-init adapters JSON";
                mo9212a(str, th);
            } catch (Throwable th) {
                th = th;
                str = "Failed to auto-init adapters";
                mo9212a(str, th);
            }
        }
    }
}
