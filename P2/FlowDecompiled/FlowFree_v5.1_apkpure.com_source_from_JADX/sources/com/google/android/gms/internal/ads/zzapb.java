package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzapb {
    public static final zzaoy<JSONObject> zza = new zzapa();
    public static final zzaow<InputStream> zzb = zzaoz.zza;
    private static final Charset zzc = Charset.forName("UTF-8");

    static final /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
