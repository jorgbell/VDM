package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.flurry.sdk.C1598bu;
import com.flurry.sdk.C1648cy;
import com.flurry.sdk.C1698dz;

public final class FlurryInstallReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        C1648cy.m4317a(4, "FlurryInstallReceiver", "Received an Install notification of " + intent.getAction());
        String string = intent.getExtras().getString("referrer");
        C1648cy.m4317a(4, "FlurryInstallReceiver", "Received an Install referrer of ".concat(String.valueOf(string)));
        if (string == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            C1648cy.m4317a(5, "FlurryInstallReceiver", "referrer is null");
            return;
        }
        if (!string.contains("=")) {
            C1648cy.m4317a(4, "FlurryInstallReceiver", "referrer is before decoding: ".concat(String.valueOf(string)));
            string = C1698dz.m4449d(string);
            C1648cy.m4317a(4, "FlurryInstallReceiver", "referrer is: ".concat(String.valueOf(string)));
        }
        new C1598bu(context).mo11350a(string);
    }
}
