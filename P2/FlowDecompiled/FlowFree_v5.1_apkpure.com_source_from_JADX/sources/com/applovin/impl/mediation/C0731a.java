package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C0923a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1112a;

/* renamed from: com.applovin.impl.mediation.a */
public class C0731a extends C1112a {

    /* renamed from: a */
    private final C0923a f759a;

    /* renamed from: b */
    private final C1107r f760b;

    /* renamed from: c */
    private C0732a f761c;

    /* renamed from: d */
    private C0735c f762d;

    /* renamed from: e */
    private int f763e;

    /* renamed from: f */
    private boolean f764f;

    /* renamed from: com.applovin.impl.mediation.a$a */
    public interface C0732a {
        /* renamed from: a */
        void mo8383a(C0735c cVar);
    }

    C0731a(C1062k kVar) {
        this.f760b = kVar.mo9411z();
        this.f759a = kVar.mo9370ae();
    }

    /* renamed from: a */
    public void mo8381a() {
        this.f760b.mo9584b("AdActivityObserver", "Cancelling...");
        this.f759a.mo8947b(this);
        this.f761c = null;
        this.f762d = null;
        this.f763e = 0;
        this.f764f = false;
    }

    /* renamed from: a */
    public void mo8382a(C0735c cVar, C0732a aVar) {
        C1107r rVar = this.f760b;
        rVar.mo9584b("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        mo8381a();
        this.f761c = aVar;
        this.f762d = cVar;
        this.f759a.mo8945a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f764f) {
            this.f764f = true;
        }
        this.f763e++;
        this.f760b.mo9584b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f763e);
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f764f) {
            this.f763e--;
            this.f760b.mo9584b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f763e);
            if (this.f763e <= 0) {
                this.f760b.mo9584b("AdActivityObserver", "Last ad Activity destroyed");
                if (this.f761c != null) {
                    this.f760b.mo9584b("AdActivityObserver", "Invoking callback...");
                    this.f761c.mo8383a(this.f762d);
                }
                mo8381a();
            }
        }
    }
}
