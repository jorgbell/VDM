package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeus<T> implements zzevf<T> {
    private final zzeuo zza;
    private final zzevt<?, ?> zzb;
    private final boolean zzc;
    private final zzesu<?> zzd;

    private zzeus(zzevt<?, ?> zzevt, zzesu<?> zzesu, zzeuo zzeuo) {
        this.zzb = zzevt;
        this.zzc = zzesu.zza(zzeuo);
        this.zzd = zzesu;
        this.zza = zzeuo;
    }

    static <T> zzeus<T> zzg(zzevt<?, ?> zzevt, zzesu<?> zzesu, zzeuo zzeuo) {
        return new zzeus<>(zzevt, zzesu, zzeuo);
    }

    public final T zza() {
        return this.zza.zzaM().zzak();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int hashCode = this.zzb.zzj(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzevh.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzevh.zzE(this.zzd, t, t2);
            throw null;
        }
    }

    public final int zze(T t) {
        zzevt<?, ?> zzevt = this.zzb;
        int zzp = zzevt.zzp(zzevt.zzj(t));
        if (!this.zzc) {
            return zzp;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzf(T t, zzeuz zzeuz, zzest zzest) throws IOException {
        boolean z;
        zzevt<?, ?> zzevt = this.zzb;
        zzesu<?> zzesu = this.zzd;
        Object zzk = zzevt.zzk(t);
        zzesy<?> zzc2 = zzesu.zzc(t);
        while (zzeuz.zzb() != Integer.MAX_VALUE) {
            int zzc3 = zzeuz.zzc();
            if (zzc3 != 11) {
                if ((zzc3 & 7) == 2) {
                    Object zzf = zzesu.zzf(zzest, this.zza, zzc3 >>> 3);
                    if (zzf != null) {
                        zzesu.zzg(zzeuz, zzf, zzest, zzc2);
                    } else {
                        z = zzevt.zzn(zzk, zzeuz);
                    }
                } else {
                    z = zzeuz.zzd();
                }
                if (!z) {
                    zzevt.zzl(t, zzk);
                    return;
                }
            } else {
                int i = 0;
                Object obj = null;
                zzesf zzesf = null;
                while (true) {
                    try {
                        if (zzeuz.zzb() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzc4 = zzeuz.zzc();
                        if (zzc4 == 16) {
                            i = zzeuz.zzr();
                            obj = zzesu.zzf(zzest, this.zza, i);
                        } else if (zzc4 == 26) {
                            if (obj != null) {
                                zzesu.zzg(zzeuz, obj, zzest, zzc2);
                            } else {
                                zzesf = zzeuz.zzq();
                            }
                        } else if (!zzeuz.zzd()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzevt.zzl(t, zzk);
                        throw th;
                    }
                }
                if (zzeuz.zzc() != 12) {
                    throw zzett.zzf();
                } else if (zzesf != null) {
                    if (obj != null) {
                        zzesu.zzh(zzesf, obj, zzest, zzc2);
                    } else {
                        zzevt.zze(zzk, i, zzesf);
                    }
                }
            }
        }
        zzevt.zzl(t, zzk);
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzers zzers) throws IOException {
        zzeth zzeth = (zzeth) t;
        if (zzeth.zzc == zzevu.zza()) {
            zzeth.zzc = zzevu.zzb();
        }
        zzete zzete = (zzete) t;
        throw null;
    }

    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzn(T t, zzesp zzesp) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
