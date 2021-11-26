package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzecm extends zzecp {
    final /* synthetic */ zzecn zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzecm(zzecn zzecn, zzecq zzecq, CharSequence charSequence) {
        super(zzecq, charSequence);
        this.zza = zzecn;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        zzeby zzeby = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzecl.zze(i, length, "index");
        while (i < length) {
            if (zzeby.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        return i + 1;
    }
}
