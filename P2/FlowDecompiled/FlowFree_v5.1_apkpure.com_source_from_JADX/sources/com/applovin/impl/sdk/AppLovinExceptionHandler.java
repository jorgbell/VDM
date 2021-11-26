package com.applovin.impl.sdk;

import android.os.Process;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final AppLovinExceptionHandler f1364a = new AppLovinExceptionHandler();

    /* renamed from: b */
    private final Set<C1062k> f1365b = new HashSet(2);

    /* renamed from: c */
    private final AtomicBoolean f1366c = new AtomicBoolean();

    /* renamed from: d */
    private Thread.UncaughtExceptionHandler f1367d;

    public static AppLovinExceptionHandler shared() {
        return f1364a;
    }

    public void addSdk(C1062k kVar) {
        this.f1365b.add(kVar);
    }

    public void enable() {
        if (this.f1366c.compareAndSet(false, true)) {
            this.f1367d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        for (C1062k next : this.f1365b) {
            next.mo9411z().mo9584b("AppLovinExceptionHandler", "Detected unhandled exception");
            ((EventServiceImpl) next.mo9406u()).trackEventSynchronously("paused");
            ((EventServiceImpl) next.mo9406u()).trackEventSynchronously("crashed");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1367d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
