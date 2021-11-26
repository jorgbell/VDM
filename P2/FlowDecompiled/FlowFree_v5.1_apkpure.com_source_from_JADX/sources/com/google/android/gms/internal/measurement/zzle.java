package com.google.android.gms.internal.measurement;

import com.mopub.common.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzle implements zzld {
    public static final zzfh<Long> zzA;
    public static final zzfh<Long> zzB;
    public static final zzfh<Long> zzC;
    public static final zzfh<Long> zzD;
    public static final zzfh<Long> zzE;
    public static final zzfh<Long> zzF;
    public static final zzfh<Long> zzG;
    public static final zzfh<Long> zzH;
    public static final zzfh<Long> zzI;
    public static final zzfh<Long> zzJ;
    public static final zzfh<String> zzK;
    public static final zzfh<Long> zzL;
    public static final zzfh<Long> zza;
    public static final zzfh<Long> zzb;
    public static final zzfh<Long> zzc;
    public static final zzfh<String> zze;
    public static final zzfh<String> zzf;
    public static final zzfh<Long> zzg;
    public static final zzfh<Long> zzh;
    public static final zzfh<Long> zzi;
    public static final zzfh<Long> zzj;
    public static final zzfh<Long> zzk;
    public static final zzfh<Long> zzl;
    public static final zzfh<Long> zzm;
    public static final zzfh<Long> zzn;
    public static final zzfh<Long> zzo;
    public static final zzfh<Long> zzp;
    public static final zzfh<Long> zzr;
    public static final zzfh<Long> zzt;
    public static final zzfh<Long> zzu;
    public static final zzfh<Long> zzv;
    public static final zzfh<Long> zzw;
    public static final zzfh<Long> zzx;
    public static final zzfh<Long> zzy;
    public static final zzfh<Long> zzz;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zza("measurement.ad_id_cache_time", 10000);
        zzb = zzff.zza("measurement.max_bundles_per_iteration", 100);
        zzc = zzff.zza("measurement.config.cache_time", 86400000);
        zzff.zzd("measurement.log_tag", "FA");
        zze = zzff.zzd("measurement.config.url_authority", "app-measurement.com");
        zzf = zzff.zzd("measurement.config.url_scheme", Constants.HTTPS);
        zzg = zzff.zza("measurement.upload.debug_upload_interval", 1000);
        zzh = zzff.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzi = zzff.zza("measurement.store.max_stored_events_per_app", 100000);
        zzj = zzff.zza("measurement.experiment.max_ids", 50);
        zzk = zzff.zza("measurement.audience.filter_result_max_count", 200);
        zzl = zzff.zza("measurement.alarm_manager.minimum_interval", 60000);
        zzm = zzff.zza("measurement.upload.minimum_delay", 500);
        zzn = zzff.zza("measurement.monitoring.sample_period_millis", 86400000);
        zzo = zzff.zza("measurement.upload.realtime_upload_interval", 10000);
        zzp = zzff.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzff.zza("measurement.config.cache_time.service", 3600000);
        zzr = zzff.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzff.zzd("measurement.log_tag.service", "FA-SVC");
        zzt = zzff.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        zzu = zzff.zza("measurement.sdk.attribution.cache.ttl", 604800000);
        zzv = zzff.zza("measurement.upload.backoff_period", 43200000);
        zzw = zzff.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzx = zzff.zza("measurement.upload.interval", 3600000);
        zzy = zzff.zza("measurement.upload.max_bundle_size", 65536);
        zzz = zzff.zza("measurement.upload.max_bundles", 100);
        zzA = zzff.zza("measurement.upload.max_conversions_per_day", 500);
        zzB = zzff.zza("measurement.upload.max_error_events_per_day", 1000);
        zzC = zzff.zza("measurement.upload.max_events_per_bundle", 1000);
        zzD = zzff.zza("measurement.upload.max_events_per_day", 100000);
        zzE = zzff.zza("measurement.upload.max_public_events_per_day", 50000);
        zzF = zzff.zza("measurement.upload.max_queue_time", 2419200000L);
        zzG = zzff.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzH = zzff.zza("measurement.upload.max_batch_size", 65536);
        zzI = zzff.zza("measurement.upload.retry_count", 6);
        zzJ = zzff.zza("measurement.upload.retry_time", 1800000);
        zzK = zzff.zzd("measurement.upload.url", "https://app-measurement.com/a");
        zzL = zzff.zza("measurement.upload.window_interval", 3600000);
    }

    public final long zzA() {
        return zzD.zze().longValue();
    }

    public final long zzB() {
        return zzE.zze().longValue();
    }

    public final long zzC() {
        return zzF.zze().longValue();
    }

    public final long zzD() {
        return zzG.zze().longValue();
    }

    public final long zzE() {
        return zzH.zze().longValue();
    }

    public final long zzF() {
        return zzI.zze().longValue();
    }

    public final long zzG() {
        return zzJ.zze().longValue();
    }

    public final String zzH() {
        return zzK.zze();
    }

    public final long zzI() {
        return zzL.zze().longValue();
    }

    public final long zza() {
        return zza.zze().longValue();
    }

    public final long zzb() {
        return zzb.zze().longValue();
    }

    public final long zzc() {
        return zzc.zze().longValue();
    }

    public final String zzd() {
        return zze.zze();
    }

    public final String zze() {
        return zzf.zze();
    }

    public final long zzf() {
        return zzg.zze().longValue();
    }

    public final long zzg() {
        return zzh.zze().longValue();
    }

    public final long zzh() {
        return zzi.zze().longValue();
    }

    public final long zzi() {
        return zzj.zze().longValue();
    }

    public final long zzj() {
        return zzk.zze().longValue();
    }

    public final long zzk() {
        return zzl.zze().longValue();
    }

    public final long zzl() {
        return zzm.zze().longValue();
    }

    public final long zzm() {
        return zzn.zze().longValue();
    }

    public final long zzn() {
        return zzo.zze().longValue();
    }

    public final long zzo() {
        return zzp.zze().longValue();
    }

    public final long zzp() {
        return zzr.zze().longValue();
    }

    public final long zzq() {
        return zzt.zze().longValue();
    }

    public final long zzr() {
        return zzu.zze().longValue();
    }

    public final long zzs() {
        return zzv.zze().longValue();
    }

    public final long zzt() {
        return zzw.zze().longValue();
    }

    public final long zzu() {
        return zzx.zze().longValue();
    }

    public final long zzv() {
        return zzy.zze().longValue();
    }

    public final long zzw() {
        return zzz.zze().longValue();
    }

    public final long zzx() {
        return zzA.zze().longValue();
    }

    public final long zzy() {
        return zzB.zze().longValue();
    }

    public final long zzz() {
        return zzC.zze().longValue();
    }
}
