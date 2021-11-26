package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface SnapshotMetadata extends Parcelable, Freezable<SnapshotMetadata> {
    float getCoverImageAspectRatio();

    @RecentlyNullable
    Uri getCoverImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getCoverImageUrl();

    @RecentlyNonNull
    String getDescription();

    @RecentlyNullable
    String getDeviceName();

    @RecentlyNonNull
    Game getGame();

    long getLastModifiedTimestamp();

    @RecentlyNonNull
    Player getOwner();

    long getPlayedTime();

    long getProgressValue();

    @RecentlyNonNull
    String getSnapshotId();

    @RecentlyNonNull
    String getTitle();

    @RecentlyNonNull
    String getUniqueName();

    boolean hasChangePending();
}
