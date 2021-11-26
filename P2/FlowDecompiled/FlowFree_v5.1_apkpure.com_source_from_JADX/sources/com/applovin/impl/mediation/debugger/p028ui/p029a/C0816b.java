package com.applovin.impl.mediation.debugger.p028ui.p029a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0796a;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0797b;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0799d;
import com.applovin.impl.mediation.debugger.p028ui.p030b.p031a.C0833a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0852e;
import com.applovin.impl.sdk.utils.C1155o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.b */
class C0816b extends C0850d {

    /* renamed from: a */
    private final C0796a f1014a;

    /* renamed from: b */
    private final C0797b f1015b;

    /* renamed from: d */
    private final List<C0846c> f1016d = m1217c();

    /* renamed from: e */
    private final List<C0846c> f1017e = m1218d();

    /* renamed from: f */
    private final List<C0846c> f1018f = m1219e();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$a */
    class C0817a extends C0833a {

        /* renamed from: o */
        private final C0797b f1020o;

        C0817a(C0797b bVar, String str, boolean z) {
            super(bVar.mo8572a(), C0816b.this.f1153c);
            this.f1020o = bVar;
            this.f1119d = C1155o.m2663a(bVar.mo8574c(), -16777216, 18, 1);
            this.f1120e = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f1118c = z;
        }

        /* renamed from: a */
        public C0797b mo8636a() {
            return this.f1020o;
        }

        /* renamed from: b */
        public boolean mo8637b() {
            return this.f1118c;
        }

        /* renamed from: c */
        public int mo8638c() {
            return -12303292;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b */
    enum C0818b {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    C0816b(C0796a aVar, C0797b bVar, Context context) {
        super(context);
        this.f1014a = aVar;
        this.f1015b = bVar;
        notifyDataSetChanged();
    }

    /* renamed from: c */
    private List<C0846c> m1217c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(m1220f());
        arrayList.add(m1221g());
        if (this.f1015b != null) {
            arrayList.add(m1222h());
        }
        return arrayList;
    }

    /* renamed from: d */
    private List<C0846c> m1218d() {
        C0797b bVar = this.f1015b;
        if (bVar != null && !bVar.mo8576e()) {
            return new ArrayList();
        }
        List<C0797b> a = this.f1014a.mo8570e().mo8578a();
        ArrayList arrayList = new ArrayList(a.size());
        for (C0797b next : a) {
            C0797b bVar2 = this.f1015b;
            if (bVar2 == null || bVar2.mo8573b().equals(next.mo8573b())) {
                arrayList.add(new C0817a(next, next.mo8575d() != null ? next.mo8575d().mo8581a() : "", this.f1015b == null));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private List<C0846c> m1219e() {
        C0797b bVar = this.f1015b;
        if (bVar != null && bVar.mo8576e()) {
            return new ArrayList();
        }
        List<C0797b> b = this.f1014a.mo8570e().mo8579b();
        ArrayList arrayList = new ArrayList(b.size());
        for (C0797b next : b) {
            C0797b bVar2 = this.f1015b;
            if (bVar2 == null || bVar2.mo8573b().equals(next.mo8573b())) {
                arrayList.add(new C0817a(next, (String) null, this.f1015b == null));
                for (C0799d next2 : next.mo8577f()) {
                    arrayList.add(C0846c.m1320p().mo8692a(next2.mo8581a()).mo8697b(next2.mo8582b()).mo8698b(true).mo8694a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private C0846c m1220f() {
        return C0846c.m1320p().mo8692a("ID").mo8697b(this.f1014a.mo8565a()).mo8694a();
    }

    /* renamed from: g */
    private C0846c m1221g() {
        return C0846c.m1320p().mo8692a("Ad Format").mo8697b(this.f1014a.mo8567c()).mo8694a();
    }

    /* renamed from: h */
    private C0846c m1222h() {
        return C0846c.m1320p().mo8692a("Selected Network").mo8697b(this.f1015b.mo8574c()).mo8694a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8631a(int i) {
        return (i == C0818b.INFO.ordinal() ? this.f1016d : i == C0818b.BIDDERS.ordinal() ? this.f1017e : this.f1018f).size();
    }

    /* renamed from: a */
    public String mo8632a() {
        return this.f1014a.mo8566b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8633b() {
        return C0818b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0846c mo8634b(int i) {
        return i == C0818b.INFO.ordinal() ? new C0852e("INFO") : i == C0818b.BIDDERS.ordinal() ? new C0852e("BIDDERS") : new C0852e("WATERFALL");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public List<C0846c> mo8635c(int i) {
        return i == C0818b.INFO.ordinal() ? this.f1016d : i == C0818b.BIDDERS.ordinal() ? this.f1017e : this.f1018f;
    }
}
