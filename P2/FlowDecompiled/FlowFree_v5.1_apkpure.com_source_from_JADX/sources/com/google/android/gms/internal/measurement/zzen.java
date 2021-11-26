package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzen extends ContentObserver {
    final /* synthetic */ zzeo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzen(zzeo zzeo, Handler handler) {
        super((Handler) null);
        this.zza = zzeo;
    }

    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
