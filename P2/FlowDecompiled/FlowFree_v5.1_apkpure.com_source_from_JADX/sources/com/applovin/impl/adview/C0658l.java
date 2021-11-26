package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C0651i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.l */
class C0658l extends Dialog implements C0657k {

    /* renamed from: a */
    private final Activity f559a;

    /* renamed from: b */
    private final C1062k f560b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1107r f561c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0638d f562d;

    /* renamed from: e */
    private final C0924a f563e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RelativeLayout f564f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0651i f565g;

    C0658l(C0924a aVar, C0638d dVar, Activity activity, C1062k kVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (dVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f560b = kVar;
            this.f561c = kVar.mo9411z();
            this.f559a = activity;
            this.f562d = dVar;
            this.f563e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* renamed from: a */
    private int m642a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f559a, i);
    }

    /* renamed from: a */
    private void m644a(C0651i.C0652a aVar) {
        if (this.f565g != null) {
            this.f561c.mo9587d("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        C0651i a = C0651i.m623a(aVar, this.f559a);
        this.f565g = a;
        a.setVisibility(8);
        this.f565g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0658l.this.m647c();
            }
        });
        this.f565g.setClickable(false);
        int a2 = m642a(((Integer) this.f560b.mo9350a(C0965b.f1640bL)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(10);
        C1062k kVar = this.f560b;
        C0965b bVar = C0965b.f1643bO;
        int i = 9;
        layoutParams.addRule(((Boolean) kVar.mo9350a(bVar)).booleanValue() ? 9 : 11);
        this.f565g.mo8189a(a2);
        int a3 = m642a(((Integer) this.f560b.mo9350a(C0965b.f1642bN)).intValue());
        int a4 = m642a(((Integer) this.f560b.mo9350a(C0965b.f1641bM)).intValue());
        layoutParams.setMargins(a4, a3, a4, 0);
        this.f564f.addView(this.f565g, layoutParams);
        this.f565g.bringToFront();
        int a5 = m642a(((Integer) this.f560b.mo9350a(C0965b.f1644bP)).intValue());
        View view = new View(this.f559a);
        view.setBackgroundColor(0);
        int i2 = a2 + a5;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        if (!((Boolean) this.f560b.mo9350a(bVar)).booleanValue()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a4 - m642a(5), a3 - m642a(5), a4 - m642a(5), 0);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C0658l.this.f565g.isClickable()) {
                    C0658l.this.f565g.performClick();
                }
            }
        });
        this.f564f.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m646b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f562d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f559a);
        this.f564f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f564f.setBackgroundColor(-1157627904);
        this.f564f.addView(this.f562d);
        if (!this.f563e.mo8961m()) {
            m644a(this.f563e.mo8962n());
            m649d();
        }
        setContentView(this.f564f);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m647c() {
        this.f562d.mo8129a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                C0658l.this.dismiss();
            }
        });
    }

    /* renamed from: d */
    private void m649d() {
        this.f559a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C0658l.this.f565g == null) {
                        C0658l.this.m647c();
                    }
                    C0658l.this.f565g.setVisibility(0);
                    C0658l.this.f565g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            C0658l.this.f565g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    C0658l.this.f565g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    C0658l.this.f561c.mo9585b("ExpandedAdDialog", "Unable to fade in close button", th);
                    C0658l.this.m647c();
                }
            }
        });
    }

    /* renamed from: a */
    public C0924a mo8202a() {
        return this.f563e;
    }

    public void dismiss() {
        C0981d statsManagerHelper = this.f562d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo9179e();
        }
        this.f559a.runOnUiThread(new Runnable() {
            public void run() {
                C0658l.this.f564f.removeView(C0658l.this.f562d);
                C0658l.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.f562d.mo8129a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                C0658l.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m646b();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f559a.getWindow().getAttributes().flags, this.f559a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
                return;
            }
            this.f561c.mo9588e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f561c.mo9585b("ExpandedAdDialog", "Setting window flags failed.", th);
        }
    }
}
