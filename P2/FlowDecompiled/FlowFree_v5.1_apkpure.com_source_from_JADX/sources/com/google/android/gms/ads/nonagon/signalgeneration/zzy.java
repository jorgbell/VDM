package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzeev;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzy implements zzeev {
    private final zzawc zza;

    zzy(zzawc zzawc) {
        this.zza = zzawc;
    }

    public final zzefw zza(Object obj) {
        zzawc zzawc = this.zza;
        zzab zzab = new zzab(new JsonReader(new InputStreamReader((InputStream) obj)));
        try {
            zzab.zzb = zzs.zzc().zzh(zzawc.zza).toString();
        } catch (JSONException unused) {
            zzab.zzb = "{}";
        }
        return zzefo.zza(zzab);
    }
}
