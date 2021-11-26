package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcqi implements zzbui, zzbvr, zzp, zzbhr {
    private final Context zza;
    private final zzbbq zzb;
    private zzcpz zzc;
    private zzbgf zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzabx zzh;
    private boolean zzi;

    zzcqi(Context context, zzbbq zzbbq) {
        this.zza = context;
        this.zzb = zzbbq;
    }

    private final synchronized boolean zzi(zzabx zzabx) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue()) {
            zzbbk.zzi("Ad inspector had an internal error.");
            try {
                zzabx.zze(zzdsb.zzd(15, (String) null, (zzym) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzbbk.zzi("Ad inspector had an internal error.");
            try {
                zzabx.zze(zzdsb.zzd(15, (String) null, (zzym) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzs.zzj().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzfS)).intValue())) {
                    return true;
                }
            }
            zzbbk.zzi("Ad inspector cannot be opened because it is already open.");
            try {
                zzabx.zze(zzdsb.zzd(18, (String) null, (zzym) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzj() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzefx r0 = com.google.android.gms.internal.ads.zzbbw.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzcqh r1 = new com.google.android.gms.internal.ads.zzcqh     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqi.zzj():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x0010
            java.lang.String r4 = "Ad inspector loaded."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x002c }
            r3.zze = r0     // Catch:{ all -> 0x002c }
            r3.zzj()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x0010:
            java.lang.String r4 = "Ad inspector failed to load."
            com.google.android.gms.internal.ads.zzbbk.zzi(r4)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzabx r4 = r3.zzh     // Catch:{ RemoteException -> 0x0023 }
            if (r4 == 0) goto L_0x0023
            r1 = 16
            r2 = 0
            com.google.android.gms.internal.ads.zzym r1 = com.google.android.gms.internal.ads.zzdsb.zzd(r1, r2, r2)     // Catch:{ RemoteException -> 0x0023 }
            r4.zze(r1)     // Catch:{ RemoteException -> 0x0023 }
        L_0x0023:
            r3.zzi = r0     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzbgf r4 = r3.zzd     // Catch:{ all -> 0x002c }
            r4.destroy()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqi.zza(boolean):void");
    }

    public final void zzbC(zzym zzym) {
        zzj();
    }

    public final void zzbD() {
        zzj();
    }

    public final void zzbJ() {
    }

    public final synchronized void zzbo() {
        this.zzf = true;
        zzj();
    }

    public final void zzbr() {
    }

    public final void zzbs() {
    }

    public final synchronized void zzbt(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            zze.zza("Inspector closed.");
            zzabx zzabx = this.zzh;
            if (zzabx != null) {
                try {
                    zzabx.zze((zzym) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final void zzf(zzcpz zzcpz) {
        this.zzc = zzcpz;
    }

    public final synchronized void zzg(zzabx zzabx, zzakq zzakq) {
        zzabx zzabx2 = zzabx;
        synchronized (this) {
            if (zzi(zzabx)) {
                try {
                    zzs.zzd();
                    zzbgf zza2 = zzbgr.zza(this.zza, zzbhv.zzb(), "", false, false, (zzfh) null, (zzafp) null, this.zzb, (zzaff) null, (zzl) null, (zza) null, zzug.zza(), (zzdqo) null, (zzdqr) null);
                    this.zzd = zza2;
                    zzbht zzR = zza2.zzR();
                    if (zzR == null) {
                        zzbbk.zzi("Failed to obtain a web view for the ad inspector");
                        try {
                            zzabx2.zze(zzdsb.zzd(16, "Failed to obtain a web view for the ad inspector", (zzym) null));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.zzh = zzabx2;
                        zzR.zzK((zzyi) null, (zzajq) null, (zzp) null, (zzajs) null, (zzw) null, false, (zzaks) null, (zzb) null, (zzatl) null, (zzayr) null, (zzcvk) null, (zzdwg) null, (zzcni) null, (zzdvo) null, zzakq);
                        zzR.zzw(this);
                        this.zzd.loadUrl((String) zzaaa.zzc().zzb(zzaeq.zzfQ));
                        zzs.zzb();
                        zzn.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzs.zzj().currentTimeMillis();
                    }
                } catch (zzbgq e) {
                    zzbbk.zzj("Failed to obtain a web view for the ad inspector", e);
                    try {
                        zzabx2.zze(zzdsb.zzd(16, "Failed to obtain a web view for the ad inspector", (zzym) null));
                    } catch (RemoteException unused2) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zzb("window.inspectorInfo", this.zzc.zzi().toString());
    }
}
