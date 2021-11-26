package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.mobileads.BaseHtmlWebView;
import java.util.EnumSet;

class HtmlWebViewClient extends WebViewClient {
    private final EnumSet<UrlAction> SUPPORTED_URL_ACTIONS = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, new UrlAction[]{UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    /* access modifiers changed from: private */
    public BaseHtmlWebView.BaseWebViewListener mBaseWebViewListener;
    private final Context mContext;
    private final String mDspCreativeId;
    /* access modifiers changed from: private */
    public final BaseHtmlWebView mHtmlWebView;

    HtmlWebViewClient(BaseHtmlWebView baseHtmlWebView, BaseHtmlWebView.BaseWebViewListener baseWebViewListener, String str) {
        this.mHtmlWebView = baseHtmlWebView;
        this.mDspCreativeId = str;
        this.mContext = baseHtmlWebView.getContext();
        this.mBaseWebViewListener = baseWebViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        new UrlHandler.Builder().withDspCreativeId(this.mDspCreativeId).withSupportedUrlActions(this.SUPPORTED_URL_ACTIONS).withResultActions(new UrlHandler.ResultActions() {
            public void urlHandlingFailed(String str, UrlAction urlAction) {
            }

            public void urlHandlingSucceeded(String str, UrlAction urlAction) {
                if (HtmlWebViewClient.this.mHtmlWebView.wasClicked()) {
                    if (HtmlWebViewClient.this.mBaseWebViewListener != null) {
                        HtmlWebViewClient.this.mBaseWebViewListener.onClicked();
                    }
                    HtmlWebViewClient.this.mHtmlWebView.onResetUserClick();
                }
            }
        }).withMoPubSchemeListener(new UrlHandler.MoPubSchemeListener() {
            public void onFinishLoad() {
                HtmlWebViewClient.this.mHtmlWebView.setPageLoaded();
                if (HtmlWebViewClient.this.mBaseWebViewListener != null) {
                    HtmlWebViewClient.this.mBaseWebViewListener.onLoaded(HtmlWebViewClient.this.mHtmlWebView);
                }
            }

            public void onClose() {
                if (HtmlWebViewClient.this.mBaseWebViewListener != null) {
                    HtmlWebViewClient.this.mBaseWebViewListener.onClose();
                }
            }

            public void onFailLoad() {
                HtmlWebViewClient.this.mHtmlWebView.stopLoading();
                if (HtmlWebViewClient.this.mBaseWebViewListener != null) {
                    HtmlWebViewClient.this.mBaseWebViewListener.onFailedToLoad(MoPubErrorCode.HTML_LOAD_ERROR);
                }
            }

            public void onCrash() {
                if (HtmlWebViewClient.this.mBaseWebViewListener != null) {
                    HtmlWebViewClient.this.mBaseWebViewListener.onFailed();
                }
            }
        }).build().handleUrl(this.mContext, str, this.mHtmlWebView.wasClicked());
        return true;
    }
}
