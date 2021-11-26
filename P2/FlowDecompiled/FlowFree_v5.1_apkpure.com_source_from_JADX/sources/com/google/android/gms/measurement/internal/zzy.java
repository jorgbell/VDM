package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzy extends zzjz {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzt> zzc;
    private Long zzd;
    private Long zze;

    zzy(zzki zzki) {
        super(zzki);
    }

    private final zzt zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzt zzt = new zzt(this, this.zza, (zzs) null);
        this.zzc.put(num, zzt);
        return zzt;
    }

    private final boolean zzd(int i, int i2) {
        zzt zzt = this.zzc.get(Integer.valueOf(i));
        if (zzt == null) {
            return false;
        }
        return zzt.zze.get(i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02dd, code lost:
        if (r5 != null) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02df, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02e7, code lost:
        if (r5 != null) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030c, code lost:
        if (r5 != null) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x030f, code lost:
        r1 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x031b, code lost:
        if (r1.hasNext() == false) goto L_0x03d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x031d, code lost:
        r4 = ((java.lang.Integer) r1.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzdr) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0337, code lost:
        if (r7 == null) goto L_0x03c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x033d, code lost:
        if (r7.isEmpty() == false) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0341, code lost:
        r17 = r0;
        r0 = r10.zzf.zzm().zzo(r6.zzc(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0355, code lost:
        if (r0.isEmpty() != false) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0357, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzdq) r6.zzbu();
        r5.zzd();
        r5.zzc(r0);
        r20 = r1;
        r0 = r10.zzf.zzm().zzo(r6.zza(), r7);
        r5.zzb();
        r5.zza(r0);
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x037e, code lost:
        if (r0 >= r6.zzf()) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0390, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzg(r0).zzb())) == false) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0392, code lost:
        r5.zzf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0395, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0398, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039d, code lost:
        if (r0 >= r6.zzi()) goto L_0x03b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03af, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzj(r0).zzb())) == false) goto L_0x03b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b1, code lost:
        r5.zzh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b4, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b7, code lost:
        r3.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzdr) r5.zzaA());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c5, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03c9, code lost:
        r17 = r0;
        r20 = r1;
        r3.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03d0, code lost:
        r0 = r17;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0725, code lost:
        if (r11 != null) goto L_0x0727;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0727, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0735, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0736, code lost:
        r29 = r2;
        r28 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x073b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x073c, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x075d, code lost:
        if (r11 != null) goto L_0x0727;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x08f2, code lost:
        if (r13 != null) goto L_0x08f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x08f4, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x091a, code lost:
        if (r13 == null) goto L_0x091d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0a2e, code lost:
        if (r7.zza() == false) goto L_0x0a39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0a30, code lost:
        r7 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0a39, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0a3a, code lost:
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0150, code lost:
        if (r5 != null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0152, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0174, code lost:
        if (r5 != null) goto L_0x0152;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x059d  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x073b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:248:0x0685] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0768  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x082a  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0925  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0a77  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0b0b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b3 A[Catch:{ SQLiteException -> 0x0226 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c3 A[SYNTHETIC, Splitter:B:70:0x01c3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcy> zzb(java.lang.String r66, java.util.List<com.google.android.gms.internal.measurement.zzdc> r67, java.util.List<com.google.android.gms.internal.measurement.zzdv> r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            r65 = this;
            r10 = r65
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r68)
            r0 = r66
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r69
            r10.zzd = r0
            r0 = r70
            r10.zze = r0
            java.util.Iterator r0 = r67.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzdc r1 = (com.google.android.gms.internal.measurement.zzdc) r1
            java.lang.String r1 = r1.zzd()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            com.google.android.gms.internal.measurement.zzlr.zzb()
            com.google.android.gms.measurement.internal.zzfp r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzZ
            boolean r14 = r0.zzn(r2, r3)
            com.google.android.gms.internal.measurement.zzlr.zzb()
            com.google.android.gms.measurement.internal.zzfp r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzY
            boolean r15 = r0.zzn(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzZ()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zze()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017d
            if (r14 == 0) goto L_0x017d
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zze()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 == 0) goto L_0x014c
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.internal.measurement.zzbw r13 = com.google.android.gms.internal.measurement.zzbx.zzn()     // Catch:{ IOException -> 0x012a }
            com.google.android.gms.measurement.internal.zzkk.zzt(r13, r0)     // Catch:{ IOException -> 0x012a }
            com.google.android.gms.internal.measurement.zzbw r13 = (com.google.android.gms.internal.measurement.zzbw) r13     // Catch:{ IOException -> 0x012a }
            com.google.android.gms.internal.measurement.zzhr r0 = r13.zzaA()     // Catch:{ IOException -> 0x012a }
            com.google.android.gms.internal.measurement.zzbx r0 = (com.google.android.gms.internal.measurement.zzbx) r0     // Catch:{ IOException -> 0x012a }
            boolean r13 = r0.zzg()     // Catch:{ SQLiteException -> 0x0158 }
            if (r13 != 0) goto L_0x010b
            goto L_0x013c
        L_0x010b:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0158 }
            if (r16 != 0) goto L_0x0124
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0158 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0158 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x0126
        L_0x0124:
            r12 = r16
        L_0x0126:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x013c
        L_0x012a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r12 = r2.zzs     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzau()     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.zzek r12 = r12.zzb()     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0158 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0158 }
        L_0x013c:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 != 0) goto L_0x0149
            if (r5 == 0) goto L_0x0147
            r5.close()
        L_0x0147:
            r12 = r4
            goto L_0x017e
        L_0x0149:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014c:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0158 }
            if (r5 == 0) goto L_0x017d
        L_0x0152:
            r5.close()
            goto L_0x017d
        L_0x0156:
            r0 = move-exception
            goto L_0x0177
        L_0x0158:
            r0 = move-exception
            goto L_0x015f
        L_0x015a:
            r0 = move-exception
            r5 = 0
            goto L_0x0177
        L_0x015d:
            r0 = move-exception
            r5 = 0
        L_0x015f:
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0156 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0156 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0156 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0156 }
            if (r5 == 0) goto L_0x017d
            goto L_0x0152
        L_0x0177:
            if (r5 == 0) goto L_0x017c
            r5.close()
        L_0x017c:
            throw r0
        L_0x017d:
            r12 = r0
        L_0x017e:
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzZ()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zze()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0226 }
            if (r0 != 0) goto L_0x01c3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0226 }
            if (r4 == 0) goto L_0x01bc
            r4.close()
        L_0x01bc:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0253
        L_0x01c3:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0226 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0226 }
        L_0x01c8:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0226 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzdq r13 = com.google.android.gms.internal.measurement.zzdr.zzk()     // Catch:{ IOException -> 0x01ef }
            com.google.android.gms.measurement.internal.zzkk.zzt(r13, r0)     // Catch:{ IOException -> 0x01ef }
            com.google.android.gms.internal.measurement.zzdq r13 = (com.google.android.gms.internal.measurement.zzdq) r13     // Catch:{ IOException -> 0x01ef }
            com.google.android.gms.internal.measurement.zzhr r0 = r13.zzaA()     // Catch:{ IOException -> 0x01ef }
            com.google.android.gms.internal.measurement.zzdr r0 = (com.google.android.gms.internal.measurement.zzdr) r0     // Catch:{ IOException -> 0x01ef }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0226 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020d
        L_0x01ef:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r13 = r2.zzs     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzb()     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0224 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0222 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0222 }
        L_0x020d:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0222 }
            if (r0 != 0) goto L_0x021b
            if (r4 == 0) goto L_0x0218
            r4.close()
        L_0x0218:
            r13 = r17
            goto L_0x0253
        L_0x021b:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c8
        L_0x0222:
            r0 = move-exception
            goto L_0x0236
        L_0x0224:
            r0 = move-exception
            goto L_0x0229
        L_0x0226:
            r0 = move-exception
            r18 = r6
        L_0x0229:
            r19 = r7
            goto L_0x0236
        L_0x022c:
            r0 = move-exception
            r5 = 0
            goto L_0x0b09
        L_0x0230:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0236:
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ all -> 0x0b07 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0b07 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0b07 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0b07 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b07 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b07 }
            if (r4 == 0) goto L_0x0252
            r4.close()
        L_0x0252:
            r13 = r0
        L_0x0253:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0264
        L_0x025a:
            r12 = r8
            r30 = r9
            r28 = r18
            r29 = r19
            r13 = 0
            goto L_0x0591
        L_0x0264:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x03de
            java.lang.String r1 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0284
            goto L_0x03d6
        L_0x0284:
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r4 = r0.zzi()
            r4.zzZ()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r4.zze()
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02f3, all -> 0x02ef }
            r16 = 0
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f3, all -> 0x02ef }
            r16 = 1
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f3, all -> 0x02ef }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02f3, all -> 0x02ef }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02ed }
            if (r6 == 0) goto L_0x02e3
        L_0x02b2:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02ed }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02ed }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02ed }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02ed }
            if (r7 != 0) goto L_0x02cb
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02ed }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02ed }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02ed }
        L_0x02cb:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02ed }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02ed }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02ed }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02ed }
            if (r6 != 0) goto L_0x02b2
            if (r5 == 0) goto L_0x030f
        L_0x02df:
            r5.close()
            goto L_0x030f
        L_0x02e3:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02ed }
            if (r5 == 0) goto L_0x030f
            goto L_0x02df
        L_0x02ea:
            r0 = move-exception
            goto L_0x03d8
        L_0x02ed:
            r0 = move-exception
            goto L_0x02f5
        L_0x02ef:
            r0 = move-exception
            r5 = 0
            goto L_0x03d8
        L_0x02f3:
            r0 = move-exception
            r5 = 0
        L_0x02f5:
            com.google.android.gms.measurement.internal.zzfp r4 = r4.zzs     // Catch:{ all -> 0x02ea }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ all -> 0x02ea }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ all -> 0x02ea }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzem.zzl(r1)     // Catch:{ all -> 0x02ea }
            r4.zzc(r6, r1, r0)     // Catch:{ all -> 0x02ea }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02ea }
            if (r5 == 0) goto L_0x030f
            goto L_0x02df
        L_0x030f:
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0317:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x03d6
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzdr r6 = (com.google.android.gms.internal.measurement.zzdr) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x03c9
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0341
            goto L_0x03c9
        L_0x0341:
            com.google.android.gms.measurement.internal.zzki r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzkk r5 = r5.zzm()
            r17 = r0
            java.util.List r0 = r6.zzc()
            java.util.List r0 = r5.zzo(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzhn r5 = r6.zzbu()
            com.google.android.gms.internal.measurement.zzdq r5 = (com.google.android.gms.internal.measurement.zzdq) r5
            r5.zzd()
            r5.zzc(r0)
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkk r0 = r0.zzm()
            r20 = r1
            java.util.List r1 = r6.zza()
            java.util.List r0 = r0.zzo(r1, r7)
            r5.zzb()
            r5.zza(r0)
            r0 = 0
        L_0x037a:
            int r1 = r6.zzf()
            if (r0 >= r1) goto L_0x0398
            com.google.android.gms.internal.measurement.zzda r1 = r6.zzg(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x0395
            r5.zzf(r0)
        L_0x0395:
            int r0 = r0 + 1
            goto L_0x037a
        L_0x0398:
            r0 = 0
        L_0x0399:
            int r1 = r6.zzi()
            if (r0 >= r1) goto L_0x03b7
            com.google.android.gms.internal.measurement.zzdt r1 = r6.zzj(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x03b4
            r5.zzh(r0)
        L_0x03b4:
            int r0 = r0 + 1
            goto L_0x0399
        L_0x03b7:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzhr r1 = r5.zzaA()
            com.google.android.gms.internal.measurement.zzdr r1 = (com.google.android.gms.internal.measurement.zzdr) r1
            r3.put(r0, r1)
            goto L_0x03d0
        L_0x03c5:
            r0 = r17
            goto L_0x0317
        L_0x03c9:
            r17 = r0
            r20 = r1
            r3.put(r5, r6)
        L_0x03d0:
            r0 = r17
            r1 = r20
            goto L_0x0317
        L_0x03d6:
            r0 = r3
            goto L_0x03df
        L_0x03d8:
            if (r5 == 0) goto L_0x03dd
            r5.close()
        L_0x03dd:
            throw r0
        L_0x03de:
            r0 = r13
        L_0x03df:
            java.util.Iterator r17 = r2.iterator()
        L_0x03e3:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x025a
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r20 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzdr r1 = (com.google.android.gms.internal.measurement.zzdr) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x044b
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x0415
            goto L_0x044b
        L_0x0415:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x041d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x044b
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzda r3 = (com.google.android.gms.internal.measurement.zzda) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x041d
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r21 = r3.zzc()
            if (r21 == 0) goto L_0x0446
            long r21 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r21)
            goto L_0x0447
        L_0x0446:
            r3 = 0
        L_0x0447:
            r7.put(r4, r3)
            goto L_0x041d
        L_0x044b:
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            if (r1 == 0) goto L_0x049b
            int r2 = r1.zzi()
            if (r2 != 0) goto L_0x0459
            goto L_0x049b
        L_0x0459:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0461:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x049b
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzdt r3 = (com.google.android.gms.internal.measurement.zzdt) r3
            boolean r21 = r3.zza()
            if (r21 == 0) goto L_0x0461
            int r21 = r3.zzd()
            if (r21 <= 0) goto L_0x0461
            int r21 = r3.zzb()
            r22 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            int r21 = r3.zzd()
            r23 = r2
            int r2 = r21 + -1
            long r2 = r3.zze(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r0, r2)
            r0 = r22
            r2 = r23
            goto L_0x0461
        L_0x049b:
            r22 = r0
            if (r1 == 0) goto L_0x04f0
            r0 = 0
        L_0x04a0:
            int r2 = r1.zzb()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x04f0
            java.util.List r2 = r1.zza()
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzm(r2, r0)
            if (r2 == 0) goto L_0x04de
            com.google.android.gms.measurement.internal.zzfp r2 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            r21 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r23 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r8)
            r6.set(r0)
            java.util.List r2 = r1.zzc()
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zzm(r2, r0)
            if (r2 == 0) goto L_0x04e2
            r5.set(r0)
            goto L_0x04e9
        L_0x04de:
            r21 = r8
            r23 = r9
        L_0x04e2:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x04e9:
            int r0 = r0 + 1
            r8 = r21
            r9 = r23
            goto L_0x04a0
        L_0x04f0:
            r21 = r8
            r23 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r13.get(r0)
            r8 = r1
            com.google.android.gms.internal.measurement.zzdr r8 = (com.google.android.gms.internal.measurement.zzdr) r8
            if (r15 == 0) goto L_0x055f
            if (r14 == 0) goto L_0x055f
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x055f
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x055f
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x0514
            goto L_0x055f
        L_0x0514:
            java.util.Iterator r0 = r0.iterator()
        L_0x0518:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x055f
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbx r1 = (com.google.android.gms.internal.measurement.zzbx) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzj()
            if (r1 == 0) goto L_0x0540
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x0540:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x0551
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x0551:
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x0518
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r4.put(r1, r2)
            goto L_0x0518
        L_0x055f:
            com.google.android.gms.measurement.internal.zzt r0 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r65
            r24 = r4
            r4 = r8
            r8 = 0
            r28 = r18
            r29 = r19
            r16 = r12
            r66 = r13
            r12 = r21
            r13 = r8
            r8 = r24
            r30 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r1.put(r2, r0)
            r13 = r66
            r8 = r12
            r12 = r16
            r0 = r22
            r9 = r30
            goto L_0x03e3
        L_0x0591:
            boolean r0 = r67.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x059d
        L_0x0599:
            r25 = r11
            goto L_0x0820
        L_0x059d:
            com.google.android.gms.measurement.internal.zzu r2 = new com.google.android.gms.measurement.internal.zzu
            r2.<init>(r10, r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r67.iterator()
        L_0x05ab:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0599
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.measurement.zzdc r0 = (com.google.android.gms.internal.measurement.zzdc) r0
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzdc r5 = r2.zza(r5, r0)
            if (r5 == 0) goto L_0x081d
            com.google.android.gms.measurement.internal.zzki r6 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzi()
            java.lang.String r7 = r10.zza
            java.lang.String r8 = r5.zzd()
            java.lang.String r9 = r0.zzd()
            com.google.android.gms.measurement.internal.zzao r9 = r6.zzf(r7, r9)
            if (r9 != 0) goto L_0x0614
            com.google.android.gms.measurement.internal.zzfp r9 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zze()
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzem.zzl(r7)
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzm()
            java.lang.String r6 = r6.zzc(r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r9.zzc(r8, r14, r6)
            com.google.android.gms.measurement.internal.zzao r6 = new com.google.android.gms.measurement.internal.zzao
            r31 = r6
            java.lang.String r33 = r0.zzd()
            r34 = 1
            r36 = 1
            r38 = 1
            long r40 = r0.zzf()
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r32 = r7
            r31.<init>(r32, r33, r34, r36, r38, r40, r42, r44, r45, r46, r47)
            goto L_0x0649
        L_0x0614:
            com.google.android.gms.measurement.internal.zzao r6 = new com.google.android.gms.measurement.internal.zzao
            r48 = r6
            java.lang.String r0 = r9.zza
            r49 = r0
            java.lang.String r0 = r9.zzb
            r50 = r0
            long r7 = r9.zzc
            r14 = 1
            long r51 = r7 + r14
            long r7 = r9.zzd
            long r53 = r7 + r14
            long r7 = r9.zze
            long r55 = r7 + r14
            long r7 = r9.zzf
            r57 = r7
            long r7 = r9.zzg
            r59 = r7
            java.lang.Long r0 = r9.zzh
            r61 = r0
            java.lang.Long r0 = r9.zzi
            r62 = r0
            java.lang.Long r0 = r9.zzj
            r63 = r0
            java.lang.Boolean r0 = r9.zzk
            r64 = r0
            r48.<init>(r49, r50, r51, r53, r55, r57, r59, r61, r62, r63, r64)
        L_0x0649:
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            r0.zzh(r6)
            long r7 = r6.zzc
            java.lang.String r9 = r5.zzd()
            java.lang.Object r0 = r3.get(r9)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x076c
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r14 = r0.zzi()
            java.lang.String r15 = r10.zza
            r14.zzZ()
            r14.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r14.zze()
            r24 = r2
            r67 = r4
            r4 = r28
            r2 = r29
            java.lang.String[] r18 = new java.lang.String[]{r4, r2}     // Catch:{ SQLiteException -> 0x073e, all -> 0x073b }
            r25 = r11
            r11 = 2
            java.lang.String[] r0 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0735, all -> 0x073b }
            r17 = 0
            r0[r17] = r15     // Catch:{ SQLiteException -> 0x0735, all -> 0x073b }
            r17 = 1
            r0[r17] = r9     // Catch:{ SQLiteException -> 0x0735, all -> 0x073b }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r11 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0735, all -> 0x073b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x072d }
            if (r0 == 0) goto L_0x071b
            r29 = r2
        L_0x06ae:
            r2 = 1
            byte[] r0 = r11.getBlob(r2)     // Catch:{ SQLiteException -> 0x0719 }
            com.google.android.gms.internal.measurement.zzbw r2 = com.google.android.gms.internal.measurement.zzbx.zzn()     // Catch:{ IOException -> 0x06ea }
            com.google.android.gms.measurement.internal.zzkk.zzt(r2, r0)     // Catch:{ IOException -> 0x06ea }
            com.google.android.gms.internal.measurement.zzbw r2 = (com.google.android.gms.internal.measurement.zzbw) r2     // Catch:{ IOException -> 0x06ea }
            com.google.android.gms.internal.measurement.zzhr r0 = r2.zzaA()     // Catch:{ IOException -> 0x06ea }
            com.google.android.gms.internal.measurement.zzbx r0 = (com.google.android.gms.internal.measurement.zzbx) r0     // Catch:{ IOException -> 0x06ea }
            r2 = 0
            int r16 = r11.getInt(r2)     // Catch:{ SQLiteException -> 0x0719 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0719 }
            java.lang.Object r16 = r13.get(r2)     // Catch:{ SQLiteException -> 0x0719 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0719 }
            if (r16 != 0) goto L_0x06de
            r28 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0717 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0717 }
            r13.put(r2, r4)     // Catch:{ SQLiteException -> 0x0717 }
            goto L_0x06e2
        L_0x06de:
            r28 = r4
            r4 = r16
        L_0x06e2:
            r4.add(r0)     // Catch:{ SQLiteException -> 0x0717 }
            r16 = r13
            r13 = r30
            goto L_0x0702
        L_0x06ea:
            r0 = move-exception
            r28 = r4
            com.google.android.gms.measurement.internal.zzfp r2 = r14.zzs     // Catch:{ SQLiteException -> 0x0717 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0717 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0717 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r15)     // Catch:{ SQLiteException -> 0x0717 }
            r16 = r13
            r13 = r30
            r2.zzc(r13, r4, r0)     // Catch:{ SQLiteException -> 0x072b }
        L_0x0702:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x072b }
            if (r0 != 0) goto L_0x0710
            if (r11 == 0) goto L_0x070d
            r11.close()
        L_0x070d:
            r0 = r16
            goto L_0x0760
        L_0x0710:
            r30 = r13
            r13 = r16
            r4 = r28
            goto L_0x06ae
        L_0x0717:
            r0 = move-exception
            goto L_0x0732
        L_0x0719:
            r0 = move-exception
            goto L_0x0730
        L_0x071b:
            r29 = r2
            r28 = r4
            r13 = r30
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x072b }
            if (r11 == 0) goto L_0x0760
        L_0x0727:
            r11.close()
            goto L_0x0760
        L_0x072b:
            r0 = move-exception
            goto L_0x0748
        L_0x072d:
            r0 = move-exception
            r29 = r2
        L_0x0730:
            r28 = r4
        L_0x0732:
            r13 = r30
            goto L_0x0748
        L_0x0735:
            r0 = move-exception
            r29 = r2
            r28 = r4
            goto L_0x0745
        L_0x073b:
            r0 = move-exception
            r5 = 0
            goto L_0x0766
        L_0x073e:
            r0 = move-exception
            r29 = r2
            r28 = r4
            r25 = r11
        L_0x0745:
            r13 = r30
            r11 = 0
        L_0x0748:
            com.google.android.gms.measurement.internal.zzfp r2 = r14.zzs     // Catch:{ all -> 0x0764 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0764 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0764 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r15)     // Catch:{ all -> 0x0764 }
            r2.zzc(r12, r4, r0)     // Catch:{ all -> 0x0764 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0764 }
            if (r11 == 0) goto L_0x0760
            goto L_0x0727
        L_0x0760:
            r3.put(r9, r0)
            goto L_0x0774
        L_0x0764:
            r0 = move-exception
            r5 = r11
        L_0x0766:
            if (r5 == 0) goto L_0x076b
            r5.close()
        L_0x076b:
            throw r0
        L_0x076c:
            r24 = r2
            r67 = r4
            r25 = r11
            r13 = r30
        L_0x0774:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x077c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0815
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.util.Set<java.lang.Integer> r9 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto L_0x07a6
            com.google.android.gms.measurement.internal.zzfp r4 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzk()
            r4.zzb(r1, r11)
            goto L_0x077c
        L_0x07a6:
            java.lang.Object r9 = r0.get(r11)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
            r11 = 1
        L_0x07b1:
            boolean r14 = r9.hasNext()
            if (r14 == 0) goto L_0x0800
            java.lang.Object r11 = r9.next()
            com.google.android.gms.internal.measurement.zzbx r11 = (com.google.android.gms.internal.measurement.zzbx) r11
            com.google.android.gms.measurement.internal.zzv r15 = new com.google.android.gms.measurement.internal.zzv
            java.lang.String r14 = r10.zza
            r15.<init>(r10, r14, r4, r11)
            java.lang.Long r14 = r10.zzd
            r22 = r0
            java.lang.Long r0 = r10.zze
            int r11 = r11.zzb()
            boolean r21 = r10.zzd(r4, r11)
            r11 = r14
            r14 = r15
            r23 = r2
            r2 = r15
            r15 = r11
            r16 = r0
            r17 = r5
            r18 = r7
            r20 = r6
            boolean r11 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r11 == 0) goto L_0x07f6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.measurement.internal.zzt r0 = r10.zzc(r0)
            r0.zza(r2)
            r0 = r22
            r2 = r23
            goto L_0x07b1
        L_0x07f6:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
            goto L_0x0804
        L_0x0800:
            r22 = r0
            r23 = r2
        L_0x0804:
            if (r11 != 0) goto L_0x080f
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
        L_0x080f:
            r0 = r22
            r2 = r23
            goto L_0x077c
        L_0x0815:
            r4 = r67
            r30 = r13
            r2 = r24
            r11 = r25
        L_0x081d:
            r13 = 0
            goto L_0x05ab
        L_0x0820:
            boolean r0 = r68.isEmpty()
            if (r0 == 0) goto L_0x082a
        L_0x0826:
            r11 = r28
            goto L_0x0a5d
        L_0x082a:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r68.iterator()
        L_0x0833:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0826
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            java.lang.String r5 = r4.zzc()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0929
            com.google.android.gms.measurement.internal.zzki r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzZ()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zze()
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0901, all -> 0x08fe }
            r14 = 2
            java.lang.String[] r0 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0901, all -> 0x08fe }
            r14 = 0
            r0[r14] = r7     // Catch:{ SQLiteException -> 0x0901, all -> 0x08fe }
            r14 = 1
            r0[r14] = r5     // Catch:{ SQLiteException -> 0x0901, all -> 0x08fe }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0901, all -> 0x08fe }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x08fa }
            if (r0 == 0) goto L_0x08ec
        L_0x0890:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x08fa }
            com.google.android.gms.internal.measurement.zzcf r15 = com.google.android.gms.internal.measurement.zzcg.zzi()     // Catch:{ IOException -> 0x08c6 }
            com.google.android.gms.measurement.internal.zzkk.zzt(r15, r0)     // Catch:{ IOException -> 0x08c6 }
            com.google.android.gms.internal.measurement.zzcf r15 = (com.google.android.gms.internal.measurement.zzcf) r15     // Catch:{ IOException -> 0x08c6 }
            com.google.android.gms.internal.measurement.zzhr r0 = r15.zzaA()     // Catch:{ IOException -> 0x08c6 }
            com.google.android.gms.internal.measurement.zzcg r0 = (com.google.android.gms.internal.measurement.zzcg) r0     // Catch:{ IOException -> 0x08c6 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x08fa }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x08fa }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x08fa }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08fa }
            if (r16 != 0) goto L_0x08be
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08fa }
            r15.<init>()     // Catch:{ SQLiteException -> 0x08fa }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x08fa }
            goto L_0x08c0
        L_0x08be:
            r15 = r16
        L_0x08c0:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x08fa }
            r67 = r3
            goto L_0x08dc
        L_0x08c6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r14 = r6.zzs     // Catch:{ SQLiteException -> 0x08fa }
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()     // Catch:{ SQLiteException -> 0x08fa }
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzb()     // Catch:{ SQLiteException -> 0x08fa }
            java.lang.String r15 = "Failed to merge filter"
            r67 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ SQLiteException -> 0x08f8 }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x08f8 }
        L_0x08dc:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x08f8 }
            if (r0 != 0) goto L_0x08e9
            if (r13 == 0) goto L_0x08e7
            r13.close()
        L_0x08e7:
            r0 = r8
            goto L_0x091d
        L_0x08e9:
            r3 = r67
            goto L_0x0890
        L_0x08ec:
            r67 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x08f8 }
            if (r13 == 0) goto L_0x091d
        L_0x08f4:
            r13.close()
            goto L_0x091d
        L_0x08f8:
            r0 = move-exception
            goto L_0x0905
        L_0x08fa:
            r0 = move-exception
            r67 = r3
            goto L_0x0905
        L_0x08fe:
            r0 = move-exception
            r5 = 0
            goto L_0x0923
        L_0x0901:
            r0 = move-exception
            r67 = r3
            r13 = 0
        L_0x0905:
            com.google.android.gms.measurement.internal.zzfp r3 = r6.zzs     // Catch:{ all -> 0x0921 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0921 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0921 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x0921 }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x0921 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0921 }
            if (r13 == 0) goto L_0x091d
            goto L_0x08f4
        L_0x091d:
            r2.put(r5, r0)
            goto L_0x092f
        L_0x0921:
            r0 = move-exception
            r5 = r13
        L_0x0923:
            if (r5 == 0) goto L_0x0928
            r5.close()
        L_0x0928:
            throw r0
        L_0x0929:
            r67 = r3
            r11 = r28
            r9 = r29
        L_0x092f:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0937:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a55
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set<java.lang.Integer> r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0962
            com.google.android.gms.measurement.internal.zzfp r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            r0.zzb(r1, r7)
            goto L_0x0a55
        L_0x0962:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x096d:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a44
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzcg r7 = (com.google.android.gms.internal.measurement.zzcg) r7
            com.google.android.gms.measurement.internal.zzfp r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()
            java.lang.String r8 = r8.zzn()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x09d7
            com.google.android.gms.measurement.internal.zzfp r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzk()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zza()
            if (r15 == 0) goto L_0x09a7
            int r15 = r7.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09a8
        L_0x09a7:
            r15 = 0
        L_0x09a8:
            com.google.android.gms.measurement.internal.zzfp r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzm()
            r68 = r0
            java.lang.String r0 = r7.zzc()
            java.lang.String r0 = r13.zze(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzfp r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            com.google.android.gms.measurement.internal.zzki r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzkk r8 = r8.zzm()
            java.lang.String r8 = r8.zzj(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x09d9
        L_0x09d7:
            r68 = r0
        L_0x09d9:
            boolean r0 = r7.zza()
            if (r0 == 0) goto L_0x0a1a
            int r0 = r7.zzb()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x09e8
            goto L_0x0a1a
        L_0x09e8:
            com.google.android.gms.measurement.internal.zzx r0 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zzb()
            boolean r7 = r10.zzd(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a10
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzt r8 = r10.zzc(r8)
            r8.zza(r0)
            r0 = r68
            goto L_0x096d
        L_0x0a10:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a46
        L_0x0a1a:
            com.google.android.gms.measurement.internal.zzfp r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r6)
            boolean r8 = r7.zza()
            if (r8 == 0) goto L_0x0a39
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a3a
        L_0x0a39:
            r7 = 0
        L_0x0a3a:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a48
        L_0x0a44:
            r68 = r0
        L_0x0a46:
            if (r7 != 0) goto L_0x0a51
        L_0x0a48:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0a51:
            r0 = r68
            goto L_0x0937
        L_0x0a55:
            r3 = r67
            r29 = r9
            r28 = r11
            goto L_0x0833
        L_0x0a5d:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a71:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b06
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzt r3 = (com.google.android.gms.measurement.internal.zzt) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzcy r0 = r3.zzb(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzki r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzdr r0 = r0.zzc()
            r3.zzZ()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbp()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r25
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zze()     // Catch:{ SQLiteException -> 0x0aed }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0aeb }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b02
            com.google.android.gms.measurement.internal.zzfp r0 = r3.zzs     // Catch:{ SQLiteException -> 0x0aeb }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0aeb }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0aeb }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ SQLiteException -> 0x0aeb }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0aeb }
            goto L_0x0b02
        L_0x0aeb:
            r0 = move-exception
            goto L_0x0aef
        L_0x0aed:
            r0 = move-exception
            r9 = 0
        L_0x0aef:
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0b02:
            r25 = r4
            goto L_0x0a71
        L_0x0b06:
            return r1
        L_0x0b07:
            r0 = move-exception
            r5 = r4
        L_0x0b09:
            if (r5 == 0) goto L_0x0b0e
            r5.close()
        L_0x0b0e:
            goto L_0x0b10
        L_0x0b0f:
            throw r0
        L_0x0b10:
            goto L_0x0b0f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
