package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzlw {
    private static final int zza = zzqj.zzl("vide");
    private static final int zzb = zzqj.zzl("soun");
    private static final int zzc = zzqj.zzl("text");
    private static final int zzd = zzqj.zzl("sbtl");
    private static final int zze = zzqj.zzl("subt");
    private static final int zzf = zzqj.zzl("clcp");
    private static final int zzg = zzqj.zzl("cenc");
    private static final int zzh = zzqj.zzl("meta");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v11, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x056a: MOVE  (r6v19 java.lang.String) = (r45v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x07e6  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0838  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0841 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0842  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c3  */
    public static com.google.android.gms.internal.ads.zzmh zza(com.google.android.gms.internal.ads.zzln r51, com.google.android.gms.internal.ads.zzlo r52, long r53, com.google.android.gms.internal.ads.zzkq r55, boolean r56) throws com.google.android.gms.internal.ads.zziw {
        /*
            r0 = r51
            r15 = r55
            int r1 = com.google.android.gms.internal.ads.zzlp.zzH
            com.google.android.gms.internal.ads.zzln r1 = r0.zzd(r1)
            int r2 = com.google.android.gms.internal.ads.zzlp.zzV
            com.google.android.gms.internal.ads.zzlo r2 = r1.zzc(r2)
            com.google.android.gms.internal.ads.zzqc r2 = r2.zza
            r14 = 16
            r2.zzi(r14)
            int r2 = r2.zzr()
            int r3 = zzb
            r4 = 4
            r12 = 3
            r11 = -1
            if (r2 != r3) goto L_0x0024
            r10 = 1
            goto L_0x0044
        L_0x0024:
            int r3 = zza
            if (r2 != r3) goto L_0x002a
            r10 = 2
            goto L_0x0044
        L_0x002a:
            int r3 = zzc
            if (r2 == r3) goto L_0x0043
            int r3 = zzd
            if (r2 == r3) goto L_0x0043
            int r3 = zze
            if (r2 == r3) goto L_0x0043
            int r3 = zzf
            if (r2 != r3) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            int r3 = zzh
            if (r2 != r3) goto L_0x0041
            r10 = 4
            goto L_0x0044
        L_0x0041:
            r10 = -1
            goto L_0x0044
        L_0x0043:
            r10 = 3
        L_0x0044:
            r8 = 0
            if (r10 != r11) goto L_0x0048
            return r8
        L_0x0048:
            int r2 = com.google.android.gms.internal.ads.zzlp.zzR
            com.google.android.gms.internal.ads.zzlo r2 = r0.zzc(r2)
            com.google.android.gms.internal.ads.zzqc r2 = r2.zza
            r7 = 8
            r2.zzi(r7)
            int r3 = r2.zzr()
            int r3 = com.google.android.gms.internal.ads.zzlp.zze(r3)
            if (r3 != 0) goto L_0x0062
            r5 = 8
            goto L_0x0064
        L_0x0062:
            r5 = 16
        L_0x0064:
            r2.zzj(r5)
            int r5 = r2.zzr()
            r2.zzj(r4)
            int r6 = r2.zzg()
            if (r3 != 0) goto L_0x0076
            r13 = 4
            goto L_0x0078
        L_0x0076:
            r13 = 8
        L_0x0078:
            r9 = 0
        L_0x0079:
            r19 = 0
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 >= r13) goto L_0x009e
            byte[] r8 = r2.zza
            int r24 = r6 + r9
            byte r8 = r8[r24]
            if (r8 == r11) goto L_0x009a
            if (r3 != 0) goto L_0x0091
            long r8 = r2.zzp()
            goto L_0x0095
        L_0x0091:
            long r8 = r2.zzv()
        L_0x0095:
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x00a3
            goto L_0x00a1
        L_0x009a:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0079
        L_0x009e:
            r2.zzj(r13)
        L_0x00a1:
            r8 = r21
        L_0x00a3:
            r2.zzj(r14)
            int r3 = r2.zzr()
            int r6 = r2.zzr()
            r2.zzj(r4)
            int r13 = r2.zzr()
            int r2 = r2.zzr()
            r4 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00d3
            if (r6 != r4) goto L_0x00d2
            if (r13 != r14) goto L_0x00ce
            if (r2 != 0) goto L_0x00c8
            r2 = 90
            goto L_0x00f3
        L_0x00c8:
            r3 = 0
            r6 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00d3
        L_0x00ce:
            r3 = 0
            r6 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00d3
        L_0x00d2:
            r3 = 0
        L_0x00d3:
            if (r3 != 0) goto L_0x00e6
            if (r6 != r14) goto L_0x00e3
            if (r13 != r4) goto L_0x00de
            if (r2 != 0) goto L_0x00df
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00f3
        L_0x00de:
            r4 = r13
        L_0x00df:
            r3 = 0
            r6 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00e7
        L_0x00e3:
            r4 = r13
            r3 = 0
            goto L_0x00e7
        L_0x00e6:
            r4 = r13
        L_0x00e7:
            if (r3 != r14) goto L_0x00f2
            if (r6 != 0) goto L_0x00f2
            if (r4 != 0) goto L_0x00f2
            if (r2 != r14) goto L_0x00f2
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00f3
        L_0x00f2:
            r2 = 0
        L_0x00f3:
            com.google.android.gms.internal.ads.zzlv r14 = new com.google.android.gms.internal.ads.zzlv
            r14.<init>(r5, r8, r2)
            int r2 = (r53 > r21 ? 1 : (r53 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x0105
            long r2 = r14.zzb
            r26 = r2
            r2 = r52
            goto L_0x0109
        L_0x0105:
            r2 = r52
            r26 = r53
        L_0x0109:
            com.google.android.gms.internal.ads.zzqc r2 = r2.zza
            r2.zzi(r7)
            int r3 = r2.zzr()
            int r3 = com.google.android.gms.internal.ads.zzlp.zze(r3)
            if (r3 != 0) goto L_0x011b
            r3 = 8
            goto L_0x011d
        L_0x011b:
            r3 = 16
        L_0x011d:
            r2.zzj(r3)
            long r32 = r2.zzp()
            int r2 = (r26 > r21 ? 1 : (r26 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x012b
            r26 = r21
            goto L_0x0136
        L_0x012b:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzqj.zzj(r26, r28, r30)
            r26 = r2
        L_0x0136:
            int r2 = com.google.android.gms.internal.ads.zzlp.zzI
            com.google.android.gms.internal.ads.zzln r2 = r1.zzd(r2)
            int r3 = com.google.android.gms.internal.ads.zzlp.zzJ
            com.google.android.gms.internal.ads.zzln r2 = r2.zzd(r3)
            int r3 = com.google.android.gms.internal.ads.zzlp.zzU
            com.google.android.gms.internal.ads.zzlo r1 = r1.zzc(r3)
            com.google.android.gms.internal.ads.zzqc r1 = r1.zza
            r1.zzi(r7)
            int r3 = r1.zzr()
            int r3 = com.google.android.gms.internal.ads.zzlp.zze(r3)
            if (r3 != 0) goto L_0x015a
            r4 = 8
            goto L_0x015c
        L_0x015a:
            r4 = 16
        L_0x015c:
            r1.zzj(r4)
            long r4 = r1.zzp()
            if (r3 != 0) goto L_0x0167
            r3 = 4
            goto L_0x0169
        L_0x0167:
            r3 = 8
        L_0x0169:
            r1.zzj(r3)
            int r1 = r1.zzm()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r12)
            int r6 = r1 >> 10
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            android.util.Pair r13 = android.util.Pair.create(r3, r1)
            int r1 = com.google.android.gms.internal.ads.zzlp.zzW
            com.google.android.gms.internal.ads.zzlo r1 = r2.zzc(r1)
            com.google.android.gms.internal.ads.zzqc r9 = r1.zza
            int r21 = r14.zza
            int r22 = r14.zzc
            java.lang.Object r1 = r13.second
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
            r1 = 12
            r9.zzi(r1)
            int r6 = r9.zzr()
            com.google.android.gms.internal.ads.zzls r5 = new com.google.android.gms.internal.ads.zzls
            r5.<init>(r6)
            r4 = 0
        L_0x01c1:
            if (r4 >= r6) goto L_0x07ca
            int r3 = r9.zzg()
            int r2 = r9.zzr()
            if (r2 <= 0) goto L_0x01cf
            r1 = 1
            goto L_0x01d0
        L_0x01cf:
            r1 = 0
        L_0x01d0:
            java.lang.String r12 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpu.zzb(r1, r12)
            int r1 = r9.zzr()
            int r7 = com.google.android.gms.internal.ads.zzlp.zze
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzf
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzac
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzan
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzg
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzh
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzi
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaM
            if (r1 == r7) goto L_0x05cb
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaN
            if (r1 != r7) goto L_0x01ff
            goto L_0x05cb
        L_0x01ff:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzl
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzad
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzq
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzs
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzu
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzx
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzv
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzw
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaA
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaB
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzo
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzp
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzm
            if (r1 == r7) goto L_0x0310
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaQ
            if (r1 != r7) goto L_0x0239
            goto L_0x0310
        L_0x0239:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzam
            if (r1 == r7) goto L_0x0274
            int r12 = com.google.android.gms.internal.ads.zzlp.zzaw
            if (r1 == r12) goto L_0x0274
            int r12 = com.google.android.gms.internal.ads.zzlp.zzax
            if (r1 == r12) goto L_0x0274
            int r12 = com.google.android.gms.internal.ads.zzlp.zzay
            if (r1 == r12) goto L_0x0274
            int r12 = com.google.android.gms.internal.ads.zzlp.zzaz
            if (r1 != r12) goto L_0x024e
            goto L_0x0274
        L_0x024e:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaP
            if (r1 != r7) goto L_0x025f
            java.lang.String r1 = java.lang.Integer.toString(r21)
            java.lang.String r7 = "application/x-camera-motion"
            r12 = 0
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzit.zzf(r1, r7, r12, r11, r15)
            r5.zzb = r1
        L_0x025f:
            r35 = r2
            r24 = r3
            r36 = r4
            r0 = r5
            r31 = r6
            r34 = r8
            r50 = r9
            r18 = r10
            r47 = r13
            r16 = r14
            goto L_0x0373
        L_0x0274:
            r12 = 0
            int r11 = r3 + 16
            r9.zzi(r11)
            java.lang.String r11 = "application/ttml+xml"
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 != r7) goto L_0x028a
            r7 = r11
            r17 = r12
        L_0x0286:
            r11 = 1
            r18 = 0
            goto L_0x02c2
        L_0x028a:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaw
            if (r1 != r7) goto L_0x029f
            int r1 = r2 + -16
            byte[] r7 = new byte[r1]
            r11 = 0
            r9.zzk(r7, r11, r1)
            java.util.List r1 = java.util.Collections.singletonList(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r17 = r1
            goto L_0x0286
        L_0x029f:
            r18 = 0
            int r7 = com.google.android.gms.internal.ads.zzlp.zzax
            if (r1 != r7) goto L_0x02ac
            java.lang.String r1 = "application/x-mp4-vtt"
            r7 = r1
            r17 = r12
        L_0x02aa:
            r11 = 1
            goto L_0x02c2
        L_0x02ac:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzay
            if (r1 != r7) goto L_0x02b6
            r7 = r11
            r17 = r12
            r29 = r19
            goto L_0x02aa
        L_0x02b6:
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaz
            if (r1 != r7) goto L_0x030a
            r11 = 1
            r5.zzd = r11
            java.lang.String r1 = "application/x-mp4-cea-608"
            r7 = r1
            r17 = r12
        L_0x02c2:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r31 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r52 = r13
            r13 = r2
            r2 = r7
            r7 = r3
            r3 = r31
            r37 = r4
            r4 = r34
            r38 = r5
            r5 = r35
            r31 = r6
            r6 = r8
            r39 = r7
            r7 = r36
            r40 = r8
            r8 = r55
            r41 = r9
            r18 = r10
            r9 = r29
            r0 = 1
            r11 = r17
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzit.zzd(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r38
            r11.zzb = r1
            r47 = r52
            r0 = r11
            r35 = r13
            r16 = r14
            r36 = r37
            r24 = r39
            r34 = r40
            r50 = r41
            goto L_0x0373
        L_0x030a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0310:
            r39 = r3
            r37 = r4
            r11 = r5
            r31 = r6
            r40 = r8
            r41 = r9
            r18 = r10
            r52 = r13
            r0 = 1
            r10 = 0
            r13 = r2
            r9 = r39
            int r3 = r9 + 16
            r8 = r41
            r8.zzi(r3)
            r2 = 6
            if (r56 == 0) goto L_0x0338
            int r3 = r8.zzm()
            r8.zzj(r2)
            r7 = 8
            goto L_0x033e
        L_0x0338:
            r7 = 8
            r8.zzj(r7)
            r3 = 0
        L_0x033e:
            if (r3 == 0) goto L_0x037d
            if (r3 != r0) goto L_0x0343
            goto L_0x037d
        L_0x0343:
            r6 = 2
            if (r3 != r6) goto L_0x0364
            r2 = 16
            r8.zzj(r2)
            long r2 = r8.zzs()
            double r2 = java.lang.Double.longBitsToDouble(r2)
            long r2 = java.lang.Math.round(r2)
            int r3 = (int) r2
            int r2 = r8.zzu()
            r4 = 20
            r8.zzj(r4)
            r5 = 16
            goto L_0x0395
        L_0x0364:
            r47 = r52
            r50 = r8
            r24 = r9
            r0 = r11
            r35 = r13
            r16 = r14
            r36 = r37
            r34 = r40
        L_0x0373:
            r23 = 3
            r25 = 16
            r28 = -1
            r29 = 0
            goto L_0x07ab
        L_0x037d:
            r6 = 2
            int r4 = r8.zzm()
            r8.zzj(r2)
            int r2 = r8.zzt()
            if (r3 != r0) goto L_0x0391
            r5 = 16
            r8.zzj(r5)
            goto L_0x0393
        L_0x0391:
            r5 = 16
        L_0x0393:
            r3 = r2
            r2 = r4
        L_0x0395:
            int r4 = r8.zzg()
            int r5 = com.google.android.gms.internal.ads.zzlp.zzad
            if (r1 != r5) goto L_0x03a7
            r5 = r37
            int r1 = zze(r8, r9, r13, r11, r5)
            r8.zzi(r4)
            goto L_0x03a9
        L_0x03a7:
            r5 = r37
        L_0x03a9:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzq
            java.lang.String r0 = "audio/raw"
            if (r1 != r6) goto L_0x03b2
            java.lang.String r1 = "audio/ac3"
            goto L_0x03fb
        L_0x03b2:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzs
            if (r1 != r6) goto L_0x03b9
            java.lang.String r1 = "audio/eac3"
            goto L_0x03fb
        L_0x03b9:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzu
            if (r1 != r6) goto L_0x03c0
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03fb
        L_0x03c0:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzv
            if (r1 == r6) goto L_0x03f9
            int r6 = com.google.android.gms.internal.ads.zzlp.zzw
            if (r1 != r6) goto L_0x03c9
            goto L_0x03f9
        L_0x03c9:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzx
            if (r1 != r6) goto L_0x03d0
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03fb
        L_0x03d0:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzaA
            if (r1 != r6) goto L_0x03d7
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03fb
        L_0x03d7:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzaB
            if (r1 != r6) goto L_0x03de
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03fb
        L_0x03de:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzo
            if (r1 == r6) goto L_0x03f7
            int r6 = com.google.android.gms.internal.ads.zzlp.zzp
            if (r1 != r6) goto L_0x03e7
            goto L_0x03f7
        L_0x03e7:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzm
            if (r1 != r6) goto L_0x03ee
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03fb
        L_0x03ee:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzaQ
            if (r1 != r6) goto L_0x03f5
            java.lang.String r1 = "audio/alac"
            goto L_0x03fb
        L_0x03f5:
            r1 = r10
            goto L_0x03fb
        L_0x03f7:
            r1 = r0
            goto L_0x03fb
        L_0x03f9:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03fb:
            r6 = r1
            r28 = r2
            r29 = r3
            r30 = r10
        L_0x0402:
            int r1 = r4 - r9
            if (r1 >= r13) goto L_0x0554
            r8.zzi(r4)
            int r3 = r8.zzr()
            if (r3 <= 0) goto L_0x0411
            r1 = 1
            goto L_0x0412
        L_0x0411:
            r1 = 0
        L_0x0412:
            com.google.android.gms.internal.ads.zzpu.zzb(r1, r12)
            int r1 = r8.zzr()
            int r2 = com.google.android.gms.internal.ads.zzlp.zzM
            if (r1 == r2) goto L_0x04d3
            if (r56 == 0) goto L_0x0425
            int r7 = com.google.android.gms.internal.ads.zzlp.zzn
            if (r1 != r7) goto L_0x0425
            goto L_0x04d3
        L_0x0425:
            int r2 = com.google.android.gms.internal.ads.zzlp.zzr
            if (r1 != r2) goto L_0x044d
            int r1 = r4 + 8
            r8.zzi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r7 = r40
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzjf.zza(r8, r1, r7, r15)
            r11.zzb = r1
        L_0x043a:
            r44 = r5
            r45 = r6
            r34 = r7
            r15 = r8
            r46 = r9
            r35 = r13
            r16 = 2
            r25 = 16
            r13 = r11
        L_0x044a:
            r11 = 0
            goto L_0x04ce
        L_0x044d:
            r7 = r40
            int r2 = com.google.android.gms.internal.ads.zzlp.zzt
            if (r1 != r2) goto L_0x0463
            int r1 = r4 + 8
            r8.zzi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzjf.zzb(r8, r1, r7, r15)
            r11.zzb = r1
            goto L_0x043a
        L_0x0463:
            int r2 = com.google.android.gms.internal.ads.zzlp.zzy
            if (r1 != r2) goto L_0x04a7
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r34 = 0
            r35 = -1
            r36 = -1
            r37 = 0
            r38 = 0
            r2 = r6
            r42 = r3
            r3 = r34
            r43 = r4
            r4 = r35
            r44 = r5
            r25 = 16
            r5 = r36
            r45 = r6
            r16 = 2
            r6 = r28
            r34 = r7
            r7 = r29
            r15 = r8
            r8 = r37
            r46 = r9
            r9 = r55
            r10 = r38
            r35 = r13
            r13 = r11
            r11 = r34
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzit.zzb(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.zzb = r1
        L_0x04a2:
            r3 = r42
            r4 = r43
            goto L_0x044a
        L_0x04a7:
            r42 = r3
            r43 = r4
            r44 = r5
            r45 = r6
            r34 = r7
            r15 = r8
            r46 = r9
            r35 = r13
            r16 = 2
            r25 = 16
            r13 = r11
            int r2 = com.google.android.gms.internal.ads.zzlp.zzaQ
            if (r1 != r2) goto L_0x04a2
            r3 = r42
            byte[] r1 = new byte[r3]
            r4 = r43
            r15.zzi(r4)
            r11 = 0
            r15.zzk(r1, r11, r3)
            r30 = r1
        L_0x04ce:
            r6 = r45
            r10 = -1
            goto L_0x0542
        L_0x04d3:
            r44 = r5
            r45 = r6
            r15 = r8
            r46 = r9
            r35 = r13
            r34 = r40
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            if (r1 != r2) goto L_0x04e9
            r1 = r4
        L_0x04e7:
            r10 = -1
            goto L_0x050c
        L_0x04e9:
            int r1 = r15.zzg()
        L_0x04ed:
            int r2 = r1 - r4
            if (r2 >= r3) goto L_0x050a
            r15.zzi(r1)
            int r2 = r15.zzr()
            if (r2 <= 0) goto L_0x04fc
            r9 = 1
            goto L_0x04fd
        L_0x04fc:
            r9 = 0
        L_0x04fd:
            com.google.android.gms.internal.ads.zzpu.zzb(r9, r12)
            int r5 = r15.zzr()
            int r6 = com.google.android.gms.internal.ads.zzlp.zzM
            if (r5 == r6) goto L_0x04e7
            int r1 = r1 + r2
            goto L_0x04ed
        L_0x050a:
            r1 = -1
            goto L_0x04e7
        L_0x050c:
            if (r1 == r10) goto L_0x0540
            android.util.Pair r1 = zzd(r15, r1)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r30 = r1
            byte[] r30 = (byte[]) r30
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x053e
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzpv.zza(r30)
            java.lang.Object r5 = r1.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r28 = r1
            r6 = r2
            r29 = r5
            goto L_0x0542
        L_0x053e:
            r6 = r2
            goto L_0x0542
        L_0x0540:
            r6 = r45
        L_0x0542:
            int r4 = r4 + r3
            r11 = r13
            r8 = r15
            r40 = r34
            r13 = r35
            r5 = r44
            r9 = r46
            r7 = 8
            r10 = 0
            r15 = r55
            goto L_0x0402
        L_0x0554:
            r44 = r5
            r45 = r6
            r15 = r8
            r46 = r9
            r35 = r13
            r34 = r40
            r10 = -1
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            com.google.android.gms.internal.ads.zzit r1 = r13.zzb
            if (r1 != 0) goto L_0x05b8
            r6 = r45
            if (r6 == 0) goto L_0x05b8
            boolean r0 = r0.equals(r6)
            r1 = 1
            if (r1 == r0) goto L_0x0577
            r8 = -1
            goto L_0x0578
        L_0x0577:
            r8 = 2
        L_0x0578:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            if (r30 != 0) goto L_0x0580
            r0 = 0
            goto L_0x0584
        L_0x0580:
            java.util.List r0 = java.util.Collections.singletonList(r30)
        L_0x0584:
            r3 = 0
            r4 = -1
            r5 = -1
            r9 = -1
            r12 = -1
            r23 = 0
            r30 = 0
            r2 = r6
            r6 = r28
            r7 = r29
            r28 = -1
            r10 = r12
            r29 = 0
            r11 = r0
            r0 = 3
            r12 = r55
            r47 = r52
            r0 = r13
            r48 = r35
            r13 = r23
            r16 = r14
            r14 = r34
            r49 = r15
            r15 = r30
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzit.zzc(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            r36 = r44
            r24 = r46
            r50 = r49
            goto L_0x07a7
        L_0x05b8:
            r47 = r52
            r0 = r13
            r16 = r14
            r28 = -1
            r29 = 0
            r50 = r15
            r36 = r44
            r24 = r46
            r23 = 3
            goto L_0x07ab
        L_0x05cb:
            r48 = r2
            r46 = r3
            r44 = r4
            r0 = r5
            r31 = r6
            r34 = r8
            r49 = r9
            r18 = r10
            r47 = r13
            r16 = r14
            r28 = -1
            r29 = 0
            r15 = r46
            int r3 = r15 + 16
            r14 = r49
            r14.zzi(r3)
            r13 = 16
            r14.zzj(r13)
            int r6 = r14.zzm()
            int r7 = r14.zzm()
            r2 = 50
            r14.zzj(r2)
            int r2 = r14.zzg()
            int r3 = com.google.android.gms.internal.ads.zzlp.zzac
            if (r1 != r3) goto L_0x0611
            r11 = r44
            r10 = r48
            int r1 = zze(r14, r15, r10, r0, r11)
            r14.zzi(r2)
            goto L_0x0615
        L_0x0611:
            r11 = r44
            r10 = r48
        L_0x0615:
            r3 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            r4 = 0
            r9 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r25 = 0
            r30 = -1
        L_0x0620:
            int r5 = r2 - r15
            if (r5 >= r10) goto L_0x0769
            r14.zzi(r2)
            int r5 = r14.zzg()
            int r8 = r14.zzr()
            if (r8 != 0) goto L_0x063b
            int r8 = r14.zzg()
            int r8 = r8 - r15
            if (r8 != r10) goto L_0x063a
            goto L_0x0769
        L_0x063a:
            r8 = 0
        L_0x063b:
            if (r8 <= 0) goto L_0x063f
            r13 = 1
            goto L_0x0640
        L_0x063f:
            r13 = 0
        L_0x0640:
            com.google.android.gms.internal.ads.zzpu.zzb(r13, r12)
            int r13 = r14.zzr()
            r48 = r10
            int r10 = com.google.android.gms.internal.ads.zzlp.zzK
            if (r13 != r10) goto L_0x066d
            if (r3 != 0) goto L_0x0651
            r9 = 1
            goto L_0x0652
        L_0x0651:
            r9 = 0
        L_0x0652:
            com.google.android.gms.internal.ads.zzpu.zzd(r9)
            int r5 = r5 + 8
            r14.zzi(r5)
            com.google.android.gms.internal.ads.zzqk r3 = com.google.android.gms.internal.ads.zzqk.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r5 = r3.zzb
            r0.zzc = r5
            if (r4 != 0) goto L_0x066a
            float r3 = r3.zzc
            r23 = r3
        L_0x066a:
            java.lang.String r3 = "video/avc"
            goto L_0x068a
        L_0x066d:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzL
            if (r13 != r10) goto L_0x0690
            if (r3 != 0) goto L_0x0675
            r9 = 1
            goto L_0x0676
        L_0x0675:
            r9 = 0
        L_0x0676:
            com.google.android.gms.internal.ads.zzpu.zzd(r9)
            int r5 = r5 + 8
            r14.zzi(r5)
            com.google.android.gms.internal.ads.zzqq r3 = com.google.android.gms.internal.ads.zzqq.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r3 = r3.zzb
            r0.zzc = r3
            java.lang.String r3 = "video/hevc"
        L_0x068a:
            r35 = r1
        L_0x068c:
            r10 = 2
            r13 = 3
            goto L_0x0760
        L_0x0690:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzaO
            if (r13 != r10) goto L_0x06a6
            if (r3 != 0) goto L_0x0698
            r3 = 1
            goto L_0x0699
        L_0x0698:
            r3 = 0
        L_0x0699:
            com.google.android.gms.internal.ads.zzpu.zzd(r3)
            int r3 = com.google.android.gms.internal.ads.zzlp.zzaM
            if (r1 != r3) goto L_0x06a3
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            goto L_0x068a
        L_0x06a3:
            java.lang.String r3 = "video/x-vnd.on2.vp9"
            goto L_0x068a
        L_0x06a6:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzj
            if (r13 != r10) goto L_0x06b5
            if (r3 != 0) goto L_0x06ae
            r3 = 1
            goto L_0x06af
        L_0x06ae:
            r3 = 0
        L_0x06af:
            com.google.android.gms.internal.ads.zzpu.zzd(r3)
            java.lang.String r3 = "video/3gpp"
            goto L_0x068a
        L_0x06b5:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzM
            if (r13 != r10) goto L_0x06d5
            if (r3 != 0) goto L_0x06bd
            r9 = 1
            goto L_0x06be
        L_0x06bd:
            r9 = 0
        L_0x06be:
            com.google.android.gms.internal.ads.zzpu.zzd(r9)
            android.util.Pair r3 = zzd(r14, r5)
            java.lang.Object r5 = r3.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.second
            byte[] r3 = (byte[]) r3
            java.util.List r9 = java.util.Collections.singletonList(r3)
            r35 = r1
            r3 = r5
            goto L_0x068c
        L_0x06d5:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzal
            if (r13 != r10) goto L_0x06ee
            int r5 = r5 + 8
            r14.zzi(r5)
            int r4 = r14.zzu()
            float r4 = (float) r4
            int r5 = r14.zzu()
            float r5 = (float) r5
            float r23 = r4 / r5
            r35 = r1
            r4 = 1
            goto L_0x068c
        L_0x06ee:
            int r10 = com.google.android.gms.internal.ads.zzlp.zzaK
            if (r13 != r10) goto L_0x0724
            int r10 = r5 + 8
        L_0x06f4:
            int r13 = r10 - r5
            if (r13 >= r8) goto L_0x0719
            r14.zzi(r10)
            int r13 = r14.zzr()
            r35 = r1
            int r1 = r14.zzr()
            r52 = r4
            int r4 = com.google.android.gms.internal.ads.zzlp.zzaL
            if (r1 != r4) goto L_0x0713
            byte[] r1 = r14.zza
            int r13 = r13 + r10
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r10, r13)
            goto L_0x071e
        L_0x0713:
            int r10 = r10 + r13
            r4 = r52
            r1 = r35
            goto L_0x06f4
        L_0x0719:
            r35 = r1
            r52 = r4
            r1 = 0
        L_0x071e:
            r4 = r52
            r25 = r1
            goto L_0x068c
        L_0x0724:
            r35 = r1
            r52 = r4
            int r1 = com.google.android.gms.internal.ads.zzlp.zzaJ
            if (r13 != r1) goto L_0x075c
            int r1 = r14.zzl()
            r13 = 3
            r14.zzj(r13)
            if (r1 != 0) goto L_0x075a
            int r1 = r14.zzl()
            if (r1 == 0) goto L_0x0754
            r4 = 1
            r10 = 2
            if (r1 == r4) goto L_0x074f
            if (r1 == r10) goto L_0x074a
            if (r1 == r13) goto L_0x0745
            goto L_0x075e
        L_0x0745:
            r4 = r52
            r30 = 3
            goto L_0x0760
        L_0x074a:
            r4 = r52
            r30 = 2
            goto L_0x0760
        L_0x074f:
            r4 = r52
            r30 = 1
            goto L_0x0760
        L_0x0754:
            r10 = 2
            r4 = r52
            r30 = 0
            goto L_0x0760
        L_0x075a:
            r10 = 2
            goto L_0x075e
        L_0x075c:
            r10 = 2
            r13 = 3
        L_0x075e:
            r4 = r52
        L_0x0760:
            int r2 = r2 + r8
            r1 = r35
            r10 = r48
            r13 = 16
            goto L_0x0620
        L_0x0769:
            r48 = r10
            r10 = 2
            r13 = 3
            if (r3 == 0) goto L_0x079f
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r4 = 0
            r5 = -1
            r8 = -1
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r8 = r12
            r35 = r48
            r12 = 2
            r10 = r22
            r36 = r11
            r11 = r23
            r12 = r25
            r23 = 3
            r25 = 16
            r13 = r30
            r50 = r14
            r14 = r24
            r24 = r15
            r15 = r55
            com.google.android.gms.internal.ads.zzit r1 = com.google.android.gms.internal.ads.zzit.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            goto L_0x07ab
        L_0x079f:
            r36 = r11
            r50 = r14
            r24 = r15
            r35 = r48
        L_0x07a7:
            r23 = 3
            r25 = 16
        L_0x07ab:
            int r3 = r24 + r35
            r1 = r50
            r1.zzi(r3)
            int r4 = r36 + 1
            r15 = r55
            r5 = r0
            r9 = r1
            r14 = r16
            r10 = r18
            r6 = r31
            r8 = r34
            r13 = r47
            r7 = 8
            r11 = -1
            r12 = 3
            r0 = r51
            goto L_0x01c1
        L_0x07ca:
            r0 = r5
            r18 = r10
            r47 = r13
            r16 = r14
            r29 = 0
            int r1 = com.google.android.gms.internal.ads.zzlp.zzS
            r2 = r51
            com.google.android.gms.internal.ads.zzln r1 = r2.zzd(r1)
            if (r1 == 0) goto L_0x0838
            int r2 = com.google.android.gms.internal.ads.zzlp.zzT
            com.google.android.gms.internal.ads.zzlo r1 = r1.zzc(r2)
            if (r1 != 0) goto L_0x07e6
            goto L_0x0838
        L_0x07e6:
            com.google.android.gms.internal.ads.zzqc r1 = r1.zza
            r2 = 8
            r1.zzi(r2)
            int r2 = r1.zzr()
            int r2 = com.google.android.gms.internal.ads.zzlp.zze(r2)
            int r3 = r1.zzu()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r9 = 0
        L_0x07fe:
            if (r9 >= r3) goto L_0x0831
            r6 = 1
            if (r2 != r6) goto L_0x0808
            long r7 = r1.zzv()
            goto L_0x080c
        L_0x0808:
            long r7 = r1.zzp()
        L_0x080c:
            r4[r9] = r7
            if (r2 != r6) goto L_0x0815
            long r7 = r1.zzs()
            goto L_0x081a
        L_0x0815:
            int r7 = r1.zzr()
            long r7 = (long) r7
        L_0x081a:
            r5[r9] = r7
            short r7 = r1.zzo()
            if (r7 != r6) goto L_0x0829
            r7 = 2
            r1.zzj(r7)
            int r9 = r9 + 1
            goto L_0x07fe
        L_0x0829:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0831:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x083d
        L_0x0838:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x083d:
            com.google.android.gms.internal.ads.zzit r3 = r0.zzb
            if (r3 != 0) goto L_0x0842
            return r1
        L_0x0842:
            com.google.android.gms.internal.ads.zzmh r1 = new com.google.android.gms.internal.ads.zzmh
            int r16 = r16.zza
            r3 = r47
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            com.google.android.gms.internal.ads.zzit r5 = r0.zzb
            int r6 = r0.zzd
            com.google.android.gms.internal.ads.zzmi[] r7 = r0.zza
            int r0 = r0.zzc
            java.lang.Object r8 = r2.first
            r28 = r8
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r18
            r18 = r3
            r20 = r32
            r22 = r26
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.zza(com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlo, long, com.google.android.gms.internal.ads.zzkq, boolean):com.google.android.gms.internal.ads.zzmh");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0174 A[LOOP:5: B:57:0x0174->B:58:0x0176, LOOP_START, PHI: r14 r15 r22 r25 
      PHI: (r14v4 int) = (r14v2 int), (r14v11 int) binds: [B:56:0x0172, B:58:0x0176] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r15v5 int) = (r15v3 int), (r15v11 int) binds: [B:56:0x0172, B:58:0x0176] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r22v6 int) = (r22v5 int), (r22v9 int) binds: [B:56:0x0172, B:58:0x0176] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r25v4 long) = (r25v3 long), (r25v6 long) binds: [B:56:0x0172, B:58:0x0176] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzmk zzb(com.google.android.gms.internal.ads.zzmh r42, com.google.android.gms.internal.ads.zzln r43, com.google.android.gms.internal.ads.zzky r44) throws com.google.android.gms.internal.ads.zziw {
        /*
            r0 = r42
            r1 = r43
            r2 = r44
            int r3 = com.google.android.gms.internal.ads.zzlp.zzas
            com.google.android.gms.internal.ads.zzlo r3 = r1.zzc(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzlt r4 = new com.google.android.gms.internal.ads.zzlt
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.zzlp.zzat
            com.google.android.gms.internal.ads.zzlo r3 = r1.zzc(r3)
            if (r3 == 0) goto L_0x04d1
            com.google.android.gms.internal.ads.zzlu r4 = new com.google.android.gms.internal.ads.zzlu
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.zza()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzmk r0 = new com.google.android.gms.internal.ads.zzmk
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r6 = com.google.android.gms.internal.ads.zzlp.zzau
            com.google.android.gms.internal.ads.zzlo r6 = r1.zzc(r6)
            if (r6 != 0) goto L_0x0048
            int r6 = com.google.android.gms.internal.ads.zzlp.zzav
            com.google.android.gms.internal.ads.zzlo r6 = r1.zzc(r6)
            r8 = 1
            goto L_0x0049
        L_0x0048:
            r8 = 0
        L_0x0049:
            com.google.android.gms.internal.ads.zzqc r6 = r6.zza
            int r9 = com.google.android.gms.internal.ads.zzlp.zzar
            com.google.android.gms.internal.ads.zzlo r9 = r1.zzc(r9)
            com.google.android.gms.internal.ads.zzqc r9 = r9.zza
            int r10 = com.google.android.gms.internal.ads.zzlp.zzao
            com.google.android.gms.internal.ads.zzlo r10 = r1.zzc(r10)
            com.google.android.gms.internal.ads.zzqc r10 = r10.zza
            int r11 = com.google.android.gms.internal.ads.zzlp.zzap
            com.google.android.gms.internal.ads.zzlo r11 = r1.zzc(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzqc r11 = r11.zza
            goto L_0x0068
        L_0x0067:
            r11 = r12
        L_0x0068:
            int r13 = com.google.android.gms.internal.ads.zzlp.zzaq
            com.google.android.gms.internal.ads.zzlo r1 = r1.zzc(r13)
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzqc r1 = r1.zza
            goto L_0x0074
        L_0x0073:
            r1 = r12
        L_0x0074:
            com.google.android.gms.internal.ads.zzlq r13 = new com.google.android.gms.internal.ads.zzlq
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.zzi(r6)
            int r8 = r10.zzu()
            r9 = -1
            int r8 = r8 + r9
            int r14 = r10.zzu()
            int r15 = r10.zzu()
            if (r1 == 0) goto L_0x0096
            r1.zzi(r6)
            int r16 = r1.zzu()
            goto L_0x0098
        L_0x0096:
            r16 = 0
        L_0x0098:
            if (r11 == 0) goto L_0x00ab
            r11.zzi(r6)
            int r6 = r11.zzu()
            if (r6 <= 0) goto L_0x00a9
            int r12 = r11.zzu()
            int r12 = r12 + r9
            goto L_0x00ad
        L_0x00a9:
            r11 = r12
            goto L_0x00ac
        L_0x00ab:
            r6 = 0
        L_0x00ac:
            r12 = -1
        L_0x00ad:
            boolean r17 = r4.zzc()
            r18 = 0
            if (r17 == 0) goto L_0x015c
            com.google.android.gms.internal.ads.zzit r5 = r0.zzf
            java.lang.String r5 = r5.zzf
            java.lang.String r9 = "audio/raw"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x015c
            if (r8 != 0) goto L_0x015c
            if (r16 != 0) goto L_0x015b
            if (r6 != 0) goto L_0x015b
            int r1 = r13.zza
            long[] r5 = new long[r1]
            int[] r6 = new int[r1]
        L_0x00cd:
            boolean r8 = r13.zza()
            if (r8 == 0) goto L_0x00de
            int r8 = r13.zzb
            long r9 = r13.zzd
            r5[r8] = r9
            int r9 = r13.zzc
            r6[r8] = r9
            goto L_0x00cd
        L_0x00de:
            int r4 = r4.zzb()
            long r8 = (long) r15
            r10 = 8192(0x2000, float:1.14794E-41)
            int r10 = r10 / r4
            r11 = 0
            r12 = 0
        L_0x00e8:
            if (r11 >= r1) goto L_0x00f4
            r13 = r6[r11]
            int r13 = com.google.android.gms.internal.ads.zzqj.zze(r13, r10)
            int r12 = r12 + r13
            int r11 = r11 + 1
            goto L_0x00e8
        L_0x00f4:
            long[] r11 = new long[r12]
            int[] r13 = new int[r12]
            long[] r14 = new long[r12]
            int[] r12 = new int[r12]
            r15 = 0
            r16 = 0
            r20 = 0
            r21 = 0
        L_0x0103:
            if (r15 >= r1) goto L_0x0152
            r22 = r6[r15]
            r23 = r5[r15]
            r7 = r16
            r40 = r20
            r20 = r1
            r1 = r40
            r41 = r22
            r22 = r5
            r5 = r41
        L_0x0117:
            if (r5 <= 0) goto L_0x0143
            int r16 = java.lang.Math.min(r10, r5)
            r11[r21] = r23
            r25 = r6
            int r6 = r4 * r16
            r13[r21] = r6
            int r7 = java.lang.Math.max(r7, r6)
            r26 = r7
            long r6 = (long) r1
            long r6 = r6 * r8
            r14[r21] = r6
            r6 = 1
            r12[r21] = r6
            r6 = r13[r21]
            long r6 = (long) r6
            long r23 = r23 + r6
            int r1 = r1 + r16
            int r5 = r5 - r16
            int r21 = r21 + 1
            r6 = r25
            r7 = r26
            goto L_0x0117
        L_0x0143:
            r25 = r6
            int r15 = r15 + 1
            r16 = r7
            r5 = r22
            r40 = r20
            r20 = r1
            r1 = r40
            goto L_0x0103
        L_0x0152:
            r4 = r0
            r15 = r12
            r12 = r13
            r13 = r16
            r27 = r18
            goto L_0x02a2
        L_0x015b:
            r8 = 0
        L_0x015c:
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            long[] r9 = new long[r3]
            r20 = r6
            int[] r6 = new int[r3]
            r25 = r18
            r27 = r25
            r0 = 0
            r2 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0172:
            if (r2 >= r3) goto L_0x0214
        L_0x0174:
            if (r22 != 0) goto L_0x018e
            boolean r22 = r13.zza()
            com.google.android.gms.internal.ads.zzpu.zzd(r22)
            r24 = r14
            r29 = r15
            long r14 = r13.zzd
            r25 = r14
            int r14 = r13.zzc
            r22 = r14
            r14 = r24
            r15 = r29
            goto L_0x0174
        L_0x018e:
            r24 = r14
            r29 = r15
            if (r1 == 0) goto L_0x01aa
        L_0x0194:
            if (r21 != 0) goto L_0x01a7
            if (r16 <= 0) goto L_0x01a3
            int r21 = r1.zzu()
            int r23 = r1.zzr()
            int r16 = r16 + -1
            goto L_0x0194
        L_0x01a3:
            r14 = -1
            r21 = 0
            goto L_0x01a8
        L_0x01a7:
            r14 = -1
        L_0x01a8:
            int r21 = r21 + -1
        L_0x01aa:
            r14 = r23
            r5[r2] = r25
            int r15 = r4.zzb()
            r7[r2] = r15
            if (r15 <= r0) goto L_0x01bb
            r23 = r5
            r0 = r15
            r15 = r4
            goto L_0x01be
        L_0x01bb:
            r15 = r4
            r23 = r5
        L_0x01be:
            long r4 = (long) r14
            long r4 = r27 + r4
            r9[r2] = r4
            if (r11 != 0) goto L_0x01c7
            r4 = 1
            goto L_0x01c8
        L_0x01c7:
            r4 = 0
        L_0x01c8:
            r6[r2] = r4
            if (r2 != r12) goto L_0x01da
            r4 = 1
            r6[r2] = r4
            int r20 = r20 + -1
            if (r20 <= 0) goto L_0x01da
            int r4 = r11.zzu()
            r5 = -1
            int r4 = r4 + r5
            r12 = r4
        L_0x01da:
            r4 = r29
            r29 = r6
            long r5 = (long) r4
            long r27 = r27 + r5
            int r5 = r24 + -1
            if (r5 != 0) goto L_0x01f5
            if (r8 <= 0) goto L_0x01f2
            int r4 = r10.zzu()
            int r5 = r10.zzu()
            int r8 = r8 + -1
            goto L_0x01fa
        L_0x01f2:
            r5 = r4
            r4 = 0
            goto L_0x01fa
        L_0x01f5:
            r40 = r5
            r5 = r4
            r4 = r40
        L_0x01fa:
            r6 = r7[r2]
            r24 = r4
            r30 = r5
            long r4 = (long) r6
            long r25 = r25 + r4
            int r22 = r22 + -1
            int r2 = r2 + 1
            r4 = r15
            r5 = r23
            r6 = r29
            r15 = r30
            r23 = r14
            r14 = r24
            goto L_0x0172
        L_0x0214:
            r23 = r5
            r29 = r6
            r24 = r14
            if (r21 != 0) goto L_0x021e
            r2 = 1
            goto L_0x021f
        L_0x021e:
            r2 = 0
        L_0x021f:
            com.google.android.gms.internal.ads.zzpu.zza(r2)
        L_0x0222:
            if (r16 <= 0) goto L_0x0236
            int r2 = r1.zzu()
            if (r2 != 0) goto L_0x022c
            r2 = 1
            goto L_0x022d
        L_0x022c:
            r2 = 0
        L_0x022d:
            com.google.android.gms.internal.ads.zzpu.zza(r2)
            r1.zzr()
            int r16 = r16 + -1
            goto L_0x0222
        L_0x0236:
            if (r20 != 0) goto L_0x0258
            if (r24 != 0) goto L_0x024f
            if (r22 != 0) goto L_0x0248
            if (r8 == 0) goto L_0x0244
            r1 = 0
            r2 = 0
            r4 = r42
            r5 = r0
            goto L_0x0256
        L_0x0244:
            r4 = r42
            r5 = r0
            goto L_0x029b
        L_0x0248:
            r1 = 0
            r4 = r42
            r5 = r0
            r2 = r22
            goto L_0x0256
        L_0x024f:
            r4 = r42
            r5 = r0
            r2 = r22
            r1 = r24
        L_0x0256:
            r0 = 0
            goto L_0x0261
        L_0x0258:
            r4 = r42
            r5 = r0
            r0 = r20
            r2 = r22
            r1 = r24
        L_0x0261:
            int r6 = r4.zza
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r11 = 215(0xd7, float:3.01E-43)
            r10.<init>(r11)
            java.lang.String r11 = "Inconsistent stbl box for track "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r6 = ": remainingSynchronizationSamples "
            r10.append(r6)
            r10.append(r0)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r10.append(r0)
            r10.append(r2)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r0 = r10.toString()
            java.lang.String r1 = "AtomParsers"
            android.util.Log.w(r1, r0)
        L_0x029b:
            r13 = r5
            r12 = r7
            r14 = r9
            r11 = r23
            r15 = r29
        L_0x02a2:
            long[] r0 = r4.zzi
            if (r0 == 0) goto L_0x04b8
            boolean r0 = r44.zzb()
            if (r0 == 0) goto L_0x02ae
            goto L_0x04b8
        L_0x02ae:
            long[] r0 = r4.zzi
            int r5 = r0.length
            r6 = 1
            if (r5 != r6) goto L_0x033a
            int r5 = r4.zzb
            if (r5 != r6) goto L_0x033a
            int r5 = r14.length
            r6 = 2
            if (r5 < r6) goto L_0x033a
            long[] r6 = r4.zzj
            r7 = 0
            r8 = r6[r7]
            r29 = r0[r7]
            long r1 = r4.zzc
            r22 = r8
            long r7 = r4.zzd
            r31 = r1
            r33 = r7
            long r0 = com.google.android.gms.internal.ads.zzqj.zzj(r29, r31, r33)
            long r8 = r22 + r0
            r0 = 0
            r1 = r14[r0]
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 > 0) goto L_0x033a
            r0 = 1
            r6 = r14[r0]
            int r0 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x033a
            r0 = -1
            int r5 = r5 + r0
            r5 = r14[r5]
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x033a
            int r0 = (r8 > r27 ? 1 : (r8 == r27 ? 0 : -1))
            if (r0 > 0) goto L_0x033a
            long r29 = r22 - r1
            com.google.android.gms.internal.ads.zzit r0 = r4.zzf
            int r0 = r0.zzs
            long r0 = (long) r0
            long r5 = r4.zzc
            r31 = r0
            r33 = r5
            long r0 = com.google.android.gms.internal.ads.zzqj.zzj(r29, r31, r33)
            long r29 = r27 - r8
            com.google.android.gms.internal.ads.zzit r2 = r4.zzf
            int r2 = r2.zzs
            long r5 = (long) r2
            long r7 = r4.zzc
            r31 = r5
            r33 = r7
            long r5 = com.google.android.gms.internal.ads.zzqj.zzj(r29, r31, r33)
            int r2 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0317
            int r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x033a
        L_0x0317:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x033a
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0323
            goto L_0x033a
        L_0x0323:
            int r1 = (int) r0
            r0 = r44
            r0.zzb = r1
            int r1 = (int) r5
            r0.zzc = r1
            long r0 = r4.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzqj.zzk(r14, r2, r0)
            com.google.android.gms.internal.ads.zzmk r0 = new com.google.android.gms.internal.ads.zzmk
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x033a:
            long[] r0 = r4.zzi
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x036d
            r17 = 0
            r1 = r0[r17]
            int r0 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x036d
            r0 = 0
        L_0x0349:
            int r1 = r14.length
            if (r0 >= r1) goto L_0x0366
            r1 = r14[r0]
            long[] r3 = r4.zzj
            r5 = r3[r17]
            long r18 = r1 - r5
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r4.zzc
            r22 = r1
            long r1 = com.google.android.gms.internal.ads.zzqj.zzj(r18, r20, r22)
            r14[r0] = r1
            int r0 = r0 + 1
            r17 = 0
            goto L_0x0349
        L_0x0366:
            com.google.android.gms.internal.ads.zzmk r0 = new com.google.android.gms.internal.ads.zzmk
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x036d:
            int r0 = r4.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0374
            r6 = 1
            goto L_0x0375
        L_0x0374:
            r6 = 0
        L_0x0375:
            r0 = 0
            r1 = 0
            r2 = 0
            r7 = 0
        L_0x0379:
            long[] r5 = r4.zzi
            int r8 = r5.length
            r9 = -1
            if (r7 >= r8) goto L_0x03bb
            long[] r8 = r4.zzj
            r43 = r12
            r16 = r13
            r12 = r8[r7]
            int r8 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r8 == 0) goto L_0x03b2
            r25 = r5[r7]
            long r8 = r4.zzc
            r5 = r11
            long r10 = r4.zzd
            r27 = r8
            r29 = r10
            long r8 = com.google.android.gms.internal.ads.zzqj.zzj(r25, r27, r29)
            r10 = 1
            int r11 = com.google.android.gms.internal.ads.zzqj.zzi(r14, r12, r10, r10)
            long r12 = r12 + r8
            r8 = 0
            int r9 = com.google.android.gms.internal.ads.zzqj.zzi(r14, r12, r6, r8)
            int r8 = r9 - r11
            int r0 = r0 + r8
            if (r1 == r11) goto L_0x03ad
            r1 = 1
            goto L_0x03ae
        L_0x03ad:
            r1 = 0
        L_0x03ae:
            r1 = r1 | r2
            r2 = r1
            r1 = r9
            goto L_0x03b3
        L_0x03b2:
            r5 = r11
        L_0x03b3:
            int r7 = r7 + 1
            r12 = r43
            r11 = r5
            r13 = r16
            goto L_0x0379
        L_0x03bb:
            r5 = r11
            r43 = r12
            r16 = r13
            if (r0 == r3) goto L_0x03c4
            r1 = 1
            goto L_0x03c5
        L_0x03c4:
            r1 = 0
        L_0x03c5:
            r1 = r1 | r2
            if (r1 == 0) goto L_0x03cb
            long[] r2 = new long[r0]
            goto L_0x03cc
        L_0x03cb:
            r2 = r5
        L_0x03cc:
            if (r1 == 0) goto L_0x03d1
            int[] r3 = new int[r0]
            goto L_0x03d3
        L_0x03d1:
            r3 = r43
        L_0x03d3:
            r7 = 1
            if (r7 != r1) goto L_0x03d8
            r13 = 0
            goto L_0x03da
        L_0x03d8:
            r13 = r16
        L_0x03da:
            if (r1 == 0) goto L_0x03df
            int[] r7 = new int[r0]
            goto L_0x03e0
        L_0x03df:
            r7 = r15
        L_0x03e0:
            long[] r0 = new long[r0]
            r28 = r13
            r12 = r18
            r8 = 0
            r11 = 0
        L_0x03e8:
            long[] r9 = r4.zzi
            int r10 = r9.length
            if (r8 >= r10) goto L_0x048d
            long[] r10 = r4.zzj
            r29 = r12
            r12 = r10[r8]
            r31 = r9[r8]
            r9 = -1
            int r16 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r16 == 0) goto L_0x0475
            long r9 = r4.zzc
            r16 = r7
            r24 = r8
            long r7 = r4.zzd
            r18 = r31
            r20 = r9
            r22 = r7
            long r7 = com.google.android.gms.internal.ads.zzqj.zzj(r18, r20, r22)
            r9 = 1
            int r10 = com.google.android.gms.internal.ads.zzqj.zzi(r14, r12, r9, r9)
            long r7 = r7 + r12
            r9 = 0
            int r7 = com.google.android.gms.internal.ads.zzqj.zzi(r14, r7, r6, r9)
            if (r1 == 0) goto L_0x042c
            int r8 = r7 - r10
            java.lang.System.arraycopy(r5, r10, r2, r11, r8)
            r9 = r43
            java.lang.System.arraycopy(r9, r10, r3, r11, r8)
            r27 = r6
            r6 = r16
            java.lang.System.arraycopy(r15, r10, r6, r11, r8)
            goto L_0x0432
        L_0x042c:
            r9 = r43
            r27 = r6
            r6 = r16
        L_0x0432:
            r8 = r28
        L_0x0434:
            if (r10 >= r7) goto L_0x046e
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r33 = r5
            r16 = r6
            long r5 = r4.zzd
            r18 = r29
            r22 = r5
            long r5 = com.google.android.gms.internal.ads.zzqj.zzj(r18, r20, r22)
            r18 = r14[r10]
            long r34 = r18 - r12
            r36 = 1000000(0xf4240, double:4.940656E-318)
            r43 = r12
            long r12 = r4.zzc
            r38 = r12
            long r12 = com.google.android.gms.internal.ads.zzqj.zzj(r34, r36, r38)
            long r5 = r5 + r12
            r0[r11] = r5
            if (r1 == 0) goto L_0x0463
            r5 = r3[r11]
            if (r5 <= r8) goto L_0x0463
            r8 = r9[r10]
        L_0x0463:
            int r11 = r11 + 1
            int r10 = r10 + 1
            r12 = r43
            r6 = r16
            r5 = r33
            goto L_0x0434
        L_0x046e:
            r33 = r5
            r16 = r6
            r28 = r8
            goto L_0x047f
        L_0x0475:
            r9 = r43
            r33 = r5
            r27 = r6
            r16 = r7
            r24 = r8
        L_0x047f:
            long r12 = r29 + r31
            int r8 = r24 + 1
            r43 = r9
            r7 = r16
            r6 = r27
            r5 = r33
            goto L_0x03e8
        L_0x048d:
            r15 = r7
            r5 = 0
            r17 = 0
        L_0x0491:
            int r1 = r15.length
            if (r5 >= r1) goto L_0x049e
            if (r17 != 0) goto L_0x04a0
            r1 = r15[r5]
            r4 = 1
            r17 = r1 & 1
            int r5 = r5 + 1
            goto L_0x0491
        L_0x049e:
            if (r17 == 0) goto L_0x04b0
        L_0x04a0:
            com.google.android.gms.internal.ads.zzmk r1 = new com.google.android.gms.internal.ads.zzmk
            r25 = r1
            r26 = r2
            r27 = r3
            r29 = r0
            r30 = r15
            r25.<init>(r26, r27, r28, r29, r30)
            return r1
        L_0x04b0:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04b8:
            r33 = r11
            r9 = r12
            r16 = r13
            long r0 = r4.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzqj.zzk(r14, r2, r0)
            com.google.android.gms.internal.ads.zzmk r0 = new com.google.android.gms.internal.ads.zzmk
            r10 = r0
            r11 = r33
            r12 = r9
            r13 = r16
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x04d1:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            goto L_0x04da
        L_0x04d9:
            throw r0
        L_0x04da:
            goto L_0x04d9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.zzb(com.google.android.gms.internal.ads.zzmh, com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzky):com.google.android.gms.internal.ads.zzmk");
    }

    public static zzmz zzc(zzlo zzlo, boolean z) {
        if (z) {
            return null;
        }
        zzqc zzqc = zzlo.zza;
        zzqc.zzi(8);
        while (zzqc.zzd() >= 8) {
            int zzg2 = zzqc.zzg();
            int zzr = zzqc.zzr();
            if (zzqc.zzr() == zzlp.zzaD) {
                zzqc.zzi(zzg2);
                int i = zzg2 + zzr;
                zzqc.zzj(12);
                while (zzqc.zzg() < i) {
                    int zzg3 = zzqc.zzg();
                    int zzr2 = zzqc.zzr();
                    if (zzqc.zzr() == zzlp.zzaE) {
                        zzqc.zzi(zzg3);
                        int i2 = zzg3 + zzr2;
                        zzqc.zzj(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzqc.zzg() < i2) {
                            zzmy zza2 = zzmc.zza(zzqc);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new zzmz((List<? extends zzmy>) arrayList);
                    }
                    zzqc.zzj(zzr2 - 8);
                }
                return null;
            }
            zzqc.zzj(zzr - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzd(zzqc zzqc, int i) {
        zzqc.zzi(i + 12);
        zzqc.zzj(1);
        zzf(zzqc);
        zzqc.zzj(2);
        int zzl = zzqc.zzl();
        if ((zzl & 128) != 0) {
            zzqc.zzj(2);
        }
        if ((zzl & 64) != 0) {
            zzqc.zzj(zzqc.zzm());
        }
        if ((zzl & 32) != 0) {
            zzqc.zzj(2);
        }
        zzqc.zzj(1);
        zzf(zzqc);
        int zzl2 = zzqc.zzl();
        String str = null;
        if (zzl2 == 32) {
            str = "video/mp4v-es";
        } else if (zzl2 == 33) {
            str = "video/avc";
        } else if (zzl2 != 35) {
            if (zzl2 != 64) {
                if (zzl2 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (zzl2 == 165) {
                    str = "audio/ac3";
                } else if (zzl2 != 166) {
                    switch (zzl2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (zzl2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzqc.zzj(12);
        zzqc.zzj(1);
        int zzf2 = zzf(zzqc);
        byte[] bArr = new byte[zzf2];
        zzqc.zzk(bArr, 0, zzf2);
        return Pair.create(str, bArr);
    }

    private static int zze(zzqc zzqc, int i, int i2, zzls zzls, int i3) {
        zzqc zzqc2 = zzqc;
        int zzg2 = zzqc.zzg();
        while (true) {
            boolean z = false;
            if (zzg2 - i >= i2) {
                return 0;
            }
            zzqc.zzi(zzg2);
            int zzr = zzqc.zzr();
            zzpu.zzb(zzr > 0, "childAtomSize should be positive");
            if (zzqc.zzr() == zzlp.zzY) {
                int i4 = zzg2 + 8;
                Pair pair = null;
                Integer num = null;
                zzmi zzmi = null;
                boolean z2 = false;
                while (i4 - zzg2 < zzr) {
                    zzqc.zzi(i4);
                    int zzr2 = zzqc.zzr();
                    int zzr3 = zzqc.zzr();
                    if (zzr3 == zzlp.zzae) {
                        num = Integer.valueOf(zzqc.zzr());
                    } else if (zzr3 == zzlp.zzZ) {
                        zzqc.zzj(4);
                        z2 = zzqc.zzr() == zzg;
                    } else if (zzr3 == zzlp.zzaa) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= zzr2) {
                                zzmi = null;
                                break;
                            }
                            zzqc.zzi(i5);
                            int zzr4 = zzqc.zzr();
                            if (zzqc.zzr() == zzlp.zzab) {
                                zzqc.zzj(6);
                                boolean z3 = zzqc.zzl() == 1;
                                int zzl = zzqc.zzl();
                                byte[] bArr = new byte[16];
                                zzqc.zzk(bArr, 0, 16);
                                zzmi = new zzmi(z3, zzl, bArr);
                            } else {
                                i5 += zzr4;
                            }
                        }
                    }
                    i4 += zzr2;
                }
                if (z2) {
                    zzpu.zzb(num != null, "frma atom is mandatory");
                    if (zzmi != null) {
                        z = true;
                    }
                    zzpu.zzb(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzmi);
                }
                if (pair != null) {
                    zzls.zza[i3] = (zzmi) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzls zzls2 = zzls;
            zzg2 += zzr;
        }
    }

    private static int zzf(zzqc zzqc) {
        int zzl = zzqc.zzl();
        int i = zzl & 127;
        while ((zzl & 128) == 128) {
            zzl = zzqc.zzl();
            i = (i << 7) | (zzl & 127);
        }
        return i;
    }
}
