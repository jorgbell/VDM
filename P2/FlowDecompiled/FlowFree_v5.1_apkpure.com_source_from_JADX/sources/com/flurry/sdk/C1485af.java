package com.flurry.sdk;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.flurry.sdk.af */
public final class C1485af {

    /* renamed from: a */
    String f3737a = "";

    /* renamed from: b */
    final Set<String> f3738b;

    C1485af() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add((Object) null);
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f3738b = Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: a */
    static void m3965a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File fileStreamPath = C1536b.m4057a().getFileStreamPath(".flurryb.");
            if (C1696dy.m4434a(fileStreamPath)) {
                DataOutputStream dataOutputStream = null;
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(fileStreamPath));
                    try {
                        dataOutputStream2.writeInt(1);
                        dataOutputStream2.writeUTF(str);
                        C1698dz.m4444a((Closeable) dataOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        try {
                            C1648cy.m4318a(6, "DeviceIdProvider", "Error when saving deviceId", th);
                        } finally {
                            C1698dz.m4444a((Closeable) dataOutputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C1648cy.m4318a(6, "DeviceIdProvider", "Error when saving deviceId", th);
                }
            }
        }
    }

    /* renamed from: a */
    static String m3964a() {
        DataInputStream dataInputStream;
        File fileStreamPath = C1536b.m4057a().getFileStreamPath(".flurryb.");
        String str = null;
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (1 == dataInputStream.readInt()) {
                    str = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    C1648cy.m4318a(6, "DeviceIdProvider", "Error when loading deviceId", th);
                    C1698dz.m4444a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    C1698dz.m4444a((Closeable) dataInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            C1648cy.m4318a(6, "DeviceIdProvider", "Error when loading deviceId", th);
            C1698dz.m4444a((Closeable) dataInputStream);
            return str;
        }
        C1698dz.m4444a((Closeable) dataInputStream);
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo11265b() {
        String[] list;
        File fileStreamPath;
        DataInputStream dataInputStream;
        File filesDir = C1536b.m4057a().getFilesDir();
        String str = null;
        if (filesDir == null || (list = filesDir.list(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.startsWith(".flurryagent.");
            }
        })) == null || list.length == 0 || (fileStreamPath = C1536b.m4057a().getFileStreamPath(list[0])) == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (46586 == dataInputStream.readUnsignedShort() && 2 == dataInputStream.readUnsignedShort()) {
                    dataInputStream.readUTF();
                    str = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    C1648cy.m4318a(6, "DeviceIdProvider", "Error when loading deviceId", th);
                    C1698dz.m4444a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    C1698dz.m4444a((Closeable) dataInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            C1648cy.m4318a(6, "DeviceIdProvider", "Error when loading deviceId", th);
            C1698dz.m4444a((Closeable) dataInputStream);
            return str;
        }
        C1698dz.m4444a((Closeable) dataInputStream);
        return str;
    }
}
