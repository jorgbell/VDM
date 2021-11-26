package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdg;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzdv;
import com.google.android.gms.internal.measurement.zzlf;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzz;
import com.mopub.common.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzki implements zzgk {
    private static volatile zzki zzb;
    private final Map<String, zzaf> zzA;
    private final zzko zzB = new zzkg(this);
    long zza;
    private final zzfg zzc;
    private final zzes zzd;
    private zzai zze;
    private zzeu zzf;
    private zzjx zzg;
    private zzy zzh;
    private final zzkk zzi;
    private zzhw zzj;
    private zzjg zzk;
    private final zzka zzl;
    /* access modifiers changed from: private */
    public final zzfp zzm;
    private boolean zzn = false;
    private boolean zzo;
    private List<Runnable> zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private FileLock zzv;
    private FileChannel zzw;
    private List<Long> zzx;
    private List<Long> zzy;
    private long zzz;

    zzki(zzkj zzkj, zzfp zzfp) {
        Preconditions.checkNotNull(zzkj);
        this.zzm = zzfp.zzC(zzkj.zza, (zzz) null, (Long) null);
        this.zzz = -1;
        this.zzl = new zzka(this);
        zzkk zzkk = new zzkk(this);
        zzkk.zzaa();
        this.zzi = zzkk;
        zzes zzes = new zzes(this);
        zzes.zzaa();
        this.zzd = zzes;
        zzfg zzfg = new zzfg(this);
        zzfg.zzaa();
        this.zzc = zzfg;
        this.zzA = new HashMap();
        zzav().zzh(new zzkb(this, zzkj));
    }

    static /* synthetic */ void zzX(zzki zzki, zzkj zzkj) {
        zzki.zzav().zzg();
        zzai zzai = new zzai(zzki);
        zzai.zzaa();
        zzki.zze = zzai;
        zzae zzd2 = zzki.zzd();
        zzfg zzfg = zzki.zzc;
        Preconditions.checkNotNull(zzfg);
        zzd2.zza(zzfg);
        zzjg zzjg = new zzjg(zzki);
        zzjg.zzaa();
        zzki.zzk = zzjg;
        zzy zzy2 = new zzy(zzki);
        zzy2.zzaa();
        zzki.zzh = zzy2;
        zzhw zzhw = new zzhw(zzki);
        zzhw.zzaa();
        zzki.zzj = zzhw;
        zzjx zzjx = new zzjx(zzki);
        zzjx.zzaa();
        zzki.zzg = zzjx;
        zzki.zzf = new zzeu(zzki);
        if (zzki.zzq != zzki.zzr) {
            zzki.zzau().zzb().zzc("Not all upload components initialized", Integer.valueOf(zzki.zzq), Integer.valueOf(zzki.zzr));
        }
        zzki.zzn = true;
    }

    static final void zzZ(zzdb zzdb, int i, String str) {
        List<zzdg> zza2 = zzdb.zza();
        int i2 = 0;
        while (i2 < zza2.size()) {
            if (!"_err".equals(zza2.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zzdf zzn2 = zzdg.zzn();
        zzn2.zza("_err");
        zzn2.zzd(Long.valueOf((long) i).longValue());
        zzdf zzn3 = zzdg.zzn();
        zzn3.zza("_ev");
        zzn3.zzb(str);
        zzdb.zzf((zzdg) zzn2.zzaA());
        zzdb.zzf((zzdg) zzn3.zzaA());
    }

    public static zzki zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzki.class) {
                if (zzb == null) {
                    zzkj zzkj = new zzkj(context);
                    Preconditions.checkNotNull(zzkj);
                    zzb = new zzki(zzkj, (zzfp) null);
                }
            }
        }
        return zzb;
    }

    static final void zzaa(zzdb zzdb, String str) {
        List<zzdg> zza2 = zzdb.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(zza2.get(i).zzb())) {
                zzdb.zzj(i);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x03c7 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x048b A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04e5 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0630 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0648 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x097e A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x09c7 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x09ea A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0a61 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0a63 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0a6b A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0a97 A[Catch:{ NumberFormatException -> 0x0945, all -> 0x0d54 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:440:0x0d42=Splitter:B:440:0x0d42, B:69:0x0209=Splitter:B:69:0x0209} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzab(java.lang.String r46, long r47) {
        /*
            r45 = this;
            r1 = r45
            java.lang.String r2 = "_sc"
            java.lang.String r3 = "_sn"
            java.lang.String r4 = "_npa"
            java.lang.String r5 = "_ai"
            com.google.android.gms.measurement.internal.zzai r6 = r1.zze
            zzal(r6)
            r6.zzb()
            com.google.android.gms.measurement.internal.zzkh r6 = new com.google.android.gms.measurement.internal.zzkh     // Catch:{ all -> 0x0d54 }
            r14 = 0
            r6.<init>(r1, r14)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r7 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r7)     // Catch:{ all -> 0x0d54 }
            r8 = 0
            long r11 = r1.zzz     // Catch:{ all -> 0x0d54 }
            r9 = r47
            r13 = r6
            r7.zzW(r8, r9, r11, r13)     // Catch:{ all -> 0x0d54 }
            java.util.List<com.google.android.gms.internal.measurement.zzdc> r7 = r6.zzc     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x0d42
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x0032
            goto L_0x0d42
        L_0x0032:
            com.google.android.gms.internal.measurement.zzdk r7 = r6.zza     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhn r7 = r7.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdj r7 = (com.google.android.gms.internal.measurement.zzdj) r7     // Catch:{ all -> 0x0d54 }
            r7.zzh()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzae r9 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r10 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzea.zzT     // Catch:{ all -> 0x0d54 }
            boolean r9 = r9.zzn(r10, r11)     // Catch:{ all -> 0x0d54 }
            r18 = r14
            r20 = r18
            r8 = -1
            r10 = -1
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
        L_0x005a:
            java.util.List<com.google.android.gms.internal.measurement.zzdc> r11 = r6.zzc     // Catch:{ all -> 0x0d54 }
            int r11 = r11.size()     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = "_fr"
            java.lang.String r14 = "_et"
            r23 = r4
            java.lang.String r4 = "_e"
            r24 = r2
            r25 = r3
            if (r13 >= r11) goto L_0x069e
            java.util.List<com.google.android.gms.internal.measurement.zzdc> r3 = r6.zzc     // Catch:{ all -> 0x0d54 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r3 = (com.google.android.gms.internal.measurement.zzdc) r3     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhn r3 = r3.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdb r3 = (com.google.android.gms.internal.measurement.zzdb) r3     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfg r11 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r2 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r2 = r2.zzA()     // Catch:{ all -> 0x0d54 }
            r28 = r13
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r11.zzi(r2, r13)     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = "_err"
            if (r2 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzdk r12 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzem.zzl(r12)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfp r13 = r1.zzm     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzm()     // Catch:{ all -> 0x0d54 }
            java.lang.String r14 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r13.zzc(r14)     // Catch:{ all -> 0x0d54 }
            r2.zzc(r4, r12, r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfg r2 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r4 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.zzl(r4)     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzfg r2 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r4 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.zzm(r4)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x00dd
            goto L_0x010d
        L_0x00dd:
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzkp r29 = r45.zzq()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzko r2 = r1.zzB     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r4 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r31 = r4.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r33 = "_ev"
            java.lang.String r34 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzae r3 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzea.zzay     // Catch:{ all -> 0x0d54 }
            r11 = 0
            boolean r36 = r3.zzn(r11, r4)     // Catch:{ all -> 0x0d54 }
            r32 = 11
            r35 = 0
            r30 = r2
            r29.zzM(r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0d54 }
        L_0x010d:
            r30 = r5
            r5 = r7
            r31 = r15
            r14 = r24
            r11 = r25
            r7 = r28
            r16 = r9
            goto L_0x068e
        L_0x011c:
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzgm.zza(r5)     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.equals(r13)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x0192
            r3.zzl(r5)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = "Renaming ad_impression to _ai"
            r2.zza(r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            java.lang.String r2 = r2.zzn()     // Catch:{ all -> 0x0d54 }
            r13 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r13)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x0192
            r2 = 0
        L_0x014a:
            int r13 = r3.zzb()     // Catch:{ all -> 0x0d54 }
            if (r2 >= r13) goto L_0x0192
            java.lang.String r13 = "ad_platform"
            com.google.android.gms.internal.measurement.zzdg r29 = r3.zzc(r2)     // Catch:{ all -> 0x0d54 }
            r30 = r5
            java.lang.String r5 = r29.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r5 = r13.equals(r5)     // Catch:{ all -> 0x0d54 }
            if (r5 == 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzdg r5 = r3.zzc(r2)     // Catch:{ all -> 0x0d54 }
            java.lang.String r5 = r5.zzd()     // Catch:{ all -> 0x0d54 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0d54 }
            if (r5 != 0) goto L_0x018d
            java.lang.String r5 = "admob"
            com.google.android.gms.internal.measurement.zzdg r13 = r3.zzc(r2)     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r13.zzd()     // Catch:{ all -> 0x0d54 }
            boolean r5 = r5.equalsIgnoreCase(r13)     // Catch:{ all -> 0x0d54 }
            if (r5 == 0) goto L_0x018d
            com.google.android.gms.measurement.internal.zzem r5 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzh()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = "AdMob ad impression logged from app. Potentially duplicative."
            r5.zza(r13)     // Catch:{ all -> 0x0d54 }
        L_0x018d:
            int r2 = r2 + 1
            r5 = r30
            goto L_0x014a
        L_0x0192:
            r30 = r5
            com.google.android.gms.measurement.internal.zzfg r2 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r5 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r5 = r5.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.zzj(r5, r13)     // Catch:{ all -> 0x0d54 }
            java.lang.String r5 = "_c"
            if (r2 != 0) goto L_0x0200
            com.google.android.gms.measurement.internal.zzkk r13 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r13)     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)     // Catch:{ all -> 0x0d54 }
            r31 = r15
            int r15 = r13.hashCode()     // Catch:{ all -> 0x0d54 }
            r16 = r9
            r9 = 94660(0x171c4, float:1.32647E-40)
            if (r15 == r9) goto L_0x01e3
            r9 = 95025(0x17331, float:1.33158E-40)
            if (r15 == r9) goto L_0x01d9
            r9 = 95027(0x17333, float:1.33161E-40)
            if (r15 == r9) goto L_0x01cf
            goto L_0x01ed
        L_0x01cf:
            java.lang.String r9 = "_ui"
            boolean r9 = r13.equals(r9)
            if (r9 == 0) goto L_0x01ed
            r9 = 1
            goto L_0x01ee
        L_0x01d9:
            java.lang.String r9 = "_ug"
            boolean r9 = r13.equals(r9)
            if (r9 == 0) goto L_0x01ed
            r9 = 2
            goto L_0x01ee
        L_0x01e3:
            java.lang.String r9 = "_in"
            boolean r9 = r13.equals(r9)
            if (r9 == 0) goto L_0x01ed
            r9 = 0
            goto L_0x01ee
        L_0x01ed:
            r9 = -1
        L_0x01ee:
            if (r9 == 0) goto L_0x0204
            r13 = 1
            if (r9 == r13) goto L_0x0204
            r13 = 2
            if (r9 == r13) goto L_0x0204
            r33 = r7
            r22 = r8
            r13 = r10
            r29 = r14
            r2 = 0
            goto L_0x03c5
        L_0x0200:
            r31 = r15
            r16 = r9
        L_0x0204:
            r22 = r8
            r9 = 0
            r13 = 0
            r15 = 0
        L_0x0209:
            int r8 = r3.zzb()     // Catch:{ all -> 0x0d54 }
            r29 = r14
            java.lang.String r14 = "_r"
            if (r9 >= r8) goto L_0x0267
            com.google.android.gms.internal.measurement.zzdg r8 = r3.zzc(r9)     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r8 = r5.equals(r8)     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x023b
            com.google.android.gms.internal.measurement.zzdg r8 = r3.zzc(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhn r8 = r8.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r8 = (com.google.android.gms.internal.measurement.zzdf) r8     // Catch:{ all -> 0x0d54 }
            r13 = 1
            r8.zzd(r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r8 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r8 = (com.google.android.gms.internal.measurement.zzdg) r8     // Catch:{ all -> 0x0d54 }
            r3.zzd(r9, r8)     // Catch:{ all -> 0x0d54 }
            r13 = 1
            goto L_0x0262
        L_0x023b:
            com.google.android.gms.internal.measurement.zzdg r8 = r3.zzc(r9)     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r8 = r14.equals(r8)     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x0262
            com.google.android.gms.internal.measurement.zzdg r8 = r3.zzc(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhn r8 = r8.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r8 = (com.google.android.gms.internal.measurement.zzdf) r8     // Catch:{ all -> 0x0d54 }
            r14 = 1
            r8.zzd(r14)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r8 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r8 = (com.google.android.gms.internal.measurement.zzdg) r8     // Catch:{ all -> 0x0d54 }
            r3.zzd(r9, r8)     // Catch:{ all -> 0x0d54 }
            r15 = 1
        L_0x0262:
            int r9 = r9 + 1
            r14 = r29
            goto L_0x0209
        L_0x0267:
            if (r13 != 0) goto L_0x0298
            if (r2 == 0) goto L_0x0298
            com.google.android.gms.measurement.internal.zzem r8 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfp r13 = r1.zzm     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzm()     // Catch:{ all -> 0x0d54 }
            r33 = r7
            java.lang.String r7 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r13.zzc(r7)     // Catch:{ all -> 0x0d54 }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r7 = com.google.android.gms.internal.measurement.zzdg.zzn()     // Catch:{ all -> 0x0d54 }
            r7.zza(r5)     // Catch:{ all -> 0x0d54 }
            r8 = 1
            r7.zzd(r8)     // Catch:{ all -> 0x0d54 }
            r3.zzg(r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x029a
        L_0x0298:
            r33 = r7
        L_0x029a:
            if (r15 != 0) goto L_0x02c6
            com.google.android.gms.measurement.internal.zzem r7 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzm()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r9.zzc(r13)     // Catch:{ all -> 0x0d54 }
            r7.zzb(r8, r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r7 = com.google.android.gms.internal.measurement.zzdg.zzn()     // Catch:{ all -> 0x0d54 }
            r7.zza(r14)     // Catch:{ all -> 0x0d54 }
            r8 = 1
            r7.zzd(r8)     // Catch:{ all -> 0x0d54 }
            r3.zzg(r7)     // Catch:{ all -> 0x0d54 }
        L_0x02c6:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r7)     // Catch:{ all -> 0x0d54 }
            long r35 = r45.zzu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r8 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r37 = r8.zzA()     // Catch:{ all -> 0x0d54 }
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 1
            r34 = r7
            com.google.android.gms.measurement.internal.zzag r7 = r34.zzu(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0d54 }
            long r7 = r7.zze     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzae r9 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r13 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = r13.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzea.zzn     // Catch:{ all -> 0x0d54 }
            int r9 = r9.zzk(r13, r15)     // Catch:{ all -> 0x0d54 }
            r13 = r10
            long r9 = (long) r9     // Catch:{ all -> 0x0d54 }
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 <= 0) goto L_0x0301
            zzaa(r3, r14)     // Catch:{ all -> 0x0d54 }
            goto L_0x0303
        L_0x0301:
            r19 = 1
        L_0x0303:
            java.lang.String r7 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r7 = com.google.android.gms.measurement.internal.zzkp.zzh(r7)     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x03c5
            if (r2 == 0) goto L_0x03c5
            com.google.android.gms.measurement.internal.zzai r7 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r7)     // Catch:{ all -> 0x0d54 }
            long r35 = r45.zzu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r8 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r37 = r8.zzA()     // Catch:{ all -> 0x0d54 }
            r38 = 0
            r39 = 0
            r40 = 1
            r41 = 0
            r42 = 0
            r34 = r7
            com.google.android.gms.measurement.internal.zzag r7 = r34.zzu(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0d54 }
            long r7 = r7.zzc     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzae r9 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r10 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzea.zzm     // Catch:{ all -> 0x0d54 }
            int r9 = r9.zzk(r10, r14)     // Catch:{ all -> 0x0d54 }
            long r9 = (long) r9     // Catch:{ all -> 0x0d54 }
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 <= 0) goto L_0x03c5
            com.google.android.gms.measurement.internal.zzem r7 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzdk r9 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r9)     // Catch:{ all -> 0x0d54 }
            r7.zzb(r8, r9)     // Catch:{ all -> 0x0d54 }
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = 0
        L_0x0360:
            int r14 = r3.zzb()     // Catch:{ all -> 0x0d54 }
            if (r7 >= r14) goto L_0x038b
            com.google.android.gms.internal.measurement.zzdg r14 = r3.zzc(r7)     // Catch:{ all -> 0x0d54 }
            java.lang.String r15 = r14.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r15 = r5.equals(r15)     // Catch:{ all -> 0x0d54 }
            if (r15 == 0) goto L_0x037d
            com.google.android.gms.internal.measurement.zzhn r9 = r14.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r9 = (com.google.android.gms.internal.measurement.zzdf) r9     // Catch:{ all -> 0x0d54 }
            r10 = r9
            r9 = r7
            goto L_0x0388
        L_0x037d:
            java.lang.String r14 = r14.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r14 = r11.equals(r14)     // Catch:{ all -> 0x0d54 }
            if (r14 == 0) goto L_0x0388
            r8 = 1
        L_0x0388:
            int r7 = r7 + 1
            goto L_0x0360
        L_0x038b:
            if (r8 == 0) goto L_0x0394
            if (r10 == 0) goto L_0x0393
            r3.zzj(r9)     // Catch:{ all -> 0x0d54 }
            goto L_0x03c5
        L_0x0393:
            r10 = 0
        L_0x0394:
            if (r10 == 0) goto L_0x03ae
            com.google.android.gms.internal.measurement.zzhn r7 = r10.clone()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdf r7 = (com.google.android.gms.internal.measurement.zzdf) r7     // Catch:{ all -> 0x0d54 }
            r7.zza(r11)     // Catch:{ all -> 0x0d54 }
            r10 = 10
            r7.zzd(r10)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r7 = r7.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r7 = (com.google.android.gms.internal.measurement.zzdg) r7     // Catch:{ all -> 0x0d54 }
            r3.zzd(r9, r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x03c5
        L_0x03ae:
            com.google.android.gms.measurement.internal.zzem r7 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzdk r9 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r9)     // Catch:{ all -> 0x0d54 }
            r7.zzb(r8, r9)     // Catch:{ all -> 0x0d54 }
        L_0x03c5:
            if (r2 == 0) goto L_0x047e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d54 }
            java.util.List r7 = r3.zza()     // Catch:{ all -> 0x0d54 }
            r2.<init>(r7)     // Catch:{ all -> 0x0d54 }
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x03d3:
            int r10 = r2.size()     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = "currency"
            java.lang.String r14 = "value"
            if (r7 >= r10) goto L_0x0403
            java.lang.Object r10 = r2.get(r7)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r10 = (com.google.android.gms.internal.measurement.zzdg) r10     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = r10.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r10 = r14.equals(r10)     // Catch:{ all -> 0x0d54 }
            if (r10 == 0) goto L_0x03ef
            r8 = r7
            goto L_0x0400
        L_0x03ef:
            java.lang.Object r10 = r2.get(r7)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r10 = (com.google.android.gms.internal.measurement.zzdg) r10     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = r10.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x0d54 }
            if (r10 == 0) goto L_0x0400
            r9 = r7
        L_0x0400:
            int r7 = r7 + 1
            goto L_0x03d3
        L_0x0403:
            r7 = -1
            if (r8 != r7) goto L_0x0408
            goto L_0x047f
        L_0x0408:
            java.lang.Object r7 = r2.get(r8)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r7 = (com.google.android.gms.internal.measurement.zzdg) r7     // Catch:{ all -> 0x0d54 }
            boolean r7 = r7.zze()     // Catch:{ all -> 0x0d54 }
            if (r7 != 0) goto L_0x0439
            java.lang.Object r7 = r2.get(r8)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r7 = (com.google.android.gms.internal.measurement.zzdg) r7     // Catch:{ all -> 0x0d54 }
            boolean r7 = r7.zzi()     // Catch:{ all -> 0x0d54 }
            if (r7 != 0) goto L_0x0439
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzh()     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = "Value must be specified with a numeric type."
            r2.zza(r7)     // Catch:{ all -> 0x0d54 }
            r3.zzj(r8)     // Catch:{ all -> 0x0d54 }
            zzaa(r3, r5)     // Catch:{ all -> 0x0d54 }
            r2 = 18
            zzZ(r3, r2, r14)     // Catch:{ all -> 0x0d54 }
            goto L_0x047e
        L_0x0439:
            r7 = -1
            if (r9 != r7) goto L_0x043d
            goto L_0x0465
        L_0x043d:
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r2 = (com.google.android.gms.internal.measurement.zzdg) r2     // Catch:{ all -> 0x0d54 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0d54 }
            int r9 = r2.length()     // Catch:{ all -> 0x0d54 }
            r10 = 3
            if (r9 != r10) goto L_0x0465
            r9 = 0
        L_0x044f:
            int r10 = r2.length()     // Catch:{ all -> 0x0d54 }
            if (r9 >= r10) goto L_0x047f
            int r10 = r2.codePointAt(r9)     // Catch:{ all -> 0x0d54 }
            boolean r14 = java.lang.Character.isLetter(r10)     // Catch:{ all -> 0x0d54 }
            if (r14 == 0) goto L_0x0465
            int r10 = java.lang.Character.charCount(r10)     // Catch:{ all -> 0x0d54 }
            int r9 = r9 + r10
            goto L_0x044f
        L_0x0465:
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzh()     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r9)     // Catch:{ all -> 0x0d54 }
            r3.zzj(r8)     // Catch:{ all -> 0x0d54 }
            zzaa(r3, r5)     // Catch:{ all -> 0x0d54 }
            r2 = 19
            zzZ(r3, r2, r11)     // Catch:{ all -> 0x0d54 }
            goto L_0x047f
        L_0x047e:
            r7 = -1
        L_0x047f:
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0d54 }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04e5
            com.google.android.gms.measurement.internal.zzkk r2 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r2 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r2 = (com.google.android.gms.internal.measurement.zzdc) r2     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r2 = com.google.android.gms.measurement.internal.zzkk.zzz(r2, r12)     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x04df
            if (r20 == 0) goto L_0x04d0
            long r10 = r20.zzn()     // Catch:{ all -> 0x0d54 }
            long r14 = r3.zzn()     // Catch:{ all -> 0x0d54 }
            long r10 = r10 - r14
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d54 }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04d0
            com.google.android.gms.internal.measurement.zzhn r2 = r20.clone()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0d54 }
            boolean r5 = r1.zzad(r3, r2)     // Catch:{ all -> 0x0d54 }
            if (r5 == 0) goto L_0x04c7
            r12 = r13
            r5 = r33
            r5.zze(r12, r2)     // Catch:{ all -> 0x0d54 }
            r8 = r22
            r2 = 0
            r20 = 0
            goto L_0x04cd
        L_0x04c7:
            r12 = r13
            r5 = r33
            r2 = r3
            r8 = r17
        L_0x04cd:
            r18 = r2
            goto L_0x04d7
        L_0x04d0:
            r12 = r13
            r5 = r33
            r18 = r3
            r8 = r17
        L_0x04d7:
            r14 = r24
            r11 = r25
            r10 = r29
            goto L_0x061e
        L_0x04df:
            r12 = r13
            r5 = r33
            r8 = r22
            goto L_0x04d7
        L_0x04e5:
            r12 = r13
            r5 = r33
            java.lang.String r2 = "_vs"
            java.lang.String r10 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.equals(r10)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x0547
            com.google.android.gms.measurement.internal.zzkk r2 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r2 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r2 = (com.google.android.gms.internal.measurement.zzdc) r2     // Catch:{ all -> 0x0d54 }
            r10 = r29
            com.google.android.gms.internal.measurement.zzdg r2 = com.google.android.gms.measurement.internal.zzkk.zzz(r2, r10)     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x0544
            if (r18 == 0) goto L_0x0538
            long r13 = r18.zzn()     // Catch:{ all -> 0x0d54 }
            long r20 = r3.zzn()     // Catch:{ all -> 0x0d54 }
            long r13 = r13 - r20
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0d54 }
            int r2 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0538
            com.google.android.gms.internal.measurement.zzhn r2 = r18.clone()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0d54 }
            boolean r8 = r1.zzad(r2, r3)     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x0530
            r8 = r22
            r5.zze(r8, r2)     // Catch:{ all -> 0x0d54 }
            r2 = 0
            r18 = 0
            goto L_0x0535
        L_0x0530:
            r8 = r22
            r2 = r3
            r12 = r17
        L_0x0535:
            r20 = r2
            goto L_0x053e
        L_0x0538:
            r8 = r22
            r20 = r3
            r12 = r17
        L_0x053e:
            r14 = r24
            r11 = r25
            goto L_0x061e
        L_0x0544:
            r8 = r22
            goto L_0x053e
        L_0x0547:
            r8 = r22
            r10 = r29
            com.google.android.gms.measurement.internal.zzae r2 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r9 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzea.zzaj     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.zzn(r9, r11)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x053e
            java.lang.String r2 = "_ab"
            java.lang.String r9 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x053e
            com.google.android.gms.measurement.internal.zzkk r2 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r2 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r2 = (com.google.android.gms.internal.measurement.zzdc) r2     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r2 = com.google.android.gms.measurement.internal.zzkk.zzz(r2, r10)     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x053e
            if (r18 == 0) goto L_0x053e
            long r13 = r18.zzn()     // Catch:{ all -> 0x0d54 }
            long r26 = r3.zzn()     // Catch:{ all -> 0x0d54 }
            long r13 = r13 - r26
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0d54 }
            r26 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r13 > r26 ? 1 : (r13 == r26 ? 0 : -1))
            if (r2 > 0) goto L_0x053e
            com.google.android.gms.internal.measurement.zzhn r2 = r18.clone()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch:{ all -> 0x0d54 }
            r1.zzae(r2, r3)     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r2.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r9 = r4.equals(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r9 = r2.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r11 = r25
            com.google.android.gms.internal.measurement.zzdg r9 = com.google.android.gms.measurement.internal.zzkk.zzz(r9, r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk r13 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r13 = r2.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r13 = (com.google.android.gms.internal.measurement.zzdc) r13     // Catch:{ all -> 0x0d54 }
            r14 = r24
            com.google.android.gms.internal.measurement.zzdg r13 = com.google.android.gms.measurement.internal.zzkk.zzz(r13, r14)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk r15 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r15)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r15 = r2.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r15 = (com.google.android.gms.internal.measurement.zzdc) r15     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = "_si"
            com.google.android.gms.internal.measurement.zzdg r7 = com.google.android.gms.measurement.internal.zzkk.zzz(r15, r7)     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x05de
            java.lang.String r9 = r9.zzd()     // Catch:{ all -> 0x0d54 }
            goto L_0x05e0
        L_0x05de:
            java.lang.String r9 = ""
        L_0x05e0:
            boolean r15 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0d54 }
            if (r15 != 0) goto L_0x05ee
            com.google.android.gms.measurement.internal.zzkk r15 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r15)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r3, r11, r9)     // Catch:{ all -> 0x0d54 }
        L_0x05ee:
            if (r13 == 0) goto L_0x05f5
            java.lang.String r9 = r13.zzd()     // Catch:{ all -> 0x0d54 }
            goto L_0x05f7
        L_0x05f5:
            java.lang.String r9 = ""
        L_0x05f7:
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0d54 }
            if (r13 != 0) goto L_0x0605
            com.google.android.gms.measurement.internal.zzkk r13 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r3, r14, r9)     // Catch:{ all -> 0x0d54 }
        L_0x0605:
            if (r7 == 0) goto L_0x0619
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = "_si"
            long r24 = r7.zzf()     // Catch:{ all -> 0x0d54 }
            java.lang.Long r7 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r3, r9, r7)     // Catch:{ all -> 0x0d54 }
        L_0x0619:
            r5.zze(r8, r2)     // Catch:{ all -> 0x0d54 }
            r18 = 0
        L_0x061e:
            if (r16 != 0) goto L_0x067b
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x067b
            int r2 = r3.zzb()     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x0648
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzdk r7 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x0d54 }
            r2.zzb(r4, r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x067b
        L_0x0648:
            com.google.android.gms.measurement.internal.zzkk r2 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r2 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r2 = (com.google.android.gms.internal.measurement.zzdc) r2     // Catch:{ all -> 0x0d54 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkk.zzA(r2, r10)     // Catch:{ all -> 0x0d54 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0d54 }
            if (r2 != 0) goto L_0x0673
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzdk r7 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x0d54 }
            r2.zzb(r4, r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x067b
        L_0x0673:
            long r9 = r2.longValue()     // Catch:{ all -> 0x0d54 }
            long r9 = r31 + r9
            r31 = r9
        L_0x067b:
            java.util.List<com.google.android.gms.internal.measurement.zzdc> r2 = r6.zzc     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r4 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r4 = (com.google.android.gms.internal.measurement.zzdc) r4     // Catch:{ all -> 0x0d54 }
            r7 = r28
            r2.set(r7, r4)     // Catch:{ all -> 0x0d54 }
            int r17 = r17 + 1
            r5.zzf(r3)     // Catch:{ all -> 0x0d54 }
            r10 = r12
        L_0x068e:
            int r13 = r7 + 1
            r7 = r5
            r3 = r11
            r2 = r14
            r9 = r16
            r4 = r23
            r5 = r30
            r15 = r31
            r14 = 0
            goto L_0x005a
        L_0x069e:
            r5 = r7
            r10 = r14
            r31 = r15
            r16 = r9
            if (r16 == 0) goto L_0x06ff
            r3 = r17
            r15 = r31
            r2 = 0
        L_0x06ab:
            if (r2 >= r3) goto L_0x06fd
            com.google.android.gms.internal.measurement.zzdc r7 = r5.zzd(r2)     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0d54 }
            boolean r8 = r4.equals(r8)     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x06ce
            com.google.android.gms.measurement.internal.zzkk r8 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r8)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r8 = com.google.android.gms.measurement.internal.zzkk.zzz(r7, r12)     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x06ce
            r5.zzi(r2)     // Catch:{ all -> 0x0d54 }
            int r3 = r3 + -1
            int r2 = r2 + -1
            goto L_0x06fa
        L_0x06ce:
            com.google.android.gms.measurement.internal.zzkk r8 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r8)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r7 = com.google.android.gms.measurement.internal.zzkk.zzz(r7, r10)     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x06fa
            boolean r8 = r7.zze()     // Catch:{ all -> 0x0d54 }
            if (r8 == 0) goto L_0x06e8
            long r7 = r7.zzf()     // Catch:{ all -> 0x0d54 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x06e9
        L_0x06e8:
            r7 = 0
        L_0x06e9:
            if (r7 == 0) goto L_0x06fa
            long r8 = r7.longValue()     // Catch:{ all -> 0x0d54 }
            r13 = 0
            int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x06fa
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d54 }
            long r15 = r15 + r7
        L_0x06fa:
            r7 = 1
            int r2 = r2 + r7
            goto L_0x06ab
        L_0x06fd:
            r2 = r15
            goto L_0x0701
        L_0x06ff:
            r2 = r31
        L_0x0701:
            r4 = 0
            r1.zzac(r5, r2, r4)     // Catch:{ all -> 0x0d54 }
            java.util.List r4 = r5.zzb()     // Catch:{ all -> 0x0d54 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0d54 }
        L_0x070d:
            boolean r7 = r4.hasNext()     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = "_se"
            if (r7 == 0) goto L_0x0733
            java.lang.String r7 = "_s"
            java.lang.Object r9 = r4.next()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r9.zzd()     // Catch:{ all -> 0x0d54 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x070d
            com.google.android.gms.measurement.internal.zzai r4 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r4)     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r5.zzG()     // Catch:{ all -> 0x0d54 }
            r4.zzi(r7, r8)     // Catch:{ all -> 0x0d54 }
        L_0x0733:
            java.lang.String r4 = "_sid"
            int r4 = com.google.android.gms.measurement.internal.zzkk.zzu(r5, r4)     // Catch:{ all -> 0x0d54 }
            if (r4 < 0) goto L_0x0740
            r4 = 1
            r1.zzac(r5, r2, r4)     // Catch:{ all -> 0x0d54 }
            goto L_0x0760
        L_0x0740:
            int r2 = com.google.android.gms.measurement.internal.zzkk.zzu(r5, r8)     // Catch:{ all -> 0x0d54 }
            if (r2 < 0) goto L_0x0760
            r5.zzq(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r2 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0d54 }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzdk r4 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r4)     // Catch:{ all -> 0x0d54 }
            r2.zzb(r3, r4)     // Catch:{ all -> 0x0d54 }
        L_0x0760:
            com.google.android.gms.measurement.internal.zzkk r2 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfp r3 = r2.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "Checking account type status for ad personalization signals"
            r3.zza(r4)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzki r3 = r2.zzf     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfg r3 = r3.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r3)     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = r5.zzG()     // Catch:{ all -> 0x0d54 }
            boolean r3 = r3.zzf(r4)     // Catch:{ all -> 0x0d54 }
            if (r3 == 0) goto L_0x07f7
            com.google.android.gms.measurement.internal.zzki r3 = r2.zzf     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r3 = r3.zze     // Catch:{ all -> 0x0d54 }
            zzal(r3)     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = r5.zzG()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzs(r4)     // Catch:{ all -> 0x0d54 }
            if (r3 == 0) goto L_0x07f7
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0d54 }
            if (r3 == 0) goto L_0x07f7
            com.google.android.gms.measurement.internal.zzfp r3 = r2.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzz()     // Catch:{ all -> 0x0d54 }
            boolean r3 = r3.zzf()     // Catch:{ all -> 0x0d54 }
            if (r3 == 0) goto L_0x07f7
            com.google.android.gms.measurement.internal.zzfp r3 = r2.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzj()     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "Turning off ad personalization due to account type"
            r3.zza(r4)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdu r3 = com.google.android.gms.internal.measurement.zzdv.zzj()     // Catch:{ all -> 0x0d54 }
            r4 = r23
            r3.zzb(r4)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzam r2 = r2.zzz()     // Catch:{ all -> 0x0d54 }
            long r7 = r2.zzd()     // Catch:{ all -> 0x0d54 }
            r3.zza(r7)     // Catch:{ all -> 0x0d54 }
            r7 = 1
            r3.zze(r7)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r2 = r3.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdv r2 = (com.google.android.gms.internal.measurement.zzdv) r2     // Catch:{ all -> 0x0d54 }
            r3 = 0
        L_0x07d9:
            int r7 = r5.zzk()     // Catch:{ all -> 0x0d54 }
            if (r3 >= r7) goto L_0x07f4
            com.google.android.gms.internal.measurement.zzdv r7 = r5.zzl(r3)     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0d54 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x0d54 }
            if (r7 == 0) goto L_0x07f1
            r5.zzm(r3, r2)     // Catch:{ all -> 0x0d54 }
            goto L_0x07f7
        L_0x07f1:
            int r3 = r3 + 1
            goto L_0x07d9
        L_0x07f4:
            r5.zzn(r2)     // Catch:{ all -> 0x0d54 }
        L_0x07f7:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5.zzt(r2)     // Catch:{ all -> 0x0d54 }
            r2 = -9223372036854775808
            r5.zzv(r2)     // Catch:{ all -> 0x0d54 }
            r2 = 0
        L_0x0805:
            int r3 = r5.zzc()     // Catch:{ all -> 0x0d54 }
            if (r2 >= r3) goto L_0x0838
            com.google.android.gms.internal.measurement.zzdc r3 = r5.zzd(r2)     // Catch:{ all -> 0x0d54 }
            long r7 = r3.zzf()     // Catch:{ all -> 0x0d54 }
            long r9 = r5.zzs()     // Catch:{ all -> 0x0d54 }
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0822
            long r7 = r3.zzf()     // Catch:{ all -> 0x0d54 }
            r5.zzt(r7)     // Catch:{ all -> 0x0d54 }
        L_0x0822:
            long r7 = r3.zzf()     // Catch:{ all -> 0x0d54 }
            long r9 = r5.zzu()     // Catch:{ all -> 0x0d54 }
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0835
            long r3 = r3.zzf()     // Catch:{ all -> 0x0d54 }
            r5.zzv(r3)     // Catch:{ all -> 0x0d54 }
        L_0x0835:
            int r2 = r2 + 1
            goto L_0x0805
        L_0x0838:
            r5.zzac()     // Catch:{ all -> 0x0d54 }
            r5.zzZ()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzy r7 = r1.zzh     // Catch:{ all -> 0x0d54 }
            zzal(r7)     // Catch:{ all -> 0x0d54 }
            java.lang.String r8 = r5.zzG()     // Catch:{ all -> 0x0d54 }
            java.util.List r9 = r5.zzb()     // Catch:{ all -> 0x0d54 }
            java.util.List r10 = r5.zzj()     // Catch:{ all -> 0x0d54 }
            long r2 = r5.zzs()     // Catch:{ all -> 0x0d54 }
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d54 }
            long r2 = r5.zzu()     // Catch:{ all -> 0x0d54 }
            java.lang.Long r12 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d54 }
            java.util.List r2 = r7.zzb(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0d54 }
            r5.zzY(r2)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzae r2 = r45.zzd()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r3 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0d54 }
            boolean r2 = r2.zzx(r3)     // Catch:{ all -> 0x0d54 }
            if (r2 == 0) goto L_0x0bae
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0d54 }
            r2.<init>()     // Catch:{ all -> 0x0d54 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0d54 }
            r3.<init>()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkp r4 = r45.zzq()     // Catch:{ all -> 0x0d54 }
            java.security.SecureRandom r4 = r4.zzf()     // Catch:{ all -> 0x0d54 }
            r7 = 0
        L_0x0889:
            int r8 = r5.zzc()     // Catch:{ all -> 0x0d54 }
            if (r7 >= r8) goto L_0x0b75
            com.google.android.gms.internal.measurement.zzdc r8 = r5.zzd(r7)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhn r8 = r8.zzbu()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdb r8 = (com.google.android.gms.internal.measurement.zzdb) r8     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0d54 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0929
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzkk.zzA(r9, r11)     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0d54 }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r11 = (com.google.android.gms.measurement.internal.zzao) r11     // Catch:{ all -> 0x0d54 }
            if (r11 != 0) goto L_0x08dc
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r12 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0d54 }
            r13 = r9
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzf(r12, r13)     // Catch:{ all -> 0x0d54 }
            if (r11 == 0) goto L_0x08dc
            r2.put(r9, r11)     // Catch:{ all -> 0x0d54 }
        L_0x08dc:
            if (r11 == 0) goto L_0x091d
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0d54 }
            if (r9 != 0) goto L_0x091d
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x08fa
            long r12 = r9.longValue()     // Catch:{ all -> 0x0d54 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x08fa
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r8, r10, r9)     // Catch:{ all -> 0x0d54 }
        L_0x08fa:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x0914
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x0914
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r8, r9, r12)     // Catch:{ all -> 0x0d54 }
        L_0x0914:
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r3.add(r9)     // Catch:{ all -> 0x0d54 }
        L_0x091d:
            r5.zze(r7, r8)     // Catch:{ all -> 0x0d54 }
        L_0x0920:
            r16 = r4
            r4 = r5
            r20 = r6
            r5 = 1
            goto L_0x0b6c
        L_0x0929:
            com.google.android.gms.measurement.internal.zzfg r9 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r11 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = r11.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r12 = r9.zza(r11, r12)     // Catch:{ all -> 0x0d54 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0d54 }
            if (r13 != 0) goto L_0x095a
            long r11 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0945 }
            goto L_0x095c
        L_0x0945:
            r0 = move-exception
            r12 = r0
            com.google.android.gms.measurement.internal.zzfp r9 = r9.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = "Unable to parse timezone offset. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzem.zzl(r11)     // Catch:{ all -> 0x0d54 }
            r9.zzc(r13, r11, r12)     // Catch:{ all -> 0x0d54 }
        L_0x095a:
            r11 = 0
        L_0x095c:
            com.google.android.gms.measurement.internal.zzkp r9 = r45.zzq()     // Catch:{ all -> 0x0d54 }
            long r13 = r8.zzn()     // Catch:{ all -> 0x0d54 }
            long r13 = r9.zzab(r13, r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r17 = r11
            r15 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = "_dbg"
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0d54 }
            if (r15 != 0) goto L_0x09b2
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0d54 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0d54 }
        L_0x0986:
            boolean r15 = r9.hasNext()     // Catch:{ all -> 0x0d54 }
            if (r15 == 0) goto L_0x09b2
            java.lang.Object r15 = r9.next()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdg r15 = (com.google.android.gms.internal.measurement.zzdg) r15     // Catch:{ all -> 0x0d54 }
            r16 = r9
            java.lang.String r9 = r15.zzb()     // Catch:{ all -> 0x0d54 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x09af
            long r15 = r15.zzf()     // Catch:{ all -> 0x0d54 }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0d54 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0d54 }
            if (r9 != 0) goto L_0x09ad
            goto L_0x09b2
        L_0x09ad:
            r9 = 1
            goto L_0x09c5
        L_0x09af:
            r9 = r16
            goto L_0x0986
        L_0x09b2:
            com.google.android.gms.measurement.internal.zzfg r9 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r11 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = r11.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            int r9 = r9.zzk(r11, r12)     // Catch:{ all -> 0x0d54 }
        L_0x09c5:
            if (r9 > 0) goto L_0x09ea
            com.google.android.gms.measurement.internal.zzem r10 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r10 = r10.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0d54 }
            r10.zzc(r11, r12, r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r3.add(r9)     // Catch:{ all -> 0x0d54 }
            r5.zze(r7, r8)     // Catch:{ all -> 0x0d54 }
            goto L_0x0920
        L_0x09ea:
            java.lang.String r11 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r11 = (com.google.android.gms.measurement.internal.zzao) r11     // Catch:{ all -> 0x0d54 }
            if (r11 != 0) goto L_0x0a4a
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r12 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r15 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzf(r12, r15)     // Catch:{ all -> 0x0d54 }
            if (r11 != 0) goto L_0x0a4a
            com.google.android.gms.measurement.internal.zzem r11 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r11 = r11.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzdk r15 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r15 = r15.zzA()     // Catch:{ all -> 0x0d54 }
            r20 = r13
            java.lang.String r13 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            r11.zzc(r12, r15, r13)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r11 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r12 = r6.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r29 = r12.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.String r30 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            r31 = 1
            r33 = 1
            r35 = 1
            long r37 = r8.zzn()     // Catch:{ all -> 0x0d54 }
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r28 = r11
            r28.<init>(r29, r30, r31, r33, r35, r37, r39, r41, r42, r43, r44)     // Catch:{ all -> 0x0d54 }
            goto L_0x0a4c
        L_0x0a4a:
            r20 = r13
        L_0x0a4c:
            com.google.android.gms.measurement.internal.zzkk r12 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r12)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r12 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r12 = (com.google.android.gms.internal.measurement.zzdc) r12     // Catch:{ all -> 0x0d54 }
            java.lang.String r13 = "_eid"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzkk.zzA(r12, r13)     // Catch:{ all -> 0x0d54 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0d54 }
            if (r12 == 0) goto L_0x0a63
            r13 = 1
            goto L_0x0a64
        L_0x0a63:
            r13 = 0
        L_0x0a64:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0d54 }
            r14 = 1
            if (r9 != r14) goto L_0x0a97
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r3.add(r9)     // Catch:{ all -> 0x0d54 }
            boolean r9 = r13.booleanValue()     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x0a92
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0d54 }
            if (r9 != 0) goto L_0x0a86
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0d54 }
            if (r9 != 0) goto L_0x0a86
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x0a92
        L_0x0a86:
            r9 = 0
            com.google.android.gms.measurement.internal.zzao r10 = r11.zzc(r9, r9, r9)     // Catch:{ all -> 0x0d54 }
            java.lang.String r9 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0d54 }
        L_0x0a92:
            r5.zze(r7, r8)     // Catch:{ all -> 0x0d54 }
            goto L_0x0920
        L_0x0a97:
            int r14 = r4.nextInt(r9)     // Catch:{ all -> 0x0d54 }
            if (r14 != 0) goto L_0x0ad8
            com.google.android.gms.measurement.internal.zzkk r12 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r12)     // Catch:{ all -> 0x0d54 }
            long r14 = (long) r9     // Catch:{ all -> 0x0d54 }
            java.lang.Long r9 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r8, r10, r9)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r10 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r10 = (com.google.android.gms.internal.measurement.zzdc) r10     // Catch:{ all -> 0x0d54 }
            r3.add(r10)     // Catch:{ all -> 0x0d54 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0d54 }
            if (r10 == 0) goto L_0x0abe
            r10 = 0
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzc(r10, r9, r10)     // Catch:{ all -> 0x0d54 }
        L_0x0abe:
            java.lang.String r9 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            long r12 = r8.zzn()     // Catch:{ all -> 0x0d54 }
            r14 = r20
            com.google.android.gms.measurement.internal.zzao r10 = r11.zzb(r12, r14)     // Catch:{ all -> 0x0d54 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0d54 }
            r16 = r4
            r4 = r5
            r20 = r6
            r5 = 1
            goto L_0x0b69
        L_0x0ad8:
            r16 = r4
            r14 = r20
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0d54 }
            if (r4 == 0) goto L_0x0aed
            long r17 = r4.longValue()     // Catch:{ all -> 0x0d54 }
            r33 = r5
            r20 = r6
            r23 = r11
            r21 = r12
            goto L_0x0b03
        L_0x0aed:
            com.google.android.gms.measurement.internal.zzkp r4 = r45.zzq()     // Catch:{ all -> 0x0d54 }
            r33 = r5
            r20 = r6
            long r5 = r8.zzp()     // Catch:{ all -> 0x0d54 }
            r23 = r11
            r21 = r12
            r11 = r17
            long r17 = r4.zzab(r5, r11)     // Catch:{ all -> 0x0d54 }
        L_0x0b03:
            int r4 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0b4f
            com.google.android.gms.measurement.internal.zzkk r4 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r4)     // Catch:{ all -> 0x0d54 }
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r8, r4, r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk r4 = r1.zzi     // Catch:{ all -> 0x0d54 }
            zzal(r4)     // Catch:{ all -> 0x0d54 }
            long r11 = (long) r9     // Catch:{ all -> 0x0d54 }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzkk.zzx(r8, r10, r4)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r9 = r8.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdc r9 = (com.google.android.gms.internal.measurement.zzdc) r9     // Catch:{ all -> 0x0d54 }
            r3.add(r9)     // Catch:{ all -> 0x0d54 }
            boolean r9 = r13.booleanValue()     // Catch:{ all -> 0x0d54 }
            if (r9 == 0) goto L_0x0b3d
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0d54 }
            r11 = r23
            r10 = 0
            com.google.android.gms.measurement.internal.zzao r11 = r11.zzc(r10, r4, r9)     // Catch:{ all -> 0x0d54 }
            goto L_0x0b3f
        L_0x0b3d:
            r11 = r23
        L_0x0b3f:
            java.lang.String r4 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            long r9 = r8.zzn()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r9 = r11.zzb(r9, r14)     // Catch:{ all -> 0x0d54 }
            r2.put(r4, r9)     // Catch:{ all -> 0x0d54 }
            goto L_0x0b67
        L_0x0b4f:
            r11 = r23
            r5 = 1
            boolean r4 = r13.booleanValue()     // Catch:{ all -> 0x0d54 }
            if (r4 == 0) goto L_0x0b67
            java.lang.String r4 = r8.zzk()     // Catch:{ all -> 0x0d54 }
            r12 = r21
            r9 = 0
            com.google.android.gms.measurement.internal.zzao r10 = r11.zzc(r12, r9, r9)     // Catch:{ all -> 0x0d54 }
            r2.put(r4, r10)     // Catch:{ all -> 0x0d54 }
        L_0x0b67:
            r4 = r33
        L_0x0b69:
            r4.zze(r7, r8)     // Catch:{ all -> 0x0d54 }
        L_0x0b6c:
            int r7 = r7 + 1
            r5 = r4
            r4 = r16
            r6 = r20
            goto L_0x0889
        L_0x0b75:
            r4 = r5
            r20 = r6
            int r5 = r3.size()     // Catch:{ all -> 0x0d54 }
            int r6 = r4.zzc()     // Catch:{ all -> 0x0d54 }
            if (r5 >= r6) goto L_0x0b88
            r4.zzh()     // Catch:{ all -> 0x0d54 }
            r4.zzg(r3)     // Catch:{ all -> 0x0d54 }
        L_0x0b88:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0d54 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0d54 }
        L_0x0b90:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0d54 }
            if (r3 == 0) goto L_0x0bab
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0d54 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r5 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r5)     // Catch:{ all -> 0x0d54 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzao r3 = (com.google.android.gms.measurement.internal.zzao) r3     // Catch:{ all -> 0x0d54 }
            r5.zzh(r3)     // Catch:{ all -> 0x0d54 }
            goto L_0x0b90
        L_0x0bab:
            r2 = r20
            goto L_0x0bb0
        L_0x0bae:
            r4 = r5
            r2 = r6
        L_0x0bb0:
            com.google.android.gms.internal.measurement.zzdk r3 = r2.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r5 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r5)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzg r5 = r5.zzs(r3)     // Catch:{ all -> 0x0d54 }
            if (r5 != 0) goto L_0x0bd9
            com.google.android.gms.measurement.internal.zzem r5 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzdk r7 = r2.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x0d54 }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d54 }
            goto L_0x0c35
        L_0x0bd9:
            int r6 = r4.zzc()     // Catch:{ all -> 0x0d54 }
            if (r6 <= 0) goto L_0x0c35
            long r6 = r5.zzr()     // Catch:{ all -> 0x0d54 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0bed
            r4.zzy(r6)     // Catch:{ all -> 0x0d54 }
            goto L_0x0bf0
        L_0x0bed:
            r4.zzz()     // Catch:{ all -> 0x0d54 }
        L_0x0bf0:
            long r8 = r5.zzp()     // Catch:{ all -> 0x0d54 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0bfb
            goto L_0x0bfc
        L_0x0bfb:
            r6 = r8
        L_0x0bfc:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0c04
            r4.zzw(r6)     // Catch:{ all -> 0x0d54 }
            goto L_0x0c07
        L_0x0c04:
            r4.zzx()     // Catch:{ all -> 0x0d54 }
        L_0x0c07:
            r5.zzN()     // Catch:{ all -> 0x0d54 }
            long r6 = r5.zzI()     // Catch:{ all -> 0x0d54 }
            int r7 = (int) r6     // Catch:{ all -> 0x0d54 }
            r4.zzS(r7)     // Catch:{ all -> 0x0d54 }
            long r6 = r4.zzs()     // Catch:{ all -> 0x0d54 }
            r5.zzq(r6)     // Catch:{ all -> 0x0d54 }
            long r6 = r4.zzu()     // Catch:{ all -> 0x0d54 }
            r5.zzs(r6)     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = r5.zzab()     // Catch:{ all -> 0x0d54 }
            if (r6 == 0) goto L_0x0c2a
            r4.zzT(r6)     // Catch:{ all -> 0x0d54 }
            goto L_0x0c2d
        L_0x0c2a:
            r4.zzU()     // Catch:{ all -> 0x0d54 }
        L_0x0c2d:
            com.google.android.gms.measurement.internal.zzai r6 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r6)     // Catch:{ all -> 0x0d54 }
            r6.zzt(r5)     // Catch:{ all -> 0x0d54 }
        L_0x0c35:
            int r5 = r4.zzc()     // Catch:{ all -> 0x0d54 }
            if (r5 <= 0) goto L_0x0c99
            com.google.android.gms.measurement.internal.zzfp r5 = r1.zzm     // Catch:{ all -> 0x0d54 }
            r5.zzat()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzfg r5 = r1.zzc     // Catch:{ all -> 0x0d54 }
            zzal(r5)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r6 = r2.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = r6.zzA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzcq r5 = r5.zzb(r6)     // Catch:{ all -> 0x0d54 }
            if (r5 == 0) goto L_0x0c60
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0d54 }
            if (r6 != 0) goto L_0x0c58
            goto L_0x0c60
        L_0x0c58:
            long r5 = r5.zzb()     // Catch:{ all -> 0x0d54 }
            r4.zzad(r5)     // Catch:{ all -> 0x0d54 }
            goto L_0x0c89
        L_0x0c60:
            com.google.android.gms.internal.measurement.zzdk r5 = r2.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r5 = r5.zzP()     // Catch:{ all -> 0x0d54 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0d54 }
            if (r5 == 0) goto L_0x0c72
            r5 = -1
            r4.zzad(r5)     // Catch:{ all -> 0x0d54 }
            goto L_0x0c89
        L_0x0c72:
            com.google.android.gms.measurement.internal.zzem r5 = r45.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzdk r7 = r2.zza     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0d54 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x0d54 }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d54 }
        L_0x0c89:
            com.google.android.gms.measurement.internal.zzai r5 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r5)     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzhr r4 = r4.zzaA()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.internal.measurement.zzdk r4 = (com.google.android.gms.internal.measurement.zzdk) r4     // Catch:{ all -> 0x0d54 }
            r8 = r19
            r5.zzx(r4, r8)     // Catch:{ all -> 0x0d54 }
        L_0x0c99:
            com.google.android.gms.measurement.internal.zzai r4 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r4)     // Catch:{ all -> 0x0d54 }
            java.util.List<java.lang.Long> r2 = r2.zzb     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0d54 }
            r4.zzg()     // Catch:{ all -> 0x0d54 }
            r4.zzZ()     // Catch:{ all -> 0x0d54 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d54 }
            r6 = 0
        L_0x0cb1:
            int r7 = r2.size()     // Catch:{ all -> 0x0d54 }
            if (r6 >= r7) goto L_0x0cce
            if (r6 == 0) goto L_0x0cbe
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d54 }
        L_0x0cbe:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0d54 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d54 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d54 }
            r5.append(r7)     // Catch:{ all -> 0x0d54 }
            int r6 = r6 + 1
            goto L_0x0cb1
        L_0x0cce:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d54 }
            android.database.sqlite.SQLiteDatabase r6 = r4.zze()     // Catch:{ all -> 0x0d54 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d54 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d54 }
            int r6 = r2.size()     // Catch:{ all -> 0x0d54 }
            if (r5 == r6) goto L_0x0d03
            com.google.android.gms.measurement.internal.zzfp r4 = r4.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ all -> 0x0d54 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d54 }
            int r2 = r2.size()     // Catch:{ all -> 0x0d54 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d54 }
            r4.zzc(r6, r5, r2)     // Catch:{ all -> 0x0d54 }
        L_0x0d03:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            android.database.sqlite.SQLiteDatabase r4 = r2.zze()     // Catch:{ all -> 0x0d54 }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0d1b }
            r6 = 0
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0d1b }
            r6 = 1
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0d1b }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r4.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0d1b }
            goto L_0x0d30
        L_0x0d1b:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0d54 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0d54 }
            r2.zzc(r5, r3, r4)     // Catch:{ all -> 0x0d54 }
        L_0x0d30:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            r2.zzc()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            r2 = 1
            return r2
        L_0x0d42:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0d54 }
            zzal(r2)     // Catch:{ all -> 0x0d54 }
            r2.zzc()     // Catch:{ all -> 0x0d54 }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            r2 = 0
            return r2
        L_0x0d54:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzai r3 = r1.zze
            zzal(r3)
            r3.zzd()
            goto L_0x0d60
        L_0x0d5f:
            throw r2
        L_0x0d60:
            goto L_0x0d5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzab(java.lang.String, long):boolean");
    }

    private final void zzac(zzdj zzdj, long j, boolean z) {
        zzkn zzkn;
        String str = true != z ? "_lte" : "_se";
        zzai zzai = this.zze;
        zzal(zzai);
        zzkn zzk2 = zzai.zzk(zzdj.zzG(), str);
        if (zzk2 == null || zzk2.zze == null) {
            zzkn = new zzkn(zzdj.zzG(), "auto", str, zzay().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkn = new zzkn(zzdj.zzG(), "auto", str, zzay().currentTimeMillis(), Long.valueOf(((Long) zzk2.zze).longValue() + j));
        }
        zzdu zzj2 = zzdv.zzj();
        zzj2.zzb(str);
        zzj2.zza(zzay().currentTimeMillis());
        zzj2.zze(((Long) zzkn.zze).longValue());
        zzdv zzdv = (zzdv) zzj2.zzaA();
        int zzu2 = zzkk.zzu(zzdj, str);
        if (zzu2 >= 0) {
            zzdj.zzm(zzu2, zzdv);
        } else {
            zzdj.zzn(zzdv);
        }
        if (j > 0) {
            zzai zzai2 = this.zze;
            zzal(zzai2);
            zzai2.zzj(zzkn);
            zzau().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzkn.zze);
        }
    }

    private final boolean zzad(zzdb zzdb, zzdb zzdb2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzdb.zzk()));
        zzal(this.zzi);
        zzdg zzz2 = zzkk.zzz((zzdc) zzdb.zzaA(), "_sc");
        String str2 = null;
        if (zzz2 == null) {
            str = null;
        } else {
            str = zzz2.zzd();
        }
        zzal(this.zzi);
        zzdg zzz3 = zzkk.zzz((zzdc) zzdb2.zzaA(), "_pc");
        if (zzz3 != null) {
            str2 = zzz3.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzae(zzdb, zzdb2);
        return true;
    }

    private final void zzae(zzdb zzdb, zzdb zzdb2) {
        Preconditions.checkArgument("_e".equals(zzdb.zzk()));
        zzal(this.zzi);
        zzdg zzz2 = zzkk.zzz((zzdc) zzdb.zzaA(), "_et");
        if (zzz2 != null && zzz2.zze() && zzz2.zzf() > 0) {
            long zzf2 = zzz2.zzf();
            zzal(this.zzi);
            zzdg zzz3 = zzkk.zzz((zzdc) zzdb2.zzaA(), "_et");
            if (zzz3 != null && zzz3.zzf() > 0) {
                zzf2 += zzz3.zzf();
            }
            zzal(this.zzi);
            zzkk.zzx(zzdb2, "_et", Long.valueOf(zzf2));
            zzal(this.zzi);
            zzkk.zzx(zzdb, "_fr", 1L);
        }
    }

    private final boolean zzaf() {
        zzav().zzg();
        zzr();
        zzai zzai = this.zze;
        zzal(zzai);
        if (zzai.zzG()) {
            return true;
        }
        zzai zzai2 = this.zze;
        zzal(zzai2);
        return !TextUtils.isEmpty(zzai2.zzy());
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfm r1 = r20.zzav()
            r1.zzg()
            r20.zzr()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r20.zzay()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzem r3 = r20.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzk()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjx r1 = r0.zzg
            zzal(r1)
            r1.zzd()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfp r1 = r0.zzm
            boolean r1 = r1.zzL()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r20.zzaf()
            if (r1 != 0) goto L_0x005e
            goto L_0x0255
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzay()
            long r1 = r1.currentTimeMillis()
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzz
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzai r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzai r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzz()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzae r5 = r20.zzd()
            java.lang.String r5 = r5.zzu()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzu
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzt
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzs
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjg r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjg r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzai r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzD()
            com.google.android.gms.measurement.internal.zzai r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zzF()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018f
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzkk r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzq(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018f
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018f
            r1 = 0
        L_0x0152:
            r20.zzd()
            r2 = 20
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzea.zzB
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r11 = 0
            int r5 = java.lang.Math.max(r11, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x0114
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r2 = com.google.android.gms.measurement.internal.zzea.zzA
            java.lang.Object r2 = r2.zzb(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            r12 = 1
            long r12 = r12 << r1
            long r5 = r5 * r12
            long r7 = r7 + r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018f
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018f:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0238
            com.google.android.gms.measurement.internal.zzes r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zzb()
            if (r1 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzjg r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzq
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkk r9 = r0.zzi
            zzal(r9)
            boolean r9 = r9.zzq(r1, r5)
            if (r9 != 0) goto L_0x01ca
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.common.util.Clock r1 = r20.zzay()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0201
            r20.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzea.zzv
            r2 = 0
            java.lang.Object r1 = r1.zzb(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjg r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzay()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0201:
            com.google.android.gms.measurement.internal.zzem r1 = r20.zzau()
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzk()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzjx r1 = r0.zzg
            zzal(r1)
            r1.zzc(r7)
            return
        L_0x021b:
            com.google.android.gms.measurement.internal.zzem r1 = r20.zzau()
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzk()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzj()
            r1.zza()
            com.google.android.gms.measurement.internal.zzjx r1 = r0.zzg
            zzal(r1)
            r1.zzd()
            return
        L_0x0238:
            com.google.android.gms.measurement.internal.zzem r1 = r20.zzau()
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzk()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjx r1 = r0.zzg
            zzal(r1)
            r1.zzd()
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzem r1 = r20.zzau()
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzk()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzj()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjx r1 = r0.zzg
            zzal(r1)
            r1.zzd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzag():void");
    }

    private final void zzah() {
        zzav().zzg();
        if (this.zzs || this.zzt || this.zzu) {
            zzau().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu));
            return;
        }
        zzau().zzk().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzp;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            List<Runnable> list2 = this.zzp;
            Preconditions.checkNotNull(list2);
            list2.clear();
        }
    }

    private final Boolean zzai(zzg zzg2) {
        try {
            if (zzg2.zzv() != -2147483648L) {
                if (zzg2.zzv() == ((long) Wrappers.packageManager(this.zzm.zzax()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzm.zzax()).getPackageInfo(zzg2.zzc(), 0).versionName;
                String zzt2 = zzg2.zzt();
                if (zzt2 != null && zzt2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzp zzaj(String str) {
        String str2 = str;
        zzai zzai = this.zze;
        zzal(zzai);
        zzg zzs2 = zzai.zzs(str2);
        if (zzs2 == null || TextUtils.isEmpty(zzs2.zzt())) {
            zzau().zzj().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzai2 = zzai(zzs2);
        if (zzai2 == null || zzai2.booleanValue()) {
            String zzf2 = zzs2.zzf();
            String zzt2 = zzs2.zzt();
            long zzv2 = zzs2.zzv();
            String zzx2 = zzs2.zzx();
            long zzz2 = zzs2.zzz();
            long zzB2 = zzs2.zzB();
            boolean zzF = zzs2.zzF();
            String zzn2 = zzs2.zzn();
            long zzad = zzs2.zzad();
            boolean zzaf = zzs2.zzaf();
            String zzh2 = zzs2.zzh();
            Boolean zzah = zzs2.zzah();
            long zzD = zzs2.zzD();
            List<String> zzaj = zzs2.zzaj();
            zzmg.zzb();
            String zzj2 = zzd().zzn(str2, zzea.zzag) ? zzs2.zzj() : null;
            zzlf.zzb();
            return new zzp(str, zzf2, zzt2, zzv2, zzx2, zzz2, zzB2, (String) null, zzF, false, zzn2, zzad, 0, 0, zzaf, false, zzh2, zzah, zzD, zzaj, zzj2, zzd().zzn((String) null, zzea.zzaw) ? zzt(str).zzd() : "");
        }
        zzau().zzb().zzb("App version does not match; dropping. appId", zzem.zzl(str));
        return null;
    }

    private final boolean zzak(zzp zzp2) {
        zzmg.zzb();
        return zzd().zzn(zzp2.zza, zzea.zzag) ? !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzu) || !TextUtils.isEmpty(zzp2.zzq) : !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzq);
    }

    private static final zzjz zzal(zzjz zzjz) {
        if (zzjz == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzjz.zzY()) {
            return zzjz;
        } else {
            String valueOf = String.valueOf(zzjz.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzA(zzaf zzaf) {
        zzlf.zzb();
        if (!zzd().zzn((String) null, zzea.zzaw) || zzaf.zzh()) {
            return zzB();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zzB() {
        byte[] bArr = new byte[16];
        zzq().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v17, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:223|224) */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        zzau().zzb().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzem.zzl(r6), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0523, code lost:
        if (r4 != null) goto L_0x0525;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        r4.close();
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x052e, code lost:
        if (r4 != null) goto L_0x0525;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0546, code lost:
        if (r4 != null) goto L_0x0525;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x054d, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x055d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x054f, code lost:
        r0 = r1.zze;
        zzal(r0);
        r0 = r0.zzs(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0558, code lost:
        if (r0 == null) goto L_0x055d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x055a, code lost:
        zzE(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzz = r7;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:223:0x04c8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029b A[SYNTHETIC, Splitter:B:146:0x029b] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a4 A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x035b A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0377 A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0388 A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x041e A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x042e A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x045c A[Catch:{ MalformedURLException -> 0x04c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x046a A[Catch:{ MalformedURLException -> 0x04c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x047c A[Catch:{ MalformedURLException -> 0x04c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x04df A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0566 A[SYNTHETIC, Splitter:B:261:0x0566] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ all -> 0x0130, all -> 0x056a }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:143:0x0282=Splitter:B:143:0x0282, B:238:0x0525=Splitter:B:238:0x0525, B:251:0x0549=Splitter:B:251:0x0549, B:48:0x010a=Splitter:B:48:0x010a, B:214:0x044a=Splitter:B:214:0x044a, B:57:0x011b=Splitter:B:57:0x011b, B:60:0x012d=Splitter:B:60:0x012d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfm r0 = r22.zzav()
            r0.zzg()
            r22.zzr()
            r2 = 1
            r1.zzu = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ all -> 0x056a }
            r0.zzat()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzjf r0 = r0.zzy()     // Catch:{ all -> 0x056a }
            java.lang.Boolean r0 = r0.zzC()     // Catch:{ all -> 0x056a }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x056a }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x056a }
            r1.zzu = r3
        L_0x0030:
            r22.zzah()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x056a }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ all -> 0x056a }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x056a }
            r1.zzu = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x056a }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzag()     // Catch:{ all -> 0x056a }
            r1.zzu = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfm r0 = r22.zzav()     // Catch:{ all -> 0x056a }
            r0.zzg()     // Catch:{ all -> 0x056a }
            java.util.List<java.lang.Long> r0 = r1.zzx     // Catch:{ all -> 0x056a }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()     // Catch:{ all -> 0x056a }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x056a }
            r1.zzu = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzes r0 = r1.zzd     // Catch:{ all -> 0x056a }
            zzal(r0)     // Catch:{ all -> 0x056a }
            boolean r0 = r0.zzb()     // Catch:{ all -> 0x056a }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()     // Catch:{ all -> 0x056a }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x056a }
            r22.zzag()     // Catch:{ all -> 0x056a }
            r1.zzu = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzay()     // Catch:{ all -> 0x056a }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r0 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzea.zzP     // Catch:{ all -> 0x056a }
            r9 = 0
            int r0 = r0.zzk(r9, r8)     // Catch:{ all -> 0x056a }
            r22.zzd()     // Catch:{ all -> 0x056a }
            long r10 = com.google.android.gms.measurement.internal.zzae.zzz()     // Catch:{ all -> 0x056a }
            long r10 = r4 - r10
            r8 = 0
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzab(r9, r10)     // Catch:{ all -> 0x056a }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzjg r0 = r1.zzk     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzc     // Catch:{ all -> 0x056a }
            long r10 = r0.zza()     // Catch:{ all -> 0x056a }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ all -> 0x056a }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x056a }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x056a }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x056a }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x056a }
            zzal(r0)     // Catch:{ all -> 0x056a }
            java.lang.String r6 = r0.zzy()     // Catch:{ all -> 0x056a }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x056a }
            r7 = -1
            if (r0 != 0) goto L_0x04e3
            long r10 = r1.zzz     // Catch:{ all -> 0x056a }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzai r10 = r1.zze     // Catch:{ all -> 0x056a }
            zzal(r10)     // Catch:{ all -> 0x056a }
            android.database.sqlite.SQLiteDatabase r0 = r10.zze()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0115 }
            if (r0 != 0) goto L_0x010e
            if (r11 == 0) goto L_0x012d
        L_0x010a:
            r11.close()     // Catch:{ all -> 0x056a }
            goto L_0x012d
        L_0x010e:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0115 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            r0 = move-exception
            r11 = r9
        L_0x011b:
            com.google.android.gms.measurement.internal.zzfp r10 = r10.zzs     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzau()     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzek r10 = r10.zzb()     // Catch:{ all -> 0x0130 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x012d:
            r1.zzz = r7     // Catch:{ all -> 0x056a }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            r9 = r11
        L_0x0132:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ all -> 0x056a }
        L_0x0137:
            throw r0     // Catch:{ all -> 0x056a }
        L_0x0138:
            com.google.android.gms.measurement.internal.zzae r0 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzea.zzf     // Catch:{ all -> 0x056a }
            int r0 = r0.zzk(r6, r7)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r7 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzea.zzg     // Catch:{ all -> 0x056a }
            int r7 = r7.zzk(r6, r8)     // Catch:{ all -> 0x056a }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zze     // Catch:{ all -> 0x056a }
            zzal(r8)     // Catch:{ all -> 0x056a }
            r8.zzg()     // Catch:{ all -> 0x056a }
            r8.zzZ()     // Catch:{ all -> 0x056a }
            if (r0 <= 0) goto L_0x015f
            r10 = 1
            goto L_0x0160
        L_0x015f:
            r10 = 0
        L_0x0160:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x056a }
            if (r7 <= 0) goto L_0x0167
            r10 = 1
            goto L_0x0168
        L_0x0167:
            r10 = 0
        L_0x0168:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x056a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x056a }
            android.database.sqlite.SQLiteDatabase r11 = r8.zze()     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0276 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0276 }
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ all -> 0x056a }
        L_0x01a1:
            r20 = r4
            goto L_0x029e
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0276 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0276 }
            r13 = 0
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0276 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0247 }
            com.google.android.gms.measurement.internal.zzki r2 = r8.zzf     // Catch:{ IOException -> 0x0247 }
            com.google.android.gms.measurement.internal.zzkk r2 = r2.zzi     // Catch:{ IOException -> 0x0247 }
            zzal(r2)     // Catch:{ IOException -> 0x0247 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0232 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0232 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0232 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0232 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0232 }
            r3.<init>()     // Catch:{ IOException -> 0x0232 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0232 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0230 }
            if (r4 > 0) goto L_0x022b
            r0.close()     // Catch:{ IOException -> 0x0230 }
            r9.close()     // Catch:{ IOException -> 0x0230 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0230 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0274 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0274 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026d
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzdj r2 = com.google.android.gms.internal.measurement.zzdk.zzaj()     // Catch:{ IOException -> 0x0216 }
            com.google.android.gms.measurement.internal.zzkk.zzt(r2, r0)     // Catch:{ IOException -> 0x0216 }
            com.google.android.gms.internal.measurement.zzdj r2 = (com.google.android.gms.internal.measurement.zzdj) r2     // Catch:{ IOException -> 0x0216 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0274 }
            if (r4 != 0) goto L_0x0202
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzah(r4)     // Catch:{ SQLiteException -> 0x0274 }
        L_0x0202:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0274 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzhr r0 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.internal.measurement.zzdk r0 = (com.google.android.gms.internal.measurement.zzdk) r0     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0274 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0274 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0274 }
            goto L_0x025d
        L_0x0216:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r6)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0274 }
            goto L_0x025d
        L_0x022b:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0230 }
            goto L_0x01cf
        L_0x0230:
            r0 = move-exception
            goto L_0x0235
        L_0x0232:
            r0 = move-exception
            r20 = r4
        L_0x0235:
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ IOException -> 0x0245 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ IOException -> 0x0245 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ IOException -> 0x0245 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0245 }
            throw r0     // Catch:{ IOException -> 0x0245 }
        L_0x0245:
            r0 = move-exception
            goto L_0x024a
        L_0x0247:
            r0 = move-exception
            r20 = r4
        L_0x024a:
            com.google.android.gms.measurement.internal.zzfp r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r6)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0274 }
        L_0x025d:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0274 }
            if (r0 == 0) goto L_0x026d
            if (r13 <= r7) goto L_0x0266
            goto L_0x026d
        L_0x0266:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01ab
        L_0x026d:
            if (r11 == 0) goto L_0x0272
            r11.close()     // Catch:{ all -> 0x056a }
        L_0x0272:
            r0 = r12
            goto L_0x029e
        L_0x0274:
            r0 = move-exception
            goto L_0x0282
        L_0x0276:
            r0 = move-exception
            r20 = r4
            goto L_0x0282
        L_0x027a:
            r0 = move-exception
            r9 = 0
            goto L_0x04dd
        L_0x027e:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0282:
            com.google.android.gms.measurement.internal.zzfp r2 = r8.zzs     // Catch:{ all -> 0x04db }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x04db }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x04db }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r6)     // Catch:{ all -> 0x04db }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x04db }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04db }
            if (r11 == 0) goto L_0x029e
            r11.close()     // Catch:{ all -> 0x056a }
        L_0x029e:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x056a }
            if (r2 != 0) goto L_0x055d
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r2 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x056a }
            r4 = 0
            boolean r2 = r2.zzn(r4, r3)     // Catch:{ all -> 0x056a }
            if (r2 == 0) goto L_0x02be
            com.google.android.gms.measurement.internal.zzaf r2 = r1.zzt(r6)     // Catch:{ all -> 0x056a }
            boolean r2 = r2.zzf()     // Catch:{ all -> 0x056a }
            if (r2 == 0) goto L_0x0313
        L_0x02be:
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x056a }
        L_0x02c2:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x056a }
            if (r3 == 0) goto L_0x02e1
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x056a }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x056a }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdk r3 = (com.google.android.gms.internal.measurement.zzdk) r3     // Catch:{ all -> 0x056a }
            java.lang.String r4 = r3.zzG()     // Catch:{ all -> 0x056a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x056a }
            if (r4 != 0) goto L_0x02c2
            java.lang.String r2 = r3.zzG()     // Catch:{ all -> 0x056a }
            goto L_0x02e2
        L_0x02e1:
            r2 = 0
        L_0x02e2:
            if (r2 == 0) goto L_0x0313
            r3 = 0
        L_0x02e5:
            int r4 = r0.size()     // Catch:{ all -> 0x056a }
            if (r3 >= r4) goto L_0x0313
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x056a }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x056a }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdk r4 = (com.google.android.gms.internal.measurement.zzdk) r4     // Catch:{ all -> 0x056a }
            java.lang.String r5 = r4.zzG()     // Catch:{ all -> 0x056a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x056a }
            if (r5 == 0) goto L_0x0300
            goto L_0x0310
        L_0x0300:
            java.lang.String r4 = r4.zzG()     // Catch:{ all -> 0x056a }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x056a }
            if (r4 != 0) goto L_0x0310
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x056a }
            goto L_0x0313
        L_0x0310:
            int r3 = r3 + 1
            goto L_0x02e5
        L_0x0313:
            com.google.android.gms.internal.measurement.zzdh r2 = com.google.android.gms.internal.measurement.zzdi.zzc()     // Catch:{ all -> 0x056a }
            int r3 = r0.size()     // Catch:{ all -> 0x056a }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x056a }
            int r5 = r0.size()     // Catch:{ all -> 0x056a }
            r4.<init>(r5)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r5 = r22.zzd()     // Catch:{ all -> 0x056a }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x056a }
            if (r5 == 0) goto L_0x034a
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r5 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x056a }
            r8 = 0
            boolean r5 = r5.zzn(r8, r7)     // Catch:{ all -> 0x056a }
            if (r5 == 0) goto L_0x0348
            com.google.android.gms.measurement.internal.zzaf r5 = r1.zzt(r6)     // Catch:{ all -> 0x056a }
            boolean r5 = r5.zzf()     // Catch:{ all -> 0x056a }
            if (r5 == 0) goto L_0x034a
        L_0x0348:
            r5 = 1
            goto L_0x034b
        L_0x034a:
            r5 = 0
        L_0x034b:
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r7 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x056a }
            r9 = 0
            boolean r7 = r7.zzn(r9, r8)     // Catch:{ all -> 0x056a }
            if (r7 == 0) goto L_0x0368
            com.google.android.gms.measurement.internal.zzaf r7 = r1.zzt(r6)     // Catch:{ all -> 0x056a }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x056a }
            if (r7 == 0) goto L_0x0366
            goto L_0x0368
        L_0x0366:
            r7 = 0
            goto L_0x0369
        L_0x0368:
            r7 = 1
        L_0x0369:
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r9 = r22.zzd()     // Catch:{ all -> 0x056a }
            r10 = 0
            boolean r8 = r9.zzn(r10, r8)     // Catch:{ all -> 0x056a }
            if (r8 == 0) goto L_0x0384
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzt(r6)     // Catch:{ all -> 0x056a }
            boolean r8 = r8.zzh()     // Catch:{ all -> 0x056a }
            if (r8 == 0) goto L_0x0382
            goto L_0x0384
        L_0x0382:
            r8 = 0
            goto L_0x0385
        L_0x0384:
            r8 = 1
        L_0x0385:
            r9 = 0
        L_0x0386:
            if (r9 >= r3) goto L_0x040d
            java.lang.Object r10 = r0.get(r9)     // Catch:{ all -> 0x056a }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x056a }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdk r10 = (com.google.android.gms.internal.measurement.zzdk) r10     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzhn r10 = r10.zzbu()     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdj r10 = (com.google.android.gms.internal.measurement.zzdj) r10     // Catch:{ all -> 0x056a }
            java.lang.Object r11 = r0.get(r9)     // Catch:{ all -> 0x056a }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x056a }
            java.lang.Object r11 = r11.second     // Catch:{ all -> 0x056a }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x056a }
            r4.add(r11)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r11 = r22.zzd()     // Catch:{ all -> 0x056a }
            r11.zzf()     // Catch:{ all -> 0x056a }
            r11 = 39065(0x9899, double:1.93007E-319)
            r10.zzK(r11)     // Catch:{ all -> 0x056a }
            r11 = r20
            r10.zzr(r11)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzfp r13 = r1.zzm     // Catch:{ all -> 0x056a }
            r13.zzat()     // Catch:{ all -> 0x056a }
            r13 = 0
            r10.zzX(r13)     // Catch:{ all -> 0x056a }
            if (r5 != 0) goto L_0x03c5
            r10.zzag()     // Catch:{ all -> 0x056a }
        L_0x03c5:
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzae r13 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x056a }
            r15 = 0
            boolean r13 = r13.zzn(r15, r14)     // Catch:{ all -> 0x056a }
            if (r13 == 0) goto L_0x03e2
            if (r7 != 0) goto L_0x03dd
            r10.zzM()     // Catch:{ all -> 0x056a }
            r10.zzO()     // Catch:{ all -> 0x056a }
        L_0x03dd:
            if (r8 != 0) goto L_0x03e2
            r10.zzQ()     // Catch:{ all -> 0x056a }
        L_0x03e2:
            com.google.android.gms.measurement.internal.zzae r13 = r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzV     // Catch:{ all -> 0x056a }
            boolean r13 = r13.zzn(r6, r14)     // Catch:{ all -> 0x056a }
            if (r13 == 0) goto L_0x0404
            com.google.android.gms.internal.measurement.zzhr r13 = r10.zzaA()     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdk r13 = (com.google.android.gms.internal.measurement.zzdk) r13     // Catch:{ all -> 0x056a }
            byte[] r13 = r13.zzbp()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzkk r14 = r1.zzi     // Catch:{ all -> 0x056a }
            zzal(r14)     // Catch:{ all -> 0x056a }
            long r13 = r14.zzr(r13)     // Catch:{ all -> 0x056a }
            r10.zzam(r13)     // Catch:{ all -> 0x056a }
        L_0x0404:
            r2.zzb(r10)     // Catch:{ all -> 0x056a }
            int r9 = r9 + 1
            r20 = r11
            goto L_0x0386
        L_0x040d:
            r11 = r20
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            java.lang.String r0 = r0.zzn()     // Catch:{ all -> 0x056a }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x056a }
            if (r0 == 0) goto L_0x042e
            com.google.android.gms.measurement.internal.zzkk r0 = r1.zzi     // Catch:{ all -> 0x056a }
            zzal(r0)     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzhr r5 = r2.zzaA()     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdi r5 = (com.google.android.gms.internal.measurement.zzdi) r5     // Catch:{ all -> 0x056a }
            java.lang.String r0 = r0.zzh(r5)     // Catch:{ all -> 0x056a }
            goto L_0x042f
        L_0x042e:
            r0 = 0
        L_0x042f:
            com.google.android.gms.measurement.internal.zzkk r5 = r1.zzi     // Catch:{ all -> 0x056a }
            zzal(r5)     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzhr r5 = r2.zzaA()     // Catch:{ all -> 0x056a }
            com.google.android.gms.internal.measurement.zzdi r5 = (com.google.android.gms.internal.measurement.zzdi) r5     // Catch:{ all -> 0x056a }
            byte[] r14 = r5.zzbp()     // Catch:{ all -> 0x056a }
            r22.zzd()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.String> r5 = com.google.android.gms.measurement.internal.zzea.zzp     // Catch:{ all -> 0x056a }
            r9 = 0
            java.lang.Object r5 = r5.zzb(r9)     // Catch:{ all -> 0x056a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x056a }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04c8 }
            r13.<init>(r5)     // Catch:{ MalformedURLException -> 0x04c8 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04c8 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04c8 }
            java.util.List<java.lang.Long> r7 = r1.zzx     // Catch:{ MalformedURLException -> 0x04c8 }
            if (r7 == 0) goto L_0x046a
            com.google.android.gms.measurement.internal.zzem r4 = r22.zzau()     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ MalformedURLException -> 0x04c8 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04c8 }
            goto L_0x0471
        L_0x046a:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04c8 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04c8 }
            r1.zzx = r7     // Catch:{ MalformedURLException -> 0x04c8 }
        L_0x0471:
            com.google.android.gms.measurement.internal.zzjg r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04c8 }
            r4.zzb(r11)     // Catch:{ MalformedURLException -> 0x04c8 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x0485
            r3 = 0
            com.google.android.gms.internal.measurement.zzdk r2 = r2.zza(r3)     // Catch:{ MalformedURLException -> 0x04c8 }
            java.lang.String r4 = r2.zzA()     // Catch:{ MalformedURLException -> 0x04c8 }
        L_0x0485:
            com.google.android.gms.measurement.internal.zzem r2 = r22.zzau()     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()     // Catch:{ MalformedURLException -> 0x04c8 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04c8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04c8 }
            r2.zzd(r3, r4, r7, r0)     // Catch:{ MalformedURLException -> 0x04c8 }
            r2 = 1
            r1.zzt = r2     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzes r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x04c8 }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzkc r0 = new com.google.android.gms.measurement.internal.zzkc     // Catch:{ MalformedURLException -> 0x04c8 }
            r0.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04c8 }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04c8 }
            r11.zzZ()     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzfp r2 = r11.zzs     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzav()     // Catch:{ MalformedURLException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzer r3 = new com.google.android.gms.measurement.internal.zzer     // Catch:{ MalformedURLException -> 0x04c8 }
            r15 = 0
            r10 = r3
            r12 = r6
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04c8 }
            r2.zzk(r3)     // Catch:{ MalformedURLException -> 0x04c8 }
            goto L_0x055d
        L_0x04c8:
            com.google.android.gms.measurement.internal.zzem r0 = r22.zzau()     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ all -> 0x056a }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r6)     // Catch:{ all -> 0x056a }
            r0.zzc(r2, r3, r5)     // Catch:{ all -> 0x056a }
            goto L_0x055d
        L_0x04db:
            r0 = move-exception
            r9 = r11
        L_0x04dd:
            if (r9 == 0) goto L_0x04e2
            r9.close()     // Catch:{ all -> 0x056a }
        L_0x04e2:
            throw r0     // Catch:{ all -> 0x056a }
        L_0x04e3:
            r11 = r4
            r1.zzz = r7     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x056a }
            zzal(r2)     // Catch:{ all -> 0x056a }
            r22.zzd()     // Catch:{ all -> 0x056a }
            long r3 = com.google.android.gms.measurement.internal.zzae.zzz()     // Catch:{ all -> 0x056a }
            long r3 = r11 - r3
            r2.zzg()     // Catch:{ all -> 0x056a }
            r2.zzZ()     // Catch:{ all -> 0x056a }
            android.database.sqlite.SQLiteDatabase r0 = r2.zze()     // Catch:{ SQLiteException -> 0x0535, all -> 0x0533 }
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0535, all -> 0x0533 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0535, all -> 0x0533 }
            r4 = 0
            r5[r4] = r3     // Catch:{ SQLiteException -> 0x0535, all -> 0x0533 }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r4 = r0.rawQuery(r3, r5)     // Catch:{ SQLiteException -> 0x0535, all -> 0x0533 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0531 }
            if (r0 != 0) goto L_0x0529
            com.google.android.gms.measurement.internal.zzfp r0 = r2.zzs     // Catch:{ SQLiteException -> 0x0531 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0531 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0531 }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x0531 }
            if (r4 == 0) goto L_0x0549
        L_0x0525:
            r4.close()     // Catch:{ all -> 0x056a }
            goto L_0x0549
        L_0x0529:
            r3 = 0
            java.lang.String r9 = r4.getString(r3)     // Catch:{ SQLiteException -> 0x0531 }
            if (r4 == 0) goto L_0x0549
            goto L_0x0525
        L_0x0531:
            r0 = move-exception
            goto L_0x0537
        L_0x0533:
            r0 = move-exception
            goto L_0x0564
        L_0x0535:
            r0 = move-exception
            r4 = r9
        L_0x0537:
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs     // Catch:{ all -> 0x0562 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0562 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0562 }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x0562 }
            if (r4 == 0) goto L_0x0549
            goto L_0x0525
        L_0x0549:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x056a }
            if (r0 != 0) goto L_0x055d
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x056a }
            zzal(r0)     // Catch:{ all -> 0x056a }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzs(r9)     // Catch:{ all -> 0x056a }
            if (r0 == 0) goto L_0x055d
            r1.zzE(r0)     // Catch:{ all -> 0x056a }
        L_0x055d:
            r2 = 0
            r1.zzu = r2
            goto L_0x0030
        L_0x0562:
            r0 = move-exception
            r9 = r4
        L_0x0564:
            if (r9 == 0) goto L_0x0569
            r9.close()     // Catch:{ all -> 0x056a }
        L_0x0569:
            throw r0     // Catch:{ all -> 0x056a }
        L_0x056a:
            r0 = move-exception
            r2 = 0
            r1.zzu = r2
            r22.zzah()
            goto L_0x0573
        L_0x0572:
            throw r0
        L_0x0573:
            goto L_0x0572
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzC():void");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzD(int i, Throwable th, byte[] bArr, String str) {
        zzai zzai;
        zzav().zzg();
        zzr();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzt = false;
                zzah();
                throw th2;
            }
        }
        List<Long> list = this.zzx;
        Preconditions.checkNotNull(list);
        List<Long> list2 = list;
        this.zzx = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzau().zzk().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzay().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzay().currentTimeMillis());
            }
            zzai zzai2 = this.zze;
            zzal(zzai2);
            zzai2.zzB(list2);
            zzag();
            this.zzt = false;
            zzah();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzay().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzau().zzk().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzai zzai3 = this.zze;
                zzal(zzai3);
                zzai3.zzb();
                try {
                    for (Long l : list2) {
                        try {
                            zzai = this.zze;
                            zzal(zzai);
                            long longValue = l.longValue();
                            zzai.zzg();
                            zzai.zzZ();
                            if (zzai.zze().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzai.zzs.zzau().zzb().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List<Long> list3 = this.zzy;
                            if (list3 == null || !list3.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzai zzai4 = this.zze;
                    zzal(zzai4);
                    zzai4.zzc();
                    zzai zzai5 = this.zze;
                    zzal(zzai5);
                    zzai5.zzd();
                    this.zzy = null;
                    zzes zzes = this.zzd;
                    zzal(zzes);
                    if (!zzes.zzb() || !zzaf()) {
                        this.zzz = -1;
                        zzag();
                    } else {
                        zzC();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzai zzai6 = this.zze;
                    zzal(zzai6);
                    zzai6.zzd();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzau().zzb().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzay().elapsedRealtime();
                zzau().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzt = false;
            zzah();
        }
        zzau().zzk().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzay().currentTimeMillis());
        this.zzk.zzb.zzb(zzay().currentTimeMillis());
        zzai zzai22 = this.zze;
        zzal(zzai22);
        zzai22.zzB(list2);
        zzag();
        this.zzt = false;
        zzah();
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzg zzg2) {
        String str;
        zzav().zzg();
        zzmg.zzb();
        zzae zzd2 = zzd();
        String zzc2 = zzg2.zzc();
        zzdz<Boolean> zzdz = zzea.zzag;
        if (zzd2.zzn(zzc2, zzdz)) {
            if (TextUtils.isEmpty(zzg2.zzf()) && TextUtils.isEmpty(zzg2.zzj()) && TextUtils.isEmpty(zzg2.zzh())) {
                String zzc3 = zzg2.zzc();
                Preconditions.checkNotNull(zzc3);
                zzF(zzc3, 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zzf()) && TextUtils.isEmpty(zzg2.zzh())) {
            String zzc4 = zzg2.zzc();
            Preconditions.checkNotNull(zzc4);
            zzF(zzc4, 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        zzka zzka = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String zzf2 = zzg2.zzf();
        if (TextUtils.isEmpty(zzf2)) {
            zzmg.zzb();
            if (zzka.zzs.zzc().zzn(zzg2.zzc(), zzdz)) {
                zzf2 = zzg2.zzj();
                if (TextUtils.isEmpty(zzf2)) {
                    zzf2 = zzg2.zzh();
                }
            } else {
                zzf2 = zzg2.zzh();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder encodedAuthority = builder.scheme(zzea.zzd.zzb(null)).encodedAuthority(zzea.zze.zzb(null));
        String valueOf = String.valueOf(zzf2);
        if (valueOf.length() != 0) {
            str = "config/app/".concat(valueOf);
        } else {
            str = new String("config/app/");
        }
        Uri.Builder appendQueryParameter = encodedAuthority.path(str).appendQueryParameter("app_instance_id", zzg2.zzd()).appendQueryParameter("platform", Constants.ANDROID_PLATFORM);
        zzka.zzs.zzc().zzf();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(39065));
        String uri = builder.build().toString();
        try {
            String zzc5 = zzg2.zzc();
            Preconditions.checkNotNull(zzc5);
            String str2 = zzc5;
            URL url = new URL(uri);
            zzau().zzk().zzb("Fetching remote configuration", str2);
            zzfg zzfg = this.zzc;
            zzal(zzfg);
            zzcq zzb2 = zzfg.zzb(str2);
            zzfg zzfg2 = this.zzc;
            zzal(zzfg2);
            String zzc6 = zzfg2.zzc(str2);
            if (zzb2 != null && !TextUtils.isEmpty(zzc6)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", zzc6);
            }
            this.zzs = true;
            zzes zzes = this.zzd;
            zzal(zzes);
            zzkd zzkd = new zzkd(this);
            zzes.zzg();
            zzes.zzZ();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkd);
            zzes.zzs.zzav().zzk(new zzer(zzes, str2, url, (byte[]) null, arrayMap, zzkd));
        } catch (MalformedURLException unused) {
            zzau().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzem.zzl(zzg2.zzc()), uri);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0127 A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0135 A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0157 A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015b A[Catch:{ all -> 0x016c, all -> 0x0176 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzfm r0 = r6.zzav()
            r0.zzg()
            r6.zzr()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0176 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzem r1 = r6.zzau()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzk()     // Catch:{ all -> 0x0176 }
            int r2 = r10.length     // Catch:{ all -> 0x0176 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzai r1 = r6.zze     // Catch:{ all -> 0x0176 }
            zzal(r1)     // Catch:{ all -> 0x0176 }
            r1.zzb()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzai r1 = r6.zze     // Catch:{ all -> 0x016c }
            zzal(r1)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzs(r7)     // Catch:{ all -> 0x016c }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r3) goto L_0x0043
            r3 = 204(0xcc, float:2.86E-43)
            if (r8 == r3) goto L_0x0043
            if (r8 != r4) goto L_0x0047
            r8 = 304(0x130, float:4.26E-43)
        L_0x0043:
            if (r9 != 0) goto L_0x0047
            r3 = 1
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzem r8 = r6.zzau()     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zze()     // Catch:{ all -> 0x016c }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x016c }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016c }
            goto L_0x015e
        L_0x005d:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00bb
            if (r8 != r5) goto L_0x0064
            goto L_0x00bb
        L_0x0064:
            com.google.android.gms.common.util.Clock r10 = r6.zzay()     // Catch:{ all -> 0x016c }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x016c }
            r1.zzM(r10)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzai r10 = r6.zze     // Catch:{ all -> 0x016c }
            zzal(r10)     // Catch:{ all -> 0x016c }
            r10.zzt(r1)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzem r10 = r6.zzau()     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzek r10 = r10.zzk()     // Catch:{ all -> 0x016c }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016c }
            r10.zzc(r11, r1, r9)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzfg r9 = r6.zzc     // Catch:{ all -> 0x016c }
            zzal(r9)     // Catch:{ all -> 0x016c }
            r9.zzd(r7)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzjg r7 = r6.zzk     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzd     // Catch:{ all -> 0x016c }
            com.google.android.gms.common.util.Clock r9 = r6.zzay()     // Catch:{ all -> 0x016c }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016c }
            r7.zzb(r9)     // Catch:{ all -> 0x016c }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00a7
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b6
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzjg r7 = r6.zzk     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzb     // Catch:{ all -> 0x016c }
            com.google.android.gms.common.util.Clock r8 = r6.zzay()     // Catch:{ all -> 0x016c }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x016c }
            r7.zzb(r8)     // Catch:{ all -> 0x016c }
        L_0x00b6:
            r6.zzag()     // Catch:{ all -> 0x016c }
            goto L_0x015e
        L_0x00bb:
            r9 = 0
            if (r11 == 0) goto L_0x00c7
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x016c }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x016c }
            goto L_0x00c8
        L_0x00c7:
            r11 = r9
        L_0x00c8:
            if (r11 == 0) goto L_0x00d7
            int r3 = r11.size()     // Catch:{ all -> 0x016c }
            if (r3 <= 0) goto L_0x00d7
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x016c }
            goto L_0x00d8
        L_0x00d7:
            r11 = r9
        L_0x00d8:
            if (r8 == r5) goto L_0x00f6
            if (r8 != r4) goto L_0x00dd
            goto L_0x00f6
        L_0x00dd:
            com.google.android.gms.measurement.internal.zzfg r9 = r6.zzc     // Catch:{ all -> 0x016c }
            zzal(r9)     // Catch:{ all -> 0x016c }
            boolean r9 = r9.zzh(r7, r10, r11)     // Catch:{ all -> 0x016c }
            if (r9 != 0) goto L_0x0112
            com.google.android.gms.measurement.internal.zzai r7 = r6.zze     // Catch:{ all -> 0x0176 }
            zzal(r7)     // Catch:{ all -> 0x0176 }
        L_0x00ed:
            r7.zzd()     // Catch:{ all -> 0x0176 }
            r6.zzs = r0
            r6.zzah()
            return
        L_0x00f6:
            com.google.android.gms.measurement.internal.zzfg r10 = r6.zzc     // Catch:{ all -> 0x016c }
            zzal(r10)     // Catch:{ all -> 0x016c }
            com.google.android.gms.internal.measurement.zzcq r10 = r10.zzb(r7)     // Catch:{ all -> 0x016c }
            if (r10 != 0) goto L_0x0112
            com.google.android.gms.measurement.internal.zzfg r10 = r6.zzc     // Catch:{ all -> 0x016c }
            zzal(r10)     // Catch:{ all -> 0x016c }
            boolean r9 = r10.zzh(r7, r9, r9)     // Catch:{ all -> 0x016c }
            if (r9 != 0) goto L_0x0112
            com.google.android.gms.measurement.internal.zzai r7 = r6.zze     // Catch:{ all -> 0x0176 }
            zzal(r7)     // Catch:{ all -> 0x0176 }
            goto L_0x00ed
        L_0x0112:
            com.google.android.gms.common.util.Clock r9 = r6.zzay()     // Catch:{ all -> 0x016c }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016c }
            r1.zzK(r9)     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzai r9 = r6.zze     // Catch:{ all -> 0x016c }
            zzal(r9)     // Catch:{ all -> 0x016c }
            r9.zzt(r1)     // Catch:{ all -> 0x016c }
            if (r8 != r5) goto L_0x0135
            com.google.android.gms.measurement.internal.zzem r8 = r6.zzau()     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzh()     // Catch:{ all -> 0x016c }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016c }
            goto L_0x0146
        L_0x0135:
            com.google.android.gms.measurement.internal.zzem r7 = r6.zzau()     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()     // Catch:{ all -> 0x016c }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016c }
            r7.zzc(r9, r8, r2)     // Catch:{ all -> 0x016c }
        L_0x0146:
            com.google.android.gms.measurement.internal.zzes r7 = r6.zzd     // Catch:{ all -> 0x016c }
            zzal(r7)     // Catch:{ all -> 0x016c }
            boolean r7 = r7.zzb()     // Catch:{ all -> 0x016c }
            if (r7 == 0) goto L_0x015b
            boolean r7 = r6.zzaf()     // Catch:{ all -> 0x016c }
            if (r7 == 0) goto L_0x015b
            r6.zzC()     // Catch:{ all -> 0x016c }
            goto L_0x015e
        L_0x015b:
            r6.zzag()     // Catch:{ all -> 0x016c }
        L_0x015e:
            com.google.android.gms.measurement.internal.zzai r7 = r6.zze     // Catch:{ all -> 0x016c }
            zzal(r7)     // Catch:{ all -> 0x016c }
            r7.zzc()     // Catch:{ all -> 0x016c }
            com.google.android.gms.measurement.internal.zzai r7 = r6.zze     // Catch:{ all -> 0x0176 }
            zzal(r7)     // Catch:{ all -> 0x0176 }
            goto L_0x00ed
        L_0x016c:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzai r8 = r6.zze     // Catch:{ all -> 0x0176 }
            zzal(r8)     // Catch:{ all -> 0x0176 }
            r8.zzd()     // Catch:{ all -> 0x0176 }
            throw r7     // Catch:{ all -> 0x0176 }
        L_0x0176:
            r7 = move-exception
            r6.zzs = r0
            r6.zzah()
            goto L_0x017e
        L_0x017d:
            throw r7
        L_0x017e:
            goto L_0x017d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzF(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzG(Runnable runnable) {
        zzav().zzg();
        if (this.zzp == null) {
            this.zzp = new ArrayList();
        }
        this.zzp.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        zzav().zzg();
        zzr();
        if (!this.zzo) {
            this.zzo = true;
            if (zzI()) {
                FileChannel fileChannel = this.zzw;
                zzav().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzau().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzau().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzau().zzb().zzb("Failed to read from channel", e);
                    }
                }
                int zzm2 = this.zzm.zzA().zzm();
                zzav().zzg();
                if (i > zzm2) {
                    zzau().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                } else if (i < zzm2) {
                    FileChannel fileChannel2 = this.zzw;
                    zzav().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzau().zzb().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzm2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            if (zzd().zzn((String) null, zzea.zzap) && Build.VERSION.SDK_INT <= 19) {
                                fileChannel2.position(0);
                            }
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzau().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzau().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                            return;
                        } catch (IOException e2) {
                            zzau().zzb().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzau().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzI() {
        FileLock fileLock;
        zzav().zzg();
        if (!zzd().zzn((String) null, zzea.zzaf) || (fileLock = this.zzv) == null || !fileLock.isValid()) {
            this.zze.zzs.zzc();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzm.zzax().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzw = channel;
                FileLock tryLock = channel.tryLock();
                this.zzv = tryLock;
                if (tryLock != null) {
                    zzau().zzk().zza("Storage concurrent access okay");
                    return true;
                }
                zzau().zzb().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzau().zzb().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzau().zzb().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzau().zze().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzau().zzk().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(zzp zzp2) {
        if (this.zzx != null) {
            ArrayList arrayList = new ArrayList();
            this.zzy = arrayList;
            arrayList.addAll(this.zzx);
        }
        zzai zzai = this.zze;
        zzal(zzai);
        String str = zzp2.zza;
        Preconditions.checkNotNull(str);
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        zzai.zzg();
        zzai.zzZ();
        try {
            SQLiteDatabase zze2 = zzai.zze();
            String[] strArr = {str2};
            int delete = zze2.delete("apps", "app_id=?", strArr) + zze2.delete(Constants.VIDEO_TRACKING_EVENTS_KEY, "app_id=?", strArr) + zze2.delete("user_attributes", "app_id=?", strArr) + zze2.delete("conditional_properties", "app_id=?", strArr) + zze2.delete("raw_events", "app_id=?", strArr) + zze2.delete("raw_events_metadata", "app_id=?", strArr) + zze2.delete("queue", "app_id=?", strArr) + zze2.delete("audience_filter_values", "app_id=?", strArr) + zze2.delete("main_event_params", "app_id=?", strArr) + zze2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzai.zzs.zzau().zzk().zzc("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzai.zzs.zzau().zzb().zzc("Error resetting analytics data. appId, error", zzem.zzl(str2), e);
        }
        if (zzp2.zzh) {
            zzP(zzp2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzK(zzkl zzkl, zzp zzp2) {
        long j;
        zzkl zzkl2 = zzkl;
        zzp zzp3 = zzp2;
        zzav().zzg();
        zzr();
        if (zzak(zzp3)) {
            if (!zzp3.zzh) {
                zzU(zzp3);
                return;
            }
            int zzo2 = zzq().zzo(zzkl2.zzb);
            if (zzo2 != 0) {
                zzkp zzq2 = zzq();
                String str = zzkl2.zzb;
                zzd();
                String zzC = zzq2.zzC(str, 24, true);
                String str2 = zzkl2.zzb;
                zzq().zzM(this.zzB, zzp3.zza, zzo2, "_ev", zzC, str2 != null ? str2.length() : 0, zzd().zzn((String) null, zzea.zzay));
                return;
            }
            int zzJ = zzq().zzJ(zzkl2.zzb, zzkl.zza());
            if (zzJ != 0) {
                zzkp zzq3 = zzq();
                String str3 = zzkl2.zzb;
                zzd();
                String zzC2 = zzq3.zzC(str3, 24, true);
                Object zza2 = zzkl.zza();
                zzq().zzM(this.zzB, zzp3.zza, zzJ, "_ev", zzC2, (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) ? 0 : String.valueOf(zza2).length(), zzd().zzn((String) null, zzea.zzay));
                return;
            }
            Object zzK = zzq().zzK(zzkl2.zzb, zzkl.zza());
            if (zzK != null) {
                if ("_sid".equals(zzkl2.zzb)) {
                    long j2 = zzkl2.zzc;
                    String str4 = zzkl2.zzf;
                    String str5 = zzp3.zza;
                    Preconditions.checkNotNull(str5);
                    String str6 = str5;
                    zzai zzai = this.zze;
                    zzal(zzai);
                    zzkn zzk2 = zzai.zzk(str6, "_sno");
                    if (zzk2 != null) {
                        Object obj = zzk2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzK(new zzkl("_sno", j2, Long.valueOf(j + 1), str4), zzp3);
                        }
                    }
                    if (zzk2 != null) {
                        zzau().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzk2.zze);
                    }
                    zzai zzai2 = this.zze;
                    zzal(zzai2);
                    zzao zzf2 = zzai2.zzf(str6, "_s");
                    if (zzf2 != null) {
                        j = zzf2.zzc;
                        zzau().zzk().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzK(new zzkl("_sno", j2, Long.valueOf(j + 1), str4), zzp3);
                }
                String str7 = zzp3.zza;
                Preconditions.checkNotNull(str7);
                String str8 = zzkl2.zzf;
                Preconditions.checkNotNull(str8);
                zzkn zzkn = new zzkn(str7, str8, zzkl2.zzb, zzkl2.zzc, zzK);
                zzau().zzk().zzc("Setting user property", this.zzm.zzm().zze(zzkn.zzc), zzK);
                zzai zzai3 = this.zze;
                zzal(zzai3);
                zzai3.zzb();
                try {
                    zzU(zzp3);
                    zzai zzai4 = this.zze;
                    zzal(zzai4);
                    boolean zzj2 = zzai4.zzj(zzkn);
                    zzai zzai5 = this.zze;
                    zzal(zzai5);
                    zzai5.zzc();
                    if (!zzj2) {
                        zzau().zzb().zzc("Too many unique user properties are set. Ignoring user property", this.zzm.zzm().zze(zzkn.zzc), zzkn.zze);
                        zzq().zzM(this.zzB, zzp3.zza, 9, (String) null, (String) null, 0, zzd().zzn((String) null, zzea.zzay));
                    }
                } finally {
                    zzai zzai6 = this.zze;
                    zzal(zzai6);
                    zzai6.zzd();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzL(zzkl zzkl, zzp zzp2) {
        zzav().zzg();
        zzr();
        if (zzak(zzp2)) {
            if (!zzp2.zzh) {
                zzU(zzp2);
            } else if (!"_npa".equals(zzkl.zzb) || zzp2.zzr == null) {
                zzau().zzj().zzb("Removing user property", this.zzm.zzm().zze(zzkl.zzb));
                zzai zzai = this.zze;
                zzal(zzai);
                zzai.zzb();
                try {
                    zzU(zzp2);
                    zzai zzai2 = this.zze;
                    zzal(zzai2);
                    String str = zzp2.zza;
                    Preconditions.checkNotNull(str);
                    zzai2.zzi(str, zzkl.zzb);
                    zzai zzai3 = this.zze;
                    zzal(zzai3);
                    zzai3.zzc();
                    zzau().zzj().zzb("User property removed", this.zzm.zzm().zze(zzkl.zzb));
                } finally {
                    zzai zzai4 = this.zze;
                    zzal(zzai4);
                    zzai4.zzd();
                }
            } else {
                zzau().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzK(new zzkl("_npa", zzay().currentTimeMillis(), Long.valueOf(true != zzp2.zzr.booleanValue() ? 0 : 1), "auto"), zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzM() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final void zzN() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final zzfp zzO() {
        return this.zzm;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03d2 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03fd A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0414 A[SYNTHETIC, Splitter:B:129:0x0414] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04ba A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04d8 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x056f A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b7 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e2 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x021a A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0239 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0240 A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024f A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x025f A[Catch:{ SQLiteException -> 0x01cb, all -> 0x059d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzP(com.google.android.gms.measurement.internal.zzp r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfm r8 = r24.zzav()
            r8.zzg()
            r24.zzr()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = r24.zzak(r25)
            if (r8 == 0) goto L_0x05a7
            com.google.android.gms.measurement.internal.zzai r8 = r1.zze
            zzal(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzs(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzf()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzK(r9)
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze
            zzal(r11)
            r11.zzt(r8)
            com.google.android.gms.measurement.internal.zzfg r8 = r1.zzc
            zzal(r8)
            java.lang.String r11 = r2.zza
            r8.zze(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r24.zzU(r25)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r24.zzay()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfp r8 = r1.zzm
            com.google.android.gms.measurement.internal.zzam r8 = r8.zzz()
            r8.zze()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzem r13 = r24.zzau()
            com.google.android.gms.measurement.internal.zzek r13 = r13.zze()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzem.zzl(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzai r9 = r1.zze
            zzal(r9)
            r9.zzb()
            com.google.android.gms.measurement.internal.zzai r9 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r9)     // Catch:{ all -> 0x059d }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x059d }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzkn r9 = r9.zzk(r10, r13)     // Catch:{ all -> 0x059d }
            if (r9 == 0) goto L_0x00c4
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x059d }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x059d }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c4
        L_0x00be:
            r21 = r3
            r22 = r4
            r4 = 1
            goto L_0x0118
        L_0x00c4:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x059d }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzkl r14 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x059d }
            java.lang.String r19 = "_npa"
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x059d }
            if (r15 == r10) goto L_0x00d5
            r20 = 0
            goto L_0x00d7
        L_0x00d5:
            r20 = 1
        L_0x00d7:
            java.lang.Long r10 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x059d }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r14
            r3 = r14
            r4 = 0
            r14 = r19
            r4 = 1
            r15 = r11
            r17 = r10
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x059d }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x059d }
            java.lang.Long r10 = r3.zzd     // Catch:{ all -> 0x059d }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x059d }
            if (r9 != 0) goto L_0x0118
        L_0x00fd:
            r1.zzK(r3, r2)     // Catch:{ all -> 0x059d }
            goto L_0x0118
        L_0x0101:
            r21 = r3
            r22 = r4
            r4 = 1
            if (r9 == 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzkl r3 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r3
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x059d }
            r1.zzL(r3, r2)     // Catch:{ all -> 0x059d }
        L_0x0118:
            com.google.android.gms.measurement.internal.zzai r3 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r3)     // Catch:{ all -> 0x059d }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x059d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzs(r9)     // Catch:{ all -> 0x059d }
            if (r3 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzkp r10 = r24.zzq()     // Catch:{ all -> 0x059d }
            java.lang.String r13 = r2.zzb     // Catch:{ all -> 0x059d }
            java.lang.String r14 = r3.zzf()     // Catch:{ all -> 0x059d }
            java.lang.String r15 = r2.zzq     // Catch:{ all -> 0x059d }
            java.lang.String r9 = r3.zzh()     // Catch:{ all -> 0x059d }
            boolean r9 = r10.zzB(r13, r14, r15, r9)     // Catch:{ all -> 0x059d }
            if (r9 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzem r9 = r24.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zze()     // Catch:{ all -> 0x059d }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r3.zzc()     // Catch:{ all -> 0x059d }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r13)     // Catch:{ all -> 0x059d }
            r9.zzb(r10, r13)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzai r9 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r9)     // Catch:{ all -> 0x059d }
            java.lang.String r3 = r3.zzc()     // Catch:{ all -> 0x059d }
            r9.zzZ()     // Catch:{ all -> 0x059d }
            r9.zzg()     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x059d }
            android.database.sqlite.SQLiteDatabase r10 = r9.zze()     // Catch:{ SQLiteException -> 0x01cb }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01cb }
            r14 = 0
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x01cb }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cb }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01df
            com.google.android.gms.measurement.internal.zzfp r0 = r9.zzs     // Catch:{ SQLiteException -> 0x01cb }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x01cb }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x01cb }
            java.lang.String r10 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01cb }
            r0.zzc(r10, r3, r13)     // Catch:{ SQLiteException -> 0x01cb }
            goto L_0x01df
        L_0x01cb:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r9 = r9.zzs     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x059d }
            r9.zzc(r10, r3, r0)     // Catch:{ all -> 0x059d }
        L_0x01df:
            r3 = 0
        L_0x01e0:
            if (r3 == 0) goto L_0x0239
            long r9 = r3.zzv()     // Catch:{ all -> 0x059d }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x01fb
            long r9 = r3.zzv()     // Catch:{ all -> 0x059d }
            r23 = r5
            long r4 = r2.zzj     // Catch:{ all -> 0x059d }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01fd
            r15 = 1
            goto L_0x01fe
        L_0x01fb:
            r23 = r5
        L_0x01fd:
            r15 = 0
        L_0x01fe:
            java.lang.String r0 = r3.zzt()     // Catch:{ all -> 0x059d }
            long r3 = r3.zzv()     // Catch:{ all -> 0x059d }
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0216
            if (r0 == 0) goto L_0x0216
            java.lang.String r3 = r2.zzc     // Catch:{ all -> 0x059d }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x059d }
            if (r3 != 0) goto L_0x0216
            r3 = 1
            goto L_0x0217
        L_0x0216:
            r3 = 0
        L_0x0217:
            r3 = r3 | r15
            if (r3 == 0) goto L_0x023b
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x059d }
            r3.<init>()     // Catch:{ all -> 0x059d }
            java.lang.String r4 = "_pv"
            r3.putString(r4, r0)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_au"
            com.google.android.gms.measurement.internal.zzaq r15 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x059d }
            r15.<init>(r3)     // Catch:{ all -> 0x059d }
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x059d }
            r1.zzy(r0, r2)     // Catch:{ all -> 0x059d }
            goto L_0x023b
        L_0x0239:
            r23 = r5
        L_0x023b:
            r24.zzU(r25)     // Catch:{ all -> 0x059d }
            if (r8 != 0) goto L_0x024f
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r0)     // Catch:{ all -> 0x059d }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x059d }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzao r0 = r0.zzf(r3, r4)     // Catch:{ all -> 0x059d }
            r15 = 0
            goto L_0x025d
        L_0x024f:
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r0)     // Catch:{ all -> 0x059d }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x059d }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzao r0 = r0.zzf(r3, r4)     // Catch:{ all -> 0x059d }
            r15 = 1
        L_0x025d:
            if (r0 != 0) goto L_0x056f
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_r"
            java.lang.String r5 = "_c"
            java.lang.String r10 = "_et"
            if (r15 != 0) goto L_0x04f2
            com.google.android.gms.measurement.internal.zzkl r0 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x059d }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x059d }
            r1.zzK(r0, r2)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfm r0 = r24.zzav()     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfe r0 = r0.zzi()     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x059d }
            r8 = r0
            com.google.android.gms.measurement.internal.zzfe r8 = (com.google.android.gms.measurement.internal.zzfe) r8     // Catch:{ all -> 0x059d }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x0391
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x059d }
            if (r9 == 0) goto L_0x02a4
            goto L_0x0391
        L_0x02a4:
            com.google.android.gms.measurement.internal.zzfp r9 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzav()     // Catch:{ all -> 0x059d }
            r9.zzg()     // Catch:{ all -> 0x059d }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x059d }
            if (r9 != 0) goto L_0x02c4
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzi()     // Catch:{ all -> 0x059d }
            java.lang.String r8 = "Install Referrer Reporter is not available"
            r0.zza(r8)     // Catch:{ all -> 0x059d }
            goto L_0x03a0
        L_0x02c4:
            com.google.android.gms.measurement.internal.zzfd r9 = new com.google.android.gms.measurement.internal.zzfd     // Catch:{ all -> 0x059d }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzav()     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x059d }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x059d }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15 = r23
            r13.<init>(r15, r14)     // Catch:{ all -> 0x059d }
            r0.setComponent(r13)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfp r13 = r8.zza     // Catch:{ all -> 0x059d }
            android.content.Context r13 = r13.zzax()     // Catch:{ all -> 0x059d }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x059d }
            if (r13 != 0) goto L_0x0302
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzf()     // Catch:{ all -> 0x059d }
            java.lang.String r8 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r8)     // Catch:{ all -> 0x059d }
            goto L_0x03a0
        L_0x0302:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r14)     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x0381
            boolean r16 = r13.isEmpty()     // Catch:{ all -> 0x059d }
            if (r16 != 0) goto L_0x0381
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x059d }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x059d }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x03a0
            java.lang.String r14 = r13.packageName     // Catch:{ all -> 0x059d }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x0371
            boolean r13 = r15.equals(r14)     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x0371
            boolean r13 = r8.zza()     // Catch:{ all -> 0x059d }
            if (r13 == 0) goto L_0x0371
            android.content.Intent r13 = new android.content.Intent     // Catch:{ all -> 0x059d }
            r13.<init>(r0)     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ Exception -> 0x035c }
            com.google.android.gms.measurement.internal.zzfp r14 = r8.zza     // Catch:{ Exception -> 0x035c }
            android.content.Context r14 = r14.zzax()     // Catch:{ Exception -> 0x035c }
            r15 = 1
            boolean r0 = r0.bindService(r14, r13, r9, r15)     // Catch:{ Exception -> 0x035c }
            com.google.android.gms.measurement.internal.zzfp r9 = r8.zza     // Catch:{ Exception -> 0x035c }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()     // Catch:{ Exception -> 0x035c }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()     // Catch:{ Exception -> 0x035c }
            java.lang.String r13 = "Install Referrer Service is"
            java.lang.String r14 = "available"
            java.lang.String r15 = "not available"
            r16 = r14
            r14 = 1
            if (r14 == r0) goto L_0x0356
            r14 = r15
            goto L_0x0358
        L_0x0356:
            r14 = r16
        L_0x0358:
            r9.zzb(r13, r14)     // Catch:{ Exception -> 0x035c }
            goto L_0x03a0
        L_0x035c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfp r8 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x059d }
            r8.zzb(r9, r0)     // Catch:{ all -> 0x059d }
            goto L_0x03a0
        L_0x0371:
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x059d }
            java.lang.String r8 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r8)     // Catch:{ all -> 0x059d }
            goto L_0x03a0
        L_0x0381:
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzi()     // Catch:{ all -> 0x059d }
            java.lang.String r8 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r8)     // Catch:{ all -> 0x059d }
            goto L_0x03a0
        L_0x0391:
            com.google.android.gms.measurement.internal.zzfp r0 = r8.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzf()     // Catch:{ all -> 0x059d }
            java.lang.String r8 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r8)     // Catch:{ all -> 0x059d }
        L_0x03a0:
            com.google.android.gms.measurement.internal.zzfm r0 = r24.zzav()     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            r24.zzr()     // Catch:{ all -> 0x059d }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x059d }
            r8.<init>()     // Catch:{ all -> 0x059d }
            r13 = 1
            r8.putLong(r5, r13)     // Catch:{ all -> 0x059d }
            r8.putLong(r4, r13)     // Catch:{ all -> 0x059d }
            r4 = 0
            r8.putLong(r7, r4)     // Catch:{ all -> 0x059d }
            r8.putLong(r6, r4)     // Catch:{ all -> 0x059d }
            r9 = r22
            r8.putLong(r9, r4)     // Catch:{ all -> 0x059d }
            r15 = r21
            r8.putLong(r15, r4)     // Catch:{ all -> 0x059d }
            r4 = 1
            r8.putLong(r10, r4)     // Catch:{ all -> 0x059d }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x03d5
            r8.putLong(r3, r4)     // Catch:{ all -> 0x059d }
        L_0x03d5:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x059d }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r0)     // Catch:{ all -> 0x059d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            r0.zzZ()     // Catch:{ all -> 0x059d }
            java.lang.String r4 = "first_open_count"
            long r4 = r0.zzE(r3, r4)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ all -> 0x059d }
            android.content.Context r0 = r0.zzax()     // Catch:{ all -> 0x059d }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x059d }
            if (r0 != 0) goto L_0x0414
            com.google.android.gms.measurement.internal.zzem r0 = r24.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r7 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x059d }
            r0.zzb(r7, r3)     // Catch:{ all -> 0x059d }
            r22 = r10
        L_0x0410:
            r9 = 0
            goto L_0x04d4
        L_0x0414:
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x0426 }
            android.content.Context r0 = r0.zzax()     // Catch:{ NameNotFoundException -> 0x0426 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0426 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r13)     // Catch:{ NameNotFoundException -> 0x0426 }
            r21 = r15
            goto L_0x043b
        L_0x0426:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzem r13 = r24.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "Package info is null, first open report might be inaccurate. appId"
            r21 = r15
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x059d }
            r13.zzc(r14, r15, r0)     // Catch:{ all -> 0x059d }
            r0 = 0
        L_0x043b:
            if (r0 == 0) goto L_0x048e
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x059d }
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x048e
            r23 = r9
            r22 = r10
            long r9 = r0.lastUpdateTime     // Catch:{ all -> 0x059d }
            int r0 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x046f
            com.google.android.gms.measurement.internal.zzae r0 = r24.zzd()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzak     // Catch:{ all -> 0x059d }
            r10 = 0
            boolean r0 = r0.zzn(r10, r9)     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x0469
            r13 = 0
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0467
            r13 = 1
            r8.putLong(r7, r13)     // Catch:{ all -> 0x059d }
        L_0x0467:
            r15 = 0
            goto L_0x0471
        L_0x0469:
            r13 = 1
            r8.putLong(r7, r13)     // Catch:{ all -> 0x059d }
            goto L_0x0467
        L_0x046f:
            r10 = 0
            r15 = 1
        L_0x0471:
            com.google.android.gms.measurement.internal.zzkl r0 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x047b
            r15 = 0
            goto L_0x047d
        L_0x047b:
            r15 = 1
        L_0x047d:
            java.lang.Long r17 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x059d }
            java.lang.String r18 = "auto"
            r13 = r0
            r7 = r21
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x059d }
            r1.zzK(r0, r2)     // Catch:{ all -> 0x059d }
            goto L_0x0495
        L_0x048e:
            r23 = r9
            r22 = r10
            r7 = r21
            r10 = 0
        L_0x0495:
            com.google.android.gms.measurement.internal.zzfp r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x04a5 }
            android.content.Context r0 = r0.zzax()     // Catch:{ NameNotFoundException -> 0x04a5 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04a5 }
            r9 = 0
            android.content.pm.ApplicationInfo r9 = r0.getApplicationInfo(r3, r9)     // Catch:{ NameNotFoundException -> 0x04a5 }
            goto L_0x04b8
        L_0x04a5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzem r9 = r24.zzau()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzb()     // Catch:{ all -> 0x059d }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x059d }
            r9.zzc(r13, r3, r0)     // Catch:{ all -> 0x059d }
            r9 = r10
        L_0x04b8:
            if (r9 == 0) goto L_0x0410
            int r0 = r9.flags     // Catch:{ all -> 0x059d }
            r3 = 1
            r0 = r0 & r3
            if (r0 == 0) goto L_0x04c7
            r3 = r23
            r13 = 1
            r8.putLong(r3, r13)     // Catch:{ all -> 0x059d }
        L_0x04c7:
            int r0 = r9.flags     // Catch:{ all -> 0x059d }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0410
            r9 = 1
            r8.putLong(r7, r9)     // Catch:{ all -> 0x059d }
            goto L_0x0410
        L_0x04d4:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x04db
            r8.putLong(r6, r4)     // Catch:{ all -> 0x059d }
        L_0x04db:
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_f"
            com.google.android.gms.measurement.internal.zzaq r15 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x059d }
            r15.<init>(r8)     // Catch:{ all -> 0x059d }
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x059d }
            r1.zzx(r0, r2)     // Catch:{ all -> 0x059d }
            r4 = r22
            goto L_0x053d
        L_0x04f2:
            r22 = r10
            com.google.android.gms.measurement.internal.zzkl r0 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x059d }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x059d }
            r1.zzK(r0, r2)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzfm r0 = r24.zzav()     // Catch:{ all -> 0x059d }
            r0.zzg()     // Catch:{ all -> 0x059d }
            r24.zzr()     // Catch:{ all -> 0x059d }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x059d }
            r0.<init>()     // Catch:{ all -> 0x059d }
            r6 = 1
            r0.putLong(r5, r6)     // Catch:{ all -> 0x059d }
            r0.putLong(r4, r6)     // Catch:{ all -> 0x059d }
            r4 = r22
            r0.putLong(r4, r6)     // Catch:{ all -> 0x059d }
            boolean r5 = r2.zzp     // Catch:{ all -> 0x059d }
            if (r5 == 0) goto L_0x0529
            r0.putLong(r3, r6)     // Catch:{ all -> 0x059d }
        L_0x0529:
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_v"
            com.google.android.gms.measurement.internal.zzaq r15 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x059d }
            r15.<init>(r0)     // Catch:{ all -> 0x059d }
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x059d }
            r1.zzx(r3, r2)     // Catch:{ all -> 0x059d }
        L_0x053d:
            com.google.android.gms.measurement.internal.zzae r0 = r24.zzd()     // Catch:{ all -> 0x059d }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzea.zzT     // Catch:{ all -> 0x059d }
            boolean r0 = r0.zzn(r3, r5)     // Catch:{ all -> 0x059d }
            if (r0 != 0) goto L_0x058c
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x059d }
            r0.<init>()     // Catch:{ all -> 0x059d }
            r5 = 1
            r0.putLong(r4, r5)     // Catch:{ all -> 0x059d }
            java.lang.String r3 = "_fr"
            r0.putLong(r3, r5)     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_e"
            com.google.android.gms.measurement.internal.zzaq r15 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x059d }
            r15.<init>(r0)     // Catch:{ all -> 0x059d }
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x059d }
            r1.zzx(r3, r2)     // Catch:{ all -> 0x059d }
            goto L_0x058c
        L_0x056f:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x059d }
            if (r0 == 0) goto L_0x058c
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x059d }
            r0.<init>()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x059d }
            java.lang.String r14 = "_cd"
            com.google.android.gms.measurement.internal.zzaq r15 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x059d }
            r15.<init>(r0)     // Catch:{ all -> 0x059d }
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x059d }
            r1.zzx(r3, r2)     // Catch:{ all -> 0x059d }
        L_0x058c:
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze     // Catch:{ all -> 0x059d }
            zzal(r0)     // Catch:{ all -> 0x059d }
            r0.zzc()     // Catch:{ all -> 0x059d }
            com.google.android.gms.measurement.internal.zzai r0 = r1.zze
            zzal(r0)
            r0.zzd()
            return
        L_0x059d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            throw r0
        L_0x05a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzP(com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzQ(zzaa zzaa) {
        String str = zzaa.zza;
        Preconditions.checkNotNull(str);
        zzp zzaj = zzaj(str);
        if (zzaj != null) {
            zzR(zzaa, zzaj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzR(zzaa zzaa, zzp zzp2) {
        zzas zzas;
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotEmpty(zzaa.zza);
        Preconditions.checkNotNull(zzaa.zzb);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zzc.zzb);
        zzav().zzg();
        zzr();
        if (zzak(zzp2)) {
            if (!zzp2.zzh) {
                zzU(zzp2);
                return;
            }
            zzaa zzaa2 = new zzaa(zzaa);
            boolean z = false;
            zzaa2.zze = false;
            zzai zzai = this.zze;
            zzal(zzai);
            zzai.zzb();
            try {
                zzai zzai2 = this.zze;
                zzal(zzai2);
                String str = zzaa2.zza;
                Preconditions.checkNotNull(str);
                zzaa zzo2 = zzai2.zzo(str, zzaa2.zzc.zzb);
                if (zzo2 != null && !zzo2.zzb.equals(zzaa2.zzb)) {
                    zzau().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzm.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzb, zzo2.zzb);
                }
                if (zzo2 != null && zzo2.zze) {
                    zzaa2.zzb = zzo2.zzb;
                    zzaa2.zzd = zzo2.zzd;
                    zzaa2.zzh = zzo2.zzh;
                    zzaa2.zzf = zzo2.zzf;
                    zzaa2.zzi = zzo2.zzi;
                    zzaa2.zze = true;
                    zzkl zzkl = zzaa2.zzc;
                    zzaa2.zzc = new zzkl(zzkl.zzb, zzo2.zzc.zzc, zzkl.zza(), zzo2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzaa2.zzf)) {
                    zzkl zzkl2 = zzaa2.zzc;
                    zzaa2.zzc = new zzkl(zzkl2.zzb, zzaa2.zzd, zzkl2.zza(), zzaa2.zzc.zzf);
                    zzaa2.zze = true;
                    z = true;
                }
                if (zzaa2.zze) {
                    zzkl zzkl3 = zzaa2.zzc;
                    String str2 = zzaa2.zza;
                    Preconditions.checkNotNull(str2);
                    String str3 = zzaa2.zzb;
                    String str4 = zzkl3.zzb;
                    long j = zzkl3.zzc;
                    Object zza2 = zzkl3.zza();
                    Preconditions.checkNotNull(zza2);
                    zzkn zzkn = new zzkn(str2, str3, str4, j, zza2);
                    zzai zzai3 = this.zze;
                    zzal(zzai3);
                    if (zzai3.zzj(zzkn)) {
                        zzau().zzj().zzd("User property updated immediately", zzaa2.zza, this.zzm.zzm().zze(zzkn.zzc), zzkn.zze);
                    } else {
                        zzau().zzb().zzd("(2)Too many active user properties, ignoring", zzem.zzl(zzaa2.zza), this.zzm.zzm().zze(zzkn.zzc), zzkn.zze);
                    }
                    if (z && (zzas = zzaa2.zzi) != null) {
                        zzz(new zzas(zzas, zzaa2.zzd), zzp2);
                    }
                }
                zzai zzai4 = this.zze;
                zzal(zzai4);
                if (zzai4.zzn(zzaa2)) {
                    zzau().zzj().zzd("Conditional property added", zzaa2.zza, this.zzm.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzc.zza());
                } else {
                    zzau().zzb().zzd("Too many conditional properties, ignoring", zzem.zzl(zzaa2.zza), this.zzm.zzm().zze(zzaa2.zzc.zzb), zzaa2.zzc.zza());
                }
                zzai zzai5 = this.zze;
                zzal(zzai5);
                zzai5.zzc();
            } finally {
                zzai zzai6 = this.zze;
                zzal(zzai6);
                zzai6.zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzS(zzaa zzaa) {
        String str = zzaa.zza;
        Preconditions.checkNotNull(str);
        zzp zzaj = zzaj(str);
        if (zzaj != null) {
            zzT(zzaa, zzaj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzaa zzaa, zzp zzp2) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotEmpty(zzaa.zza);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zzc.zzb);
        zzav().zzg();
        zzr();
        if (zzak(zzp2)) {
            if (zzp2.zzh) {
                zzai zzai = this.zze;
                zzal(zzai);
                zzai.zzb();
                try {
                    zzU(zzp2);
                    String str = zzaa.zza;
                    Preconditions.checkNotNull(str);
                    String str2 = str;
                    zzai zzai2 = this.zze;
                    zzal(zzai2);
                    zzaa zzo2 = zzai2.zzo(str2, zzaa.zzc.zzb);
                    if (zzo2 != null) {
                        zzau().zzj().zzc("Removing conditional user property", zzaa.zza, this.zzm.zzm().zze(zzaa.zzc.zzb));
                        zzai zzai3 = this.zze;
                        zzal(zzai3);
                        zzai3.zzp(str2, zzaa.zzc.zzb);
                        if (zzo2.zze) {
                            zzai zzai4 = this.zze;
                            zzal(zzai4);
                            zzai4.zzi(str2, zzaa.zzc.zzb);
                        }
                        zzas zzas = zzaa.zzk;
                        if (zzas != null) {
                            zzaq zzaq = zzas.zzb;
                            Bundle zzf2 = zzaq != null ? zzaq.zzf() : null;
                            zzkp zzq2 = zzq();
                            zzas zzas2 = zzaa.zzk;
                            Preconditions.checkNotNull(zzas2);
                            zzas zzV = zzq2.zzV(str2, zzas2.zza, zzf2, zzo2.zzb, zzaa.zzk.zzd, true, false);
                            Preconditions.checkNotNull(zzV);
                            zzz(zzV, zzp2);
                        }
                    } else {
                        zzau().zze().zzc("Conditional user property doesn't exist", zzem.zzl(zzaa.zza), this.zzm.zzm().zze(zzaa.zzc.zzb));
                    }
                    zzai zzai5 = this.zze;
                    zzal(zzai5);
                    zzai5.zzc();
                } finally {
                    zzai zzai6 = this.zze;
                    zzal(zzai6);
                    zzai6.zzd();
                }
            } else {
                zzU(zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03a6, code lost:
        if (r9 != false) goto L_0x03a8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzU(com.google.android.gms.measurement.internal.zzp r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzfm r0 = r12.zzav()
            r0.zzg()
            r12.zzr()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            java.lang.String r0 = r13.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzai r0 = r12.zze
            zzal(r0)
            java.lang.String r1 = r13.zza
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzs(r1)
            com.google.android.gms.measurement.internal.zzaf r1 = com.google.android.gms.measurement.internal.zzaf.zza
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r2 = r12.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzaw
            r4 = 0
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x0040
            java.lang.String r2 = r13.zza
            com.google.android.gms.measurement.internal.zzaf r2 = r12.zzt(r2)
            java.lang.String r5 = r13.zzv
            com.google.android.gms.measurement.internal.zzaf r5 = com.google.android.gms.measurement.internal.zzaf.zzc(r5)
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzk(r5)
            goto L_0x0041
        L_0x0040:
            r2 = r1
        L_0x0041:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r5 = r12.zzd()
            boolean r5 = r5.zzn(r4, r3)
            if (r5 == 0) goto L_0x0058
            boolean r5 = r2.zzf()
            if (r5 == 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            java.lang.String r5 = ""
            goto L_0x0060
        L_0x0058:
            com.google.android.gms.measurement.internal.zzjg r5 = r12.zzk
            java.lang.String r6 = r13.zza
            java.lang.String r5 = r5.zzf(r6)
        L_0x0060:
            com.google.android.gms.internal.measurement.zzlu.zzb()
            com.google.android.gms.measurement.internal.zzae r6 = r12.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzal
            boolean r6 = r6.zzn(r4, r7)
            r7 = 0
            if (r6 == 0) goto L_0x01a5
            if (r0 != 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzfp r1 = r12.zzm
            java.lang.String r6 = r13.zza
            r0.<init>(r1, r6)
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            boolean r1 = r1.zzn(r4, r3)
            if (r1 == 0) goto L_0x00a0
            boolean r1 = r2.zzh()
            if (r1 == 0) goto L_0x0096
            java.lang.String r1 = r12.zzA(r2)
            r0.zze(r1)
        L_0x0096:
            boolean r1 = r2.zzf()
            if (r1 == 0) goto L_0x010e
            r0.zzm(r5)
            goto L_0x010e
        L_0x00a0:
            java.lang.String r1 = r12.zzB()
            r0.zze(r1)
            r0.zzm(r5)
            goto L_0x010e
        L_0x00ab:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            boolean r1 = r1.zzn(r4, r3)
            if (r1 == 0) goto L_0x00be
            boolean r1 = r2.zzf()
            if (r1 == 0) goto L_0x00ea
        L_0x00be:
            if (r5 == 0) goto L_0x00ea
            java.lang.String r1 = r0.zzl()
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x00ea
            r0.zzm(r5)
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            boolean r1 = r1.zzn(r4, r3)
            if (r1 == 0) goto L_0x00e2
            java.lang.String r1 = r12.zzA(r2)
            r0.zze(r1)
            goto L_0x010e
        L_0x00e2:
            java.lang.String r1 = r12.zzB()
            r0.zze(r1)
            goto L_0x010e
        L_0x00ea:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            boolean r1 = r1.zzn(r4, r3)
            if (r1 == 0) goto L_0x010e
            java.lang.String r1 = r0.zzd()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x010e
            boolean r1 = r2.zzh()
            if (r1 == 0) goto L_0x010e
            java.lang.String r1 = r12.zzA(r2)
            r0.zze(r1)
        L_0x010e:
            java.lang.String r1 = r13.zzb
            r0.zzg(r1)
            java.lang.String r1 = r13.zzq
            r0.zzi(r1)
            com.google.android.gms.internal.measurement.zzmg.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            java.lang.String r2 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzag
            boolean r1 = r1.zzn(r2, r3)
            if (r1 == 0) goto L_0x0130
            java.lang.String r1 = r13.zzu
            r0.zzk(r1)
        L_0x0130:
            java.lang.String r1 = r13.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x013d
            java.lang.String r1 = r13.zzk
            r0.zzo(r1)
        L_0x013d:
            long r1 = r13.zze
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0146
            r0.zzA(r1)
        L_0x0146:
            java.lang.String r1 = r13.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0153
            java.lang.String r1 = r13.zzc
            r0.zzu(r1)
        L_0x0153:
            long r1 = r13.zzj
            r0.zzw(r1)
            java.lang.String r1 = r13.zzd
            if (r1 == 0) goto L_0x015f
            r0.zzy(r1)
        L_0x015f:
            long r1 = r13.zzf
            r0.zzC(r1)
            boolean r1 = r13.zzh
            r0.zzG(r1)
            java.lang.String r1 = r13.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0176
            java.lang.String r1 = r13.zzg
            r0.zzac(r1)
        L_0x0176:
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzea.zzat
            boolean r1 = r1.zzn(r4, r2)
            if (r1 != 0) goto L_0x0187
            long r1 = r13.zzl
            r0.zzae(r1)
        L_0x0187:
            boolean r1 = r13.zzo
            r0.zzag(r1)
            java.lang.Boolean r1 = r13.zzr
            r0.zzai(r1)
            long r1 = r13.zzs
            r0.zzE(r1)
            boolean r13 = r0.zza()
            if (r13 == 0) goto L_0x01a4
            com.google.android.gms.measurement.internal.zzai r13 = r12.zze
            zzal(r13)
            r13.zzt(r0)
        L_0x01a4:
            return r0
        L_0x01a5:
            java.lang.String r2 = r13.zza
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r6 = r12.zzd()
            boolean r6 = r6.zzn(r4, r3)
            if (r6 == 0) goto L_0x01c7
            com.google.android.gms.measurement.internal.zzaf r1 = r12.zzt(r2)
            java.lang.String r6 = r13.zzv
            com.google.android.gms.measurement.internal.zzaf r6 = com.google.android.gms.measurement.internal.zzaf.zzc(r6)
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk(r6)
        L_0x01c7:
            r6 = 0
            r9 = 1
            if (r0 != 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzfp r6 = r12.zzm
            r0.<init>(r6, r2)
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r2 = r12.zzd()
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x01f6
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x01ec
            java.lang.String r2 = r12.zzA(r1)
            r0.zze(r2)
        L_0x01ec:
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x0200
            r0.zzm(r5)
            goto L_0x0200
        L_0x01f6:
            java.lang.String r1 = r12.zzB()
            r0.zze(r1)
            r0.zzm(r5)
        L_0x0200:
            r6 = 1
            goto L_0x026c
        L_0x0202:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r2 = r12.zzd()
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x0215
            boolean r2 = r1.zzf()
            if (r2 == 0) goto L_0x0247
        L_0x0215:
            if (r5 == 0) goto L_0x0247
            java.lang.String r2 = r0.zzl()
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x0247
            r0.zzm(r5)
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r2 = r12.zzd()
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x023f
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x0200
            java.lang.String r1 = r12.zzA(r1)
            r0.zze(r1)
            goto L_0x0200
        L_0x023f:
            java.lang.String r1 = r12.zzB()
            r0.zze(r1)
            goto L_0x0200
        L_0x0247:
            com.google.android.gms.internal.measurement.zzlf.zzb()
            com.google.android.gms.measurement.internal.zzae r2 = r12.zzd()
            boolean r2 = r2.zzn(r4, r3)
            if (r2 == 0) goto L_0x026c
            java.lang.String r2 = r0.zzd()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x026c
            boolean r2 = r1.zzh()
            if (r2 == 0) goto L_0x026c
            java.lang.String r1 = r12.zzA(r1)
            r0.zze(r1)
            goto L_0x0200
        L_0x026c:
            java.lang.String r1 = r13.zzb
            java.lang.String r2 = r0.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x027e
            java.lang.String r1 = r13.zzb
            r0.zzg(r1)
            r6 = 1
        L_0x027e:
            java.lang.String r1 = r13.zzq
            java.lang.String r2 = r0.zzh()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0290
            java.lang.String r1 = r13.zzq
            r0.zzi(r1)
            r6 = 1
        L_0x0290:
            com.google.android.gms.internal.measurement.zzmg.zzb()
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            java.lang.String r2 = r0.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzag
            boolean r1 = r1.zzn(r2, r3)
            if (r1 == 0) goto L_0x02b5
            java.lang.String r1 = r13.zzu
            java.lang.String r2 = r0.zzj()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x02b5
            java.lang.String r1 = r13.zzu
            r0.zzk(r1)
            r6 = 1
        L_0x02b5:
            java.lang.String r1 = r13.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02cf
            java.lang.String r1 = r13.zzk
            java.lang.String r2 = r0.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02cf
            java.lang.String r1 = r13.zzk
            r0.zzo(r1)
            r6 = 1
        L_0x02cf:
            long r1 = r13.zze
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x02e3
            long r10 = r0.zzz()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x02e3
            long r1 = r13.zze
            r0.zzA(r1)
            r6 = 1
        L_0x02e3:
            java.lang.String r1 = r13.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02fd
            java.lang.String r1 = r13.zzc
            java.lang.String r2 = r0.zzt()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02fd
            java.lang.String r1 = r13.zzc
            r0.zzu(r1)
            r6 = 1
        L_0x02fd:
            long r1 = r13.zzj
            long r10 = r0.zzv()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x030d
            long r1 = r13.zzj
            r0.zzw(r1)
            r6 = 1
        L_0x030d:
            java.lang.String r1 = r13.zzd
            if (r1 == 0) goto L_0x0321
            java.lang.String r2 = r0.zzx()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0321
            java.lang.String r1 = r13.zzd
            r0.zzy(r1)
            r6 = 1
        L_0x0321:
            long r1 = r13.zzf
            long r10 = r0.zzB()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0331
            long r1 = r13.zzf
            r0.zzC(r1)
            r6 = 1
        L_0x0331:
            boolean r1 = r13.zzh
            boolean r2 = r0.zzF()
            if (r1 == r2) goto L_0x033f
            boolean r1 = r13.zzh
            r0.zzG(r1)
            r6 = 1
        L_0x033f:
            java.lang.String r1 = r13.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0359
            java.lang.String r1 = r13.zzg
            java.lang.String r2 = r0.zzaa()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0359
            java.lang.String r1 = r13.zzg
            r0.zzac(r1)
            r6 = 1
        L_0x0359:
            com.google.android.gms.measurement.internal.zzae r1 = r12.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzea.zzat
            boolean r1 = r1.zzn(r4, r2)
            if (r1 != 0) goto L_0x0375
            long r1 = r13.zzl
            long r3 = r0.zzad()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0375
            long r1 = r13.zzl
            r0.zzae(r1)
            r6 = 1
        L_0x0375:
            boolean r1 = r13.zzo
            boolean r2 = r0.zzaf()
            if (r1 == r2) goto L_0x0383
            boolean r1 = r13.zzo
            r0.zzag(r1)
            r6 = 1
        L_0x0383:
            java.lang.Boolean r1 = r13.zzr
            java.lang.Boolean r2 = r0.zzah()
            if (r1 == r2) goto L_0x0391
            java.lang.Boolean r1 = r13.zzr
            r0.zzai(r1)
            goto L_0x0392
        L_0x0391:
            r9 = r6
        L_0x0392:
            long r1 = r13.zzs
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x03a6
            long r3 = r0.zzD()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x03a6
            long r1 = r13.zzs
            r0.zzE(r1)
            goto L_0x03a8
        L_0x03a6:
            if (r9 == 0) goto L_0x03b0
        L_0x03a8:
            com.google.android.gms.measurement.internal.zzai r13 = r12.zze
            zzal(r13)
            r13.zzt(r0)
        L_0x03b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzU(com.google.android.gms.measurement.internal.zzp):com.google.android.gms.measurement.internal.zzg");
    }

    /* access modifiers changed from: package-private */
    public final String zzV(zzp zzp2) {
        try {
            return (String) zzav().zze(new zzke(this, zzp2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzau().zzb().zzc("Failed to get app instance id. appId", zzem.zzl(zzp2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(boolean z) {
        zzag();
    }

    public final zzz zzat() {
        throw null;
    }

    public final zzem zzau() {
        zzfp zzfp = this.zzm;
        Preconditions.checkNotNull(zzfp);
        return zzfp.zzau();
    }

    public final zzfm zzav() {
        zzfp zzfp = this.zzm;
        Preconditions.checkNotNull(zzfp);
        return zzfp.zzav();
    }

    public final Context zzax() {
        return this.zzm.zzax();
    }

    public final Clock zzay() {
        zzfp zzfp = this.zzm;
        Preconditions.checkNotNull(zzfp);
        return zzfp.zzay();
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        zzav().zzg();
        zzai zzai = this.zze;
        zzal(zzai);
        zzai.zzA();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzay().currentTimeMillis());
        }
        zzag();
    }

    public final zzae zzd() {
        zzfp zzfp = this.zzm;
        Preconditions.checkNotNull(zzfp);
        return zzfp.zzc();
    }

    public final zzes zzh() {
        zzes zzes = this.zzd;
        zzal(zzes);
        return zzes;
    }

    public final zzai zzi() {
        zzai zzai = this.zze;
        zzal(zzai);
        return zzai;
    }

    public final zzeu zzj() {
        zzeu zzeu = this.zzf;
        if (zzeu != null) {
            return zzeu;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzhw zzl() {
        zzhw zzhw = this.zzj;
        zzal(zzhw);
        return zzhw;
    }

    public final zzkk zzm() {
        zzkk zzkk = this.zzi;
        zzal(zzkk);
        return zzkk;
    }

    public final zzjg zzn() {
        return this.zzk;
    }

    public final zzeh zzo() {
        return this.zzm.zzm();
    }

    public final zzkp zzq() {
        zzfp zzfp = this.zzm;
        Preconditions.checkNotNull(zzfp);
        return zzfp.zzl();
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        if (!this.zzn) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs(String str, zzaf zzaf) {
        zzlf.zzb();
        zzae zzd2 = zzd();
        zzdz<Boolean> zzdz = zzea.zzaw;
        if (zzd2.zzn((String) null, zzdz)) {
            zzav().zzg();
            zzr();
            this.zzA.put(str, zzaf);
            zzai zzai = this.zze;
            zzal(zzai);
            zzlf.zzb();
            if (zzai.zzs.zzc().zzn((String) null, zzdz)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzaf);
                zzai.zzg();
                zzai.zzZ();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzaf.zzd());
                try {
                    if (zzai.zze().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        zzai.zzs.zzau().zzb().zzb("Failed to insert/update consent setting (got -1). appId", zzem.zzl(str));
                    }
                } catch (SQLiteException e) {
                    zzai.zzs.zzau().zzb().zzc("Error storing consent setting. appId, error", zzem.zzl(str), e);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String, android.database.Cursor] */
    /* access modifiers changed from: package-private */
    public final zzaf zzt(String str) {
        String str2;
        zzaf zzaf = zzaf.zza;
        zzlf.zzb();
        ? r3 = 0;
        if (zzd().zzn(r3, zzea.zzaw)) {
            zzav().zzg();
            zzr();
            zzaf = this.zzA.get(str);
            if (zzaf == null) {
                zzai zzai = this.zze;
                zzal(zzai);
                Preconditions.checkNotNull(str);
                zzai.zzg();
                zzai.zzZ();
                try {
                    Cursor rawQuery = zzai.zze().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                    if (rawQuery.moveToFirst()) {
                        str2 = rawQuery.getString(0);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } else {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        str2 = "G1";
                    }
                    zzaf zzc2 = zzaf.zzc(str2);
                    zzs(str, zzc2);
                    return zzc2;
                } catch (SQLiteException e) {
                    zzai.zzs.zzau().zzb().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                    throw e;
                } catch (Throwable th) {
                    if (r3 != 0) {
                        r3.close();
                    }
                    throw th;
                }
            }
        }
        return zzaf;
    }

    /* access modifiers changed from: package-private */
    public final long zzu() {
        long currentTimeMillis = zzay().currentTimeMillis();
        zzjg zzjg = this.zzk;
        zzjg.zzZ();
        zzjg.zzg();
        long zza2 = zzjg.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjg.zzs.zzl().zzf().nextInt(86400000)) + 1;
            zzjg.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zzv(zzas zzas, String str) {
        zzas zzas2 = zzas;
        String str2 = str;
        zzai zzai = this.zze;
        zzal(zzai);
        zzg zzs2 = zzai.zzs(str2);
        if (zzs2 == null || TextUtils.isEmpty(zzs2.zzt())) {
            zzau().zzj().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzai2 = zzai(zzs2);
        if (zzai2 == null) {
            if (!"_ui".equals(zzas2.zza)) {
                zzau().zze().zzb("Could not find package. appId", zzem.zzl(str));
            }
        } else if (!zzai2.booleanValue()) {
            zzau().zzb().zzb("App version does not match; dropping event. appId", zzem.zzl(str));
            return;
        }
        String zzf2 = zzs2.zzf();
        String zzt2 = zzs2.zzt();
        long zzv2 = zzs2.zzv();
        String zzx2 = zzs2.zzx();
        long zzz2 = zzs2.zzz();
        long zzB2 = zzs2.zzB();
        boolean zzF = zzs2.zzF();
        String zzn2 = zzs2.zzn();
        long zzad = zzs2.zzad();
        boolean zzaf = zzs2.zzaf();
        String zzh2 = zzs2.zzh();
        Boolean zzah = zzs2.zzah();
        long zzD = zzs2.zzD();
        List<String> zzaj = zzs2.zzaj();
        zzmg.zzb();
        String zzj2 = zzd().zzn(zzs2.zzc(), zzea.zzag) ? zzs2.zzj() : null;
        zzlf.zzb();
        zzp zzp2 = r2;
        zzp zzp3 = new zzp(str, zzf2, zzt2, zzv2, zzx2, zzz2, zzB2, (String) null, zzF, false, zzn2, zzad, 0, 0, zzaf, false, zzh2, zzah, zzD, zzaj, zzj2, zzd().zzn((String) null, zzea.zzaw) ? zzt(str2).zzd() : "");
        zzx(zzas, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzx(zzas zzas, zzp zzp2) {
        Preconditions.checkNotEmpty(zzp2.zza);
        zzen zza2 = zzen.zza(zzas);
        zzkp zzq2 = zzq();
        Bundle bundle = zza2.zzd;
        zzai zzai = this.zze;
        zzal(zzai);
        zzq2.zzH(bundle, zzai.zzK(zzp2.zza));
        zzq().zzG(zza2, zzd().zzd(zzp2.zza));
        zzas zzb2 = zza2.zzb();
        if (zzd().zzn((String) null, zzea.zzab) && "_cmp".equals(zzb2.zza) && "referrer API v2".equals(zzb2.zzb.zzd("_cis"))) {
            String zzd2 = zzb2.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zzK(new zzkl("_lgclid", zzb2.zzd, zzd2, "auto"), zzp2);
            }
        }
        zzy(zzb2, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzy(zzas zzas, zzp zzp2) {
        List<zzaa> list;
        List<zzaa> list2;
        List<zzaa> list3;
        zzas zzas2 = zzas;
        zzp zzp3 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp3.zza);
        zzav().zzg();
        zzr();
        String str = zzp3.zza;
        long j = zzas2.zzd;
        zzal(this.zzi);
        if (zzkk.zzy(zzas, zzp2)) {
            if (!zzp3.zzh) {
                zzU(zzp3);
                return;
            }
            List<String> list4 = zzp3.zzt;
            if (list4 != null) {
                if (list4.contains(zzas2.zza)) {
                    Bundle zzf2 = zzas2.zzb.zzf();
                    zzf2.putLong("ga_safelisted", 1);
                    zzas2 = new zzas(zzas2.zza, new zzaq(zzf2), zzas2.zzc, zzas2.zzd);
                } else {
                    zzau().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str, zzas2.zza, zzas2.zzc);
                    return;
                }
            }
            zzai zzai = this.zze;
            zzal(zzai);
            zzai.zzb();
            try {
                zzai zzai2 = this.zze;
                zzal(zzai2);
                Preconditions.checkNotEmpty(str);
                zzai2.zzg();
                zzai2.zzZ();
                if (j < 0) {
                    zzai2.zzs.zzau().zze().zzc("Invalid time querying timed out conditional properties", zzem.zzl(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzai2.zzr("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzaa next : list) {
                    if (next != null) {
                        zzau().zzk().zzd("User property timed out", next.zza, this.zzm.zzm().zze(next.zzc.zzb), next.zzc.zza());
                        zzas zzas3 = next.zzg;
                        if (zzas3 != null) {
                            zzz(new zzas(zzas3, j), zzp3);
                        }
                        zzai zzai3 = this.zze;
                        zzal(zzai3);
                        zzai3.zzp(str, next.zzc.zzb);
                    }
                }
                zzai zzai4 = this.zze;
                zzal(zzai4);
                Preconditions.checkNotEmpty(str);
                zzai4.zzg();
                zzai4.zzZ();
                if (j < 0) {
                    zzai4.zzs.zzau().zze().zzc("Invalid time querying expired conditional properties", zzem.zzl(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzai4.zzr("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList<zzas> arrayList = new ArrayList<>(list2.size());
                for (zzaa next2 : list2) {
                    if (next2 != null) {
                        zzau().zzk().zzd("User property expired", next2.zza, this.zzm.zzm().zze(next2.zzc.zzb), next2.zzc.zza());
                        zzai zzai5 = this.zze;
                        zzal(zzai5);
                        zzai5.zzi(str, next2.zzc.zzb);
                        zzas zzas4 = next2.zzk;
                        if (zzas4 != null) {
                            arrayList.add(zzas4);
                        }
                        zzai zzai6 = this.zze;
                        zzal(zzai6);
                        zzai6.zzp(str, next2.zzc.zzb);
                    }
                }
                for (zzas zzas5 : arrayList) {
                    zzz(new zzas(zzas5, j), zzp3);
                }
                zzai zzai7 = this.zze;
                zzal(zzai7);
                String str2 = zzas2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzai7.zzg();
                zzai7.zzZ();
                if (j < 0) {
                    zzai7.zzs.zzau().zze().zzd("Invalid time querying triggered conditional properties", zzem.zzl(str), zzai7.zzs.zzm().zzc(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzai7.zzr("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList<zzas> arrayList2 = new ArrayList<>(list3.size());
                for (zzaa next3 : list3) {
                    if (next3 != null) {
                        zzkl zzkl = next3.zzc;
                        String str3 = next3.zza;
                        Preconditions.checkNotNull(str3);
                        String str4 = next3.zzb;
                        String str5 = zzkl.zzb;
                        Object zza2 = zzkl.zza();
                        Preconditions.checkNotNull(zza2);
                        zzkn zzkn = new zzkn(str3, str4, str5, j, zza2);
                        zzai zzai8 = this.zze;
                        zzal(zzai8);
                        if (zzai8.zzj(zzkn)) {
                            zzau().zzk().zzd("User property triggered", next3.zza, this.zzm.zzm().zze(zzkn.zzc), zzkn.zze);
                        } else {
                            zzau().zzb().zzd("Too many active user properties, ignoring", zzem.zzl(next3.zza), this.zzm.zzm().zze(zzkn.zzc), zzkn.zze);
                        }
                        zzas zzas6 = next3.zzi;
                        if (zzas6 != null) {
                            arrayList2.add(zzas6);
                        }
                        next3.zzc = new zzkl(zzkn);
                        next3.zze = true;
                        zzai zzai9 = this.zze;
                        zzal(zzai9);
                        zzai9.zzn(next3);
                    }
                }
                zzz(zzas2, zzp3);
                for (zzas zzas7 : arrayList2) {
                    zzz(new zzas(zzas7, j), zzp3);
                }
                zzai zzai10 = this.zze;
                zzal(zzai10);
                zzai10.zzc();
            } finally {
                zzai zzai11 = this.zze;
                zzal(zzai11);
                zzai11.zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x07f6, code lost:
        if (r14.size() == 0) goto L_0x07f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0a5a, code lost:
        r17 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0325 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x037c A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x037f A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03e1 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0578 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05b6 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x063a A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0685 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0692 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x069f A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x06ad A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x06be A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06d3 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0700 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0739 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0758 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0773 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x07fb A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x084a A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0897 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08a4 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x08d1 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0957 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x099d A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x09bb A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a50 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0afc A[Catch:{ SQLiteException -> 0x0b17 }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0b12  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0a5d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a7 A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01be A[SYNTHETIC, Splitter:B:57:0x01be] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x023c A[Catch:{ NumberFormatException -> 0x07e0, all -> 0x0b9b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzz(com.google.android.gms.measurement.internal.zzas r33, com.google.android.gms.measurement.internal.zzp r34) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            r3 = r34
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r34)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfm r10 = r32.zzav()
            r10.zzg()
            r32.zzr()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzkk r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzkk.zzy(r33, r34)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0ba6
            com.google.android.gms.measurement.internal.zzfg r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzi(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.zzem r3 = r32.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zze()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r10)
            com.google.android.gms.measurement.internal.zzfp r5 = r1.zzm
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzc(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfg r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzl(r10)
            if (r3 != 0) goto L_0x00a2
            com.google.android.gms.measurement.internal.zzfg r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzm(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x00a2
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()
            com.google.android.gms.measurement.internal.zzko r12 = r1.zzB
            r3 = 11
            java.lang.String r2 = r2.zza
            r17 = 0
            com.google.android.gms.measurement.internal.zzae r4 = r32.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzea.zzay
            boolean r18 = r4.zzn(r14, r5)
            java.lang.String r15 = "_ev"
            r13 = r10
            r14 = r3
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17, r18)
            return
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzs(r10)
            if (r2 == 0) goto L_0x00e9
            long r3 = r2.zzL()
            long r5 = r2.zzJ()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r32.zzay()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r32.zzd()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzea.zzy
            java.lang.Object r5 = r5.zzb(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.zzem r3 = r32.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzj()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zzE(r2)
        L_0x00e9:
            return
        L_0x00ea:
            com.google.android.gms.measurement.internal.zzen r2 = com.google.android.gms.measurement.internal.zzen.zza(r33)
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()
            com.google.android.gms.measurement.internal.zzae r12 = r32.zzd()
            int r12 = r12.zzd(r10)
            r11.zzG(r2, r12)
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzb()
            com.google.android.gms.measurement.internal.zzem r11 = r32.zzau()
            java.lang.String r11 = r11.zzn()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x0170
            com.google.android.gms.measurement.internal.zzem r11 = r32.zzau()
            com.google.android.gms.measurement.internal.zzek r11 = r11.zzk()
            com.google.android.gms.measurement.internal.zzfp r12 = r1.zzm
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzm()
            boolean r16 = r12.zzb()
            if (r16 != 0) goto L_0x0129
            java.lang.String r12 = r2.toString()
            goto L_0x016b
        L_0x0129:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "origin="
            r13.append(r14)
            java.lang.String r14 = r2.zzc
            r13.append(r14)
            java.lang.String r14 = ",name="
            r13.append(r14)
            java.lang.String r14 = r2.zza
            java.lang.String r14 = r12.zzc(r14)
            r13.append(r14)
            java.lang.String r14 = ",params="
            r13.append(r14)
            com.google.android.gms.measurement.internal.zzaq r14 = r2.zzb
            if (r14 != 0) goto L_0x0151
            r12 = 0
            goto L_0x0164
        L_0x0151:
            boolean r17 = r12.zzb()
            if (r17 != 0) goto L_0x015c
            java.lang.String r12 = r14.toString()
            goto L_0x0164
        L_0x015c:
            android.os.Bundle r14 = r14.zzf()
            java.lang.String r12 = r12.zzf(r14)
        L_0x0164:
            r13.append(r12)
            java.lang.String r12 = r13.toString()
        L_0x016b:
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x0170:
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze
            zzal(r11)
            r11.zzb()
            r1.zzU(r3)     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = "refund"
            if (r11 != 0) goto L_0x019c
            java.lang.String r11 = "purchase"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x019c
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x019a
            goto L_0x019c
        L_0x019a:
            r11 = 0
            goto L_0x019d
        L_0x019c:
            r11 = 1
        L_0x019d:
            java.lang.String r13 = "_iap"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0b9b }
            if (r13 != 0) goto L_0x01b2
            if (r11 == 0) goto L_0x01ab
            r11 = 1
            goto L_0x01b2
        L_0x01ab:
            r28 = r8
            r30 = r15
        L_0x01af:
            r8 = 2
            goto L_0x0367
        L_0x01b2:
            com.google.android.gms.measurement.internal.zzaq r13 = r2.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.String r14 = "currency"
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0b9b }
            java.lang.String r14 = "value"
            if (r11 == 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.Double r11 = r11.zzc(r14)     // Catch:{ all -> 0x0b9b }
            double r19 = r11.doubleValue()     // Catch:{ all -> 0x0b9b }
            r21 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r19 = r19 * r21
            r23 = 0
            int r11 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r11 != 0) goto L_0x01e8
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.Long r11 = r11.zzb(r14)     // Catch:{ all -> 0x0b9b }
            r23 = r15
            long r14 = r11.longValue()     // Catch:{ all -> 0x0b9b }
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r19 = r14 * r21
            goto L_0x01ea
        L_0x01e8:
            r23 = r15
        L_0x01ea:
            r14 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r11 = (r19 > r14 ? 1 : (r19 == r14 ? 0 : -1))
            if (r11 > 0) goto L_0x0204
            r14 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r11 = (r19 > r14 ? 1 : (r19 == r14 ? 0 : -1))
            if (r11 < 0) goto L_0x0204
            long r14 = java.lang.Math.round(r19)     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x0236
            long r14 = -r14
            goto L_0x0236
        L_0x0204:
            com.google.android.gms.measurement.internal.zzem r2 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()     // Catch:{ all -> 0x0b9b }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            java.lang.Double r5 = java.lang.Double.valueOf(r19)     // Catch:{ all -> 0x0b9b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            r2.zzc()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            return
        L_0x022a:
            r23 = r15
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.Long r11 = r11.zzb(r14)     // Catch:{ all -> 0x0b9b }
            long r14 = r11.longValue()     // Catch:{ all -> 0x0b9b }
        L_0x0236:
            boolean r11 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x0361
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = r13.toUpperCase(r11)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = "[A-Z]{3}"
            boolean r12 = r11.matches(r12)     // Catch:{ all -> 0x0b9b }
            if (r12 == 0) goto L_0x0361
            java.lang.String r12 = "_ltv_"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0b9b }
            int r13 = r11.length()     // Catch:{ all -> 0x0b9b }
            if (r13 == 0) goto L_0x025c
            java.lang.String r11 = r12.concat(r11)     // Catch:{ all -> 0x0b9b }
        L_0x025a:
            r13 = r11
            goto L_0x0262
        L_0x025c:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0b9b }
            r11.<init>(r12)     // Catch:{ all -> 0x0b9b }
            goto L_0x025a
        L_0x0262:
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r11)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r11 = r11.zzk(r10, r13)     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x02a8
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b9b }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b9b }
            if (r12 != 0) goto L_0x0274
            goto L_0x02a8
        L_0x0274:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0b9b }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r19 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x0b9b }
            r20 = r13
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.util.Clock r21 = r32.zzay()     // Catch:{ all -> 0x0b9b }
            long r21 = r21.currentTimeMillis()     // Catch:{ all -> 0x0b9b }
            long r11 = r11 + r14
            java.lang.Long r24 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b9b }
            r11 = r19
            r12 = r10
            r17 = r20
            r14 = 1
            r15 = 2
            r28 = r8
            r8 = 0
            r9 = 1
            r14 = r17
            r30 = r23
            r15 = r21
            r17 = r24
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b9b }
            r9 = r19
            r8 = 2
            goto L_0x031a
        L_0x02a8:
            r28 = r8
            r17 = r13
            r30 = r23
            r8 = 0
            r9 = 1
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r11)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r12 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzea.zzD     // Catch:{ all -> 0x0b9b }
            int r12 = r12.zzk(r10, r13)     // Catch:{ all -> 0x0b9b }
            int r12 = r12 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b9b }
            r11.zzg()     // Catch:{ all -> 0x0b9b }
            r11.zzZ()     // Catch:{ all -> 0x0b9b }
            android.database.sqlite.SQLiteDatabase r13 = r11.zze()     // Catch:{ SQLiteException -> 0x02e6 }
            r9 = 3
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x02e6 }
            r9[r8] = r10     // Catch:{ SQLiteException -> 0x02e6 }
            r16 = 1
            r9[r16] = r10     // Catch:{ SQLiteException -> 0x02e6 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteException -> 0x02e6 }
            r8 = 2
            r9[r8] = r12     // Catch:{ SQLiteException -> 0x02e4 }
            java.lang.String r12 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r13.execSQL(r12, r9)     // Catch:{ SQLiteException -> 0x02e4 }
            goto L_0x02fc
        L_0x02e4:
            r0 = move-exception
            goto L_0x02e8
        L_0x02e6:
            r0 = move-exception
            r8 = 2
        L_0x02e8:
            r9 = r0
            com.google.android.gms.measurement.internal.zzfp r11 = r11.zzs     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r11 = r11.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            r11.zzc(r12, r13, r9)     // Catch:{ all -> 0x0b9b }
        L_0x02fc:
            com.google.android.gms.measurement.internal.zzkn r19 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.util.Clock r9 = r32.zzay()     // Catch:{ all -> 0x0b9b }
            long r20 = r9.currentTimeMillis()     // Catch:{ all -> 0x0b9b }
            java.lang.Long r9 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0b9b }
            r11 = r19
            r12 = r10
            r14 = r17
            r15 = r20
            r17 = r9
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b9b }
            r9 = r19
        L_0x031a:
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r11)     // Catch:{ all -> 0x0b9b }
            boolean r11 = r11.zzj(r9)     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x0367
            com.google.android.gms.measurement.internal.zzem r11 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r11 = r11.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r14 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzm()     // Catch:{ all -> 0x0b9b }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0b9b }
            java.lang.String r14 = r14.zze(r15)     // Catch:{ all -> 0x0b9b }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b9b }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzko r12 = r1.zzB     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r9 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzea.zzay     // Catch:{ all -> 0x0b9b }
            r14 = 0
            boolean r18 = r9.zzn(r14, r13)     // Catch:{ all -> 0x0b9b }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0b9b }
            goto L_0x0367
        L_0x0361:
            r28 = r8
            r30 = r23
            goto L_0x01af
        L_0x0367:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r9 = com.google.android.gms.measurement.internal.zzkp.zzh(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b9b }
            r12 = r30
            boolean r22 = r12.equals(r11)     // Catch:{ all -> 0x0b9b }
            r32.zzq()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaq r11 = r2.zzb     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x037f
            r16 = 0
            goto L_0x039f
        L_0x037f:
            com.google.android.gms.measurement.internal.zzap r12 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0b9b }
            r12.<init>(r11)     // Catch:{ all -> 0x0b9b }
            r16 = 0
        L_0x0386:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0b9b }
            if (r13 == 0) goto L_0x039f
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0b9b }
            java.lang.Object r13 = r11.zza(r13)     // Catch:{ all -> 0x0b9b }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0b9b }
            if (r14 == 0) goto L_0x0386
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0b9b }
            int r13 = r13.length     // Catch:{ all -> 0x0b9b }
            long r13 = (long) r13     // Catch:{ all -> 0x0b9b }
            long r16 = r16 + r13
            goto L_0x0386
        L_0x039f:
            r23 = 1
            long r16 = r16 + r23
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r11)     // Catch:{ all -> 0x0b9b }
            long r12 = r32.zzu()     // Catch:{ all -> 0x0b9b }
            r20 = 1
            r21 = 0
            r25 = 0
            r14 = r10
            r15 = r16
            r17 = r20
            r18 = r9
            r19 = r21
            r20 = r22
            r21 = r25
            com.google.android.gms.measurement.internal.zzag r11 = r11.zzv(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0b9b }
            long r12 = r11.zzb     // Catch:{ all -> 0x0b9b }
            r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzea.zzj     // Catch:{ all -> 0x0b9b }
            r15 = 0
            java.lang.Object r14 = r14.zzb(r15)     // Catch:{ all -> 0x0b9b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0b9b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0b9b }
            long r14 = (long) r14     // Catch:{ all -> 0x0b9b }
            long r12 = r12 - r14
            r14 = 1000(0x3e8, double:4.94E-321)
            r21 = r9
            r8 = 0
            int r16 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r16 <= 0) goto L_0x040e
            long r12 = r12 % r14
            int r2 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x03fd
            com.google.android.gms.measurement.internal.zzem r2 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            long r5 = r11.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b9b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b9b }
        L_0x03fd:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            r2.zzc()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            return
        L_0x040e:
            if (r21 == 0) goto L_0x0476
            long r12 = r11.zza     // Catch:{ all -> 0x0b9b }
            r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzea.zzl     // Catch:{ all -> 0x0b9b }
            r15 = 0
            java.lang.Object r14 = r14.zzb(r15)     // Catch:{ all -> 0x0b9b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0b9b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0b9b }
            long r14 = (long) r14     // Catch:{ all -> 0x0b9b }
            long r12 = r12 - r14
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 <= 0) goto L_0x0476
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r14
            int r3 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r3 != 0) goto L_0x0446
            com.google.android.gms.measurement.internal.zzem r3 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            long r6 = r11.zza     // Catch:{ all -> 0x0b9b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b9b }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0b9b }
        L_0x0446:
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzko r12 = r1.zzB     // Catch:{ all -> 0x0b9b }
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r3 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzea.zzay     // Catch:{ all -> 0x0b9b }
            r5 = 0
            boolean r18 = r3.zzn(r5, r4)     // Catch:{ all -> 0x0b9b }
            r14 = 16
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            r2.zzc()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            return
        L_0x0476:
            r12 = 1000000(0xf4240, float:1.401298E-39)
            if (r22 == 0) goto L_0x04c6
            long r13 = r11.zzd     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r15 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzea.zzk     // Catch:{ all -> 0x0b9b }
            int r8 = r15.zzk(r8, r9)     // Catch:{ all -> 0x0b9b }
            int r8 = java.lang.Math.min(r12, r8)     // Catch:{ all -> 0x0b9b }
            r9 = 0
            int r8 = java.lang.Math.max(r9, r8)     // Catch:{ all -> 0x0b9b }
            long r8 = (long) r8     // Catch:{ all -> 0x0b9b }
            long r13 = r13 - r8
            r8 = 0
            int r15 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r15 <= 0) goto L_0x04c6
            int r2 = (r13 > r23 ? 1 : (r13 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x04b5
            com.google.android.gms.measurement.internal.zzem r2 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            long r5 = r11.zzd     // Catch:{ all -> 0x0b9b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b9b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b9b }
        L_0x04b5:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            r2.zzc()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            return
        L_0x04c6:
            com.google.android.gms.measurement.internal.zzaq r8 = r2.zzb     // Catch:{ all -> 0x0b9b }
            android.os.Bundle r8 = r8.zzf()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkp r9 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = "_o"
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b9b }
            r9.zzL(r8, r11, r13)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkp r9 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            boolean r9 = r9.zzT(r10)     // Catch:{ all -> 0x0b9b }
            java.lang.String r15 = "_r"
            if (r9 == 0) goto L_0x04f7
            com.google.android.gms.measurement.internal.zzkp r9 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            java.lang.Long r11 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = "_dbg"
            r9.zzL(r8, r13, r11)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkp r9 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            r9.zzL(r8, r15, r11)     // Catch:{ all -> 0x0b9b }
        L_0x04f7:
            java.lang.String r9 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b9b }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x051d
            com.google.android.gms.measurement.internal.zzai r9 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r9 = r9.zzk(r11, r7)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x051d
            java.lang.Object r11 = r9.zze     // Catch:{ all -> 0x0b9b }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x051d
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b9b }
            r11.zzL(r8, r7, r9)     // Catch:{ all -> 0x0b9b }
        L_0x051d:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r7)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b9b }
            r7.zzg()     // Catch:{ all -> 0x0b9b }
            r7.zzZ()     // Catch:{ all -> 0x0b9b }
            android.database.sqlite.SQLiteDatabase r9 = r7.zze()     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzfp r11 = r7.zzs     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc()     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzea.zzo     // Catch:{ SQLiteException -> 0x055a }
            int r11 = r11.zzk(r10, r13)     // Catch:{ SQLiteException -> 0x055a }
            int r11 = java.lang.Math.min(r12, r11)     // Catch:{ SQLiteException -> 0x055a }
            r14 = 0
            int r11 = java.lang.Math.max(r14, r11)     // Catch:{ SQLiteException -> 0x0558 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0558 }
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0558 }
            r12[r14] = r10     // Catch:{ SQLiteException -> 0x0558 }
            r13 = 1
            r12[r13] = r11     // Catch:{ SQLiteException -> 0x0558 }
            java.lang.String r11 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r7 = r9.delete(r6, r11, r12)     // Catch:{ SQLiteException -> 0x0558 }
            long r11 = (long) r7
            goto L_0x0572
        L_0x0558:
            r0 = move-exception
            goto L_0x055c
        L_0x055a:
            r0 = move-exception
            r14 = 0
        L_0x055c:
            r9 = r0
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zzs     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = "Error deleting over the limit events. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            r7.zzc(r11, r12, r9)     // Catch:{ all -> 0x0b9b }
            r11 = 0
        L_0x0572:
            r16 = 0
            int r7 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x058d
            com.google.android.gms.measurement.internal.zzem r7 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r7 = r7.zze()     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b9b }
            r7.zzc(r9, r13, r11)     // Catch:{ all -> 0x0b9b }
        L_0x058d:
            com.google.android.gms.measurement.internal.zzan r7 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r12 = r1.zzm     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b9b }
            r30 = r4
            r31 = r5
            long r4 = r2.zzd     // Catch:{ all -> 0x0b9b }
            r18 = 0
            r11 = r7
            r2 = 0
            r14 = r10
            r2 = r15
            r15 = r9
            r16 = r4
            r20 = r8
            r11.<init>((com.google.android.gms.measurement.internal.zzfp) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r4 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r4)     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzao r4 = r4.zzf(r10, r5)     // Catch:{ all -> 0x0b9b }
            if (r4 != 0) goto L_0x063a
            com.google.android.gms.measurement.internal.zzai r4 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r4)     // Catch:{ all -> 0x0b9b }
            long r4 = r4.zzI(r10)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r8 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            int r8 = r8.zze(r10)     // Catch:{ all -> 0x0b9b }
            long r8 = (long) r8     // Catch:{ all -> 0x0b9b }
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 < 0) goto L_0x061c
            if (r21 == 0) goto L_0x061c
            com.google.android.gms.measurement.internal.zzem r2 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r10)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r5 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x0b9b }
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r5.zzc(r6)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r6 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            int r6 = r6.zze(r10)     // Catch:{ all -> 0x0b9b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b9b }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkp r11 = r32.zzq()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzko r12 = r1.zzB     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r2 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzay     // Catch:{ all -> 0x0b9b }
            r4 = 0
            boolean r18 = r2.zzn(r4, r3)     // Catch:{ all -> 0x0b9b }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            return
        L_0x061c:
            com.google.android.gms.measurement.internal.zzao r4 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = r7.zzb     // Catch:{ all -> 0x0b9b }
            long r8 = r7.zzd     // Catch:{ all -> 0x0b9b }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r8
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0b9b }
            goto L_0x0648
        L_0x063a:
            com.google.android.gms.measurement.internal.zzfp r5 = r1.zzm     // Catch:{ all -> 0x0b9b }
            long r8 = r4.zzf     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzan r7 = r7.zza(r5, r8)     // Catch:{ all -> 0x0b9b }
            long r8 = r7.zzd     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzao r4 = r4.zza(r8)     // Catch:{ all -> 0x0b9b }
        L_0x0648:
            com.google.android.gms.measurement.internal.zzai r5 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r5)     // Catch:{ all -> 0x0b9b }
            r5.zzh(r4)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfm r4 = r32.zzav()     // Catch:{ all -> 0x0b9b }
            r4.zzg()     // Catch:{ all -> 0x0b9b }
            r32.zzr()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r34)     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0b9b }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.internal.measurement.zzdj r4 = com.google.android.gms.internal.measurement.zzdk.zzaj()     // Catch:{ all -> 0x0b9b }
            r5 = 1
            r4.zza(r5)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = "android"
            r4.zzA(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x068a
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b9b }
            r4.zzH(r8)     // Catch:{ all -> 0x0b9b }
        L_0x068a:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x0697
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0b9b }
            r4.zzF(r8)     // Catch:{ all -> 0x0b9b }
        L_0x0697:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x06a4
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0b9b }
            r4.zzI(r8)     // Catch:{ all -> 0x0b9b }
        L_0x06a4:
            long r8 = r3.zzj     // Catch:{ all -> 0x0b9b }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06b1
            int r9 = (int) r8     // Catch:{ all -> 0x0b9b }
            r4.zzab(r9)     // Catch:{ all -> 0x0b9b }
        L_0x06b1:
            long r8 = r3.zze     // Catch:{ all -> 0x0b9b }
            r4.zzJ(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x06c3
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0b9b }
            r4.zzW(r8)     // Catch:{ all -> 0x0b9b }
        L_0x06c3:
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r8 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x0b9b }
            r10 = 0
            boolean r8 = r8.zzn(r10, r9)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x06ef
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzt(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r9 = com.google.android.gms.measurement.internal.zzaf.zzc(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = r8.zzd()     // Catch:{ all -> 0x0b9b }
            r4.zzap(r8)     // Catch:{ all -> 0x0b9b }
        L_0x06ef:
            com.google.android.gms.internal.measurement.zzmg.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r8 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzea.zzag     // Catch:{ all -> 0x0b9b }
            boolean r8 = r8.zzn(r9, r10)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0739
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0717
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x0717
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0b9b }
            r4.zzao(r8)     // Catch:{ all -> 0x0b9b }
        L_0x0717:
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0750
            java.lang.String r8 = r4.zzan()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0750
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x0750
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b9b }
            r4.zzai(r8)     // Catch:{ all -> 0x0b9b }
            goto L_0x0750
        L_0x0739:
            java.lang.String r8 = r4.zzV()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0750
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x0750
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0b9b }
            r4.zzai(r8)     // Catch:{ all -> 0x0b9b }
        L_0x0750:
            long r8 = r3.zzf     // Catch:{ all -> 0x0b9b }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x075b
            r4.zzR(r8)     // Catch:{ all -> 0x0b9b }
        L_0x075b:
            long r8 = r3.zzs     // Catch:{ all -> 0x0b9b }
            r4.zzal(r8)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkk r8 = r1.zzi     // Catch:{ all -> 0x0b9b }
            zzal(r8)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzki r9 = r8.zzf     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r9 = r9.zzm     // Catch:{ all -> 0x0b9b }
            android.content.Context r9 = r9.zzax()     // Catch:{ all -> 0x0b9b }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzea.zza(r9)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x07f8
            int r10 = r9.size()     // Catch:{ all -> 0x0b9b }
            if (r10 != 0) goto L_0x077b
            goto L_0x07f8
        L_0x077b:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0b9b }
            r14.<init>()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzea.zzO     // Catch:{ all -> 0x0b9b }
            r11 = 0
            java.lang.Object r10 = r10.zzb(r11)     // Catch:{ all -> 0x0b9b }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0b9b }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0b9b }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0b9b }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0b9b }
        L_0x0795:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x07f2
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0b9b }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0b9b }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0b9b }
            if (r12 == 0) goto L_0x0795
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x07e0 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            if (r11 == 0) goto L_0x0795
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x07e0 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x07e0 }
            if (r11 < r10) goto L_0x0795
            com.google.android.gms.measurement.internal.zzfp r11 = r8.zzs     // Catch:{ NumberFormatException -> 0x07e0 }
            com.google.android.gms.measurement.internal.zzem r11 = r11.zzau()     // Catch:{ NumberFormatException -> 0x07e0 }
            com.google.android.gms.measurement.internal.zzek r11 = r11.zze()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x07e0 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x07e0 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x07e0 }
            goto L_0x07f2
        L_0x07e0:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfp r12 = r8.zzs     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r12 = r12.zze()     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0b9b }
            goto L_0x0795
        L_0x07f2:
            int r8 = r14.size()     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x07f9
        L_0x07f8:
            r14 = 0
        L_0x07f9:
            if (r14 == 0) goto L_0x07fe
            r4.zzak(r14)     // Catch:{ all -> 0x0b9b }
        L_0x07fe:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r8 = r1.zzt(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r9 = com.google.android.gms.measurement.internal.zzaf.zzc(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r9 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzea.zzaw     // Catch:{ all -> 0x0b9b }
            r11 = 0
            boolean r9 = r9.zzn(r11, r10)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x0829
            boolean r9 = r8.zzf()     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x0853
        L_0x0829:
            com.google.android.gms.measurement.internal.zzjg r9 = r1.zzk     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0b9b }
            android.util.Pair r9 = r9.zzc(r11, r8)     // Catch:{ all -> 0x0b9b }
            java.lang.Object r11 = r9.first     // Catch:{ all -> 0x0b9b }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x0b9b }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x0853
            boolean r11 = r3.zzo     // Catch:{ all -> 0x0b9b }
            if (r11 == 0) goto L_0x0853
            java.lang.Object r11 = r9.first     // Catch:{ all -> 0x0b9b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0b9b }
            r4.zzL(r11)     // Catch:{ all -> 0x0b9b }
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x0853
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0b9b }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0b9b }
            r4.zzN(r9)     // Catch:{ all -> 0x0b9b }
        L_0x0853:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b9b }
            r9.zzv()     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0b9b }
            r4.zzC(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b9b }
            r9.zzv()     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0b9b }
            r4.zzB(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b9b }
            long r11 = r9.zzb()     // Catch:{ all -> 0x0b9b }
            int r9 = (int) r11     // Catch:{ all -> 0x0b9b }
            r4.zzE(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzam r9 = r9.zzz()     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0b9b }
            r4.zzD(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r9 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzea.zzat     // Catch:{ all -> 0x0b9b }
            r12 = 0
            boolean r9 = r9.zzn(r12, r11)     // Catch:{ all -> 0x0b9b }
            if (r9 != 0) goto L_0x089c
            long r12 = r3.zzl     // Catch:{ all -> 0x0b9b }
            r4.zzae(r12)     // Catch:{ all -> 0x0b9b }
        L_0x089c:
            com.google.android.gms.measurement.internal.zzfp r9 = r1.zzm     // Catch:{ all -> 0x0b9b }
            boolean r9 = r9.zzF()     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x08c4
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r9 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            r12 = 0
            boolean r9 = r9.zzn(r12, r10)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x08b6
            r4.zzG()     // Catch:{ all -> 0x0b9b }
            goto L_0x08b9
        L_0x08b6:
            r4.zzG()     // Catch:{ all -> 0x0b9b }
        L_0x08b9:
            boolean r9 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0b9b }
            if (r9 == 0) goto L_0x08c0
            goto L_0x08c4
        L_0x08c0:
            r4.zzaf(r12)     // Catch:{ all -> 0x0b9b }
            throw r12
        L_0x08c4:
            com.google.android.gms.measurement.internal.zzai r9 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzs(r12)     // Catch:{ all -> 0x0b9b }
            if (r9 != 0) goto L_0x0969
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzfp r12 = r1.zzm     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0b9b }
            r9.<init>(r12, r13)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r12 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            r13 = 0
            boolean r12 = r12.zzn(r13, r10)     // Catch:{ all -> 0x0b9b }
            if (r12 == 0) goto L_0x08f0
            java.lang.String r12 = r1.zzA(r8)     // Catch:{ all -> 0x0b9b }
            r9.zze(r12)     // Catch:{ all -> 0x0b9b }
            goto L_0x08f7
        L_0x08f0:
            java.lang.String r12 = r32.zzB()     // Catch:{ all -> 0x0b9b }
            r9.zze(r12)     // Catch:{ all -> 0x0b9b }
        L_0x08f7:
            java.lang.String r12 = r3.zzk     // Catch:{ all -> 0x0b9b }
            r9.zzo(r12)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = r3.zzb     // Catch:{ all -> 0x0b9b }
            r9.zzg(r12)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r12 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            r13 = 0
            boolean r12 = r12.zzn(r13, r10)     // Catch:{ all -> 0x0b9b }
            if (r12 == 0) goto L_0x0919
            boolean r12 = r8.zzf()     // Catch:{ all -> 0x0b9b }
            if (r12 == 0) goto L_0x0916
            goto L_0x0919
        L_0x0916:
            r12 = 0
            goto L_0x0925
        L_0x0919:
            com.google.android.gms.measurement.internal.zzjg r12 = r1.zzk     // Catch:{ all -> 0x0b9b }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = r12.zzf(r13)     // Catch:{ all -> 0x0b9b }
            r9.zzm(r12)     // Catch:{ all -> 0x0b9b }
            goto L_0x0916
        L_0x0925:
            r9.zzH(r12)     // Catch:{ all -> 0x0b9b }
            r9.zzq(r12)     // Catch:{ all -> 0x0b9b }
            r9.zzs(r12)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = r3.zzc     // Catch:{ all -> 0x0b9b }
            r9.zzu(r12)     // Catch:{ all -> 0x0b9b }
            long r12 = r3.zzj     // Catch:{ all -> 0x0b9b }
            r9.zzw(r12)     // Catch:{ all -> 0x0b9b }
            java.lang.String r12 = r3.zzd     // Catch:{ all -> 0x0b9b }
            r9.zzy(r12)     // Catch:{ all -> 0x0b9b }
            long r12 = r3.zze     // Catch:{ all -> 0x0b9b }
            r9.zzA(r12)     // Catch:{ all -> 0x0b9b }
            long r12 = r3.zzf     // Catch:{ all -> 0x0b9b }
            r9.zzC(r12)     // Catch:{ all -> 0x0b9b }
            boolean r12 = r3.zzh     // Catch:{ all -> 0x0b9b }
            r9.zzG(r12)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r12 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            r13 = 0
            boolean r11 = r12.zzn(r13, r11)     // Catch:{ all -> 0x0b9b }
            if (r11 != 0) goto L_0x095c
            long r11 = r3.zzl     // Catch:{ all -> 0x0b9b }
            r9.zzae(r11)     // Catch:{ all -> 0x0b9b }
        L_0x095c:
            long r11 = r3.zzs     // Catch:{ all -> 0x0b9b }
            r9.zzE(r11)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r11 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r11)     // Catch:{ all -> 0x0b9b }
            r11.zzt(r9)     // Catch:{ all -> 0x0b9b }
        L_0x0969:
            com.google.android.gms.internal.measurement.zzlf.zzb()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r11 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            r12 = 0
            boolean r10 = r11.zzn(r12, r10)     // Catch:{ all -> 0x0b9b }
            if (r10 == 0) goto L_0x097d
            boolean r8 = r8.zzh()     // Catch:{ all -> 0x0b9b }
            if (r8 == 0) goto L_0x0993
        L_0x097d:
            java.lang.String r8 = r9.zzd()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x0993
            java.lang.String r8 = r9.zzd()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0b9b }
            r4.zzP(r8)     // Catch:{ all -> 0x0b9b }
        L_0x0993:
            java.lang.String r8 = r9.zzn()     // Catch:{ all -> 0x0b9b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b9b }
            if (r8 != 0) goto L_0x09a9
            java.lang.String r8 = r9.zzn()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0b9b }
            r4.zzaa(r8)     // Catch:{ all -> 0x0b9b }
        L_0x09a9:
            com.google.android.gms.measurement.internal.zzai r8 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0b9b }
            java.util.List r3 = r8.zzl(r3)     // Catch:{ all -> 0x0b9b }
            r14 = 0
        L_0x09b5:
            int r8 = r3.size()     // Catch:{ all -> 0x0b9b }
            if (r14 >= r8) goto L_0x09eb
            com.google.android.gms.internal.measurement.zzdu r8 = com.google.android.gms.internal.measurement.zzdv.zzj()     // Catch:{ all -> 0x0b9b }
            java.lang.Object r9 = r3.get(r14)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r9 = (com.google.android.gms.measurement.internal.zzkn) r9     // Catch:{ all -> 0x0b9b }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0b9b }
            r8.zzb(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.Object r9 = r3.get(r14)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r9 = (com.google.android.gms.measurement.internal.zzkn) r9     // Catch:{ all -> 0x0b9b }
            long r9 = r9.zzd     // Catch:{ all -> 0x0b9b }
            r8.zza(r9)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkk r9 = r1.zzi     // Catch:{ all -> 0x0b9b }
            zzal(r9)     // Catch:{ all -> 0x0b9b }
            java.lang.Object r10 = r3.get(r14)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkn r10 = (com.google.android.gms.measurement.internal.zzkn) r10     // Catch:{ all -> 0x0b9b }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0b9b }
            r9.zzc(r8, r10)     // Catch:{ all -> 0x0b9b }
            r4.zzo(r8)     // Catch:{ all -> 0x0b9b }
            int r14 = r14 + 1
            goto L_0x09b5
        L_0x09eb:
            com.google.android.gms.measurement.internal.zzai r3 = r1.zze     // Catch:{ IOException -> 0x0b4f }
            zzal(r3)     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.internal.measurement.zzhr r8 = r4.zzaA()     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.internal.measurement.zzdk r8 = (com.google.android.gms.internal.measurement.zzdk) r8     // Catch:{ IOException -> 0x0b4f }
            r3.zzg()     // Catch:{ IOException -> 0x0b4f }
            r3.zzZ()     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0b4f }
            java.lang.String r9 = r8.zzA()     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0b4f }
            byte[] r9 = r8.zzbp()     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.measurement.internal.zzki r10 = r3.zzf     // Catch:{ IOException -> 0x0b4f }
            com.google.android.gms.measurement.internal.zzkk r10 = r10.zzi     // Catch:{ IOException -> 0x0b4f }
            zzal(r10)     // Catch:{ IOException -> 0x0b4f }
            long r10 = r10.zzr(r9)     // Catch:{ IOException -> 0x0b4f }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b4f }
            r12.<init>()     // Catch:{ IOException -> 0x0b4f }
            java.lang.String r13 = r8.zzA()     // Catch:{ IOException -> 0x0b4f }
            r14 = r31
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0b4f }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0b4f }
            r15 = r30
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0b4f }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0b4f }
            android.database.sqlite.SQLiteDatabase r9 = r3.zze()     // Catch:{ SQLiteException -> 0x0b33 }
            java.lang.String r13 = "raw_events_metadata"
            r5 = 4
            r16 = r4
            r4 = 0
            r9.insertWithOnConflict(r13, r4, r12, r5)     // Catch:{ SQLiteException -> 0x0b31 }
            com.google.android.gms.measurement.internal.zzai r3 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r3)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzaq r4 = r7.zzf     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0b9b }
            r5.<init>(r4)     // Catch:{ all -> 0x0b9b }
        L_0x0a4a:
            boolean r4 = r5.hasNext()     // Catch:{ all -> 0x0b9b }
            if (r4 == 0) goto L_0x0a5d
            java.lang.String r4 = r5.next()     // Catch:{ all -> 0x0b9b }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0b9b }
            if (r4 == 0) goto L_0x0a4a
        L_0x0a5a:
            r17 = 1
            goto L_0x0a9f
        L_0x0a5d:
            com.google.android.gms.measurement.internal.zzfg r2 = r1.zzc     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b9b }
            boolean r2 = r2.zzj(r4, r5)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r4 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r4)     // Catch:{ all -> 0x0b9b }
            long r19 = r32.zzu()     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b9b }
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r18 = r4
            r21 = r5
            com.google.android.gms.measurement.internal.zzag r4 = r18.zzu(r19, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0b9b }
            if (r2 == 0) goto L_0x0a9d
            long r4 = r4.zze     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzae r2 = r32.zzd()     // Catch:{ all -> 0x0b9b }
            java.lang.String r8 = r7.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzea.zzn     // Catch:{ all -> 0x0b9b }
            int r2 = r2.zzk(r8, r9)     // Catch:{ all -> 0x0b9b }
            long r8 = (long) r2     // Catch:{ all -> 0x0b9b }
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0a9d
            goto L_0x0a5a
        L_0x0a9d:
            r17 = 0
        L_0x0a9f:
            r3.zzg()     // Catch:{ all -> 0x0b9b }
            r3.zzZ()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b9b }
            java.lang.String r2 = r7.zza     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzki r2 = r3.zzf     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzkk r2 = r2.zzi     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.internal.measurement.zzdc r2 = r2.zzf(r7)     // Catch:{ all -> 0x0b9b }
            byte[] r2 = r2.zzbp()     // Catch:{ all -> 0x0b9b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0b9b }
            r4.<init>()     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b9b }
            r4.put(r14, r5)     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = "name"
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b9b }
            r4.put(r5, r8)     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = "timestamp"
            long r8 = r7.zzd     // Catch:{ all -> 0x0b9b }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0b9b }
            r4.put(r5, r8)     // Catch:{ all -> 0x0b9b }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0b9b }
            r4.put(r15, r5)     // Catch:{ all -> 0x0b9b }
            java.lang.String r5 = "data"
            r4.put(r5, r2)     // Catch:{ all -> 0x0b9b }
            java.lang.String r2 = "realtime"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0b9b }
            r4.put(r2, r5)     // Catch:{ all -> 0x0b9b }
            android.database.sqlite.SQLiteDatabase r2 = r3.zze()     // Catch:{ SQLiteException -> 0x0b17 }
            r5 = 0
            long r4 = r2.insert(r6, r5, r4)     // Catch:{ SQLiteException -> 0x0b17 }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0b12
            com.google.android.gms.measurement.internal.zzfp r2 = r3.zzs     // Catch:{ SQLiteException -> 0x0b17 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x0b17 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x0b17 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.zza     // Catch:{ SQLiteException -> 0x0b17 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ SQLiteException -> 0x0b17 }
            r2.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0b17 }
            goto L_0x0b68
        L_0x0b12:
            r4 = 0
            r1.zza = r4     // Catch:{ all -> 0x0b9b }
            goto L_0x0b68
        L_0x0b17:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b9b }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ all -> 0x0b9b }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0b9b }
            goto L_0x0b68
        L_0x0b2f:
            r0 = move-exception
            goto L_0x0b52
        L_0x0b31:
            r0 = move-exception
            goto L_0x0b36
        L_0x0b33:
            r0 = move-exception
            r16 = r4
        L_0x0b36:
            r2 = r0
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs     // Catch:{ IOException -> 0x0b2f }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ IOException -> 0x0b2f }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ IOException -> 0x0b2f }
            java.lang.String r4 = "Error storing raw event metadata. appId"
            java.lang.String r5 = r8.zzA()     // Catch:{ IOException -> 0x0b2f }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ IOException -> 0x0b2f }
            r3.zzc(r4, r5, r2)     // Catch:{ IOException -> 0x0b2f }
            throw r2     // Catch:{ IOException -> 0x0b2f }
        L_0x0b4f:
            r0 = move-exception
            r16 = r4
        L_0x0b52:
            r2 = r0
            com.google.android.gms.measurement.internal.zzem r3 = r32.zzau()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0b9b }
            java.lang.String r4 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r16.zzG()     // Catch:{ all -> 0x0b9b }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ all -> 0x0b9b }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0b9b }
        L_0x0b68:
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze     // Catch:{ all -> 0x0b9b }
            zzal(r2)     // Catch:{ all -> 0x0b9b }
            r2.zzc()     // Catch:{ all -> 0x0b9b }
            com.google.android.gms.measurement.internal.zzai r2 = r1.zze
            zzal(r2)
            r2.zzd()
            r32.zzag()
            com.google.android.gms.measurement.internal.zzem r2 = r32.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0b9b:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzai r3 = r1.zze
            zzal(r3)
            r3.zzd()
            throw r2
        L_0x0ba6:
            r1.zzU(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zzz(com.google.android.gms.measurement.internal.zzas, com.google.android.gms.measurement.internal.zzp):void");
    }
}
