package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface Game extends Parcelable, Freezable<Game> {
    boolean areSnapshotsEnabled();

    int getAchievementTotalCount();

    @RecentlyNonNull
    String getApplicationId();

    @RecentlyNonNull
    String getDescription();

    @RecentlyNonNull
    String getDeveloperName();

    @RecentlyNonNull
    String getDisplayName();

    @RecentlyNonNull
    Uri getFeaturedImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getFeaturedImageUrl();

    @RecentlyNonNull
    Uri getHiResImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getHiResImageUrl();

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    @RecentlyNonNull
    String getPrimaryCategory();

    @RecentlyNonNull
    String getSecondaryCategory();

    @RecentlyNonNull
    String getThemeColor();

    boolean hasGamepadSupport();

    boolean isMuted();

    boolean zzc();

    boolean zzd();

    boolean zze();

    @RecentlyNonNull
    String zzf();

    @Deprecated
    boolean zzg();

    @Deprecated
    boolean zzh();
}
