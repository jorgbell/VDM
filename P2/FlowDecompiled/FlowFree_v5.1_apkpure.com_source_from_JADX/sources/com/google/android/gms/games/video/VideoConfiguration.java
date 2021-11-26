package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class VideoConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new zzb();
    private final int zzmg;
    private final int zzmk;
    private final boolean zzml;
    private final boolean zzmm;
    private final boolean zzmn;

    public VideoConfiguration(int i, int i2, boolean z, boolean z2, boolean z3) {
        Preconditions.checkArgument(isValidQualityLevel(i, false));
        Preconditions.checkArgument(isValidCaptureMode(i2, false));
        this.zzmk = i;
        this.zzmg = i2;
        this.zzml = z;
        this.zzmm = z2;
        this.zzmn = z3;
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return true;
            }
            if (i != 1) {
                return false;
            }
        }
        return z;
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        if (i != -1) {
            z = true;
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                return z;
            }
            return false;
        }
        return z;
    }

    public final int getQualityLevel() {
        return this.zzmk;
    }

    public final int getCaptureMode() {
        return this.zzmg;
    }

    public final boolean getCameraEnabled() {
        return this.zzmm;
    }

    public final boolean getMicEnabled() {
        return this.zzmn;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getQualityLevel());
        SafeParcelWriter.writeInt(parcel, 2, getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzml);
        SafeParcelWriter.writeBoolean(parcel, 8, getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel, 9, getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
