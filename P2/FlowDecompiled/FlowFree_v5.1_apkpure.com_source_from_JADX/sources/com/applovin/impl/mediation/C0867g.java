package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.mediation.p022b.C0764a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.mopub.network.ImpressionData;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.g */
public class C0867g {

    /* renamed from: a */
    private final C1062k f1214a;

    /* renamed from: b */
    private final C1107r f1215b;

    /* renamed from: c */
    private final AtomicBoolean f1216c = new AtomicBoolean();

    /* renamed from: d */
    private final JSONArray f1217d = new JSONArray();

    /* renamed from: e */
    private final LinkedHashSet<String> f1218e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f1219f = new Object();

    /* renamed from: g */
    private boolean f1220g;

    public C0867g(C1062k kVar) {
        this.f1214a = kVar;
        this.f1215b = kVar.mo9411z();
    }

    /* renamed from: a */
    public void mo8739a(Activity activity) {
        boolean z = false;
        if (this.f1216c.compareAndSet(false, true)) {
            if (activity == null) {
                z = true;
            }
            this.f1220g = z;
            this.f1214a.mo9340Q().mo9265a((C0989a) new C0764a(activity, this.f1214a));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8740a(C0737e eVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.f1219f) {
                z = !mo8743a(eVar);
                if (z) {
                    this.f1218e.add(eVar.mo8442I());
                    JSONObject jSONObject = new JSONObject();
                    C1123j.m2584a(jSONObject, "class", eVar.mo8442I(), this.f1214a);
                    C1123j.m2584a(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()), this.f1214a);
                    C1123j.m2584a(jSONObject, "error_message", JSONObject.quote(str), this.f1214a);
                    this.f1217d.put(jSONObject);
                }
            }
            if (z) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "DID_INITIALIZE");
                bundle.putString(ImpressionData.NETWORK_NAME, eVar.mo8443J());
                bundle.putInt("initialization_status", initializationStatus.getCode());
                if (C1155o.m2673b(str)) {
                    bundle.putString("error_message", str);
                }
                this.f1214a.mo9372ag().mo9302a(bundle, "max_adapter_events");
                this.f1214a.mo9356a(eVar);
                this.f1214a.mo9327C().processAdapterInitializationPostback(eVar, j, initializationStatus, str);
                this.f1214a.mo9372ag().mo9305a(initializationStatus, eVar.mo8442I());
            }
        }
    }

    /* renamed from: a */
    public void mo8741a(C0737e eVar, Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("type", "WILL_INITIALIZE");
        bundle.putString(ImpressionData.NETWORK_NAME, eVar.mo8443J());
        this.f1214a.mo9372ag().mo9302a(bundle, "max_adapter_events");
        C0870i a = this.f1214a.mo9325A().mo8747a(eVar);
        if (a != null) {
            C1107r rVar = this.f1215b;
            rVar.mo9586c("MediationAdapterInitializationManager", "Initializing adapter " + eVar);
            a.mo8758a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.m846a(eVar), activity);
        }
    }

    /* renamed from: a */
    public boolean mo8742a() {
        return this.f1216c.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8743a(C0737e eVar) {
        boolean contains;
        synchronized (this.f1219f) {
            contains = this.f1218e.contains(eVar.mo8442I());
        }
        return contains;
    }

    /* renamed from: b */
    public boolean mo8744b() {
        return this.f1220g;
    }

    /* renamed from: c */
    public LinkedHashSet<String> mo8745c() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f1219f) {
            linkedHashSet = this.f1218e;
        }
        return linkedHashSet;
    }

    /* renamed from: d */
    public JSONArray mo8746d() {
        JSONArray jSONArray;
        synchronized (this.f1219f) {
            jSONArray = this.f1217d;
        }
        return jSONArray;
    }
}
