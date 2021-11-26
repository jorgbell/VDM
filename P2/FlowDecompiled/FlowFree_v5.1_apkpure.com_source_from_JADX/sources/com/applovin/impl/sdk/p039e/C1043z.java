package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.z */
public class C1043z extends C0990aa {

    /* renamed from: a */
    private final C0934g f2114a;

    /* renamed from: c */
    private final AppLovinAdRewardListener f2115c;

    public C1043z(C0934g gVar, AppLovinAdRewardListener appLovinAdRewardListener, C1062k kVar) {
        super("TaskValidateAppLovinReward", kVar);
        this.f2114a = gVar;
        this.f2115c = appLovinAdRewardListener;
    }

    /* renamed from: a */
    public String mo8541a() {
        return "2.0/vr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8542a(int i) {
        String str;
        super.mo8542a(i);
        if (i < 400 || i >= 500) {
            this.f2115c.validationRequestFailed(this.f2114a, i);
            str = "network_timeout";
        } else {
            this.f2115c.userRewardRejected(this.f2114a, Collections.emptyMap());
            str = "rejected";
        }
        this.f2114a.mo9020a(C0962c.m1734a(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8547a(C0962c cVar) {
        this.f2114a.mo9020a(cVar);
        String b = cVar.mo9110b();
        Map<String, String> a = cVar.mo9109a();
        if (b.equals("accepted")) {
            this.f2115c.userRewardVerified(this.f2114a, a);
        } else if (b.equals("quota_exceeded")) {
            this.f2115c.userOverQuota(this.f2114a, a);
        } else if (b.equals("rejected")) {
            this.f2115c.userRewardRejected(this.f2114a, a);
        } else {
            this.f2115c.validationRequestFailed(this.f2114a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8543a(JSONObject jSONObject) {
        C1123j.m2584a(jSONObject, "zone_id", this.f2114a.getAdZone().mo8972a(), this.f1980b);
        String clCode = this.f2114a.getClCode();
        if (!C1155o.m2673b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1123j.m2584a(jSONObject, "clcode", clCode, this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8548b() {
        return this.f2114a.mo9027aF();
    }
}
