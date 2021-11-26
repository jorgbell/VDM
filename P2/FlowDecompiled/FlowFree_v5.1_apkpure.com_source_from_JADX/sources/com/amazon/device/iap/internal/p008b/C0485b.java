package com.amazon.device.iap.internal.p008b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.prompt.SimplePrompt;
import com.amazon.android.framework.resource.Resource;
import com.amazon.device.iap.internal.util.C0532e;

/* renamed from: com.amazon.device.iap.internal.b.b */
/* compiled from: FailurePrompt */
public class C0485b extends SimplePrompt {

    /* renamed from: a */
    private static final String f33a = C0485b.class.getSimpleName();
    @Resource

    /* renamed from: b */
    private ContextManager f34b;

    /* renamed from: c */
    private final PromptContent f35c;

    /* access modifiers changed from: protected */
    public long getExpirationDurationInSeconds() {
        return 31536000;
    }

    public C0485b(PromptContent promptContent) {
        super(promptContent);
        this.f35c = promptContent;
    }

    /* access modifiers changed from: protected */
    public void doAction() {
        C0532e.m187a(f33a, "doAction");
        if ("Amazon Appstore required".equalsIgnoreCase(this.f35c.getTitle()) || "Amazon Appstore Update Required".equalsIgnoreCase(this.f35c.getTitle())) {
            try {
                Activity visible = this.f34b.getVisible();
                if (visible == null) {
                    visible = this.f34b.getRoot();
                }
                visible.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl")));
            } catch (Exception e) {
                String str = f33a;
                C0532e.m189b(str, "Exception in PurchaseItemCommandTask.OnSuccess: " + e);
            }
        }
    }

    public String toString() {
        return f33a;
    }
}
