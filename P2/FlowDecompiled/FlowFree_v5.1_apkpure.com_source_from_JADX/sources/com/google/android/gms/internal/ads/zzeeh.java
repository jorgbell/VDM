package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeeh<V> extends zzego implements zzefw<V> {
    /* access modifiers changed from: private */
    public static final boolean zzaI;
    private static final Logger zzaL = Logger.getLogger(zzeeh.class.getName());
    /* access modifiers changed from: private */
    public static final zza zzaM;
    private static final Object zzaN = new Object();
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile Object value;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    abstract class zza {
        /* synthetic */ zza(C19441 r1) {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract void zzb(zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzc(zzeeh<?> zzeeh, zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzd(zzeeh<?> zzeeh, zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zze(zzeeh<?> zzeeh, Object obj, Object obj2);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        @NullableDecl
        final Throwable zzd;

        static {
            if (zzeeh.zzaI) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        zzb(boolean z, @NullableDecl Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            Objects.requireNonNull(th);
            this.zzb = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzd {
        static final zzd zza = new zzd((Runnable) null, (Executor) null);
        @NullableDecl
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzeeh, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzeeh, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzeeh, Object> zze;

        zze(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzeeh, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzeeh, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzeeh, Object> atomicReferenceFieldUpdater5) {
            super((C19441) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk, zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzc(zzeeh<?> zzeeh, zzk zzk, zzk zzk2) {
            return this.zzc.compareAndSet(zzeeh, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzd(zzeeh<?> zzeeh, zzd zzd2, zzd zzd3) {
            return this.zzd.compareAndSet(zzeeh, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzeeh<?> zzeeh, Object obj, Object obj2) {
            return this.zze.compareAndSet(zzeeh, obj, obj2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzf<V> implements Runnable {
        final zzeeh<V> zza;
        final zzefw<? extends V> zzb;

        zzf(zzeeh<V> zzeeh, zzefw<? extends V> zzefw) {
            this.zza = zzeeh;
            this.zzb = zzefw;
        }

        public final void run() {
            if (this.zza.value == this) {
                if (zzeeh.zzaM.zze(this.zza, this, zzeeh.zzb(this.zzb))) {
                    zzeeh.zzx(this.zza);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzg extends zza {
        /* synthetic */ zzg(C19441 r1) {
            super((C19441) null);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        public final boolean zzc(zzeeh<?> zzeeh, zzk zzk, zzk zzk2) {
            synchronized (zzeeh) {
                if (zzeeh.waiters != zzk) {
                    return false;
                }
                zzk unused = zzeeh.waiters = zzk2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zzd(zzeeh<?> zzeeh, zzd zzd, zzd zzd2) {
            synchronized (zzeeh) {
                if (zzeeh.listeners != zzd) {
                    return false;
                }
                zzd unused = zzeeh.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzeeh<?> zzeeh, Object obj, Object obj2) {
            synchronized (zzeeh) {
                if (zzeeh.value != obj) {
                    return false;
                }
                Object unused = zzeeh.value = obj2;
                return true;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    interface zzh<V> extends zzefw<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    abstract class zzi<V> extends zzeeh<V> implements zzh<V> {
        zzi() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzeeh.zzj.C19461());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzeeh$zzk> r0 = com.google.android.gms.internal.ads.zzeeh.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzeeh$zzj$1 r1 = new com.google.android.gms.internal.ads.zzeeh$zzj$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzeeh> r2 = com.google.android.gms.internal.ads.zzeeh.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzc = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzb = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzd = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zze = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                zzf = r2     // Catch:{ Exception -> 0x0053 }
                zza = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzecu.zza(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeh.zzj.<clinit>():void");
        }

        /* synthetic */ zzj(C19441 r1) {
            super((C19441) null);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk, zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzc(zzeeh<?> zzeeh, zzk zzk, zzk zzk2) {
            return zza.compareAndSwapObject(zzeeh, zzc, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzd(zzeeh<?> zzeeh, zzd zzd2, zzd zzd3) {
            return zza.compareAndSwapObject(zzeeh, zzb, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzeeh<?> zzeeh, Object obj, Object obj2) {
            return zza.compareAndSwapObject(zzeeh, zzd, obj, obj2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
    final class zzk {
        static final zzk zza = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        zzk() {
            zzeeh.zzaM.zza(this, Thread.currentThread());
        }

        zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzaI = z;
        try {
            zza2 = new zzj((C19441) null);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzg((C19441) null);
        }
        zzaM = zza2;
        if (th != null) {
            Logger logger = zzaL;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    protected zzeeh() {
    }

    private final void zzA(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static void zzB(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzaL;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), e);
        }
    }

    private static final V zzC(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzaN) {
            return null;
        } else {
            return obj;
        }
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzaM.zzc(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    public static Object zzb(zzefw<?> zzefw) {
        Throwable zzk2;
        if (zzefw instanceof zzh) {
            Object obj = ((zzeeh) zzefw).value;
            if (!(obj instanceof zzb)) {
                return obj;
            }
            zzb zzb2 = (zzb) obj;
            if (!zzb2.zzc) {
                return obj;
            }
            Throwable th = zzb2.zzd;
            return th != null ? new zzb(false, th) : zzb.zzb;
        } else if ((zzefw instanceof zzego) && (zzk2 = ((zzego) zzefw).zzk()) != null) {
            return new zzc(zzk2);
        } else {
            boolean isCancelled = zzefw.isCancelled();
            if ((!zzaI) && isCancelled) {
                return zzb.zzb;
            }
            try {
                Object zzw = zzw(zzefw);
                if (!isCancelled) {
                    return zzw == null ? zzaN : zzw;
                }
                String valueOf = String.valueOf(zzefw);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzb(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzc(e.getCause());
                }
                String valueOf2 = String.valueOf(zzefw);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 84);
                sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb2.append(valueOf2);
                return new zzb(false, new IllegalArgumentException(sb2.toString(), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzb(false, e2);
                }
                String valueOf3 = String.valueOf(zzefw);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 77);
                sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb3.append(valueOf3);
                return new zzc(new IllegalArgumentException(sb3.toString(), e2));
            } catch (Throwable th2) {
                return new zzc(th2);
            }
        }
    }

    private static <V> V zzw(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* access modifiers changed from: private */
    public static void zzx(zzeeh<?> zzeeh) {
        zzeeh<V> zzeeh2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzeeh<?> zzeeh3 = zzeeh;
        while (true) {
            zzk zzk2 = zzeeh3.waiters;
            if (zzaM.zzc(zzeeh3, zzk2, zzk.zza)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzeeh3.zzd();
                do {
                    zzd2 = zzeeh3.listeners;
                } while (!zzaM.zzd(zzeeh3, zzd2, zzd.zza));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.zzb;
                    if (runnable instanceof zzf) {
                        zzf zzf2 = (zzf) runnable;
                        zzeeh<V> zzeeh4 = zzf2.zza;
                        if (zzeeh4.value == zzf2) {
                            if (zzaM.zze(zzeeh4, zzf2, zzb(zzf2.zzb))) {
                                zzeeh2 = zzeeh4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zzB(runnable, zzd3.zzc);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zzeeh2 = zzeeh3;
            zzeeh3 = zzeeh2;
        }
    }

    private final void zzy(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzA(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                str = zzecs.zzb(zzc());
            } catch (RuntimeException | StackOverflowError e) {
                String valueOf = String.valueOf(e.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                sb2.append("Exception thrown from implementation: ");
                sb2.append(valueOf);
                str = sb2.toString();
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzz(sb);
        }
    }

    private final void zzz(StringBuilder sb) {
        try {
            Object zzw = zzw(this);
            sb.append("SUCCESS, result=[");
            if (zzw == null) {
                sb.append("null");
            } else if (zzw == this) {
                sb.append("this future");
            } else {
                sb.append(zzw.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzw)));
            }
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.android.gms.internal.ads.zzefw<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzeeh.zzf
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = zzaI
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzeeh$zzb r3 = new com.google.android.gms.internal.ads.zzeeh$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzeeh$zzb r3 = com.google.android.gms.internal.ads.zzeeh.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzeeh$zzb r3 = com.google.android.gms.internal.ads.zzeeh.zzb.zzb
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            com.google.android.gms.internal.ads.zzeeh$zza r6 = zzaM
            boolean r6 = r6.zze(r4, r0, r3)
            if (r6 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x0035
            r4.zzf()
        L_0x0035:
            zzx(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzeeh.zzf
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzeeh$zzf r0 = (com.google.android.gms.internal.ads.zzeeh.zzf) r0
            com.google.android.gms.internal.ads.zzefw<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzeeh.zzh
            if (r4 == 0) goto L_0x0055
            r4 = r0
            com.google.android.gms.internal.ads.zzeeh r4 = (com.google.android.gms.internal.ads.zzeeh) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzeeh.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0058
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
        L_0x0058:
            r1 = 1
            goto L_0x0061
        L_0x005a:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzeeh.zzf
            if (r6 != 0) goto L_0x0028
            r1 = r5
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeh.cancel(boolean):boolean");
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzC(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzaM;
                    zza2.zzb(zzk3, zzk2);
                    if (zza2.zzc(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzC(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            return zzC(this.value);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zzf)) & (obj != null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzz(sb);
        } else {
            zzy(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String zzc() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void zzd() {
    }

    public void zze(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzecl.zzb(runnable, "Runnable was null.");
        zzecl.zzb(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzB(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzaM.zzd(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzB(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void zzf() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzg() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    /* access modifiers changed from: protected */
    public boolean zzh(@NullableDecl V v) {
        if (v == null) {
            v = zzaN;
        }
        if (!zzaM.zze(this, (Object) null, v)) {
            return false;
        }
        zzx(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzi(Throwable th) {
        Objects.requireNonNull(th);
        if (!zzaM.zze(this, (Object) null, new zzc(th))) {
            return false;
        }
        zzx(this);
        return true;
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final Throwable zzk() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzl(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzg());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzj(zzefw<? extends V> zzefw) {
        zzf zzf2;
        zzc zzc2;
        Objects.requireNonNull(zzefw);
        Object obj = this.value;
        if (obj == null) {
            if (zzefw.isDone()) {
                if (!zzaM.zze(this, (Object) null, zzb(zzefw))) {
                    return false;
                }
                zzx(this);
                return true;
            }
            zzf2 = new zzf(this, zzefw);
            if (zzaM.zze(this, (Object) null, zzf2)) {
                try {
                    zzefw.zze(zzf2, zzefc.INSTANCE);
                } catch (Throwable unused) {
                    zzc2 = zzc.zza;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            zzefw.cancel(((zzb) obj).zzc);
        }
        return false;
        zzaM.zze(this, zzf2, zzc2);
        return true;
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof zzf))) {
                return zzC(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zza) {
                    zzk zzk3 = new zzk();
                    do {
                        zza zza2 = zzaM;
                        zza2.zzb(zzk3, zzk2);
                        if (zza2.zzc(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                        return zzC(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zza);
                }
                return zzC(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zzf))) {
                    return zzC(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzeeh = toString();
            String timeUnit3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit3.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzeeh).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzeeh);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }
}
