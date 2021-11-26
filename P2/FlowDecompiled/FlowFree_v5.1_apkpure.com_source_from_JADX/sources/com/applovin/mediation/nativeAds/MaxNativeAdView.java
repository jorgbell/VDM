package com.applovin.mediation.nativeAds;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.sdk.C1107r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.C1199R;

@SuppressLint({"ViewConstructor"})
public class MaxNativeAdView extends FrameLayout {

    /* renamed from: a */
    private final MaxNativeAd f2585a;

    /* renamed from: b */
    private final TextView f2586b;

    /* renamed from: c */
    private final TextView f2587c;

    /* renamed from: d */
    private final ImageView f2588d;

    /* renamed from: e */
    private final FrameLayout f2589e;

    /* renamed from: f */
    private final FrameLayout f2590f;

    /* renamed from: g */
    private final FrameLayout f2591g;

    /* renamed from: h */
    private final Button f2592h;

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        super(activity);
        int i;
        MaxAdFormat format = maxNativeAd.getFormat();
        if (format == MaxAdFormat.BANNER) {
            i = "vertical_banner_template".equals(str) ? C1199R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? C1199R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? C1199R.layout.max_native_ad_vertical_media_banner_view : C1199R.layout.max_native_ad_banner_view;
        } else if (format == MaxAdFormat.LEADER) {
            i = "vertical_leader_template".equals(str) ? C1199R.layout.max_native_ad_vertical_leader_view : C1199R.layout.max_native_ad_leader_view;
        } else if (format == MaxAdFormat.MREC) {
            i = C1199R.layout.max_native_ad_mrec_view;
        } else {
            throw new IllegalArgumentException("Unsupported ad format: " + format);
        }
        addView(activity.getLayoutInflater().inflate(i, (ViewGroup) null));
        this.f2586b = (TextView) findViewById(C1199R.C1201id.native_title_text_view);
        this.f2587c = (TextView) findViewById(C1199R.C1201id.native_body_text_view);
        this.f2588d = (ImageView) findViewById(C1199R.C1201id.native_icon_image_view);
        this.f2589e = (FrameLayout) findViewById(C1199R.C1201id.native_icon_view);
        this.f2590f = (FrameLayout) findViewById(C1199R.C1201id.options_view);
        this.f2591g = (FrameLayout) findViewById(C1199R.C1201id.native_media_content_view);
        this.f2592h = (Button) findViewById(C1199R.C1201id.native_cta_button);
        this.f2585a = maxNativeAd;
        m2838a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2838a() {
        /*
            r4 = this;
            android.widget.TextView r0 = r4.f2586b
            com.applovin.mediation.nativeAds.MaxNativeAd r1 = r4.f2585a
            java.lang.String r1 = r1.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r4.f2587c
            if (r0 == 0) goto L_0x0018
            com.applovin.mediation.nativeAds.MaxNativeAd r1 = r4.f2585a
            java.lang.String r1 = r1.getBody()
            r0.setText(r1)
        L_0x0018:
            android.widget.Button r0 = r4.f2592h
            if (r0 == 0) goto L_0x0025
            com.applovin.mediation.nativeAds.MaxNativeAd r1 = r4.f2585a
            java.lang.String r1 = r1.getCallToAction()
            r0.setText(r1)
        L_0x0025:
            com.applovin.mediation.nativeAds.MaxNativeAd r0 = r4.f2585a
            com.applovin.mediation.nativeAds.MaxNativeAd$MaxNativeAdImage r0 = r0.getIcon()
            com.applovin.mediation.nativeAds.MaxNativeAd r1 = r4.f2585a
            android.view.View r1 = r1.getIconView()
            r2 = 8
            r3 = -1
            if (r0 == 0) goto L_0x0064
            android.graphics.drawable.Drawable r1 = r0.getDrawable()
            if (r1 == 0) goto L_0x0046
            android.widget.ImageView r1 = r4.f2588d
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            r1.setImageDrawable(r0)
            goto L_0x0079
        L_0x0046:
            android.net.Uri r1 = r0.getUri()
            if (r1 == 0) goto L_0x0074
            android.net.Uri r1 = r0.getUri()
            java.lang.String r1 = r1.toString()
            boolean r1 = com.applovin.sdk.AppLovinSdkUtils.isValidString(r1)
            if (r1 == 0) goto L_0x0074
            android.widget.ImageView r1 = r4.f2588d
            android.net.Uri r0 = r0.getUri()
            r1.setImageURI(r0)
            goto L_0x0079
        L_0x0064:
            if (r1 == 0) goto L_0x0074
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r0.<init>(r3, r3)
            r1.setLayoutParams(r0)
            android.widget.FrameLayout r0 = r4.f2589e
            r0.addView(r1)
            goto L_0x0079
        L_0x0074:
            android.widget.FrameLayout r0 = r4.f2589e
            r0.setVisibility(r2)
        L_0x0079:
            com.applovin.mediation.nativeAds.MaxNativeAd r0 = r4.f2585a
            android.view.View r0 = r0.getOptionsView()
            android.widget.FrameLayout r1 = r4.f2590f
            if (r1 == 0) goto L_0x0093
            if (r0 == 0) goto L_0x0093
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r3, r3)
            r0.setLayoutParams(r1)
            android.widget.FrameLayout r1 = r4.f2590f
            r1.addView(r0)
            goto L_0x0098
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            r1.setVisibility(r2)
        L_0x0098:
            com.applovin.mediation.nativeAds.MaxNativeAd r0 = r4.f2585a
            android.view.View r0 = r0.getMediaView()
            android.widget.FrameLayout r1 = r4.f2591g
            if (r1 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x00b2
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r3, r3)
            r0.setLayoutParams(r1)
            android.widget.FrameLayout r1 = r4.f2591g
            r1.addView(r0)
            goto L_0x00c1
        L_0x00b2:
            com.applovin.mediation.nativeAds.MaxNativeAd r0 = r4.f2585a
            com.applovin.mediation.MaxAdFormat r0 = r0.getFormat()
            com.applovin.mediation.MaxAdFormat r1 = com.applovin.mediation.MaxAdFormat.LEADER
            if (r0 != r1) goto L_0x00c1
            android.widget.FrameLayout r0 = r4.f2591g
            r0.setVisibility(r2)
        L_0x00c1:
            r4.m2839b()
            com.applovin.mediation.nativeAds.MaxNativeAdView$1 r0 = new com.applovin.mediation.nativeAds.MaxNativeAdView$1
            r0.<init>()
            r1 = 2000(0x7d0, double:9.88E-321)
            r4.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.mediation.nativeAds.MaxNativeAdView.m2838a():void");
    }

    /* renamed from: b */
    private void m2839b() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(C1199R.C1201id.inner_parent_layout);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (getViewTreeObserver().isAlive()) {
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        MaxNativeAdView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                        layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                        viewGroup.setLayoutParams(layoutParams);
                        return true;
                    }
                });
            }
        }
    }

    public MaxNativeAd getAd() {
        return this.f2585a;
    }

    public TextView getBodyTextView() {
        return this.f2587c;
    }

    public Button getCallToActionButton() {
        return this.f2592h;
    }

    public FrameLayout getIconContentView() {
        return this.f2589e;
    }

    public ImageView getIconImageView() {
        return this.f2588d;
    }

    public FrameLayout getMediaContentView() {
        return this.f2591g;
    }

    public FrameLayout getOptionsContentView() {
        return this.f2590f;
    }

    public TextView getTitleTextView() {
        return this.f2586b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            C1107r.m2483h("MaxAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
        }
    }
}
