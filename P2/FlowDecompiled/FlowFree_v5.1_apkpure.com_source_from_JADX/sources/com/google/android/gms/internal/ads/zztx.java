package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zztx implements Runnable {
    private final zzua zza;
    private final zztr zzb;
    private final zzts zzc;
    private final zzbcb zzd;

    zztx(zzua zzua, zztr zztr, zzts zzts, zzbcb zzbcb) {
        this.zza = zzua;
        this.zzb = zztr;
        this.zzc = zzts;
        this.zzd = zzbcb;
    }

    public final void run() {
        zztp zztp;
        zzua zzua = this.zza;
        zztr zztr = this.zzb;
        zzts zzts = this.zzc;
        zzbcb zzbcb = this.zzd;
        try {
            zztu zzq = zztr.zzq();
            if (zztr.zzp()) {
                zztp = zzq.zzf(zzts);
            } else {
                zztp = zzq.zze(zzts);
            }
            if (!zztp.zza()) {
                zzbcb.zzd(new RuntimeException("No entry contents."));
                zzuc.zzb(zzua.zzc);
                return;
            }
            zztz zztz = new zztz(zzua, zztp.zzb(), 1);
            int read = zztz.read();
            if (read != -1) {
                zztz.unread(read);
                zzbcb.zzc(zzue.zza(zztz, zztp.zzd(), zztp.zzg(), zztp.zzf(), zztp.zze()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzbbk.zzg("Unable to obtain a cache service instance.", e);
            zzbcb.zzd(e);
            zzuc.zzb(zzua.zzc);
        }
    }
}
