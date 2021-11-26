package com.vungle.warren.p054ui.contract;

/* renamed from: com.vungle.warren.ui.contract.LocalAdContract$LocalPresenter */
public interface LocalAdContract$LocalPresenter extends AdContract$AdvertisementPresenter<LocalAdContract$LocalView> {
    void onDownload();

    boolean onMediaError(String str);

    void onMute(boolean z);

    void onPrivacy();

    void onProgressUpdate(int i, float f);

    void onVideoStart(int i, float f);
}
