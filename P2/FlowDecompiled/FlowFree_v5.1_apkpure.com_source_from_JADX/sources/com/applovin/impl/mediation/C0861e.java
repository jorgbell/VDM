package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.C1155o;

/* renamed from: com.applovin.impl.mediation.e */
public class C0861e {
    public static final C0861e EMPTY = new C0861e(0);
    private final int errorCode;
    private final String errorMessage;

    public C0861e(int i) {
        this(i, "");
    }

    public C0861e(int i, String str) {
        this.errorCode = i;
        this.errorMessage = C1155o.m2675c(str);
    }

    public C0861e(String str) {
        this(-1, str);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        return "MaxError{errorCode=" + getErrorCode() + ", errorMessage='" + getErrorMessage() + '\'' + '}';
    }
}
