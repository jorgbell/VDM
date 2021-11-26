package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

public class ConfigGetParameterHandler {
    private final ConfigCacheClient activatedConfigsCache;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final Set<BiConsumer<String, ConfigContainer>> listeners = new HashSet();

    static {
        Charset.forName("UTF-8");
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public ConfigGetParameterHandler(Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.executor = executor2;
        this.activatedConfigsCache = configCacheClient;
        this.defaultConfigsCache = configCacheClient2;
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
        if (stringFromCache != null) {
            callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
            return new FirebaseRemoteConfigValueImpl(stringFromCache, 2);
        }
        String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
        if (stringFromCache2 != null) {
            return new FirebaseRemoteConfigValueImpl(stringFromCache2, 1);
        }
        logParameterValueDoesNotExist(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl("", 0);
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(getKeySetFromCache(this.activatedConfigsCache));
        hashSet.addAll(getKeySetFromCache(this.defaultConfigsCache));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    public void addListener(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.listeners) {
            this.listeners.add(biConsumer);
        }
    }

    private void callListeners(String str, ConfigContainer configContainer) {
        if (configContainer != null) {
            synchronized (this.listeners) {
                for (BiConsumer<String, ConfigContainer> lambdaFactory$ : this.listeners) {
                    this.executor.execute(ConfigGetParameterHandler$$Lambda$1.lambdaFactory$(lambdaFactory$, str, configContainer));
                }
            }
        }
    }

    private static String getStringFromCache(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return null;
        }
        try {
            return configsFromCache.getConfigs().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static Set<String> getKeySetFromCache(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return hashSet;
        }
        Iterator<String> keys = configsFromCache.getConfigs().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static ConfigContainer getConfigsFromCache(ConfigCacheClient configCacheClient) {
        return configCacheClient.getBlocking();
    }

    private static void logParameterValueDoesNotExist(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", new Object[]{str2, str}));
    }
}
