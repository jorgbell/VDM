package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import com.google.android.play.core.internal.C2058ag;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.missingsplits.b */
final class C2125b implements MissingSplitsManager {

    /* renamed from: a */
    private static final C2058ag f5227a = new C2058ag("MissingSplitsManagerImpl");

    /* renamed from: b */
    private final Context f5228b;

    /* renamed from: c */
    private final Runtime f5229c;

    /* renamed from: d */
    private final C2124a f5230d;

    /* renamed from: e */
    private final AtomicReference<Boolean> f5231e;

    C2125b(Context context, Runtime runtime, C2124a aVar, AtomicReference<Boolean> atomicReference) {
        this.f5228b = context;
        this.f5229c = runtime;
        this.f5230d = aVar;
        this.f5231e = atomicReference;
    }

    @TargetApi(21)
    /* renamed from: d */
    private final List<ActivityManager.AppTask> m5346d() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.f5228b.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        f5227a.mo22028e("App '%s' is not found in PackageManager", r9.f5228b.getPackageName());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean disableAppIfMissingRequiredSplits() {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x01c8
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r3 = r9.f5231e
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r4 = r9.f5231e     // Catch:{ all -> 0x01c5 }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x01c5 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01c5 }
            r5 = 1
            if (r4 != 0) goto L_0x00ab
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r4 = r9.f5231e     // Catch:{ all -> 0x01c5 }
            if (r0 >= r1) goto L_0x001c
        L_0x0019:
            r0 = 0
            goto L_0x00a4
        L_0x001c:
            android.content.Context r6 = r9.f5228b     // Catch:{ all -> 0x01c5 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ all -> 0x01c5 }
            android.content.Context r7 = r9.f5228b     // Catch:{ NameNotFoundException -> 0x0091 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0091 }
            r8 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0091 }
            if (r6 == 0) goto L_0x0019
            android.os.Bundle r6 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0091 }
            if (r6 == 0) goto L_0x0019
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ NameNotFoundException -> 0x0091 }
            java.lang.String r8 = "com.android.vending.splits.required"
            java.lang.Object r6 = r6.get(r8)     // Catch:{ NameNotFoundException -> 0x0091 }
            boolean r6 = r7.equals(r6)     // Catch:{ NameNotFoundException -> 0x0091 }
            if (r6 == 0) goto L_0x0019
            if (r0 >= r1) goto L_0x0049
        L_0x0044:
            java.util.Set r0 = java.util.Collections.emptySet()     // Catch:{ all -> 0x01c5 }
            goto L_0x007b
        L_0x0049:
            android.content.Context r0 = r9.f5228b     // Catch:{ NameNotFoundException -> 0x0069 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0069 }
            android.content.Context r1 = r9.f5228b     // Catch:{ NameNotFoundException -> 0x0069 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException -> 0x0069 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x0069 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ NameNotFoundException -> 0x0069 }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x0069 }
            if (r0 == 0) goto L_0x0067
            java.lang.String[] r0 = r0.splitNames     // Catch:{ NameNotFoundException -> 0x0069 }
            if (r0 == 0) goto L_0x0067
            java.util.Collections.addAll(r1, r0)     // Catch:{ NameNotFoundException -> 0x0069 }
        L_0x0067:
            r0 = r1
            goto L_0x007b
        L_0x0069:
            com.google.android.play.core.internal.ag r0 = f5227a     // Catch:{ all -> 0x01c5 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x01c5 }
            android.content.Context r6 = r9.f5228b     // Catch:{ all -> 0x01c5 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01c5 }
            r1[r2] = r6     // Catch:{ all -> 0x01c5 }
            java.lang.String r6 = "App '%s' is not found in PackageManager"
            r0.mo22028e(r6, r1)     // Catch:{ all -> 0x01c5 }
            goto L_0x0044
        L_0x007b:
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x01c5 }
            if (r1 != 0) goto L_0x008f
            int r1 = r0.size()     // Catch:{ all -> 0x01c5 }
            if (r1 != r5) goto L_0x0019
            java.lang.String r1 = ""
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x01c5 }
            if (r0 == 0) goto L_0x0019
        L_0x008f:
            r0 = 1
            goto L_0x00a4
        L_0x0091:
            com.google.android.play.core.internal.ag r0 = f5227a     // Catch:{ all -> 0x01c5 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x01c5 }
            android.content.Context r6 = r9.f5228b     // Catch:{ all -> 0x01c5 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01c5 }
            r1[r2] = r6     // Catch:{ all -> 0x01c5 }
            java.lang.String r6 = "App '%s' is not found in the PackageManager"
            r0.mo22028e(r6, r1)     // Catch:{ all -> 0x01c5 }
            goto L_0x0019
        L_0x00a4:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x01c5 }
            r4.set(r0)     // Catch:{ all -> 0x01c5 }
        L_0x00ab:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r9.f5231e     // Catch:{ all -> 0x01c5 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x01c5 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01c5 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01c5 }
            monitor-exit(r3)     // Catch:{ all -> 0x01c5 }
            if (r0 == 0) goto L_0x01b2
            java.util.List r0 = r9.m5346d()
            java.util.Iterator r0 = r0.iterator()
        L_0x00c2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0104
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            if (r3 == 0) goto L_0x00c2
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            if (r3 == 0) goto L_0x00c2
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x00c2
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r1 = r1.getClassName()
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            java.lang.String r3 = r3.getName()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00c2
            goto L_0x01b1
        L_0x0104:
            java.util.List r0 = r9.m5346d()
            java.util.Iterator r0 = r0.iterator()
        L_0x010c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0166
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            if (r1 == 0) goto L_0x010c
            android.content.Intent r3 = r1.baseIntent
            if (r3 == 0) goto L_0x010c
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x010c
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r3 = r1.getClassName()
            java.lang.Class r1 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x014c }
        L_0x0136:
            if (r1 == 0) goto L_0x010c
            java.lang.Class<android.app.Activity> r3 = android.app.Activity.class
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0142
        L_0x0140:
            r0 = 1
            goto L_0x0167
        L_0x0142:
            java.lang.Class r3 = r1.getSuperclass()
            if (r3 == r1) goto L_0x014a
            r1 = r3
            goto L_0x0136
        L_0x014a:
            r1 = 0
            goto L_0x0136
        L_0x014c:
            com.google.android.play.core.internal.ag r4 = f5227a
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r2] = r3
            java.lang.String r3 = "ClassNotFoundException when scanning class hierarchy of '%s'"
            r4.mo22028e(r3, r6)
            android.content.Context r3 = r9.f5228b     // Catch:{ NameNotFoundException -> 0x0164 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0164 }
            android.content.pm.ActivityInfo r1 = r3.getActivityInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x0164 }
            if (r1 == 0) goto L_0x010c
            goto L_0x0140
        L_0x0164:
            goto L_0x010c
        L_0x0166:
            r0 = 0
        L_0x0167:
            com.google.android.play.core.missingsplits.a r1 = r9.f5230d
            r1.mo22118b()
            java.util.List r1 = r9.m5346d()
            java.util.Iterator r1 = r1.iterator()
        L_0x0174:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0184
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$AppTask r3 = (android.app.ActivityManager.AppTask) r3
            r3.finishAndRemoveTask()
            goto L_0x0174
        L_0x0184:
            if (r0 == 0) goto L_0x01ac
            android.content.Context r0 = r9.f5228b
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r3 = r9.f5228b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r4 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r1.<init>(r3, r4)
            r0.setComponentEnabledSetting(r1, r5, r5)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r9.f5228b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r0.<init>(r1, r3)
            r1 = 884998144(0x34c00000, float:3.5762787E-7)
            android.content.Intent r0 = r0.addFlags(r1)
            android.content.Context r1 = r9.f5228b
            r1.startActivity(r0)
        L_0x01ac:
            java.lang.Runtime r0 = r9.f5229c
            r0.exit(r2)
        L_0x01b1:
            return r5
        L_0x01b2:
            com.google.android.play.core.missingsplits.a r0 = r9.f5230d
            boolean r0 = r0.mo22117a()
            if (r0 == 0) goto L_0x01c4
            com.google.android.play.core.missingsplits.a r0 = r9.f5230d
            r0.mo22119c()
            java.lang.Runtime r0 = r9.f5229c
            r0.exit(r2)
        L_0x01c4:
            return r2
        L_0x01c5:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01c5 }
            throw r0
        L_0x01c8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.C2125b.disableAppIfMissingRequiredSplits():boolean");
    }
}
