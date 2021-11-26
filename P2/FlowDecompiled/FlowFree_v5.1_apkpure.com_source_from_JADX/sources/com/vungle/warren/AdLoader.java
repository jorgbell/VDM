package com.vungle.warren;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.OperationSequence;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.p054ui.HackMraid;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.DownloadJob;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AdLoader {
    /* access modifiers changed from: private */
    public static final String TAG = "com.vungle.warren.AdLoader";
    /* access modifiers changed from: private */
    public final CacheManager cacheManager;
    private final Downloader downloader;
    private AtomicReference<JobRunner> jobRunnerRef = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Map<String, Operation> loadOperations = new ConcurrentHashMap();
    private final OMInjector omInjector;
    private final Map<String, Operation> pendingOperations = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Repository repository;
    /* access modifiers changed from: private */
    public final RuntimeValues runtimeValues;
    /* access modifiers changed from: private */
    public final Executors sdkExecutors;
    /* access modifiers changed from: private */
    public final OperationSequence sequence;
    private String sequenceLoadingId = null;
    /* access modifiers changed from: private */
    public final List<Operation> startingOperations = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final VisionController visionController;
    /* access modifiers changed from: private */
    public final VungleStaticApi vungleApi;
    /* access modifiers changed from: private */
    public final VungleApiClient vungleApiClient;

    interface DownloadCallback {
        void onDownloadCompleted(String str, String str2);

        void onDownloadFailed(VungleException vungleException, String str, String str2);

        void onReady(String str, Placement placement, Advertisement advertisement);
    }

    private boolean recoverableServerCode(int i) {
        return i == 408 || (500 <= i && i < 600);
    }

    public static class Operation {
        long delay;

        /* renamed from: id */
        final String f5621id;
        final Set<LoadAdCallback> loadAdCallbacks;
        final AtomicBoolean loading;
        boolean logError;
        int policy;
        int priority;
        List<DownloadRequest> requests = new CopyOnWriteArrayList();
        int retry;
        long retryDelay;
        int retryLimit;
        final AdConfig.AdSize size;

        Operation(String str, AdConfig.AdSize adSize, long j, long j2, int i, int i2, int i3, boolean z, int i4, LoadAdCallback... loadAdCallbackArr) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.loadAdCallbacks = copyOnWriteArraySet;
            this.f5621id = str;
            this.delay = j;
            this.retryDelay = j2;
            this.retryLimit = i;
            this.policy = i2;
            this.retry = i3;
            this.loading = new AtomicBoolean();
            this.size = adSize;
            this.logError = z;
            this.priority = i4;
            if (loadAdCallbackArr != null) {
                copyOnWriteArraySet.addAll(Arrays.asList(loadAdCallbackArr));
            }
        }

        /* access modifiers changed from: package-private */
        public Operation delay(long j) {
            return new Operation(this.f5621id, this.size, j, this.retryDelay, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public Operation retryDelay(long j) {
            return new Operation(this.f5621id, this.size, this.delay, j, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public Operation retry(int i) {
            return new Operation(this.f5621id, this.size, this.delay, this.retryDelay, this.retryLimit, this.policy, i, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public void merge(Operation operation) {
            this.delay = Math.min(this.delay, operation.delay);
            this.retryDelay = Math.min(this.retryDelay, operation.retryDelay);
            this.retryLimit = Math.min(this.retryLimit, operation.retryLimit);
            int i = operation.policy;
            if (i != 0) {
                i = this.policy;
            }
            this.policy = i;
            this.retry = Math.min(this.retry, operation.retry);
            this.logError |= operation.logError;
            this.priority = Math.min(this.priority, operation.priority);
            this.loadAdCallbacks.addAll(operation.loadAdCallbacks);
        }

        public String toString() {
            return "id=" + this.f5621id + " size=" + this.size.toString() + " priority=" + this.priority + " policy=" + this.policy + " retry=" + this.retry + "/" + this.retryLimit + " delay=" + this.delay + "->" + this.retryDelay + " log=" + this.logError;
        }
    }

    public AdLoader(Executors executors, Repository repository2, VungleApiClient vungleApiClient2, CacheManager cacheManager2, Downloader downloader2, RuntimeValues runtimeValues2, VungleStaticApi vungleStaticApi, VisionController visionController2, OperationSequence operationSequence, OMInjector oMInjector) {
        this.sdkExecutors = executors;
        this.repository = repository2;
        this.vungleApiClient = vungleApiClient2;
        this.cacheManager = cacheManager2;
        this.downloader = downloader2;
        this.runtimeValues = runtimeValues2;
        this.vungleApi = vungleStaticApi;
        this.visionController = visionController2;
        this.sequence = operationSequence;
        this.omInjector = oMInjector;
    }

    public void init(JobRunner jobRunner) {
        this.jobRunnerRef.set(jobRunner);
        this.downloader.init();
    }

    /* access modifiers changed from: private */
    public boolean canReDownload(Advertisement advertisement) {
        List<AdAsset> list;
        if (advertisement == null || ((advertisement.getState() != 0 && advertisement.getState() != 1) || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0)) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 1) {
                if (!fileIsValid(new File(adAsset.localPath), adAsset)) {
                    return false;
                }
            } else if (TextUtils.isEmpty(adAsset.serverPath)) {
                return false;
            }
        }
        return true;
    }

    public boolean canPlayAd(Advertisement advertisement) {
        if (advertisement == null || advertisement.getState() != 1) {
            return false;
        }
        return hasAssetsFor(advertisement.getId());
    }

    public boolean canRenderAd(Advertisement advertisement) {
        if (advertisement == null) {
            return false;
        }
        if (advertisement.getState() == 1 || advertisement.getState() == 2) {
            return hasAssetsFor(advertisement.getId());
        }
        return false;
    }

    public void clear() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(this.loadOperations.keySet());
        hashSet.addAll(this.pendingOperations.keySet());
        for (String str : hashSet) {
            Operation remove = this.loadOperations.remove(str);
            this.startingOperations.remove(remove);
            onError(remove, 25);
            onError(this.pendingOperations.remove(str), 25);
        }
        for (Operation next : this.startingOperations) {
            this.startingOperations.remove(next);
            onError(next, 25);
        }
        this.sdkExecutors.getBackgroundExecutor().submit(new Runnable() {
            public void run() {
                for (OperationSequence.Entry entry : AdLoader.this.sequence.removeAll()) {
                    AdLoader.this.onError(entry.operation, 25);
                }
            }
        });
    }

    public boolean isLoading(String str) {
        Operation operation = this.loadOperations.get(str);
        return operation != null && operation.loading.get();
    }

    /* access modifiers changed from: private */
    public void setLoading(String str, boolean z) {
        Operation operation = this.loadOperations.get(str);
        if (operation != null) {
            operation.loading.set(z);
        }
    }

    public void loadPendingInternal(String str) {
        Operation remove = this.pendingOperations.remove(str);
        if (remove != null) {
            load(remove.delay(0));
        }
    }

    public void load(final Operation operation) {
        JobRunner jobRunner = this.jobRunnerRef.get();
        if (jobRunner == null) {
            VungleLogger.error("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", new Object[]{operation}));
            onError(operation, 9);
            return;
        }
        Operation remove = this.pendingOperations.remove(operation.f5621id);
        if (remove != null) {
            operation.merge(remove);
        }
        if (operation.delay <= 0) {
            this.startingOperations.add(operation);
            this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                public void run() {
                    if (AdLoader.this.startingOperations.contains(operation)) {
                        Operation operation = operation;
                        Operation operation2 = (Operation) AdLoader.this.loadOperations.get(operation.f5621id);
                        if (operation2 != null) {
                            int i = operation2.priority;
                            operation2.merge(operation);
                            if (operation2.priority < i) {
                                AdLoader.this.onChangePriority(operation2);
                            }
                        } else {
                            OperationSequence.Entry remove = AdLoader.this.sequence.remove(operation.f5621id);
                            if (remove != null) {
                                remove.operation.merge(operation);
                                operation = remove.operation;
                            }
                            if (operation.priority <= 0) {
                                AdLoader.this.startLoading(operation);
                            } else {
                                OperationSequence access$000 = AdLoader.this.sequence;
                                if (remove == null) {
                                    remove = new OperationSequence.Entry(operation);
                                }
                                access$000.offer(remove);
                                AdLoader.this.tryLoadNextInQueue((String) null);
                            }
                        }
                        AdLoader.this.startingOperations.remove(operation);
                    }
                }
            });
            return;
        }
        this.pendingOperations.put(operation.f5621id, operation);
        JobInfo makeJobInfo = DownloadJob.makeJobInfo(operation.f5621id);
        makeJobInfo.setDelay(operation.delay);
        makeJobInfo.setUpdateCurrent(true);
        jobRunner.execute(makeJobInfo);
    }

    /* access modifiers changed from: private */
    public void startLoading(Operation operation) {
        this.loadOperations.put(operation.f5621id, operation);
        loadAd(operation, new DownloadCallbackWrapper(this.sdkExecutors.getBackgroundExecutor(), new DownloadAdCallback()));
    }

    /* access modifiers changed from: private */
    public void tryLoadNextInQueue(String str) {
        String str2 = this.sequenceLoadingId;
        if (str2 == null || str2.equals(str)) {
            this.sequenceLoadingId = null;
            OperationSequence.Entry poll = this.sequence.poll();
            if (poll != null) {
                Operation operation = poll.operation;
                this.sequenceLoadingId = operation.f5621id;
                startLoading(operation);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onChangePriority(Operation operation) {
        for (DownloadRequest next : operation.requests) {
            next.setPriority(getAssetPriority(operation.priority));
            this.downloader.updatePriority(next);
        }
    }

    /* access modifiers changed from: private */
    public void onError(Operation operation, int i) {
        Object[] objArr = new Object[2];
        objArr[0] = new VungleException(i);
        objArr[1] = operation != null ? operation : "null";
        VungleLogger.error("AdLoader#onError; loadAd sequence", String.format("Error %1$s occured; operation is %2$s", objArr));
        if (operation != null) {
            for (LoadAdCallback onError : operation.loadAdCallbacks) {
                onError.onError(operation.f5621id, new VungleException(i));
            }
        }
    }

    /* access modifiers changed from: private */
    public VungleException reposeCodeToVungleException(int i) {
        if (recoverableServerCode(i)) {
            return new VungleException(22);
        }
        return new VungleException(21);
    }

    /* access modifiers changed from: private */
    public VungleException retrofitToVungleException(Throwable th) {
        if (th instanceof UnknownHostException) {
            return new VungleException(11);
        }
        if (th instanceof IOException) {
            return new VungleException(20);
        }
        return new VungleException(11);
    }

    private void loadAd(Operation operation, DownloadCallbackWrapper downloadCallbackWrapper) {
        final long currentTimeMillis = System.currentTimeMillis();
        final DownloadCallbackWrapper downloadCallbackWrapper2 = downloadCallbackWrapper;
        final Operation operation2 = operation;
        this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!AdLoader.this.vungleApi.isInitialized()) {
                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence", "Vungle is not initialized");
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(9), operation2.f5621id, (String) null);
                    return;
                }
                Placement placement = AdLoader.this.repository.load(operation2.f5621id, Placement.class).get();
                if (placement == null) {
                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence", "placement not found for id" + operation2.f5621id);
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(13), operation2.f5621id, (String) null);
                } else if (!placement.isValid()) {
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(5), operation2.f5621id, (String) null);
                } else if (AdLoader.this.isSizeInvalid(placement, operation2.size)) {
                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence", "size is invalid, size = " + operation2.size);
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(28), operation2.f5621id, (String) null);
                } else {
                    Advertisement advertisement = AdLoader.this.repository.findValidAdvertisementForPlacement(placement.getId()).get();
                    if (!(placement.getPlacementAdType() != 1 || advertisement == null || advertisement.getAdConfig().getAdSize() == operation2.size)) {
                        try {
                            AdLoader.this.repository.deleteAdvertisement(advertisement.getId());
                        } catch (DatabaseHelper.DBException unused) {
                            VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence", "cannot delete advertisement, id = " + operation2.f5621id);
                            downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                            return;
                        }
                    }
                    if (advertisement != null && AdLoader.this.canPlayAd(advertisement)) {
                        AdLoader.this.tryLoadNextInQueue(operation2.f5621id);
                        downloadCallbackWrapper2.onReady(operation2.f5621id, placement, advertisement);
                    } else if (AdLoader.this.canReDownload(advertisement)) {
                        Log.d(AdLoader.TAG, "Found valid adv but not ready - downloading content");
                        VungleSettings vungleSettings = AdLoader.this.runtimeValues.settings.get();
                        if (vungleSettings == null || AdLoader.this.cacheManager.getBytesAvailable() < vungleSettings.getMinimumSpaceForAd()) {
                            if (advertisement.getState() != 4) {
                                try {
                                    AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f5621id, 4);
                                } catch (DatabaseHelper.DBException unused2) {
                                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply ERROR state, id = " + operation2.f5621id);
                                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                                    return;
                                }
                            }
                            VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence", "failed to download assets, no space; id = " + operation2.f5621id);
                            downloadCallbackWrapper2.onDownloadFailed(new VungleException(19), operation2.f5621id, (String) null);
                            return;
                        }
                        AdLoader.this.setLoading(operation2.f5621id, true);
                        if (advertisement.getState() != 0) {
                            try {
                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f5621id, 0);
                            } catch (DatabaseHelper.DBException unused3) {
                                VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply NEW state, id = " + operation2.f5621id);
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                                return;
                            }
                        }
                        advertisement.setAdRequestStartTime(currentTimeMillis);
                        advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                        AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallbackWrapper2);
                    } else if (placement.getWakeupTime() > System.currentTimeMillis()) {
                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(1), operation2.f5621id, (String) null);
                        VungleLogger.warn("AdLoader#loadAd#execute; loadAd sequence; snoozed branch", String.format("Placement with id %s is snoozed ", new Object[]{placement.getId()}));
                        String access$1200 = AdLoader.TAG;
                        Log.w(access$1200, "Placement " + placement.getId() + " is  snoozed");
                        if (placement.isAutoCached()) {
                            String access$12002 = AdLoader.TAG;
                            Log.d(access$12002, "Placement " + placement.getId() + " is sleeping rescheduling it ");
                            AdLoader.this.loadEndless(placement, operation2.size, placement.getWakeupTime() - System.currentTimeMillis());
                        }
                    } else {
                        String access$12003 = AdLoader.TAG;
                        Log.i(access$12003, "didn't find cached adv for " + operation2.f5621id + " downloading ");
                        if (advertisement != null) {
                            try {
                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f5621id, 4);
                            } catch (DatabaseHelper.DBException unused4) {
                                VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", "cannot save/apply ERROR state, id = " + operation2.f5621id);
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                                return;
                            }
                        }
                        VungleSettings vungleSettings2 = AdLoader.this.runtimeValues.settings.get();
                        if (vungleSettings2 == null || AdLoader.this.cacheManager.getBytesAvailable() >= vungleSettings2.getMinimumSpaceForAd()) {
                            String access$12004 = AdLoader.TAG;
                            Log.d(access$12004, "No adv for placement " + placement.getId() + " getting new data ");
                            AdLoader.this.setLoading(operation2.f5621id, true);
                            AdLoader.this.fetchAdMetadata(operation2, placement, downloadCallbackWrapper2);
                            return;
                        }
                        VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", String.format("no space to load, isAutoCached = %1$s, id = %2$s", new Object[]{Boolean.valueOf(placement.isAutoCached()), operation2.f5621id}));
                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(placement.isAutoCached() ? 18 : 17), operation2.f5621id, (String) null);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isSizeInvalid(Placement placement, AdConfig.AdSize adSize) {
        if (placement.getPlacementAdType() == 1 && !AdConfig.AdSize.isBannerAdSize(adSize)) {
            return true;
        }
        if (placement.getPlacementAdType() != 0 || !AdConfig.AdSize.isBannerAdSize(adSize)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void fetchAdMetadata(Operation operation, Placement placement, DownloadCallback downloadCallback) {
        final HeaderBiddingCallback headerBiddingCallback = this.runtimeValues.headerBiddingCallback.get();
        final long currentTimeMillis = System.currentTimeMillis();
        final Operation operation2 = operation;
        final DownloadCallback downloadCallback2 = downloadCallback;
        this.vungleApiClient.requestAd(operation.f5621id, AdConfig.AdSize.isBannerAdSize(operation.size) ? operation.size.getName() : "", placement.isHeaderBidding(), this.visionController.isEnabled() ? this.visionController.getPayload() : null).enqueue(new Callback<JsonObject>() {
            public void onFailure(Call<JsonObject> call, Throwable th) {
                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("failed to request ad, id = %1$s, throwable = %2$s", new Object[]{operation2.f5621id, th}));
                downloadCallback2.onDownloadFailed(AdLoader.this.retrofitToVungleException(th), operation2.f5621id, (String) null);
            }

            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        C29024 r0;
                        HeaderBiddingCallback headerBiddingCallback;
                        int state;
                        Placement placement = AdLoader.this.repository.load(operation2.f5621id, Placement.class).get();
                        if (placement == null) {
                            Log.e(AdLoader.TAG, "Placement metadata not found for requested advertisement.");
                            VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", "Placement metadata not found for requested advertisement. id = " + operation2.f5621id);
                            downloadCallback2.onDownloadFailed(new VungleException(2), operation2.f5621id, (String) null);
                        } else if (!response.isSuccessful()) {
                            long retryAfterHeaderValue = AdLoader.this.vungleApiClient.getRetryAfterHeaderValue(response);
                            if (retryAfterHeaderValue <= 0 || !placement.isAutoCached()) {
                                Log.e(AdLoader.TAG, "Failed to retrieve advertisement information");
                                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was not successful, not retrying;id = %1$s; responseCode = %2$s", new Object[]{operation2.f5621id, Integer.valueOf(response.code())}));
                                C29024 r02 = C29024.this;
                                downloadCallback2.onDownloadFailed(AdLoader.this.reposeCodeToVungleException(response.code()), operation2.f5621id, (String) null);
                                return;
                            }
                            C29024 r03 = C29024.this;
                            AdLoader.this.loadEndless(placement, operation2.size, retryAfterHeaderValue);
                            VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", "Response was not successful, retrying; id = " + operation2.f5621id);
                            downloadCallback2.onDownloadFailed(new VungleException(14), operation2.f5621id, (String) null);
                        } else {
                            JsonObject jsonObject = (JsonObject) response.body();
                            String access$1200 = AdLoader.TAG;
                            Log.d(access$1200, "Ads Response: " + jsonObject);
                            if (jsonObject == null || !jsonObject.has("ads") || jsonObject.get("ads").isJsonNull()) {
                                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response has no ads; placement = %1$s;op.id = %2$s; response = %3$s", new Object[]{placement, operation2.f5621id, jsonObject}));
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f5621id, (String) null);
                                return;
                            }
                            JsonArray asJsonArray = jsonObject.getAsJsonArray("ads");
                            if (asJsonArray == null || asJsonArray.size() == 0) {
                                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", "Response was successful, but no ads; id = " + operation2.f5621id);
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f5621id, (String) null);
                                return;
                            }
                            JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
                            try {
                                Advertisement advertisement = new Advertisement(asJsonObject);
                                if (AdLoader.this.visionController.isEnabled()) {
                                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("ad_markup");
                                    if (JsonUtil.hasNonNull(asJsonObject2, "data_science_cache")) {
                                        AdLoader.this.visionController.setDataScienceCache(asJsonObject2.get("data_science_cache").getAsString());
                                    } else {
                                        AdLoader.this.visionController.setDataScienceCache((String) null);
                                    }
                                }
                                Advertisement advertisement2 = AdLoader.this.repository.load(advertisement.getId(), Advertisement.class).get();
                                if (advertisement2 == null || !((state = advertisement2.getState()) == 0 || state == 1 || state == 2)) {
                                    if (placement.isHeaderBidding() && (headerBiddingCallback = headerBiddingCallback) != null) {
                                        headerBiddingCallback.onBidTokenAvailable(operation2.f5621id, advertisement.getBidToken());
                                    }
                                    AdLoader.this.repository.deleteAdvertisement(advertisement.getId());
                                    Set<Map.Entry<String, String>> entrySet = advertisement.getDownloadableUrls().entrySet();
                                    File destinationDir = AdLoader.this.getDestinationDir(advertisement);
                                    if (destinationDir != null) {
                                        if (destinationDir.isDirectory()) {
                                            for (Map.Entry next : entrySet) {
                                                if (!URLUtil.isHttpsUrl((String) next.getValue())) {
                                                    if (!URLUtil.isHttpUrl((String) next.getValue())) {
                                                        VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but one of downloadable urls is neither http nor https : url = %1$s; op.id = %2$s, ad.getId() = %3$s", new Object[]{next.getValue(), operation2.f5621id, advertisement.getId()}));
                                                        downloadCallback2.onDownloadFailed(new VungleException(11), operation2.f5621id, advertisement.getId());
                                                        return;
                                                    }
                                                }
                                                AdLoader.this.saveAsset(advertisement, destinationDir, (String) next.getKey(), (String) next.getValue());
                                            }
                                            if (placement.getPlacementAdType() != 1 || (advertisement.getAdType() == 1 && "banner".equals(advertisement.getTemplateType()))) {
                                                advertisement.getAdConfig().setAdSize(operation2.size);
                                                advertisement.setAdRequestStartTime(currentTimeMillis);
                                                advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.f5621id, 0);
                                                C29024 r04 = C29024.this;
                                                AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallback2);
                                                return;
                                            }
                                            Object[] objArr = new Object[3];
                                            objArr[0] = advertisement.getAdType() != 1 ? "ad type is not MRAID" : "advertisement template type is not banner";
                                            objArr[1] = operation2.f5621id;
                                            objArr[2] = advertisement.getId();
                                            VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but placement is banner while %1$s; op.id = %2$s, ad.getId() = %3$s", objArr));
                                            downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f5621id, advertisement.getId());
                                            return;
                                        }
                                    }
                                    Object[] objArr2 = new Object[3];
                                    objArr2[0] = destinationDir == null ? "null" : "not a dir";
                                    objArr2[1] = operation2.f5621id;
                                    objArr2[2] = advertisement.getId();
                                    VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but adv directory is %1$s; op.id = %2$s, ad.getId() = %3$s", objArr2));
                                    downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f5621id, advertisement.getId());
                                    return;
                                }
                                Log.d(AdLoader.TAG, "Operation Cancelled");
                                downloadCallback2.onDownloadFailed(new VungleException(25), operation2.f5621id, (String) null);
                            } catch (IllegalArgumentException unused) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("ad_markup");
                                if (asJsonObject3.has("sleep")) {
                                    long asInt = (long) asJsonObject3.get("sleep").getAsInt();
                                    placement.snooze(asInt);
                                    try {
                                        VungleLogger.warn("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd - snoozed placement %1$s; op.id = %2$s", new Object[]{placement, operation2.f5621id}));
                                        AdLoader.this.repository.save(placement);
                                        if (placement.isAutoCached()) {
                                            C29024 r05 = C29024.this;
                                            AdLoader.this.loadEndless(placement, operation2.size, asInt * 1000);
                                        }
                                    } catch (DatabaseHelper.DBException unused2) {
                                        VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd - can't save snoozed placement %1$s; op.id = %2$s", new Object[]{placement, operation2.f5621id}));
                                        downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                                        return;
                                    }
                                }
                                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd; can't proceed %1$s; op.id = %2$s", new Object[]{placement, operation2.f5621id}));
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.f5621id, (String) null);
                            } catch (DatabaseHelper.DBException e) {
                                VungleLogger.error("AdLoader#fetchAdMetadata; loadAd sequence", String.format("BadAd - DBException; can't proceed; placement = %1$s; op.id = %2$s; exception = %3$s", new Object[]{placement, operation2.f5621id, e}));
                                downloadCallback2.onDownloadFailed(new VungleException(26), operation2.f5621id, (String) null);
                            }
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public File getDestinationDir(Advertisement advertisement) {
        return this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
    }

    /* access modifiers changed from: package-private */
    public void saveAsset(Advertisement advertisement, File file, String str, String str2) throws DatabaseHelper.DBException {
        String str3 = file.getPath() + File.separator + str;
        int i = (str3.endsWith("postroll") || str3.endsWith("template")) ? 0 : 2;
        AdAsset adAsset = new AdAsset(advertisement.getId(), str2, str3);
        adAsset.status = 0;
        adAsset.fileType = i;
        try {
            this.repository.save(adAsset);
        } catch (DatabaseHelper.DBException e) {
            VungleLogger.error("AdLoader#saveAsset; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadAdAssets(com.vungle.warren.AdLoader.Operation r12, com.vungle.warren.model.Advertisement r13, com.vungle.warren.AdLoader.DownloadCallback r14) {
        /*
            r11 = this;
            java.lang.String r0 = r12.f5621id
            r11.tryLoadNextInQueue(r0)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r12.requests
            r0.clear()
            java.util.Map r0 = r13.getDownloadableUrls()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = "AdLoader#downnloadAdAssets; loadAd sequence"
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0084
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004b
            java.lang.Object r6 = r1.getValue()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004b
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x0016
        L_0x004b:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = r12.f5621id
            r0[r3] = r1
            r0[r5] = r13
            java.lang.String r1 = "One or more ad asset URLs is empty or not valid;op.id = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r1 = 11
            r0.<init>(r1)
            java.lang.String r12 = r12.f5621id
            r1 = 0
            r14.onDownloadFailed(r0, r12, r1)
            java.lang.String r12 = TAG
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Aborting, Failed to download Ad assets for: "
            r14.append(r0)
            java.lang.String r13 = r13.getId()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            android.util.Log.e(r12, r13)
            return
        L_0x0084:
            com.vungle.warren.DownloadCallbackWrapper r0 = new com.vungle.warren.DownloadCallbackWrapper
            com.vungle.warren.utility.Executors r1 = r11.sdkExecutors
            java.util.concurrent.ExecutorService r1 = r1.getUIExecutor()
            r0.<init>(r1, r14)
            r1 = 26
            com.vungle.warren.persistence.Repository r6 = r11.repository     // Catch:{ DBException -> 0x01cc }
            r6.save(r13)     // Catch:{ DBException -> 0x01cc }
            com.vungle.warren.persistence.Repository r14 = r11.repository
            java.lang.String r6 = r13.getId()
            com.vungle.warren.persistence.FutureResult r14 = r14.loadAllAdAssets(r6)
            java.lang.Object r14 = r14.get()
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x00c8
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r4 = r12.f5621id
            r14[r3] = r4
            r14[r5] = r13
            java.lang.String r3 = "Cannot load all ad assets; op.id = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r3, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r1)
            java.lang.String r12 = r12.f5621id
            java.lang.String r13 = r13.getId()
            r0.onDownloadFailed(r14, r12, r13)
            return
        L_0x00c8:
            java.util.Iterator r14 = r14.iterator()
        L_0x00cc:
            boolean r6 = r14.hasNext()
            if (r6 == 0) goto L_0x019f
            java.lang.Object r6 = r14.next()
            com.vungle.warren.model.AdAsset r6 = (com.vungle.warren.model.AdAsset) r6
            int r7 = r6.status
            r8 = 3
            r9 = 24
            if (r7 != r8) goto L_0x0111
            java.io.File r7 = new java.io.File
            java.lang.String r8 = r6.localPath
            r7.<init>(r8)
            boolean r7 = r11.fileIsValid(r7, r6)
            if (r7 == 0) goto L_0x00ed
            goto L_0x00cc
        L_0x00ed:
            int r7 = r6.fileType
            if (r7 != r5) goto L_0x0111
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r1 = r12.f5621id
            r14[r3] = r1
            r14[r5] = r13
            java.lang.String r1 = "Cannot download ad assets - asset filetype is zip_asset;op.id = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r1, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r9)
            java.lang.String r12 = r12.f5621id
            java.lang.String r13 = r13.getId()
            r0.onDownloadFailed(r14, r12, r13)
            return
        L_0x0111:
            int r7 = r6.status
            r8 = 4
            if (r7 != r8) goto L_0x011b
            int r7 = r6.fileType
            if (r7 != 0) goto L_0x011b
            goto L_0x00cc
        L_0x011b:
            java.lang.String r7 = r6.serverPath
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0143
            java.lang.Object[] r14 = new java.lang.Object[r4]
            java.lang.String r1 = r12.f5621id
            r14[r3] = r1
            r14[r5] = r13
            java.lang.String r1 = "Cannot download ad assets - empty ;op.id = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r1, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r9)
            java.lang.String r12 = r12.f5621id
            java.lang.String r13 = r13.getId()
            r0.onDownloadFailed(r14, r12, r13)
            return
        L_0x0143:
            int r7 = r12.priority
            com.vungle.warren.downloader.DownloadRequest r7 = r11.getDownloadRequest(r6, r7)
            int r8 = r6.status
            if (r8 != r5) goto L_0x015a
            com.vungle.warren.downloader.Downloader r8 = r11.downloader
            r9 = 1000(0x3e8, double:4.94E-321)
            r8.cancelAndAwait(r7, r9)
            int r7 = r12.priority
            com.vungle.warren.downloader.DownloadRequest r7 = r11.getDownloadRequest(r6, r7)
        L_0x015a:
            java.lang.String r8 = TAG
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Starting download for "
            r9.append(r10)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r8, r9)
            r6.status = r5
            com.vungle.warren.persistence.Repository r8 = r11.repository     // Catch:{ DBException -> 0x017e }
            r8.save(r6)     // Catch:{ DBException -> 0x017e }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r6 = r12.requests
            r6.add(r7)
            goto L_0x00cc
        L_0x017e:
            r14 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            r2[r5] = r14
            java.lang.String r14 = "Can't save asset %1$s; exception = %2$s"
            java.lang.String r14 = java.lang.String.format(r14, r2)
            java.lang.String r2 = "AdLoader#downloadAdAssets; loadAd sequence"
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r1)
            java.lang.String r12 = r12.f5621id
            java.lang.String r13 = r13.getId()
            r0.onDownloadFailed(r14, r12, r13)
            return
        L_0x019f:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r14 = r12.requests
            int r14 = r14.size()
            if (r14 != 0) goto L_0x01af
            java.lang.String r12 = r12.f5621id
            java.util.List r14 = java.util.Collections.EMPTY_LIST
            r11.onAssetDownloadFinished(r12, r0, r13, r14)
            return
        L_0x01af:
            com.vungle.warren.downloader.AssetDownloadListener r13 = r11.getAssetDownloadListener(r13, r12, r0)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r12 = r12.requests
            java.util.Iterator r12 = r12.iterator()
        L_0x01b9:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x01cb
            java.lang.Object r14 = r12.next()
            com.vungle.warren.downloader.DownloadRequest r14 = (com.vungle.warren.downloader.DownloadRequest) r14
            com.vungle.warren.downloader.Downloader r0 = r11.downloader
            r0.download(r14, r13)
            goto L_0x01b9
        L_0x01cb:
            return
        L_0x01cc:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r4 = r12.f5621id
            r0[r3] = r4
            r0[r5] = r13
            java.lang.String r3 = "Cannot save advertisement op.id = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r0.<init>(r1)
            java.lang.String r12 = r12.f5621id
            java.lang.String r13 = r13.getId()
            r14.onDownloadFailed(r0, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.downloadAdAssets(com.vungle.warren.AdLoader$Operation, com.vungle.warren.model.Advertisement, com.vungle.warren.AdLoader$DownloadCallback):void");
    }

    private DownloadRequest getDownloadRequest(AdAsset adAsset, int i) {
        return new DownloadRequest(3, getAssetPriority(i), adAsset.serverPath, adAsset.localPath, false, adAsset.identifier);
    }

    private int getAssetPriority(int i) {
        return Math.max(-2147483646, i);
    }

    private AssetDownloadListener getAssetDownloadListener(Advertisement advertisement, Operation operation, DownloadCallback downloadCallback) {
        return new AssetDownloadListener(operation, downloadCallback, advertisement) {
            AtomicLong downloadCount;
            List<AssetDownloadListener.DownloadError> errors = Collections.synchronizedList(new ArrayList());
            final /* synthetic */ Advertisement val$advertisement;
            final /* synthetic */ DownloadCallback val$callback;
            final /* synthetic */ Operation val$op;

            public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
            }

            {
                this.val$op = r2;
                this.val$callback = r3;
                this.val$advertisement = r4;
                this.downloadCount = new AtomicLong((long) r2.requests.size());
            }

            public void onError(final AssetDownloadListener.DownloadError downloadError, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        Log.e(AdLoader.TAG, "Download Failed");
                        DownloadRequest downloadRequest = downloadRequest;
                        if (downloadRequest != null) {
                            String str = downloadRequest.cookieString;
                            if (TextUtils.isEmpty(str)) {
                                adAsset = null;
                            } else {
                                adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                            }
                            if (adAsset != null) {
                                C29045.this.errors.add(downloadError);
                                adAsset.status = 2;
                                try {
                                    AdLoader.this.repository.save(adAsset);
                                } catch (DatabaseHelper.DBException unused) {
                                    C29045.this.errors.add(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4));
                                }
                            } else {
                                C29045.this.errors.add(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1));
                            }
                        } else {
                            C29045.this.errors.add(new AssetDownloadListener.DownloadError(-1, new RuntimeException("error in request"), 4));
                        }
                        if (C29045.this.downloadCount.decrementAndGet() <= 0) {
                            C29045 r0 = C29045.this;
                            AdLoader.this.onAssetDownloadFinished(r0.val$op.f5621id, r0.val$callback, r0.val$advertisement, r0.errors);
                        }
                    }
                });
            }

            public void onSuccess(final File file, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        if (!file.exists()) {
                            VungleLogger.error("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("Downloaded file %1$s doesn't exist", new Object[]{file.getPath()}));
                            C29045.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 3), downloadRequest);
                            return;
                        }
                        String str = downloadRequest.cookieString;
                        if (str == null) {
                            adAsset = null;
                        } else {
                            adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                        }
                        if (adAsset == null) {
                            Object[] objArr = new Object[2];
                            objArr[0] = str == null ? "id is null" : "repository returned null";
                            objArr[1] = downloadRequest;
                            VungleLogger.error("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("adAsset is null because %1$s, downloadRequest = %2$s", objArr));
                            C29045.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1), downloadRequest);
                            return;
                        }
                        adAsset.fileType = AdLoader.this.isZip(file) ? 0 : 2;
                        adAsset.fileSize = file.length();
                        adAsset.status = 3;
                        try {
                            AdLoader.this.repository.save(adAsset);
                            if (C29045.this.downloadCount.decrementAndGet() <= 0) {
                                C29045 r0 = C29045.this;
                                AdLoader.this.onAssetDownloadFinished(r0.val$op.f5621id, r0.val$callback, r0.val$advertisement, r0.errors);
                            }
                        } catch (DatabaseHelper.DBException e) {
                            VungleLogger.error("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
                            C29045.this.onError(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4), downloadRequest);
                        }
                    }
                });
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean isZip(File file) {
        return file.getName().equals("postroll") || file.getName().equals("template");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x025f A[EDGE_INSN: B:98:0x025f->B:86:0x025f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAssetDownloadFinished(java.lang.String r17, com.vungle.warren.AdLoader.DownloadCallback r18, com.vungle.warren.model.Advertisement r19, java.util.List<com.vungle.warren.downloader.AssetDownloadListener.DownloadError> r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            boolean r0 = r20.isEmpty()
            r8 = 1
            if (r0 == 0) goto L_0x020e
            com.vungle.warren.persistence.Repository r0 = r1.repository
            java.lang.String r9 = r19.getId()
            com.vungle.warren.persistence.FutureResult r0 = r0.loadAllAdAssets(r9)
            java.lang.Object r0 = r0.get()
            java.util.List r0 = (java.util.List) r0
            java.lang.String r9 = "null"
            r10 = 0
            java.lang.String r11 = "AdLoader#onAssetDownloadFinished; loadAd sequence"
            r12 = 2
            r13 = 3
            if (r0 == 0) goto L_0x01e8
            int r14 = r0.size()
            if (r14 != 0) goto L_0x0030
            goto L_0x01e8
        L_0x0030:
            java.util.Iterator r14 = r0.iterator()
        L_0x0034:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0107
            java.lang.Object r15 = r14.next()
            com.vungle.warren.model.AdAsset r15 = (com.vungle.warren.model.AdAsset) r15
            int r5 = r15.status
            r6 = 4
            if (r5 != r13) goto L_0x00dd
            java.io.File r5 = new java.io.File
            java.lang.String r7 = r15.localPath
            r5.<init>(r7)
            boolean r7 = r1.fileIsValid(r5, r15)
            if (r7 != 0) goto L_0x007c
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r5 = r5.getPath()
            r0[r10] = r5
            java.lang.String r5 = r15.toString()
            r0[r8] = r5
            r0[r12] = r2
            r0[r13] = r4
            java.lang.String r5 = "Assets file not valid %1$s; asset = %2$s,placementId = %3$s; advertisement = %4$s"
            java.lang.String r0 = java.lang.String.format(r5, r0)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 24
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x007c:
            int r7 = r15.fileType
            if (r7 != 0) goto L_0x0034
            r1.unzipFile(r4, r15, r5, r0)     // Catch:{ IOException -> 0x00ac, DBException -> 0x0084 }
            goto L_0x0034
        L_0x0084:
            r0 = move-exception
            r5 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r10] = r5
            java.lang.String r5 = r15.toString()
            r0[r8] = r5
            r0[r12] = r2
            r0[r13] = r4
            java.lang.String r5 = "Issue(s) with database: exception = %1$s; asset = %2$s,placementId = %3$s; advertisement = %4$s"
            java.lang.String r0 = java.lang.String.format(r5, r0)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 26
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x00ac:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r5 = r5.getPath()
            r0[r10] = r5
            java.lang.String r5 = r15.toString()
            r0[r8] = r5
            r0[r12] = r2
            r0[r13] = r4
            java.lang.String r5 = "Unzip failed %1$s; asset = %2$s,placementId = %3$s; advertisement = %4$s"
            java.lang.String r0 = java.lang.String.format(r5, r0)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.downloader.Downloader r0 = r1.downloader
            java.lang.String r5 = r15.serverPath
            r0.dropCache(r5)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 24
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x00dd:
            int r7 = r15.fileType
            if (r7 != 0) goto L_0x0034
            if (r5 == r6) goto L_0x0034
            java.lang.Object[] r0 = new java.lang.Object[r13]
            java.lang.String r5 = r15.toString()
            r0[r10] = r5
            r0[r8] = r2
            r0[r12] = r4
            java.lang.String r5 = "Zip asset left unprocessed asset = %1$s,placementId = %2$s; advertisement = %3$s"
            java.lang.String r0 = java.lang.String.format(r5, r0)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 24
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x0107:
            int r0 = r19.getAdType()
            if (r0 != r8) goto L_0x01df
            java.io.File r0 = r1.getDestinationDir(r4)
            if (r0 == 0) goto L_0x01b9
            boolean r5 = r0.isDirectory()
            if (r5 != 0) goto L_0x011b
            goto L_0x01b9
        L_0x011b:
            boolean r5 = r19.getOmEnabled()
            if (r5 == 0) goto L_0x0174
            com.vungle.warren.omsdk.OMInjector r5 = r1.omInjector     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            java.util.List r5 = r5.injectJsFiles(r0)     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
        L_0x012b:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            if (r6 == 0) goto L_0x0174
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            java.io.File r6 = (java.io.File) r6     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            com.vungle.warren.model.AdAsset r7 = new com.vungle.warren.model.AdAsset     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            java.lang.String r9 = r19.getId()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            java.lang.String r14 = r6.getPath()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r15 = 0
            r7.<init>(r9, r15, r14)     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            long r8 = r6.length()     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r7.fileSize = r8     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r7.fileType = r12     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r7.status = r13     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            com.vungle.warren.persistence.Repository r6 = r1.repository     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r6.save(r7)     // Catch:{ IOException -> 0x0165, DBException -> 0x0156 }
            r8 = 1
            goto L_0x012b
        L_0x0156:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 26
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x0165:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 24
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x0174:
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "saving MRAID for "
            r6.append(r7)
            java.lang.String r7 = r19.getId()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
            r4.setMraidAssetDir(r0)
            com.vungle.warren.persistence.Repository r0 = r1.repository     // Catch:{ DBException -> 0x0197 }
            r0.save(r4)     // Catch:{ DBException -> 0x0197 }
            goto L_0x01df
        L_0x0197:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r13]
            r5[r10] = r0
            r6 = 1
            r5[r6] = r2
            r5[r12] = r4
            java.lang.String r0 = "Issue(s) with database: can't save advertisement;exception = %1$s; placementId = %2$s; advertisement = %3$s"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 26
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x01b9:
            java.lang.Object[] r5 = new java.lang.Object[r13]
            if (r0 != 0) goto L_0x01be
            goto L_0x01c0
        L_0x01be:
            java.lang.String r9 = "not a dir"
        L_0x01c0:
            r5[r10] = r9
            r6 = 1
            r5[r6] = r2
            r5[r12] = r4
            java.lang.String r0 = "Mraid ad; bad destinationDir - %1$splacementId = %2$s; advertisement = %3$s"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 26
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x01df:
            java.lang.String r0 = r19.getId()
            r3.onDownloadCompleted(r2, r0)
            goto L_0x0266
        L_0x01e8:
            java.lang.Object[] r5 = new java.lang.Object[r13]
            if (r0 != 0) goto L_0x01ed
            goto L_0x01ef
        L_0x01ed:
            java.lang.String r9 = "empty"
        L_0x01ef:
            r5[r10] = r9
            r6 = 1
            r5[r6] = r2
            r5[r12] = r4
            java.lang.String r0 = "Assets are %1$s; placementId = %2$s; advertisement = %3$s"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            com.vungle.warren.VungleLogger.error(r11, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r5 = 24
            r0.<init>(r5)
            java.lang.String r4 = r19.getId()
            r3.onDownloadFailed(r0, r2, r4)
            return
        L_0x020e:
            r15 = 0
            java.util.Iterator r0 = r20.iterator()
            r5 = r15
        L_0x0214:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x025f
            java.lang.Object r5 = r0.next()
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r5 = (com.vungle.warren.downloader.AssetDownloadListener.DownloadError) r5
            java.lang.Throwable r6 = r5.cause
            int r6 = com.vungle.warren.error.VungleException.getExceptionCode(r6)
            r7 = 26
            if (r6 != r7) goto L_0x0230
            com.vungle.warren.error.VungleException r5 = new com.vungle.warren.error.VungleException
            r5.<init>(r7)
            goto L_0x025f
        L_0x0230:
            int r6 = r5.serverCode
            boolean r6 = r1.recoverableServerCode(r6)
            r8 = 23
            if (r6 == 0) goto L_0x0245
            int r6 = r5.reason
            r9 = 1
            if (r6 != r9) goto L_0x0246
            com.vungle.warren.error.VungleException r5 = new com.vungle.warren.error.VungleException
            r5.<init>(r8)
            goto L_0x024f
        L_0x0245:
            r9 = 1
        L_0x0246:
            int r5 = r5.reason
            if (r5 != 0) goto L_0x0252
            com.vungle.warren.error.VungleException r5 = new com.vungle.warren.error.VungleException
            r5.<init>(r8)
        L_0x024f:
            r6 = 24
            goto L_0x0259
        L_0x0252:
            com.vungle.warren.error.VungleException r5 = new com.vungle.warren.error.VungleException
            r6 = 24
            r5.<init>(r6)
        L_0x0259:
            int r8 = r5.getExceptionCode()
            if (r8 != r6) goto L_0x0214
        L_0x025f:
            java.lang.String r0 = r19.getId()
            r3.onDownloadFailed(r5, r2, r0)
        L_0x0266:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.onAssetDownloadFinished(java.lang.String, com.vungle.warren.AdLoader$DownloadCallback, com.vungle.warren.model.Advertisement, java.util.List):void");
    }

    private class DownloadAdCallback implements DownloadCallback {
        private DownloadAdCallback() {
        }

        public void onDownloadCompleted(String str, String str2) {
            Advertisement advertisement;
            String access$1200 = AdLoader.TAG;
            Log.d(access$1200, "download completed " + str);
            Placement placement = AdLoader.this.repository.load(str, Placement.class).get();
            if (placement == null) {
                VungleLogger.error("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("loaded placement is null: placementId = %1$s; advertisementId = %2$s", new Object[]{str, str2}));
                onDownloadFailed(new VungleException(13), str, str2);
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                advertisement = null;
            } else {
                advertisement = AdLoader.this.repository.load(str2, Advertisement.class).get();
            }
            if (advertisement == null) {
                VungleLogger.error("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("advertisement is null: placementId = %1$s; advertisementId = %2$s", new Object[]{str, str2}));
                onDownloadFailed(new VungleException(11), str, str2);
                return;
            }
            advertisement.setFinishedDownloadingTime(System.currentTimeMillis());
            try {
                AdLoader.this.repository.saveAndApplyState(advertisement, str, 1);
                onReady(str, placement, advertisement);
            } catch (DatabaseHelper.DBException e) {
                VungleLogger.error("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("Can't save/apply state READY: exception = %1$s;placementId = %2$s; advertisement = %3$s", new Object[]{e, str, advertisement}));
                onDownloadFailed(new VungleException(26), str, str2);
            }
        }

        public void onReady(String str, Placement placement, Advertisement advertisement) {
            AdLoader.this.setLoading(str, false);
            HeaderBiddingCallback headerBiddingCallback = AdLoader.this.runtimeValues.headerBiddingCallback.get();
            if (placement.isHeaderBidding() && headerBiddingCallback != null) {
                headerBiddingCallback.adAvailableForBidToken(str, advertisement.getBidToken());
            }
            String access$1200 = AdLoader.TAG;
            Log.i(access$1200, "found already cached valid adv, calling onAdLoad " + str + " callback ");
            InitCallback initCallback = AdLoader.this.runtimeValues.initCallback.get();
            if (placement.isAutoCached() && initCallback != null) {
                initCallback.onAutoCacheAdAvailable(str);
            }
            Operation operation = (Operation) AdLoader.this.loadOperations.remove(str);
            if (operation != null) {
                placement.setAdSize(operation.size);
                try {
                    AdLoader.this.repository.save(placement);
                } catch (DatabaseHelper.DBException e) {
                    VungleLogger.error("AdLoader#DownloadAdCallback#onReady; loadAd sequence", String.format("Can't save placement: exception = %1$s;placement = %2$s; advertisement = %3$s", new Object[]{e, placement, advertisement}));
                    onDownloadFailed(new VungleException(26), str, advertisement.getId());
                }
                for (LoadAdCallback onAdLoad : operation.loadAdCallbacks) {
                    onAdLoad.onAdLoad(str);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3 A[SYNTHETIC, Splitter:B:43:0x00c3] */
        /* JADX WARNING: Removed duplicated region for block: B:73:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDownloadFailed(com.vungle.warren.error.VungleException r12, java.lang.String r13, java.lang.String r14) {
            /*
                r11 = this;
                com.vungle.warren.AdLoader r0 = com.vungle.warren.AdLoader.this
                java.util.Map r0 = r0.loadOperations
                java.lang.Object r0 = r0.remove(r13)
                com.vungle.warren.AdLoader$Operation r0 = (com.vungle.warren.AdLoader.Operation) r0
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this
                r1.tryLoadNextInQueue(r13)
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this
                com.vungle.warren.persistence.Repository r1 = r1.repository
                java.lang.Class<com.vungle.warren.model.Placement> r2 = com.vungle.warren.model.Placement.class
                com.vungle.warren.persistence.FutureResult r1 = r1.load(r13, r2)
                java.lang.Object r1 = r1.get()
                com.vungle.warren.model.Placement r1 = (com.vungle.warren.model.Placement) r1
                if (r14 != 0) goto L_0x0027
                r14 = 0
                goto L_0x0039
            L_0x0027:
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this
                com.vungle.warren.persistence.Repository r2 = r2.repository
                java.lang.Class<com.vungle.warren.model.Advertisement> r3 = com.vungle.warren.model.Advertisement.class
                com.vungle.warren.persistence.FutureResult r14 = r2.load(r14, r3)
                java.lang.Object r14 = r14.get()
                com.vungle.warren.model.Advertisement r14 = (com.vungle.warren.model.Advertisement) r14
            L_0x0039:
                r2 = 26
                r3 = 4
                r4 = 0
                if (r1 != 0) goto L_0x006e
                if (r14 == 0) goto L_0x0050
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x004b }
                com.vungle.warren.persistence.Repository r1 = r1.repository     // Catch:{ DBException -> 0x004b }
                r1.saveAndApplyState(r14, r13, r3)     // Catch:{ DBException -> 0x004b }
                goto L_0x0050
            L_0x004b:
                com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
                r12.<init>(r2)
            L_0x0050:
                if (r0 == 0) goto L_0x0068
                java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
                java.util.Iterator r14 = r14.iterator()
            L_0x0058:
                boolean r0 = r14.hasNext()
                if (r0 == 0) goto L_0x0068
                java.lang.Object r0 = r14.next()
                com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
                r0.onError(r13, r12)
                goto L_0x0058
            L_0x0068:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this
                r12.setLoading(r13, r4)
                return
            L_0x006e:
                int r1 = r12.getExceptionCode()
                r5 = 1
                if (r1 == r5) goto L_0x0097
                r6 = 14
                if (r1 == r6) goto L_0x0097
                r6 = 20
                if (r1 == r6) goto L_0x0094
                r6 = 25
                if (r1 == r6) goto L_0x0097
                r6 = 22
                if (r1 == r6) goto L_0x0094
                r6 = 23
                if (r1 == r6) goto L_0x008a
                goto L_0x0090
            L_0x008a:
                if (r14 == 0) goto L_0x0090
                r1 = 0
                r6 = 1
                r7 = 0
                goto L_0x0099
            L_0x0090:
                r1 = 0
            L_0x0091:
                r6 = 0
            L_0x0092:
                r7 = 4
                goto L_0x0099
            L_0x0094:
                r1 = 0
                r6 = 1
                goto L_0x0092
            L_0x0097:
                r1 = 1
                goto L_0x0091
            L_0x0099:
                if (r0 == 0) goto L_0x009f
                boolean r8 = r0.logError
                if (r8 == 0) goto L_0x00bc
            L_0x009f:
                java.lang.String r8 = com.vungle.warren.AdLoader.TAG
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "Failed to load Ad/Assets for "
                r9.append(r10)
                r9.append(r13)
                java.lang.String r10 = ". Cause : "
                r9.append(r10)
                java.lang.String r9 = r9.toString()
                android.util.Log.e(r8, r9, r12)
            L_0x00bc:
                com.vungle.warren.AdLoader r8 = com.vungle.warren.AdLoader.this
                r8.setLoading(r13, r4)
                if (r0 == 0) goto L_0x0150
                int r8 = r0.policy     // Catch:{ DBException -> 0x0135 }
                r9 = 2
                if (r8 != 0) goto L_0x00f7
                int r1 = r0.retry     // Catch:{ DBException -> 0x0135 }
                int r4 = r0.retryLimit     // Catch:{ DBException -> 0x0135 }
                if (r1 >= r4) goto L_0x0129
                if (r6 == 0) goto L_0x0129
                if (r14 == 0) goto L_0x00dc
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.persistence.Repository r12 = r12.repository     // Catch:{ DBException -> 0x0135 }
                r12.saveAndApplyState(r14, r13, r7)     // Catch:{ DBException -> 0x0135 }
            L_0x00dc:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0135 }
                long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.AdLoader$Operation r14 = r0.delay(r3)     // Catch:{ DBException -> 0x0135 }
                long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0135 }
                long r3 = r3 * r9
                com.vungle.warren.AdLoader$Operation r14 = r14.retryDelay(r3)     // Catch:{ DBException -> 0x0135 }
                int r1 = r0.retry     // Catch:{ DBException -> 0x0135 }
                int r1 = r1 + r5
                com.vungle.warren.AdLoader$Operation r14 = r14.retry(r1)     // Catch:{ DBException -> 0x0135 }
                r12.load(r14)     // Catch:{ DBException -> 0x0135 }
                return
            L_0x00f7:
                if (r8 != r5) goto L_0x0129
                if (r1 != 0) goto L_0x0129
                int r12 = r0.retry     // Catch:{ DBException -> 0x0135 }
                int r1 = r0.retryLimit     // Catch:{ DBException -> 0x0135 }
                if (r12 >= r1) goto L_0x0106
                if (r6 == 0) goto L_0x0106
                int r4 = r12 + 1
                r3 = r7
            L_0x0106:
                if (r14 == 0) goto L_0x0111
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.persistence.Repository r12 = r12.repository     // Catch:{ DBException -> 0x0135 }
                r12.saveAndApplyState(r14, r13, r3)     // Catch:{ DBException -> 0x0135 }
            L_0x0111:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0135 }
                long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.AdLoader$Operation r14 = r0.delay(r5)     // Catch:{ DBException -> 0x0135 }
                long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0135 }
                long r5 = r5 * r9
                com.vungle.warren.AdLoader$Operation r14 = r14.retryDelay(r5)     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.AdLoader$Operation r14 = r14.retry(r4)     // Catch:{ DBException -> 0x0135 }
                r12.load(r14)     // Catch:{ DBException -> 0x0135 }
                return
            L_0x0129:
                if (r14 == 0) goto L_0x013a
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0135 }
                com.vungle.warren.persistence.Repository r1 = r1.repository     // Catch:{ DBException -> 0x0135 }
                r1.saveAndApplyState(r14, r13, r3)     // Catch:{ DBException -> 0x0135 }
                goto L_0x013a
            L_0x0135:
                com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
                r12.<init>(r2)
            L_0x013a:
                java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
                java.util.Iterator r14 = r14.iterator()
            L_0x0140:
                boolean r0 = r14.hasNext()
                if (r0 == 0) goto L_0x0150
                java.lang.Object r0 = r14.next()
                com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
                r0.onError(r13, r12)
                goto L_0x0140
            L_0x0150:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.DownloadAdCallback.onDownloadFailed(com.vungle.warren.error.VungleException, java.lang.String, java.lang.String):void");
        }
    }

    public void load(String str, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        load(new Operation(str, adConfig.getAdSize(), 0, 2000, 5, 0, 0, true, 0, loadAdCallback));
    }

    public void loadEndless(Placement placement, AdConfig.AdSize adSize, long j) {
        if (!isSizeInvalid(placement, adSize)) {
            load(new Operation(placement.getId(), adSize, j, 2000, 5, 1, 0, false, placement.getAutoCachePriority(), new LoadAdCallback[0]));
        }
    }

    public void loadEndless(Placement placement, long j) {
        loadEndless(placement, placement.getAdSize(), j);
    }

    private void unzipFile(Advertisement advertisement, AdAsset adAsset, final File file, List<AdAsset> list) throws IOException, DatabaseHelper.DBException {
        final ArrayList arrayList = new ArrayList();
        for (AdAsset next : list) {
            if (next.fileType == 2) {
                arrayList.add(next.localPath);
            }
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            Object[] objArr = new Object[2];
            objArr[0] = destinationDir == null ? "null" : "not a dir";
            objArr[1] = advertisement;
            VungleLogger.error("AdLoader#unzipFile; loadAd sequence", String.format("Can't unzip file: destination dir is %1$s; advertisement = %2$s", objArr));
            throw new IOException("Unable to access Destination Directory");
        }
        List<File> unzip = UnzipUtility.unzip(file.getPath(), destinationDir.getPath(), new UnzipUtility.Filter(this) {
            public boolean matches(String str) {
                File file = new File(str);
                for (String file2 : arrayList) {
                    File file3 = new File(file2);
                    if (file3.equals(file)) {
                        return false;
                    }
                    String path = file.getPath();
                    if (path.startsWith(file3.getPath() + File.separator)) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (file.getName().equals("template")) {
            File file2 = new File(destinationDir.getPath() + File.separator + "mraid.js");
            if (file2.exists()) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                HackMraid.apply(printWriter);
                printWriter.close();
            }
        }
        for (File next2 : unzip) {
            AdAsset adAsset2 = new AdAsset(advertisement.getId(), (String) null, next2.getPath());
            adAsset2.fileSize = next2.length();
            adAsset2.fileType = 1;
            adAsset2.parentId = adAsset.identifier;
            adAsset2.status = 3;
            this.repository.save(adAsset2);
        }
        String str = TAG;
        Log.d(str, "Uzipped " + destinationDir);
        FileUtility.printDirectoryTree(destinationDir);
        adAsset.status = 4;
        this.repository.save(adAsset, new Repository.SaveCallback() {
            public void onError(Exception exc) {
            }

            public void onSaved() {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        try {
                            FileUtility.delete(file);
                        } catch (IOException e) {
                            Log.e(AdLoader.TAG, "Error on deleting zip assets archive", e);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean hasAssetsFor(String str) throws IllegalStateException {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null || list.size() == 0) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 0) {
                if (adAsset.status != 4) {
                    return false;
                }
            } else if (adAsset.status != 3 || !fileIsValid(new File(adAsset.localPath), adAsset)) {
                return false;
            }
        }
        return true;
    }

    private boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.fileSize;
    }

    public void dropCache(String str) {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null) {
            Log.w(TAG, "No assets found in ad cache to cleanup");
            return;
        }
        for (AdAsset adAsset : list) {
            this.downloader.dropCache(adAsset.serverPath);
        }
    }
}
