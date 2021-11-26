package com.google.android.gms.internal.ads;

import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeey<V, C> extends zzeeo<V, C> {
    private List<zzeex<V>> zza;

    zzeey(zzedb<? extends zzefw<? extends V>> zzedb, boolean z) {
        super(zzedb, true, true);
        List<zzeex<V>> list;
        if (zzedb.isEmpty()) {
            list = zzede.zzi();
        } else {
            list = zzedm.zza(zzedb.size());
        }
        for (int i = 0; i < zzedb.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    /* access modifiers changed from: package-private */
    public final void zzB(int i) {
        super.zzB(i);
        this.zza = null;
    }

    /* access modifiers changed from: package-private */
    public abstract C zzI(List<zzeex<V>> list);

    /* access modifiers changed from: package-private */
    public final void zzw(int i, @NullableDecl V v) {
        List<zzeex<V>> list = this.zza;
        if (list != null) {
            list.set(i, new zzeex(v));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzx() {
        List<zzeex<V>> list = this.zza;
        if (list != null) {
            zzh(zzI(list));
        }
    }
}
