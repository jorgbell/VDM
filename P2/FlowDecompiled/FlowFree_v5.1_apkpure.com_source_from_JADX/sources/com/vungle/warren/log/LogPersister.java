package com.vungle.warren.log;

import android.util.Log;
import com.vungle.warren.log.LogManager;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

class LogPersister {
    private static final String TAG = "LogPersister";
    private int entryCount;
    private LogManager.SdkLoggingEventListener listener;
    private File logDir;
    private File logFile;
    private int maximumEntries = 100;

    LogPersister(File file) {
        if (file != null) {
            File orCreateLogDir = getOrCreateLogDir(file);
            this.logDir = orCreateLogDir;
            if (orCreateLogDir != null) {
                this.logFile = getOrCreateLogFile(orCreateLogDir);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSdkLoggingEventListener(LogManager.SdkLoggingEventListener sdkLoggingEventListener) {
        this.listener = sdkLoggingEventListener;
    }

    /* access modifiers changed from: package-private */
    public void setMaximumEntries(int i) {
        if (i <= 0) {
            i = 100;
        }
        this.maximumEntries = i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x007f */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveLogData(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r14 = this;
            r1 = r14
            java.io.File r0 = r1.logDir
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = TAG
            java.lang.String r2 = "No log cache dir found."
            android.util.Log.w(r0, r2)
            return
        L_0x000d:
            java.io.File r0 = r1.logFile
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0030
        L_0x0017:
            java.lang.String r0 = TAG
            java.lang.String r2 = "current log file maybe deleted, create new one."
            android.util.Log.d(r0, r2)
            java.io.File r2 = r1.logDir
            java.io.File r2 = r14.getOrCreateLogFile(r2)
            r1.logFile = r2
            if (r2 == 0) goto L_0x00c8
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0030
            goto L_0x00c8
        L_0x0030:
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.lang.String r9 = r0.getID()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = getDateText(r2)
            com.vungle.warren.log.LogEntry r0 = new com.vungle.warren.log.LogEntry
            r2 = r0
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = 0
            r3 = 1
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x007f }
            java.io.File r5 = r1.logFile     // Catch:{ IOException -> 0x007f }
            r4.<init>(r5, r3)     // Catch:{ IOException -> 0x007f }
            int r2 = r1.entryCount     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            if (r2 <= 0) goto L_0x0069
            java.lang.String r2 = "\n"
            r4.append(r2)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
        L_0x0069:
            java.lang.String r0 = r0.toJsonString()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r4.append(r0)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r4.flush()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r4)
            r0 = 1
            goto L_0x008a
        L_0x0078:
            r0 = move-exception
            r2 = r4
            goto L_0x00c4
        L_0x007b:
            r2 = r4
            goto L_0x007f
        L_0x007d:
            r0 = move-exception
            goto L_0x00c4
        L_0x007f:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "Failed to write sdk logs."
            android.util.Log.e(r0, r4)     // Catch:{ all -> 0x007d }
            r0 = 0
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
        L_0x008a:
            if (r0 == 0) goto L_0x00c3
            int r0 = r1.entryCount
            int r0 = r0 + r3
            r1.entryCount = r0
            int r2 = r1.maximumEntries
            if (r0 < r2) goto L_0x00c3
            java.io.File r0 = r1.logFile
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r1.logFile
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = "_pending"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r0 = r14.renameFile(r0, r2)
            if (r0 == 0) goto L_0x00bc
            java.io.File r0 = r1.logDir
            java.io.File r0 = r14.getOrCreateLogFile(r0)
            r1.logFile = r0
        L_0x00bc:
            com.vungle.warren.log.LogManager$SdkLoggingEventListener r0 = r1.listener
            if (r0 == 0) goto L_0x00c3
            r0.sendPendingLogs()
        L_0x00c3:
            return
        L_0x00c4:
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            throw r0
        L_0x00c8:
            java.lang.String r2 = "Can't create log file, maybe no space left."
            android.util.Log.w(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogPersister.saveLogData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public File[] getPendingFiles() {
        File file = this.logDir;
        if (file != null) {
            return file.listFiles(new FilenameFilter(this) {
                public boolean accept(File file, String str) {
                    return str.endsWith("_pending");
                }
            });
        }
        Log.w(TAG, "No log cache dir found.");
        return null;
    }

    private File getOrCreateLogDir(File file) {
        File createFileOrDirectory = createFileOrDirectory(file, "sdk_logs", true);
        if (createFileOrDirectory != null && createFileOrDirectory.exists()) {
            return createFileOrDirectory;
        }
        Log.e(TAG, "Failed to create vungle logs dir");
        return null;
    }

    /* access modifiers changed from: package-private */
    public File getOrCreateLogFile(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter(this) {
            public boolean accept(File file, String str) {
                return !str.endsWith("_pending");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            this.entryCount = 0;
            return createFileOrDirectory(file, "log_" + System.currentTimeMillis() + UUID.randomUUID().toString(), false);
        }
        Arrays.sort(listFiles, new Comparator<File>(this) {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        File file2 = listFiles[0];
        int fileLineCount = getFileLineCount(file2.getAbsolutePath());
        if (fileLineCount <= 0 || fileLineCount < this.maximumEntries) {
            this.entryCount = fileLineCount;
            return file2;
        }
        File file3 = null;
        try {
            File file4 = this.logFile;
            if (renameFile(file4, this.logFile.getName() + "_pending")) {
                file3 = getOrCreateLogFile(file);
            }
        } catch (Exception unused) {
        }
        if (file3 != null) {
            return file3;
        }
        this.entryCount = fileLineCount;
        return file2;
    }

    private File createFileOrDirectory(File file, String str, boolean z) {
        boolean z2;
        File file2 = new File(file, str);
        if (file2.exists()) {
            z2 = true;
        } else if (!z) {
            try {
                z2 = file2.createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "", e);
                z2 = false;
            }
        } else {
            z2 = file2.mkdir();
        }
        if (z2) {
            return file2;
        }
        return null;
    }

    private boolean renameFile(File file, String str) {
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(this.logDir, str);
        if (file2.exists()) {
            return false;
        }
        return file.renameTo(file2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022 A[SYNTHETIC, Splitter:B:16:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0029 A[SYNTHETIC, Splitter:B:23:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int getFileLineCount(java.lang.String r3) {
        /*
            r0 = 0
            java.io.LineNumberReader r1 = new java.io.LineNumberReader     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0026, all -> 0x001f }
        L_0x000b:
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x001d, all -> 0x001a }
            if (r3 == 0) goto L_0x0012
            goto L_0x000b
        L_0x0012:
            int r3 = r1.getLineNumber()     // Catch:{ Exception -> 0x001d, all -> 0x001a }
            r1.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x002c
        L_0x001a:
            r3 = move-exception
            r0 = r1
            goto L_0x0020
        L_0x001d:
            r0 = r1
            goto L_0x0026
        L_0x001f:
            r3 = move-exception
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            throw r3
        L_0x0026:
            r3 = -1
            if (r0 == 0) goto L_0x002c
            r0.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogPersister.getFileLineCount(java.lang.String):int");
    }

    private static String getDateText(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    /* access modifiers changed from: package-private */
    public File[] getCrashReportFiles(int i) {
        File file = this.logDir;
        if (file == null) {
            Log.w(TAG, "No log cache dir found.");
            return null;
        }
        File[] listFiles = file.listFiles(new FilenameFilter(this) {
            public boolean accept(File file, String str) {
                return str.endsWith("_crash");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>(this) {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        return (File[]) Arrays.copyOfRange(listFiles, 0, Math.min(listFiles.length, i));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveCrashLogData(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r14 = this;
            r1 = r14
            java.io.File r0 = r1.logDir
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = TAG
            java.lang.String r2 = "No log cache dir found."
            android.util.Log.w(r0, r2)
            return
        L_0x000d:
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.lang.String r9 = r0.getID()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = getDateText(r2)
            com.vungle.warren.log.LogEntry r0 = new com.vungle.warren.log.LogEntry
            r2 = r0
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "crash_"
            r2.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.io.File r3 = r1.logDir
            r4 = 0
            java.io.File r2 = r14.createFileOrDirectory(r3, r2, r4)
            if (r2 == 0) goto L_0x0098
            r3 = 0
            r5 = 1
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ IOException -> 0x006f }
            r6.<init>(r2, r5)     // Catch:{ IOException -> 0x006f }
            java.lang.String r0 = r0.toJsonString()     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r6.append(r0)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r6.flush()     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r6)
            r4 = 1
            goto L_0x0079
        L_0x0068:
            r0 = move-exception
            r3 = r6
            goto L_0x0094
        L_0x006b:
            r3 = r6
            goto L_0x006f
        L_0x006d:
            r0 = move-exception
            goto L_0x0094
        L_0x006f:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "Failed to write crash log."
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x006d }
            com.vungle.warren.utility.FileUtility.closeQuietly(r3)
        L_0x0079:
            if (r4 == 0) goto L_0x0098
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r2.getName()
            r0.append(r3)
            java.lang.String r3 = "_crash"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r14.renameFile(r2, r0)
            goto L_0x0098
        L_0x0094:
            com.vungle.warren.utility.FileUtility.closeQuietly(r3)
            throw r0
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogPersister.saveCrashLogData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
