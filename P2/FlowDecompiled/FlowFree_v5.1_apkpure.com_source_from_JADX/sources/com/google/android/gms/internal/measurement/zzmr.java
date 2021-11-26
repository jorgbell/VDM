package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzmr implements zzmq {
    public static final zzfh<Boolean> zza;
    public static final zzfh<Boolean> zzb;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzff.zzb("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zze().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zze().booleanValue();
    }
}
