package com.google.android.gms.common.util;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Strings {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean isEmptyOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }
}
