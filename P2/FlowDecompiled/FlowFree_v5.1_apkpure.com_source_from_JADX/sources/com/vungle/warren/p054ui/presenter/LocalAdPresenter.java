package com.vungle.warren.p054ui.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.vungle.warren.SessionData;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.p054ui.DurationRecorder;
import com.vungle.warren.p054ui.PresenterAppLeftCallback;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.p054ui.contract.LocalAdContract$LocalPresenter;
import com.vungle.warren.p054ui.contract.LocalAdContract$LocalView;
import com.vungle.warren.p054ui.state.OptionsState;
import com.vungle.warren.p054ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.LocalAdPresenter */
public class LocalAdPresenter implements LocalAdContract$LocalPresenter, WebViewAPI.WebClientErrorHandler {
    /* access modifiers changed from: private */
    public LocalAdContract$LocalView adView;
    private boolean adViewed;
    /* access modifiers changed from: private */
    public Advertisement advertisement;
    /* access modifiers changed from: private */
    public final AdAnalytics analytics;
    private File assetDir;
    private AdContract$AdvertisementPresenter.EventListener bus;
    private AtomicBoolean busy = new AtomicBoolean(false);
    private LinkedList<Advertisement.Checkpoint> checkpointList = new LinkedList<>();
    private final Map<String, Cookie> cookies = new HashMap();
    private String dialogBody = "If you exit now, you will not get your reward";
    private String dialogClose = "Close";
    private String dialogContinue = "Continue";
    private String dialogTitle = "Are you sure?";
    private int duration;
    private DurationRecorder durationRecorder;
    private AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    /* access modifiers changed from: private */
    public boolean inPost;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private boolean muted;
    private Placement placement;
    private int progress;
    private Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        boolean errorHappened = false;

        public void onSaved() {
        }

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                LocalAdPresenter.this.makeBusError(26);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
                LocalAdPresenter.this.closeAndReport();
            }
        }
    };
    private Report report;
    /* access modifiers changed from: private */
    public Repository repository;
    private final Scheduler scheduler;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private SessionData sessionData;
    /* access modifiers changed from: private */
    public boolean userExitEnabled;
    private int videoPosition;
    private final WebViewAPI webViewAPI;

    public LocalAdPresenter(Advertisement advertisement2, Placement placement2, Repository repository2, Scheduler scheduler2, AdAnalytics adAnalytics, WebViewAPI webViewAPI2, OptionsState optionsState, File file, SessionData sessionData2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webViewAPI = webViewAPI2;
        this.repository = repository2;
        this.assetDir = file;
        this.sessionData = sessionData2;
        if (advertisement2.getCheckpoints() != null) {
            this.checkpointList.addAll(advertisement2.getCheckpoints());
            Collections.sort(this.checkpointList);
        }
        loadData(optionsState);
    }

    public void setEventListener(AdContract$AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    private void reportError(String str) {
        this.report.recordError(str);
        this.repository.save(this.report, this.repoCallback);
        makeBusError(27);
        if (this.inPost || !this.advertisement.hasPostroll()) {
            makeBusError(10);
            this.adView.close();
            return;
        }
        playPost();
    }

    public void reportAction(String str, String str2) {
        if (str.equals("videoLength")) {
            int parseInt = Integer.parseInt(str2);
            this.duration = parseInt;
            this.report.setVideoLength((long) parseInt);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -840405966:
                if (str.equals("unmute")) {
                    c = 0;
                    break;
                }
                break;
            case 3363353:
                if (str.equals("mute")) {
                    c = 1;
                    break;
                }
                break;
            case 1370606900:
                if (str.equals("video_close")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                this.analytics.ping(this.advertisement.getTpatUrls(str));
                break;
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void onViewConfigurationChanged() {
        this.webViewAPI.notifyPropertiesChange(true);
        this.adView.refreshDialogIfVisible();
    }

    public void attach(LocalAdContract$LocalView localAdContract$LocalView, OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = localAdContract$LocalView;
        localAdContract$LocalView.setPresenter(this);
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            if ((settings & 2) == 2) {
                z = true;
            }
            this.userExitEnabled = z;
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
        Log.d("LocalAdPresenter", "Requested Orientation " + i2);
        localAdContract$LocalView.setOrientation(i2);
        prepare(optionsState);
    }

    public void detach(int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.adView.destroyAdView(0);
    }

    private void playPost() {
        File file = new File(this.assetDir.getPath());
        final File file2 = new File(file.getPath() + File.separator + "index.html");
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file2, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (z) {
                    LocalAdContract$LocalView access$200 = LocalAdPresenter.this.adView;
                    access$200.showWebsite("file://" + file2.getPath());
                    LocalAdPresenter.this.analytics.ping(LocalAdPresenter.this.advertisement.getTpatUrls("postroll_view"));
                    boolean unused = LocalAdPresenter.this.inPost = true;
                    return;
                }
                LocalAdPresenter.this.makeBusError(27);
                LocalAdPresenter.this.makeBusError(10);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#playPost", "Error Rendering Postroll");
                LocalAdPresenter.this.closeAndReport();
            }
        });
    }

    private void prepare(OptionsState optionsState) {
        String str;
        restoreFromSave(optionsState);
        Cookie cookie = this.cookies.get("incentivizedTextSetByPub");
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
        this.webViewAPI.setErrorHandler(this);
        this.adView.showCTAOverlay(this.advertisement.isCtaOverlayEnabled(), this.advertisement.getCtaClickArea());
        AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("start", (String) null, this.placement.getId());
        }
    }

    private boolean needShowGDPR(Cookie cookie) {
        return cookie != null && cookie.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie.getString("consent_status"));
    }

    private void showGDPR(final Cookie cookie) {
        C30353 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                cookie.putValue("consent_status", i == -2 ? "opted_out" : i == -1 ? "opted_in" : "opted_out_by_timeout");
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "vungle_modal");
                LocalAdPresenter.this.repository.save(cookie, (Repository.SaveCallback) null);
                LocalAdPresenter.this.start();
            }
        };
        cookie.putValue("consent_status", "opted_out_by_timeout");
        cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        cookie.putValue("consent_source", "vungle_modal");
        this.repository.save(cookie, this.repoCallback);
        showDialog(cookie.getString("consent_title"), cookie.getString("consent_message"), cookie.getString("button_accept"), cookie.getString("button_deny"), r5);
    }

    public boolean handleExit() {
        if (this.inPost) {
            closeAndReport();
            return true;
        } else if (!this.userExitEnabled) {
            return false;
        } else {
            if (!this.placement.isIncentivized() || this.progress > 75) {
                reportAction("video_close", (String) null);
                if (this.advertisement.hasPostroll()) {
                    playPost();
                    return false;
                }
                closeAndReport();
                return true;
            }
            showIncetivizedDialog();
            return false;
        }
    }

    private void showIncetivizedDialog() {
        String str = this.dialogTitle;
        String str2 = this.dialogBody;
        String str3 = this.dialogContinue;
        String str4 = this.dialogClose;
        Cookie cookie = this.cookies.get("incentivizedTextSetByPub");
        if (cookie != null) {
            str = cookie.getString("title") == null ? this.dialogTitle : cookie.getString("title");
            str2 = cookie.getString("body") == null ? this.dialogBody : cookie.getString("body");
            str3 = cookie.getString("continue") == null ? this.dialogContinue : cookie.getString("continue");
            str4 = cookie.getString("close") == null ? this.dialogClose : cookie.getString("close");
        }
        showDialog(str, str2, str3, str4, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    LocalAdPresenter.this.reportAction("video_close", (String) null);
                    LocalAdPresenter.this.continueWithPostroll();
                }
            }
        });
    }

    private void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.adView.pauseVideo();
        this.adView.showDialog(str, str2, str3, str4, onClickListener);
    }

    /* access modifiers changed from: private */
    public void continueWithPostroll() {
        if (this.advertisement.hasPostroll()) {
            playPost();
        } else {
            closeAndReport();
        }
    }

    private boolean isWebPageBlank() {
        String websiteUrl = this.adView.getWebsiteUrl();
        return TextUtils.isEmpty(websiteUrl) || "about:blank".equalsIgnoreCase(websiteUrl);
    }

    public void start() {
        this.durationRecorder.start();
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#start", new VungleException(31).getLocalizedMessage());
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        Cookie cookie = this.cookies.get("consentIsImportantToVungle");
        if (needShowGDPR(cookie)) {
            showGDPR(cookie);
        } else if (this.inPost) {
            if (isWebPageBlank()) {
                playPost();
            }
        } else if (!this.adView.isVideoPlaying() && !this.adView.isDialogVisible()) {
            this.adView.playVideo(new File(this.assetDir.getPath() + File.separator + "video"), this.muted, this.videoPosition);
            int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
            if (showCloseDelay > 0) {
                this.scheduler.schedule(new Runnable() {
                    public void run() {
                        boolean unused = LocalAdPresenter.this.userExitEnabled = true;
                        if (!LocalAdPresenter.this.inPost) {
                            LocalAdPresenter.this.adView.showCloseButton();
                        }
                    }
                }, (long) showCloseDelay);
                return;
            }
            this.userExitEnabled = true;
            this.adView.showCloseButton();
        }
    }

    public void stop(int i) {
        this.durationRecorder.stop();
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        this.adView.pauseWeb();
        if (this.adView.isVideoPlaying()) {
            this.videoPosition = this.adView.getVideoPosition();
            this.adView.pauseVideo();
        }
        if (z2 || !z) {
            if (this.inPost || z) {
                this.adView.showWebsite("about:blank");
            }
        } else if (!this.isDestroying.getAndSet(true)) {
            String str = null;
            reportAction("close", (String) null);
            this.scheduler.cancelAll();
            AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void onProgressUpdate(int i, float f) {
        this.progress = (int) ((((float) i) / f) * 100.0f);
        this.videoPosition = i;
        this.durationRecorder.update();
        AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext("percentViewed:" + this.progress, (String) null, this.placement.getId());
        }
        AdContract$AdvertisementPresenter.EventListener eventListener2 = this.bus;
        if (eventListener2 != null && i > 0 && !this.adViewed) {
            this.adViewed = true;
            eventListener2.onNext("adViewed", (String) null, this.placement.getId());
        }
        reportAction("video_viewed", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)}));
        if (this.progress == 100) {
            if (this.checkpointList.peekLast() != null && this.checkpointList.peekLast().getPercentage() == 100) {
                this.analytics.ping(this.checkpointList.pollLast().getUrls());
            }
            continueWithPostroll();
        }
        this.report.recordProgress(this.videoPosition);
        this.repository.save(this.report, this.repoCallback);
        while (this.checkpointList.peek() != null && this.progress > this.checkpointList.peek().getPercentage()) {
            this.analytics.ping(this.checkpointList.poll().getUrls());
        }
        Cookie cookie = this.cookies.get("configSettings");
        if (this.placement.isIncentivized() && this.progress > 75 && cookie != null && cookie.getBoolean("isReportIncentivizedEnabled").booleanValue() && !this.sendReportIncentivized.getAndSet(true)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("placement_reference_id", new JsonPrimitive(this.placement.getId()));
            jsonObject.add("app_id", new JsonPrimitive(this.advertisement.getAppID()));
            jsonObject.add("adStartTime", new JsonPrimitive((Number) Long.valueOf(this.report.getAdStartTime())));
            jsonObject.add("user", new JsonPrimitive(this.report.getUserID()));
            this.analytics.mo27243ri(jsonObject);
        }
    }

    public void onVideoStart(int i, float f) {
        reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf((int) f)}));
    }

    public void onMute(boolean z) {
        this.muted = z;
        if (z) {
            reportAction("mute", "true");
        } else {
            reportAction("unmute", "false");
        }
    }

    public void onDownload() {
        download();
    }

    public boolean onMediaError(String str) {
        reportError(str);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onMediaError", "Media Error: " + str);
        return false;
    }

    public void onPrivacy() {
        this.adView.open("https://vungle.com/privacy/", new PresenterAppLeftCallback(this.bus, this.placement));
    }

    public void generateSaveState(OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            Report report2 = this.report;
            optionsState.put("saved_report", report2 == null ? null : report2.getId());
            optionsState.put("incentivized_sent", this.sendReportIncentivized.get());
            optionsState.put("in_post_roll", this.inPost);
            optionsState.put("is_muted_mode", this.muted);
            LocalAdContract$LocalView localAdContract$LocalView = this.adView;
            optionsState.put("videoPosition", (localAdContract$LocalView == null || !localAdContract$LocalView.isVideoPlaying()) ? this.videoPosition : this.adView.getVideoPosition());
        }
    }

    public void restoreFromSave(OptionsState optionsState) {
        if (optionsState != null) {
            if (optionsState.getBoolean("incentivized_sent", false)) {
                this.sendReportIncentivized.set(true);
            }
            this.inPost = optionsState.getBoolean("in_post_roll", this.inPost);
            this.muted = optionsState.getBoolean("is_muted_mode", this.muted);
            this.videoPosition = optionsState.getInt("videoPosition", this.videoPosition).intValue();
        }
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
                closeAndReport();
                return;
            case 2:
                download();
                closeAndReport();
                return;
            default:
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onMraidAction", "Unknown MRAID Command");
                throw new IllegalArgumentException("Unknown action " + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006e A[Catch:{ ActivityNotFoundException -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void download() {
        /*
            r6 = this;
            java.lang.String r0 = "LocalAdPresenter"
            java.lang.String r1 = "cta"
            java.lang.String r2 = ""
            r6.reportAction(r1, r2)
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r3 = "postroll_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007c }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r3 = "click_url"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007c }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r3 = "video_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007c }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007c }
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Advertisement r4 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r2 = r4.getCTAURL(r2)     // Catch:{ ActivityNotFoundException -> 0x007c }
            r4 = 0
            r3[r4] = r2     // Catch:{ ActivityNotFoundException -> 0x007c }
            r1.ping(r3)     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r1 = "download"
            r2 = 0
            r6.reportAction(r1, r2)     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Advertisement r1 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r1 = r1.getCTAURL(r4)     // Catch:{ ActivityNotFoundException -> 0x007c }
            if (r1 == 0) goto L_0x0065
            boolean r2 = r1.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x007c }
            if (r2 == 0) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            com.vungle.warren.ui.contract.LocalAdContract$LocalView r2 = r6.adView     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x007c }
            com.vungle.warren.model.Placement r5 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x007c }
            r3.<init>(r4, r5)     // Catch:{ ActivityNotFoundException -> 0x007c }
            r2.open(r1, r3)     // Catch:{ ActivityNotFoundException -> 0x007c }
            goto L_0x006a
        L_0x0065:
            java.lang.String r1 = "CTA destination URL is not configured properly"
            android.util.Log.e(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x007c }
        L_0x006a:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x007c }
            if (r1 == 0) goto L_0x009d
            java.lang.String r2 = "open"
            java.lang.String r3 = "adClick"
            com.vungle.warren.model.Placement r4 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x007c }
            java.lang.String r4 = r4.getId()     // Catch:{ ActivityNotFoundException -> 0x007c }
            r1.onNext(r2, r3, r4)     // Catch:{ ActivityNotFoundException -> 0x007c }
            goto L_0x009d
        L_0x007c:
            java.lang.String r1 = "Unable to find destination activity"
            android.util.Log.e(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.LocalAdPresenter> r1 = com.vungle.warren.p054ui.presenter.LocalAdPresenter.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "#download"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Download - Activity Not Found"
            com.vungle.warren.VungleLogger.error(r0, r1)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p054ui.presenter.LocalAdPresenter.download():void");
    }

    /* access modifiers changed from: private */
    public void closeAndReport() {
        if (this.busy.get()) {
            Log.w("LocalAdPresenter", "Busy with closing");
            return;
        }
        this.busy.set(true);
        reportAction("close", (String) null);
        this.scheduler.cancelAll();
        this.adView.close();
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookies.put("incentivizedTextSetByPub", this.repository.load("incentivizedTextSetByPub", cls).get());
        this.cookies.put("consentIsImportantToVungle", this.repository.load("consentIsImportantToVungle", cls).get());
        this.cookies.put("configSettings", this.repository.load("configSettings", cls).get());
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
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "onReceivedError", str);
        }
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    private void handleWebViewException(int i) {
        LocalAdContract$LocalView localAdContract$LocalView = this.adView;
        if (localAdContract$LocalView != null) {
            localAdContract$LocalView.removeWebView();
        }
        reportErrorAndCloseAd(i);
    }

    private void reportErrorAndCloseAd(int i) {
        makeBusError(i);
        String simpleName = LocalAdPresenter.class.getSimpleName();
        VungleLogger.error(simpleName, "WebViewException: " + new VungleException(i).getLocalizedMessage());
        closeAndReport();
    }

    /* access modifiers changed from: private */
    public void makeBusError(int i) {
        AdContract$AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }
}
