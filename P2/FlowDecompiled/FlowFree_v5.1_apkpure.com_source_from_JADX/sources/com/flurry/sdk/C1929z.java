package com.flurry.sdk;

import java.lang.Thread;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.flurry.sdk.z */
public final class C1929z {

    /* renamed from: c */
    private static C1929z f4775c;

    /* renamed from: a */
    final Thread.UncaughtExceptionHandler f4776a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    final Map<Thread.UncaughtExceptionHandler, Void> f4777b = new WeakHashMap();

    private C1929z() {
        Thread.setDefaultUncaughtExceptionHandler(new C1930a(this, (byte) 0));
    }

    /* renamed from: a */
    public static synchronized C1929z m4834a() {
        C1929z zVar;
        synchronized (C1929z.class) {
            if (f4775c == null) {
                f4775c = new C1929z();
            }
            zVar = f4775c;
        }
        return zVar;
    }

    /* renamed from: b */
    public static synchronized void m4835b() {
        synchronized (C1929z.class) {
            C1929z zVar = f4775c;
            if (zVar != null) {
                Thread.setDefaultUncaughtExceptionHandler(zVar.f4776a);
            }
            f4775c = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Set<Thread.UncaughtExceptionHandler> mo11580c() {
        Set<Thread.UncaughtExceptionHandler> keySet;
        synchronized (this.f4777b) {
            keySet = this.f4777b.keySet();
        }
        return keySet;
    }

    /* renamed from: com.flurry.sdk.z$a */
    final class C1930a implements Thread.UncaughtExceptionHandler {
        private C1930a() {
        }

        /* synthetic */ C1930a(C1929z zVar, byte b) {
            this();
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            for (Thread.UncaughtExceptionHandler uncaughtException : C1929z.this.mo11580c()) {
                try {
                    uncaughtException.uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = C1929z.this.f4776a;
            if (uncaughtExceptionHandler != null) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
