package com.iab.omid.library.vungle.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.p048b.C2423a;
import com.iab.omid.library.vungle.p048b.C2426c;
import com.iab.omid.library.vungle.p050d.C2442f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.vungle.walking.a */
public class C2452a {

    /* renamed from: a */
    private final HashMap<View, String> f5523a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, C2453a> f5524b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f5525c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f5526d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f5527e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f5528f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f5529g = new HashMap<>();

    /* renamed from: h */
    private boolean f5530h;

    /* renamed from: com.iab.omid.library.vungle.walking.a$a */
    public static class C2453a {

        /* renamed from: a */
        private final C2426c f5531a;

        /* renamed from: b */
        private final ArrayList<String> f5532b = new ArrayList<>();

        public C2453a(C2426c cVar, String str) {
            this.f5531a = cVar;
            mo24241a(str);
        }

        /* renamed from: a */
        public C2426c mo24240a() {
            return this.f5531a;
        }

        /* renamed from: a */
        public void mo24241a(String str) {
            this.f5532b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> mo24242b() {
            return this.f5532b;
        }
    }

    /* renamed from: a */
    private void m5837a(C2421a aVar) {
        for (C2426c a : aVar.mo24157a()) {
            m5838a(a, aVar);
        }
    }

    /* renamed from: a */
    private void m5838a(C2426c cVar, C2421a aVar) {
        View view = (View) cVar.mo24177a().get();
        if (view != null) {
            C2453a aVar2 = this.f5524b.get(view);
            if (aVar2 != null) {
                aVar2.mo24241a(aVar.getAdSessionId());
            } else {
                this.f5524b.put(view, new C2453a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    /* renamed from: d */
    private String m5839d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C2442f.m5798e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f5526d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    public String mo24230a(View view) {
        if (this.f5523a.size() == 0) {
            return null;
        }
        String str = this.f5523a.get(view);
        if (str != null) {
            this.f5523a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo24231a(String str) {
        return this.f5529g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo24232a() {
        return this.f5527e;
    }

    /* renamed from: b */
    public View mo24233b(String str) {
        return this.f5525c.get(str);
    }

    /* renamed from: b */
    public C2453a mo24234b(View view) {
        C2453a aVar = this.f5524b.get(view);
        if (aVar != null) {
            this.f5524b.remove(view);
        }
        return aVar;
    }

    /* renamed from: b */
    public HashSet<String> mo24235b() {
        return this.f5528f;
    }

    /* renamed from: c */
    public C2463c mo24236c(View view) {
        return this.f5526d.contains(view) ? C2463c.PARENT_VIEW : this.f5530h ? C2463c.OBSTRUCTION_VIEW : C2463c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo24237c() {
        C2423a a = C2423a.m5714a();
        if (a != null) {
            for (C2421a next : a.mo24169c()) {
                View d = next.mo24158d();
                if (next.mo24159e()) {
                    String adSessionId = next.getAdSessionId();
                    if (d != null) {
                        String d2 = m5839d(d);
                        if (d2 == null) {
                            this.f5527e.add(adSessionId);
                            this.f5523a.put(d, adSessionId);
                            m5837a(next);
                        } else {
                            this.f5528f.add(adSessionId);
                            this.f5525c.put(adSessionId, d);
                            this.f5529g.put(adSessionId, d2);
                        }
                    } else {
                        this.f5528f.add(adSessionId);
                        this.f5529g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo24238d() {
        this.f5523a.clear();
        this.f5524b.clear();
        this.f5525c.clear();
        this.f5526d.clear();
        this.f5527e.clear();
        this.f5528f.clear();
        this.f5529g.clear();
        this.f5530h = false;
    }

    /* renamed from: e */
    public void mo24239e() {
        this.f5530h = true;
    }
}
