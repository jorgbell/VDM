package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.p */
public class C0703p implements AppLovinInterstitialAdDialog {

    /* renamed from: b */
    public static volatile boolean f666b = false;

    /* renamed from: c */
    public static volatile boolean f667c = false;

    /* renamed from: d */
    private static final Map<String, C0703p> f668d = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    protected final C1062k f669a;

    /* renamed from: e */
    private final String f670e;

    /* renamed from: f */
    private final WeakReference<Context> f671f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile AppLovinAdLoadListener f672g;

    /* renamed from: h */
    private volatile AppLovinAdDisplayListener f673h;

    /* renamed from: i */
    private volatile AppLovinAdVideoPlaybackListener f674i;

    /* renamed from: j */
    private volatile AppLovinAdClickListener f675j;

    /* renamed from: k */
    private volatile C0934g f676k;

    /* renamed from: l */
    private volatile C0934g.C0937b f677l;

    /* renamed from: m */
    private volatile C0657k f678m;

    public C0703p(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f669a = appLovinSdk.coreSdk;
            this.f670e = UUID.randomUUID().toString();
            this.f671f = new WeakReference<>(context);
            f666b = true;
            f667c = false;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static C0703p m770a(String str) {
        return f668d.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m772a(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0703p.this.f672g != null) {
                    C0703p.this.f672g.failedToReceiveAd(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m773a(Context context) {
        Intent intent = new Intent(context, this.f676k.mo9063o() ? AppLovinFullscreenActivity.class : AppLovinInterstitialActivity.class);
        intent.putExtra("com.applovin.interstitial.wrapper_id", this.f670e);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f669a.mo9409x());
        C0668o.lastKnownWrapper = this;
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private void m777a(C0934g gVar, final Context context) {
        if (this.f669a.mo9370ae().mo8946b() == null) {
            gVar.mo9060b(true);
            this.f669a.mo9341R().mo9199a(C0986g.f1966m);
        }
        f668d.put(this.f670e, this);
        if (((Boolean) this.f669a.mo9350a(C0965b.f1788eD)).booleanValue()) {
            this.f669a.mo9340Q().mo9270b().execute(new Runnable() {
                public void run() {
                    System.gc();
                }
            });
        }
        this.f676k = gVar;
        this.f677l = this.f676k.mo9064p();
        final long max = Math.max(0, ((Long) this.f669a.mo9350a(C0965b.f1716cj)).longValue());
        C1107r z = this.f669a.mo9411z();
        z.mo9584b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        m778a(gVar, context, new Runnable() {
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        C07063 r0 = C07063.this;
                        C0703p.this.m773a(context);
                    }
                }, max);
            }
        });
    }

    /* renamed from: a */
    private void m778a(C0934g gVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(gVar.mo9003L()) || !gVar.mo9038af() || C1120h.m2544a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(gVar.mo9039ag()).setMessage(gVar.mo9040ah()).setPositiveButton(gVar.mo9041ai(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* renamed from: a */
    private void m779a(AppLovinAd appLovinAd) {
        if (this.f673h != null) {
            this.f673h.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m780b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0703p.this.f672g != null) {
                    C0703p.this.f672g.adReceived(appLovinAd);
                }
            }
        });
    }

    /* renamed from: h */
    private Context m781h() {
        WeakReference<Context> weakReference = this.f671f;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public C1062k mo8265a() {
        return this.f669a;
    }

    /* renamed from: a */
    public void mo8266a(C0657k kVar) {
        this.f678m = kVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8267a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f669a.mo9404t().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: b */
    public C0934g mo8268b() {
        return this.f676k;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener mo8269c() {
        return this.f674i;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener mo8270d() {
        return this.f673h;
    }

    /* renamed from: e */
    public AppLovinAdClickListener mo8271e() {
        return this.f675j;
    }

    /* renamed from: f */
    public C0934g.C0937b mo8272f() {
        return this.f677l;
    }

    /* renamed from: g */
    public void mo8273g() {
        f666b = false;
        f667c = true;
        f668d.remove(this.f670e);
        if (this.f676k != null) {
            this.f678m = null;
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f669a.mo9404t().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f675j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f673h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f672g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f674i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        mo8267a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                C0703p.this.m780b(appLovinAd);
                C0703p.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i) {
                C0703p.this.m772a(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        String str;
        C1107r rVar;
        Context h = m781h();
        if (h != null) {
            AppLovinAd a = C1160r.m2706a(appLovinAd, this.f669a);
            if (a == null) {
                rVar = this.f669a.mo9411z();
                str = "Failed to show ad: " + appLovinAd;
            } else if (((AppLovinAdBase) a).hasShown() && ((Boolean) this.f669a.mo9350a(C0965b.f1645bQ)).booleanValue()) {
                throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
            } else if (a instanceof C0934g) {
                m777a((C0934g) a, h);
                return;
            } else {
                this.f669a.mo9411z().mo9588e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + a + "'");
                m779a(a);
                return;
            }
        } else {
            rVar = this.f669a.mo9411z();
            str = "Failed to show interstitial: stale activity reference provided";
        }
        rVar.mo9588e("InterstitialAdDialogWrapper", str);
        m779a(appLovinAd);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
