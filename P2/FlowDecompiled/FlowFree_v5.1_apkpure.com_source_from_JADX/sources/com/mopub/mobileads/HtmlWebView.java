package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.BaseHtmlWebView;

public class HtmlWebView extends BaseHtmlWebView {
    public HtmlWebView(Context context) {
        super(context);
    }

    public void init(BaseHtmlWebView.BaseWebViewListener baseWebViewListener, String str) {
        super.init();
        setWebViewClient(new HtmlWebViewClient(this, baseWebViewListener, str));
    }
}
