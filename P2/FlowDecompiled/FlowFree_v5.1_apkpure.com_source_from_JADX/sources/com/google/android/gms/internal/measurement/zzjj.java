package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzjj {
    private static final Class<?> zza;
    private static final zzjv<?, ?> zzb = zzab(false);
    private static final zzjv<?, ?> zzc = zzab(true);
    private static final zzjv<?, ?> zzd = new zzjx();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzjv<?, ?> zzA() {
        return zzb;
    }

    public static zzjv<?, ?> zzB() {
        return zzc;
    }

    public static zzjv<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzhh<FT>> void zzE(zzhe<FT> zzhe, T t, T t2) {
        zzhe.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzjv<UT, UB> zzjv, T t, T t2) {
        zzjv.zzc(t, zzjv.zzf(zzjv.zzd(t), zzjv.zzd(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzhv zzhv, UB ub, zzjv<UT, UB> zzjv) {
        if (zzhv == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhv.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzjv);
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
                if (!zzhv.zza(intValue2)) {
                    ub = zzH(i, intValue2, ub, zzjv);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzjv<UT, UB> zzjv) {
        if (ub == null) {
            ub = zzjv.zzb();
        }
        zzjv.zza(ub, i, (long) i2);
        return ub;
    }

    static <T> void zzI(zzir zzir, T t, T t2, long j) {
        zzkf.zzo(t, j, zzir.zzb(zzkf.zzn(t, j), zzkf.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzgz zzgz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzgz zzgz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzgr> list, zzgz zzgz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgz.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzgz zzgz, zzjh zzjh) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgz.zzr(i, list.get(i2), zzjh);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhr.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzgz zzgz, zzjh zzjh) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgz.zzs(i, list.get(i2), zzjh);
            }
        }
    }

    private static zzjv<?, ?> zzab(boolean z) {
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
            return (zzjv) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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
        if (list instanceof zzil) {
            zzil zzil = (zzil) list;
            i = 0;
            while (i2 < size) {
                i += zzgy.zzx(zzil.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgy.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzgy.zzu(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzil) {
            zzil zzil = (zzil) list;
            i = 0;
            while (i2 < size) {
                i += zzgy.zzx(zzil.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgy.zzx(list.get(i2).longValue());
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
        return zzd(list) + (size * zzgy.zzu(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzil) {
            zzil zzil = (zzil) list;
            i = 0;
            while (i2 < size) {
                long zzc2 = zzil.zzc(i2);
                i += zzgy.zzx((zzc2 >> 63) ^ (zzc2 + zzc2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + zzgy.zzx((longValue >> 63) ^ (longValue + longValue));
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
        return zzf(list) + (size * zzgy.zzu(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhs) {
            zzhs zzhs = (zzhs) list;
            i = 0;
            while (i2 < size) {
                i += zzgy.zzv(zzhs.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgy.zzv(list.get(i2).intValue());
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
        return zzh(list) + (size * zzgy.zzu(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhs) {
            zzhs zzhs = (zzhs) list;
            i = 0;
            while (i2 < size) {
                i += zzgy.zzv(zzhs.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgy.zzv(list.get(i2).intValue());
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
        return zzj(list) + (size * zzgy.zzu(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhs) {
            zzhs zzhs = (zzhs) list;
            i = 0;
            while (i2 < size) {
                i += zzgy.zzw(zzhs.zzg(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgy.zzw(list.get(i2).intValue());
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
        return zzl(list) + (size * zzgy.zzu(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhs) {
            zzhs zzhs = (zzhs) list;
            i = 0;
            while (i2 < size) {
                int zzg = zzhs.zzg(i2);
                i += zzgy.zzw((zzg >> 31) ^ (zzg + zzg));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i3 = i + zzgy.zzw((intValue >> 31) ^ (intValue + intValue));
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
        return zzn(list) + (size * zzgy.zzu(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgy.zzw(i << 3) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgy.zzw(i << 3) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgy.zzw(i << 3) + 1);
    }

    static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzgy.zzu(i) * size;
        if (list instanceof zzig) {
            zzig zzig = (zzig) list;
            while (i4 < size) {
                Object zzg = zzig.zzg(i4);
                if (zzg instanceof zzgr) {
                    i3 = zzgy.zzA((zzgr) zzg);
                } else {
                    i3 = zzgy.zzy((String) zzg);
                }
                zzu += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgr) {
                    i2 = zzgy.zzA((zzgr) obj);
                } else {
                    i2 = zzgy.zzy((String) obj);
                }
                zzu += i2;
                i4++;
            }
        }
        return zzu;
    }

    static int zzw(int i, Object obj, zzjh zzjh) {
        if (!(obj instanceof zzie)) {
            return zzgy.zzw(i << 3) + zzgy.zzB((zziw) obj, zzjh);
        }
        int zzw = zzgy.zzw(i << 3);
        int zza2 = ((zzie) obj).zza();
        return zzw + zzgy.zzw(zza2) + zza2;
    }

    static int zzx(int i, List<?> list, zzjh zzjh) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzgy.zzu(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzie) {
                i2 = zzgy.zzz((zzie) obj);
            } else {
                i2 = zzgy.zzB((zziw) obj, zzjh);
            }
            zzu += i2;
        }
        return zzu;
    }

    static int zzy(int i, List<zzgr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzgy.zzu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzu += zzgy.zzA(list.get(i2));
        }
        return zzu;
    }

    static int zzz(int i, List<zziw> list, zzjh zzjh) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgy.zzE(i, list.get(i3), zzjh);
        }
        return i2;
    }
}
