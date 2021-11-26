package com.google.android.gms.games;

import android.os.Parcelable;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface PlayerRelationshipInfo extends Parcelable, Freezable<PlayerRelationshipInfo> {
    int getFriendStatus();

    @RecentlyNullable
    String zzq();

    @RecentlyNullable
    String zzr();

    @RecentlyNullable
    String zzs();
}
