package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.db */
public final class C1652db {

    /* renamed from: a */
    private static List<C1653dc> f4167a = new ArrayList();

    /* renamed from: b */
    private static final Map<Class<? extends C1653dc>, C1649cz> f4168b = new LinkedHashMap();

    /* renamed from: c */
    private static List<C1649cz> f4169c;

    /* renamed from: d */
    private static final Map<Class<? extends C1653dc>, C1653dc> f4170d = new LinkedHashMap();

    /* renamed from: e */
    private static List<String> f4171e;

    static {
        ArrayList arrayList = new ArrayList();
        f4171e = arrayList;
        arrayList.add("com.flurry.android.marketing.core.FlurryMarketingCoreModule");
        f4171e.add("com.flurry.android.marketing.FlurryMarketingModule");
        f4171e.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
        f4171e.add("com.flurry.android.nativecrash.FlurryNativeCrashModule");
        f4171e.add("com.flurry.android.nativecrash.internal.FlurryNativeCrashModuleStreamingImpl");
        f4171e.add("com.flurry.android.FlurryAdModule");
        f4171e.add("com.flurry.android.ymadlite.YahooAdModule");
    }

    /* renamed from: a */
    public static void m4345a(Class<? extends C1653dc> cls) {
        C1648cy.m4317a(3, "FlurryModuleManager", "Register Ads ".concat(String.valueOf(cls)));
        if (cls != null) {
            Map<Class<? extends C1653dc>, C1649cz> map = f4168b;
            synchronized (map) {
                map.put(cls, new C1649cz(cls));
            }
        }
    }

    /* renamed from: a */
    public static void m4344a(C1653dc dcVar) {
        C1648cy.m4317a(3, "FlurryModuleManager", "Register Add-On ".concat(String.valueOf(dcVar)));
        if (dcVar != null) {
            boolean z = false;
            Iterator<C1653dc> it = f4167a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getClass().getSimpleName().equals(dcVar.getClass().getSimpleName())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                f4167a.add(dcVar);
                return;
            }
            C1648cy.m4317a(3, "FlurryModuleManager", dcVar + " has been register already as addOn module");
            return;
        }
        C1648cy.m4317a(5, "FlurryModuleManager", "Module is null, cannot register it");
    }

    /* renamed from: a */
    public static void m4343a(Context context) {
        ArrayList<C1649cz> arrayList;
        C1648cy.m4317a(3, "FlurryModuleManager", "Init Ads");
        Map<Class<? extends C1653dc>, C1649cz> map = f4168b;
        synchronized (map) {
            arrayList = new ArrayList<>(map.values());
            f4169c = arrayList;
        }
        for (C1649cz czVar : arrayList) {
            C1648cy.m4317a(5, "FlurryModuleManager", "registration ".concat(String.valueOf(czVar)));
            try {
                Class<? extends C1653dc> cls = czVar.f4160a;
                if (cls != null && Build.VERSION.SDK_INT >= czVar.f4161b) {
                    C1653dc dcVar = (C1653dc) cls.newInstance();
                    dcVar.init(context);
                    f4170d.put(czVar.f4160a, dcVar);
                }
            } catch (Exception e) {
                C1648cy.m4318a(5, "FlurryModuleManager", "Flurry Module for class " + czVar.f4160a + " is not available:", e);
            }
        }
    }

    /* renamed from: b */
    public static void m4348b(Context context) {
        C1648cy.m4317a(2, "FlurryModuleManager", "Init Add on modules");
        synchronized (f4170d) {
            for (C1653dc next : f4167a) {
                try {
                    C1648cy.m4317a(2, "FlurryModuleManager", "Module list: ".concat(String.valueOf(next)));
                    Map<Class<? extends C1653dc>, C1653dc> map = f4170d;
                    if (map.containsKey(next.getClass())) {
                        C1648cy.m4317a(5, "FlurryModuleManager", next.getClass() + " has been initialized");
                    } else {
                        next.init(context);
                        map.put(next.getClass(), next);
                        C1648cy.m4317a(3, "FlurryModuleManager", "Initialized modules: " + next.getClass());
                    }
                } catch (C1651da e) {
                    C1648cy.m4325b("FlurryModuleManager", e.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m4342a() {
        C1648cy.m4317a(3, "FlurryModuleManager", "Unregister Ads");
        Map<Class<? extends C1653dc>, C1649cz> map = f4168b;
        synchronized (map) {
            map.clear();
        }
    }

    /* renamed from: b */
    public static void m4347b() {
        C1648cy.m4317a(3, "FlurryModuleManager", "Unregister Add On");
        synchronized (f4167a) {
            f4167a.clear();
        }
    }

    /* renamed from: c */
    public static synchronized void m4349c() {
        synchronized (C1652db.class) {
            C1648cy.m4317a(3, "FlurryModuleManager", "Destroy Streaming");
            List<C1653dc> d = m4350d();
            for (int size = d.size() - 1; size >= 0; size--) {
                try {
                    f4170d.remove(d.get(size).getClass()).destroy();
                } catch (Exception e) {
                    C1648cy.m4318a(5, "FlurryModuleManager", "Error destroying module:", e);
                }
            }
        }
    }

    /* renamed from: d */
    private static List<C1653dc> m4350d() {
        ArrayList arrayList;
        C1648cy.m4317a(3, "FlurryModuleManager", "Get Streaming module list");
        Map<Class<? extends C1653dc>, C1653dc> map = f4170d;
        synchronized (map) {
            arrayList = new ArrayList(map.values());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m4346a(String str) {
        return f4171e.contains(str);
    }
}
