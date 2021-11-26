package com.applovin.impl.mediation.debugger.p028ui.p029a;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0796a;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0797b;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0844a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0852e;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.sdk.C1199R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.c */
public class C0819c extends C0808a {

    /* renamed from: a */
    private List<C0796a> f1026a;

    /* renamed from: b */
    private C1062k f1027b;

    /* renamed from: c */
    private C0850d f1028c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<C0846c> f1029d;

    /* renamed from: e */
    private ListView f1030e;

    /* renamed from: a */
    private List<C0846c> m1232a(List<C0796a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C0796a next : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C1155o.m2674c("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append(C1155o.m2672b(next.mo8565a(), -16777216));
            spannableStringBuilder.append(new SpannedString("\n"));
            spannableStringBuilder.append(C1155o.m2674c("FORMAT  ", -7829368));
            spannableStringBuilder.append(C1155o.m2672b(next.mo8567c(), -16777216));
            arrayList.add(C0846c.m1318a(C0846c.C0849b.DETAIL).mo8691a(C1155o.m2663a(next.mo8566b(), -16777216, 18, 1)).mo8696b(new SpannedString(spannableStringBuilder)).mo8690a((Context) this).mo8693a(true).mo8694a());
        }
        return arrayList;
    }

    public void initialize(final List<C0796a> list, final C1062k kVar) {
        this.f1026a = list;
        this.f1027b = kVar;
        this.f1029d = m1232a(list);
        C08201 r0 = new C0850d(this) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int mo8631a(int i) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public int mo8633b() {
                return 1;
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C0846c mo8634b(int i) {
                return new C0852e("");
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public List<C0846c> mo8635c(int i) {
                return C0819c.this.f1029d;
            }
        };
        this.f1028c = r0;
        r0.mo8704a((C0850d.C0851a) new C0850d.C0851a() {
            /* renamed from: a */
            public void mo8627a(final C0844a aVar, C0846c cVar) {
                C0819c.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, kVar.mo9370ae(), new C0808a.C0810a<MaxDebuggerAdUnitDetailActivity>() {
                    /* renamed from: a */
                    public void mo8623a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                        maxDebuggerAdUnitDetailActivity.initialize((C0796a) list.get(aVar.mo8677b()), (C0797b) null, kVar);
                    }
                });
            }
        });
        this.f1028c.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Ad Units");
        setContentView(C1199R.layout.list_view);
        ListView listView = (ListView) findViewById(C1199R.C1201id.listView);
        this.f1030e = listView;
        listView.setAdapter(this.f1028c);
    }
}
