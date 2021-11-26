package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1121i;
import com.applovin.impl.sdk.utils.C1152l;
import com.applovin.impl.sdk.utils.C1157p;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.l */
public class C1067l implements AppLovinCommunicatorSubscriber, C1121i.C1122a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f2224a;

    /* renamed from: b */
    private Object f2225b;

    /* renamed from: c */
    private WeakReference<View> f2226c = new WeakReference<>((Object) null);

    /* renamed from: d */
    private String f2227d;

    /* renamed from: e */
    private C1121i f2228e;

    /* renamed from: f */
    private C1157p f2229f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f2230g;

    public C1067l(C1062k kVar) {
        this.f2224a = kVar;
        AppLovinCommunicator.getInstance(kVar.mo9334J()).subscribe((AppLovinCommunicatorSubscriber) this, "safedk_ad_info");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.widget.Button} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m2210a(final android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 40
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r0)
            int r1 = r0 / 10
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388629(0x800015, float:1.1754973E-38)
            r2.<init>(r0, r0, r3)
            r2.setMargins(r1, r1, r1, r1)
            android.widget.ImageButton r0 = new android.widget.ImageButton     // Catch:{ NotFoundException -> 0x0030 }
            r0.<init>(r6)     // Catch:{ NotFoundException -> 0x0030 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ NotFoundException -> 0x0030 }
            int r4 = com.applovin.sdk.C1199R.C1200drawable.applovin_ic_white_small     // Catch:{ NotFoundException -> 0x0030 }
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)     // Catch:{ NotFoundException -> 0x0030 }
            r0.setImageDrawable(r3)     // Catch:{ NotFoundException -> 0x0030 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NotFoundException -> 0x0030 }
            r0.setScaleType(r3)     // Catch:{ NotFoundException -> 0x0030 }
            int r3 = r1 * 2
            r0.setPadding(r1, r1, r1, r3)     // Catch:{ NotFoundException -> 0x0030 }
            goto L_0x004b
        L_0x0030:
            android.widget.Button r0 = new android.widget.Button
            r0.<init>(r6)
            java.lang.String r1 = "ⓘ"
            r0.setText(r1)
            r1 = -1
            r0.setTextColor(r1)
            r1 = 0
            r0.setAllCaps(r1)
            r3 = 1101004800(0x41a00000, float:20.0)
            r4 = 2
            r0.setTextSize(r4, r3)
            r0.setPadding(r1, r1, r1, r1)
        L_0x004b:
            r0.setLayoutParams(r2)
            android.graphics.drawable.Drawable r1 = r5.m2218e()
            r0.setBackground(r1)
            com.applovin.impl.sdk.l$4 r1 = new com.applovin.impl.sdk.l$4
            r1.<init>(r6)
            r0.setOnClickListener(r1)
            boolean r1 = com.applovin.impl.sdk.utils.C1119g.m2531d()
            if (r1 == 0) goto L_0x006c
            r1 = 5
            int r6 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r1)
            float r6 = (float) r6
            r0.setElevation(r6)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1067l.m2210a(android.app.Activity):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2212a(Context context) {
        final String f = m2219f();
        final WeakReference weakReference = new WeakReference(context);
        new AlertDialog.Builder(context).setTitle("Ad Info").setMessage(f).setNegativeButton("Close", (DialogInterface.OnClickListener) null).setPositiveButton("Report", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (weakReference.get() != null) {
                    C1067l.this.m2213a((Context) weakReference.get(), f);
                }
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2213a(Context context, String str) {
        C1152l lVar = new C1152l();
        lVar.mo9652b("Describe your issue below:\n\n\n").mo9648a("Ad Info:").mo9648a(str).mo9648a("\nDebug Info:\n").mo9649a("Platform", "Android").mo9649a("AppLovin SDK Version", AppLovinSdk.VERSION).mo9649a("Plugin Version", this.f2224a.mo9350a(C0965b.f1779du)).mo9649a("Ad Review Version", C1160r.m2758f()).mo9649a("App Package Name", context.getPackageName()).mo9649a("Device", Build.DEVICE).mo9649a("OS Version", Build.VERSION.RELEASE).mo9649a("AppLovin Random Token", this.f2224a.mo9399o());
        if (this.f2227d != null) {
            lVar.mo9648a("\nSafeDK Ad Info:\n");
            lVar.mo9648a(this.f2227d);
        }
        Intent intent = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", "MAX Ad Report").setPackage("com.google.android.gm");
        Object obj = this.f2225b;
        if (obj instanceof C0934g) {
            JSONObject b = ((C0934g) obj).mo7823b();
            lVar.mo9648a("\nAd Response:\n");
            lVar.mo9648a(b.toString());
            intent.putExtra("android.intent.extra.SUBJECT", "AppLovin Ad Report");
        }
        intent.putExtra("android.intent.extra.TEXT", lVar.toString());
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            intent.setPackage((String) null);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2217d() {
        if (this.f2224a.mo9369ad().mo9576b() && this.f2226c.get() == null) {
            Activity a = this.f2224a.mo9370ae().mo8944a();
            View findViewById = a.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                C1107r z = this.f2224a.mo9411z();
                z.mo9584b("AppLovinSdk", "Displaying creative debugger button for ad: " + this.f2225b);
                final FrameLayout frameLayout = (FrameLayout) findViewById;
                final View a2 = m2210a(a);
                frameLayout.addView(a2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150);
                a2.startAnimation(alphaAnimation);
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (a2.getParent() == null) {
                            frameLayout.addView(a2);
                        }
                    }
                });
                this.f2226c = new WeakReference<>(a2);
            }
        }
    }

    /* renamed from: e */
    private Drawable m2218e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* renamed from: f */
    private String m2219f() {
        C1152l lVar = new C1152l();
        Object obj = this.f2225b;
        if (obj instanceof C0934g) {
            C0934g gVar = (C0934g) obj;
            lVar.mo9649a("Network", "APPLOVIN").mo9646a(gVar).mo9651b(gVar);
        } else if (obj instanceof C0733a) {
            lVar.mo9645a((C0733a) obj);
        }
        lVar.mo9647a(this.f2224a);
        return lVar.toString();
    }

    /* renamed from: a */
    public void mo9416a() {
        C1121i iVar = this.f2228e;
        if (iVar != null) {
            iVar.mo9613b();
        }
        this.f2225b = null;
        this.f2226c = new WeakReference<>((Object) null);
        this.f2227d = null;
    }

    /* renamed from: a */
    public void mo9417a(Object obj) {
        if (!C0788c.m1114b(obj)) {
            this.f2225b = obj;
            if (((Boolean) this.f2224a.mo9350a(C0965b.f1629bA)).booleanValue() && this.f2224a.mo9400p().isCreativeDebuggerEnabled()) {
                if (this.f2228e == null) {
                    this.f2228e = new C1121i(this.f2224a, this);
                }
                this.f2228e.mo9612a();
            }
        }
    }

    /* renamed from: b */
    public void mo9418b() {
        if (this.f2230g == 0) {
            this.f2229f = C1157p.m2682a(TimeUnit.SECONDS.toMillis(3), this.f2224a, new Runnable() {
                public void run() {
                    int unused = C1067l.this.f2230g = 0;
                }
            });
        }
        int i = this.f2230g;
        if (i % 2 == 0) {
            this.f2230g = i + 1;
        }
    }

    /* renamed from: c */
    public void mo9419c() {
        int i = this.f2230g;
        if (i % 2 == 1) {
            this.f2230g = i + 1;
        }
        if (this.f2230g / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C1067l.this.f2224a.mo9372ag().mo9302a(new Bundle(), "show_creative_debugger");
                    C1067l.this.m2217d();
                }
            });
            this.f2230g = 0;
            this.f2229f.mo9664d();
            this.f2228e.mo9613b();
        }
    }

    public String getCommunicatorId() {
        return C1067l.class.getSimpleName();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f2227d = appLovinCommunicatorMessage.getMessageData().toString();
        }
    }
}
