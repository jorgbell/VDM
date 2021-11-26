package com.noodlecake.ads;

import android.app.Activity;
import android.os.Handler;
import com.noodlecake.lib.UIKit;
import java.util.Map;

public class InterstitialController {
    private static InterstitialController instance;
    public Activity context;
    /* access modifiers changed from: private */
    public IInterstitialProvider moPub = null;

    private InterstitialController(Activity activity, boolean z, Map<String, String> map, String str, String str2) {
        this.context = activity;
        this.moPub = new MoPubInterstitialBridge(activity, z, map, str, str2);
    }

    private void onStartReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onStart();
        }
    }

    private void onRestartReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onRestart();
        }
    }

    private void onCreateReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onCreate();
        }
    }

    public void onDestroyReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onDestroy();
            this.moPub = null;
        }
        instance = null;
    }

    private void onStopReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onStop();
        }
    }

    private void onPauseReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onPause();
        }
    }

    private void onResumeReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            iInterstitialProvider.onResume();
        }
    }

    private boolean onBackPressedReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            return iInterstitialProvider.onBackPressed();
        }
        return false;
    }

    private void preloadInterstitialReal(final String str) {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (InterstitialController.this.moPub != null) {
                        InterstitialController.this.moPub.preloadInterstitial(str);
                    }
                }
            });
        }
    }

    private boolean hasPreloadedInterstitialReal(String str) {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            return iInterstitialProvider.hasPreloadedInterstitial(str);
        }
        return false;
    }

    private void showInterstitialReal(final String str, final boolean z) {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (InterstitialController.this.moPub != null) {
                        InterstitialController.this.moPub.showInterstitial(str, z);
                    }
                }
            });
        }
    }

    private void preloadRewardedVideoReal() {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (InterstitialController.this.moPub != null) {
                        InterstitialController.this.moPub.preloadRewardedVideo();
                    }
                }
            });
        }
    }

    private boolean hasPreloadedRewardedVideoReal() {
        IInterstitialProvider iInterstitialProvider = this.moPub;
        if (iInterstitialProvider != null) {
            return iInterstitialProvider.hasPreloadedRewardedVideo();
        }
        return false;
    }

    private void showRewardedVideoReal() {
        Handler handler = UIKit.appHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (InterstitialController.this.moPub != null) {
                        InterstitialController.this.moPub.showRewardedVideo();
                    }
                }
            });
        }
    }

    public static void init(Activity activity, boolean z, Map<String, String> map, String str, String str2) {
        if (instance == null) {
            instance = new InterstitialController(activity, z, map, str, str2);
        }
    }

    public static void preloadInterstitial(String str) {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.preloadInterstitialReal(str);
        }
    }

    public static boolean hasPreloadedInterstitial(String str) {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            return interstitialController.hasPreloadedInterstitialReal(str);
        }
        return false;
    }

    public static void showInterstitial(String str, boolean z) {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.showInterstitialReal(str, z);
        }
    }

    public static void preloadRewardedVideo() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.preloadRewardedVideoReal();
        }
    }

    public static boolean hasPreloadedRewardedVideo() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            return interstitialController.hasPreloadedRewardedVideoReal();
        }
        return false;
    }

    public static void showRewardedVideo() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.showRewardedVideoReal();
        }
    }

    public static void onCreate() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onCreateReal();
        }
    }

    public static void onDestroy() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onDestroyReal();
        }
    }

    public static void onStart() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onStartReal();
        }
    }

    public static void onRestart() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onRestartReal();
        }
    }

    public static void onPause() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onPauseReal();
        }
    }

    public static void onResume() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onResumeReal();
        }
    }

    public static void onStop() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            interstitialController.onStopReal();
        }
    }

    public static boolean onBackPressed() {
        InterstitialController interstitialController = instance;
        if (interstitialController != null) {
            return interstitialController.onBackPressedReal();
        }
        return false;
    }
}
