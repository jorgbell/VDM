package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzami implements zzv {
    /* access modifiers changed from: private */
    public volatile zzalv zza;
    private final Context zzb;

    public zzami(Context context) {
        this.zzb = context;
    }

    static /* synthetic */ void zzb(zzami zzami) {
        if (zzami.zza != null) {
            zzami.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzy zza(zzac<?> zzac) throws zzal {
        Parcelable.Creator<zzalw> creator = zzalw.CREATOR;
        Map<String, String> zzm = zzac.zzm();
        int size = zzm.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry next : zzm.entrySet()) {
            strArr[i2] = (String) next.getKey();
            strArr2[i2] = (String) next.getValue();
            i2++;
        }
        zzalw zzalw = new zzalw(zzac.zzh(), strArr, strArr2);
        long elapsedRealtime = zzs.zzj().elapsedRealtime();
        try {
            zzbcb zzbcb = new zzbcb();
            this.zza = new zzalv(this.zzb, zzs.zzq().zza(), new zzamg(this, zzbcb), new zzamh(this, zzbcb));
            this.zza.checkAvailabilityAndConnect();
            zzame zzame = new zzame(this, zzalw);
            zzefx zzefx = zzbbw.zza;
            zzefw zzg = zzefo.zzg(zzefo.zzh(zzbcb, zzame, zzefx), (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzcG)).intValue(), TimeUnit.MILLISECONDS, zzbbw.zzd);
            zzg.zze(new zzamf(this), zzefx);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzg.get();
            long elapsedRealtime2 = zzs.zzj().elapsedRealtime();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2 - elapsedRealtime);
            sb.append("ms");
            zze.zza(sb.toString());
            zzaly zzaly = (zzaly) new zzawa(parcelFileDescriptor).zza(zzaly.CREATOR);
            if (zzaly == null) {
                return null;
            }
            if (zzaly.zza) {
                throw new zzal(zzaly.zzb);
            } else if (zzaly.zze.length != zzaly.zzf.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzaly.zze;
                    if (i >= strArr3.length) {
                        return new zzy(zzaly.zzc, zzaly.zzd, (Map<String, String>) hashMap, zzaly.zzg, zzaly.zzh);
                    }
                    hashMap.put(strArr3[i], zzaly.zzf[i]);
                    i++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzs.zzj().elapsedRealtime();
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(elapsedRealtime3 - elapsedRealtime);
            sb2.append("ms");
            zze.zza(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = zzs.zzj().elapsedRealtime();
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime4 - elapsedRealtime);
            sb3.append("ms");
            zze.zza(sb3.toString());
            throw th;
        }
    }
}
