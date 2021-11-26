package com.iab.omid.library.mopub.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.mopub.p043c.C2382a;
import com.iab.omid.library.mopub.p043c.C2384b;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2391d;
import com.iab.omid.library.mopub.p044d.C2393f;
import com.iab.omid.library.mopub.walking.C2403a;
import com.iab.omid.library.mopub.walking.p046a.C2409c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C2382a.C2383a {

    /* renamed from: a */
    private static TreeWalker f5418a = new TreeWalker();

    /* renamed from: b */
    private static Handler f5419b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f5420c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f5421j = new Runnable() {
        public void run() {
            TreeWalker.getInstance().m5649h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f5422k = new Runnable() {
        public void run() {
            if (TreeWalker.f5420c != null) {
                TreeWalker.f5420c.post(TreeWalker.f5421j);
                TreeWalker.f5420c.postDelayed(TreeWalker.f5422k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f5423d = new ArrayList();

    /* renamed from: e */
    private int f5424e;

    /* renamed from: f */
    private C2384b f5425f = new C2384b();

    /* renamed from: g */
    private C2403a f5426g = new C2403a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2413b f5427h = new C2413b(new C2409c());

    /* renamed from: i */
    private long f5428i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m5640a(long j) {
        if (this.f5423d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f5423d) {
                next.onTreeProcessed(this.f5424e, TimeUnit.NANOSECONDS.toMillis(j));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f5424e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5641a(View view, C2382a aVar, JSONObject jSONObject, C2414c cVar) {
        aVar.mo24060a(view, jSONObject, this, cVar == C2414c.PARENT_VIEW);
    }

    /* renamed from: a */
    private void m5642a(String str, View view, JSONObject jSONObject) {
        C2382a b = this.f5425f.mo24063b();
        String a = this.f5426g.mo24100a(str);
        if (a != null) {
            JSONObject a2 = b.mo24059a(view);
            C2388b.m5580a(a2, str);
            C2388b.m5585b(a2, a);
            C2388b.m5582a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m5643a(View view, JSONObject jSONObject) {
        String a = this.f5426g.mo24099a(view);
        if (a == null) {
            return false;
        }
        C2388b.m5580a(jSONObject, a);
        this.f5426g.mo24108e();
        return true;
    }

    /* renamed from: b */
    private void m5644b(View view, JSONObject jSONObject) {
        C2403a.C2404a b = this.f5426g.mo24103b(view);
        if (b != null) {
            C2388b.m5579a(jSONObject, b);
        }
    }

    public static TreeWalker getInstance() {
        return f5418a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m5649h() {
        m5650i();
        mo24093d();
        m5651j();
    }

    /* renamed from: i */
    private void m5650i() {
        this.f5424e = 0;
        this.f5428i = C2391d.m5593a();
    }

    /* renamed from: j */
    private void m5651j() {
        m5640a(C2391d.m5593a() - this.f5428i);
    }

    /* renamed from: k */
    private void m5652k() {
        if (f5420c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f5420c = handler;
            handler.post(f5421j);
            f5420c.postDelayed(f5422k, 200);
        }
    }

    /* renamed from: l */
    private void m5653l() {
        Handler handler = f5420c;
        if (handler != null) {
            handler.removeCallbacks(f5422k);
            f5420c = null;
        }
    }

    /* renamed from: a */
    public void mo24090a() {
        m5652k();
    }

    /* renamed from: a */
    public void mo24061a(View view, C2382a aVar, JSONObject jSONObject) {
        C2414c c;
        if (C2393f.m5610d(view) && (c = this.f5426g.mo24105c(view)) != C2414c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo24059a(view);
            C2388b.m5582a(jSONObject, a);
            if (!m5643a(view, a)) {
                m5644b(view, a);
                m5641a(view, aVar, a, c);
            }
            this.f5424e++;
        }
    }

    /* renamed from: b */
    public void mo24091b() {
        mo24092c();
        this.f5423d.clear();
        f5419b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f5427h.mo24126a();
            }
        });
    }

    /* renamed from: c */
    public void mo24092c() {
        m5653l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo24093d() {
        this.f5426g.mo24106c();
        long a = C2391d.m5593a();
        C2382a a2 = this.f5425f.mo24062a();
        if (this.f5426g.mo24104b().size() > 0) {
            Iterator<String> it = this.f5426g.mo24104b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.mo24059a((View) null);
                m5642a(next, this.f5426g.mo24102b(next), a3);
                C2388b.m5578a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f5427h.mo24128b(a3, hashSet, a);
            }
        }
        if (this.f5426g.mo24101a().size() > 0) {
            JSONObject a4 = a2.mo24059a((View) null);
            m5641a((View) null, a2, a4, C2414c.PARENT_VIEW);
            C2388b.m5578a(a4);
            this.f5427h.mo24127a(a4, this.f5426g.mo24101a(), a);
        } else {
            this.f5427h.mo24126a();
        }
        this.f5426g.mo24107d();
    }
}
