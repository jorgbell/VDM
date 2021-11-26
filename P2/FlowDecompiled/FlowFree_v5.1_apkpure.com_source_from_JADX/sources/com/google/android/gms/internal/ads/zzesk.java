package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzesk implements zzeuz {
    private final zzesj zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzesk(zzesj zzesj) {
        zzetr.zzb(zzesj, "input");
        this.zza = zzesj;
        zzesj.zzb = this;
    }

    private final void zzP(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzett.zzg();
        }
    }

    private final <T> T zzQ(zzevf<T> zzevf, zzest zzest) throws IOException {
        int zzo = this.zza.zzo();
        zzesj zzesj = this.zza;
        if (zzesj.zza < 100) {
            int zzz = zzesj.zzz(zzo);
            T zza2 = zzevf.zza();
            this.zza.zza++;
            zzevf.zzf(zza2, this, zzest);
            zzevf.zzj(zza2);
            this.zza.zzb(0);
            zzesj zzesj2 = this.zza;
            zzesj2.zza--;
            zzesj2.zzA(zzz);
            return zza2;
        }
        throw new zzett("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzR(zzevf<T> zzevf, zzest zzest) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzevf.zza();
            zzevf.zzf(zza2, this, zzest);
            zzevf.zzj(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzett.zzi();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzS(int i) throws IOException {
        if (this.zza.zzC() != i) {
            throw zzett.zzb();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzett.zzi();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzett.zzi();
        }
    }

    public static zzesk zza(zzesj zzesj) {
        zzesk zzesk = zzesj.zzb;
        return zzesk != null ? zzesk : new zzesk(zzesj);
    }

    public final void zzA(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeud.zzg(this.zza.zzg());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeud.zzg(this.zza.zzg());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeti.zzh(this.zza.zzh());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeti.zzh(this.zza.zzh());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzC(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzeud.zzg(this.zza.zzi());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzeud.zzg(this.zza.zzi());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzi()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Long.valueOf(this.zza.zzi()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzD(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzeti.zzh(this.zza.zzj());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzeti.zzh(this.zza.zzj());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzE(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeru) {
            zzeru zzeru = (zzeru) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeru.zzd(this.zza.zzk());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeru.zzd(this.zza.zzk());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzk()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Boolean.valueOf(this.zza.zzk()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final <T> void zzG(List<T> list, zzevf<T> zzevf, zzest zzest) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzQ(zzevf, zzest));
                if (!this.zza.zzB() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzett.zzg();
    }

    public final <T> void zzH(List<T> list, zzevf<T> zzevf, zzest zzest) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzR(zzevf, zzest));
                if (!this.zza.zzB() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzett.zzg();
    }

    public final void zzI(List<zzesf> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                if (!this.zza.zzB()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzett.zzg();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeti.zzh(this.zza.zzo());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeti.zzh(this.zza.zzo());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzK(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeti.zzh(this.zza.zzp());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeti.zzh(this.zza.zzp());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzp()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzp()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzeti.zzh(this.zza.zzq());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzeti.zzh(this.zza.zzq());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzeud.zzg(this.zza.zzr());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzeud.zzg(this.zza.zzr());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzN(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeti.zzh(this.zza.zzs());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeti.zzh(this.zza.zzs());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzs()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Integer.valueOf(this.zza.zzs()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzO(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeud.zzg(this.zza.zzt());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeud.zzg(this.zza.zzt());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        if (this.zza.zzB() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    public final double zze() throws IOException {
        zzP(1);
        return this.zza.zzd();
    }

    public final float zzf() throws IOException {
        zzP(5);
        return this.zza.zze();
    }

    public final long zzg() throws IOException {
        zzP(0);
        return this.zza.zzf();
    }

    public final long zzh() throws IOException {
        zzP(0);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzP(0);
        return this.zza.zzh();
    }

    public final long zzj() throws IOException {
        zzP(1);
        return this.zza.zzi();
    }

    public final int zzk() throws IOException {
        zzP(5);
        return this.zza.zzj();
    }

    public final boolean zzl() throws IOException {
        zzP(0);
        return this.zza.zzk();
    }

    public final String zzm() throws IOException {
        zzP(2);
        return this.zza.zzl();
    }

    public final String zzn() throws IOException {
        zzP(2);
        return this.zza.zzm();
    }

    public final <T> T zzo(zzevf<T> zzevf, zzest zzest) throws IOException {
        zzP(2);
        return zzQ(zzevf, zzest);
    }

    public final <T> T zzp(zzevf<T> zzevf, zzest zzest) throws IOException {
        zzP(3);
        return zzR(zzevf, zzest);
    }

    public final zzesf zzq() throws IOException {
        zzP(2);
        return this.zza.zzn();
    }

    public final int zzr() throws IOException {
        zzP(0);
        return this.zza.zzo();
    }

    public final int zzs() throws IOException {
        zzP(0);
        return this.zza.zzp();
    }

    public final int zzt() throws IOException {
        zzP(5);
        return this.zza.zzq();
    }

    public final long zzu() throws IOException {
        zzP(1);
        return this.zza.zzr();
    }

    public final int zzv() throws IOException {
        zzP(0);
        return this.zza.zzs();
    }

    public final long zzw() throws IOException {
        zzP(0);
        return this.zza.zzt();
    }

    public final void zzx(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzesq) {
            zzesq zzesq = (zzesq) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzesq.zzd(this.zza.zzd());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzo = this.zza.zzo();
                zzU(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzesq.zzd(this.zza.zzd());
                } while (this.zza.zzC() < zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzd()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzU(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Double.valueOf(this.zza.zzd()));
                } while (this.zza.zzC() < zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzy(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeta) {
            zzeta zzeta = (zzeta) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzo = this.zza.zzo();
                zzT(zzo);
                int zzC = this.zza.zzC() + zzo;
                do {
                    zzeta.zzd(this.zza.zze());
                } while (this.zza.zzC() < zzC);
            } else if (i == 5) {
                do {
                    zzeta.zzd(this.zza.zze());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzo2 = this.zza.zzo();
                zzT(zzo2);
                int zzC2 = this.zza.zzC() + zzo2;
                do {
                    list.add(Float.valueOf(this.zza.zze()));
                } while (this.zza.zzC() < zzC2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zze()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzeud.zzg(this.zza.zzf());
                    if (!this.zza.zzB()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzC = this.zza.zzC() + this.zza.zzo();
                do {
                    zzeud.zzg(this.zza.zzf());
                } while (this.zza.zzC() < zzC);
                zzS(zzC);
            } else {
                throw zzett.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzf()));
                    if (!this.zza.zzB()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzC2 = this.zza.zzC() + this.zza.zzo();
                do {
                    list.add(Long.valueOf(this.zza.zzf()));
                } while (this.zza.zzC() < zzC2);
                zzS(zzC2);
            } else {
                throw zzett.zzg();
            }
        }
    }

    public final void zzF(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzett.zzg();
        } else if ((list instanceof zzety) && !z) {
            zzety zzety = (zzety) list;
            do {
                zzety.zzf(zzq());
                if (!this.zza.zzB()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        } else {
            do {
                list.add(z ? zzn() : zzm());
                if (!this.zza.zzB()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }
}
