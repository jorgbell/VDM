package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzedh<E> extends zzecz<E> {
    @NullableDecl
    Object[] zzd;
    private int zze;

    public final /* bridge */ /* synthetic */ zzeda zzc(Object obj) {
        zze(obj);
        return this;
    }

    public final zzedh<E> zzf(Iterable<? extends E> iterable) {
        if (this.zzd != null) {
            for (Object zze2 : iterable) {
                zze(zze2);
            }
        } else {
            super.zzb(iterable);
        }
        return this;
    }

    zzedh(int i) {
        super(i);
        this.zzd = new Object[zzedi.zzj(i)];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.internal.ads.zzedu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzedi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.internal.ads.zzedu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.ads.zzedu} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzedi<E> zzg() {
        /*
            r8 = this;
            int r0 = r8.zzb
            if (r0 == 0) goto L_0x005a
            r1 = 1
            if (r0 == r1) goto L_0x004f
            java.lang.Object[] r2 = r8.zzd
            if (r2 == 0) goto L_0x003b
            int r0 = com.google.android.gms.internal.ads.zzedi.zzj(r0)
            java.lang.Object[] r2 = r8.zzd
            int r2 = r2.length
            if (r0 != r2) goto L_0x003b
            int r0 = r8.zzb
            java.lang.Object[] r2 = r8.zza
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzedi.zzq(r0, r2)
            if (r0 == 0) goto L_0x0028
            java.lang.Object[] r0 = r8.zza
            int r2 = r8.zzb
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x002a
        L_0x0028:
            java.lang.Object[] r0 = r8.zza
        L_0x002a:
            r3 = r0
            com.google.android.gms.internal.ads.zzedu r0 = new com.google.android.gms.internal.ads.zzedu
            int r4 = r8.zze
            java.lang.Object[] r5 = r8.zzd
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.zzb
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0049
        L_0x003b:
            int r0 = r8.zzb
            java.lang.Object[] r2 = r8.zza
            com.google.android.gms.internal.ads.zzedi r0 = com.google.android.gms.internal.ads.zzedi.zzp(r0, r2)
            int r2 = r0.size()
            r8.zzb = r2
        L_0x0049:
            r8.zzc = r1
            r1 = 0
            r8.zzd = r1
            return r0
        L_0x004f:
            java.lang.Object[] r0 = r8.zza
            r1 = 0
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzedw r1 = new com.google.android.gms.internal.ads.zzedw
            r1.<init>(r0)
            return r1
        L_0x005a:
            com.google.android.gms.internal.ads.zzedu<java.lang.Object> r0 = com.google.android.gms.internal.ads.zzedu.zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedh.zzg():com.google.android.gms.internal.ads.zzedi");
    }

    public final zzedh<E> zze(E e) {
        int length;
        Objects.requireNonNull(e);
        if (this.zzd == null || zzedi.zzj(this.zzb) > (length = this.zzd.length)) {
            this.zzd = null;
            super.zza(e);
            return this;
        }
        int i = length - 1;
        int hashCode = e.hashCode();
        int zza = zzecy.zza(hashCode);
        while (true) {
            int i2 = zza & i;
            Object[] objArr = this.zzd;
            Object obj = objArr[i2];
            if (obj != null) {
                if (obj.equals(e)) {
                    break;
                }
                zza = i2 + 1;
            } else {
                objArr[i2] = e;
                this.zze += hashCode;
                super.zza(e);
                break;
            }
        }
        return this;
    }
}
