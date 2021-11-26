package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class MostRecentGameInfoEntity extends zzb implements zza {
    @RecentlyNonNull
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzc();
    private final String zzhj;
    private final String zzhk;
    private final long zzhl;
    private final Uri zzhm;
    private final Uri zzhn;
    private final Uri zzho;

    public MostRecentGameInfoEntity(zza zza) {
        this.zzhj = zza.zzbx();
        this.zzhk = zza.zzby();
        this.zzhl = zza.zzbz();
        this.zzhm = zza.zzca();
        this.zzhn = zza.zzcb();
        this.zzho = zza.zzcc();
    }

    MostRecentGameInfoEntity(String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zzhj = str;
        this.zzhk = str2;
        this.zzhl = j;
        this.zzhm = uri;
        this.zzhn = uri2;
        this.zzho = uri3;
    }

    @RecentlyNonNull
    public final String zzbx() {
        return this.zzhj;
    }

    @RecentlyNonNull
    public final String zzby() {
        return this.zzhk;
    }

    public final long zzbz() {
        return this.zzhl;
    }

    @RecentlyNonNull
    public final Uri zzca() {
        return this.zzhm;
    }

    @RecentlyNonNull
    public final Uri zzcb() {
        return this.zzhn;
    }

    @RecentlyNonNull
    public final Uri zzcc() {
        return this.zzho;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(zza zza) {
        return Objects.hashCode(zza.zzbx(), zza.zzby(), Long.valueOf(zza.zzbz()), zza.zzca(), zza.zzcb(), zza.zzcc());
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(zza zza, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zza == obj) {
            return true;
        }
        zza zza2 = (zza) obj;
        return Objects.equal(zza2.zzbx(), zza.zzbx()) && Objects.equal(zza2.zzby(), zza.zzby()) && Objects.equal(Long.valueOf(zza2.zzbz()), Long.valueOf(zza.zzbz())) && Objects.equal(zza2.zzca(), zza.zzca()) && Objects.equal(zza2.zzcb(), zza.zzcb()) && Objects.equal(zza2.zzcc(), zza.zzcc());
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }

    static String zzb(zza zza) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(zza);
        stringHelper.add("GameId", zza.zzbx());
        stringHelper.add("GameName", zza.zzby());
        stringHelper.add("ActivityTimestampMillis", Long.valueOf(zza.zzbz()));
        stringHelper.add("GameIconUri", zza.zzca());
        stringHelper.add("GameHiResUri", zza.zzcb());
        stringHelper.add("GameFeaturedUri", zza.zzcc());
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhj, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzhk, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzhl);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzhm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzhn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzho, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
