package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzn extends zzh implements PlayerRelationshipInfo {
    private final zzd zzg;

    public zzn(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzg = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getFriendStatus() {
        return zza(this.zzg.zzjg, -1);
    }

    public final String zzq() {
        return zza(this.zzg.zzjh, (String) null);
    }

    public final String zzr() {
        return zza(this.zzg.zzji, (String) null);
    }

    public final String zzs() {
        return zza(this.zzg.zzce, (String) null);
    }

    public final int hashCode() {
        return zzm.zza(this);
    }

    public final boolean equals(Object obj) {
        return zzm.zza(this, obj);
    }

    public final String toString() {
        return zzm.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new zzm(this).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new zzm(this);
    }
}
