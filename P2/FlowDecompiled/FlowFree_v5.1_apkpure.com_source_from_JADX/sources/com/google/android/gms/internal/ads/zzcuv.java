package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcuv {
    private static final SparseArray<zzwx> zzh;
    private final Context zza;
    private final zzbtl zzb;
    private final TelephonyManager zzc;
    private final zzcuo zzd;
    /* access modifiers changed from: private */
    public final zzcuk zze;
    /* access modifiers changed from: private */
    public final zzg zzf;
    private zzvy zzg;

    static {
        SparseArray<zzwx> sparseArray = new SparseArray<>();
        zzh = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwx.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzwx zzwx = zzwx.CONNECTING;
        sparseArray.put(ordinal, zzwx);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzwx);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzwx);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwx.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzwx zzwx2 = zzwx.DISCONNECTED;
        sparseArray.put(ordinal2, zzwx2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzwx2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzwx2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzwx2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzwx2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwx.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzwx);
        }
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzwx);
    }

    zzcuv(Context context, zzbtl zzbtl, zzcuo zzcuo, zzcuk zzcuk, zzg zzg2) {
        this.zza = context;
        this.zzb = zzbtl;
        this.zzd = zzcuo;
        this.zze = zzcuk;
        this.zzc = (TelephonyManager) context.getSystemService("phone");
        this.zzf = zzg2;
    }

    static /* synthetic */ zzwo zzd(zzcuv zzcuv, Bundle bundle) {
        zzwk zzwk;
        zzwh zzf2 = zzwo.zzf();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzcuv.zzg = zzvy.ENUM_TRUE;
        } else {
            zzcuv.zzg = zzvy.ENUM_FALSE;
            if (i == 0) {
                zzf2.zza(zzwn.CELL);
            } else if (i != 1) {
                zzf2.zza(zzwn.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzf2.zza(zzwn.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzwk = zzwk.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzwk = zzwk.THREE_G;
                    break;
                case 13:
                    zzwk = zzwk.LTE;
                    break;
                default:
                    zzwk = zzwk.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzf2.zzb(zzwk);
        }
        return (zzwo) zzf2.zzah();
    }

    static /* synthetic */ byte[] zzf(zzcuv zzcuv, boolean z, ArrayList arrayList, zzwo zzwo, zzwx zzwx) {
        zzws zzo = zzwt.zzo();
        zzo.zze(arrayList);
        boolean z2 = true;
        zzo.zzh(zzg(zzs.zze().zzf(zzcuv.zza.getContentResolver()) != 0));
        zzo.zzi(zzs.zze().zzq(zzcuv.zza, zzcuv.zzc));
        zzo.zzc(zzcuv.zzd.zzd());
        zzo.zzd(zzcuv.zzd.zzh());
        zzo.zzj(zzcuv.zzd.zzb());
        zzo.zzl(zzwx);
        zzo.zzf(zzwo);
        zzo.zzk(zzcuv.zzg);
        zzo.zzb(zzg(z));
        zzo.zza(zzs.zzj().currentTimeMillis());
        if (zzs.zze().zze(zzcuv.zza.getContentResolver()) == 0) {
            z2 = false;
        }
        zzo.zzg(zzg(z2));
        return ((zzwt) zzo.zzah()).zzao();
    }

    private static final zzvy zzg(boolean z) {
        return z ? zzvy.ENUM_TRUE : zzvy.ENUM_FALSE;
    }

    public final void zza(boolean z) {
        zzefo.zzo(this.zzb.zza(), new zzcuu(this, z), zzbbw.zzf);
    }
}
