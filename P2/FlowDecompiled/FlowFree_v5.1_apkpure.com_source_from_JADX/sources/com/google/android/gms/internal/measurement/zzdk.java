package com.google.android.gms.internal.measurement;

import com.mopub.common.Constants;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdk extends zzhr<zzdk, zzdj> implements zzix {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzdk zzaa;
    private String zzA = "";
    private long zzB;
    private int zzC;
    private String zzD = "";
    private String zzE = "";
    private boolean zzF;
    /* access modifiers changed from: private */
    public zzhy<zzcy> zzG = zzhr.zzbE();
    private String zzH = "";
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL = "";
    private long zzM;
    private long zzN;
    private String zzO = "";
    private String zzP = "";
    private int zzQ;
    private String zzR = "";
    private zzdp zzS;
    private zzhw zzT = zzhr.zzbB();
    private long zzU;
    private long zzV;
    private String zzW = "";
    private String zzX = "";
    private int zzY;
    private boolean zzZ;
    private int zze;
    private int zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public zzhy<zzdc> zzh = zzhr.zzbE();
    private zzhy<zzdv> zzi = zzhr.zzbE();
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private int zzs;
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private long zzw;
    private long zzx;
    private String zzy = "";
    private boolean zzz;

    static {
        zzdk zzdk = new zzdk();
        zzaa = zzdk;
        zzhr.zzby(zzdk.class, zzdk);
    }

    private zzdk() {
    }

    static /* synthetic */ void zzaA(zzdk zzdk, long j) {
        zzdk.zze |= 32;
        zzdk.zzn = j;
    }

    static /* synthetic */ void zzaB(zzdk zzdk) {
        zzdk.zze &= -33;
        zzdk.zzn = 0;
    }

    static /* synthetic */ void zzaC(zzdk zzdk, String str) {
        zzdk.zze |= 64;
        zzdk.zzo = Constants.ANDROID_PLATFORM;
    }

    static /* synthetic */ void zzaD(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 128;
        zzdk.zzp = str;
    }

    static /* synthetic */ void zzaE(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 256;
        zzdk.zzq = str;
    }

    static /* synthetic */ void zzaF(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 512;
        zzdk.zzr = str;
    }

    static /* synthetic */ void zzaG(zzdk zzdk, int i) {
        zzdk.zze |= 1024;
        zzdk.zzs = i;
    }

    static /* synthetic */ void zzaH(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 2048;
        zzdk.zzt = str;
    }

    static /* synthetic */ void zzaI(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 4096;
        zzdk.zzu = str;
    }

    static /* synthetic */ void zzaJ(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 8192;
        zzdk.zzv = str;
    }

    static /* synthetic */ void zzaK(zzdk zzdk, long j) {
        zzdk.zze |= 16384;
        zzdk.zzw = j;
    }

    static /* synthetic */ void zzaL(zzdk zzdk, long j) {
        zzdk.zze |= 32768;
        zzdk.zzx = 39065;
    }

    static /* synthetic */ void zzaM(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 65536;
        zzdk.zzy = str;
    }

    static /* synthetic */ void zzaN(zzdk zzdk) {
        zzdk.zze &= -65537;
        zzdk.zzy = zzaa.zzy;
    }

    static /* synthetic */ void zzaO(zzdk zzdk, boolean z) {
        zzdk.zze |= 131072;
        zzdk.zzz = z;
    }

    static /* synthetic */ void zzaP(zzdk zzdk) {
        zzdk.zze &= -131073;
        zzdk.zzz = false;
    }

    static /* synthetic */ void zzaQ(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 262144;
        zzdk.zzA = str;
    }

    static /* synthetic */ void zzaR(zzdk zzdk) {
        zzdk.zze &= -262145;
        zzdk.zzA = zzaa.zzA;
    }

    static /* synthetic */ void zzaS(zzdk zzdk, long j) {
        zzdk.zze |= 524288;
        zzdk.zzB = j;
    }

    static /* synthetic */ void zzaT(zzdk zzdk, int i) {
        zzdk.zze |= 1048576;
        zzdk.zzC = i;
    }

    static /* synthetic */ void zzaU(zzdk zzdk, String str) {
        zzdk.zze |= 2097152;
        zzdk.zzD = str;
    }

    static /* synthetic */ void zzaV(zzdk zzdk) {
        zzdk.zze &= -2097153;
        zzdk.zzD = zzaa.zzD;
    }

    static /* synthetic */ void zzaW(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 4194304;
        zzdk.zzE = str;
    }

    static /* synthetic */ void zzaX(zzdk zzdk, boolean z) {
        zzdk.zze |= 8388608;
        zzdk.zzF = z;
    }

    static /* synthetic */ void zzaY(zzdk zzdk, Iterable iterable) {
        zzhy<zzcy> zzhy = zzdk.zzG;
        if (!zzhy.zza()) {
            zzdk.zzG = zzhr.zzbF(zzhy);
        }
        zzgc.zzbs(iterable, zzdk.zzG);
    }

    public static zzdj zzaj() {
        return (zzdj) zzaa.zzbt();
    }

    static /* synthetic */ void zzal(zzdk zzdk, int i) {
        zzdk.zze |= 1;
        zzdk.zzg = 1;
    }

    static /* synthetic */ void zzam(zzdk zzdk, int i, zzdc zzdc) {
        zzdc.getClass();
        zzdk.zzbI();
        zzdk.zzh.set(i, zzdc);
    }

    static /* synthetic */ void zzan(zzdk zzdk, zzdc zzdc) {
        zzdc.getClass();
        zzdk.zzbI();
        zzdk.zzh.add(zzdc);
    }

    static /* synthetic */ void zzao(zzdk zzdk, Iterable iterable) {
        zzdk.zzbI();
        zzgc.zzbs(iterable, zzdk.zzh);
    }

    static /* synthetic */ void zzaq(zzdk zzdk, int i) {
        zzdk.zzbI();
        zzdk.zzh.remove(i);
    }

    static /* synthetic */ void zzar(zzdk zzdk, int i, zzdv zzdv) {
        zzdv.getClass();
        zzdk.zzbJ();
        zzdk.zzi.set(i, zzdv);
    }

    static /* synthetic */ void zzas(zzdk zzdk, zzdv zzdv) {
        zzdv.getClass();
        zzdk.zzbJ();
        zzdk.zzi.add(zzdv);
    }

    static /* synthetic */ void zzau(zzdk zzdk, int i) {
        zzdk.zzbJ();
        zzdk.zzi.remove(i);
    }

    static /* synthetic */ void zzav(zzdk zzdk, long j) {
        zzdk.zze |= 2;
        zzdk.zzj = j;
    }

    static /* synthetic */ void zzaw(zzdk zzdk, long j) {
        zzdk.zze |= 4;
        zzdk.zzk = j;
    }

    static /* synthetic */ void zzax(zzdk zzdk, long j) {
        zzdk.zze |= 8;
        zzdk.zzl = j;
    }

    static /* synthetic */ void zzay(zzdk zzdk, long j) {
        zzdk.zze |= 16;
        zzdk.zzm = j;
    }

    static /* synthetic */ void zzaz(zzdk zzdk) {
        zzdk.zze &= -17;
        zzdk.zzm = 0;
    }

    private final void zzbI() {
        zzhy<zzdc> zzhy = this.zzh;
        if (!zzhy.zza()) {
            this.zzh = zzhr.zzbF(zzhy);
        }
    }

    private final void zzbJ() {
        zzhy<zzdv> zzhy = this.zzi;
        if (!zzhy.zza()) {
            this.zzi = zzhr.zzbF(zzhy);
        }
    }

    static /* synthetic */ void zzba(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zze |= 16777216;
        zzdk.zzH = str;
    }

    static /* synthetic */ void zzbb(zzdk zzdk, int i) {
        zzdk.zze |= 33554432;
        zzdk.zzI = i;
    }

    static /* synthetic */ void zzbc(zzdk zzdk) {
        zzdk.zze &= -268435457;
        zzdk.zzL = zzaa.zzL;
    }

    static /* synthetic */ void zzbd(zzdk zzdk, long j) {
        zzdk.zze |= 536870912;
        zzdk.zzM = j;
    }

    static /* synthetic */ void zzbe(zzdk zzdk, long j) {
        zzdk.zze |= 1073741824;
        zzdk.zzN = j;
    }

    static /* synthetic */ void zzbf(zzdk zzdk) {
        zzdk.zze &= Integer.MAX_VALUE;
        zzdk.zzO = zzaa.zzO;
    }

    static /* synthetic */ void zzbg(zzdk zzdk, int i) {
        zzdk.zzf |= 2;
        zzdk.zzQ = i;
    }

    static /* synthetic */ void zzbh(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zzf |= 4;
        zzdk.zzR = str;
    }

    static /* synthetic */ void zzbj(zzdk zzdk, Iterable iterable) {
        zzhw zzhw = zzdk.zzT;
        if (!zzhw.zza()) {
            int size = zzhw.size();
            zzdk.zzT = zzhw.zzf(size == 0 ? 10 : size + size);
        }
        zzgc.zzbs(iterable, zzdk.zzT);
    }

    static /* synthetic */ void zzbk(zzdk zzdk, long j) {
        zzdk.zzf |= 16;
        zzdk.zzU = j;
    }

    static /* synthetic */ void zzbl(zzdk zzdk, long j) {
        zzdk.zzf |= 32;
        zzdk.zzV = j;
    }

    static /* synthetic */ void zzbm(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zzf |= 64;
        zzdk.zzW = str;
    }

    static /* synthetic */ void zzbn(zzdk zzdk, String str) {
        str.getClass();
        zzdk.zzf |= 128;
        zzdk.zzX = str;
    }

    public final String zzA() {
        return this.zzu;
    }

    public final String zzB() {
        return this.zzv;
    }

    public final boolean zzC() {
        return (this.zze & 16384) != 0;
    }

    public final long zzD() {
        return this.zzw;
    }

    public final boolean zzE() {
        return (this.zze & 32768) != 0;
    }

    public final long zzF() {
        return this.zzx;
    }

    public final String zzG() {
        return this.zzy;
    }

    public final boolean zzH() {
        return (this.zze & 131072) != 0;
    }

    public final boolean zzI() {
        return this.zzz;
    }

    public final String zzJ() {
        return this.zzA;
    }

    public final boolean zzK() {
        return (this.zze & 524288) != 0;
    }

    public final long zzL() {
        return this.zzB;
    }

    public final boolean zzM() {
        return (this.zze & 1048576) != 0;
    }

    public final int zzN() {
        return this.zzC;
    }

    public final String zzO() {
        return this.zzD;
    }

    public final String zzP() {
        return this.zzE;
    }

    public final boolean zzQ() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean zzR() {
        return this.zzF;
    }

    public final List<zzcy> zzS() {
        return this.zzG;
    }

    public final String zzT() {
        return this.zzH;
    }

    public final boolean zzU() {
        return (this.zze & 33554432) != 0;
    }

    public final int zzV() {
        return this.zzI;
    }

    public final boolean zzW() {
        return (this.zze & 536870912) != 0;
    }

    public final long zzX() {
        return this.zzM;
    }

    public final boolean zzY() {
        return (this.zze & 1073741824) != 0;
    }

    public final long zzZ() {
        return this.zzN;
    }

    public final boolean zza() {
        return (this.zze & 1) != 0;
    }

    public final String zzaa() {
        return this.zzO;
    }

    public final boolean zzab() {
        return (this.zzf & 2) != 0;
    }

    public final int zzac() {
        return this.zzQ;
    }

    public final String zzad() {
        return this.zzR;
    }

    public final boolean zzae() {
        return (this.zzf & 16) != 0;
    }

    public final long zzaf() {
        return this.zzU;
    }

    public final String zzag() {
        return this.zzW;
    }

    public final boolean zzah() {
        return (this.zzf & 128) != 0;
    }

    public final String zzai() {
        return this.zzX;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final List<zzdc> zzc() {
        return this.zzh;
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final zzdc zze(int i) {
        return this.zzh.get(i);
    }

    public final List<zzdv> zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final zzdv zzh(int i) {
        return this.zzi.get(i);
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final long zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zze & 4) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzaa, "\u0001.\u0000\u0002\u00017.\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)", new Object[]{"zze", "zzf", "zzg", "zzh", zzdc.class, "zzi", zzdv.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzcy.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", zzcw.zzb(), "zzZ"});
        } else if (i2 == 3) {
            return new zzdk();
        } else {
            if (i2 == 4) {
                return new zzdj((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzaa;
        }
    }

    public final long zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return (this.zze & 8) != 0;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        return (this.zze & 16) != 0;
    }

    public final long zzq() {
        return this.zzm;
    }

    public final boolean zzr() {
        return (this.zze & 32) != 0;
    }

    public final long zzs() {
        return this.zzn;
    }

    public final String zzt() {
        return this.zzo;
    }

    public final String zzu() {
        return this.zzp;
    }

    public final String zzv() {
        return this.zzq;
    }

    public final String zzw() {
        return this.zzr;
    }

    public final boolean zzx() {
        return (this.zze & 1024) != 0;
    }

    public final int zzy() {
        return this.zzs;
    }

    public final String zzz() {
        return this.zzt;
    }
}
