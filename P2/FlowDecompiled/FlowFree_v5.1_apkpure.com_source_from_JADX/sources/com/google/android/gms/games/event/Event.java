package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface Event extends Parcelable, Freezable<Event> {
    @RecentlyNonNull
    String getDescription();

    @RecentlyNonNull
    String getEventId();

    @RecentlyNonNull
    String getFormattedValue();

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @RecentlyNonNull
    String getName();

    @RecentlyNonNull
    Player getPlayer();

    long getValue();

    boolean isVisible();
}
