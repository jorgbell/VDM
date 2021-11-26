package com.mopub.common.privacy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.privacy.ConsentDialogLayout;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.MoPubErrorCode;

public class ConsentDialogActivity extends Activity {
    Handler mCloseButtonHandler;
    ConsentStatus mConsentStatus;
    private Runnable mEnableCloseButtonRunnable;
    ConsentDialogLayout mView;

    static void start(Context context, String str) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(str)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "ConsentDialogActivity htmlData can't be empty string.");
            MoPubLog.ConsentLogEvent consentLogEvent = MoPubLog.ConsentLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(consentLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            return;
        }
        try {
            Intents.startActivity(context, createIntent(context, str));
        } catch (ActivityNotFoundException | IntentNotResolvableException unused) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "ConsentDialogActivity not found - did you declare it in AndroidManifest.xml?");
            MoPubLog.ConsentLogEvent consentLogEvent2 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(consentLogEvent2, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
        }
    }

    static Intent createIntent(Context context, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Bundle bundle = new Bundle();
        bundle.putString("html-page-content", str);
        return Intents.getStartActivityIntent(context, ConsentDialogActivity.class, bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("html-page-content");
        if (TextUtils.isEmpty(stringExtra)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Web page for ConsentDialogActivity is empty");
            MoPubLog.ConsentLogEvent consentLogEvent = MoPubLog.ConsentLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(consentLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        try {
            ConsentDialogLayout consentDialogLayout = new ConsentDialogLayout(this);
            this.mView = consentDialogLayout;
            consentDialogLayout.setConsentClickListener(new ConsentDialogLayout.ConsentListener() {
                public void onConsentClick(ConsentStatus consentStatus) {
                    ConsentDialogActivity.this.saveConsentStatus(consentStatus);
                    ConsentDialogActivity.this.setCloseButtonVisibility(false);
                }

                public void onCloseClick() {
                    ConsentDialogActivity.this.finish();
                }
            });
            this.mEnableCloseButtonRunnable = new Runnable() {
                public void run() {
                    ConsentDialogActivity.this.setCloseButtonVisibility(true);
                }
            };
            setContentView(this.mView);
            this.mView.startLoading(stringExtra, new ConsentDialogLayout.PageLoadListener(this) {
                public void onLoadProgress(int i) {
                    int i2 = ConsentDialogLayout.FINISHED_LOADING;
                }
            });
        } catch (RuntimeException e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Unable to create WebView", e);
            MoPubLog.ConsentLogEvent consentLogEvent2 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(consentLogEvent2, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Handler handler = new Handler();
        this.mCloseButtonHandler = handler;
        handler.postDelayed(this.mEnableCloseButtonRunnable, 10000);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MoPubLog.log(MoPubLog.ConsentLogEvent.SHOW_SUCCESS, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        setCloseButtonVisibility(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ConsentStatus consentStatus;
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (!(personalInformationManager == null || (consentStatus = this.mConsentStatus) == null)) {
            personalInformationManager.changeConsentStateFromDialog(consentStatus);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void setCloseButtonVisibility(boolean z) {
        Handler handler = this.mCloseButtonHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mEnableCloseButtonRunnable);
        }
        ConsentDialogLayout consentDialogLayout = this.mView;
        if (consentDialogLayout != null) {
            consentDialogLayout.setCloseVisible(z);
        }
    }

    /* access modifiers changed from: private */
    public void saveConsentStatus(ConsentStatus consentStatus) {
        Preconditions.checkNotNull(consentStatus);
        this.mConsentStatus = consentStatus;
    }
}
