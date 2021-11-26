package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzb extends zzh implements CurrentPlayerInfo {
    private final zzd zzg;

    public zzb(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzg = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getFriendsListVisibilityStatus() {
        return zza(this.zzg.zzjk, 0);
    }

    public final int hashCode() {
        return zza.zza(this);
    }

    public final boolean equals(Object obj) {
        return zza.zza(this, obj);
    }

    public final String toString() {
        return zza.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new zza((CurrentPlayerInfo) this).writeToParcel(parcel, i);
    }

    public final boolean zzb() {
        return hasColumn(this.zzg.zzjk) && !hasNull(this.zzg.zzjk);
    }

    public final /* synthetic */ Object freeze() {
        return new zza((CurrentPlayerInfo) this);
    }
}
