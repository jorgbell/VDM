package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class SnapshotEntity extends zzb implements Snapshot {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();
    private final SnapshotMetadataEntity zzky;
    private final SnapshotContentsEntity zzkz;

    public SnapshotEntity(@RecentlyNonNull SnapshotMetadata snapshotMetadata, @RecentlyNonNull SnapshotContentsEntity snapshotContentsEntity) {
        this.zzky = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzkz = snapshotContentsEntity;
    }

    @RecentlyNonNull
    public final SnapshotMetadata getMetadata() {
        return this.zzky;
    }

    @RecentlyNonNull
    public final SnapshotContents getSnapshotContents() {
        if (this.zzkz.isClosed()) {
            return null;
        }
        return this.zzkz;
    }

    public final int hashCode() {
        return Objects.hashCode(getMetadata(), getSnapshotContents());
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Snapshot snapshot = (Snapshot) obj;
        if (!Objects.equal(snapshot.getMetadata(), getMetadata()) || !Objects.equal(snapshot.getSnapshotContents(), getSnapshotContents())) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("Metadata", getMetadata());
        stringHelper.add("HasContents", Boolean.valueOf(getSnapshotContents() != null));
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getMetadata(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
