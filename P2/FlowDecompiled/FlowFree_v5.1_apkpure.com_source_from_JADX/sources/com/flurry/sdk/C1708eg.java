package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.flurry.android.FlurryPrivacySession;
import com.flurry.sdk.C1654dd;
import com.flurry.sdk.C1659df;
import com.flurry.sdk.C1704ed;
import com.flurry.sdk.C1720ex;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.eg */
public final class C1708eg extends C1730f {

    /* renamed from: a */
    private static C1708eg f4302a = new C1708eg();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FlurryPrivacySession.Request f4303b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1914o<C1501ak> f4304d = new C1914o<C1501ak>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            C1913n.m4811a().f4728g.unsubscribe(C1708eg.this.f4304d);
            C1708eg.this.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    Map b = C1708eg.m4464b(C1708eg.this.f4303b);
                    C1654dd ddVar = new C1654dd();
                    ddVar.f4187f = "https://api.login.yahoo.com/oauth2/device_session";
                    ddVar.f4188g = C1659df.C1662a.kPost;
                    ddVar.mo11438a("Content-Type", "application/json");
                    ddVar.f4173b = new JSONObject(b).toString();
                    ddVar.f4175d = new C1689dt();
                    ddVar.f4174c = new C1689dt();
                    ddVar.f4172a = new C1654dd.C1656a<String, String>() {
                        /* renamed from: a */
                        public final /* synthetic */ void mo11330a(C1654dd ddVar, Object obj) {
                            String str = (String) obj;
                            try {
                                int i = ddVar.f4194m;
                                if (i == 200) {
                                    JSONObject jSONObject = new JSONObject(str);
                                    C1708eg.m4462a(C1708eg.this, new FlurryPrivacySession.C1435a(jSONObject.getString("device_session_id"), jSONObject.getLong("expires_in"), C1708eg.this.f4303b));
                                    C1708eg.this.f4303b.callback.success();
                                    return;
                                }
                                C1648cy.m4332e("PrivacyManager", "Error in getting privacy dashboard url. Error code = ".concat(String.valueOf(i)));
                                C1708eg.this.f4303b.callback.failure();
                            } catch (JSONException e) {
                                C1648cy.m4326b("PrivacyManager", "Error in getting privacy dashboard url. ", (Throwable) e);
                                C1708eg.this.f4303b.callback.failure();
                            }
                        }
                    };
                    C1638ct.m4301a().mo11424a(C1708eg.this, ddVar);
                }
            });
        }
    };

    private C1708eg() {
        super("PrivacyManager", C1720ex.m4478a(C1720ex.C1722a.MISC));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m4465b(Context context, FlurryPrivacySession.C1435a aVar) {
        Intent intent = new Intent("android.intent.action.VIEW", aVar.f3570a);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m4460a(FlurryPrivacySession.Request request) {
        C1708eg egVar = f4302a;
        egVar.f4303b = request;
        egVar.runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                if (C1913n.m4811a().f4728g.mo11270c()) {
                    C1708eg.this.runAsync(new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() throws Exception {
                            Map b = C1708eg.m4464b(C1708eg.this.f4303b);
                            C1654dd ddVar = new C1654dd();
                            ddVar.f4187f = "https://api.login.yahoo.com/oauth2/device_session";
                            ddVar.f4188g = C1659df.C1662a.kPost;
                            ddVar.mo11438a("Content-Type", "application/json");
                            ddVar.f4173b = new JSONObject(b).toString();
                            ddVar.f4175d = new C1689dt();
                            ddVar.f4174c = new C1689dt();
                            ddVar.f4172a = new C1654dd.C1656a<String, String>() {
                                /* renamed from: a */
                                public final /* synthetic */ void mo11330a(C1654dd ddVar, Object obj) {
                                    String str = (String) obj;
                                    try {
                                        int i = ddVar.f4194m;
                                        if (i == 200) {
                                            JSONObject jSONObject = new JSONObject(str);
                                            C1708eg.m4462a(C1708eg.this, new FlurryPrivacySession.C1435a(jSONObject.getString("device_session_id"), jSONObject.getLong("expires_in"), C1708eg.this.f4303b));
                                            C1708eg.this.f4303b.callback.success();
                                            return;
                                        }
                                        C1648cy.m4332e("PrivacyManager", "Error in getting privacy dashboard url. Error code = ".concat(String.valueOf(i)));
                                        C1708eg.this.f4303b.callback.failure();
                                    } catch (JSONException e) {
                                        C1648cy.m4326b("PrivacyManager", "Error in getting privacy dashboard url. ", (Throwable) e);
                                        C1708eg.this.f4303b.callback.failure();
                                    }
                                }
                            };
                            C1638ct.m4301a().mo11424a(C1708eg.this, ddVar);
                        }
                    });
                    return;
                }
                C1648cy.m4317a(3, "PrivacyManager", "Waiting for ID provider.");
                C1913n.m4811a().f4728g.subscribe(C1708eg.this.f4304d);
            }
        });
    }

    /* renamed from: b */
    static /* synthetic */ Map m4464b(FlurryPrivacySession.Request request) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_verifier", request.verifier);
        HashMap hashMap2 = new HashMap();
        C1501ak a = C1913n.m4811a().f4728g.mo11264a();
        String str = a.mo11283a().get(C1502al.AndroidAdvertisingId);
        if (str != null) {
            hashMap2.put("gpaid", str);
        }
        String str2 = a.mo11283a().get(C1502al.DeviceId);
        if (str2 != null) {
            hashMap2.put("andid", str2);
        }
        hashMap.putAll(hashMap2);
        HashMap hashMap3 = new HashMap();
        byte[] bytes = C1913n.m4811a().f4728g.mo11264a().mo11283a().get(C1502al.AndroidInstallationId).getBytes();
        if (bytes != null) {
            hashMap3.put("flurry_guid", C1698dz.m4441a(bytes));
        }
        hashMap3.put("flurry_project_api_key", C1913n.m4811a().f4729h.f3706a);
        hashMap.putAll(hashMap3);
        Context context = request.context;
        HashMap hashMap4 = new HashMap();
        hashMap4.put("src", "flurryandroidsdk");
        hashMap4.put("srcv", "12.11.0");
        hashMap4.put("appsrc", context.getPackageName());
        C1564bl.m4094a();
        hashMap4.put("appsrcv", C1564bl.m4095a(context));
        hashMap.putAll(hashMap4);
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ void m4462a(C1708eg egVar, final FlurryPrivacySession.C1435a aVar) {
        Context a = C1536b.m4057a();
        if (C1704ed.m4455a(a)) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setShowTitle(true);
            C1704ed.m4454a(a, builder.build(), Uri.parse(aVar.f3570a.toString()), new C1704ed.C1705a() {
                /* renamed from: a */
                public final void mo11489a(Context context) {
                    C1708eg.m4465b(context, aVar);
                }
            });
            return;
        }
        m4465b(a, aVar);
    }
}
