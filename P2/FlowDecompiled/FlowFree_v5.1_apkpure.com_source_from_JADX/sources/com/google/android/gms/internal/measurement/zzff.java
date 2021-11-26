package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzff {
    final String zza = null;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzfm<Context, Boolean> zzi;

    public zzff(Uri uri) {
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzfh<Long> zza(String str, long j) {
        return new zzfb(this, str, Long.valueOf(j), true);
    }

    public final zzfh<Boolean> zzb(String str, boolean z) {
        return new zzfc(this, str, Boolean.valueOf(z), true);
    }

    public final zzfh<Double> zzc(String str, double d) {
        return new zzfd(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzfh<String> zzd(String str, String str2) {
        return new zzfe(this, str, str2, true);
    }
}
