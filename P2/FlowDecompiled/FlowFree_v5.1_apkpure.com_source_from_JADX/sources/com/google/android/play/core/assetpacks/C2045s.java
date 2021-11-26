package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2086bh;
import com.google.android.play.core.internal.C2103ce;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.s */
public final class C2045s implements C2103ce<Executor> {

    /* renamed from: a */
    private final /* synthetic */ int f5134a = 0;

    public C2045s() {
    }

    public C2045s(byte[] bArr) {
    }

    public C2045s(char[] cArr) {
    }

    public C2045s(short[] sArr) {
    }

    /* renamed from: b */
    public static Executor m5114b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C2036k.f5118a);
        C2086bh.m5232k(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: c */
    public static Executor m5115c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C2036k.f5119b);
        C2086bh.m5232k(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: d */
    public static C1979be m5116d() {
        return new C1979be();
    }

    /* renamed from: e */
    public static C1989bo m5117e() {
        return new C1989bo();
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo21822a() {
        int i = this.f5134a;
        return i != 0 ? i != 1 ? i != 2 ? m5117e() : m5116d() : m5115c() : m5114b();
    }
}
