package com.unity3d.services.core.webview.bridge.invocation;

import android.os.ConditionVariable;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebViewBridgeInvocation implements IWebViewBridgeInvocation {
    /* access modifiers changed from: private */
    public static IWebViewBridgeInvocationCallback invocationCallback;
    /* access modifiers changed from: private */
    public static ConditionVariable responseTimeout;
    /* access modifiers changed from: private */
    public IWebViewBridgeInvoker _webViewBridgeInvoker;
    private ExecutorService executorService;
    /* access modifiers changed from: private */
    public Method webViewBridgeCallbackMethod;

    public WebViewBridgeInvocation(IWebViewBridgeInvoker iWebViewBridgeInvoker, IWebViewBridgeInvocationCallback iWebViewBridgeInvocationCallback) {
        responseTimeout = new ConditionVariable();
        invocationCallback = iWebViewBridgeInvocationCallback;
        if (iWebViewBridgeInvoker != null) {
            this._webViewBridgeInvoker = iWebViewBridgeInvoker;
            this.executorService = Executors.newSingleThreadExecutor();
            try {
                this.webViewBridgeCallbackMethod = WebViewBridgeInvocation.class.getMethod("onInvocationComplete", new Class[]{CallbackStatus.class});
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("loadCallback cannot be null");
            }
        } else {
            throw new IllegalArgumentException("webViewBridgeInvoker cannot be null");
        }
    }

    public synchronized void invoke(String str, String str2, int i, Object... objArr) {
        final String str3 = str;
        final String str4 = str2;
        final Object[] objArr2 = objArr;
        final int i2 = i;
        this.executorService.submit(new Runnable() {
            public void run() {
                if (!WebViewBridgeInvocation.this._webViewBridgeInvoker.invokeMethod(str3, str4, WebViewBridgeInvocation.this.webViewBridgeCallbackMethod, objArr2)) {
                    if (WebViewBridgeInvocation.invocationCallback != null) {
                        WebViewBridgeInvocation.invocationCallback.onFailure("WebViewBridgeInvocation:execute: invokeMethod failure", (CallbackStatus) null);
                    }
                } else if (!WebViewBridgeInvocation.responseTimeout.block((long) i2) && WebViewBridgeInvocation.invocationCallback != null) {
                    WebViewBridgeInvocation.invocationCallback.onTimeout();
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void onInvocationComplete(com.unity3d.services.core.webview.bridge.CallbackStatus r3) {
        /*
            java.lang.Class<com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation> r0 = com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation.class
            monitor-enter(r0)
            android.os.ConditionVariable r1 = responseTimeout     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x000a
            r1.open()     // Catch:{ all -> 0x002a }
        L_0x000a:
            com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback r1 = invocationCallback     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            int[] r1 = com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation.C28782.f5619x2a9b2b27     // Catch:{ all -> 0x002a }
            int r2 = r3.ordinal()     // Catch:{ all -> 0x002a }
            r1 = r1[r2]     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 == r2) goto L_0x0023
            com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback r1 = invocationCallback     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "WebViewBridgeInvocation:OnInvocationComplete: CallbackStatus.Error"
            r1.onFailure(r2, r3)     // Catch:{ all -> 0x002a }
            goto L_0x0028
        L_0x0023:
            com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback r3 = invocationCallback     // Catch:{ all -> 0x002a }
            r3.onSuccess()     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r0)
            return
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation.onInvocationComplete(com.unity3d.services.core.webview.bridge.CallbackStatus):void");
    }

    /* renamed from: com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation$2 */
    static /* synthetic */ class C28782 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$webview$bridge$CallbackStatus */
        static final /* synthetic */ int[] f5619x2a9b2b27;

        static {
            int[] iArr = new int[CallbackStatus.values().length];
            f5619x2a9b2b27 = iArr;
            try {
                iArr[CallbackStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
