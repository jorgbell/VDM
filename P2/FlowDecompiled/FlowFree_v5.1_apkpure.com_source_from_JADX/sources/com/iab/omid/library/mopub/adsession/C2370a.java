package com.iab.omid.library.mopub.adsession;

import android.view.View;
import com.iab.omid.library.mopub.p042b.C2372a;
import com.iab.omid.library.mopub.p042b.C2376c;
import com.iab.omid.library.mopub.p042b.C2380f;
import com.iab.omid.library.mopub.p044d.C2392e;
import com.iab.omid.library.mopub.p045e.C2394a;
import com.iab.omid.library.mopub.publisher.AdSessionStatePublisher;
import com.iab.omid.library.mopub.publisher.C2397a;
import com.iab.omid.library.mopub.publisher.C2398b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.adsession.a */
public class C2370a extends AdSession {

    /* renamed from: a */
    private static final Pattern f5346a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b */
    private final AdSessionContext f5347b;

    /* renamed from: c */
    private final AdSessionConfiguration f5348c;

    /* renamed from: d */
    private final List<C2376c> f5349d = new ArrayList();

    /* renamed from: e */
    private C2394a f5350e;

    /* renamed from: f */
    private AdSessionStatePublisher f5351f;

    /* renamed from: g */
    private boolean f5352g = false;

    /* renamed from: h */
    private boolean f5353h = false;

    /* renamed from: i */
    private String f5354i;

    /* renamed from: j */
    private boolean f5355j;

    /* renamed from: k */
    private boolean f5356k;

    C2370a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f5348c = adSessionConfiguration;
        this.f5347b = adSessionContext;
        this.f5354i = UUID.randomUUID().toString();
        m5483c((View) null);
        this.f5351f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C2397a(adSessionContext.getWebView()) : new C2398b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f5351f.mo24065a();
        C2372a.m5503a().mo24020a(this);
        this.f5351f.mo24069a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C2376c m5480a(View view) {
        for (C2376c next : this.f5349d) {
            if (next.mo24033a().get() == view) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m5481a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50 || !f5346a.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
        }
    }

    /* renamed from: b */
    private void m5482b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m5483c(View view) {
        this.f5350e = new C2394a(view);
    }

    /* renamed from: d */
    private void m5484d(View view) {
        Collection<C2370a> b = C2372a.m5503a().mo24021b();
        if (b != null && b.size() > 0) {
            for (C2370a next : b) {
                if (next != this && next.mo23990d() == view) {
                    next.f5350e.clear();
                }
            }
        }
    }

    /* renamed from: j */
    private void m5485j() {
        if (this.f5355j) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: k */
    private void m5486k() {
        if (this.f5356k) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C2376c> mo23986a() {
        return this.f5349d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23987a(JSONObject jSONObject) {
        m5486k();
        getAdSessionStatePublisher().mo24076a(jSONObject);
        this.f5356k = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.f5353h) {
            m5482b(view);
            m5481a(str);
            if (m5480a(view) == null) {
                this.f5349d.add(new C2376c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo23988b() {
        m5485j();
        getAdSessionStatePublisher().mo24084g();
        this.f5355j = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo23989c() {
        m5486k();
        getAdSessionStatePublisher().mo24086h();
        this.f5356k = true;
    }

    /* renamed from: d */
    public View mo23990d() {
        return (View) this.f5350e.get();
    }

    /* renamed from: e */
    public boolean mo23991e() {
        return this.f5352g && !this.f5353h;
    }

    /* renamed from: f */
    public boolean mo23992f() {
        return this.f5352g;
    }

    public void finish() {
        if (!this.f5353h) {
            this.f5350e.clear();
            removeAllFriendlyObstructions();
            this.f5353h = true;
            getAdSessionStatePublisher().mo24083f();
            C2372a.m5503a().mo24024c(this);
            getAdSessionStatePublisher().mo24078b();
            this.f5351f = null;
        }
    }

    /* renamed from: g */
    public boolean mo23993g() {
        return this.f5353h;
    }

    public String getAdSessionId() {
        return this.f5354i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f5351f;
    }

    /* renamed from: h */
    public boolean mo23996h() {
        return this.f5348c.isNativeImpressionOwner();
    }

    /* renamed from: i */
    public boolean mo23997i() {
        return this.f5348c.isNativeMediaEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f5353h) {
            C2392e.m5597a((Object) view, "AdView is null");
            if (mo23990d() != view) {
                m5483c(view);
                getAdSessionStatePublisher().mo24087i();
                m5484d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f5353h) {
            this.f5349d.clear();
        }
    }

    public void start() {
        if (!this.f5352g) {
            this.f5352g = true;
            C2372a.m5503a().mo24022b(this);
            this.f5351f.mo24066a(C2380f.m5545a().mo24058d());
            this.f5351f.mo24070a(this, this.f5347b);
        }
    }
}
