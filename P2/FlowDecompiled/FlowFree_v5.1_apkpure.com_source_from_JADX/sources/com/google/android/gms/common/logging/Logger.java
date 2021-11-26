package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Logger {
    private final String zza;
    private final String zzb;
    private final int zzd;

    public Logger(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.zzb = str2;
        this.zza = str;
        new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public String format(@RecentlyNonNull String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    /* renamed from: e */
    public void mo13437e(@RecentlyNonNull String str, Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    /* renamed from: d */
    public void mo13436d(@RecentlyNonNull String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }
}
