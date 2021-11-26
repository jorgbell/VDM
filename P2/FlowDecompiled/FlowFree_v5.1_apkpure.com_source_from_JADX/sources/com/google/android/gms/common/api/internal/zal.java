package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zal implements Runnable {
    final /* synthetic */ zak zaa;
    private final zam zab;

    zal(zak zak, zam zam) {
        this.zaa = zak;
        this.zab = zam;
    }

    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult zab2 = this.zab.zab();
            if (zab2.hasResolution()) {
                zak zak = this.zaa;
                LifecycleFragment lifecycleFragment = zak.mLifecycleFragment;
                Activity activity = zak.getActivity();
                PendingIntent resolution = zab2.getResolution();
                Preconditions.checkNotNull(resolution);
                lifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(activity, resolution, this.zab.zaa(), false), 1);
                return;
            }
            zak zak2 = this.zaa;
            if (zak2.zac.getErrorResolutionIntent(zak2.getActivity(), zab2.getErrorCode(), (String) null) != null) {
                zak zak3 = this.zaa;
                zak3.zac.zaa(zak3.getActivity(), this.zaa.mLifecycleFragment, zab2.getErrorCode(), 2, this.zaa);
            } else if (zab2.getErrorCode() == 18) {
                Dialog zaa2 = GoogleApiAvailability.zaa(this.zaa.getActivity(), (DialogInterface.OnCancelListener) this.zaa);
                zak zak4 = this.zaa;
                zak4.zac.zaa(zak4.getActivity().getApplicationContext(), (zabl) new zan(this, zaa2));
            } else {
                this.zaa.zaa(zab2, this.zab.zaa());
            }
        }
    }
}
