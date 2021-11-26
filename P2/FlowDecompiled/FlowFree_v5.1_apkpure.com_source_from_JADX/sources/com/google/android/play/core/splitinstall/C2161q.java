package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.play.core.splitinstall.q */
final class C2161q implements C2153d {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f5287a;

    /* renamed from: b */
    final /* synthetic */ Intent f5288b;

    /* renamed from: c */
    final /* synthetic */ Context f5289c;

    /* renamed from: d */
    final /* synthetic */ C2163s f5290d;

    C2161q(C2163s sVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f5290d = sVar;
        this.f5287a = splitInstallSessionState;
        this.f5288b = intent;
        this.f5289c = context;
    }

    /* renamed from: a */
    public final void mo22171a() {
        this.f5290d.f5296d.post(new C2162r(this.f5290d, this.f5287a, 5, 0));
    }

    /* renamed from: b */
    public final void mo22172b() {
        if (!this.f5288b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f5288b.putExtra("triggered_from_app_after_verification", true);
            this.f5289c.sendBroadcast(this.f5288b);
            return;
        }
        this.f5290d.f5217a.mo22025b("Splits copied and verified more than once.", new Object[0]);
    }

    /* renamed from: c */
    public final void mo22173c(int i) {
        this.f5290d.f5296d.post(new C2162r(this.f5290d, this.f5287a, 6, i));
    }
}
