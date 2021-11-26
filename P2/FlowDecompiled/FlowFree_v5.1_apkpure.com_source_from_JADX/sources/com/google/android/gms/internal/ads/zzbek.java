package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbek implements zzpe {
    private final zzpt<zzpe> zza;
    private final Context zzb;
    private final zzpe zzc;
    private final zzbej zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue();
    private InputStream zzh;
    private boolean zzi;
    private Uri zzj;
    private volatile zzts zzk;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn = false;
    private boolean zzo = false;
    private long zzp = 0;
    private zzefw<Long> zzq = null;
    private final AtomicLong zzr = new AtomicLong(-1);

    public zzbek(Context context, zzpe zzpe, String str, int i, zzpt<zzpe> zzpt, zzbej zzbej) {
        this.zzb = context;
        this.zzc = zzpe;
        this.zza = zzpt;
        this.zzd = zzbej;
        this.zze = str;
        this.zzf = i;
    }

    private final void zzl(zzpg zzpg) {
        zzpt<zzpe> zzpt = this.zza;
        if (zzpt != null) {
            ((zzbew) zzpt).zzj(this, zzpg);
        }
    }

    private final boolean zzm() {
        if (!this.zzg) {
            return false;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcA)).booleanValue() && !this.zzn) {
            return true;
        }
        return ((Boolean) zzaaa.zzc().zzb(zzaeq.zzcB)).booleanValue() && !this.zzo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e0  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x010b=Splitter:B:34:0x010b, B:39:0x012c=Splitter:B:39:0x012c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzpg r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.zzi
            if (r2 != 0) goto L_0x01ff
            r2 = 1
            r14.zzi = r2
            android.net.Uri r3 = r15.zza
            r14.zzj = r3
            boolean r3 = r14.zzg
            if (r3 != 0) goto L_0x0016
            r14.zzl(r15)
        L_0x0016:
            android.net.Uri r3 = r15.zza
            com.google.android.gms.internal.ads.zzts r3 = com.google.android.gms.internal.ads.zzts.zza(r3)
            r14.zzk = r3
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzcx
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzts r3 = r14.zzk
            if (r3 == 0) goto L_0x01da
            com.google.android.gms.internal.ads.zzts r3 = r14.zzk
            long r7 = r15.zzc
            r3.zzh = r7
            com.google.android.gms.internal.ads.zzts r3 = r14.zzk
            java.lang.String r7 = r14.zze
            java.lang.String r7 = com.google.android.gms.internal.ads.zzecs.zza(r7)
            r3.zzi = r7
            com.google.android.gms.internal.ads.zzts r3 = r14.zzk
            int r7 = r14.zzf
            r3.zzj = r7
            com.google.android.gms.internal.ads.zzts r3 = r14.zzk
            boolean r3 = r3.zzg
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzaeq.zzcz
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x006c
        L_0x0060:
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzaeq.zzcy
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
        L_0x006c:
            long r7 = r3.longValue()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r9 = r3.elapsedRealtime()
            com.google.android.gms.ads.internal.zzs.zzw()
            android.content.Context r3 = r14.zzb
            com.google.android.gms.internal.ads.zzts r11 = r14.zzk
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zzud.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            com.google.android.gms.internal.ads.zzue r7 = (com.google.android.gms.internal.ads.zzue) r7     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            boolean r8 = r7.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzl = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r7.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzn = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r7.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzo = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            long r12 = r7.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzp = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r14.zzm()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            if (r8 != 0) goto L_0x00de
            java.io.InputStream r7 = r7.zzb()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzh = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r7 = r14.zzg     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            if (r7 == 0) goto L_0x00b8
            r14.zzl(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzs.zzj()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzbej r15 = r14.zzd
            r15.zza(r2, r6)
            r14.zzm = r2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r1)
            r15.append(r6)
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r15)
            return r4
        L_0x00de:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbej r5 = r14.zzd
            r5.zza(r2, r3)
            r14.zzm = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0151
        L_0x0101:
            r15 = move-exception
            goto L_0x0158
        L_0x0103:
            r4 = 1
            goto L_0x010b
        L_0x0105:
            r4 = 1
            goto L_0x012c
        L_0x0107:
            r15 = move-exception
            r2 = 0
            goto L_0x0158
        L_0x010a:
            r4 = 0
        L_0x010b:
            r3.cancel(r2)     // Catch:{ all -> 0x0156 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0156 }
            r2.interrupt()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzs.zzj()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbej r5 = r14.zzd
            r5.zza(r4, r2)
            r14.zzm = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            goto L_0x0144
        L_0x012b:
            r4 = 0
        L_0x012c:
            r3.cancel(r2)     // Catch:{ all -> 0x0156 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzs.zzj()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbej r5 = r14.zzd
            r5.zza(r4, r2)
            r14.zzm = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
        L_0x0144:
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x0151:
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            goto L_0x01da
        L_0x0156:
            r15 = move-exception
            r2 = r4
        L_0x0158:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbej r5 = r14.zzd
            r5.zza(r2, r3)
            r14.zzm = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            throw r15
        L_0x017e:
            com.google.android.gms.internal.ads.zzts r0 = r14.zzk
            if (r0 == 0) goto L_0x01a3
            com.google.android.gms.internal.ads.zzts r0 = r14.zzk
            long r7 = r15.zzc
            r0.zzh = r7
            com.google.android.gms.internal.ads.zzts r0 = r14.zzk
            java.lang.String r1 = r14.zze
            java.lang.String r1 = com.google.android.gms.internal.ads.zzecs.zza(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzts r0 = r14.zzk
            int r1 = r14.zzf
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzto r0 = com.google.android.gms.ads.internal.zzs.zzi()
            com.google.android.gms.internal.ads.zzts r1 = r14.zzk
            com.google.android.gms.internal.ads.zztp r0 = r0.zzc(r1)
            goto L_0x01a4
        L_0x01a3:
            r0 = 0
        L_0x01a4:
            if (r0 == 0) goto L_0x01da
            boolean r1 = r0.zza()
            if (r1 == 0) goto L_0x01da
            boolean r1 = r0.zzd()
            r14.zzl = r1
            boolean r1 = r0.zzg()
            r14.zzn = r1
            boolean r1 = r0.zze()
            r14.zzo = r1
            long r7 = r0.zzf()
            r14.zzp = r7
            r14.zzm = r2
            boolean r1 = r14.zzm()
            if (r1 != 0) goto L_0x01da
            java.io.InputStream r0 = r0.zzb()
            r14.zzh = r0
            boolean r0 = r14.zzg
            if (r0 == 0) goto L_0x01d9
            r14.zzl(r15)
        L_0x01d9:
            return r4
        L_0x01da:
            r14.zzm = r6
            com.google.android.gms.internal.ads.zzts r0 = r14.zzk
            if (r0 == 0) goto L_0x01f8
            com.google.android.gms.internal.ads.zzpg r0 = new com.google.android.gms.internal.ads.zzpg
            com.google.android.gms.internal.ads.zzts r1 = r14.zzk
            java.lang.String r1 = r1.zza
            android.net.Uri r2 = android.net.Uri.parse(r1)
            r3 = 0
            long r4 = r15.zzb
            long r6 = r15.zzc
            long r8 = r15.zzd
            r10 = 0
            r11 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x01f8:
            com.google.android.gms.internal.ads.zzpe r0 = r14.zzc
            long r0 = r0.zza(r15)
            return r0
        L_0x01ff:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.zza(com.google.android.gms.internal.ads.zzpg):long");
    }

    public final int zzb(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        zzpt<zzpe> zzpt;
        if (this.zzi) {
            InputStream inputStream = this.zzh;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzc.zzb(bArr, i, i2);
            }
            if ((!this.zzg || this.zzh != null) && (zzpt = this.zza) != null) {
                ((zzbew) zzpt).zzC(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    public final Uri zzc() {
        return this.zzj;
    }

    public final void zzd() throws IOException {
        if (this.zzi) {
            this.zzi = false;
            this.zzj = null;
            InputStream inputStream = this.zzh;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
                this.zzh = null;
                return;
            }
            this.zzc.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final boolean zze() {
        return this.zzl;
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        return this.zzn;
    }

    public final boolean zzh() {
        return this.zzo;
    }

    public final long zzi() {
        return this.zzp;
    }

    public final long zzj() {
        if (this.zzk == null) {
            return -1;
        }
        if (this.zzr.get() != -1) {
            return this.zzr.get();
        }
        synchronized (this) {
            if (this.zzq == null) {
                this.zzq = zzbbw.zza.zzb(new zzbei(this));
            }
        }
        if (!this.zzq.isDone()) {
            return -1;
        }
        try {
            this.zzr.compareAndSet(-1, this.zzq.get().longValue());
            return this.zzr.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Long zzk() throws Exception {
        return Long.valueOf(zzs.zzi().zzd(this.zzk));
    }
}
