package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class NativeAd$Image {
    @RecentlyNonNull
    public abstract Drawable getDrawable();

    public abstract double getScale();

    @RecentlyNonNull
    public abstract Uri getUri();

    public int zza() {
        return -1;
    }

    public int zzb() {
        return -1;
    }
}
