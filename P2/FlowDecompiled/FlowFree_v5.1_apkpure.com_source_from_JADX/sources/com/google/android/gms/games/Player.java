package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.zza;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface Player extends Parcelable, Freezable<Player> {
    @RecentlyNullable
    Uri getBannerImageLandscapeUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getBannerImageLandscapeUrl();

    @RecentlyNullable
    Uri getBannerImagePortraitUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getBannerImagePortraitUrl();

    @RecentlyNullable
    CurrentPlayerInfo getCurrentPlayerInfo();

    @RecentlyNonNull
    String getDisplayName();

    @RecentlyNullable
    Uri getHiResImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getHiResImageUrl();

    @RecentlyNullable
    Uri getIconImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getIconImageUrl();

    @Deprecated
    long getLastPlayedWithTimestamp();

    @RecentlyNullable
    PlayerLevelInfo getLevelInfo();

    @RecentlyNonNull
    String getName();

    @RecentlyNonNull
    String getPlayerId();

    @RecentlyNullable
    PlayerRelationshipInfo getRelationshipInfo();

    long getRetrievedTimestamp();

    @RecentlyNullable
    String getTitle();

    @RecentlyNullable
    String zzk();

    boolean zzl();

    @Deprecated
    int zzm();

    boolean zzn();

    zza zzo();

    long zzp();
}
