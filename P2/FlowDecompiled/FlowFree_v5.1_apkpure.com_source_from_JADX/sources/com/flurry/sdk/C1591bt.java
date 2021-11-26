package com.flurry.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.bt */
public final class C1591bt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Object f4003a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static List<C1595b> f4004b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static IInAppBillingService f4005c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ServiceConnection f4006d;

    /* renamed from: com.flurry.sdk.bt$a */
    public static abstract class C1594a {
        /* renamed from: a */
        public abstract void mo11345a(int i, C1597c cVar);
    }

    /* renamed from: a */
    public static void m4152a(final Context context, final String str, final C1594a aVar) {
        try {
            Class.forName("com.android.vending.billing.IInAppBillingService");
            C1648cy.m4317a(3, "GooglePlayIap", "Google play billing library is available");
            C15921 r0 = new C1595b() {
                /* renamed from: a */
                public final void mo11342a(int i, IInAppBillingService iInAppBillingService) {
                    if (i == 0) {
                        C1597c a = C1591bt.m4153b(iInAppBillingService, context, "inapp", str);
                        if (a == null) {
                            a = C1591bt.m4153b(iInAppBillingService, context, "subs", str);
                        }
                        aVar.mo11345a(i, a);
                        return;
                    }
                    aVar.mo11345a(i, (C1597c) null);
                }
            };
            Boolean bool = Boolean.FALSE;
            synchronized (f4003a) {
                if (f4006d == null) {
                    f4006d = new ServiceConnection() {
                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            synchronized (C1591bt.f4003a) {
                                IInAppBillingService unused = C1591bt.f4005c = IInAppBillingService.Stub.asInterface(iBinder);
                                for (C1595b b : C1591bt.f4004b) {
                                    b.mo11346b(0, C1591bt.f4005c);
                                }
                                C1591bt.f4004b.clear();
                            }
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                            synchronized (C1591bt.f4003a) {
                                ServiceConnection unused = C1591bt.f4006d = null;
                                IInAppBillingService unused2 = C1591bt.f4005c = null;
                                for (C1595b b : C1591bt.f4004b) {
                                    b.mo11346b(1, (IInAppBillingService) null);
                                }
                                C1591bt.f4004b.clear();
                            }
                        }
                    };
                    bool = Boolean.TRUE;
                }
                IInAppBillingService iInAppBillingService = f4005c;
                if (iInAppBillingService == null) {
                    f4004b.add(r0);
                } else {
                    r0.mo11346b(0, iInAppBillingService);
                }
                if (bool.booleanValue()) {
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        r0.mo11346b(1, (IInAppBillingService) null);
                        f4006d = null;
                    } else {
                        context.bindService(intent, f4006d, 1);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            C1648cy.m4325b("GooglePlayIap", "Could not find google play billing library");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C1597c m4153b(IInAppBillingService iInAppBillingService, Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        try {
            Bundle skuDetails = iInAppBillingService.getSkuDetails(3, context.getPackageName(), str, bundle);
            if (skuDetails.containsKey("DETAILS_LIST")) {
                ArrayList<String> stringArrayList = skuDetails.getStringArrayList("DETAILS_LIST");
                if (stringArrayList.size() > 0) {
                    return new C1597c(str, stringArrayList.get(0));
                }
            }
            return null;
        } catch (RemoteException e) {
            C1648cy.m4320a("GooglePlayIap", "RemoteException getting SKU Details", (Throwable) e);
            return null;
        } catch (JSONException e2) {
            C1648cy.m4320a("GooglePlayIap", "JSONException parsing SKU Details", (Throwable) e2);
            return null;
        }
    }

    /* renamed from: com.flurry.sdk.bt$b */
    static abstract class C1595b {
        /* renamed from: a */
        public abstract void mo11342a(int i, IInAppBillingService iInAppBillingService);

        private C1595b() {
        }

        /* synthetic */ C1595b(byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo11346b(final int i, final IInAppBillingService iInAppBillingService) {
            new Thread(new Runnable() {
                public final void run() {
                    C1595b.this.mo11342a(i, iInAppBillingService);
                }
            }).start();
        }
    }

    /* renamed from: com.flurry.sdk.bt$c */
    public static class C1597c {

        /* renamed from: a */
        public final String f4013a;

        /* renamed from: b */
        public final long f4014b;

        /* renamed from: c */
        public final String f4015c;

        /* renamed from: d */
        public final String f4016d;

        /* renamed from: e */
        private final String f4017e;

        /* renamed from: f */
        private final String f4018f;

        /* renamed from: g */
        private final String f4019g;

        /* renamed from: h */
        private final String f4020h;

        /* renamed from: i */
        private final String f4021i;

        public C1597c(String str, String str2) throws JSONException {
            this.f4017e = str;
            this.f4021i = str2;
            JSONObject jSONObject = new JSONObject(str2);
            this.f4018f = jSONObject.optString("productId");
            this.f4013a = jSONObject.optString("type");
            this.f4019g = jSONObject.optString("price");
            this.f4014b = jSONObject.optLong("price_amount_micros");
            this.f4015c = jSONObject.optString("price_currency_code");
            this.f4016d = jSONObject.optString("title");
            this.f4020h = jSONObject.optString("description");
        }

        public final String toString() {
            return "SkuDetails:" + this.f4021i;
        }
    }
}
