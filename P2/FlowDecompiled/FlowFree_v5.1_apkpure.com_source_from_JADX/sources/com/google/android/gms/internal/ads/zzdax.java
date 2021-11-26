package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbvn;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdax<AdT, AdapterT, ListenerT extends zzbvn> implements zzcvw<AdT> {
    private final zzcvy<AdapterT, ListenerT> zza;
    private final zzcwe<AdT, AdapterT, ListenerT> zzb;
    private final zzdve zzc;
    private final zzefx zzd;

    public zzdax(zzdve zzdve, zzefx zzefx, zzcvy<AdapterT, ListenerT> zzcvy, zzcwe<AdT, AdapterT, ListenerT> zzcwe) {
        this.zzc = zzdve;
        this.zzd = zzefx;
        this.zzb = zzcwe;
        this.zza = zzcvy;
    }

    static final String zze(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        return !zzdqo.zzs.isEmpty();
    }

    public final zzefw<AdT> zzb(zzdra zzdra, zzdqo zzdqo) {
        zzcvz<AdapterT, ListenerT> zzcvz;
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        Iterator<String> it = zzdqo.zzs.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcvz = null;
                break;
            }
            try {
                zzcvz = this.zza.zza(it.next(), zzdqo.zzu);
                break;
            } catch (zzdrl unused) {
            }
        }
        if (zzcvz == null) {
            return zzefo.zzb(new zzcyz("Unable to instantiate mediation adapter class."));
        }
        zzbcb zzbcb = new zzbcb();
        zzcvz.zzc.zza(new zzdaw(this, zzcvz, zzbcb));
        if (zzdqo.zzH) {
            Bundle bundle = zzdra.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzdve zzdve = this.zzc;
        return zzdup.zzd(new zzdau(this, zzdra, zzdqo, zzcvz), this.zzd, zzduy.ADAPTER_LOAD_AD_SYN, zzdve).zzj(zzduy.ADAPTER_LOAD_AD_ACK).zze(zzbcb).zzj(zzduy.ADAPTER_WRAP_ADAPTER).zzb(new zzdav(this, zzdra, zzdqo, zzcvz)).zzi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz, Void voidR) throws Exception {
        return this.zzb.zzb(zzdra, zzdqo, zzcvz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws Exception {
        this.zzb.zza(zzdra, zzdqo, zzcvz);
    }
}
