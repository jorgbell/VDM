package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class VideoCtaButtonWidget extends ImageView {
    private CtaButtonDrawable mCtaButtonDrawable;
    private boolean mHasClickthroughUrl;
    private boolean mHasCompanionAd;
    private boolean mIsVideoComplete;
    private boolean mIsVideoSkippable;
    private final RelativeLayout.LayoutParams mLayoutParams;

    public VideoCtaButtonWidget(Context context, boolean z, boolean z2) {
        super(context);
        this.mHasCompanionAd = z;
        this.mHasClickthroughUrl = z2;
        setId(View.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(150.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(38.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        CtaButtonDrawable ctaButtonDrawable = new CtaButtonDrawable(context);
        this.mCtaButtonDrawable = ctaButtonDrawable;
        setImageDrawable(ctaButtonDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.mLayoutParams = layoutParams;
        layoutParams.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        updateLayoutAndVisibility();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateLayoutAndVisibility();
    }

    /* access modifiers changed from: package-private */
    public void updateCtaText(String str) {
        this.mCtaButtonDrawable.setCtaText(str);
    }

    /* access modifiers changed from: package-private */
    public void notifyVideoSkippable() {
        this.mIsVideoSkippable = true;
        updateLayoutAndVisibility();
    }

    /* access modifiers changed from: package-private */
    public void notifyVideoComplete() {
        this.mIsVideoSkippable = true;
        this.mIsVideoComplete = true;
        updateLayoutAndVisibility();
    }

    private void updateLayoutAndVisibility() {
        if (!this.mHasClickthroughUrl) {
            setVisibility(8);
        } else if (!this.mIsVideoSkippable) {
            setVisibility(4);
        } else if (!this.mIsVideoComplete || !this.mHasCompanionAd) {
            setLayoutParams(this.mLayoutParams);
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @VisibleForTesting
    public String getCtaText() {
        return this.mCtaButtonDrawable.getCtaText();
    }
}
