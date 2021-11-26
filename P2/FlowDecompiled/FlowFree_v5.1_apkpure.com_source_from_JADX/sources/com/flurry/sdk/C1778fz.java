package com.flurry.sdk;

import android.os.SystemClock;
import com.flurry.sdk.C1776fy;
import com.flurry.sdk.C1798gk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.fz */
public final class C1778fz implements C1776fy {

    /* renamed from: a */
    Map<C1893jo, C1895jq> f4448a;

    /* renamed from: b */
    long f4449b = Long.MIN_VALUE;

    /* renamed from: c */
    long f4450c = Long.MIN_VALUE;

    /* renamed from: d */
    long f4451d = Long.MIN_VALUE;

    /* renamed from: e */
    int f4452e = C1547bd.BACKGROUND.f3913d;

    /* renamed from: f */
    private AtomicBoolean f4453f;

    /* renamed from: g */
    private C1775fx f4454g;

    /* renamed from: h */
    private boolean f4455h = false;

    /* renamed from: i */
    private Timer f4456i = null;

    /* renamed from: j */
    private TimerTask f4457j = null;

    /* renamed from: k */
    private C1782b f4458k = C1782b.INACTIVE;

    /* renamed from: com.flurry.sdk.fz$b */
    enum C1782b {
        INACTIVE,
        FOREGROUND_RUNNING,
        FOREGROUND_ENDING,
        BACKGROUND_RUNNING,
        BACKGROUND_ENDING
    }

    /* renamed from: a */
    static boolean m4606a(long j) {
        return j > 0;
    }

    public C1778fz(C1775fx fxVar) {
        this.f4454g = fxVar;
        if (this.f4448a == null) {
            this.f4448a = new HashMap();
        }
        this.f4448a.clear();
        this.f4448a.put(C1893jo.SESSION_INFO, (Object) null);
        this.f4448a.put(C1893jo.APP_STATE, (Object) null);
        this.f4448a.put(C1893jo.APP_INFO, (Object) null);
        this.f4448a.put(C1893jo.REPORTED_ID, (Object) null);
        this.f4448a.put(C1893jo.DEVICE_PROPERTIES, (Object) null);
        this.f4448a.put(C1893jo.SESSION_ID, (Object) null);
        this.f4448a = this.f4448a;
        this.f4453f = new AtomicBoolean(false);
    }

    /* renamed from: a */
    public final void mo11529a() {
        m4613e();
    }

    /* renamed from: a */
    public final void mo11530a(C1895jq jqVar) {
        if (jqVar.mo11542a().equals(C1893jo.FLUSH_FRAME)) {
            C1866ip ipVar = (C1866ip) jqVar.mo11560f();
            if (!C1776fy.C1777a.REASON_SESSION_FINALIZE.f4447j.equals(ipVar.f4603b)) {
                if (!C1776fy.C1777a.REASON_STICKY_SET_COMPLETE.f4447j.equals(ipVar.f4603b)) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    m4603a(this.f4450c, elapsedRealtime, "Flush In Middle");
                    mo11533b((C1895jq) C1884jg.m4750a(this.f4449b, this.f4450c, elapsedRealtime, this.f4452e));
                }
                C1895jq jqVar2 = this.f4448a.get(C1893jo.SESSION_ID);
                if (jqVar2 != null) {
                    m4610c(jqVar2);
                    return;
                }
                return;
            }
            return;
        }
        if (jqVar.mo11542a().equals(C1893jo.REPORTING)) {
            C1817gz gzVar = (C1817gz) jqVar.mo11560f();
            int i = C17802.f4461a[this.f4458k.ordinal()];
            if (i == 1) {
                C1547bd bdVar = gzVar.f4543a;
                C1547bd bdVar2 = C1547bd.FOREGROUND;
                if (bdVar.equals(bdVar2)) {
                    if (this.f4455h && !gzVar.f4548f) {
                        this.f4455h = false;
                    }
                    if ((gzVar.f4543a.equals(bdVar2) && gzVar.f4547e.equals(C1546bc.SESSION_END)) && (this.f4455h || !gzVar.f4548f)) {
                        m4607b(gzVar.f4546d);
                        m4604a(C1782b.FOREGROUND_ENDING);
                    }
                }
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            C1648cy.m4317a(6, "SessionRule", "Unreachable Code");
                        } else if (m4608b(gzVar)) {
                            this.f4455h = gzVar.f4548f;
                            m4604a(C1782b.FOREGROUND_RUNNING);
                            m4605a(gzVar);
                        } else if (m4611c(gzVar)) {
                            m4604a(C1782b.BACKGROUND_RUNNING);
                            m4605a(gzVar);
                        }
                    } else if (m4608b(gzVar)) {
                        m4613e();
                        m4604a(C1782b.FOREGROUND_RUNNING);
                        m4605a(gzVar);
                    } else if (m4611c(gzVar)) {
                        mo11532b();
                        this.f4451d = Long.MIN_VALUE;
                        m4604a(C1782b.BACKGROUND_RUNNING);
                    }
                } else if (m4608b(gzVar)) {
                    m4613e();
                    m4604a(C1782b.FOREGROUND_RUNNING);
                    m4605a(gzVar);
                } else {
                    if (gzVar.f4543a.equals(C1547bd.BACKGROUND) && gzVar.f4547e.equals(C1546bc.SESSION_END)) {
                        m4607b(gzVar.f4546d);
                        m4604a(C1782b.BACKGROUND_ENDING);
                    }
                }
            } else if (m4608b(gzVar)) {
                mo11532b();
                this.f4451d = Long.MIN_VALUE;
                m4604a(C1782b.FOREGROUND_RUNNING);
            }
        }
        if (jqVar.mo11542a().equals(C1893jo.ANALYTICS_ERROR) && ((C1801gl) jqVar.mo11560f()).f4500g == C1798gk.C1799a.UNRECOVERABLE_CRASH.f4488d) {
            mo11532b();
            this.f4451d = SystemClock.elapsedRealtime();
            if (m4606a(this.f4449b)) {
                m4603a(this.f4450c, this.f4451d, "Process Crash");
                mo11533b((C1895jq) C1884jg.m4750a(this.f4449b, this.f4450c, this.f4451d, this.f4452e));
            } else {
                C1648cy.m4317a(6, "SessionRule", "Session id is invalid. Not appending this session id frame.");
            }
        }
        if (jqVar.mo11542a().equals(C1893jo.CCPA_DELETION)) {
            C1776fy.C1777a aVar = C1776fy.C1777a.REASON_DATA_DELETION;
            m4610c((C1895jq) C1865io.m4729a(aVar.ordinal(), aVar.f4447j));
        }
        C1893jo a = jqVar.mo11542a();
        if (this.f4448a.containsKey(a)) {
            C1648cy.m4317a(3, "SessionRule", "Adding Sticky Frame:" + jqVar.mo11559e());
            this.f4448a.put(a, jqVar);
        } else {
            C1895jq jqVar3 = jqVar;
        }
        if (!this.f4453f.get() && m4612d()) {
            this.f4453f.set(true);
            C1776fy.C1777a aVar2 = C1776fy.C1777a.REASON_STICKY_SET_COMPLETE;
            m4610c((C1895jq) C1865io.m4729a(aVar2.ordinal(), aVar2.f4447j));
            int b = C1739fe.m4514b("last_streaming_http_error_code", Integer.MIN_VALUE);
            String b2 = C1739fe.m4516b("last_streaming_http_error_message", "");
            String b3 = C1739fe.m4516b("last_streaming_http_report_identifier", "");
            if (b != Integer.MIN_VALUE) {
                C1698dz.m4443a(b, b2, b3, false);
                C1739fe.m4510a("last_streaming_http_error_code");
                C1739fe.m4510a("last_streaming_http_error_message");
                C1739fe.m4510a("last_streaming_http_report_identifier");
            }
            int b4 = C1739fe.m4514b("last_legacy_http_error_code", Integer.MIN_VALUE);
            String b5 = C1739fe.m4516b("last_legacy_http_error_message", "");
            String b6 = C1739fe.m4516b("last_legacy_http_report_identifier", "");
            if (b4 != Integer.MIN_VALUE) {
                C1698dz.m4443a(b4, b5, b6, false);
                C1739fe.m4510a("last_legacy_http_error_code");
                C1739fe.m4510a("last_legacy_http_error_message");
                C1739fe.m4510a("last_legacy_http_report_identifier");
            }
            C1739fe.m4512a("last_streaming_session_id", this.f4449b);
            HashMap hashMap = new HashMap();
            hashMap.put("streaming.session.id", String.valueOf(this.f4449b));
            C1548be.m4072a();
            C1548be.m4075b("Session Ids", hashMap);
            C1548be.m4072a().mo11316b();
        } else if (this.f4453f.get() && jqVar.mo11542a().equals(C1893jo.NOTIFICATION)) {
            C1548be.m4072a();
            C1548be.m4075b("Flush Token Refreshed", Collections.emptyMap());
            C1776fy.C1777a aVar3 = C1776fy.C1777a.REASON_PUSH_TOKEN_REFRESH;
            m4610c((C1895jq) C1865io.m4729a(aVar3.ordinal(), aVar3.f4447j));
        }
    }

    /* renamed from: com.flurry.sdk.fz$2 */
    static /* synthetic */ class C17802 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4461a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flurry.sdk.fz$b[] r0 = com.flurry.sdk.C1778fz.C1782b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4461a = r0
                com.flurry.sdk.fz$b r1 = com.flurry.sdk.C1778fz.C1782b.FOREGROUND_RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4461a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.fz$b r1 = com.flurry.sdk.C1778fz.C1782b.FOREGROUND_ENDING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4461a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flurry.sdk.fz$b r1 = com.flurry.sdk.C1778fz.C1782b.BACKGROUND_RUNNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4461a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flurry.sdk.fz$b r1 = com.flurry.sdk.C1778fz.C1782b.BACKGROUND_ENDING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4461a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flurry.sdk.fz$b r1 = com.flurry.sdk.C1778fz.C1782b.INACTIVE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1778fz.C17802.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m4604a(C1782b bVar) {
        if (this.f4458k.equals(bVar)) {
            C1648cy.m4317a(3, "SessionRule", "Invalid state transition.");
            return;
        }
        C1648cy.m4317a(3, "SessionRule", "Previous session state: " + this.f4458k.name());
        this.f4458k = bVar;
        C1648cy.m4317a(3, "SessionRule", "Current session state: " + this.f4458k.name());
    }

    /* renamed from: d */
    private boolean m4612d() {
        boolean z = true;
        for (Map.Entry<C1893jo, C1895jq> value : this.f4448a.entrySet()) {
            if (value.getValue() == null) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: e */
    private void m4613e() {
        if (this.f4449b <= 0) {
            C1648cy.m4317a(6, "SessionRule", "Finalize session " + this.f4449b);
            return;
        }
        mo11532b();
        C1548be.m4072a().mo11316b();
        this.f4451d = SystemClock.elapsedRealtime();
        if (m4606a(this.f4449b)) {
            mo11533b((C1895jq) C1884jg.m4750a(this.f4449b, this.f4450c, this.f4451d, this.f4452e));
        } else {
            C1648cy.m4317a(6, "SessionRule", "Session id is invalid. Not appending this session id frame.");
        }
        C1776fy.C1777a aVar = C1776fy.C1777a.REASON_SESSION_FINALIZE;
        mo11533b((C1895jq) C1865io.m4729a(aVar.ordinal(), aVar.f4447j));
        mo11531a(false);
        mo11534c();
    }

    /* renamed from: a */
    private void m4605a(C1817gz gzVar) {
        if (!gzVar.f4547e.equals(C1546bc.SESSION_START)) {
            C1648cy.m4317a(3, "SessionRule", "Only generate session id during session start");
        } else if (this.f4449b == Long.MIN_VALUE && this.f4448a.get(C1893jo.SESSION_ID) == null) {
            C1648cy.m4317a(3, "SessionRule", "Generating Session Id:" + gzVar.f4544b);
            this.f4449b = gzVar.f4544b;
            this.f4450c = SystemClock.elapsedRealtime();
            this.f4452e = gzVar.f4543a.f3913d == 1 ? 2 : 0;
            if (m4606a(this.f4449b)) {
                m4603a(this.f4450c, this.f4451d, "Generate Session Id");
                m4610c((C1895jq) C1884jg.m4750a(this.f4449b, this.f4450c, this.f4451d, this.f4452e));
            } else {
                C1648cy.m4317a(6, "SessionRule", "Session id is invalid. Not appending this session id frame.");
            }
            mo11531a(true);
        }
    }

    /* renamed from: c */
    private void m4610c(C1895jq jqVar) {
        if (this.f4454g != null) {
            C1648cy.m4317a(3, "SessionRule", "Appending Frame:" + jqVar.mo11559e());
            this.f4454g.mo11522a(jqVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo11533b(C1895jq jqVar) {
        if (this.f4454g != null) {
            C1648cy.m4317a(3, "SessionRule", "Forwarding Frame:" + jqVar.mo11559e());
            this.f4454g.mo11524b(jqVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo11532b() {
        Timer timer = this.f4456i;
        if (timer != null) {
            timer.cancel();
            this.f4456i = null;
        }
        TimerTask timerTask = this.f4457j;
        if (timerTask != null) {
            timerTask.cancel();
            this.f4457j = null;
        }
    }

    /* renamed from: com.flurry.sdk.fz$a */
    public class C1781a extends TimerTask {
        protected C1781a() {
        }

        public final void run() {
            C1778fz.this.mo11532b();
            C1778fz fzVar = C1778fz.this;
            C1548be.m4072a().mo11316b();
            if (fzVar.f4451d <= 0) {
                fzVar.f4451d = SystemClock.elapsedRealtime();
            }
            if (C1778fz.m4606a(fzVar.f4449b)) {
                fzVar.mo11533b((C1895jq) C1884jg.m4750a(fzVar.f4449b, fzVar.f4450c, fzVar.f4451d, fzVar.f4452e));
            } else {
                C1648cy.m4317a(6, "SessionRule", "Session id is invalid. Not appending this session id frame.");
            }
            C1776fy.C1777a aVar = C1776fy.C1777a.REASON_SESSION_FINALIZE;
            fzVar.mo11533b((C1895jq) C1865io.m4729a(aVar.ordinal(), aVar.f4447j));
            fzVar.mo11531a(false);
            fzVar.mo11534c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo11534c() {
        C1648cy.m4317a(3, "SessionRule", "Reset session rule");
        this.f4448a.put(C1893jo.SESSION_ID, (Object) null);
        this.f4453f.set(false);
        this.f4449b = Long.MIN_VALUE;
        this.f4450c = Long.MIN_VALUE;
        this.f4451d = Long.MIN_VALUE;
        this.f4458k = C1782b.INACTIVE;
        this.f4455h = false;
    }

    /* renamed from: b */
    private static boolean m4608b(C1817gz gzVar) {
        return gzVar.f4543a.equals(C1547bd.FOREGROUND) && gzVar.f4547e.equals(C1546bc.SESSION_START);
    }

    /* renamed from: c */
    private static boolean m4611c(C1817gz gzVar) {
        return gzVar.f4543a.equals(C1547bd.BACKGROUND) && gzVar.f4547e.equals(C1546bc.SESSION_START);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo11531a(final boolean z) {
        C1775fx fxVar = this.f4454g;
        if (fxVar != null) {
            fxVar.mo11523a((Runnable) new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    if (z) {
                        C1538bb bbVar = C1913n.m4811a().f4732k;
                        C1778fz fzVar = C1778fz.this;
                        bbVar.mo11312a(fzVar.f4449b, fzVar.f4450c);
                    }
                    C1538bb bbVar2 = C1913n.m4811a().f4732k;
                    bbVar2.f3888d.set(z);
                }
            });
        }
    }

    /* renamed from: a */
    private static void m4603a(long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("fl.session.elapsed.start.time", String.valueOf(j));
        if (j2 != Long.MIN_VALUE) {
            hashMap.put("fl.session.elapsed.end.time", String.valueOf(j2));
            hashMap.put("fl.session.duration", String.valueOf(j2 - j));
        }
        hashMap.put("fl.session.message", str);
        C1548be.m4072a();
        C1548be.m4075b("Session Duration", hashMap);
    }

    /* renamed from: b */
    private void m4607b(long j) {
        mo11532b();
        this.f4451d = SystemClock.elapsedRealtime();
        if (m4606a(this.f4449b)) {
            m4603a(this.f4450c, this.f4451d, "Start Session Finalize Timer");
            m4610c((C1895jq) C1884jg.m4750a(this.f4449b, this.f4450c, this.f4451d, this.f4452e));
        } else {
            C1648cy.m4317a(6, "SessionRule", "Session id is invalid. Not appending this session id frame.");
        }
        m4609c(j);
    }

    /* renamed from: c */
    private synchronized void m4609c(long j) {
        if (this.f4456i != null) {
            mo11532b();
        }
        this.f4456i = new Timer("FlurrySessionTimer");
        C1781a aVar = new C1781a();
        this.f4457j = aVar;
        this.f4456i.schedule(aVar, j);
    }
}
