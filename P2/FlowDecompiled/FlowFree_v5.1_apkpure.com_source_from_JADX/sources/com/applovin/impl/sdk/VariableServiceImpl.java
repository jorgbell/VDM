package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1012l;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a */
    private final C1062k f1376a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicBoolean f1377b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f1378c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinVariableService.OnVariablesUpdateListener f1379d;

    /* renamed from: e */
    private Bundle f1380e;

    /* renamed from: f */
    private final Object f1381f = new Object();

    VariableServiceImpl(C1062k kVar) {
        this.f1376a = kVar;
        String str = (String) kVar.mo9351a(C0967d.f1855j);
        if (C1155o.m2673b(str)) {
            updateVariables(C1123j.m2578a(str, kVar));
        }
    }

    /* renamed from: a */
    private Object m1505a(String str, Object obj, Class<?> cls) {
        if (TextUtils.isEmpty(str)) {
            C1107r.m2484i("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return obj;
        }
        if (!this.f1376a.mo9388d()) {
            C1107r.m2483h("AppLovinSdk", "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        synchronized (this.f1381f) {
            if (this.f1380e == null) {
                C1107r.m2484i("AppLovinVariableService", "Unable to retrieve variable value for name \"" + str + "\". No variables returned by the server.");
                return obj;
            } else if (cls.equals(String.class)) {
                String string = this.f1380e.getString(str, (String) obj);
                return string;
            } else if (cls.equals(Boolean.class)) {
                Boolean valueOf = Boolean.valueOf(this.f1380e.getBoolean(str, ((Boolean) obj).booleanValue()));
                return valueOf;
            } else {
                throw new IllegalStateException("Unable to retrieve variable value for " + str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1507a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f1381f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r4.f1379d     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            android.os.Bundle r1 = r4.f1380e     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000c
            goto L_0x001d
        L_0x000c:
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x001f }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x001f }
            r2 = 1
            com.applovin.impl.sdk.VariableServiceImpl$2 r3 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x001f }
            r3.<init>(r1)     // Catch:{ all -> 0x001f }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r2, r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.m1507a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) m1505a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        return (String) m1505a(str, str2, String.class);
    }

    @Deprecated
    public void loadVariables() {
        String str;
        if (!this.f1376a.mo9388d()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else if (this.f1377b.compareAndSet(false, true)) {
            this.f1376a.mo9340Q().mo9266a((C0989a) new C1012l(this.f1376a, new C1012l.C1014a() {
                /* renamed from: a */
                public void mo8942a() {
                    VariableServiceImpl.this.f1377b.set(false);
                }
            }), C1020o.C1022a.BACKGROUND);
            return;
        } else {
            str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
        }
        C1107r.m2484i("AppLovinVariableService", str);
    }

    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f1379d = onVariablesUpdateListener;
        synchronized (this.f1381f) {
            if (onVariablesUpdateListener != null) {
                if (this.f1380e != null && this.f1378c.compareAndSet(false, true)) {
                    this.f1376a.mo9411z().mo9584b("AppLovinVariableService", "Setting initial listener");
                    m1507a();
                }
            }
        }
    }

    public String toString() {
        return "VariableService{variables=" + this.f1380e + ", listener=" + this.f1379d + '}';
    }

    public void updateVariables(JSONObject jSONObject) {
        C1107r z = this.f1376a.mo9411z();
        z.mo9584b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        synchronized (this.f1381f) {
            this.f1380e = C1123j.m2602c(jSONObject);
            m1507a();
            this.f1376a.mo9357a(C0967d.f1855j, jSONObject.toString());
        }
    }
}
