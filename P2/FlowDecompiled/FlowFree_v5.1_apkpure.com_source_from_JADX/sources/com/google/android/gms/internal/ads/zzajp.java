package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajp implements zzakp<Object> {
    private final zzajq zza;

    public zzajp(zzajq zzajq) {
        this.zza = zzajq;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zza != null) {
            String str = map.get(MediationMetaData.KEY_NAME);
            if (str == null) {
                zzbbk.zzh("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbk.zzj(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzbbk.zzg("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzbbk.zzf("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
