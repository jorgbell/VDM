package com.applovin.impl.mediation.debugger.p028ui.p032c;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.p032c.C0842b;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0844a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.a */
public class C0839a extends C0808a {

    /* renamed from: a */
    private C0842b f1091a;

    /* renamed from: b */
    private ListView f1092b;

    public void initialize(final C0801b bVar) {
        setTitle(bVar.mo8595h());
        C0842b bVar2 = new C0842b(bVar, this);
        this.f1091a = bVar2;
        bVar2.mo8704a((C0850d.C0851a) new C0850d.C0851a() {
            /* renamed from: a */
            public void mo8627a(C0844a aVar, C0846c cVar) {
                if (aVar.mo8676a() == C0842b.C0843a.TEST_ADS.ordinal()) {
                    C1062k s = bVar.mo8606s();
                    C0801b.C0803b c = bVar.mo8589c();
                    if (C0801b.C0803b.READY == c) {
                        C0839a.this.startActivity(MaxDebuggerMultiAdActivity.class, s.mo9370ae(), new C0808a.C0810a<MaxDebuggerMultiAdActivity>() {
                            /* renamed from: a */
                            public void mo8623a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                maxDebuggerMultiAdActivity.initialize(bVar);
                            }
                        });
                        return;
                    } else if (C0801b.C0803b.DISABLED == c) {
                        s.mo9332H().mo8733d();
                        C1160r.m2723a("Restart Required", cVar.mo8686m(), (Context) C0839a.this);
                        return;
                    }
                }
                C1160r.m2723a("Instructions", cVar.mo8686m(), (Context) C0839a.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1199R.layout.list_view);
        ListView listView = (ListView) findViewById(C1199R.C1201id.listView);
        this.f1092b = listView;
        listView.setAdapter(this.f1091a);
    }
}
