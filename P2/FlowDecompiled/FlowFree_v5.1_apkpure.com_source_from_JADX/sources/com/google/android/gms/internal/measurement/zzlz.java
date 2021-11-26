package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzlz implements zzly {
    public static final zzfh<Boolean> zza;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzff.zzb("measurement.client.sessions.check_on_startup", true);
        zzff.zzb("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zze().booleanValue();
    }
}
