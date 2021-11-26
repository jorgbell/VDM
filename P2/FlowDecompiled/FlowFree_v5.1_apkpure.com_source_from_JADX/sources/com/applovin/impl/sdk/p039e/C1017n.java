package com.applovin.impl.sdk.p039e;

import android.app.Activity;
import android.os.Build;
import com.applovin.impl.sdk.C1048h;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1152l;
import com.applovin.impl.sdk.utils.C1159q;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.n */
public class C1017n extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f2025a;

    public C1017n(C1062k kVar) {
        super("TaskInitializeSdk", kVar);
        this.f2025a = kVar;
    }

    /* renamed from: a */
    private void m1982a() {
        if (!this.f2025a.mo9326B().mo8742a()) {
            Activity am = this.f2025a.mo9378am();
            if (am != null) {
                this.f2025a.mo9326B().mo8739a(am);
            } else {
                this.f2025a.mo9340Q().mo9267a(new C1042y(this.f2025a, true, new Runnable() {
                    public void run() {
                        C1017n.this.f2025a.mo9326B().mo8739a(C1017n.this.f2025a.mo9370ae().mo8944a());
                    }
                }), C1020o.C1022a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    /* renamed from: b */
    private void m1983b() {
        String str;
        if (!this.f2025a.mo9389e()) {
            boolean d = this.f2025a.mo9333I().mo9129d();
            if (d) {
                str = this.f2025a.mo9343T().mo9436j().f2255b + " (use this for test devices)";
            } else {
                str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            }
            Map<String, Object> b = this.f2025a.mo9343T().mo9428b();
            Map<String, Object> c = this.f2025a.mo9343T().mo9429c();
            C1152l lVar = new C1152l();
            lVar.mo9643a().mo9648a("AppLovin SDK");
            lVar.mo9649a("Version", AppLovinSdk.VERSION).mo9649a("Plugin Version", this.f2025a.mo9350a(C0965b.f1779du)).mo9649a("Ad Review Version", C1160r.m2758f());
            lVar.mo9649a("OS", C1160r.m2755e() + " " + Build.VERSION.SDK_INT).mo9649a("Target SDK", c.get("target_sdk")).mo9649a("GAID", str).mo9649a("SDK Key", this.f2025a.mo9409x());
            lVar.mo9649a("Model", b.get("model")).mo9649a("Locale", b.get("locale")).mo9649a("Emulator", b.get("sim"));
            lVar.mo9649a("Application ID", c.get("package_name")).mo9649a("Test Mode On", Boolean.valueOf(this.f2025a.mo9332H().mo8729a())).mo9649a("Verbose Logging On", Boolean.valueOf(d));
            lVar.mo9649a("Mediation Provider", this.f2025a.mo9403s()).mo9649a("TG", C1159q.m2693a(this.f2025a));
            lVar.mo9648a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").mo9648a(C1048h.m2072a(mo9218f()));
            lVar.mo9643a();
            C1107r.m2481f("AppLovinSdk", lVar.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0144, code lost:
        if (r12.f2025a.mo9388d() != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x018e, code lost:
        if (r12.f2025a.mo9388d() == false) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0191, code lost:
        r2 = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0192, code lost:
        r8.append(r2);
        r8.append(" in ");
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append("ms");
        mo9211a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Initializing AppLovin SDK v"
            r8.append(r9)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r10 = "..."
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r12.mo9211a(r8)
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.d.h r8 = r8.mo9341R()     // Catch:{ all -> 0x0147 }
            r8.mo9207d()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.d.h r8 = r8.mo9341R()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.d.g r10 = com.applovin.impl.sdk.p038d.C0986g.f1955b     // Catch:{ all -> 0x0147 }
            r8.mo9206c(r10)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.p r8 = r8.mo9349Z()     // Catch:{ all -> 0x0147 }
            android.content.Context r10 = r12.mo9218f()     // Catch:{ all -> 0x0147 }
            r8.mo9567a((android.content.Context) r10)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.p r8 = r8.mo9349Z()     // Catch:{ all -> 0x0147 }
            android.content.Context r10 = r12.mo9218f()     // Catch:{ all -> 0x0147 }
            r8.mo9570b((android.content.Context) r10)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.d.c r8 = r8.mo9367ab()     // Catch:{ all -> 0x0147 }
            r8.mo9159a()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.e.o r8 = r8.mo9340Q()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.e.b r10 = new com.applovin.impl.sdk.e.b     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r11 = r12.f2025a     // Catch:{ all -> 0x0147 }
            r10.<init>(r11)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.e.o$a r11 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MAIN     // Catch:{ all -> 0x0147 }
            r8.mo9266a((com.applovin.impl.sdk.p039e.C0989a) r10, (com.applovin.impl.sdk.p039e.C1020o.C1022a) r11)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.m r8 = r8.mo9343T()     // Catch:{ all -> 0x0147 }
            r8.mo9431e()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.utils.n r8 = r8.mo9373ah()     // Catch:{ all -> 0x0147 }
            r8.mo9654a()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.n r8 = r8.mo9376ak()     // Catch:{ all -> 0x0147 }
            r8.mo9439a()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            r8.mo9392h()     // Catch:{ all -> 0x0147 }
            r12.m1983b()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p037c.C0965b.f1748dP     // Catch:{ all -> 0x0147 }
            java.lang.Object r8 = r8.mo9350a(r10)     // Catch:{ all -> 0x0147 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0147 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x00af
            com.applovin.impl.sdk.e.n$1 r8 = new com.applovin.impl.sdk.e.n$1     // Catch:{ all -> 0x0147 }
            r8.<init>()     // Catch:{ all -> 0x0147 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r8)     // Catch:{ all -> 0x0147 }
        L_0x00af:
            r12.m1982a()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            r10 = 1
            r8.mo9363a((boolean) r10)     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.network.e r8 = r8.mo9342S()     // Catch:{ all -> 0x0147 }
            r8.mo9498a()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.sdk.AppLovinEventService r8 = r8.mo9406u()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ all -> 0x0147 }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.mediation.debugger.a r8 = r8.mo9329E()     // Catch:{ all -> 0x0147 }
            boolean r8 = r8.mo8555b()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x00e0
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            boolean r8 = r8.mo9389e()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x0104
        L_0x00e0:
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p037c.C0964a.f1549h     // Catch:{ all -> 0x0147 }
            java.lang.Object r8 = r8.mo9350a(r10)     // Catch:{ all -> 0x0147 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0147 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x010d
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            android.content.Context r8 = r8.mo9334J()     // Catch:{ all -> 0x0147 }
            boolean r8 = com.applovin.impl.sdk.utils.C1160r.m2756e((android.content.Context) r8)     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x010d
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            boolean r8 = r8.mo9390f()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x010d
        L_0x0104:
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x0147 }
            com.applovin.impl.mediation.debugger.a r8 = r8.mo9329E()     // Catch:{ all -> 0x0147 }
            r8.mo8552a()     // Catch:{ all -> 0x0147 }
        L_0x010d:
            com.applovin.impl.sdk.k r8 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p037c.C0965b.f1621at
            java.lang.Object r8 = r8.mo9350a(r10)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0130
            com.applovin.impl.sdk.k r8 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Long> r10 = com.applovin.impl.sdk.p037c.C0965b.f1622au
            java.lang.Object r8 = r8.mo9350a(r10)
            java.lang.Long r8 = (java.lang.Long) r8
            long r10 = r8.longValue()
            com.applovin.impl.sdk.k r8 = r12.f2025a
            r8.mo9354a((long) r10)
        L_0x0130:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r9)
            r8.append(r4)
            com.applovin.impl.sdk.k r4 = r12.f2025a
            boolean r4 = r4.mo9388d()
            if (r4 == 0) goto L_0x0191
            goto L_0x0192
        L_0x0147:
            r8 = move-exception
            java.lang.String r9 = "AppLovinSdk"
            java.lang.String r10 = "Failed to initialize SDK!"
            com.applovin.impl.sdk.C1107r.m2480c(r9, r10, r8)     // Catch:{ all -> 0x01ab }
            com.applovin.impl.sdk.k r8 = r12.f2025a     // Catch:{ all -> 0x01ab }
            r9 = 0
            r8.mo9363a((boolean) r9)     // Catch:{ all -> 0x01ab }
            com.applovin.impl.sdk.k r8 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.p037c.C0965b.f1621at
            java.lang.Object r8 = r8.mo9350a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0178
            com.applovin.impl.sdk.k r8 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.p037c.C0965b.f1622au
            java.lang.Object r8 = r8.mo9350a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.k r10 = r12.f2025a
            r10.mo9354a((long) r8)
        L_0x0178:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.k r4 = r12.f2025a
            boolean r4 = r4.mo9388d()
            if (r4 == 0) goto L_0x0191
            goto L_0x0192
        L_0x0191:
            r2 = r3
        L_0x0192:
            r8.append(r2)
            r8.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r12.mo9211a(r0)
            return
        L_0x01ab:
            r8 = move-exception
            com.applovin.impl.sdk.k r9 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p037c.C0965b.f1621at
            java.lang.Object r9 = r9.mo9350a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x01cf
            com.applovin.impl.sdk.k r9 = r12.f2025a
            com.applovin.impl.sdk.c.b<java.lang.Long> r10 = com.applovin.impl.sdk.p037c.C0965b.f1622au
            java.lang.Object r9 = r9.mo9350a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.k r11 = r12.f2025a
            r11.mo9354a((long) r9)
        L_0x01cf:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r9.append(r5)
            r9.append(r4)
            com.applovin.impl.sdk.k r4 = r12.f2025a
            boolean r4 = r4.mo9388d()
            if (r4 == 0) goto L_0x01e8
            goto L_0x01e9
        L_0x01e8:
            r2 = r3
        L_0x01e9:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r12.mo9211a(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p039e.C1017n.run():void");
    }
}
