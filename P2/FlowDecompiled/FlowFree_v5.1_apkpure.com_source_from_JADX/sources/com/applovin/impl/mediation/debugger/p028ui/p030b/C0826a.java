package com.applovin.impl.mediation.debugger.p028ui.p030b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.applovin.impl.adview.C0564a;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.p030b.C0835b;
import com.applovin.impl.mediation.debugger.p028ui.p030b.p031a.C0833a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0844a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.sdk.C0923a;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a */
public class C0826a extends C0808a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0835b f1044a;

    /* renamed from: b */
    private DataSetObserver f1045b;

    /* renamed from: c */
    private FrameLayout f1046c;

    /* renamed from: d */
    private ListView f1047d;

    /* renamed from: e */
    private C0564a f1048e;

    /* renamed from: a */
    private void m1241a() {
        String d = this.f1044a.mo8666d().mo9329E().mo8557d();
        if (!TextUtils.isEmpty(d)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", d);
            intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
            intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
            startActivity(Intent.createChooser(intent, (CharSequence) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1242a(final Context context) {
        if (C1155o.m2673b(this.f1044a.mo8669g()) && !this.f1044a.mo8665c()) {
            this.f1044a.mo8663a(true);
            runOnUiThread(new Runnable() {
                public void run() {
                    C1160r.m2723a(C0826a.this.f1044a.mo8668f(), C0826a.this.f1044a.mo8669g(), context);
                }
            });
        }
    }

    /* renamed from: b */
    private void m1247b() {
        m1249c();
        C0564a aVar = new C0564a(this, 50, 16842874);
        this.f1048e = aVar;
        aVar.setColor(-3355444);
        this.f1046c.addView(this.f1048e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f1046c.bringChildToFront(this.f1048e);
        this.f1048e.mo7946a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1249c() {
        C0564a aVar = this.f1048e;
        if (aVar != null) {
            aVar.mo7947b();
            this.f1046c.removeView(this.f1048e);
            this.f1048e = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(C1199R.layout.list_view);
        this.f1046c = (FrameLayout) findViewById(16908290);
        this.f1047d = (ListView) findViewById(C1199R.C1201id.listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1199R.C1202menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1044a.unregisterDataSetObserver(this.f1045b);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (C1199R.C1201id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m1241a();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f1047d.setAdapter(this.f1044a);
        if (!this.f1044a.mo8664a()) {
            m1247b();
        }
    }

    public void setListAdapter(C0835b bVar, final C0923a aVar) {
        DataSetObserver dataSetObserver;
        C0835b bVar2 = this.f1044a;
        if (!(bVar2 == null || (dataSetObserver = this.f1045b) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f1044a = bVar;
        this.f1045b = new DataSetObserver() {
            public void onChanged() {
                C0826a.this.m1249c();
                C0826a aVar = C0826a.this;
                aVar.m1242a((Context) aVar);
            }
        };
        m1242a((Context) this);
        this.f1044a.registerDataSetObserver(this.f1045b);
        this.f1044a.mo8704a((C0850d.C0851a) new C0850d.C0851a() {
            /* renamed from: a */
            public void mo8627a(C0844a aVar, final C0846c cVar) {
                C0826a aVar2;
                String str;
                String str2;
                int a = aVar.mo8676a();
                if (a == C0835b.C0838b.MAX.ordinal()) {
                    C1160r.m2723a(cVar.mo8685l(), cVar.mo8686m(), (Context) C0826a.this);
                } else if (a == C0835b.C0838b.ADS.ordinal()) {
                    if (aVar.mo8677b() == C0835b.C0837a.AD_UNITS.ordinal()) {
                        if (C0826a.this.f1044a.mo8667e().size() > 0) {
                            C0826a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, aVar, new C0808a.C0810a<MaxDebuggerAdUnitsListActivity>() {
                                /* renamed from: a */
                                public void mo8623a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(C0826a.this.f1044a.mo8667e(), C0826a.this.f1044a.mo8666d());
                                }
                            });
                            return;
                        }
                        aVar2 = C0826a.this;
                        str = "No live ad units";
                        str2 = "Please setup or enable your MAX ad units on https://applovin.com.";
                    } else if (aVar.mo8677b() != C0835b.C0837a.SELECT_LIVE_NETWORKS.ordinal()) {
                        return;
                    } else {
                        if (C0826a.this.f1044a.mo8670h().size() <= 0) {
                            aVar2 = C0826a.this;
                            str = "Complete Integrations";
                            str2 = "Please complete integrations in order to access this.";
                        } else if (C0826a.this.f1044a.mo8666d().mo9332H().mo8729a()) {
                            C1160r.m2723a("Restart Required", cVar.mo8686m(), (Context) C0826a.this);
                            return;
                        } else {
                            C0826a.this.startActivity(MaxDebuggerTestLiveNetworkActivity.class, aVar, new C0808a.C0810a<MaxDebuggerTestLiveNetworkActivity>() {
                                /* renamed from: a */
                                public void mo8623a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                    maxDebuggerTestLiveNetworkActivity.initialize(C0826a.this.f1044a.mo8670h(), C0826a.this.f1044a.mo8666d());
                                }
                            });
                            return;
                        }
                    }
                    C1160r.m2723a(str, str2, (Context) aVar2);
                } else if ((a == C0835b.C0838b.INCOMPLETE_NETWORKS.ordinal() || a == C0835b.C0838b.COMPLETED_NETWORKS.ordinal()) && (cVar instanceof C0833a)) {
                    C0826a.this.startActivity(MaxDebuggerDetailActivity.class, aVar, new C0808a.C0810a<MaxDebuggerDetailActivity>() {
                        /* renamed from: a */
                        public void mo8623a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((C0833a) cVar).mo8655d());
                        }
                    });
                }
            }
        });
    }
}
