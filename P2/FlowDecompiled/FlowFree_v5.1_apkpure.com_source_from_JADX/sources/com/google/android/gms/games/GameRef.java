package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class GameRef extends DataBufferRef implements Game {
    public GameRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    @RecentlyNonNull
    public final String getApplicationId() {
        return getString("external_game_id");
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return getString("display_name");
    }

    @RecentlyNonNull
    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    @RecentlyNonNull
    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("game_description");
    }

    @RecentlyNonNull
    public final String getDeveloperName() {
        return getString("developer_name");
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return parseUri("game_icon_image_uri");
    }

    @RecentlyNonNull
    public final String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    @RecentlyNonNull
    public final Uri getHiResImageUri() {
        return parseUri("game_hi_res_image_uri");
    }

    @RecentlyNonNull
    public final String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    @RecentlyNonNull
    public final Uri getFeaturedImageUri() {
        return parseUri("featured_image_uri");
    }

    @RecentlyNonNull
    public final String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    public final boolean zzc() {
        return getBoolean("play_enabled_game");
    }

    public final boolean isMuted() {
        return getBoolean("muted");
    }

    public final boolean zzd() {
        return getBoolean("identity_sharing_confirmed");
    }

    public final boolean zze() {
        return getInteger("installed") > 0;
    }

    @RecentlyNonNull
    public final String zzf() {
        return getString("package_name");
    }

    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    public final boolean zzg() {
        return getInteger("real_time_support") > 0;
    }

    public final boolean zzh() {
        return getInteger("turn_based_support") > 0;
    }

    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    @RecentlyNonNull
    public final String getThemeColor() {
        return getString("theme_color");
    }

    public final boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    public final int hashCode() {
        return GameEntity.zza((Game) this);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return GameEntity.zza(this, obj);
    }

    @RecentlyNonNull
    public final String toString() {
        return GameEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        ((GameEntity) ((Game) freeze())).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final /* synthetic */ Object freeze() {
        return new GameEntity(this);
    }
}
