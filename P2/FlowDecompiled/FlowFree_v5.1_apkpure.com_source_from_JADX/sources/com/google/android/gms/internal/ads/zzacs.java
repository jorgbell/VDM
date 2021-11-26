package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzacs {
    final zzzz zza;
    private final zzapy zzb;
    private final zzyw zzc;
    /* access modifiers changed from: private */
    public final VideoController zze;
    private zzyi zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzaau zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    private static zzyx zzB(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzyx.zze();
            }
        }
        zzyx zzyx = new zzyx(context, adSizeArr);
        zzyx.zzj = zzC(i);
        return zzyx;
    }

    private static boolean zzC(int i) {
        return i == 1;
    }

    public final void zza() {
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzc();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final AdListener zzb() {
        return this.zzg;
    }

    public final AdSize zzc() {
        zzyx zzn2;
        try {
            zzaau zzaau = this.zzj;
            if (!(zzaau == null || (zzn2 = zzaau.zzn()) == null)) {
                return zza.zza(zzn2.zze, zzn2.zzb, zzn2.zza);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] zzd() {
        return this.zzh;
    }

    public final String zze() {
        zzaau zzaau;
        if (this.zzl == null && (zzaau = this.zzj) != null) {
            try {
                this.zzl = zzaau.zzu();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final AppEventListener zzf() {
        return this.zzi;
    }

    public final void zzg(zzacq zzacq) {
        zzaau zzaau;
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzyx zzB = zzB(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzB.zza)) {
                    zzaau = (zzaau) new zzzp(zzzy.zzb(), context, zzB, this.zzl).zzd(context, false);
                } else {
                    zzaau = (zzaau) new zzzn(zzzy.zzb(), context, zzB, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzaau;
                zzaau.zzh(new zzyo(this.zza));
                zzyi zzyi = this.zzf;
                if (zzyi != null) {
                    this.zzj.zzy(new zzyj(zzyi));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzi(new zzrw(appEventListener));
                }
                VideoOptions videoOptions = this.zzk;
                if (videoOptions != null) {
                    this.zzj.zzF(new zzady(videoOptions));
                }
                this.zzj.zzO(new zzadr(this.zzp));
                this.zzj.zzz(this.zzo);
                zzaau zzaau2 = this.zzj;
                if (zzaau2 != null) {
                    try {
                        IObjectWrapper zzb2 = zzaau2.zzb();
                        if (zzb2 != null) {
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzb2));
                        }
                    } catch (RemoteException e) {
                        zzbbk.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzaau zzaau3 = this.zzj;
            Objects.requireNonNull(zzaau3);
            if (zzaau3.zze(this.zzc.zza(this.zzm.getContext(), zzacq))) {
                this.zzb.zze(zzacq.zzn());
            }
        } catch (RemoteException e2) {
            zzbbk.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzh() {
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzf();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzj() {
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzg();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzk(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzl(zzyi zzyi) {
        try {
            this.zzf = zzyi;
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzy(zzyi != null ? new zzyj(zzyi) : null);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzn(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzo(zzB(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzo(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzp(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzi(appEventListener != null ? new zzrw(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(boolean z) {
        this.zzo = z;
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzz(z);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final ResponseInfo zzs() {
        zzacg zzacg = null;
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzacg = zzaau.zzt();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzacg);
    }

    public final void zzt(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzO(new zzadr(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", e);
        }
    }

    public final OnPaidEventListener zzu() {
        return this.zzp;
    }

    public final VideoController zzv() {
        return this.zze;
    }

    public final zzacj zzw() {
        zzaau zzaau = this.zzj;
        if (zzaau != null) {
            try {
                return zzaau.zzE();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final void zzx(VideoOptions videoOptions) {
        this.zzk = videoOptions;
        try {
            zzaau zzaau = this.zzj;
            if (zzaau != null) {
                zzaau.zzF(videoOptions == null ? null : new zzady(videoOptions));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions zzy() {
        return this.zzk;
    }

    public zzacs(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzyw.zza, (zzaau) null, i);
    }

    public final void zzm(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzn(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public zzacs(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzyw.zza, (zzaau) null, 0);
    }

    public zzacs(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzyw.zza, (zzaau) null, i);
    }

    zzacs(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyw zzyw, zzaau zzaau, int i) {
        zzyx zzyx;
        this.zzb = new zzapy();
        this.zze = new VideoController();
        this.zza = new zzacr(this);
        this.zzm = viewGroup;
        this.zzc = zzyw;
        this.zzj = null;
        new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzzf zzzf = new zzzf(context, attributeSet);
                this.zzh = zzzf.zza(z);
                this.zzl = zzzf.zzb();
                if (viewGroup.isInEditMode()) {
                    zzbbd zza2 = zzzy.zza();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzyx = zzyx.zze();
                    } else {
                        zzyx zzyx2 = new zzyx(context, adSize);
                        zzyx2.zzj = zzC(i2);
                        zzyx = zzyx2;
                    }
                    zza2.zzc(viewGroup, zzyx, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzzy.zza().zzb(viewGroup, new zzyx(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
