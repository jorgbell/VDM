package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.flurry.sdk.eb */
public abstract class C1702eb implements Runnable {

    /* renamed from: a */
    private PrintStream f4296a;

    /* renamed from: b */
    private PrintWriter f4297b;

    /* renamed from: a */
    public abstract void mo11257a() throws Exception;

    public final void run() {
        try {
            mo11257a();
        } catch (Throwable th) {
            if (this.f4296a != null) {
                th.printStackTrace(this.f4296a);
            } else {
                PrintWriter printWriter = this.f4297b;
                if (printWriter != null) {
                    th.printStackTrace(printWriter);
                } else {
                    th.printStackTrace();
                }
            }
            C1648cy.m4318a(6, "SafeRunnable", "", th);
            C1548be.m4072a();
            C1548be.m4073a("SafeRunnableException", "Exception caught by SafeRunnable", th);
        }
    }
}
