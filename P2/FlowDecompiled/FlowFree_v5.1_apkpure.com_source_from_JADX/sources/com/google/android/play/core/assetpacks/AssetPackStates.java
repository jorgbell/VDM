package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    /* renamed from: a */
    public static AssetPackStates m4867a(long j, Map<String, AssetPackState> map) {
        return new C1976ba(j, map);
    }

    /* renamed from: b */
    public static AssetPackStates m4868b(Bundle bundle, C1989bo boVar) {
        return m4869c(bundle, boVar, new ArrayList());
    }

    /* renamed from: c */
    public static AssetPackStates m4869c(Bundle bundle, C1989bo boVar, List<String> list) {
        return m4870e(bundle, boVar, list, C1969at.f4850a);
    }

    /* renamed from: e */
    private static AssetPackStates m4870e(Bundle bundle, C1989bo boVar, List<String> list, C1968as asVar) {
        Bundle bundle2 = bundle;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.m4864d(bundle, str, boVar, asVar));
        }
        for (String next : list) {
            hashMap.put(next, AssetPackState.m4863c(next, 4, 0, 0, 0, 0.0d, 1, ""));
        }
        return m4867a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
