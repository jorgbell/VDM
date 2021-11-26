package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeeg<V, X extends Throwable, F, T> extends zzefe<V> implements Runnable {
    @NullableDecl
    zzefw<? extends V> zza;
    @NullableDecl
    Class<X> zzb;
    @NullableDecl
    F zzc;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzefw<? extends V> r0 = r10.zza
            java.lang.Class<X> r1 = r10.zzb
            F r2 = r10.zzc
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = 1
            goto L_0x000d
        L_0x000c:
            r5 = 0
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = 1
            goto L_0x0012
        L_0x0011:
            r6 = 0
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x00b5
            boolean r3 = r10.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x00b5
        L_0x0022:
            r3 = 0
            r10.zza = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzego     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.android.gms.internal.ads.zzego r4 = (com.google.android.gms.internal.ads.zzego) r4     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            java.lang.Throwable r4 = r4.zzk()     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x003a
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefo.zzp(r0)     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x008b
        L_0x0039:
            r4 = move-exception
        L_0x003a:
            r5 = r3
            goto L_0x008b
        L_0x003c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0089
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = java.lang.String.valueOf(r6)
            int r7 = r7.length()
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r8 = r8.length()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            int r7 = r7 + 35
            int r7 = r7 + r8
            r9.<init>(r7)
            java.lang.String r7 = "Future type "
            r9.append(r7)
            r9.append(r6)
            java.lang.String r6 = " threw "
            r9.append(r6)
            r9.append(r4)
            java.lang.String r4 = " without a cause"
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r5.<init>(r4)
        L_0x0089:
            r4 = r5
            goto L_0x003a
        L_0x008b:
            if (r4 != 0) goto L_0x0091
            r10.zzh(r5)
            return
        L_0x0091:
            boolean r1 = r1.isInstance(r4)
            if (r1 == 0) goto L_0x00b2
            java.lang.Object r0 = r10.zzb(r2, r4)     // Catch:{ all -> 0x00a3 }
            r10.zzb = r3
            r10.zzc = r3
            r10.zza(r0)
            return
        L_0x00a3:
            r0 = move-exception
            r10.zzi(r0)     // Catch:{ all -> 0x00ac }
            r10.zzb = r3
            r10.zzc = r3
            return
        L_0x00ac:
            r0 = move-exception
            r10.zzb = r3
            r10.zzc = r3
            throw r0
        L_0x00b2:
            r10.zzj(r0)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeg.run():void");
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzb(F f, X x) throws Exception;

    /* access modifiers changed from: protected */
    public final String zzc() {
        String str;
        zzefw<? extends V> zzefw = this.zza;
        Class<X> cls = this.zzb;
        F f = this.zzc;
        String zzc2 = super.zzc();
        if (zzefw != null) {
            String valueOf = String.valueOf(zzefw);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
            sb2.append(str);
            sb2.append("exceptionType=[");
            sb2.append(valueOf2);
            sb2.append("], fallback=[");
            sb2.append(valueOf3);
            sb2.append("]");
            return sb2.toString();
        } else if (zzc2 == null) {
            return null;
        } else {
            String valueOf4 = String.valueOf(str);
            return zzc2.length() != 0 ? valueOf4.concat(zzc2) : new String(valueOf4);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    zzeeg(zzefw<? extends V> zzefw, Class<X> cls, F f) {
        Objects.requireNonNull(zzefw);
        this.zza = zzefw;
        this.zzb = cls;
        Objects.requireNonNull(f);
        this.zzc = f;
    }
}
