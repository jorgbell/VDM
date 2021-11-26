package com.iab.omid.library.mopub.walking.p046a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.walking.a.b */
public abstract class C2406b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C2407a f5443a;

    /* renamed from: d */
    protected final C2408b f5444d;

    /* renamed from: com.iab.omid.library.mopub.walking.a.b$a */
    public interface C2407a {
        /* renamed from: a */
        void mo24116a(C2406b bVar);
    }

    /* renamed from: com.iab.omid.library.mopub.walking.a.b$b */
    public interface C2408b {
        /* renamed from: a */
        void mo24117a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo24118b();
    }

    public C2406b(C2408b bVar) {
        this.f5444d = bVar;
    }

    /* renamed from: a */
    public void mo24112a(C2407a aVar) {
        this.f5443a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C2407a aVar = this.f5443a;
        if (aVar != null) {
            aVar.mo24116a(this);
        }
    }

    /* renamed from: a */
    public void mo24114a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
