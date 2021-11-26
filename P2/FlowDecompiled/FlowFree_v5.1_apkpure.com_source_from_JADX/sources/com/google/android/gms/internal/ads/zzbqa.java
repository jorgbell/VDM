package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzs;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbqa extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzbqa(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzbqa zza(Context context, View view, zzdqo zzdqo) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzbqa zzbqa = new zzbqa(context);
        if (!(zzdqo.zzt.isEmpty() || (resources = zzbqa.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzdqp zzdqp = zzdqo.zzt.get(0);
            float f = displayMetrics.density;
            zzbqa.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzdqp.zza) * f), (int) (((float) zzdqp.zzb) * f)));
        }
        zzbqa.zzb = view;
        zzbqa.addView(view);
        zzs.zzz();
        zzbcj.zzb(zzbqa, zzbqa);
        zzs.zzz();
        zzbcj.zza(zzbqa, zzbqa);
        JSONObject jSONObject = zzdqo.zzac;
        RelativeLayout relativeLayout = new RelativeLayout(zzbqa.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzbqa.zzb(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzbqa.zzb(optJSONObject2, relativeLayout, 12);
        }
        zzbqa.addView(relativeLayout);
        return zzbqa;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzc = zzc(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzc, 0, zzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzc(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzc(double d) {
        zzzy.zza();
        return zzbbd.zzs(this.zza, (int) d);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
