package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzauz extends zzbac {
    final /* synthetic */ QueryInfoGenerationCallback zza;

    zzauz(zzava zzava, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = queryInfoGenerationCallback;
    }

    public final void zzb(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzadb(str, (Bundle) null));
        zzzy.zzf().put(queryInfo, str2);
        this.zza.onSuccess(queryInfo);
    }

    public final void zzc(String str) {
        this.zza.onFailure(str);
    }

    public final void zzd(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzadb(str, bundle));
        zzzy.zzf().put(queryInfo, str2);
        this.zza.onSuccess(queryInfo);
    }
}
