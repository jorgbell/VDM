package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C1229b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.chartboost.sdk.impl.e0 */
public class C1300e0 {

    /* renamed from: a */
    private String f3073a;

    /* renamed from: b */
    private String f3074b;

    /* renamed from: c */
    private String f3075c;

    /* renamed from: d */
    private String f3076d;

    /* renamed from: e */
    private ArrayList<C1303f0> f3077e;

    /* renamed from: f */
    private ArrayList<C1229b> f3078f;

    public C1300e0() {
        this.f3073a = "";
        this.f3074b = "";
        this.f3075c = "USD";
        this.f3076d = "";
        this.f3077e = new ArrayList<>();
        this.f3078f = new ArrayList<>();
    }

    /* renamed from: e */
    private String m3419e() {
        Iterator<C1303f0> it = this.f3077e.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            str = "Seatbid " + i + " : " + it.next().toString() + "\n";
            i++;
        }
        return str;
    }

    /* renamed from: a */
    public ArrayList<C1229b> mo10399a() {
        return this.f3078f;
    }

    /* renamed from: b */
    public HashMap<String, C1229b> mo10400b() {
        HashMap<String, C1229b> hashMap = new HashMap<>();
        Iterator<C1229b> it = this.f3078f.iterator();
        while (it.hasNext()) {
            C1229b next = it.next();
            hashMap.put(next.f2729b, next);
        }
        return hashMap;
    }

    /* renamed from: c */
    public String mo10401c() {
        return this.f3073a;
    }

    /* renamed from: d */
    public ArrayList<C1303f0> mo10402d() {
        return this.f3077e;
    }

    public String toString() {
        return "id: " + this.f3073a + "\nnbr: " + this.f3074b + "\ncurrency: " + this.f3075c + "\nbidId: " + this.f3076d + "\nseatbid: " + m3419e() + "\n";
    }

    public C1300e0(String str, String str2, String str3, String str4, ArrayList<C1303f0> arrayList, ArrayList<C1229b> arrayList2) {
        this.f3073a = str;
        this.f3074b = str2;
        this.f3075c = str3;
        this.f3076d = str4;
        this.f3077e = arrayList;
        this.f3078f = arrayList2;
    }
}
