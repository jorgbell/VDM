package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxv implements RewardItem {
    private final zzaxi zza;

    public zzaxv(zzaxi zzaxi) {
        this.zza = zzaxi;
    }

    public final int getAmount() {
        zzaxi zzaxi = this.zza;
        if (zzaxi != null) {
            try {
                return zzaxi.zzf();
            } catch (RemoteException e) {
                zzbbk.zzj("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzaxi zzaxi = this.zza;
        if (zzaxi != null) {
            try {
                return zzaxi.zze();
            } catch (RemoteException e) {
                zzbbk.zzj("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
