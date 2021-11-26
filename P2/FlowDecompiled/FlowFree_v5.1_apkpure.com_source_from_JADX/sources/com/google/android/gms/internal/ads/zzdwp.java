package com.google.android.gms.internal.ads;

import com.mopub.mobileads.VastResourceXmlManager;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwp {
    private final zzdww zza;
    private final zzdww zzb;
    private final zzdwt zzc;
    private final zzdwv zzd;

    private zzdwp(zzdwt zzdwt, zzdwv zzdwv, zzdww zzdww, zzdww zzdww2, boolean z) {
        this.zzc = zzdwt;
        this.zzd = zzdwv;
        this.zza = zzdww;
        if (zzdww2 == null) {
            this.zzb = zzdww.NONE;
        } else {
            this.zzb = zzdww2;
        }
    }

    public static zzdwp zza(zzdwt zzdwt, zzdwv zzdwv, zzdww zzdww, zzdww zzdww2, boolean z) {
        zzdxw.zza(zzdwv, "ImpressionType is null");
        zzdxw.zza(zzdww, "Impression owner is null");
        zzdxw.zzc(zzdww, zzdwt, zzdwv);
        return new zzdwp(zzdwt, zzdwv, zzdww, zzdww2, true);
    }

    @Deprecated
    public static zzdwp zzb(zzdww zzdww, zzdww zzdww2, boolean z) {
        zzdxw.zza(zzdww, "Impression owner is null");
        zzdxw.zzc(zzdww, (zzdwt) null, (zzdwv) null);
        return new zzdwp((zzdwt) null, (zzdwv) null, zzdww, zzdww2, true);
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = new JSONObject();
        zzdxu.zzc(jSONObject, "impressionOwner", this.zza);
        if (this.zzc == null || this.zzd == null) {
            zzdxu.zzc(jSONObject, "videoEventsOwner", this.zzb);
        } else {
            zzdxu.zzc(jSONObject, "mediaEventsOwner", this.zzb);
            zzdxu.zzc(jSONObject, VastResourceXmlManager.CREATIVE_TYPE, this.zzc);
            zzdxu.zzc(jSONObject, "impressionType", this.zzd);
        }
        zzdxu.zzc(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
