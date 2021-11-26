package com.google.android.gms.games;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface CurrentPlayerInfo extends Parcelable, Freezable<CurrentPlayerInfo> {
    int getFriendsListVisibilityStatus();
}
