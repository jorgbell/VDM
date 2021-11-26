package com.vungle.warren.downloader;

import java.io.File;

public interface AssetDownloadListener {
    void onError(DownloadError downloadError, DownloadRequest downloadRequest);

    void onProgress(Progress progress, DownloadRequest downloadRequest);

    void onSuccess(File file, DownloadRequest downloadRequest);

    public static class DownloadError {
        public final Throwable cause;
        public final int reason;
        public final int serverCode;

        public DownloadError(int i, Throwable th, int i2) {
            this.serverCode = i;
            this.cause = th;
            this.reason = i2;
        }
    }

    public static class Progress {
        public int progressPercent;
        public long sizeBytes;
        public long startBytes;
        public int status;
        public long timestampDownloadStart;

        public static Progress copy(Progress progress) {
            Progress progress2 = new Progress();
            progress2.status = progress.status;
            progress2.progressPercent = progress.progressPercent;
            progress2.timestampDownloadStart = progress.timestampDownloadStart;
            progress2.sizeBytes = progress.sizeBytes;
            progress2.startBytes = progress.startBytes;
            return progress2;
        }
    }
}
