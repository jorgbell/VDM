package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Players$zza;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class ProfileSettingsEntity extends zzb implements Players$zza {
    @RecentlyNonNull
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    private final boolean zzbh;
    private final String zzbj;
    private final Status zzdw;
    private final boolean zzhp;
    private final boolean zzhq;
    private final StockProfileImageEntity zzhr;
    private final boolean zzhs;
    private final boolean zzht;
    private final int zzhu;
    private final boolean zzhv;
    private final boolean zzhw;
    private final int zzhx;
    private final int zzhy;

    ProfileSettingsEntity(Status status, String str, boolean z, boolean z2, boolean z3, StockProfileImageEntity stockProfileImageEntity, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, int i3) {
        this.zzdw = status;
        this.zzbj = str;
        this.zzhp = z;
        this.zzbh = z2;
        this.zzhq = z3;
        this.zzhr = stockProfileImageEntity;
        this.zzhs = z4;
        this.zzht = z5;
        this.zzhu = i;
        this.zzhv = z6;
        this.zzhw = z7;
        this.zzhx = i2;
        this.zzhy = i3;
    }

    @RecentlyNonNull
    public final String zzk() {
        return this.zzbj;
    }

    public final boolean zzv() {
        return this.zzhp;
    }

    public final boolean zzn() {
        return this.zzbh;
    }

    public final boolean zzt() {
        return this.zzhq;
    }

    @RecentlyNonNull
    public final StockProfileImage zzu() {
        return this.zzhr;
    }

    public final boolean zzw() {
        return this.zzhs;
    }

    public final boolean zzx() {
        return this.zzht;
    }

    public final boolean zzy() {
        return this.zzhv;
    }

    public final boolean zzz() {
        return this.zzhw;
    }

    @RecentlyNonNull
    public Status getStatus() {
        return this.zzdw;
    }

    public final int zzaa() {
        return this.zzhu;
    }

    public final int zzab() {
        return this.zzhx;
    }

    public final int zzac() {
        return this.zzhy;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzbj, Boolean.valueOf(this.zzhp), Boolean.valueOf(this.zzbh), Boolean.valueOf(this.zzhq), this.zzdw, this.zzhr, Boolean.valueOf(this.zzhs), Boolean.valueOf(this.zzht), Integer.valueOf(this.zzhu), Boolean.valueOf(this.zzhv), Boolean.valueOf(this.zzhw), Integer.valueOf(this.zzhx), Integer.valueOf(this.zzhy));
    }

    public boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof Players$zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Players$zza players$zza = (Players$zza) obj;
        return Objects.equal(this.zzbj, players$zza.zzk()) && Objects.equal(Boolean.valueOf(this.zzhp), Boolean.valueOf(players$zza.zzv())) && Objects.equal(Boolean.valueOf(this.zzbh), Boolean.valueOf(players$zza.zzn())) && Objects.equal(Boolean.valueOf(this.zzhq), Boolean.valueOf(players$zza.zzt())) && Objects.equal(this.zzdw, players$zza.getStatus()) && Objects.equal(this.zzhr, players$zza.zzu()) && Objects.equal(Boolean.valueOf(this.zzhs), Boolean.valueOf(players$zza.zzw())) && Objects.equal(Boolean.valueOf(this.zzht), Boolean.valueOf(players$zza.zzx())) && this.zzhu == players$zza.zzaa() && this.zzhv == players$zza.zzy() && this.zzhw == players$zza.zzz() && this.zzhx == players$zza.zzab() && this.zzhy == players$zza.zzac();
    }

    @RecentlyNonNull
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("GamerTag", this.zzbj);
        stringHelper.add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzhp));
        stringHelper.add("IsProfileVisible", Boolean.valueOf(this.zzbh));
        stringHelper.add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zzhq));
        stringHelper.add("Status", this.zzdw);
        stringHelper.add("StockProfileImage", this.zzhr);
        stringHelper.add("IsProfileDiscoverable", Boolean.valueOf(this.zzhs));
        stringHelper.add("AutoSignIn", Boolean.valueOf(this.zzht));
        stringHelper.add("httpErrorCode", Integer.valueOf(this.zzhu));
        stringHelper.add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzhv));
        char[] cArr = {128, 171, 171, 174, 182, 133, 177, 168, 164, 173, 163, 136, 173, 181, 168, 179, 164, 178};
        for (int i = 0; i < 18; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        stringHelper.add(new String(cArr), Boolean.valueOf(this.zzhw));
        stringHelper.add("ProfileVisibility", Integer.valueOf(this.zzhx));
        char[] cArr2 = {166, 171, 174, 161, 160, 171, 158, 165, 177, 168, 164, 173, 163, 178, 158, 171, 168, 178, 179, 158, 181, 168, 178, 168, 161, 168, 171, 168, 179, 184};
        for (int i2 = 0; i2 < 30; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - '?');
        }
        stringHelper.add(new String(cArr2), Integer.valueOf(this.zzhy));
        return stringHelper.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbj, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzhp);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbh);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhq);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzhr, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzhs);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzht);
        SafeParcelWriter.writeInt(parcel, 9, this.zzhu);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzhv);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzhw);
        SafeParcelWriter.writeInt(parcel, 12, this.zzhx);
        SafeParcelWriter.writeInt(parcel, 13, this.zzhy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
