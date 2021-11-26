package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0703p;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;

public class FullscreenAdService extends Service {
    public static final String DATA_KEY_AD_SOURCE = "ad_source";
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$a */
    private static class C0566a extends Handler {
        private C0566a() {
        }

        public void handleMessage(Message message) {
            try {
                C0703p pVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (pVar != null) {
                    C0934g b = pVar.mo8268b();
                    int i = message.what;
                    C0567b bVar = C0567b.AD;
                    if (i == bVar.mo7951a()) {
                        Bundle bundle = new Bundle();
                        bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, b.getRawFullResponse());
                        bundle.putInt(FullscreenAdService.DATA_KEY_AD_SOURCE, b.getSource().mo8963a());
                        Message obtain = Message.obtain((Handler) null, bVar.mo7951a());
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    } else if (message.what == C0567b.AD_DISPLAYED.mo7951a()) {
                        C1124k.m2616a(pVar.mo8270d(), (AppLovinAd) b);
                    } else if (message.what == C0567b.AD_CLICKED.mo7951a()) {
                        C1124k.m2615a(pVar.mo8271e(), (AppLovinAd) b);
                    } else if (message.what == C0567b.AD_VIDEO_STARTED.mo7951a()) {
                        C1124k.m2620a(pVar.mo8269c(), (AppLovinAd) b);
                    } else if (message.what == C0567b.AD_VIDEO_ENDED.mo7951a()) {
                        Bundle data = message.getData();
                        C1124k.m2621a(pVar.mo8269c(), (AppLovinAd) b, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    } else if (message.what == C0567b.AD_HIDDEN.mo7951a()) {
                        C1124k.m2627b(pVar.mo8270d(), (AppLovinAd) b);
                    } else {
                        super.handleMessage(message);
                    }
                } else if (!C1160r.m2727a(1)) {
                    super.handleMessage(message);
                } else {
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
            } catch (RemoteException e) {
                C1107r.m2480c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$b */
    public enum C0567b {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);
        

        /* renamed from: g */
        private final int f300g;

        private C0567b(int i) {
            this.f300g = i;
        }

        /* renamed from: a */
        public int mo7951a() {
            return this.f300g;
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new C0566a()).getBinder();
    }
}
