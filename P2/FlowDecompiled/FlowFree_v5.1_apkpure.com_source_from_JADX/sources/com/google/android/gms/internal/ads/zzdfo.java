package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.sdk.AppLovinEventTypes;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfo implements zzdiz<zzdfp> {
    private final zzefx zza;
    private final Context zzb;

    public zzdfo(zzefx zzefx, Context context) {
        this.zza = zzefx;
        this.zzb = context;
    }

    public final zzefw<zzdfp> zza() {
        return this.zza.zzb(new zzdfn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfp zzb() throws Exception {
        double d;
        Intent registerReceiver = this.zzb.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzdfp(d, z);
    }
}
