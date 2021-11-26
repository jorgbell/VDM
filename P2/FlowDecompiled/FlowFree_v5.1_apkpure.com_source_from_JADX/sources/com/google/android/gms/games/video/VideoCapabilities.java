package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class VideoCapabilities extends zzb {
    @RecentlyNonNull
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();
    private final boolean zzma;
    private final boolean zzmb;
    private final boolean zzmc;
    private final boolean[] zzmd;
    private final boolean[] zzme;

    public VideoCapabilities(boolean z, boolean z2, boolean z3, @RecentlyNonNull boolean[] zArr, @RecentlyNonNull boolean[] zArr2) {
        this.zzma = z;
        this.zzmb = z2;
        this.zzmc = z3;
        this.zzmd = zArr;
        this.zzme = zArr2;
    }

    public final boolean isMicSupported() {
        return this.zzmb;
    }

    public final boolean isCameraSupported() {
        return this.zzma;
    }

    public final boolean isWriteStorageSupported() {
        return this.zzmc;
    }

    @RecentlyNonNull
    public final boolean[] getSupportedCaptureModes() {
        return this.zzmd;
    }

    @RecentlyNonNull
    public final boolean[] getSupportedQualityLevels() {
        return this.zzme;
    }

    public final int hashCode() {
        return Objects.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return Objects.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Objects.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("SupportedCaptureModes", getSupportedCaptureModes());
        stringHelper.add("SupportedQualityLevels", getSupportedQualityLevels());
        stringHelper.add("CameraSupported", Boolean.valueOf(isCameraSupported()));
        stringHelper.add("MicSupported", Boolean.valueOf(isMicSupported()));
        stringHelper.add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported()));
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
