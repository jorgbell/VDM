package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdss implements zzdsr {
    @GuardedBy("this")
    private final ConcurrentHashMap<zzdtb, zzdsq> zza;
    private final zzdsy zzb;
    private final zzdsu zzc = new zzdsu();

    public zzdss(zzdsy zzdsy) {
        this.zza = new ConcurrentHashMap<>(zzdsy.zzd);
        this.zzb = zzdsy;
    }

    private final void zzf() {
        Parcelable.Creator<zzdsy> creator = zzdsy.CREATOR;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeu)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i = 0;
            for (Map.Entry next : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(next.getValue());
                sb.append("#");
                sb.append(((zzdtb) next.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzdsq) next.getValue()).zzc(); i2++) {
                    sb.append("[O]");
                }
                for (int zzc2 = ((zzdsq) next.getValue()).zzc(); zzc2 < this.zzb.zzd; zzc2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzdsq) next.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzbbk.zzd(sb.toString());
        }
    }

    public final synchronized zzdta<?> zza(zzdtb zzdtb) {
        zzdta<?> zzdta;
        zzdsq zzdsq = this.zza.get(zzdtb);
        if (zzdsq != null) {
            zzdta = zzdsq.zzb();
            if (zzdta == null) {
                this.zzc.zzb();
            }
            zzdtp zzh = zzdsq.zzh();
            if (zzdta != null) {
                zzuv zza2 = zzvd.zza();
                zzut zza3 = zzuu.zza();
                zza3.zza(zzuy.IN_MEMORY);
                zzuz zza4 = zzva.zza();
                zza4.zza(zzh.zza);
                zza4.zzb(zzh.zzb);
                zza3.zzb(zza4);
                zza2.zza(zza3);
                zzdta.zza.zzd().zzk((zzvd) zza2.zzah());
            }
            zzf();
        } else {
            this.zzc.zza();
            zzf();
            zzdta = null;
        }
        return zzdta;
    }

    public final synchronized boolean zzb(zzdtb zzdtb, zzdta<?> zzdta) {
        boolean zza2;
        zzdsq zzdsq = this.zza.get(zzdtb);
        zzdta.zzd = zzs.zzj().currentTimeMillis();
        if (zzdsq == null) {
            zzdsy zzdsy = this.zzb;
            zzdsq = new zzdsq(zzdsy.zzd, zzdsy.zze * 1000);
            int size = this.zza.size();
            zzdsy zzdsy2 = this.zzb;
            if (size == zzdsy2.zzc) {
                int i = zzdsy2.zzg;
                int i2 = i - 1;
                zzdtb zzdtb2 = null;
                if (i != 0) {
                    long j = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry next : this.zza.entrySet()) {
                            if (((zzdsq) next.getValue()).zzd() < j) {
                                j = ((zzdsq) next.getValue()).zzd();
                                zzdtb2 = (zzdtb) next.getKey();
                            }
                        }
                        if (zzdtb2 != null) {
                            this.zza.remove(zzdtb2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry next2 : this.zza.entrySet()) {
                            if (((zzdsq) next2.getValue()).zze() < j) {
                                j = ((zzdsq) next2.getValue()).zze();
                                zzdtb2 = (zzdtb) next2.getKey();
                            }
                        }
                        if (zzdtb2 != null) {
                            this.zza.remove(zzdtb2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry next3 : this.zza.entrySet()) {
                            if (((zzdsq) next3.getValue()).zzf() < i3) {
                                i3 = ((zzdsq) next3.getValue()).zzf();
                                zzdtb2 = (zzdtb) next3.getKey();
                            }
                        }
                        if (zzdtb2 != null) {
                            this.zza.remove(zzdtb2);
                        }
                    }
                    this.zzc.zzd();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzdtb, zzdsq);
            this.zzc.zzc();
        }
        zza2 = zzdsq.zza(zzdta);
        this.zzc.zze();
        zzdst zzf = this.zzc.zzf();
        zzdtp zzh = zzdsq.zzh();
        if (zzdta != null) {
            zzuv zza3 = zzvd.zza();
            zzut zza4 = zzuu.zza();
            zza4.zza(zzuy.IN_MEMORY);
            zzvb zza5 = zzvc.zza();
            zza5.zza(zzf.zza);
            zza5.zzb(zzf.zzb);
            zza5.zzc(zzh.zzb);
            zza4.zzc(zza5);
            zza3.zza(zza4);
            zzdta.zza.zzd().zzl((zzvd) zza3.zzah());
        }
        zzf();
        return zza2;
    }

    public final synchronized boolean zzc(zzdtb zzdtb) {
        zzdsq zzdsq = this.zza.get(zzdtb);
        if (zzdsq == null) {
            return true;
        }
        if (zzdsq.zzc() < this.zzb.zzd) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final zzdtb zzd(zzys zzys, String str, zzzd zzzd) {
        return new zzdtc(zzys, str, new zzawg(this.zzb.zza).zza().zzk, this.zzb.zzf, zzzd);
    }

    public final zzdsy zze() {
        return this.zzb;
    }
}
