package com.mopub.mraid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.sdk.AppLovinMediationProvider;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseWebViewViewability;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.network.C2676Networking;
import com.mopub.network.MoPubRequestUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MraidBridge {
    private boolean mAllowCustomClose;
    /* access modifiers changed from: private */
    public ViewGestureDetector mGestureDetector;
    private boolean mHasLoaded;
    /* access modifiers changed from: private */
    public MraidBridgeListener mMraidBridgeListener;
    private MraidWebView mMraidWebView;
    private final WebViewClient mMraidWebViewClient;
    private final PlacementType mPlacementType;

    public interface MraidBridgeListener {
        void onClose();

        boolean onConsoleMessage(ConsoleMessage consoleMessage);

        void onExpand(URI uri, boolean z) throws MraidCommandException;

        boolean onJsAlert(String str, JsResult jsResult);

        void onOpen(URI uri);

        void onPageFailedToLoad();

        void onPageLoaded();

        void onRenderProcessGone(MoPubErrorCode moPubErrorCode);

        void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException;

        void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException;

        void onUseCustomClose(boolean z);

        void onVisibilityChanged(boolean z);
    }

    MraidBridge(PlacementType placementType, boolean z) {
        this(placementType, new MraidNativeCommandHandler(), z);
    }

    @VisibleForTesting
    MraidBridge(PlacementType placementType, MraidNativeCommandHandler mraidNativeCommandHandler, boolean z) {
        this.mMraidWebViewClient = new MraidWebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return MraidBridge.this.handleShouldOverrideUrl(str);
            }

            public void onPageFinished(WebView webView, String str) {
                if (webView instanceof BaseWebViewViewability) {
                    ((BaseWebViewViewability) webView).setPageLoaded();
                }
                MraidBridge.this.handlePageFinished();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Error: " + str);
                super.onReceivedError(webView, i, str, str2);
            }

            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                MraidBridge.this.handleRenderProcessGone(renderProcessGoneDetail);
                return true;
            }
        };
        this.mPlacementType = placementType;
        this.mAllowCustomClose = z;
    }

    /* access modifiers changed from: package-private */
    public void setMraidBridgeListener(MraidBridgeListener mraidBridgeListener) {
        this.mMraidBridgeListener = mraidBridgeListener;
    }

    /* access modifiers changed from: package-private */
    public void attachView(MraidWebView mraidWebView) {
        this.mMraidWebView = mraidWebView;
        mraidWebView.getSettings().setJavaScriptEnabled(true);
        if (this.mPlacementType == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.mMraidWebView.setScrollContainer(false);
        this.mMraidWebView.setVerticalScrollBarEnabled(false);
        this.mMraidWebView.setHorizontalScrollBarEnabled(false);
        this.mMraidWebView.setBackgroundColor(0);
        this.mMraidWebView.setWebViewClient(this.mMraidWebViewClient);
        this.mMraidWebView.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (MraidBridge.this.mMraidBridgeListener != null) {
                    return MraidBridge.this.mMraidBridgeListener.onJsAlert(str2, jsResult);
                }
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (MraidBridge.this.mMraidBridgeListener != null) {
                    return MraidBridge.this.mMraidBridgeListener.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.mGestureDetector = new ViewGestureDetector(this.mMraidWebView.getContext());
        this.mMraidWebView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MraidBridge.this.mGestureDetector.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.mMraidWebView.setVisibilityChangedListener(new MraidWebView.OnVisibilityChangedListener() {
            public void onVisibilityChanged(boolean z) {
                if (MraidBridge.this.mMraidBridgeListener != null) {
                    MraidBridge.this.mMraidBridgeListener.onVisibilityChanged(z);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        MraidWebView mraidWebView = this.mMraidWebView;
        if (mraidWebView != null) {
            mraidWebView.destroy();
            this.mMraidWebView = null;
        }
    }

    public void setContentHtml(String str) {
        MraidWebView mraidWebView = this.mMraidWebView;
        if (mraidWebView == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.mHasLoaded = false;
        mraidWebView.loadDataWithBaseURL(C2676Networking.getScheme() + "://" + Constants.HOST + "/", str, "text/html", "UTF-8", (String) null);
    }

    public void setContentUrl(String str) {
        MraidWebView mraidWebView = this.mMraidWebView;
        if (mraidWebView == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.mHasLoaded = false;
        mraidWebView.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public void injectJavaScript(String str) {
        if (this.mMraidWebView == null) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        MoPubLog.SdkLogEvent sdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        MoPubLog.log(sdkLogEvent2, "Injecting Javascript into MRAID WebView:\n\t" + str);
        MraidWebView mraidWebView = this.mMraidWebView;
        mraidWebView.loadUrl("javascript:" + str);
    }

    private void fireErrorEvent(MraidJavascriptCommand mraidJavascriptCommand, String str) {
        injectJavaScript("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(mraidJavascriptCommand.toJavascriptString()) + ", " + JSONObject.quote(str) + ")");
    }

    private void fireNativeCommandCompleteEvent(MraidJavascriptCommand mraidJavascriptCommand) {
        injectJavaScript("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(mraidJavascriptCommand.toJavascriptString()) + ")");
    }

    public static class MraidWebView extends BaseWebViewViewability {
        private boolean mMraidViewable;
        private OnVisibilityChangedListener mOnVisibilityChangedListener;
        private VisibilityTracker mVisibilityTracker;

        public interface OnVisibilityChangedListener {
            void onVisibilityChanged(boolean z);
        }

        public MraidWebView(Context context) {
            super(context);
            if (Build.VERSION.SDK_INT <= 22) {
                this.mMraidViewable = getVisibility() == 0;
                return;
            }
            VisibilityTracker visibilityTracker = new VisibilityTracker(context);
            this.mVisibilityTracker = visibilityTracker;
            visibilityTracker.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() {
                public void onVisibilityChanged(List<View> list, List<View> list2) {
                    Preconditions.checkNotNull(list);
                    Preconditions.checkNotNull(list2);
                    MraidWebView mraidWebView = MraidWebView.this;
                    mraidWebView.setMraidViewable(list.contains(mraidWebView));
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void setVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.mOnVisibilityChangedListener = onVisibilityChangedListener;
        }

        /* access modifiers changed from: protected */
        public void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            VisibilityTracker visibilityTracker = this.mVisibilityTracker;
            boolean z = true;
            if (visibilityTracker == null) {
                if (i != 0) {
                    z = false;
                }
                setMraidViewable(z);
            } else if (i == 0) {
                visibilityTracker.clear();
                this.mVisibilityTracker.addView(view, this, 0, 0, 1);
            } else {
                visibilityTracker.removeView(this);
                setMraidViewable(false);
            }
        }

        /* access modifiers changed from: private */
        public void setMraidViewable(boolean z) {
            if (this.mMraidViewable != z) {
                this.mMraidViewable = z;
                OnVisibilityChangedListener onVisibilityChangedListener = this.mOnVisibilityChangedListener;
                if (onVisibilityChangedListener != null) {
                    onVisibilityChangedListener.onVisibilityChanged(z);
                }
            }
        }

        public boolean isMraidViewable() {
            return this.mMraidViewable;
        }

        public void destroy() {
            super.destroy();
            this.mVisibilityTracker = null;
            this.mOnVisibilityChangedListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean handleShouldOverrideUrl(String str) {
        MraidBridgeListener mraidBridgeListener;
        try {
            new URI(str);
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (AppLovinMediationProvider.MOPUB.equals(scheme)) {
                if ("failLoad".equals(host) && this.mPlacementType == PlacementType.INLINE && (mraidBridgeListener = this.mMraidBridgeListener) != null) {
                    mraidBridgeListener.onPageFailedToLoad();
                }
                return true;
            }
            if (isClicked() && !"mraid".equals(scheme)) {
                try {
                    parse = Uri.parse("mraid://open?url=" + URLEncoder.encode(str, "UTF-8"));
                    host = parse.getHost();
                    scheme = parse.getScheme();
                } catch (UnsupportedEncodingException unused) {
                    MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                    MoPubLog.log(sdkLogEvent, "Invalid MRAID URL encoding: " + str);
                    fireErrorEvent(MraidJavascriptCommand.OPEN, "Non-mraid URL is invalid");
                    return false;
                }
            }
            if (!"mraid".equals(scheme)) {
                return false;
            }
            MraidJavascriptCommand fromJavascriptString = MraidJavascriptCommand.fromJavascriptString(host);
            try {
                runCommand(fromJavascriptString, MoPubRequestUtils.getQueryParamMap(parse));
            } catch (MraidCommandException | IllegalArgumentException e) {
                fireErrorEvent(fromJavascriptString, e.getMessage());
            }
            fireNativeCommandCompleteEvent(fromJavascriptString);
            return true;
        } catch (URISyntaxException unused2) {
            MoPubLog.SdkLogEvent sdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent2, "Invalid MRAID URL: " + str);
            fireErrorEvent(MraidJavascriptCommand.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    public void handlePageFinished() {
        if (!this.mHasLoaded) {
            this.mHasLoaded = true;
            MraidBridgeListener mraidBridgeListener = this.mMraidBridgeListener;
            if (mraidBridgeListener != null) {
                mraidBridgeListener.onPageLoaded();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    @VisibleForTesting
    public void handleRenderProcessGone(RenderProcessGoneDetail renderProcessGoneDetail) {
        MoPubErrorCode moPubErrorCode = (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED : MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH;
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, moPubErrorCode);
        detach();
        MraidBridgeListener mraidBridgeListener = this.mMraidBridgeListener;
        if (mraidBridgeListener != null) {
            mraidBridgeListener.onRenderProcessGone(moPubErrorCode);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void runCommand(MraidJavascriptCommand mraidJavascriptCommand, Map<String, String> map) throws MraidCommandException {
        if (mraidJavascriptCommand.requiresClick(this.mPlacementType) && !isClicked()) {
            throw new MraidCommandException("Cannot execute this command unless the user clicks");
        } else if (this.mMraidBridgeListener == null) {
            throw new MraidCommandException("Invalid state to execute this command");
        } else if (this.mMraidWebView != null) {
            switch (C26525.$SwitchMap$com$mopub$mraid$MraidJavascriptCommand[mraidJavascriptCommand.ordinal()]) {
                case 1:
                    this.mMraidBridgeListener.onClose();
                    return;
                case 2:
                    int parseSize = parseSize(map.get("width"));
                    checkRange(parseSize, 0, 100000);
                    int parseSize2 = parseSize(map.get("height"));
                    checkRange(parseSize2, 0, 100000);
                    int parseSize3 = parseSize(map.get("offsetX"));
                    checkRange(parseSize3, -100000, 100000);
                    int parseSize4 = parseSize(map.get("offsetY"));
                    checkRange(parseSize4, -100000, 100000);
                    this.mMraidBridgeListener.onResize(parseSize, parseSize2, parseSize3, parseSize4, parseClosePosition(map.get("customClosePosition"), CloseableLayout.ClosePosition.TOP_RIGHT), parseBoolean(map.get("allowOffscreen"), true));
                    this.mMraidBridgeListener.onUseCustomClose(this.mAllowCustomClose);
                    return;
                case 3:
                    this.mMraidBridgeListener.onExpand(parseURI(map.get("url"), (URI) null), parseAllowCustomClose(map, this.mAllowCustomClose));
                    return;
                case 4:
                    this.mMraidBridgeListener.onUseCustomClose(parseAllowCustomClose(map, this.mAllowCustomClose));
                    return;
                case 5:
                    this.mMraidBridgeListener.onOpen(parseURI(map.get("url")));
                    return;
                case 6:
                    this.mMraidBridgeListener.onSetOrientationProperties(parseBoolean(map.get("allowOrientationChange")), parseOrientation(map.get("forceOrientation")));
                    return;
                case 7:
                case 8:
                case 9:
                    throw new MraidCommandException("Unsupported MRAID Javascript command");
                case 10:
                    throw new MraidCommandException("Unspecified MRAID Javascript command");
                default:
                    return;
            }
        } else {
            throw new MraidCommandException("The current WebView is being destroyed");
        }
    }

    /* renamed from: com.mopub.mraid.MraidBridge$5 */
    static /* synthetic */ class C26525 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mraid$MraidJavascriptCommand;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mopub.mraid.MraidJavascriptCommand[] r0 = com.mopub.mraid.MraidJavascriptCommand.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$mraid$MraidJavascriptCommand = r0
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.CLOSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.RESIZE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.EXPAND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.USE_CUSTOM_CLOSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.OPEN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.SET_ORIENTATION_PROPERTIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.PLAY_VIDEO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.STORE_PICTURE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.CREATE_CALENDAR_EVENT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$mopub$mraid$MraidJavascriptCommand     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mopub.mraid.MraidJavascriptCommand r1 = com.mopub.mraid.MraidJavascriptCommand.UNSPECIFIED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mraid.MraidBridge.C26525.<clinit>():void");
        }
    }

    private CloseableLayout.ClosePosition parseClosePosition(String str, CloseableLayout.ClosePosition closePosition) throws MraidCommandException {
        if (TextUtils.isEmpty(str)) {
            return closePosition;
        }
        if (str.equals("top-left")) {
            return CloseableLayout.ClosePosition.TOP_LEFT;
        }
        if (str.equals("top-right")) {
            return CloseableLayout.ClosePosition.TOP_RIGHT;
        }
        if (str.equals("center")) {
            return CloseableLayout.ClosePosition.CENTER;
        }
        if (str.equals("bottom-left")) {
            return CloseableLayout.ClosePosition.BOTTOM_LEFT;
        }
        if (str.equals("bottom-right")) {
            return CloseableLayout.ClosePosition.BOTTOM_RIGHT;
        }
        if (str.equals("top-center")) {
            return CloseableLayout.ClosePosition.TOP_CENTER;
        }
        if (str.equals("bottom-center")) {
            return CloseableLayout.ClosePosition.BOTTOM_CENTER;
        }
        throw new MraidCommandException("Invalid close position: " + str);
    }

    private int parseSize(String str) throws MraidCommandException {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new MraidCommandException("Invalid numeric parameter: " + str);
        }
    }

    private MraidOrientation parseOrientation(String str) throws MraidCommandException {
        if ("portrait".equals(str)) {
            return MraidOrientation.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return MraidOrientation.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return MraidOrientation.NONE;
        }
        throw new MraidCommandException("Invalid orientation: " + str);
    }

    private static boolean parseAllowCustomClose(Map<String, String> map, boolean z) throws MraidCommandException {
        return parseBoolean(map.get("shouldUseCustomClose"), false) & z;
    }

    private int checkRange(int i, int i2, int i3) throws MraidCommandException {
        if (i >= i2 && i <= i3) {
            return i;
        }
        throw new MraidCommandException("Integer parameter out of range: " + i);
    }

    private static boolean parseBoolean(String str, boolean z) throws MraidCommandException {
        return str == null ? z : parseBoolean(str);
    }

    private static boolean parseBoolean(String str) throws MraidCommandException {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new MraidCommandException("Invalid boolean parameter: " + str);
    }

    private URI parseURI(String str, URI uri) throws MraidCommandException {
        return str == null ? uri : parseURI(str);
    }

    private URI parseURI(String str) throws MraidCommandException {
        if (str != null) {
            try {
                return new URI(str);
            } catch (URISyntaxException unused) {
                throw new MraidCommandException("Invalid URL parameter: " + str);
            }
        } else {
            throw new MraidCommandException("Parameter cannot be null");
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyViewability(boolean z) {
        injectJavaScript("mraidbridge.setIsViewable(" + z + ")");
    }

    /* access modifiers changed from: package-private */
    public void notifyPlacementType(PlacementType placementType) {
        injectJavaScript("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    /* access modifiers changed from: package-private */
    public void notifyViewState(ViewState viewState) {
        injectJavaScript("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    /* access modifiers changed from: package-private */
    public void notifySupports(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        injectJavaScript("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + ")");
    }

    private String stringifyRect(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    private String stringifySize(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    public void notifyScreenMetrics(MraidScreenMetrics mraidScreenMetrics) {
        injectJavaScript("mraidbridge.setScreenSize(" + stringifySize(mraidScreenMetrics.getScreenRectDips()) + ");mraidbridge.setMaxSize(" + stringifySize(mraidScreenMetrics.getRootViewRectDips()) + ");mraidbridge.setCurrentPosition(" + stringifyRect(mraidScreenMetrics.getCurrentAdRectDips()) + ");mraidbridge.setDefaultPosition(" + stringifyRect(mraidScreenMetrics.getDefaultAdRectDips()) + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.notifySizeChangeEvent(");
        sb.append(stringifySize(mraidScreenMetrics.getCurrentAdRectDips()));
        sb.append(")");
        injectJavaScript(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void notifyReady() {
        injectJavaScript("mraidbridge.notifyReadyEvent();");
    }

    /* access modifiers changed from: package-private */
    public boolean isClicked() {
        ViewGestureDetector viewGestureDetector = this.mGestureDetector;
        return viewGestureDetector != null && viewGestureDetector.isClicked();
    }

    /* access modifiers changed from: package-private */
    public boolean isViewable() {
        MraidWebView mraidWebView = this.mMraidWebView;
        return mraidWebView != null && mraidWebView.isMraidViewable();
    }

    /* access modifiers changed from: package-private */
    public boolean isAttached() {
        return this.mMraidWebView != null;
    }

    /* access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.mHasLoaded;
    }
}
