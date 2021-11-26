package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R$string;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzath extends zzatk {
    private final Map<String, String> zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzath(zzbgf zzbgf, Map<String, String> map) {
        super(zzbgf, "storePicture");
        this.zza = map;
        this.zzb = zzbgf.zzj();
    }

    public final void zza() {
        if (this.zzb == null) {
            zzf("Activity context is not available");
            return;
        }
        zzs.zzc();
        if (!new zzaeb(this.zzb).zza()) {
            zzf("Feature is not supported by the device.");
            return;
        }
        String str = this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzf("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzf(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzs.zzc();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zzf = zzs.zzg().zzf();
                zzs.zzc();
                AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
                builder.setTitle(zzf != null ? zzf.getString(R$string.f4781s1) : "Save image");
                builder.setMessage(zzf != null ? zzf.getString(R$string.f4782s2) : "Allow Ad to store image in Picture gallery?");
                builder.setPositiveButton(zzf != null ? zzf.getString(R$string.f4783s3) : "Accept", new zzatf(this, str, lastPathSegment));
                builder.setNegativeButton(zzf != null ? zzf.getString(R$string.f4784s4) : "Decline", new zzatg(this));
                builder.create().show();
                return;
            }
            String valueOf2 = String.valueOf(lastPathSegment);
            zzf(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
        }
    }
}
