package com.applovin.impl.sdk.p039e;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0966c;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.t */
public abstract class C1033t<T> extends C0989a implements C1081a.C1084c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1085b<T> f2098a;

    /* renamed from: c */
    private final C1081a.C1084c<T> f2099c;

    /* renamed from: d */
    protected C1081a.C1082a f2100d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1020o.C1022a f2101e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0965b<String> f2102f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0965b<String> f2103g;

    public C1033t(C1085b<T> bVar, C1062k kVar) {
        this(bVar, kVar, false);
    }

    public C1033t(C1085b<T> bVar, final C1062k kVar, boolean z) {
        super("TaskRepeatRequest", kVar, z);
        this.f2101e = C1020o.C1022a.BACKGROUND;
        this.f2102f = null;
        this.f2103g = null;
        if (bVar != null) {
            this.f2098a = bVar;
            this.f2100d = new C1081a.C1082a();
            this.f2099c = new C1081a.C1084c<T>() {
                /* renamed from: a */
                public void mo8530a(int i) {
                    C0965b bVar;
                    C1033t tVar;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if ((i != -103) && (z2 || z3 || C1033t.this.f2098a.mo9474m())) {
                        String f = C1033t.this.f2098a.mo9466f();
                        if (C1033t.this.f2098a.mo9468h() > 0) {
                            C1033t tVar2 = C1033t.this;
                            tVar2.mo9214c("Unable to send request due to server failure (code " + i + "). " + C1033t.this.f2098a.mo9468h() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds((long) C1033t.this.f2098a.mo9472k()) + " seconds...");
                            int h = C1033t.this.f2098a.mo9468h() - 1;
                            C1033t.this.f2098a.mo9458a(h);
                            if (h == 0) {
                                C1033t tVar3 = C1033t.this;
                                tVar3.m2013c(tVar3.f2102f);
                                if (C1155o.m2673b(f) && f.length() >= 4) {
                                    C1033t tVar4 = C1033t.this;
                                    tVar4.mo9213b("Switching to backup endpoint " + f);
                                    C1033t.this.f2098a.mo9459a(f);
                                    z = true;
                                }
                            }
                            long millis = (!((Boolean) kVar.mo9350a(C0965b.f1763de)).booleanValue() || !z) ? C1033t.this.f2098a.mo9473l() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, (double) C1033t.this.f2098a.mo9470i())) : (long) C1033t.this.f2098a.mo9472k() : 0;
                            C1020o Q = kVar.mo9340Q();
                            C1033t tVar5 = C1033t.this;
                            Q.mo9267a(tVar5, tVar5.f2101e, millis);
                            return;
                        }
                        if (f == null || !f.equals(C1033t.this.f2098a.mo9457a())) {
                            tVar = C1033t.this;
                            bVar = tVar.f2102f;
                        } else {
                            tVar = C1033t.this;
                            bVar = tVar.f2103g;
                        }
                        tVar.m2013c(bVar);
                    }
                    C1033t.this.mo8530a(i);
                }

                /* renamed from: a */
                public void mo8531a(T t, int i) {
                    C1033t.this.f2098a.mo9458a(0);
                    C1033t.this.mo8531a(t, i);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <ST> void m2013c(C0965b<ST> bVar) {
        if (bVar != null) {
            C0966c I = mo9215d().mo9333I();
            I.mo9123a((C0965b<?>) bVar, (Object) bVar.mo9118b());
            I.mo9122a();
        }
    }

    /* renamed from: a */
    public abstract void mo8530a(int i);

    /* renamed from: a */
    public void mo9285a(C0965b<String> bVar) {
        this.f2102f = bVar;
    }

    /* renamed from: a */
    public void mo9286a(C1020o.C1022a aVar) {
        this.f2101e = aVar;
    }

    /* renamed from: a */
    public abstract void mo8531a(T t, int i);

    /* renamed from: b */
    public void mo9287b(C0965b<String> bVar) {
        this.f2103g = bVar;
    }

    public void run() {
        int i;
        C1081a P = mo9215d().mo9339P();
        if (!mo9215d().mo9387c() && !mo9215d().mo9388d()) {
            mo9216d("AppLovin SDK is disabled: please check your connection");
            C1107r.m2484i("AppLovinSdk", "AppLovin SDK is disabled: please check your connection");
            i = -22;
        } else if (!C1155o.m2673b(this.f2098a.mo9457a()) || this.f2098a.mo9457a().length() < 4) {
            mo9216d("Task has an invalid or null request endpoint.");
            i = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.f2098a.mo9460b())) {
                this.f2098a.mo9461b(this.f2098a.mo9464e() != null ? "POST" : "GET");
            }
            P.mo9449a(this.f2098a, this.f2100d, this.f2099c);
            return;
        }
        mo8530a(i);
    }
}
