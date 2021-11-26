package com.google.android.gms.games.snapshot;

import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.BitmapTeleporter;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface SnapshotMetadataChange {

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    public static final class Builder {
        private String description;
        private Long zzla;
        private Long zzlb;
        private BitmapTeleporter zzlc;
        private Uri zzld;

        @RecentlyNonNull
        public final Builder setDescription(@RecentlyNonNull String str) {
            this.description = str;
            return this;
        }

        @RecentlyNonNull
        public final Builder setPlayedTimeMillis(long j) {
            this.zzla = Long.valueOf(j);
            return this;
        }

        @RecentlyNonNull
        public final Builder setProgressValue(long j) {
            this.zzlb = Long.valueOf(j);
            return this;
        }

        @RecentlyNonNull
        public final Builder fromMetadata(@RecentlyNonNull SnapshotMetadata snapshotMetadata) {
            this.description = snapshotMetadata.getDescription();
            this.zzla = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzlb = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzla.longValue() == -1) {
                this.zzla = null;
            }
            Uri coverImageUri = snapshotMetadata.getCoverImageUri();
            this.zzld = coverImageUri;
            if (coverImageUri != null) {
                this.zzlc = null;
            }
            return this;
        }

        @RecentlyNonNull
        public final SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.description, this.zzla, this.zzlc, this.zzld, this.zzlb);
        }
    }

    static {
        new SnapshotMetadataChangeEntity();
    }

    @RecentlyNullable
    BitmapTeleporter zzcl();
}
