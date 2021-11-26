package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2116u;
import com.google.android.play.core.tasks.C2172i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ag */
class C1958ag<T> extends C2116u {

    /* renamed from: a */
    final C2172i<T> f4820a;

    /* renamed from: b */
    final /* synthetic */ C1963an f4821b;

    C1958ag(C1963an anVar, C2172i<T> iVar) {
        this.f4821b = anVar;
        this.f4820a = iVar;
    }

    C1958ag(C1963an anVar, C2172i iVar, byte[] bArr) {
        this(anVar, iVar);
    }

    C1958ag(C1963an anVar, C2172i iVar, char[] cArr) {
        this(anVar, iVar);
    }

    C1958ag(C1963an anVar, C2172i iVar, int[] iArr) {
        this(anVar, iVar);
    }

    /* renamed from: b */
    public void mo21845b(int i, Bundle bundle) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onStartDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo21846c(List<Bundle> list) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onGetSessionStates", new Object[0]);
    }

    /* renamed from: d */
    public void mo21847d(Bundle bundle, Bundle bundle2) {
        this.f4821b.f4833f.mo22037b();
        C1963an.f4828a.mo22027d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    /* renamed from: e */
    public void mo21848e(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onGetChunkFileDescriptor", new Object[0]);
    }

    /* renamed from: f */
    public void mo21849f(Bundle bundle, Bundle bundle2) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onRequestDownloadInfo()", new Object[0]);
    }

    /* renamed from: g */
    public void mo21850g(Bundle bundle) {
        this.f4821b.f4832e.mo22037b();
        int i = bundle.getInt("error_code");
        C1963an.f4828a.mo22025b("onError(%d)", Integer.valueOf(i));
        this.f4820a.mo22195d(new AssetPackException(i));
    }

    /* renamed from: h */
    public final void mo21851h(int i) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: i */
    public void mo21852i() {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onCancelDownloads()", new Object[0]);
    }

    /* renamed from: j */
    public final void mo21853j(int i) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: k */
    public void mo21854k(Bundle bundle) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: l */
    public void mo21855l(Bundle bundle) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: m */
    public void mo21856m(Bundle bundle) {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: n */
    public void mo21857n() {
        this.f4821b.f4832e.mo22037b();
        C1963an.f4828a.mo22027d("onRemoveModule()", new Object[0]);
    }
}
