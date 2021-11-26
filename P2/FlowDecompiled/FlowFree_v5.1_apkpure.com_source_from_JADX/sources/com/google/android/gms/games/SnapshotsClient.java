package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface SnapshotsClient {

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    public static final class SnapshotConflict {
        private final Snapshot zzcg;
        private final Snapshot zzci;
        private final SnapshotContents zzcj;

        public SnapshotConflict(@RecentlyNonNull Snapshot snapshot, @RecentlyNonNull String str, @RecentlyNonNull Snapshot snapshot2, @RecentlyNonNull SnapshotContents snapshotContents) {
            this.zzcg = snapshot;
            this.zzci = snapshot2;
            this.zzcj = snapshotContents;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    public static final class SnapshotContentUnavailableApiException extends ApiException {
        @RecentlyNonNull
        protected final SnapshotMetadata metadata;

        public SnapshotContentUnavailableApiException(@RecentlyNonNull Status status, @RecentlyNonNull SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }
    }

    @RecentlyNonNull
    Task<SnapshotMetadata> commitAndClose(@RecentlyNonNull Snapshot snapshot, @RecentlyNonNull SnapshotMetadataChange snapshotMetadataChange);

    @RecentlyNonNull
    Task<DataOrConflict<Snapshot>> open(@RecentlyNonNull String str, boolean z, int i);

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    public static final class DataOrConflict<T> {
        private final T data;
        private final SnapshotConflict zzcf;

        public DataOrConflict(T t, SnapshotConflict snapshotConflict) {
            this.data = t;
            this.zzcf = snapshotConflict;
        }

        public final boolean isConflict() {
            return this.zzcf != null;
        }

        @RecentlyNullable
        public final T getData() {
            if (!isConflict()) {
                return this.data;
            }
            throw new IllegalStateException("getData called when there is a conflict.");
        }
    }
}
