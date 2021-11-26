package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Predicate;
import com.mopub.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbgm extends WebViewClient implements zzbht {
    public static final /* synthetic */ int zzb = 0;
    private View.OnAttachStateChangeListener zzA;
    protected zzayr zza;
    private final zzbgf zzc;
    private final zzug zzd;
    private final HashMap<String, List<zzakp<? super zzbgf>>> zze = new HashMap<>();
    private final Object zzf = new Object();
    private zzyi zzg;
    private zzp zzh;
    private zzbhr zzi;
    private zzbhs zzj;
    private zzajq zzk;
    private zzajs zzl;
    private boolean zzm;
    private boolean zzn;
    @GuardedBy("lock")
    private boolean zzo;
    @GuardedBy("lock")
    private boolean zzp;
    @GuardedBy("lock")
    private boolean zzq;
    private zzw zzr;
    private zzatj zzs;
    private zzb zzt;
    private zzate zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private boolean zzy;
    private final HashSet<String> zzz;

    public zzbgm(zzbgf zzbgf, zzug zzug, boolean z) {
        zzatj zzatj = new zzatj(zzbgf, zzbgf.zzM(), new zzaeb(zzbgf.getContext()));
        this.zzd = zzug;
        this.zzc = zzbgf;
        this.zzo = z;
        this.zzs = zzatj;
        this.zzu = null;
        this.zzz = new HashSet<>(Arrays.asList(((String) zzaaa.zzc().zzb(zzaeq.zzdM)).split(",")));
    }

    /* access modifiers changed from: private */
    public final void zzL(View view, zzayr zzayr, int i) {
        if (zzayr.zzc() && i > 0) {
            zzayr.zzd(view);
            if (zzayr.zzc()) {
                zzr.zza.postDelayed(new zzbgg(this, view, zzayr, i), 100);
            }
        }
    }

    private final void zzM() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzA;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    private static WebResourceResponse zzN() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzav)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzO(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry next : map.entrySet()) {
                        openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzs.zzc().zzb(this.zzc.getContext(), this.zzc.zzt().zza, false, httpURLConnection, false, 60000);
                        zzbbj zzbbj = new zzbbj((String) null);
                        zzbbj.zza(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzbbj.zzc(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzs.zzc();
                            WebResourceResponse zzQ = zzr.zzQ(httpURLConnection);
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zzbbk.zzi("Protocol is null");
                                    WebResourceResponse zzN = zzN();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzN;
                                } else if (protocol.equals("http") || protocol.equals(Constants.HTTPS)) {
                                    zzbbk.zzd(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    zzbbk.zzi(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                                    return zzN();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzs.zzc();
            WebResourceResponse zzQ2 = zzr.zzQ(httpURLConnection);
            TrafficStats.clearThreadStatsTag();
            return zzQ2;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzP(Map<String, String> map, List<zzakp<? super zzbgf>> list, String str) {
        if (zze.zzc()) {
            zze.zza(str.length() != 0 ? "Received GMSG: ".concat(str) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str2).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zze.zza(sb.toString());
            }
        }
        for (zzakp<? super zzbgf> zza2 : list) {
            zza2.zza(this.zzc, map);
        }
    }

    public final void onAdClicked() {
        zzyi zzyi = this.zzg;
        if (zzyi != null) {
            zzyi.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zze.zza(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzD(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzb();
        r0.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzv = true;
        r1 = r0.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.zzf
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbgf r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.zzX()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbgf r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            r2.zzY()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzv = r1
            com.google.android.gms.internal.ads.zzbhs r1 = r0.zzj
            if (r1 == 0) goto L_0x0025
            r1.zzb()
            r1 = 0
            r0.zzj = r1
        L_0x0025:
            r0.zzl()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgm.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzn = true;
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaz(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzy(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "AdWebView shouldOverrideUrlLoading: ".concat(valueOf);
        } else {
            str2 = new String("AdWebView shouldOverrideUrlLoading: ");
        }
        zze.zza(str2);
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzm && webView == this.zzc.zzG()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) {
                    zzyi zzyi = this.zzg;
                    if (zzyi != null) {
                        zzyi.onAdClicked();
                        zzayr zzayr = this.zza;
                        if (zzayr != null) {
                            zzayr.zzb(str);
                        }
                        this.zzg = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzG().willNotDraw()) {
                try {
                    zzfh zzU = this.zzc.zzU();
                    if (zzU != null && zzU.zza(parse)) {
                        Context context = this.zzc.getContext();
                        zzbgf zzbgf = this.zzc;
                        parse = zzU.zze(parse, context, (View) zzbgf, zzbgf.zzj());
                    }
                } catch (zzfi unused) {
                    String valueOf2 = String.valueOf(str);
                    zzbbk.zzi(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zzb zzb2 = this.zzt;
                if (zzb2 == null || zzb2.zzb()) {
                    zzm(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzu) null));
                    return true;
                }
                this.zzt.zzc(str);
                return true;
            }
            String valueOf3 = String.valueOf(str);
            zzbbk.zzi(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            return true;
        }
        zzD(parse);
        return true;
    }

    public final void zzA() {
        synchronized (this.zzf) {
            this.zzm = false;
            this.zzo = true;
            zzbbw.zze.execute(new zzbgh(this));
        }
    }

    public final void zzB(boolean z) {
        this.zzy = z;
    }

    public final void zzC(int i, int i2) {
        zzate zzate = this.zzu;
        if (zzate != null) {
            zzate.zze(i, i2);
        }
    }

    public final void zzD(Uri uri) {
        String path = uri.getPath();
        List list = this.zze.get(path);
        if (path == null || list == null) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(valueOf);
            zze.zza(sb.toString());
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeO)).booleanValue() && zzs.zzg().zza() != null) {
                zzbbw.zza.execute(new zzbgi((path == null || path.length() < 2) ? "null" : path.substring(1)));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdL)).booleanValue() && this.zzz.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzdN)).intValue()) {
                zze.zza(path.length() != 0 ? "Parsing gmsg query params on BG thread: ".concat(path) : new String("Parsing gmsg query params on BG thread: "));
                zzefo.zzo(zzs.zzc().zzi(uri), new zzbgk(this, list, path, uri), zzbbw.zze);
                return;
            }
        }
        zzs.zzc();
        zzP(zzr.zzP(uri), list, path);
    }

    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzp = true;
        }
    }

    public final void zzF(boolean z) {
        synchronized (this.zzf) {
            this.zzq = z;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG() {
        this.zzc.zzah();
        zzm zzN = this.zzc.zzN();
        if (zzN != null) {
            zzN.zzv();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(View view, zzayr zzayr, int i) {
        zzL(view, zzayr, i - 1);
    }

    public final void zzK(zzyi zzyi, zzajq zzajq, zzp zzp2, zzajs zzajs, zzw zzw2, boolean z, zzaks zzaks, zzb zzb2, zzatl zzatl, zzayr zzayr, zzcvk zzcvk, zzdwg zzdwg, zzcni zzcni, zzdvo zzdvo, zzakq zzakq) {
        zzajq zzajq2 = zzajq;
        zzajs zzajs2 = zzajs;
        zzaks zzaks2 = zzaks;
        zzatl zzatl2 = zzatl;
        zzayr zzayr2 = zzayr;
        zzakq zzakq2 = zzakq;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzayr2, (zzavq) null) : zzb2;
        this.zzu = new zzate(this.zzc, zzatl2);
        this.zza = zzayr2;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaC)).booleanValue()) {
            zzs("/adMetadata", new zzajp(zzajq2));
        }
        if (zzajs2 != null) {
            zzs("/appEvent", new zzajr(zzajs2));
        }
        zzs("/backButton", zzako.zzk);
        zzs("/refresh", zzako.zzl);
        zzs("/canOpenApp", zzako.zzb);
        zzs("/canOpenURLs", zzako.zza);
        zzs("/canOpenIntents", zzako.zzc);
        zzs("/close", zzako.zze);
        zzs("/customClose", zzako.zzf);
        zzs("/instrument", zzako.zzo);
        zzs("/delayPageLoaded", zzako.zzq);
        zzs("/delayPageClosed", zzako.zzr);
        zzs("/getLocationInfo", zzako.zzs);
        zzs("/log", zzako.zzh);
        zzs("/mraid", new zzakw(zzb3, this.zzu, zzatl2));
        zzatj zzatj = this.zzs;
        if (zzatj != null) {
            zzs("/mraidLoaded", zzatj);
        }
        zzs("/open", new zzala(zzb3, this.zzu, zzcvk, zzcni, zzdvo));
        zzs("/precache", new zzbfo());
        zzs("/touch", zzako.zzj);
        zzs("/video", zzako.zzm);
        zzs("/videoMeta", zzako.zzn);
        if (zzcvk == null || zzdwg == null) {
            zzs("/click", zzako.zzd);
            zzs("/httpTrack", zzako.zzg);
        } else {
            zzs("/click", zzdrp.zza(zzcvk, zzdwg));
            zzs("/httpTrack", zzdrp.zzb(zzcvk, zzdwg));
        }
        if (zzs.zzA().zzb(this.zzc.getContext())) {
            zzs("/logScionEvent", new zzakv(this.zzc.getContext()));
        }
        if (zzaks2 != null) {
            zzs("/setInterstitialProperties", new zzakr(zzaks2, (byte[]) null));
        }
        if (zzakq2 != null) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue()) {
                zzs("/inspectorNetworkExtras", zzakq2);
            }
        }
        this.zzg = zzyi;
        this.zzh = zzp2;
        this.zzk = zzajq2;
        this.zzl = zzajs2;
        this.zzr = zzw2;
        this.zzt = zzb3;
        this.zzm = z;
    }

    public final void zza(int i, int i2, boolean z) {
        zzatj zzatj = this.zzs;
        if (zzatj != null) {
            zzatj.zzb(i, i2);
        }
        zzate zzate = this.zzu;
        if (zzate != null) {
            zzate.zzc(i, i2, false);
        }
    }

    public final zzb zzb() {
        return this.zzt;
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzo;
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzp;
        }
        return z;
    }

    public final boolean zze() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzq;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzf() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzg() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final void zzh() {
        zzayr zzayr = this.zza;
        if (zzayr != null) {
            WebView zzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(zzG)) {
                zzL(zzG, zzayr, 10);
                return;
            }
            zzM();
            zzbgj zzbgj = new zzbgj(this, zzayr);
            this.zzA = zzbgj;
            ((View) this.zzc).addOnAttachStateChangeListener(zzbgj);
        }
    }

    public final void zzi() {
        synchronized (this.zzf) {
        }
        this.zzx++;
        zzl();
    }

    public final void zzj() {
        this.zzx--;
        zzl();
    }

    public final void zzk() {
        zzug zzug = this.zzd;
        if (zzug != null) {
            zzug.zzb(zzui.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzw = true;
        zzl();
        this.zzc.destroy();
    }

    public final void zzl() {
        if (this.zzi != null && ((this.zzv && this.zzx <= 0) || this.zzw || this.zzn)) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbj)).booleanValue() && this.zzc.zzq() != null) {
                zzaex.zza(this.zzc.zzq().zzc(), this.zzc.zzi(), "awfllc");
            }
            zzbhr zzbhr = this.zzi;
            boolean z = false;
            if (!this.zzw && !this.zzn) {
                z = true;
            }
            zzbhr.zza(z);
            this.zzi = null;
        }
        this.zzc.zzao();
    }

    public final void zzm(zzc zzc2) {
        zzyi zzyi;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzyi = this.zzg;
        } else {
            zzyi = null;
        }
        zzr(new AdOverlayInfoParcel(zzc2, zzyi, zzW ? null : this.zzh, this.zzr, this.zzc.zzt(), this.zzc));
    }

    public final void zzn(zzbh zzbh, zzcvk zzcvk, zzcni zzcni, zzdvo zzdvo, String str, String str2, int i) {
        zzbgf zzbgf = this.zzc;
        zzr(new AdOverlayInfoParcel(zzbgf, zzbgf.zzt(), zzbh, zzcvk, zzcni, zzdvo, str, str2, i));
    }

    public final void zzo(boolean z, int i) {
        zzyi zzyi;
        if (!this.zzc.zzW() || this.zzc.zzP().zzg()) {
            zzyi = this.zzg;
        } else {
            zzyi = null;
        }
        zzp zzp2 = this.zzh;
        zzw zzw2 = this.zzr;
        zzbgf zzbgf = this.zzc;
        zzr(new AdOverlayInfoParcel(zzyi, zzp2, zzw2, zzbgf, z, i, zzbgf.zzt()));
    }

    public final void zzp(boolean z, int i, String str) {
        zzyi zzyi;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzyi = this.zzg;
        } else {
            zzyi = null;
        }
        zzbgl zzbgl = zzW ? null : new zzbgl(this.zzc, this.zzh);
        zzajq zzajq = this.zzk;
        zzajs zzajs = this.zzl;
        zzw zzw2 = this.zzr;
        zzbgf zzbgf = this.zzc;
        zzr(new AdOverlayInfoParcel(zzyi, zzbgl, zzajq, zzajs, zzw2, zzbgf, z, i, str, zzbgf.zzt()));
    }

    public final void zzq(boolean z, int i, String str, String str2) {
        zzyi zzyi;
        boolean zzW = this.zzc.zzW();
        if (!zzW || this.zzc.zzP().zzg()) {
            zzyi = this.zzg;
        } else {
            zzyi = null;
        }
        zzbgl zzbgl = zzW ? null : new zzbgl(this.zzc, this.zzh);
        zzajq zzajq = this.zzk;
        zzajs zzajs = this.zzl;
        zzw zzw2 = this.zzr;
        zzbgf zzbgf = this.zzc;
        zzr(new AdOverlayInfoParcel(zzyi, (zzp) zzbgl, zzajq, zzajs, zzw2, zzbgf, z, i, str, str2, zzbgf.zzt()));
    }

    public final void zzr(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzc2;
        zzate zzate = this.zzu;
        boolean zzd2 = zzate != null ? zzate.zzd() : false;
        zzs.zzb();
        zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zzd2);
        zzayr zzayr = this.zza;
        if (zzayr != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzayr.zzb(str);
        }
    }

    public final void zzs(String str, zzakp<? super zzbgf> zzakp) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzakp);
        }
    }

    public final void zzt(String str, zzakp<? super zzbgf> zzakp) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list != null) {
                list.remove(zzakp);
            }
        }
    }

    public final void zzu(String str, Predicate<zzakp<? super zzbgf>> predicate) {
        synchronized (this.zzf) {
            List<zzakp> list = this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzakp zzakp : list) {
                    if (predicate.apply(zzakp)) {
                        arrayList.add(zzakp);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zzv() {
        zzayr zzayr = this.zza;
        if (zzayr != null) {
            zzayr.zzf();
            this.zza = null;
        }
        zzM();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzm = false;
            this.zzo = false;
            this.zzp = false;
            this.zzr = null;
            this.zzt = null;
            this.zzs = null;
            zzate zzate = this.zzu;
            if (zzate != null) {
                zzate.zzb(true);
                this.zzu = null;
            }
        }
    }

    public final void zzw(zzbhr zzbhr) {
        this.zzi = zzbhr;
    }

    public final void zzx(zzbhs zzbhs) {
        this.zzj = zzbhs;
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzy(String str, Map<String, String> map) {
        zztp zzc2;
        try {
            String zza2 = zzazv.zza(str, this.zzc.getContext(), this.zzy);
            if (!zza2.equals(str)) {
                return zzO(zza2, map);
            }
            zzts zza3 = zzts.zza(Uri.parse(str));
            if (zza3 != null && (zzc2 = zzs.zzi().zzc(zza3)) != null && zzc2.zza()) {
                return new WebResourceResponse("", "", zzc2.zzb());
            }
            if (!zzbbj.zzj() || !zzaga.zzb.zze().booleanValue()) {
                return null;
            }
            return zzO(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzs.zzg().zzg(e, "AdWebViewClient.interceptRequest");
            return zzN();
        }
    }

    public final void zzz(boolean z) {
        this.zzm = false;
    }
}
