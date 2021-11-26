package com.mopub.common;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.iab.omid.library.mopub.Omid;
import com.iab.omid.library.mopub.ScriptInjector;
import com.iab.omid.library.mopub.adsession.Partner;
import com.mopub.common.logging.MoPubLog;
import java.util.Set;

public class ViewabilityManager {
    private static final ViewabilityScriptLoader sScriptLoader = new ViewabilityScriptLoader();
    private static boolean sViewabilityEnabled = true;
    private Partner mPartner;

    private static class Helper {
        /* access modifiers changed from: private */
        public static ViewabilityManager sInstance = new ViewabilityManager();
    }

    private ViewabilityManager() {
    }

    private static ViewabilityManager getInstance() {
        return Helper.sInstance;
    }

    public static void activate(Context context) {
        Preconditions.checkUiThread("activate() must be called on the UI thread.");
        Preconditions.checkNotNull(context);
        getInstance().init(context);
    }

    static boolean isActive() {
        Preconditions.checkUiThread("isActive() must be called on the UI thread.");
        return getInstance().isActiveImpl();
    }

    static String getOmidVersion() {
        Preconditions.checkUiThread("getOmidVersion() must be called on the UI thread.");
        return Omid.getVersion();
    }

    static void disableViewability() {
        sViewabilityEnabled = false;
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "OMSDK Viewability has been disabled");
    }

    public static boolean isViewabilityEnabled() {
        return sViewabilityEnabled;
    }

    static String getOmidJsServiceContent() {
        return sScriptLoader.getOmidJsServiceContent();
    }

    static Partner getPartner() {
        return getInstance().mPartner;
    }

    public static String injectScriptContentIntoHtml(String str) {
        Preconditions.checkUiThread();
        Preconditions.checkNotNull(str);
        if (!isViewabilityEnabled()) {
            return str;
        }
        try {
            return ScriptInjector.injectScriptContentIntoHtml(getOmidJsServiceContent(), str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Failed to inject OM script into HTML. ", e);
            return str;
        }
    }

    static String injectScriptUrlIntoHtml(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        if (!isViewabilityEnabled()) {
            return str;
        }
        String str3 = "<script src=\"" + str2 + "\"></script>";
        try {
            String injectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml("cfc10ccaf0724c4cbc6122cf51421f03", str);
            String replace = injectScriptContentIntoHtml.replace("<script type=\"text/javascript\">cfc10ccaf0724c4cbc6122cf51421f03</script>", str3);
            if (!replace.equals(injectScriptContentIntoHtml)) {
                return replace;
            }
            return str;
        } catch (IllegalArgumentException | IllegalStateException e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Failed to inject script URL into HTML. ", e);
        }
    }

    public static String injectVerificationUrlsIntoHtml(String str, Set<ViewabilityVendor> set) {
        Preconditions.checkNotNull(str);
        if (set != null && !TextUtils.isEmpty(str)) {
            for (ViewabilityVendor next : set) {
                if (next != null) {
                    str = injectScriptUrlIntoHtml(str, next.getJavascriptResourceUrl().toString());
                }
            }
        }
        return str;
    }

    private void init(Context context) {
        if (this.mPartner != null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "ViewabilityManager already initialized.");
            return;
        }
        try {
            Omid.activate(context.getApplicationContext());
            this.mPartner = Partner.createPartner(AppLovinMediationProvider.MOPUB, MoPub.SDK_VERSION);
        } catch (IllegalArgumentException e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "createPartner() ", e);
        }
    }

    private boolean isActiveImpl() {
        try {
            return sViewabilityEnabled && Omid.isActive() && this.mPartner != null;
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "isActive() ", e);
            return false;
        }
    }

    public static void setViewabilityEnabled(boolean z) {
        sViewabilityEnabled = z;
    }
}
