package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbef extends zzbcy implements TextureView.SurfaceTextureListener, zzbev {
    private final zzbdp zzc;
    private final zzbdq zzd;
    private final boolean zze;
    private final zzbdo zzf;
    private zzbcx zzg;
    private Surface zzh;
    private zzbew zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm = 1;
    private zzbdn zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private float zzv;

    public zzbef(Context context, zzbdq zzbdq, zzbdp zzbdp, boolean z, boolean z2, zzbdo zzbdo) {
        super(context);
        this.zze = z2;
        this.zzc = zzbdp;
        this.zzd = zzbdq;
        this.zzo = z;
        this.zzf = zzbdo;
        setSurfaceTextureListener(this);
        zzbdq.zza(this);
    }

    private final boolean zzP() {
        zzbew zzbew = this.zzi;
        return (zzbew == null || zzbew.zzo() == null || this.zzl) ? false : true;
    }

    private final boolean zzQ() {
        return zzP() && this.zzm != 1;
    }

    private final void zzR() {
        String str;
        if (this.zzi == null && (str = this.zzj) != null && this.zzh != null) {
            if (str.startsWith("cache:")) {
                zzbfn zzs2 = this.zzc.zzs(this.zzj);
                if (zzs2 instanceof zzbfv) {
                    zzbew zzj2 = ((zzbfv) zzs2).zzj();
                    this.zzi = zzj2;
                    if (zzj2.zzo() == null) {
                        zzbbk.zzi("Precached video player has been released.");
                        return;
                    }
                } else if (zzs2 instanceof zzbft) {
                    zzbft zzbft = (zzbft) zzs2;
                    String zzs3 = zzs();
                    ByteBuffer zzr2 = zzbft.zzr();
                    boolean zzq2 = zzbft.zzq();
                    String zzp2 = zzbft.zzp();
                    if (zzp2 == null) {
                        zzbbk.zzi("Stream cache URL is null.");
                        return;
                    }
                    zzbew zzr3 = zzr();
                    this.zzi = zzr3;
                    zzr3.zzu(new Uri[]{Uri.parse(zzp2)}, zzs3, zzr2, zzq2);
                } else {
                    String valueOf = String.valueOf(this.zzj);
                    zzbbk.zzi(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzi = zzr();
                String zzs4 = zzs();
                Uri[] uriArr = new Uri[this.zzk.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzk;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzi.zzt(uriArr, zzs4);
            }
            this.zzi.zzr(this);
            zzS(this.zzh, false);
            if (this.zzi.zzo() != null) {
                int zzc2 = this.zzi.zzo().zzc();
                this.zzm = zzc2;
                if (zzc2 == 3) {
                    zzU();
                }
            }
        }
    }

    private final void zzS(Surface surface, boolean z) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzE(surface, z);
        } else {
            zzbbk.zzi("Trying to set surface before player is initialized.");
        }
    }

    private final void zzT(float f, boolean z) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzF(f, z);
        } else {
            zzbbk.zzi("Trying to set volume before player is initialized.");
        }
    }

    private final void zzU() {
        if (!this.zzp) {
            this.zzp = true;
            zzr.zza.post(new zzbdu(this));
            zzq();
            this.zzd.zzb();
            if (this.zzq) {
                zze();
            }
        }
    }

    private static String zzV(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void zzW() {
        zzX(this.zzr, this.zzs);
    }

    private final void zzX(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzv != f) {
            this.zzv = f;
            requestLayout();
        }
    }

    private final void zzY() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzG(true);
        }
    }

    private final void zzZ() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzG(false);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[LOOP:0: B:30:0x0078->B:35:0x0093, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzv
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzbdn r2 = r10.zzn
            if (r2 != 0) goto L_0x0028
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0028
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x0028:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbdn r0 = r10.zzn
            if (r0 == 0) goto L_0x0032
            r0.zzc(r11, r12)
        L_0x0032:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a0
            int r0 = r10.zzt
            if (r0 <= 0) goto L_0x003e
            if (r0 != r11) goto L_0x0044
        L_0x003e:
            int r0 = r10.zzu
            if (r0 <= 0) goto L_0x009c
            if (r0 == r12) goto L_0x009c
        L_0x0044:
            boolean r0 = r10.zze
            if (r0 != 0) goto L_0x0049
            goto L_0x009c
        L_0x0049:
            boolean r0 = r10.zzP()
            if (r0 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzbew r0 = r10.zzi
            com.google.android.gms.internal.ads.zzij r0 = r0.zzo()
            long r2 = r0.zzm()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009c
            boolean r2 = r0.zzf()
            if (r2 != 0) goto L_0x009c
            r2 = 1
            r10.zzT(r1, r2)
            r0.zze(r2)
            long r1 = r0.zzm()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.currentTimeMillis()
        L_0x0078:
            boolean r5 = r10.zzP()
            if (r5 == 0) goto L_0x0095
            long r5 = r0.zzm()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0095
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzs.zzj()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0078
        L_0x0095:
            r1 = 0
            r0.zze(r1)
            r10.zzq()
        L_0x009c:
            r10.zzt = r11
            r10.zzu = r12
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbef.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzo) {
            zzbdn zzbdn = new zzbdn(getContext());
            this.zzn = zzbdn;
            zzbdn.zzb(surfaceTexture, i, i2);
            this.zzn.start();
            SurfaceTexture zze2 = this.zzn.zze();
            if (zze2 != null) {
                surfaceTexture = zze2;
            } else {
                this.zzn.zzd();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzR();
        } else {
            zzS(surface, true);
            if (!this.zzf.zza) {
                zzY();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzX(i, i2);
        } else {
            zzW();
        }
        zzr.zza.post(new zzbea(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzf();
        zzbdn zzbdn = this.zzn;
        if (zzbdn != null) {
            zzbdn.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzZ();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzS((Surface) null, true);
        }
        zzr.zza.post(new zzbec(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbdn zzbdn = this.zzn;
        if (zzbdn != null) {
            zzbdn.zzc(i, i2);
        }
        zzr.zza.post(new zzbeb(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zze.zza(sb.toString());
        zzr.zza.post(new zzbed(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzU();
            } else if (i == 4) {
                if (this.zzf.zza) {
                    zzZ();
                }
                this.zzd.zzf();
                this.zzb.zze();
                zzr.zza.post(new zzbdw(this));
            }
        }
    }

    public final void zzB(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzW();
    }

    public final void zzC(String str, Exception exc) {
        String zzV = zzV(str, exc);
        String valueOf = String.valueOf(zzV);
        zzbbk.zzi(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzl = true;
        if (this.zzf.zza) {
            zzZ();
        }
        zzr.zza.post(new zzbdx(this, zzV));
    }

    public final void zzD(String str, Exception exc) {
        String zzV = zzV("onLoadException", exc);
        String valueOf = String.valueOf(zzV);
        zzbbk.zzi(valueOf.length() != 0 ? "ExoPlayerAdapter exception: ".concat(valueOf) : new String("ExoPlayerAdapter exception: "));
        zzr.zza.post(new zzbdv(this, zzV));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE(String str) {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzg("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(int i) {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(int i, int i2) {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzj(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzc();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM(String str) {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzf("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zze();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO() {
        zzbcx zzbcx = this.zzg;
        if (zzbcx != null) {
            zzbcx.zzb();
        }
    }

    public final String zza() {
        String str = true != this.zzo ? "" : " spherical";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zzb(zzbcx zzbcx) {
        this.zzg = zzbcx;
    }

    public final void zzc(String str) {
        if (str != null) {
            this.zzj = str;
            this.zzk = new String[]{str};
            zzR();
        }
    }

    public final void zzd() {
        if (zzP()) {
            this.zzi.zzo().zzh();
            if (this.zzi != null) {
                zzS((Surface) null, true);
                zzbew zzbew = this.zzi;
                if (zzbew != null) {
                    zzbew.zzr((zzbev) null);
                    this.zzi.zzv();
                    this.zzi = null;
                }
                this.zzm = 1;
                this.zzl = false;
                this.zzp = false;
                this.zzq = false;
            }
        }
        this.zzd.zzf();
        this.zzb.zze();
        this.zzd.zzc();
    }

    public final void zze() {
        if (zzQ()) {
            if (this.zzf.zza) {
                zzY();
            }
            this.zzi.zzo().zze(true);
            this.zzd.zze();
            this.zzb.zzd();
            this.zza.zza();
            zzr.zza.post(new zzbdy(this));
            return;
        }
        this.zzq = true;
    }

    public final void zzf() {
        if (zzQ()) {
            if (this.zzf.zza) {
                zzZ();
            }
            this.zzi.zzo().zze(false);
            this.zzd.zzf();
            this.zzb.zze();
            zzr.zza.post(new zzbdz(this));
        }
    }

    public final int zzg() {
        if (zzQ()) {
            return (int) this.zzi.zzo().zzl();
        }
        return 0;
    }

    public final int zzh() {
        if (zzQ()) {
            return (int) this.zzi.zzo().zzm();
        }
        return 0;
    }

    public final void zzi(int i) {
        if (zzQ()) {
            this.zzi.zzo().zzg((long) i);
        }
    }

    public final void zzj(float f, float f2) {
        zzbdn zzbdn = this.zzn;
        if (zzbdn != null) {
            zzbdn.zzf(f, f2);
        }
    }

    public final int zzk() {
        return this.zzr;
    }

    public final int zzl() {
        return this.zzs;
    }

    public final long zzm() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            return zzbew.zzx();
        }
        return -1;
    }

    public final long zzn() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            return zzbew.zzy();
        }
        return -1;
    }

    public final long zzo() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            return zzbew.zzz();
        }
        return -1;
    }

    public final int zzp() {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            return zzbew.zzA();
        }
        return -1;
    }

    public final void zzq() {
        zzT(this.zzb.zzc(), false);
    }

    /* access modifiers changed from: package-private */
    public final zzbew zzr() {
        return new zzbew(this.zzc.getContext(), this.zzf, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final String zzs() {
        return zzs.zzc().zze(this.zzc.getContext(), this.zzc.zzt().zza);
    }

    public final void zzt(boolean z, long j) {
        if (this.zzc != null) {
            zzbbw.zze.execute(new zzbee(this, z, j));
        }
    }

    public final void zzu(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                zzc(str);
            }
            this.zzj = str;
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzR();
        }
    }

    public final void zzv(int i) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzs().zzg(i);
        }
    }

    public final void zzw(int i) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzs().zzh(i);
        }
    }

    public final void zzx(int i) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzs().zzi(i);
        }
    }

    public final void zzy(int i) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzs().zzj(i);
        }
    }

    public final void zzz(int i) {
        zzbew zzbew = this.zzi;
        if (zzbew != null) {
            zzbew.zzD(i);
        }
    }
}
