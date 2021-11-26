package com.iab.omid.library.vungle.walking.p052a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.a.b */
public abstract class C2455b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C2456a f5536a;

    /* renamed from: d */
    protected final C2457b f5537d;

    /* renamed from: com.iab.omid.library.vungle.walking.a.b$a */
    public interface C2456a {
        /* renamed from: a */
        void mo24247a(C2455b bVar);
    }

    /* renamed from: com.iab.omid.library.vungle.walking.a.b$b */
    public interface C2457b {
        /* renamed from: a */
        void mo24248a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo24249b();
    }

    public C2455b(C2457b bVar) {
        this.f5537d = bVar;
    }

    /* renamed from: a */
    public void mo24243a(C2456a aVar) {
        this.f5536a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C2456a aVar = this.f5536a;
        if (aVar != null) {
            aVar.mo24247a(this);
        }
    }

    /* renamed from: a */
    public void mo24245a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
