package com.applovin.impl.mediation.debugger.p028ui.p034e;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.p030b.p031a.C0833a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0844a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.C1199R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.e.a */
public class C0853a extends C0808a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0850d f1156a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1062k f1157b;

    /* renamed from: c */
    private ListView f1158c;

    /* renamed from: a */
    private List<C0846c> m1359a(List<C0801b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final C0801b next : list) {
            arrayList.add(new C0833a(this, next) {
                /* renamed from: f */
                public int mo8657f() {
                    if (C0853a.this.f1157b.mo9332H().mo8732c() == null || !C0853a.this.f1157b.mo9332H().mo8732c().equals(next.mo8594g())) {
                        return 0;
                    }
                    return C1199R.C1200drawable.applovin_ic_check_mark_borderless;
                }

                /* renamed from: g */
                public int mo8658g() {
                    if (C0853a.this.f1157b.mo9332H().mo8732c() == null || !C0853a.this.f1157b.mo9332H().mo8732c().equals(next.mo8594g())) {
                        return super.mo8658g();
                    }
                    return -16776961;
                }

                /* renamed from: m */
                public String mo8686m() {
                    return "Please restart the app to show ads from the network: " + next.mo8595h() + ".";
                }
            });
        }
        return arrayList;
    }

    public void initialize(List<C0801b> list, final C1062k kVar) {
        this.f1157b = kVar;
        final List<C0846c> a = m1359a(list);
        C08541 r0 = new C0850d(this) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int mo8631a(int i) {
                return a.size();
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public int mo8633b() {
                return 1;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C0846c mo8634b(int i) {
                return new C0846c.C0848a(C0846c.C0849b.SECTION_CENTERED).mo8692a("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").mo8694a();
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public List<C0846c> mo8635c(int i) {
                return a;
            }
        };
        this.f1156a = r0;
        r0.mo8704a((C0850d.C0851a) new C0850d.C0851a() {
            /* renamed from: a */
            public void mo8627a(C0844a aVar, C0846c cVar) {
                if (C1155o.m2673b(kVar.mo9332H().mo8732c())) {
                    kVar.mo9332H().mo8726a(((C0833a) cVar).mo8655d().mo8594g());
                } else {
                    kVar.mo9332H().mo8730b(((C0833a) cVar).mo8655d().mo8594g());
                    C1160r.m2723a("Restart Required", cVar.mo8686m(), (Context) C0853a.this);
                }
                C0853a.this.f1156a.notifyDataSetChanged();
            }
        });
        this.f1156a.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(C1199R.layout.list_view);
        ListView listView = (ListView) findViewById(C1199R.C1201id.listView);
        this.f1158c = listView;
        listView.setAdapter(this.f1156a);
    }
}
