package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class StockProfileImageEntity extends zzb implements StockProfileImage {
    @RecentlyNonNull
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzf();
    private final String zzjl;
    private final Uri zzjm;

    public StockProfileImageEntity(@RecentlyNonNull String str, @RecentlyNonNull Uri uri) {
        this.zzjl = str;
        this.zzjm = uri;
    }

    @RecentlyNonNull
    public final String getImageUrl() {
        return this.zzjl;
    }

    @RecentlyNonNull
    public final Uri zzcd() {
        return this.zzjm;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzjl, this.zzjm);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return Objects.equal(this.zzjl, stockProfileImage.getImageUrl()) && Objects.equal(this.zzjm, stockProfileImage.zzcd());
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("ImageId", this.zzjl);
        stringHelper.add("ImageUri", this.zzjm);
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzjm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
