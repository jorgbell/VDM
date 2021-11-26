package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.C0623b;
import com.applovin.impl.sdk.C1107r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    private C0623b f122a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m192a((AppLovinAdSize) null, (String) null, (AppLovinSdk) null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m192a(appLovinAdSize, str, (AppLovinSdk) null, context, (AttributeSet) null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m192a(appLovinAdSize, str, appLovinSdk, context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m191a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    /* renamed from: a */
    private void m192a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            C0623b bVar = new C0623b();
            bVar.mo8084a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
            this.f122a = bVar;
            return;
        }
        m191a(attributeSet, context);
    }

    public void destroy() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8099f();
        }
    }

    @Deprecated
    public C0623b getAdViewController() {
        return this.f122a;
    }

    public AppLovinAdSize getSize() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            return bVar.mo8094b();
        }
        return null;
    }

    public String getZoneId() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            return bVar.mo8096c();
        }
        return null;
    }

    public void loadNextAd() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8080a();
        } else {
            C1107r.m2482g("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8101h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8102i();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8097d();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8088a(appLovinAd);
        }
    }

    public void resume() {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8098e();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8090a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8091a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8092a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        C0623b bVar = this.f122a;
        if (bVar != null) {
            bVar.mo8085a(appLovinAdViewEventListener);
        }
    }

    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "\", size=" + getSize() + '}';
    }
}
