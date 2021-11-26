package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcfy implements zzakp {
    private final zzcfz zza;
    private final zzaja zzb;

    zzcfy(zzcfz zzcfz, zzaja zzaja) {
        this.zza = zzcfz;
        this.zzb = zzaja;
    }

    public final void zza(Object obj, Map map) {
        zzcfz zzcfz = this.zza;
        zzaja zzaja = this.zzb;
        try {
            zzcfz.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzbbk.zzf("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzcfz.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzaja == null) {
            zzbbk.zzd("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzaja.zze(str);
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
