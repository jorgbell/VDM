package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzil extends Handler {
    final /* synthetic */ zzim zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzil(zzim zzim, Looper looper) {
        super(looper);
        this.zza = zzim;
    }

    public final void handleMessage(Message message) {
        this.zza.zzs(message);
    }
}
