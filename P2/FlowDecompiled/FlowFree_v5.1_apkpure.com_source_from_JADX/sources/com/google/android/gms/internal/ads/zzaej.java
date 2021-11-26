package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaej {
    private final Collection<zzaei<?>> zza = new ArrayList();
    private final Collection<zzaei<String>> zzb = new ArrayList();
    private final Collection<zzaei<String>> zzc = new ArrayList();

    public final void zza(zzaei zzaei) {
        this.zza.add(zzaei);
    }

    public final void zzb(zzaei<String> zzaei) {
        this.zzb.add(zzaei);
    }

    public final void zzc(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaei next : this.zza) {
            if (next.zzm() == 1) {
                next.zzb(editor, next.zzc(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbbk.zzf("Flag Json is null.");
        }
    }

    public final List<String> zzd() {
        ArrayList arrayList = new ArrayList();
        for (zzaei<String> zzb2 : this.zzb) {
            String str = (String) zzaaa.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzaer.zza());
        return arrayList;
    }

    public final List<String> zze() {
        List<String> zzd = zzd();
        for (zzaei<String> zzb2 : this.zzc) {
            String str = (String) zzaaa.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                zzd.add(str);
            }
        }
        zzd.addAll(zzaer.zzb());
        return zzd;
    }
}
