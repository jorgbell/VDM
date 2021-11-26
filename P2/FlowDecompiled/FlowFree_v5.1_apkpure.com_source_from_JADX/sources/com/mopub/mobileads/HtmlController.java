package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.BaseHtmlWebView;

public class HtmlController extends MoPubWebViewController {
    private BaseHtmlWebView.BaseWebViewListener mHtmlWebViewListener = new HtmlWebViewListener();

    public HtmlController(Context context, String str) {
        super(context, str);
        this.mDefaultAdContainer.setLayoutParams(getLayoutParams());
    }

    /* access modifiers changed from: protected */
    public BaseWebView createWebView() {
        HtmlWebView htmlWebView = new HtmlWebView(this.mContext);
        AdViewController.setShouldHonorServerDimensions(htmlWebView);
        htmlWebView.init(this.mHtmlWebViewListener, this.mDspCreativeId);
        return htmlWebView;
    }

    /* access modifiers changed from: protected */
    public void doFillContent(String str) {
        ((HtmlWebView) this.mWebView).loadHtmlResponse(str);
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        super.destroy();
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.destroy();
            this.mWebView = null;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams getLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2, 17);
    }

    public View getAdContainer() {
        BaseWebView baseWebView = this.mWebView;
        return baseWebView != null ? baseWebView : this.mDefaultAdContainer;
    }

    class HtmlWebViewListener implements BaseHtmlWebView.BaseWebViewListener {
        HtmlWebViewListener() {
        }

        public void onLoaded(View view) {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onLoaded(view);
            }
        }

        public void onFailedToLoad(MoPubErrorCode moPubErrorCode) {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onFailedToLoad(MoPubErrorCode.HTML_LOAD_ERROR);
            }
        }

        public void onFailed() {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onFailed();
            }
        }

        public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onRenderProcessGone(moPubErrorCode);
            }
        }

        public void onClicked() {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onClicked();
            }
        }

        public void onExpand() {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onExpand();
            }
        }

        public void onResize(boolean z) {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onResize(z);
            }
        }

        public void onClose() {
            BaseHtmlWebView.BaseWebViewListener baseWebViewListener = HtmlController.this.mBaseWebViewListener;
            if (baseWebViewListener != null) {
                baseWebViewListener.onClose();
            }
        }
    }

    @VisibleForTesting
    public void setWebView(BaseWebView baseWebView) {
        this.mWebView = baseWebView;
    }

    @VisibleForTesting
    public BaseWebView getWebView() {
        return this.mWebView;
    }
}
