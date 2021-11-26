package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeba {
    boolean zza;
    zzebb zzb;

    public zzeba(Context context, String str, String str2) {
        zzebb zzebb;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.ads.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzebb = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IClearcut");
                if (queryLocalInterface instanceof zzebb) {
                    zzebb = (zzebb) queryLocalInterface;
                } else {
                    zzebb = new zzebb(instantiate);
                }
            }
            try {
                this.zzb = zzebb;
                this.zzb.zzj(ObjectWrapper.wrap(context), str, (String) null);
                this.zza = true;
            } catch (RemoteException | zzeac | NullPointerException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
            }
        } catch (Exception e) {
            throw new zzeac(e);
        } catch (Exception e2) {
            throw new zzeac(e2);
        }
    }

    public final zzeaz zza(byte[] bArr) {
        return new zzeaz(this, bArr, (zzeay) null);
    }
}
