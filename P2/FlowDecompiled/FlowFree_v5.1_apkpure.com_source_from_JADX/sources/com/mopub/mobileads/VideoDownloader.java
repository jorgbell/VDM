package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;

public class VideoDownloader {
    /* access modifiers changed from: private */
    public static final Deque<WeakReference<VideoDownloaderTask>> sDownloaderTasks = new ArrayDeque();

    interface VideoDownloaderListener {
        void onComplete(boolean z);
    }

    private VideoDownloader() {
    }

    public static void cache(String str, VideoDownloaderListener videoDownloaderListener) {
        Preconditions.checkNotNull(videoDownloaderListener);
        if (str == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "VideoDownloader attempted to cache video with null url.");
            videoDownloaderListener.onComplete(false);
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new VideoDownloaderTask(videoDownloaderListener), str);
        } catch (Exception unused) {
            videoDownloaderListener.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks() {
        for (WeakReference<VideoDownloaderTask> cancelOneTask : sDownloaderTasks) {
            cancelOneTask(cancelOneTask);
        }
        sDownloaderTasks.clear();
    }

    public static void cancelLastDownloadTask() {
        Deque<WeakReference<VideoDownloaderTask>> deque = sDownloaderTasks;
        if (!deque.isEmpty()) {
            cancelOneTask(deque.peekLast());
            deque.removeLast();
        }
    }

    private static boolean cancelOneTask(WeakReference<VideoDownloaderTask> weakReference) {
        VideoDownloaderTask videoDownloaderTask;
        if (weakReference == null || (videoDownloaderTask = (VideoDownloaderTask) weakReference.get()) == null) {
            return false;
        }
        return videoDownloaderTask.cancel(true);
    }

    @VisibleForTesting
    static class VideoDownloaderTask extends AsyncTask<String, Void, Boolean> {
        private final VideoDownloaderListener mListener;
        private final WeakReference<VideoDownloaderTask> mWeakSelf;

        @VisibleForTesting
        VideoDownloaderTask(VideoDownloaderListener videoDownloaderListener) {
            this.mListener = videoDownloaderListener;
            WeakReference<VideoDownloaderTask> weakReference = new WeakReference<>(this);
            this.mWeakSelf = weakReference;
            VideoDownloader.sDownloaderTasks.add(weakReference);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00bd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.String... r11) {
            /*
                r10 = this;
                r0 = 1
                r1 = 0
                if (r11 == 0) goto L_0x00c1
                int r2 = r11.length
                if (r2 == 0) goto L_0x00c1
                r2 = r11[r1]
                if (r2 != 0) goto L_0x000d
                goto L_0x00c1
            L_0x000d:
                r11 = r11[r1]
                r2 = 2
                r3 = 0
                java.net.HttpURLConnection r4 = com.mopub.common.MoPubHttpUrlConnection.getHttpUrlConnection(r11)     // Catch:{ Exception -> 0x009e, all -> 0x009b }
                java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0099 }
                java.io.InputStream r6 = r4.getInputStream()     // Catch:{ Exception -> 0x0099 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0099 }
                int r3 = r4.getResponseCode()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r6 = 200(0xc8, float:2.8E-43)
                if (r3 < r6) goto L_0x006c
                r6 = 300(0x12c, float:4.2E-43)
                if (r3 < r6) goto L_0x002b
                goto L_0x006c
            L_0x002b:
                int r3 = r4.getContentLength()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r6 = 26214400(0x1900000, float:5.2897246E-38)
                if (r3 <= r6) goto L_0x005b
                com.mopub.common.logging.MoPubLog$SdkLogEvent r11 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.String r8 = "VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum)."
                java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r9[r1] = r3     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r9[r0] = r3     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.String r3 = java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r7[r1] = r3     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                com.mopub.common.logging.MoPubLog.log(r11, r7)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                com.mopub.common.util.Streams.closeStream(r5)
                if (r4 == 0) goto L_0x005a
                r4.disconnect()
            L_0x005a:
                return r11
            L_0x005b:
                boolean r11 = com.mopub.common.CacheService.putToDiskCache((java.lang.String) r11, (java.io.InputStream) r5)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                com.mopub.common.util.Streams.closeStream(r5)
                if (r4 == 0) goto L_0x006b
                r4.disconnect()
            L_0x006b:
                return r11
            L_0x006c:
                com.mopub.common.logging.MoPubLog$SdkLogEvent r11 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r7.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.String r8 = "VideoDownloader encountered unexpected statusCode: "
                r7.append(r8)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r7.append(r3)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                r6[r1] = r3     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                com.mopub.common.logging.MoPubLog.log(r11, r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                com.mopub.common.util.Streams.closeStream(r5)
                if (r4 == 0) goto L_0x0090
                r4.disconnect()
            L_0x0090:
                return r11
            L_0x0091:
                r11 = move-exception
                r3 = r5
                goto L_0x00b8
            L_0x0094:
                r11 = move-exception
                r3 = r5
                goto L_0x00a0
            L_0x0097:
                r11 = move-exception
                goto L_0x00b8
            L_0x0099:
                r11 = move-exception
                goto L_0x00a0
            L_0x009b:
                r11 = move-exception
                r4 = r3
                goto L_0x00b8
            L_0x009e:
                r11 = move-exception
                r4 = r3
            L_0x00a0:
                com.mopub.common.logging.MoPubLog$SdkLogEvent r5 = com.mopub.common.logging.MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE     // Catch:{ all -> 0x0097 }
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0097 }
                java.lang.String r6 = "VideoDownloader task threw an internal exception."
                r2[r1] = r6     // Catch:{ all -> 0x0097 }
                r2[r0] = r11     // Catch:{ all -> 0x0097 }
                com.mopub.common.logging.MoPubLog.log(r5, r2)     // Catch:{ all -> 0x0097 }
                java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0097 }
                com.mopub.common.util.Streams.closeStream(r3)
                if (r4 == 0) goto L_0x00b7
                r4.disconnect()
            L_0x00b7:
                return r11
            L_0x00b8:
                com.mopub.common.util.Streams.closeStream(r3)
                if (r4 == 0) goto L_0x00c0
                r4.disconnect()
            L_0x00c0:
                throw r11
            L_0x00c1:
                com.mopub.common.logging.MoPubLog$SdkLogEvent r11 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r2 = "VideoDownloader task tried to execute null or empty url."
                r0[r1] = r2
                com.mopub.common.logging.MoPubLog.log(r11, r0)
                java.lang.Boolean r11 = java.lang.Boolean.FALSE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VideoDownloader.VideoDownloaderTask.doInBackground(java.lang.String[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (isCancelled()) {
                onCancelled();
                return;
            }
            VideoDownloader.sDownloaderTasks.remove(this.mWeakSelf);
            if (bool == null) {
                this.mListener.onComplete(false);
            } else {
                this.mListener.onComplete(bool.booleanValue());
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "VideoDownloader task was cancelled.");
            VideoDownloader.sDownloaderTasks.remove(this.mWeakSelf);
            this.mListener.onComplete(false);
        }
    }

    @Deprecated
    @VisibleForTesting
    public static Deque<WeakReference<VideoDownloaderTask>> getDownloaderTasks() {
        return sDownloaderTasks;
    }

    @Deprecated
    @VisibleForTesting
    public static void clearDownloaderTasks() {
        sDownloaderTasks.clear();
    }
}
