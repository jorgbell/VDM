package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.play.core.tasks.n */
final class C2177n implements OnSuccessListener, OnFailureListener {

    /* renamed from: a */
    private final CountDownLatch f5325a = new CountDownLatch(1);

    /* synthetic */ C2177n(byte[] bArr) {
    }

    /* renamed from: a */
    public final void mo22203a() throws InterruptedException {
        this.f5325a.await();
    }

    public final void onFailure(Exception exc) {
        this.f5325a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f5325a.countDown();
    }
}
