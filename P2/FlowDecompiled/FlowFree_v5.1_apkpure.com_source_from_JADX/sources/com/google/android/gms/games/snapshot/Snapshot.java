package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface Snapshot extends Parcelable, Freezable<Snapshot> {
    @RecentlyNonNull
    SnapshotMetadata getMetadata();

    @RecentlyNonNull
    SnapshotContents getSnapshotContents();
}
