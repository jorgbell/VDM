package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhc implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhr zzb;

    zzhc(zzhr zzhr, Bundle bundle) {
        this.zzb = zzhr;
        this.zza = bundle;
    }

    public final void run() {
        zzkl zzkl;
        zzhr zzhr = this.zzb;
        Bundle bundle = this.zza;
        zzhr.zzg();
        zzhr.zzb();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(MediationMetaData.KEY_NAME));
        if (zzhr.zzs.zzF()) {
            if (zzhr.zzs.zzc().zzn((String) null, zzea.zzaA)) {
                zzkl = new zzkl(bundle.getString(MediationMetaData.KEY_NAME), 0, (Object) null, "");
            } else {
                zzkl = new zzkl(bundle.getString(MediationMetaData.KEY_NAME), 0, (Object) null, (String) null);
            }
            try {
                zzhr.zzs.zzy().zzm(new zzaa(bundle.getString("app_id"), bundle.getString("origin"), zzkl, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), (zzas) null, bundle.getLong("trigger_timeout"), (zzas) null, bundle.getLong("time_to_live"), zzhr.zzs.zzl().zzV(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false)));
            } catch (IllegalArgumentException unused) {
            }
        } else {
            zzhr.zzs.zzau().zzk().zza("Conditional property not cleared since app measurement is disabled");
        }
    }
}
