package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaaq;
import com.google.android.gms.internal.ads.zzaau;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzabl;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaho;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzaqb;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzbag;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzcfq;
import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzdcf;
import com.google.android.gms.internal.ads.zzdls;
import com.google.android.gms.internal.ads.zzdlt;
import com.google.android.gms.internal.ads.zzdnc;
import com.google.android.gms.internal.ads.zzdov;
import com.google.android.gms.internal.ads.zzdqh;
import com.google.android.gms.internal.ads.zzyx;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class ClientApi extends zzabd {
    public final zzaau zzb(IObjectWrapper iObjectWrapper, zzyx zzyx, String str, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdnc zzl = zzbid.zza(context, zzaqb, i).zzl();
        zzl.zzd(context);
        zzl.zzb(zzyx);
        zzl.zzc(str);
        return zzl.zza().zza();
    }

    public final zzaau zzc(IObjectWrapper iObjectWrapper, zzyx zzyx, String str, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdov zzq = zzbid.zza(context, zzaqb, i).zzq();
        zzq.zzd(context);
        zzq.zzb(zzyx);
        zzq.zzc(str);
        return zzq.zza().zza();
    }

    public final zzaaq zzd(IObjectWrapper iObjectWrapper, String str, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzdcf(zzbid.zza(context, zzaqb, i), context, str);
    }

    public final zzaho zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcfs((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 210890000);
    }

    public final zzawv zzf(IObjectWrapper iObjectWrapper, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdqh zzt = zzbid.zza(context, zzaqb, i).zzt();
        zzt.zzc(context);
        return zzt.zza().zza();
    }

    public final zzaul zzg(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzt(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzs(activity);
        }
        if (i == 2) {
            return new zzab(activity);
        }
        if (i == 3) {
            return new zzac(activity);
        }
        if (i != 4) {
            return i != 5 ? new zzt(activity) : new zzz(activity);
        }
        return new zzv(activity, zza);
    }

    public final zzabl zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzbid.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzj();
    }

    public final zzaau zzi(IObjectWrapper iObjectWrapper, zzyx zzyx, String str, int i) {
        return new zzr((Context) ObjectWrapper.unwrap(iObjectWrapper), zzyx, str, new zzbbq(210890000, i, true, false));
    }

    public final zzahs zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcfq((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaxl zzk(IObjectWrapper iObjectWrapper, String str, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdqh zzt = zzbid.zza(context, zzaqb, i).zzt();
        zzt.zzc(context);
        zzt.zzb(str);
        return zzt.zza().zzb();
    }

    public final zzaau zzl(IObjectWrapper iObjectWrapper, zzyx zzyx, String str, zzaqb zzaqb, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdls zzo = zzbid.zza(context, zzaqb, i).zzo();
        zzo.zzb(str);
        zzo.zzc(context);
        zzdlt zza = zzo.zza();
        if (i >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzdu)).intValue()) {
            return zza.zzb();
        }
        return zza.zza();
    }

    public final zzbag zzm(IObjectWrapper iObjectWrapper, zzaqb zzaqb, int i) {
        return zzbid.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaqb, i).zzv();
    }

    public final zzatz zzn(IObjectWrapper iObjectWrapper, zzaqb zzaqb, int i) {
        return zzbid.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaqb, i).zzw();
    }

    public final zzaln zzo(IObjectWrapper iObjectWrapper, zzaqb zzaqb, int i, zzalk zzalk) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzcop zzB = zzbid.zza(context, zzaqb, i).zzB();
        zzB.zzc(context);
        zzB.zzb(zzalk);
        return zzB.zza().zza();
    }
}
