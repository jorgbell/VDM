package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzmc implements zzmb {
    public static final zzfh<Boolean> zzb;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zzff.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzff.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
        zzff.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return zzb.zze().booleanValue();
    }
}
