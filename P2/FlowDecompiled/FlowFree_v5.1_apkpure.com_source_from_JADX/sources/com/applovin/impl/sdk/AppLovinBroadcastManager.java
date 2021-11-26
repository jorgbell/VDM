package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppLovinBroadcastManager {

    /* renamed from: f */
    private static AppLovinBroadcastManager f1349f;

    /* renamed from: g */
    private static final Object f1350g = new Object();

    /* renamed from: a */
    private final Context f1351a;

    /* renamed from: b */
    private final HashMap<Receiver, ArrayList<C0919b>> f1352b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C0919b>> f1353c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C0918a> f1354d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f1355e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.this.m1493a();
            } else {
                super.handleMessage(message);
            }
        }
    };

    public interface Receiver {
        void onReceive(Context context, Intent intent, Map<String, Object> map);
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$a */
    private static class C0918a {

        /* renamed from: a */
        final Intent f1357a;

        /* renamed from: b */
        final Map<String, Object> f1358b;

        /* renamed from: c */
        final List<C0919b> f1359c;

        C0918a(Intent intent, Map<String, Object> map, List<C0919b> list) {
            this.f1357a = intent;
            this.f1358b = map;
            this.f1359c = list;
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$b */
    private static class C0919b {

        /* renamed from: a */
        final IntentFilter f1360a;

        /* renamed from: b */
        final Receiver f1361b;

        /* renamed from: c */
        boolean f1362c;

        /* renamed from: d */
        boolean f1363d;

        C0919b(IntentFilter intentFilter, Receiver receiver) {
            this.f1360a = intentFilter;
            this.f1361b = receiver;
        }
    }

    private AppLovinBroadcastManager(Context context) {
        this.f1351a = context;
    }

    /* renamed from: a */
    private List<C0919b> m1492a(Intent intent) {
        synchronized (this.f1352b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1351a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            List<C0919b> list = this.f1353c.get(action);
            if (list == null) {
                return null;
            }
            ArrayList<C0919b> arrayList = null;
            for (C0919b bVar : list) {
                if (!bVar.f1362c) {
                    C0919b bVar2 = bVar;
                    if (bVar.f1360a.match(action, resolveTypeIfNeeded, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(bVar2);
                        bVar2.f1362c = true;
                        arrayList = arrayList2;
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            for (C0919b bVar3 : arrayList) {
                bVar3.f1362c = false;
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r0 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r3 = r2[r0];
        r4 = r3.f1359c.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r4.hasNext() == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r5 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r5.f1363d != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r5.f1361b.onReceive(r9.f1351a, r3.f1357a, r3.f1358b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1493a() {
        /*
            r9 = this;
        L_0x0000:
            java.util.HashMap<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r9.f1352b
            monitor-enter(r0)
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r1 = r9.f1354d     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            com.applovin.impl.sdk.AppLovinBroadcastManager$a[] r2 = new com.applovin.impl.sdk.AppLovinBroadcastManager.C0918a[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r3 = r9.f1354d     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r3 = r9.f1354d     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
        L_0x001b:
            if (r0 >= r1) goto L_0x0000
            r3 = r2[r0]
            java.util.List<com.applovin.impl.sdk.AppLovinBroadcastManager$b> r4 = r3.f1359c
            java.util.Iterator r4 = r4.iterator()
        L_0x0025:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0041
            java.lang.Object r5 = r4.next()
            com.applovin.impl.sdk.AppLovinBroadcastManager$b r5 = (com.applovin.impl.sdk.AppLovinBroadcastManager.C0919b) r5
            boolean r6 = r5.f1363d
            if (r6 != 0) goto L_0x0025
            com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver r5 = r5.f1361b
            android.content.Context r6 = r9.f1351a
            android.content.Intent r7 = r3.f1357a
            java.util.Map<java.lang.String, java.lang.Object> r8 = r3.f1358b
            r5.onReceive(r6, r7, r8)
            goto L_0x0025
        L_0x0041:
            int r0 = r0 + 1
            goto L_0x001b
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0047:
            throw r1
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.m1493a():void");
    }

    public static AppLovinBroadcastManager getInstance(Context context) {
        AppLovinBroadcastManager appLovinBroadcastManager;
        synchronized (f1350g) {
            if (f1349f == null) {
                f1349f = new AppLovinBroadcastManager(context.getApplicationContext());
            }
            appLovinBroadcastManager = f1349f;
        }
        return appLovinBroadcastManager;
    }

    public void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        synchronized (this.f1352b) {
            C0919b bVar = new C0919b(intentFilter, receiver);
            ArrayList arrayList = this.f1352b.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f1352b.put(receiver, arrayList);
            }
            arrayList.add(bVar);
            Iterator<String> actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                ArrayList arrayList2 = this.f1353c.get(next);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f1353c.put(next, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            java.util.HashMap<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r4.f1352b
            monitor-enter(r0)
            java.util.List r1 = r4.m1492a((android.content.Intent) r5)     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x000c
            r5 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r5
        L_0x000c:
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = r4.f1354d     // Catch:{ all -> 0x0026 }
            com.applovin.impl.sdk.AppLovinBroadcastManager$a r3 = new com.applovin.impl.sdk.AppLovinBroadcastManager$a     // Catch:{ all -> 0x0026 }
            r3.<init>(r5, r6, r1)     // Catch:{ all -> 0x0026 }
            r2.add(r3)     // Catch:{ all -> 0x0026 }
            android.os.Handler r5 = r4.f1355e     // Catch:{ all -> 0x0026 }
            r6 = 1
            boolean r5 = r5.hasMessages(r6)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0024
            android.os.Handler r5 = r4.f1355e     // Catch:{ all -> 0x0026 }
            r5.sendEmptyMessage(r6)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r6
        L_0x0026:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.sendBroadcast(android.content.Intent, java.util.Map):boolean");
    }

    public void sendBroadcastSync(Intent intent, Map<String, Object> map) {
        List<C0919b> a = m1492a(intent);
        if (a != null) {
            for (C0919b next : a) {
                if (!next.f1363d) {
                    next.f1361b.onReceive(this.f1351a, intent, map);
                }
            }
        }
    }

    public void sendBroadcastSyncWithPendingBroadcasts(Intent intent, Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            m1493a();
        }
    }

    public boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("ad", obj);
        return sendBroadcast(new Intent(str), hashMap);
    }

    public void unregisterReceiver(Receiver receiver) {
        synchronized (this.f1352b) {
            List<C0919b> remove = this.f1352b.remove(receiver);
            if (remove != null) {
                for (C0919b bVar : remove) {
                    bVar.f1363d = true;
                    Iterator<String> actionsIterator = bVar.f1360a.actionsIterator();
                    while (actionsIterator.hasNext()) {
                        String next = actionsIterator.next();
                        List list = this.f1353c.get(next);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (((C0919b) it.next()).f1361b == receiver) {
                                    bVar.f1363d = true;
                                    it.remove();
                                }
                            }
                            if (list.size() <= 0) {
                                this.f1353c.remove(next);
                            }
                        }
                    }
                }
            }
        }
    }
}
