package com.applovin.impl.mediation.p021a;

import android.os.SystemClock;
import com.applovin.impl.mediation.C0870i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p037c.C0964a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.c */
public class C0735c extends C0733a {

    /* renamed from: c */
    private final AtomicReference<C0962c> f767c;

    /* renamed from: d */
    private final AtomicBoolean f768d;

    /* renamed from: e */
    private final AtomicBoolean f769e;

    private C0735c(C0735c cVar, C0870i iVar) {
        super(cVar.mo8441H(), cVar.mo8440G(), iVar, cVar.f771b);
        this.f769e = new AtomicBoolean();
        this.f767c = cVar.f767c;
        this.f768d = cVar.f768d;
    }

    public C0735c(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        super(jSONObject, jSONObject2, (C0870i) null, kVar);
        this.f769e = new AtomicBoolean();
        this.f767c = new AtomicReference<>();
        this.f768d = new AtomicBoolean();
    }

    /* renamed from: A */
    public C0962c mo8423A() {
        return this.f767c.getAndSet((Object) null);
    }

    /* renamed from: B */
    public boolean mo8424B() {
        return mo8464b("show_nia", mo8456a("show_nia", Boolean.FALSE)).booleanValue();
    }

    /* renamed from: C */
    public String mo8425C() {
        return mo8466b("nia_title", mo8458a("nia_title", ""));
    }

    /* renamed from: D */
    public String mo8426D() {
        return mo8466b("nia_message", mo8458a("nia_message", ""));
    }

    /* renamed from: E */
    public String mo8427E() {
        return mo8466b("nia_button_title", mo8458a("nia_button_title", ""));
    }

    /* renamed from: F */
    public AtomicBoolean mo8428F() {
        return this.f769e;
    }

    /* renamed from: a */
    public C0733a mo8384a(C0870i iVar) {
        return new C0735c(this, iVar);
    }

    /* renamed from: a */
    public void mo8429a(C0962c cVar) {
        this.f767c.set(cVar);
    }

    /* renamed from: p */
    public long mo8412p() {
        long b = mo8463b("ad_expiration_ms", -1);
        return b >= 0 ? b : mo8455a("ad_expiration_ms", ((Long) this.f771b.mo9350a(C0964a.f1525C)).longValue());
    }

    /* renamed from: q */
    public long mo8430q() {
        long b = mo8463b("ad_hidden_timeout_ms", -1);
        return b >= 0 ? b : mo8455a("ad_hidden_timeout_ms", ((Long) this.f771b.mo9350a(C0964a.f1528F)).longValue());
    }

    /* renamed from: r */
    public boolean mo8431r() {
        if (mo8464b("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return mo8456a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f771b.mo9350a(C0964a.f1529G)).booleanValue();
    }

    /* renamed from: s */
    public long mo8432s() {
        long b = mo8463b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        return b >= 0 ? b : mo8455a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f771b.mo9350a(C0964a.f1530H)).longValue());
    }

    /* renamed from: t */
    public long mo8433t() {
        if (mo8404l() > 0) {
            return SystemClock.elapsedRealtime() - mo8404l();
        }
        return -1;
    }

    /* renamed from: u */
    public long mo8434u() {
        long b = mo8463b("fullscreen_display_delay_ms", -1);
        return b >= 0 ? b : ((Long) this.f771b.mo9350a(C0964a.f1563v)).longValue();
    }

    /* renamed from: v */
    public long mo8435v() {
        return mo8463b("ahdm", ((Long) this.f771b.mo9350a(C0964a.f1564w)).longValue());
    }

    /* renamed from: w */
    public String mo8436w() {
        return mo8466b("bcode", "");
    }

    /* renamed from: x */
    public String mo8437x() {
        return mo8458a("mcode", "");
    }

    /* renamed from: y */
    public boolean mo8438y() {
        return this.f768d.get();
    }

    /* renamed from: z */
    public void mo8439z() {
        this.f768d.set(true);
    }
}
