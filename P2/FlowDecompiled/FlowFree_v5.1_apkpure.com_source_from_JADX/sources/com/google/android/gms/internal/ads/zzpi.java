package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzpi implements zzpn {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzpm zzg = new zzpm();
    private final zzpt<? super zzpi> zzh;
    private zzpg zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;

    public zzpi(String str, zzqe<String> zzqe, zzpt<? super zzpi> zzpt, int i, int i2, boolean z, zzpm zzpm) {
        zzpu.zzf(str);
        this.zzf = str;
        this.zzh = zzpt;
        this.zzd = i;
        this.zze = i2;
    }

    private final void zzf() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0100, code lost:
        if (r3 != 0) goto L_0x0105;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzpg r21) throws com.google.android.gms.internal.ads.zzpk {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "Unable to connect to "
            r1.zzi = r2
            r4 = 0
            r1.zzp = r4
            r1.zzo = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02b6 }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x02b6 }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x02b6 }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x02b6 }
            r12 = 0
        L_0x001e:
            int r13 = r12 + 1
            r14 = 20
            if (r12 > r14) goto L_0x029d
            java.net.URLConnection r12 = r0.openConnection()     // Catch:{ IOException -> 0x02b6 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x02b6 }
            int r15 = r1.zzd     // Catch:{ IOException -> 0x02b6 }
            r12.setConnectTimeout(r15)     // Catch:{ IOException -> 0x02b6 }
            int r15 = r1.zze     // Catch:{ IOException -> 0x02b6 }
            r12.setReadTimeout(r15)     // Catch:{ IOException -> 0x02b6 }
            com.google.android.gms.internal.ads.zzpm r15 = r1.zzg     // Catch:{ IOException -> 0x02b6 }
            java.util.Map r15 = r15.zza()     // Catch:{ IOException -> 0x02b6 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ IOException -> 0x02b6 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ IOException -> 0x02b6 }
        L_0x0042:
            boolean r16 = r15.hasNext()     // Catch:{ IOException -> 0x02b6 }
            if (r16 == 0) goto L_0x0062
            java.lang.Object r16 = r15.next()     // Catch:{ IOException -> 0x02b6 }
            java.util.Map$Entry r16 = (java.util.Map.Entry) r16     // Catch:{ IOException -> 0x02b6 }
            java.lang.Object r17 = r16.getKey()     // Catch:{ IOException -> 0x02b6 }
            r6 = r17
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x02b6 }
            java.lang.Object r16 = r16.getValue()     // Catch:{ IOException -> 0x02b6 }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x02b6 }
            r12.setRequestProperty(r6, r11)     // Catch:{ IOException -> 0x02b6 }
            goto L_0x0042
        L_0x0062:
            r6 = 27
            r15 = -1
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x006e
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x00ad
        L_0x006e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r11.<init>(r6)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = "bytes="
            r11.append(r6)     // Catch:{ IOException -> 0x02b6 }
            r11.append(r7)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = "-"
            r11.append(r6)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = r11.toString()     // Catch:{ IOException -> 0x02b6 }
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x00a8
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x02b6 }
            long r18 = r7 + r9
            long r4 = r18 + r15
            java.lang.String r11 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x02b6 }
            int r11 = r11.length()     // Catch:{ IOException -> 0x02b6 }
            int r11 = r11 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r14.<init>(r11)     // Catch:{ IOException -> 0x02b6 }
            r14.append(r6)     // Catch:{ IOException -> 0x02b6 }
            r14.append(r4)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r6 = r14.toString()     // Catch:{ IOException -> 0x02b6 }
        L_0x00a8:
            java.lang.String r4 = "Range"
            r12.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x02b6 }
        L_0x00ad:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzf     // Catch:{ IOException -> 0x02b6 }
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b6 }
            r4 = 0
            r12.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.setDoOutput(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.connect()     // Catch:{ IOException -> 0x02b6 }
            int r4 = r12.getResponseCode()     // Catch:{ IOException -> 0x02b6 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x024c
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x024c
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x024c
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x024c
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x024c
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00e3
            goto L_0x024c
        L_0x00e3:
            r1.zzj = r12     // Catch:{ IOException -> 0x02b6 }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x0225 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x0209
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x00f3
            goto L_0x0209
        L_0x00f3:
            java.net.HttpURLConnection r4 = r1.zzj
            r4.getContentType()
            if (r0 != r3) goto L_0x0103
            long r3 = r2.zzc
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r3 = 0
        L_0x0105:
            r1.zzm = r3
            long r3 = r2.zzd
            int r0 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x0111
            r1.zzn = r3
            goto L_0x01e9
        L_0x0111:
            java.net.HttpURLConnection r0 = r1.zzj
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "DefaultHttpDataSource"
            java.lang.String r6 = "]"
            if (r4 != 0) goto L_0x0149
            long r7 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0128 }
            goto L_0x014a
        L_0x0128:
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r4 = r4 + 28
            r7.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Length ["
            r7.append(r4)
            r7.append(r3)
            r7.append(r6)
            java.lang.String r4 = r7.toString()
            android.util.Log.e(r5, r4)
        L_0x0149:
            r7 = r15
        L_0x014a:
            java.lang.String r4 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01de
            java.util.regex.Pattern r4 = zzb
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r9 = r4.find()
            if (r9 == 0) goto L_0x01de
            r9 = 2
            java.lang.String r9 = r4.group(r9)     // Catch:{ NumberFormatException -> 0x01bc }
            long r9 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x01bc }
            r11 = 1
            java.lang.String r4 = r4.group(r11)     // Catch:{ NumberFormatException -> 0x01bc }
            long r11 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            long r9 = r9 - r11
            r11 = 1
            long r9 = r9 + r11
            r18 = 0
            int r4 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r4 >= 0) goto L_0x0180
            r7 = r9
            goto L_0x01de
        L_0x0180:
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x01de
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4.length()     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4 + 26
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01bc }
            int r11 = r11.length()     // Catch:{ NumberFormatException -> 0x01bc }
            int r4 = r4 + r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01bc }
            r11.<init>(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r4 = "Inconsistent headers ["
            r11.append(r4)     // Catch:{ NumberFormatException -> 0x01bc }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r3 = "] ["
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x01bc }
            r11.append(r0)     // Catch:{ NumberFormatException -> 0x01bc }
            r11.append(r6)     // Catch:{ NumberFormatException -> 0x01bc }
            java.lang.String r3 = r11.toString()     // Catch:{ NumberFormatException -> 0x01bc }
            android.util.Log.w(r5, r3)     // Catch:{ NumberFormatException -> 0x01bc }
            long r3 = java.lang.Math.max(r7, r9)     // Catch:{ NumberFormatException -> 0x01bc }
            r7 = r3
            goto L_0x01de
        L_0x01bc:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r9 = 27
            int r3 = r3 + r9
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r5, r0)
        L_0x01de:
            int r0 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x01e6
            long r3 = r1.zzm
            long r15 = r7 - r3
        L_0x01e6:
            r3 = r15
            r1.zzn = r3
        L_0x01e9:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x01fe }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01fe }
            r1.zzk = r0     // Catch:{ IOException -> 0x01fe }
            r3 = 1
            r1.zzl = r3
            com.google.android.gms.internal.ads.zzpt<? super com.google.android.gms.internal.ads.zzpi> r0 = r1.zzh
            if (r0 == 0) goto L_0x01fb
            r0.zzj(r1, r2)
        L_0x01fb:
            long r2 = r1.zzn
            return r2
        L_0x01fe:
            r0 = move-exception
            r20.zzf()
            com.google.android.gms.internal.ads.zzpk r3 = new com.google.android.gms.internal.ads.zzpk
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzpg) r2, (int) r4)
            throw r3
        L_0x0209:
            java.net.HttpURLConnection r3 = r1.zzj
            java.util.Map r3 = r3.getHeaderFields()
            r20.zzf()
            com.google.android.gms.internal.ads.zzpl r4 = new com.google.android.gms.internal.ads.zzpl
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x0224
            com.google.android.gms.internal.ads.zzpf r0 = new com.google.android.gms.internal.ads.zzpf
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x0224:
            throw r4
        L_0x0225:
            r0 = move-exception
            r4 = r0
            r20.zzf()
            com.google.android.gms.internal.ads.zzpk r0 = new com.google.android.gms.internal.ads.zzpk
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0241
            java.lang.String r3 = r3.concat(r5)
            goto L_0x0247
        L_0x0241:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x0247:
            r5 = 1
            r0.<init>(r3, r4, r2, r5)
            throw r0
        L_0x024c:
            r5 = 0
            r18 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r12.getHeaderField(r4)     // Catch:{ IOException -> 0x02b6 }
            r12.disconnect()     // Catch:{ IOException -> 0x02b6 }
            if (r4 == 0) goto L_0x0295
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x02b6 }
            r6.<init>(r0, r4)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r0 = r6.getProtocol()     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b6 }
            if (r4 != 0) goto L_0x028f
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b6 }
            if (r4 != 0) goto L_0x028f
            java.net.ProtocolException r4 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02b6 }
            int r6 = r0.length()     // Catch:{ IOException -> 0x02b6 }
            if (r6 == 0) goto L_0x0286
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x02b6 }
            goto L_0x028b
        L_0x0286:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x02b6 }
        L_0x028b:
            r4.<init>(r0)     // Catch:{ IOException -> 0x02b6 }
            throw r4     // Catch:{ IOException -> 0x02b6 }
        L_0x028f:
            r0 = r6
            r12 = r13
            r4 = r18
            goto L_0x001e
        L_0x0295:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b6 }
            throw r0     // Catch:{ IOException -> 0x02b6 }
        L_0x029d:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b6 }
            r5 = 31
            r4.<init>(r5)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x02b6 }
            r4.append(r13)     // Catch:{ IOException -> 0x02b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02b6 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b6 }
            throw r0     // Catch:{ IOException -> 0x02b6 }
        L_0x02b6:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzpk r4 = new com.google.android.gms.internal.ads.zzpk
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x02ce
            java.lang.String r3 = r3.concat(r5)
            goto L_0x02d4
        L_0x02ce:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x02d4:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            goto L_0x02da
        L_0x02d9:
            throw r4
        L_0x02da:
            goto L_0x02d9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.zza(com.google.android.gms.internal.ads.zzpg):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|(1:6)(1:7)|8|9|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzpk {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzk     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0077
            java.net.HttpURLConnection r2 = r9.zzj     // Catch:{ all -> 0x0083 }
            long r3 = r9.zzn     // Catch:{ all -> 0x0083 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzp     // Catch:{ all -> 0x0083 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzqj.zza     // Catch:{ all -> 0x0083 }
            r8 = 19
            if (r7 == r8) goto L_0x001f
            r8 = 20
            if (r7 == r8) goto L_0x001f
            goto L_0x0067
        L_0x001f:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0067 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x002f
            int r3 = r2.read()     // Catch:{ Exception -> 0x0067 }
            r4 = -1
            if (r3 == r4) goto L_0x0067
            goto L_0x0036
        L_0x002f:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0036
            goto L_0x0067
        L_0x0036:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0067 }
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0067 }
            if (r3 == 0) goto L_0x0067
        L_0x004e:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0067 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0067 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0067 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0067 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0067 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            java.io.InputStream r2 = r9.zzk     // Catch:{ IOException -> 0x006d }
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0077
        L_0x006d:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzpk r3 = new com.google.android.gms.internal.ads.zzpk     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzpg r4 = r9.zzi     // Catch:{ all -> 0x0083 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzpg) r4, (int) r5)     // Catch:{ all -> 0x0083 }
            throw r3     // Catch:{ all -> 0x0083 }
        L_0x0077:
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0082
            r9.zzl = r1
        L_0x0082:
            return
        L_0x0083:
            r2 = move-exception
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x008f
            r9.zzl = r1
        L_0x008f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.zzd():void");
    }

    public final int zzb(byte[] bArr, int i, int i2) throws zzpk {
        try {
            if (this.zzo != this.zzm) {
                byte[] andSet = zzc.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzc.set(andSet);
                        break;
                    }
                    int read = this.zzk.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzo += (long) read;
                        zzpt<? super zzpi> zzpt = this.zzh;
                        if (zzpt != null) {
                            zzpt.zzk(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzp += (long) read2;
                zzpt<? super zzpi> zzpt2 = this.zzh;
                if (zzpt2 == null) {
                    return read2;
                }
                zzpt2.zzk(this, read2);
                return read2;
            } else if (this.zzn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzpk(e, this.zzi, 2);
        }
    }
}
