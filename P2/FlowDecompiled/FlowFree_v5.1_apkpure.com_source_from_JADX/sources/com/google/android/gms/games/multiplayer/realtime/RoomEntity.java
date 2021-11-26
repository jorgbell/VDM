package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesGmsClientImpl.java")
@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class RoomEntity extends GamesDowngradeableSafeParcel {
    @RecentlyNonNull
    public static final Parcelable.Creator<RoomEntity> CREATOR = new zza();

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    static final class zza extends zzc {
        zza() {
        }

        public final RoomEntity zzf(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(RoomEntity.class.getCanonicalName())) {
                return super.zzf(parcel);
            }
            return new RoomEntity();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzf(parcel);
        }
    }

    RoomEntity() {
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
            return;
        }
        parcel.writeString("unsupported");
        parcel.writeString("unsupported");
        parcel.writeLong(0);
        parcel.writeInt(0);
        parcel.writeString("unsupported");
        parcel.writeInt(-1);
        parcel.writeBundle((Bundle) null);
        parcel.writeInt(0);
    }
}
