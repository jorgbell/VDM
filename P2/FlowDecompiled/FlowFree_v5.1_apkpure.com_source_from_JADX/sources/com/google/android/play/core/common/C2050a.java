package com.google.android.play.core.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.common.a */
public final class C2050a {

    /* renamed from: a */
    private final Map<String, Object> f5146a = new HashMap();

    /* renamed from: b */
    private final AtomicBoolean f5147b = new AtomicBoolean(false);

    /* renamed from: b */
    private final synchronized void m5132b() {
        this.f5146a.put("assetOnlyUpdates", Boolean.FALSE);
    }

    /* renamed from: a */
    public final synchronized boolean mo22020a() {
        if (!this.f5147b.get()) {
            m5132b();
        }
        Object obj = this.f5146a.get("assetOnlyUpdates");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
