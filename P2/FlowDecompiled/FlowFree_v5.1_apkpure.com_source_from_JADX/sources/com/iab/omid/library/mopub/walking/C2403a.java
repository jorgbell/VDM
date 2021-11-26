package com.iab.omid.library.mopub.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.p042b.C2372a;
import com.iab.omid.library.mopub.p042b.C2376c;
import com.iab.omid.library.mopub.p044d.C2393f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.mopub.walking.a */
public class C2403a {

    /* renamed from: a */
    private final HashMap<View, String> f5430a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, C2404a> f5431b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f5432c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f5433d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f5434e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f5435f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f5436g = new HashMap<>();

    /* renamed from: h */
    private boolean f5437h;

    /* renamed from: com.iab.omid.library.mopub.walking.a$a */
    public static class C2404a {

        /* renamed from: a */
        private final C2376c f5438a;

        /* renamed from: b */
        private final ArrayList<String> f5439b = new ArrayList<>();

        public C2404a(C2376c cVar, String str) {
            this.f5438a = cVar;
            mo24110a(str);
        }

        /* renamed from: a */
        public C2376c mo24109a() {
            return this.f5438a;
        }

        /* renamed from: a */
        public void mo24110a(String str) {
            this.f5439b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> mo24111b() {
            return this.f5439b;
        }
    }

    /* renamed from: a */
    private void m5659a(C2370a aVar) {
        for (C2376c a : aVar.mo23986a()) {
            m5660a(a, aVar);
        }
    }

    /* renamed from: a */
    private void m5660a(C2376c cVar, C2370a aVar) {
        View view = (View) cVar.mo24033a().get();
        if (view != null) {
            C2404a aVar2 = this.f5431b.get(view);
            if (aVar2 != null) {
                aVar2.mo24110a(aVar.getAdSessionId());
            } else {
                this.f5431b.put(view, new C2404a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    /* renamed from: d */
    private String m5661d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C2393f.m5611e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f5433d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    public String mo24099a(View view) {
        if (this.f5430a.size() == 0) {
            return null;
        }
        String str = this.f5430a.get(view);
        if (str != null) {
            this.f5430a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo24100a(String str) {
        return this.f5436g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo24101a() {
        return this.f5434e;
    }

    /* renamed from: b */
    public View mo24102b(String str) {
        return this.f5432c.get(str);
    }

    /* renamed from: b */
    public C2404a mo24103b(View view) {
        C2404a aVar = this.f5431b.get(view);
        if (aVar != null) {
            this.f5431b.remove(view);
        }
        return aVar;
    }

    /* renamed from: b */
    public HashSet<String> mo24104b() {
        return this.f5435f;
    }

    /* renamed from: c */
    public C2414c mo24105c(View view) {
        return this.f5433d.contains(view) ? C2414c.PARENT_VIEW : this.f5437h ? C2414c.OBSTRUCTION_VIEW : C2414c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo24106c() {
        C2372a a = C2372a.m5503a();
        if (a != null) {
            for (C2370a next : a.mo24023c()) {
                View d = next.mo23990d();
                if (next.mo23991e()) {
                    String adSessionId = next.getAdSessionId();
                    if (d != null) {
                        String d2 = m5661d(d);
                        if (d2 == null) {
                            this.f5434e.add(adSessionId);
                            this.f5430a.put(d, adSessionId);
                            m5659a(next);
                        } else {
                            this.f5435f.add(adSessionId);
                            this.f5432c.put(adSessionId, d);
                            this.f5436g.put(adSessionId, d2);
                        }
                    } else {
                        this.f5435f.add(adSessionId);
                        this.f5436g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo24107d() {
        this.f5430a.clear();
        this.f5431b.clear();
        this.f5432c.clear();
        this.f5433d.clear();
        this.f5434e.clear();
        this.f5435f.clear();
        this.f5436g.clear();
        this.f5437h = false;
    }

    /* renamed from: e */
    public void mo24108e() {
        this.f5437h = true;
    }
}
