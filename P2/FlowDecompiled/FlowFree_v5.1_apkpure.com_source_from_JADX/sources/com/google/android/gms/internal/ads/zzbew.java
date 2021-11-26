package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbew implements zzpt, zznr, zzrd, zzjq, zzig {
    static int zza;
    static int zzb;
    private final Context zzc;
    private final zzbel zzd;
    private final zziy zze;
    private final zziy zzf;
    private final zzov zzg;
    private final zzbdo zzh;
    private zzij zzi;
    private ByteBuffer zzj;
    private boolean zzk;
    private final WeakReference<zzbdp> zzl;
    private zzbev zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private final String zzq;
    private final int zzr;
    private final ArrayList<zzpn> zzs;
    private volatile zzbek zzt;
    private final Set<WeakReference<zzbeh>> zzu = new HashSet();

    public zzbew(Context context, zzbdo zzbdo, zzbdp zzbdp) {
        this.zzc = context;
        this.zzh = zzbdo;
        this.zzl = new WeakReference<>(zzbdp);
        zzbel zzbel = new zzbel();
        this.zzd = zzbel;
        zzmp zzmp = zzmp.zza;
        zzebq zzebq = zzr.zza;
        zzqs zzqs = new zzqs(context, zzmp, 0, zzebq, this, -1);
        this.zze = zzqs;
        zzkd zzkd = new zzkd(zzmp, (zzkr) null, true, zzebq, this);
        this.zzf = zzkd;
        zzor zzor = new zzor((zzow) null);
        this.zzg = zzor;
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
        zza++;
        int i = 0;
        zzij zza2 = zzik.zza(new zziy[]{zzkd, zzqs}, zzor, zzbel);
        this.zzi = zza2;
        zza2.zza(this);
        this.zzn = 0;
        this.zzp = 0;
        this.zzo = 0;
        this.zzs = new ArrayList<>();
        this.zzt = null;
        this.zzq = (zzbdp == null || zzbdp.zzn() == null) ? "" : zzbdp.zzn();
        this.zzr = zzbdp != null ? zzbdp.zzp() : i;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzo)).booleanValue()) {
            this.zzi.zzo();
        }
        if (zzbdp != null && zzbdp.zzD() > 0) {
            this.zzi.zzp(zzbdp.zzD());
        }
        if (zzbdp != null && zzbdp.zzE() > 0) {
            this.zzi.zzq(zzbdp.zzE());
        }
    }

    private final boolean zzM() {
        return this.zzt != null && this.zzt.zzf();
    }

    public static int zzp() {
        return zza;
    }

    public static int zzq() {
        return zzb;
    }

    public final void finalize() throws Throwable {
        zza--;
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
    }

    public final int zzA() {
        return this.zzo;
    }

    /* renamed from: zzB */
    public final void zzj(zzpe zzpe, zzpg zzpg) {
        if (zzpe instanceof zzpn) {
            this.zzs.add((zzpn) zzpe);
        } else if (zzpe instanceof zzbek) {
            this.zzt = (zzbek) zzpe;
            zzbdp zzbdp = (zzbdp) this.zzl.get();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue() && zzbdp != null && this.zzt.zze()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzg()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzh()));
                zzr.zza.post(new zzbem(zzbdp, hashMap));
            }
        }
    }

    public final void zzC(zzpe zzpe, int i) {
        this.zzn += i;
    }

    public final void zzD(int i) {
        for (WeakReference<zzbeh> weakReference : this.zzu) {
            zzbeh zzbeh = (zzbeh) weakReference.get();
            if (zzbeh != null) {
                zzbeh.zzf(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(Surface surface, boolean z) {
        zzij zzij = this.zzi;
        if (zzij != null) {
            zzii zzii = new zzii(this.zze, 1, surface);
            if (z) {
                zzij.zzk(zzii);
                return;
            }
            zzij.zzj(zzii);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(float f, boolean z) {
        if (this.zzi != null) {
            zzii zzii = new zzii(this.zzf, 2, Float.valueOf(f));
            if (z) {
                this.zzi.zzk(zzii);
                return;
            }
            this.zzi.zzj(zzii);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzG(boolean z) {
        if (this.zzi != null) {
            for (int i = 0; i < 2; i++) {
                this.zzg.zzc(i, !z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzaaa.zzc().zzb(com.google.android.gms.internal.ads.zzaeq.zzbj)).booleanValue() == false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zznw zzH(android.net.Uri r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzns r9 = new com.google.android.gms.internal.ads.zzns
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x0022
            java.nio.ByteBuffer r0 = r10.zzj
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0022
            java.nio.ByteBuffer r12 = r10.zzj
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzj
            r0.get(r12)
            com.google.android.gms.internal.ads.zzben r0 = new com.google.android.gms.internal.ads.zzben
            r0.<init>(r12)
        L_0x0020:
            r2 = r0
            goto L_0x0087
        L_0x0022:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzbl
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            if (r0 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzbj
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x004f
        L_0x0047:
            com.google.android.gms.internal.ads.zzbdo r0 = r10.zzh
            boolean r0 = r0.zzj
            if (r0 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            com.google.android.gms.internal.ads.zzbdo r0 = r10.zzh
            int r2 = r0.zzi
            if (r2 <= 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzbeo r2 = new com.google.android.gms.internal.ads.zzbeo
            r2.<init>(r10, r12, r1)
            goto L_0x0060
        L_0x005b:
            com.google.android.gms.internal.ads.zzbep r2 = new com.google.android.gms.internal.ads.zzbep
            r2.<init>(r10, r12, r1)
        L_0x0060:
            boolean r12 = r0.zzj
            if (r12 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzbeq r12 = new com.google.android.gms.internal.ads.zzbeq
            r12.<init>(r10, r2)
            r2 = r12
        L_0x006a:
            java.nio.ByteBuffer r12 = r10.zzj
            if (r12 == 0) goto L_0x0087
            int r12 = r12.limit()
            if (r12 <= 0) goto L_0x0087
            java.nio.ByteBuffer r12 = r10.zzj
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzj
            r0.get(r12)
            com.google.android.gms.internal.ads.zzber r0 = new com.google.android.gms.internal.ads.zzber
            r0.<init>(r2, r12)
            goto L_0x0020
        L_0x0087:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzaeq.zzn
            com.google.android.gms.internal.ads.zzaeo r0 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r12 = r0.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzkw r12 = com.google.android.gms.internal.ads.zzbes.zza
            goto L_0x009e
        L_0x009c:
            com.google.android.gms.internal.ads.zzkw r12 = com.google.android.gms.internal.ads.zzbet.zza
        L_0x009e:
            r3 = r12
            com.google.android.gms.internal.ads.zzbdo r12 = r10.zzh
            int r4 = r12.zzk
            com.google.android.gms.internal.ads.zzebq r5 = com.google.android.gms.ads.internal.util.zzr.zza
            r7 = 0
            int r8 = r12.zzg
            r0 = r9
            r1 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbew.zzH(android.net.Uri, java.lang.String):com.google.android.gms.internal.ads.zznw");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzpe zzI(zzpd zzpd) {
        return new zzbek(this.zzc, zzpd.zza(), this.zzq, this.zzr, this, new zzbeu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z, long j) {
        zzbev zzbev = this.zzm;
        if (zzbev != null) {
            zzbev.zzt(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzpe zzK(String str, boolean z) {
        zzbew zzbew = true != z ? null : this;
        zzbdo zzbdo = this.zzh;
        return new zzpi(str, (zzqe<String>) null, zzbew, zzbdo.zzd, zzbdo.zzf, true, (zzpm) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzpe zzL(String str, boolean z) {
        zzbew zzbew = true != z ? null : this;
        zzbdo zzbdo = this.zzh;
        zzbeh zzbeh = new zzbeh(str, zzbew, zzbdo.zzd, zzbdo.zzf, zzbdo.zzi);
        this.zzu.add(new WeakReference(zzbeh));
        return zzbeh;
    }

    public final void zza(zzje zzje, Object obj) {
    }

    public final void zzb(zzol zzol, zzox zzox) {
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(boolean z, int i) {
        zzbev zzbev = this.zzm;
        if (zzbev != null) {
            zzbev.zzA(i);
        }
    }

    public final void zze(zzif zzif) {
        zzbev zzbev = this.zzm;
        if (zzbev != null) {
            zzbev.zzC("onPlayerError", zzif);
        }
    }

    public final void zzf() {
    }

    public final void zzg(zzix zzix) {
    }

    public final void zzh(zzit zzit) {
        zzbdp zzbdp = (zzbdp) this.zzl.get();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue() && zzbdp != null && zzit != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzit.zze);
            hashMap.put("audioSampleMime", zzit.zzf);
            hashMap.put("audioCodec", zzit.zzc);
            zzbdp.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzi(IOException iOException) {
        zzbev zzbev = this.zzm;
        if (zzbev == null) {
            return;
        }
        if (this.zzh.zzl) {
            zzbev.zzD("onLoadException", iOException);
        } else {
            zzbev.zzC("onLoadError", iOException);
        }
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i) {
        this.zzn += i;
    }

    public final void zzl(zzit zzit) {
        zzbdp zzbdp = (zzbdp) this.zzl.get();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue() && zzbdp != null && zzit != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzit.zzl));
            hashMap.put("bitRate", String.valueOf(zzit.zzb));
            int i = zzit.zzj;
            int i2 = zzit.zzk;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzit.zze);
            hashMap.put("videoSampleMime", zzit.zzf);
            hashMap.put("videoCodec", zzit.zzc);
            zzbdp.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzm(int i, long j) {
        this.zzo += i;
    }

    public final void zzn(int i, int i2, int i3, float f) {
        zzbev zzbev = this.zzm;
        if (zzbev != null) {
            zzbev.zzB(i, i2);
        }
    }

    public final zzij zzo() {
        return this.zzi;
    }

    public final void zzr(zzbev zzbev) {
        this.zzm = zzbev;
    }

    public final zzbel zzs() {
        return this.zzd;
    }

    public final void zzt(Uri[] uriArr, String str) {
        zzu(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzv() {
        zzij zzij = this.zzi;
        if (zzij != null) {
            zzij.zzb(this);
            this.zzi.zzi();
            this.zzi = null;
            zzb--;
        }
    }

    public final long zzw() {
        return (long) this.zzn;
    }

    public final long zzx() {
        if (!zzM()) {
            return (long) this.zzn;
        }
        return 0;
    }

    public final long zzy() {
        if (zzM() && this.zzt.zzg()) {
            return Math.min((long) this.zzn, this.zzt.zzi());
        }
        return 0;
    }

    public final long zzz() {
        if (zzM()) {
            return this.zzt.zzj();
        }
        while (!this.zzs.isEmpty()) {
            long j = this.zzp;
            Map<String, List<String>> zze2 = this.zzs.remove(0).zze();
            long j2 = 0;
            if (zze2 != null) {
                Iterator<Map.Entry<String, List<String>>> it = zze2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    if (next != null) {
                        try {
                            if (!(next.getKey() == null || !zzebt.zza("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                                j2 = Long.parseLong((String) ((List) next.getValue()).get(0));
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    }
                }
            }
            this.zzp = j + j2;
        }
        return this.zzp;
    }

    public final void zzu(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zznw zznw;
        if (this.zzi != null) {
            this.zzj = byteBuffer;
            this.zzk = z;
            int length = uriArr.length;
            if (length == 1) {
                zznw = zzH(uriArr[0], str);
            } else {
                zznw[] zznwArr = new zznw[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zznwArr[i] = zzH(uriArr[i], str);
                }
                zznw = new zzoa(zznwArr);
            }
            this.zzi.zzd(zznw);
            zzb++;
        }
    }
}
