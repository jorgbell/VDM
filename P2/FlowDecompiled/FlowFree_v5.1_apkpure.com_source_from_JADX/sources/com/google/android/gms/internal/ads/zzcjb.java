package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjb implements zzakp<Object> {
    private final zzaik zza;
    private final zzcjo zzb;
    private final zzeyf<zzcix> zzc;

    public zzcjb(zzcfi zzcfi, zzcex zzcex, zzcjo zzcjo, zzeyf<zzcix> zzeyf) {
        this.zza = zzcfi.zzg(zzcex.zzN());
        this.zzb = zzcjo;
        this.zzc = zzeyf;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zza.zze(this.zzc.zzb(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzbbk.zzj(sb.toString(), e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzd("/nativeAdCustomClick", this);
        }
    }
}
