package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.review.b */
final class C2127b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2172i f5233a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2127b(Handler handler, C2172i iVar) {
        super(handler);
        this.f5233a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f5233a.mo22196e(null);
    }
}
