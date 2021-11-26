package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1222i;

/* renamed from: com.chartboost.sdk.impl.p1 */
public abstract class C1359p1 extends RelativeLayout {

    /* renamed from: a */
    final C1362c f3344a;

    /* renamed from: b */
    private final Rect f3345b;

    /* renamed from: c */
    protected Button f3346c;

    /* renamed from: d */
    boolean f3347d;

    /* renamed from: com.chartboost.sdk.impl.p1$a */
    class C1360a implements View.OnTouchListener {
        C1360a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean a = C1359p1.this.mo10572a(view, motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    if (C1359p1.this.getVisibility() == 0 && C1359p1.this.isEnabled() && a) {
                        C1359p1.this.mo10432a(motionEvent);
                    }
                    C1359p1.this.f3344a.mo10575a(false);
                } else if (actionMasked == 2) {
                    C1359p1.this.f3344a.mo10575a(a);
                } else if (actionMasked == 3 || actionMasked == 4) {
                    C1359p1.this.f3344a.mo10575a(false);
                }
                return true;
            }
            C1359p1.this.f3344a.mo10575a(a);
            return a;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.p1$b */
    class C1361b implements View.OnClickListener {
        C1361b() {
        }

        public void onClick(View view) {
            C1359p1.this.mo10432a((MotionEvent) null);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.p1$c */
    private class C1362c extends C1355o1 {

        /* renamed from: c */
        private boolean f3350c;

        public C1362c(Context context) {
            super(context);
            this.f3350c = false;
            this.f3350c = false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10575a(boolean z) {
            if (!C1359p1.this.f3347d || !z) {
                if (this.f3350c) {
                    if (getDrawable() != null) {
                        getDrawable().clearColorFilter();
                    } else if (getBackground() != null) {
                        getBackground().clearColorFilter();
                    }
                    invalidate();
                    this.f3350c = false;
                }
            } else if (!this.f3350c) {
                if (getDrawable() != null) {
                    getDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                } else if (getBackground() != null) {
                    getBackground().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                }
                invalidate();
                this.f3350c = true;
            }
        }

        public boolean performClick() {
            super.performClick();
            return true;
        }
    }

    public C1359p1(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo10432a(MotionEvent motionEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10572a(View view, MotionEvent motionEvent) {
        view.getLocalVisibleRect(this.f3345b);
        this.f3345b.left += view.getPaddingLeft();
        this.f3345b.top += view.getPaddingTop();
        this.f3345b.right -= view.getPaddingRight();
        this.f3345b.bottom -= view.getPaddingBottom();
        return this.f3345b.contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C1359p1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3345b = new Rect();
        this.f3346c = null;
        this.f3347d = true;
        C1362c cVar = new C1362c(getContext());
        this.f3344a = cVar;
        cVar.setOnTouchListener(new C1360a());
        addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void mo10570a(String str) {
        if (str != null) {
            mo10567a().setText(str);
            addView(mo10567a(), new RelativeLayout.LayoutParams(-1, -1));
            this.f3344a.setVisibility(8);
            mo10571a(false);
            this.f3346c.setOnClickListener(new C1361b());
        } else if (this.f3346c != null) {
            removeView(mo10567a());
            this.f3346c = null;
            this.f3344a.setVisibility(0);
            mo10571a(true);
        }
    }

    /* renamed from: a */
    public TextView mo10567a() {
        if (this.f3346c == null) {
            Button button = new Button(getContext());
            this.f3346c = button;
            button.setGravity(17);
        }
        this.f3346c.postInvalidate();
        return this.f3346c;
    }

    /* renamed from: a */
    public void mo10569a(C1222i iVar) {
        if (iVar != null && iVar.mo10060e()) {
            this.f3344a.mo10558a(iVar);
            mo10570a((String) null);
        }
    }

    /* renamed from: a */
    public void mo10568a(ImageView.ScaleType scaleType) {
        this.f3344a.setScaleType(scaleType);
    }

    /* renamed from: a */
    public void mo10571a(boolean z) {
        this.f3347d = z;
    }
}
