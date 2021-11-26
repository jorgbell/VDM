package com.vungle.warren.p054ui.contract;

import com.vungle.warren.p054ui.presenter.LocalAdPresenter;
import java.io.File;

/* renamed from: com.vungle.warren.ui.contract.LocalAdContract$LocalView */
public interface LocalAdContract$LocalView extends AdContract$AdView<LocalAdPresenter> {
    int getVideoPosition();

    boolean isDialogVisible();

    boolean isVideoPlaying();

    void pauseVideo();

    void playVideo(File file, boolean z, int i);

    void showCTAOverlay(boolean z, boolean z2);
}
