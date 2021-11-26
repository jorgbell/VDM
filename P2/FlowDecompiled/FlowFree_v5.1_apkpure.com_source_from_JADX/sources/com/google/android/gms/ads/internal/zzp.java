package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzfh;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzp extends AsyncTask<Void, Void, String> {
    final /* synthetic */ zzr zza;

    /* synthetic */ zzp(zzr zzr, zzm zzm) {
        this.zza = zzr;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zza.zzf != null && str != null) {
            this.zza.zzf.loadUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzr zzr = this.zza;
            zzfh unused = zzr.zzh = (zzfh) zzr.zzc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            zzbbk.zzj("", e);
        } catch (TimeoutException e2) {
            zzbbk.zzj("", e2);
        }
        return this.zza.zzM();
    }
}
