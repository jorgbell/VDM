package com.google.android.gms.internal.ads;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajr implements zzakp<Object> {
    private final zzajs zza;

    public zzajr(zzajs zzajs) {
        this.zza = zzajs;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(MediationMetaData.KEY_NAME);
        if (str == null) {
            zzbbk.zzi("App event with no name parameter.");
        } else {
            this.zza.zzbB(str, map.get("info"));
        }
    }
}
