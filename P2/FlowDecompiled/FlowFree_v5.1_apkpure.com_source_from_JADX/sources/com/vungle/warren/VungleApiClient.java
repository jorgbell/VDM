package com.vungle.warren;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import androidx.annotation.Keep;
import com.chartboost.sdk.Privacy.model.GDPR;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mopub.common.Constants;
import com.mopub.mobileads.vungle.BuildConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.network.APIFactory;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.VungleApi;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.ViewUtility;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class VungleApiClient {
    private static String BASE_URL = "https://ads.api.vungle.com/";
    /* access modifiers changed from: private */
    public static final String TAG = "com.vungle.warren.VungleApiClient";
    protected static WrapperFramework WRAPPER_FRAMEWORK_SELECTED;
    private static String headerUa;
    private VungleApi api;
    private JsonObject appBody;
    private CacheManager cacheManager;
    private OkHttpClient client;
    /* access modifiers changed from: private */
    public Context context;
    private boolean defaultIdFallbackDisabled;
    /* access modifiers changed from: private */
    public JsonObject deviceBody;
    private boolean enableOm;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private String logEndpoint;
    private String newEndpoint;
    private final boolean okHttpSupported;
    private final OMInjector omInjector;
    private String reportAdEndpoint;
    private Repository repository;
    private String requestAdEndpoint;
    /* access modifiers changed from: private */
    public Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    private String riEndpoint;
    private VungleApi timeoutApi;
    private TimeoutProvider timeoutProvider;
    /* access modifiers changed from: private */
    public String uaString = System.getProperty("http.agent");
    private boolean willPlayAdEnabled;
    private String willPlayAdEndpoint;
    private int willPlayAdTimeout;

    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    private String getConnectionTypeDetail(int i) {
        switch (i) {
            case 1:
                return "gprs";
            case 2:
                return "edge";
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            case 12:
                return "cdma_evdo_b";
            case 13:
                return "LTE";
            case 14:
                return "hrpd";
            default:
                return "unknown";
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Amazon".equals(Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/");
        sb.append("6.9.1");
        headerUa = sb.toString();
        new HashSet();
        new HashSet();
    }

    VungleApiClient(Context context2, CacheManager cacheManager2, Repository repository2, OMInjector oMInjector) {
        this.cacheManager = cacheManager2;
        this.context = context2.getApplicationContext();
        this.repository = repository2;
        this.omInjector = oMInjector;
        C29721 r3 = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                int code;
                Request request = chain.request();
                String encodedPath = request.url().encodedPath();
                Long l = (Long) VungleApiClient.this.retryAfterDataMap.get(encodedPath);
                if (l != null) {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(l.longValue() - System.currentTimeMillis());
                    if (seconds > 0) {
                        Response.Builder builder = new Response.Builder();
                        builder.request(request);
                        builder.addHeader("Retry-After", String.valueOf(seconds));
                        builder.code(500);
                        builder.protocol(Protocol.HTTP_1_1);
                        builder.message("Server is busy");
                        builder.body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}"));
                        return builder.build();
                    }
                    VungleApiClient.this.retryAfterDataMap.remove(encodedPath);
                }
                Response proceed = chain.proceed(request);
                if (proceed != null && ((code = proceed.code()) == 429 || code == 500 || code == 502 || code == 503)) {
                    String str = proceed.headers().get("Retry-After");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            long parseLong = Long.parseLong(str);
                            if (parseLong > 0) {
                                VungleApiClient.this.retryAfterDataMap.put(encodedPath, Long.valueOf((parseLong * 1000) + System.currentTimeMillis()));
                            }
                        } catch (NumberFormatException unused) {
                            Log.d(VungleApiClient.TAG, "Retry-After value is not an valid value");
                        }
                    }
                }
                return proceed;
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(r3);
        try {
            this.client = builder.build();
            this.okHttpSupported = true;
            builder.addInterceptor(new GzipRequestInterceptor());
            OkHttpClient build = builder.build();
            this.api = new APIFactory(this.client, BASE_URL).createAPI();
            this.gzipApi = new APIFactory(build, BASE_URL).createAPI();
            this.timeoutProvider = (TimeoutProvider) ServiceLocator.getInstance(context2).getService(TimeoutProvider.class);
        } catch (ExceptionInInitializerError | NoClassDefFoundError e) {
            Log.e(TAG, "Can't init OKHttp", e);
            this.okHttpSupported = false;
        }
    }

    public static String getHeaderUa() {
        return headerUa;
    }

    public static void setHeaderUa(String str) {
        headerUa = str;
    }

    public boolean platformIsNotSupported() {
        return !this.okHttpSupported;
    }

    public void init() {
        init(this.context);
    }

    static class GzipRequestInterceptor implements Interceptor {
        GzipRequestInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (request.body() == null || request.header("Content-Encoding") != null) {
                return chain.proceed(request);
            }
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.header("Content-Encoding", "gzip");
            newBuilder.method(request.method(), gzip(request.body()));
            return chain.proceed(newBuilder.build());
        }

        private RequestBody gzip(final RequestBody requestBody) throws IOException {
            final Buffer buffer = new Buffer();
            BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
            requestBody.writeTo(buffer2);
            buffer2.close();
            return new RequestBody(this) {
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                public long contentLength() {
                    return buffer.size();
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(buffer.snapshot());
                }
            };
        }
    }

    public void setDefaultIdFallbackDisabled(boolean z) {
        this.defaultIdFallbackDisabled = z;
    }

    /* access modifiers changed from: package-private */
    public synchronized void init(final Context context2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("bundle", context2.getPackageName());
        String str = null;
        try {
            str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (str == null) {
            str = "1.0";
        }
        jsonObject.addProperty("ver", str);
        JsonObject jsonObject2 = new JsonObject();
        String str2 = Build.MANUFACTURER;
        jsonObject2.addProperty("make", str2);
        jsonObject2.addProperty("model", Build.MODEL);
        jsonObject2.addProperty("osv", Build.VERSION.RELEASE);
        jsonObject2.addProperty("carrier", ((TelephonyManager) context2.getSystemService("phone")).getNetworkOperatorName());
        jsonObject2.addProperty("os", "Amazon".equals(str2) ? "amazon" : Constants.ANDROID_PLATFORM);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        jsonObject2.addProperty("w", (Number) Integer.valueOf(displayMetrics.widthPixels));
        jsonObject2.addProperty("h", (Number) Integer.valueOf(displayMetrics.heightPixels));
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add(BuildConfig.NETWORK_NAME, new JsonObject());
        jsonObject2.add("ext", jsonObject3);
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                this.uaString = getUserAgentFromCookie();
                initUserAgentLazy();
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                this.uaString = ViewUtility.getWebView(context2.getApplicationContext()).getSettings().getUserAgentString();
            } else {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            String unused = VungleApiClient.this.uaString = ViewUtility.getWebView(context2.getApplicationContext()).getSettings().getUserAgentString();
                        } catch (InstantiationException e) {
                            String access$100 = VungleApiClient.TAG;
                            Log.e(access$100, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
                        }
                        countDownLatch.countDown();
                    }
                });
                if (!countDownLatch.await(2, TimeUnit.SECONDS)) {
                    Log.e(TAG, "Unable to get User Agent String in specified time");
                }
            }
        } catch (Exception e) {
            String str3 = TAG;
            Log.e(str3, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
        }
        jsonObject2.addProperty("ua", this.uaString);
        this.deviceBody = jsonObject2;
        this.appBody = jsonObject;
        this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
    }

    /* access modifiers changed from: package-private */
    public void setAppId(String str) {
        setAppId(str, this.appBody);
    }

    private void setAppId(String str, JsonObject jsonObject) {
        jsonObject.addProperty("id", str);
    }

    private void initUserAgentLazy() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    VungleApiClient vungleApiClient = VungleApiClient.this;
                    String unused = vungleApiClient.uaString = WebSettings.getDefaultUserAgent(vungleApiClient.context);
                    VungleApiClient.this.deviceBody.addProperty("ua", VungleApiClient.this.uaString);
                    VungleApiClient vungleApiClient2 = VungleApiClient.this;
                    vungleApiClient2.addUserAgentInCookie(vungleApiClient2.uaString);
                } catch (Exception e) {
                    String access$100 = VungleApiClient.TAG;
                    Log.e(access$100, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
                }
            }
        }).start();
    }

    public com.vungle.warren.network.Response config() throws VungleException, IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", getDeviceBody());
        jsonObject.add("app", this.appBody);
        jsonObject.add("user", getUserBody());
        com.vungle.warren.network.Response<JsonObject> execute = this.api.config(getHeaderUa(), jsonObject).execute();
        if (!execute.isSuccessful()) {
            return execute;
        }
        JsonObject body = execute.body();
        String str = TAG;
        Log.d(str, "Config Response: " + body);
        if (JsonUtil.hasNonNull(body, "sleep")) {
            String asString = JsonUtil.hasNonNull(body, "info") ? body.get("info").getAsString() : "";
            Log.e(str, "Error Initializing Vungle. Please try again. " + asString);
            throw new VungleException(3);
        } else if (JsonUtil.hasNonNull(body, "endpoints")) {
            JsonObject asJsonObject = body.getAsJsonObject("endpoints");
            HttpUrl parse = HttpUrl.parse(asJsonObject.get("new").getAsString());
            HttpUrl parse2 = HttpUrl.parse(asJsonObject.get("ads").getAsString());
            HttpUrl parse3 = HttpUrl.parse(asJsonObject.get("will_play_ad").getAsString());
            HttpUrl parse4 = HttpUrl.parse(asJsonObject.get("report_ad").getAsString());
            HttpUrl parse5 = HttpUrl.parse(asJsonObject.get("ri").getAsString());
            HttpUrl parse6 = HttpUrl.parse(asJsonObject.get("log").getAsString());
            if (parse == null || parse2 == null || parse3 == null || parse4 == null || parse5 == null || parse6 == null) {
                Log.e(str, "Error Initializing Vungle. Please try again. ");
                throw new VungleException(3);
            }
            this.newEndpoint = parse.toString();
            this.requestAdEndpoint = parse2.toString();
            this.willPlayAdEndpoint = parse3.toString();
            this.reportAdEndpoint = parse4.toString();
            this.riEndpoint = parse5.toString();
            this.logEndpoint = parse6.toString();
            JsonObject asJsonObject2 = body.getAsJsonObject("will_play_ad");
            this.willPlayAdTimeout = asJsonObject2.get("request_timeout").getAsInt();
            this.willPlayAdEnabled = asJsonObject2.get("enabled").getAsBoolean();
            this.enableOm = JsonUtil.getAsBoolean(body.getAsJsonObject("viewability"), "om", false);
            if (this.willPlayAdEnabled) {
                Log.v(str, "willPlayAd is enabled, generating a timeout client.");
                OkHttpClient.Builder newBuilder = this.client.newBuilder();
                newBuilder.readTimeout((long) this.willPlayAdTimeout, TimeUnit.MILLISECONDS);
                this.timeoutApi = new APIFactory(newBuilder.build(), "https://api.vungle.com/").createAPI();
            }
            if (getOmEnabled()) {
                this.omInjector.init();
            }
            return execute;
        } else {
            Log.e(str, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
    }

    public Call<JsonObject> reportNew() throws IllegalStateException {
        if (this.newEndpoint != null) {
            HashMap hashMap = new HashMap(2);
            JsonElement jsonElement = this.appBody.get("id");
            JsonElement jsonElement2 = this.deviceBody.get("ifa");
            String str = "";
            hashMap.put("app_id", jsonElement != null ? jsonElement.getAsString() : str);
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
            hashMap.put("ifa", str);
            return this.api.reportNew(getHeaderUa(), this.newEndpoint, hashMap);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> requestAd(String str, String str2, boolean z, JsonObject jsonObject) throws IllegalStateException {
        if (this.requestAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            JsonObject userBody = getUserBody();
            if (jsonObject != null) {
                userBody.add("vision", jsonObject);
            }
            jsonObject2.add("user", userBody);
            JsonObject jsonObject3 = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject3.add("placements", jsonArray);
            jsonObject3.addProperty("header_bidding", Boolean.valueOf(z));
            if (!TextUtils.isEmpty(str2)) {
                jsonObject3.addProperty("ad_size", str2);
            }
            jsonObject2.add("request", jsonObject3);
            return this.gzipApi.ads(getHeaderUa(), this.requestAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* access modifiers changed from: package-private */
    public Call<JsonObject> willPlayAd(String str, boolean z, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", getDeviceBody());
        jsonObject.add("app", this.appBody);
        jsonObject.add("user", getUserBody());
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("reference_id", str);
        jsonObject3.addProperty("is_auto_cached", Boolean.valueOf(z));
        jsonObject2.add("placement", jsonObject3);
        jsonObject2.addProperty("ad_token", str2);
        jsonObject.add("request", jsonObject2);
        return this.timeoutApi.willPlayAd(getHeaderUa(), this.willPlayAdEndpoint, jsonObject);
    }

    /* access modifiers changed from: package-private */
    public boolean canCallWillPlayAd() {
        return this.willPlayAdEnabled && !TextUtils.isEmpty(this.willPlayAdEndpoint);
    }

    public Call<JsonObject> reportAd(JsonObject jsonObject) {
        if (this.reportAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            jsonObject2.add("request", jsonObject);
            jsonObject2.add("user", getUserBody());
            return this.gzipApi.reportAd(getHeaderUa(), this.reportAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> sendLog(JsonObject jsonObject) {
        if (this.logEndpoint != null) {
            return this.gzipApi.sendLog(getHeaderUa(), this.logEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* renamed from: ri */
    public Call<JsonObject> mo27222ri(JsonObject jsonObject) {
        if (this.riEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            jsonObject2.add("request", jsonObject);
            return this.api.mo27452ri(getHeaderUa(), this.riEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public boolean pingTPAT(String str) throws ClearTextTrafficException, MalformedURLException {
        boolean z;
        if (TextUtils.isEmpty(str) || HttpUrl.parse(str) == null) {
            throw new MalformedURLException("Invalid URL : " + str);
        }
        try {
            String host = new URL(str).getHost();
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                z = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else {
                z = i >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true;
            }
            if (z || !URLUtil.isHttpUrl(str)) {
                try {
                    this.api.pingTPAT(this.uaString, str).execute();
                    return true;
                } catch (IOException unused) {
                    Log.d(TAG, "Error on pinging TPAT");
                    return false;
                }
            } else {
                throw new ClearTextTrafficException("Clear Text Traffic is blocked");
            }
        } catch (MalformedURLException unused2) {
            throw new MalformedURLException("Invalid URL : " + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02e9 A[SYNTHETIC, Splitter:B:156:0x02e9] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0303 A[Catch:{ SettingNotFoundException -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0184  */
    @android.annotation.SuppressLint({"HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.JsonObject getDeviceBody() throws java.lang.IllegalStateException {
        /*
            r15 = this;
            java.lang.String r0 = "ifa"
            java.lang.String r1 = "Amazon"
            com.google.gson.JsonObject r2 = new com.google.gson.JsonObject
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 1
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0084 }
            boolean r6 = r1.equals(r6)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r7 = "advertising_id"
            if (r6 == 0) goto L_0x003d
            android.content.Context r6 = r15.context     // Catch:{ SettingNotFoundException -> 0x002f }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x002f }
            java.lang.String r8 = "limit_ad_tracking"
            int r8 = android.provider.Settings.Secure.getInt(r6, r8)     // Catch:{ SettingNotFoundException -> 0x002f }
            if (r8 != r5) goto L_0x0026
            r8 = 1
            goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ SettingNotFoundException -> 0x002d }
            goto L_0x0090
        L_0x002d:
            r6 = move-exception
            goto L_0x0031
        L_0x002f:
            r6 = move-exception
            r8 = 1
        L_0x0031:
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x003a }
            java.lang.String r9 = "Error getting Amazon advertising info"
            android.util.Log.w(r7, r9, r6)     // Catch:{ Exception -> 0x003a }
            r6 = r3
            goto L_0x0090
        L_0x003a:
            r6 = r8
            r8 = r3
            goto L_0x0086
        L_0x003d:
            android.content.Context r6 = r15.context     // Catch:{ NoClassDefFoundError -> 0x005a }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r6 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r6)     // Catch:{ NoClassDefFoundError -> 0x005a }
            if (r6 == 0) goto L_0x0057
            java.lang.String r8 = r6.getId()     // Catch:{ NoClassDefFoundError -> 0x005a }
            boolean r6 = r6.isLimitAdTrackingEnabled()     // Catch:{ NoClassDefFoundError -> 0x0055, Exception -> 0x0085 }
            com.google.gson.JsonObject r9 = r15.deviceBody     // Catch:{ NoClassDefFoundError -> 0x0053 }
            r9.addProperty((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ NoClassDefFoundError -> 0x0053 }
            goto L_0x008d
        L_0x0053:
            r9 = move-exception
            goto L_0x005d
        L_0x0055:
            r9 = move-exception
            goto L_0x005c
        L_0x0057:
            r6 = r3
            r8 = 1
            goto L_0x0090
        L_0x005a:
            r9 = move-exception
            r8 = r3
        L_0x005c:
            r6 = 1
        L_0x005d:
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r11.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r12 = "Play services Not available: "
            r11.append(r12)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r9 = r9.getLocalizedMessage()     // Catch:{ Exception -> 0x0086 }
            r11.append(r9)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x0086 }
            android.util.Log.e(r10, r9)     // Catch:{ Exception -> 0x0086 }
            android.content.Context r9 = r15.context     // Catch:{ Exception -> 0x0086 }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = android.provider.Settings.Secure.getString(r9, r7)     // Catch:{ Exception -> 0x0086 }
            r8 = r6
            r6 = r7
            goto L_0x0090
        L_0x0084:
            r8 = r3
        L_0x0085:
            r6 = 1
        L_0x0086:
            java.lang.String r7 = TAG
            java.lang.String r9 = "Cannot load Advertising ID"
            android.util.Log.e(r7, r9)
        L_0x008d:
            r14 = r8
            r8 = r6
            r6 = r14
        L_0x0090:
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x00aa
            java.lang.String r9 = android.os.Build.MANUFACTURER
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x009f
            java.lang.String r9 = "amazon_advertising_id"
            goto L_0x00a1
        L_0x009f:
            java.lang.String r9 = "gaid"
        L_0x00a1:
            r2.addProperty((java.lang.String) r9, (java.lang.String) r6)
            com.google.gson.JsonObject r9 = r15.deviceBody
            r9.addProperty((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x00d5
        L_0x00aa:
            android.content.Context r6 = r15.context
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.lang.String r9 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r9)
            com.google.gson.JsonObject r10 = r15.deviceBody
            boolean r11 = r15.defaultIdFallbackDisabled
            if (r11 == 0) goto L_0x00be
        L_0x00bc:
            r11 = r7
            goto L_0x00c5
        L_0x00be:
            boolean r11 = android.text.TextUtils.isEmpty(r6)
            if (r11 != 0) goto L_0x00bc
            r11 = r6
        L_0x00c5:
            r10.addProperty((java.lang.String) r0, (java.lang.String) r11)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r15.defaultIdFallbackDisabled
            if (r0 != 0) goto L_0x00d5
            r2.addProperty((java.lang.String) r9, (java.lang.String) r6)
        L_0x00d5:
            com.google.gson.JsonObject r0 = r15.deviceBody
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "lmt"
            r0.addProperty((java.lang.String) r8, (java.lang.Number) r6)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r6 = r15.isGooglePlayServicesAvailable()
            boolean r0 = r0.equals(r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r6 = "is_google_play_services_available"
            r2.addProperty((java.lang.String) r6, (java.lang.Boolean) r0)
            android.content.Context r0 = r15.context
            if (r0 == 0) goto L_0x0102
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r8 = "android.intent.action.BATTERY_CHANGED"
            r6.<init>(r8)
            android.content.Intent r3 = r0.registerReceiver(r3, r6)
        L_0x0102:
            r0 = 4
            r6 = 2
            java.lang.String r8 = "UNKNOWN"
            if (r3 == 0) goto L_0x014f
            java.lang.String r9 = "level"
            r10 = -1
            int r9 = r3.getIntExtra(r9, r10)
            java.lang.String r11 = "scale"
            int r11 = r3.getIntExtra(r11, r10)
            if (r9 <= 0) goto L_0x0125
            if (r11 <= 0) goto L_0x0125
            float r9 = (float) r9
            float r11 = (float) r11
            float r9 = r9 / r11
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.String r11 = "battery_level"
            r2.addProperty((java.lang.String) r11, (java.lang.Number) r9)
        L_0x0125:
            java.lang.String r9 = "status"
            int r9 = r3.getIntExtra(r9, r10)
            if (r9 != r10) goto L_0x012e
            goto L_0x014f
        L_0x012e:
            if (r9 == r6) goto L_0x0137
            r11 = 5
            if (r9 != r11) goto L_0x0134
            goto L_0x0137
        L_0x0134:
            java.lang.String r3 = "NOT_CHARGING"
            goto L_0x0150
        L_0x0137:
            java.lang.String r9 = "plugged"
            int r3 = r3.getIntExtra(r9, r10)
            if (r3 == r5) goto L_0x014c
            if (r3 == r6) goto L_0x0149
            if (r3 == r0) goto L_0x0146
            java.lang.String r3 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x0150
        L_0x0146:
            java.lang.String r3 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x0150
        L_0x0149:
            java.lang.String r3 = "BATTERY_PLUGGED_USB"
            goto L_0x0150
        L_0x014c:
            java.lang.String r3 = "BATTERY_PLUGGED_AC"
            goto L_0x0150
        L_0x014f:
            r3 = r8
        L_0x0150:
            java.lang.String r9 = "battery_state"
            r2.addProperty((java.lang.String) r9, (java.lang.String) r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r3 < r9) goto L_0x0179
            android.content.Context r9 = r15.context
            java.lang.String r10 = "power"
            java.lang.Object r9 = r9.getSystemService(r10)
            android.os.PowerManager r9 = (android.os.PowerManager) r9
            if (r9 == 0) goto L_0x016f
            boolean r9 = r9.isPowerSaveMode()
            if (r9 == 0) goto L_0x016f
            r9 = 1
            goto L_0x0170
        L_0x016f:
            r9 = 0
        L_0x0170:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "battery_saver_enabled"
            r2.addProperty((java.lang.String) r10, (java.lang.Number) r9)
        L_0x0179:
            android.content.Context r9 = r15.context
            java.lang.String r10 = "android.permission.ACCESS_NETWORK_STATE"
            int r9 = androidx.core.content.PermissionChecker.checkCallingOrSelfPermission(r9, r10)
            r10 = 3
            if (r9 != 0) goto L_0x0204
            android.content.Context r9 = r15.context
            java.lang.String r11 = "connectivity"
            java.lang.Object r9 = r9.getSystemService(r11)
            android.net.ConnectivityManager r9 = (android.net.ConnectivityManager) r9
            java.lang.String r11 = "unknown"
            if (r9 == 0) goto L_0x01c0
            android.net.NetworkInfo r12 = r9.getActiveNetworkInfo()
            if (r12 == 0) goto L_0x01c0
            int r13 = r12.getType()
            if (r13 == 0) goto L_0x01b5
            if (r13 == r5) goto L_0x01b2
            r12 = 6
            if (r13 == r12) goto L_0x01b2
            r12 = 7
            if (r13 == r12) goto L_0x01af
            r12 = 9
            if (r13 == r12) goto L_0x01ac
            r12 = r8
            goto L_0x01c2
        L_0x01ac:
            java.lang.String r12 = "ETHERNET"
            goto L_0x01c2
        L_0x01af:
            java.lang.String r12 = "BLUETOOTH"
            goto L_0x01c2
        L_0x01b2:
            java.lang.String r12 = "WIFI"
            goto L_0x01c2
        L_0x01b5:
            int r11 = r12.getSubtype()
            java.lang.String r11 = r15.getConnectionTypeDetail(r11)
            java.lang.String r12 = "MOBILE"
            goto L_0x01c2
        L_0x01c0:
            java.lang.String r12 = "NONE"
        L_0x01c2:
            java.lang.String r13 = "connection_type"
            r2.addProperty((java.lang.String) r13, (java.lang.String) r12)
            java.lang.String r12 = "connection_type_detail"
            r2.addProperty((java.lang.String) r12, (java.lang.String) r11)
            r11 = 24
            if (r3 < r11) goto L_0x0204
            boolean r11 = r9.isActiveNetworkMetered()
            java.lang.String r12 = "network_metered"
            java.lang.String r13 = "data_saver_status"
            if (r11 == 0) goto L_0x01f8
            int r9 = r9.getRestrictBackgroundStatus()
            if (r9 == r5) goto L_0x01eb
            if (r9 == r6) goto L_0x01e8
            if (r9 == r10) goto L_0x01e5
            goto L_0x01ed
        L_0x01e5:
            java.lang.String r8 = "ENABLED"
            goto L_0x01ed
        L_0x01e8:
            java.lang.String r8 = "WHITELISTED"
            goto L_0x01ed
        L_0x01eb:
            java.lang.String r8 = "DISABLED"
        L_0x01ed:
            r2.addProperty((java.lang.String) r13, (java.lang.String) r8)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r2.addProperty((java.lang.String) r12, (java.lang.Number) r6)
            goto L_0x0204
        L_0x01f8:
            java.lang.String r6 = "NOT_APPLICABLE"
            r2.addProperty((java.lang.String) r13, (java.lang.String) r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r2.addProperty((java.lang.String) r12, (java.lang.Number) r6)
        L_0x0204:
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "locale"
            r2.addProperty((java.lang.String) r8, (java.lang.String) r6)
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getLanguage()
            java.lang.String r8 = "language"
            r2.addProperty((java.lang.String) r8, (java.lang.String) r6)
            java.util.TimeZone r6 = java.util.TimeZone.getDefault()
            java.lang.String r6 = r6.getID()
            java.lang.String r8 = "time_zone"
            r2.addProperty((java.lang.String) r8, (java.lang.String) r6)
            android.content.Context r6 = r15.context
            java.lang.String r8 = "audio"
            java.lang.Object r6 = r6.getSystemService(r8)
            android.media.AudioManager r6 = (android.media.AudioManager) r6
            if (r6 == 0) goto L_0x0259
            int r8 = r6.getStreamMaxVolume(r10)
            int r6 = r6.getStreamVolume(r10)
            float r9 = (float) r6
            float r8 = (float) r8
            float r9 = r9 / r8
            java.lang.Float r8 = java.lang.Float.valueOf(r9)
            java.lang.String r9 = "volume_level"
            r2.addProperty((java.lang.String) r9, (java.lang.Number) r8)
            if (r6 <= 0) goto L_0x024f
            r6 = 1
            goto L_0x0250
        L_0x024f:
            r6 = 0
        L_0x0250:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "sound_enabled"
            r2.addProperty((java.lang.String) r8, (java.lang.Number) r6)
        L_0x0259:
            com.vungle.warren.persistence.CacheManager r6 = r15.cacheManager
            java.io.File r6 = r6.getCache()
            r6.getPath()
            boolean r8 = r6.exists()
            if (r8 == 0) goto L_0x027d
            boolean r6 = r6.isDirectory()
            if (r6 == 0) goto L_0x027d
            com.vungle.warren.persistence.CacheManager r6 = r15.cacheManager
            long r8 = r6.getBytesAvailable()
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            java.lang.String r8 = "storage_bytes_available"
            r2.addProperty((java.lang.String) r8, (java.lang.Number) r6)
        L_0x027d:
            java.lang.String r6 = android.os.Build.MANUFACTURER
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0296
            android.content.Context r0 = r15.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r6 = "amazon.hardware.fire_tv"
            boolean r0 = r0.hasSystemFeature(r6)
            goto L_0x02d3
        L_0x0296:
            r6 = 23
            if (r3 < r6) goto L_0x02ae
            android.content.Context r6 = r15.context
            java.lang.String r8 = "uimode"
            java.lang.Object r6 = r6.getSystemService(r8)
            android.app.UiModeManager r6 = (android.app.UiModeManager) r6
            int r6 = r6.getCurrentModeType()
            if (r6 != r0) goto L_0x02ac
        L_0x02aa:
            r0 = 1
            goto L_0x02d3
        L_0x02ac:
            r0 = 0
            goto L_0x02d3
        L_0x02ae:
            android.content.Context r0 = r15.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r6 = "com.google.android.tv"
            boolean r0 = r0.hasSystemFeature(r6)
            if (r0 != 0) goto L_0x02aa
            android.content.Context r0 = r15.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r6 = "android.hardware.touchscreen"
            boolean r0 = r0.hasSystemFeature(r6)
            if (r0 != 0) goto L_0x02ac
            goto L_0x02aa
        L_0x02d3:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r6 = "is_tv"
            r2.addProperty((java.lang.String) r6, (java.lang.Boolean) r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.String r6 = "os_api_level"
            r2.addProperty((java.lang.String) r6, (java.lang.Number) r0)
            r0 = 26
            if (r3 < r0) goto L_0x0303
            android.content.Context r0 = r15.context     // Catch:{ SettingNotFoundException -> 0x0313 }
            java.lang.String r3 = "android.permission.REQUEST_INSTALL_PACKAGES"
            int r0 = r0.checkCallingOrSelfPermission(r3)     // Catch:{ SettingNotFoundException -> 0x0313 }
            if (r0 != 0) goto L_0x031b
            android.content.Context r0 = r15.context     // Catch:{ SettingNotFoundException -> 0x0313 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ SettingNotFoundException -> 0x0313 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ SettingNotFoundException -> 0x0313 }
            boolean r0 = r0.canRequestPackageInstalls()     // Catch:{ SettingNotFoundException -> 0x0313 }
            r4 = r0
            goto L_0x031b
        L_0x0303:
            android.content.Context r0 = r15.context     // Catch:{ SettingNotFoundException -> 0x0313 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0313 }
            java.lang.String r3 = "install_non_market_apps"
            int r0 = android.provider.Settings.Secure.getInt(r0, r3)     // Catch:{ SettingNotFoundException -> 0x0313 }
            if (r0 != r5) goto L_0x031b
            r4 = 1
            goto L_0x031b
        L_0x0313:
            r0 = move-exception
            java.lang.String r3 = TAG
            java.lang.String r5 = "isInstallNonMarketAppsEnabled Settings not found"
            android.util.Log.e(r3, r5, r0)
        L_0x031b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            java.lang.String r3 = "is_sideload_enabled"
            r2.addProperty((java.lang.String) r3, (java.lang.Boolean) r0)
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "sd_card_available"
            r2.addProperty((java.lang.String) r3, (java.lang.Number) r0)
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r3 = "os_name"
            r2.addProperty((java.lang.String) r3, (java.lang.String) r0)
            java.lang.String r0 = "vduid"
            r2.addProperty((java.lang.String) r0, (java.lang.String) r7)
            com.google.gson.JsonObject r0 = r15.deviceBody
            java.lang.String r3 = "ext"
            com.google.gson.JsonObject r0 = r0.getAsJsonObject(r3)
            java.lang.String r3 = "vungle"
            com.google.gson.JsonObject r0 = r0.getAsJsonObject(r3)
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x035c
            java.lang.String r1 = "amazon"
            goto L_0x035e
        L_0x035c:
            java.lang.String r1 = "android"
        L_0x035e:
            r0.add(r1, r2)
            com.google.gson.JsonObject r0 = r15.deviceBody
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VungleApiClient.getDeviceBody():com.google.gson.JsonObject");
    }

    private JsonObject getUserBody() {
        long j;
        String str;
        String str2;
        String str3;
        Class<Cookie> cls = Cookie.class;
        JsonObject jsonObject = new JsonObject();
        Cookie cookie = this.repository.load("consentIsImportantToVungle", cls).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        String str4 = "";
        if (cookie != null) {
            str2 = cookie.getString("consent_status");
            str = cookie.getString("consent_source");
            j = cookie.getLong("timestamp").longValue();
            str3 = cookie.getString("consent_message_version");
        } else {
            j = 0;
            str2 = "unknown";
            str = "no_interaction";
            str3 = str4;
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("consent_status", str2);
        jsonObject2.addProperty("consent_source", str);
        jsonObject2.addProperty("consent_timestamp", (Number) Long.valueOf(j));
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3;
        }
        jsonObject2.addProperty("consent_message_version", str4);
        jsonObject.add(GDPR.GDPR_STANDARD, jsonObject2);
        Cookie cookie2 = this.repository.load("ccpaIsImportantToVungle", cls).get();
        String string = cookie2 != null ? cookie2.getString("ccpa_status") : "opted_in";
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("status", string);
        jsonObject.add("ccpa", jsonObject3);
        return jsonObject;
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    private String getUserAgentFromCookie() {
        Cookie cookie = this.repository.load("userAgent", Cookie.class).get();
        if (cookie == null) {
            return System.getProperty("http.agent");
        }
        String string = cookie.getString("userAgent");
        return TextUtils.isEmpty(string) ? System.getProperty("http.agent") : string;
    }

    /* access modifiers changed from: private */
    public void addUserAgentInCookie(String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie("userAgent");
        cookie.putValue("userAgent", str);
        this.repository.save(cookie);
    }

    public long getRetryAfterHeaderValue(com.vungle.warren.network.Response response) {
        try {
            return Long.parseLong(response.headers().get("Retry-After")) * 1000;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static class ClearTextTrafficException extends IOException {
        ClearTextTrafficException(String str) {
            super(str);
        }
    }

    public Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    /* access modifiers changed from: package-private */
    public Boolean getPlayServicesAvailabilityFromCookie() {
        Cookie cookie = this.repository.load("isPlaySvcAvailable", Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie != null) {
            return cookie.getBoolean("isPlaySvcAvailable");
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Boolean getPlayServicesAvailabilityFromAPI() {
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            if (instance == null) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(instance.isGooglePlayServicesAvailable(this.context) == 0);
            addPlaySvcAvailabilityInCookie(valueOf.booleanValue());
            return valueOf;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Play services Not available");
            Boolean bool = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
                return bool;
            } catch (DatabaseHelper.DBException unused2) {
                Log.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        } catch (Exception unused3) {
            Log.w(TAG, "Unexpected exception from Play services lib.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void addPlaySvcAvailabilityInCookie(boolean z) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie("isPlaySvcAvailable");
        cookie.putValue("isPlaySvcAvailable", Boolean.valueOf(z));
        this.repository.save(cookie);
    }
}
