package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzb extends DataBufferRef implements zza {
    private final zzd zzg;

    public zzb(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zzg = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final String zzbx() {
        return getString(this.zzg.zzir);
    }

    public final String zzby() {
        return getString(this.zzg.zzis);
    }

    public final long zzbz() {
        return getLong(this.zzg.zzit);
    }

    public final Uri zzca() {
        return parseUri(this.zzg.zziu);
    }

    public final Uri zzcb() {
        return parseUri(this.zzg.zziv);
    }

    public final Uri zzcc() {
        return parseUri(this.zzg.zziw);
    }

    public final int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((zza) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }
}
