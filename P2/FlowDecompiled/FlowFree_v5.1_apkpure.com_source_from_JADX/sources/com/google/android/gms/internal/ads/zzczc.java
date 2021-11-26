package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzczc<AdT> implements zzcvw<AdT> {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        return !TextUtils.isEmpty(zzdqo.zzu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public final zzefw<AdT> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzdqo zzdqo2 = zzdqo;
        String optString = zzdqo2.zzu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdrg zzdrg = zzdra.zza.zza;
        zzdrf zzdrf = new zzdrf();
        zzdrf.zzt(zzdrg);
        zzdrf.zzf(optString);
        Bundle zzd = zzd(zzdrg.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzdqo2.zzu.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzdqo2.zzu.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdqo2.zzC.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdqo2.zzC.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzys zzys = zzdrg.zzd;
        zzys zzys2 = r5;
        zzys zzys3 = new zzys(zzys.zza, zzys.zzb, zzd2, zzys.zzd, zzys.zze, zzys.zzf, zzys.zzg, zzys.zzh, zzys.zzi, zzys.zzj, zzys.zzk, zzys.zzl, zzd, zzys.zzn, zzys.zzo, zzys.zzp, zzys.zzq, zzys.zzr, zzys.zzs, zzys.zzt, zzys.zzu, zzys.zzv, zzys.zzw);
        zzdrf.zza(zzys2);
        zzdrg zzu = zzdrf.zzu();
        Bundle bundle = new Bundle();
        zzdra zzdra2 = zzdra;
        zzdqr zzdqr = zzdra2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzdqr.zza));
        bundle2.putInt("refresh_interval", zzdqr.zzc);
        bundle2.putString("gws_query_id", zzdqr.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdra2.zza.zza.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzdqo zzdqo3 = zzdqo;
        bundle3.putString("allocation_id", zzdqo3.zzv);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzdqo3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzdqo3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzdqo3.zzo));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzdqo3.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzdqo3.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzdqo3.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzdqo3.zzi));
        bundle3.putString(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, zzdqo3.zzj);
        bundle3.putString("valid_from_timestamp", zzdqo3.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzdqo3.zzK);
        if (zzdqo3.zzl != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdqo3.zzl.zzb);
            bundle4.putString("rb_type", zzdqo3.zzl.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzu, bundle);
    }

    /* access modifiers changed from: protected */
    public abstract zzefw<AdT> zzc(zzdrg zzdrg, Bundle bundle);
}
