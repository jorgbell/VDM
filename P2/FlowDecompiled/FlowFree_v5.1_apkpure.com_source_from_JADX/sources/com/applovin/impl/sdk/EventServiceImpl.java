package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.network.C1094f;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f1368a;

    /* renamed from: b */
    private final Map<String, Object> f1369b;

    /* renamed from: c */
    private final AtomicBoolean f1370c = new AtomicBoolean();

    public EventServiceImpl(C1062k kVar) {
        this.f1368a = kVar;
        if (((Boolean) kVar.mo9350a(C0965b.f1600aY)).booleanValue()) {
            this.f1369b = C1123j.m2576a((String) kVar.mo9379b(C0967d.f1864s, "{}"), (Map<String, Object>) new HashMap(), kVar);
            return;
        }
        this.f1369b = new HashMap();
        kVar.mo9357a(C0967d.f1864s, "{}");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m1496a() {
        return ((String) this.f1368a.mo9350a(C0965b.f1592aQ)) + "4.0/pix";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m1499a(C1102o oVar, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        boolean contains = this.f1368a.mo9381b(C0965b.f1598aW).contains(oVar.mo9555a());
        hashMap.put("AppLovin-Event", contains ? oVar.mo9555a() : "postinstall");
        if (!contains) {
            hashMap.put("AppLovin-Sub-Event", oVar.mo9555a());
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m1500a(C1102o oVar, boolean z) {
        boolean contains = this.f1368a.mo9381b(C0965b.f1598aW).contains(oVar.mo9555a());
        Map<String, Object> a = this.f1368a.mo9343T().mo9426a((Map<String, String>) null, z, false);
        a.put("event", contains ? oVar.mo9555a() : "postinstall");
        a.put("event_id", oVar.mo9558d());
        a.put("ts", Long.toString(oVar.mo9557c()));
        if (!contains) {
            a.put("sub_event", oVar.mo9555a());
        }
        return C1160r.m2719a(a);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m1501b() {
        return ((String) this.f1368a.mo9350a(C0965b.f1593aR)) + "4.0/pix";
    }

    /* renamed from: c */
    private void m1504c() {
        if (((Boolean) this.f1368a.mo9350a(C0965b.f1600aY)).booleanValue()) {
            this.f1368a.mo9357a(C0967d.f1864s, C1123j.m2571a(this.f1369b, "{}", this.f1368a));
        }
    }

    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f1369b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f1370c.compareAndSet(false, true)) {
            this.f1368a.mo9406u().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            C1107r.m2484i("AppLovinEventService", "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.f1369b.remove(str);
            m1504c();
        } else {
            List<String> b = this.f1368a.mo9381b(C0965b.f1599aX);
            if (!C1160r.m2734a(obj, b, this.f1368a)) {
                C1107r.m2484i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b);
                return;
            }
            this.f1369b.put(str, C1160r.m2707a(obj, this.f1368a));
            m1504c();
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap(1);
        }
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        C1107r z = this.f1368a.mo9411z();
        z.mo9584b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        final C1102o oVar = new C1102o(str, map, this.f1369b);
        try {
            this.f1368a.mo9340Q().mo9266a((C0989a) new C1042y(this.f1368a, new Runnable() {
                public void run() {
                    EventServiceImpl.this.f1368a.mo9342S().mo9499a(C1094f.m2366o().mo9528c(EventServiceImpl.this.m1496a()).mo9531d(EventServiceImpl.this.m1501b()).mo9522a((Map<String, String>) EventServiceImpl.this.m1500a(oVar, false)).mo9526b((Map<String, String>) EventServiceImpl.this.m1499a(oVar, (Map<String, String>) map2)).mo9529c(oVar.mo9556b()).mo9527b(((Boolean) EventServiceImpl.this.f1368a.mo9350a(C0965b.f1827et)).booleanValue()).mo9523a(((Boolean) EventServiceImpl.this.f1368a.mo9350a(C0965b.f1818ek)).booleanValue()).mo9524a());
                }
            }), C1020o.C1022a.BACKGROUND);
        } catch (Throwable th) {
            C1107r z2 = this.f1368a.mo9411z();
            z2.mo9585b("AppLovinEventService", "Unable to track event: " + oVar, th);
        }
    }

    public void trackEventSynchronously(String str) {
        C1107r z = this.f1368a.mo9411z();
        z.mo9584b("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        C1102o oVar = new C1102o(str, new HashMap(), this.f1369b);
        this.f1368a.mo9342S().mo9499a(C1094f.m2366o().mo9528c(m1496a()).mo9531d(m1501b()).mo9522a(m1500a(oVar, true)).mo9526b(m1499a(oVar, (Map<String, String>) null)).mo9529c(oVar.mo9556b()).mo9527b(((Boolean) this.f1368a.mo9350a(C0965b.f1827et)).booleanValue()).mo9523a(((Boolean) this.f1368a.mo9350a(C0965b.f1818ek)).booleanValue()).mo9524a());
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            C1107r.m2480c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
        }
        trackEvent("iap", hashMap);
    }
}
