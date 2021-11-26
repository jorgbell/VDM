package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class ExperienceEventEntity extends zzb implements ExperienceEvent {
    @RecentlyNonNull
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    private final int type;
    private final String zzhb;
    private final GameEntity zzhc;
    private final String zzhd;
    private final String zzhe;
    private final long zzhf;
    private final long zzhg;
    private final long zzhh;
    private final int zzhi;
    private final Uri zzm;
    private final String zzx;

    ExperienceEventEntity(String str, GameEntity gameEntity, String str2, String str3, String str4, Uri uri, long j, long j2, long j3, int i, int i2) {
        this.zzhb = str;
        this.zzhc = gameEntity;
        this.zzhd = str2;
        this.zzhe = str3;
        this.zzx = str4;
        this.zzm = uri;
        this.zzhf = j;
        this.zzhg = j2;
        this.zzhh = j3;
        this.type = i;
        this.zzhi = i2;
    }

    @RecentlyNonNull
    public final String zzbq() {
        return this.zzhb;
    }

    @RecentlyNonNull
    public final Game getGame() {
        return this.zzhc;
    }

    @RecentlyNonNull
    public final String zzbr() {
        return this.zzhd;
    }

    @RecentlyNonNull
    public final String zzbs() {
        return this.zzhe;
    }

    @RecentlyNonNull
    public final String getIconImageUrl() {
        return this.zzx;
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return this.zzm;
    }

    public final long zzbt() {
        return this.zzhf;
    }

    public final long zzbu() {
        return this.zzhg;
    }

    public final long zzbv() {
        return this.zzhh;
    }

    public final int getType() {
        return this.type;
    }

    public final int zzbw() {
        return this.zzhi;
    }

    public final int hashCode() {
        return Objects.hashCode(zzbq(), getGame(), zzbr(), zzbs(), getIconImageUrl(), getIconImageUri(), Long.valueOf(zzbt()), Long.valueOf(zzbu()), Long.valueOf(zzbv()), Integer.valueOf(getType()), Integer.valueOf(zzbw()));
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof ExperienceEvent)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ExperienceEvent experienceEvent = (ExperienceEvent) obj;
        if (!Objects.equal(experienceEvent.zzbq(), zzbq()) || !Objects.equal(experienceEvent.getGame(), getGame()) || !Objects.equal(experienceEvent.zzbr(), zzbr()) || !Objects.equal(experienceEvent.zzbs(), zzbs()) || !Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) || !Objects.equal(experienceEvent.getIconImageUri(), getIconImageUri()) || !Objects.equal(Long.valueOf(experienceEvent.zzbt()), Long.valueOf(zzbt())) || !Objects.equal(Long.valueOf(experienceEvent.zzbu()), Long.valueOf(zzbu())) || !Objects.equal(Long.valueOf(experienceEvent.zzbv()), Long.valueOf(zzbv())) || !Objects.equal(Integer.valueOf(experienceEvent.getType()), Integer.valueOf(getType())) || !Objects.equal(Integer.valueOf(experienceEvent.zzbw()), Integer.valueOf(zzbw()))) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("ExperienceId", zzbq());
        stringHelper.add("Game", getGame());
        stringHelper.add("DisplayTitle", zzbr());
        stringHelper.add("DisplayDescription", zzbs());
        stringHelper.add("IconImageUrl", getIconImageUrl());
        stringHelper.add("IconImageUri", getIconImageUri());
        stringHelper.add("CreatedTimestamp", Long.valueOf(zzbt()));
        stringHelper.add("XpEarned", Long.valueOf(zzbu()));
        stringHelper.add("CurrentXp", Long.valueOf(zzbv()));
        stringHelper.add("Type", Integer.valueOf(getType()));
        stringHelper.add("NewLevel", Integer.valueOf(zzbw()));
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhb, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhc, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhd, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhe, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzm, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzhf);
        SafeParcelWriter.writeLong(parcel, 8, this.zzhg);
        SafeParcelWriter.writeLong(parcel, 9, this.zzhh);
        SafeParcelWriter.writeInt(parcel, 10, this.type);
        SafeParcelWriter.writeInt(parcel, 11, this.zzhi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
