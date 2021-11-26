package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0734b;
import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.mediation.p021a.C0738f;
import com.applovin.impl.mediation.p021a.C0740g;
import com.applovin.impl.mediation.p022b.C0773d;
import com.applovin.impl.mediation.p022b.C0781f;
import com.applovin.impl.mediation.p022b.C0782g;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f739a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f740b;

    /* renamed from: com.applovin.impl.mediation.MediationServiceImpl$a */
    private class C0729a implements C0789d {

        /* renamed from: b */
        private final C0733a f755b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public MaxAdListener f756c;

        private C0729a(C0733a aVar, MaxAdListener maxAdListener) {
            this.f755b = aVar;
            this.f756c = maxAdListener;
        }

        /* renamed from: a */
        public void mo8364a(MaxAd maxAd, Bundle bundle) {
            this.f755b.mo8405m();
            this.f755b.mo8386a(bundle);
            MediationServiceImpl.this.m864b(this.f755b);
            C1124k.m2611a(this.f756c, maxAd);
        }

        /* renamed from: a */
        public void mo8365a(MaxAd maxAd, C0861e eVar) {
            MediationServiceImpl.this.m865b(this.f755b, eVar, this.f756c);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof C0735c)) {
                ((C0735c) maxAd).mo8439z();
            }
        }

        /* renamed from: a */
        public void mo8366a(MaxAdListener maxAdListener) {
            this.f756c = maxAdListener;
        }

        /* renamed from: a */
        public void mo8367a(String str, C0861e eVar) {
            this.f755b.mo8405m();
            MediationServiceImpl.this.m854a(this.f755b, eVar, this.f756c);
        }

        /* renamed from: b */
        public void mo8368b(MaxAd maxAd, Bundle bundle) {
            MediationServiceImpl.this.f740b.mo9584b("MediationService", "Scheduling impression for ad via callback...");
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f755b);
            this.f755b.mo8386a(bundle);
            MediationServiceImpl.this.f739a.mo9372ag().mo9304a(this.f755b, "DID_DISPLAY");
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f739a.mo9369ad().mo9572a((Object) maxAd);
                MediationServiceImpl.this.f739a.mo9377al().mo9417a((Object) maxAd);
            }
            C1124k.m2626b(this.f756c, maxAd);
        }

        public void onAdClicked(MaxAd maxAd) {
            MediationServiceImpl.this.m866c(this.f755b);
            C1124k.m2632d(this.f756c, maxAd);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            C1124k.m2636h(this.f756c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            MediationServiceImpl.this.m865b(this.f755b, new C0861e(i), this.f756c);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            mo8368b(maxAd, (Bundle) null);
        }

        public void onAdExpanded(MaxAd maxAd) {
            C1124k.m2635g(this.f756c, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MediationServiceImpl.this.f739a.mo9372ag().mo9304a((C0733a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat().isFullscreenAd()) {
                        MediationServiceImpl.this.f739a.mo9369ad().mo9575b((Object) maxAd);
                        MediationServiceImpl.this.f739a.mo9377al().mo9416a();
                    }
                    C1124k.m2630c(C0729a.this.f756c, maxAd);
                }
            }, maxAd instanceof C0735c ? ((C0735c) maxAd).mo8435v() : 0);
        }

        public void onAdLoadFailed(String str, int i) {
            this.f755b.mo8405m();
            MediationServiceImpl.this.m854a(this.f755b, new C0861e(i), this.f756c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            mo8364a(maxAd, (Bundle) null);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1124k.m2634f(this.f756c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1124k.m2633e(this.f756c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1124k.m2613a(this.f756c, maxAd, maxReward);
            MediationServiceImpl.this.f739a.mo9340Q().mo9266a((C0989a) new C0781f((C0735c) maxAd, MediationServiceImpl.this.f739a), C1020o.C1022a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(C1062k kVar) {
        this.f739a = kVar;
        this.f740b = kVar.mo9411z();
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    /* renamed from: a */
    private void m853a(C0733a aVar) {
        m857a("mpreload", (C0737e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m854a(C0733a aVar, C0861e eVar, MaxAdListener maxAdListener) {
        m856a(eVar, aVar);
        destroyAd(aVar);
        C1124k.m2614a(maxAdListener, aVar.getAdUnitId(), eVar.getErrorCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m855a(C0735c cVar, MaxAdListener maxAdListener) {
        long longValue = ((Long) this.f739a.mo9350a(C0964a.f1527E)).longValue();
        if (longValue > 0) {
            final C0735c cVar2 = cVar;
            final long j = longValue;
            final MaxAdListener maxAdListener2 = maxAdListener;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (!cVar2.mo8406n().get()) {
                        C1107r.m2484i("MediationService", "Ad (" + cVar2.mo8444K() + ") has not been displayed after " + j + "ms. Failing ad display...");
                        MediationServiceImpl.this.m865b(cVar2, new C0861e(-5201, "Adapter did not call adDisplayed."), maxAdListener2);
                        MediationServiceImpl.this.f739a.mo9369ad().mo9575b((Object) cVar2);
                        MediationServiceImpl.this.f739a.mo9377al().mo9416a();
                    }
                }
            }, longValue);
        }
    }

    /* renamed from: a */
    private void m856a(C0861e eVar, C0733a aVar) {
        long j = aVar.mo8402j();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(j));
        m860a("mlerr", (Map<String, String>) hashMap, eVar, (C0737e) aVar);
    }

    /* renamed from: a */
    private void m857a(String str, C0737e eVar) {
        m860a(str, (Map<String, String>) Collections.EMPTY_MAP, (C0861e) null, eVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m858a(String str, C0740g gVar, C0870i iVar) {
        HashMap hashMap = new HashMap(2);
        C1160r.m2724a("{ADAPTER_VERSION}", iVar.mo8767g(), (Map) hashMap);
        C1160r.m2724a("{SDK_VERSION}", iVar.mo8766f(), (Map) hashMap);
        m860a("serr", (Map<String, String>) hashMap, new C0861e(str), (C0737e) gVar);
    }

    /* renamed from: a */
    private void m859a(String str, Map<String, String> map, C0737e eVar) {
        m860a(str, map, (C0861e) null, eVar);
    }

    /* renamed from: a */
    private void m860a(String str, Map<String, String> map, C0861e eVar, C0737e eVar2) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("{PLACEMENT}", C1155o.m2675c(eVar2.getPlacement()));
        if (eVar2 instanceof C0733a) {
            hashMap.put("{CREATIVE_ID}", C1155o.m2675c(((C0733a) eVar2).getCreativeId()));
        }
        this.f739a.mo9340Q().mo9266a((C0989a) new C0773d(str, hashMap, eVar, eVar2, this.f739a), C1020o.C1022a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m864b(C0733a aVar) {
        this.f739a.mo9372ag().mo9304a(aVar, "DID_LOAD");
        if (aVar.mo8388c().endsWith("load")) {
            this.f739a.mo9372ag().mo9303a(aVar);
        }
        long j = aVar.mo8402j();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(j));
        m859a("load", (Map<String, String>) hashMap, (C0737e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m865b(C0733a aVar, C0861e eVar, MaxAdListener maxAdListener) {
        this.f739a.mo9372ag().mo9304a(aVar, "DID_FAIL_DISPLAY");
        processAdDisplayErrorPostback(eVar, aVar);
        if (aVar.mo8406n().compareAndSet(false, true)) {
            C1124k.m2612a(maxAdListener, (MaxAd) aVar, eVar.getErrorCode());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m866c(C0733a aVar) {
        this.f739a.mo9372ag().mo9304a(aVar, "DID_CLICKED");
        this.f739a.mo9372ag().mo9304a(aVar, "DID_CLICK");
        if (aVar.mo8388c().endsWith("click")) {
            this.f739a.mo9372ag().mo9303a(aVar);
        }
        m857a("mclick", (C0737e) aVar);
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final C0740g gVar, Activity activity, final C0738f.C0739a aVar) {
        String str;
        C1107r rVar;
        String str2;
        StringBuilder sb;
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (aVar != null) {
            final C0870i a = this.f739a.mo9325A().mo8747a((C0737e) gVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m847a(gVar, maxAdFormat, activity.getApplicationContext());
                a.mo8758a((MaxAdapterInitializationParameters) a2, activity);
                C07272 r1 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.mo8480a(C0738f.m964a(gVar, a, str));
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.m858a(str, gVar, a);
                        aVar.mo8480a(C0738f.m966b(gVar, a, str));
                    }
                };
                if (!gVar.mo8385a()) {
                    rVar = this.f740b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for adapter: ";
                } else if (this.f739a.mo9326B().mo8743a((C0737e) gVar)) {
                    rVar = this.f740b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for now-initialized adapter: ";
                } else {
                    C1107r rVar2 = this.f740b;
                    rVar2.mo9588e("MediationService", "Skip collecting signal for not-initialized adapter: " + a.mo8762b());
                    str = "Adapter not initialized yet";
                }
                sb.append(str2);
                sb.append(a.mo8762b());
                rVar.mo9584b("MediationService", sb.toString());
                a.mo8759a(a2, gVar, activity, r1);
                return;
            }
            str = "Could not load adapter";
            aVar.mo8480a(C0738f.m965a(gVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof C0733a) {
            C1107r rVar = this.f740b;
            rVar.mo9586c("MediationService", "Destroying " + maxAd);
            C0733a aVar = (C0733a) maxAd;
            C0870i f = aVar.mo8391f();
            if (f != null) {
                f.mo8768h();
                aVar.mo8407o();
            }
        }
    }

    public void loadAd(String str, MaxAdFormat maxAdFormat, C1099h hVar, Activity activity, MaxAdListener maxAdListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (maxAdListener != null) {
            if (TextUtils.isEmpty(this.f739a.mo9403s())) {
                C1107r.m2484i("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
            }
            if (!this.f739a.mo9388d()) {
                C1107r.m2483h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.f739a.mo9353a();
            if (str.length() != 16 && !str.startsWith("test_mode") && !this.f739a.mo9409x().startsWith("05TMD")) {
                C1107r.m2484i("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
            }
            this.f739a.mo9331G().mo8737a(str, maxAdFormat, hVar, activity, maxAdListener);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, C0733a aVar, Activity activity, MaxAdListener maxAdListener) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (activity != null) {
            C1107r rVar = this.f740b;
            rVar.mo9584b("MediationService", "Loading " + aVar + "...");
            this.f739a.mo9372ag().mo9304a(aVar, "WILL_LOAD");
            m853a(aVar);
            C0870i a = this.f739a.mo9325A().mo8747a((C0737e) aVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m845a(aVar, activity.getApplicationContext());
                a.mo8758a((MaxAdapterInitializationParameters) a2, activity);
                C0733a a3 = aVar.mo8384a(a);
                a.mo8760a(str, a3);
                a3.mo8403k();
                a.mo8761a(str, a2, a3, activity, new C0729a(a3, maxAdListener));
                return;
            }
            C1107r rVar2 = this.f740b;
            rVar2.mo9587d("MediationService", "Failed to load " + aVar + ": adapter not loaded");
            m854a(aVar, new C0861e((int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED), maxAdListener);
        } else {
            throw new IllegalArgumentException("A valid Activity is required");
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object c = this.f739a.mo9369ad().mo9577c();
            if (c instanceof C0733a) {
                processAdDisplayErrorPostback(MaxAdapterError.WEBVIEW_ERROR, (C0733a) c);
            }
        }
    }

    public void processAdDisplayErrorPostback(C0861e eVar, C0733a aVar) {
        m860a("mierr", (Map<String, String>) Collections.EMPTY_MAP, eVar, (C0737e) aVar);
    }

    public void processAdLossPostback(C0733a aVar, Float f) {
        String f2 = f != null ? f.toString() : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("{MBR}", f2);
        m859a("mloss", (Map<String, String>) hashMap, (C0737e) aVar);
    }

    public void processAdapterInitializationPostback(C0737e eVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        m860a("minit", (Map<String, String>) hashMap, new C0861e(str), eVar);
    }

    public void processCallbackAdImpressionPostback(C0733a aVar) {
        if (aVar.mo8388c().endsWith("cimp")) {
            this.f739a.mo9372ag().mo9303a(aVar);
        }
        m857a("mcimp", (C0737e) aVar);
    }

    public void processRawAdImpressionPostback(C0733a aVar) {
        this.f739a.mo9372ag().mo9304a(aVar, "WILL_DISPLAY");
        if (aVar.mo8388c().endsWith("mimp")) {
            this.f739a.mo9372ag().mo9303a(aVar);
        }
        HashMap hashMap = new HashMap(1);
        if (aVar instanceof C0735c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((C0735c) aVar).mo8433t()));
        }
        m859a("mimp", (Map<String, String>) hashMap, (C0737e) aVar);
    }

    public void processViewabilityAdImpressionPostback(C0734b bVar, long j) {
        if (bVar.mo8388c().endsWith("vimp")) {
            this.f739a.mo9372ag().mo9303a(bVar);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(bVar.mo8420x()));
        m859a("mvimp", (Map<String, String>) hashMap, (C0737e) bVar);
    }

    public void showFullscreenAd(MaxAd maxAd, String str, Activity activity, MaxAdListener maxAdListener) {
        if (maxAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (maxAd instanceof C0735c) {
            this.f739a.mo9369ad().mo9573a(true);
            final C0735c cVar = (C0735c) maxAd;
            final C0870i f = cVar.mo8391f();
            if (f != null) {
                cVar.mo8468c(str);
                long u = cVar.mo8434u();
                C1107r rVar = this.f740b;
                rVar.mo9586c("MediationService", "Showing ad " + maxAd.getAdUnitId() + " with delay of " + u + "ms...");
                final Activity activity2 = activity;
                final MaxAdListener maxAdListener2 = maxAdListener;
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                            MediationServiceImpl.this.f739a.mo9340Q().mo9266a((C0989a) new C0782g(cVar, MediationServiceImpl.this.f739a), C1020o.C1022a.MEDIATION_REWARD);
                        }
                        f.mo8757a((C0733a) cVar, activity2);
                        MediationServiceImpl.this.f739a.mo9369ad().mo9573a(false);
                        MediationServiceImpl.this.m855a(cVar, maxAdListener2);
                        MediationServiceImpl.this.f740b.mo9584b("MediationService", "Scheduling impression for ad manually...");
                        MediationServiceImpl.this.processRawAdImpressionPostback(cVar);
                    }
                }, u);
                return;
            }
            this.f739a.mo9369ad().mo9573a(false);
            C1107r rVar2 = this.f740b;
            rVar2.mo9587d("MediationService", "Failed to show " + maxAd + ": adapter not found");
            C1107r.m2484i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
            throw new IllegalStateException("Could not find adapter for provided ad");
        } else {
            C1107r.m2484i("MediationService", "Unable to show ad for '" + maxAd.getAdUnitId() + "': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). " + maxAd.getFormat() + " ad was provided.");
            throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
        }
    }
}
