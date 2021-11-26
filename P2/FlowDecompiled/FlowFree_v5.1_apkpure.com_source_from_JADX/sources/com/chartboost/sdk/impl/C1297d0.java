package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.d0 */
public class C1297d0 {

    /* renamed from: a */
    private String f3060a;

    /* renamed from: b */
    private String f3061b;

    /* renamed from: c */
    private String f3062c;

    /* renamed from: d */
    private String f3063d;

    /* renamed from: e */
    private List<String> f3064e;

    public C1297d0() {
        this.f3060a = "";
        this.f3061b = "";
        this.f3062c = "";
        this.f3063d = "";
        this.f3064e = new ArrayList();
    }

    /* renamed from: a */
    public String mo10384a() {
        return this.f3061b;
    }

    /* renamed from: b */
    public String mo10385b() {
        return this.f3062c;
    }

    /* renamed from: c */
    public String mo10386c() {
        return this.f3060a;
    }

    /* renamed from: d */
    public List<String> mo10387d() {
        return this.f3064e;
    }

    /* renamed from: e */
    public String mo10388e() {
        return this.f3063d;
    }

    public String toString() {
        return "crtype: " + this.f3060a + "\ncgn: " + this.f3062c + "\ntemplate: " + this.f3063d + "\nimptrackers: " + this.f3064e.size() + "\nadId: " + this.f3061b;
    }

    public C1297d0(String str, String str2, String str3, String str4, List<String> list) {
        this.f3060a = str;
        this.f3061b = str2;
        this.f3062c = str3;
        this.f3063d = str4;
        this.f3064e = list;
    }
}
