package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcex {
    private int zza;
    private zzacj zzb;
    private zzahc zzc;
    private View zzd;
    private List<?> zze;
    private List<zzada> zzf = Collections.emptyList();
    private zzada zzg;
    private Bundle zzh;
    private zzbgf zzi;
    private zzbgf zzj;
    private IObjectWrapper zzk;
    private View zzl;
    private IObjectWrapper zzm;
    private double zzn;
    private zzahk zzo;
    private zzahk zzp;
    private String zzq;
    private final SimpleArrayMap<String, zzagu> zzr = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, String> zzs = new SimpleArrayMap<>();
    private float zzt;
    private String zzu;

    public static zzcex zzW(zzaqq zzaqq) {
        try {
            return zzab(zzad(zzaqq.zzn(), zzaqq), zzaqq.zzo(), (View) zzac(zzaqq.zzp()), zzaqq.zze(), zzaqq.zzf(), zzaqq.zzg(), zzaqq.zzs(), zzaqq.zzi(), (View) zzac(zzaqq.zzq()), zzaqq.zzr(), zzaqq.zzl(), zzaqq.zzm(), zzaqq.zzk(), zzaqq.zzh(), zzaqq.zzj(), zzaqq.zzz());
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzcex zzX(zzaqn zzaqn) {
        try {
            zzcew zzad = zzad(zzaqn.zzs(), (zzaqq) null);
            zzahc zzt2 = zzaqn.zzt();
            String zze2 = zzaqn.zze();
            List<?> zzf2 = zzaqn.zzf();
            String zzg2 = zzaqn.zzg();
            Bundle zzp2 = zzaqn.zzp();
            String zzi2 = zzaqn.zzi();
            IObjectWrapper zzv = zzaqn.zzv();
            String zzj2 = zzaqn.zzj();
            zzahk zzh2 = zzaqn.zzh();
            zzcex zzcex = new zzcex();
            zzcex.zza = 1;
            zzcex.zzb = zzad;
            zzcex.zzc = zzt2;
            zzcex.zzd = (View) zzac(zzaqn.zzr());
            zzcex.zzo("headline", zze2);
            zzcex.zze = zzf2;
            zzcex.zzo("body", zzg2);
            zzcex.zzh = zzp2;
            zzcex.zzo("call_to_action", zzi2);
            zzcex.zzl = (View) zzac(zzaqn.zzu());
            zzcex.zzm = zzv;
            zzcex.zzo("advertiser", zzj2);
            zzcex.zzp = zzh2;
            return zzcex;
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzcex zzY(zzaqm zzaqm) {
        try {
            zzcew zzad = zzad(zzaqm.zzt(), (zzaqq) null);
            zzahc zzv = zzaqm.zzv();
            String zze2 = zzaqm.zze();
            List<?> zzf2 = zzaqm.zzf();
            String zzg2 = zzaqm.zzg();
            Bundle zzr2 = zzaqm.zzr();
            String zzi2 = zzaqm.zzi();
            IObjectWrapper zzx = zzaqm.zzx();
            String zzk2 = zzaqm.zzk();
            String zzl2 = zzaqm.zzl();
            double zzj2 = zzaqm.zzj();
            zzahk zzh2 = zzaqm.zzh();
            zzcex zzcex = new zzcex();
            zzcex.zza = 2;
            zzcex.zzb = zzad;
            zzcex.zzc = zzv;
            zzcex.zzd = (View) zzac(zzaqm.zzu());
            zzcex.zzo("headline", zze2);
            zzcex.zze = zzf2;
            zzcex.zzo("body", zzg2);
            zzcex.zzh = zzr2;
            zzcex.zzo("call_to_action", zzi2);
            zzcex.zzl = (View) zzac(zzaqm.zzw());
            zzcex.zzm = zzx;
            zzcex.zzo(TransactionErrorDetailsUtilities.STORE, zzk2);
            zzcex.zzo("price", zzl2);
            zzcex.zzn = zzj2;
            zzcex.zzo = zzh2;
            return zzcex;
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzcex zzZ(zzaqm zzaqm) {
        try {
            return zzab(zzad(zzaqm.zzt(), (zzaqq) null), zzaqm.zzv(), (View) zzac(zzaqm.zzu()), zzaqm.zze(), zzaqm.zzf(), zzaqm.zzg(), zzaqm.zzr(), zzaqm.zzi(), (View) zzac(zzaqm.zzw()), zzaqm.zzx(), zzaqm.zzk(), zzaqm.zzl(), zzaqm.zzj(), zzaqm.zzh(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcex zzaa(zzaqn zzaqn) {
        try {
            return zzab(zzad(zzaqn.zzs(), (zzaqq) null), zzaqn.zzt(), (View) zzac(zzaqn.zzr()), zzaqn.zze(), zzaqn.zzf(), zzaqn.zzg(), zzaqn.zzp(), zzaqn.zzi(), (View) zzac(zzaqn.zzu()), zzaqn.zzv(), (String) null, (String) null, -1.0d, zzaqn.zzh(), zzaqn.zzj(), 0.0f);
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzcex zzab(zzacj zzacj, zzahc zzahc, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzahk zzahk, String str6, float f) {
        zzcex zzcex = new zzcex();
        zzcex.zza = 6;
        zzcex.zzb = zzacj;
        zzcex.zzc = zzahc;
        zzcex.zzd = view;
        String str7 = str;
        zzcex.zzo("headline", str);
        zzcex.zze = list;
        String str8 = str2;
        zzcex.zzo("body", str2);
        zzcex.zzh = bundle;
        String str9 = str3;
        zzcex.zzo("call_to_action", str3);
        zzcex.zzl = view2;
        zzcex.zzm = iObjectWrapper;
        String str10 = str4;
        zzcex.zzo(TransactionErrorDetailsUtilities.STORE, str4);
        String str11 = str5;
        zzcex.zzo("price", str5);
        zzcex.zzn = d;
        zzcex.zzo = zzahk;
        zzcex.zzo("advertiser", str6);
        zzcex.zzq(f);
        return zzcex;
    }

    private static <T> T zzac(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzcew zzad(zzacj zzacj, zzaqq zzaqq) {
        if (zzacj == null) {
            return null;
        }
        return new zzcew(zzacj, zzaqq);
    }

    public final synchronized List<zzada> zzA() {
        return this.zzf;
    }

    public final synchronized zzada zzB() {
        return this.zzg;
    }

    public final synchronized String zzC() {
        return zzs("body");
    }

    public final synchronized Bundle zzD() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized String zzE() {
        return zzs("call_to_action");
    }

    public final synchronized View zzF() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzG() {
        return this.zzm;
    }

    public final synchronized String zzH() {
        return zzs(TransactionErrorDetailsUtilities.STORE);
    }

    public final synchronized String zzI() {
        return zzs("price");
    }

    public final synchronized double zzJ() {
        return this.zzn;
    }

    public final synchronized zzahk zzK() {
        return this.zzo;
    }

    public final synchronized String zzL() {
        return zzs("advertiser");
    }

    public final synchronized zzahk zzM() {
        return this.zzp;
    }

    public final synchronized String zzN() {
        return this.zzq;
    }

    public final synchronized zzbgf zzO() {
        return this.zzi;
    }

    public final synchronized zzbgf zzP() {
        return this.zzj;
    }

    public final synchronized IObjectWrapper zzQ() {
        return this.zzk;
    }

    public final synchronized SimpleArrayMap<String, zzagu> zzR() {
        return this.zzr;
    }

    public final synchronized float zzS() {
        return this.zzt;
    }

    public final synchronized String zzT() {
        return this.zzu;
    }

    public final synchronized SimpleArrayMap<String, String> zzU() {
        return this.zzs;
    }

    public final synchronized void zzV() {
        zzbgf zzbgf = this.zzi;
        if (zzbgf != null) {
            zzbgf.destroy();
            this.zzi = null;
        }
        zzbgf zzbgf2 = this.zzj;
        if (zzbgf2 != null) {
            zzbgf2.destroy();
            this.zzj = null;
        }
        this.zzk = null;
        this.zzr.clear();
        this.zzs.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzl = null;
        this.zzm = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
    }

    public final synchronized void zza(int i) {
        this.zza = i;
    }

    public final synchronized void zzb(zzacj zzacj) {
        this.zzb = zzacj;
    }

    public final synchronized void zzc(zzahc zzahc) {
        this.zzc = zzahc;
    }

    public final synchronized void zzd(List<zzagu> list) {
        this.zze = list;
    }

    public final synchronized void zze(List<zzada> list) {
        this.zzf = list;
    }

    public final synchronized void zzf(zzada zzada) {
        this.zzg = zzada;
    }

    public final synchronized void zzg(View view) {
        this.zzl = view;
    }

    public final synchronized void zzh(double d) {
        this.zzn = d;
    }

    public final synchronized void zzi(zzahk zzahk) {
        this.zzo = zzahk;
    }

    public final synchronized void zzj(zzahk zzahk) {
        this.zzp = zzahk;
    }

    public final synchronized void zzk(String str) {
        this.zzq = str;
    }

    public final synchronized void zzl(zzbgf zzbgf) {
        this.zzi = zzbgf;
    }

    public final synchronized void zzm(zzbgf zzbgf) {
        this.zzj = zzbgf;
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) {
        this.zzk = iObjectWrapper;
    }

    public final synchronized void zzo(String str, String str2) {
        if (str2 == null) {
            this.zzs.remove(str);
        } else {
            this.zzs.put(str, str2);
        }
    }

    public final synchronized void zzp(String str, zzagu zzagu) {
        if (zzagu == null) {
            this.zzr.remove(str);
        } else {
            this.zzr.put(str, zzagu);
        }
    }

    public final synchronized void zzq(float f) {
        this.zzt = f;
    }

    public final synchronized void zzr(String str) {
        this.zzu = str;
    }

    public final synchronized String zzs(String str) {
        return this.zzs.get(str);
    }

    public final synchronized int zzt() {
        return this.zza;
    }

    public final synchronized zzacj zzu() {
        return this.zzb;
    }

    public final synchronized zzahc zzv() {
        return this.zzc;
    }

    public final synchronized View zzw() {
        return this.zzd;
    }

    public final synchronized String zzx() {
        return zzs("headline");
    }

    public final synchronized List<?> zzy() {
        return this.zze;
    }

    public final zzahk zzz() {
        List<?> list = this.zze;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzahj.zzg((IBinder) obj);
            }
        }
        return null;
    }
}
