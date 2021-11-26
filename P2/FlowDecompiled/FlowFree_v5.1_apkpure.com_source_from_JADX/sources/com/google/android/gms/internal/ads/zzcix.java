package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcix extends zzahz {
    private final Context zza;
    private final zzcex zzb;
    private zzcfw zzc;
    /* access modifiers changed from: private */
    public zzces zzd;

    public zzcix(Context context, zzcex zzcex, zzcfw zzcfw, zzces zzces) {
        this.zza = context;
        this.zzb = zzcex;
        this.zzc = zzcfw;
        this.zzd = zzces;
    }

    public final String zze(String str) {
        return this.zzb.zzU().get(str);
    }

    public final zzahk zzf(String str) {
        return this.zzb.zzR().get(str);
    }

    public final List<String> zzg() {
        SimpleArrayMap<String, zzagu> zzR = this.zzb.zzR();
        SimpleArrayMap<String, String> zzU = this.zzb.zzU();
        String[] strArr = new String[(zzR.size() + zzU.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzR.size()) {
            strArr[i3] = zzR.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzU.size()) {
            strArr[i3] = zzU.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String zzh() {
        return this.zzb.zzN();
    }

    public final void zzi(String str) {
        zzces zzces = this.zzd;
        if (zzces != null) {
            zzces.zza(str);
        }
    }

    public final void zzj() {
        zzces zzces = this.zzd;
        if (zzces != null) {
            zzces.zzb();
        }
    }

    public final zzacj zzk() {
        return this.zzb.zzu();
    }

    public final void zzl() {
        zzces zzces = this.zzd;
        if (zzces != null) {
            zzces.zzR();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final IObjectWrapper zzm() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final boolean zzn(IObjectWrapper iObjectWrapper) {
        zzcfw zzcfw;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzcfw = this.zzc) == null || !zzcfw.zzd((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzO().zzap(new zzciw(this));
        return true;
    }

    public final boolean zzo() {
        zzces zzces = this.zzd;
        if ((zzces == null || zzces.zzC()) && this.zzb.zzP() != null && this.zzb.zzO() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzp() {
        IObjectWrapper zzQ = this.zzb.zzQ();
        if (zzQ != null) {
            zzs.zzr().zzh(zzQ);
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdo)).booleanValue() || this.zzb.zzP() == null) {
                return true;
            }
            this.zzb.zzP().zze("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzbbk.zzi("Trying to start OMID session before creation.");
        return false;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzces zzces;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzQ() != null && (zzces = this.zzd) != null) {
            zzces.zzD((View) unwrap);
        }
    }

    public final void zzr() {
        String zzT = this.zzb.zzT();
        if ("Google".equals(zzT)) {
            zzbbk.zzi("Illegal argument specified for omid partner name.");
            return;
        }
        zzces zzces = this.zzd;
        if (zzces != null) {
            zzces.zzB(zzT, false);
        }
    }
}
