package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzsr {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzsq> priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        if (length < 6) {
            zzb(i, zze(strArr2, 0, length), zzc(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzb(i, zze, zzc(strArr2, 0, 6), 6, priorityQueue);
        long zzd = zzd(16785407, 5);
        int i3 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i3 < length2 - 5) {
                zze = ((((((zze + 1073807359) - ((((((long) zzsn.zza(strArr2[i3 - 1])) + 2147483647L) % 1073807359) * zzd) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzsn.zza(strArr2[i3 + 5])) + 2147483647L) % 1073807359)) % 1073807359;
                zzb(i, zze, zzc(strArr2, i3, 6), length2, priorityQueue);
                i3++;
            } else {
                return;
            }
        }
    }

    static void zzb(int i, long j, String str, int i2, PriorityQueue<zzsq> priorityQueue) {
        zzsq zzsq = new zzsq(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzc <= zzsq.zzc && priorityQueue.peek().zza <= zzsq.zza)) && !priorityQueue.contains(zzsq)) {
            priorityQueue.add(zzsq);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    static String zzc(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzbbk.zzf("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    static long zzd(long j, int i) {
        if (i == 1) {
            return j;
        }
        return ((i & 1) == 0 ? zzd((j * j) % 1073807359, i >> 1) : j * (zzd((j * j) % 1073807359, i >> 1) % 1073807359)) % 1073807359;
    }

    private static long zze(String[] strArr, int i, int i2) {
        long zza = (((long) zzsn.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zza = (((zza * 16785407) % 1073807359) + ((((long) zzsn.zza(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
