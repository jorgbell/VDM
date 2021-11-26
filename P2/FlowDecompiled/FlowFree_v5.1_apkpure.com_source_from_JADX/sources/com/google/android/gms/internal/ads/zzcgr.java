package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public interface zzcgr extends View.OnClickListener, View.OnTouchListener {
    FrameLayout zzbu();

    View zzby();

    zzrj zzh();

    void zzi(String str, View view, boolean z);

    Map<String, WeakReference<View>> zzj();

    Map<String, WeakReference<View>> zzk();

    Map<String, WeakReference<View>> zzl();

    View zzm(String str);

    String zzn();

    IObjectWrapper zzo();

    JSONObject zzp();
}
