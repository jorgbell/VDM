package com.chartboost.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;

@SuppressLint({"Registered"})
public class CBImpressionActivity extends Activity {

    /* renamed from: a */
    final Handler f2642a;

    /* renamed from: b */
    final C1275d f2643b;

    public CBImpressionActivity() {
        C1275d dVar = null;
        this.f2642a = C1414j.m3867b() != null ? C1414j.m3867b().f3493B : null;
        this.f2643b = C1414j.m3867b() != null ? C1414j.m3867b().f3494C : dVar;
    }

    public void onAttachedToWindow() {
        View decorView;
        try {
            super.onAttachedToWindow();
            Window window = getWindow();
            if (window != null && (decorView = window.getDecorView()) != null && !decorView.isHardwareAccelerated() && this.f2643b != null) {
                CBLogging.m2905b("CBImpressionActivity", "The activity passed down is not hardware accelerated, so Chartboost cannot show ads");
                C1230c f = this.f2643b.mo10309f();
                if (f != null) {
                    f.mo10085a(CBError.CBImpressionError.HARDWARE_ACCELERATION_DISABLED);
                }
                finish();
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onAttachedToWindow: " + e.toString());
        }
    }

    public void onBackPressed() {
        try {
            C1275d dVar = this.f2643b;
            if (dVar == null || !dVar.mo10312i()) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onBackPressed: " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ((getIntent() != null && !getIntent().getBooleanExtra("isChartboost", false)) || this.f2642a == null || this.f2643b == null) {
            CBLogging.m2905b("CBImpressionActivity", "This activity cannot be called from outside chartboost SDK");
            finish();
            return;
        }
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(0);
        }
        this.f2643b.mo10297a(this);
        setContentView(new RelativeLayout(this));
        CBLogging.m2903a("CBImpressionActivity", "Impression Activity onCreate() called");
        try {
            this.f2643b.mo10313j();
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onCreate: " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            C1275d dVar = this.f2643b;
            if (dVar != null) {
                dVar.mo10302c((Activity) this);
            }
            super.onDestroy();
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onDestroy: " + e.toString());
        } catch (Throwable th) {
            super.onDestroy();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            C1275d dVar = this.f2643b;
            if (dVar != null) {
                dVar.mo10300b((Activity) this);
                this.f2643b.mo10314k();
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onPause: " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            C1275d dVar = this.f2643b;
            if (dVar != null) {
                dVar.mo10300b((Activity) this);
                this.f2643b.mo10315l();
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onResume: " + e.toString());
        }
        Chartboost.setActivityAttrs(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            C1275d dVar = this.f2643b;
            if (dVar != null) {
                dVar.mo10305d((Activity) this);
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onStart: " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            C1275d dVar = this.f2643b;
            if (dVar != null) {
                dVar.mo10307e((Activity) this);
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpressionActivity", "onStop: " + e.toString());
        }
    }
}
