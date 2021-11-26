package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2088bp;
import com.google.android.play.core.internal.C2118w;
import com.google.android.play.core.internal.C2121z;

/* renamed from: com.google.android.play.core.assetpacks.b */
final class C1975b extends C2118w {

    /* renamed from: a */
    private final C2058ag f4874a = new C2058ag("AssetPackExtractionService");

    /* renamed from: b */
    private final Context f4875b;

    /* renamed from: c */
    private final C1970au f4876c;

    C1975b(Context context, C1970au auVar) {
        this.f4875b = context;
        this.f4876c = auVar;
    }

    /* renamed from: d */
    private final synchronized void m4971d(Bundle bundle) {
        ComponentName componentName;
        Intent intent = new Intent(this.f4875b, ExtractionForegroundService.class);
        int i = bundle.getInt("action_type");
        intent.putExtra("action_type", i);
        if (i == 1) {
            intent.putExtra("notification_channel_name", bundle.getString("notification_channel_name"));
            intent.putExtra("notification_title", bundle.getString("notification_title"));
            intent.putExtra("notification_subtext", bundle.getString("notification_subtext"));
            intent.putExtra("notification_timeout", bundle.getLong("notification_timeout"));
            Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
            if (parcelable instanceof PendingIntent) {
                intent.putExtra("notification_on_click_intent", parcelable);
            }
            intent.putExtra("notification_color", bundle.getInt("notification_color"));
        }
        try {
            componentName = Build.VERSION.SDK_INT >= 26 ? this.f4875b.startForegroundService(intent) : this.f4875b.startService(intent);
        } catch (IllegalStateException | SecurityException e) {
            this.f4874a.mo22026c(e, "Failed starting installation service.", new Object[0]);
            componentName = null;
        }
        if (componentName == null) {
            this.f4874a.mo22025b("Failed starting installation service.", new Object[0]);
        }
    }

    /* renamed from: b */
    public final void mo21910b(Bundle bundle, C2121z zVar) throws RemoteException {
        this.f4874a.mo22024a("updateServiceState AIDL call", new Object[0]);
        if (!C2088bp.m5239a(this.f4875b) || !C2088bp.m5240b(this.f4875b)) {
            zVar.mo22105d(new Bundle());
            return;
        }
        m4971d(bundle);
        zVar.mo22104c(new Bundle(), new Bundle());
    }

    /* renamed from: c */
    public final void mo21911c(C2121z zVar) throws RemoteException {
        this.f4874a.mo22024a("clearAssetPackStorage AIDL call", new Object[0]);
        if (!C2088bp.m5239a(this.f4875b) || !C2088bp.m5240b(this.f4875b)) {
            zVar.mo22105d(new Bundle());
            return;
        }
        this.f4876c.mo21897x();
        zVar.mo22106e(new Bundle());
    }
}
