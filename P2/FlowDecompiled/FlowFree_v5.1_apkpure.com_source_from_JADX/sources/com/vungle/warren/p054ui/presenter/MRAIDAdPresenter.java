package com.vungle.warren.p054ui.presenter;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.vungle.warren.SessionData;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.omsdk.WebViewObserver;
import com.vungle.warren.p054ui.DurationRecorder;
import com.vungle.warren.p054ui.PresenterAppLeftCallback;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdView;
import com.vungle.warren.p054ui.state.OptionsState;
import com.vungle.warren.p054ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.MRAIDAdPresenter */
public class MRAIDAdPresenter implements WebAdContract$WebAdPresenter, WebViewAPI.MRAIDDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String TAG = "com.vungle.warren.ui.presenter.MRAIDAdPresenter";
    /* access modifiers changed from: private */
    public WebAdContract$WebAdView adView;
    private boolean adViewed;
    private Advertisement advertisement;
    private final AdAnalytics analytics;
    private File assetDir;
    /* access modifiers changed from: private */
    public boolean backEnabled;
    private AdContract$AdvertisementPresenter.EventListener bus;
    private Map<String, Cookie> cookieMap = new HashMap();
    private long duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private final OMTracker omTracker;
    private final Placement placement;
    private Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onSaved() {
        }

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                MRAIDAdPresenter.this.makeBusError(26);
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName(), new VungleException(26).getLocalizedMessage());
                MRAIDAdPresenter.this.closeView();
            }
        }
    };
    private Report report;
    private Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private SessionData sessionData;
    private WebViewAPI webClient;

    public MRAIDAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, WebViewAPI webViewAPI, OptionsState optionsState, File file, SessionData sessionData2, OMTracker oMTracker) {
        this.advertisement = advertisement2;
        this.repository = repository2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webClient = webViewAPI;
        this.assetDir = file;
        this.sessionData = sessionData2;
        this.omTracker = oMTracker;
        loadData(optionsState);
    }

    public void setEventListener(AdContract$AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            long parseLong = Long.parseLong(str2);
            this.duration = parseLong;
            this.report.setVideoLength(parseLong);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void onViewConfigurationChanged() {
        this.adView.updateWindow();
        this.webClient.notifyPropertiesChange(true);
    }

    public void attach(WebAdContract$WebAdView webAdContract$WebAdView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = webAdContract$WebAdView;
        webAdContract$WebAdView.setPresenter(this);
        this.omTracker.start();
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            if ((settings & 2) == 2) {
                z = true;
            }
            this.backEnabled = z;
        }
        int i = -1;
        int adOrientation = this.advertisement.getAdConfig().getAdOrientation();
        int i2 = 6;
        if (adOrientation == 3) {
            int orientation = this.advertisement.getOrientation();
            if (orientation == 0) {
                i = 7;
            } else if (orientation == 1) {
                i = 6;
            }
            i2 = i;
        } else if (adOrientation == 0) {
            i2 = 7;
        } else if (adOrientation != 1) {
            i2 = 4;
        }
        String str = TAG;
        Log.d(str, "Requested Orientation " + i2);
        webAdContract$WebAdView.setOrientation(i2);
        prepare(optionsState);
    }

    public void detach(int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.webClient.setWebViewObserver((WebViewObserver) null);
        this.adView.destroyAdView(this.omTracker.stop());
    }

    private void prepare(OptionsState optionsState) {
        String str;
        this.webClient.setMRAIDDelegate(this);
        this.webClient.setErrorHandler(this);
        loadMraid(new File(this.assetDir.getPath() + File.separator + "template"));
        Cookie cookie = this.cookieMap.get("incentivizedTextSetByPub");
        if (cookie == null) {
            str = null;
        } else {
            str = cookie.getString("userID");
        }
        if (this.report == null) {
            Report report2 = new Report(this.advertisement, this.placement, System.currentTimeMillis(), str, this.sessionData);
            this.report = report2;
            report2.setTtDownload(this.advertisement.getTtDownload());
            this.repository.save(this.report, this.repoCallback);
        }
        if (this.durationRecorder == null) {
            this.durationRecorder = new DurationRecorder(this.report, this.repository, this.repoCallback);
        }
        Cookie cookie2 = this.cookieMap.get("consentIsImportantToVungle");
        if (cookie2 != null) {
            boolean z = cookie2.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie2.getString("consent_status"));
            this.webClient.setConsentStatus(z, cookie2.getString("consent_title"), cookie2.getString("consent_message"), cookie2.getString("button_accept"), cookie2.getString("button_deny"));
            if (z) {
                cookie2.putValue("consent_status", "opted_out_by_timeout");
                cookie2.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie2.putValue("consent_source", "vungle_modal");
                this.repository.save(cookie2, this.repoCallback);
            }
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
        if (showCloseDelay > 0) {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    boolean unused = MRAIDAdPresenter.this.backEnabled = true;
                }
            }, (long) showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        this.adView.updateWindow();
        AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("start", (String) null, this.placement.getId());
        }
    }

    private void loadMraid(File file) {
        File file2 = new File(file.getParent());
        final File file3 = new File(file2.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file3, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (!z) {
                    MRAIDAdPresenter.this.makeBusError(27);
                    MRAIDAdPresenter.this.makeBusError(10);
                    MRAIDAdPresenter.this.adView.close();
                    return;
                }
                WebAdContract$WebAdView access$300 = MRAIDAdPresenter.this.adView;
                access$300.showWebsite("file://" + file3.getPath());
            }
        });
    }

    public void start() {
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        setAdVisibility(true);
    }

    public void stop(int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        this.adView.pauseWeb();
        setAdVisibility(false);
        if (!z && z2 && !this.isDestroying.getAndSet(true)) {
            WebViewAPI webViewAPI = this.webClient;
            String str = null;
            if (webViewAPI != null) {
                webViewAPI.setMRAIDDelegate((WebViewAPI.MRAIDDelegate) null);
            }
            if (z3) {
                reportAction("mraidCloseByApi", (String) null);
            }
            this.repository.save(this.report, this.repoCallback);
            AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void setAdVisibility(boolean z) {
        this.webClient.setAdVisibility(z);
        if (z) {
            this.durationRecorder.start();
        } else {
            this.durationRecorder.stop();
        }
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            optionsState.put("saved_report", this.report.getId());
            optionsState.put("incentivized_sent", this.sendReportIncentivized.get());
        }
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            boolean z = optionsState.getBoolean("incentivized_sent", false);
            if (z) {
                this.sendReportIncentivized.set(z);
            }
            if (this.report == null) {
                this.adView.close();
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#restoreFromSave", "The advertisement was not started and cannot be restored.");
            }
        }
    }

    public boolean handleExit() {
        if (!this.backEnabled) {
            return false;
        }
        this.adView.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r20, com.google.gson.JsonObject r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r20.hashCode()
            int r3 = r20.hashCode()
            java.lang.String r4 = "useCustomPrivacy"
            java.lang.String r5 = "openNonMraid"
            java.lang.String r6 = "successfulView"
            java.lang.String r7 = "open"
            switch(r3) {
                case -1912374177: goto L_0x0088;
                case -1422950858: goto L_0x007d;
                case -735200587: goto L_0x0072;
                case -660787472: goto L_0x0067;
                case -511324706: goto L_0x005c;
                case -418575596: goto L_0x0053;
                case -348095344: goto L_0x004a;
                case 3417674: goto L_0x0041;
                case 3566511: goto L_0x0035;
                case 94756344: goto L_0x0028;
                case 1614272768: goto L_0x001b;
                default: goto L_0x0018;
            }
        L_0x0018:
            r3 = -1
            goto L_0x0090
        L_0x001b:
            java.lang.String r3 = "useCustomClose"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0024
            goto L_0x0018
        L_0x0024:
            r3 = 10
            goto L_0x0090
        L_0x0028:
            java.lang.String r3 = "close"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0031
            goto L_0x0018
        L_0x0031:
            r3 = 9
            goto L_0x0090
        L_0x0035:
            java.lang.String r3 = "tpat"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x003e
            goto L_0x0018
        L_0x003e:
            r3 = 8
            goto L_0x0090
        L_0x0041:
            boolean r3 = r1.equals(r7)
            if (r3 != 0) goto L_0x0048
            goto L_0x0018
        L_0x0048:
            r3 = 7
            goto L_0x0090
        L_0x004a:
            boolean r3 = r1.equals(r4)
            if (r3 != 0) goto L_0x0051
            goto L_0x0018
        L_0x0051:
            r3 = 6
            goto L_0x0090
        L_0x0053:
            boolean r3 = r1.equals(r5)
            if (r3 != 0) goto L_0x005a
            goto L_0x0018
        L_0x005a:
            r3 = 5
            goto L_0x0090
        L_0x005c:
            java.lang.String r3 = "openPrivacy"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0065
            goto L_0x0018
        L_0x0065:
            r3 = 4
            goto L_0x0090
        L_0x0067:
            java.lang.String r3 = "consentAction"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0070
            goto L_0x0018
        L_0x0070:
            r3 = 3
            goto L_0x0090
        L_0x0072:
            java.lang.String r3 = "actionWithValue"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x007b
            goto L_0x0018
        L_0x007b:
            r3 = 2
            goto L_0x0090
        L_0x007d:
            java.lang.String r3 = "action"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0086
            goto L_0x0018
        L_0x0086:
            r3 = 1
            goto L_0x0090
        L_0x0088:
            boolean r3 = r1.equals(r6)
            if (r3 != 0) goto L_0x008f
            goto L_0x0018
        L_0x008f:
            r3 = 0
        L_0x0090:
            java.lang.String r12 = "user"
            java.lang.String r13 = "adStartTime"
            java.lang.String r14 = "app_id"
            java.lang.String r15 = "placement_reference_id"
            java.lang.String r8 = "isReportIncentivizedEnabled"
            java.lang.String r9 = "Unknown value "
            java.lang.String r11 = "configSettings"
            java.lang.String r10 = "url"
            r16 = r6
            java.lang.String r6 = "gone"
            r17 = r12
            java.lang.String r12 = "event"
            r18 = r13
            r13 = 0
            switch(r3) {
                case 0: goto L_0x034d;
                case 1: goto L_0x034b;
                case 2: goto L_0x0231;
                case 3: goto L_0x01f3;
                case 4: goto L_0x01db;
                case 5: goto L_0x0187;
                case 6: goto L_0x013a;
                case 7: goto L_0x0187;
                case 8: goto L_0x0125;
                case 9: goto L_0x011b;
                case 10: goto L_0x00cc;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.MRAIDAdPresenter> r2 = com.vungle.warren.p054ui.presenter.MRAIDAdPresenter.class
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = "#processCommand"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Unknown MRAID Command"
            com.vungle.warren.VungleLogger.error(r1, r2)
            r1 = 0
            return r1
        L_0x00cc:
            r1 = 0
            java.lang.String r3 = "sdkCloseButton"
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            r2.hashCode()
            int r3 = r2.hashCode()
            switch(r3) {
                case -1901805651: goto L_0x00f7;
                case 3178655: goto L_0x00ee;
                case 466743410: goto L_0x00e3;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            r8 = -1
            goto L_0x0101
        L_0x00e3:
            java.lang.String r1 = "visible"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00ec
            goto L_0x00e1
        L_0x00ec:
            r8 = 2
            goto L_0x0101
        L_0x00ee:
            boolean r1 = r2.equals(r6)
            if (r1 != 0) goto L_0x00f5
            goto L_0x00e1
        L_0x00f5:
            r8 = 1
            goto L_0x0101
        L_0x00f7:
            java.lang.String r3 = "invisible"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0100
            goto L_0x00e1
        L_0x0100:
            r8 = 0
        L_0x0101:
            switch(r8) {
                case 0: goto L_0x0119;
                case 1: goto L_0x0119;
                case 2: goto L_0x0119;
                default: goto L_0x0104;
            }
        L_0x0104:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0119:
            r1 = 1
            return r1
        L_0x011b:
            r1 = 1
            java.lang.String r2 = "mraidClose"
            r0.reportAction(r2, r13)
            r19.closeView()
            return r1
        L_0x0125:
            r1 = 1
            com.google.gson.JsonElement r2 = r2.get(r12)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.analytics.AdAnalytics r3 = r0.analytics
            com.vungle.warren.model.Advertisement r4 = r0.advertisement
            java.lang.String[] r2 = r4.getTpatUrls(r2)
            r3.ping(r2)
            return r1
        L_0x013a:
            r1 = 0
            com.google.gson.JsonElement r2 = r2.get(r4)
            java.lang.String r2 = r2.getAsString()
            r2.hashCode()
            int r3 = r2.hashCode()
            switch(r3) {
                case 3178655: goto L_0x0165;
                case 3569038: goto L_0x015a;
                case 97196323: goto L_0x014f;
                default: goto L_0x014d;
            }
        L_0x014d:
            r8 = -1
            goto L_0x016d
        L_0x014f:
            java.lang.String r1 = "false"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0158
            goto L_0x014d
        L_0x0158:
            r8 = 2
            goto L_0x016d
        L_0x015a:
            java.lang.String r1 = "true"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0163
            goto L_0x014d
        L_0x0163:
            r8 = 1
            goto L_0x016d
        L_0x0165:
            boolean r3 = r2.equals(r6)
            if (r3 != 0) goto L_0x016c
            goto L_0x014d
        L_0x016c:
            r8 = 0
        L_0x016d:
            switch(r8) {
                case 0: goto L_0x0185;
                case 1: goto L_0x0185;
                case 2: goto L_0x0185;
                default: goto L_0x0170;
            }
        L_0x0170:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0185:
            r1 = 1
            return r1
        L_0x0187:
            java.lang.String r3 = "download"
            r0.reportAction(r3, r13)
            boolean r3 = r7.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0198
            java.lang.String r1 = "mraidOpen"
            r0.reportAction(r1, r13)
            goto L_0x01a3
        L_0x0198:
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x01a3
            java.lang.String r1 = "nonMraidOpen"
            r0.reportAction(r1, r13)
        L_0x01a3:
            com.google.gson.JsonElement r1 = r2.get(r10)
            java.lang.String r1 = r1.getAsString()
            if (r1 == 0) goto L_0x01c3
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x01b4
            goto L_0x01c3
        L_0x01b4:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r2 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            com.vungle.warren.model.Placement r5 = r0.placement
            r3.<init>(r4, r5)
            r2.open(r1, r3)
            goto L_0x01ca
        L_0x01c3:
            java.lang.String r1 = TAG
            java.lang.String r2 = "CTA destination URL is not configured properly"
            android.util.Log.e(r1, r2)
        L_0x01ca:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x01d9
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = "adClick"
            r1.onNext(r7, r3, r2)
        L_0x01d9:
            r1 = 1
            return r1
        L_0x01db:
            r1 = 1
            com.google.gson.JsonElement r2 = r2.get(r10)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r3 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r4 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r0.bus
            com.vungle.warren.model.Placement r6 = r0.placement
            r4.<init>(r5, r6)
            r3.open(r2, r4)
            return r1
        L_0x01f3:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.String r3 = "consentIsImportantToVungle"
            java.lang.Object r1 = r1.get(r3)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            if (r1 != 0) goto L_0x0204
            com.vungle.warren.model.Cookie r1 = new com.vungle.warren.model.Cookie
            r1.<init>(r3)
        L_0x0204:
            com.google.gson.JsonElement r2 = r2.get(r12)
            java.lang.String r2 = r2.getAsString()
            java.lang.String r3 = "consent_status"
            r1.putValue(r3, r2)
            java.lang.String r2 = "consent_source"
            java.lang.String r3 = "vungle_modal"
            r1.putValue(r2, r3)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "timestamp"
            r1.putValue(r3, r2)
            com.vungle.warren.persistence.Repository r2 = r0.repository
            com.vungle.warren.persistence.Repository$SaveCallback r3 = r0.repoCallback
            r2.save(r1, r3)
            r1 = 1
            return r1
        L_0x0231:
            com.google.gson.JsonElement r1 = r2.get(r12)
            java.lang.String r1 = r1.getAsString()
            java.lang.String r3 = "value"
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.model.Report r3 = r0.report
            long r4 = java.lang.System.currentTimeMillis()
            r3.recordAction(r1, r2, r4)
            com.vungle.warren.persistence.Repository r3 = r0.repository
            com.vungle.warren.model.Report r4 = r0.report
            com.vungle.warren.persistence.Repository$SaveCallback r5 = r0.repoCallback
            r3.save(r4, r5)
            java.lang.String r3 = "videoViewed"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x032c
            r3 = 0
            float r4 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0263 }
            goto L_0x026b
        L_0x0263:
            java.lang.String r4 = TAG
            java.lang.String r5 = "value for videoViewed is null !"
            android.util.Log.e(r4, r5)
            r4 = 0
        L_0x026b:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r0.bus
            if (r5 == 0) goto L_0x0285
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0285
            boolean r3 = r0.adViewed
            if (r3 != 0) goto L_0x0285
            r3 = 1
            r0.adViewed = r3
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            java.lang.String r6 = "adViewed"
            r5.onNext(r6, r13, r3)
        L_0x0285:
            long r5 = r0.duration
            r9 = 0
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x032c
            float r3 = (float) r5
            float r4 = r4 / r3
            r3 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r3
            int r3 = (int) r4
            if (r3 <= 0) goto L_0x0327
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            if (r4 == 0) goto L_0x02b4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "percentViewed:"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.vungle.warren.model.Placement r6 = r0.placement
            java.lang.String r6 = r6.getId()
            r4.onNext(r5, r13, r6)
        L_0x02b4:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r4 = r0.cookieMap
            java.lang.Object r4 = r4.get(r11)
            com.vungle.warren.model.Cookie r4 = (com.vungle.warren.model.Cookie) r4
            com.vungle.warren.model.Placement r5 = r0.placement
            boolean r5 = r5.isIncentivized()
            if (r5 == 0) goto L_0x0327
            r5 = 75
            if (r3 <= r5) goto L_0x0327
            if (r4 == 0) goto L_0x0327
            java.lang.Boolean r3 = r4.getBoolean(r8)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0327
            java.util.concurrent.atomic.AtomicBoolean r3 = r0.sendReportIncentivized
            r4 = 1
            boolean r3 = r3.getAndSet(r4)
            if (r3 != 0) goto L_0x0327
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r5 = r0.placement
            java.lang.String r5 = r5.getId()
            r4.<init>((java.lang.String) r5)
            r3.add(r15, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r5 = r0.advertisement
            java.lang.String r5 = r5.getAppID()
            r4.<init>((java.lang.String) r5)
            r3.add(r14, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            long r5 = r5.getAdStartTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4.<init>((java.lang.Number) r5)
            r5 = r18
            r3.add(r5, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            java.lang.String r5 = r5.getUserID()
            r4.<init>((java.lang.String) r5)
            r6 = r17
            r3.add(r6, r4)
            com.vungle.warren.analytics.AdAnalytics r4 = r0.analytics
            r4.mo27243ri(r3)
        L_0x0327:
            com.vungle.warren.ui.DurationRecorder r3 = r0.durationRecorder
            r3.update()
        L_0x032c:
            java.lang.String r3 = "videoLength"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0344
            long r4 = java.lang.Long.parseLong(r2)
            r0.duration = r4
            r0.reportAction(r3, r2)
            com.vungle.warren.ui.view.WebViewAPI r1 = r0.webClient
            r2 = 1
            r1.notifyPropertiesChange(r2)
            goto L_0x0345
        L_0x0344:
            r2 = 1
        L_0x0345:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r1 = r0.adView
            r1.setVisibility(r2)
            return r2
        L_0x034b:
            r2 = 1
            return r2
        L_0x034d:
            r6 = r17
            r5 = r18
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x0360
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            r3 = r16
            r1.onNext(r3, r13, r2)
        L_0x0360:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.Object r1 = r1.get(r11)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            com.vungle.warren.model.Placement r2 = r0.placement
            boolean r2 = r2.isIncentivized()
            if (r2 == 0) goto L_0x03cb
            if (r1 == 0) goto L_0x03cb
            java.lang.Boolean r1 = r1.getBoolean(r8)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x03cb
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            r2 = 1
            boolean r1 = r1.getAndSet(r2)
            if (r1 != 0) goto L_0x03cb
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            r2.<init>((java.lang.String) r3)
            r1.add(r15, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String r3 = r3.getAppID()
            r2.<init>((java.lang.String) r3)
            r1.add(r14, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            long r3 = r3.getAdStartTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.<init>((java.lang.Number) r3)
            r1.add(r5, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            java.lang.String r3 = r3.getUserID()
            r2.<init>((java.lang.String) r3)
            r1.add(r6, r2)
            com.vungle.warren.analytics.AdAnalytics r2 = r0.analytics
            r2.mo27243ri(r1)
        L_0x03cb:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p054ui.presenter.MRAIDAdPresenter.processCommand(java.lang.String, com.google.gson.JsonObject):boolean");
    }

    public void onMraidAction(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -314498168:
                if (str.equals("privacy")) {
                    c = 0;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = 1;
                    break;
                }
                break;
            case 1427818632:
                if (str.equals("download")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return;
            case 1:
                closeView();
                return;
            case 2:
                download();
                return;
            default:
                throw new IllegalArgumentException("Unknown action " + str);
        }
    }

    private void download() {
        reportAction("cta", "");
        try {
            this.analytics.ping(new String[]{this.advertisement.getCTAURL(true)});
            this.adView.open(this.advertisement.getCTAURL(false), new PresenterAppLeftCallback(this.bus, this.placement));
        } catch (ActivityNotFoundException unused) {
            VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.scheduler.cancelAll();
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookieMap.put("incentivizedTextSetByPub", this.repository.load("incentivizedTextSetByPub", cls).get());
        this.cookieMap.put("consentIsImportantToVungle", this.repository.load("consentIsImportantToVungle", cls).get());
        this.cookieMap.put("configSettings", this.repository.load("configSettings", cls).get());
        if (optionsState != null) {
            String string = optionsState.getString("saved_report");
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    public void onReceivedError(String str) {
        Report report2 = this.report;
        if (report2 != null) {
            report2.recordError(str);
            this.repository.save(this.report, this.repoCallback);
        }
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onReceivedError", str);
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    private void handleWebViewException(int i) {
        WebAdContract$WebAdView webAdContract$WebAdView = this.adView;
        if (webAdContract$WebAdView != null) {
            webAdContract$WebAdView.removeWebView();
        }
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#handleWebViewException", "WebViewException: " + new VungleException(i).getLocalizedMessage());
        reportErrorAndCloseAd(i);
    }

    private void reportErrorAndCloseAd(int i) {
        makeBusError(i);
        closeView();
    }

    /* access modifiers changed from: private */
    public void makeBusError(int i) {
        AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }
}
