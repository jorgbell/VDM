package com.flurry.sdk;

import android.app.Activity;
import android.view.ViewTreeObserver;
import com.flurry.android.FlurryAgent;
import com.flurry.sdk.C1673dk;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.dn */
public final class C1679dn {

    /* renamed from: h */
    private static C1679dn f4267h;

    /* renamed from: a */
    C1665dh f4268a;

    /* renamed from: b */
    Map<String, C1665dh> f4269b = new HashMap();

    /* renamed from: c */
    public boolean f4270c = false;

    /* renamed from: d */
    long f4271d = 0;

    /* renamed from: e */
    long f4272e = 0;

    /* renamed from: f */
    int f4273f = 0;

    /* renamed from: g */
    boolean f4274g = false;

    /* renamed from: i */
    private C1673dk.C1675a f4275i;

    private C1679dn() {
    }

    /* renamed from: a */
    public static synchronized C1679dn m4408a() {
        C1679dn dnVar;
        synchronized (C1679dn.class) {
            if (f4267h == null) {
                f4267h = new C1679dn();
            }
            dnVar = f4267h;
        }
        return dnVar;
    }

    /* renamed from: b */
    public final void mo11477b() {
        if (this.f4275i == null) {
            C1648cy.m4317a(3, "ScreenTimeMonitor", "Register Screen Time metrics.");
            long nanoTime = System.nanoTime();
            this.f4272e = nanoTime;
            this.f4271d = nanoTime;
            this.f4275i = new C1673dk.C1675a() {
                /* renamed from: a */
                public final void mo11447a(final Activity activity) {
                    C1648cy.m4317a(3, "ScreenTimeMonitor", "onActivityStarted for activity: " + activity.toString());
                    C1679dn dnVar = C1679dn.this;
                    C1665dh dhVar = dnVar.f4268a;
                    dnVar.f4268a = new C1665dh(activity.getClass().getSimpleName(), dhVar == null ? null : dhVar.f4218b);
                    C1679dn.this.f4269b.put(activity.toString(), C1679dn.this.f4268a);
                    C1679dn dnVar2 = C1679dn.this;
                    int i = dnVar2.f4273f + 1;
                    dnVar2.f4273f = i;
                    if (i == 1 && !dnVar2.f4274g) {
                        C1648cy.m4317a(3, "ScreenTimeMonitor", "onForeground for activity: " + activity.toString());
                        long nanoTime = System.nanoTime();
                        C1679dn dnVar3 = C1679dn.this;
                        double d = (double) (nanoTime - dnVar3.f4272e);
                        Double.isNaN(d);
                        long j = (long) (d / 1000000.0d);
                        dnVar3.f4272e = nanoTime;
                        dnVar3.f4271d = nanoTime;
                        if (dnVar3.f4270c) {
                            C1679dn.m4409a("fl.background.time", activity.getClass().getSimpleName(), j);
                        }
                    }
                    activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            C1665dh dhVar;
                            activity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            C1679dn dnVar = C1679dn.this;
                            if (dnVar.f4270c && (dhVar = dnVar.f4268a) != null) {
                                double nanoTime = (double) (System.nanoTime() - C1679dn.this.f4271d);
                                Double.isNaN(nanoTime);
                                dhVar.f4224h = (long) (nanoTime / 1000000.0d);
                                C1648cy.m4317a(3, "ScreenTimeMonitor", "Start timed event for activity: " + C1679dn.this.f4268a.f4218b);
                                C1665dh dhVar2 = C1679dn.this.f4268a;
                                if (!dhVar2.f4222f) {
                                    C1648cy.m4317a(4, "ActivityScreenData", "Start timed activity event: " + dhVar2.f4218b);
                                    String str = dhVar2.f4217a;
                                    String str2 = dhVar2.f4219c;
                                    if (str2 != null) {
                                        dhVar2.f4221e.put("fl.previous.screen", str2);
                                    }
                                    dhVar2.f4221e.put("fl.current.screen", dhVar2.f4218b);
                                    dhVar2.f4221e.put("fl.resume.time", Long.toString(dhVar2.f4223g));
                                    dhVar2.f4221e.put("fl.layout.time", Long.toString(dhVar2.f4224h));
                                    FlurryAgent.logEvent(str, dhVar2.f4221e, true);
                                    dhVar2.f4222f = true;
                                }
                            }
                        }
                    });
                }

                /* renamed from: b */
                public final void mo11448b(Activity activity) {
                    C1665dh dhVar;
                    C1679dn dnVar = C1679dn.this;
                    if (dnVar.f4270c && (dhVar = dnVar.f4268a) != null) {
                        double nanoTime = (double) (System.nanoTime() - C1679dn.this.f4271d);
                        Double.isNaN(nanoTime);
                        dhVar.f4223g = (long) (nanoTime / 1000000.0d);
                    }
                }

                /* renamed from: a */
                public final void mo11446a() {
                    C1679dn.this.f4271d = System.nanoTime();
                }

                /* renamed from: c */
                public final void mo11449c(Activity activity) {
                    C1665dh remove = C1679dn.this.f4269b.remove(activity.toString());
                    C1679dn.this.f4274g = activity.isChangingConfigurations();
                    C1679dn dnVar = C1679dn.this;
                    int i = dnVar.f4273f - 1;
                    dnVar.f4273f = i;
                    if (i == 0 && !dnVar.f4274g) {
                        C1648cy.m4317a(3, "ScreenTimeMonitor", "onBackground for activity: " + activity.toString());
                        long nanoTime = System.nanoTime();
                        C1679dn dnVar2 = C1679dn.this;
                        double d = (double) (nanoTime - dnVar2.f4272e);
                        Double.isNaN(d);
                        long j = (long) (d / 1000000.0d);
                        dnVar2.f4272e = nanoTime;
                        if (dnVar2.f4270c) {
                            C1679dn.m4409a("fl.foreground.time", activity.getClass().getSimpleName(), j);
                        }
                    }
                    if (C1679dn.this.f4270c && remove != null) {
                        C1648cy.m4317a(3, "ScreenTimeMonitor", "End timed event: " + remove.f4218b);
                        if (remove.f4222f) {
                            C1648cy.m4317a(4, "ActivityScreenData", "End timed activity event: " + remove.f4218b);
                            String str = remove.f4217a;
                            double nanoTime2 = (double) (System.nanoTime() - remove.f4220d);
                            Double.isNaN(nanoTime2);
                            remove.f4221e.put("fl.duration", Long.toString((long) (nanoTime2 / 1000000.0d)));
                            FlurryAgent.endTimedEvent(str, remove.f4221e);
                            remove.f4222f = false;
                        }
                    }
                }
            };
            C1673dk.m4390a().mo11469a(this.f4275i);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4409a(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("fl.current.screen", str2);
        hashMap.put(str, Long.toString(j));
        FlurryAgent.logEvent("Flurry.ForegroundTime", (Map<String, String>) hashMap);
    }
}
