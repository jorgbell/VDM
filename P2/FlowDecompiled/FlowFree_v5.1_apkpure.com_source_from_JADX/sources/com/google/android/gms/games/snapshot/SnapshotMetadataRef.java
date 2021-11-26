package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.mopub.mobileads.VastIconXmlManager;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    private final Game zzjr;
    private final Player zzlo;

    public SnapshotMetadataRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzjr = new GameRef(dataHolder, i);
        this.zzlo = new PlayerRef(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    @RecentlyNonNull
    public final Game getGame() {
        return this.zzjr;
    }

    @RecentlyNonNull
    public final Player getOwner() {
        return this.zzlo;
    }

    @RecentlyNonNull
    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    @RecentlyNonNull
    public final Uri getCoverImageUri() {
        return parseUri("cover_icon_image_uri");
    }

    @RecentlyNonNull
    public final String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public final float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        float f2 = getFloat("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    @RecentlyNonNull
    public final String getUniqueName() {
        return getString("unique_name");
    }

    @RecentlyNonNull
    public final String getTitle() {
        return getString("title");
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("description");
    }

    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public final long getPlayedTime() {
        return getLong(VastIconXmlManager.DURATION);
    }

    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public final long getProgressValue() {
        return getLong("progress_value");
    }

    @RecentlyNonNull
    public final String getDeviceName() {
        return getString("device_name");
    }

    public final int hashCode() {
        return SnapshotMetadataEntity.zza(this);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return SnapshotMetadataEntity.zza(this, obj);
    }

    @RecentlyNonNull
    public final String toString() {
        return SnapshotMetadataEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        ((SnapshotMetadataEntity) ((SnapshotMetadata) freeze())).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final /* synthetic */ Object freeze() {
        return new SnapshotMetadataEntity(this);
    }
}
