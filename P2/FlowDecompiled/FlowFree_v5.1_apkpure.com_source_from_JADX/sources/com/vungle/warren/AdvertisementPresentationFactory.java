package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.vungle.warren.AdConfig;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.analytics.JobDelegateAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.p054ui.CloseDelegate;
import com.vungle.warren.p054ui.JavascriptBridge;
import com.vungle.warren.p054ui.OrientationDelegate;
import com.vungle.warren.p054ui.contract.AdContract$AdView;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdPresenter;
import com.vungle.warren.p054ui.presenter.LocalAdPresenter;
import com.vungle.warren.p054ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.p054ui.state.OptionsState;
import com.vungle.warren.p054ui.view.FullAdWidget;
import com.vungle.warren.p054ui.view.LocalAdView;
import com.vungle.warren.p054ui.view.MRAIDAdView;
import com.vungle.warren.p054ui.view.VungleWebClient;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.HandlerScheduler;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class AdvertisementPresentationFactory implements PresentationFactory {
    /* access modifiers changed from: private */
    public static final String TAG = "AdvertisementPresentationFactory";
    private final AdLoader adLoader;
    private VungleApiClient apiClient;
    /* access modifiers changed from: private */
    public Advertisement currentAdvertisement;
    private final JobRunner jobRunner;
    private final OMTracker.Factory omTrackerFactory;
    private BaseTask.OnModelLoadListener onModelLoadListener = new BaseTask.OnModelLoadListener() {
        public void onLoad(Advertisement advertisement, Placement placement) {
            Advertisement unused = AdvertisementPresentationFactory.this.currentAdvertisement = advertisement;
        }
    };
    private Repository repository;
    private final SessionData sessionData;
    private BaseTask task;
    private VungleStaticApi vungleStaticApi;

    AdvertisementPresentationFactory(AdLoader adLoader2, VungleStaticApi vungleStaticApi2, Repository repository2, VungleApiClient vungleApiClient, JobRunner jobRunner2, RuntimeValues runtimeValues, OMTracker.Factory factory) {
        this.vungleStaticApi = vungleStaticApi2;
        this.repository = repository2;
        this.apiClient = vungleApiClient;
        this.jobRunner = jobRunner2;
        this.adLoader = adLoader2;
        this.sessionData = runtimeValues.sessionData.get();
        this.omTrackerFactory = factory;
    }

    public void getFullScreenPresentation(Context context, String str, FullAdWidget fullAdWidget, OptionsState optionsState, CloseDelegate closeDelegate, OrientationDelegate orientationDelegate, Bundle bundle, PresentationFactory.FullScreenCallback fullScreenCallback) {
        cancelTask();
        AdLoader adLoader2 = this.adLoader;
        Repository repository2 = this.repository;
        VungleStaticApi vungleStaticApi2 = this.vungleStaticApi;
        JobRunner jobRunner2 = this.jobRunner;
        VungleApiClient vungleApiClient = this.apiClient;
        SessionData sessionData2 = this.sessionData;
        FullScreenPresentationTask fullScreenPresentationTask = new FullScreenPresentationTask(context, adLoader2, str, repository2, vungleStaticApi2, jobRunner2, vungleApiClient, sessionData2, fullAdWidget, optionsState, orientationDelegate, closeDelegate, fullScreenCallback, this.onModelLoadListener, bundle, this.omTrackerFactory);
        this.task = fullScreenPresentationTask;
        fullScreenPresentationTask.execute(new Void[0]);
    }

    private void cancelTask() {
        BaseTask baseTask = this.task;
        if (baseTask != null) {
            baseTask.cancel(true);
            this.task.clear();
        }
    }

    public void getNativeViewPresentation(String str, AdConfig adConfig, CloseDelegate closeDelegate, PresentationFactory.ViewCallback viewCallback) {
        cancelTask();
        NativeViewPresentationTask nativeViewPresentationTask = new NativeViewPresentationTask(str, adConfig, this.adLoader, this.repository, this.vungleStaticApi, this.jobRunner, viewCallback, (Bundle) null, this.sessionData, this.onModelLoadListener, this.apiClient, this.omTrackerFactory);
        this.task = nativeViewPresentationTask;
        nativeViewPresentationTask.execute(new Void[0]);
    }

    public void saveState(Bundle bundle) {
        Advertisement advertisement = this.currentAdvertisement;
        bundle.putString("ADV_FACTORY_ADVERTISEMENT", advertisement == null ? null : advertisement.getId());
    }

    public void destroy() {
        cancelTask();
    }

    private static class PresentationResultHolder {
        /* access modifiers changed from: private */
        public AdContract$AdView adView;
        /* access modifiers changed from: private */
        public AdContract$AdvertisementPresenter advertisementPresenter;
        /* access modifiers changed from: private */
        public VungleException exception;
        /* access modifiers changed from: private */
        public VungleWebClient webClient;

        PresentationResultHolder(VungleException vungleException) {
            this.exception = vungleException;
        }

        PresentationResultHolder(AdContract$AdView adContract$AdView, AdContract$AdvertisementPresenter adContract$AdvertisementPresenter, VungleWebClient vungleWebClient) {
            this.adView = adContract$AdView;
            this.advertisementPresenter = adContract$AdvertisementPresenter;
            this.webClient = vungleWebClient;
        }
    }

    private static class FullScreenPresentationTask extends BaseTask {
        private final AdLoader adLoader;
        private Advertisement advertisement;
        private final VungleApiClient apiClient;
        private final CloseDelegate closeDelegate;
        @SuppressLint({"StaticFieldLeak"})
        private Context context;
        @SuppressLint({"StaticFieldLeak"})
        private FullAdWidget fullAdWidget;
        private final PresentationFactory.FullScreenCallback fullscreenCallback;
        private final JobRunner jobRunner;
        private final OMTracker.Factory omTrackerFactory;
        private final OptionsState optionsState;
        private final OrientationDelegate orientationDelegate;
        private final String placementId;
        private final Bundle savedState;
        private final SessionData sessionData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        FullScreenPresentationTask(Context context2, AdLoader adLoader2, String str, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, VungleApiClient vungleApiClient, SessionData sessionData2, FullAdWidget fullAdWidget2, OptionsState optionsState2, OrientationDelegate orientationDelegate2, CloseDelegate closeDelegate2, PresentationFactory.FullScreenCallback fullScreenCallback, BaseTask.OnModelLoadListener onModelLoadListener, Bundle bundle, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            Repository repository2 = repository;
            VungleStaticApi vungleStaticApi2 = vungleStaticApi;
            this.placementId = str;
            this.fullAdWidget = fullAdWidget2;
            this.optionsState = optionsState2;
            this.context = context2;
            this.fullscreenCallback = fullScreenCallback;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.apiClient = vungleApiClient;
            this.orientationDelegate = orientationDelegate2;
            this.closeDelegate = closeDelegate2;
            this.adLoader = adLoader2;
            this.sessionData = sessionData2;
            this.omTrackerFactory = factory;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            super.clear();
            this.context = null;
            this.fullAdWidget = null;
        }

        /* access modifiers changed from: protected */
        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.placementId, this.savedState);
                Advertisement advertisement2 = (Advertisement) loadPresentationData.first;
                this.advertisement = advertisement2;
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canRenderAd(advertisement2)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                }
                JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                Cookie cookie = this.repository.load("appId", Cookie.class).get();
                if (cookie != null && !TextUtils.isEmpty(cookie.getString("appId"))) {
                    cookie.getString("appId");
                }
                VungleWebClient vungleWebClient = new VungleWebClient(this.advertisement, placement);
                File file = this.repository.getAdvertisementAssetDirectory(this.advertisement.getId()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                    return new PresentationResultHolder(new VungleException(26));
                }
                int adType = this.advertisement.getAdType();
                if (adType != 0) {
                    boolean z = true;
                    if (adType != 1) {
                        return new PresentationResultHolder(new VungleException(10));
                    }
                    OMTracker.Factory factory = this.omTrackerFactory;
                    if (!this.apiClient.getOmEnabled() || !this.advertisement.getOmEnabled()) {
                        z = false;
                    }
                    OMTracker make = factory.make(z);
                    vungleWebClient.setWebViewObserver(make);
                    return new PresentationResultHolder(new MRAIDAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new MRAIDAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, this.sessionData, make), vungleWebClient);
                }
                return new PresentationResultHolder(new LocalAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new LocalAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, this.sessionData), vungleWebClient);
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && this.fullscreenCallback != null) {
                if (presentationResultHolder.exception != null) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Exception on creating presenter", presentationResultHolder.exception);
                    this.fullscreenCallback.onResult(new Pair((Object) null, (Object) null), presentationResultHolder.exception);
                    return;
                }
                this.fullAdWidget.linkWebView(presentationResultHolder.webClient, new JavascriptBridge(presentationResultHolder.advertisementPresenter));
                this.fullscreenCallback.onResult(new Pair(presentationResultHolder.adView, presentationResultHolder.advertisementPresenter), presentationResultHolder.exception);
            }
        }
    }

    private static class NativeViewPresentationTask extends BaseTask {
        private final AdConfig adConfig;
        private final AdLoader adLoader;
        private final VungleApiClient apiClient;
        private final JobRunner jobRunner;
        private final OMTracker.Factory omTrackerFactory;
        private final String placementId;
        private final Bundle savedState;
        private final SessionData sessionData;
        private final PresentationFactory.ViewCallback viewCallback;

        NativeViewPresentationTask(String str, AdConfig adConfig2, AdLoader adLoader2, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, PresentationFactory.ViewCallback viewCallback2, Bundle bundle, SessionData sessionData2, BaseTask.OnModelLoadListener onModelLoadListener, VungleApiClient vungleApiClient, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            this.placementId = str;
            this.adConfig = adConfig2;
            this.viewCallback = viewCallback2;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.adLoader = adLoader2;
            this.sessionData = sessionData2;
            this.apiClient = vungleApiClient;
            this.omTrackerFactory = factory;
        }

        /* access modifiers changed from: protected */
        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.placementId, this.savedState);
                Advertisement advertisement = (Advertisement) loadPresentationData.first;
                boolean z = true;
                if (advertisement.getAdType() != 1) {
                    return new PresentationResultHolder(new VungleException(10));
                }
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canPlayAd(advertisement)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    if (placement.isAutoCached()) {
                        this.adLoader.loadEndless(placement, 0);
                    }
                    return new PresentationResultHolder(new VungleException(10));
                }
                JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                VungleWebClient vungleWebClient = new VungleWebClient(advertisement, placement);
                File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                    return new PresentationResultHolder(new VungleException(26));
                } else if (advertisement.getAdType() != 1) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Invalid Ad Type for Native Ad.");
                    return new PresentationResultHolder(new VungleException(10));
                } else if (!"mrec".equals(advertisement.getTemplateType()) || this.adConfig.getAdSize() == AdConfig.AdSize.VUNGLE_MREC) {
                    advertisement.configure(this.adConfig);
                    try {
                        this.repository.save(advertisement);
                        OMTracker.Factory factory = this.omTrackerFactory;
                        if (!this.apiClient.getOmEnabled() || !advertisement.getOmEnabled()) {
                            z = false;
                        }
                        OMTracker make = factory.make(z);
                        vungleWebClient.setWebViewObserver(make);
                        return new PresentationResultHolder((AdContract$AdView) null, new MRAIDAdPresenter(advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, (OptionsState) null, file, this.sessionData, make), vungleWebClient);
                    } catch (DatabaseHelper.DBException unused) {
                        return new PresentationResultHolder(new VungleException(26));
                    }
                } else {
                    Log.e(AdvertisementPresentationFactory.TAG, "Corresponding AdConfig#setAdSize must be passed for the type/size of native ad");
                    return new PresentationResultHolder(new VungleException(28));
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            PresentationFactory.ViewCallback viewCallback2;
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && (viewCallback2 = this.viewCallback) != null) {
                viewCallback2.onResult(new Pair((WebAdContract$WebAdPresenter) presentationResultHolder.advertisementPresenter, presentationResultHolder.webClient), presentationResultHolder.exception);
            }
        }
    }

    private static abstract class BaseTask extends AsyncTask<Void, Void, PresentationResultHolder> {
        private AtomicReference<Advertisement> adRef = new AtomicReference<>();
        private OnModelLoadListener onDataLoadedListener;
        private AtomicReference<Placement> plRef = new AtomicReference<>();
        protected final Repository repository;
        protected final VungleStaticApi vungleStaticApi;

        interface OnModelLoadListener {
            void onLoad(Advertisement advertisement, Placement placement);
        }

        BaseTask(Repository repository2, VungleStaticApi vungleStaticApi2, OnModelLoadListener onModelLoadListener) {
            this.repository = repository2;
            this.vungleStaticApi = vungleStaticApi2;
            this.onDataLoadedListener = onModelLoadListener;
        }

        /* access modifiers changed from: package-private */
        public Pair<Advertisement, Placement> loadPresentationData(String str, Bundle bundle) throws VungleException {
            if (!this.vungleStaticApi.isInitialized()) {
                throw new VungleException(9);
            } else if (!TextUtils.isEmpty(str)) {
                Placement placement = this.repository.load(str, Placement.class).get();
                if (placement != null) {
                    this.plRef.set(placement);
                    Advertisement advertisement = null;
                    if (bundle == null) {
                        advertisement = this.repository.findValidAdvertisementForPlacement(str).get();
                    } else {
                        String string = bundle.getString("ADV_FACTORY_ADVERTISEMENT");
                        if (!TextUtils.isEmpty(string)) {
                            advertisement = this.repository.load(string, Advertisement.class).get();
                        }
                    }
                    if (advertisement != null) {
                        this.adRef.set(advertisement);
                        File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                        if (file != null && file.isDirectory()) {
                            return new Pair<>(advertisement, placement);
                        }
                        Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                        throw new VungleException(26);
                    }
                    throw new VungleException(10);
                }
                Log.e(AdvertisementPresentationFactory.TAG, "No Placement for ID");
                throw new VungleException(13);
            } else {
                throw new VungleException(10);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            OnModelLoadListener onModelLoadListener = this.onDataLoadedListener;
            if (onModelLoadListener != null) {
                onModelLoadListener.onLoad(this.adRef.get(), this.plRef.get());
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.onDataLoadedListener = null;
        }
    }
}
