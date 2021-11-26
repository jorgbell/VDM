package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbhb extends zzaci {
    private final zzbdp zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    @GuardedBy("lock")
    private int zze;
    @GuardedBy("lock")
    private zzacm zzf;
    @GuardedBy("lock")
    private boolean zzg;
    @GuardedBy("lock")
    private boolean zzh = true;
    @GuardedBy("lock")
    private float zzi;
    @GuardedBy("lock")
    private float zzj;
    @GuardedBy("lock")
    private float zzk;
    @GuardedBy("lock")
    private boolean zzl;
    @GuardedBy("lock")
    private boolean zzm;
    @GuardedBy("lock")
    private zzaio zzn;

    public zzbhb(zzbdp zzbdp, float f, boolean z, boolean z2) {
        this.zza = zzbdp;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbw.zze.execute(new zzbgz(this, hashMap));
    }

    private final void zzx(int i, int i2, boolean z, boolean z2) {
        zzbbw.zze.execute(new zzbha(this, i, i2, z, z2));
    }

    public final void zzc(zzady zzady) {
        boolean z = zzady.zza;
        boolean z2 = zzady.zzb;
        boolean z3 = zzady.zzc;
        synchronized (this.zzb) {
            this.zzl = z2;
            this.zzm = z3;
        }
        zzw("initialState", CollectionUtils.mapOf("muteStart", true != z ? "0" : "1", "customControlsRequested", true != z2 ? "0" : "1", "clickToExpandRequested", true != z3 ? "0" : "1"));
    }

    public final void zzd(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zze() {
        zzw("play", (Map<String, String>) null);
    }

    public final void zzf() {
        zzw("pause", (Map<String, String>) null);
    }

    public final void zzg(boolean z) {
        zzw(true != z ? "unmute" : "mute", (Map<String, String>) null);
    }

    public final boolean zzh() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    public final int zzi() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    public final float zzj() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    public final float zzk() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    public final void zzl(zzacm zzacm) {
        synchronized (this.zzb) {
            this.zzf = zzacm;
        }
    }

    public final float zzm() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    public final zzacm zzo() throws RemoteException {
        zzacm zzacm;
        synchronized (this.zzb) {
            zzacm = this.zzf;
        }
        return zzacm;
    }

    public final boolean zzp() {
        boolean z;
        boolean zzn2 = zzn();
        synchronized (this.zzb) {
            z = false;
            if (!zzn2) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final void zzq() {
        zzw("stop", (Map<String, String>) null);
    }

    public final void zzr() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzx(i, 3, z, z);
    }

    public final void zzs(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi) {
                if (f3 == this.zzk) {
                    z2 = false;
                }
            }
            this.zzi = f2;
            this.zzj = f;
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzH().invalidate();
            }
        }
        if (z2) {
            try {
                zzaio zzaio = this.zzn;
                if (zzaio != null) {
                    zzaio.zze();
                }
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
        zzx(i2, i, z3, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        zzacm zzacm;
        zzacm zzacm2;
        zzacm zzacm3;
        synchronized (this.zzb) {
            boolean z5 = this.zzg;
            boolean z6 = false;
            if (z5 || i2 != 1) {
                i3 = i2;
                z3 = false;
            } else {
                i3 = 1;
                z3 = true;
            }
            if (i == i2 || i3 != 1) {
                z4 = false;
            } else {
                i3 = 1;
                z4 = true;
            }
            boolean z7 = i != i2 && i3 == 2;
            boolean z8 = i != i2 && i3 == 3;
            if (z5 || z3) {
                z6 = true;
            }
            this.zzg = z6;
            if (z3) {
                try {
                    zzacm zzacm4 = this.zzf;
                    if (zzacm4 != null) {
                        zzacm4.zze();
                    }
                } catch (RemoteException e) {
                    zzbbk.zzl("#007 Could not call remote method.", e);
                }
            }
            if (z4 && (zzacm3 = this.zzf) != null) {
                zzacm3.zzf();
            }
            if (z7 && (zzacm2 = this.zzf) != null) {
                zzacm2.zzg();
            }
            if (z8) {
                zzacm zzacm5 = this.zzf;
                if (zzacm5 != null) {
                    zzacm5.zzh();
                }
                this.zza.zzA();
            }
            if (!(z == z2 || (zzacm = this.zzf) == null)) {
                zzacm.zzi(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    public final void zzv(zzaio zzaio) {
        synchronized (this.zzb) {
            this.zzn = zzaio;
        }
    }
}
