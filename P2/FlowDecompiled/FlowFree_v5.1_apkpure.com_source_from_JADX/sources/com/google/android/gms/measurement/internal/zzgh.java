package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzlf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzgh extends zzec {
    /* access modifiers changed from: private */
    public final zzki zza;
    private Boolean zzb;
    private String zzc = null;

    public zzgh(zzki zzki, String str) {
        Preconditions.checkNotNull(zzki);
        this.zza = zzki;
    }

    private final void zzx(zzp zzp, boolean z) {
        Preconditions.checkNotNull(zzp);
        Preconditions.checkNotEmpty(zzp.zza);
        zzy(zzp.zza, false);
        this.zza.zzq().zzA(zzp.zzb, zzp.zzq, zzp.zzu);
    }

    private final void zzy(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzax(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzax()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzau().zzb().zzb("Measurement Service called with invalid calling package. appId", zzem.zzl(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzax(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzau().zzb().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final zzas zzb(zzas zzas, zzp zzp) {
        zzaq zzaq;
        if (!(!"_cmp".equals(zzas.zza) || (zzaq = zzas.zzb) == null || zzaq.zze() == 0)) {
            String zzd = zzas.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                this.zza.zzau().zzi().zzb("Event has been filtered ", zzas.toString());
                return new zzas("_cmpx", zzas.zzb, zzas.zzc, zzas.zzd);
            }
        }
        return zzas;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzav().zzd()) {
            runnable.run();
        } else {
            this.zza.zzav().zzh(runnable);
        }
    }

    public final void zzd(zzas zzas, zzp zzp) {
        Preconditions.checkNotNull(zzas);
        zzx(zzp, false);
        zzc(new zzga(this, zzas, zzp));
    }

    public final void zze(zzkl zzkl, zzp zzp) {
        Preconditions.checkNotNull(zzkl);
        zzx(zzp, false);
        zzc(new zzgd(this, zzkl, zzp));
    }

    public final void zzf(zzp zzp) {
        zzx(zzp, false);
        zzc(new zzgf(this, zzp));
    }

    public final void zzg(zzas zzas, String str, String str2) {
        Preconditions.checkNotNull(zzas);
        Preconditions.checkNotEmpty(str);
        zzy(str, true);
        zzc(new zzgb(this, zzas, str));
    }

    public final void zzh(zzp zzp) {
        zzx(zzp, false);
        zzc(new zzfy(this, zzp));
    }

    public final List<zzkl> zzi(zzp zzp, boolean z) {
        zzx(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzkn> list = (List) this.zza.zzav().zze(new zzge(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzkn : list) {
                if (z || !zzkp.zzR(zzkn.zzc)) {
                    arrayList.add(new zzkl(zzkn));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzc("Failed to get user properties. appId", zzem.zzl(zzp.zza), e);
            return null;
        }
    }

    public final byte[] zzj(zzas zzas, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzas);
        zzy(str, true);
        this.zza.zzau().zzj().zzb("Log and bundle. event", this.zza.zzo().zzc(zzas.zza));
        long nanoTime = this.zza.zzay().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzav().zzf(new zzgc(this, zzas, str)).get();
            if (bArr == null) {
                this.zza.zzau().zzb().zzb("Log and bundle returned null. appId", zzem.zzl(str));
                bArr = new byte[0];
            }
            this.zza.zzau().zzj().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzo().zzc(zzas.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzay().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzd("Failed to log and bundle. appId, event, error", zzem.zzl(str), this.zza.zzo().zzc(zzas.zza), e);
            return null;
        }
    }

    public final void zzk(long j, String str, String str2, String str3) {
        zzc(new zzgg(this, str2, str3, str, j));
    }

    public final String zzl(zzp zzp) {
        zzx(zzp, false);
        return this.zza.zzV(zzp);
    }

    public final void zzm(zzaa zzaa, zzp zzp) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotNull(zzaa.zzc);
        zzx(zzp, false);
        zzaa zzaa2 = new zzaa(zzaa);
        zzaa2.zza = zzp.zza;
        zzc(new zzfr(this, zzaa2, zzp));
    }

    public final void zzn(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotNull(zzaa.zzc);
        Preconditions.checkNotEmpty(zzaa.zza);
        zzy(zzaa.zza, true);
        zzc(new zzfs(this, new zzaa(zzaa)));
    }

    public final List<zzkl> zzo(String str, String str2, boolean z, zzp zzp) {
        zzx(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzkn> list = (List) this.zza.zzav().zze(new zzft(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzkn : list) {
                if (z || !zzkp.zzR(zzkn.zzc)) {
                    arrayList.add(new zzkl(zzkn));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzc("Failed to query user properties. appId", zzem.zzl(zzp.zza), e);
            return Collections.emptyList();
        }
    }

    public final List<zzkl> zzp(String str, String str2, String str3, boolean z) {
        zzy(str, true);
        try {
            List<zzkn> list = (List) this.zza.zzav().zze(new zzfu(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzkn : list) {
                if (z || !zzkp.zzR(zzkn.zzc)) {
                    arrayList.add(new zzkl(zzkn));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzc("Failed to get user properties as. appId", zzem.zzl(str), e);
            return Collections.emptyList();
        }
    }

    public final List<zzaa> zzq(String str, String str2, zzp zzp) {
        zzx(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzav().zze(new zzfv(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List<zzaa> zzr(String str, String str2, String str3) {
        zzy(str, true);
        try {
            return (List) this.zza.zzav().zze(new zzfw(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzau().zzb().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final void zzs(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        zzy(zzp.zza, false);
        zzc(new zzfx(this, zzp));
    }

    public final void zzt(Bundle bundle, zzp zzp) {
        zzx(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        zzc(new zzfq(this, str, bundle));
    }

    public final void zzu(zzp zzp) {
        zzlf.zzb();
        if (this.zza.zzd().zzn((String) null, zzea.zzaw)) {
            Preconditions.checkNotEmpty(zzp.zza);
            Preconditions.checkNotNull(zzp.zzv);
            zzfz zzfz = new zzfz(this, zzp);
            Preconditions.checkNotNull(zzfz);
            if (this.zza.zzav().zzd()) {
                zzfz.run();
            } else {
                this.zza.zzav().zzj(zzfz);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(String str, Bundle bundle) {
        zzai zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzZ();
        byte[] zzbp = zzi.zzf.zzm().zzf(new zzan(zzi.zzs, "", str, "dep", 0, 0, bundle)).zzbp();
        zzi.zzs.zzau().zzk().zzc("Saving default event parameters, appId, data size", zzi.zzs.zzm().zzc(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbp);
        try {
            if (zzi.zze().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzi.zzs.zzau().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzem.zzl(str));
            }
        } catch (SQLiteException e) {
            zzi.zzs.zzau().zzb().zzc("Error storing default event parameters. appId", zzem.zzl(str), e);
        }
    }
}
