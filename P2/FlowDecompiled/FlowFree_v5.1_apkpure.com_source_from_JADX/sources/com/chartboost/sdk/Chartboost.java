package com.chartboost.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.C1213b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.requests.models.MediationModel;
import com.chartboost.sdk.Privacy.model.CCPA;
import com.chartboost.sdk.Privacy.model.Custom;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;
import com.chartboost.sdk.Tracking.C1264c;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1305g;
import com.chartboost.sdk.impl.C1317h1;
import com.chartboost.sdk.impl.C1380v0;
import com.chartboost.sdk.impl.C1406x;
import com.chartboost.sdk.impl.C1412z;
import com.mopub.common.logging.MoPubLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chartboost {

    public enum CBFramework {
        CBFrameworkUnity("Unity"),
        CBFrameworkCorona("Corona"),
        CBFrameworkAir("AIR"),
        CBFrameworkGameSalad("GameSalad"),
        CBFrameworkCordova("Cordova"),
        CBFrameworkCocoonJS("CocoonJS"),
        CBFrameworkCocos2dx("Cocos2dx"),
        CBFrameworkPrime31Unreal("Prime31Unreal"),
        CBFrameworkWeeby("Weeby"),
        CBFrameworkOther("Other");
        

        /* renamed from: a */
        private final String f2645a;

        private CBFramework(String str) {
            this.f2645a = str;
        }

        public static CBFramework fromString(String str) {
            CBFramework cBFramework = CBFrameworkUnity;
            if (str.equals(cBFramework.toString())) {
                return cBFramework;
            }
            CBFramework cBFramework2 = CBFrameworkCorona;
            if (str.equals(cBFramework2.toString())) {
                return cBFramework2;
            }
            CBFramework cBFramework3 = CBFrameworkAir;
            if (str.equals(cBFramework3.toString())) {
                return cBFramework3;
            }
            CBFramework cBFramework4 = CBFrameworkGameSalad;
            if (str.equals(cBFramework4.toString())) {
                return cBFramework4;
            }
            CBFramework cBFramework5 = CBFrameworkCordova;
            if (str.equals(cBFramework5.toString())) {
                return cBFramework5;
            }
            CBFramework cBFramework6 = CBFrameworkCocoonJS;
            if (str.equals(cBFramework6.toString())) {
                return cBFramework6;
            }
            CBFramework cBFramework7 = CBFrameworkCocos2dx;
            if (str.equals(cBFramework7.toString())) {
                return cBFramework7;
            }
            CBFramework cBFramework8 = CBFrameworkPrime31Unreal;
            if (str.equals(cBFramework8.toString())) {
                return cBFramework8;
            }
            CBFramework cBFramework9 = CBFrameworkWeeby;
            if (str.equals(cBFramework9.toString())) {
                return cBFramework9;
            }
            CBFramework cBFramework10 = CBFrameworkOther;
            if (str.equals(cBFramework10.toString())) {
            }
            return cBFramework10;
        }

        public boolean doesWrapperUseCustomBackgroundingBehavior() {
            return this == CBFrameworkAir;
        }

        public boolean doesWrapperUseCustomShouldDisplayBehavior() {
            return this == CBFrameworkAir || this == CBFrameworkCocos2dx;
        }

        public String toString() {
            return this.f2645a;
        }
    }

    public enum CBMediation {
        CBMediationAdMarvel("AdMarvel"),
        CBMediationAdMob("AdMob"),
        CBMediationFuse("Fuse"),
        CBMediationFyber("Fyber"),
        CBMediationHeyZap("HeyZap"),
        CBMediationMoPub(MoPubLog.LOGTAG),
        CBMediationironSource("ironSource"),
        CBMediationHyprMX("HyprMX"),
        CBMediationAerServ("AerServ"),
        CBMediationHelium("Helium"),
        CBMediationFairbid("Fairbid"),
        CBMediationMAX("MAX"),
        CBMediationOther("Other");
        

        /* renamed from: a */
        private final String f2647a;

        private CBMediation(String str) {
            this.f2647a = str;
        }

        public String toString() {
            return this.f2647a;
        }
    }

    @Deprecated
    public enum CBPIDataUseConsent {
        UNKNOWN(-1, "Unknown"),
        NO_BEHAVIORAL(0, "Non behavioral"),
        YES_BEHAVIORAL(1, "Behavioral");
        

        /* renamed from: c */
        private static Map<Integer, CBPIDataUseConsent> f2648c;

        /* renamed from: d */
        private static List<CharSequence> f2649d;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f2651a;

        /* renamed from: b */
        private String f2652b;

        static {
            int i;
            f2648c = new HashMap();
            f2649d = new ArrayList();
            for (CBPIDataUseConsent cBPIDataUseConsent : values()) {
                f2648c.put(Integer.valueOf(cBPIDataUseConsent.f2651a), cBPIDataUseConsent);
                f2649d.add(cBPIDataUseConsent.f2652b);
            }
        }

        @Deprecated
        private CBPIDataUseConsent(int i, String str) {
            this.f2651a = i;
            this.f2652b = str;
        }

        @Deprecated
        public static CharSequence[] getAsCharsArray() {
            return (CharSequence[]) f2649d.toArray(new CharSequence[0]);
        }

        @Deprecated
        public static CBPIDataUseConsent getConsentByName(String str) {
            CBPIDataUseConsent cBPIDataUseConsent = NO_BEHAVIORAL;
            if (cBPIDataUseConsent.f2652b.equals(str)) {
                return cBPIDataUseConsent;
            }
            CBPIDataUseConsent cBPIDataUseConsent2 = YES_BEHAVIORAL;
            if (cBPIDataUseConsent2.f2652b.equals(str)) {
                return cBPIDataUseConsent2;
            }
            return UNKNOWN;
        }

        @Deprecated
        public int getValue() {
            return this.f2651a;
        }

        @Deprecated
        public static CBPIDataUseConsent valueOf(int i) {
            CBPIDataUseConsent cBPIDataUseConsent = f2648c.get(Integer.valueOf(i));
            return cBPIDataUseConsent == null ? UNKNOWN : cBPIDataUseConsent;
        }
    }

    private Chartboost() {
    }

    public static void addDataUseConsent(Context context, DataUseConsent dataUseConsent) {
        if (context == null || (!(dataUseConsent instanceof GDPR) && !(dataUseConsent instanceof CCPA) && !(dataUseConsent instanceof Custom))) {
            try {
                C1266e.m3223e(new C1264c("consent_subclassing_error", dataUseConsent.getClass().getName(), "", ""));
            } catch (Exception unused) {
            }
            CBLogging.m2909e("Chartboost", "Attempt to addDataUseConsent. Context and DataUseConsent cannot be null.");
            return;
        }
        C1414j.m3862a(context, dataUseConsent);
    }

    public static void cacheInterstitial(String str) {
        C1317h1.m3507a("Chartboost.cacheInterstitial", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m2905b("Chartboost", "Interstitial not supported for this Android version");
            C1272a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str)) {
                CBLogging.m2905b("Chartboost", "cacheInterstitial location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3519v;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, false, ""));
                return;
            }
            C1236h j = b.mo10717j();
            if ((!j.f2823q || !j.f2825s) && (!j.f2811e || !j.f2813g)) {
                Handler k = b.mo10718k();
                C1286a g = b.mo10714g();
                g.getClass();
                k.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (ChartboostError) null, false, ""));
                return;
            }
            C1305g gVar = b.f3518u;
            gVar.getClass();
            b.f3514q.execute(new C1305g.C1307b(3, str, (C1312h) null, (CBError.CBImpressionError) null));
        }
    }

    public static void cacheMoreApps(String str) {
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            b.getClass();
            C1414j.C1416b bVar = new C1414j.C1416b(5);
            bVar.f3526b = str;
            b.f3493B.postDelayed(bVar, C1213b.f2667b);
        }
    }

    public static void cacheRewardedVideo(String str) {
        C1317h1.m3507a("Chartboost.cacheRewardedVideo", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m2905b("Chartboost", "Rewarded video not supported for this Android version");
            C1272a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str)) {
                CBLogging.m2905b("Chartboost", "cacheRewardedVideo location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3523z;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, false, ""));
                return;
            }
            C1236h j = b.mo10717j();
            if ((!j.f2823q || !j.f2828v) && (!j.f2811e || !j.f2816j)) {
                Handler k = b.mo10718k();
                C1286a i = b.mo10716i();
                i.getClass();
                k.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (ChartboostError) null, false, ""));
                return;
            }
            C1305g gVar = b.f3522y;
            gVar.getClass();
            b.f3514q.execute(new C1305g.C1307b(3, str, (C1312h) null, (CBError.CBImpressionError) null));
        }
    }

    public static DataUseConsent clearDataUseConsent(Context context, String str) {
        if (context != null && str != null && !str.isEmpty()) {
            return C1414j.m3866b(context, str);
        }
        CBLogging.m2909e("Chartboost", "Attempt to removeDataUseConsent. Context and privacyStandard cannot be null.");
        return null;
    }

    @Deprecated
    public static void closeImpression() {
    }

    @Deprecated
    private static void forwardTouchEventsAIR(boolean z) {
    }

    public static boolean getAutoCacheAds() {
        return C1418k.f3544n;
    }

    public static String getCustomId() {
        if (!C1274c.m3270a()) {
            return "";
        }
        return C1418k.f3532b;
    }

    public static DataUseConsent getDataUseConsent(Context context, String str) {
        if (context != null && str != null && !str.isEmpty()) {
            return C1414j.m3858a(context, str);
        }
        CBLogging.m2909e("Chartboost", "Attempt to getDataUseConsent. Context and privacyStandard cannot be null.");
        return null;
    }

    public static C1272a getDelegate() {
        return C1418k.f3534d;
    }

    public static CBLogging.Level getLoggingLevel() {
        C1274c.m3270a();
        return CBLogging.f2662a;
    }

    @Deprecated
    public static CBPIDataUseConsent getPIDataUseConsent() {
        return C1380v0.f3390a;
    }

    public static String getSDKVersion() {
        return "8.2.0";
    }

    public static boolean hasInterstitial(String str) {
        C1317h1.m3507a("Chartboost.hasInterstitial", str);
        C1414j b = C1414j.m3867b();
        if (b == null || !C1274c.m3275c() || b.f3518u.mo10422f(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean hasMoreApps(String str) {
        return false;
    }

    public static boolean hasRewardedVideo(String str) {
        C1317h1.m3507a("Chartboost.hasRewardedVideo", str);
        C1414j b = C1414j.m3867b();
        if (b == null || !C1274c.m3275c() || b.f3522y.mo10422f(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean isAnyViewVisible() {
        C1317h1.m3505a("Chartboost.isAnyViewVisible");
        C1414j b = C1414j.m3867b();
        return b != null && b.f3494C.mo10310g();
    }

    public static boolean isSdkStarted() {
        C1414j b = C1414j.m3867b();
        if (b == null) {
            return false;
        }
        return b.mo10719m();
    }

    public static boolean isWebViewEnabled() {
        C1414j b = C1414j.m3867b();
        return b == null || b.f3492A.get().f2823q;
    }

    public static boolean onBackPressed() {
        C1317h1.m3505a("Chartboost.onBackPressed");
        C1414j b = C1414j.m3867b();
        if (b == null) {
            return false;
        }
        return b.f3494C.mo10311h();
    }

    @TargetApi(28)
    public static void setActivityAttrs(Activity activity) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (C1418k.f3538h) {
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.getDecorView().setSystemUiVisibility(5894);
            } else if ((window.getAttributes().flags & 1024) != 0) {
                CBLogging.m2909e("Chartboost", "Attempting to show Status and Navigation bars on a fullscreen activity. Please change your Chartboost activity theme to: \"@android:style/Theme.Translucent\"` in your Manifest file");
            }
        }
    }

    public static void setAutoCacheAds(boolean z) {
        C1317h1.m3508a("Chartboost.setAutoCacheAds", z);
        C1414j b = C1414j.m3867b();
        if (b != null) {
            b.getClass();
            C1414j.C1416b bVar = new C1414j.C1416b(1);
            bVar.f3527c = z;
            C1414j.m3873e(bVar);
        }
    }

    public static void setChartboostWrapperVersion(String str) {
        C1317h1.m3507a("Chartboost.setChartboostWrapperVersion", str);
        C1283g gVar = new C1283g(5);
        gVar.f3025d = str;
        C1414j.m3873e(gVar);
    }

    public static void setCustomId(String str) {
        C1317h1.m3507a("Chartboost.setCustomId", str);
        C1283g gVar = new C1283g(6);
        gVar.f3027f = str;
        C1414j.m3873e(gVar);
    }

    public static void setDelegate(ChartboostDelegate chartboostDelegate) {
        C1317h1.m3506a("Chartboost.setDelegate", (Object) chartboostDelegate);
        C1283g gVar = new C1283g(8);
        gVar.f3029h = chartboostDelegate;
        C1414j.m3873e(gVar);
    }

    public static void setFramework(CBFramework cBFramework, String str) {
        C1317h1.m3505a("Chartboost.setFramework");
        C1283g gVar = new C1283g(4);
        gVar.f3024c = cBFramework;
        gVar.f3025d = str;
        C1414j.m3873e(gVar);
    }

    @Deprecated
    public static void setFrameworkVersion(String str) {
        C1317h1.m3507a("Chartboost.setFrameworkVersion", str);
        C1283g gVar = new C1283g(5);
        gVar.f3025d = str;
        C1414j.m3873e(gVar);
    }

    public static void setLoggingLevel(CBLogging.Level level) {
        C1317h1.m3507a("Chartboost.setLoggingLevel", level.toString());
        C1283g gVar = new C1283g(7);
        gVar.f3028g = level;
        C1414j.m3873e(gVar);
    }

    @Deprecated
    public static void setMediation(CBMediation cBMediation, String str) {
        C1317h1.m3505a("Chartboost.setMediation.deprecated");
        setMediation(cBMediation, str, (String) null);
    }

    @Deprecated
    public static void setPIDataUseConsent(Context context, CBPIDataUseConsent cBPIDataUseConsent) {
        if (cBPIDataUseConsent == CBPIDataUseConsent.UNKNOWN) {
            clearDataUseConsent(context, GDPR.GDPR_STANDARD);
        } else {
            addDataUseConsent(context, new GDPR(GDPR.GDPR_CONSENT.fromValue(String.valueOf(cBPIDataUseConsent.f2651a))));
        }
    }

    public static void setShouldDisplayLoadingViewForMoreApps(boolean z) {
    }

    public static void setShouldHideSystemUI(Boolean bool) {
        C1317h1.m3506a("Chartboost.setHideSystemUI", (Object) bool);
        C1418k.f3538h = bool.booleanValue();
    }

    public static void setShouldPrefetchVideoContent(boolean z) {
        C1317h1.m3508a("Chartboost.setShouldPrefetchVideoContent", z);
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c()) {
            b.getClass();
            C1414j.C1416b bVar = new C1414j.C1416b(2);
            bVar.f3528d = z;
            C1414j.m3873e(bVar);
        }
    }

    public static void setShouldRequestInterstitialsInFirstSession(boolean z) {
        C1317h1.m3508a("Chartboost.setShouldRequestInterstitialsInFirstSession", z);
        if (C1274c.m3270a()) {
            C1283g gVar = new C1283g(1);
            gVar.f3023b = z;
            C1414j.m3873e(gVar);
        }
    }

    public static void showInterstitial(String str) {
        C1317h1.m3507a("Chartboost.showInterstitial", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m2905b("Chartboost", "Interstitial not supported for this Android version");
            C1272a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str)) {
                CBLogging.m2905b("Chartboost", "showInterstitial location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3519v;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, true, ""));
                return;
            }
            C1236h hVar = b.f3492A.get();
            if ((!hVar.f2823q || !hVar.f2825s) && (!hVar.f2811e || !hVar.f2813g)) {
                Handler handler2 = b.f3493B;
                C1286a aVar2 = b.f3519v;
                aVar2.getClass();
                handler2.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (ChartboostError) null, true, ""));
                return;
            }
            C1305g gVar = b.f3518u;
            gVar.getClass();
            b.f3514q.execute(new C1305g.C1307b(4, str, (C1312h) null, (CBError.CBImpressionError) null));
        }
    }

    private static void showInterstitialAIR(String str, boolean z) {
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            C1236h hVar = b.f3492A.get();
            if ((!hVar.f2823q || !hVar.f2825s) && (!hVar.f2811e || !hVar.f2813g)) {
                C1418k.f3534d.didFailToLoadInterstitial(str, CBError.CBImpressionError.END_POINT_DISABLED);
                return;
            }
            Handler handler = b.f3493B;
            C1286a aVar = b.f3519v;
            aVar.getClass();
            handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INTERNAL, (ChartboostError) null, true, ""));
        }
    }

    public static void showMoreApps(String str) {
        cacheMoreApps(str);
    }

    private static void showMoreAppsAIR(String str, boolean z) {
        cacheMoreApps(str);
    }

    public static void showRewardedVideo(String str) {
        C1317h1.m3507a("Chartboost.showRewardedVideo", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m2905b("Chartboost", "Rewarded video not supported for this Android version");
            C1272a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            if (C1406x.m3823b().mo10696a((CharSequence) str)) {
                CBLogging.m2905b("Chartboost", "showRewardedVideo location cannot be empty");
                Handler handler = b.f3493B;
                C1286a aVar = b.f3523z;
                aVar.getClass();
                handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (ChartboostError) null, true, ""));
                return;
            }
            C1236h hVar = b.f3492A.get();
            if ((!hVar.f2823q || !hVar.f2828v) && (!hVar.f2811e || !hVar.f2816j)) {
                Handler handler2 = b.f3493B;
                C1286a aVar2 = b.f3523z;
                aVar2.getClass();
                handler2.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (ChartboostError) null, true, ""));
                return;
            }
            C1305g gVar = b.f3522y;
            gVar.getClass();
            b.f3514q.execute(new C1305g.C1307b(4, str, (C1312h) null, (CBError.CBImpressionError) null));
        }
    }

    private static void showRewardedVideoAIR(String str, boolean z) {
        C1414j b = C1414j.m3867b();
        if (b != null && C1274c.m3275c() && C1414j.m3874l()) {
            C1236h hVar = b.f3492A.get();
            if ((!hVar.f2823q || !hVar.f2828v) && (!hVar.f2811e || !hVar.f2816j)) {
                C1272a aVar = C1418k.f3534d;
                if (aVar != null) {
                    aVar.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.END_POINT_DISABLED);
                    return;
                }
                return;
            }
            Handler handler = b.f3493B;
            C1286a aVar2 = b.f3519v;
            aVar2.getClass();
            handler.post(new C1286a.C1287a(4, str, CBError.CBImpressionError.INTERNAL, (ChartboostError) null, true, ""));
        }
    }

    @Deprecated
    public static void startWithAppId(Activity activity, String str, String str2) {
        if (activity == null) {
            CBLogging.m2905b("Chartboost", "Can't start SDK with null activity");
        } else {
            startWithAppId(activity.getApplicationContext(), str, str2);
        }
    }

    public static void setMediation(CBMediation cBMediation, String str, String str2) {
        C1317h1.m3505a("Chartboost.setMediation");
        C1283g gVar = new C1283g(3);
        gVar.f3025d = str;
        gVar.f3026e = new MediationModel(cBMediation.toString() + " " + str, str, str2);
        C1414j.m3873e(gVar);
    }

    public static void startWithAppId(Context context, String str, String str2) {
        C1418k.f3531a = "​!SDK-VERSION-STRING!:​com.chartboost.sdk:android-sdk:8.2.0";
        C1317h1.m3506a("Chartboost.startWithAppId", (Object) context);
        C1283g gVar = new C1283g(0);
        gVar.f3030i = context;
        gVar.f3031j = str;
        gVar.f3032k = str2;
        C1414j.m3873e(gVar);
    }

    public static void cacheRewardedVideo(String str, String str2) {
        C1317h1.m3507a("Chartboost.cacheHeliumRewardedVideo", str);
        C1412z.m3855a(str, str2, 1);
    }

    public static void cacheInterstitial(String str, String str2) {
        C1317h1.m3507a("Chartboost.cacheHeliumInterstitial", str);
        C1412z.m3855a(str, str2, 0);
    }
}
