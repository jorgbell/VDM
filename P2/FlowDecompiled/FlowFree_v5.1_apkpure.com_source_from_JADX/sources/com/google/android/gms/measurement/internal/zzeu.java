package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzeu extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public final zzki zzb;
    private boolean zzc;
    private boolean zzd;

    static {
        Class<zzeu> cls = zzeu.class;
    }

    zzeu(zzki zzki) {
        Preconditions.checkNotNull(zzki);
        this.zzb = zzki;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzr();
        String action = intent.getAction();
        this.zzb.zzau().zzk().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzb2 = this.zzb.zzh().zzb();
            if (this.zzd != zzb2) {
                this.zzd = zzb2;
                this.zzb.zzav().zzh(new zzet(this, zzb2));
                return;
            }
            return;
        }
        this.zzb.zzau().zze().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zzb.zzr();
        this.zzb.zzav().zzg();
        if (!this.zzc) {
            this.zzb.zzax().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzd = this.zzb.zzh().zzb();
            this.zzb.zzau().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzb() {
        this.zzb.zzr();
        this.zzb.zzav().zzg();
        this.zzb.zzav().zzg();
        if (this.zzc) {
            this.zzb.zzau().zzk().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzax().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzau().zzb().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
