package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbav {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb;
    private final zzbaz zzc;
    private boolean zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public zzbbq zzf;
    /* access modifiers changed from: private */
    public zzaev zzg;
    private Boolean zzh;
    private final AtomicInteger zzi;
    private final zzbau zzj;
    private final Object zzk;
    private zzefw<ArrayList<String>> zzl;

    public zzbav() {
        zzj zzj2 = new zzj();
        this.zzb = zzj2;
        this.zzc = new zzbaz(zzzy.zzc(), zzj2);
        this.zzd = false;
        this.zzg = null;
        this.zzh = null;
        this.zzi = new AtomicInteger(0);
        this.zzj = new zzbau((zzbat) null);
        this.zzk = new Object();
    }

    public final zzaev zza() {
        zzaev zzaev;
        synchronized (this.zza) {
            zzaev = this.zzg;
        }
        return zzaev;
    }

    public final void zzb(Boolean bool) {
        synchronized (this.zza) {
            this.zzh = bool;
        }
    }

    public final Boolean zzc() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzh;
        }
        return bool;
    }

    public final void zzd() {
        this.zzj.zza();
    }

    @TargetApi(23)
    public final void zze(Context context, zzbbq zzbbq) {
        zzaev zzaev;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = zzbbq;
                zzs.zzf().zzb(this.zzc);
                this.zzb.zza(this.zze);
                zzavk.zzb(this.zze, this.zzf);
                zzs.zzl();
                if (!zzafy.zzc.zze().booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzaev = null;
                } else {
                    zzaev = new zzaev();
                }
                this.zzg = zzaev;
                if (zzaev != null) {
                    zzbbz.zza(new zzbat(this).zzb(), "AppState.registerCsiReporter");
                }
                this.zzd = true;
                zzn();
            }
        }
        zzs.zzc().zze(context, zzbbq.zza);
    }

    public final Resources zzf() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            zzbbo.zzb(this.zze).getResources();
            return null;
        } catch (zzbbn e) {
            zzbbk.zzj("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zzg(Throwable th, String str) {
        zzavk.zzb(this.zze, this.zzf).zzd(th, str);
    }

    public final void zzh(Throwable th, String str) {
        zzavk.zzb(this.zze, this.zzf).zze(th, str, zzagj.zzg.zze().floatValue());
    }

    public final void zzi() {
        this.zzi.incrementAndGet();
    }

    public final void zzj() {
        this.zzi.decrementAndGet();
    }

    public final int zzk() {
        return this.zzi.get();
    }

    public final zzg zzl() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final Context zzm() {
        return this.zze;
    }

    public final zzefw<ArrayList<String>> zzn() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zze != null) {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzbG)).booleanValue()) {
                synchronized (this.zzk) {
                    zzefw<ArrayList<String>> zzefw = this.zzl;
                    if (zzefw != null) {
                        return zzefw;
                    }
                    zzefw<ArrayList<String>> zzb2 = zzbbw.zza.zzb(new zzbas(this));
                    this.zzl = zzb2;
                    return zzb2;
                }
            }
        }
        return zzefo.zza(new ArrayList());
    }

    public final zzbaz zzo() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzp() throws Exception {
        Context zza2 = zzawq.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }
}
