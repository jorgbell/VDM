package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbaq {
    /* access modifiers changed from: private */
    public final Clock zza;
    private final zzbaz zzb;
    @GuardedBy("lock")
    private final LinkedList<zzbap> zzc;
    private final Object zzd = new Object();
    private final String zze;
    private final String zzf;
    @GuardedBy("lock")
    private long zzg = -1;
    @GuardedBy("lock")
    private long zzh = -1;
    @GuardedBy("lock")
    private long zzi = 0;
    @GuardedBy("lock")
    private long zzj = -1;
    @GuardedBy("lock")
    private long zzk = -1;

    zzbaq(Clock clock, zzbaz zzbaz, String str, String str2) {
        this.zza = clock;
        this.zzb = zzbaz;
        this.zze = str;
        this.zzf = str2;
        this.zzc = new LinkedList<>();
    }

    public final void zza(zzys zzys) {
        synchronized (this.zzd) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            this.zzj = elapsedRealtime;
            this.zzb.zzf(zzys, elapsedRealtime);
        }
    }

    public final void zzb() {
        synchronized (this.zzd) {
            this.zzb.zzg();
        }
    }

    public final void zzc(long j) {
        synchronized (this.zzd) {
            this.zzk = j;
            if (j != -1) {
                this.zzb.zzb(this);
            }
        }
    }

    public final void zzd() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && this.zzg == -1) {
                this.zzg = this.zza.elapsedRealtime();
                this.zzb.zzb(this);
            }
            this.zzb.zze();
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                zzbap zzbap = new zzbap(this);
                zzbap.zzc();
                this.zzc.add(zzbap);
                this.zzi++;
                this.zzb.zzd();
                this.zzb.zzb(this);
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && !this.zzc.isEmpty()) {
                zzbap last = this.zzc.getLast();
                if (last.zza() == -1) {
                    last.zzb();
                    this.zzb.zzb(this);
                }
            }
        }
    }

    public final void zzg(boolean z) {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                this.zzh = this.zza.elapsedRealtime();
            }
        }
    }

    public final Bundle zzh() {
        Bundle bundle;
        synchronized (this.zzd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zze);
            bundle.putString("slotid", this.zzf);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzj);
            bundle.putLong("tresponse", this.zzk);
            bundle.putLong("timp", this.zzg);
            bundle.putLong("tload", this.zzh);
            bundle.putLong("pcc", this.zzi);
            bundle.putLong("tfetch", -1);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzbap) it.next()).zzd());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzi() {
        return this.zze;
    }
}
