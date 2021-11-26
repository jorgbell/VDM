package com.amazon.device.iap.internal.p017c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.p008b.C0496d;
import com.amazon.device.iap.internal.util.C0527a;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.Receipt;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.c.a */
/* compiled from: PendingReceiptsManager */
public class C0518a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f83a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f84b;

    /* renamed from: c */
    private static final String f85c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f86d = 604800000;

    /* renamed from: e */
    private static final C0518a f87e = new C0518a();

    static {
        Class<C0518a> cls = C0518a.class;
        f84b = cls.getName() + "_PREFS";
        f85c = cls.getName() + "_CLEANER_PREFS";
    }

    /* renamed from: a */
    public void mo7481a(String str, String str2, String str3, String str4) {
        String str5 = f83a;
        C0532e.m187a(str5, "enter saveReceipt for receipt [" + str4 + "]");
        try {
            C0531d.m184a(str2, "userId");
            C0531d.m184a(str3, "receiptId");
            C0531d.m184a(str4, "receiptString");
            Context b = C0524d.m156d().mo7500b();
            C0531d.m183a((Object) b, "context");
            C0522d dVar = new C0522d(str2, str4, str, System.currentTimeMillis());
            SharedPreferences.Editor edit = b.getSharedPreferences(f84b, 0).edit();
            edit.putString(str3, dVar.mo7492d());
            edit.commit();
        } catch (Throwable th) {
            String str6 = f83a;
            C0532e.m187a(str6, "error in saving pending receipt:" + str + "/" + str4 + ":" + th.getMessage());
        }
        String str7 = f83a;
        C0532e.m187a(str7, "leaving saveReceipt for receipt id [" + str3 + "]");
    }

    /* renamed from: e */
    private void m139e() {
        C0532e.m187a(f83a, "enter old receipts cleanup! ");
        final Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        m135a(System.currentTimeMillis());
        new Handler().post(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|19) */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r4 = com.amazon.device.iap.internal.p017c.C0518a.m136b();
                com.amazon.device.iap.internal.util.C0532e.m187a(r4, "house keeping - try remove Receipt:" + r3 + " since it's invalid ");
                r9.f89b.mo7480a(r3);
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    java.lang.String r0 = "house keeping - try remove Receipt:"
                    java.lang.String r1 = com.amazon.device.iap.internal.p017c.C0518a.f83a     // Catch:{ all -> 0x008b }
                    java.lang.String r2 = "perform house keeping! "
                    com.amazon.device.iap.internal.util.C0532e.m187a(r1, r2)     // Catch:{ all -> 0x008b }
                    android.content.Context r1 = r0     // Catch:{ all -> 0x008b }
                    java.lang.String r2 = com.amazon.device.iap.internal.p017c.C0518a.f84b     // Catch:{ all -> 0x008b }
                    r3 = 0
                    android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x008b }
                    java.util.Map r2 = r1.getAll()     // Catch:{ all -> 0x008b }
                    java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x008b }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x008b }
                L_0x0022:
                    boolean r3 = r2.hasNext()     // Catch:{ all -> 0x008b }
                    if (r3 == 0) goto L_0x00a4
                    java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x008b }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x008b }
                    r4 = 0
                    java.lang.String r4 = r1.getString(r3, r4)     // Catch:{ e -> 0x006a }
                    com.amazon.device.iap.internal.c.d r4 = com.amazon.device.iap.internal.p017c.C0522d.m151a(r4)     // Catch:{ e -> 0x006a }
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ e -> 0x006a }
                    long r7 = r4.mo7491c()     // Catch:{ e -> 0x006a }
                    long r5 = r5 - r7
                    int r4 = com.amazon.device.iap.internal.p017c.C0518a.f86d     // Catch:{ e -> 0x006a }
                    long r7 = (long) r4     // Catch:{ e -> 0x006a }
                    int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0022
                    java.lang.String r4 = com.amazon.device.iap.internal.p017c.C0518a.f83a     // Catch:{ e -> 0x006a }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ e -> 0x006a }
                    r5.<init>()     // Catch:{ e -> 0x006a }
                    r5.append(r0)     // Catch:{ e -> 0x006a }
                    r5.append(r3)     // Catch:{ e -> 0x006a }
                    java.lang.String r6 = " since it's too old"
                    r5.append(r6)     // Catch:{ e -> 0x006a }
                    java.lang.String r5 = r5.toString()     // Catch:{ e -> 0x006a }
                    com.amazon.device.iap.internal.util.C0532e.m187a(r4, r5)     // Catch:{ e -> 0x006a }
                    com.amazon.device.iap.internal.c.a r4 = com.amazon.device.iap.internal.p017c.C0518a.this     // Catch:{ e -> 0x006a }
                    r4.mo7480a((java.lang.String) r3)     // Catch:{ e -> 0x006a }
                    goto L_0x0022
                L_0x006a:
                    java.lang.String r4 = com.amazon.device.iap.internal.p017c.C0518a.f83a     // Catch:{ all -> 0x008b }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
                    r5.<init>()     // Catch:{ all -> 0x008b }
                    r5.append(r0)     // Catch:{ all -> 0x008b }
                    r5.append(r3)     // Catch:{ all -> 0x008b }
                    java.lang.String r6 = " since it's invalid "
                    r5.append(r6)     // Catch:{ all -> 0x008b }
                    java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008b }
                    com.amazon.device.iap.internal.util.C0532e.m187a(r4, r5)     // Catch:{ all -> 0x008b }
                    com.amazon.device.iap.internal.c.a r4 = com.amazon.device.iap.internal.p017c.C0518a.this     // Catch:{ all -> 0x008b }
                    r4.mo7480a((java.lang.String) r3)     // Catch:{ all -> 0x008b }
                    goto L_0x0022
                L_0x008b:
                    r0 = move-exception
                    java.lang.String r1 = com.amazon.device.iap.internal.p017c.C0518a.f83a
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Error in running cleaning job:"
                    r2.append(r3)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    com.amazon.device.iap.internal.util.C0532e.m187a(r1, r0)
                L_0x00a4:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.p017c.C0518a.C05191.run():void");
            }
        });
    }

    /* renamed from: a */
    public void mo7480a(String str) {
        String str2 = f83a;
        C0532e.m187a(str2, "enter removeReceipt for receipt[" + str + "]");
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(f84b, 0).edit();
        edit.remove(str);
        edit.commit();
        C0532e.m187a(str2, "leave removeReceipt for receipt[" + str + "]");
    }

    /* renamed from: f */
    private long m140f() {
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.getSharedPreferences(f85c, 0).getLong("LAST_CLEANING_TIME", 0);
        if (j != 0) {
            return j;
        }
        m135a(currentTimeMillis);
        return currentTimeMillis;
    }

    /* renamed from: a */
    private void m135a(long j) {
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(f85c, 0).edit();
        edit.putLong("LAST_CLEANING_TIME", j);
        edit.commit();
    }

    /* renamed from: b */
    public Set<Receipt> mo7482b(String str) {
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        String str2 = f83a;
        C0532e.m187a(str2, "enter getLocalReceipts for user[" + str + "]");
        HashSet hashSet = new HashSet();
        if (!C0531d.m186a(str)) {
            Map<String, ?> all = b.getSharedPreferences(f84b, 0).getAll();
            for (String next : all.keySet()) {
                String str3 = (String) all.get(next);
                try {
                    C0522d a = C0522d.m151a(str3);
                    hashSet.add(C0527a.m173a(new JSONObject(a.mo7490b()), str, a.mo7489a()));
                } catch (C0496d unused) {
                    mo7480a(next);
                    String str4 = f83a;
                    C0532e.m189b(str4, "failed to verify signature:[" + str3 + "]");
                } catch (JSONException unused2) {
                    mo7480a(next);
                    String str5 = f83a;
                    C0532e.m189b(str5, "failed to convert string to JSON object:[" + str3 + "]");
                } catch (Throwable unused3) {
                    String str6 = f83a;
                    C0532e.m189b(str6, "failed to load the receipt from SharedPreference:[" + str3 + "]");
                }
            }
            String str7 = f83a;
            C0532e.m187a(str7, "leaving getLocalReceipts for user[" + str + "], " + hashSet.size() + " local receipts found.");
            if (System.currentTimeMillis() - m140f() > ((long) f86d)) {
                m139e();
            }
            return hashSet;
        }
        C0532e.m189b(str2, "empty UserId: " + str);
        throw new RuntimeException("Invalid UserId:" + str);
    }

    /* renamed from: a */
    public static C0518a m134a() {
        return f87e;
    }

    /* renamed from: c */
    public String mo7483c(String str) {
        Context b = C0524d.m156d().mo7500b();
        C0531d.m183a((Object) b, "context");
        if (!C0531d.m186a(str)) {
            String string = b.getSharedPreferences(f84b, 0).getString(str, (String) null);
            if (string != null) {
                try {
                    return C0522d.m151a(string).mo7489a();
                } catch (C0523e unused) {
                }
            }
            return null;
        }
        String str2 = f83a;
        C0532e.m189b(str2, "empty receiptId: " + str);
        throw new RuntimeException("Invalid ReceiptId:" + str);
    }
}
