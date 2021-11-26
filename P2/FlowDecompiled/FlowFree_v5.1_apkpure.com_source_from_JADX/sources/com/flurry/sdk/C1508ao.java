package com.flurry.sdk;

import android.os.Bundle;

/* renamed from: com.flurry.sdk.ao */
public final class C1508ao {

    /* renamed from: a */
    public final C1509a f3791a;

    /* renamed from: b */
    public final Bundle f3792b;

    /* renamed from: com.flurry.sdk.ao$a */
    public enum C1509a {
        CREATED,
        STARTED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED,
        SAVE_STATE,
        APP_ORIENTATION_CHANGE,
        APP_BACKGROUND,
        TRIM_MEMORY
    }

    public C1508ao(C1509a aVar, Bundle bundle) {
        this.f3791a = aVar;
        this.f3792b = bundle;
    }
}
