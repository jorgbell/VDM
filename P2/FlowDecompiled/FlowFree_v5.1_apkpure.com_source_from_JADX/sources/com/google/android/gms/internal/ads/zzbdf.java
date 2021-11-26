package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbdf extends FrameLayout implements zzbcx {
    private final zzbdp zza;
    private final FrameLayout zzb;
    private final zzaff zzc;
    private final zzbdr zzd;
    private final long zze;
    private final zzbcy zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private String zzm;
    private String[] zzn;
    private Bitmap zzo;
    private final ImageView zzp;
    private boolean zzq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbdf(Context context, zzbdp zzbdp, int i, boolean z, zzaff zzaff, zzbdo zzbdo) {
        super(context);
        zzbcy zzbcy;
        Context context2 = context;
        zzaff zzaff2 = zzaff;
        this.zza = zzbdp;
        this.zzc = zzaff2;
        FrameLayout frameLayout = new FrameLayout(context2);
        this.zzb = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbdp.zzk());
        zzbcz zzbcz = zzbdp.zzk().zza;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            zzbdq zzbdq = new zzbdq(context, zzbdp.zzt(), zzbdp.zzm(), zzaff, zzbdp.zzi());
            if (i == 2) {
                zzbcy = new zzbef(context, zzbdq, zzbdp, z, zzbcz.zza(zzbdp), zzbdo);
            } else {
                Context context3 = context;
                zzbcy = new zzbcw(context3, zzbdp, z, zzbcz.zza(zzbdp), zzbdo, new zzbdq(context3, zzbdp.zzt(), zzbdp.zzm(), zzaff, zzbdp.zzi()));
            }
        } else {
            zzbcy = null;
        }
        this.zzf = zzbcy;
        if (zzbcy != null) {
            frameLayout.addView(zzbcy, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzy)).booleanValue()) {
                zzB();
            }
        }
        this.zzp = new ImageView(context2);
        this.zze = ((Long) zzaaa.zzc().zzb(zzaeq.zzC)).longValue();
        boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzA)).booleanValue();
        this.zzj = booleanValue;
        if (zzaff2 != null) {
            zzaff2.zzd("spinner_used", true != booleanValue ? "0" : "1");
        }
        this.zzd = new zzbdr(this);
        if (zzbcy != null) {
            zzbcy.zzb(this);
        }
        if (zzbcy == null) {
            zzf("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private final boolean zzG() {
        return this.zzp.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzH(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zza.zze("onVideoEvent", hashMap);
    }

    private final void zzI() {
        if (this.zza.zzj() != null && this.zzh && !this.zzi) {
            this.zza.zzj().getWindow().clearFlags(128);
            this.zzh = false;
        }
    }

    public final void finalize() throws Throwable {
        try {
            this.zzd.zza();
            zzbcy zzbcy = this.zzf;
            if (zzbcy != null) {
                zzbbw.zze.execute(zzbda.zza(zzbcy));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzd.zzb();
        } else {
            this.zzd.zza();
            this.zzl = this.zzk;
        }
        zzr.zza.post(new zzbdb(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzd.zzb();
            z = true;
        } else {
            this.zzd.zza();
            this.zzl = this.zzk;
            z = false;
        }
        zzr.zza.post(new zzbde(this, z));
    }

    @TargetApi(14)
    public final void zzA(MotionEvent motionEvent) {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.dispatchTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    public final void zzB() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            TextView textView = new TextView(zzbcy.getContext());
            String valueOf = String.valueOf(this.zzf.zza());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.zzb.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzb.bringChildToFront(textView);
        }
    }

    public final void zzC() {
        this.zzd.zza();
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzd();
        }
        zzI();
    }

    /* access modifiers changed from: package-private */
    public final void zzD() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            long zzh2 = (long) zzbcy.zzh();
            if (this.zzk != zzh2 && zzh2 > 0) {
                float f = ((float) zzh2) / 1000.0f;
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue()) {
                    zzH("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzf.zzo()), "qoeCachedBytes", String.valueOf(this.zzf.zzn()), "qoeLoadedBytes", String.valueOf(this.zzf.zzm()), "droppedFrames", String.valueOf(this.zzf.zzp()), "reportTime", String.valueOf(zzs.zzj().currentTimeMillis()));
                } else {
                    zzH("timeupdate", "time", String.valueOf(f));
                }
                this.zzk = zzh2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE(boolean z) {
        zzH("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zza() {
        this.zzd.zzb();
        zzr.zza.post(new zzbdc(this));
    }

    public final void zzb() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null && this.zzl == 0) {
            zzH("canplaythrough", VastIconXmlManager.DURATION, String.valueOf(((float) zzbcy.zzg()) / 1000.0f), "videoWidth", String.valueOf(this.zzf.zzk()), "videoHeight", String.valueOf(this.zzf.zzl()));
        }
    }

    public final void zzc() {
        if (this.zza.zzj() != null && !this.zzh) {
            boolean z = (this.zza.zzj().getWindow().getAttributes().flags & 128) != 0;
            this.zzi = z;
            if (!z) {
                this.zza.zzj().getWindow().addFlags(128);
                this.zzh = true;
            }
        }
        this.zzg = true;
    }

    public final void zzd() {
        zzH("pause", new String[0]);
        zzI();
        this.zzg = false;
    }

    public final void zze() {
        zzH("ended", new String[0]);
        zzI();
    }

    public final void zzf(String str, String str2) {
        zzH("error", "what", str, "extra", str2);
    }

    public final void zzg(String str, String str2) {
        zzH("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzh() {
        if (this.zzq && this.zzo != null && !zzG()) {
            this.zzp.setImageBitmap(this.zzo);
            this.zzp.invalidate();
            this.zzb.addView(this.zzp, new FrameLayout.LayoutParams(-1, -1));
            this.zzb.bringChildToFront(this.zzp);
        }
        this.zzd.zza();
        this.zzl = this.zzk;
        zzr.zza.post(new zzbdd(this));
    }

    public final void zzi() {
        if (this.zzg && zzG()) {
            this.zzb.removeView(this.zzp);
        }
        if (this.zzo != null) {
            long elapsedRealtime = zzs.zzj().elapsedRealtime();
            if (this.zzf.getBitmap(this.zzo) != null) {
                this.zzq = true;
            }
            long elapsedRealtime2 = zzs.zzj().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zze.zza(sb.toString());
            }
            if (elapsedRealtime2 > this.zze) {
                zzbbk.zzi("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzj = false;
                this.zzo = null;
                zzaff zzaff = this.zzc;
                if (zzaff != null) {
                    zzaff.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzj(int i, int i2) {
        if (this.zzj) {
            zzaei zzaei = zzaeq.zzB;
            int max = Math.max(i / ((Integer) zzaaa.zzc().zzb(zzaei)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzaaa.zzc().zzb(zzaei)).intValue(), 1);
            Bitmap bitmap = this.zzo;
            if (bitmap == null || bitmap.getWidth() != max || this.zzo.getHeight() != max2) {
                this.zzo = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzq = false;
            }
        }
    }

    public final void zzk(int i) {
        this.zzb.setBackgroundColor(i);
    }

    public final void zzl(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzm(String str, String[] strArr) {
        this.zzm = str;
        this.zzn = strArr;
    }

    public final void zzn(float f, float f2) {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzj(f, f2);
        }
    }

    public final void zzo() {
        if (this.zzf != null) {
            if (!TextUtils.isEmpty(this.zzm)) {
                this.zzf.zzu(this.zzm, this.zzn);
            } else {
                zzH("no_src", new String[0]);
            }
        }
    }

    public final void zzp() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzf();
        }
    }

    public final void zzq() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zze();
        }
    }

    public final void zzr(int i) {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzi(i);
        }
    }

    public final void zzs() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzb.zza(true);
            zzbcy.zzq();
        }
    }

    public final void zzt() {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzb.zza(false);
            zzbcy.zzq();
        }
    }

    public final void zzu(float f) {
        zzbcy zzbcy = this.zzf;
        if (zzbcy != null) {
            zzbcy.zzb.zzb(f);
            zzbcy.zzq();
        }
    }

    public final void zzv(int i) {
        this.zzf.zzv(i);
    }

    public final void zzw(int i) {
        this.zzf.zzw(i);
    }

    public final void zzx(int i) {
        this.zzf.zzx(i);
    }

    public final void zzy(int i) {
        this.zzf.zzy(i);
    }

    public final void zzz(int i) {
        this.zzf.zzz(i);
    }
}
