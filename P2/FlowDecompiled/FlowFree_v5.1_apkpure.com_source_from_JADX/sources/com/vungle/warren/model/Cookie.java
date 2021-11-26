package com.vungle.warren.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cookie {
    Map<String, Boolean> booleans = new ConcurrentHashMap();
    String identifier;
    Map<String, Integer> integers = new ConcurrentHashMap();
    Map<String, Long> longs = new ConcurrentHashMap();
    Map<String, String> strings = new ConcurrentHashMap();

    public Cookie(String str) {
        this.identifier = str;
    }

    public <T> void putValue(String str, T t) {
        if (t instanceof String) {
            this.strings.put(str, (String) t);
        } else if (t instanceof Boolean) {
            this.booleans.put(str, (Boolean) t);
        } else if (t instanceof Integer) {
            this.integers.put(str, (Integer) t);
        } else if (t instanceof Long) {
            this.longs.put(str, (Long) t);
        } else {
            throw new IllegalArgumentException("Value type is not supported!");
        }
    }

    public String getString(String str) {
        return this.strings.get(str);
    }

    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.booleans.get(str) != null && this.booleans.get(str).booleanValue());
    }

    public Long getLong(String str) {
        return Long.valueOf(this.longs.get(str) != null ? this.longs.get(str).longValue() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Cookie.class != obj.getClass()) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        Map<String, String> map = this.strings;
        if (map == null ? cookie.strings != null : !map.equals(cookie.strings)) {
            return false;
        }
        Map<String, Boolean> map2 = this.booleans;
        if (map2 == null ? cookie.booleans != null : !map2.equals(cookie.booleans)) {
            return false;
        }
        Map<String, Integer> map3 = this.integers;
        if (map3 == null ? cookie.integers != null : !map3.equals(cookie.integers)) {
            return false;
        }
        Map<String, Long> map4 = this.longs;
        if (map4 == null ? cookie.longs != null : !map4.equals(cookie.longs)) {
            return false;
        }
        String str = this.identifier;
        String str2 = cookie.identifier;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Map<String, String> map = this.strings;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Boolean> map2 = this.booleans;
        int hashCode2 = (hashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Integer> map3 = this.integers;
        int hashCode3 = (hashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<String, Long> map4 = this.longs;
        int hashCode4 = (hashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
        String str = this.identifier;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode4 + i;
    }
}
