package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2058ag;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.co */
final class C2013co {

    /* renamed from: a */
    private static final C2058ag f5034a = new C2058ag("MergeSliceTaskHandler");

    /* renamed from: b */
    private final C1970au f5035b;

    C2013co(C1970au auVar) {
        this.f5035b = auVar;
    }

    /* renamed from: b */
    private static void m5053b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m5053b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new C1985bk(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new C1985bk(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new C1985bk(sb3.toString());
        }
    }

    /* renamed from: a */
    public final void mo21965a(C2012cn cnVar) {
        File i = this.f5035b.mo21883i(cnVar.f5000k, cnVar.f5031a, cnVar.f5032b, cnVar.f5033c);
        if (i.exists()) {
            File j = this.f5035b.mo21884j(cnVar.f5000k, cnVar.f5031a, cnVar.f5032b);
            if (!j.exists()) {
                j.mkdirs();
            }
            m5053b(i, j);
            try {
                this.f5035b.mo21886l(cnVar.f5000k, cnVar.f5031a, cnVar.f5032b, this.f5035b.mo21885k(cnVar.f5000k, cnVar.f5031a, cnVar.f5032b) + 1);
            } catch (IOException e) {
                f5034a.mo22025b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new C1985bk("Writing merge checkpoint failed.", e, cnVar.f4999j);
            }
        } else {
            throw new C1985bk(String.format("Cannot find verified files for slice %s.", new Object[]{cnVar.f5033c}), cnVar.f4999j);
        }
    }
}
