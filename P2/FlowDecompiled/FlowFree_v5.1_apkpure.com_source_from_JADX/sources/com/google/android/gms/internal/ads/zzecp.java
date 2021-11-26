package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
abstract class zzecp extends zzebs<String> {
    final CharSequence zzb;
    int zzd = 0;
    int zze;

    protected zzecp(zzecq zzecq, CharSequence charSequence) {
        zzeby unused = zzecq.zza;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzc = zzc(i3);
                if (zzc == -1) {
                    zzc = this.zzb.length();
                    this.zzd = -1;
                    i = -1;
                } else {
                    i = zzd(zzc);
                    this.zzd = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zzd = i4;
                    if (i4 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i2 < zzc) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzc) {
                        this.zzb.charAt(zzc - 1);
                    }
                    int i5 = this.zze;
                    if (i5 == 1) {
                        zzc = this.zzb.length();
                        this.zzd = -1;
                        if (zzc > i2) {
                            this.zzb.charAt(zzc - 1);
                        }
                    } else {
                        this.zze = i5 - 1;
                    }
                    return this.zzb.subSequence(i2, zzc).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);
}
