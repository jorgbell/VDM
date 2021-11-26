package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1107r;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.b */
public class C0724b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private boolean f723a = true;

    /* renamed from: b */
    private final String f724b;

    /* renamed from: c */
    private final WeakReference<AppLovinCommunicatorSubscriber> f725c;

    /* renamed from: d */
    private final Set<CommunicatorMessageImpl> f726d = new LinkedHashSet();

    /* renamed from: e */
    private final Object f727e = new Object();

    C0724b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f724b = str;
        this.f725c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    /* renamed from: a */
    public String mo8330a() {
        return this.f724b;
    }

    /* renamed from: a */
    public void mo8331a(boolean z) {
        this.f723a = z;
    }

    /* renamed from: b */
    public AppLovinCommunicatorSubscriber mo8332b() {
        return (AppLovinCommunicatorSubscriber) this.f725c.get();
    }

    /* renamed from: c */
    public boolean mo8333c() {
        return this.f723a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0724b)) {
            return false;
        }
        C0724b bVar = (C0724b) obj;
        if (mo8330a().equals(bVar.mo8330a())) {
            if (this.f725c.get() != null) {
                if (((AppLovinCommunicatorSubscriber) this.f725c.get()).equals(bVar.f725c.get())) {
                    return true;
                }
            } else if (this.f725c.get() == bVar.f725c.get()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f724b.hashCode() * 31) + (this.f725c.get() != null ? ((AppLovinCommunicatorSubscriber) this.f725c.get()).hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (mo8332b() == null) {
            C1107r.m2484i("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.f727e) {
            if (!this.f726d.contains(communicatorMessageImpl)) {
                this.f726d.add(communicatorMessageImpl);
                z = true;
            }
        }
        if (z) {
            mo8332b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }
}
