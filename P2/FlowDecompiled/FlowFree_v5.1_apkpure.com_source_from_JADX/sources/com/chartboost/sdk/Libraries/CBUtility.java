package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Model.C1236h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class CBUtility {
    private CBUtility() {
    }

    /* renamed from: a */
    public static float m2911a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public static boolean m2916a(int i) {
        return i == 1 || i == 3;
    }

    /* renamed from: b */
    public static int m2918b(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        int rotation = defaultDisplay.getRotation();
        boolean z = defaultDisplay.getWidth() != defaultDisplay.getHeight() ? defaultDisplay.getWidth() < defaultDisplay.getHeight() : context.getResources().getConfiguration().orientation != 2;
        if (!(rotation == 0 || rotation == 2)) {
            z = !z;
        }
        if (z) {
            if (rotation == 1) {
                return 1;
            }
            if (rotation == 2) {
                return 2;
            }
            if (rotation != 3) {
                return 0;
            }
            return 3;
        } else if (rotation == 1) {
            return 2;
        } else {
            if (rotation == 2) {
                return 3;
            }
            if (rotation != 3) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: b */
    public static boolean m2921b(int i) {
        return i == 0 || i == 2;
    }

    /* renamed from: c */
    public static String m2922c(Context context) {
        int b = m2918b(context);
        if (b == 0) {
            return "portrait";
        }
        if (b == 1) {
            return "landscape";
        }
        if (b != 2) {
            return b != 3 ? "unknown" : "landscape";
        }
        return "portrait";
    }

    /* renamed from: d */
    public static String m2924d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date());
    }

    /* renamed from: e */
    public static String m2925e() {
        Object[] objArr = new Object[3];
        objArr[0] = "Chartboost-Android-SDK";
        Object obj = C1418k.f3535e;
        if (obj == null) {
            obj = "";
        }
        objArr[1] = obj;
        objArr[2] = "8.2.0";
        return String.format("%s %s %s", objArr);
    }

    /* renamed from: f */
    public static boolean m2926f() {
        return m2915a() || m2923c() || m2920b();
    }

    public static void throwProguardError(Exception exc) {
        if (exc instanceof NoSuchMethodException) {
            CBLogging.m2905b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
        } else if (exc == null || exc.getMessage() == null) {
            CBLogging.m2905b("CBUtility", "Unknown Proguard error");
        } else {
            CBLogging.m2905b("CBUtility", exc.getMessage());
        }
    }

    /* renamed from: a */
    public static int m2912a(int i, Context context) {
        return Math.round(((float) i) * m2911a(context));
    }

    /* renamed from: c */
    private static boolean m2923c() {
        return new File("/system/app/Superuser.apk").exists();
    }

    /* renamed from: a */
    public static float m2910a(float f, Context context) {
        return f * m2911a(context);
    }

    /* renamed from: a */
    private static boolean m2915a() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: a */
    public static void m2914a(Activity activity, int i, C1236h hVar) {
        if (activity != null && !m2917a(activity)) {
            if ((i == 1 && hVar.f2823q && hVar.f2826t) || (i == 0 && hVar.f2811e && hVar.f2814h)) {
                int b = m2918b((Context) activity);
                if (b == 0) {
                    activity.setRequestedOrientation(1);
                } else if (b == 2) {
                    activity.setRequestedOrientation(9);
                } else if (b == 1) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(8);
                }
            }
        }
    }

    /* renamed from: a */
    public static ArrayList<File> m2913a(File file, boolean z) {
        if (file == null) {
            return null;
        }
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && !file2.getName().equals(".nomedia")) {
                    arrayList.add(file2);
                } else if (file2.isDirectory() && z) {
                    arrayList.addAll(m2913a(file2, z));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static boolean m2920b() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m2919b(Activity activity, int i, C1236h hVar) {
        if (activity != null && !m2917a(activity)) {
            if ((i == 1 && hVar.f2823q && hVar.f2826t) || (i == 0 && hVar.f2811e && hVar.f2814h)) {
                activity.setRequestedOrientation(-1);
            }
        }
    }

    /* renamed from: a */
    public static boolean m2917a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getBackground() == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || activity.getWindow().getDecorView().getBackground().getAlpha() == 255) {
            return false;
        }
        return true;
    }
}
