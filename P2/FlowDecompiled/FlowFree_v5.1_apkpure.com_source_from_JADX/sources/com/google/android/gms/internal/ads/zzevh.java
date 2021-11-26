package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevh {
    private static final Class<?> zza;
    private static final zzevt<?, ?> zzb = zzab(false);
    private static final zzevt<?, ?> zzc = zzab(true);
    private static final zzevt<?, ?> zzd = new zzevv();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzevt<?, ?> zzA() {
        return zzb;
    }

    public static zzevt<?, ?> zzB() {
        return zzc;
    }

    public static zzevt<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzesx<FT>> void zzE(zzesu<FT> zzesu, T t, T t2) {
        zzesu.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzevt<UT, UB> zzevt, T t, T t2) {
        zzevt.zzi(t, zzevt.zzo(zzevt.zzj(t), zzevt.zzj(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzetl zzetl, UB ub, zzevt<UT, UB> zzevt) {
        if (zzetl == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzetl.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzevt);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzetl.zza(intValue2)) {
                    ub = zzH(i, intValue2, ub, zzevt);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzevt<UT, UB> zzevt) {
        if (ub == null) {
            ub = zzevt.zzg();
        }
        zzevt.zzb(ub, i, (long) i2);
        return ub;
    }

    static <T> void zzI(zzeuj zzeuj, T t, T t2, long j) {
        zzewd.zzo(t, j, zzeuj.zzc(zzewd.zzn(t, j), zzewd.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzesp zzesp, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzesp zzesp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzesf> list, zzesp zzesp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzesp.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzesp zzesp, zzevf zzevf) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzesp.zzr(i, list.get(i2), zzevf);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzeth.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzesp zzesp, zzevf zzevf) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzesp.zzs(i, list.get(i2), zzevf);
            }
        }
    }

    private static zzevt<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzevt) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            i = 0;
            while (i2 < size) {
                i += zzeso.zzx(zzeud.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzeso.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzeso.zzu(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            i = 0;
            while (i2 < size) {
                i += zzeso.zzx(zzeud.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzeso.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzeso.zzu(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeud) {
            zzeud zzeud = (zzeud) list;
            i = 0;
            while (i2 < size) {
                long zzf = zzeud.zzf(i2);
                i += zzeso.zzx((zzf >> 63) ^ (zzf + zzf));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + zzeso.zzx((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzeso.zzu(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            i = 0;
            while (i2 < size) {
                i += zzeso.zzv(zzeti.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzeso.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzeso.zzu(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            i = 0;
            while (i2 < size) {
                i += zzeso.zzv(zzeti.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzeso.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzeso.zzu(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            i = 0;
            while (i2 < size) {
                i += zzeso.zzw(zzeti.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzeso.zzw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzeso.zzu(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeti) {
            zzeti zzeti = (zzeti) list;
            i = 0;
            while (i2 < size) {
                int zzg = zzeti.zzg(i2);
                i += zzeso.zzw((zzg >> 31) ^ (zzg + zzg));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i3 = i + zzeso.zzw((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzeso.zzu(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzeso.zzw(i << 3) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzeso.zzw(i << 3) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzeso.zzw(i << 3) + 1);
    }

    static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzeso.zzu(i) * size;
        if (list instanceof zzety) {
            zzety zzety = (zzety) list;
            while (i4 < size) {
                Object zzg = zzety.zzg(i4);
                if (zzg instanceof zzesf) {
                    i3 = zzeso.zzA((zzesf) zzg);
                } else {
                    i3 = zzeso.zzy((String) zzg);
                }
                zzu += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzesf) {
                    i2 = zzeso.zzA((zzesf) obj);
                } else {
                    i2 = zzeso.zzy((String) obj);
                }
                zzu += i2;
                i4++;
            }
        }
        return zzu;
    }

    static int zzw(int i, Object obj, zzevf zzevf) {
        if (!(obj instanceof zzetw)) {
            return zzeso.zzw(i << 3) + zzeso.zzB((zzeuo) obj, zzevf);
        }
        int zzw = zzeso.zzw(i << 3);
        int zza2 = ((zzetw) obj).zza();
        return zzw + zzeso.zzw(zza2) + zza2;
    }

    static int zzx(int i, List<?> list, zzevf zzevf) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzeso.zzu(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzetw) {
                i2 = zzeso.zzz((zzetw) obj);
            } else {
                i2 = zzeso.zzB((zzeuo) obj, zzevf);
            }
            zzu += i2;
        }
        return zzu;
    }

    static int zzy(int i, List<zzesf> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzeso.zzu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzu += zzeso.zzA(list.get(i2));
        }
        return zzu;
    }

    static int zzz(int i, List<zzeuo> list, zzevf zzevf) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzeso.zzE(i, list.get(i3), zzevf);
        }
        return i2;
    }
}
