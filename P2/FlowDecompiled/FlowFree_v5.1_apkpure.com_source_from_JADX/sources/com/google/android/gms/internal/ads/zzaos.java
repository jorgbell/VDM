package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaos implements zzani, zzaor {
    private final zzaor zza;
    private final HashSet<AbstractMap.SimpleEntry<String, zzakp<? super zzaor>>> zzb = new HashSet<>();

    public zzaos(zzaor zzaor) {
        this.zza = zzaor;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final void zzb(String str, String str2) {
        zzanh.zzb(this, str, str2);
    }

    public final void zzc() {
        Iterator<AbstractMap.SimpleEntry<String, zzakp<? super zzaor>>> it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzakp) next.getValue()).toString());
            zze.zza(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zza.zzm((String) next.getKey(), (zzakp) next.getValue());
        }
        this.zzb.clear();
    }

    public final void zzd(String str, JSONObject jSONObject) {
        zzanh.zzc(this, str, jSONObject);
    }

    public final void zze(String str, Map map) {
        zzanh.zzd(this, str, map);
    }

    public final void zzl(String str, zzakp<? super zzaor> zzakp) {
        this.zza.zzl(str, zzakp);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzakp));
    }

    public final void zzm(String str, zzakp<? super zzaor> zzakp) {
        this.zza.zzm(str, zzakp);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzakp));
    }

    public final void zzr(String str, JSONObject jSONObject) {
        zzanh.zza(this, str, jSONObject);
    }
}
