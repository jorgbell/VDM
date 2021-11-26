package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhb implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhr zzb;

    zzhb(zzhr zzhr, Bundle bundle) {
        this.zzb = zzhr;
        this.zza = bundle;
    }

    public final void run() {
        zzhr zzhr = this.zzb;
        Bundle bundle = this.zza;
        zzhr.zzg();
        zzhr.zzb();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString(MediationMetaData.KEY_NAME);
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzhr.zzs.zzF()) {
            zzhr.zzs.zzau().zzk().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkl zzkl = new zzkl(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzas zzV = zzhr.zzs.zzl().zzV(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0, true, false);
            zzas zzV2 = zzhr.zzs.zzl().zzV(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0, true, false);
            zzas zzV3 = zzhr.zzs.zzl().zzV(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0, true, false);
            zzhr.zzs.zzy().zzm(new zzaa(bundle.getString("app_id"), string2, zzkl, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzV2, bundle.getLong("trigger_timeout"), zzV, bundle.getLong("time_to_live"), zzV3));
        } catch (IllegalArgumentException unused) {
        }
    }
}
