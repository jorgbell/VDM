package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* renamed from: com.flurry.sdk.jt */
public final class C1898jt {
    /* renamed from: a */
    public static boolean m4787a(C1897js jsVar) {
        return new File(jsVar.f4694a, jsVar.f4695b).delete();
    }

    /* renamed from: a */
    public static boolean m4788a(C1897js jsVar, C1897js jsVar2) {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            File file = new File(jsVar.f4694a, jsVar.f4695b);
            File file2 = new File(jsVar2.f4694a, jsVar2.f4695b);
            file2.getParentFile().mkdirs();
            file2.delete();
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                fileChannel2.transferFrom(channel, 0, channel.size());
                C1698dz.m4444a((Closeable) channel);
                C1698dz.m4444a((Closeable) fileChannel2);
                return true;
            } catch (Exception e) {
                e = e;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                try {
                    C1648cy.m4317a(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                    C1698dz.m4444a((Closeable) fileChannel2);
                    C1698dz.m4444a((Closeable) fileChannel);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    C1698dz.m4444a((Closeable) fileChannel2);
                    C1698dz.m4444a((Closeable) fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel4 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel4;
                C1698dz.m4444a((Closeable) fileChannel2);
                C1698dz.m4444a((Closeable) fileChannel);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
            C1648cy.m4317a(6, "FileProcessor", "Copy file failed. " + e.getMessage());
            C1698dz.m4444a((Closeable) fileChannel2);
            C1698dz.m4444a((Closeable) fileChannel);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            C1698dz.m4444a((Closeable) fileChannel2);
            C1698dz.m4444a((Closeable) fileChannel);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m4789a(File file, File file2) {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            file2.getParentFile().mkdirs();
            file2.delete();
            file2.createNewFile();
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                fileChannel2.transferFrom(channel, 0, channel.size());
                C1698dz.m4444a((Closeable) channel);
                C1698dz.m4444a((Closeable) fileChannel2);
                return true;
            } catch (Exception e) {
                e = e;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                try {
                    C1648cy.m4317a(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                    C1698dz.m4444a((Closeable) fileChannel2);
                    C1698dz.m4444a((Closeable) fileChannel);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    C1698dz.m4444a((Closeable) fileChannel2);
                    C1698dz.m4444a((Closeable) fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel4 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel4;
                C1698dz.m4444a((Closeable) fileChannel2);
                C1698dz.m4444a((Closeable) fileChannel);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
            C1648cy.m4317a(6, "FileProcessor", "Copy file failed. " + e.getMessage());
            C1698dz.m4444a((Closeable) fileChannel2);
            C1698dz.m4444a((Closeable) fileChannel);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            C1698dz.m4444a((Closeable) fileChannel2);
            C1698dz.m4444a((Closeable) fileChannel);
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m4790b(C1897js jsVar, C1897js jsVar2) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3 = null;
        try {
            File file = new File(jsVar.f4694a, jsVar.f4695b);
            FileChannel channel = new FileInputStream(new File(jsVar2.f4694a, jsVar2.f4695b)).getChannel();
            try {
                fileChannel3 = new FileOutputStream(file, true).getChannel();
                fileChannel3.transferFrom(channel, fileChannel3.size(), channel.size());
                C1698dz.m4444a((Closeable) channel);
                C1698dz.m4444a((Closeable) fileChannel3);
                return true;
            } catch (Exception unused) {
                FileChannel fileChannel4 = fileChannel3;
                fileChannel3 = channel;
                fileChannel = fileChannel4;
                C1698dz.m4444a((Closeable) fileChannel3);
                C1698dz.m4444a((Closeable) fileChannel);
                return false;
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel5 = fileChannel3;
                fileChannel3 = channel;
                fileChannel2 = fileChannel5;
                C1698dz.m4444a((Closeable) fileChannel3);
                C1698dz.m4444a((Closeable) fileChannel2);
                throw th;
            }
        } catch (Exception unused2) {
            fileChannel = null;
            C1698dz.m4444a((Closeable) fileChannel3);
            C1698dz.m4444a((Closeable) fileChannel);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel2 = null;
            C1698dz.m4444a((Closeable) fileChannel3);
            C1698dz.m4444a((Closeable) fileChannel2);
            throw th;
        }
    }
}
