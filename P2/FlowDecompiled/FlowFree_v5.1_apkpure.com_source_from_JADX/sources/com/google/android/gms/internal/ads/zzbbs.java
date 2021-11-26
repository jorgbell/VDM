package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbbs extends ScheduledThreadPoolExecutor {
    zzbbs(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
