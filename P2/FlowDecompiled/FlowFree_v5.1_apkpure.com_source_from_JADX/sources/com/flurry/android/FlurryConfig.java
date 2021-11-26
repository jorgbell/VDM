package com.flurry.android;

import android.os.Handler;
import android.util.Pair;
import com.flurry.sdk.C1439a;
import com.flurry.sdk.C1600bw;
import com.flurry.sdk.C1605by;
import com.flurry.sdk.C1607bz;
import com.flurry.sdk.C1623cg;
import com.flurry.sdk.C1648cy;
import com.flurry.sdk.C1702eb;
import java.util.Map;

public final class FlurryConfig {

    /* renamed from: a */
    private static FlurryConfig f3562a;

    /* renamed from: b */
    private C1607bz f3563b = C1607bz.m4189a();

    public static synchronized FlurryConfig getInstance() {
        FlurryConfig flurryConfig;
        synchronized (FlurryConfig.class) {
            if (f3562a == null) {
                if (!C1439a.m3912i()) {
                    C1648cy.m4325b("FlurryConfig", "Flurry SDK must be initialized before starting config");
                }
                f3562a = new FlurryConfig();
            }
            flurryConfig = f3562a;
        }
        return flurryConfig;
    }

    private FlurryConfig() {
    }

    public final void resetState() {
        C1607bz bzVar = this.f3563b;
        bzVar.runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1636cr.m4298c(C1536b.m4057a());
                if (C1607bz.this.f4053f != null) {
                    C1607bz.this.f4053f.mo11399a();
                }
                C1607bz.this.f4050a.mo11378c();
                boolean unused = C1607bz.this.f4059m = false;
                C1614a unused2 = C1607bz.this.f4061o = C1614a.None;
                boolean unused3 = C1607bz.this.f4060n = false;
                for (C1623cg put : C1623cg.m4239b()) {
                    Map d = C1607bz.this.f4057j;
                    Boolean bool = Boolean.FALSE;
                    d.put(put, new Pair(bool, bool));
                }
            }
        });
    }

    public final void registerListener(FlurryConfigListener flurryConfigListener) {
        this.f3563b.mo11366a(flurryConfigListener, C1623cg.f4101a, (Handler) null);
    }

    public final void registerListener(FlurryConfigListener flurryConfigListener, Handler handler) {
        this.f3563b.mo11366a(flurryConfigListener, C1623cg.f4101a, handler);
    }

    public final void unregisterListener(FlurryConfigListener flurryConfigListener) {
        this.f3563b.mo11365a(flurryConfigListener);
    }

    public final String getString(String str, String str2) {
        return this.f3563b.mo11369c().mo11355a(str, str2, C1623cg.f4101a);
    }

    public final boolean getBoolean(String str, boolean z) {
        C1600bw c = this.f3563b.mo11369c();
        C1605by a = c.f4027b.mo11397a(str, C1623cg.f4101a);
        if (a == null) {
            a = c.f4026a.mo11381a(str);
        }
        return a != null ? Boolean.parseBoolean(a.mo11362a()) : z;
    }

    public final int getInt(String str, int i) {
        return this.f3563b.mo11369c().mo11353a(str, i, C1623cg.f4101a);
    }

    public final long getLong(String str, long j) {
        return this.f3563b.mo11369c().mo11354a(str, j, C1623cg.f4101a);
    }

    public final double getDouble(String str, double d) {
        return this.f3563b.mo11369c().mo11351a(str, d, C1623cg.f4101a);
    }

    public final float getFloat(String str, float f) {
        return this.f3563b.mo11369c().mo11352a(str, f, C1623cg.f4101a);
    }

    public final String toString() {
        return this.f3563b.toString();
    }

    public final void fetchConfig() {
        if (!C1439a.m3912i()) {
            C1648cy.m4325b("FlurryConfig", "Flurry SDK must be initialized before fetching config");
        } else {
            this.f3563b.mo11370d();
        }
    }

    public final boolean activateConfig() {
        if (C1439a.m3912i()) {
            return this.f3563b.mo11368a((C1623cg) null);
        }
        C1648cy.m4325b("FlurryConfig", "Flurry SDK must be initialized before activating config");
        return false;
    }
}
