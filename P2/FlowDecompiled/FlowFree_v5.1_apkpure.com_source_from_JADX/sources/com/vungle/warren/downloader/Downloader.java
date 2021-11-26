package com.vungle.warren.downloader;

import java.util.List;

public interface Downloader {
    void cancel(DownloadRequest downloadRequest);

    void cancelAll();

    boolean cancelAndAwait(DownloadRequest downloadRequest, long j);

    void clearCache();

    void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener);

    boolean dropCache(String str);

    List<DownloadRequest> getAllRequests();

    void init();

    void setCacheEnabled(boolean z);

    void updatePriority(DownloadRequest downloadRequest);

    public static class RequestException extends Exception {
        RequestException(String str) {
            super(str);
        }
    }
}
