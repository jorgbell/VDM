package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzbbp implements zzbbc {
    private final String zza;

    public zzbbp() {
        this.zza = null;
    }

    public zzbbp(String str) {
        this.zza = str;
    }

    public final void zza(String str) {
        String str2;
        HttpURLConnection httpURLConnection;
        try {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.setThreadStatsTag(263);
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Pinging URL: ".concat(valueOf);
            } else {
                str2 = new String("Pinging URL: ");
            }
            zzbbk.zzd(str2);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzzy.zza();
            String str3 = this.zza;
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setReadTimeout(60000);
            if (str3 != null) {
                httpURLConnection.setRequestProperty("User-Agent", str3);
            }
            httpURLConnection.setUseCaches(false);
            zzbbj zzbbj = new zzbbj((String) null);
            zzbbj.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzbbj.zzc(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                zzbbk.zzi(sb.toString());
            }
            httpURLConnection.disconnect();
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            zzbbk.zzi(sb2.toString());
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (IOException | RuntimeException e2) {
            try {
                String message2 = e2.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
                sb3.append("Error while pinging URL: ");
                sb3.append(str);
                sb3.append(". ");
                sb3.append(message2);
                zzbbk.zzi(sb3.toString());
            } finally {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
