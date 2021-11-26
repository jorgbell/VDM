package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyx> CREATOR = new zzyy();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final zzyx[] zzg;
    public final boolean zzh;
    public final boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;

    public zzyx() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzyx[]) null, false, false, false, false, false, false, false, false);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int) (((float) zzf(displayMetrics)) * displayMetrics.density);
    }

    public static zzyx zzb() {
        return new zzyx("320x50_mb", 0, 0, false, 0, 0, (zzyx[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzyx zzc() {
        return new zzyx("reward_mb", 0, 0, true, 0, 0, (zzyx[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzyx zzd() {
        return new zzyx("interstitial_mb", 0, 0, false, 0, 0, (zzyx[]) null, false, false, false, false, true, false, false, false);
    }

    public static zzyx zze() {
        return new zzyx("invalid", 0, 0, false, 0, 0, (zzyx[]) null, false, false, false, true, false, false, false, false);
    }

    private static int zzf(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzyx(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzyx(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzd = r0
            boolean r2 = r1.isFluid()
            r12.zzi = r2
            boolean r3 = com.google.android.gms.ads.zza.zzf(r1)
            r12.zzm = r3
            boolean r3 = com.google.android.gms.ads.zza.zzg(r1)
            r12.zzn = r3
            boolean r3 = com.google.android.gms.ads.zza.zzd(r1)
            r12.zzo = r3
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r3 = r2.getWidth()
            r12.zze = r3
            int r2 = r2.getHeight()
            r12.zzb = r2
            goto L_0x005d
        L_0x0031:
            boolean r2 = r12.zzn
            if (r2 == 0) goto L_0x0042
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = com.google.android.gms.ads.zza.zzh(r1)
            r12.zzb = r2
            goto L_0x005d
        L_0x0042:
            if (r3 == 0) goto L_0x0051
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = com.google.android.gms.ads.zza.zze(r1)
            r12.zzb = r2
            goto L_0x005d
        L_0x0051:
            int r2 = r1.getWidth()
            r12.zze = r2
            int r2 = r1.getHeight()
            r12.zzb = r2
        L_0x005d:
            int r3 = r12.zze
            android.content.res.Resources r4 = r13.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            r5 = -1
            if (r3 != r5) goto L_0x0136
            com.google.android.gms.internal.ads.zzzy.zza()
            android.content.res.Resources r6 = r13.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 == r7) goto L_0x007c
            goto L_0x0118
        L_0x007c:
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r7 = r6.heightPixels
            float r7 = (float) r7
            float r6 = r6.density
            float r7 = r7 / r6
            int r6 = (int) r7
            r7 = 600(0x258, float:8.41E-43)
            if (r6 >= r7) goto L_0x0118
            com.google.android.gms.internal.ads.zzzy.zza()
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            java.lang.String r7 = "window"
            java.lang.Object r7 = r13.getSystemService(r7)
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            if (r7 == 0) goto L_0x0118
            android.view.Display r7 = r7.getDefaultDisplay()
            boolean r8 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()
            if (r8 == 0) goto L_0x00b6
            r7.getRealMetrics(r6)
            int r8 = r6.heightPixels
            int r9 = r6.widthPixels
            goto L_0x00ea
        L_0x00b6:
            java.lang.Class<android.view.Display> r8 = android.view.Display.class
            java.lang.String r9 = "getRawHeight"
            java.lang.Class[] r10 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0118 }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r10)     // Catch:{ Exception -> 0x0118 }
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0118 }
            java.lang.Object r8 = r8.invoke(r7, r9)     // Catch:{ Exception -> 0x0118 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x0118 }
            java.lang.Class<android.view.Display> r9 = android.view.Display.class
            java.lang.String r10 = "getRawWidth"
            java.lang.Class[] r11 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0118 }
            java.lang.reflect.Method r9 = r9.getMethod(r10, r11)     // Catch:{ Exception -> 0x0118 }
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0118 }
            java.lang.Object r9 = r9.invoke(r7, r10)     // Catch:{ Exception -> 0x0118 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x0118 }
            if (r8 != 0) goto L_0x00de
            r8 = 0
            goto L_0x00e2
        L_0x00de:
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0118 }
        L_0x00e2:
            if (r9 != 0) goto L_0x00e6
            r9 = 0
            goto L_0x00ea
        L_0x00e6:
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0118 }
        L_0x00ea:
            r7.getMetrics(r6)
            int r7 = r6.heightPixels
            int r6 = r6.widthPixels
            if (r7 != r8) goto L_0x0118
            if (r6 != r9) goto L_0x0118
            int r6 = r4.widthPixels
            com.google.android.gms.internal.ads.zzzy.zza()
            android.content.res.Resources r7 = r13.getResources()
            java.lang.String r8 = "navigation_bar_width"
            java.lang.String r9 = "dimen"
            java.lang.String r10 = "android"
            int r7 = r7.getIdentifier(r8, r9, r10)
            if (r7 <= 0) goto L_0x0113
            android.content.res.Resources r8 = r13.getResources()
            int r7 = r8.getDimensionPixelSize(r7)
            goto L_0x0114
        L_0x0113:
            r7 = 0
        L_0x0114:
            int r6 = r6 - r7
            r12.zzf = r6
            goto L_0x011c
        L_0x0118:
            int r6 = r4.widthPixels
            r12.zzf = r6
        L_0x011c:
            float r6 = (float) r6
            float r7 = r4.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r9)
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0143
            int r8 = r8 + 1
            goto L_0x0143
        L_0x0136:
            int r8 = r12.zze
            com.google.android.gms.internal.ads.zzzy.zza()
            int r6 = r12.zze
            int r6 = com.google.android.gms.internal.ads.zzbbd.zzk(r4, r6)
            r12.zzf = r6
        L_0x0143:
            r6 = -2
            if (r2 != r6) goto L_0x014b
            int r7 = zzf(r4)
            goto L_0x014d
        L_0x014b:
            int r7 = r12.zzb
        L_0x014d:
            com.google.android.gms.internal.ads.zzzy.zza()
            int r4 = com.google.android.gms.internal.ads.zzbbd.zzk(r4, r7)
            r12.zzc = r4
            java.lang.String r4 = "_as"
            java.lang.String r9 = "x"
            r10 = 26
            if (r3 == r5) goto L_0x0194
            if (r2 != r6) goto L_0x0161
            goto L_0x0194
        L_0x0161:
            boolean r2 = r12.zzn
            if (r2 != 0) goto L_0x0178
            boolean r2 = r12.zzo
            if (r2 == 0) goto L_0x016a
            goto L_0x0178
        L_0x016a:
            boolean r2 = r12.zzi
            if (r2 == 0) goto L_0x0171
            java.lang.String r1 = "320x50_mb"
            goto L_0x0191
        L_0x0171:
            java.lang.String r1 = r1.toString()
            r12.zza = r1
            goto L_0x01ab
        L_0x0178:
            int r1 = r12.zze
            int r2 = r12.zzb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r10)
            r3.append(r1)
            r3.append(r9)
            r3.append(r2)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x0191:
            r12.zza = r1
            goto L_0x01ab
        L_0x0194:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r8)
            r1.append(r9)
            r1.append(r7)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r12.zza = r1
        L_0x01ab:
            int r1 = r14.length
            r2 = 1
            if (r1 <= r2) goto L_0x01c5
            com.google.android.gms.internal.ads.zzyx[] r1 = new com.google.android.gms.internal.ads.zzyx[r1]
            r12.zzg = r1
            r1 = 0
        L_0x01b4:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x01c8
            com.google.android.gms.internal.ads.zzyx[] r2 = r12.zzg
            com.google.android.gms.internal.ads.zzyx r3 = new com.google.android.gms.internal.ads.zzyx
            r4 = r14[r1]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x01b4
        L_0x01c5:
            r13 = 0
            r12.zzg = r13
        L_0x01c8:
            r12.zzh = r0
            r12.zzj = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyx.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    zzyx(String str, int i, int i2, boolean z, int i3, int i4, zzyx[] zzyxArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = zzyxArr;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = z5;
        this.zzl = z6;
        this.zzm = z7;
        this.zzn = z8;
        this.zzo = z9;
    }
}
