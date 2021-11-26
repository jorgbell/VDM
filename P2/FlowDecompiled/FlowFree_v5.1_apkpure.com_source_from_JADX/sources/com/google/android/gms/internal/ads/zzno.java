package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzno {
    private final zzku[] zza;
    private final zzkv zzb;
    private zzku zzc;

    public zzno(zzku[] zzkuArr, zzkv zzkv) {
        this.zza = zzkuArr;
        this.zzb = zzkv;
    }

    public final void zza() {
        if (this.zzc != null) {
            this.zzc = null;
        }
    }

    public final zzku zzb(zzkt zzkt, Uri uri) throws IOException, InterruptedException {
        zzku zzku = this.zzc;
        if (zzku != null) {
            return zzku;
        }
        zzku[] zzkuArr = this.zza;
        int length = zzkuArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzku zzku2 = zzkuArr[i];
            try {
                if (zzku2.zzf(zzkt)) {
                    this.zzc = zzku2;
                    zzkt.zzg();
                    break;
                }
                zzkt.zzg();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzkt.zzg();
                throw th;
            }
        }
        zzku zzku3 = this.zzc;
        if (zzku3 != null) {
            zzku3.zzd(this.zzb);
            return this.zzc;
        }
        String zzn = zzqj.zzn(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(zzn).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zzn);
        sb.append(") could read the stream.");
        throw new zzom(sb.toString(), uri);
    }
}
