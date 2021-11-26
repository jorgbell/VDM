package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final /* synthetic */ class zzdn implements RemoteCall {
    private final String zzew;
    private final int zzfl;
    private final boolean zzfn;

    zzdn(String str, boolean z, int i) {
        this.zzew = str;
        this.zzfn = z;
        this.zzfl = i;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzf) obj).zza((TaskCompletionSource) obj2, this.zzew, this.zzfn, this.zzfl);
    }
}
