package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface StockProfileImage extends Parcelable, Freezable<StockProfileImage> {
    @RecentlyNonNull
    String getImageUrl();

    @RecentlyNonNull
    Uri zzcd();
}
