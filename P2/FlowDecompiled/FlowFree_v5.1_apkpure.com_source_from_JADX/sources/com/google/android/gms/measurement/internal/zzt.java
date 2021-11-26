package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzlr;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzt {
    final /* synthetic */ zzy zza;
    private String zzb;
    private boolean zzc;
    private zzdr zzd;
    /* access modifiers changed from: private */
    public BitSet zze;
    private BitSet zzf;
    private Map<Integer, Long> zzg;
    private Map<Integer, List<Long>> zzh;

    /* synthetic */ zzt(zzy zzy, String str, zzs zzs) {
        this.zza = zzy;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw) {
        int zza2 = zzw.zza();
        Boolean bool = zzw.zzd;
        if (bool != null) {
            this.zzf.set(zza2, bool.booleanValue());
        }
        Boolean bool2 = zzw.zze;
        if (bool2 != null) {
            this.zze.set(zza2, bool2.booleanValue());
        }
        if (zzw.zzf != null) {
            Map<Integer, Long> map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l = map.get(valueOf);
            long longValue = zzw.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzw.zzg != null) {
            Map<Integer, List<Long>> map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzw.zzb()) {
                list.clear();
            }
            zzlr.zzb();
            zzae zzc2 = this.zza.zzs.zzc();
            String str = this.zzb;
            zzdz<Boolean> zzdz = zzea.zzZ;
            if (zzc2.zzn(str, zzdz) && zzw.zzc()) {
                list.clear();
            }
            zzlr.zzb();
            if (this.zza.zzs.zzc().zzn(this.zzb, zzdz)) {
                Long valueOf3 = Long.valueOf(zzw.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzw.zzg.longValue() / 1000));
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcy zzb(int i) {
        ArrayList arrayList;
        List list;
        zzcx zzh2 = zzcy.zzh();
        zzh2.zza(i);
        zzh2.zzd(this.zzc);
        zzdr zzdr = this.zzd;
        if (zzdr != null) {
            zzh2.zzc(zzdr);
        }
        zzdq zzk = zzdr.zzk();
        zzk.zzc(zzkk.zzn(this.zze));
        zzk.zza(zzkk.zzn(this.zzf));
        Map<Integer, Long> map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.zzg.keySet()) {
                int intValue2 = intValue.intValue();
                Long l = this.zzg.get(Integer.valueOf(intValue2));
                if (l != null) {
                    zzcz zze2 = zzda.zze();
                    zze2.zza(intValue2);
                    zze2.zzb(l.longValue());
                    arrayList2.add((zzda) zze2.zzaA());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzk.zze(arrayList);
        }
        Map<Integer, List<Long>> map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer next : this.zzh.keySet()) {
                zzds zzf2 = zzdt.zzf();
                zzf2.zza(next.intValue());
                List list2 = this.zzh.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzf2.zzb(list2);
                }
                arrayList3.add((zzdt) zzf2.zzaA());
            }
            list = arrayList3;
        }
        zzk.zzg(list);
        zzh2.zzb(zzk);
        return (zzcy) zzh2.zzaA();
    }

    /* synthetic */ zzt(zzy zzy, String str, zzdr zzdr, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzs zzs) {
        this.zza = zzy;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzdr;
    }
}
