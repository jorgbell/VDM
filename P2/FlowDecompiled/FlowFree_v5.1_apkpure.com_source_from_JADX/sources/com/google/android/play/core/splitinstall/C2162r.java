package com.google.android.play.core.splitinstall;

/* renamed from: com.google.android.play.core.splitinstall.r */
final class C2162r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f5291a;

    /* renamed from: b */
    final /* synthetic */ int f5292b;

    /* renamed from: c */
    final /* synthetic */ int f5293c;

    /* renamed from: d */
    final /* synthetic */ C2163s f5294d;

    C2162r(C2163s sVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f5294d = sVar;
        this.f5291a = splitInstallSessionState;
        this.f5292b = i;
        this.f5293c = i2;
    }

    public final void run() {
        C2163s sVar = this.f5294d;
        SplitInstallSessionState splitInstallSessionState = this.f5291a;
        sVar.mo22177k(new C2152a(splitInstallSessionState.sessionId(), this.f5292b, this.f5293c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo22159a(), splitInstallSessionState.mo22160b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo22162c()));
    }
}
