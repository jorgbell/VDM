package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class EventRef extends DataBufferRef implements Event {
    public final int describeContents() {
        return 0;
    }

    @RecentlyNonNull
    public final String getEventId() {
        return getString("external_event_id");
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
    public final Uri getIconImageUri() {
        return parseUri("icon_image_uri");
    }

    @RecentlyNonNull
    public final String getIconImageUrl() {
        return getString("icon_image_url");
    }

    @RecentlyNonNull
    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow);
    }

    public final long getValue() {
        return getLong("value");
    }

    @RecentlyNonNull
    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    public final boolean isVisible() {
        return getBoolean("visibility");
    }

    public final int hashCode() {
        return EventEntity.zza(this);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return EventEntity.zza(this, obj);
    }

    @RecentlyNonNull
    public final String toString() {
        return EventEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        ((EventEntity) ((Event) freeze())).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final /* synthetic */ Object freeze() {
        return new EventEntity(this);
    }
}
