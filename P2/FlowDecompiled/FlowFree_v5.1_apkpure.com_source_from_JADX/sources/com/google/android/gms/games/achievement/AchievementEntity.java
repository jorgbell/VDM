package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class AchievementEntity extends zzb implements Achievement {
    @RecentlyNonNull
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    private final String description;
    private final String name;
    private final int state;
    private final int type;
    private final String zzck;
    private final Uri zzcl;
    private final String zzcm;
    private final Uri zzcn;
    private final String zzco;
    private final int zzcp;
    private final String zzcq;
    private final PlayerEntity zzcr;
    private final int zzcs;
    private final String zzct;
    private final long zzcu;
    private final long zzcv;
    private final float zzcw;
    private final String zzh;

    public AchievementEntity(@RecentlyNonNull Achievement achievement) {
        String achievementId = achievement.getAchievementId();
        this.zzck = achievementId;
        this.type = achievement.getType();
        this.name = achievement.getName();
        String description2 = achievement.getDescription();
        this.description = description2;
        this.zzcl = achievement.getUnlockedImageUri();
        this.zzcm = achievement.getUnlockedImageUrl();
        this.zzcn = achievement.getRevealedImageUri();
        this.zzco = achievement.getRevealedImageUrl();
        if (achievement.zzad() != null) {
            this.zzcr = (PlayerEntity) achievement.zzad().freeze();
        } else {
            this.zzcr = null;
        }
        this.state = achievement.getState();
        this.zzcu = achievement.getLastUpdatedTimestamp();
        this.zzcv = achievement.getXpValue();
        this.zzcw = achievement.zzae();
        this.zzh = achievement.getApplicationId();
        if (achievement.getType() == 1) {
            this.zzcp = achievement.getTotalSteps();
            this.zzcq = achievement.getFormattedTotalSteps();
            this.zzcs = achievement.getCurrentSteps();
            this.zzct = achievement.getFormattedCurrentSteps();
        } else {
            this.zzcp = 0;
            this.zzcq = null;
            this.zzcs = 0;
            this.zzct = null;
        }
        Asserts.checkNotNull(achievementId);
        Asserts.checkNotNull(description2);
    }

    AchievementEntity(String str, int i, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i2, String str6, PlayerEntity playerEntity, int i3, int i4, String str7, long j, long j2, float f, String str8) {
        this.zzck = str;
        this.type = i;
        this.name = str2;
        this.description = str3;
        this.zzcl = uri;
        this.zzcm = str4;
        this.zzcn = uri2;
        this.zzco = str5;
        this.zzcp = i2;
        this.zzcq = str6;
        this.zzcr = playerEntity;
        this.state = i3;
        this.zzcs = i4;
        this.zzct = str7;
        this.zzcu = j;
        this.zzcv = j2;
        this.zzcw = f;
        this.zzh = str8;
    }

    @RecentlyNonNull
    public final String getAchievementId() {
        return this.zzck;
    }

    @RecentlyNonNull
    public final String getApplicationId() {
        return this.zzh;
    }

    public final int getType() {
        return this.type;
    }

    @RecentlyNonNull
    public final String getName() {
        return this.name;
    }

    @RecentlyNonNull
    public final String getDescription() {
        return this.description;
    }

    @RecentlyNonNull
    public final Uri getUnlockedImageUri() {
        return this.zzcl;
    }

    @RecentlyNonNull
    public final String getUnlockedImageUrl() {
        return this.zzcm;
    }

    @RecentlyNonNull
    public final Uri getRevealedImageUri() {
        return this.zzcn;
    }

    @RecentlyNonNull
    public final String getRevealedImageUrl() {
        return this.zzco;
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzcp;
    }

    @RecentlyNonNull
    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzcq;
    }

    @RecentlyNullable
    public final Player zzad() {
        return this.zzcr;
    }

    public final int getState() {
        return this.state;
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzcs;
    }

    @RecentlyNonNull
    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzct;
    }

    public final long getLastUpdatedTimestamp() {
        return this.zzcu;
    }

    public final long getXpValue() {
        return this.zzcv;
    }

    public final float zzae() {
        return this.zzcw;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i2 = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else {
            i2 = 0;
            i = 0;
        }
        return Objects.hashCode(achievement.getAchievementId(), achievement.getApplicationId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzad(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && Objects.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && Objects.equal(achievement2.getApplicationId(), achievement.getApplicationId()) && Objects.equal(achievement2.getName(), achievement.getName()) && Objects.equal(achievement2.getDescription(), achievement.getDescription()) && Objects.equal(achievement2.zzad(), achievement.zzad()) && achievement2.zzae() == achievement.zzae();
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }

    static String zzb(Achievement achievement) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(achievement);
        stringHelper.add("Id", achievement.getAchievementId());
        stringHelper.add("Game Id", achievement.getApplicationId());
        stringHelper.add("Type", Integer.valueOf(achievement.getType()));
        stringHelper.add("Name", achievement.getName());
        stringHelper.add("Description", achievement.getDescription());
        stringHelper.add("Player", achievement.zzad());
        stringHelper.add("State", Integer.valueOf(achievement.getState()));
        stringHelper.add("Rarity Percent", Float.valueOf(achievement.zzae()));
        if (achievement.getType() == 1) {
            stringHelper.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            stringHelper.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzcp);
        SafeParcelWriter.writeString(parcel, 10, this.zzcq, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzcr, i, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.zzcs);
        SafeParcelWriter.writeString(parcel, 14, this.zzct, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.zzcw);
        SafeParcelWriter.writeString(parcel, 18, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
