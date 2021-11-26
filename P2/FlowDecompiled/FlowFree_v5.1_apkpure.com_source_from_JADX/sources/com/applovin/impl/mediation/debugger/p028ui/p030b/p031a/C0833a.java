package com.applovin.impl.mediation.debugger.p028ui.p030b.p031a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.sdk.utils.C1118f;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.a */
public class C0833a extends C0846c {

    /* renamed from: a */
    private final C0801b f1058a;

    /* renamed from: o */
    private final Context f1059o;

    public C0833a(C0801b bVar, Context context) {
        super(C0846c.C0849b.DETAIL);
        this.f1058a = bVar;
        this.f1059o = context;
        this.f1119d = m1258q();
        this.f1120e = m1259r();
    }

    /* renamed from: q */
    private SpannedString m1258q() {
        return C1155o.m2663a(this.f1058a.mo8595h(), mo8637b() ? -16777216 : -7829368, 18, 1);
    }

    /* renamed from: r */
    private SpannedString m1259r() {
        if (!mo8637b()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(m1260s());
        spannableStringBuilder.append(new SpannableString("\n"));
        spannableStringBuilder.append(m1261t());
        if (this.f1058a.mo8587a() == C0801b.C0802a.INVALID_INTEGRATION) {
            spannableStringBuilder.append(new SpannableString("\n"));
            spannableStringBuilder.append(C1155o.m2672b("Invalid Integration", -65536));
        }
        return new SpannedString(spannableStringBuilder);
    }

    /* renamed from: s */
    private SpannedString m1260s() {
        if (!this.f1058a.mo8591d()) {
            return C1155o.m2672b("SDK Missing", -65536);
        }
        if (!TextUtils.isEmpty(this.f1058a.mo8596i())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C1155o.m2674c("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append(C1155o.m2672b(this.f1058a.mo8596i(), -16777216));
            return new SpannedString(spannableStringBuilder);
        }
        return C1155o.m2672b(this.f1058a.mo8592e() ? "Retrieving SDK Version..." : "SDK Found", -16777216);
    }

    /* renamed from: t */
    private SpannedString m1261t() {
        if (!this.f1058a.mo8592e()) {
            return C1155o.m2672b("Adapter Missing", -65536);
        }
        if (TextUtils.isEmpty(this.f1058a.mo8597j())) {
            return C1155o.m2672b("Adapter Found", -16777216);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C1155o.m2674c("ADAPTER  ", -7829368));
        spannableStringBuilder.append(C1155o.m2672b(this.f1058a.mo8597j(), -16777216));
        if (this.f1058a.mo8593f()) {
            spannableStringBuilder.append(C1155o.m2674c("  LATEST  ", Color.rgb(255, 127, 0)));
            spannableStringBuilder.append(C1155o.m2672b(this.f1058a.mo8598k(), -16777216));
        }
        return new SpannedString(spannableStringBuilder);
    }

    /* renamed from: b */
    public boolean mo8637b() {
        return this.f1058a.mo8587a() != C0801b.C0802a.MISSING;
    }

    /* renamed from: d */
    public C0801b mo8655d() {
        return this.f1058a;
    }

    /* renamed from: e */
    public int mo8656e() {
        int n = this.f1058a.mo8601n();
        return n > 0 ? n : C1199R.C1200drawable.applovin_ic_mediation_placeholder;
    }

    /* renamed from: f */
    public int mo8657f() {
        return mo8637b() ? C1199R.C1200drawable.applovin_ic_disclosure_arrow : super.mo8656e();
    }

    /* renamed from: g */
    public int mo8658g() {
        return C1118f.m2525a(C1199R.color.applovin_sdk_disclosureButtonColor, this.f1059o);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + this.f1119d + ", detailText=" + this.f1120e + ", network=" + this.f1058a + "}";
    }
}
