package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.chartboost.sdk.impl.f0 */
public class C1303f0 {

    /* renamed from: a */
    private String f3086a;

    /* renamed from: b */
    private ArrayList<C1294c0> f3087b;

    public C1303f0() {
        this.f3086a = "";
        this.f3087b = new ArrayList<>();
    }

    /* renamed from: a */
    private String m3436a() {
        Iterator<C1294c0> it = this.f3087b.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            str = "Bid " + i + " : " + it.next().toString() + "\n";
            i++;
        }
        return str;
    }

    /* renamed from: b */
    public ArrayList<C1294c0> mo10409b() {
        return this.f3087b;
    }

    public String toString() {
        return "seat: " + this.f3086a + "\nbid: " + m3436a() + "\n";
    }

    public C1303f0(String str, ArrayList<C1294c0> arrayList) {
        this.f3086a = str;
        this.f3087b = arrayList;
    }
}
