package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzart extends zzaqp {
    private final UnifiedNativeAdMapper zza;

    public zzart(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zza = unifiedNativeAdMapper;
    }

    public final float zzA() {
        return this.zza.getDuration();
    }

    public final float zzB() {
        return this.zza.getCurrentTime();
    }

    public final String zze() {
        return this.zza.getHeadline();
    }

    public final List zzf() {
        List<NativeAd$Image> images = this.zza.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd$Image next : images) {
                arrayList.add(new zzagu(next.getDrawable(), next.getUri(), next.getScale(), next.zza(), next.zzb()));
            }
        }
        return arrayList;
    }

    public final String zzg() {
        return this.zza.getBody();
    }

    public final zzahk zzh() {
        NativeAd$Image icon = this.zza.getIcon();
        if (icon != null) {
            return new zzagu(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.zza(), icon.zzb());
        }
        return null;
    }

    public final String zzi() {
        return this.zza.getCallToAction();
    }

    public final String zzj() {
        return this.zza.getAdvertiser();
    }

    public final double zzk() {
        if (this.zza.getStarRating() != null) {
            return this.zza.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String zzl() {
        return this.zza.getStore();
    }

    public final String zzm() {
        return this.zza.getPrice();
    }

    public final zzacj zzn() {
        if (this.zza.zzc() != null) {
            return this.zza.zzc().zzb();
        }
        return null;
    }

    public final zzahc zzo() {
        return null;
    }

    public final IObjectWrapper zzp() {
        View adChoicesContent = this.zza.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzq() {
        View zzd = this.zza.zzd();
        if (zzd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzd);
    }

    public final IObjectWrapper zzr() {
        Object zze = this.zza.zze();
        if (zze == null) {
            return null;
        }
        return ObjectWrapper.wrap(zze);
    }

    public final Bundle zzs() {
        return this.zza.getExtras();
    }

    public final boolean zzt() {
        return this.zza.getOverrideImpressionRecording();
    }

    public final boolean zzu() {
        return this.zza.getOverrideClickHandling();
    }

    public final void zzv() {
        this.zza.recordImpression();
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zza.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        this.zza.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final float zzz() {
        return this.zza.getMediaContentAspectRatio();
    }
}
