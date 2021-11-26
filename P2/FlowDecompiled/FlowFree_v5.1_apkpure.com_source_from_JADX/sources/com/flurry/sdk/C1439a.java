package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import com.flurry.android.Consent;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.android.FlurryModule;
import com.flurry.sdk.C1720ex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.a */
public final class C1439a extends C1730f {

    /* renamed from: b */
    public static AtomicBoolean f3581b = new AtomicBoolean(false);

    /* renamed from: d */
    private static C1439a f3582d = null;

    /* renamed from: a */
    public List<FlurryModule> f3583a = new ArrayList();

    public C1439a() {
        super("FlurryAgentImpl", C1720ex.m4478a(C1720ex.C1722a.PUBLIC_API));
    }

    /* renamed from: a */
    public static C1439a m3903a() {
        if (f3582d == null) {
            f3582d = new C1439a();
        }
        return f3582d;
    }

    /* renamed from: b */
    public static int m3905b() {
        C1564bl.m4094a();
        return 322;
    }

    /* renamed from: c */
    public static String m3906c() {
        return C1564bl.m4094a().f3959b;
    }

    /* renamed from: a */
    public final void mo11254a(Context context) {
        if (context instanceof Activity) {
            C1648cy.m4319a("FlurryAgentImpl", "Activity's session is controlled by Flurry SDK");
        } else if (!f3581b.get()) {
            C1648cy.m4331d("FlurryAgentImpl", "Invalid call to onStartSession. Flurry is not initialized");
        } else {
            runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() {
                    C1863im.m4726b();
                    C1913n.m4811a().f4732k.mo11314a(C1547bd.FOREGROUND, true);
                }
            });
        }
    }

    /* renamed from: i */
    public static boolean m3912i() {
        return f3581b.get();
    }

    /* renamed from: a */
    public final void mo11256a(final String str, final String str2, final Map<String, String> map) {
        if (!f3581b.get()) {
            C1648cy.m4331d("FlurryAgentImpl", "Invalid call to addOrigin. Flurry is not initialized");
        } else {
            runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() {
                    C1535az azVar = C1913n.m4811a().f4736o;
                    String str = str;
                    String str2 = str2;
                    Map map = map;
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put("fl.origin.attribute.version", str2);
                    azVar.f3878a.put(str, map);
                    azVar.notifyObservers(new C1534ay(str, str2, map));
                }
            });
        }
    }

    /* renamed from: d */
    public static Consent m3907d() {
        if (f3581b.get()) {
            return C1913n.m4811a().f4733l.f4758a;
        }
        C1648cy.m4331d("FlurryAgentImpl", "Invalid call to getFlurryConsent. Flurry is not initialized");
        return null;
    }

    /* renamed from: e */
    public static String m3908e() {
        if (f3581b.get()) {
            return C1913n.m4811a().f4734m.mo11264a();
        }
        C1648cy.m4331d("FlurryAgentImpl", "Invalid call to getInstantAppName. Flurry is not initialized");
        return null;
    }

    /* renamed from: f */
    public static boolean m3909f() {
        if (f3581b.get()) {
            return C1913n.m4811a().f4732k.f3888d.get();
        }
        C1648cy.m4331d("FlurryAgentImpl", "Invalid call to isSessionActive. Flurry is not initialized");
        return false;
    }

    /* renamed from: g */
    public static String m3910g() {
        if (f3581b.get()) {
            return C1913n.m4811a().f4732k.mo11264a();
        }
        C1648cy.m4331d("FlurryAgentImpl", "Invalid call to getSessionId. Flurry is not initialized");
        return null;
    }

    /* renamed from: a */
    public final void mo11255a(String str, String str2, String str3, Map<String, String> map, StackTraceElement[] stackTraceElementArr) {
        if (!f3581b.get()) {
            C1648cy.m4331d("FlurryAgentImpl", "Invalid call to onError. Flurry is not initialized");
            return;
        }
        final Throwable th = new Throwable(str2);
        th.setStackTrace(stackTraceElementArr);
        final long currentTimeMillis = System.currentTimeMillis();
        final HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1913n.m4811a().f4727f.mo11260a(str4, currentTimeMillis, str5, str6, th, (Map<String, String>) null, hashMap);
            }
        });
    }

    /* renamed from: a */
    public static void m3904a(Consent consent) {
        if (!f3581b.get()) {
            C1648cy.m4331d("FlurryAgentImpl", "Invalid call to updateFlurryConsent. Flurry is not initialized");
        } else {
            C1913n.m4811a().f4733l.mo11575a(consent);
        }
    }

    /* renamed from: h */
    public static void m3911h() {
        if (f3581b.get()) {
            C1652db.m4349c();
            C1719ej.m4477b();
            C1842hu.m4703b();
            C1913n.m4812b();
            C1735fb.m4503b();
            f3581b.set(false);
        }
    }

    /* renamed from: a */
    public final FlurryEventRecordStatus mo11253a(String str, Map<String, String> map, boolean z, boolean z2, long j, long j2) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        Map<String, String> map2 = map;
        if (!f3581b.get()) {
            C1648cy.m4331d("FlurryAgentImpl", "Invalid call to logEvent. Flurry is not initialized");
            return null;
        } else if (C1698dz.m4440a(str).length() == 0) {
            return FlurryEventRecordStatus.kFlurryEventFailed;
        } else {
            final HashMap hashMap = new HashMap();
            if (map2 != null) {
                hashMap.putAll(map);
            }
            if (hashMap.size() > 10) {
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
            } else {
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
            }
            final String str2 = str;
            final boolean z3 = z;
            final boolean z4 = z2;
            final long j3 = j;
            final long j4 = j2;
            runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() {
                    C1802gm.m4656a(str2, (Map<String, String>) hashMap, z3, z4, j3, j4);
                }
            });
            return flurryEventRecordStatus;
        }
    }
}
