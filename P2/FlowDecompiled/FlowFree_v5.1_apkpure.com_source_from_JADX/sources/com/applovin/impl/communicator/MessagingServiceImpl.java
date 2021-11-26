package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f713a;

    /* renamed from: b */
    private final ScheduledThreadPoolExecutor f714b;

    /* renamed from: c */
    private final Queue<CommunicatorMessageImpl> f715c = new LinkedList();

    /* renamed from: d */
    private final Object f716d = new Object();

    public MessagingServiceImpl(Context context) {
        this.f713a = context;
        this.f714b = m836a();
    }

    /* renamed from: a */
    private Queue<CommunicatorMessageImpl> m835a(String str) {
        LinkedList linkedList;
        synchronized (this.f716d) {
            linkedList = new LinkedList();
            for (CommunicatorMessageImpl communicatorMessageImpl : this.f715c) {
                if (communicatorMessageImpl.mo8322a() && communicatorMessageImpl.getTopic().equals(str)) {
                    linkedList.add(communicatorMessageImpl);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m836a() {
        return new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    /* renamed from: a */
    private void m837a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f714b.execute(new Runnable() {
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f713a).sendBroadcastSync(communicatorMessageImpl, (Map<String, Object>) null);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl a : m835a(str)) {
            m837a(a);
        }
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        m837a((CommunicatorMessageImpl) appLovinCommunicatorMessage);
        synchronized (this.f716d) {
            this.f715c.add(appLovinCommunicatorMessage);
        }
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}
