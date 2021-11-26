package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxz {
    private final HashMap<View, String> zza = new HashMap<>();
    private final HashMap<View, zzdxy> zzb = new HashMap<>();
    private final HashMap<String, View> zzc = new HashMap<>();
    private final HashSet<View> zzd = new HashSet<>();
    private final HashSet<String> zze = new HashSet<>();
    private final HashSet<String> zzf = new HashSet<>();
    private final HashMap<String, String> zzg = new HashMap<>();
    private boolean zzh;

    public final HashSet<String> zza() {
        return this.zze;
    }

    public final HashSet<String> zzb() {
        return this.zzf;
    }

    public final String zzc(String str) {
        return this.zzg.get(str);
    }

    public final void zzd() {
        zzdxd zza2 = zzdxd.zza();
        if (zza2 != null) {
            for (zzdws next : zza2.zzf()) {
                View zzj = next.zzj();
                if (next.zzk()) {
                    String zzi = next.zzi();
                    if (zzj != null) {
                        String str = null;
                        if (!zzj.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = zzj;
                            while (true) {
                                if (view == null) {
                                    this.zzd.addAll(hashSet);
                                    break;
                                }
                                String zzb2 = zzdxx.zzb(view);
                                if (zzb2 != null) {
                                    str = zzb2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            this.zze.add(zzi);
                            this.zza.put(zzj, zzi);
                            for (zzdxg next2 : next.zzg()) {
                                View view2 = (View) next2.zza().get();
                                if (view2 != null) {
                                    zzdxy zzdxy = this.zzb.get(view2);
                                    if (zzdxy != null) {
                                        zzdxy.zza(next.zzi());
                                    } else {
                                        this.zzb.put(view2, new zzdxy(next2, next.zzi()));
                                    }
                                }
                            }
                        } else {
                            this.zzf.add(zzi);
                            this.zzc.put(zzi, zzj);
                            this.zzg.put(zzi, str);
                        }
                    } else {
                        this.zzf.add(zzi);
                        this.zzg.put(zzi, "noAdView");
                    }
                }
            }
        }
    }

    public final void zze() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzh = false;
    }

    public final void zzf() {
        this.zzh = true;
    }

    public final String zzg(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final View zzh(String str) {
        return this.zzc.get(str);
    }

    public final zzdxy zzi(View view) {
        zzdxy zzdxy = this.zzb.get(view);
        if (zzdxy != null) {
            this.zzb.remove(view);
        }
        return zzdxy;
    }

    public final int zzj(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzh ? 2 : 3;
    }
}
