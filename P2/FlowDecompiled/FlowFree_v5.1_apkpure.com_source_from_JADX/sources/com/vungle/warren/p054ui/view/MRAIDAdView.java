package com.vungle.warren.p054ui.view;

import android.content.Context;
import com.vungle.warren.p054ui.CloseDelegate;
import com.vungle.warren.p054ui.OrientationDelegate;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdView;

/* renamed from: com.vungle.warren.ui.view.MRAIDAdView */
public class MRAIDAdView extends BaseAdView<WebAdContract$WebAdPresenter> implements WebAdContract$WebAdView {
    private WebAdContract$WebAdPresenter presenter;

    public MRAIDAdView(Context context, FullAdWidget fullAdWidget, OrientationDelegate orientationDelegate, CloseDelegate closeDelegate) {
        super(context, fullAdWidget, orientationDelegate, closeDelegate);
    }

    public void updateWindow() {
        this.view.updateWindow();
    }

    public void setVisibility(boolean z) {
        this.view.setVisibility(z ? 0 : 8);
    }

    public void setPresenter(WebAdContract$WebAdPresenter webAdContract$WebAdPresenter) {
        this.presenter = webAdContract$WebAdPresenter;
    }

    public void showWebsite(String str) {
        this.view.showWebsite(str);
    }
}
