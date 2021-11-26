package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhj extends zzhm {
    private final View zzi;

    public zzhj(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, View view) {
        super(zzge, "/nUAVD6E5149sZYPq78F0SxtCINb4d4P8HJ52kECSRArxECTN1q26bJ2wQ4rH1F5", "ToWTu5sR1jYEliR/iVXRogiAAmKJy3kOi4U3O1i9Y2M=", zzcn, i, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzaaa.zzc().zzb(zzaeq.zzbP);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzgi zzgi = new zzgi((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool}));
            zzda zza = zzdb.zza();
            zza.zza(zzgi.zza.longValue());
            zza.zzb(zzgi.zzb.longValue());
            zza.zzc(zzgi.zzc.longValue());
            if (bool.booleanValue()) {
                zza.zzd(zzgi.zzd.longValue());
            }
            this.zze.zzO((zzdb) zza.zzah());
        }
    }
}
