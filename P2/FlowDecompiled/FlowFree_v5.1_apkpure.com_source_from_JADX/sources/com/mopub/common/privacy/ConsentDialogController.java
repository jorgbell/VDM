package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentDialogRequest;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.VolleyError;

public class ConsentDialogController implements ConsentDialogRequest.Listener {
    private final Context mAppContext;
    private ConsentDialogListener mExtListener;
    private final Handler mHandler = new Handler();
    private String mHtmlBody;
    volatile boolean mReady;
    volatile boolean mRequestInFlight;

    ConsentDialogController(Context context) {
        Preconditions.checkNotNull(context);
        this.mAppContext = context.getApplicationContext();
    }

    public void onSuccess(ConsentDialogResponse consentDialogResponse) {
        this.mRequestInFlight = false;
        String html = consentDialogResponse.getHtml();
        this.mHtmlBody = html;
        if (TextUtils.isEmpty(html)) {
            this.mReady = false;
            if (this.mExtListener != null) {
                MoPubLog.ConsentLogEvent consentLogEvent = MoPubLog.ConsentLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                MoPubLog.log(consentLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                this.mExtListener.onConsentDialogLoadFailed(moPubErrorCode);
                return;
            }
            return;
        }
        MoPubLog.log(MoPubLog.ConsentLogEvent.LOAD_SUCCESS, new Object[0]);
        this.mReady = true;
        ConsentDialogListener consentDialogListener = this.mExtListener;
        if (consentDialogListener != null) {
            consentDialogListener.onConsentDialogLoaded();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        ConsentDialogListener consentDialogListener = this.mExtListener;
        resetState();
        if (consentDialogListener != null) {
            if (volleyError instanceof MoPubNetworkError) {
                if (C25012.$SwitchMap$com$mopub$network$MoPubNetworkError$Reason[((MoPubNetworkError) volleyError).getReason().ordinal()] != 1) {
                    MoPubLog.ConsentLogEvent consentLogEvent = MoPubLog.ConsentLogEvent.LOAD_FAILED;
                    MoPubErrorCode moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                    MoPubLog.log(consentLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                } else {
                    MoPubLog.ConsentLogEvent consentLogEvent2 = MoPubLog.ConsentLogEvent.LOAD_FAILED;
                    MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.INTERNAL_ERROR;
                    MoPubLog.log(consentLogEvent2, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
                    consentDialogListener.onConsentDialogLoadFailed(moPubErrorCode2);
                    return;
                }
            }
            consentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.UNSPECIFIED);
        }
    }

    /* renamed from: com.mopub.common.privacy.ConsentDialogController$2 */
    static /* synthetic */ class C25012 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$network$MoPubNetworkError$Reason;

        static {
            int[] iArr = new int[MoPubNetworkError.Reason.values().length];
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = iArr;
            try {
                iArr[MoPubNetworkError.Reason.BAD_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadConsentDialog(final com.mopub.common.privacy.ConsentDialogListener r6, java.lang.Boolean r7, com.mopub.common.privacy.PersonalInfoData r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.mopub.common.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0070 }
            boolean r0 = r5.mReady     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0016
            if (r6 == 0) goto L_0x0014
            android.os.Handler r7 = r5.mHandler     // Catch:{ all -> 0x0070 }
            com.mopub.common.privacy.ConsentDialogController$1 r8 = new com.mopub.common.privacy.ConsentDialogController$1     // Catch:{ all -> 0x0070 }
            r8.<init>(r5, r6)     // Catch:{ all -> 0x0070 }
            r7.post(r8)     // Catch:{ all -> 0x0070 }
        L_0x0014:
            monitor-exit(r5)
            return
        L_0x0016:
            boolean r0 = r5.mRequestInFlight     // Catch:{ all -> 0x0070 }
            r1 = 1
            if (r0 == 0) goto L_0x0029
            com.mopub.common.logging.MoPubLog$SdkLogEvent r6 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ all -> 0x0070 }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x0070 }
            r8 = 0
            java.lang.String r0 = "Already making a consent dialog load request."
            r7[r8] = r0     // Catch:{ all -> 0x0070 }
            com.mopub.common.logging.MoPubLog.log(r6, r7)     // Catch:{ all -> 0x0070 }
            monitor-exit(r5)
            return
        L_0x0029:
            r5.mExtListener = r6     // Catch:{ all -> 0x0070 }
            r5.mRequestInFlight = r1     // Catch:{ all -> 0x0070 }
            com.mopub.common.privacy.ConsentDialogRequest r6 = new com.mopub.common.privacy.ConsentDialogRequest     // Catch:{ all -> 0x0070 }
            android.content.Context r0 = r5.mAppContext     // Catch:{ all -> 0x0070 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r1 = new com.mopub.common.privacy.ConsentDialogUrlGenerator     // Catch:{ all -> 0x0070 }
            android.content.Context r2 = r5.mAppContext     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = r8.getAdUnitId()     // Catch:{ all -> 0x0070 }
            com.mopub.common.privacy.ConsentStatus r4 = r8.getConsentStatus()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r4.getValue()     // Catch:{ all -> 0x0070 }
            r1.<init>(r2, r3, r4)     // Catch:{ all -> 0x0070 }
            r1.withGdprApplies(r7)     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = r8.getConsentedPrivacyPolicyVersion()     // Catch:{ all -> 0x0070 }
            r1.withConsentedPrivacyPolicyVersion(r7)     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = r8.getConsentedVendorListVersion()     // Catch:{ all -> 0x0070 }
            r1.withConsentedVendorListVersion(r7)     // Catch:{ all -> 0x0070 }
            boolean r7 = r8.isForceGdprApplies()     // Catch:{ all -> 0x0070 }
            r1.withForceGdprApplies(r7)     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = com.mopub.common.Constants.HOST     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = r1.generateUrlString(r7)     // Catch:{ all -> 0x0070 }
            r6.<init>(r0, r7, r5)     // Catch:{ all -> 0x0070 }
            android.content.Context r7 = r5.mAppContext     // Catch:{ all -> 0x0070 }
            com.mopub.network.MoPubRequestQueue r7 = com.mopub.network.C2676Networking.getRequestQueue(r7)     // Catch:{ all -> 0x0070 }
            r7.add(r6)     // Catch:{ all -> 0x0070 }
            monitor-exit(r5)
            return
        L_0x0070:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.privacy.ConsentDialogController.loadConsentDialog(com.mopub.common.privacy.ConsentDialogListener, java.lang.Boolean, com.mopub.common.privacy.PersonalInfoData):void");
    }

    /* access modifiers changed from: package-private */
    public boolean showConsentDialog() {
        MoPubLog.log(MoPubLog.ConsentLogEvent.SHOW_ATTEMPTED, new Object[0]);
        if (!this.mReady || TextUtils.isEmpty(this.mHtmlBody)) {
            MoPubLog.ConsentLogEvent consentLogEvent = MoPubLog.ConsentLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(consentLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            return false;
        }
        this.mReady = false;
        ConsentDialogActivity.start(this.mAppContext, this.mHtmlBody);
        resetState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isReady() {
        return this.mReady;
    }

    private void resetState() {
        this.mRequestInFlight = false;
        this.mReady = false;
        this.mExtListener = null;
        this.mHtmlBody = null;
    }
}
