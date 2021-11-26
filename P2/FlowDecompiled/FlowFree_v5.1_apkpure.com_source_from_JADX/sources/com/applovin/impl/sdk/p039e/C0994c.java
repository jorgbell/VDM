package com.applovin.impl.sdk.p039e;

import android.net.Uri;
import com.applovin.impl.mediation.C0911j;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1103p;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.p038d.C0982e;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.e.c */
abstract class C0994c extends C0989a implements C0911j.C0912a {

    /* renamed from: a */
    protected final C0934g f1986a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAdLoadListener f1987c;

    /* renamed from: d */
    private final C1103p f1988d;

    /* renamed from: e */
    private final Collection<Character> f1989e;

    /* renamed from: f */
    private final C0982e f1990f;

    /* renamed from: g */
    private boolean f1991g;

    C0994c(String str, C0934g gVar, C1062k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, kVar);
        if (gVar != null) {
            this.f1986a = gVar;
            this.f1987c = appLovinAdLoadListener;
            this.f1988d = kVar.mo9349Z();
            this.f1989e = m1908j();
            this.f1990f = new C0982e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    /* renamed from: a */
    private Uri m1903a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (C1155o.m2673b(uri2)) {
                mo9211a("Caching " + str + " image...");
                return m1907g(uri2);
            }
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        mo9211a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private Uri m1904a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String J = this.f1986a.mo9001J();
        if (C1155o.m2673b(J)) {
            replace = J + replace;
        }
        File a = this.f1988d.mo9564a(replace, this.f1980b.mo9334J());
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.f1990f.mo9184b(a.length());
            sb = new StringBuilder();
        } else {
            if (!this.f1988d.mo9569a(a, str + str2, Arrays.asList(new String[]{str}), this.f1990f)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("file://");
        sb.append(a.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    /* renamed from: g */
    private Uri m1907g(String str) {
        return mo9230b(str, this.f1986a.mo9000I(), true);
    }

    /* renamed from: j */
    private Collection<Character> m1908j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f1980b.mo9350a(C0965b.f1661bg)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Uri mo9225a(String str, List<String> list, boolean z) {
        String str2;
        if (!C1155o.m2673b(str)) {
            return null;
        }
        mo9211a("Caching video " + str + "...");
        String a = this.f1988d.mo9565a(mo9218f(), str, this.f1986a.mo9001J(), list, z, this.f1990f);
        if (C1155o.m2673b(a)) {
            File a2 = this.f1988d.mo9564a(a, mo9218f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    mo9211a("Finish caching video for ad #" + this.f1986a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a);
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + a2;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            mo9216d(str2);
            return null;
        }
        mo9216d("Failed to cache video");
        mo9235h();
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9226a(String str, List<String> list) {
        if (C1155o.m2673b(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                mo9211a("Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (C1155o.m2673b(this.f1986a.mo9001J())) {
                lastPathSegment = this.f1986a.mo9001J() + lastPathSegment;
            }
            File a = this.f1988d.mo9564a(lastPathSegment, mo9218f());
            ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f1988d.mo9562a(a);
            if (a2 == null) {
                a2 = this.f1988d.mo9563a(str, list, true);
                if (a2 != null) {
                    this.f1988d.mo9568a(a2, a);
                    this.f1990f.mo9183a((long) a2.size());
                }
            } else {
                this.f1990f.mo9184b((long) a2.size());
            }
            try {
                return a2.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                mo9212a("UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                mo9212a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9227a(String str, List<String> list, C0934g gVar) {
        if (!C1155o.m2673b(str)) {
            return str;
        }
        if (!((Boolean) this.f1980b.mo9350a(C0965b.f1662bh)).booleanValue()) {
            mo9211a("Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = gVar.shouldCancelHtmlCachingIfShown();
        for (String next : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb.length()) {
                if (mo9231b()) {
                    return str;
                }
                i = sb.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb.length();
                int i3 = i;
                while (!this.f1989e.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    mo9216d("Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb.substring(next.length() + i, i3);
                if (!C1155o.m2673b(substring)) {
                    mo9211a("Skip caching of non-resource " + substring);
                } else if (!shouldCancelHtmlCachingIfShown || !gVar.hasShown()) {
                    Uri a = m1904a(next, substring);
                    if (a != null) {
                        sb.replace(i, i3, a.toString());
                        gVar.mo9059b(a);
                        this.f1990f.mo9188e();
                    } else {
                        this.f1990f.mo9189f();
                    }
                } else {
                    mo9211a("Cancelling HTML caching due to ad being shown already");
                    this.f1990f.mo9182a();
                    return str;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9228a() {
        this.f1980b.mo9330F().mo8848b(this);
    }

    /* renamed from: a */
    public void mo8849a(C0733a aVar) {
        if (aVar.mo8390e().equalsIgnoreCase(this.f1986a.mo9003L())) {
            mo9216d("Updating flag for timeout...");
            this.f1991g = true;
        }
        this.f1980b.mo9330F().mo8848b(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9229a(AppLovinAdBase appLovinAdBase) {
        C0981d.m1833a(this.f1990f, appLovinAdBase, this.f1980b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Uri mo9230b(String str, List<String> list, boolean z) {
        String str2;
        try {
            String a = this.f1988d.mo9565a(mo9218f(), str, this.f1986a.mo9001J(), list, z, this.f1990f);
            if (!C1155o.m2673b(a)) {
                return null;
            }
            File a2 = this.f1988d.mo9564a(a, mo9218f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    return fromFile;
                }
                str2 = "Unable to extract Uri from image file";
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a;
            }
            mo9216d(str2);
            return null;
        } catch (Throwable th) {
            mo9212a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo9231b() {
        return this.f1991g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9232c() {
        mo9211a("Caching mute images...");
        Uri a = m1903a(this.f1986a.mo9025aD(), "mute");
        if (a != null) {
            this.f1986a.mo9061c(a);
        }
        Uri a2 = m1903a(this.f1986a.mo9026aE(), "unmute");
        if (a2 != null) {
            this.f1986a.mo9062d(a2);
        }
        mo9211a("Ad updated with muteImageFilename = " + this.f1986a.mo9025aD() + ", unmuteImageFilename = " + this.f1986a.mo9026aE());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Uri mo9233e(String str) {
        return mo9225a(str, this.f1986a.mo9000I(), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo9234f(final String str) {
        if (!C1155o.m2673b(str)) {
            return null;
        }
        C1085b a = C1085b.m2299a(this.f1980b).mo9481a(str).mo9487b("GET").mo9480a("").mo9479a(0).mo9485a();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.f1980b.mo9339P().mo9449a(a, new C1081a.C1082a(), new C1081a.C1084c<String>() {
            /* renamed from: a */
            public void mo8530a(int i) {
                C0994c cVar = C0994c.this;
                cVar.mo9216d("Failed to load resource from '" + str + "'");
            }

            /* renamed from: a */
            public void mo8531a(String str, int i) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f1990f.mo9183a((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo9235h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f1987c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.f1987c = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo9236i() {
        mo9211a("Rendered new ad:" + this.f1986a);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0994c.this.f1987c != null) {
                    C0994c.this.f1987c.adReceived(C0994c.this.f1986a);
                    AppLovinAdLoadListener unused = C0994c.this.f1987c = null;
                }
            }
        });
    }

    public void run() {
        if (this.f1986a.mo9002K()) {
            mo9211a("Subscribing to timeout events...");
            this.f1980b.mo9330F().mo8847a((C0911j.C0912a) this);
        }
    }
}
