package com.applovin.impl.mediation.p021a;

import android.view.View;
import com.applovin.impl.mediation.C0870i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.b */
public class C0734b extends C0733a {
    private C0734b(C0734b bVar, C0870i iVar) {
        super(bVar.mo8441H(), bVar.mo8440G(), iVar, bVar.f771b);
    }

    public C0734b(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        super(jSONObject, jSONObject2, (C0870i) null, kVar);
    }

    /* renamed from: A */
    public long mo8409A() {
        long b = mo8463b("ad_refresh_ms", -1);
        return b >= 0 ? b : mo8455a("ad_refresh_ms", ((Long) this.f771b.mo9350a(C0964a.f1554m)).longValue());
    }

    /* renamed from: B */
    public boolean mo8410B() {
        return mo8464b("proe", (Boolean) this.f771b.mo9350a(C0964a.f1531I)).booleanValue();
    }

    /* renamed from: C */
    public long mo8411C() {
        return C1160r.m2754e(mo8466b("bg_color", (String) null));
    }

    /* renamed from: a */
    public C0733a mo8384a(C0870i iVar) {
        return new C0734b(this, iVar);
    }

    /* renamed from: p */
    public int mo8412p() {
        int b = mo8462b("ad_view_width", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    /* renamed from: q */
    public int mo8413q() {
        int b = mo8462b("ad_view_height", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    /* renamed from: r */
    public View mo8414r() {
        C0870i iVar;
        if (!mo8389d() || (iVar = this.f765a) == null) {
            return null;
        }
        View a = iVar.mo8756a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Ad-view based ad is missing an ad view");
    }

    /* renamed from: s */
    public long mo8415s() {
        return mo8463b("viewability_imp_delay_ms", ((Long) this.f771b.mo9350a(C0965b.f1630bB)).longValue());
    }

    /* renamed from: t */
    public int mo8416t() {
        MaxAdFormat format = getFormat();
        C0965b bVar = format == MaxAdFormat.BANNER ? C0965b.f1631bC : format == MaxAdFormat.MREC ? C0965b.f1633bE : format == MaxAdFormat.LEADER ? C0965b.f1635bG : null;
        if (bVar != null) {
            return mo8462b("viewability_min_width", ((Integer) this.f771b.mo9350a(bVar)).intValue());
        }
        return 0;
    }

    /* renamed from: u */
    public int mo8417u() {
        MaxAdFormat format = getFormat();
        C0965b bVar = format == MaxAdFormat.BANNER ? C0965b.f1632bD : format == MaxAdFormat.MREC ? C0965b.f1634bF : format == MaxAdFormat.LEADER ? C0965b.f1636bH : null;
        if (bVar != null) {
            return mo8462b("viewability_min_height", ((Integer) this.f771b.mo9350a(bVar)).intValue());
        }
        return 0;
    }

    /* renamed from: v */
    public float mo8418v() {
        return mo8453a("viewability_min_alpha", ((Float) this.f771b.mo9350a(C0965b.f1637bI)).floatValue() / 100.0f);
    }

    /* renamed from: w */
    public int mo8419w() {
        return mo8462b("viewability_min_pixels", -1);
    }

    /* renamed from: x */
    public boolean mo8420x() {
        return mo8419w() >= 0;
    }

    /* renamed from: y */
    public long mo8421y() {
        return mo8463b("viewability_timer_min_visible_ms", ((Long) this.f771b.mo9350a(C0965b.f1638bJ)).longValue());
    }

    /* renamed from: z */
    public boolean mo8422z() {
        return mo8409A() >= 0;
    }
}
