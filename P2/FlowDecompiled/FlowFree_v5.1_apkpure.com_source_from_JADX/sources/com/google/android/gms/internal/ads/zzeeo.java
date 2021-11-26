package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeeo<InputT, OutputT> extends zzeet<OutputT> {
    private static final Logger zza = Logger.getLogger(zzeeo.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zzedb<? extends zzefw<? extends InputT>> zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzeeo(zzedb<? extends zzefw<? extends InputT>> zzedb, boolean z, boolean z2) {
        super(zzedb.size());
        Objects.requireNonNull(zzedb);
        this.zzb = zzedb;
        this.zzc = z;
        this.zzd = z2;
    }

    static /* synthetic */ void zzA(zzeeo zzeeo, zzedb zzedb) {
        int zzD = zzeeo.zzD();
        if (zzD < 0) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (zzD == 0) {
            if (zzedb != null) {
                zzedz zza2 = zzedb.iterator();
                int i = 0;
                while (zza2.hasNext()) {
                    Future future = (Future) zza2.next();
                    if (!future.isCancelled()) {
                        zzeeo.zzK(i, future);
                    }
                    i++;
                }
            }
            zzeeo.zzE();
            zzeeo.zzx();
            zzeeo.zzB(2);
        }
    }

    private static void zzJ(Throwable th) {
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    /* access modifiers changed from: private */
    public final void zzK(int i, Future<? extends InputT> future) {
        try {
            zzw(i, zzefo.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    private static boolean zzL(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void zzB(int i) {
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (this.zzb.isEmpty()) {
            zzx();
        } else if (this.zzc) {
            zzedz<? extends zzefw<? extends InputT>> zza2 = this.zzb.iterator();
            int i = 0;
            while (zza2.hasNext()) {
                zzefw zzefw = (zzefw) zza2.next();
                zzefw.zze(new zzeem(this, zzefw, i), zzefc.INSTANCE);
                i++;
            }
        } else {
            zzeen zzeen = new zzeen(this, this.zzd ? this.zzb : null);
            zzedz<? extends zzefw<? extends InputT>> zza3 = this.zzb.iterator();
            while (zza3.hasNext()) {
                ((zzefw) zza3.next()).zze(zzeen, zzefc.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzc() {
        zzedb<? extends zzefw<? extends InputT>> zzedb = this.zzb;
        if (zzedb == null) {
            return super.zzc();
        }
        String valueOf = String.valueOf(zzedb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("futures=");
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzedb<? extends zzefw<? extends InputT>> zzedb = this.zzb;
        boolean z = true;
        zzB(1);
        boolean isCancelled = isCancelled();
        if (zzedb == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzg = zzg();
            zzedz<? extends zzefw<? extends InputT>> zza2 = zzedb.iterator();
            while (zza2.hasNext()) {
                ((Future) zza2.next()).cancel(zzg);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzw(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: package-private */
    public abstract void zzx();

    /* access modifiers changed from: package-private */
    public final void zzb(Set<Throwable> set) {
        Objects.requireNonNull(set);
        if (!isCancelled()) {
            zzL(set, zzk());
        }
    }

    private final void zzI(Throwable th) {
        Objects.requireNonNull(th);
        if (this.zzc && !zzi(th) && zzL(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }
}
