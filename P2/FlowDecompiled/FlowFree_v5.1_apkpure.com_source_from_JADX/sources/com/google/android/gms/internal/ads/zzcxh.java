package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxh implements zzcwe<zzbom, zzasi, zzcxs> {
    private final Context zza;
    private final zzbpj zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzaqk zzd;

    public zzcxh(Context context, zzbpj zzbpj) {
        this.zza = context;
        this.zzb = zzbpj;
    }

    public final void zza(zzdra zzdra, zzdqo zzdqo, zzcvz<zzasi, zzcxs> zzcvz) throws zzdrl {
        try {
            ((zzasi) zzcvz.zzb).zzo(zzdqo.zzT);
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() || !zzdqo.zzab) {
                ((zzasi) zzcvz.zzb).zzi(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzcxg(this, zzcvz, (zzcxf) null), (zzaqh) zzcvz.zzc, zzdra.zza.zza.zze);
            } else {
                ((zzasi) zzcvz.zzb).zzq(zzdqo.zzO, zzdqo.zzu.toString(), zzdra.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzcxg(this, zzcvz, (zzcxf) null), (zzaqh) zzcvz.zzc, zzdra.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzdrl(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) throws zzdrl, zzczn {
        View view;
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() || !zzdqo.zzab) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzdrl(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzefo.zzh(zzefo.zza(null), new zzcxe(this, view, zzdqo), zzbbw.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzdrl(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzdrl(e2);
            }
        }
        zzbon zzd2 = this.zzb.zzd(new zzbra(zzdra, zzdqo, zzcvz.zza), new zzbot(view, (zzbgf) null, new zzcxd(zzcvz), zzdqo.zzt.get(0)));
        zzd2.zzj().zza(view);
        ((zzcxs) zzcvz.zzc).zzc(zzd2.zzg());
        return zzd2.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(View view, zzdqo zzdqo, Object obj) throws Exception {
        return zzefo.zza(zzbqa.zza(this.zza, view, zzdqo));
    }
}
