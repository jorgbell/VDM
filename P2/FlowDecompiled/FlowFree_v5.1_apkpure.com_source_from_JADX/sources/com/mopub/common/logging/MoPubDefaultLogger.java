package com.mopub.common.logging;

import android.util.Log;

public class MoPubDefaultLogger implements MoPubLogger {
    static int MAX_MESSAGE_LENGTH_BYTES = 3072;

    public void log(String str, String str2, String str3, String str4) {
        for (String str5 : split(str4)) {
            if (str3 == null) {
                Log.i(MoPubLog.LOGTAG, String.format("[%s][%s] %s", new Object[]{str, str2, str5}));
            } else {
                Log.i(MoPubLog.LOGTAG, String.format("[%s][%s][%s] %s", new Object[]{str, str2, str3, str5}));
            }
        }
    }

    static String[] split(String str) {
        if (str == null) {
            return new String[1];
        }
        int length = (str.length() / MAX_MESSAGE_LENGTH_BYTES) + 1;
        String[] strArr = new String[length];
        int i = 0;
        while (i < length) {
            int i2 = MAX_MESSAGE_LENGTH_BYTES;
            int i3 = i + 1;
            strArr[i] = str.substring(i * i2, Math.min(i2 * i3, str.length()));
            i = i3;
        }
        return strArr;
    }
}
