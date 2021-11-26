package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfw {
    private final zzg zza;
    private final zzdrg zzb;
    private final zzcfc zzc;
    private final zzcex zzd;
    private final zzcgh zze;
    private final zzcgp zzf;
    private final Executor zzg;
    private final Executor zzh;
    private final zzagy zzi;
    private final zzceu zzj;

    public zzcfw(zzg zzg2, zzdrg zzdrg, zzcfc zzcfc, zzcex zzcex, zzcgh zzcgh, zzcgp zzcgp, Executor executor, Executor executor2, zzceu zzceu) {
        this.zza = zzg2;
        this.zzb = zzdrg;
        this.zzi = zzdrg.zzi;
        this.zzc = zzcfc;
        this.zzd = zzcex;
        this.zze = zzcgh;
        this.zzf = zzcgp;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzceu;
    }

    public final void zza(zzcgr zzcgr) {
        this.zzg.execute(new zzcft(this, zzcgr));
    }

    public final void zzb(zzcgr zzcgr) {
        if (zzcgr != null && this.zze != null && zzcgr.zzbu() != null && this.zzc.zzb()) {
            try {
                zzcgr.zzbu().addView(this.zze.zza());
            } catch (zzbgq e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzc(zzcgr zzcgr) {
        if (zzcgr != null) {
            Context context = zzcgr.zzby().getContext();
            if (zzbn.zzi(context, this.zzc.zza)) {
                if (!(context instanceof Activity)) {
                    zzbbk.zzd("Activity context is needed for policy validator.");
                } else if (this.zzf != null && zzcgr.zzbu() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzf.zza(zzcgr.zzbu(), windowManager), zzbn.zzj());
                    } catch (zzbgq e) {
                        zze.zzb("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    public final boolean zzd(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzF = this.zzd.zzF();
        if (zzF == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzF.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzF.getParent()).removeView(zzF);
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzce)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzF, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcgr zzcgr) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzahh zza2;
        Drawable drawable;
        int i = 0;
        IObjectWrapper iObjectWrapper = null;
        if (this.zzc.zze() || this.zzc.zzc()) {
            String[] strArr = {"1098", "3011"};
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                View zzm = zzcgr.zzm(strArr[i2]);
                if (zzm != null && (zzm instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzm;
                    break;
                }
                i2++;
            }
        }
        viewGroup = null;
        Context context = zzcgr.zzby().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzd.zzw() != null) {
            view = this.zzd.zzw();
            zzagy zzagy = this.zzi;
            if (zzagy != null && viewGroup == null) {
                zzg(layoutParams, zzagy.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.zzd.zzv() instanceof zzagr)) {
            view = null;
        } else {
            zzagr zzagr = (zzagr) this.zzd.zzv();
            if (viewGroup == null) {
                zzg(layoutParams, zzagr.zzi());
            }
            zzags zzags = new zzags(context, zzagr, layoutParams);
            zzags.setContentDescription((CharSequence) zzaaa.zzc().zzb(zzaeq.zzcc));
            view = zzags;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzcgr.zzby().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzbu = zzcgr.zzbu();
                if (zzbu != null) {
                    zzbu.addView(zza3);
                }
            }
            zzcgr.zzi(zzcgr.zzn(), view, true);
        }
        zzede<String> zzede = zzcfs.zza;
        int size = zzede.size();
        while (true) {
            if (i >= size) {
                viewGroup2 = null;
                break;
            }
            View zzm2 = zzcgr.zzm(zzede.get(i));
            i++;
            if (zzm2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzm2;
                break;
            }
        }
        this.zzh.execute(new zzcfu(this, viewGroup2));
        if (viewGroup2 != null) {
            if (!zzd(viewGroup2)) {
                viewGroup2.removeAllViews();
                View zzby = zzcgr.zzby();
                Context context2 = zzby != null ? zzby.getContext() : null;
                if (context2 != null && (zza2 = this.zzj.zza()) != null) {
                    try {
                        IObjectWrapper zzg2 = zza2.zzg();
                        if (zzg2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzg2)) != null) {
                            ImageView imageView = new ImageView(context2);
                            imageView.setImageDrawable(drawable);
                            if (zzcgr != null) {
                                iObjectWrapper = zzcgr.zzo();
                            }
                            if (iObjectWrapper != null) {
                                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzen)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapper));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zzbbk.zzi("Could not get main image drawable");
                    }
                }
            } else if (this.zzd.zzO() != null) {
                this.zzd.zzO().zzap(new zzcfv(this, zzcgr, viewGroup2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzd.zzF() == null) {
            return;
        }
        if (this.zzd.zzt() == 2 || this.zzd.zzt() == 1) {
            this.zza.zzv(this.zzb.zzf, String.valueOf(this.zzd.zzt()), z);
        } else if (this.zzd.zzt() == 6) {
            this.zza.zzv(this.zzb.zzf, "2", z);
            this.zza.zzv(this.zzb.zzf, "1", z);
        }
    }

    private static void zzg(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
