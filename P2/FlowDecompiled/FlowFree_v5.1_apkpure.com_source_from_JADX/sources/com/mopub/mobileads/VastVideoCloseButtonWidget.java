package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.base.C2620R;
import com.mopub.mobileads.resource.DrawableConstants;
import com.mopub.network.C2676Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

public class VastVideoCloseButtonWidget extends RelativeLayout {
    private final int mEdgePadding;
    /* access modifiers changed from: private */
    public boolean mHasCustomImage;
    private final ImageLoader mImageLoader;
    private final int mImagePadding;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    private final int mTextRightMargin;
    private TextView mTextView;
    private final int mWidgetHeight;

    public VastVideoCloseButtonWidget(Context context) {
        super(context);
        setId(View.generateViewId());
        this.mEdgePadding = Dips.dipsToIntPixels(6.0f, context);
        this.mImagePadding = Dips.dipsToIntPixels(5.0f, context);
        int dipsToIntPixels = Dips.dipsToIntPixels(50.0f, context);
        this.mWidgetHeight = dipsToIntPixels;
        this.mTextRightMargin = Dips.dipsToIntPixels(0.0f, context);
        this.mImageLoader = C2676Networking.getImageLoader(context);
        createImageView();
        createTextView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dipsToIntPixels);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    private void createImageView() {
        ImageView imageView = new ImageView(getContext());
        this.mImageView = imageView;
        imageView.setId(View.generateViewId());
        int i = this.mWidgetHeight;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11);
        this.mImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), C2620R.C2621drawable.ic_mopub_skip_button));
        ImageView imageView2 = this.mImageView;
        int i2 = this.mImagePadding;
        int i3 = this.mEdgePadding;
        imageView2.setPadding(i2, i2 + i3, i3 + i2, i2);
        addView(this.mImageView, layoutParams);
    }

    private void createTextView() {
        TextView textView = new TextView(getContext());
        this.mTextView = textView;
        textView.setSingleLine();
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setTextColor(-1);
        this.mTextView.setTextSize(20.0f);
        this.mTextView.setTypeface(DrawableConstants.CloseButton.TEXT_TYPEFACE);
        this.mTextView.setText("");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, this.mImageView.getId());
        this.mTextView.setPadding(0, this.mEdgePadding, 0, 0);
        layoutParams.setMargins(0, 0, this.mTextRightMargin, 0);
        addView(this.mTextView, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void updateCloseButtonText(String str) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCloseButtonIcon(final String str) {
        this.mImageLoader.get(str, new ImageLoader.ImageListener() {
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                Bitmap bitmap = imageContainer.getBitmap();
                if (bitmap != null) {
                    VastVideoCloseButtonWidget.this.mImageView.setImageBitmap(bitmap);
                    boolean unused = VastVideoCloseButtonWidget.this.mHasCustomImage = true;
                    return;
                }
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("%s returned null bitmap", new Object[]{str}));
            }

            public void onErrorResponse(VolleyError volleyError) {
                MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Failed to load image.", volleyError);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setOnTouchListenerToContent(View.OnTouchListener onTouchListener) {
        this.mImageView.setOnTouchListener(onTouchListener);
        this.mTextView.setOnTouchListener(onTouchListener);
    }

    /* access modifiers changed from: package-private */
    public void notifyVideoComplete() {
        if (!this.mHasCustomImage) {
            this.mImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), C2620R.C2621drawable.ic_mopub_close_button));
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @VisibleForTesting
    public ImageView getImageView() {
        return this.mImageView;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @VisibleForTesting
    public void setImageView(ImageView imageView) {
        this.mImageView = imageView;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @VisibleForTesting
    public TextView getTextView() {
        return this.mTextView;
    }
}
