package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzrx {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzsm zze;
    private final zzsu zzf;
    private final Object zzg = new Object();
    private final ArrayList<String> zzh = new ArrayList<>();
    private final ArrayList<String> zzi = new ArrayList<>();
    private final ArrayList<zzsi> zzj = new ArrayList<>();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private int zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzrx(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
        this.zze = new zzsm(i4);
        this.zzf = new zzsu(i5, i6, i7);
    }

    private final void zzp(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzc) {
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z) {
                    this.zzi.add(str);
                    this.zzj.add(new zzsi(f, f2, f3, f4, this.zzi.size() - 1));
                }
            }
        }
    }

    private static final String zzq(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append(arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrx)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzrx) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int i = this.zzl;
        int i2 = this.zzn;
        int i3 = this.zzk;
        String zzq2 = zzq(this.zzh, 100);
        String zzq3 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        int length = String.valueOf(zzq2).length();
        int length2 = String.valueOf(zzq3).length();
        int length3 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 165 + length2 + length3 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zzq2);
        sb.append("\n viewableText");
        sb.append(zzq3);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final boolean zza() {
        boolean z;
        synchronized (this.zzg) {
            z = this.zzm == 0;
        }
        return z;
    }

    public final String zzb() {
        return this.zzo;
    }

    public final String zzc() {
        return this.zzp;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzh(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                zzbbk.zzd("ActivityContent: negative number of WebViews.");
            }
            zzk();
        }
    }

    public final void zzi(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
    }

    public final void zzj() {
        synchronized (this.zzg) {
            int zzl2 = zzl(this.zzk, this.zzl);
            if (zzl2 > this.zzn) {
                this.zzn = zzl2;
            }
        }
    }

    public final void zzk() {
        synchronized (this.zzg) {
            int zzl2 = zzl(this.zzk, this.zzl);
            if (zzl2 > this.zzn) {
                this.zzn = zzl2;
                if (!zzs.zzg().zzl().zzd()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!zzs.zzg().zzl().zzh()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzl(int i, int i2) {
        return this.zzd ? this.zzb : (i * this.zza) + (i2 * this.zzb);
    }

    public final int zzm() {
        return this.zzn;
    }

    public final void zzn(int i) {
        this.zzl = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzo() {
        return this.zzk;
    }
}
