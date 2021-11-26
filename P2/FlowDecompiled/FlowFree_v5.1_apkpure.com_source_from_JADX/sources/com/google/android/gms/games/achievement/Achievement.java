package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface Achievement extends Parcelable, Freezable<Achievement> {
    @RecentlyNonNull
    String getAchievementId();

    @RecentlyNonNull
    String getApplicationId();

    int getCurrentSteps();

    @RecentlyNonNull
    String getDescription();

    @RecentlyNonNull
    String getFormattedCurrentSteps();

    @RecentlyNonNull
    String getFormattedTotalSteps();

    long getLastUpdatedTimestamp();

    @RecentlyNonNull
    String getName();

    @RecentlyNullable
    Uri getRevealedImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getRevealedImageUrl();

    int getState();

    int getTotalSteps();

    int getType();

    @RecentlyNullable
    Uri getUnlockedImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getUnlockedImageUrl();

    long getXpValue();

    @RecentlyNullable
    Player zzad();

    float zzae();
}
