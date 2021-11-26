package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zza extends zzb implements CurrentPlayerInfo {
    public static final Parcelable.Creator<zza> CREATOR = new zzc();
    private final int zzf;

    public zza(CurrentPlayerInfo currentPlayerInfo) {
        this.zzf = currentPlayerInfo.getFriendsListVisibilityStatus();
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public zza(int i) {
        this.zzf = i;
    }

    public final int getFriendsListVisibilityStatus() {
        return this.zzf;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(CurrentPlayerInfo currentPlayerInfo) {
        return Objects.hashCode(Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(CurrentPlayerInfo currentPlayerInfo, Object obj) {
        if (!(obj instanceof CurrentPlayerInfo)) {
            return false;
        }
        return obj == currentPlayerInfo || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == currentPlayerInfo.getFriendsListVisibilityStatus();
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(CurrentPlayerInfo currentPlayerInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(currentPlayerInfo);
        stringHelper.add("FriendsListVisibilityStatus", Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
        return stringHelper.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getFriendsListVisibilityStatus());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
