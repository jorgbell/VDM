package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdSize {
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    @RecentlyNonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    @RecentlyNonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    @RecentlyNonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    @RecentlyNonNull
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    @RecentlyNonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    @RecentlyNonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    @RecentlyNonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    @RecentlyNonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    @RecentlyNonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        new AdSize(-3, 0, "search_v2");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        L_0x000a:
            r1 = -2
            if (r7 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r7)
        L_0x0014:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + 4
            int r2 = r2 + r3
            r4.<init>(r2)
            r4.append(r0)
            java.lang.String r0 = "x"
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = "_as"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r5.<init>(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getWidth() {
        return this.zzb;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    @RecentlyNonNull
    public String toString() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        this.zzf = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i) {
        this.zzg = i;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(boolean z) {
        this.zzh = true;
    }

    /* access modifiers changed from: package-private */
    public final int zzh() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zzi(int i) {
        this.zzi = i;
    }

    public int getHeightInPixels(@RecentlyNonNull Context context) {
        int i = this.zzc;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzyx.zza(context.getResources().getDisplayMetrics());
        }
        zzzy.zza();
        return zzbbd.zzs(context, this.zzc);
    }

    public int getWidthInPixels(@RecentlyNonNull Context context) {
        int i = this.zzb;
        if (i == -3) {
            return -1;
        }
        if (i != -1) {
            zzzy.zza();
            return zzbbd.zzs(context, this.zzb);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzyx> creator = zzyx.CREATOR;
        return displayMetrics.widthPixels;
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.zzb = i;
            this.zzc = i2;
            this.zzd = str;
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
