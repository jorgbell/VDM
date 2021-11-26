package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.chartboost.sdk.C1277e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1230c;

/* renamed from: com.chartboost.sdk.impl.m1 */
public class C1342m1 {

    /* renamed from: a */
    private final Handler f3287a;

    /* renamed from: com.chartboost.sdk.impl.m1$a */
    class C1343a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ View f3288a;

        /* renamed from: b */
        final /* synthetic */ int f3289b;

        /* renamed from: c */
        final /* synthetic */ C1230c f3290c;

        /* renamed from: d */
        final /* synthetic */ Runnable f3291d;

        /* renamed from: e */
        final /* synthetic */ boolean f3292e;

        C1343a(View view, int i, C1230c cVar, Runnable runnable, boolean z) {
            this.f3288a = view;
            this.f3289b = i;
            this.f3290c = cVar;
            this.f3291d = runnable;
            this.f3292e = z;
        }

        public void onGlobalLayout() {
            this.f3288a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            C1342m1.this.mo10514a(this.f3289b, this.f3290c, this.f3291d, this.f3292e);
        }
    }

    public C1342m1(Handler handler) {
        this.f3287a = handler;
    }

    /* renamed from: a */
    public static Integer m3626a(int i) {
        if (i < 1 || i > 9) {
            return null;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    public void mo10513a(int i, C1230c cVar, Runnable runnable, C1277e eVar) {
        m3627a(i, cVar, runnable, true, eVar);
    }

    /* renamed from: a */
    public void mo10512a(int i, C1230c cVar, Runnable runnable) {
        mo10514a(i, cVar, runnable, false);
    }

    /* renamed from: a */
    private void m3627a(int i, C1230c cVar, Runnable runnable, boolean z, C1277e eVar) {
        C1371s1 s1Var;
        if (i == 7) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (cVar == null || (s1Var = cVar.f2759y) == null) {
            CBLogging.m2903a("AnimationManager", "Transition of impression canceled due to lack of container");
        } else {
            View c = s1Var.mo10603c();
            if (c == null) {
                eVar.mo10324e(cVar);
                CBLogging.m2903a("AnimationManager", "Transition of impression canceled due to lack of view");
                return;
            }
            ViewTreeObserver viewTreeObserver = c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new C1343a(c, i, cVar, runnable, z));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10514a(int i, C1230c cVar, Runnable runnable, boolean z) {
        C1371s1 s1Var;
        C1365q1 q1Var;
        ScaleAnimation scaleAnimation;
        TranslateAnimation translateAnimation;
        C1365q1 q1Var2;
        ScaleAnimation scaleAnimation2;
        TranslateAnimation translateAnimation2;
        AlphaAnimation alphaAnimation;
        int i2 = i;
        C1230c cVar2 = cVar;
        Runnable runnable2 = runnable;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 1.0f));
        if (cVar2 == null || (s1Var = cVar2.f2759y) == null) {
            CBLogging.m2903a("AnimationManager", "Transition of impression canceled due to lack of container");
            if (runnable2 != null) {
                runnable.run();
                return;
            }
            return;
        }
        View c = s1Var.mo10603c();
        if (c == null) {
            if (runnable2 != null) {
                runnable.run();
            }
            CBLogging.m2903a("AnimationManager", "Transition of impression canceled due to lack of view");
            return;
        }
        int i3 = cVar2.f2735a;
        if (i3 == 2 || i3 == 1) {
            c = cVar2.f2759y;
        }
        float width = (float) c.getWidth();
        float height = (float) c.getHeight();
        int i4 = cVar2.f2751q.f2709b;
        switch (i2) {
            case 1:
                if (z) {
                    q1Var = new C1365q1(-60.0f, 0.0f, width / 2.0f, height / 2.0f, true);
                } else {
                    q1Var = new C1365q1(0.0f, 60.0f, width / 2.0f, height / 2.0f, true);
                }
                q1Var.setDuration(500);
                q1Var.setFillAfter(true);
                animationSet.addAnimation(q1Var);
                if (z) {
                    scaleAnimation = new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f);
                } else {
                    scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f);
                }
                scaleAnimation.setDuration(500);
                scaleAnimation.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation);
                if (z) {
                    translateAnimation = new TranslateAnimation((-width) * 0.4f, 0.0f, height * 0.3f, 0.0f);
                } else {
                    translateAnimation = new TranslateAnimation(0.0f, width, 0.0f, height * 0.3f);
                }
                translateAnimation.setDuration(500);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                break;
            case 2:
                if (!z) {
                    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation3.setDuration(500);
                    scaleAnimation3.setStartOffset(0);
                    scaleAnimation3.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation3);
                    break;
                } else {
                    ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.6f, 1.1f, 0.6f, 1.1f, 1, 0.5f, 1, 0.5f);
                    float f = (float) 500;
                    float f2 = 0.6f * f;
                    scaleAnimation4.setDuration((long) Math.round(f2));
                    scaleAnimation4.setStartOffset(0);
                    scaleAnimation4.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation4);
                    ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.81818175f, 1.0f, 0.81818175f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation5.setDuration((long) Math.round(0.19999999f * f));
                    scaleAnimation5.setStartOffset((long) Math.round(f2));
                    scaleAnimation5.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation5);
                    ScaleAnimation scaleAnimation6 = new ScaleAnimation(1.0f, 1.1111112f, 1.0f, 1.1111112f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation6.setDuration((long) Math.round(0.099999964f * f));
                    scaleAnimation6.setStartOffset((long) Math.round(f * 0.8f));
                    scaleAnimation6.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation6);
                    break;
                }
            case 3:
                if (z) {
                    q1Var2 = new C1365q1(-60.0f, 0.0f, width / 2.0f, height / 2.0f, false);
                } else {
                    q1Var2 = new C1365q1(0.0f, 60.0f, width / 2.0f, height / 2.0f, false);
                }
                C1365q1 q1Var3 = q1Var2;
                q1Var3.setDuration(500);
                q1Var3.setFillAfter(true);
                animationSet.addAnimation(q1Var3);
                if (z) {
                    scaleAnimation2 = new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f);
                } else {
                    scaleAnimation2 = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f);
                }
                scaleAnimation2.setDuration(500);
                scaleAnimation2.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation2);
                if (z) {
                    translateAnimation2 = new TranslateAnimation(width * 0.3f, 0.0f, (-height) * 0.4f, 0.0f);
                } else {
                    translateAnimation2 = new TranslateAnimation(0.0f, width * 0.3f, 0.0f, height);
                }
                translateAnimation2.setDuration(500);
                translateAnimation2.setFillAfter(true);
                animationSet.addAnimation(translateAnimation2);
                break;
            case 4:
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, z ? -height : 0.0f, z ? 0.0f : -height);
                translateAnimation3.setDuration(500);
                translateAnimation3.setFillAfter(true);
                animationSet.addAnimation(translateAnimation3);
                break;
            case 5:
                float f3 = z ? height : 0.0f;
                if (z) {
                    height = 0.0f;
                }
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, f3, height);
                translateAnimation4.setDuration(500);
                translateAnimation4.setFillAfter(true);
                animationSet.addAnimation(translateAnimation4);
                break;
            case 6:
                if (z) {
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                }
                alphaAnimation.setDuration(500);
                alphaAnimation.setFillAfter(true);
                animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                break;
            case 8:
                float f4 = z ? width : 0.0f;
                if (z) {
                    width = 0.0f;
                }
                TranslateAnimation translateAnimation5 = new TranslateAnimation(f4, width, 0.0f, 0.0f);
                translateAnimation5.setDuration(500);
                translateAnimation5.setFillAfter(true);
                animationSet.addAnimation(translateAnimation5);
                break;
            case 9:
                TranslateAnimation translateAnimation6 = new TranslateAnimation(z ? -width : 0.0f, z ? 0.0f : -width, 0.0f, 0.0f);
                translateAnimation6.setDuration(500);
                translateAnimation6.setFillAfter(true);
                animationSet.addAnimation(translateAnimation6);
                break;
        }
        if (i2 == 7) {
            if (runnable2 != null) {
                runnable.run();
            }
            return;
        }
        if (runnable2 != null) {
            this.f3287a.postDelayed(runnable2, 500);
        }
        c.startAnimation(animationSet);
    }

    /* renamed from: a */
    public void mo10516a(boolean z, View view, C1228a aVar) {
        int i = aVar.f2709b;
        mo10515a(z, view, 500);
    }

    /* renamed from: a */
    public void mo10515a(boolean z, View view, long j) {
        view.clearAnimation();
        if (z) {
            view.setVisibility(0);
        }
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillBefore(true);
        view.startAnimation(alphaAnimation);
    }
}
