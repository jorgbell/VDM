package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdek implements zzdiz<zzdel> {
    private final zzdiz<zzdje> zza;
    private final zzdrg zzb;
    private final Context zzc;
    private final zzbav zzd;

    public zzdek(zzdfv<zzdje> zzdfv, zzdrg zzdrg, Context context, zzbav zzbav) {
        this.zza = zzdfv;
        this.zzb = zzdrg;
        this.zzc = context;
        this.zzd = zzbav;
    }

    public final zzefw<zzdel> zza() {
        return zzefo.zzi(this.zza.zza(), new zzdej(this), zzbbw.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdel zzb(zzdje zzdje) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        DisplayMetrics displayMetrics;
        zzyx zzyx = this.zzb.zze;
        zzyx[] zzyxArr = zzyx.zzg;
        if (zzyxArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzyx zzyx2 : zzyxArr) {
                boolean z4 = zzyx2.zzi;
                if (!z4 && !z2) {
                    str = zzyx2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (!z3) {
                        z3 = true;
                        z = true;
                    } else {
                        z3 = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzyx.zza;
            z = zzyx.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzd.zzl().zzy();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzyx[] zzyxArr2 = zzyx.zzg;
        if (zzyxArr2 != null) {
            boolean z5 = false;
            for (zzyx zzyx3 : zzyxArr2) {
                if (zzyx3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i5 = zzyx3.zze;
                    if (i5 == -1) {
                        i5 = f != 0.0f ? (int) (((float) zzyx3.zzf) / f) : -1;
                    }
                    sb.append(i5);
                    sb.append("x");
                    int i6 = zzyx3.zzb;
                    if (i6 == -2) {
                        i6 = f != 0.0f ? (int) (((float) zzyx3.zzc) / f) : -2;
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdel(zzyx, str, z, sb.toString(), f, i2, i, str2, this.zzb.zzp);
    }
}
