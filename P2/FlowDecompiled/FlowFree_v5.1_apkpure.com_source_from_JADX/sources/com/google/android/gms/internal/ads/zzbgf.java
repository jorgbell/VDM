package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public interface zzbgf extends zzyi, zzbfw, zzang, zzbhc, zzbhh, zzanu, zzri, zzbhl, zzl, zzbho, zzbhp, zzbdp, zzbhq {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    zzdqo zzF();

    WebView zzG();

    View zzH();

    void zzI();

    void zzJ(int i);

    void zzK();

    void zzL();

    Context zzM();

    zzm zzN();

    zzm zzO();

    zzbhv zzP();

    String zzQ();

    zzbht zzR();

    WebViewClient zzS();

    boolean zzT();

    zzfh zzU();

    IObjectWrapper zzV();

    boolean zzW();

    boolean zzX();

    void zzY();

    boolean zzZ();

    boolean zzaA();

    zzdqr zzaB();

    void zzaC(zzdqo zzdqo, zzdqr zzdqr);

    void zzaD(boolean z);

    zzefw<String> zzaE();

    boolean zzaa();

    void zzab(String str, zzakp<? super zzbgf> zzakp);

    void zzac(String str, zzakp<? super zzbgf> zzakp);

    void zzad(String str, Predicate<zzakp<? super zzbgf>> predicate);

    void zzae(zzm zzm);

    void zzaf(zzbhv zzbhv);

    void zzag(boolean z);

    void zzah();

    void zzai(Context context);

    void zzaj(boolean z);

    void zzak(IObjectWrapper iObjectWrapper);

    void zzal(int i);

    void zzam(zzm zzm);

    void zzan(boolean z);

    void zzao();

    void zzap(zzagw zzagw);

    zzagw zzaq();

    void zzar(boolean z);

    void zzas();

    void zzat(String str, String str2, String str3);

    void zzau();

    void zzav(boolean z);

    void zzaw(zzagt zzagt);

    void zzax(zzsv zzsv);

    zzsv zzay();

    boolean zzaz(boolean z, int i);

    zzbhb zzh();

    Activity zzj();

    zza zzk();

    zzafd zzq();

    zzbbq zzt();

    void zzu(String str, zzbfn zzbfn);

    void zzx(zzbhb zzbhb);
}
