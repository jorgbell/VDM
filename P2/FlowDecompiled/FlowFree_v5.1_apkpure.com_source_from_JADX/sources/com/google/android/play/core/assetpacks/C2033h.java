package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.h */
final class C2033h extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2172i f5101a;

    /* renamed from: b */
    final /* synthetic */ C2034i f5102b;

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f5101a.mo22196e(-1);
            this.f5102b.f5107h.mo21922a((PendingIntent) null);
        } else if (i != 2) {
            this.f5101a.mo22195d(new AssetPackException(-100));
        } else {
            this.f5101a.mo22196e(0);
        }
    }
}
