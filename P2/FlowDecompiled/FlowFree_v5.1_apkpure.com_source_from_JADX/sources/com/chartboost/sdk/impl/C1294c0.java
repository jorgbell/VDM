package com.chartboost.sdk.impl;

/* renamed from: com.chartboost.sdk.impl.c0 */
public class C1294c0 {

    /* renamed from: a */
    private String f3051a;

    /* renamed from: b */
    private String f3052b;

    /* renamed from: c */
    private Double f3053c;

    /* renamed from: d */
    private String f3054d;

    /* renamed from: e */
    private String f3055e;

    /* renamed from: f */
    private String f3056f;

    /* renamed from: g */
    private C1297d0 f3057g;

    public C1294c0() {
        this.f3051a = "";
        this.f3052b = "";
        this.f3053c = Double.valueOf(0.0d);
        this.f3054d = "";
        this.f3055e = "";
        this.f3056f = "";
        this.f3057g = new C1297d0();
    }

    /* renamed from: a */
    public String mo10379a() {
        return this.f3056f;
    }

    /* renamed from: b */
    public String mo10380b() {
        return this.f3055e;
    }

    /* renamed from: c */
    public C1297d0 mo10381c() {
        return this.f3057g;
    }

    public String toString() {
        return "id: " + this.f3051a + "\nimpid: " + this.f3052b + "\nprice: " + this.f3053c + "\nburl: " + this.f3054d + "\ncrid: " + this.f3055e + "\nadm: " + this.f3056f + "\next: " + this.f3057g.toString() + "\n";
    }

    public C1294c0(String str, String str2, Double d, String str3, String str4, String str5, C1297d0 d0Var) {
        this.f3051a = str;
        this.f3052b = str2;
        this.f3053c = d;
        this.f3054d = str3;
        this.f3055e = str4;
        this.f3056f = str5;
        this.f3057g = d0Var;
    }
}
