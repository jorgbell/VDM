package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class ScreenshotEntity extends zzb implements Parcelable, Freezable {
    @RecentlyNonNull
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzc();
    private final int height;
    private final Uri uri;
    private final int width;

    public ScreenshotEntity(@RecentlyNonNull Uri uri2, int i, int i2) {
        this.uri = uri2;
        this.width = i;
        this.height = i2;
    }

    public final int hashCode() {
        return Objects.hashCode(this.uri, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof ScreenshotEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
        if (!Objects.equal(screenshotEntity.uri, this.uri) || !Objects.equal(Integer.valueOf(screenshotEntity.width), Integer.valueOf(this.width)) || !Objects.equal(Integer.valueOf(screenshotEntity.height), Integer.valueOf(this.height))) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("Uri", this.uri);
        stringHelper.add("Width", Integer.valueOf(this.width));
        stringHelper.add("Height", Integer.valueOf(this.height));
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.uri, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
