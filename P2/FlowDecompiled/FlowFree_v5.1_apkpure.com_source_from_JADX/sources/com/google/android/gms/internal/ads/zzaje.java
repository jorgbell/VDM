package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd$Image;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaje extends UnifiedNativeAd {
    private final zzajd zza;
    private final List<NativeAd$Image> zzb = new ArrayList();
    private final zzahl zzc;
    private final VideoController zzd = new VideoController();
    private final List<Object> zzf = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[Catch:{ RemoteException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0027 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaje(com.google.android.gms.internal.ads.zzajd r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzd = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzf = r1
            r5.zza = r6
            r1 = 0
            java.util.List r6 = r6.zzf()     // Catch:{ RemoteException -> 0x005b }
            if (r6 == 0) goto L_0x005f
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005b }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005b }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005b }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005b }
            if (r3 == 0) goto L_0x004d
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005b }
            if (r2 != 0) goto L_0x003a
            goto L_0x004d
        L_0x003a:
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005b }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzahk     // Catch:{ RemoteException -> 0x005b }
            if (r4 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzahk r3 = (com.google.android.gms.internal.ads.zzahk) r3     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x0047:
            com.google.android.gms.internal.ads.zzahi r3 = new com.google.android.gms.internal.ads.zzahi     // Catch:{ RemoteException -> 0x005b }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x004d:
            r3 = r1
        L_0x004e:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzb     // Catch:{ RemoteException -> 0x005b }
            com.google.android.gms.internal.ads.zzahl r4 = new com.google.android.gms.internal.ads.zzahl     // Catch:{ RemoteException -> 0x005b }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005b }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x0027
        L_0x005b:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbbk.zzg(r0, r6)
        L_0x005f:
            com.google.android.gms.internal.ads.zzajd r6 = r5.zza     // Catch:{ RemoteException -> 0x008e }
            java.util.List r6 = r6.zzz()     // Catch:{ RemoteException -> 0x008e }
            if (r6 == 0) goto L_0x0092
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008e }
        L_0x006b:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008e }
            if (r2 == 0) goto L_0x0092
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008e }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008e }
            if (r3 == 0) goto L_0x0080
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.internal.ads.zzabt r2 = com.google.android.gms.internal.ads.zzabs.zzb(r2)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x0081
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r2 == 0) goto L_0x006b
            java.util.List<java.lang.Object> r3 = r5.zzf     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.internal.ads.zzabu r4 = new com.google.android.gms.internal.ads.zzabu     // Catch:{ RemoteException -> 0x008e }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008e }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x006b
        L_0x008e:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbbk.zzg(r0, r6)
        L_0x0092:
            com.google.android.gms.internal.ads.zzajd r6 = r5.zza     // Catch:{ RemoteException -> 0x00a1 }
            com.google.android.gms.internal.ads.zzahk r6 = r6.zzh()     // Catch:{ RemoteException -> 0x00a1 }
            if (r6 == 0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzahl r2 = new com.google.android.gms.internal.ads.zzahl     // Catch:{ RemoteException -> 0x00a1 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x00a1 }
            r1 = r2
            goto L_0x00a5
        L_0x00a1:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbbk.zzg(r0, r6)
        L_0x00a5:
            r5.zzc = r1
            com.google.android.gms.internal.ads.zzajd r6 = r5.zza     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzahc r6 = r6.zzq()     // Catch:{ RemoteException -> 0x00bb }
            if (r6 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzahd r6 = new com.google.android.gms.internal.ads.zzahd     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzajd r1 = r5.zza     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzahc r1 = r1.zzq()     // Catch:{ RemoteException -> 0x00bb }
            r6.<init>(r1)     // Catch:{ RemoteException -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbbk.zzg(r0, r6)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaje.<init>(com.google.android.gms.internal.ads.zzajd):void");
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final String getHeadline() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final NativeAd$Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd$Image> getImages() {
        return this.zzb;
    }

    public final String getPrice() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double zzk = this.zza.zzk();
            if (zzk == -1.0d) {
                return null;
            }
            return Double.valueOf(zzk);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzn() != null) {
                this.zzd.zza(this.zza.zzn());
            }
        } catch (RemoteException e) {
            zzbbk.zzg("Exception occurred while getting video controller", e);
        }
        return this.zzd;
    }

    public final Object zza() {
        try {
            IObjectWrapper zzv = this.zza.zzv();
            if (zzv != null) {
                return ObjectWrapper.unwrap(zzv);
            }
            return null;
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }
}
