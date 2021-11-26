package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzmy;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzfg extends zzjz implements zzad {
    private final Map<String, Map<String, String>> zza = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzb = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzc = new ArrayMap();
    private final Map<String, zzcq> zzd = new ArrayMap();
    private final Map<String, Map<String, Integer>> zze = new ArrayMap();
    private final Map<String, String> zzg = new ArrayMap();

    zzfg(zzki zzki) {
        super(zzki);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (r2 != null) goto L_0x0095;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzn(java.lang.String r13) {
        /*
            r12 = this;
            r12.zzZ()
            r12.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcq> r0 = r12.zzd
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzki r0 = r12.zzf
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r0.zzg()
            r0.zzZ()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zze()     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            r11 = 0
            r6[r11] = r13     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0078 }
            if (r3 != 0) goto L_0x0047
            if (r2 == 0) goto L_0x0098
            goto L_0x0095
        L_0x0047:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0078 }
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0078 }
            if (r5 == 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzfp r5 = r0.zzs     // Catch:{ SQLiteException -> 0x0078 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x0078 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r13)     // Catch:{ SQLiteException -> 0x0078 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0078 }
        L_0x0068:
            if (r3 != 0) goto L_0x006d
            if (r2 == 0) goto L_0x0098
            goto L_0x0095
        L_0x006d:
            android.util.Pair r5 = new android.util.Pair     // Catch:{ SQLiteException -> 0x0078 }
            r5.<init>(r3, r4)     // Catch:{ SQLiteException -> 0x0078 }
            if (r2 == 0) goto L_0x0099
            r2.close()
            goto L_0x0099
        L_0x0078:
            r3 = move-exception
            goto L_0x0080
        L_0x007a:
            r13 = move-exception
            goto L_0x0108
        L_0x007d:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0080:
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ all -> 0x0106 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0106 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ all -> 0x0106 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r13)     // Catch:{ all -> 0x0106 }
            r0.zzc(r4, r5, r3)     // Catch:{ all -> 0x0106 }
            if (r2 == 0) goto L_0x0098
        L_0x0095:
            r2.close()
        L_0x0098:
            r5 = r1
        L_0x0099:
            if (r5 != 0) goto L_0x00ba
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r12.zza
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r12.zzb
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r12.zzc
            r0.put(r13, r1)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcq> r0 = r12.zzd
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.zzg
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> r0 = r12.zze
            r0.put(r13, r1)
            return
        L_0x00ba:
            java.lang.Object r0 = r5.first
            byte[] r0 = (byte[]) r0
            com.google.android.gms.internal.measurement.zzcq r0 = r12.zzq(r13, r0)
            com.google.android.gms.internal.measurement.zzhn r0 = r0.zzbu()
            com.google.android.gms.internal.measurement.zzcp r0 = (com.google.android.gms.internal.measurement.zzcp) r0
            r12.zzo(r13, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r12.zza
            com.google.android.gms.internal.measurement.zzhr r3 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcq r3 = (com.google.android.gms.internal.measurement.zzcq) r3
            java.util.Map r3 = zzr(r3)
            r2.put(r13, r3)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcq> r2 = r12.zzd
            com.google.android.gms.internal.measurement.zzhr r0 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcq r0 = (com.google.android.gms.internal.measurement.zzcq) r0
            r2.put(r13, r0)
            com.google.android.gms.internal.measurement.zzmy.zzb()
            com.google.android.gms.measurement.internal.zzfp r0 = r12.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzea.zzaE
            boolean r0 = r0.zzn(r1, r2)
            if (r0 == 0) goto L_0x0100
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.zzg
            java.lang.Object r1 = r5.second
            java.lang.String r1 = (java.lang.String) r1
            r0.put(r13, r1)
            return
        L_0x0100:
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.zzg
            r0.put(r13, r1)
            return
        L_0x0106:
            r13 = move-exception
            r1 = r2
        L_0x0108:
            if (r1 == 0) goto L_0x010d
            r1.close()
        L_0x010d:
            throw r13
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zzn(java.lang.String):void");
    }

    private final void zzo(String str, zzcp zzcp) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzcp != null) {
            for (int i = 0; i < zzcp.zza(); i++) {
                zzcn zzcn = (zzcn) zzcp.zzb(i).zzbu();
                if (TextUtils.isEmpty(zzcn.zza())) {
                    this.zzs.zzau().zze().zza("EventConfig contained null event name");
                } else {
                    String zza2 = zzcn.zza();
                    String zzb2 = zzgm.zzb(zzcn.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzcn.zzb(zzb2);
                        zzcp.zzc(i, zzcn);
                    }
                    arrayMap.put(zza2, Boolean.valueOf(zzcn.zzc()));
                    arrayMap2.put(zzcn.zza(), Boolean.valueOf(zzcn.zzd()));
                    if (zzcn.zze()) {
                        if (zzcn.zzf() < 2 || zzcn.zzf() > 65535) {
                            this.zzs.zzau().zze().zzc("Invalid sampling rate. Event name, sample rate", zzcn.zza(), Integer.valueOf(zzcn.zzf()));
                        } else {
                            arrayMap3.put(zzcn.zza(), Integer.valueOf(zzcn.zzf()));
                        }
                    }
                }
            }
        }
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zze.put(str, arrayMap3);
    }

    private final zzcq zzq(String str, byte[] bArr) {
        if (bArr == null) {
            return zzcq.zzk();
        }
        try {
            zzcp zzj = zzcq.zzj();
            zzkk.zzt(zzj, bArr);
            zzcq zzcq = (zzcq) zzj.zzaA();
            zzek zzk = this.zzs.zzau().zzk();
            String str2 = null;
            Long valueOf = zzcq.zza() ? Long.valueOf(zzcq.zzb()) : null;
            if (zzcq.zzc()) {
                str2 = zzcq.zzd();
            }
            zzk.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzcq;
        } catch (zzib e) {
            this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(str), e);
            return zzcq.zzk();
        } catch (RuntimeException e2) {
            this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(str), e2);
            return zzcq.zzk();
        }
    }

    private static final Map<String, String> zzr(zzcq zzcq) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzcq != null) {
            for (zzcs next : zzcq.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    public final String zza(String str, String str2) {
        zzg();
        zzn(str);
        Map map = this.zza.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final zzcq zzb(String str) {
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzn(str);
        return this.zzd.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzc(String str) {
        zzg();
        return this.zzg.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzd(String str) {
        zzg();
        this.zzg.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str) {
        zzg();
        this.zzd.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        zzg();
        zzcq zzb2 = zzb(str);
        if (zzb2 == null) {
            return false;
        }
        return zzb2.zzi();
    }

    /* access modifiers changed from: protected */
    public final boolean zzh(String str, byte[] bArr, String str2) {
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzcp zzcp = (zzcp) zzq(str, bArr).zzbu();
        if (zzcp == null) {
            return false;
        }
        zzo(str, zzcp);
        this.zzd.put(str, (zzcq) zzcp.zzaA());
        this.zzg.put(str, str2);
        this.zza.put(str, zzr((zzcq) zzcp.zzaA()));
        this.zzf.zzi().zzL(str, new ArrayList(zzcp.zzd()));
        try {
            zzcp.zze();
            bArr = ((zzcq) zzcp.zzaA()).zzbp();
        } catch (RuntimeException e) {
            this.zzs.zzau().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzem.zzl(str), e);
        }
        zzmy.zzb();
        if (this.zzs.zzc().zzn((String) null, zzea.zzaE)) {
            this.zzf.zzi().zzw(str, bArr, str2);
        } else {
            this.zzf.zzi().zzw(str, bArr, (String) null);
        }
        this.zzd.put(str, (zzcq) zzcp.zzaA());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(String str, String str2) {
        Boolean bool;
        zzg();
        zzn(str);
        if (zzl(str) && zzkp.zzR(str2)) {
            return true;
        }
        if (zzm(str) && zzkp.zzh(str2)) {
            return true;
        }
        Map map = this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        Boolean bool;
        zzg();
        zzn(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int zzk(String str, String str2) {
        Integer num;
        zzg();
        zzn(str);
        Map map = this.zze.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }
}
