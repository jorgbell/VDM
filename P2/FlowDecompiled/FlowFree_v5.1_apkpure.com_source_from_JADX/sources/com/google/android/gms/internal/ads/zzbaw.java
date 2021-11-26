package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.mopub.common.Constants;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbaw {
    long zza = -1;
    long zzb = -1;
    @GuardedBy("lock")
    int zzc = -1;
    int zzd = -1;
    long zze = 0;
    final String zzf;
    @GuardedBy("lock")
    int zzg = 0;
    @GuardedBy("lock")
    int zzh = 0;
    private final Object zzi = new Object();
    private final zzg zzj;

    public zzbaw(String str, zzg zzg2) {
        this.zzf = str;
        this.zzj = zzg2;
    }

    public final void zza() {
        synchronized (this.zzi) {
            this.zzg++;
        }
    }

    public final void zzb() {
        synchronized (this.zzi) {
            this.zzh++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzys r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.zzi
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzg r1 = r10.zzj     // Catch:{ all -> 0x0074 }
            long r1 = r1.zzq()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ all -> 0x0074 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0074 }
            long r5 = r10.zzb     // Catch:{ all -> 0x0074 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzaeq.zzaE     // Catch:{ all -> 0x0074 }
            com.google.android.gms.internal.ads.zzaeo r6 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x0074 }
            java.lang.Object r5 = r6.zzb(r5)     // Catch:{ all -> 0x0074 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0074 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0074 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzd = r1     // Catch:{ all -> 0x0074 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzg r1 = r10.zzj     // Catch:{ all -> 0x0074 }
            int r1 = r1.zzs()     // Catch:{ all -> 0x0074 }
            r10.zzd = r1     // Catch:{ all -> 0x0074 }
        L_0x003b:
            r10.zzb = r12     // Catch:{ all -> 0x0074 }
            r10.zza = r12     // Catch:{ all -> 0x0074 }
            goto L_0x0042
        L_0x0040:
            r10.zza = r12     // Catch:{ all -> 0x0074 }
        L_0x0042:
            android.os.Bundle r11 = r11.zzc     // Catch:{ all -> 0x0074 }
            r12 = 1
            if (r11 == 0) goto L_0x0053
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0074 }
            if (r11 == r12) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0053:
            int r11 = r10.zzc     // Catch:{ all -> 0x0074 }
            int r11 = r11 + r12
            r10.zzc = r11     // Catch:{ all -> 0x0074 }
            int r11 = r10.zzd     // Catch:{ all -> 0x0074 }
            int r11 = r11 + r12
            r10.zzd = r11     // Catch:{ all -> 0x0074 }
            if (r11 != 0) goto L_0x0069
            r11 = 0
            r10.zze = r11     // Catch:{ all -> 0x0074 }
            com.google.android.gms.ads.internal.util.zzg r11 = r10.zzj     // Catch:{ all -> 0x0074 }
            r11.zzt(r3)     // Catch:{ all -> 0x0074 }
            goto L_0x0072
        L_0x0069:
            com.google.android.gms.ads.internal.util.zzg r11 = r10.zzj     // Catch:{ all -> 0x0074 }
            long r11 = r11.zzu()     // Catch:{ all -> 0x0074 }
            long r3 = r3 - r11
            r10.zze = r3     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0074:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbaw.zzc(com.google.android.gms.internal.ads.zzys, long):void");
    }

    public final void zzd() {
        if (zzagh.zza.zze().booleanValue()) {
            synchronized (this.zzi) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final Bundle zze(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzi) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzj.zzB() ? "" : this.zzf);
            bundle.putLong("basets", this.zzb);
            bundle.putLong("currts", this.zza);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzc);
            bundle.putInt("preqs_in_session", this.zzd);
            bundle.putLong("time_in_session", this.zze);
            bundle.putInt("pclick", this.zzg);
            bundle.putInt("pimp", this.zzh);
            Context zza2 = zzawq.zza(context);
            int identifier = zza2.getResources().getIdentifier("Theme.Translucent", "style", Constants.ANDROID_PLATFORM);
            boolean z = false;
            if (identifier == 0) {
                zzbbk.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            } else {
                try {
                    if (identifier == zza2.getPackageManager().getActivityInfo(new ComponentName(zza2.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                        z = true;
                    } else {
                        zzbbk.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zzbbk.zzi("Fail to fetch AdActivity theme");
                    zzbbk.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                }
            }
            bundle.putBoolean("support_transparent_background", z);
        }
        return bundle;
    }
}
