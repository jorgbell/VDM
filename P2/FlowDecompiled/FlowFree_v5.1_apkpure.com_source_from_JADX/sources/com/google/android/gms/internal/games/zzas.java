package com.google.android.gms.internal.games;

import android.view.View;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final /* synthetic */ class zzas implements RemoteCall {
    private final View zzfj;

    zzas(View view) {
        this.zzfj = view;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzf) obj).zza(this.zzfj);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
