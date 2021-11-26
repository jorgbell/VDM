package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddz implements zzdiz<zzdea> {
    private final zzefx zza;
    private final Context zzb;
    private final zzdrg zzc;
    private final View zzd;

    public zzddz(zzefx zzefx, Context context, zzdrg zzdrg, ViewGroup viewGroup) {
        this.zza = zzefx;
        this.zzb = context;
        this.zzc = zzdrg;
        this.zzd = viewGroup;
    }

    public final zzefw<zzdea> zza() {
        return this.zza.zzb(new zzddy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdea zzb() throws Exception {
        Context context = this.zzb;
        zzyx zzyx = this.zzc.zze;
        ArrayList arrayList = new ArrayList();
        View view = this.zzd;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzdea(context, zzyx, arrayList);
    }
}
