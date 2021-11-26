package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbti implements zzbvr, zzbuy {
    private final zzdqo zzb;

    public zzbti(Context context, zzdqo zzdqo, zzauo zzauo, byte[] bArr) {
        this.zzb = zzdqo;
    }

    public final void zzb(Context context) {
    }

    public final void zzbD() {
        zzaup zzaup = this.zzb.zzX;
        if (zzaup != null && zzaup.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzX.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzX.zzb);
            }
        }
    }

    public final void zzbn(Context context) {
    }

    public final void zzbq(Context context) {
    }
}
