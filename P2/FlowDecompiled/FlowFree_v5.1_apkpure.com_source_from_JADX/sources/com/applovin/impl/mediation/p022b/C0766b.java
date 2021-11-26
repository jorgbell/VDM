package com.applovin.impl.mediation.p022b;

import android.app.Activity;
import com.applovin.impl.mediation.p021a.C0738f;
import com.applovin.impl.mediation.p021a.C0740g;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.MaxAdFormat;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.b */
public class C0766b extends C0989a {

    /* renamed from: a */
    private static String f851a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdFormat f852c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Activity f853d;

    /* renamed from: e */
    private final C0770a f854e;

    /* renamed from: com.applovin.impl.mediation.b.b$a */
    public interface C0770a {
        /* renamed from: a */
        void mo8528a(JSONArray jSONArray);
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m1033a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            m1033a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f851a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C0766b(MaxAdFormat maxAdFormat, Activity activity, C1062k kVar, C0770a aVar) {
        super("TaskCollectSignals", kVar);
        this.f852c = maxAdFormat;
        this.f853d = activity;
        this.f854e = aVar;
    }

    /* renamed from: a */
    private static JSONObject m1033a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MediationMetaData.KEY_NAME, str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", 30000);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1034a(final C0740g gVar, final C0738f.C0739a aVar) {
        C07692 r0 = new Runnable() {
            public void run() {
                C0766b.this.f1980b.mo9327C().collectSignal(C0766b.this.f852c, gVar, C0766b.this.f853d, aVar);
            }
        };
        if (gVar.mo8449P()) {
            mo9211a("Running signal collection for " + gVar + " on the main thread");
            this.f853d.runOnUiThread(r0);
            return;
        }
        mo9211a("Running signal collection for " + gVar + " on the background thread");
        r0.run();
    }

    /* renamed from: a */
    private void m1036a(Collection<C0738f> collection) {
        String str;
        String d;
        JSONArray jSONArray = new JSONArray();
        for (C0738f next : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0740g a = next.mo8474a();
                jSONObject.put(MediationMetaData.KEY_NAME, a.mo8443J());
                jSONObject.put("class", a.mo8442I());
                jSONObject.put("adapter_version", next.mo8476c());
                jSONObject.put("sdk_version", next.mo8475b());
                JSONObject jSONObject2 = new JSONObject();
                if (C1155o.m2673b(next.mo8478e())) {
                    str = "error_message";
                    d = next.mo8478e();
                } else {
                    str = "signal";
                    d = next.mo8477d();
                }
                jSONObject2.put(str, d);
                jSONObject.put("data", jSONObject2);
                jSONArray.put(jSONObject);
                mo9211a("Collected signal from " + a);
            } catch (JSONException e) {
                mo9212a("Failed to create signal data", e);
            }
        }
        m1037a(jSONArray);
    }

    /* renamed from: a */
    private void m1037a(JSONArray jSONArray) {
        C0770a aVar = this.f854e;
        if (aVar != null) {
            aVar.mo8528a(jSONArray);
        }
    }

    /* renamed from: a */
    private void m1038a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        List a = C1117e.m2520a(jSONArray.length());
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        CountDownLatch countDownLatch = new CountDownLatch(jSONArray.length());
        ScheduledExecutorService b = this.f1980b.mo9340Q().mo9270b();
        for (int i = 0; i < jSONArray.length(); i++) {
            final C0740g gVar = new C0740g(jSONArray.getJSONObject(i), jSONObject, this.f1980b);
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final List list = a;
            final CountDownLatch countDownLatch2 = countDownLatch;
            b.execute(new Runnable() {
                public void run() {
                    C0766b.this.m1034a(gVar, (C0738f.C0739a) new C0738f.C0739a() {
                        /* renamed from: a */
                        public void mo8480a(C0738f fVar) {
                            if (atomicBoolean2.get() && fVar != null) {
                                list.add(fVar);
                            }
                            countDownLatch2.countDown();
                        }
                    });
                }
            });
        }
        countDownLatch.await(((Long) this.f1980b.mo9350a(C0964a.f1552k)).longValue(), TimeUnit.MILLISECONDS);
        atomicBoolean.set(false);
        m1036a((Collection<C0738f>) a);
    }

    /* renamed from: b */
    private void m1040b(String str, Throwable th) {
        mo9212a("No signals collected: " + str, th);
        m1037a(new JSONArray());
    }

    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f1980b.mo9379b(C0967d.f1869x, f851a));
            JSONArray b = C1123j.m2599b(jSONObject, "signal_providers", (JSONArray) null, this.f1980b);
            if (b.length() == 0) {
                m1040b("No signal providers found", (Throwable) null);
            } else {
                m1038a(b, jSONObject);
            }
        } catch (JSONException e) {
            th = e;
            str = "Failed to parse signals JSON";
            m1040b(str, th);
        } catch (InterruptedException e2) {
            th = e2;
            str = "Failed to wait for signals";
            m1040b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            m1040b(str, th);
        }
    }
}
