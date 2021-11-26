package com.vungle.warren.utility;

import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class FileUtility {
    private static final String TAG = "FileUtility";
    protected static final List<Class<?>> allowedClasses = Arrays.asList(new Class[]{LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class});
    private static ObjectInputStreamProvider objectInputStreamProvider = new ObjectInputStreamProvider() {
        public SafeObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException {
            return new SafeObjectInputStream(inputStream, FileUtility.allowedClasses);
        }
    };

    interface ObjectInputStreamProvider {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    public static void printDirectoryTree(File file) {
    }

    public static void delete(File file) throws IOException {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete(delete);
                    }
                } else {
                    return;
                }
            }
            if (!file.delete()) {
                throw new FileNotFoundException("Failed to delete file: " + file);
            }
        }
    }

    public static void deleteAndLogIfFailed(File file) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else if (!file.delete()) {
                String str = TAG;
                Log.e(str, "Cannot delete " + file.getName());
            }
        } catch (IOException e) {
            String str2 = TAG;
            Log.e(str2, "Cannot delete " + file.getName(), e);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static HashMap<String, String> readMap(String str) {
        Object readSerializable = readSerializable(new File(str));
        if (readSerializable instanceof HashMap) {
            return (HashMap) readSerializable;
        }
        return new HashMap<>();
    }

    public static void writeMap(String str, HashMap<String, String> hashMap) {
        File file = new File(str);
        if (!hashMap.isEmpty()) {
            writeSerializable(file, hashMap);
        }
    }

    public static void writeSerializable(File file, Serializable serializable) {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        objectOutputStream2.reset();
                        closeQuietly(objectOutputStream2);
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        try {
                            Log.e(TAG, "IOIOException", e);
                            closeQuietly(objectOutputStream);
                            closeQuietly(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            closeQuietly(objectOutputStream);
                            closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        closeQuietly(objectOutputStream);
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, "IOIOException", e);
                    closeQuietly(objectOutputStream);
                    closeQuietly(fileOutputStream);
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                Log.e(TAG, "IOIOException", e);
                closeQuietly(objectOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeQuietly(objectOutputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
            closeQuietly(fileOutputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T readSerializable(java.io.File r6) {
        /*
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x003d, Exception -> 0x0032, all -> 0x002f }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x003d, Exception -> 0x0032, all -> 0x002f }
            com.vungle.warren.utility.FileUtility$ObjectInputStreamProvider r2 = objectInputStreamProvider     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0029, Exception -> 0x0026, all -> 0x0024 }
            java.io.ObjectInputStream r2 = r2.provideObjectInputStream(r0)     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0029, Exception -> 0x0026, all -> 0x0024 }
            java.lang.Object r6 = r2.readObject()     // Catch:{ IOException -> 0x0022, ClassNotFoundException -> 0x0020, Exception -> 0x001e }
            closeQuietly(r2)
            closeQuietly(r0)
            return r6
        L_0x001e:
            r3 = move-exception
            goto L_0x0035
        L_0x0020:
            r3 = move-exception
            goto L_0x0040
        L_0x0022:
            r3 = move-exception
            goto L_0x004b
        L_0x0024:
            r6 = move-exception
            goto L_0x005e
        L_0x0026:
            r3 = move-exception
            r2 = r1
            goto L_0x0035
        L_0x0029:
            r3 = move-exception
            r2 = r1
            goto L_0x0040
        L_0x002c:
            r3 = move-exception
            r2 = r1
            goto L_0x004b
        L_0x002f:
            r6 = move-exception
            r0 = r1
            goto L_0x005e
        L_0x0032:
            r3 = move-exception
            r0 = r1
            r2 = r0
        L_0x0035:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x005c }
            java.lang.String r5 = "cannot read serializable"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x005c }
            goto L_0x0052
        L_0x003d:
            r3 = move-exception
            r0 = r1
            r2 = r0
        L_0x0040:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x005c }
            java.lang.String r5 = "ClassNotFoundException"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x005c }
            goto L_0x0052
        L_0x0048:
            r3 = move-exception
            r0 = r1
            r2 = r0
        L_0x004b:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x005c }
            java.lang.String r5 = "IOIOException"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x005c }
        L_0x0052:
            closeQuietly(r2)
            closeQuietly(r0)
            delete(r6)     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            return r1
        L_0x005c:
            r6 = move-exception
            r1 = r2
        L_0x005e:
            closeQuietly(r1)
            closeQuietly(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.utility.FileUtility.readSerializable(java.io.File):java.lang.Object");
    }

    public static long size(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File size : listFiles) {
                j += size(size);
            }
        }
        return j;
    }
}
