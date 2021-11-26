package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C2055ac;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2068aq;
import com.google.android.play.core.internal.C2088bp;
import com.google.android.play.core.tasks.C2172i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.review.i */
public final class C2134i {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C2058ag f5242b = new C2058ag("ReviewService");

    /* renamed from: a */
    C2068aq<C2055ac> f5243a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f5244c;

    public C2134i(Context context) {
        this.f5244c = context.getPackageName();
        if (C2088bp.m5239a(context)) {
            Context context2 = context;
            this.f5243a = new C2068aq(context2, f5242b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C2129d.f5236a);
        }
    }

    /* renamed from: a */
    public final Task<ReviewInfo> mo22129a() {
        C2058ag agVar = f5242b;
        agVar.mo22027d("requestInAppReview (%s)", this.f5244c);
        if (this.f5243a == null) {
            agVar.mo22025b("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.m5431b(new C2130e());
        }
        C2172i iVar = new C2172i();
        this.f5243a.mo22036a(new C2131f(this, iVar, iVar));
        return iVar.mo22194c();
    }
}
