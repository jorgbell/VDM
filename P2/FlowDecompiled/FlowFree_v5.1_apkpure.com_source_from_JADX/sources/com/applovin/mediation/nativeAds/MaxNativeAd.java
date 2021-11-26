package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.applovin.mediation.MaxAdFormat;

public class MaxNativeAd {

    /* renamed from: a */
    private final MaxAdFormat f2567a;

    /* renamed from: b */
    private final String f2568b;

    /* renamed from: c */
    private final String f2569c;

    /* renamed from: d */
    private final String f2570d;

    /* renamed from: e */
    private final MaxNativeAdImage f2571e;

    /* renamed from: f */
    private final View f2572f;

    /* renamed from: g */
    private final View f2573g;

    /* renamed from: h */
    private final View f2574h;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public MaxAdFormat f2575a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f2576b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f2577c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f2578d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public MaxNativeAdImage f2579e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public View f2580f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public View f2581g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public View f2582h;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f2575a = maxAdFormat;
            return this;
        }

        public Builder setBody(String str) {
            this.f2577c = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f2578d = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f2579e = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f2580f = view;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f2582h = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f2581g = view;
            return this;
        }

        public Builder setTitle(String str) {
            this.f2576b = str;
            return this;
        }
    }

    public static class MaxNativeAdImage {

        /* renamed from: a */
        private Drawable f2583a;

        /* renamed from: b */
        private Uri f2584b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f2583a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f2584b = uri;
        }

        public Drawable getDrawable() {
            return this.f2583a;
        }

        public Uri getUri() {
            return this.f2584b;
        }
    }

    private MaxNativeAd(Builder builder) {
        this.f2567a = builder.f2575a;
        this.f2568b = builder.f2576b;
        this.f2569c = builder.f2577c;
        this.f2570d = builder.f2578d;
        this.f2571e = builder.f2579e;
        this.f2572f = builder.f2580f;
        this.f2573g = builder.f2581g;
        this.f2574h = builder.f2582h;
    }

    public String getBody() {
        return this.f2569c;
    }

    public String getCallToAction() {
        return this.f2570d;
    }

    public MaxAdFormat getFormat() {
        return this.f2567a;
    }

    public MaxNativeAdImage getIcon() {
        return this.f2571e;
    }

    public View getIconView() {
        return this.f2572f;
    }

    public View getMediaView() {
        return this.f2574h;
    }

    public View getOptionsView() {
        return this.f2573g;
    }

    public String getTitle() {
        return this.f2568b;
    }
}
