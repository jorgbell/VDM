package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1026p;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.activity.a */
public class C0568a implements ServiceConnection {

    /* renamed from: a */
    private final C1062k f301a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f302b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WeakReference<AppLovinFullscreenActivity> f303c;

    /* renamed from: d */
    private final AtomicBoolean f304d = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Messenger f305e;

    /* renamed from: com.applovin.impl.adview.activity.a$a */
    private class C0570a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        private C0570a() {
        }

        /* renamed from: a */
        private void m358a(Bundle bundle, FullscreenAdService.C0567b bVar) {
            Message obtain = Message.obtain((Handler) null, bVar.mo7951a());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                C0568a.this.f305e.send(obtain);
            } catch (RemoteException e) {
                C1107r b = C0568a.this.f302b;
                b.mo9585b("InterActivityV2", "Failed to forward callback (" + bVar.mo7951a() + ")", e);
            }
        }

        /* renamed from: a */
        private void m359a(FullscreenAdService.C0567b bVar) {
            m358a((Bundle) null, bVar);
        }

        public void adClicked(AppLovinAd appLovinAd) {
            m359a(FullscreenAdService.C0567b.AD_CLICKED);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            m359a(FullscreenAdService.C0567b.AD_DISPLAYED);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            m359a(FullscreenAdService.C0567b.AD_HIDDEN);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            m359a(FullscreenAdService.C0567b.AD_VIDEO_STARTED);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d);
            bundle.putBoolean("fully_watched", z);
            m358a(bundle, FullscreenAdService.C0567b.AD_VIDEO_ENDED);
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.a$b */
    private static class C0571b extends Handler {

        /* renamed from: a */
        private final WeakReference<C0568a> f308a;

        private C0571b(C0568a aVar) {
            this.f308a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C0568a aVar;
            if (message.what != FullscreenAdService.C0567b.AD.mo7951a() || (aVar = (C0568a) this.f308a.get()) == null) {
                super.handleMessage(message);
                return;
            }
            aVar.m354a(C0925b.m1531a(message.getData().getInt(FullscreenAdService.DATA_KEY_AD_SOURCE)), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
        }
    }

    public C0568a(AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar) {
        this.f301a = kVar;
        this.f302b = kVar.mo9411z();
        this.f303c = new WeakReference<>(appLovinFullscreenActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m352a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.f303c.get();
        if (appLovinFullscreenActivity != null) {
            this.f302b.mo9584b("InterActivityV2", "Dismissing...");
            appLovinFullscreenActivity.dismiss();
            return;
        }
        this.f302b.mo9588e("InterActivityV2", "Unable to dismiss parent Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m354a(C0925b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C0925b bVar2 = bVar;
            this.f301a.mo9340Q().mo9265a((C0989a) new C1026p(jSONObject, C0928d.m1540a(C1123j.m2594b(jSONObject, "zone_id", "", this.f301a), this.f301a), bVar2, new AppLovinAdLoadListener() {
                public void adReceived(AppLovinAd appLovinAd) {
                    AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) C0568a.this.f303c.get();
                    if (appLovinFullscreenActivity != null) {
                        C0568a.this.f302b.mo9584b("InterActivityV2", "Presenting ad...");
                        C0570a aVar = new C0570a();
                        appLovinFullscreenActivity.present((C0934g) appLovinAd, aVar, aVar, aVar);
                        return;
                    }
                    C1107r b = C0568a.this.f302b;
                    b.mo9588e("InterActivityV2", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                }

                public void failedToReceiveAd(int i) {
                    C0568a.this.m352a();
                }
            }, this.f301a));
        } catch (JSONException e) {
            C1107r rVar = this.f302b;
            rVar.mo9585b("InterActivityV2", "Unable to process ad: " + str, e);
            m352a();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f304d.compareAndSet(false, true)) {
            C1107r rVar = this.f302b;
            rVar.mo9584b("InterActivityV2", "Fullscreen ad service connected to " + componentName);
            this.f305e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.C0567b.AD.mo7951a());
            obtain.replyTo = new Messenger(new C0571b());
            try {
                this.f302b.mo9584b("InterActivityV2", "Requesting ad from FullscreenAdService...");
                this.f305e.send(obtain);
            } catch (RemoteException e) {
                this.f302b.mo9585b("InterActivityV2", "Failed to send ad request message to FullscreenAdService", e);
                m352a();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f304d.compareAndSet(true, false)) {
            C1107r rVar = this.f302b;
            rVar.mo9584b("InterActivityV2", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
