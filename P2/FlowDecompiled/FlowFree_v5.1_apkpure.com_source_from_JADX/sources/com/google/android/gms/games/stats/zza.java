package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.internal.Asserts;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zza extends DataBufferRef implements PlayerStats {
    private Bundle zzlw;

    public final int describeContents() {
        return 0;
    }

    public final float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    public final float getChurnProbability() {
        return getFloat("churn_probability");
    }

    public final int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    public final int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    public final int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    public final float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    public final float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    public final float getSpendProbability() {
        if (!hasColumn("spend_probability")) {
            return -1.0f;
        }
        return getFloat("spend_probability");
    }

    public final float getHighSpenderProbability() {
        if (!hasColumn("high_spender_probability")) {
            return -1.0f;
        }
        return getFloat("high_spender_probability");
    }

    public final float getTotalSpendNext28Days() {
        if (!hasColumn("total_spend_next_28_days")) {
            return -1.0f;
        }
        return getFloat("total_spend_next_28_days");
    }

    public final Bundle zzcm() {
        Bundle bundle = this.zzlw;
        if (bundle != null) {
            return bundle;
        }
        this.zzlw = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (!(string == null || string2 == null)) {
            String[] split = string.split(",");
            String[] split2 = string2.split(",");
            Asserts.checkState(split.length <= split2.length, "Invalid raw arguments!");
            for (int i = 0; i < split.length; i++) {
                this.zzlw.putString(split[i], split2[i]);
            }
        }
        return this.zzlw;
    }

    public final int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public final String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerStatsEntity) ((PlayerStats) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new PlayerStatsEntity(this);
    }
}
