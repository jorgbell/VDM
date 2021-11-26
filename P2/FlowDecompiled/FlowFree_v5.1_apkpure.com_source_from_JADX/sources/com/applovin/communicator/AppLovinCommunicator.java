package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.C0723a;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {

    /* renamed from: a */
    private static AppLovinCommunicator f132a;

    /* renamed from: b */
    private static final Object f133b = new Object();

    /* renamed from: c */
    private C1062k f134c;

    /* renamed from: d */
    private C1107r f135d;

    /* renamed from: e */
    private final C0723a f136e;

    /* renamed from: f */
    private final MessagingServiceImpl f137f;

    private AppLovinCommunicator(Context context) {
        this.f136e = new C0723a(context);
        this.f137f = new MessagingServiceImpl(context);
    }

    /* renamed from: a */
    private void m195a(String str) {
        C1107r rVar = this.f135d;
        if (rVar != null) {
            rVar.mo9584b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f133b) {
            if (f132a == null) {
                f132a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f132a;
    }

    /* renamed from: a */
    public void mo7799a(C1062k kVar) {
        this.f134c = kVar;
        this.f135d = kVar.mo9411z();
        m195a("Attached SDK instance: " + kVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f137f;
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (this.f136e.mo8328a(appLovinCommunicatorSubscriber, next)) {
                this.f137f.maybeFlushStickyMessages(next);
            } else {
                m195a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f134c + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            m195a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            this.f136e.mo8329b(appLovinCommunicatorSubscriber, next);
        }
    }
}
