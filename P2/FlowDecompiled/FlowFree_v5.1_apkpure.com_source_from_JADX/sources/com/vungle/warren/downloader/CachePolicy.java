package com.vungle.warren.downloader;

import java.util.List;

public interface CachePolicy<T> {
    List<T> getOrderedCacheItems();

    void load();

    void put(T t, long j);

    void remove(T t);

    void save();
}
