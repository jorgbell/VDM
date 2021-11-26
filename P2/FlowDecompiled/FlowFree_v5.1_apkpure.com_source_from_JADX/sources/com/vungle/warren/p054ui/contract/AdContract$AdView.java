package com.vungle.warren.p054ui.contract;

import android.content.DialogInterface;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.utility.ActivityManager;

/* renamed from: com.vungle.warren.ui.contract.AdContract$AdView */
public interface AdContract$AdView<T extends AdContract$AdvertisementPresenter> {
    void close();

    void destroyAdView(long j);

    String getWebsiteUrl();

    boolean hasWebView();

    void open(String str, ActivityManager.LeftApplicationCallback leftApplicationCallback);

    void pauseWeb();

    void refreshDialogIfVisible();

    void removeWebView();

    void resumeWeb();

    void setImmersiveMode();

    void setOrientation(int i);

    void setPresenter(T t);

    void showCloseButton();

    void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener);

    void showWebsite(String str);
}
