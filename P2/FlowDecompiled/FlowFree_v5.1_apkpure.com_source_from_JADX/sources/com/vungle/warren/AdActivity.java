package com.vungle.warren;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p054ui.CloseDelegate;
import com.vungle.warren.p054ui.OrientationDelegate;
import com.vungle.warren.p054ui.contract.AdContract$AdView;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.p054ui.state.BundleOptionsState;
import com.vungle.warren.p054ui.state.OptionsState;
import com.vungle.warren.p054ui.view.FullAdWidget;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AdActivity extends Activity {
    /* access modifiers changed from: private */
    public static AdContract$AdvertisementPresenter.EventListener bus;
    private BroadcastReceiver broadcastReceiver;
    private PresentationFactory.FullScreenCallback fullscreenCallback = new PresentationFactory.FullScreenCallback() {
        public void onResult(Pair<AdContract$AdView, AdContract$AdvertisementPresenter> pair, VungleException vungleException) {
            if (pair == null || vungleException != null) {
                PresentationFactory unused = AdActivity.this.presenterFactory = null;
                AdActivity adActivity = AdActivity.this;
                adActivity.deliverError(10, adActivity.placementId);
                AdActivity.this.finish();
                return;
            }
            AdContract$AdvertisementPresenter unused2 = AdActivity.this.presenter = (AdContract$AdvertisementPresenter) pair.second;
            AdActivity.this.presenter.setEventListener(AdActivity.bus);
            AdActivity.this.presenter.attach((AdContract$AdView) pair.first, AdActivity.this.state);
            if (AdActivity.this.pendingStart.getAndSet(false)) {
                AdActivity.this.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public AtomicBoolean pendingStart = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public String placementId;
    /* access modifiers changed from: private */
    public AdContract$AdvertisementPresenter presenter;
    /* access modifiers changed from: private */
    public PresentationFactory presenterFactory;
    private boolean resumed = false;
    private boolean started = false;
    /* access modifiers changed from: private */
    public OptionsState state;

    /* access modifiers changed from: protected */
    public abstract boolean canRotate();

    public static void setEventListener(AdContract$AdvertisementPresenter.EventListener eventListener) {
        bus = eventListener;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        OptionsState optionsState;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        this.placementId = getIntent().getStringExtra("placement");
        ServiceLocator instance = ServiceLocator.getInstance(this);
        if (!((VungleStaticApi) instance.getService(VungleStaticApi.class)).isInitialized() || bus == null || TextUtils.isEmpty(this.placementId)) {
            finish();
            return;
        }
        try {
            FullAdWidget fullAdWidget = new FullAdWidget(this, getWindow());
            this.presenterFactory = (PresentationFactory) instance.getService(PresentationFactory.class);
            if (bundle == null) {
                optionsState = null;
            } else {
                optionsState = (OptionsState) bundle.getParcelable("presenter_state");
            }
            OptionsState optionsState2 = optionsState;
            this.state = optionsState2;
            this.presenterFactory.getFullScreenPresentation(this, this.placementId, fullAdWidget, optionsState2, new CloseDelegate() {
                public void close() {
                    AdActivity.this.finish();
                }
            }, new OrientationDelegate() {
                public void setOrientation(int i) {
                    AdActivity.this.setRequestedOrientation(i);
                }
            }, bundle, this.fullscreenCallback);
            setContentView(fullAdWidget, fullAdWidget.getLayoutParams());
            connectBroadcastReceiver();
        } catch (InstantiationException unused) {
            deliverError(10, this.placementId);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = getIntent().getStringExtra("placement");
        String stringExtra2 = intent.getStringExtra("placement");
        if (stringExtra != null && stringExtra2 != null && !stringExtra.equals(stringExtra2)) {
            Log.d("VungleActivity", "Tried to play another placement " + stringExtra2 + " while playing " + stringExtra);
            deliverError(15, stringExtra2);
            StringBuilder sb = new StringBuilder();
            sb.append(AdActivity.class.getSimpleName());
            sb.append("#onNewIntent");
            VungleLogger.warn(sb.toString(), String.format("Tried to play another placement %1$s while playing %2$s", new Object[]{stringExtra2, stringExtra}));
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(int i, String str) {
        VungleException vungleException = new VungleException(i);
        AdContract$AdvertisementPresenter.EventListener eventListener = bus;
        if (eventListener != null) {
            eventListener.onError(vungleException, str);
        }
        VungleLogger.error(AdActivity.class.getSimpleName() + "#deliverError", vungleException.getLocalizedMessage());
    }

    private void connectBroadcastReceiver() {
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("command");
                stringExtra.hashCode();
                if (!stringExtra.equals("stopAll")) {
                    VungleLogger.warn(AdActivity.class.getSimpleName() + "#connectBroadcastReceiver", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
                    return;
                }
                AdActivity.this.finish();
            }
        };
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.broadcastReceiver, new IntentFilter("AdvertisementBus"));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            start();
        } else {
            stop();
        }
    }

    /* access modifiers changed from: private */
    public void start() {
        if (this.presenter == null) {
            this.pendingStart.set(true);
        } else if (!this.started && this.resumed && hasWindowFocus()) {
            this.presenter.start();
            this.started = true;
        }
    }

    private void stop() {
        if (this.presenter != null && this.started) {
            this.presenter.stop(isChangingConfigurations() | (isFinishing() ? (char) 2 : 0) ? 1 : 0);
            this.started = false;
        }
        this.pendingStart.set(false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.resumed = true;
        start();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.resumed = false;
        stop();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i == 2) {
            Log.d("VungleActivity", "landscape");
        } else if (i == 1) {
            Log.d("VungleActivity", "portrait");
        }
        AdContract$AdvertisementPresenter adContract$AdvertisementPresenter = this.presenter;
        if (adContract$AdvertisementPresenter != null) {
            adContract$AdvertisementPresenter.onViewConfigurationChanged();
        }
    }

    @SuppressLint({"ResourceType"})
    public void onBackPressed() {
        AdContract$AdvertisementPresenter adContract$AdvertisementPresenter = this.presenter;
        if (adContract$AdvertisementPresenter != null) {
            adContract$AdvertisementPresenter.handleExit();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Log.d("VungleActivity", "onSaveInstanceState");
        BundleOptionsState bundleOptionsState = new BundleOptionsState();
        AdContract$AdvertisementPresenter adContract$AdvertisementPresenter = this.presenter;
        if (adContract$AdvertisementPresenter != null) {
            adContract$AdvertisementPresenter.generateSaveState(bundleOptionsState);
            bundle.putParcelable("presenter_state", bundleOptionsState);
        }
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.saveState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AdContract$AdvertisementPresenter adContract$AdvertisementPresenter;
        super.onRestoreInstanceState(bundle);
        Log.d("VungleActivity", "onRestoreInstanceState(" + bundle + ")");
        if (bundle != null && (adContract$AdvertisementPresenter = this.presenter) != null) {
            adContract$AdvertisementPresenter.restoreFromSave((OptionsState) bundle.getParcelable("presenter_state"));
        }
    }

    public void setRequestedOrientation(int i) {
        if (canRotate()) {
            super.setRequestedOrientation(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.broadcastReceiver);
        AdContract$AdvertisementPresenter adContract$AdvertisementPresenter = this.presenter;
        if (adContract$AdvertisementPresenter != null) {
            adContract$AdvertisementPresenter.detach(isChangingConfigurations() | true ? 1 : 0);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                AdContract$AdvertisementPresenter.EventListener eventListener = bus;
                if (eventListener != null) {
                    eventListener.onError(new VungleException(25), this.placementId);
                }
            }
        }
        super.onDestroy();
    }
}
