package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class WorkSourceUtil {
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zzf;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[SYNTHETIC, Splitter:B:22:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            android.os.Process.myUid()
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0017 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0017 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0017 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r5 = r3
        L_0x0018:
            zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r6 = 2
            if (r5 == 0) goto L_0x0030
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0030 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0030 }
            r5[r4] = r7     // Catch:{ Exception -> 0x0030 }
            r5[r2] = r0     // Catch:{ Exception -> 0x0030 }
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r1 = r7.getMethod(r1, r5)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r1 = r3
        L_0x0031:
            zzc = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x003e }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r1 = r3
        L_0x003f:
            zzd = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x004f }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004f }
            r1[r4] = r5     // Catch:{ Exception -> 0x004f }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "get"
            r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r1 == 0) goto L_0x0066
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0065 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0065 }
            r1[r4] = r5     // Catch:{ Exception -> 0x0065 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r3 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0066
        L_0x0065:
        L_0x0066:
            zzf = r3
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r3 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0080
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x007a }
            r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x007a }
            goto L_0x0080
        L_0x007a:
            r1 = move-exception
            java.lang.String r5 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r3, r5, r1)
        L_0x0080:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x009a }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x009a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009a }
            r5[r4] = r6     // Catch:{ Exception -> 0x009a }
            r5[r2] = r0     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = "addNode"
            r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x009a }
            goto L_0x00a0
        L_0x009a:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r3, r1, r0)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    @RecentlyNullable
    public static WorkSource fromPackage(@RecentlyNonNull Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                zza(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    @androidx.annotation.RecentlyNonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> getNames(android.os.WorkSource r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "Unable to assign blame through WorkSource"
            java.lang.String r2 = "WorkSourceUtil"
            r3 = 0
            if (r10 != 0) goto L_0x000e
        L_0x000c:
            r4 = 0
            goto L_0x0027
        L_0x000e:
            java.lang.reflect.Method r4 = zzd
            if (r4 == 0) goto L_0x000c
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.invoke(r10, r5)     // Catch:{ Exception -> 0x0022 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0022 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0027
        L_0x0022:
            r4 = move-exception
            android.util.Log.wtf(r2, r1, r4)
            goto L_0x000c
        L_0x0027:
            if (r4 == 0) goto L_0x0055
            r5 = 0
        L_0x002a:
            if (r5 >= r4) goto L_0x0055
            java.lang.reflect.Method r6 = zzf
            r7 = 0
            if (r6 == 0) goto L_0x0046
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0042 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0042 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r6 = r6.invoke(r10, r8)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0042 }
            r7 = r6
            goto L_0x0046
        L_0x0042:
            r6 = move-exception
            android.util.Log.wtf(r2, r1, r6)
        L_0x0046:
            boolean r6 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r7)
            if (r6 != 0) goto L_0x0052
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            r0.add(r7)
        L_0x0052:
            int r5 = r5 + 1
            goto L_0x002a
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.getNames(android.os.WorkSource):java.util.List");
    }

    public static boolean hasWorkSourcePermission(@RecentlyNonNull Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static void zza(@RecentlyNonNull WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method != null) {
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }
}
