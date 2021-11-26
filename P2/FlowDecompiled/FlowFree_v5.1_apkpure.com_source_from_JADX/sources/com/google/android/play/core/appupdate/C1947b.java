package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.appupdate.b */
final class C1947b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C2172i f4789a;

    public final void onReceiveResult(int i, Bundle bundle) {
        C2172i iVar;
        int i2 = 1;
        if (i == 1) {
            iVar = this.f4789a;
            i2 = -1;
        } else if (i != 2) {
            iVar = this.f4789a;
        } else {
            iVar = this.f4789a;
            i2 = 0;
        }
        iVar.mo22196e(Integer.valueOf(i2));
    }
}
