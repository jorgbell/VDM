package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzfg extends zzff {
    protected zzfg(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzfg zzv(String str, Context context, boolean z, int i) {
        zzff.zzm(context, z);
        zzff.zzt(str, context, z, i);
        return new zzfg(context, str, z, i);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zzp(zzge zzge, Context context, zzcn zzcn, zzce zzce) {
        if (zzge.zzd() == null || !this.zzt) {
            return super.zzp(zzge, context, zzcn, (zzce) null);
        }
        int zzs = zzge.zzs();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzge, context, zzcn, (zzce) null));
        arrayList.add(new zzgt(zzge, "HDBr8nc5ubdBn1y5M6IpuatOFh1+XK9blifaQQrU1HNvfw3hhdVJEUnkWE7sod57", "A6vbZ9nEwiHcLSfXI6B1ZE45FocqpxNzrogO6LWG5xM=", zzcn, zzs, 24));
        return arrayList;
    }
}
