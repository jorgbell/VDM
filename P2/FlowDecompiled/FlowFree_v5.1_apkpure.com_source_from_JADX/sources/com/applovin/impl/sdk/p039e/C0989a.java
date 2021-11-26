package com.applovin.impl.sdk.p039e;

import android.content.Context;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;

/* renamed from: com.applovin.impl.sdk.e.a */
public abstract class C0989a implements Runnable {

    /* renamed from: a */
    private final String f1979a;
    /* access modifiers changed from: protected */

    /* renamed from: b */
    public final C1062k f1980b;

    /* renamed from: c */
    private final C1107r f1981c;

    /* renamed from: d */
    private final Context f1982d;

    /* renamed from: e */
    private final boolean f1983e;

    public C0989a(String str, C1062k kVar) {
        this(str, kVar, false);
    }

    public C0989a(String str, C1062k kVar, boolean z) {
        this.f1979a = str;
        this.f1980b = kVar;
        this.f1981c = kVar.mo9411z();
        this.f1982d = kVar.mo9334J();
        this.f1983e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9211a(String str) {
        this.f1981c.mo9584b(this.f1979a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9212a(String str, Throwable th) {
        this.f1981c.mo9585b(this.f1979a, str, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9213b(String str) {
        this.f1981c.mo9586c(this.f1979a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9214c(String str) {
        this.f1981c.mo9587d(this.f1979a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C1062k mo9215d() {
        return this.f1980b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9216d(String str) {
        this.f1981c.mo9588e(this.f1979a, str);
    }

    /* renamed from: e */
    public String mo9217e() {
        return this.f1979a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Context mo9218f() {
        return this.f1982d;
    }

    /* renamed from: g */
    public boolean mo9219g() {
        return this.f1983e;
    }
}
