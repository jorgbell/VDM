package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzb;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class PlayerRef extends zzh implements Player {
    private final PlayerLevelInfo zzbg;
    private final zzb zzby;
    private final zzn zzbz;
    private final zzb zzca;
    private final zzd zzg;

    public PlayerRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        this(dataHolder, i, (String) null);
    }

    public final int describeContents() {
        return 0;
    }

    private PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        zzd zzd = new zzd((String) null);
        this.zzg = zzd;
        this.zzby = new zzb(dataHolder, i, zzd);
        this.zzbz = new zzn(dataHolder, i, zzd);
        this.zzca = new zzb(dataHolder, i, zzd);
        if (!hasNull(zzd.zzii) && getLong(zzd.zzii) != -1) {
            int integer = getInteger(zzd.zzij);
            int integer2 = getInteger(zzd.zzim);
            PlayerLevel playerLevel = new PlayerLevel(integer, getLong(zzd.zzik), getLong(zzd.zzil));
            this.zzbg = new PlayerLevelInfo(getLong(zzd.zzii), getLong(zzd.zzio), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(zzd.zzil), getLong(zzd.zzin)) : playerLevel);
            return;
        }
        this.zzbg = null;
    }

    @RecentlyNonNull
    public final String getPlayerId() {
        return getString(this.zzg.zzhz);
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return getString(this.zzg.zzia);
    }

    @RecentlyNonNull
    public final String zzk() {
        return getString(this.zzg.zzbj);
    }

    @RecentlyNonNull
    public final String getName() {
        return getString(this.zzg.name);
    }

    public final boolean zzl() {
        return getBoolean(this.zzg.zzix);
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return parseUri(this.zzg.zzib);
    }

    @RecentlyNonNull
    public final String getIconImageUrl() {
        return getString(this.zzg.zzic);
    }

    @RecentlyNonNull
    public final Uri getHiResImageUri() {
        return parseUri(this.zzg.zzid);
    }

    @RecentlyNonNull
    public final String getHiResImageUrl() {
        return getString(this.zzg.zzie);
    }

    public final long getRetrievedTimestamp() {
        return getLong(this.zzg.zzif);
    }

    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zzg.zzih) || hasNull(this.zzg.zzih)) {
            return -1;
        }
        return getLong(this.zzg.zzih);
    }

    @RecentlyNonNull
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        if (this.zzca.zzb()) {
            return this.zzca;
        }
        return null;
    }

    public final int zzm() {
        return getInteger(this.zzg.zzig);
    }

    public final boolean zzn() {
        return getBoolean(this.zzg.zziq);
    }

    @RecentlyNonNull
    public final String getTitle() {
        return getString(this.zzg.zzbe);
    }

    @RecentlyNonNull
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzbg;
    }

    public final zza zzo() {
        if (hasNull(this.zzg.zzir)) {
            return null;
        }
        return this.zzby;
    }

    @RecentlyNonNull
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zzg.zziy);
    }

    @RecentlyNonNull
    public final String getBannerImageLandscapeUrl() {
        return getString(this.zzg.zziz);
    }

    @RecentlyNonNull
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zzg.zzja);
    }

    @RecentlyNonNull
    public final String getBannerImagePortraitUrl() {
        return getString(this.zzg.zzjb);
    }

    public final long zzp() {
        String str = this.zzg.zzjf;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    @RecentlyNonNull
    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzn zzn = this.zzbz;
        if ((zzn.getFriendStatus() == -1 && zzn.zzq() == null && zzn.zzr() == null) ? false : true) {
            return this.zzbz;
        }
        return null;
    }

    public final int hashCode() {
        return PlayerEntity.zza((Player) this);
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    @RecentlyNonNull
    public final String toString() {
        return PlayerEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        ((PlayerEntity) ((Player) freeze())).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final /* synthetic */ Object freeze() {
        return new PlayerEntity(this);
    }
}
