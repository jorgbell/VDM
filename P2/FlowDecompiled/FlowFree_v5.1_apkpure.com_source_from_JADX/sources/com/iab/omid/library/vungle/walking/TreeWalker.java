package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.vungle.p049c.C2431a;
import com.iab.omid.library.vungle.p049c.C2433b;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2440d;
import com.iab.omid.library.vungle.p050d.C2442f;
import com.iab.omid.library.vungle.walking.C2452a;
import com.iab.omid.library.vungle.walking.p052a.C2458c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C2431a.C2432a {

    /* renamed from: a */
    private static TreeWalker f5511a = new TreeWalker();

    /* renamed from: b */
    private static Handler f5512b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f5513c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f5514j = new Runnable() {
        public void run() {
            TreeWalker.getInstance().m5827h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f5515k = new Runnable() {
        public void run() {
            if (TreeWalker.f5513c != null) {
                TreeWalker.f5513c.post(TreeWalker.f5514j);
                TreeWalker.f5513c.postDelayed(TreeWalker.f5515k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f5516d = new ArrayList();

    /* renamed from: e */
    private int f5517e;

    /* renamed from: f */
    private C2433b f5518f = new C2433b();

    /* renamed from: g */
    private C2452a f5519g = new C2452a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2462b f5520h = new C2462b(new C2458c());

    /* renamed from: i */
    private long f5521i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m5818a(long j) {
        if (this.f5516d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f5516d) {
                next.onTreeProcessed(this.f5517e, TimeUnit.NANOSECONDS.toMillis(j));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f5517e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5819a(View view, C2431a aVar, JSONObject jSONObject, C2463c cVar) {
        aVar.mo24200a(view, jSONObject, this, cVar == C2463c.PARENT_VIEW);
    }

    /* renamed from: a */
    private void m5820a(String str, View view, JSONObject jSONObject) {
        C2431a b = this.f5518f.mo24203b();
        String a = this.f5519g.mo24231a(str);
        if (a != null) {
            JSONObject a2 = b.mo24199a(view);
            C2437b.m5775a(a2, str);
            C2437b.m5780b(a2, a);
            C2437b.m5777a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m5821a(View view, JSONObject jSONObject) {
        String a = this.f5519g.mo24230a(view);
        if (a == null) {
            return false;
        }
        C2437b.m5775a(jSONObject, a);
        this.f5519g.mo24239e();
        return true;
    }

    /* renamed from: b */
    private void m5822b(View view, JSONObject jSONObject) {
        C2452a.C2453a b = this.f5519g.mo24234b(view);
        if (b != null) {
            C2437b.m5774a(jSONObject, b);
        }
    }

    public static TreeWalker getInstance() {
        return f5511a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m5827h() {
        m5828i();
        mo24224d();
        m5829j();
    }

    /* renamed from: i */
    private void m5828i() {
        this.f5517e = 0;
        this.f5521i = C2440d.m5788a();
    }

    /* renamed from: j */
    private void m5829j() {
        m5818a(C2440d.m5788a() - this.f5521i);
    }

    /* renamed from: k */
    private void m5830k() {
        if (f5513c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f5513c = handler;
            handler.post(f5514j);
            f5513c.postDelayed(f5515k, 200);
        }
    }

    /* renamed from: l */
    private void m5831l() {
        Handler handler = f5513c;
        if (handler != null) {
            handler.removeCallbacks(f5515k);
            f5513c = null;
        }
    }

    /* renamed from: a */
    public void mo24221a() {
        m5830k();
    }

    /* renamed from: a */
    public void mo24201a(View view, C2431a aVar, JSONObject jSONObject) {
        C2463c c;
        if (C2442f.m5797d(view) && (c = this.f5519g.mo24236c(view)) != C2463c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo24199a(view);
            C2437b.m5777a(jSONObject, a);
            if (!m5821a(view, a)) {
                m5822b(view, a);
                m5819a(view, aVar, a, c);
            }
            this.f5517e++;
        }
    }

    /* renamed from: b */
    public void mo24222b() {
        mo24223c();
        this.f5516d.clear();
        f5512b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f5520h.mo24257a();
            }
        });
    }

    /* renamed from: c */
    public void mo24223c() {
        m5831l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo24224d() {
        this.f5519g.mo24237c();
        long a = C2440d.m5788a();
        C2431a a2 = this.f5518f.mo24202a();
        if (this.f5519g.mo24235b().size() > 0) {
            Iterator<String> it = this.f5519g.mo24235b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.mo24199a((View) null);
                m5820a(next, this.f5519g.mo24233b(next), a3);
                C2437b.m5773a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f5520h.mo24259b(a3, hashSet, a);
            }
        }
        if (this.f5519g.mo24232a().size() > 0) {
            JSONObject a4 = a2.mo24199a((View) null);
            m5819a((View) null, a2, a4, C2463c.PARENT_VIEW);
            C2437b.m5773a(a4);
            this.f5520h.mo24258a(a4, this.f5519g.mo24232a(), a);
        } else {
            this.f5520h.mo24257a();
        }
        this.f5519g.mo24238d();
    }
}
