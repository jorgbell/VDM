package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

public class RadialCountdownWidget extends ImageView {
    private int mLastProgressMilliseconds;
    private RadialCountdownDrawable mRadialCountdownDrawable;

    public RadialCountdownWidget(Context context) {
        super(context);
        setId(View.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(50.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(3.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(3.0f, context);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(9.0f, context);
        RadialCountdownDrawable radialCountdownDrawable = new RadialCountdownDrawable(context);
        this.mRadialCountdownDrawable = radialCountdownDrawable;
        setImageDrawable(radialCountdownDrawable);
        setPadding(dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels2, dipsToIntPixels3, 0);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    public void calibrateAndMakeVisible(int i) {
        this.mRadialCountdownDrawable.setInitialCountdown(i);
        setVisibility(0);
    }

    public void updateCountdownProgress(int i, int i2) {
        if (i2 < this.mLastProgressMilliseconds) {
            return;
        }
        if (i - i2 < 0) {
            setVisibility(8);
            return;
        }
        this.mRadialCountdownDrawable.updateCountdownProgress(i2);
        this.mLastProgressMilliseconds = i2;
    }

    @Deprecated
    @VisibleForTesting
    public RadialCountdownDrawable getImageViewDrawable() {
        return this.mRadialCountdownDrawable;
    }

    @Deprecated
    @VisibleForTesting
    public void setImageViewDrawable(RadialCountdownDrawable radialCountdownDrawable) {
        this.mRadialCountdownDrawable = radialCountdownDrawable;
    }
}
