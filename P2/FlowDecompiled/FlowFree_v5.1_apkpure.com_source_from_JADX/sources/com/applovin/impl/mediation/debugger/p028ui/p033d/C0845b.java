package com.applovin.impl.mediation.debugger.p028ui.p033d;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.b */
public class C0845b {

    /* renamed from: a */
    public TextView f1111a;

    /* renamed from: b */
    public TextView f1112b;

    /* renamed from: c */
    public ImageView f1113c;

    /* renamed from: d */
    public ImageView f1114d;

    /* renamed from: e */
    private C0846c f1115e;

    /* renamed from: f */
    private int f1116f;

    /* renamed from: a */
    public int mo8678a() {
        return this.f1116f;
    }

    /* renamed from: a */
    public void mo8679a(int i) {
        this.f1116f = i;
    }

    /* renamed from: a */
    public void mo8680a(C0846c cVar) {
        this.f1115e = cVar;
        this.f1111a.setText(cVar.mo8684k());
        this.f1111a.setTextColor(cVar.mo8687n());
        if (this.f1112b != null) {
            if (!TextUtils.isEmpty(cVar.mo8660a_())) {
                this.f1112b.setTypeface((Typeface) null, 0);
                this.f1112b.setVisibility(0);
                this.f1112b.setText(cVar.mo8660a_());
                this.f1112b.setTextColor(cVar.mo8638c());
                if (cVar.mo8661b_()) {
                    this.f1112b.setTypeface((Typeface) null, 1);
                }
            } else {
                this.f1112b.setVisibility(8);
            }
        }
        if (this.f1113c != null) {
            if (cVar.mo8656e() > 0) {
                this.f1113c.setImageResource(cVar.mo8656e());
                this.f1113c.setColorFilter(cVar.mo8688o());
                this.f1113c.setVisibility(0);
            } else {
                this.f1113c.setVisibility(8);
            }
        }
        if (this.f1114d == null) {
            return;
        }
        if (cVar.mo8657f() > 0) {
            this.f1114d.setImageResource(cVar.mo8657f());
            this.f1114d.setColorFilter(cVar.mo8658g());
            this.f1114d.setVisibility(0);
            return;
        }
        this.f1114d.setVisibility(8);
    }

    /* renamed from: b */
    public C0846c mo8681b() {
        return this.f1115e;
    }
}
