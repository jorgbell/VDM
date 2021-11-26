package com.unity3d.services.core.properties;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class ClientProperties {
    private static final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static WeakReference<Activity> _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static String _gameId;

    public static Activity getActivity() {
        return (Activity) _activity.get();
    }

    public static void setActivity(Activity activity) {
        _activity = new WeakReference<>(activity);
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static void setApplicationContext(Context context) {
        _applicationContext = context;
    }

    public static Application getApplication() {
        return _application;
    }

    public static void setApplication(Application application) {
        _application = application;
    }

    public static String getGameId() {
        return _gameId;
    }

    public static void setGameId(String str) {
        _gameId = str;
    }

    public static String getAppName() {
        return _applicationContext.getPackageName();
    }

    public static String getAppVersion() {
        String packageName = getApplicationContext().getPackageName();
        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            if (packageManager.getPackageInfo(packageName, 0).versionName == null) {
                return "FakeVersionName";
            }
            return packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Error getting package info", e);
            return null;
        }
    }

    public static boolean isAppDebuggable() {
        boolean z;
        if (getApplicationContext() == null) {
            return false;
        }
        PackageManager packageManager = getApplicationContext().getPackageManager();
        String packageName = getApplicationContext().getPackageName();
        boolean z2 = true;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            int i = applicationInfo.flags & 2;
            applicationInfo.flags = i;
            if (i == 0) {
                z2 = false;
            }
            z = z2;
            z2 = false;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Could not find name", e);
            z = false;
        }
        if (z2) {
            try {
                for (Signature byteArray : packageManager.getPackageInfo(packageName, 64).signatures) {
                    z = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray.toByteArray()))).getSubjectX500Principal().equals(DEBUG_CERT);
                    if (z) {
                        break;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                DeviceLog.exception("Could not find name", e2);
            } catch (CertificateException e3) {
                DeviceLog.exception("Certificate exception", e3);
            }
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:7|8|9|12|13|14|15|16|17|22|18|5) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray areClassesPresent(org.json.JSONArray r8) {
        /*
            java.lang.String r0 = "found"
            java.lang.String r1 = "class"
            if (r8 != 0) goto L_0x000c
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
            return r8
        L_0x000c:
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x0013:
            int r5 = r8.length()
            if (r4 >= r5) goto L_0x0040
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.Object r6 = r8.get(r4)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            java.lang.String r6 = ""
        L_0x0029:
            java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0034 }
            r5.put(r1, r6)     // Catch:{ Exception -> 0x0034 }
            r7 = 1
            r5.put(r0, r7)     // Catch:{ Exception -> 0x0034 }
            goto L_0x003a
        L_0x0034:
            r5.put(r1, r6)     // Catch:{ Exception -> 0x003a }
            r5.put(r0, r3)     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            r2.put(r5)     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.properties.ClientProperties.areClassesPresent(org.json.JSONArray):org.json.JSONArray");
    }
}
