package com.amazon.device.iap.internal.p008b.p010b;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.resource.Resource;
import com.amazon.android.framework.task.Task;
import com.amazon.android.framework.task.TaskManager;
import com.amazon.android.framework.task.pipeline.TaskPipelineId;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.internal.util.MetricsHelper;
import com.amazon.venezia.command.SuccessResult;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.b.b.a */
/* compiled from: PurchaseItemCommandBase */
abstract class C0486a extends C0516i {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f36d = C0486a.class.getSimpleName();
    @Resource

    /* renamed from: a */
    protected TaskManager f37a;
    @Resource

    /* renamed from: b */
    protected ContextManager f38b;

    /* renamed from: c */
    protected final String f39c;

    C0486a(C0501e eVar, String str, String str2) {
        super(eVar, "purchase_item", str);
        this.f39c = str2;
        mo7468a(AppLovinEventParameters.PRODUCT_IDENTIFIER, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        Map data = successResult.getData();
        String str = f36d;
        C0532e.m187a(str, "data: " + data);
        if (!data.containsKey("purchaseItemIntent")) {
            C0532e.m189b(str, "did not find intent");
            return false;
        }
        C0532e.m187a(str, "found intent");
        final Intent intent = (Intent) data.remove("purchaseItemIntent");
        this.f37a.enqueueAtFront(TaskPipelineId.FOREGROUND, new Task() {
            public void execute() {
                try {
                    Activity visible = C0486a.this.f38b.getVisible();
                    if (visible == null) {
                        visible = C0486a.this.f38b.getRoot();
                    }
                    String a = C0486a.f36d;
                    C0532e.m187a(a, "About to fire intent with activity " + visible);
                    visible.startActivity(intent);
                } catch (Exception e) {
                    String a2 = C0486a.this.mo7472c();
                    MetricsHelper.submitExceptionMetrics(a2, C0486a.f36d + ".onResult().execute()", e);
                    String a3 = C0486a.f36d;
                    C0532e.m189b(a3, "Exception when attempting to fire intent: " + e);
                }
            }
        });
        return true;
    }
}
