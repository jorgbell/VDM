package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class SnapshotMetadataChangeEntity extends zzb implements SnapshotMetadataChange {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    private final String description;
    private final Long zzlb;
    private final Uri zzld;
    private final Long zzlm;
    private BitmapTeleporter zzln;

    SnapshotMetadataChangeEntity() {
        this((String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this.description = str;
        this.zzlm = l;
        this.zzln = bitmapTeleporter;
        this.zzld = uri;
        this.zzlb = l2;
        Preconditions.checkState(bitmapTeleporter == null || uri == null, "Cannot set both a URI and an image");
    }

    @RecentlyNullable
    public final String getDescription() {
        return this.description;
    }

    @RecentlyNullable
    public final Long getPlayedTimeMillis() {
        return this.zzlm;
    }

    @RecentlyNullable
    public final Long getProgressValue() {
        return this.zzlb;
    }

    @RecentlyNullable
    public final BitmapTeleporter zzcl() {
        return this.zzln;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getDescription(), false);
        SafeParcelWriter.writeLongObject(parcel, 2, getPlayedTimeMillis(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzld, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzln, i, false);
        SafeParcelWriter.writeLongObject(parcel, 6, getProgressValue(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
