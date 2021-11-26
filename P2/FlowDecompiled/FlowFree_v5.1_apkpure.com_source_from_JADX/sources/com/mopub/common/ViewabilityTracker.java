package com.mopub.common;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.mopub.adsession.AdEvents;
import com.iab.omid.library.mopub.adsession.AdSession;
import com.iab.omid.library.mopub.adsession.AdSessionConfiguration;
import com.iab.omid.library.mopub.adsession.AdSessionContext;
import com.iab.omid.library.mopub.adsession.CreativeType;
import com.iab.omid.library.mopub.adsession.ImpressionType;
import com.iab.omid.library.mopub.adsession.Owner;
import com.iab.omid.library.mopub.adsession.Partner;
import com.iab.omid.library.mopub.adsession.VerificationScriptResource;
import com.iab.omid.library.mopub.adsession.media.Position;
import com.iab.omid.library.mopub.adsession.media.VastProperties;
import com.mopub.common.logging.MoPubLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class ViewabilityTracker {
    private static AtomicInteger sessionCounter = new AtomicInteger(0);
    private AdEvents adEvents;
    private AdSession adSession;
    private boolean impressionOccurred = false;
    int sessionID;
    protected STATE state;
    protected boolean tracking = false;

    protected enum STATE {
        INIT,
        STARTED,
        STARTED_VIDEO,
        IMPRESSED,
        STOPPED
    }

    /* access modifiers changed from: package-private */
    public void trackVideo(VideoEvent videoEvent) {
    }

    /* access modifiers changed from: package-private */
    public void videoPrepared(float f) {
    }

    static ViewabilityTracker createWebViewTracker(WebView webView) throws IllegalArgumentException {
        Partner partner = ViewabilityManager.getPartner();
        if (partner != null) {
            AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(partner, webView, "", ""));
            return new ViewabilityTracker(createAdSession, AdEvents.createAdEvents(createAdSession), webView);
        }
        throw new IllegalArgumentException("Parameter 'partner' may not be null.");
    }

    static ViewabilityTracker createNativeTracker(View view, Set<ViewabilityVendor> set) throws IllegalArgumentException {
        if (set.size() != 0) {
            AdSession createAdSession = createAdSession(CreativeType.NATIVE_DISPLAY, set, Owner.NONE);
            return new ViewabilityTracker(createAdSession, AdEvents.createAdEvents(createAdSession), view);
        }
        throw new IllegalArgumentException("Empty viewability vendors list.");
    }

    static AdSession createAdSession(CreativeType creativeType, Set<ViewabilityVendor> set, Owner owner) {
        Preconditions.checkNotNull(creativeType);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(owner);
        List<VerificationScriptResource> createVerificationResources = createVerificationResources(set);
        if (!createVerificationResources.isEmpty()) {
            Partner partner = ViewabilityManager.getPartner();
            if (partner != null) {
                return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(partner, ViewabilityManager.getOmidJsServiceContent(), createVerificationResources, "", ""));
            }
            throw new IllegalArgumentException("Parameter 'partner' may not be null.");
        }
        throw new IllegalArgumentException("verificationScriptResources is empty");
    }

    ViewabilityTracker(AdSession adSession2, AdEvents adEvents2, View view) {
        Preconditions.checkNotNull(adSession2);
        Preconditions.checkNotNull(adEvents2);
        Preconditions.checkNotNull(view);
        this.state = STATE.INIT;
        this.adSession = adSession2;
        this.adEvents = adEvents2;
        this.sessionID = sessionCounter.incrementAndGet();
        registerTrackedView(view);
    }

    /* access modifiers changed from: package-private */
    public boolean isTracking() {
        return this.tracking;
    }

    /* renamed from: com.mopub.common.ViewabilityTracker$1 */
    static /* synthetic */ class C24931 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$common$ViewabilityTracker$STATE;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mopub.common.ViewabilityTracker$STATE[] r0 = com.mopub.common.ViewabilityTracker.STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$common$ViewabilityTracker$STATE = r0
                com.mopub.common.ViewabilityTracker$STATE r1 = com.mopub.common.ViewabilityTracker.STATE.STARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$common$ViewabilityTracker$STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.common.ViewabilityTracker$STATE r1 = com.mopub.common.ViewabilityTracker.STATE.STARTED_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$common$ViewabilityTracker$STATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.common.ViewabilityTracker$STATE r1 = com.mopub.common.ViewabilityTracker.STATE.IMPRESSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$mopub$common$ViewabilityTracker$STATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mopub.common.ViewabilityTracker$STATE r1 = com.mopub.common.ViewabilityTracker.STATE.STOPPED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.ViewabilityTracker.C24931.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void changeState(STATE state2) {
        STATE state3;
        STATE state4;
        boolean z = false;
        if (ViewabilityManager.isActive()) {
            int i = C24931.$SwitchMap$com$mopub$common$ViewabilityTracker$STATE[state2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (!(i != 4 || (state4 = this.state) == STATE.INIT || state4 == STATE.STOPPED)) {
                            this.adSession.finish();
                            this.tracking = false;
                        }
                    } else if (!this.impressionOccurred && ((state3 = this.state) == STATE.STARTED || state3 == STATE.STARTED_VIDEO)) {
                        this.adEvents.impressionOccurred();
                        this.impressionOccurred = true;
                    }
                } else if (this.state == STATE.INIT) {
                    this.adSession.start();
                    this.adEvents.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                    this.tracking = true;
                }
            } else if (this.state == STATE.INIT) {
                this.adSession.start();
                this.adEvents.loaded();
                this.tracking = true;
            }
            z = true;
        }
        if (z) {
            this.state = state2;
            log("new state: " + this.state.name() + " " + this.sessionID);
            return;
        }
        log("skip transition from: " + this.state + " to " + state2);
    }

    /* access modifiers changed from: package-private */
    public void startTracking() {
        log("startTracking(): " + this.sessionID);
        changeState(STATE.STARTED);
    }

    /* access modifiers changed from: package-private */
    public void stopTracking() {
        log("stopTracking(): " + this.sessionID);
        changeState(STATE.STOPPED);
    }

    public void trackImpression() {
        log("trackImpression(): " + this.sessionID);
        changeState(STATE.IMPRESSED);
    }

    /* access modifiers changed from: package-private */
    public boolean hasImpressionOccurred() {
        return this.impressionOccurred;
    }

    /* access modifiers changed from: package-private */
    public void registerTrackedView(View view) {
        this.adSession.registerAdView(view);
    }

    /* access modifiers changed from: package-private */
    public void registerFriendlyObstructions(Iterable<Pair<View, ViewabilityObstruction>> iterable) {
        for (Pair next : iterable) {
            try {
                registerFriendlyObstruction((View) next.first, (ViewabilityObstruction) next.second);
            } catch (IllegalArgumentException e) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "registerFriendlyObstructions() " + e.getLocalizedMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void registerFriendlyObstruction(View view, ViewabilityObstruction viewabilityObstruction) {
        log("registerFriendlyObstruction(): " + this.sessionID);
        this.adSession.addFriendlyObstruction(view, viewabilityObstruction.value, " ");
    }

    private static List<VerificationScriptResource> createVerificationResources(Set<ViewabilityVendor> set) {
        ArrayList arrayList = new ArrayList();
        for (ViewabilityVendor next : set) {
            try {
                if (!TextUtils.isEmpty(next.getVendorKey())) {
                    if (!TextUtils.isEmpty(next.getVerificationParameters())) {
                        arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(next.getVendorKey(), next.getJavascriptResourceUrl(), next.getVerificationParameters()));
                    }
                }
                arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(next.getJavascriptResourceUrl()));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        if (ViewabilityManager.isViewabilityEnabled()) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "OMSDK " + str);
        }
    }
}
