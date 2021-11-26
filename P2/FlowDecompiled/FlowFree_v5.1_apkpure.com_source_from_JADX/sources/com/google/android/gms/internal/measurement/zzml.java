package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzml implements zzmk {
    public static final zzfh<Boolean> zza;
    public static final zzfh<Boolean> zzb;
    public static final zzfh<Boolean> zzc;
    public static final zzfh<Boolean> zzd;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzff.zzb("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzff.zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzff.zzb("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zzff.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zze().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zze().booleanValue();
    }
}
