package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    @RecentlyNonNull
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zza();
    private String description;
    private int type;
    private String zzbe;
    private Uri zzm;

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    static final class zza extends zzb {
        zza() {
        }

        public final GameBadgeEntity zzd(Parcel parcel) {
            Uri uri;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzd(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            return new GameBadgeEntity(readInt, readString, readString2, uri);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzd(parcel);
        }
    }

    GameBadgeEntity(int i, String str, String str2, Uri uri) {
        this.type = i;
        this.zzbe = str;
        this.description = str2;
        this.zzm = uri;
    }

    public final int getType() {
        return this.type;
    }

    @RecentlyNonNull
    public final String getTitle() {
        return this.zzbe;
    }

    @RecentlyNonNull
    public final String getDescription() {
        return this.description;
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return this.zzm;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getType()), getTitle(), getDescription(), getIconImageUri());
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zza2 = (zza) obj;
        if (!Objects.equal(Integer.valueOf(zza2.getType()), getTitle()) || !Objects.equal(zza2.getDescription(), getIconImageUri())) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("Type", Integer.valueOf(getType()));
        stringHelper.add("Title", getTitle());
        stringHelper.add("Description", getDescription());
        stringHelper.add("IconImageUri", getIconImageUri());
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.type);
            SafeParcelWriter.writeString(parcel, 2, this.zzbe, false);
            SafeParcelWriter.writeString(parcel, 3, this.description, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzm, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.zzbe);
        parcel.writeString(this.description);
        Uri uri = this.zzm;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
