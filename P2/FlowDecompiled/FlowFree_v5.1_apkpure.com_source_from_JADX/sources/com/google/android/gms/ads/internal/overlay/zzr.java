package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzr extends FrameLayout implements View.OnClickListener {
    private final ImageButton zza;
    private final zzaa zzb;

    public zzr(Context context, zzq zzq, zzaa zzaa) {
        super(context);
        this.zzb = zzaa;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        imageButton.setImageResource(17301527);
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzzy.zza();
        int zzs = zzbbd.zzs(context, zzq.zza);
        zzzy.zza();
        int zzs2 = zzbbd.zzs(context, 0);
        zzzy.zza();
        int zzs3 = zzbbd.zzs(context, zzq.zzb);
        zzzy.zza();
        imageButton.setPadding(zzs, zzs2, zzs3, zzbbd.zzs(context, zzq.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzzy.zza();
        int zzs4 = zzbbd.zzs(context, zzq.zzd + zzq.zza + zzq.zzb);
        zzzy.zza();
        addView(imageButton, new FrameLayout.LayoutParams(zzs4, zzbbd.zzs(context, zzq.zzd + zzq.zzc), 17));
    }

    public final void onClick(View view) {
        zzaa zzaa = this.zzb;
        if (zzaa != null) {
            zzaa.zzd();
        }
    }

    public final void zza(boolean z) {
        if (z) {
            this.zza.setVisibility(8);
        } else {
            this.zza.setVisibility(0);
        }
    }
}
