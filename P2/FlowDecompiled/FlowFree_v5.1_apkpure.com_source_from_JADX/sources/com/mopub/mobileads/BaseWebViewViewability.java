package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.ViewabilityManager;
import com.mopub.common.logging.MoPubLog;

public class BaseWebViewViewability extends BaseWebView {
    protected boolean automaticImpression = true;
    protected ExternalViewabilitySessionManager externalViewabilityTracker = ExternalViewabilitySessionManager.create();
    protected boolean pageLoaded = false;
    protected boolean pageVisible = false;
    protected State state = State.INIT;
    protected boolean viewabilityEnabled = ViewabilityManager.isViewabilityEnabled();

    protected enum State {
        INIT,
        STARTED,
        IMPRESSED,
        STOPPED
    }

    public BaseWebViewViewability(Context context) {
        super(context);
        if (this.viewabilityEnabled) {
            this.delayDestroy = true;
        }
        log("BaseWebViewViewability() " + this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void changeState(com.mopub.mobileads.BaseWebViewViewability.State r5) {
        /*
            r4 = this;
            boolean r0 = r4.viewabilityEnabled
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            int[] r1 = com.mopub.mobileads.BaseWebViewViewability.C25311.$SwitchMap$com$mopub$mobileads$BaseWebViewViewability$State
            int r2 = r5.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x0038
            r3 = 2
            if (r1 == r3) goto L_0x0028
            r3 = 3
            if (r1 == r3) goto L_0x0018
            goto L_0x004d
        L_0x0018:
            com.mopub.mobileads.BaseWebViewViewability$State r1 = r4.state
            com.mopub.mobileads.BaseWebViewViewability$State r3 = com.mopub.mobileads.BaseWebViewViewability.State.INIT
            if (r1 == r3) goto L_0x004d
            com.mopub.mobileads.BaseWebViewViewability$State r3 = com.mopub.mobileads.BaseWebViewViewability.State.STOPPED
            if (r1 == r3) goto L_0x004d
            com.mopub.common.ExternalViewabilitySessionManager r0 = r4.externalViewabilityTracker
            r0.endSession()
            goto L_0x004c
        L_0x0028:
            com.mopub.mobileads.BaseWebViewViewability$State r1 = r4.state
            com.mopub.mobileads.BaseWebViewViewability$State r3 = com.mopub.mobileads.BaseWebViewViewability.State.STARTED
            if (r1 != r3) goto L_0x004d
            boolean r1 = r4.pageVisible
            if (r1 == 0) goto L_0x004d
            com.mopub.common.ExternalViewabilitySessionManager r0 = r4.externalViewabilityTracker
            r0.trackImpression()
            goto L_0x004c
        L_0x0038:
            com.mopub.mobileads.BaseWebViewViewability$State r1 = r4.state
            com.mopub.mobileads.BaseWebViewViewability$State r3 = com.mopub.mobileads.BaseWebViewViewability.State.INIT
            if (r1 != r3) goto L_0x004d
            boolean r1 = r4.pageLoaded
            if (r1 == 0) goto L_0x004d
            com.mopub.common.ExternalViewabilitySessionManager r0 = r4.externalViewabilityTracker
            r0.createWebViewSession(r4)
            com.mopub.common.ExternalViewabilitySessionManager r0 = r4.externalViewabilityTracker
            r0.startSession()
        L_0x004c:
            r0 = 1
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            r4.state = r5
            goto L_0x0070
        L_0x0052:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Skip state transition "
            r0.append(r1)
            com.mopub.mobileads.BaseWebViewViewability$State r1 = r4.state
            r0.append(r1)
            java.lang.String r1 = " to "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.log(r5)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.BaseWebViewViewability.changeState(com.mopub.mobileads.BaseWebViewViewability$State):void");
    }

    /* renamed from: com.mopub.mobileads.BaseWebViewViewability$1 */
    static /* synthetic */ class C25311 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mobileads$BaseWebViewViewability$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mopub.mobileads.BaseWebViewViewability$State[] r0 = com.mopub.mobileads.BaseWebViewViewability.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$mobileads$BaseWebViewViewability$State = r0
                com.mopub.mobileads.BaseWebViewViewability$State r1 = com.mopub.mobileads.BaseWebViewViewability.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$mobileads$BaseWebViewViewability$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.mobileads.BaseWebViewViewability$State r1 = com.mopub.mobileads.BaseWebViewViewability.State.IMPRESSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$mobileads$BaseWebViewViewability$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.mobileads.BaseWebViewViewability$State r1 = com.mopub.mobileads.BaseWebViewViewability.State.STOPPED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.BaseWebViewViewability.C25311.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        log("onAttachedToWindow() " + this);
        if (this.pageLoaded) {
            changeState(State.STARTED);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        changeState(State.STOPPED);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        log("onVisibilityChanged: " + i + " " + this);
        this.pageVisible = i == 0;
        if (this.automaticImpression) {
            changeState(State.IMPRESSED);
        }
    }

    public void disableTracking() {
        this.viewabilityEnabled = false;
    }

    public void enableTracking() {
        this.viewabilityEnabled = true;
    }

    public void disableAutomaticImpression() {
        this.automaticImpression = false;
    }

    public void setPageLoaded() {
        log("setPageLoaded() " + this);
        this.pageLoaded = true;
        changeState(State.STARTED);
        if (this.automaticImpression) {
            changeState(State.IMPRESSED);
        }
    }

    public void notifyImpression() {
        changeState(State.IMPRESSED);
    }

    /* access modifiers changed from: package-private */
    public void setMockExternalTracker(ExternalViewabilitySessionManager externalViewabilitySessionManager) {
        this.externalViewabilityTracker = externalViewabilitySessionManager;
    }

    private void log(String str) {
        if (ViewabilityManager.isViewabilityEnabled()) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "OMSDK " + str);
        }
    }
}
