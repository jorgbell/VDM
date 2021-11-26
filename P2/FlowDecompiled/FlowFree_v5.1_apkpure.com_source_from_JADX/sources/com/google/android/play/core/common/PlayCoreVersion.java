package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.C2058ag;
import com.mopub.mobileads.unityads.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PlayCoreVersion {

    /* renamed from: c */
    private static final Map<String, Map<String, Integer>> f5145c = new HashMap();

    static {
        new HashSet(Arrays.asList(new String[]{"app_update", "review"}));
        new HashSet(Arrays.asList(new String[]{"native", BuildConfig.NETWORK_NAME}));
        new C2058ag("PlayCoreVersion");
    }

    /* renamed from: a */
    public static synchronized Map<String, Integer> m5130a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            Map<String, Map<String, Integer>> map2 = f5145c;
            if (!map2.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 11000);
                map2.put(str, hashMap);
            }
            map = map2.get(str);
        }
        return map;
    }

    /* renamed from: b */
    public static Bundle m5131b(String str) {
        Bundle bundle = new Bundle();
        Map<String, Integer> a = m5130a(str);
        bundle.putInt("playcore_version_code", a.get("java").intValue());
        if (a.containsKey("native")) {
            bundle.putInt("playcore_native_version", a.get("native").intValue());
        }
        if (a.containsKey(BuildConfig.NETWORK_NAME)) {
            bundle.putInt("playcore_unity_version", a.get(BuildConfig.NETWORK_NAME).intValue());
        }
        return bundle;
    }
}
