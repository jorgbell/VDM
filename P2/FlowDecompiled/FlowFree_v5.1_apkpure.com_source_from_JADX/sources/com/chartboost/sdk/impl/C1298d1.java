package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Privacy.model.DataUseConsent;

/* renamed from: com.chartboost.sdk.impl.d1 */
public class C1298d1 {

    /* renamed from: a */
    private C1407x0 f3065a;

    /* renamed from: b */
    private SharedPreferences f3066b;

    public C1298d1(C1407x0 x0Var, SharedPreferences sharedPreferences) {
        this.f3065a = x0Var;
        this.f3066b = sharedPreferences;
    }

    /* renamed from: d */
    private int m3403d() {
        DataUseConsent a = this.f3065a.mo10698a();
        if (a != null) {
            return m3402a(a);
        }
        return m3404e();
    }

    /* renamed from: e */
    private int m3404e() {
        Chartboost.CBPIDataUseConsent cBPIDataUseConsent;
        if (m3409j()) {
            cBPIDataUseConsent = m3408i();
        } else {
            cBPIDataUseConsent = m3407h();
        }
        return cBPIDataUseConsent.getValue();
    }

    /* renamed from: f */
    private boolean m3405f() {
        SharedPreferences sharedPreferences = this.f3066b;
        if (sharedPreferences != null) {
            return !sharedPreferences.contains("cbGDPR");
        }
        return true;
    }

    /* renamed from: g */
    private boolean m3406g() {
        SharedPreferences sharedPreferences = this.f3066b;
        if (sharedPreferences != null) {
            return sharedPreferences.contains("cbLimitTrack");
        }
        return false;
    }

    @Deprecated
    /* renamed from: h */
    private Chartboost.CBPIDataUseConsent m3407h() {
        Chartboost.CBPIDataUseConsent cBPIDataUseConsent = C1380v0.f3390a;
        SharedPreferences sharedPreferences = this.f3066b;
        return sharedPreferences != null ? Chartboost.CBPIDataUseConsent.valueOf(sharedPreferences.getInt("cbGDPR", cBPIDataUseConsent.getValue())) : cBPIDataUseConsent;
    }

    @Deprecated
    /* renamed from: i */
    private Chartboost.CBPIDataUseConsent m3408i() {
        Chartboost.CBPIDataUseConsent cBPIDataUseConsent = Chartboost.CBPIDataUseConsent.UNKNOWN;
        SharedPreferences sharedPreferences = this.f3066b;
        return (sharedPreferences == null || !sharedPreferences.getBoolean("cbLimitTrack", false)) ? cBPIDataUseConsent : Chartboost.CBPIDataUseConsent.NO_BEHAVIORAL;
    }

    /* renamed from: j */
    private boolean m3409j() {
        return m3406g() && m3405f();
    }

    /* renamed from: a */
    public void mo10390a() {
        C1380v0.m3738a(m3403d());
    }

    /* renamed from: b */
    public int mo10391b() {
        return C1380v0.m3737a();
    }

    /* renamed from: c */
    public int mo10392c() {
        return C1380v0.m3741b();
    }

    /* renamed from: a */
    private int m3402a(DataUseConsent dataUseConsent) {
        try {
            return Integer.parseInt(dataUseConsent.getConsent());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
