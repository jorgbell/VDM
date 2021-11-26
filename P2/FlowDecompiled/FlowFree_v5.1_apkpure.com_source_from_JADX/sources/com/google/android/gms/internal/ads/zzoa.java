package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzoa implements zznw {
    private final zznw[] zza;
    private final ArrayList<zznw> zzb;
    private final zzjd zzc = new zzjd();
    private zznv zzd;
    private zzje zze;
    private int zzf = -1;
    private zznz zzg;

    public zzoa(zznw... zznwArr) {
        this.zza = zznwArr;
        this.zzb = new ArrayList<>(Arrays.asList(zznwArr));
    }

    static /* synthetic */ void zzf(zzoa zzoa, int i, zzje zzje, Object obj) {
        zznz zznz;
        if (zzoa.zzg == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                zzje.zzg(i2, zzoa.zzc, false);
            }
            int i3 = zzoa.zzf;
            if (i3 == -1) {
                zzoa.zzf = 1;
            } else if (i3 != 1) {
                zznz = new zznz(1);
                zzoa.zzg = zznz;
            }
            zznz = null;
            zzoa.zzg = zznz;
        }
        if (zzoa.zzg == null) {
            zzoa.zzb.remove(zzoa.zza[i]);
            if (i == 0) {
                zzoa.zze = zzje;
            }
            if (zzoa.zzb.isEmpty()) {
                zzoa.zzd.zzi(zzoa.zze, (Object) null);
            }
        }
    }

    public final void zza(zzij zzij, boolean z, zznv zznv) {
        this.zzd = zznv;
        int i = 0;
        while (true) {
            zznw[] zznwArr = this.zza;
            if (i < zznwArr.length) {
                zznwArr[i].zza(zzij, false, new zzny(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzb() throws IOException {
        zznz zznz = this.zzg;
        if (zznz == null) {
            for (zznw zzb2 : this.zza) {
                zzb2.zzb();
            }
            return;
        }
        throw zznz;
    }

    public final void zzc(zznu zznu) {
        zznx zznx = (zznx) zznu;
        int i = 0;
        while (true) {
            zznw[] zznwArr = this.zza;
            if (i < zznwArr.length) {
                zznwArr[i].zzc(zznx.zza[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzd() {
        for (zznw zzd2 : this.zza) {
            zzd2.zzd();
        }
    }

    public final zznu zze(int i, zzph zzph) {
        int length = this.zza.length;
        zznu[] zznuArr = new zznu[length];
        for (int i2 = 0; i2 < length; i2++) {
            zznuArr[i2] = this.zza[i2].zze(i, zzph);
        }
        return new zznx(zznuArr);
    }
}
