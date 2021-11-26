package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfz implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference<View> zzc;
    private final zzcjo zzd;
    private final Clock zze;
    private zzaja zzf;
    private zzakp<Object> zzg;

    public zzcfz(zzcjo zzcjo, Clock clock) {
        this.zzd = zzcjo;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzf("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final void zza(zzaja zzaja) {
        this.zzf = zzaja;
        zzakp<Object> zzakp = this.zzg;
        if (zzakp != null) {
            this.zzd.zze("/unconfirmedClick", zzakp);
        }
        zzcfy zzcfy = new zzcfy(this, zzaja);
        this.zzg = zzcfy;
        this.zzd.zzd("/unconfirmedClick", zzcfy);
    }

    public final zzaja zzb() {
        return this.zzf;
    }

    public final void zzc() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zzf();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
