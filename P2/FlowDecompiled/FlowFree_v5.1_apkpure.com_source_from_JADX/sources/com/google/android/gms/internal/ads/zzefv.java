package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzefv<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zza = new zzefu((zzeft) null);
    private static final Runnable zzb = new zzefu((zzeft) null);
    private static final Runnable zzc = new zzefu((zzeft) null);

    zzefv() {
    }

    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !zzd();
            if (z) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zza)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            Runnable runnable2 = zzb;
                            if (runnable != runnable2 && runnable != zzc) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable3 = zzc;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    zzf((Object) null, th);
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, zza)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    Runnable runnable5 = zzb;
                    if (runnable4 != runnable5 && runnable4 != zzc) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable6 = zzc;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = (Runnable) get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzf(obj, (Throwable) null);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable == zzb) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzc2 = zzc();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzc2).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzc2);
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String zzc();

    /* access modifiers changed from: package-private */
    public abstract boolean zzd();

    /* access modifiers changed from: package-private */
    public abstract void zzf(@NullableDecl T t, @NullableDecl Throwable th);

    /* access modifiers changed from: package-private */
    public final void zzg() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzb)) {
            try {
                Thread thread = (Thread) runnable;
                thread.interrupt();
                if (((Runnable) getAndSet(zza)) == zzc) {
                    LockSupport.unpark(thread);
                }
            } catch (Throwable th) {
                if (((Runnable) getAndSet(zza)) == zzc) {
                    LockSupport.unpark((Thread) runnable);
                }
                throw th;
            }
        }
    }
}
