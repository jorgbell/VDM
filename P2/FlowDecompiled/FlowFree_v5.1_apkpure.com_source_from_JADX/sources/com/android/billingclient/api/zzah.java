package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzd;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzah implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public BillingClientStateListener zzd;

    /* synthetic */ zzah(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzs zzs) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    /* access modifiers changed from: private */
    public final void zzf(BillingResult billingResult) {
        this.zza.zzB(new zzae(this, billingResult));
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zza.zza("BillingClient", "Billing service connected.");
        zzd unused = this.zza.zzg = zzc.zzo(iBinder);
        if (this.zza.zzz(new zzaf(this), 30000, new zzag(this)) == null) {
            zzf(this.zza.zzC());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zza.zzb("BillingClient", "Billing service disconnected.");
        zzd unused = this.zza.zzg = null;
        int unused2 = this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
