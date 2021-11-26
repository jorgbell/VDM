package com.flurry.sdk;

import android.content.SharedPreferences;
import com.flurry.sdk.C1720ex;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.ae */
public final class C1484ae extends C1730f {

    /* renamed from: a */
    String f3734a = "";

    /* renamed from: b */
    boolean f3735b = false;

    /* renamed from: d */
    AtomicBoolean f3736d = new AtomicBoolean(false);

    C1484ae() {
        super("AdvertisingIdProvider", C1720ex.m4478a(C1720ex.C1722a.PROVIDER));
    }

    /* renamed from: a */
    public final void mo11264a() {
        AdvertisingIdClient.Info b = m3962b();
        if (b != null) {
            this.f3734a = b.getId();
            this.f3735b = !b.isLimitAdTrackingEnabled();
            this.f3736d.set(true);
            if (b != null) {
                C1739fe.m4513a("advertising_id", b.getId());
                boolean isLimitAdTrackingEnabled = b.isLimitAdTrackingEnabled();
                SharedPreferences.Editor edit = C1536b.m4057a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
                edit.putBoolean(String.format(Locale.US, "com.flurry.sdk.%s", new Object[]{"ad_tracking_enabled"}), isLimitAdTrackingEnabled);
                edit.apply();
            }
        }
    }

    /* renamed from: b */
    private static AdvertisingIdClient.Info m3962b() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C1536b.m4057a());
            return new AdvertisingIdClient.Info(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (NoClassDefFoundError unused) {
            C1648cy.m4325b("AdvertisingIdProvider", "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (Exception e) {
            C1648cy.m4325b("AdvertisingIdProvider", "GOOGLE PLAY SERVICES ERROR: " + e.getMessage());
            C1648cy.m4325b("AdvertisingIdProvider", "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }
}
