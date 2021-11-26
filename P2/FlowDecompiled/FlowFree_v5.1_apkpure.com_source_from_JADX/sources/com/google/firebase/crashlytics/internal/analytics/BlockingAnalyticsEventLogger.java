package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private CountDownLatch eventLatch;
    private final Object latchLock = new Object();
    private final TimeUnit timeUnit;
    private final int timeout;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit2) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.google.firebase.crashlytics.internal.Logger.getLogger().mo22333e("Interrupted while awaiting app exception callback from Analytics listener.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logEvent(java.lang.String r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.latchLock
            monitor-enter(r0)
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r2.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "Logging event "
            r2.append(r3)     // Catch:{ all -> 0x0068 }
            r2.append(r5)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = " to Firebase Analytics with params "
            r2.append(r3)     // Catch:{ all -> 0x0068 }
            r2.append(r6)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0068 }
            r1.mo22337v(r2)     // Catch:{ all -> 0x0068 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0068 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0068 }
            r4.eventLatch = r1     // Catch:{ all -> 0x0068 }
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = r4.baseAnalyticsEventLogger     // Catch:{ all -> 0x0068 }
            r1.logEvent(r5, r6)     // Catch:{ all -> 0x0068 }
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = "Awaiting app exception callback from Analytics..."
            r5.mo22337v(r6)     // Catch:{ all -> 0x0068 }
            java.util.concurrent.CountDownLatch r5 = r4.eventLatch     // Catch:{ InterruptedException -> 0x005a }
            int r6 = r4.timeout     // Catch:{ InterruptedException -> 0x005a }
            long r1 = (long) r6     // Catch:{ InterruptedException -> 0x005a }
            java.util.concurrent.TimeUnit r6 = r4.timeUnit     // Catch:{ InterruptedException -> 0x005a }
            boolean r5 = r5.await(r1, r6)     // Catch:{ InterruptedException -> 0x005a }
            if (r5 == 0) goto L_0x0050
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r6 = "App exception callback received from Analytics listener."
            r5.mo22337v(r6)     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0063
        L_0x0050:
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r6 = "Timeout exceeded while awaiting app exception callback from Analytics listener."
            r5.mo22339w(r6)     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0063
        L_0x005a:
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = "Interrupted while awaiting app exception callback from Analytics listener."
            r5.mo22333e(r6)     // Catch:{ all -> 0x0068 }
        L_0x0063:
            r5 = 0
            r4.eventLatch = r5     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            return
        L_0x0068:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger.logEvent(java.lang.String, android.os.Bundle):void");
    }

    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
