package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzdyi extends AsyncTask<Object, Void, String> {
    private zzdyj zza;
    protected final zzdya zzd;

    public zzdyi(zzdya zzdya, byte[] bArr) {
        this.zzd = zzdya;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzdyj zzdyj = this.zza;
        if (zzdyj != null) {
            zzdyj.zzb(this);
        }
    }

    public final void zzb(zzdyj zzdyj) {
        this.zza = zzdyj;
    }
}
