package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class AchievementRef extends DataBufferRef implements Achievement {
    public final int describeContents() {
        return 0;
    }

    @RecentlyNonNull
    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    @RecentlyNonNull
    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final int getType() {
        return getInteger("type");
    }

    @RecentlyNonNull
    public final String getName() {
        return getString(MediationMetaData.KEY_NAME);
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("description");
    }

    @RecentlyNonNull
    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    @RecentlyNonNull
    public final String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    @RecentlyNonNull
    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    @RecentlyNonNull
    public final String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("total_steps");
    }

    @RecentlyNonNull
    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_total_steps");
    }

    @RecentlyNullable
    public final Player zzad() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow);
    }

    public final int getState() {
        return getInteger("state");
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("current_steps");
    }

    @RecentlyNonNull
    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_current_steps");
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public final long getXpValue() {
        if (!hasColumn("instance_xp_value") || hasNull("instance_xp_value")) {
            return getLong("definition_xp_value");
        }
        return getLong("instance_xp_value");
    }

    public final float zzae() {
        if (!hasColumn("rarity_percent") || hasNull("rarity_percent")) {
            return -1.0f;
        }
        return getFloat("rarity_percent");
    }

    public final int hashCode() {
        return AchievementEntity.zza(this);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return AchievementEntity.zza(this, obj);
    }

    @RecentlyNonNull
    public final String toString() {
        return AchievementEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) freeze())).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final /* synthetic */ Object freeze() {
        return new AchievementEntity(this);
    }
}
