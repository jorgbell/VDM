package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserMetadata {
    private final Map<String, String> attributes = new HashMap();
    private String userId = null;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = sanitizeAttribute(str);
    }

    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public void setCustomKey(String str, String str2) {
        setSyncCustomKeys(new HashMap<String, String>(this, str, str2) {
            final /* synthetic */ String val$key;
            final /* synthetic */ String val$value;

            {
                this.val$key = r2;
                this.val$value = r3;
                put(UserMetadata.sanitizeKey(r2), UserMetadata.sanitizeAttribute(r3));
            }
        });
    }

    public void setCustomKeys(Map<String, String> map) {
        setSyncCustomKeys(map);
    }

    private synchronized void setSyncCustomKeys(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String sanitizeKey = sanitizeKey((String) next.getKey());
            String sanitizeAttribute = next.getValue() == null ? "" : sanitizeAttribute((String) next.getValue());
            if (this.attributes.containsKey(sanitizeKey)) {
                hashMap.put(sanitizeKey, sanitizeAttribute);
            } else {
                hashMap2.put(sanitizeKey, sanitizeAttribute);
            }
        }
        this.attributes.putAll(hashMap);
        if (this.attributes.size() + hashMap2.size() > 64) {
            int size = 64 - this.attributes.size();
            Logger.getLogger().mo22337v("Exceeded maximum number of custom attributes (64).");
            hashMap2.keySet().retainAll(new ArrayList(hashMap2.keySet()).subList(0, size));
        }
        this.attributes.putAll(hashMap2);
    }

    /* access modifiers changed from: private */
    public static String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeAttribute(str);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    /* access modifiers changed from: private */
    public static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }
}
