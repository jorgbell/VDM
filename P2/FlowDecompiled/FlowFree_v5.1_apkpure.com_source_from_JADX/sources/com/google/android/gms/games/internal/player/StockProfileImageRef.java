package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class StockProfileImageRef extends DataBufferRef implements StockProfileImage {
    @RecentlyNonNull
    public String getImageUrl() {
        return getString("image_url");
    }

    @RecentlyNonNull
    public final Uri zzcd() {
        throw new NoSuchMethodError();
    }

    public int describeContents() {
        throw new NoSuchMethodError();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        throw new NoSuchMethodError();
    }
}
