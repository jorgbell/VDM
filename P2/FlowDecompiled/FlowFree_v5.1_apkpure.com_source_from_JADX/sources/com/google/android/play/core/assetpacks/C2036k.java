package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.k */
final /* synthetic */ class C2036k implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f5118a = new C2036k();

    /* renamed from: b */
    static final ThreadFactory f5119b = new C2036k((byte[]) null);

    /* renamed from: c */
    private final /* synthetic */ int f5120c = 0;

    private C2036k() {
    }

    private C2036k(byte[] bArr) {
    }

    public final Thread newThread(Runnable runnable) {
        return this.f5120c != 0 ? new Thread(runnable, "AssetPackBackgroundExecutor") : new Thread(runnable, "UpdateListenerExecutor");
    }
}
