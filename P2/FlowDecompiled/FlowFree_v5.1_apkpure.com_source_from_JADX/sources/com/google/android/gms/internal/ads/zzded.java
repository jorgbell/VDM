package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzded implements zzdiy<Bundle> {
    final zzdrg zza;
    private final long zzb;

    public zzded(zzdrg zzdrg, long j) {
        Preconditions.checkNotNull(zzdrg, "the targeting must not be null");
        this.zza = zzdrg;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzys zzys = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzys.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        int i2 = i - 1;
        if (i != 0) {
            boolean z = true;
            if (i2 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i2 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            zzdrs.zzb(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzys.zzb)), zzys.zzb != -1);
            zzdrs.zzf(bundle, "extras", zzys.zzc);
            zzdrs.zzc(bundle, "cust_gender", Integer.valueOf(zzys.zzd), zzys.zzd != -1);
            zzdrs.zzg(bundle, "kw", zzys.zze);
            zzdrs.zzc(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzys.zzg), zzys.zzg != -1);
            if (zzys.zzf) {
                bundle.putBoolean("test_request", true);
            }
            zzdrs.zzc(bundle, "d_imp_hdr", 1, zzys.zza >= 2 && zzys.zzh);
            String str = zzys.zzi;
            zzdrs.zzb(bundle, "ppid", str, zzys.zza >= 2 && !TextUtils.isEmpty(str));
            Location location = zzys.zzk;
            if (location != null) {
                Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(location.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", valueOf.floatValue());
                bundle2.putLong("lat", valueOf3.longValue());
                bundle2.putLong("long", valueOf4.longValue());
                bundle2.putLong("time", valueOf2.longValue());
                bundle.putBundle("uule", bundle2);
            }
            zzdrs.zze(bundle, "url", zzys.zzl);
            zzdrs.zzg(bundle, "neighboring_content_urls", zzys.zzv);
            zzdrs.zzf(bundle, "custom_targeting", zzys.zzn);
            zzdrs.zzg(bundle, "category_exclusions", zzys.zzo);
            zzdrs.zze(bundle, "request_agent", zzys.zzp);
            zzdrs.zze(bundle, "request_pkg", zzys.zzq);
            zzdrs.zzd(bundle, "is_designed_for_families", Boolean.valueOf(zzys.zzr), zzys.zza >= 7);
            if (zzys.zza >= 8) {
                Integer valueOf5 = Integer.valueOf(zzys.zzt);
                if (zzys.zzt == -1) {
                    z = false;
                }
                zzdrs.zzc(bundle, "tag_for_under_age_of_consent", valueOf5, z);
                zzdrs.zze(bundle, "max_ad_content_rating", zzys.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
