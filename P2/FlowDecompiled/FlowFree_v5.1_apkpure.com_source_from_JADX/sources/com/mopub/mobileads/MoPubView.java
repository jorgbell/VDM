package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.MoPubAd;
import com.mopub.mobileads.base.C2620R;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import java.util.Map;

public class MoPubView extends FrameLayout implements MoPubAd {
    protected AdViewController mAdViewController;
    private BannerAdListener mBannerAdListener;
    private Context mContext;
    private MoPubAdSize mMoPubAdSize;
    private BroadcastReceiver mScreenStateReceiver;
    /* access modifiers changed from: private */
    public int mScreenVisibility;

    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
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

    @Deprecated
    public String getClickTrackingUrl() {
        return null;
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

    @Deprecated
    public String getResponseString() {
        return null;
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

    public void onAdComplete(MoPubReward moPubReward) {
    }

    public void onAdDismissed() {
    }

    public void onAdImpression() {
    }

    public void onAdShown() {
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

    @Deprecated
    public void setLocation(Location location) {
    }

    @Deprecated
    public void setTimeout(int i) {
    }

    public /* bridge */ /* synthetic */ void setUserDataKeywords(String str) {
        MoPubAd.CC.$default$setUserDataKeywords(this, str);
    }

    public enum MoPubAdSize {
        MATCH_VIEW(-1),
        HEIGHT_50(50),
        HEIGHT_90(90),
        HEIGHT_250(250),
        HEIGHT_280(280);
        
        private final int mSizeInt;

        private MoPubAdSize(int i) {
            this.mSizeInt = i;
        }

        public static MoPubAdSize valueOf(int i) {
            if (i == 50) {
                return HEIGHT_50;
            }
            if (i == 90) {
                return HEIGHT_90;
            }
            if (i == 250) {
                return HEIGHT_250;
            }
            if (i != 280) {
                return MATCH_VIEW;
            }
            return HEIGHT_280;
        }

        public int toInt() {
            return this.mSizeInt;
        }
    }

    public MoPubView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MoPubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMoPubAdSize = getMoPubAdSizeFromAttributeSet(context, attributeSet, MoPubAdSize.MATCH_VIEW);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.mContext = context;
        this.mScreenVisibility = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setAdViewController(AdViewControllerFactory.create(context, this));
        registerScreenStateBroadcastReceiver();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            setWindowInsets(getRootWindowInsets());
        }
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 28) {
            setWindowInsets(windowInsets);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    private void registerScreenStateBroadcastReceiver() {
        this.mScreenStateReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (Visibility.isScreenVisible(MoPubView.this.mScreenVisibility) && intent != null) {
                    String action = intent.getAction();
                    if ("android.intent.action.USER_PRESENT".equals(action)) {
                        MoPubView.this.setAdVisibility(0);
                    } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        MoPubView.this.setAdVisibility(8);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.mContext.registerReceiver(this.mScreenStateReceiver, intentFilter);
    }

    private void unregisterScreenStateBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (Exception unused) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    public void loadAd(MoPubAdSize moPubAdSize) {
        setAdSize(moPubAdSize);
        loadAd();
    }

    public void destroy() {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Destroy() called");
        unregisterScreenStateBroadcastReceiver();
        removeAllViews();
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.cleanup();
            this.mAdViewController = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (Visibility.hasScreenVisibilityChanged(this.mScreenVisibility, i)) {
            this.mScreenVisibility = i;
            setAdVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public void setAdVisibility(int i) {
        if (this.mAdViewController != null) {
            if (Visibility.isScreenVisible(i)) {
                this.mAdViewController.resumeRefresh();
            } else {
                this.mAdViewController.pauseRefresh();
            }
        }
    }

    private MoPubAdSize getMoPubAdSizeFromAttributeSet(Context context, AttributeSet attributeSet, MoPubAdSize moPubAdSize) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2620R.styleable.MoPubView, 0, 0);
        try {
            moPubAdSize = MoPubAdSize.valueOf(obtainStyledAttributes.getInteger(C2620R.styleable.MoPubView_moPubAdSize, moPubAdSize.toInt()));
        } catch (Resources.NotFoundException e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Encountered a problem while setting the MoPubAdSize", e);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        return moPubAdSize;
    }

    public Point resolveAdSize() {
        Point point = new Point(getWidth(), getHeight());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(getParent() == null || layoutParams == null || layoutParams.width >= 0)) {
            point.x = ((View) getParent()).getWidth();
        }
        if (this.mMoPubAdSize != MoPubAdSize.MATCH_VIEW) {
            point.y = (int) Math.ceil((double) (((float) this.mMoPubAdSize.toInt()) * this.mContext.getResources().getDisplayMetrics().density));
        } else if (!(getParent() == null || layoutParams == null || layoutParams.height >= 0)) {
            point.y = ((View) getParent()).getHeight();
        }
        return point;
    }

    public AdFormat getAdFormat() {
        return AdFormat.BANNER;
    }

    public Activity getActivity() {
        return (Activity) this.mContext;
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
    }

    public BannerAdListener getBannerAdListener() {
        return this.mBannerAdListener;
    }

    public void setAutorefreshEnabled(boolean z) {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.setShouldAllowAutoRefresh(z);
        }
    }

    public boolean getAutorefreshEnabled() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            return adViewController.getCurrentAutoRefreshStatus();
        }
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
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
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void forceRefresh() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.forceRefresh();
        }
    }

    public void setAdSize(MoPubAdSize moPubAdSize) {
        this.mMoPubAdSize = moPubAdSize;
    }

    public MoPubAdSize getAdSize() {
        return this.mMoPubAdSize;
    }

    /* access modifiers changed from: package-private */
    public void setWindowInsets(WindowInsets windowInsets) {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.setWindowInsets(windowInsets);
        }
    }

    public AdViewController getAdViewController() {
        return this.mAdViewController;
    }

    public void setAdViewController(AdViewController adViewController) {
        this.mAdViewController = adViewController;
    }

    public void onAdLoaded() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.show();
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerLoaded(this);
        }
    }

    public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerFailed(this, moPubErrorCode);
        }
    }

    public void onAdFailed(MoPubErrorCode moPubErrorCode) {
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerFailed(this, moPubErrorCode);
        }
    }

    public void onAdExpanded() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.engageOverlay();
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerExpanded(this);
        }
    }

    public void onAdCollapsed() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.dismissOverlay();
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerCollapsed(this);
        }
    }

    public void onAdClicked() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.registerClick();
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerClicked(this);
        }
    }

    public void onAdPauseAutoRefresh() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.engageOverlay();
        }
    }

    public void onAdResumeAutoRefresh() {
        AdViewController adViewController = this.mAdViewController;
        if (adViewController != null) {
            adViewController.dismissOverlay();
        }
    }
}
