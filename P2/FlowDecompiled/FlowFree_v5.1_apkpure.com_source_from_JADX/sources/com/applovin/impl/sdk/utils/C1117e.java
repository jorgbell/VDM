package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.e */
public class C1117e {
    /* renamed from: a */
    public static String m2517a(Collection<String> collection, int i) {
        return m2518a(collection, ",", i);
    }

    /* renamed from: a */
    public static String m2518a(Collection<String> collection, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        } else if (collection == null || collection.size() < 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String next : collection) {
                if (i2 >= i) {
                    break;
                }
                i2++;
                sb.append(next);
                sb.append(str);
            }
            if (sb.length() > str.length()) {
                sb.setLength(sb.length() - str.length());
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static <T> List<T> m2519a() {
        return m2520a(-1);
    }

    /* renamed from: a */
    public static <T> List<T> m2520a(int i) {
        return i >= 0 ? Collections.synchronizedList(new ArrayList(i)) : Collections.synchronizedList(new ArrayList());
    }

    /* renamed from: a */
    public static List<String> m2521a(String str) {
        return m2522a(str, ",\\s*");
    }

    /* renamed from: a */
    public static List<String> m2522a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    /* renamed from: a */
    public static List<String> m2523a(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String trim : list) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m2524a(K k, V v) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(k, v);
        return hashMap;
    }
}
