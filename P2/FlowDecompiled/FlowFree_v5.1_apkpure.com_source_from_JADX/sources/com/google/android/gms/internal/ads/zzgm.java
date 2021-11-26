package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgm extends zzhm {
    private final Activity zzi;
    private final View zzj;

    public zzgm(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, View view, Activity activity) {
        super(zzge, "d7iz/RaEjr4+F5KeSshTAEj7Q3zrU63hP4JJ9g4PP8N7gmW+Iw0VuVNSijbICL3k", "qWEJpfGQyAWr4gtX2zyFUAILvlzTpMpm09EeOcWOxm8=", zzcn, i, 62);
        this.zzj = view;
        this.zzi = activity;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzj != null) {
            boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbC)).booleanValue();
            Object[] objArr = (Object[]) this.zzf.invoke((Object) null, new Object[]{this.zzj, this.zzi, Boolean.valueOf(booleanValue)});
            synchronized (this.zze) {
                this.zze.zzS(((Long) objArr[0]).longValue());
                this.zze.zzT(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zze.zzU((String) objArr[2]);
                }
            }
        }
    }
}
