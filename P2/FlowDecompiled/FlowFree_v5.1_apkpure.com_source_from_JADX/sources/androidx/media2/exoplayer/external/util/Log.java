package androidx.media2.exoplayer.external.util;

import android.text.TextUtils;

public final class Log {
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    /* renamed from: d */
    public static void m12d(String str, String str2) {
        if (logLevel == 0) {
            android.util.Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m15i(String str, String str2) {
        if (logLevel <= 1) {
            android.util.Log.i(str, str2);
        }
    }

    /* renamed from: w */
    public static void m16w(String str, String str2) {
        if (logLevel <= 2) {
            android.util.Log.w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m17w(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m16w(str, appendThrowableMessage(str2, th));
        } else if (logLevel <= 2) {
            android.util.Log.w(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m13e(String str, String str2) {
        if (logLevel <= 3) {
            android.util.Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m14e(String str, String str2, Throwable th) {
        if (!logStackTraces) {
            m13e(str, appendThrowableMessage(str2, th));
        } else if (logLevel <= 3) {
            android.util.Log.e(str, str2, th);
        }
    }

    private static String appendThrowableMessage(String str, Throwable th) {
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(message).length());
        sb.append(str);
        sb.append(" - ");
        sb.append(message);
        return sb.toString();
    }
}
