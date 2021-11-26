package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaae;
import com.google.android.gms.internal.ads.zzaah;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzaay;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzabi;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzacg;
import com.google.android.gms.internal.ads.zzacj;
import com.google.android.gms.internal.ads.zzacn;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzafl;
import com.google.android.gms.internal.ads.zzafu;
import com.google.android.gms.internal.ads.zzaus;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfh;
import com.google.android.gms.internal.ads.zzfi;
import com.google.android.gms.internal.ads.zzte;
import com.google.android.gms.internal.ads.zzys;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzy;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzr extends zzaat {
    /* access modifiers changed from: private */
    public final zzbbq zza;
    private final zzyx zzb;
    /* access modifiers changed from: private */
    public final Future<zzfh> zzc = zzbbw.zza.zzb(new zzo(this));
    /* access modifiers changed from: private */
    public final Context zzd;
    private final zzq zze;
    /* access modifiers changed from: private */
    public WebView zzf;
    /* access modifiers changed from: private */
    public zzaah zzg;
    /* access modifiers changed from: private */
    public zzfh zzh;
    private AsyncTask<Void, Void, String> zzi;

    public zzr(Context context, zzyx zzyx, String str, zzbbq zzbbq) {
        this.zzd = context;
        this.zza = zzbbq;
        this.zzb = zzyx;
        this.zzf = new WebView(context);
        this.zze = new zzq(context, str);
        zzL(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzm(this));
        this.zzf.setOnTouchListener(new zzn(this));
    }

    static /* synthetic */ String zzT(zzr zzr, String str) {
        if (zzr.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzr.zzh.zze(parse, zzr.zzd, (View) null, (Activity) null);
        } catch (zzfi e) {
            zzbbk.zzj("Unable to process ad data", e);
        }
        return parse.toString();
    }

    static /* synthetic */ void zzU(zzr zzr, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzr.zzd.startActivity(intent);
    }

    public final boolean zzA() throws RemoteException {
        return false;
    }

    public final void zzB(zzawy zzawy) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzC(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final zzacj zzE() {
        return null;
    }

    public final void zzF(zzady zzady) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzG(zzacn zzacn) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzzd zzzd) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzte zzte) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzK(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                zzzy.zza();
                return zzbbd.zzs(this.zzd, Integer.parseInt(queryParameter));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzL(int i) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzM() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzafu.zzd.zze());
        builder.appendQueryParameter(AppLovinEventParameters.SEARCH_QUERY, this.zze.zzb());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        Map<String, String> zzd2 = this.zze.zzd();
        for (String next : zzd2.keySet()) {
            builder.appendQueryParameter(next, zzd2.get(next));
        }
        Uri build = builder.build();
        zzfh zzfh = this.zzh;
        if (zzfh != null) {
            try {
                build = zzfh.zzc(build, this.zzd);
            } catch (zzfi e) {
                zzbbk.zzj("Unable to process ad data", e);
            }
        }
        String zzN = zzN();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzN).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzN);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzN() {
        String zza2 = this.zze.zza();
        if (true == TextUtils.isEmpty(zza2)) {
            zza2 = "www.google.com";
        }
        String zze2 = zzafu.zzd.zze();
        StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 8 + String.valueOf(zze2).length());
        sb.append("https://");
        sb.append(zza2);
        sb.append(zze2);
        return sb.toString();
    }

    public final void zzO(zzacd zzacd) {
    }

    public final void zzP(zzys zzys, zzaak zzaak) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzabi zzabi) {
    }

    public final void zzab(zzabf zzabf) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    public final boolean zzbI() throws RemoteException {
        return false;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(true);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final boolean zze(zzys zzys) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zze(zzys, this.zza);
        this.zzi = new zzp(this, (zzm) null).execute(new Void[0]);
        return true;
    }

    public final void zzf() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void zzg() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzh(zzaah zzaah) throws RemoteException {
        this.zzg = zzaah;
    }

    public final void zzi(zzabb zzabb) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzj(zzaay zzaay) {
        throw new IllegalStateException("Unused method");
    }

    public final Bundle zzk() {
        throw new IllegalStateException("Unused method");
    }

    public final void zzl() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzm() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzyx zzn() throws RemoteException {
        return this.zzb;
    }

    public final void zzo(zzyx zzyx) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzp(zzaus zzaus) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzq(zzauv zzauv, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final String zzr() throws RemoteException {
        return null;
    }

    public final String zzs() throws RemoteException {
        return null;
    }

    public final zzacg zzt() {
        return null;
    }

    public final String zzu() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzabb zzv() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzaah zzw() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void zzx(zzafl zzafl) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzy(zzaae zzaae) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzz(boolean z) throws RemoteException {
    }
}
