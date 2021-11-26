package com.applovin.impl.sdk.utils;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.applovin.impl.sdk.utils.o */
public class C1155o {

    /* renamed from: a */
    private static final char[] f2482a = "0123456789abcdef".toCharArray();

    /* renamed from: a */
    public static int m2660a(String str) {
        return m2661a(str, 0);
    }

    /* renamed from: a */
    public static int m2661a(String str, int i) {
        return m2676d(str) ? Integer.parseInt(str) : i;
    }

    /* renamed from: a */
    public static SpannedString m2662a(String str, int i, int i2) {
        return m2663a(str, i, i2, 0);
    }

    /* renamed from: a */
    public static SpannedString m2663a(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableString.length(), 33);
        spannableString.setSpan(new StyleSpan(i3), 0, spannableString.length(), 33);
        return new SpannedString(spannableString);
    }

    /* renamed from: a */
    public static Boolean m2664a(String str, List<String> list) {
        for (String endsWith : list) {
            if (str.endsWith(endsWith)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    public static String m2665a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        return str.substring(0, i);
    }

    /* renamed from: a */
    private static String m2666a(String str, Integer num) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            String a = m2670a(instance.digest());
            return num.intValue() > 0 ? a.substring(0, Math.min(num.intValue(), a.length())) : a;
        } catch (Throwable th) {
            throw new RuntimeException("SHA-1 for \"" + str + "\" failed.", th);
        }
    }

    /* renamed from: a */
    public static String m2667a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static String m2668a(String str, Map<String, String> map) {
        if (!(str == null || map == null)) {
            for (Map.Entry next : map.entrySet()) {
                str = str.replace((CharSequence) next.getKey(), (CharSequence) next.getValue());
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m2669a(String str, Map<String, String> map, boolean z) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() {
                /* renamed from: a */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static String m2670a(byte[] bArr) {
        if (bArr != null) {
            char[] cArr = new char[(bArr.length * 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                char[] cArr2 = f2482a;
                cArr[i2] = cArr2[(bArr[i] & 240) >>> 4];
                cArr[i2 + 1] = cArr2[bArr[i] & 15];
            }
            return new String(cArr);
        }
        throw new IllegalArgumentException("No data specified");
    }

    /* renamed from: a */
    public static boolean m2671a(String str, String str2) {
        return m2673b(str) && m2673b(str2) && str.toLowerCase().contains(str2.toLowerCase());
    }

    /* renamed from: b */
    public static SpannedString m2672b(String str, int i) {
        return m2662a(str, i, 16);
    }

    /* renamed from: b */
    public static boolean m2673b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* renamed from: c */
    public static SpannedString m2674c(String str, int i) {
        return m2663a(str, i, 12, 1);
    }

    /* renamed from: c */
    public static String m2675c(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public static boolean m2676d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = (charAt == '-' || charAt == '+') ? 1 : 0;
        int length = str.length();
        if (i == 1 && length == 1) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m2677e(String str) {
        if (m2673b(str)) {
            return str.matches("^[a-zA-Z0-9]*$");
        }
        return false;
    }

    /* renamed from: f */
    public static String m2678f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /* renamed from: g */
    public static String m2679g(String str) {
        Uri parse = Uri.parse(str);
        return parse.getHost() + parse.getPath();
    }

    /* renamed from: h */
    public static String m2680h(String str) {
        return m2666a(str, (Integer) 16);
    }
}
