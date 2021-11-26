package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zznd implements zznc {
    public static final zzfh<Boolean> zza;
    public static final zzfh<Double> zzb;
    public static final zzfh<Long> zzc;
    public static final zzfh<Long> zzd;
    public static final zzfh<String> zze;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.test.boolean_flag", false);
        zzb = zzff.zzc("measurement.test.double_flag", -3.0d);
        zzc = zzff.zza("measurement.test.int_flag", -2);
        zzd = zzff.zza("measurement.test.long_flag", -1);
        zze = zzff.zzd("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }

    public final double zzb() {
        return zzb.zze().doubleValue();
    }

    public final long zzc() {
        return zzc.zze().longValue();
    }

    public final long zzd() {
        return zzd.zze().longValue();
    }

    public final String zze() {
        return zze.zze();
    }
}
