package com.vungle.warren.p054ui.contract;

import com.vungle.warren.error.VungleException;
import com.vungle.warren.p054ui.JavascriptBridge;
import com.vungle.warren.p054ui.contract.AdContract$AdView;
import com.vungle.warren.p054ui.state.OptionsState;

/* renamed from: com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter */
public interface AdContract$AdvertisementPresenter<T extends AdContract$AdView> extends JavascriptBridge.MraidHandler {

    /* renamed from: com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener */
    public interface EventListener {
        void onError(VungleException vungleException, String str);

        void onNext(String str, String str2, String str3);
    }

    void attach(T t, OptionsState optionsState);

    void detach(int i);

    void generateSaveState(OptionsState optionsState);

    boolean handleExit();

    void onViewConfigurationChanged();

    void restoreFromSave(OptionsState optionsState);

    void setEventListener(EventListener eventListener);

    void start();

    void stop(int i);
}
