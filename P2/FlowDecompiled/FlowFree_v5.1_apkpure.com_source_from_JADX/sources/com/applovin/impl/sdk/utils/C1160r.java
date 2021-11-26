package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0940h;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0973a;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.r */
public abstract class C1160r {

    /* renamed from: a */
    private static Boolean f2495a;

    /* renamed from: com.applovin.impl.sdk.utils.r$a */
    private static class C1162a implements Player.EventListener {
        private C1162a() {
        }

        public void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        }

        public void onIsLoadingChanged(boolean z) {
        }

        public void onIsPlayingChanged(boolean z) {
        }

        public void onLoadingChanged(boolean z) {
        }

        public void onMediaItemTransition(MediaItem mediaItem, int i) {
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        public void onPlaybackStateChanged(int i) {
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        public void onPlayerStateChanged(boolean z, int i) {
        }

        public void onPositionDiscontinuity(int i) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSeekProcessed() {
        }

        public void onShuffleModeEnabledChanged(boolean z) {
        }

        public void onTimelineChanged(Timeline timeline, int i) {
        }

        public void onTimelineChanged(Timeline timeline, Object obj, int i) {
        }

        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }
    }

    /* renamed from: a */
    public static double m2699a(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return d / 1000.0d;
    }

    /* renamed from: a */
    public static float m2700a(float f) {
        return f * 1000.0f;
    }

    /* renamed from: a */
    public static int m2701a(JSONObject jSONObject) {
        int b = C1123j.m2592b(jSONObject, "video_completion_percent", -1, (C1062k) null);
        if (b < 0 || b > 100) {
            return 95;
        }
        return b;
    }

    /* renamed from: a */
    public static long m2702a(C1062k kVar) {
        long longValue = ((Long) kVar.mo9350a(C0965b.f1820em)).longValue();
        long longValue2 = ((Long) kVar.mo9350a(C0965b.f1821en)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    /* renamed from: a */
    public static Activity m2703a(View view, C1062k kVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                kVar.mo9411z().mo9585b("Utils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static View m2704a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    /* renamed from: a */
    public static C0928d m2705a(JSONObject jSONObject, C1062k kVar) {
        return C0928d.m1539a(AppLovinAdSize.fromString(C1123j.m2594b(jSONObject, "ad_size", (String) null, kVar)), AppLovinAdType.fromString(C1123j.m2594b(jSONObject, "ad_type", (String) null, kVar)), C1123j.m2594b(jSONObject, "zone_id", (String) null, kVar), kVar);
    }

    /* renamed from: a */
    public static AppLovinAd m2706a(AppLovinAd appLovinAd, C1062k kVar) {
        if (!(appLovinAd instanceof C0940h)) {
            return appLovinAd;
        }
        C0940h hVar = (C0940h) appLovinAd;
        AppLovinAd dequeueAd = kVar.mo9404t().dequeueAd(hVar.getAdZone());
        C1107r z = kVar.mo9411z();
        z.mo9584b("Utils", "Dequeued ad for dummy ad: " + dequeueAd);
        if (dequeueAd == null) {
            return hVar.mo9075a();
        }
        hVar.mo9076a(dequeueAd);
        ((AppLovinAdBase) dequeueAd).setDummyAd(hVar);
        return dequeueAd;
    }

    /* renamed from: a */
    public static Object m2707a(Object obj, C1062k kVar) {
        int i;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                hashMap.put(key instanceof String ? (String) key : String.valueOf(key), m2707a(entry.getValue(), kVar));
            }
            return hashMap;
        } else if (obj instanceof List) {
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object a : list) {
                arrayList.add(m2707a(a, kVar));
            }
            return arrayList;
        } else if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        } else {
            String valueOf = String.valueOf(obj);
            if (obj instanceof String) {
                i = ((Integer) kVar.mo9350a(C0965b.f1601aZ)).intValue();
                if (i <= 0 || valueOf.length() <= i) {
                    return valueOf;
                }
            } else if (!(obj instanceof Uri) || (i = ((Integer) kVar.mo9350a(C0965b.f1655ba)).intValue()) <= 0 || valueOf.length() <= i) {
                return valueOf;
            }
            return valueOf.substring(0, i);
        }
    }

    /* renamed from: a */
    public static String m2708a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: a */
    public static String m2709a(Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() {
                /* renamed from: a */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next.getKey());
            sb.append('=');
            sb.append(next.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m2710a(boolean z, String str) {
        return str.replace("{PLACEMENT}", "").replace("{SOC}", String.valueOf(z));
    }

    /* renamed from: a */
    public static Field m2711a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return m2711a(superclass, str);
        }
    }

    /* renamed from: a */
    public static List<C0973a> m2712a(String str, JSONObject jSONObject, String str2, String str3, C1062k kVar) {
        return m2713a(str, jSONObject, str2, (Map<String, String>) null, str3, kVar);
    }

    /* renamed from: a */
    public static List<C0973a> m2713a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, C1062k kVar) {
        return m2714a(str, jSONObject, str2, map, str3, (Map<String, String>) null, false, kVar);
    }

    /* renamed from: a */
    public static List<C0973a> m2714a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, boolean z, C1062k kVar) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put("{CLCODE}", str2);
        return m2715a(str, jSONObject, map3, str3, map2, z, kVar);
    }

    /* renamed from: a */
    public static List<C0973a> m2715a(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, boolean z, C1062k kVar) {
        JSONObject b = C1123j.m2600b(jSONObject, str, new JSONObject(), kVar);
        ArrayList arrayList = new ArrayList(b.length() + 1);
        if (C1155o.m2673b(str2)) {
            arrayList.add(new C0973a(str2, (String) null, map2, z));
        }
        if (b.length() > 0) {
            Iterator<String> keys = b.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = b.optString(next);
                        String a = C1155o.m2668a(next, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = C1155o.m2668a(optString, map);
                        }
                        arrayList.add(new C0973a(a, optString, map2, z));
                    }
                } catch (Throwable th) {
                    kVar.mo9411z().mo9585b("Utils", "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<Class> m2716a(List<String> list, C1062k kVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            try {
                arrayList.add(Class.forName(next));
            } catch (ClassNotFoundException unused) {
                C1107r z = kVar.mo9411z();
                z.mo9588e("Utils", "Failed to create class for name: " + next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Uri> m2717a(boolean z, C0934g gVar, C1062k kVar, Context context) {
        if (gVar instanceof C0536a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : new ArrayList(gVar.mo9074z())) {
            if (!kVar.mo9349Z().mo9571b(uri.getLastPathSegment(), context)) {
                C1107r z2 = kVar.mo9411z();
                z2.mo9588e("Utils", "Cached HTML asset missing: " + uri);
                arrayList.add(uri);
            }
        }
        if (z) {
            Uri g = gVar.mo7829g();
            if (!kVar.mo9349Z().mo9571b(g.getLastPathSegment(), context)) {
                C1107r z3 = kVar.mo9411z();
                z3.mo9588e("Utils", "Cached video missing: " + g);
                arrayList.add(g);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, String> m2718a(AppLovinSdkSettings appLovinSdkSettings) {
        try {
            Field a = m2711a((Class) appLovinSdkSettings.getClass(), "metaData");
            if (a != null) {
                a.setAccessible(true);
            }
            return (Map) a.get(appLovinSdkSettings);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m2719a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m2720a(Closeable closeable, C1062k kVar) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2721a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getDisplayName() + ": " + str, 1).show();
    }

    /* renamed from: a */
    public static void m2722a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, C1062k kVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object b = C1123j.m2593b(jSONObject, "no_fill_reason", new Object(), kVar);
            C1107r.m2484i("AppLovinSdk", "\n**************************************************\nNO FILL received:\n..ID: \"" + str + "\"\n..FORMAT: \"" + maxAdFormat.getLabel() + "\"\n..SDK KEY: \"" + kVar.mo9409x() + "\"\n..PACKAGE NAME: \"" + kVar.mo9334J().getPackageName() + "\"\n..Reason: " + b + "\n**************************************************\n");
        }
    }

    /* renamed from: a */
    public static void m2723a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(17039370, (DialogInterface.OnClickListener) null).create().show();
    }

    /* renamed from: a */
    public static void m2724a(String str, String str2, Map map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m2725a(HttpURLConnection httpURLConnection, C1062k kVar) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (kVar != null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9585b("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m2726a() {
        Context K = C1062k.m2110K();
        if (K != null) {
            return C1114c.m2509a(K).mo9607a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2727a(int i) {
        return i > 0 && i <= 100 && ((int) (Math.random() * 100.0d)) + 1 <= i;
    }

    /* renamed from: a */
    public static boolean m2728a(long j, long j2) {
        return (j & j2) != 0;
    }

    /* renamed from: a */
    public static boolean m2729a(Context context) {
        if (context == null) {
            context = C1062k.m2110K();
        }
        if (context != null) {
            return C1114c.m2509a(context).mo9608a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2730a(Context context, Uri uri, C1062k kVar) {
        boolean z;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            if ("market".equals(intent.getScheme())) {
                intent.setPackage("com.android.vending");
            }
            kVar.mo9368ac().mo9719b();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C1107r z2 = kVar.mo9411z();
            z2.mo9585b("Utils", "Unable to open \"" + uri + "\".", th);
            z = false;
        }
        if (!z) {
            kVar.mo9368ac().mo9720c();
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m2731a(View view, Activity activity) {
        View rootView;
        if (!(activity == null || view == null)) {
            Window window = activity.getWindow();
            if (window != null) {
                rootView = window.getDecorView();
            } else {
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    rootView = findViewById.getRootView();
                }
            }
            return m2732a(view, rootView);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2732a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (m2732a(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2733a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER || appLovinAdSize == AppLovinAdSize.CROSS_PROMO;
    }

    /* renamed from: a */
    public static boolean m2734a(Object obj, List<String> list, C1062k kVar) {
        if (list == null) {
            return false;
        }
        for (Class isInstance : m2716a(list, kVar)) {
            if (isInstance.isInstance(obj)) {
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        if (!(entry.getKey() instanceof String)) {
                            kVar.mo9411z().mo9584b("Utils", "Invalid key type used. Map keys should be of type String.");
                            return false;
                        } else if (!m2734a(entry.getValue(), list, kVar)) {
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof List)) {
                    return true;
                } else {
                    for (Object a : (List) obj) {
                        if (!m2734a(a, list, kVar)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        C1107r z = kVar.mo9411z();
        z.mo9584b("Utils", "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        return false;
    }

    /* renamed from: a */
    public static boolean m2735a(String str, List<String> list) {
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m2736a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public static int m2737b(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    /* renamed from: b */
    public static long m2738b(float f) {
        return m2746c(m2700a(f));
    }

    /* renamed from: b */
    public static String m2739b(Class cls, String str) {
        try {
            Field a = m2711a(cls, str);
            a.setAccessible(true);
            return (String) a.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m2740b(String str) {
        return m2710a(false, str);
    }

    /* renamed from: b */
    public static Map<String, String> m2741b(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                hashMap.put(str, C1155o.m2678f(str2));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m2742b(AppLovinAd appLovinAd, C1062k kVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String x = kVar.mo9409x();
            String x2 = ((AppLovinAdBase) appLovinAd).getSdk().mo9409x();
            if (!x.equals(x2)) {
                C1107r.m2484i("AppLovinAd", "Ad was loaded from sdk with key: " + x2 + ", but is being rendered from sdk with key: " + x);
                kVar.mo9341R().mo9199a(C0986g.f1965l);
            }
        }
    }

    /* renamed from: b */
    public static void m2743b(String str, String str2, Map<String, Object> map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    /* renamed from: b */
    public static boolean m2744b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static boolean m2745b(C1062k kVar) {
        Boolean bool = f2495a;
        if (bool != null) {
            return bool.booleanValue();
        }
        int h = m2763h();
        int intValue = ((Integer) kVar.mo9350a(C0965b.f1688cH)).intValue();
        if (m2753d("com.google.android.exoplayer2.ui.PlayerView") && h >= ((Integer) kVar.mo9350a(C0965b.f1687cG)).intValue() && (intValue < 0 || h <= intValue)) {
            try {
                SimpleExoPlayer build = new SimpleExoPlayer.Builder(kVar.mo9334J()).build();
                build.addListener(new C1162a());
                build.setMediaSource(new DefaultMediaSourceFactory(kVar.mo9334J()).createMediaSource(MediaItem.fromUri("")));
                build.release();
                f2495a = Boolean.TRUE;
                return true;
            } catch (Throwable th) {
                C1107r z = kVar.mo9411z();
                z.mo9584b("Utils", "Marking ExoPlayer not eligible due to throwable: " + th);
            }
        }
        f2495a = Boolean.FALSE;
        return false;
    }

    /* renamed from: c */
    private static long m2746c(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: c */
    public static String m2747c(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0).activityInfo.name;
        }
        return null;
    }

    /* renamed from: c */
    public static String m2748c(String str) {
        Uri parse = Uri.parse(str);
        return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).build().toString();
    }

    /* renamed from: c */
    public static boolean m2749c() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            C1107r.m2480c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i = runningAppProcessInfo.importance;
        return i == 100 || i == 200;
    }

    /* renamed from: c */
    public static boolean m2750c(C1062k kVar) {
        if (!C1119g.m2530c()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            kVar.mo9411z().mo9583a("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    /* renamed from: d */
    public static int m2751d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[Catch:{ all -> 0x002e }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2752d() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ all -> 0x002e }
        L_0x0004:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x002e }
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r1.getDisplayName()     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "tun"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ppp"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ipsec"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0004
        L_0x002c:
            r0 = 1
            return r0
        L_0x002e:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "Unable to check Network Interfaces"
            com.applovin.impl.sdk.C1107r.m2480c(r1, r2, r0)
        L_0x0036:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1160r.m2752d():boolean");
    }

    /* renamed from: d */
    public static boolean m2753d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static long m2754e(String str) {
        if (!C1155o.m2673b(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return (long) Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    /* renamed from: e */
    public static String m2755e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt((Object) null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            C1107r.m2480c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    /* renamed from: e */
    public static boolean m2756e(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: f */
    public static int m2757f(String str) {
        int i = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                C1107r.m2484i("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i;
            }
            i = (i * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i * 100) + 99 : i;
    }

    /* renamed from: f */
    public static String m2758f() {
        return m2762g("getVersion");
    }

    /* renamed from: f */
    public static boolean m2759f(Context context) {
        return C1114c.m2509a(context).mo9607a("applovin.sdk.is_test_environment");
    }

    /* renamed from: g */
    public static int m2760g(Context context) {
        boolean b = C1119g.m2529b();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    /* renamed from: g */
    public static String m2761g() {
        return m2762g("getSdkKey");
    }

    /* renamed from: g */
    private static String m2762g(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("com.applovin.quality.AppLovinQualityService");
        } catch (Throwable unused) {
            return "";
        }
        return (String) cls.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    /* renamed from: h */
    public static int m2763h() {
        try {
            Field a = m2711a((Class) Class.forName("com.google.android.exoplayer2.ExoPlayerLibraryInfo"), "VERSION_INT");
            a.setAccessible(true);
            return ((Integer) a.get((Object) null)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: i */
    public static boolean m2764i() {
        try {
            Class.forName("com.applovin.sdk.AppLovinSdk");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }
}
