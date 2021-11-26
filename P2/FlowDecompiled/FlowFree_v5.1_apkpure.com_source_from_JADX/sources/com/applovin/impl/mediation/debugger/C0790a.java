package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0796a;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p027b.C0806a;
import com.applovin.impl.mediation.debugger.p028ui.p030b.C0835b;
import com.applovin.impl.sdk.C1048h;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a */
public class C0790a implements AppLovinCommunicatorSubscriber, C1081a.C1084c<JSONObject> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WeakReference<MaxDebuggerActivity> f911a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final AtomicBoolean f912b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1062k f913c;

    /* renamed from: d */
    private final C1107r f914d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0835b f915e;

    /* renamed from: f */
    private final Map<String, C0801b> f916f = new HashMap();

    /* renamed from: g */
    private final StringBuilder f917g = new StringBuilder("");

    /* renamed from: h */
    private final AtomicBoolean f918h = new AtomicBoolean();

    /* renamed from: i */
    private boolean f919i;

    /* renamed from: j */
    private final Context f920j;

    public C0790a(C1062k kVar) {
        this.f913c = kVar;
        this.f914d = kVar.mo9411z();
        Context J = kVar.mo9334J();
        this.f920j = J;
        this.f915e = new C0835b(J);
    }

    /* renamed from: a */
    private List<C0801b> m1121a(JSONObject jSONObject, C1062k kVar) {
        JSONArray b = C1123j.m2599b(jSONObject, "networks", new JSONArray(), kVar);
        ArrayList arrayList = new ArrayList(b.length());
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1123j.m2581a(b, i, (JSONObject) null, kVar);
            if (a != null) {
                C0801b bVar = new C0801b(a, kVar);
                arrayList.add(bVar);
                this.f916f.put(bVar.mo8599l(), bVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private List<C0796a> m1122a(JSONObject jSONObject, List<C0801b> list, C1062k kVar) {
        JSONArray b = C1123j.m2599b(jSONObject, "ad_units", new JSONArray(), kVar);
        ArrayList arrayList = new ArrayList(b.length());
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1123j.m2581a(b, i, (JSONObject) null, kVar);
            if (a != null) {
                arrayList.add(new C0796a(a, this.f916f, kVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m1123a(List<C0801b> list) {
        boolean z;
        Iterator<C0801b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C0801b next = it.next();
            if (next.mo8592e() && next.mo8587a() == C0801b.C0802a.INVALID_INTEGRATION) {
                z = true;
                break;
            }
        }
        if (z) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    new AlertDialog.Builder(C0790a.this.f913c.mo9370ae().mo8944a()).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C0790a.this.mo8556c();
                        }
                    }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
                }
            }, TimeUnit.SECONDS.toMillis(2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m1129g() {
        WeakReference<MaxDebuggerActivity> weakReference = f911a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    public void mo8552a() {
        if (this.f918h.compareAndSet(false, true)) {
            this.f913c.mo9340Q().mo9266a((C0989a) new C0806a(this, this.f913c), C1020o.C1022a.MEDIATION_MAIN);
        }
    }

    /* renamed from: a */
    public void mo8530a(int i) {
        C1107r rVar = this.f914d;
        rVar.mo9588e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        C1107r.m2484i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f915e.mo8662a((List<C0801b>) null, (List<C0796a>) null, (String) null, (String) null, (String) null, this.f913c);
        this.f918h.set(false);
    }

    /* renamed from: a */
    public void mo8531a(JSONObject jSONObject, int i) {
        Map<String, String> a;
        List<C0801b> a2 = m1121a(jSONObject, this.f913c);
        List<C0796a> a3 = m1122a(jSONObject, a2, this.f913c);
        JSONObject b = C1123j.m2600b(jSONObject, "alert", (JSONObject) null, this.f913c);
        this.f915e.mo8662a(a2, a3, C1123j.m2594b(b, "title", (String) null, this.f913c), C1123j.m2594b(b, "message", (String) null, this.f913c), C1123j.m2594b(jSONObject, "account_id", (String) null, this.f913c), this.f913c);
        AppLovinCommunicator.getInstance(this.f920j).subscribe((AppLovinCommunicatorSubscriber) this, "privacy_setting_updated");
        if (mo8555b()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0790a.this.mo8556c();
                }
            }, TimeUnit.SECONDS.toMillis(2));
        } else {
            m1123a(a2);
        }
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + C1160r.m2756e(this.f920j));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f913c.mo9332H().mo8729a() ? "enabled" : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f913c.mo9343T().mo9433g().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f913c.mo9350a(C0965b.f1779du);
        String f = C1160r.m2758f();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nPlugin Version - ");
        String str3 = "None";
        if (!C1155o.m2673b(str2)) {
            str2 = str3;
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!C1155o.m2673b(f)) {
            f = "Disabled";
        }
        sb4.append(f);
        sb.append(sb4.toString());
        if (this.f913c.mo9391g() && (a = C1160r.m2718a(this.f913c.mo9400p())) != null) {
            String str4 = a.get("UnityVersion");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nUnity Version - ");
            if (C1155o.m2673b(str4)) {
                str3 = str4;
            }
            sb5.append(str3);
            sb.append(sb5.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(C1048h.m2072a(this.f920j));
        sb.append("\n========== NETWORKS ==========");
        for (C0801b t : a2) {
            String sb6 = sb.toString();
            String t2 = t.mo8607t();
            if (sb6.length() + t2.length() >= ((Integer) this.f913c.mo9350a(C0965b.f1610ai)).intValue()) {
                C1107r.m2481f("MediationDebuggerService", sb6);
                this.f917g.append(sb6);
                sb.setLength(1);
            }
            sb.append(t2);
        }
        sb.append("\n========== AD UNITS ==========");
        for (C0796a f2 : a3) {
            String sb7 = sb.toString();
            String f3 = f2.mo8571f();
            if (sb7.length() + f3.length() >= ((Integer) this.f913c.mo9350a(C0965b.f1610ai)).intValue()) {
                C1107r.m2481f("MediationDebuggerService", sb7);
                this.f917g.append(sb7);
                sb.setLength(1);
            }
            sb.append(f3);
        }
        sb.append("\n========== END ==========");
        C1107r.m2481f("MediationDebuggerService", sb.toString());
        this.f917g.append(sb.toString());
    }

    /* renamed from: a */
    public void mo8554a(boolean z) {
        this.f919i = z;
    }

    /* renamed from: b */
    public boolean mo8555b() {
        return this.f919i;
    }

    /* renamed from: c */
    public void mo8556c() {
        mo8552a();
        if (m1129g() || !f912b.compareAndSet(false, true)) {
            C1107r.m2484i("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        this.f913c.mo9370ae().mo8945a(new C1112a() {
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1107r.m2481f("AppLovinSdk", "Mediation debugger destroyed");
                    C0790a.this.f913c.mo9370ae().mo8947b(this);
                    WeakReference unused = C0790a.f911a = null;
                }
            }

            public void onActivityStarted(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1107r.m2481f("AppLovinSdk", "Started mediation debugger");
                    if (!C0790a.this.m1129g() || C0790a.f911a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = C0790a.f911a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(C0790a.this.f915e, C0790a.this.f913c.mo9370ae());
                    }
                    C0790a.f912b.set(false);
                }
            }
        });
        Intent intent = new Intent(this.f920j, MaxDebuggerActivity.class);
        intent.setFlags(268435456);
        C1107r.m2481f("AppLovinSdk", "Starting mediation debugger...");
        this.f920j.startActivity(intent);
    }

    /* renamed from: d */
    public String mo8557d() {
        return this.f917g.toString();
    }

    public String getCommunicatorId() {
        return "MediationDebuggerService";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C0790a.this.f915e.notifyDataSetChanged();
                }
            });
        }
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f915e + "}";
    }
}
