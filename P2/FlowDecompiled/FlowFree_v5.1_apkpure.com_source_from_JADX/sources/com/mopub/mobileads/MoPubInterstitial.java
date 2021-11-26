package com.mopub.mobileads;

import android.app.Activity;
import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPubReward;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.mobileads.MoPubAd;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import java.util.Map;

public class MoPubInterstitial implements MoPubAd {
    private Activity mActivity;
    protected AdViewController mAdViewController;
    private volatile InterstitialState mCurrentInterstitialState = InterstitialState.IDLE;
    private InterstitialAdListener mInterstitialAdListener;

    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    @VisibleForTesting
    enum InterstitialState {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public /* bridge */ /* synthetic */ int getAdHeight() {
        return MoPubAd.CC.$default$getAdHeight(this);
    }

    public /* bridge */ /* synthetic */ String getAdUnitId() {
        return MoPubAd.CC.$default$getAdUnitId(this);
    }

    public /* bridge */ /* synthetic */ int getAdWidth() {
        return MoPubAd.CC.$default$getAdWidth(this);
    }

    public /* bridge */ /* synthetic */ String getKeywords() {
        return MoPubAd.CC.$default$getKeywords(this);
    }

    public /* bridge */ /* synthetic */ Map<String, Object> getLocalExtras() {
        return MoPubAd.CC.$default$getLocalExtras(this);
    }

    public /* bridge */ /* synthetic */ Location getLocation() {
        return MoPubAd.CC.$default$getLocation(this);
    }

    public /* bridge */ /* synthetic */ String getUserDataKeywords() {
        return MoPubAd.CC.$default$getUserDataKeywords(this);
    }

    public /* bridge */ /* synthetic */ void loadAd() {
        MoPubAd.CC.$default$loadAd(this);
    }

    public /* bridge */ /* synthetic */ boolean loadFailUrl(MoPubErrorCode moPubErrorCode) {
        return MoPubAd.CC.$default$loadFailUrl(this, moPubErrorCode);
    }

    public /* bridge */ /* synthetic */ void onAdCollapsed() {
        AdLifecycleListener.InlineInteractionListener.CC.$default$onAdCollapsed(this);
    }

    public /* bridge */ /* synthetic */ void onAdExpanded() {
        AdLifecycleListener.InlineInteractionListener.CC.$default$onAdExpanded(this);
    }

    public void onAdImpression() {
    }

    public /* bridge */ /* synthetic */ void onAdPauseAutoRefresh() {
        AdLifecycleListener.InlineInteractionListener.CC.$default$onAdPauseAutoRefresh(this);
    }

    public /* bridge */ /* synthetic */ void onAdResumeAutoRefresh() {
        AdLifecycleListener.InlineInteractionListener.CC.$default$onAdResumeAutoRefresh(this);
    }

    public /* bridge */ /* synthetic */ void pauseAutoRefresh() {
        MoPubAd.CC.$default$pauseAutoRefresh(this);
    }

    public /* bridge */ /* synthetic */ void resumeAutoRefresh() {
        MoPubAd.CC.$default$resumeAutoRefresh(this);
    }

    public /* bridge */ /* synthetic */ void setAdContentView(View view) {
        MoPubAd.CC.$default$setAdContentView(this, view);
    }

    public /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        MoPubAd.CC.$default$setAdUnitId(this, str);
    }

    public /* bridge */ /* synthetic */ void setKeywords(String str) {
        MoPubAd.CC.$default$setKeywords(this, str);
    }

    public /* bridge */ /* synthetic */ void setLocalExtras(Map<String, ? extends Object> map) {
        MoPubAd.CC.$default$setLocalExtras(this, map);
    }

    public /* bridge */ /* synthetic */ void setUserDataKeywords(String str) {
        MoPubAd.CC.$default$setUserDataKeywords(this, str);
    }

    public MoPubInterstitial(Activity activity, String str) {
        this.mActivity = activity;
        AdViewController create = AdViewControllerFactory.create(activity, this);
        create.setShouldAllowAutoRefresh(false);
        setAdViewController(create);
        setAdUnitId(str);
        new Handler();
    }

    private boolean attemptStateTransition(InterstitialState interstitialState) {
        return attemptStateTransition(interstitialState, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00fc, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x013d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x014c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0067, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00bd, code lost:
        return false;
     */
    @com.mopub.common.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean attemptStateTransition(com.mopub.mobileads.MoPubInterstitial.InterstitialState r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.mopub.common.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r0 = r8.mCurrentInterstitialState     // Catch:{ all -> 0x014d }
            int[] r1 = com.mopub.mobileads.MoPubInterstitial.C25571.f5551xe6f223c6     // Catch:{ all -> 0x014d }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x014d }
            r0 = r1[r0]     // Catch:{ all -> 0x014d }
            r2 = 2
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 0
            if (r0 == r6) goto L_0x00fd
            if (r0 == r2) goto L_0x00be
            if (r0 == r5) goto L_0x0075
            if (r0 == r4) goto L_0x0068
            if (r0 == r3) goto L_0x0020
            monitor-exit(r8)
            return r7
        L_0x0020:
            int r9 = r9.ordinal()     // Catch:{ all -> 0x014d }
            r9 = r1[r9]     // Catch:{ all -> 0x014d }
            if (r9 == r6) goto L_0x004f
            if (r9 == r2) goto L_0x0042
            if (r9 == r5) goto L_0x0035
            if (r9 == r4) goto L_0x0030
            monitor-exit(r8)
            return r7
        L_0x0030:
            r8.setInterstitialStateDestroyed()     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x0035:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "No interstitial loading or loaded."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x0042:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Attempted transition from IDLE to READY failed due to no known load call."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x004f:
            r8.invalidateInterstitialAdapter()     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.LOADING     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            r8.updatedInsets()     // Catch:{ all -> 0x014d }
            if (r10 == 0) goto L_0x0063
            com.mopub.mobileads.AdViewController r9 = r8.mAdViewController     // Catch:{ all -> 0x014d }
            if (r9 == 0) goto L_0x0066
            r9.forceRefresh()     // Catch:{ all -> 0x014d }
            goto L_0x0066
        L_0x0063:
            r8.loadAd()     // Catch:{ all -> 0x014d }
        L_0x0066:
            monitor-exit(r8)
            return r6
        L_0x0068:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "MoPubInterstitial destroyed. Ignoring all requests."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x0075:
            int r9 = r9.ordinal()     // Catch:{ all -> 0x014d }
            r9 = r1[r9]     // Catch:{ all -> 0x014d }
            if (r9 == r6) goto L_0x00af
            if (r9 == r5) goto L_0x00a2
            if (r9 == r4) goto L_0x009d
            if (r9 == r3) goto L_0x0085
            monitor-exit(r8)
            return r7
        L_0x0085:
            if (r10 == 0) goto L_0x0094
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Cannot force refresh while showing an interstitial."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x0094:
            r8.invalidateInterstitialAdapter()     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.IDLE     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x009d:
            r8.setInterstitialStateDestroyed()     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x00a2:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Already showing an interstitial. Cannot show it again."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x00af:
            if (r10 != 0) goto L_0x00bc
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Interstitial already showing. Not loading another."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
        L_0x00bc:
            monitor-exit(r8)
            return r7
        L_0x00be:
            int r9 = r9.ordinal()     // Catch:{ all -> 0x014d }
            r9 = r1[r9]     // Catch:{ all -> 0x014d }
            if (r9 == r6) goto L_0x00e9
            if (r9 == r5) goto L_0x00e0
            if (r9 == r4) goto L_0x00db
            if (r9 == r3) goto L_0x00ce
            monitor-exit(r8)
            return r7
        L_0x00ce:
            if (r10 == 0) goto L_0x00d9
            r8.invalidateInterstitialAdapter()     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.IDLE     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x00d9:
            monitor-exit(r8)
            return r7
        L_0x00db:
            r8.setInterstitialStateDestroyed()     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x00e0:
            r8.showFullscreen()     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.SHOWING     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x00e9:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Interstitial already loaded. Not loading another."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r9 = r8.mInterstitialAdListener     // Catch:{ all -> 0x014d }
            if (r9 == 0) goto L_0x00fb
            r9.onInterstitialLoaded(r8)     // Catch:{ all -> 0x014d }
        L_0x00fb:
            monitor-exit(r8)
            return r7
        L_0x00fd:
            int r9 = r9.ordinal()     // Catch:{ all -> 0x014d }
            r9 = r1[r9]     // Catch:{ all -> 0x014d }
            if (r9 == r6) goto L_0x013e
            if (r9 == r2) goto L_0x012a
            if (r9 == r5) goto L_0x011d
            if (r9 == r4) goto L_0x0118
            if (r9 == r3) goto L_0x010f
            monitor-exit(r8)
            return r7
        L_0x010f:
            r8.invalidateInterstitialAdapter()     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.IDLE     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x0118:
            r8.setInterstitialStateDestroyed()     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r6
        L_0x011d:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Interstitial is not ready to be shown yet."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            monitor-exit(r8)
            return r7
        L_0x012a:
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.LOAD_SUCCESS     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialState r9 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.READY     // Catch:{ all -> 0x014d }
            r8.mCurrentInterstitialState = r9     // Catch:{ all -> 0x014d }
            com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener r9 = r8.mInterstitialAdListener     // Catch:{ all -> 0x014d }
            if (r9 == 0) goto L_0x013c
            r9.onInterstitialLoaded(r8)     // Catch:{ all -> 0x014d }
        L_0x013c:
            monitor-exit(r8)
            return r6
        L_0x013e:
            if (r10 != 0) goto L_0x014b
            com.mopub.common.logging.MoPubLog$AdLogEvent r9 = com.mopub.common.logging.MoPubLog.AdLogEvent.CUSTOM     // Catch:{ all -> 0x014d }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = "Already loading an interstitial."
            r10[r7] = r0     // Catch:{ all -> 0x014d }
            com.mopub.common.logging.MoPubLog.log(r9, r10)     // Catch:{ all -> 0x014d }
        L_0x014b:
            monitor-exit(r8)
            return r7
        L_0x014d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubInterstitial.attemptStateTransition(com.mopub.mobileads.MoPubInterstitial$InterstitialState, boolean):boolean");
    }

    /* renamed from: com.mopub.mobileads.MoPubInterstitial$1 */
    static /* synthetic */ class C25571 {

        /* renamed from: $SwitchMap$com$mopub$mobileads$MoPubInterstitial$InterstitialState */
        static final /* synthetic */ int[] f5551xe6f223c6;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mopub.mobileads.MoPubInterstitial$InterstitialState[] r0 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5551xe6f223c6 = r0
                com.mopub.mobileads.MoPubInterstitial$InterstitialState r1 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5551xe6f223c6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.mobileads.MoPubInterstitial$InterstitialState r1 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5551xe6f223c6     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.mobileads.MoPubInterstitial$InterstitialState r1 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.SHOWING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5551xe6f223c6     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mopub.mobileads.MoPubInterstitial$InterstitialState r1 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5551xe6f223c6     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mopub.mobileads.MoPubInterstitial$InterstitialState r1 = com.mopub.mobileads.MoPubInterstitial.InterstitialState.IDLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubInterstitial.C25571.<clinit>():void");
        }
    }

    private void setInterstitialStateDestroyed() {
        invalidateInterstitialAdapter();
        this.mInterstitialAdListener = null;
        this.mCurrentInterstitialState = InterstitialState.DESTROYED;
    }

    private void updatedInsets() {
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        AdViewController adViewController;
        if (Build.VERSION.SDK_INT >= 28 && (window = this.mActivity.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootWindowInsets = decorView.getRootWindowInsets()) != null && (adViewController = this.mAdViewController) != null) {
            adViewController.setWindowInsets(rootWindowInsets);
        }
    }

    public void load() {
        MoPubLog.log(MoPubLog.AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
        attemptStateTransition(InterstitialState.LOADING);
    }

    public boolean show() {
        MoPubLog.log(MoPubLog.AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        return attemptStateTransition(InterstitialState.SHOWING);
    }

    public void forceRefresh() {
        attemptStateTransition(InterstitialState.IDLE, true);
        attemptStateTransition(InterstitialState.LOADING, true);
    }

    public boolean isReady() {
        return this.mCurrentInterstitialState == InterstitialState.READY;
    }

    /* access modifiers changed from: package-private */
    public boolean isDestroyed() {
        return this.mCurrentInterstitialState == InterstitialState.DESTROYED;
    }

    private void showFullscreen() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.show();
        }
    }

    private void invalidateInterstitialAdapter() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.invalidateAdapter();
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public void destroy() {
        attemptStateTransition(InterstitialState.DESTROYED);
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdListener = interstitialAdListener;
    }

    public InterstitialAdListener getInterstitialAdListener() {
        return this.mInterstitialAdListener;
    }

    public void setTesting(boolean z) {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.setTesting(z);
        }
    }

    public boolean getTesting() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            return adViewController.getTesting();
        }
        MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, "Can't get testing status for destroyed AdViewController. Returning false.");
        return false;
    }

    public void onAdLoaded() {
        if (!isDestroyed()) {
            attemptStateTransition(InterstitialState.READY);
        }
    }

    public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
        if (!isDestroyed()) {
            MoPubLog.log(MoPubLog.AdLogEvent.LOAD_FAILED, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialFailed(this, moPubErrorCode);
            }
            attemptStateTransition(InterstitialState.IDLE);
        }
    }

    public void onAdFailed(MoPubErrorCode moPubErrorCode) {
        if (!isDestroyed()) {
            MoPubLog.log(MoPubLog.AdLogEvent.SHOW_FAILED, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialFailed(this, moPubErrorCode);
            }
            attemptStateTransition(InterstitialState.IDLE);
        }
    }

    public void onAdShown() {
        if (!isDestroyed()) {
            MoPubLog.log(MoPubLog.AdLogEvent.SHOW_SUCCESS, new Object[0]);
            InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialShown(this);
            }
        }
    }

    public void onAdClicked() {
        if (!isDestroyed()) {
            MoPubLog.log(MoPubLog.AdLogEvent.CLICKED, new Object[0]);
            AdViewController adViewController = this.mAdViewController;
            if (adViewController != null) {
                adViewController.registerClick();
            }
            InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialClicked(this);
            }
        }
    }

    public void onAdDismissed() {
        if (!isDestroyed()) {
            MoPubLog.log(MoPubLog.AdLogEvent.DID_DISAPPEAR, new Object[0]);
            attemptStateTransition(InterstitialState.IDLE);
            InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onInterstitialDismissed(this);
            }
        }
    }

    public void onAdComplete(MoPubReward moPubReward) {
        MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, "Interstitial finished.");
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.onAdComplete((MoPubReward) null);
        }
    }

    public AdFormat getAdFormat() {
        return AdFormat.INTERSTITIAL;
    }

    public AdViewController getAdViewController() {
        return this.mAdViewController;
    }

    public void setAdViewController(AdViewController adViewController) {
        this.mAdViewController = adViewController;
    }

    public Point resolveAdSize() {
        return DeviceUtils.getDeviceDimensions(this.mActivity);
    }
}
