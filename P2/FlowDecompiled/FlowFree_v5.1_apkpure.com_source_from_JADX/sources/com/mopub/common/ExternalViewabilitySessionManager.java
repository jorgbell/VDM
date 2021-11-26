package com.mopub.common;

import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import java.util.HashSet;
import java.util.Set;

public class ExternalViewabilitySessionManager {
    private static ExternalViewabilityManagerFactory sCreator;
    final Set<Pair<View, ViewabilityObstruction>> mObstructions = new HashSet();
    private ViewabilityTracker mViewabilityTracker = null;

    @VisibleForTesting
    public interface ExternalViewabilityManagerFactory {
        ExternalViewabilitySessionManager create();
    }

    @Deprecated
    public enum ViewabilityVendor {
        AVID,
        MOAT,
        ALL
    }

    private ExternalViewabilitySessionManager() {
    }

    public static ExternalViewabilitySessionManager create() {
        ExternalViewabilityManagerFactory externalViewabilityManagerFactory = sCreator;
        if (externalViewabilityManagerFactory == null) {
            return new ExternalViewabilitySessionManager();
        }
        return externalViewabilityManagerFactory.create();
    }

    public void createWebViewSession(WebView webView) {
        Preconditions.checkUiThread();
        Preconditions.checkNotNull(webView);
        if (this.mViewabilityTracker == null) {
            try {
                this.mViewabilityTracker = ViewabilityTracker.createWebViewTracker(webView);
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "createWebViewTracker failed", e);
            }
        }
    }

    public void createNativeSession(View view, Set<ViewabilityVendor> set) {
        Preconditions.checkUiThread();
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(set);
        if (this.mViewabilityTracker == null) {
            try {
                this.mViewabilityTracker = ViewabilityTracker.createNativeTracker(view, set);
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "createNativeTracker failed", e);
            }
        }
    }

    public void createVideoSession(View view, Set<ViewabilityVendor> set) {
        Preconditions.checkUiThread();
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(set);
        if (this.mViewabilityTracker == null) {
            try {
                this.mViewabilityTracker = ViewabilityTrackerVideo.createVastVideoTracker(view, set);
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "createVastVideoTracker failed", e);
            }
        }
    }

    public void startSession() {
        Preconditions.checkUiThread();
        try {
            if (this.mViewabilityTracker != null) {
                registerFriendlyObstruction((View) null, (ViewabilityObstruction) null);
                this.mViewabilityTracker.startTracking();
            }
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "startSession()", e);
        }
    }

    public boolean isTracking() {
        Preconditions.checkUiThread();
        ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
        if (viewabilityTracker == null) {
            return false;
        }
        return viewabilityTracker.isTracking();
    }

    public void trackImpression() {
        Preconditions.checkUiThread();
        try {
            ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
            if (viewabilityTracker != null) {
                viewabilityTracker.trackImpression();
            }
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "trackImpression()", e);
        }
    }

    public boolean hasImpressionOccurred() {
        ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
        if (viewabilityTracker != null) {
            return viewabilityTracker.hasImpressionOccurred();
        }
        return false;
    }

    public void registerTrackedView(View view) {
        ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
        if (viewabilityTracker != null) {
            viewabilityTracker.registerTrackedView(view);
        }
    }

    public void endSession() {
        Preconditions.checkUiThread();
        try {
            ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
            if (viewabilityTracker != null) {
                viewabilityTracker.stopTracking();
            }
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "stopTracking failed", e);
        }
    }

    public void registerFriendlyObstruction(View view, ViewabilityObstruction viewabilityObstruction) {
        Preconditions.checkUiThread();
        ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
        if (viewabilityTracker != null) {
            if (!(view == null || viewabilityObstruction == null)) {
                viewabilityTracker.registerFriendlyObstruction(view, viewabilityObstruction);
            }
            if (this.mObstructions.size() > 0) {
                viewabilityTracker.registerFriendlyObstructions(this.mObstructions);
                this.mObstructions.clear();
            }
        } else if (view != null && viewabilityObstruction != null) {
            try {
                this.mObstructions.add(new Pair(view, viewabilityObstruction));
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, e.getLocalizedMessage());
            }
        }
    }

    public void registerVideoObstruction(View view, ViewabilityObstruction viewabilityObstruction) {
        registerFriendlyObstruction(view, viewabilityObstruction);
    }

    public void onVideoPrepared(long j) {
        Preconditions.checkUiThread();
        try {
            ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
            if (viewabilityTracker != null) {
                viewabilityTracker.videoPrepared(((float) j) / 1000.0f);
            }
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "videoPrepared failed", e);
        }
    }

    public void recordVideoEvent(VideoEvent videoEvent, int i) {
        Preconditions.checkUiThread();
        Preconditions.checkNotNull(videoEvent);
        try {
            ViewabilityTracker viewabilityTracker = this.mViewabilityTracker;
            if (viewabilityTracker != null) {
                viewabilityTracker.trackVideo(videoEvent);
            }
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "trackVideo failed", e);
        }
    }

    @VisibleForTesting
    public static void setCreator(ExternalViewabilityManagerFactory externalViewabilityManagerFactory) {
        sCreator = externalViewabilityManagerFactory;
    }
}
