package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeel<I, O, F, T> extends zzefe<O> implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    @NullableDecl
    zzefw<? extends I> zza;
    @NullableDecl
    F zzb;

    public final void run() {
        zzefw<? extends I> zzefw = this.zza;
        F f = this.zzb;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzefw == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zza = null;
            if (zzefw.isCancelled()) {
                zzj(zzefw);
                return;
            }
            try {
                try {
                    Object zzb2 = zzb(f, zzefo.zzp(zzefw));
                    this.zzb = null;
                    zza(zzb2);
                } catch (Throwable th) {
                    this.zzb = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                zzi(e.getCause());
            } catch (RuntimeException e2) {
                zzi(e2);
            } catch (Error e3) {
                zzi(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzb(F f, @NullableDecl I i) throws Exception;

    /* access modifiers changed from: protected */
    public final String zzc() {
        String str;
        zzefw<? extends I> zzefw = this.zza;
        F f = this.zzb;
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
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (zzc2 == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            return zzc2.length() != 0 ? valueOf3.concat(zzc2) : new String(valueOf3);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    zzeel(zzefw<? extends I> zzefw, F f) {
        Objects.requireNonNull(zzefw);
        this.zza = zzefw;
        Objects.requireNonNull(f);
        this.zzb = f;
    }
}
