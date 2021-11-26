package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1222i;

/* renamed from: com.chartboost.sdk.impl.o1 */
public class C1355o1 extends ImageView {

    /* renamed from: a */
    private C1222i f3337a = null;

    /* renamed from: b */
    protected TextView f3338b = null;

    public C1355o1(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo10558a(C1222i iVar) {
        if (iVar != null && iVar.mo10060e() && this.f3337a != iVar) {
            this.f3337a = iVar;
            setImageDrawable(new BitmapDrawable(iVar.mo10057b()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo10557a(canvas);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f3337a = null;
        setImageDrawable(new BitmapDrawable(bitmap));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10557a(Canvas canvas) {
        TextView textView = this.f3338b;
        if (textView != null) {
            textView.layout(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f3338b.setEnabled(isEnabled());
            this.f3338b.setSelected(isSelected());
            if (isFocused()) {
                this.f3338b.requestFocus();
            } else {
                this.f3338b.clearFocus();
            }
            this.f3338b.setPressed(isPressed());
            this.f3338b.draw(canvas);
        }
    }
}
