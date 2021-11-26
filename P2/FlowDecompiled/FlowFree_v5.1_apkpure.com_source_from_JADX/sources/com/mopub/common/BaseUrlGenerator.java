package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import com.mopub.network.C2676Networking;
import com.mopub.network.PlayServicesUrlRewriter;

public abstract class BaseUrlGenerator {
    private static AppEngineInfo mAppEngineInfo;
    private static String sWrapperVersion;
    private boolean mFirstParam;
    private StringBuilder mStringBuilder;

    public abstract String generateUrlString(String str);

    /* access modifiers changed from: protected */
    public void initUrlString(String str, String str2) {
        StringBuilder sb = new StringBuilder(C2676Networking.getScheme());
        sb.append("://");
        sb.append(str);
        sb.append(str2);
        this.mStringBuilder = sb;
        this.mFirstParam = true;
    }

    /* access modifiers changed from: protected */
    public String getFinalUrlString() {
        return this.mStringBuilder.toString();
    }

    /* access modifiers changed from: protected */
    public void addParam(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mStringBuilder.append(getParamDelimiter());
            this.mStringBuilder.append(str);
            this.mStringBuilder.append("=");
            this.mStringBuilder.append(Uri.encode(str2));
        }
    }

    /* access modifiers changed from: protected */
    public void addParam(String str, Boolean bool) {
        if (bool != null) {
            this.mStringBuilder.append(getParamDelimiter());
            this.mStringBuilder.append(str);
            this.mStringBuilder.append("=");
            this.mStringBuilder.append(bool.booleanValue() ? "1" : "0");
        }
    }

    private String getParamDelimiter() {
        if (!this.mFirstParam) {
            return "&";
        }
        this.mFirstParam = false;
        return "?";
    }

    /* access modifiers changed from: protected */
    public void setApiVersion(String str) {
        addParam("v", str);
    }

    /* access modifiers changed from: protected */
    public void setAppVersion(String str) {
        addParam("av", str);
    }

    /* access modifiers changed from: protected */
    public void setDeviceInfo(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length >= 1) {
            for (int i = 0; i < strArr.length - 1; i++) {
                sb.append(strArr[i]);
                sb.append(",");
            }
            sb.append(strArr[strArr.length - 1]);
            addParam("dn", sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void appendAdvertisingInfoTemplates() {
        addParam("ifa", PlayServicesUrlRewriter.IFA_TEMPLATE);
        addParam("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
        addParam("tas", PlayServicesUrlRewriter.TAS_TEMPLATE);
        addParam("mid", PlayServicesUrlRewriter.MOPUB_ID_TEMPLATE);
    }

    public static void setAppEngineInfo(AppEngineInfo appEngineInfo) {
        mAppEngineInfo = appEngineInfo;
    }

    public static void setWrapperVersion(String str) {
        Preconditions.checkNotNull(str);
        sWrapperVersion = str;
    }

    /* access modifiers changed from: protected */
    public void appendAppEngineInfo() {
        AppEngineInfo appEngineInfo = mAppEngineInfo;
        if (appEngineInfo != null) {
            addParam("e_name", appEngineInfo.mName);
            addParam("e_ver", appEngineInfo.mVersion);
        }
    }

    /* access modifiers changed from: protected */
    public void appendWrapperVersion() {
        addParam("w_ver", sWrapperVersion);
    }

    /* access modifiers changed from: protected */
    public void setDeviceDimensions(Point point, Point point2, WindowInsets windowInsets) {
        int i = 0;
        int i2 = point2 != null ? point2.x : 0;
        if (point2 != null) {
            i = point2.y;
        }
        if (Build.VERSION.SDK_INT < 28 || windowInsets == null || windowInsets.getDisplayCutout() == null) {
            addParam("cw", "" + i2);
            addParam("ch", "" + i);
        } else {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            int safeInsetLeft = (point.x - displayCutout.getSafeInsetLeft()) - displayCutout.getSafeInsetRight();
            int safeInsetTop = (point.y - displayCutout.getSafeInsetTop()) - displayCutout.getSafeInsetBottom();
            addParam("cw", "" + Math.min(safeInsetLeft, i2));
            addParam("ch", "" + Math.min(safeInsetTop, i));
        }
        addParam("w", "" + point.x);
        addParam("h", "" + point.y);
    }
}
