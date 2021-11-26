package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdoh {
    public static zzdof<zzbnp, zzbnv> zza(Context context, zzdsn zzdsn, zzdtf zzdtf) {
        return zzc(context, zzdsn, zzdtf);
    }

    public static zzdof<zzboa, zzbof> zzb(Context context, zzdsn zzdsn, zzdtf zzdtf) {
        return zzc(context, zzdsn, zzdtf);
    }

    private static <AppOpenAdRequestComponent extends zzbto<AppOpenAd>, AppOpenAd extends zzbql> zzdof<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdsn zzdsn, zzdtf zzdtf) {
        if (((Integer) zzaaa.zzc().zzb(zzaeq.zzeJ)).intValue() <= 0) {
            return new zzdnv();
        }
        zzdte zza = zzdtf.zza(zzdsv.AppOpen, context, zzdsn, new zzdnk(new zzdng()));
        zzdnw zzdnw = new zzdnw(new zzdnv());
        zzdsr zzdsr = zza.zza;
        zzefx zzefx = zzbbw.zza;
        return new zzdnm(zzdnw, new zzdns(zzdsr, zzefx), zza.zzb, zzefx);
    }
}
