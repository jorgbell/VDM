package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzr;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbdj {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzaaa.zzc().zzb(zzaeq.zzz)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzbdj() {
    }

    public final void zza() {
        this.zzc = true;
    }

    public final void zzb(SurfaceTexture surfaceTexture, zzbcx zzbcx) {
        if (zzbcx != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzc || Math.abs(timestamp - this.zzb) >= this.zza) {
                this.zzc = false;
                this.zzb = timestamp;
                zzr.zza.post(new zzbdi(this, zzbcx));
            }
        }
    }
}
