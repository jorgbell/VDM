package com.applovin.impl.mediation.debugger.p028ui.p029a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.d */
public class C0823d extends Dialog {

    /* renamed from: a */
    private MaxAdView f1038a;

    /* renamed from: b */
    private MaxAdFormat f1039b;

    /* renamed from: c */
    private Activity f1040c;

    /* renamed from: d */
    private RelativeLayout f1041d;

    public C0823d(MaxAdView maxAdView, MaxAdFormat maxAdFormat, Activity activity) {
        super(activity, 16973840);
        this.f1038a = maxAdView;
        this.f1039b = maxAdFormat;
        this.f1040c = activity;
        requestWindowFeature(1);
    }

    public void dismiss() {
        this.f1041d.removeView(this.f1038a);
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f1040c, this.f1039b.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this.f1040c, this.f1039b.getSize().getHeight()));
        layoutParams.addRule(13);
        this.f1038a.setLayoutParams(layoutParams);
        int dpToPx = AppLovinSdkUtils.dpToPx(this.f1040c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f1040c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f1040c.getResources().getDrawable(C1199R.C1200drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground((Drawable) null);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0823d.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f1040c);
        this.f1041d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1041d.setBackgroundColor(Integer.MIN_VALUE);
        this.f1041d.addView(imageButton);
        this.f1041d.addView(this.f1038a);
        this.f1041d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0823d.this.dismiss();
            }
        });
        setContentView(this.f1041d);
    }
}
