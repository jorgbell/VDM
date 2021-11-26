package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    @RecentlyNonNull
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zza();
    private final String name;
    private String zzba;
    private final long zzbb;
    private final int zzbc;
    private final long zzbd;
    private final String zzbe;
    private final MostRecentGameInfoEntity zzbf;
    private final PlayerLevelInfo zzbg;
    private final boolean zzbh;
    private final boolean zzbi;
    private final String zzbj;
    private final Uri zzbk;
    private final String zzbl;
    private final Uri zzbm;
    private final String zzbn;
    private long zzbo;
    private final zzm zzbp;
    private final zza zzbq;
    private String zzi;
    private final Uri zzm;
    private final Uri zzn;
    private final String zzx;
    private final String zzy;

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    static final class zza extends zzi {
        zza() {
        }

        public final PlayerEntity zzc(Parcel parcel) {
            Uri uri;
            Uri uri2;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
                return super.zzc(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            if (readString4 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString4);
            }
            return new PlayerEntity(readString, readString2, uri, uri2, readLong, -1, -1, (String) null, (String) null, (String) null, (MostRecentGameInfoEntity) null, (PlayerLevelInfo) null, true, false, readString5, readString6, (Uri) null, (String) null, (Uri) null, (String) null, -1, (zzm) null, (zza) null);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzc(parcel);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.games.zza} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PlayerEntity(@androidx.annotation.RecentlyNonNull com.google.android.gms.games.Player r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.String r0 = r7.getPlayerId()
            r6.zzba = r0
            java.lang.String r0 = r7.getDisplayName()
            r6.zzi = r0
            android.net.Uri r0 = r7.getIconImageUri()
            r6.zzm = r0
            java.lang.String r0 = r7.getIconImageUrl()
            r6.zzx = r0
            android.net.Uri r0 = r7.getHiResImageUri()
            r6.zzn = r0
            java.lang.String r0 = r7.getHiResImageUrl()
            r6.zzy = r0
            long r0 = r7.getRetrievedTimestamp()
            r6.zzbb = r0
            int r2 = r7.zzm()
            r6.zzbc = r2
            long r2 = r7.getLastPlayedWithTimestamp()
            r6.zzbd = r2
            java.lang.String r2 = r7.getTitle()
            r6.zzbe = r2
            boolean r2 = r7.zzn()
            r6.zzbh = r2
            com.google.android.gms.games.internal.player.zza r2 = r7.zzo()
            r3 = 0
            if (r2 != 0) goto L_0x004e
            r4 = r3
            goto L_0x0053
        L_0x004e:
            com.google.android.gms.games.internal.player.MostRecentGameInfoEntity r4 = new com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
            r4.<init>(r2)
        L_0x0053:
            r6.zzbf = r4
            com.google.android.gms.games.PlayerLevelInfo r2 = r7.getLevelInfo()
            r6.zzbg = r2
            boolean r2 = r7.zzl()
            r6.zzbi = r2
            java.lang.String r2 = r7.zzk()
            r6.zzbj = r2
            java.lang.String r2 = r7.getName()
            r6.name = r2
            android.net.Uri r2 = r7.getBannerImageLandscapeUri()
            r6.zzbk = r2
            java.lang.String r2 = r7.getBannerImageLandscapeUrl()
            r6.zzbl = r2
            android.net.Uri r2 = r7.getBannerImagePortraitUri()
            r6.zzbm = r2
            java.lang.String r2 = r7.getBannerImagePortraitUrl()
            r6.zzbn = r2
            long r4 = r7.zzp()
            r6.zzbo = r4
            com.google.android.gms.games.PlayerRelationshipInfo r2 = r7.getRelationshipInfo()
            if (r2 != 0) goto L_0x0093
            r4 = r3
            goto L_0x009e
        L_0x0093:
            com.google.android.gms.games.zzm r4 = new com.google.android.gms.games.zzm
            java.lang.Object r2 = r2.freeze()
            com.google.android.gms.games.PlayerRelationshipInfo r2 = (com.google.android.gms.games.PlayerRelationshipInfo) r2
            r4.<init>(r2)
        L_0x009e:
            r6.zzbp = r4
            com.google.android.gms.games.CurrentPlayerInfo r7 = r7.getCurrentPlayerInfo()
            if (r7 != 0) goto L_0x00a7
            goto L_0x00ae
        L_0x00a7:
            java.lang.Object r7 = r7.freeze()
            r3 = r7
            com.google.android.gms.games.zza r3 = (com.google.android.gms.games.zza) r3
        L_0x00ae:
            r6.zzbq = r3
            java.lang.String r7 = r6.zzba
            com.google.android.gms.common.internal.Asserts.checkNotNull(r7)
            java.lang.String r7 = r6.zzi
            com.google.android.gms.common.internal.Asserts.checkNotNull(r7)
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x00c2
            r7 = 1
            goto L_0x00c3
        L_0x00c2:
            r7 = 0
        L_0x00c3:
            com.google.android.gms.common.internal.Asserts.checkState(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.PlayerEntity.<init>(com.google.android.gms.games.Player):void");
    }

    @RecentlyNonNull
    public final Player freeze() {
        return this;
    }

    PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j, int i, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, long j3, zzm zzm2, zza zza2) {
        this.zzba = str;
        this.zzi = str2;
        this.zzm = uri;
        this.zzx = str3;
        this.zzn = uri2;
        this.zzy = str4;
        this.zzbb = j;
        this.zzbc = i;
        this.zzbd = j2;
        this.zzbe = str5;
        this.zzbh = z;
        this.zzbf = mostRecentGameInfoEntity;
        this.zzbg = playerLevelInfo;
        this.zzbi = z2;
        this.zzbj = str6;
        this.name = str7;
        this.zzbk = uri3;
        this.zzbl = str8;
        this.zzbm = uri4;
        this.zzbn = str9;
        this.zzbo = j3;
        this.zzbp = zzm2;
        this.zzbq = zza2;
    }

    @RecentlyNonNull
    public final String getPlayerId() {
        return this.zzba;
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return this.zzi;
    }

    @RecentlyNullable
    public final String zzk() {
        return this.zzbj;
    }

    @RecentlyNonNull
    public final String getName() {
        return this.name;
    }

    public final boolean zzl() {
        return this.zzbi;
    }

    @RecentlyNullable
    public final Uri getIconImageUri() {
        return this.zzm;
    }

    @RecentlyNullable
    public final String getIconImageUrl() {
        return this.zzx;
    }

    @RecentlyNullable
    public final Uri getHiResImageUri() {
        return this.zzn;
    }

    @RecentlyNullable
    public final String getHiResImageUrl() {
        return this.zzy;
    }

    public final long getRetrievedTimestamp() {
        return this.zzbb;
    }

    public final long getLastPlayedWithTimestamp() {
        return this.zzbd;
    }

    public final int zzm() {
        return this.zzbc;
    }

    public final boolean zzn() {
        return this.zzbh;
    }

    @RecentlyNullable
    public final String getTitle() {
        return this.zzbe;
    }

    @RecentlyNullable
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzbg;
    }

    public final com.google.android.gms.games.internal.player.zza zzo() {
        return this.zzbf;
    }

    @RecentlyNullable
    public final Uri getBannerImageLandscapeUri() {
        return this.zzbk;
    }

    @RecentlyNullable
    public final String getBannerImageLandscapeUrl() {
        return this.zzbl;
    }

    @RecentlyNullable
    public final Uri getBannerImagePortraitUri() {
        return this.zzbm;
    }

    @RecentlyNullable
    public final String getBannerImagePortraitUrl() {
        return this.zzbn;
    }

    public final long zzp() {
        return this.zzbo;
    }

    @RecentlyNullable
    public final PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzbp;
    }

    @RecentlyNonNull
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzbq;
    }

    public final int hashCode() {
        return zza((Player) this);
    }

    static int zza(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzl()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzk(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Long.valueOf(player.zzp()), player.getRelationshipInfo(), player.getCurrentPlayerInfo());
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzl()), Boolean.valueOf(player.zzl())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzk(), player.zzk()) && Objects.equal(player2.getName(), player.getName()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Long.valueOf(player2.zzp()), Long.valueOf(player.zzp())) && Objects.equal(player2.getCurrentPlayerInfo(), player.getCurrentPlayerInfo()) && Objects.equal(player2.getRelationshipInfo(), player.getRelationshipInfo());
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }

    static String zzb(Player player) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(player);
        stringHelper.add("PlayerId", player.getPlayerId());
        stringHelper.add("DisplayName", player.getDisplayName());
        stringHelper.add("HasDebugAccess", Boolean.valueOf(player.zzl()));
        stringHelper.add("IconImageUri", player.getIconImageUri());
        stringHelper.add("IconImageUrl", player.getIconImageUrl());
        stringHelper.add("HiResImageUri", player.getHiResImageUri());
        stringHelper.add("HiResImageUrl", player.getHiResImageUrl());
        stringHelper.add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp()));
        stringHelper.add("Title", player.getTitle());
        stringHelper.add("LevelInfo", player.getLevelInfo());
        stringHelper.add("GamerTag", player.zzk());
        stringHelper.add("Name", player.getName());
        stringHelper.add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri());
        stringHelper.add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl());
        stringHelper.add("BannerImagePortraitUri", player.getBannerImagePortraitUri());
        stringHelper.add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl());
        stringHelper.add("CurrentPlayerInfo", player.getCurrentPlayerInfo());
        stringHelper.add("totalUnlockedAchievement", Long.valueOf(player.zzp()));
        if (player.getRelationshipInfo() != null) {
            stringHelper.add("RelationshipInfo", player.getRelationshipInfo());
        }
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
            SafeParcelWriter.writeInt(parcel, 6, this.zzbc);
            SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
            SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
            SafeParcelWriter.writeParcelable(parcel, 15, this.zzbf, i, false);
            SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzbh);
            SafeParcelWriter.writeBoolean(parcel, 19, this.zzbi);
            SafeParcelWriter.writeString(parcel, 20, this.zzbj, false);
            SafeParcelWriter.writeString(parcel, 21, this.name, false);
            SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
            SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
            SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
            SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
            SafeParcelWriter.writeLong(parcel, 29, this.zzbo);
            SafeParcelWriter.writeParcelable(parcel, 33, getRelationshipInfo(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 35, getCurrentPlayerInfo(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzba);
        parcel.writeString(this.zzi);
        Uri uri = this.zzm;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzn;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
        parcel.writeLong(this.zzbb);
    }
}
