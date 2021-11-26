package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.mopub.network.ImpressionData;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

final class CctTransportBackend implements TransportBackend {
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    private static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i;
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.m4841e("CctTransportBackend", "Unable to find version code for package", e);
            return -1;
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        EventInternal.Builder builder = eventInternal.toBuilder();
        builder.addMetadata("sdk-version", Build.VERSION.SDK_INT);
        builder.addMetadata("model", Build.MODEL);
        builder.addMetadata("hardware", Build.HARDWARE);
        builder.addMetadata("device", Build.DEVICE);
        builder.addMetadata(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT);
        builder.addMetadata("os-uild", Build.ID);
        builder.addMetadata("manufacturer", Build.MANUFACTURER);
        builder.addMetadata("fingerprint", Build.FINGERPRINT);
        builder.addMetadata("tz-offset", getTzOffset());
        builder.addMetadata("net-type", getNetTypeValue(activeNetworkInfo));
        builder.addMetadata("mobile-subtype", getNetSubtypeValue(activeNetworkInfo));
        builder.addMetadata(ImpressionData.COUNTRY, Locale.getDefault().getCountry());
        builder.addMetadata("locale", Locale.getDefault().getLanguage());
        builder.addMetadata("mcc_mnc", getTelephonyManager(this.applicationContext).getSimOperator());
        builder.addMetadata("application_build", Integer.toString(getPackageVersionCode(this.applicationContext)));
        return builder.build();
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder builder2 = LogRequest.builder();
            builder2.setQosTier(QosTier.DEFAULT);
            builder2.setRequestTimeMs(this.wallTimeClock.getTime());
            builder2.setRequestUptimeMs(this.uptimeClock.getTime());
            ClientInfo.Builder builder3 = ClientInfo.builder();
            builder3.setClientType(ClientInfo.ClientType.ANDROID_FIREBASE);
            AndroidClientInfo.Builder builder4 = AndroidClientInfo.builder();
            builder4.setSdkVersion(Integer.valueOf(eventInternal.getInteger("sdk-version")));
            builder4.setModel(eventInternal.get("model"));
            builder4.setHardware(eventInternal.get("hardware"));
            builder4.setDevice(eventInternal.get("device"));
            builder4.setProduct(eventInternal.get(AppLovinEventTypes.USER_VIEWED_PRODUCT));
            builder4.setOsBuild(eventInternal.get("os-uild"));
            builder4.setManufacturer(eventInternal.get("manufacturer"));
            builder4.setFingerprint(eventInternal.get("fingerprint"));
            builder4.setCountry(eventInternal.get(ImpressionData.COUNTRY));
            builder4.setLocale(eventInternal.get("locale"));
            builder4.setMccMnc(eventInternal.get("mcc_mnc"));
            builder4.setApplicationBuild(eventInternal.get("application_build"));
            builder3.setAndroidClientInfo(builder4.build());
            builder2.setClientInfo(builder3.build());
            try {
                builder2.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                builder2.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.m4837of("proto"))) {
                    builder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.m4837of("json"))) {
                    builder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.m4843w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                builder.setEventTimeMs(eventInternal2.getEventMillis());
                builder.setEventUptimeMs(eventInternal2.getUptimeMillis());
                builder.setTimezoneOffsetSeconds(eventInternal2.getLong("tz-offset"));
                NetworkConnectionInfo.Builder builder5 = NetworkConnectionInfo.builder();
                builder5.setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal2.getInteger("net-type")));
                builder5.setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal2.getInteger("mobile-subtype")));
                builder.setNetworkConnectionInfo(builder5.build());
                if (eventInternal2.getCode() != null) {
                    builder.setEventCode(eventInternal2.getCode());
                }
                arrayList3.add(builder.build());
            }
            builder2.setLogEvents(arrayList3);
            arrayList2.add(builder2.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x010d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x012a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0131 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.datatransport.cct.CctTransportBackend.HttpResponse doSend(com.google.android.datatransport.cct.CctTransportBackend.HttpRequest r13) throws java.io.IOException {
        /*
            r12 = this;
            java.net.URL r0 = r13.url
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.logging.Logging.m4839d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r13.url
            java.net.URLConnection r0 = r0.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r2 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r2)
            int r2 = r12.readTimeout
            r0.setReadTimeout(r2)
            r2 = 1
            r0.setDoOutput(r2)
            r3 = 0
            r0.setInstanceFollowRedirects(r3)
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "2.3.3"
            r2[r3] = r4
            java.lang.String r3 = "datatransport/%s android/"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "User-Agent"
            r0.setRequestProperty(r3, r2)
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r0.setRequestProperty(r2, r3)
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r0.setRequestProperty(r4, r5)
            java.lang.String r5 = "Accept-Encoding"
            r0.setRequestProperty(r5, r3)
            java.lang.String r3 = r13.apiKey
            if (r3 == 0) goto L_0x0055
            java.lang.String r5 = "X-Goog-Api-Key"
            r0.setRequestProperty(r5, r3)
        L_0x0055:
            r5 = 0
            r3 = 0
            java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ ConnectException -> 0x0144, UnknownHostException -> 0x0142, EncodingException -> 0x0134, IOException -> 0x0132 }
            java.util.zip.GZIPOutputStream r8 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x012b }
            r8.<init>(r7)     // Catch:{ all -> 0x012b }
            com.google.firebase.encoders.DataEncoder r9 = r12.dataEncoder     // Catch:{ all -> 0x0126 }
            com.google.android.datatransport.cct.internal.BatchedLogRequest r13 = r13.requestBody     // Catch:{ all -> 0x0126 }
            java.io.BufferedWriter r10 = new java.io.BufferedWriter     // Catch:{ all -> 0x0126 }
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0126 }
            r11.<init>(r8)     // Catch:{ all -> 0x0126 }
            r10.<init>(r11)     // Catch:{ all -> 0x0126 }
            r9.encode(r13, r10)     // Catch:{ all -> 0x0126 }
            r8.close()     // Catch:{ all -> 0x012b }
            if (r7 == 0) goto L_0x007a
            r7.close()     // Catch:{ ConnectException -> 0x0144, UnknownHostException -> 0x0142, EncodingException -> 0x0134, IOException -> 0x0132 }
        L_0x007a:
            int r13 = r0.getResponseCode()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Status Code: "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            com.google.android.datatransport.runtime.logging.Logging.m4842i(r1, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Content-Type: "
            r7.append(r8)
            java.lang.String r4 = r0.getHeaderField(r4)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            com.google.android.datatransport.runtime.logging.Logging.m4842i(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "Content-Encoding: "
            r4.append(r7)
            java.lang.String r7 = r0.getHeaderField(r2)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.google.android.datatransport.runtime.logging.Logging.m4842i(r1, r4)
            r1 = 302(0x12e, float:4.23E-43)
            if (r13 == r1) goto L_0x0115
            r1 = 301(0x12d, float:4.22E-43)
            if (r13 == r1) goto L_0x0115
            r1 = 307(0x133, float:4.3E-43)
            if (r13 != r1) goto L_0x00cf
            goto L_0x0115
        L_0x00cf:
            r1 = 200(0xc8, float:2.8E-43)
            if (r13 == r1) goto L_0x00d9
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r0 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r0.<init>(r13, r3, r5)
            return r0
        L_0x00d9:
            java.io.InputStream r1 = r0.getInputStream()
            java.lang.String r0 = r0.getHeaderField(r2)     // Catch:{ all -> 0x010e }
            java.io.InputStream r0 = maybeUnGzip(r1, r0)     // Catch:{ all -> 0x010e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0107 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0107 }
            r4.<init>(r0)     // Catch:{ all -> 0x0107 }
            r2.<init>(r4)     // Catch:{ all -> 0x0107 }
            com.google.android.datatransport.cct.internal.LogResponse r2 = com.google.android.datatransport.cct.internal.LogResponse.fromJson(r2)     // Catch:{ all -> 0x0107 }
            long r4 = r2.getNextRequestWaitMillis()     // Catch:{ all -> 0x0107 }
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r2 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse     // Catch:{ all -> 0x0107 }
            r2.<init>(r13, r3, r4)     // Catch:{ all -> 0x0107 }
            if (r0 == 0) goto L_0x0101
            r0.close()     // Catch:{ all -> 0x010e }
        L_0x0101:
            if (r1 == 0) goto L_0x0106
            r1.close()
        L_0x0106:
            return r2
        L_0x0107:
            r13 = move-exception
            if (r0 == 0) goto L_0x010d
            r0.close()     // Catch:{ all -> 0x010d }
        L_0x010d:
            throw r13     // Catch:{ all -> 0x010e }
        L_0x010e:
            r13 = move-exception
            if (r1 == 0) goto L_0x0114
            r1.close()     // Catch:{ all -> 0x0114 }
        L_0x0114:
            throw r13
        L_0x0115:
            java.lang.String r1 = "Location"
            java.lang.String r0 = r0.getHeaderField(r1)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r1 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            java.net.URL r2 = new java.net.URL
            r2.<init>(r0)
            r1.<init>(r13, r2, r5)
            return r1
        L_0x0126:
            r13 = move-exception
            r8.close()     // Catch:{ all -> 0x012a }
        L_0x012a:
            throw r13     // Catch:{ all -> 0x012b }
        L_0x012b:
            r13 = move-exception
            if (r7 == 0) goto L_0x0131
            r7.close()     // Catch:{ all -> 0x0131 }
        L_0x0131:
            throw r13     // Catch:{ ConnectException -> 0x0144, UnknownHostException -> 0x0142, EncodingException -> 0x0134, IOException -> 0x0132 }
        L_0x0132:
            r13 = move-exception
            goto L_0x0135
        L_0x0134:
            r13 = move-exception
        L_0x0135:
            java.lang.String r0 = "Couldn't encode request, returning with 400"
            com.google.android.datatransport.runtime.logging.Logging.m4841e(r1, r0, r13)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r13 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r0 = 400(0x190, float:5.6E-43)
            r13.<init>(r0, r3, r5)
            return r13
        L_0x0142:
            r13 = move-exception
            goto L_0x0145
        L_0x0144:
            r13 = move-exception
        L_0x0145:
            java.lang.String r0 = "Couldn't open connection, returning with 500"
            com.google.android.datatransport.runtime.logging.Logging.m4841e(r1, r0, r13)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r13 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r0 = 500(0x1f4, float:7.0E-43)
            r13.<init>(r0, r3, r5)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.doSend(com.google.android.datatransport.cct.CctTransportBackend$HttpRequest):com.google.android.datatransport.cct.CctTransportBackend$HttpResponse");
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public BackendResponse send(BackendRequest backendRequest) {
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL url = this.endPoint;
        String str = null;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = parseUrlOrThrow(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, new HttpRequest(url, requestBody, str), CctTransportBackend$$Lambda$1.lambdaFactory$(this), CctTransportBackend$$Lambda$4.lambdaFactory$());
            int i = httpResponse.code;
            if (i == 200) {
                return BackendResponse.m4838ok(httpResponse.nextRequestMillis);
            }
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.m4841e("CctTransportBackend", "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.redirectUrl;
        if (url == null) {
            return null;
        }
        Logging.m4839d("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return httpRequest.withUrl(httpResponse.redirectUrl);
    }

    static long getTzOffset() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    static final class HttpResponse {
        final int code;
        final long nextRequestMillis;
        final URL redirectUrl;

        HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    static final class HttpRequest {
        final String apiKey;
        final BatchedLogRequest requestBody;
        final URL url;

        HttpRequest(URL url2, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url2;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        /* access modifiers changed from: package-private */
        public HttpRequest withUrl(URL url2) {
            return new HttpRequest(url2, this.requestBody, this.apiKey);
        }
    }
}
