package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.C1222i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import com.mopub.mobileads.VastIconXmlManager;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.h0 */
public class C1313h0 extends C1279f {

    /* renamed from: m */
    C1222i f3158m = new C1222i(this);

    /* renamed from: n */
    C1222i f3159n = new C1222i(this);

    /* renamed from: o */
    C1222i f3160o = new C1222i(this);

    /* renamed from: p */
    C1222i f3161p = new C1222i(this);

    /* renamed from: q */
    C1222i f3162q = new C1222i(this);

    /* renamed from: r */
    C1222i f3163r = new C1222i(this);

    /* renamed from: s */
    protected float f3164s = 1.0f;

    /* renamed from: com.chartboost.sdk.impl.h0$a */
    public class C1314a extends C1279f.C1281b {

        /* renamed from: i */
        protected C1355o1 f3165i;

        /* renamed from: j */
        protected C1359p1 f3166j;

        /* renamed from: k */
        private boolean f3167k = false;

        /* renamed from: l */
        protected C1359p1 f3168l;

        /* renamed from: m */
        protected ImageView f3169m;

        /* renamed from: com.chartboost.sdk.impl.h0$a$a */
        class C1315a extends C1359p1 {
            C1315a(Context context, C1313h0 h0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo10432a(MotionEvent motionEvent) {
                C1314a.this.mo10438a(motionEvent.getX(), motionEvent.getY(), (float) C1314a.this.f3168l.getWidth(), (float) C1314a.this.f3168l.getHeight());
            }
        }

        /* renamed from: com.chartboost.sdk.impl.h0$a$b */
        class C1316b extends C1359p1 {
            C1316b(Context context) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo10432a(MotionEvent motionEvent) {
                C1314a.this.mo10439c();
            }
        }

        protected C1314a(Context context) {
            super(context);
            setBackgroundColor(0);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            C1284h a = C1284h.m3343a();
            C1355o1 o1Var = (C1355o1) a.mo10361a(new C1355o1(context));
            this.f3165i = o1Var;
            addView(o1Var, new RelativeLayout.LayoutParams(-1, -1));
            C1359p1 p1Var = (C1359p1) a.mo10361a(new C1315a(context, C1313h0.this));
            this.f3168l = p1Var;
            mo10353a((View) p1Var);
            this.f3168l.setContentDescription("CBAd");
            ImageView imageView = (ImageView) a.mo10361a(new ImageView(context));
            this.f3169m = imageView;
            imageView.setBackgroundColor(-16777216);
            addView(this.f3169m);
            addView(this.f3168l);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo10439c() {
            C1313h0.this.mo10329a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo10440d() {
            C1316b bVar = new C1316b(getContext());
            this.f3166j = bVar;
            bVar.setContentDescription("CBClose");
            addView(this.f3166j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10438a(float f, float f2, float f3, float f4) {
            C1313h0.this.mo10335a(C1217e.m2937a(C1217e.m2935a("x", (Object) Float.valueOf(f)), C1217e.m2935a("y", (Object) Float.valueOf(f2)), C1217e.m2935a("w", (Object) Float.valueOf(f3)), C1217e.m2935a("h", (Object) Float.valueOf(f4))));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10352a(int i, int i2) {
            int i3;
            int i4;
            if (!this.f3167k) {
                mo10440d();
                this.f3167k = true;
            }
            boolean b = CBUtility.m2921b(C1313h0.this.mo10341f());
            C1222i iVar = b ? C1313h0.this.f3158m : C1313h0.this.f3159n;
            C1222i iVar2 = b ? C1313h0.this.f3160o : C1313h0.this.f3161p;
            if (!iVar.mo10060e()) {
                C1313h0 h0Var = C1313h0.this;
                C1222i iVar3 = h0Var.f3158m;
                iVar = iVar == iVar3 ? h0Var.f3159n : iVar3;
            }
            if (!iVar2.mo10060e()) {
                C1313h0 h0Var2 = C1313h0.this;
                C1222i iVar4 = h0Var2.f3160o;
                iVar2 = iVar2 == iVar4 ? h0Var2.f3161p : iVar4;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            C1313h0.this.mo10436a(layoutParams, iVar, 1.0f);
            C1313h0.this.f3164s = Math.min(Math.min(((float) i) / ((float) layoutParams.width), ((float) i2) / ((float) layoutParams.height)), 1.0f);
            C1313h0 h0Var3 = C1313h0.this;
            float f = h0Var3.f3164s;
            layoutParams.width = (int) (((float) layoutParams.width) * f);
            layoutParams.height = (int) (((float) layoutParams.height) * f);
            Point b2 = h0Var3.mo10437b(b ? "frame-portrait" : "frame-landscape");
            layoutParams.leftMargin = Math.round((((float) (i - layoutParams.width)) / 2.0f) + ((((float) b2.x) / iVar.mo10054a()) * C1313h0.this.f3164s));
            layoutParams.topMargin = Math.round((((float) (i2 - layoutParams.height)) / 2.0f) + ((((float) b2.y) / iVar.mo10054a()) * C1313h0.this.f3164s));
            C1313h0.this.mo10436a(layoutParams2, iVar2, 1.0f);
            Point b3 = C1313h0.this.mo10437b(b ? "close-portrait" : "close-landscape");
            int i5 = b3.x;
            if (i5 == 0 && b3.y == 0) {
                i4 = layoutParams.leftMargin + layoutParams.width + Math.round(((float) (-layoutParams2.width)) / 2.0f);
                i3 = layoutParams.topMargin + Math.round(((float) (-layoutParams2.height)) / 2.0f);
            } else {
                int round = Math.round(((((float) layoutParams.leftMargin) + (((float) layoutParams.width) / 2.0f)) + ((float) i5)) - (((float) layoutParams2.width) / 2.0f));
                i3 = Math.round(((((float) layoutParams.topMargin) + (((float) layoutParams.height) / 2.0f)) + ((float) b3.y)) - (((float) layoutParams2.height) / 2.0f));
                i4 = round;
            }
            layoutParams2.leftMargin = Math.min(Math.max(0, i4), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, i3), i2 - layoutParams2.height);
            this.f3165i.setLayoutParams(layoutParams);
            this.f3166j.setLayoutParams(layoutParams2);
            this.f3165i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f3165i.mo10558a(iVar);
            this.f3166j.mo10569a(iVar2);
            C1222i iVar5 = b ? C1313h0.this.f3162q : C1313h0.this.f3163r;
            if (!iVar5.mo10060e()) {
                C1313h0 h0Var4 = C1313h0.this;
                C1222i iVar6 = h0Var4.f3162q;
                iVar5 = iVar5 == iVar6 ? h0Var4.f3163r : iVar6;
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            C1313h0 h0Var5 = C1313h0.this;
            h0Var5.mo10436a(layoutParams3, iVar5, h0Var5.f3164s);
            Point b4 = C1313h0.this.mo10437b(b ? "ad-portrait" : "ad-landscape");
            layoutParams3.leftMargin = Math.round((((float) (i - layoutParams3.width)) / 2.0f) + ((((float) b4.x) / iVar5.mo10054a()) * C1313h0.this.f3164s));
            layoutParams3.topMargin = Math.round((((float) (i2 - layoutParams3.height)) / 2.0f) + ((((float) b4.y) / iVar5.mo10054a()) * C1313h0.this.f3164s));
            this.f3169m.setLayoutParams(layoutParams3);
            this.f3168l.setLayoutParams(layoutParams3);
            this.f3168l.mo10568a(ImageView.ScaleType.FIT_CENTER);
            this.f3168l.mo10569a(iVar5);
        }

        /* renamed from: a */
        public void mo10351a() {
            super.mo10351a();
            this.f3165i = null;
            this.f3166j = null;
            this.f3168l = null;
            this.f3169m = null;
        }
    }

    public C1313h0(Context context, C1230c cVar, Handler handler, C1275d dVar) {
        super(context, cVar, handler, dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1279f.C1281b mo10328a(Context context) {
        return new C1314a(context);
    }

    /* renamed from: b */
    public boolean mo10337b(JSONObject jSONObject) {
        if (!super.mo10337b(jSONObject)) {
            return false;
        }
        if (this.f3002e.isNull("frame-portrait") || this.f3002e.isNull("close-portrait")) {
            this.f3007j = false;
        }
        if (this.f3002e.isNull("frame-landscape") || this.f3002e.isNull("close-landscape")) {
            this.f3008k = false;
        }
        if (this.f3002e.isNull("ad-portrait")) {
            this.f3007j = false;
        }
        if (this.f3002e.isNull("ad-landscape")) {
            this.f3008k = false;
        }
        if (this.f3159n.mo10055a("frame-landscape") && this.f3158m.mo10055a("frame-portrait") && this.f3161p.mo10055a("close-landscape") && this.f3160o.mo10055a("close-portrait") && this.f3163r.mo10055a("ad-landscape") && this.f3162q.mo10055a("ad-portrait")) {
            return true;
        }
        CBLogging.m2905b("ImageViewProtocol", "Error while downloading the assets");
        mo10331a(CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        return false;
    }

    /* renamed from: a */
    public void mo10436a(ViewGroup.LayoutParams layoutParams, C1222i iVar, float f) {
        if (iVar != null && iVar.mo10060e()) {
            layoutParams.width = (int) ((((float) iVar.mo10059d()) / iVar.mo10054a()) * f);
            layoutParams.height = (int) ((((float) iVar.mo10058c()) / iVar.mo10054a()) * f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Point mo10437b(String str) {
        JSONObject a = C1217e.m2936a(this.f3002e, str, VastIconXmlManager.OFFSET);
        if (a != null) {
            return new Point(a.optInt("x"), a.optInt("y"));
        }
        return new Point(0, 0);
    }

    /* renamed from: b */
    public void mo10336b() {
        super.mo10336b();
        this.f3159n = null;
        this.f3158m = null;
        this.f3161p = null;
        this.f3160o = null;
        this.f3163r = null;
        this.f3162q = null;
    }
}
