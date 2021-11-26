package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfk implements zzdiz<zzdfl> {
    private final zzefx zza;
    private final Context zzb;

    public zzdfk(zzefx zzefx, Context context) {
        this.zza = zzefx;
        this.zzb = context;
    }

    public final zzefw<zzdfl> zza() {
        return this.zza.zzb(new zzdfj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfl zzb() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        return new zzdfl(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzs.zzh().zzb(), zzs.zzh().zzd());
    }
}
