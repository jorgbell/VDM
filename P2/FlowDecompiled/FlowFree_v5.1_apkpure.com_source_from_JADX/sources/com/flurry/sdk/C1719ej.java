package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryModule;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.sdk.ej */
public final class C1719ej {

    /* renamed from: a */
    private static boolean f4315a;

    /* renamed from: b */
    private static boolean f4316b;

    /* renamed from: a */
    public static synchronized void m4474a() {
        synchronized (C1719ej.class) {
            if (!f4315a) {
                try {
                    C1652db.m4345a((Class<? extends C1653dc>) Class.forName("com.flurry.android.bridge.FlurryBridgeModule"));
                } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                    C1648cy.m4317a(3, "FlurrySDK", "Ads module not available");
                }
                f4315a = true;
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m4475a(Context context) {
        synchronized (C1719ej.class) {
            C1652db.m4348b(context);
        }
    }

    /* renamed from: a */
    public static synchronized void m4476a(List<FlurryModule> list) {
        synchronized (C1719ej.class) {
            if (!f4316b) {
                if (list != null) {
                    Iterator<FlurryModule> it = list.iterator();
                    while (it.hasNext()) {
                        C1652db.m4344a((C1653dc) it.next());
                    }
                }
                f4316b = true;
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m4477b() {
        synchronized (C1719ej.class) {
            C1652db.m4342a();
            C1652db.m4347b();
            f4315a = false;
            f4316b = false;
        }
    }
}
