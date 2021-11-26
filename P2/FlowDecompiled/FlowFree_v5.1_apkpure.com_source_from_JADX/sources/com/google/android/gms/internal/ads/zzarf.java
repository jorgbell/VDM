package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzarf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzaqd {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zza;
    private final NETWORK_EXTRAS zzb;

    public zzarf(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zza = mediationAdapter;
        this.zzb = network_extras;
    }

    private final SERVER_PARAMETERS zzb(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzbbk.zzg("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zza.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    private static final boolean zzc(zzys zzys) {
        if (zzys.zzf) {
            return true;
        }
        zzzy.zza();
        return zzbbd.zzm();
    }

    public final void zzA(boolean z) {
    }

    public final zzacj zzB() {
        return null;
    }

    public final zzaqq zzC() {
        return null;
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzamn zzamn, List<zzamt> list) throws RemoteException {
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
    }

    public final zzasv zzH() {
        return null;
    }

    public final zzasv zzI() {
        return null;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzyx zzyx, zzys zzys, String str, String str2, zzaqh zzaqh) {
    }

    public final zzaqk zzK() {
        return null;
    }

    public final void zzL(IObjectWrapper iObjectWrapper) {
    }

    public final zzaqm zzM() {
        return null;
    }

    public final zzaqn zzN() {
        return null;
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzyx zzyx, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
        zzj(iObjectWrapper, zzyx, zzys, str, (String) null, zzaqh);
    }

    public final IObjectWrapper zzf() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbk.zzi(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbbk.zzg("", th);
            throw new RemoteException();
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
        zzk(iObjectWrapper, zzys, str, (String) null, zzaqh);
    }

    public final void zzh() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbk.zzi(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbk.zzd("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).showInterstitial();
        } catch (Throwable th) {
            zzbbk.zzg("", th);
            throw new RemoteException();
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzyx zzyx, zzys zzys, String str, String str2, zzaqh zzaqh) throws RemoteException {
        AdSize adSize;
        String str3;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str3 = "Not a MediationBannerAdapter: ".concat(valueOf);
            } else {
                str3 = new String("Not a MediationBannerAdapter: ");
            }
            zzbbk.zzi(str3);
            throw new RemoteException();
        }
        zzbbk.zzd("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zza;
            zzarr zzarr = new zzarr(zzaqh);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzb2 = zzb(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzyx.zze && adSizeArr[i].getHeight() == zzyx.zzb) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zza.zza(zzyx.zze, zzyx.zzb, zzyx.zza));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzarr, activity, zzb2, adSize, zzars.zzb(zzys, zzc(zzys)), this.zzb);
        } catch (Throwable th) {
            zzbbk.zzg("", th);
            throw new RemoteException();
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzys zzys, String str, String str2, zzaqh zzaqh) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbk.zzi(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbk.zzd("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).requestInterstitialAd(new zzarr(zzaqh), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzb(str), zzars.zzb(zzys, zzc(zzys)), this.zzb);
        } catch (Throwable th) {
            zzbbk.zzg("", th);
            throw new RemoteException();
        }
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaxd zzaxd, String str2) throws RemoteException {
    }

    public final void zzo(zzys zzys, String str) {
    }

    public final void zzp() {
    }

    public final boolean zzq() {
        return true;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzys zzys, String str, String str2, zzaqh zzaqh, zzagy zzagy, List<String> list) {
    }

    public final Bundle zzs() {
        return new Bundle();
    }

    public final Bundle zzt() {
        return new Bundle();
    }

    public final Bundle zzu() {
        return new Bundle();
    }

    public final void zzv(zzys zzys, String str, String str2) {
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final boolean zzx() {
        return false;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzaxd zzaxd, List<String> list) {
    }

    public final zzaia zzz() {
        return null;
    }

    public final void zzi() throws RemoteException {
        try {
            this.zza.destroy();
        } catch (Throwable th) {
            zzbbk.zzg("", th);
            throw new RemoteException();
        }
    }
}
