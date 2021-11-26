package com.amazon.device.iap.internal.p008b;

import android.os.RemoteException;
import com.amazon.android.Kiwi;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.task.command.AbstractCommandTask;
import com.amazon.android.licensing.LicenseFailurePromptContentMapper;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.b.i */
/* compiled from: KiwiCommand */
public abstract class C0516i extends AbstractCommandTask {

    /* renamed from: a */
    private static final String f72a = C0516i.class.getSimpleName();

    /* renamed from: b */
    private final C0501e f73b;

    /* renamed from: c */
    private final String f74c;

    /* renamed from: d */
    private final String f75d;

    /* renamed from: e */
    private final String f76e;

    /* renamed from: f */
    private final Map<String, Object> f77f;

    /* renamed from: g */
    private final LicenseFailurePromptContentMapper f78g = new LicenseFailurePromptContentMapper();

    /* renamed from: h */
    private boolean f79h;

    /* renamed from: i */
    private C0516i f80i;

    /* renamed from: j */
    private C0516i f81j;

    /* renamed from: k */
    private boolean f82k = false;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo7442a(SuccessResult successResult) throws Exception;

    /* access modifiers changed from: protected */
    public boolean isExecutionNeeded() {
        return true;
    }

    public C0516i(C0501e eVar, String str, String str2) {
        this.f73b = eVar;
        String requestId = eVar.mo7456c().toString();
        this.f74c = requestId;
        this.f75d = str;
        this.f76e = str2;
        HashMap hashMap = new HashMap();
        this.f77f = hashMap;
        hashMap.put("requestId", requestId);
        hashMap.put("sdkVersion", PurchasingService.SDK_VERSION);
        this.f79h = true;
        this.f80i = null;
        this.f81j = null;
    }

    /* renamed from: a */
    public C0516i mo7466a(boolean z) {
        this.f82k = z;
        return this;
    }

    /* renamed from: a */
    public void mo7467a(C0516i iVar) {
        this.f80i = iVar;
    }

    /* renamed from: b */
    public void mo7470b(C0516i iVar) {
        this.f81j = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7468a(String str, Object obj) {
        this.f77f.put(str, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0501e mo7469b() {
        return this.f73b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo7472c() {
        return this.f74c;
    }

    /* access modifiers changed from: protected */
    public String getCommandName() {
        return this.f75d;
    }

    /* access modifiers changed from: protected */
    public String getCommandVersion() {
        return this.f76e;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getCommandData() {
        return this.f77f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7471b(boolean z) {
        this.f79h = z;
    }

    /* renamed from: a */
    private void m118a(PromptContent promptContent) {
        if (promptContent != null) {
            Kiwi.getPromptManager().present(new C0485b(promptContent));
        }
    }

    /* access modifiers changed from: protected */
    public final void onSuccess(SuccessResult successResult) throws RemoteException {
        C0516i iVar;
        String str = (String) successResult.getData().get("errorMessage");
        String str2 = f72a;
        C0532e.m187a(str2, "onSuccess: result = " + successResult + ", errorMessage: " + str);
        if (C0531d.m186a(str)) {
            boolean z = false;
            try {
                z = mo7442a(successResult);
            } catch (Exception e) {
                String str3 = f72a;
                C0532e.m189b(str3, "Error calling onResult: " + e);
            }
            if (z && (iVar = this.f80i) != null) {
                iVar.mo7460a_();
            } else if (this.f82k) {
            } else {
                if (z) {
                    this.f73b.mo7444a();
                } else {
                    this.f73b.mo7445b();
                }
            }
        } else if (!this.f82k) {
            this.f73b.mo7445b();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = (java.lang.String) r5.getExtensionData().get("maxVersion");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFailure(com.amazon.venezia.command.FailureResult r5) throws android.os.RemoteException, com.amazon.android.framework.exception.KiwiException {
        /*
            r4 = this;
            java.lang.String r0 = f72a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onFailure: result = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.amazon.device.iap.internal.util.C0532e.m187a(r0, r1)
            if (r5 == 0) goto L_0x0030
            java.util.Map r0 = r5.getExtensionData()
            java.lang.String r1 = "maxVersion"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0030
            java.lang.String r1 = "1.0"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x0042
            com.amazon.device.iap.internal.b.i r0 = r4.f81j
            if (r0 == 0) goto L_0x0042
            boolean r5 = r4.f82k
            r0.mo7466a((boolean) r5)
            com.amazon.device.iap.internal.b.i r5 = r4.f81j
            r5.mo7460a_()
            return
        L_0x0042:
            boolean r0 = r4.f79h
            if (r0 == 0) goto L_0x005e
            com.amazon.android.framework.prompt.PromptContent r0 = new com.amazon.android.framework.prompt.PromptContent
            java.lang.String r1 = r5.getDisplayableName()
            java.lang.String r2 = r5.getDisplayableMessage()
            java.lang.String r3 = r5.getButtonLabel()
            boolean r5 = r5.show()
            r0.<init>(r1, r2, r3, r5)
            r4.m118a((com.amazon.android.framework.prompt.PromptContent) r0)
        L_0x005e:
            boolean r5 = r4.f82k
            if (r5 != 0) goto L_0x0067
            com.amazon.device.iap.internal.b.e r5 = r4.f73b
            r5.mo7445b()
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.p008b.C0516i.onFailure(com.amazon.venezia.command.FailureResult):void");
    }

    /* access modifiers changed from: protected */
    public final void onException(KiwiException kiwiException) {
        C0516i iVar;
        String str = f72a;
        C0532e.m187a(str, "onException: exception = " + kiwiException.getMessage());
        if (!"UNHANDLED_EXCEPTION".equals(kiwiException.getType()) || !"2.0".equals(this.f76e) || (iVar = this.f81j) == null) {
            if (this.f79h) {
                m118a(this.f78g.map(kiwiException));
            }
            if (!this.f82k) {
                this.f73b.mo7445b();
                return;
            }
            return;
        }
        iVar.mo7466a(this.f82k);
        this.f81j.mo7460a_();
    }

    /* renamed from: a_ */
    public void mo7460a_() {
        Kiwi.addCommandToCommandTaskPipeline(this);
    }
}
