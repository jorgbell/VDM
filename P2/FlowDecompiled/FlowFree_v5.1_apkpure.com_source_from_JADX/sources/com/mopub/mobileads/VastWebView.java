package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.C2676Networking;

public class VastWebView extends BaseWebView {
    VastWebViewClickListener mVastWebViewClickListener;

    interface VastWebViewClickListener {
        void onVastWebViewClick();
    }

    VastWebView(Context context) {
        super(context);
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        setBackgroundColor(0);
        setOnTouchListener(new VastWebViewOnTouchListener());
        setId(View.generateViewId());
    }

    /* access modifiers changed from: package-private */
    public void loadData(String str) {
        loadDataWithBaseURL(C2676Networking.getScheme() + "://" + Constants.HOST + "/", str, "text/html", "utf-8", (String) null);
    }

    /* access modifiers changed from: package-private */
    public void setVastWebViewClickListener(VastWebViewClickListener vastWebViewClickListener) {
        this.mVastWebViewClickListener = vastWebViewClickListener;
    }

    private void disableScrollingAndZoom() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    static VastWebView createView(Context context, VastResource vastResource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastResource);
        VastWebView vastWebView = new VastWebView(context);
        vastResource.initializeWebView(vastWebView);
        return vastWebView;
    }

    class VastWebViewOnTouchListener implements View.OnTouchListener {
        private boolean mClickStarted;

        VastWebViewOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mClickStarted = true;
            } else if (action != 1 || !this.mClickStarted) {
                return false;
            } else {
                this.mClickStarted = false;
                VastWebViewClickListener vastWebViewClickListener = VastWebView.this.mVastWebViewClickListener;
                if (vastWebViewClickListener != null) {
                    vastWebViewClickListener.onVastWebViewClick();
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @VisibleForTesting
    public VastWebViewClickListener getVastWebViewClickListener() {
        return this.mVastWebViewClickListener;
    }
}
