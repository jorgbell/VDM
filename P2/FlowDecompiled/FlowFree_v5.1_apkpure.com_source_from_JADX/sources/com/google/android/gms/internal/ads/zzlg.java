package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.io.IOException;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzlg {
    private final byte[] zza = new byte[8];
    private final Stack<zzlf> zzb = new Stack<>();
    private final zzlm zzc = new zzlm();
    private int zzd;
    private int zze;
    private long zzf;
    private zzli zzg;

    zzlg() {
    }

    private final long zzd(zzkt zzkt, int i) throws IOException, InterruptedException {
        zzkt.zzb(this.zza, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zza[i2] & Constants.UNKNOWN));
        }
        return j;
    }

    public final void zza() {
        this.zzd = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    public final void zzb(zzli zzli) {
        this.zzg = zzli;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r0 == 1) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzkt r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            com.google.android.gms.internal.ads.zzpu.zzd(r0)
        L_0x000c:
            java.util.Stack<com.google.android.gms.internal.ads.zzlf> r0 = r11.zzb
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x003d
            long r3 = r12.zzh()
            java.util.Stack<com.google.android.gms.internal.ads.zzlf> r0 = r11.zzb
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzlf r0 = (com.google.android.gms.internal.ads.zzlf) r0
            long r5 = r0.zzb
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0029
            goto L_0x003d
        L_0x0029:
            com.google.android.gms.internal.ads.zzli r12 = r11.zzg
            java.util.Stack<com.google.android.gms.internal.ads.zzlf> r0 = r11.zzb
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzlf r0 = (com.google.android.gms.internal.ads.zzlf) r0
            int r0 = r0.zza
            com.google.android.gms.internal.ads.zzlk r12 = r12.zza
            r12.zzb(r0)
            return r1
        L_0x003d:
            int r0 = r11.zzd
            r3 = 2
            r4 = 4
            if (r0 != 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzlm r0 = r11.zzc
            long r5 = r0.zze(r12, r1, r2, r4)
            r7 = -2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x007e
            r12.zzg()
        L_0x0052:
            byte[] r0 = r11.zza
            r12.zze(r0, r2, r4, r2)
            byte[] r0 = r11.zza
            byte r0 = r0[r2]
            int r0 = com.google.android.gms.internal.ads.zzlm.zzc(r0)
            r5 = -1
            if (r0 == r5) goto L_0x007a
            if (r0 > r4) goto L_0x007a
            byte[] r5 = r11.zza
            long r5 = com.google.android.gms.internal.ads.zzlm.zzd(r5, r0, r2)
            int r6 = (int) r5
            com.google.android.gms.internal.ads.zzli r5 = r11.zzg
            com.google.android.gms.internal.ads.zzlk r5 = r5.zza
            boolean r5 = com.google.android.gms.internal.ads.zzlk.zzm(r6)
            if (r5 == 0) goto L_0x007a
            r12.zzd(r0, r2)
            long r5 = (long) r6
            goto L_0x007e
        L_0x007a:
            r12.zzd(r1, r2)
            goto L_0x0052
        L_0x007e:
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0085
            return r2
        L_0x0085:
            int r0 = (int) r5
            r11.zze = r0
            r11.zzd = r1
            goto L_0x008d
        L_0x008b:
            if (r0 != r1) goto L_0x0099
        L_0x008d:
            com.google.android.gms.internal.ads.zzlm r0 = r11.zzc
            r5 = 8
            long r5 = r0.zze(r12, r2, r1, r5)
            r11.zzf = r5
            r11.zzd = r3
        L_0x0099:
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            int r5 = r11.zze
            com.google.android.gms.internal.ads.zzlk r0 = r0.zza
            int r0 = com.google.android.gms.internal.ads.zzlk.zzl(r5)
            if (r0 == 0) goto L_0x0193
            if (r0 == r1) goto L_0x0171
            r5 = 8
            if (r0 == r3) goto L_0x0141
            r3 = 3
            if (r0 == r3) goto L_0x0103
            if (r0 == r4) goto L_0x00f4
            long r7 = r11.zzf
            r9 = 4
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x00d6
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00bd
            goto L_0x00d6
        L_0x00bd:
            com.google.android.gms.internal.ads.zziw r12 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 40
            r0.<init>(r1)
            java.lang.String r1 = "Invalid float size: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        L_0x00d6:
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            int r3 = r11.zze
            int r5 = (int) r7
            long r6 = r11.zzd(r12, r5)
            if (r5 != r4) goto L_0x00e8
            int r12 = (int) r6
            float r12 = java.lang.Float.intBitsToFloat(r12)
            double r4 = (double) r12
            goto L_0x00ec
        L_0x00e8:
            double r4 = java.lang.Double.longBitsToDouble(r6)
        L_0x00ec:
            com.google.android.gms.internal.ads.zzlk r12 = r0.zza
            r12.zzh(r3, r4)
            r11.zzd = r2
            return r1
        L_0x00f4:
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            int r3 = r11.zze
            long r4 = r11.zzf
            com.google.android.gms.internal.ads.zzlk r0 = r0.zza
            int r5 = (int) r4
            r0.zzk(r3, r5, r12)
            r11.zzd = r2
            return r1
        L_0x0103:
            long r3 = r11.zzf
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            int r5 = r11.zze
            int r4 = (int) r3
            if (r4 != 0) goto L_0x0116
            java.lang.String r12 = ""
            goto L_0x0120
        L_0x0116:
            byte[] r3 = new byte[r4]
            r12.zzb(r3, r2, r4, r2)
            java.lang.String r12 = new java.lang.String
            r12.<init>(r3)
        L_0x0120:
            com.google.android.gms.internal.ads.zzlk r0 = r0.zza
            r0.zzi(r5, r12)
            r11.zzd = r2
            return r1
        L_0x0128:
            com.google.android.gms.internal.ads.zziw r12 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 41
            r0.<init>(r1)
            java.lang.String r1 = "String element size: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        L_0x0141:
            long r3 = r11.zzf
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0158
            com.google.android.gms.internal.ads.zzli r0 = r11.zzg
            int r5 = r11.zze
            int r4 = (int) r3
            long r3 = r11.zzd(r12, r4)
            com.google.android.gms.internal.ads.zzlk r12 = r0.zza
            r12.zzc(r5, r3)
            r11.zzd = r2
            return r1
        L_0x0158:
            com.google.android.gms.internal.ads.zziw r12 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 42
            r0.<init>(r1)
            java.lang.String r1 = "Invalid integer size: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        L_0x0171:
            long r5 = r12.zzh()
            long r3 = r11.zzf
            java.util.Stack<com.google.android.gms.internal.ads.zzlf> r12 = r11.zzb
            com.google.android.gms.internal.ads.zzlf r0 = new com.google.android.gms.internal.ads.zzlf
            int r7 = r11.zze
            long r3 = r3 + r5
            r8 = 0
            r0.<init>(r7, r3, r8)
            r12.add(r0)
            com.google.android.gms.internal.ads.zzli r12 = r11.zzg
            int r4 = r11.zze
            long r7 = r11.zzf
            com.google.android.gms.internal.ads.zzlk r3 = r12.zza
            r3.zza(r4, r5, r7)
            r11.zzd = r2
            return r1
        L_0x0193:
            long r3 = r11.zzf
            int r0 = (int) r3
            r12.zzd(r0, r2)
            r11.zzd = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zzc(com.google.android.gms.internal.ads.zzkt):boolean");
    }
}
