package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.be */
final class C2083be implements C2076ay {

    /* renamed from: a */
    private final /* synthetic */ int f5187a = 0;

    C2083be() {
    }

    C2083be(byte[] bArr) {
    }

    C2083be(char[] cArr) {
    }

    /* renamed from: a */
    public final boolean mo22049a(Object obj, File file, File file2) {
        int i = this.f5187a;
        if (i == 0) {
            try {
                return !((Boolean) C2086bh.m5227f(Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
            } catch (ClassNotFoundException unused) {
                Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
                return false;
            }
        } else if (i != 1) {
            return true;
        } else {
            return new File((String) C2086bh.m5228g(obj.getClass(), String.class, File.class, file, File.class, file2)).exists();
        }
    }
}
