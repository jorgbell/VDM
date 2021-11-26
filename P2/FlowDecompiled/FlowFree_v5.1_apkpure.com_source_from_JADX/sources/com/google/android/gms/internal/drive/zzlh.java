package com.google.android.gms.internal.drive;

final class zzlh implements zzlp {
    private zzlp[] zztt;

    zzlh(zzlp... zzlpArr) {
        this.zztt = zzlpArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzlp zzb : this.zztt) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzlo zzc(Class<?> cls) {
        for (zzlp zzlp : this.zztt) {
            if (zzlp.zzb(cls)) {
                return zzlp.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
