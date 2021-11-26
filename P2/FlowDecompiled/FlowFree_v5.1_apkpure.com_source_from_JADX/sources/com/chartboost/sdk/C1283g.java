package com.chartboost.sdk;

import android.content.Context;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Networking.requests.models.MediationModel;

/* renamed from: com.chartboost.sdk.g */
class C1283g implements Runnable {

    /* renamed from: a */
    private final int f3022a;

    /* renamed from: b */
    boolean f3023b = false;

    /* renamed from: c */
    Chartboost.CBFramework f3024c = null;

    /* renamed from: d */
    String f3025d = null;

    /* renamed from: e */
    MediationModel f3026e = null;

    /* renamed from: f */
    String f3027f = null;

    /* renamed from: g */
    CBLogging.Level f3028g = null;

    /* renamed from: h */
    ChartboostDelegate f3029h = null;

    /* renamed from: i */
    Context f3030i = null;

    /* renamed from: j */
    String f3031j = null;

    /* renamed from: k */
    String f3032k = null;

    C1283g(int i) {
        this.f3022a = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.util.concurrent.ScheduledExecutorService} */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ee A[Catch:{ all -> 0x00e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r11 = this;
            int r0 = r11.f3022a     // Catch:{ Exception -> 0x011f }
            switch(r0) {
                case 0: goto L_0x005d;
                case 1: goto L_0x0057;
                case 2: goto L_0x0005;
                case 3: goto L_0x0051;
                case 4: goto L_0x002c;
                case 5: goto L_0x0025;
                case 6: goto L_0x001f;
                case 7: goto L_0x0012;
                case 8: goto L_0x0007;
                default: goto L_0x0005;
            }     // Catch:{ Exception -> 0x011f }
        L_0x0005:
            goto L_0x0144
        L_0x0007:
            com.chartboost.sdk.ChartboostDelegate r0 = r11.f3029h     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3534d = r0     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = "SdkSettings.assignDelegate"
            com.chartboost.sdk.impl.C1317h1.m3506a((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x0012:
            boolean r0 = com.chartboost.sdk.C1274c.m3270a()     // Catch:{ Exception -> 0x011f }
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            com.chartboost.sdk.Libraries.CBLogging$Level r0 = r11.f3028g     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.Libraries.CBLogging.f2662a = r0     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x001f:
            java.lang.String r0 = r11.f3027f     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3532b = r0     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x0025:
            java.lang.String r0 = r11.f3025d     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1274c.m3269a((java.lang.String) r0)     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x002c:
            com.chartboost.sdk.Chartboost$CBFramework r0 = r11.f3024c     // Catch:{ Exception -> 0x011f }
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = "ChartboostCommand"
            java.lang.String r1 = "Pass a valid CBFramework enum value"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r0, r1)     // Catch:{ Exception -> 0x011f }
            return
        L_0x0038:
            com.chartboost.sdk.C1418k.f3535e = r0     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = r11.f3025d     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3536f = r1     // Catch:{ Exception -> 0x011f }
            java.lang.String r2 = "%s %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x011f }
            r4 = 0
            r3[r4] = r0     // Catch:{ Exception -> 0x011f }
            r0 = 1
            r3[r0] = r1     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3537g = r0     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x0051:
            com.chartboost.sdk.Networking.requests.models.MediationModel r0 = r11.f3026e     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3539i = r0     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x0057:
            boolean r0 = r11.f3023b     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.C1418k.f3545o = r0     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x005d:
            com.chartboost.sdk.j r0 = com.chartboost.sdk.C1414j.m3867b()     // Catch:{ Exception -> 0x011f }
            r1 = 3
            if (r0 != 0) goto L_0x0108
            java.lang.Class<com.chartboost.sdk.j> r0 = com.chartboost.sdk.C1414j.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.j r2 = com.chartboost.sdk.C1414j.m3867b()     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0103
            android.content.Context r2 = r11.f3030i     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x007a
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "Context object is null. Please pass a valid activity object"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r1, r2)     // Catch:{ all -> 0x0105 }
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            return
        L_0x007a:
            boolean r2 = com.chartboost.sdk.C1274c.m3274b(r2)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0089
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "Permissions not set correctly"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r1, r2)     // Catch:{ all -> 0x0105 }
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            return
        L_0x0089:
            android.content.Context r2 = r11.f3030i     // Catch:{ all -> 0x0105 }
            boolean r2 = com.chartboost.sdk.C1274c.m3271a((android.content.Context) r2)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0098
            java.lang.String r2 = "ChartboostCommand"
            java.lang.String r3 = "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions."
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r2, r3)     // Catch:{ all -> 0x0105 }
        L_0x0098:
            java.lang.String r2 = r11.f3031j     // Catch:{ all -> 0x0105 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x00fa
            java.lang.String r2 = r11.f3032k     // Catch:{ all -> 0x0105 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00a9
            goto L_0x00fa
        L_0x00a9:
            com.chartboost.sdk.impl.x r7 = com.chartboost.sdk.impl.C1406x.m3823b()     // Catch:{ all -> 0x0105 }
            com.chartboost.sdk.h r2 = com.chartboost.sdk.C1284h.m3343a()     // Catch:{ all -> 0x0105 }
            android.os.Handler r9 = r7.f3484a     // Catch:{ all -> 0x0105 }
            r3 = 0
            java.util.concurrent.ScheduledExecutorService r4 = com.chartboost.sdk.Networking.C1241b.m3086a()     // Catch:{ all -> 0x00eb }
            java.lang.Object r4 = r2.mo10361a(r4)     // Catch:{ all -> 0x00eb }
            r8 = r4
            java.util.concurrent.ScheduledExecutorService r8 = (java.util.concurrent.ScheduledExecutorService) r8     // Catch:{ all -> 0x00eb }
            r3 = 4
            java.util.concurrent.ExecutorService r3 = com.chartboost.sdk.Networking.C1241b.m3085a(r3)     // Catch:{ all -> 0x00e8 }
            java.lang.Object r2 = r2.mo10361a(r3)     // Catch:{ all -> 0x00e8 }
            r10 = r2
            java.util.concurrent.ExecutorService r10 = (java.util.concurrent.ExecutorService) r10     // Catch:{ all -> 0x00e8 }
            com.chartboost.sdk.j r2 = new com.chartboost.sdk.j     // Catch:{ all -> 0x0105 }
            android.content.Context r4 = r11.f3030i     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r11.f3031j     // Catch:{ all -> 0x0105 }
            java.lang.String r6 = r11.f3032k     // Catch:{ all -> 0x0105 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0105 }
            com.chartboost.sdk.C1414j.m3871c((com.chartboost.sdk.C1414j) r2)     // Catch:{ all -> 0x0105 }
            com.chartboost.sdk.impl.n r3 = r2.f3505h     // Catch:{ all -> 0x0105 }
            r3.mo10522b()     // Catch:{ all -> 0x0105 }
            com.chartboost.sdk.j$b r3 = new com.chartboost.sdk.j$b     // Catch:{ all -> 0x0105 }
            r3.<init>(r1)     // Catch:{ all -> 0x0105 }
            r2.mo10710c((java.lang.Runnable) r3)     // Catch:{ all -> 0x0105 }
            goto L_0x0103
        L_0x00e8:
            r1 = move-exception
            r3 = r8
            goto L_0x00ec
        L_0x00eb:
            r1 = move-exception
        L_0x00ec:
            if (r3 == 0) goto L_0x00f1
            r3.shutdown()     // Catch:{ all -> 0x0105 }
        L_0x00f1:
            java.lang.String r2 = "ChartboostCommand"
            java.lang.String r3 = "Unable to start threads"
            com.chartboost.sdk.Libraries.CBLogging.m2904a(r2, r3, r1)     // Catch:{ all -> 0x0105 }
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            return
        L_0x00fa:
            java.lang.String r1 = "ChartboostCommand"
            java.lang.String r2 = "AppId or AppSignature is null. Please pass a valid id's"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r1, r2)     // Catch:{ all -> 0x0105 }
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            return
        L_0x0103:
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            goto L_0x0144
        L_0x0105:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            throw r1     // Catch:{ Exception -> 0x011f }
        L_0x0108:
            com.chartboost.sdk.a r0 = com.chartboost.sdk.C1418k.f3534d     // Catch:{ Exception -> 0x011f }
            if (r0 == 0) goto L_0x010f
            r0.didInitialize()     // Catch:{ Exception -> 0x011f }
        L_0x010f:
            com.chartboost.sdk.j r0 = com.chartboost.sdk.C1414j.m3867b()     // Catch:{ Exception -> 0x011f }
            com.chartboost.sdk.j$b r2 = new com.chartboost.sdk.j$b     // Catch:{ Exception -> 0x011f }
            r0.getClass()     // Catch:{ Exception -> 0x011f }
            r2.<init>(r1)     // Catch:{ Exception -> 0x011f }
            r0.mo10710c((java.lang.Runnable) r2)     // Catch:{ Exception -> 0x011f }
            goto L_0x0144
        L_0x011f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "run ("
            r1.append(r2)
            int r2 = r11.f3022a
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "ChartboostCommand"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r1, r0)
        L_0x0144:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.C1283g.run():void");
    }
}
