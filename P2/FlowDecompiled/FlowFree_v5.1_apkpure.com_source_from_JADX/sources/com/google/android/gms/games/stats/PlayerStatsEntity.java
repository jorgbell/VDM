package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class PlayerStatsEntity extends zzb implements PlayerStats {
    @RecentlyNonNull
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new zzb();
    private final float zzlp;
    private final float zzlq;
    private final int zzlr;
    private final int zzls;
    private final int zzlt;
    private final float zzlu;
    private final float zzlv;
    private final Bundle zzlw;
    private final float zzlx;
    private final float zzly;
    private final float zzlz;

    public PlayerStatsEntity(@RecentlyNonNull PlayerStats playerStats) {
        this.zzlp = playerStats.getAverageSessionLength();
        this.zzlq = playerStats.getChurnProbability();
        this.zzlr = playerStats.getDaysSinceLastPlayed();
        this.zzls = playerStats.getNumberOfPurchases();
        this.zzlt = playerStats.getNumberOfSessions();
        this.zzlu = playerStats.getSessionPercentile();
        this.zzlv = playerStats.getSpendPercentile();
        this.zzlx = playerStats.getSpendProbability();
        this.zzly = playerStats.getHighSpenderProbability();
        this.zzlz = playerStats.getTotalSpendNext28Days();
        this.zzlw = playerStats.zzcm();
    }

    PlayerStatsEntity(float f, float f2, int i, int i2, int i3, float f3, float f4, Bundle bundle, float f5, float f6, float f7) {
        this.zzlp = f;
        this.zzlq = f2;
        this.zzlr = i;
        this.zzls = i2;
        this.zzlt = i3;
        this.zzlu = f3;
        this.zzlv = f4;
        this.zzlw = bundle;
        this.zzlx = f5;
        this.zzly = f6;
        this.zzlz = f7;
    }

    public float getAverageSessionLength() {
        return this.zzlp;
    }

    public float getChurnProbability() {
        return this.zzlq;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzlr;
    }

    public int getNumberOfPurchases() {
        return this.zzls;
    }

    public int getNumberOfSessions() {
        return this.zzlt;
    }

    public float getSessionPercentile() {
        return this.zzlu;
    }

    public float getSpendPercentile() {
        return this.zzlv;
    }

    @RecentlyNonNull
    public final Bundle zzcm() {
        return this.zzlw;
    }

    public float getSpendProbability() {
        return this.zzlx;
    }

    public float getHighSpenderProbability() {
        return this.zzly;
    }

    public float getTotalSpendNext28Days() {
        return this.zzlz;
    }

    public int hashCode() {
        return zza(this);
    }

    static int zza(PlayerStats playerStats) {
        return Objects.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return Objects.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && Objects.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && Objects.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && Objects.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && Objects.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && Objects.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    @RecentlyNonNull
    public String toString() {
        return zzb(this);
    }

    static String zzb(PlayerStats playerStats) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(playerStats);
        stringHelper.add("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength()));
        stringHelper.add("ChurnProbability", Float.valueOf(playerStats.getChurnProbability()));
        stringHelper.add("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed()));
        stringHelper.add("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases()));
        stringHelper.add("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions()));
        stringHelper.add("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile()));
        stringHelper.add("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile()));
        stringHelper.add("SpendProbability", Float.valueOf(playerStats.getSpendProbability()));
        stringHelper.add("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability()));
        stringHelper.add("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days()));
        return stringHelper.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel, 2, getChurnProbability());
        SafeParcelWriter.writeInt(parcel, 3, getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel, 4, getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel, 5, getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel, 6, getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel, 7, getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel, 8, this.zzlw, false);
        SafeParcelWriter.writeFloat(parcel, 9, getSpendProbability());
        SafeParcelWriter.writeFloat(parcel, 10, getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel, 11, getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
