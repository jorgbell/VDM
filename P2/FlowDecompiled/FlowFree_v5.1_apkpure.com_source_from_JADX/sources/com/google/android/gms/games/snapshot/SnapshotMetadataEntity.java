package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class SnapshotMetadataEntity extends zzb implements SnapshotMetadata {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new zzd();
    private final String description;
    private final String deviceName;
    private final String zzbe;
    private final String zzeb;
    private final GameEntity zzhc;
    private final Uri zzld;
    private final PlayerEntity zzle;
    private final String zzlf;
    private final long zzlg;
    private final long zzlh;
    private final float zzli;
    private final String zzlj;
    private final boolean zzlk;
    private final long zzll;

    public SnapshotMetadataEntity(@RecentlyNonNull SnapshotMetadata snapshotMetadata) {
        this(snapshotMetadata, new PlayerEntity(snapshotMetadata.getOwner()));
    }

    @RecentlyNonNull
    public final SnapshotMetadata freeze() {
        return this;
    }

    private SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata, PlayerEntity playerEntity) {
        this.zzhc = new GameEntity(snapshotMetadata.getGame());
        this.zzle = playerEntity;
        this.zzeb = snapshotMetadata.getSnapshotId();
        this.zzld = snapshotMetadata.getCoverImageUri();
        this.zzlf = snapshotMetadata.getCoverImageUrl();
        this.zzli = snapshotMetadata.getCoverImageAspectRatio();
        this.zzbe = snapshotMetadata.getTitle();
        this.description = snapshotMetadata.getDescription();
        this.zzlg = snapshotMetadata.getLastModifiedTimestamp();
        this.zzlh = snapshotMetadata.getPlayedTime();
        this.zzlj = snapshotMetadata.getUniqueName();
        this.zzlk = snapshotMetadata.hasChangePending();
        this.zzll = snapshotMetadata.getProgressValue();
        this.deviceName = snapshotMetadata.getDeviceName();
    }

    SnapshotMetadataEntity(GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z, long j3, String str6) {
        this.zzhc = gameEntity;
        this.zzle = playerEntity;
        this.zzeb = str;
        this.zzld = uri;
        this.zzlf = str2;
        this.zzli = f;
        this.zzbe = str3;
        this.description = str4;
        this.zzlg = j;
        this.zzlh = j2;
        this.zzlj = str5;
        this.zzlk = z;
        this.zzll = j3;
        this.deviceName = str6;
    }

    @RecentlyNonNull
    public final Game getGame() {
        return this.zzhc;
    }

    @RecentlyNonNull
    public final Player getOwner() {
        return this.zzle;
    }

    @RecentlyNonNull
    public final String getSnapshotId() {
        return this.zzeb;
    }

    @RecentlyNullable
    public final Uri getCoverImageUri() {
        return this.zzld;
    }

    @RecentlyNullable
    public final String getCoverImageUrl() {
        return this.zzlf;
    }

    public final float getCoverImageAspectRatio() {
        return this.zzli;
    }

    @RecentlyNonNull
    public final String getUniqueName() {
        return this.zzlj;
    }

    @RecentlyNonNull
    public final String getTitle() {
        return this.zzbe;
    }

    @RecentlyNonNull
    public final String getDescription() {
        return this.description;
    }

    public final long getLastModifiedTimestamp() {
        return this.zzlg;
    }

    public final long getPlayedTime() {
        return this.zzlh;
    }

    public final boolean hasChangePending() {
        return this.zzlk;
    }

    public final long getProgressValue() {
        return this.zzll;
    }

    @RecentlyNonNull
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return Objects.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return Objects.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && Objects.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && Objects.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && Objects.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && Objects.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && Objects.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && Objects.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && Objects.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && Objects.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && Objects.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && Objects.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && Objects.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && Objects.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(snapshotMetadata);
        stringHelper.add("Game", snapshotMetadata.getGame());
        stringHelper.add("Owner", snapshotMetadata.getOwner());
        stringHelper.add("SnapshotId", snapshotMetadata.getSnapshotId());
        stringHelper.add("CoverImageUri", snapshotMetadata.getCoverImageUri());
        stringHelper.add("CoverImageUrl", snapshotMetadata.getCoverImageUrl());
        stringHelper.add("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()));
        stringHelper.add("Description", snapshotMetadata.getDescription());
        stringHelper.add("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()));
        stringHelper.add("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime()));
        stringHelper.add("UniqueName", snapshotMetadata.getUniqueName());
        stringHelper.add("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending()));
        stringHelper.add("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue()));
        stringHelper.add("DeviceName", snapshotMetadata.getDeviceName());
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getOwner(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getCoverImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbe, false);
        SafeParcelWriter.writeString(parcel, 8, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 9, getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getPlayedTime());
        SafeParcelWriter.writeFloat(parcel, 11, getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel, 12, getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel, 13, hasChangePending());
        SafeParcelWriter.writeLong(parcel, 14, getProgressValue());
        SafeParcelWriter.writeString(parcel, 15, getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
