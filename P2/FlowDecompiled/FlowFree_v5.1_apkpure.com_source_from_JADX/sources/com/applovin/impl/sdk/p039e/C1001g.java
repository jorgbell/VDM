package com.applovin.impl.sdk.p039e;

import android.text.TextUtils;
import com.applovin.impl.adview.C0638d;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1097g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.g */
public class C1001g extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1097g f2001a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinPostbackListener f2002c;

    /* renamed from: d */
    private final C1020o.C1022a f2003d;

    public C1001g(C1097g gVar, C1020o.C1022a aVar, C1062k kVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", kVar);
        if (gVar != null) {
            this.f2001a = gVar;
            this.f2002c = appLovinPostbackListener;
            this.f2003d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1935a() {
        C10032 r0 = new C1033t<Object>(this.f2001a, mo9215d()) {

            /* renamed from: a */
            final String f2005a;

            {
                this.f2005a = C1001g.this.f2001a.mo9457a();
            }

            /* renamed from: a */
            public void mo8530a(int i) {
                mo9216d("Failed to dispatch postback. Error code: " + i + " URL: " + this.f2005a);
                if (C1001g.this.f2002c != null) {
                    C1001g.this.f2002c.onPostbackFailure(this.f2005a, i);
                }
                if (C1001g.this.f2001a.mo9532q()) {
                    this.f1980b.mo9372ag().mo9306a(C1001g.this.f2001a.mo9533r(), this.f2005a, i, (Object) null);
                }
            }

            /* renamed from: a */
            public void mo8531a(Object obj, int i) {
                if (obj instanceof String) {
                    for (String next : this.f1980b.mo9381b(C0965b.f1585aJ)) {
                        if (next.startsWith(next)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    C1120h.m2549d(jSONObject, this.f1980b);
                                    C1120h.m2548c(jSONObject, this.f1980b);
                                    C1120h.m2551e(jSONObject, this.f1980b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (C1001g.this.f2002c != null) {
                    C1001g.this.f2002c.onPostbackSuccess(this.f2005a);
                }
                if (C1001g.this.f2001a.mo9532q()) {
                    this.f1980b.mo9372ag().mo9306a(C1001g.this.f2001a.mo9533r(), this.f2005a, i, obj);
                }
            }
        };
        r0.mo9286a(this.f2003d);
        mo9215d().mo9340Q().mo9265a((C0989a) r0);
    }

    public void run() {
        if (!C1155o.m2673b(this.f2001a.mo9457a())) {
            mo9213b("Requested URL is not valid; nothing to do...");
            AppLovinPostbackListener appLovinPostbackListener = this.f2002c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(this.f2001a.mo9457a(), AppLovinErrorCodes.INVALID_URL);
            }
        } else if (this.f2001a.mo9534s()) {
            C0638d.m597a(this.f2001a, mo9215d(), new AppLovinPostbackListener() {
                public void onPostbackFailure(String str, int i) {
                    C1001g.this.m1935a();
                }

                public void onPostbackSuccess(String str) {
                    if (C1001g.this.f2002c != null) {
                        C1001g.this.f2002c.onPostbackSuccess(C1001g.this.f2001a.mo9457a());
                    }
                }
            });
        } else {
            m1935a();
        }
    }
}
