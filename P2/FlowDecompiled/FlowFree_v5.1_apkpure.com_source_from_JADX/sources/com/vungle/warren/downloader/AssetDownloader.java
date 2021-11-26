package com.vungle.warren.downloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.NetworkProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@SuppressLint({"LogNotTimber"})
public class AssetDownloader implements Downloader {
    /* access modifiers changed from: private */
    public static final String TAG = AssetDownloader.class.getSimpleName();
    public static final long VERIFICATION_WINDOW = TimeUnit.HOURS.toMillis(24);
    private final Object addLock = new Object();
    /* access modifiers changed from: private */
    public final DownloaderCache cache;
    private final ThreadPoolExecutor downloadExecutor;
    private boolean isCacheEnabled = true;
    int maxReconnectAttempts = 10;
    private Map<String, DownloadRequestMediator> mediators = new ConcurrentHashMap();
    private final NetworkProvider.NetworkListener networkListener = new NetworkProvider.NetworkListener() {
        public void onChanged(int i) {
            String access$100 = AssetDownloader.TAG;
            Log.d(access$100, "Network changed: " + i);
            AssetDownloader.this.onNetworkChanged(i);
        }
    };
    private final NetworkProvider networkProvider;
    /* access modifiers changed from: private */
    public final OkHttpClient okHttpClient;
    /* access modifiers changed from: private */
    public volatile int progressStep = 5;
    int reconnectTimeout = 300;
    int retryCountOnConnectionLost = 5;
    private final long timeWindow;
    private List<DownloadRequest> transitioning = new ArrayList();
    private final ExecutorService uiExecutor;

    public AssetDownloader(DownloaderCache downloaderCache, long j, int i, NetworkProvider networkProvider2, ExecutorService executorService) {
        this.cache = downloaderCache;
        int max = Math.max(i, 1);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 1, timeUnit, new PriorityBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.timeWindow = j;
        this.downloadExecutor = threadPoolExecutor;
        this.networkProvider = networkProvider2;
        this.uiExecutor = executorService;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, timeUnit);
        builder.connectTimeout(30, timeUnit);
        builder.cache((Cache) null);
        builder.followRedirects(true);
        builder.followSslRedirects(true);
        this.okHttpClient = builder.build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void download(final com.vungle.warren.downloader.DownloadRequest r5, final com.vungle.warren.downloader.AssetDownloadListener r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x0020
            java.lang.String r5 = "AssetDownloader#download; loadAd sequence"
            java.lang.String r0 = "downloadRequest is null"
            com.vungle.warren.VungleLogger.error(r5, r0)     // Catch:{ all -> 0x0034 }
            if (r6 == 0) goto L_0x001e
            r5 = 0
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0034 }
            r1 = -1
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "DownloadRequest is null"
            r2.<init>(r3)     // Catch:{ all -> 0x0034 }
            r3 = 1
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x0034 }
            r4.deliverError(r5, r6, r0)     // Catch:{ all -> 0x0034 }
        L_0x001e:
            monitor-exit(r4)
            return
        L_0x0020:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r4.transitioning     // Catch:{ all -> 0x0034 }
            r0.add(r5)     // Catch:{ all -> 0x0034 }
            java.util.concurrent.ThreadPoolExecutor r0 = r4.downloadExecutor     // Catch:{ all -> 0x0034 }
            com.vungle.warren.downloader.AssetDownloader$1 r1 = new com.vungle.warren.downloader.AssetDownloader$1     // Catch:{ all -> 0x0034 }
            r2 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r1.<init>(r2, r5, r6)     // Catch:{ all -> 0x0034 }
            r0.execute(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)
            return
        L_0x0034:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.download(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.transitioning.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (r1.mo27289is(6) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        if (r1.mo27289is(3) == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r8.isCancelled() != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r1.isCacheable == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        r1.add(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if (r1.mo27289is(2) == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        load(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
        com.vungle.warren.VungleLogger.warn("AssetDownloader#launchRequest; loadAd sequence", "request " + r8 + " is already running");
        deliverError(r8, r9, new com.vungle.warren.downloader.AssetDownloadListener.DownloadError(-1, new java.lang.IllegalArgumentException("DownloadRequest is already running"), 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        r8 = makeNewMediator(r8, r9);
        r7.mediators.put(r1.key, r8);
        load(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launchRequest(com.vungle.warren.downloader.DownloadRequest r8, com.vungle.warren.downloader.AssetDownloadListener r9) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.addLock
            monitor-enter(r0)
            monitor-enter(r7)     // Catch:{ all -> 0x00e6 }
            boolean r1 = r8.isCancelled()     // Catch:{ all -> 0x00e3 }
            r2 = 1
            r3 = -1
            r4 = 3
            if (r1 == 0) goto L_0x0048
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Request "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r8.url     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = " is cancelled before starting"
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            android.util.Log.d(r1, r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$Progress r1 = new com.vungle.warren.downloader.AssetDownloadListener$Progress     // Catch:{ all -> 0x00e3 }
            r1.<init>()     // Catch:{ all -> 0x00e3 }
            r1.status = r4     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00e3 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "Cancelled"
            r4.<init>(r5)     // Catch:{ all -> 0x00e3 }
            r1.<init>(r3, r4, r2)     // Catch:{ all -> 0x00e3 }
            r7.deliverError(r8, r9, r1)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x0048:
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r1 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r7.mediatorKeyFromRequest(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r1 = (com.vungle.warren.downloader.DownloadRequestMediator) r1     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x006c
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00e3 }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r8.key     // Catch:{ all -> 0x00e3 }
            r9.put(r1, r8)     // Catch:{ all -> 0x00e3 }
            r7.load(r8)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x006c:
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            r1.lock()     // Catch:{ all -> 0x00de }
            monitor-enter(r7)     // Catch:{ all -> 0x00de }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r5 = r7.transitioning     // Catch:{ all -> 0x00db }
            r5.remove(r8)     // Catch:{ all -> 0x00db }
            r5 = 6
            boolean r5 = r1.mo27289is(r5)     // Catch:{ all -> 0x00db }
            if (r5 != 0) goto L_0x00c7
            boolean r4 = r1.mo27289is(r4)     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x008a
            boolean r4 = r8.isCancelled()     // Catch:{ all -> 0x00db }
            if (r4 != 0) goto L_0x008a
            goto L_0x00c7
        L_0x008a:
            boolean r4 = r1.isCacheable     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x009c
            r1.add(r8, r9)     // Catch:{ all -> 0x00db }
            r8 = 2
            boolean r8 = r1.mo27289is(r8)     // Catch:{ all -> 0x00db }
            if (r8 == 0) goto L_0x00d5
            r7.load(r1)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x009c:
            java.lang.String r4 = "AssetDownloader#launchRequest; loadAd sequence"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "request "
            r5.append(r6)     // Catch:{ all -> 0x00db }
            r5.append(r8)     // Catch:{ all -> 0x00db }
            java.lang.String r6 = " is already running"
            r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00db }
            com.vungle.warren.VungleLogger.warn(r4, r5)     // Catch:{ all -> 0x00db }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00db }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "DownloadRequest is already running"
            r5.<init>(r6)     // Catch:{ all -> 0x00db }
            r4.<init>(r3, r5, r2)     // Catch:{ all -> 0x00db }
            r7.deliverError(r8, r9, r4)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x00c7:
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00db }
            java.lang.String r2 = r1.key     // Catch:{ all -> 0x00db }
            r9.put(r2, r8)     // Catch:{ all -> 0x00db }
            r7.load(r8)     // Catch:{ all -> 0x00db }
        L_0x00d5:
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x00db:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            throw r8     // Catch:{ all -> 0x00de }
        L_0x00de:
            r8 = move-exception
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e3:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.launchRequest(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    private DownloadRequestMediator makeNewMediator(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) throws IOException {
        String str;
        boolean z;
        File file;
        File file2;
        if (!isCacheEnabled()) {
            file2 = new File(downloadRequest.path);
            file = new File(file2.getPath() + ".vng_meta");
            str = downloadRequest.url + " " + downloadRequest.path;
            z = false;
        } else {
            file2 = this.cache.getFile(downloadRequest.url);
            file = this.cache.getMetaFile(file2);
            str = downloadRequest.url;
            z = true;
        }
        Log.d(TAG, "Destination file " + file2.getPath());
        return new DownloadRequestMediator(downloadRequest, assetDownloadListener, file2.getPath(), file.getPath(), z, str);
    }

    public synchronized List<DownloadRequest> getAllRequests() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (DownloadRequestMediator requests : new ArrayList(this.mediators.values())) {
            arrayList.addAll(requests.requests());
        }
        arrayList.addAll(this.transitioning);
        return arrayList;
    }

    private synchronized void load(final DownloadRequestMediator downloadRequestMediator) {
        addNetworkListener();
        downloadRequestMediator.set(1);
        this.downloadExecutor.execute(new DownloadPriorityRunnable(downloadRequestMediator) {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v8, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v9, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: com.vungle.warren.downloader.DownloadRequestMediator} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v10, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v53, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v41, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v42, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v13, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v14, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v44, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v15, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v45, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v16, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v17, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v47, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v48, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v19, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v20, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v21, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v22, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v23, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v24, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v25, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v26, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v121, resolved type: okio.BufferedSink} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v27, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v28, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v29, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v30, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v58, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v32, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v33, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v34, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v35, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v36, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v70, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v37, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v39, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v85, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v41, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v42, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v43, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v44, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v58, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v93, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v94, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v98, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v97, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v98, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v52, resolved type: long} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v62, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v64, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v99, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v100, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v101, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: okhttp3.Response} */
            /* JADX WARNING: type inference failed for: r29v1 */
            /* JADX WARNING: type inference failed for: r29v2 */
            /* JADX WARNING: type inference failed for: r29v3, types: [okhttp3.Call] */
            /* JADX WARNING: type inference failed for: r8v23, types: [boolean] */
            /* JADX WARNING: type inference failed for: r8v48 */
            /* JADX WARNING: type inference failed for: r29v11 */
            /* JADX WARNING: type inference failed for: r6v28 */
            /* JADX WARNING: type inference failed for: r29v12 */
            /* JADX WARNING: type inference failed for: r6v29 */
            /* JADX WARNING: type inference failed for: r29v18 */
            /* JADX WARNING: type inference failed for: r5v27, types: [okio.BufferedSource, okio.Source, java.io.Closeable] */
            /* JADX WARNING: type inference failed for: r6v47 */
            /* JADX WARNING: type inference failed for: r29v31 */
            /* JADX WARNING: type inference failed for: r29v38 */
            /* JADX WARNING: type inference failed for: r29v40 */
            /* JADX WARNING: type inference failed for: r4v108 */
            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                	at java.base/java.util.Objects.checkIndex(Objects.java:372)
                	at java.base/java.util.ArrayList.get(ArrayList.java:458)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                */
            /* JADX WARNING: Multi-variable type inference failed */
            public void run() {
                /*
                    r32 = this;
                    r1 = r32
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    r2 = 0
                    r0.setRunnable(r2)
                    com.vungle.warren.downloader.AssetDownloadListener$Progress r3 = new com.vungle.warren.downloader.AssetDownloadListener$Progress
                    r3.<init>()
                    long r4 = java.lang.System.currentTimeMillis()
                    r3.timestampDownloadStart = r4
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    java.lang.String r4 = r0.url
                    java.lang.String r5 = r0.filePath
                    java.lang.String r0 = r0.metaPath
                    java.io.File r12 = new java.io.File
                    r12.<init>(r5)
                    java.io.File r5 = new java.io.File
                    r5.<init>(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.startTracking(r12)
                L_0x003c:
                    r14 = r2
                    r0 = 0
                    r11 = 0
                    r15 = 0
                L_0x0040:
                    if (r0 != 0) goto L_0x0dfa
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "Start load: url: "
                    r6.append(r7)
                    r6.append(r4)
                    java.lang.String r6 = r6.toString()
                    android.util.Log.d(r0, r6)
                    r9 = 2
                    r7 = 5
                    r8 = 3
                    r6 = 4
                    r13 = 1
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x098d }
                    boolean r0 = r0.mo27289is(r13)     // Catch:{ all -> 0x098d }
                    if (r0 != 0) goto L_0x015e
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x014a }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
                    r10.<init>()     // Catch:{ all -> 0x014a }
                    java.lang.String r13 = "Abort download, wrong state "
                    r10.append(r13)     // Catch:{ all -> 0x014a }
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x014a }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x014a }
                    java.lang.String r2 = r13.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x014a }
                    r10.append(r2)     // Catch:{ all -> 0x014a }
                    java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x014a }
                    android.util.Log.w(r0, r2)     // Catch:{ all -> 0x014a }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r9) goto L_0x00d6
                    if (r0 == r8) goto L_0x00cf
                    if (r0 == r6) goto L_0x00c7
                    if (r0 == r7) goto L_0x00bf
                    if (r15 != 0) goto L_0x00d6
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x00d6
                L_0x00bf:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r14, r2)
                    goto L_0x00d6
                L_0x00c7:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x00d6
                L_0x00cf:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x00d6:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0147 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0147 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0147 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0146
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0146
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x013d
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0146
                L_0x013d:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0146:
                    return
                L_0x0147:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0147 }
                    throw r0
                L_0x014a:
                    r0 = move-exception
                    r9 = r0
                    r23 = r4
                    r6 = r5
                    r0 = r11
                    r7 = r14
                    r27 = r15
                    r2 = 0
                    r4 = 3
                    r5 = 0
                    r8 = 0
                    r10 = -1
                    r17 = 0
                    r29 = 0
                    goto L_0x09a1
                L_0x015e:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x097f }
                    boolean r0 = r0.isAnyConnected(r2)     // Catch:{ all -> 0x097f }
                    if (r0 == 0) goto L_0x0949
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x097f }
                    r2 = 1
                    r0.setConnected(r2)     // Catch:{ all -> 0x097f }
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x097f }
                    if (r0 == 0) goto L_0x0185
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x014a }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x014a }
                    if (r0 != 0) goto L_0x0185
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x014a }
                    r0.mkdirs()     // Catch:{ all -> 0x014a }
                L_0x0185:
                    boolean r0 = r12.exists()     // Catch:{ all -> 0x097f }
                    r18 = 0
                    if (r0 == 0) goto L_0x0194
                    long r20 = r12.length()     // Catch:{ all -> 0x014a }
                    r7 = r20
                    goto L_0x0196
                L_0x0194:
                    r7 = r18
                L_0x0196:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x097f }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x097f }
                    r13.<init>()     // Catch:{ all -> 0x097f }
                    java.lang.String r2 = "already downloaded : "
                    r13.append(r2)     // Catch:{ all -> 0x097f }
                    r13.append(r7)     // Catch:{ all -> 0x097f }
                    java.lang.String r2 = ", file exists = "
                    r13.append(r2)     // Catch:{ all -> 0x097f }
                    boolean r2 = r12.exists()     // Catch:{ all -> 0x097f }
                    r13.append(r2)     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x097f }
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r10)     // Catch:{ all -> 0x097f }
                    r13.append(r2)     // Catch:{ all -> 0x097f }
                    java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x097f }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097f }
                    java.util.HashMap r0 = r0.extractMeta(r5)     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x097f }
                    boolean r2 = r2.useCacheWithoutVerification(r10, r12, r0)     // Catch:{ all -> 0x097f }
                    if (r2 == 0) goto L_0x02a8
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x014a }
                    r0.set(r6)     // Catch:{ all -> 0x014a }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x014a }
                    java.lang.String r2 = "Using cache without verification, dispatch existing file"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x014a }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r9) goto L_0x0234
                    r2 = 3
                    if (r0 == r2) goto L_0x022d
                    if (r0 == r6) goto L_0x0225
                    r10 = 5
                    if (r0 == r10) goto L_0x021d
                    if (r15 != 0) goto L_0x0234
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0234
                L_0x021d:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r14, r2)
                    goto L_0x0234
                L_0x0225:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0234
                L_0x022d:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0234:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r7)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x02a5 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x02a5 }
                    monitor-exit(r7)     // Catch:{ all -> 0x02a5 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x02a4
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x02a4
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x029b
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x02a4
                L_0x029b:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x02a4:
                    return
                L_0x02a5:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x02a5 }
                    throw r0
                L_0x02a8:
                    r2 = 3
                    r10 = 5
                    okhttp3.Request$Builder r13 = new okhttp3.Request$Builder     // Catch:{ all -> 0x097f }
                    r13.<init>()     // Catch:{ all -> 0x097f }
                    r13.url((java.lang.String) r4)     // Catch:{ all -> 0x097f }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097f }
                    r20 = r14
                    r14 = 4
                    r6 = r2
                    r28 = r7
                    r2 = 5
                    r10 = 3
                    r2 = 2
                    r9 = r12
                    r10 = r0
                    r2 = r11
                    r11 = r13
                    r6.appendHeaders(r7, r9, r10, r11)     // Catch:{ all -> 0x093e }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x093e }
                    okhttp3.OkHttpClient r6 = r6.okHttpClient     // Catch:{ all -> 0x093e }
                    okhttp3.Request r7 = r13.build()     // Catch:{ all -> 0x093e }
                    okhttp3.Call r6 = r6.newCall(r7)     // Catch:{ all -> 0x093e }
                    okhttp3.Response r7 = r6.execute()     // Catch:{ all -> 0x0929 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0913 }
                    long r8 = r8.getContentLength(r7)     // Catch:{ all -> 0x0913 }
                    java.lang.String r10 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0913 }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0913 }
                    r11.<init>()     // Catch:{ all -> 0x0913 }
                    java.lang.String r13 = "Response code: "
                    r11.append(r13)     // Catch:{ all -> 0x0913 }
                    int r13 = r7.code()     // Catch:{ all -> 0x0913 }
                    r11.append(r13)     // Catch:{ all -> 0x0913 }
                    java.lang.String r13 = " "
                    r11.append(r13)     // Catch:{ all -> 0x0913 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0913 }
                    r11.append(r13)     // Catch:{ all -> 0x0913 }
                    java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0913 }
                    android.util.Log.d(r10, r11)     // Catch:{ all -> 0x0913 }
                    int r10 = r7.code()     // Catch:{ all -> 0x0913 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08fa }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x08fa }
                    boolean r11 = r11.notModified(r12, r7, r13, r0)     // Catch:{ all -> 0x08fa }
                    if (r11 != 0) goto L_0x07c7
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07ae }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x07ae }
                    boolean r11 = r11.useCacheOnFail(r13, r12, r0, r10)     // Catch:{ all -> 0x07ae }
                    if (r11 == 0) goto L_0x031c
                    goto L_0x07c7
                L_0x031c:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07ae }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x07ae }
                    r22 = r0
                    r23 = r28
                    r25 = r10
                    r26 = r7
                    r27 = r11
                    boolean r0 = r22.partialMalformed(r23, r25, r26, r27)     // Catch:{ all -> 0x07ae }
                    if (r0 == 0) goto L_0x03d3
                    int r11 = r2 + 1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03bf }
                    int r8 = r0.maxReconnectAttempts     // Catch:{ all -> 0x03bf }
                    if (r2 >= r8) goto L_0x03a8
                    r2 = 0
                    r0.deleteFileAndMeta(r12, r5, r2)     // Catch:{ all -> 0x03bf }
                    if (r7 == 0) goto L_0x034b
                    okhttp3.ResponseBody r0 = r7.body()
                    if (r0 == 0) goto L_0x034b
                    okhttp3.ResponseBody r0 = r7.body()
                    r0.close()
                L_0x034b:
                    if (r6 == 0) goto L_0x0350
                    r6.cancel()
                L_0x0350:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r6 = "request is done "
                    r2.append(r6)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r2.append(r6)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r6 = "Not removing connections and listener "
                    r2.append(r6)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r2.append(r6)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03a5 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x03a5 }
                    monitor-exit(r2)     // Catch:{ all -> 0x03a5 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    r14 = r20
                    r0 = 0
                    goto L_0x0cef
                L_0x03a5:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x03a5 }
                    throw r0
                L_0x03a8:
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x03bf }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03bf }
                    r2.<init>()     // Catch:{ all -> 0x03bf }
                    java.lang.String r8 = "Code: "
                    r2.append(r8)     // Catch:{ all -> 0x03bf }
                    r2.append(r10)     // Catch:{ all -> 0x03bf }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03bf }
                    r0.<init>(r2)     // Catch:{ all -> 0x03bf }
                    throw r0     // Catch:{ all -> 0x03bf }
                L_0x03bf:
                    r0 = move-exception
                    r9 = r0
                    r23 = r4
                    r29 = r6
                    r2 = r7
                    r0 = r11
                L_0x03c7:
                    r27 = r15
                L_0x03c9:
                    r7 = r20
                    r4 = 3
                    r8 = 0
                    r17 = 0
                    r6 = r5
                    r5 = 0
                    goto L_0x09a1
                L_0x03d3:
                    boolean r0 = r7.isSuccessful()     // Catch:{ all -> 0x07ae }
                    if (r0 == 0) goto L_0x0782
                    r0 = 206(0xce, float:2.89E-43)
                    if (r10 == r0) goto L_0x03f0
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03e7 }
                    r11 = 0
                    r0.deleteFileAndMeta(r12, r5, r11)     // Catch:{ all -> 0x03e7 }
                    r13 = r15
                    r14 = r18
                    goto L_0x03f3
                L_0x03e7:
                    r0 = move-exception
                    r9 = r0
                    r0 = r2
                    r23 = r4
                    r29 = r6
                    r2 = r7
                    goto L_0x03c7
                L_0x03f0:
                    r13 = r15
                    r14 = r28
                L_0x03f3:
                    com.vungle.warren.utility.FileUtility.deleteAndLogIfFailed(r5)     // Catch:{ all -> 0x0771 }
                    okhttp3.Headers r0 = r7.headers()     // Catch:{ all -> 0x0771 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0771 }
                    r11.checkEncoding(r12, r5, r0)     // Catch:{ all -> 0x0771 }
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0771 }
                    java.util.HashMap r0 = r11.makeMeta(r5, r0, r4)     // Catch:{ all -> 0x0771 }
                    boolean r11 = okhttp3.internal.http.HttpHeaders.hasBody(r7)     // Catch:{ all -> 0x0771 }
                    if (r11 == 0) goto L_0x0741
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0771 }
                    com.vungle.warren.downloader.DownloaderCache r11 = r11.cache     // Catch:{ all -> 0x0771 }
                    if (r11 == 0) goto L_0x043f
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0434 }
                    com.vungle.warren.downloader.DownloaderCache r11 = r11.cache     // Catch:{ all -> 0x0434 }
                    r23 = r4
                    r24 = r5
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0425 }
                    r11.setCacheLastUpdateTimestamp(r12, r4)     // Catch:{ all -> 0x0425 }
                    goto L_0x0443
                L_0x0425:
                    r0 = move-exception
                    r9 = r0
                    r0 = r2
                    r29 = r6
                    r2 = r7
                    r27 = r13
                    r7 = r20
                    r6 = r24
                    r4 = 3
                    goto L_0x07c1
                L_0x0434:
                    r0 = move-exception
                    r23 = r4
                    r9 = r0
                    r0 = r2
                    r29 = r6
                    r2 = r7
                    r27 = r13
                    goto L_0x03c9
                L_0x043f:
                    r23 = r4
                    r24 = r5
                L_0x0443:
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0734 }
                    okhttp3.ResponseBody r4 = r4.decodeGzipIfNeeded(r7)     // Catch:{ all -> 0x0734 }
                    okio.BufferedSource r5 = r4.source()     // Catch:{ all -> 0x0734 }
                    java.lang.String r11 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x071f }
                    r25 = r2
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x071d }
                    r2.<init>()     // Catch:{ all -> 0x071d }
                    r26 = r10
                    java.lang.String r10 = "Start download from bytes: "
                    r2.append(r10)     // Catch:{ all -> 0x070a }
                    r2.append(r14)     // Catch:{ all -> 0x070a }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x070a }
                    r27 = r13
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0700 }
                    java.lang.String r10 = r10.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r13)     // Catch:{ all -> 0x0700 }
                    r2.append(r10)     // Catch:{ all -> 0x0700 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0700 }
                    android.util.Log.d(r11, r2)     // Catch:{ all -> 0x0700 }
                    long r8 = r8 + r14
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0700 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0700 }
                    r10.<init>()     // Catch:{ all -> 0x0700 }
                    java.lang.String r11 = "final offset = "
                    r10.append(r11)     // Catch:{ all -> 0x0700 }
                    r10.append(r14)     // Catch:{ all -> 0x0700 }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0700 }
                    android.util.Log.d(r2, r10)     // Catch:{ all -> 0x0700 }
                    int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                    if (r2 != 0) goto L_0x04a8
                    okio.Sink r2 = okio.Okio.sink((java.io.File) r12)     // Catch:{ all -> 0x0498 }
                    goto L_0x04ac
                L_0x0498:
                    r0 = move-exception
                    r9 = r0
                    r29 = r6
                    r2 = r7
                    r7 = r20
                    r6 = r24
                    r0 = r25
                    r10 = r26
                    r4 = 3
                    goto L_0x07c2
                L_0x04a8:
                    okio.Sink r2 = okio.Okio.appendingSink(r12)     // Catch:{ all -> 0x0700 }
                L_0x04ac:
                    okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x0700 }
                    r10 = 0
                    r3.status = r10     // Catch:{ all -> 0x06ec }
                    long r10 = r4.contentLength()     // Catch:{ all -> 0x06ec }
                    r3.sizeBytes = r10     // Catch:{ all -> 0x06ec }
                    r3.startBytes = r14     // Catch:{ all -> 0x06ec }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06ec }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x06ec }
                    r4.onProgressMediator(r10, r3)     // Catch:{ all -> 0x06ec }
                    r10 = r18
                    r4 = 0
                L_0x04c5:
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x06ec }
                    r28 = r4
                    r4 = 1
                    boolean r13 = r13.mo27289is(r4)     // Catch:{ all -> 0x06ec }
                    if (r13 == 0) goto L_0x0586
                    okio.Buffer r4 = r2.buffer()     // Catch:{ all -> 0x0573 }
                    r29 = r6
                    r13 = r7
                    r6 = 2048(0x800, double:1.0118E-320)
                    long r6 = r5.read(r4, r6)     // Catch:{ all -> 0x0571 }
                    r30 = -1
                    int r4 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
                    if (r4 == 0) goto L_0x0589
                    boolean r4 = r12.exists()     // Catch:{ all -> 0x0571 }
                    if (r4 == 0) goto L_0x0558
                    r2.emit()     // Catch:{ all -> 0x0571 }
                    long r10 = r10 + r6
                    long r6 = r14 + r10
                    r30 = 100
                    int r4 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
                    if (r4 <= 0) goto L_0x04fa
                    long r6 = r6 * r30
                    long r6 = r6 / r8
                    int r4 = (int) r6     // Catch:{ all -> 0x0571 }
                    goto L_0x04fc
                L_0x04fa:
                    r4 = r28
                L_0x04fc:
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3     // Catch:{ all -> 0x0571 }
                    boolean r6 = r6.isConnected()     // Catch:{ all -> 0x0571 }
                    if (r6 == 0) goto L_0x0537
                L_0x0504:
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0571 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0571 }
                    int r6 = r6 + r7
                    if (r6 > r4) goto L_0x0533
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0571 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0571 }
                    int r6 = r6 + r7
                    long r6 = (long) r6     // Catch:{ all -> 0x0571 }
                    int r28 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
                    if (r28 > 0) goto L_0x0533
                    r6 = 1
                    r3.status = r6     // Catch:{ all -> 0x0571 }
                    int r6 = r3.progressPercent     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0571 }
                    int r7 = r7.progressStep     // Catch:{ all -> 0x0571 }
                    int r6 = r6 + r7
                    r3.progressPercent = r6     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x0571 }
                    r6.onProgressMediator(r7, r3)     // Catch:{ all -> 0x0571 }
                    goto L_0x0504
                L_0x0533:
                    r7 = r13
                    r6 = r29
                    goto L_0x04c5
                L_0x0537:
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r4 = "mediator %s is not connected"
                    r6 = 1
                    java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0571 }
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)     // Catch:{ all -> 0x0571 }
                    r8 = 0
                    r7[r8] = r6     // Catch:{ all -> 0x0571 }
                    java.lang.String r4 = java.lang.String.format(r4, r7)     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.VungleLogger.error(r0, r4)     // Catch:{ all -> 0x0571 }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0571 }
                    java.lang.String r4 = "Request is not connected"
                    r0.<init>(r4)     // Catch:{ all -> 0x0571 }
                    throw r0     // Catch:{ all -> 0x0571 }
                L_0x0558:
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r4 = "file %s does not exist"
                    r6 = 1
                    java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0571 }
                    r6 = 0
                    r7[r6] = r12     // Catch:{ all -> 0x0571 }
                    java.lang.String r4 = java.lang.String.format(r4, r7)     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.VungleLogger.error(r0, r4)     // Catch:{ all -> 0x0571 }
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x0571 }
                    java.lang.String r4 = "File is not existing"
                    r0.<init>(r4)     // Catch:{ all -> 0x0571 }
                    throw r0     // Catch:{ all -> 0x0571 }
                L_0x0571:
                    r0 = move-exception
                    goto L_0x0577
                L_0x0573:
                    r0 = move-exception
                    r29 = r6
                    r13 = r7
                L_0x0577:
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r7 = r20
                    r6 = r24
                L_0x057f:
                    r0 = r25
                    r10 = r26
                    r4 = 3
                    goto L_0x06fd
                L_0x0586:
                    r29 = r6
                    r13 = r7
                L_0x0589:
                    r2.flush()     // Catch:{ all -> 0x06ea }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x06ea }
                    r6 = 1
                    boolean r4 = r4.mo27289is(r6)     // Catch:{ all -> 0x06ea }
                    if (r4 == 0) goto L_0x05d0
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x05c6 }
                    java.lang.String r4 = "DOWNLOAD_COMPLETE"
                    java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x05c6 }
                    java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x05c6 }
                    r0.put(r4, r8)     // Catch:{ all -> 0x05c6 }
                    java.lang.String r4 = "Last-Cache-Verification"
                    java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x05c6 }
                    r0.put(r4, r8)     // Catch:{ all -> 0x05c6 }
                    java.lang.String r4 = "Last-Download"
                    java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x05c6 }
                    r0.put(r4, r6)     // Catch:{ all -> 0x05c6 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05c6 }
                    r6 = r24
                    r4.saveMeta(r6, r0)     // Catch:{ all -> 0x05c4 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x05c4 }
                    r4 = 4
                    r0.set(r4)     // Catch:{ all -> 0x05c4 }
                    goto L_0x05fc
                L_0x05c4:
                    r0 = move-exception
                    goto L_0x05c9
                L_0x05c6:
                    r0 = move-exception
                    r6 = r24
                L_0x05c9:
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r7 = r20
                    goto L_0x057f
                L_0x05d0:
                    r6 = r24
                    r0 = 6
                    r3.status = r0     // Catch:{ all -> 0x06e6 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06e6 }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x06e6 }
                    r0.onProgressMediator(r4, r3)     // Catch:{ all -> 0x06e6 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x06e6 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x06e6 }
                    r4.<init>()     // Catch:{ all -> 0x06e6 }
                    java.lang.String r7 = "State has changed, cancelling download "
                    r4.append(r7)     // Catch:{ all -> 0x06e6 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06e6 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x06e6 }
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)     // Catch:{ all -> 0x06e6 }
                    r4.append(r7)     // Catch:{ all -> 0x06e6 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x06e6 }
                    android.util.Log.d(r0, r4)     // Catch:{ all -> 0x06e6 }
                L_0x05fc:
                    if (r13 == 0) goto L_0x060b
                    okhttp3.ResponseBody r0 = r13.body()
                    if (r0 == 0) goto L_0x060b
                    okhttp3.ResponseBody r0 = r13.body()
                    r0.close()
                L_0x060b:
                    if (r29 == 0) goto L_0x0610
                    r29.cancel()
                L_0x0610:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r7 = "request is done "
                    r4.append(r7)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r4.append(r7)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r4 = 2
                    if (r0 == r4) goto L_0x066a
                    r4 = 3
                    if (r0 == r4) goto L_0x0660
                    r4 = 4
                    if (r0 == r4) goto L_0x0656
                    r4 = 5
                    if (r0 == r4) goto L_0x064c
                    if (r27 != 0) goto L_0x066a
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.removeMediator(r4)
                    goto L_0x066a
                L_0x064c:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r7 = r20
                    r0.onErrorMediator(r7, r4)
                    goto L_0x066c
                L_0x0656:
                    r7 = r20
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.onSuccessMediator(r12, r4)
                    goto L_0x066c
                L_0x0660:
                    r7 = r20
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r0.onCancelledMediator(r4)
                    goto L_0x066c
                L_0x066a:
                    r7 = r20
                L_0x066c:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r8 = "Done with request in state "
                    r4.append(r8)
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    int r8 = r8.getStatus()
                    r4.append(r8)
                    java.lang.String r8 = " "
                    r4.append(r8)
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3
                    java.lang.String r8 = r8.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r9)
                    r4.append(r8)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06e3 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x06e3 }
                    monitor-exit(r8)     // Catch:{ all -> 0x06e3 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x06db
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x06db
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x06d2
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x06db
                L_0x06d2:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x06db:
                    r11 = r25
                    r15 = r27
                    r0 = 1
                    r14 = 0
                    goto L_0x0ceb
                L_0x06e3:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x06e3 }
                    throw r0
                L_0x06e6:
                    r0 = move-exception
                    r7 = r20
                    goto L_0x06f4
                L_0x06ea:
                    r0 = move-exception
                    goto L_0x06f0
                L_0x06ec:
                    r0 = move-exception
                    r29 = r6
                    r13 = r7
                L_0x06f0:
                    r7 = r20
                    r6 = r24
                L_0x06f4:
                    r4 = 3
                    r9 = r0
                    r17 = r2
                    r2 = r13
                    r0 = r25
                    r10 = r26
                L_0x06fd:
                    r8 = 0
                    goto L_0x09a1
                L_0x0700:
                    r0 = move-exception
                    r29 = r6
                    r13 = r7
                    r7 = r20
                    r6 = r24
                    r4 = 3
                    goto L_0x0715
                L_0x070a:
                    r0 = move-exception
                    r29 = r6
                    r27 = r13
                    r6 = r24
                    r4 = 3
                    r13 = r7
                    r7 = r20
                L_0x0715:
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    r10 = r26
                    goto L_0x07c2
                L_0x071d:
                    r0 = move-exception
                    goto L_0x0722
                L_0x071f:
                    r0 = move-exception
                    r25 = r2
                L_0x0722:
                    r29 = r6
                    r26 = r10
                    r27 = r13
                    r6 = r24
                    r4 = 3
                    r13 = r7
                    r7 = r20
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    goto L_0x07c2
                L_0x0734:
                    r0 = move-exception
                    r25 = r2
                    r29 = r6
                    r26 = r10
                    r27 = r13
                    r6 = r24
                    r4 = 3
                    goto L_0x077e
                L_0x0741:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r26 = r10
                    r27 = r13
                    r4 = 3
                    r6 = r5
                    r13 = r7
                    r7 = r20
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "response has no body %s"
                    r5 = 1
                    java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0769 }
                    r5 = 0
                    r8[r5] = r13     // Catch:{ all -> 0x0769 }
                    java.lang.String r2 = java.lang.String.format(r2, r8)     // Catch:{ all -> 0x0769 }
                    com.vungle.warren.VungleLogger.error(r0, r2)     // Catch:{ all -> 0x0769 }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0769 }
                    java.lang.String r2 = "Response body is null"
                    r0.<init>(r2)     // Catch:{ all -> 0x0769 }
                    throw r0     // Catch:{ all -> 0x0769 }
                L_0x0769:
                    r0 = move-exception
                    r9 = r0
                    r2 = r13
                    r0 = r25
                    r10 = r26
                    goto L_0x07c1
                L_0x0771:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r26 = r10
                    r27 = r13
                    r4 = 3
                    r6 = r5
                L_0x077e:
                    r13 = r7
                    r7 = r20
                    goto L_0x07bd
                L_0x0782:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r26 = r10
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r6 = r5
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x07aa }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x07aa }
                    r2.<init>()     // Catch:{ all -> 0x07aa }
                    java.lang.String r5 = "Code: "
                    r2.append(r5)     // Catch:{ all -> 0x07aa }
                    r5 = r26
                    r2.append(r5)     // Catch:{ all -> 0x07f5 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x07f5 }
                    r0.<init>(r2)     // Catch:{ all -> 0x07f5 }
                    throw r0     // Catch:{ all -> 0x07f5 }
                L_0x07aa:
                    r0 = move-exception
                    r5 = r26
                    goto L_0x07f6
                L_0x07ae:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r6 = r5
                    r5 = r10
                L_0x07bd:
                    r9 = r0
                L_0x07be:
                    r2 = r13
                    r0 = r25
                L_0x07c1:
                    r5 = 0
                L_0x07c2:
                    r8 = 0
                    r17 = 0
                    goto L_0x09a1
                L_0x07c7:
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r6 = r5
                    r5 = r10
                    r2 = 304(0x130, float:4.26E-43)
                    if (r5 != r2) goto L_0x07f9
                    java.lang.String r2 = "Last-Cache-Verification"
                    long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x07f5 }
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x07f5 }
                    r0.put(r2, r8)     // Catch:{ all -> 0x07f5 }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07f5 }
                    r2.saveMeta(r6, r0)     // Catch:{ all -> 0x07f5 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x07f5 }
                    java.lang.String r2 = "Verification success, dispatch existing file"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x07f5 }
                    goto L_0x0815
                L_0x07f5:
                    r0 = move-exception
                L_0x07f6:
                    r9 = r0
                    r10 = r5
                    goto L_0x07be
                L_0x07f9:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x08f5 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f5 }
                    r2.<init>()     // Catch:{ all -> 0x08f5 }
                    java.lang.String r8 = "Using local cache file despite response code = "
                    r2.append(r8)     // Catch:{ all -> 0x08f5 }
                    int r8 = r13.code()     // Catch:{ all -> 0x08f5 }
                    r2.append(r8)     // Catch:{ all -> 0x08f5 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x08f5 }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x08f5 }
                L_0x0815:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x08f5 }
                    r2 = 4
                    r0.set(r2)     // Catch:{ all -> 0x08f5 }
                    if (r13 == 0) goto L_0x082a
                    okhttp3.ResponseBody r0 = r13.body()
                    if (r0 == 0) goto L_0x082a
                    okhttp3.ResponseBody r0 = r13.body()
                    r0.close()
                L_0x082a:
                    if (r29 == 0) goto L_0x082f
                    r29.cancel()
                L_0x082f:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x0881
                    if (r0 == r4) goto L_0x087a
                    r2 = 4
                    if (r0 == r2) goto L_0x0872
                    r2 = 5
                    if (r0 == r2) goto L_0x086a
                    if (r27 != 0) goto L_0x0881
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0881
                L_0x086a:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r7, r2)
                    goto L_0x0881
                L_0x0872:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0881
                L_0x087a:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0881:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08f2 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x08f2 }
                    monitor-exit(r2)     // Catch:{ all -> 0x08f2 }
                    r8 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r8)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x08f1
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x08f1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x08e8
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x08f1
                L_0x08e8:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x08f1:
                    return
                L_0x08f2:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x08f2 }
                    throw r0
                L_0x08f5:
                    r0 = move-exception
                    r8 = 0
                    r9 = r0
                    r10 = r5
                    goto L_0x090b
                L_0x08fa:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r5 = r10
                    r9 = r0
                L_0x090b:
                    r5 = r8
                    r17 = r5
                    r2 = r13
                    r0 = r25
                    goto L_0x09a1
                L_0x0913:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r13 = r7
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r9 = r0
                    r5 = r8
                    r17 = r5
                    r2 = r13
                    goto L_0x099e
                L_0x0929:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r29 = r6
                    r27 = r15
                    r7 = r20
                    r4 = 3
                    r8 = 0
                    r6 = r5
                    r9 = r0
                    r2 = r8
                    r5 = r2
                    r17 = r5
                    goto L_0x099e
                L_0x093e:
                    r0 = move-exception
                    r25 = r2
                    r23 = r4
                    r6 = r5
                    r27 = r15
                    r7 = r20
                    goto L_0x0988
                L_0x0949:
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r27 = r15
                    r4 = 3
                    r8 = 0
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x097d }
                    java.lang.String r2 = "Request is not connected to required network"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x097d }
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "No connected to required network requests in %s"
                    r5 = 1
                    java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x097d }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x097d }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x097d }
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r10)     // Catch:{ all -> 0x097d }
                    r10 = 0
                    r9[r10] = r5     // Catch:{ all -> 0x097d }
                    java.lang.String r2 = java.lang.String.format(r2, r9)     // Catch:{ all -> 0x097d }
                    com.vungle.warren.VungleLogger.warn(r0, r2)     // Catch:{ all -> 0x097d }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x097d }
                    java.lang.String r2 = "Not connected to correct network"
                    r0.<init>(r2)     // Catch:{ all -> 0x097d }
                    throw r0     // Catch:{ all -> 0x097d }
                L_0x097d:
                    r0 = move-exception
                    goto L_0x098a
                L_0x097f:
                    r0 = move-exception
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r27 = r15
                L_0x0988:
                    r4 = 3
                    r8 = 0
                L_0x098a:
                    r9 = r0
                    r2 = r8
                    goto L_0x0999
                L_0x098d:
                    r0 = move-exception
                    r8 = r2
                    r23 = r4
                    r6 = r5
                    r25 = r11
                    r7 = r14
                    r27 = r15
                    r4 = 3
                    r9 = r0
                L_0x0999:
                    r5 = r2
                    r17 = r5
                    r29 = r17
                L_0x099e:
                    r0 = r25
                    r10 = -1
                L_0x09a1:
                    java.lang.String r13 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r14 = "exception, cannot load due to %1$s, state is %2$s"
                    r15 = 2
                    java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ all -> 0x0cf7 }
                    r15 = 0
                    r8[r15] = r9     // Catch:{ all -> 0x0cf7 }
                    com.vungle.warren.downloader.AssetDownloader r15 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0cf7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x0cf7 }
                    java.lang.String r11 = r15.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r11)     // Catch:{ all -> 0x0cf7 }
                    r15 = 1
                    r8[r15] = r11     // Catch:{ all -> 0x0cf7 }
                    java.lang.String r8 = java.lang.String.format(r14, r8)     // Catch:{ all -> 0x0cf7 }
                    com.vungle.warren.VungleLogger.error(r13, r8)     // Catch:{ all -> 0x0cf7 }
                    java.lang.String r8 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0cf7 }
                    java.lang.String r11 = "Exception on download"
                    android.util.Log.e(r8, r11, r9)     // Catch:{ all -> 0x0cf7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0cf7 }
                    boolean r8 = r8.mo27289is(r4)     // Catch:{ all -> 0x0cf7 }
                    if (r8 != 0) goto L_0x09dc
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x09d5 }
                    r11 = 5
                    r8.set(r11)     // Catch:{ all -> 0x09d5 }
                    goto L_0x09dc
                L_0x09d5:
                    r0 = move-exception
                    r14 = r7
                L_0x09d7:
                    r15 = r27
                    r13 = 1
                    goto L_0x0cfc
                L_0x09dc:
                    boolean r8 = r9 instanceof java.io.IOException     // Catch:{ all -> 0x0cf7 }
                    if (r8 == 0) goto L_0x0bcc
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09d5 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x09d5 }
                    boolean r8 = r8.isAnyConnected(r11)     // Catch:{ all -> 0x09d5 }
                    if (r8 != 0) goto L_0x0ae2
                    if (r2 != 0) goto L_0x0ae2
                    com.vungle.warren.downloader.AssetDownloader r11 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09d5 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x09d5 }
                    java.util.HashMap r14 = r11.extractMeta(r6)     // Catch:{ all -> 0x09d5 }
                    r15 = -1
                    boolean r11 = r11.useCacheOnFail(r13, r12, r14, r15)     // Catch:{ all -> 0x09d5 }
                    if (r11 == 0) goto L_0x0ae2
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x09d5 }
                    boolean r0 = r0.mo27289is(r4)     // Catch:{ all -> 0x09d5 }
                    if (r0 != 0) goto L_0x0a09
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x09d5 }
                    r3 = 4
                    r0.set(r3)     // Catch:{ all -> 0x09d5 }
                L_0x0a09:
                    if (r2 == 0) goto L_0x0a18
                    okhttp3.ResponseBody r0 = r2.body()
                    if (r0 == 0) goto L_0x0a18
                    okhttp3.ResponseBody r0 = r2.body()
                    r0.close()
                L_0x0a18:
                    if (r29 == 0) goto L_0x0a1d
                    r29.cancel()
                L_0x0a1d:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x0a6f
                    if (r0 == r4) goto L_0x0a68
                    r2 = 4
                    if (r0 == r2) goto L_0x0a60
                    r2 = 5
                    if (r0 == r2) goto L_0x0a58
                    if (r27 != 0) goto L_0x0a6f
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0a6f
                L_0x0a58:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r7, r2)
                    goto L_0x0a6f
                L_0x0a60:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0a6f
                L_0x0a68:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0a6f:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r3)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0adf }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0adf }
                    monitor-exit(r3)     // Catch:{ all -> 0x0adf }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0ade
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0ade
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0ad5
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0ade
                L_0x0ad5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0ade:
                    return
                L_0x0adf:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x0adf }
                    throw r0
                L_0x0ae2:
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x09d5 }
                    r13.setConnected(r8)     // Catch:{ all -> 0x09d5 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r13 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x09d5 }
                    com.vungle.warren.downloader.AssetDownloader r14 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09d5 }
                    int r14 = r14.mapExceptionToReason(r9, r8)     // Catch:{ all -> 0x09d5 }
                    r13.<init>(r10, r9, r14)     // Catch:{ all -> 0x09d5 }
                    if (r8 != 0) goto L_0x0b67
                    r7 = 5
                    r3.status = r7     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0b63 }
                    r7.onProgressMediator(r8, r3)     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x0b63 }
                    boolean r7 = r7.mo27289is(r4)     // Catch:{ all -> 0x0b63 }
                    if (r7 != 0) goto L_0x0b67
                    int r7 = r0 + 1
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b63 }
                    int r8 = r8.maxReconnectAttempts     // Catch:{ all -> 0x0b63 }
                    if (r0 >= r8) goto L_0x0b60
                    r0 = 0
                L_0x0b0f:
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b63 }
                    int r9 = r8.retryCountOnConnectionLost     // Catch:{ all -> 0x0b63 }
                    if (r0 >= r9) goto L_0x0b60
                    int r9 = r8.reconnectTimeout     // Catch:{ all -> 0x0b63 }
                    long r9 = (long) r9     // Catch:{ all -> 0x0b63 }
                    r8.sleep(r9)     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0b63 }
                    boolean r8 = r8.mo27289is(r4)     // Catch:{ all -> 0x0b63 }
                    if (r8 == 0) goto L_0x0b24
                    goto L_0x0b60
                L_0x0b24:
                    java.lang.String r8 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0b63 }
                    java.lang.String r9 = "Trying to reconnect"
                    android.util.Log.d(r8, r9)     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0b63 }
                    boolean r8 = r8.isAnyConnected(r9)     // Catch:{ all -> 0x0b63 }
                    if (r8 == 0) goto L_0x0b57
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0b63 }
                    java.lang.String r8 = "Reconnected, starting download again"
                    android.util.Log.d(r0, r8)     // Catch:{ all -> 0x0b63 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b50 }
                    r8 = 1
                    r0.setConnected(r8)     // Catch:{ all -> 0x0b50 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b50 }
                    r0.set(r8)     // Catch:{ all -> 0x0b50 }
                    r0 = r7
                    r14 = 0
                    r16 = 0
                    goto L_0x0b6a
                L_0x0b50:
                    r0 = move-exception
                    r14 = r13
                    r15 = r27
                    r13 = 0
                    goto L_0x0cfc
                L_0x0b57:
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0b63 }
                    r14 = 0
                    r8.setConnected(r14)     // Catch:{ all -> 0x0b63 }
                    int r0 = r0 + 1
                    goto L_0x0b0f
                L_0x0b60:
                    r14 = 0
                    r0 = r7
                    goto L_0x0b68
                L_0x0b63:
                    r0 = move-exception
                    r14 = r13
                    goto L_0x09d7
                L_0x0b67:
                    r14 = 0
                L_0x0b68:
                    r16 = 1
                L_0x0b6a:
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0bc6 }
                    monitor-enter(r7)     // Catch:{ all -> 0x0bc6 }
                    if (r16 == 0) goto L_0x0bb6
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0bb2 }
                    boolean r8 = r8.isConnected()     // Catch:{ all -> 0x0bb2 }
                    if (r8 != 0) goto L_0x0bb6
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0bb2 }
                    boolean r8 = r8.isPausable()     // Catch:{ all -> 0x0bb2 }
                    if (r8 == 0) goto L_0x0bb6
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0bb2 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0bb2 }
                    boolean r8 = r8.isAnyConnected(r9)     // Catch:{ all -> 0x0bb2 }
                    if (r8 == 0) goto L_0x0ba8
                    java.lang.String r8 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0bb2 }
                    java.lang.String r9 = "Reconnected, starting download again"
                    android.util.Log.d(r8, r9)     // Catch:{ all -> 0x0bb2 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0ba2 }
                    r9 = 1
                    r8.setConnected(r9)     // Catch:{ all -> 0x0ba2 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0ba2 }
                    r8.set(r9)     // Catch:{ all -> 0x0ba2 }
                    r15 = r27
                    r16 = 0
                    goto L_0x0bb8
                L_0x0ba2:
                    r0 = move-exception
                    r15 = r27
                    r16 = 0
                    goto L_0x0bbe
                L_0x0ba8:
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0bb2 }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x0bb2 }
                    boolean r8 = r8.pause(r9, r3, r13)     // Catch:{ all -> 0x0bb2 }
                    r15 = r8
                    goto L_0x0bb8
                L_0x0bb2:
                    r0 = move-exception
                    r15 = r27
                    goto L_0x0bbe
                L_0x0bb6:
                    r15 = r27
                L_0x0bb8:
                    monitor-exit(r7)     // Catch:{ all -> 0x0bbd }
                    r8 = r13
                    r13 = r16
                    goto L_0x0bee
                L_0x0bbd:
                    r0 = move-exception
                L_0x0bbe:
                    monitor-exit(r7)     // Catch:{ all -> 0x0bbd }
                    throw r0     // Catch:{ all -> 0x0bc0 }
                L_0x0bc0:
                    r0 = move-exception
                    r14 = r13
                    r13 = r16
                    goto L_0x0cfc
                L_0x0bc6:
                    r0 = move-exception
                    r14 = r13
                    r13 = r16
                    goto L_0x0cfa
                L_0x0bcc:
                    r14 = 0
                    boolean r8 = r9 instanceof com.vungle.warren.downloader.Downloader.RequestException     // Catch:{ all -> 0x0cf7 }
                    if (r8 == 0) goto L_0x0be0
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09d5 }
                    r13 = 1
                    r8.deleteFileAndMeta(r12, r6, r13)     // Catch:{ all -> 0x09d5 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r8 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x09d5 }
                    r8.<init>(r10, r9, r13)     // Catch:{ all -> 0x09d5 }
                    r15 = r27
                    r13 = 1
                    goto L_0x0bee
                L_0x0be0:
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0cf7 }
                    r13 = 1
                    r8.deleteFileAndMeta(r12, r6, r13)     // Catch:{ all -> 0x0cf5 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r8 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0cf5 }
                    r11 = 4
                    r8.<init>(r10, r9, r11)     // Catch:{ all -> 0x0cf5 }
                    r15 = r27
                L_0x0bee:
                    if (r2 == 0) goto L_0x0bfd
                    okhttp3.ResponseBody r7 = r2.body()
                    if (r7 == 0) goto L_0x0bfd
                    okhttp3.ResponseBody r2 = r2.body()
                    r2.close()
                L_0x0bfd:
                    if (r29 == 0) goto L_0x0c02
                    r29.cancel()
                L_0x0c02:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r9 = "request is done "
                    r7.append(r9)
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3
                    java.lang.String r9 = r9.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r10)
                    r7.append(r9)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.d(r2, r7)
                    if (r13 == 0) goto L_0x0c85
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r7 = 2
                    if (r2 == r7) goto L_0x0c56
                    if (r2 == r4) goto L_0x0c4f
                    r4 = 4
                    if (r2 == r4) goto L_0x0c47
                    r4 = 5
                    if (r2 == r4) goto L_0x0c3f
                    if (r15 != 0) goto L_0x0c56
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.removeMediator(r4)
                    goto L_0x0c56
                L_0x0c3f:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onErrorMediator(r8, r4)
                    goto L_0x0c56
                L_0x0c47:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onSuccessMediator(r12, r4)
                    goto L_0x0c56
                L_0x0c4f:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onCancelledMediator(r4)
                L_0x0c56:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r7 = "Done with request in state "
                    r4.append(r7)
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    int r7 = r7.getStatus()
                    r4.append(r7)
                    java.lang.String r7 = " "
                    r4.append(r7)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r9)
                    r4.append(r7)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r2, r4)
                    goto L_0x0ca5
                L_0x0c85:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r7 = "Not removing connections and listener "
                    r4.append(r7)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r9)
                    r4.append(r7)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r2, r4)
                L_0x0ca5:
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r9)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0cf2 }
                    r2.removeNetworkListener()     // Catch:{ all -> 0x0cf2 }
                    monitor-exit(r9)     // Catch:{ all -> 0x0cf2 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r13 == 0) goto L_0x0ce8
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0ce8
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0ce8
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0cdf
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0ce8
                L_0x0cdf:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0ce8:
                    r11 = r0
                    r7 = r8
                    r0 = r13
                L_0x0ceb:
                    r5 = r6
                    r14 = r7
                    r4 = r23
                L_0x0cef:
                    r2 = 0
                    goto L_0x0040
                L_0x0cf2:
                    r0 = move-exception
                    monitor-exit(r9)     // Catch:{ all -> 0x0cf2 }
                    throw r0
                L_0x0cf5:
                    r0 = move-exception
                    goto L_0x0cf9
                L_0x0cf7:
                    r0 = move-exception
                    r13 = 1
                L_0x0cf9:
                    r14 = r7
                L_0x0cfa:
                    r15 = r27
                L_0x0cfc:
                    if (r2 == 0) goto L_0x0d0b
                    okhttp3.ResponseBody r3 = r2.body()
                    if (r3 == 0) goto L_0x0d0b
                    okhttp3.ResponseBody r2 = r2.body()
                    r2.close()
                L_0x0d0b:
                    if (r29 == 0) goto L_0x0d10
                    r29.cancel()
                L_0x0d10:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r6 = "request is done "
                    r3.append(r6)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r3.append(r6)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                    if (r13 == 0) goto L_0x0d93
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r3 = 2
                    if (r2 == r3) goto L_0x0d64
                    if (r2 == r4) goto L_0x0d5d
                    r3 = 4
                    if (r2 == r3) goto L_0x0d55
                    r3 = 5
                    if (r2 == r3) goto L_0x0d4d
                    if (r15 != 0) goto L_0x0d64
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.removeMediator(r3)
                    goto L_0x0d64
                L_0x0d4d:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onErrorMediator(r14, r3)
                    goto L_0x0d64
                L_0x0d55:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onSuccessMediator(r12, r3)
                    goto L_0x0d64
                L_0x0d5d:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    r2.onCancelledMediator(r3)
                L_0x0d64:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Done with request in state "
                    r3.append(r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    int r4 = r4.getStatus()
                    r3.append(r4)
                    java.lang.String r4 = " "
                    r3.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                    goto L_0x0db3
                L_0x0d93:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Not removing connections and listener "
                    r3.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                L_0x0db3:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0df7 }
                    r3.removeNetworkListener()     // Catch:{ all -> 0x0df7 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0df7 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r17)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r13 == 0) goto L_0x0df6
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0df6
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0df6
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0ded
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0df6
                L_0x0ded:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0df6:
                    throw r0
                L_0x0df7:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0df7 }
                    throw r0
                L_0x0dfa:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.C29802.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean useCacheOnFail(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map, int i) {
        return this.cache != null && downloadRequestMediator.isCacheable && i != 200 && i != 416 && i != 206 && Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE")) && file.exists() && file.length() > 0;
    }

    /* access modifiers changed from: private */
    public synchronized void removeMediator(DownloadRequestMediator downloadRequestMediator) {
        this.mediators.remove(downloadRequestMediator.key);
    }

    private void addNetworkListener() {
        Log.d(TAG, "Adding network listner");
        this.networkProvider.addListener(this.networkListener);
    }

    /* access modifiers changed from: private */
    public boolean pause(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress, AssetDownloadListener.DownloadError downloadError) {
        boolean z = false;
        if (downloadRequestMediator.mo27289is(3) || isAnyConnected(downloadRequestMediator)) {
            return false;
        }
        progress.status = 2;
        AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
        boolean z2 = false;
        for (Pair next : downloadRequestMediator.values()) {
            DownloadRequest downloadRequest = (DownloadRequest) next.first;
            if (downloadRequest != null) {
                if (!downloadRequest.pauseOnConnectionLost) {
                    downloadRequestMediator.remove(downloadRequest);
                    deliverError(downloadRequest, (AssetDownloadListener) next.second, downloadError);
                } else {
                    downloadRequestMediator.set(2);
                    String str = TAG;
                    Log.d(str, "Pausing download " + debugString(downloadRequest));
                    deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
                    z2 = true;
                }
            }
        }
        if (!z2) {
            downloadRequestMediator.set(5);
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Attempted to pause - ");
        if (downloadRequestMediator.getStatus() == 2) {
            z = true;
        }
        sb.append(z);
        Log.d(str2, sb.toString());
        return z2;
    }

    /* access modifiers changed from: private */
    public void sleep(long j) {
        try {
            Thread.sleep(Math.max(0, j));
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> makeMeta(File file, Headers headers, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Download_URL", str);
        hashMap.put("ETag", headers.get("ETag"));
        hashMap.put("Last-Modified", headers.get("Last-Modified"));
        hashMap.put("Accept-Ranges", headers.get("Accept-Ranges"));
        hashMap.put("Content-Encoding", headers.get("Content-Encoding"));
        saveMeta(file, hashMap);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void checkEncoding(File file, File file2, Headers headers) throws IOException {
        String str = headers.get("Content-Encoding");
        if (str != null && !"gzip".equalsIgnoreCase(str) && !"identity".equalsIgnoreCase(str)) {
            deleteFileAndMeta(file, file2, false);
            VungleLogger.error("AssetDownloader#checkEncoding; loadAd sequence", String.format("unknown %1$s %2$s ", new Object[]{"Content-Encoding", str}));
            throw new IOException("Unknown Content-Encoding");
        }
    }

    /* access modifiers changed from: private */
    public boolean useCacheWithoutVerification(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map) {
        String str;
        if (map == null || this.cache == null || !downloadRequestMediator.isCacheable || (str = map.get("Last-Cache-Verification")) == null || !file.exists() || !Boolean.parseBoolean(map.get("DOWNLOAD_COMPLETE"))) {
            return false;
        }
        try {
            long parseLong = Long.parseLong(str);
            long j = this.timeWindow;
            if (j >= Long.MAX_VALUE - parseLong || parseLong + j >= System.currentTimeMillis()) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean partialMalformed(long j, int i, Response response, DownloadRequestMediator downloadRequestMediator) {
        return (i == 206 && !satisfiesPartialDownload(response, j, downloadRequestMediator)) || i == 416;
    }

    /* access modifiers changed from: private */
    public void appendHeaders(long j, File file, HashMap<String, String> hashMap, Request.Builder builder) {
        builder.addHeader("Accept-Encoding", "identity");
        if (file.exists() && !hashMap.isEmpty()) {
            String str = hashMap.get("ETag");
            String str2 = hashMap.get("Last-Modified");
            if (Boolean.parseBoolean(hashMap.get("DOWNLOAD_COMPLETE"))) {
                if (!TextUtils.isEmpty(str)) {
                    builder.addHeader("If-None-Match", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.addHeader("If-Modified-Since", str2);
                }
            } else if ("bytes".equalsIgnoreCase(hashMap.get("Accept-Ranges"))) {
                if (hashMap.get("Content-Encoding") == null || "identity".equalsIgnoreCase(hashMap.get("Content-Encoding"))) {
                    builder.addHeader("Range", "bytes=" + j + "-");
                    if (!TextUtils.isEmpty(str)) {
                        builder.addHeader("If-Range", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        builder.addHeader("If-Range", str2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public ResponseBody decodeGzipIfNeeded(Response response) {
        if (!"gzip".equalsIgnoreCase(response.header("Content-Encoding")) || !HttpHeaders.hasBody(response) || response.body() == null) {
            return response.body();
        }
        return new RealResponseBody(response.header("Content-Type"), -1, Okio.buffer((Source) new GzipSource(response.body().source())));
    }

    /* access modifiers changed from: private */
    public synchronized void onCancelledMediator(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest onCancelled : downloadRequestMediator.requests()) {
            onCancelled(onCancelled);
        }
    }

    private void onCancelled(DownloadRequest downloadRequest) {
        DownloadRequest downloadRequest2;
        if (!downloadRequest.isCancelled()) {
            downloadRequest.cancel();
            DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
            if (!(findMediatorForCancellation == null || findMediatorForCancellation.getStatus() == 3)) {
                Pair<DownloadRequest, AssetDownloadListener> remove = findMediatorForCancellation.remove(downloadRequest);
                AssetDownloadListener assetDownloadListener = null;
                if (remove == null) {
                    downloadRequest2 = null;
                } else {
                    downloadRequest2 = (DownloadRequest) remove.first;
                }
                if (remove != null) {
                    assetDownloadListener = (AssetDownloadListener) remove.second;
                }
                if (findMediatorForCancellation.values().isEmpty()) {
                    findMediatorForCancellation.set(3);
                }
                if (downloadRequest2 != null) {
                    AssetDownloadListener.Progress progress = new AssetDownloadListener.Progress();
                    progress.status = 3;
                    deliverProgress(progress, downloadRequest2, assetDownloadListener);
                } else {
                    return;
                }
            }
            removeNetworkListener();
        }
    }

    private synchronized DownloadRequestMediator findMediatorForCancellation(DownloadRequest downloadRequest) {
        ArrayList<DownloadRequestMediator> arrayList = new ArrayList<>(2);
        arrayList.add(this.mediators.get(getCacheableKey(downloadRequest)));
        arrayList.add(this.mediators.get(getNonCacheableKey(downloadRequest)));
        for (DownloadRequestMediator downloadRequestMediator : arrayList) {
            if (downloadRequestMediator != null) {
                for (DownloadRequest equals : downloadRequestMediator.requests()) {
                    if (equals.equals(downloadRequest)) {
                        return downloadRequestMediator;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void removeNetworkListener() {
        if (this.mediators.isEmpty()) {
            Log.d(TAG, "Removing listener");
            this.networkProvider.removeListener(this.networkListener);
        }
    }

    /* access modifiers changed from: private */
    public int mapExceptionToReason(Throwable th, boolean z) {
        if (th instanceof RuntimeException) {
            return 4;
        }
        if (!z || (th instanceof SocketException) || (th instanceof SocketTimeoutException)) {
            return 0;
        }
        return ((th instanceof UnknownHostException) || (th instanceof SSLException)) ? 1 : 2;
    }

    /* access modifiers changed from: private */
    public long getContentLength(Response response) {
        if (response == null) {
            return -1;
        }
        String str = response.headers().get("Content-Length");
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public boolean notModified(File file, Response response, DownloadRequestMediator downloadRequestMediator, HashMap<String, String> hashMap) {
        if (response != null && file.exists() && file.length() > 0 && downloadRequestMediator.isCacheable) {
            int code = response.code();
            if (Boolean.parseBoolean(hashMap.get("DOWNLOAD_COMPLETE")) && code == 304) {
                String str = TAG;
                Log.d(str, "304 code, data size matches file size " + debugString(downloadRequestMediator));
                return true;
            }
        }
        return false;
    }

    private boolean satisfiesPartialDownload(Response response, long j, DownloadRequestMediator downloadRequestMediator) {
        boolean z;
        RangeResponse rangeResponse = new RangeResponse(response.headers().get("Content-Range"));
        if (response.code() == 206 && "bytes".equalsIgnoreCase(rangeResponse.dimension)) {
            long j2 = rangeResponse.rangeStart;
            if (j2 >= 0 && j == j2) {
                z = true;
                String str = TAG;
                Log.d(str, "satisfies partial download: " + z + " " + debugString(downloadRequestMediator));
                return z;
            }
        }
        z = false;
        String str2 = TAG;
        Log.d(str2, "satisfies partial download: " + z + " " + debugString(downloadRequestMediator));
        return z;
    }

    /* access modifiers changed from: private */
    public String debugString(DownloadRequestMediator downloadRequestMediator) {
        return ", mediator url - " + downloadRequestMediator.url + ", path - " + downloadRequestMediator.filePath + ", th - " + Thread.currentThread().getName() + "id " + downloadRequestMediator;
    }

    private String debugString(DownloadRequest downloadRequest) {
        return ", single request url - " + downloadRequest.url + ", path - " + downloadRequest.path + ", th - " + Thread.currentThread().getName() + "id " + downloadRequest.f5622id;
    }

    /* access modifiers changed from: private */
    public boolean isAnyConnected(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest next : downloadRequestMediator.requests()) {
            if (next == null) {
                Log.d(TAG, "Request is null");
            } else if (isConnected(next)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    private boolean isConnected(DownloadRequest downloadRequest) {
        int i;
        int currentNetworkType = this.networkProvider.getCurrentNetworkType();
        boolean z = true;
        if (currentNetworkType >= 0 && downloadRequest.networkType == 3) {
            return true;
        }
        if (currentNetworkType != 0) {
            if (currentNetworkType != 1) {
                if (currentNetworkType != 4) {
                    if (currentNetworkType != 9) {
                        if (currentNetworkType != 17) {
                            if (currentNetworkType != 6) {
                                if (currentNetworkType != 7) {
                                    i = -1;
                                    if (i <= 0 || (downloadRequest.networkType & i) != i) {
                                        z = false;
                                    }
                                    String str = TAG;
                                    Log.d(str, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
            i = 2;
            z = false;
            String str2 = TAG;
            Log.d(str2, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
            return z;
        }
        i = 1;
        z = false;
        String str22 = TAG;
        Log.d(str22, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        sleep(10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancelAndAwait(com.vungle.warren.downloader.DownloadRequest r6, long r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.cancel(r6)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            long r7 = java.lang.Math.max(r3, r7)
            long r1 = r1 + r7
        L_0x0012:
            long r7 = java.lang.System.currentTimeMillis()
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            com.vungle.warren.downloader.DownloadRequestMediator r7 = r5.findMediatorForCancellation(r6)
            monitor-enter(r5)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r8 = r5.transitioning     // Catch:{ all -> 0x003d }
            boolean r8 = r8.contains(r6)     // Catch:{ all -> 0x003d }
            if (r8 != 0) goto L_0x0036
            if (r7 == 0) goto L_0x0033
            java.util.List r7 = r7.requests()     // Catch:{ all -> 0x003d }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x003d }
            if (r7 != 0) goto L_0x0036
        L_0x0033:
            r6 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            return r6
        L_0x0036:
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            r7 = 10
            r5.sleep(r7)
            goto L_0x0012
        L_0x003d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.cancelAndAwait(com.vungle.warren.downloader.DownloadRequest, long):boolean");
    }

    public synchronized void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest != null) {
            onCancelled(downloadRequest);
        }
    }

    public synchronized void cancelAll() {
        Log.d(TAG, "Cancelling all");
        for (DownloadRequest next : this.transitioning) {
            String str = TAG;
            Log.d(str, "Cancel in transtiotion " + next.url);
            cancel(next);
        }
        String str2 = TAG;
        Log.d(str2, "Cancel in mediator " + this.mediators.values().size());
        for (DownloadRequestMediator next2 : this.mediators.values()) {
            String str3 = TAG;
            Log.d(str3, "Cancel in mediator " + next2.key);
            onCancelledMediator(next2);
        }
    }

    public synchronized void init() {
        DownloaderCache downloaderCache = this.cache;
        if (downloaderCache != null) {
            downloaderCache.init();
        }
    }

    public synchronized void clearCache() {
        DownloaderCache downloaderCache = this.cache;
        if (downloaderCache != null) {
            downloaderCache.clear();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onNetworkChanged(int i) {
        String str = TAG;
        Log.d(str, "Num of connections: " + this.mediators.values().size());
        for (DownloadRequestMediator next : this.mediators.values()) {
            if (next.mo27289is(3)) {
                Log.d(TAG, "Result cancelled");
            } else {
                boolean isAnyConnected = isAnyConnected(next);
                String str2 = TAG;
                Log.d(str2, "Connected = " + isAnyConnected + " for " + i);
                next.setConnected(isAnyConnected);
                if (next.isPausable() && isAnyConnected && next.mo27289is(2)) {
                    load(next);
                    Log.d(str2, "resumed " + next.key + " " + next);
                }
            }
        }
    }

    public static abstract class DownloadPriorityRunnable implements Comparable, Runnable {
        private static final AtomicInteger seq = new AtomicInteger();
        private final DownloadRequestMediator mediator;
        private final int order = seq.incrementAndGet();
        private final int priority;

        DownloadPriorityRunnable(DownloadRequestMediator downloadRequestMediator) {
            this.mediator = downloadRequestMediator;
            this.priority = 0;
            downloadRequestMediator.setRunnable(this);
        }

        DownloadPriorityRunnable(int i) {
            this.priority = i;
            this.mediator = null;
        }

        /* access modifiers changed from: package-private */
        public Integer getPriority() {
            DownloadRequestMediator downloadRequestMediator = this.mediator;
            return Integer.valueOf(downloadRequestMediator != null ? downloadRequestMediator.getPriority() : this.priority);
        }

        public int compareTo(Object obj) {
            if (!(obj instanceof DownloadPriorityRunnable)) {
                return -1;
            }
            DownloadPriorityRunnable downloadPriorityRunnable = (DownloadPriorityRunnable) obj;
            int compareTo = getPriority().compareTo(downloadPriorityRunnable.getPriority());
            return compareTo == 0 ? Integer.valueOf(this.order).compareTo(Integer.valueOf(downloadPriorityRunnable.order)) : compareTo;
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> extractMeta(File file) {
        return FileUtility.readMap(file.getPath());
    }

    /* access modifiers changed from: private */
    public void saveMeta(File file, HashMap<String, String> hashMap) {
        FileUtility.writeMap(file.getPath(), hashMap);
    }

    private void copyToDestination(File file, File file2, Pair<DownloadRequest, AssetDownloadListener> pair) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        if (file2.exists()) {
            FileUtility.deleteAndLogIfFailed(file2);
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
                    Log.d(TAG, "Copying: finished " + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                } catch (IOException e2) {
                    e = e2;
                    try {
                        VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                        deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                        Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                        FileUtility.closeQuietly(fileInputStream);
                        FileUtility.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                fileOutputStream = null;
                e = iOException;
                VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                FileUtility.closeQuietly(fileInputStream);
                FileUtility.closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                FileUtility.closeQuietly(fileInputStream2);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            fileOutputStream = null;
            e = e4;
            fileInputStream = null;
            VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
            deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
            Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
            FileUtility.closeQuietly(fileInputStream);
            FileUtility.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtility.closeQuietly(fileInputStream2);
            FileUtility.closeQuietly(fileOutputStream);
            throw th;
        }
        FileUtility.closeQuietly(fileInputStream);
        FileUtility.closeQuietly(fileOutputStream);
    }

    private void deliverSuccess(Pair<DownloadRequest, AssetDownloadListener> pair, File file) {
        S s = pair.second;
        if (s != null) {
            ((AssetDownloadListener) s).onSuccess(file, (DownloadRequest) pair.first);
        }
    }

    /* access modifiers changed from: private */
    public void onSuccessMediator(File file, DownloadRequestMediator downloadRequestMediator) {
        String str = TAG;
        Log.d(str, "OnComplete - Removing connections and listener " + downloadRequestMediator);
        try {
            downloadRequestMediator.lock();
            List<Pair<DownloadRequest, AssetDownloadListener>> values = downloadRequestMediator.values();
            if (!file.exists()) {
                VungleLogger.error("AssetDownloader#onSuccessMediator; loadAd sequence", String.format("File %1$s does not exist; mediator %2$s ", new Object[]{file.getPath(), debugString(downloadRequestMediator)}));
                onErrorMediator(new AssetDownloadListener.DownloadError(-1, new IOException("File is deleted"), 2), downloadRequestMediator);
                return;
            }
            DownloaderCache downloaderCache = this.cache;
            if (downloaderCache != null && downloadRequestMediator.isCacheable) {
                downloaderCache.onCacheHit(file, (long) values.size());
                this.cache.setCacheLastUpdateTimestamp(file, System.currentTimeMillis());
            }
            for (Pair next : values) {
                File file2 = new File(((DownloadRequest) next.first).path);
                if (!file2.equals(file)) {
                    copyToDestination(file, file2, next);
                } else {
                    file2 = file;
                }
                String str2 = TAG;
                Log.d(str2, "Deliver success:" + ((DownloadRequest) next.first).url + " dest file: " + file2.getPath());
                deliverSuccess(next, file2);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
            String str3 = TAG;
            Log.d(str3, "Finished " + debugString(downloadRequestMediator));
            downloadRequestMediator.unlock();
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    private String mediatorKeyFromRequest(DownloadRequest downloadRequest) {
        if (isCacheEnabled()) {
            return getCacheableKey(downloadRequest);
        }
        return getNonCacheableKey(downloadRequest);
    }

    private String getNonCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url + " " + downloadRequest.path;
    }

    private String getCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url;
    }

    /* access modifiers changed from: private */
    public void onErrorMediator(AssetDownloadListener.DownloadError downloadError, DownloadRequestMediator downloadRequestMediator) {
        VungleLogger.error("AssetDownloader#onErrorMediator; loadAd sequence", String.format("Error %1$s occured; mediator %2$s", new Object[]{downloadError, debugString(downloadRequestMediator)}));
        if (downloadError == null) {
            downloadError = new AssetDownloadListener.DownloadError(-1, new RuntimeException(), 4);
        }
        try {
            downloadRequestMediator.lock();
            for (Pair next : downloadRequestMediator.values()) {
                deliverError((DownloadRequest) next.first, (AssetDownloadListener) next.second, downloadError);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener, final AssetDownloadListener.DownloadError downloadError) {
        Object[] objArr = new Object[2];
        objArr[0] = downloadError;
        objArr[1] = downloadRequest != null ? debugString(downloadRequest) : "null";
        VungleLogger.error("AssetDownloader#deliverError; loadAd sequence", String.format("Delivering error %1$s; request %2$s", objArr));
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable(this) {
                public void run() {
                    assetDownloadListener.onError(downloadError, downloadRequest);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onProgressMediator(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress) {
        if (downloadRequestMediator != null) {
            AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
            String str = TAG;
            Log.d(str, "Progress " + progress.progressPercent + " status " + progress.status + " " + downloadRequestMediator + " " + downloadRequestMediator.filePath);
            for (Pair next : downloadRequestMediator.values()) {
                deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
            }
        }
    }

    private void deliverProgress(final AssetDownloadListener.Progress progress, final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener) {
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable(this) {
                public void run() {
                    String access$100 = AssetDownloader.TAG;
                    Log.d(access$100, "On progress " + downloadRequest);
                    assetDownloadListener.onProgress(progress, downloadRequest);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void deleteFileAndMeta(File file, File file2, boolean z) {
        if (file != null) {
            FileUtility.deleteAndLogIfFailed(file);
            if (file2 != null) {
                FileUtility.deleteAndLogIfFailed(file2);
            }
            if (this.cache != null && isCacheEnabled()) {
                if (z) {
                    this.cache.deleteAndRemove(file);
                } else {
                    this.cache.deleteContents(file);
                }
            }
        }
    }

    public boolean dropCache(String str) {
        DownloaderCache downloaderCache = this.cache;
        if (!(downloaderCache == null || str == null)) {
            try {
                File file = downloaderCache.getFile(str);
                String str2 = TAG;
                Log.d(str2, "Broken asset, deleting " + file.getPath());
                return this.cache.deleteAndRemove(file);
            } catch (IOException e) {
                VungleLogger.error("AssetDownloader#dropCache; loadAd sequence", String.format("Error %1$s occured", new Object[]{e}));
                Log.e(TAG, "There was an error to get file", e);
            }
        }
        return false;
    }

    public synchronized boolean isCacheEnabled() {
        return this.cache != null && this.isCacheEnabled;
    }

    public synchronized void setCacheEnabled(boolean z) {
        this.isCacheEnabled = z;
    }

    public void updatePriority(DownloadRequest downloadRequest) {
        Runnable runnable;
        DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
        if (findMediatorForCancellation != null && (runnable = findMediatorForCancellation.getRunnable()) != null && this.downloadExecutor.remove(runnable)) {
            String str = TAG;
            Log.d(str, "prio: updated to " + findMediatorForCancellation.getPriority());
            this.downloadExecutor.execute(runnable);
        }
    }
}
