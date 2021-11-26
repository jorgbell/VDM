package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzlh implements zzlg {
    public static final zzfh<Boolean> zza;
    public static final zzfh<Boolean> zzb;
    public static final zzfh<Boolean> zzc;
    public static final zzfh<Long> zze;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.client.consent_state_v1", true);
        zzb = zzff.zzb("measurement.client.3p_consent_state_v1", true);
        zzc = zzff.zzb("measurement.service.consent_state_v1_W36", true);
        zzff.zza("measurement.id.service.consent_state_v1_W36", 0);
        zze = zzff.zza("measurement.service.storage_consent_support_version", 203590);
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

    public final boolean zzd() {
        return zzc.zze().booleanValue();
    }

    public final long zze() {
        return zze.zze().longValue();
    }
}
