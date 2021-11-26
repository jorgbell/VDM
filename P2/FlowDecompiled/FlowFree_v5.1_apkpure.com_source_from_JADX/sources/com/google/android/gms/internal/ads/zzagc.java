package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzagc {
    public static final zzafs<String> zza = zzafs.zzd("gads:gma_attestation:click:macro_string", "@click_attok@");
    public static final zzafs<String> zzb = zzafs.zzd("gads:gma_attestation:click:query_param", "attok");
    public static final zzafs<Long> zzc = zzafs.zzb("gads:gma_attestation:click:timeout", 2000);
    public static final zzafs<Boolean> zzd = zzafs.zza("gads:gma_attestation:click:enable", false);
    public static final zzafs<Boolean> zze = zzafs.zza("gads:gma_attestation:click:qualification:enable", true);
    public static final zzafs<Boolean> zzf = zzafs.zza("gads:gma_attestation:click_v2:enable", false);
    public static final zzafs<Boolean> zzg = zzafs.zza("gads:gma_attestation:impression:enable", false);
    public static final zzafs<Boolean> zzj = zzafs.zza("gads:gma_attestation:click:report_error", true);

    static {
        zzafs.zza("gads:gma_attestation:request:enable_javascript", false);
        zzafs.zza("gads:gma_attestation:request:enable", false);
    }
}
