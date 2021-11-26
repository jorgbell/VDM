package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.internal.C2100ca;
import com.google.android.play.core.listener.C2123b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ar */
final class C1967ar extends C2123b<AssetPackState> {

    /* renamed from: c */
    private final C2001ca f4842c;

    /* renamed from: d */
    private final C1986bl f4843d;

    /* renamed from: e */
    private final C2100ca<C2046t> f4844e;

    /* renamed from: f */
    private final C1979be f4845f;

    /* renamed from: g */
    private final C1989bo f4846g;

    /* renamed from: h */
    private final C2100ca<Executor> f4847h;

    /* renamed from: i */
    private final C2100ca<Executor> f4848i;

    /* renamed from: j */
    private final Handler f4849j = new Handler(Looper.getMainLooper());

    C1967ar(Context context, C2001ca caVar, C1986bl blVar, C2100ca<C2046t> caVar2, C1989bo boVar, C1979be beVar, C2100ca<Executor> caVar3, C2100ca<Executor> caVar4) {
        super(new C2058ag("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f4842c = caVar;
        this.f4843d = blVar;
        this.f4844e = caVar2;
        this.f4846g = boVar;
        this.f4845f = beVar;
        this.f4847h = caVar3;
        this.f4848i = caVar4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21868a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f5217a.mo22025b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            AssetPackState d = AssetPackState.m4864d(bundleExtra, stringArrayList.get(0), this.f4846g, C1969at.f4851b);
            this.f5217a.mo22024a("ListenerRegistryBroadcastReceiver.onReceive: %s", d);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f4845f.mo21922a(pendingIntent);
            }
            this.f4848i.mo22065a().execute(new C1965ap(this, bundleExtra, d));
            this.f4847h.mo22065a().execute(new C1966aq(this, bundleExtra));
            return;
        }
        this.f5217a.mo22025b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo21869b(AssetPackState assetPackState) {
        this.f4849j.post(new C1964ao(this, assetPackState));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo21870c(Bundle bundle) {
        if (this.f4842c.mo21939d(bundle)) {
            this.f4843d.mo21927a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo21871d(Bundle bundle, AssetPackState assetPackState) {
        if (this.f4842c.mo21940e(bundle)) {
            mo21869b(assetPackState);
            this.f4844e.mo22065a().mo21864j();
        }
    }
}
