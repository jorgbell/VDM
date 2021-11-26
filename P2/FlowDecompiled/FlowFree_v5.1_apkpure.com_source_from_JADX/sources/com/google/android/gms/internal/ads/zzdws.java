package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdws extends zzdwo {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzdwq zzb;
    private final List<zzdxg> zzd = new ArrayList();
    private zzdyn zze;
    private zzdxq zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    zzdws(zzdwp zzdwp, zzdwq zzdwq) {
        this.zzb = zzdwq;
        this.zzi = UUID.randomUUID().toString();
        zzl((View) null);
        if (zzdwq.zzj() == zzdwr.HTML || zzdwq.zzj() == zzdwr.JAVASCRIPT) {
            this.zzf = new zzdxr(zzdwq.zzg());
        } else {
            this.zzf = new zzdxt(zzdwq.zzf(), (String) null);
        }
        this.zzf.zza();
        zzdxd.zza().zzb(this);
        zzdxj.zza().zzb(this.zzf.zzd(), zzdwp.zzc());
    }

    private final void zzl(View view) {
        this.zze = new zzdyn(view);
    }

    public final void zza() {
        if (!this.zzg) {
            this.zzg = true;
            zzdxd.zza().zzc(this);
            this.zzf.zzj(zzdxk.zza().zzf());
            this.zzf.zzh(this, this.zzb);
        }
    }

    public final void zzb(View view) {
        if (!this.zzh && zzj() != view) {
            zzl(view);
            this.zzf.zzk();
            Collection<zzdws> zze2 = zzdxd.zza().zze();
            if (zze2 != null && zze2.size() > 0) {
                for (zzdws next : zze2) {
                    if (next != this && next.zzj() == view) {
                        next.zze.clear();
                    }
                }
            }
        }
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            if (!this.zzh) {
                this.zzd.clear();
            }
            this.zzh = true;
            zzdxj.zza().zzd(this.zzf.zzd());
            zzdxd.zza().zzd(this);
            this.zzf.zzb();
            this.zzf = null;
        }
    }

    public final void zzd(View view, zzdwu zzdwu, String str) {
        zzdxg zzdxg;
        if (this.zzh) {
            return;
        }
        if (str == null || (str.length() <= 50 && zza.matcher(str).matches())) {
            Iterator<zzdxg> it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzdxg = null;
                    break;
                }
                zzdxg = it.next();
                if (zzdxg.zza().get() == view) {
                    break;
                }
            }
            if (zzdxg == null) {
                this.zzd.add(new zzdxg(view, zzdwu, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
    }

    @Deprecated
    public final void zze(View view) {
        zzd(view, zzdwu.OTHER, (String) null);
    }

    public final List<zzdxg> zzg() {
        return this.zzd;
    }

    public final zzdxq zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final View zzj() {
        return (View) this.zze.get();
    }

    public final boolean zzk() {
        return this.zzg && !this.zzh;
    }
}
