package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.chartboost.sdk.impl.q1 */
public final class C1365q1 extends Animation {

    /* renamed from: a */
    private final float f3361a;

    /* renamed from: b */
    private final float f3362b;

    /* renamed from: c */
    private final float f3363c;

    /* renamed from: d */
    private final float f3364d;

    /* renamed from: e */
    private boolean f3365e = true;

    /* renamed from: f */
    private Camera f3366f;

    public C1365q1(float f, float f2, float f3, float f4, boolean z) {
        this.f3361a = f;
        this.f3362b = f2;
        this.f3363c = f3;
        this.f3364d = f4;
        this.f3365e = z;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f3361a;
        float f3 = f2 + ((this.f3362b - f2) * f);
        Camera camera = this.f3366f;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f3365e) {
            camera.rotateY(f3);
        } else {
            camera.rotateX(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.f3363c, -this.f3364d);
        matrix.postTranslate(this.f3363c, this.f3364d);
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f3366f = new Camera();
    }
}
