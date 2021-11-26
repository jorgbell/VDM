package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final /* synthetic */ class zzi implements RemoteCall {
    private final String zzew;

    zzi(String str) {
        this.zzew = str;
    }

    public final void accept(Object obj, Object obj2) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        ((zzf) obj).zzb((TaskCompletionSource<Void>) null, this.zzew);
    }
}
