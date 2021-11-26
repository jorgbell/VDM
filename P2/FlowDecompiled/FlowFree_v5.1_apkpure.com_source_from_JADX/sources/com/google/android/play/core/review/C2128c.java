package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C2172i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C2128c implements ReviewManager {

    /* renamed from: a */
    private final C2134i f5234a;

    /* renamed from: b */
    private final Handler f5235b = new Handler(Looper.getMainLooper());

    C2128c(C2134i iVar) {
        this.f5234a = iVar;
    }

    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo22120a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C2172i iVar = new C2172i();
        intent.putExtra("result_receiver", new C2127b(this.f5235b, iVar));
        activity.startActivity(intent);
        return iVar.mo22194c();
    }

    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f5234a.mo22129a();
    }
}
