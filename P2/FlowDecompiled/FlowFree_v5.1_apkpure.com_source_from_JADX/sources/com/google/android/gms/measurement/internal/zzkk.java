package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdg;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzdk;
import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzdv;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziv;
import com.mopub.network.ImpressionData;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzkk extends zzjz {
    zzkk(zzki zzki) {
        super(zzki);
    }

    static final Object zzA(zzdc zzdc, String str) {
        zzdg zzz = zzz(zzdc, str);
        if (zzz == null) {
            return null;
        }
        if (zzz.zzc()) {
            return zzz.zzd();
        }
        if (zzz.zze()) {
            return Long.valueOf(zzz.zzf());
        }
        if (zzz.zzi()) {
            return Double.valueOf(zzz.zzj());
        }
        if (zzz.zzm() <= 0) {
            return null;
        }
        List<zzdg> zzk = zzz.zzk();
        ArrayList arrayList = new ArrayList();
        for (zzdg next : zzk) {
            if (next != null) {
                Bundle bundle = new Bundle();
                for (zzdg next2 : next.zzk()) {
                    if (next2.zzc()) {
                        bundle.putString(next2.zzb(), next2.zzd());
                    } else if (next2.zze()) {
                        bundle.putLong(next2.zzb(), next2.zzf());
                    } else if (next2.zzi()) {
                        bundle.putDouble(next2.zzb(), next2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzB(StringBuilder sb, int i, List<zzdg> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzdg next : list) {
                if (next != null) {
                    zzD(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    zzG(sb, i2, MediationMetaData.KEY_NAME, next.zza() ? this.zzs.zzm().zzd(next.zzb()) : null);
                    zzG(sb, i2, "string_value", next.zzc() ? next.zzd() : null);
                    zzG(sb, i2, "int_value", next.zze() ? Long.valueOf(next.zzf()) : null);
                    if (next.zzi()) {
                        d = Double.valueOf(next.zzj());
                    }
                    zzG(sb, i2, "double_value", d);
                    if (next.zzm() > 0) {
                        zzB(sb, i2, next.zzk());
                    }
                    zzD(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zzC(StringBuilder sb, int i, zzbz zzbz) {
        if (zzbz != null) {
            zzD(sb, i);
            sb.append("filter {\n");
            if (zzbz.zze()) {
                zzG(sb, i, "complement", Boolean.valueOf(zzbz.zzf()));
            }
            if (zzbz.zzg()) {
                zzG(sb, i, "param_name", this.zzs.zzm().zzd(zzbz.zzh()));
            }
            if (zzbz.zza()) {
                int i2 = i + 1;
                zzcl zzb = zzbz.zzb();
                if (zzb != null) {
                    zzD(sb, i2);
                    sb.append("string_filter {\n");
                    if (zzb.zza()) {
                        zzG(sb, i2, "match_type", zzb.zzb().name());
                    }
                    if (zzb.zzc()) {
                        zzG(sb, i2, "expression", zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zzG(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zzD(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : zzb.zzg()) {
                            zzD(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zzD(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzbz.zzc()) {
                zzH(sb, i + 1, "number_filter", zzbz.zzd());
            }
            zzD(sb, i);
            sb.append("}\n");
        }
    }

    private static final void zzD(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final String zzE(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzF(StringBuilder sb, int i, String str, zzdr zzdr) {
        if (zzdr != null) {
            zzD(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzdr.zzd() != 0) {
                zzD(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long next : zzdr.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzdr.zzb() != 0) {
                zzD(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long next2 : zzdr.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzdr.zzf() != 0) {
                zzD(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzda next3 : zzdr.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next3.zza() ? Integer.valueOf(next3.zzb()) : null);
                    sb.append(":");
                    sb.append(next3.zzc() ? Long.valueOf(next3.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzdr.zzi() != 0) {
                zzD(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzdt next4 : zzdr.zzh()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next4.zza() ? Integer.valueOf(next4.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next4.zzc()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zzD(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void zzG(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zzD(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static final void zzH(StringBuilder sb, int i, String str, zzce zzce) {
        if (zzce != null) {
            zzD(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzce.zza()) {
                zzG(sb, i, "comparison_type", zzce.zzb().name());
            }
            if (zzce.zzc()) {
                zzG(sb, i, "match_as_float", Boolean.valueOf(zzce.zzd()));
            }
            if (zzce.zze()) {
                zzG(sb, i, "comparison_value", zzce.zzf());
            }
            if (zzce.zzg()) {
                zzG(sb, i, "min_comparison_value", zzce.zzh());
            }
            if (zzce.zzi()) {
                zzG(sb, i, "max_comparison_value", zzce.zzj());
            }
            zzD(sb, i);
            sb.append("}\n");
        }
    }

    static boolean zzl(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zzm(List<Long> list, int i) {
        if (i >= list.size() * 64) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    static List<Long> zzn(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    static <Builder extends zziv> Builder zzt(Builder builder, byte[] bArr) throws zzib {
        zzhd zzb = zzhd.zzb();
        if (zzb != null) {
            builder.zzav(bArr, zzb);
            return builder;
        }
        builder.zzaw(bArr);
        return builder;
    }

    static int zzu(zzdj zzdj, String str) {
        for (int i = 0; i < zzdj.zzk(); i++) {
            if (str.equals(zzdj.zzl(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    static List<zzdg> zzv(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzdf zzn = zzdg.zzn();
                for (String str : bundle.keySet()) {
                    zzdf zzn2 = zzdg.zzn();
                    zzn2.zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zzn2.zzd(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zzn2.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zzn2.zzf(((Double) obj).doubleValue());
                    }
                    zzn.zzi(zzn2);
                }
                if (zzn.zzh() > 0) {
                    arrayList.add((zzdg) zzn.zzaA());
                }
            }
        }
        return arrayList;
    }

    static final void zzx(zzdb zzdb, String str, Object obj) {
        List<zzdg> zza = zzdb.zza();
        int i = 0;
        while (true) {
            if (i >= zza.size()) {
                i = -1;
                break;
            } else if (str.equals(zza.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzdf zzn = zzdg.zzn();
        zzn.zza(str);
        if (obj instanceof Long) {
            zzn.zzd(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzn.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzn.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzn.zzj(zzv((Bundle[]) obj));
        }
        if (i >= 0) {
            zzdb.zze(i, zzn);
        } else {
            zzdb.zzg(zzn);
        }
    }

    static final boolean zzy(zzas zzas, zzp zzp) {
        Preconditions.checkNotNull(zzas);
        Preconditions.checkNotNull(zzp);
        return !TextUtils.isEmpty(zzp.zzb) || !TextUtils.isEmpty(zzp.zzq);
    }

    static final zzdg zzz(zzdc zzdc, String str) {
        for (zzdg next : zzdc.zza()) {
            if (next.zzb().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzdu zzdu, Object obj) {
        Preconditions.checkNotNull(obj);
        zzdu.zzd();
        zzdu.zzf();
        zzdu.zzh();
        if (obj instanceof String) {
            zzdu.zzc((String) obj);
        } else if (obj instanceof Long) {
            zzdu.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzdu.zzg(((Double) obj).doubleValue());
        } else {
            this.zzs.zzau().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzdf zzdf, Object obj) {
        Preconditions.checkNotNull(obj);
        zzdf.zzc();
        zzdf.zze();
        zzdf.zzg();
        zzdf.zzk();
        if (obj instanceof String) {
            zzdf.zzb((String) obj);
        } else if (obj instanceof Long) {
            zzdf.zzd(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzdf.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzdf.zzj(zzv((Bundle[]) obj));
        } else {
            this.zzs.zzau().zzb().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzdc zzf(zzan zzan) {
        zzdb zzk = zzdc.zzk();
        zzk.zzq(zzan.zze);
        zzap zzap = new zzap(zzan.zzf);
        while (zzap.hasNext()) {
            String zza = zzap.next();
            zzdf zzn = zzdg.zzn();
            zzn.zza(zza);
            Object zza2 = zzan.zzf.zza(zza);
            Preconditions.checkNotNull(zza2);
            zzd(zzn, zza2);
            zzk.zzg(zzn);
        }
        return (zzdc) zzk.zzaA();
    }

    /* access modifiers changed from: package-private */
    public final String zzh(zzdi zzdi) {
        if (zzdi == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzdk next : zzdi.zza()) {
            if (next != null) {
                zzD(sb, 1);
                sb.append("bundle {\n");
                if (next.zza()) {
                    zzG(sb, 1, "protocol_version", Integer.valueOf(next.zzb()));
                }
                zzG(sb, 1, "platform", next.zzt());
                if (next.zzC()) {
                    zzG(sb, 1, "gmp_version", Long.valueOf(next.zzD()));
                }
                if (next.zzE()) {
                    zzG(sb, 1, "uploading_gmp_version", Long.valueOf(next.zzF()));
                }
                if (next.zzae()) {
                    zzG(sb, 1, "dynamite_version", Long.valueOf(next.zzaf()));
                }
                if (next.zzW()) {
                    zzG(sb, 1, "config_version", Long.valueOf(next.zzX()));
                }
                zzG(sb, 1, "gmp_app_id", next.zzP());
                zzG(sb, 1, "admob_app_id", next.zzad());
                zzG(sb, 1, "app_id", next.zzA());
                zzG(sb, 1, ImpressionData.APP_VERSION, next.zzB());
                if (next.zzU()) {
                    zzG(sb, 1, "app_version_major", Integer.valueOf(next.zzV()));
                }
                zzG(sb, 1, "firebase_instance_id", next.zzT());
                if (next.zzK()) {
                    zzG(sb, 1, "dev_cert_hash", Long.valueOf(next.zzL()));
                }
                zzG(sb, 1, "app_store", next.zzz());
                if (next.zzi()) {
                    zzG(sb, 1, "upload_timestamp_millis", Long.valueOf(next.zzj()));
                }
                if (next.zzk()) {
                    zzG(sb, 1, "start_timestamp_millis", Long.valueOf(next.zzm()));
                }
                if (next.zzn()) {
                    zzG(sb, 1, "end_timestamp_millis", Long.valueOf(next.zzo()));
                }
                if (next.zzp()) {
                    zzG(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(next.zzq()));
                }
                if (next.zzr()) {
                    zzG(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(next.zzs()));
                }
                zzG(sb, 1, "app_instance_id", next.zzJ());
                zzG(sb, 1, "resettable_device_id", next.zzG());
                zzG(sb, 1, "ds_id", next.zzaa());
                if (next.zzH()) {
                    zzG(sb, 1, "limited_ad_tracking", Boolean.valueOf(next.zzI()));
                }
                zzG(sb, 1, "os_version", next.zzu());
                zzG(sb, 1, "device_model", next.zzv());
                zzG(sb, 1, "user_default_language", next.zzw());
                if (next.zzx()) {
                    zzG(sb, 1, "time_zone_offset_minutes", Integer.valueOf(next.zzy()));
                }
                if (next.zzM()) {
                    zzG(sb, 1, "bundle_sequential_index", Integer.valueOf(next.zzN()));
                }
                if (next.zzQ()) {
                    zzG(sb, 1, "service_upload", Boolean.valueOf(next.zzR()));
                }
                zzG(sb, 1, "health_monitor", next.zzO());
                if (!this.zzs.zzc().zzn((String) null, zzea.zzat) && next.zzY() && next.zzZ() != 0) {
                    zzG(sb, 1, "android_id", Long.valueOf(next.zzZ()));
                }
                if (next.zzab()) {
                    zzG(sb, 1, "retry_counter", Integer.valueOf(next.zzac()));
                }
                if (next.zzah()) {
                    zzG(sb, 1, "consent_signals", next.zzai());
                }
                List<zzdv> zzf = next.zzf();
                if (zzf != null) {
                    for (zzdv next2 : zzf) {
                        if (next2 != null) {
                            zzD(sb, 2);
                            sb.append("user_property {\n");
                            zzG(sb, 2, "set_timestamp_millis", next2.zza() ? Long.valueOf(next2.zzb()) : null);
                            zzG(sb, 2, MediationMetaData.KEY_NAME, this.zzs.zzm().zze(next2.zzc()));
                            zzG(sb, 2, "string_value", next2.zze());
                            zzG(sb, 2, "int_value", next2.zzf() ? Long.valueOf(next2.zzg()) : null);
                            zzG(sb, 2, "double_value", next2.zzh() ? Double.valueOf(next2.zzi()) : null);
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcy> zzS = next.zzS();
                if (zzS != null) {
                    for (zzcy next3 : zzS) {
                        if (next3 != null) {
                            zzD(sb, 2);
                            sb.append("audience_membership {\n");
                            if (next3.zza()) {
                                zzG(sb, 2, "audience_id", Integer.valueOf(next3.zzb()));
                            }
                            if (next3.zzf()) {
                                zzG(sb, 2, "new_audience", Boolean.valueOf(next3.zzg()));
                            }
                            zzF(sb, 2, "current_data", next3.zzc());
                            if (next3.zzd()) {
                                zzF(sb, 2, "previous_data", next3.zze());
                            }
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzdc> zzc = next.zzc();
                if (zzc != null) {
                    for (zzdc next4 : zzc) {
                        if (next4 != null) {
                            zzD(sb, 2);
                            sb.append("event {\n");
                            zzG(sb, 2, MediationMetaData.KEY_NAME, this.zzs.zzm().zzc(next4.zzd()));
                            if (next4.zze()) {
                                zzG(sb, 2, "timestamp_millis", Long.valueOf(next4.zzf()));
                            }
                            if (next4.zzg()) {
                                zzG(sb, 2, "previous_timestamp_millis", Long.valueOf(next4.zzh()));
                            }
                            if (next4.zzi()) {
                                zzG(sb, 2, "count", Integer.valueOf(next4.zzj()));
                            }
                            if (next4.zzb() != 0) {
                                zzB(sb, 2, next4.zza());
                            }
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzD(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzi(zzbx zzbx) {
        if (zzbx == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbx.zza()) {
            zzG(sb, 0, "filter_id", Integer.valueOf(zzbx.zzb()));
        }
        zzG(sb, 0, "event_name", this.zzs.zzm().zzc(zzbx.zzc()));
        String zzE = zzE(zzbx.zzi(), zzbx.zzj(), zzbx.zzm());
        if (!zzE.isEmpty()) {
            zzG(sb, 0, "filter_type", zzE);
        }
        if (zzbx.zzg()) {
            zzH(sb, 1, "event_count_filter", zzbx.zzh());
        }
        if (zzbx.zze() > 0) {
            sb.append("  filters {\n");
            for (zzbz zzC : zzbx.zzd()) {
                zzC(sb, 2, zzC);
            }
        }
        zzD(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzj(zzcg zzcg) {
        if (zzcg == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzcg.zza()) {
            zzG(sb, 0, "filter_id", Integer.valueOf(zzcg.zzb()));
        }
        zzG(sb, 0, "property_name", this.zzs.zzm().zze(zzcg.zzc()));
        String zzE = zzE(zzcg.zze(), zzcg.zzf(), zzcg.zzh());
        if (!zzE.isEmpty()) {
            zzG(sb, 0, "filter_type", zzE);
        }
        zzC(sb, 1, zzcg.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.zzs.zzau().zzb().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zzk(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002f
        L_0x001c:
            com.google.android.gms.measurement.internal.zzfp r5 = r4.zzs     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002f:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzk(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zzo(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                this.zzs.zzau().zze().zzb("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzs.zzau().zze().zzc("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (next.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzs.zzay().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final long zzr(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzs.zzl().zzg();
        MessageDigest zzN = zzkp.zzN();
        if (zzN != null) {
            return zzkp.zzO(zzN.digest(bArr));
        }
        this.zzs.zzau().zzb().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzs(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzs.zzau().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }
}
