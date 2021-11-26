package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdgr implements zzdiz<zzdgs> {
    private final zzefx zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set<String> zzd;

    public zzdgr(zzefx zzefx, ViewGroup viewGroup, Context context, Set<String> set) {
        this.zza = zzefx;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final zzefw<zzdgs> zza() {
        return this.zza.zzb(new zzdgq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgs zzb() throws Exception {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdZ)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzdgs(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean bool = null;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzea)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolean z = false;
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    bool = Boolean.TRUE;
                }
                return new zzdgs(bool);
            }
        }
        return new zzdgs((Boolean) null);
    }
}
