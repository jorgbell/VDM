package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzge {
    private static final String zzd = "zzge";
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzfk zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzdc zzm;
    private Future zzn;
    private zzew zzo;
    private final Map<Pair<String, String>, zzhl> zzp;
    private boolean zzq;
    private zzfx zzr;

    private zzge(Context context) {
        boolean z = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzq = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzp = new HashMap();
        if (this.zzr == null) {
            this.zzr = new zzfx(context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|(3:27|28|(17:30|(2:32|33)|34|35|36|37|(2:39|(1:41)(2:42|43))|44|(1:46)|47|48|49|50|51|52|53|82)(3:71|72|73))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ zzfv -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ IllegalArgumentException -> 0x0157, zzfj -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0151 A[SYNTHETIC, Splitter:B:71:0x0151] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzge zza(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r11 = "1613498354782"
            com.google.android.gms.internal.ads.zzge r0 = new com.google.android.gms.internal.ads.zzge
            r0.<init>(r9)
            com.google.android.gms.internal.ads.zzga r9 = new com.google.android.gms.internal.ads.zzga     // Catch:{ zzfv -> 0x0165 }
            r9.<init>()     // Catch:{ zzfv -> 0x0165 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzfv -> 0x0165 }
            r0.zze = r9     // Catch:{ zzfv -> 0x0165 }
            r0.zzj = r12     // Catch:{ zzfv -> 0x0165 }
            if (r12 == 0) goto L_0x0025
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzfv -> 0x0165 }
            com.google.android.gms.internal.ads.zzgb r12 = new com.google.android.gms.internal.ads.zzgb     // Catch:{ zzfv -> 0x0165 }
            r12.<init>(r0)     // Catch:{ zzfv -> 0x0165 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzfv -> 0x0165 }
            r0.zzk = r9     // Catch:{ zzfv -> 0x0165 }
        L_0x0025:
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzfv -> 0x0165 }
            com.google.android.gms.internal.ads.zzgd r12 = new com.google.android.gms.internal.ads.zzgd     // Catch:{ zzfv -> 0x0165 }
            r12.<init>(r0)     // Catch:{ zzfv -> 0x0165 }
            r9.execute(r12)     // Catch:{ zzfv -> 0x0165 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r2 = r1.getApkVersion(r2)     // Catch:{ all -> 0x004f }
            if (r2 <= 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            r0.zzb = r2     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            r0.zzc = r1     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0.zzq(r12, r9)     // Catch:{ zzfv -> 0x0165 }
            boolean r1 = com.google.android.gms.internal.ads.zzgh.zzd()     // Catch:{ zzfv -> 0x0165 }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaeq.zzbK     // Catch:{ zzfv -> 0x0165 }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ zzfv -> 0x0165 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ zzfv -> 0x0165 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzfv -> 0x0165 }
            boolean r1 = r1.booleanValue()     // Catch:{ zzfv -> 0x0165 }
            if (r1 != 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzfv -> 0x0165 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzfv -> 0x0165 }
            throw r9     // Catch:{ zzfv -> 0x0165 }
        L_0x0073:
            com.google.android.gms.internal.ads.zzfk r1 = new com.google.android.gms.internal.ads.zzfk     // Catch:{ zzfv -> 0x0165 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzfv -> 0x0165 }
            r0.zzg = r1     // Catch:{ zzfv -> 0x0165 }
            java.lang.String r3 = "AQZlye0Qf6I1JwsO6u2s3ZPB9yudAuKGNAQ9qUeSY1g="
            byte[] r3 = com.google.android.gms.internal.ads.zzdx.zzb(r3, r12)     // Catch:{ IllegalArgumentException -> 0x0157 }
            int r4 = r3.length     // Catch:{ IllegalArgumentException -> 0x0157 }
            r5 = 32
            if (r4 != r5) goto L_0x0151
            r4 = 4
            r5 = 16
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0157 }
            byte[] r4 = new byte[r5]     // Catch:{ IllegalArgumentException -> 0x0157 }
            r3.get(r4)     // Catch:{ IllegalArgumentException -> 0x0157 }
            r3 = 0
        L_0x0093:
            if (r3 >= r5) goto L_0x009f
            byte r6 = r4[r3]     // Catch:{ IllegalArgumentException -> 0x0157 }
            r6 = r6 ^ 68
            byte r6 = (byte) r6     // Catch:{ IllegalArgumentException -> 0x0157 }
            r4[r3] = r6     // Catch:{ IllegalArgumentException -> 0x0157 }
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009f:
            r0.zzh = r4     // Catch:{ zzfj -> 0x015e }
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            if (r1 != 0) goto L_0x00ba
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r3 = "dex"
            java.io.File r1 = r1.getDir(r3, r12)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            if (r1 == 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            com.google.android.gms.internal.ads.zzfv r9 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            throw r9     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x00ba:
            java.lang.String r3 = "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"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r6[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r6[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r7 = "%s/%s.jar"
            java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            boolean r6 = r4.exists()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            if (r6 != 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzfk r6 = r0.zzg     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            byte[] r7 = r0.zzh     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            byte[] r3 = r6.zzb(r7, r3)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            int r7 = r3.length     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r6.write(r3, r12, r7)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r6.close()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x00eb:
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            dalvik.system.DexClassLoader r3 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x0120 }
            java.lang.String r6 = r4.getAbsolutePath()     // Catch:{ all -> 0x0120 }
            java.lang.String r7 = r1.getAbsolutePath()     // Catch:{ all -> 0x0120 }
            android.content.Context r8 = r0.zza     // Catch:{ all -> 0x0120 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x0120 }
            r3.<init>(r6, r7, r2, r8)     // Catch:{ all -> 0x0120 }
            r0.zzf = r3     // Catch:{ all -> 0x0120 }
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r0.zzv(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r2[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r2[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r10 = java.lang.String.format(r10, r2)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            zzz(r10)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            com.google.android.gms.internal.ads.zzew r10 = new com.google.android.gms.internal.ads.zzew     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r0)     // Catch:{ zzfv -> 0x0165 }
            r0.zzo = r10     // Catch:{ zzfv -> 0x0165 }
            r0.zzq = r9     // Catch:{ zzfv -> 0x0165 }
            goto L_0x0165
        L_0x0120:
            r2 = move-exception
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r0.zzv(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r3[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            r3[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r9 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            zzz(r9)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
            throw r2     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzfj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x0135:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfv r10 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzfv -> 0x0165 }
            throw r10     // Catch:{ zzfv -> 0x0165 }
        L_0x013c:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfv r10 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzfv -> 0x0165 }
            throw r10     // Catch:{ zzfv -> 0x0165 }
        L_0x0143:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfv r10 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzfv -> 0x0165 }
            throw r10     // Catch:{ zzfv -> 0x0165 }
        L_0x014a:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfv r10 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzfv -> 0x0165 }
            throw r10     // Catch:{ zzfv -> 0x0165 }
        L_0x0151:
            com.google.android.gms.internal.ads.zzfj r9 = new com.google.android.gms.internal.ads.zzfj     // Catch:{ IllegalArgumentException -> 0x0157 }
            r9.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0157 }
            throw r9     // Catch:{ IllegalArgumentException -> 0x0157 }
        L_0x0157:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfj r10 = new com.google.android.gms.internal.ads.zzfj     // Catch:{ zzfj -> 0x015e }
            r10.<init>(r1, r9)     // Catch:{ zzfj -> 0x015e }
            throw r10     // Catch:{ zzfj -> 0x015e }
        L_0x015e:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzfv r10 = new com.google.android.gms.internal.ads.zzfv     // Catch:{ zzfv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzfv -> 0x0165 }
            throw r10     // Catch:{ zzfv -> 0x0165 }
        L_0x0165:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzge.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzge");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00bd */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3 A[SYNTHETIC, Splitter:B:42:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00da A[SYNTHETIC, Splitter:B:46:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4 A[SYNTHETIC, Splitter:B:54:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb A[SYNTHETIC, Splitter:B:58:0x00eb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzv(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r12 = "test"
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r11
            r4 = 1
            java.lang.String r5 = "1613498354782"
            r2[r4] = r5
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x001f
            return
        L_0x001f:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r11
            r1[r4] = r5
            java.lang.String r11 = "%s/%s.dex"
            java.lang.String r11 = java.lang.String.format(r11, r1)
            r2.<init>(r11)
            boolean r11 = r2.exists()
            if (r11 != 0) goto L_0x0037
            return
        L_0x0037:
            long r6 = r2.length()
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x0042
            return
        L_0x0042:
            int r11 = (int) r6
            byte[] r11 = new byte[r11]
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e1, all -> 0x00ce }
            r4.<init>(r2)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e1, all -> 0x00ce }
            int r6 = r4.read(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            if (r6 > 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            zzy(r2)
            return
        L_0x0058:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r6.print(r12)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r6.print(r12)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r6.print(r12)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzdf r12 = com.google.android.gms.internal.ads.zzdg.zzg()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzesf r6 = com.google.android.gms.internal.ads.zzesf.zzs(r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r12.zzd(r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            byte[] r5 = r5.getBytes()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzesf r5 = com.google.android.gms.internal.ads.zzesf.zzs(r5)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r12.zzc(r5)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzfk r5 = r10.zzg     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            byte[] r6 = r10.zzh     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            java.lang.String r11 = r5.zza(r6, r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            byte[] r11 = r11.getBytes()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzesf r5 = com.google.android.gms.internal.ads.zzesf.zzs(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r12.zza(r5)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            byte[] r11 = com.google.android.gms.internal.ads.zzeb.zze(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzesf r11 = com.google.android.gms.internal.ads.zzesf.zzs(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r12.zzb(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r0.createNewFile()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            r11.<init>(r0)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cb, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzeth r12 = r12.zzah()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            com.google.android.gms.internal.ads.zzdg r12 = (com.google.android.gms.internal.ads.zzdg) r12     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            byte[] r12 = r12.zzao()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            int r0 = r12.length     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            r11.write(r12, r3, r0)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            r11.close()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c4 }
            r4.close()     // Catch:{ IOException -> 0x00bd }
        L_0x00bd:
            r11.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            zzy(r2)
            return
        L_0x00c4:
            r12 = move-exception
            goto L_0x00c9
        L_0x00c6:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00c9:
            r1 = r4
            goto L_0x00d1
        L_0x00cb:
            r11 = r1
        L_0x00cc:
            r1 = r4
            goto L_0x00e2
        L_0x00ce:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00d1:
            if (r1 == 0) goto L_0x00d8
            r1.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00d8
        L_0x00d7:
        L_0x00d8:
            if (r11 == 0) goto L_0x00dd
            r11.close()     // Catch:{ IOException -> 0x00dd }
        L_0x00dd:
            zzy(r2)
            throw r12
        L_0x00e1:
            r11 = r1
        L_0x00e2:
            if (r1 == 0) goto L_0x00e9
            r1.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
        L_0x00e9:
            if (r11 == 0) goto L_0x00ee
            r11.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00ee:
            zzy(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzge.zzv(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|32|33|34|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e3, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00db */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: zzfj | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ea A[SYNTHETIC, Splitter:B:61:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f1 A[SYNTHETIC, Splitter:B:65:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f8 A[SYNTHETIC, Splitter:B:72:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ff A[SYNTHETIC, Splitter:B:76:0x00ff] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzw(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r11 = new java.io.File
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r10
            r3 = 1
            java.lang.String r4 = "1613498354782"
            r1[r3] = r4
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r11.<init>(r1)
            boolean r1 = r11.exists()
            if (r1 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r10
            r0[r3] = r4
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r0)
            r1.<init>(r10)
            boolean r10 = r1.exists()
            if (r10 != 0) goto L_0x0102
            r10 = 0
            long r5 = r11.length()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0043
            zzy(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            return r2
        L_0x0043:
            int r0 = (int) r5     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            byte[] r0 = new byte[r0]     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            r5.<init>(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00f5, all -> 0x00e6 }
            int r6 = r5.read(r0)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            if (r6 > 0) goto L_0x005f
            java.lang.String r0 = zzd     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            zzy(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r5.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            return r2
        L_0x005f:
            com.google.android.gms.internal.ads.zzest r6 = com.google.android.gms.internal.ads.zzest.zza()     // Catch:{ NullPointerException -> 0x00db, zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, zzfj | IOException | NoSuchAlgorithmException -> 0x00e3 }
            com.google.android.gms.internal.ads.zzdg r0 = com.google.android.gms.internal.ads.zzdg.zzf(r0, r6)     // Catch:{ NullPointerException -> 0x00db, zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, zzfj | IOException | NoSuchAlgorithmException -> 0x00e3 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            com.google.android.gms.internal.ads.zzesf r7 = r0.zzd()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r7 = r7.zzy()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r6.<init>(r7)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            boolean r4 = r4.equals(r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            if (r4 == 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzesf r4 = r0.zzc()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r4 = r4.zzy()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            com.google.android.gms.internal.ads.zzesf r6 = r0.zza()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r6 = r6.zzy()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r6 = com.google.android.gms.internal.ads.zzeb.zze(r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            if (r4 == 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzesf r4 = r0.zze()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r4 = r4.zzy()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r6 = r6.getBytes()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            if (r4 != 0) goto L_0x00a9
            goto L_0x00d4
        L_0x00a9:
            com.google.android.gms.internal.ads.zzfk r11 = r9.zzg     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r4 = r9.zzh     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            com.google.android.gms.internal.ads.zzesf r0 = r0.zza()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r0 = r0.zzy()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r6.<init>(r0)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            byte[] r11 = r11.zzb(r4, r6)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r1.createNewFile()     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r0.<init>(r1)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            int r10 = r11.length     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e4, all -> 0x00d1 }
            r0.write(r11, r2, r10)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e4, all -> 0x00d1 }
            r5.close()     // Catch:{ IOException -> 0x00cd }
        L_0x00cd:
            r0.close()     // Catch:{ IOException -> 0x00d0 }
        L_0x00d0:
            return r3
        L_0x00d1:
            r10 = move-exception
            r11 = r10
            goto L_0x00e1
        L_0x00d4:
            zzy(r11)     // Catch:{ zzfj | IOException | NoSuchAlgorithmException -> 0x00e3, all -> 0x00df }
            r5.close()     // Catch:{ IOException -> 0x00da }
        L_0x00da:
            return r2
        L_0x00db:
            r5.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            return r2
        L_0x00df:
            r11 = move-exception
            r0 = r10
        L_0x00e1:
            r10 = r5
            goto L_0x00e8
        L_0x00e3:
            r0 = r10
        L_0x00e4:
            r10 = r5
            goto L_0x00f6
        L_0x00e6:
            r11 = move-exception
            r0 = r10
        L_0x00e8:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00ef
        L_0x00ee:
        L_0x00ef:
            if (r0 == 0) goto L_0x00f4
            r0.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            throw r11
        L_0x00f5:
            r0 = r10
        L_0x00f6:
            if (r10 == 0) goto L_0x00fd
            r10.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x00fd
        L_0x00fc:
        L_0x00fd:
            if (r0 == 0) goto L_0x0102
            r0.close()     // Catch:{ IOException -> 0x0102 }
        L_0x0102:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzge.zzw(java.io.File, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzx() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final Context zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzq;
    }

    public final ExecutorService zzd() {
        return this.zze;
    }

    public final DexClassLoader zze() {
        return this.zzf;
    }

    public final zzfk zzf() {
        return this.zzg;
    }

    public final byte[] zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzb;
    }

    public final zzew zzi() {
        return this.zzo;
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        return this.zzr.zza();
    }

    /* access modifiers changed from: package-private */
    public final zzfx zzl() {
        return this.zzr;
    }

    public final zzdc zzm() {
        return this.zzm;
    }

    public final Future zzn() {
        return this.zzn;
    }

    public final boolean zzo(String str, String str2, Class<?>... clsArr) {
        if (this.zzp.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzp.put(new Pair(str, str2), new zzhl(this, str, str2, clsArr));
        return true;
    }

    public final Method zzp(String str, String str2) {
        zzhl zzhl = this.zzp.get(new Pair(str, str2));
        if (zzhl == null) {
            return null;
        }
        return zzhl.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzq(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzgc(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final AdvertisingIdClient zzr() {
        if (!this.zzj) {
            return null;
        }
        if (this.zzi != null) {
            return this.zzi;
        }
        Future future = this.zzk;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final int zzs() {
        if (this.zzo != null) {
            return zzew.zzd();
        }
        return Integer.MIN_VALUE;
    }
}
