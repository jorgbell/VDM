package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.ads.internal.util.zzaw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbdq {
    private final Context zza;
    private final String zzb;
    private final zzbbq zzc;
    private final zzafc zzd;
    private final zzaff zze;
    private final zzaw zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm;
    private zzbcy zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq = -1;

    public zzbdq(Context context, zzbbq zzbbq, String str, zzaff zzaff, zzafc zzafc) {
        zzav zzav = new zzav();
        zzav zzav2 = zzav;
        zzav2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzav2.zza("1_5", 1.0d, 5.0d);
        zzav2.zza("5_10", 5.0d, 10.0d);
        zzav2.zza("10_20", 10.0d, 20.0d);
        zzav2.zza("20_30", 20.0d, 30.0d);
        zzav2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzav.zzb();
        this.zza = context;
        this.zzc = zzbbq;
        this.zzb = str;
        this.zze = zzaff;
        this.zzd = zzafc;
        String str2 = (String) zzaaa.zzc().zzb(zzaeq.zzw);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzg[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzbbk.zzj("Unable to parse frame hash target time number.", e);
                this.zzg[i] = -1;
            }
        }
    }

    public final void zza(zzbcy zzbcy) {
        zzaex.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzbcy.zza());
        this.zzn = zzbcy;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzaex.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        if (zzago.zza.zze().booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzb);
            bundle.putString("player", this.zzn.zza());
            for (zzau next : this.zzf.zzb()) {
                String valueOf = String.valueOf(next.zza);
                bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(next.zze));
                String valueOf2 = String.valueOf(next.zza);
                bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(next.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i < jArr.length) {
                    String str = this.zzh[i];
                    if (str != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzs.zzc().zzj(this.zza, this.zzc.zza, "gmob-apps", bundle, true);
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zzd(zzbcy zzbcy) {
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzaex.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzs.zzj().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            long nanos = TimeUnit.SECONDS.toNanos(1);
            long j = this.zzq;
            zzaw zzaw = this.zzf;
            double d = (double) nanos;
            double d2 = (double) (nanoTime - j);
            Double.isNaN(d);
            Double.isNaN(d2);
            zzaw.zza(d / d2);
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzaaa.zzc().zzb(zzaeq.zzx)).longValue();
        long zzh2 = (long) zzbcy.zzh();
        int i = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(zzh2 - this.zzg[i])) {
                String[] strArr2 = this.zzh;
                int i2 = 8;
                Bitmap bitmap = zzbcy.getBitmap(8, 8);
                long j2 = 63;
                long j3 = 0;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j3 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j2);
                        i4++;
                        j2--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j3)});
                return;
            }
            zzbcy zzbcy2 = zzbcy;
            i++;
        }
    }

    public final void zze() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzaex.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzf() {
        this.zzm = false;
    }
}
