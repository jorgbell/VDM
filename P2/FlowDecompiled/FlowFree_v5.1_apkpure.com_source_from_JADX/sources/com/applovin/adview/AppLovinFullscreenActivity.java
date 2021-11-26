package com.applovin.adview;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.applovin.impl.adview.C0657k;
import com.applovin.impl.adview.C0703p;
import com.applovin.impl.adview.activity.C0568a;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.p020b.C0578a;
import com.applovin.impl.adview.activity.p020b.C0591b;
import com.applovin.impl.adview.activity.p020b.C0594c;
import com.applovin.impl.adview.activity.p020b.C0596d;
import com.applovin.impl.adview.activity.p020b.C0598e;
import com.applovin.impl.adview.activity.p020b.C0610f;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0941i;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenActivity extends Activity implements C0657k {
    public static C0703p parentInterstitialWrapper;

    /* renamed from: a */
    private C1062k f124a;

    /* renamed from: b */
    private C0578a f125b;

    /* renamed from: c */
    private final AtomicBoolean f126c = new AtomicBoolean(true);

    /* renamed from: d */
    private C0568a f127d;

    /* renamed from: a */
    private void m193a(String str, Throwable th) {
        C1107r.m2480c("InterActivityV2", str, th);
        AppLovinAdDisplayListener d = parentInterstitialWrapper.mo8270d();
        if (d instanceof C0941i) {
            C1124k.m2617a(d, str);
        } else {
            C1124k.m2627b(d, (AppLovinAd) parentInterstitialWrapper.mo8268b());
        }
        dismiss();
    }

    public void dismiss() {
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7985f();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7989j();
        }
        if (C1160r.m2759f(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7972a(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityManager activityManager;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        findViewById(16908290).setBackgroundColor(-16777216);
        C1062k kVar = AppLovinSdk.getInstance(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"), new AppLovinSdkSettings(this), this).coreSdk;
        this.f124a = kVar;
        if (parentInterstitialWrapper != null) {
            int intValue = ((Integer) kVar.mo9350a(C0965b.f1794eJ)).intValue();
            if (!(intValue == -1 || (activityManager = (ActivityManager) getSystemService("activity")) == null)) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                if (memoryInfo.availMem < ((long) intValue)) {
                    m193a("Not enough available memory", (Throwable) null);
                    return;
                }
            }
            present(parentInterstitialWrapper.mo8268b(), parentInterstitialWrapper.mo8271e(), parentInterstitialWrapper.mo8270d(), parentInterstitialWrapper.mo8269c());
            return;
        }
        Intent intent = new Intent(this, FullscreenAdService.class);
        C0568a aVar = new C0568a(this, this.f124a);
        this.f127d = aVar;
        bindService(intent, aVar, 1);
        if (C1119g.m2534g()) {
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        parentInterstitialWrapper = null;
        C0568a aVar = this.f127d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        C0578a aVar2 = this.f125b;
        if (aVar2 != null) {
            aVar2.mo7987h();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7969a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7988i();
        }
        super.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7984e();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C0578a aVar;
        try {
            super.onResume();
            if (!this.f126c.get() && (aVar = this.f125b) != null) {
                aVar.mo7983d();
            }
        } catch (IllegalArgumentException e) {
            this.f124a.mo9411z().mo9585b("InterActivityV2", "Error was encountered in onResume().", e);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C0578a aVar = this.f125b;
        if (aVar != null) {
            aVar.mo7986g();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.f125b != null) {
            if (!this.f126c.getAndSet(false) || (this.f125b instanceof C0598e)) {
                this.f125b.mo7982c(z);
            }
            if (z) {
                getWindow().getDecorView().setSystemUiVisibility(5894);
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void present(C0934g gVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        boolean z = gVar.mo9030aI() && C1160r.m2745b(this.f124a);
        if (gVar instanceof C0536a) {
            if (z) {
                try {
                    this.f125b = new C0594c(gVar, this, this.f124a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th) {
                    m193a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + this.f124a + " and throwable: " + th.getMessage(), th);
                    return;
                }
            } else {
                try {
                    this.f125b = new C0596d(gVar, this, this.f124a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th2) {
                    m193a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + this.f124a + " and throwable: " + th2.getMessage(), th2);
                    return;
                }
            }
        } else if (!gVar.hasVideoUrl()) {
            try {
                this.f125b = new C0591b(gVar, this, this.f124a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th3) {
                m193a("Failed to create FullscreenGraphicAdPresenter with sdk: " + this.f124a + " and throwable: " + th3.getMessage(), th3);
                return;
            }
        } else if (z) {
            try {
                this.f125b = new C0598e(gVar, this, this.f124a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th4) {
                m193a("Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: " + this.f124a + " and throwable: " + th4.getMessage(), th4);
                return;
            }
        } else {
            try {
                this.f125b = new C0610f(gVar, this, this.f124a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th5) {
                m193a("Failed to create FullscreenVideoAdPresenter with sdk: " + this.f124a + " and throwable: " + th5.getMessage(), th5);
                return;
            }
        }
        this.f125b.mo7981c();
    }
}
