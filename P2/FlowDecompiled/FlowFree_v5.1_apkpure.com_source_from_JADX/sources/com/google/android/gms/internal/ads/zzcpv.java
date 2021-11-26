package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcpv {
    private final zzcpj zza;
    private final zzcld zzb;
    private final Object zzc = new Object();
    private final List<zzcpu> zzd;
    private boolean zze;

    zzcpv(zzcpj zzcpj, zzcld zzcld) {
        this.zza = zzcpj;
        this.zzb = zzcld;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List<zzamj> list) {
        String zzasv;
        synchronized (this.zzc) {
            if (!this.zze) {
                for (zzamj next : list) {
                    List<zzcpu> list2 = this.zzd;
                    String str = next.zza;
                    zzclc zzc2 = this.zzb.zzc(str);
                    if (zzc2 == null) {
                        zzasv = "";
                    } else {
                        zzasv zzasv2 = zzc2.zzb;
                        if (zzasv2 == null) {
                            zzasv = "";
                        } else {
                            zzasv = zzasv2.toString();
                        }
                    }
                    String str2 = zzasv;
                    boolean z = next.zzb;
                    list2.add(new zzcpu(str, str2, z ? 1 : 0, next.zzd, next.zzc));
                }
                this.zze = true;
            }
        }
    }

    public final void zza() {
        this.zza.zzb(new zzcpt(this));
    }

    public final JSONArray zzb() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zze()) {
                    zzd(this.zza.zzd());
                } else {
                    zza();
                    return jSONArray;
                }
            }
            for (zzcpu zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
            return jSONArray;
        }
    }
}
