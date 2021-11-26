package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzacq;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class AdRequest {
    protected final zzacq zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static class Builder {
        protected final zzacp zza;

        public Builder() {
            zzacp zzacp = new zzacp();
            this.zza = zzacp;
            zzacp.zze("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        @RecentlyNonNull
        public Builder addKeyword(@RecentlyNonNull String str) {
            this.zza.zza(str);
            return this;
        }

        @RecentlyNonNull
        public Builder addNetworkExtrasBundle(@RecentlyNonNull Class<? extends Object> cls, @RecentlyNonNull Bundle bundle) {
            this.zza.zzc(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.zza.zzf("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        @RecentlyNonNull
        public AdRequest build() {
            return new AdRequest(this);
        }

        @RecentlyNonNull
        public Builder setContentUrl(@RecentlyNonNull String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            Preconditions.checkArgument(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zza.zzh(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setLocation(@RecentlyNonNull Location location) {
            this.zza.zzk(location);
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestAgent(@RecentlyNonNull String str) {
            this.zza.zzm(str);
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public final Builder zza(@RecentlyNonNull String str) {
            this.zza.zze(str);
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public final Builder zzb(@RecentlyNonNull Date date) {
            this.zza.zzg(date);
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public final Builder zzc(int i) {
            this.zza.zzj(i);
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public final Builder zzd(boolean z) {
            this.zza.zzn(z);
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public final Builder zze(boolean z) {
            this.zza.zzq(z);
            return this;
        }
    }

    protected AdRequest(@RecentlyNonNull Builder builder) {
        this.zza = new zzacq(builder.zza, (SearchAdRequest) null);
    }

    public zzacq zza() {
        return this.zza;
    }
}
