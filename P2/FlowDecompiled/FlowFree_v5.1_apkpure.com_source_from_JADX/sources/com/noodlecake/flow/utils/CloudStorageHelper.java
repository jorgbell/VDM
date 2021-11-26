package com.noodlecake.flow.utils;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.noodlecake.noodlenews.NoodlecakeGameActivity;
import java.io.IOException;

public class CloudStorageHelper {
    /* access modifiers changed from: private */
    public static String TAG = "CloudStorageHelper";
    private static byte[] cloudDataSaving = null;
    /* access modifiers changed from: private */
    public static byte[] cloudDataToSave = null;
    private static boolean hasLoadPending = false;
    /* access modifiers changed from: private */
    public static boolean isLoadedSuccessfully = false;
    private static boolean isLoading = false;
    /* access modifiers changed from: private */
    public static boolean loadOnConnection = false;

    public static native byte[] nativeResolveData(byte[] bArr);

    public static void loadCloudData() {
        if (!isLoading) {
            isLoading = true;
            new CloudLoadTask().execute(new byte[0][]);
            return;
        }
        hasLoadPending = true;
    }

    /* access modifiers changed from: private */
    public static void cloudDataLoaded() {
        isLoading = false;
        if (hasLoadPending) {
            hasLoadPending = false;
            loadCloudData();
        }
    }

    public static void saveCloudData(byte[] bArr) {
        cloudDataToSave = bArr;
        if (cloudDataSaving == null) {
            executeCloudSave();
        }
    }

    /* access modifiers changed from: private */
    public static void cloudDataSaved() {
        cloudDataSaving = null;
        if (cloudDataToSave != null) {
            executeCloudSave();
        }
    }

    private static void executeCloudSave() {
        if (isLoadedSuccessfully) {
            cloudDataSaving = cloudDataToSave;
            cloudDataToSave = null;
            new CloudSaveTask().execute(new byte[][]{cloudDataSaving});
            return;
        }
        loadCloudData();
    }

    static class CloudSaveTask extends AsyncTask<byte[], Void, Boolean> {
        /* access modifiers changed from: protected */
        public void onCancelled() {
        }

        CloudSaveTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(byte[]... bArr) {
            if (bArr.length < 1) {
                return Boolean.FALSE;
            }
            if (!NoodlecakeGameActivity.isGoogleAPIConnected()) {
                return Boolean.FALSE;
            }
            Snapshot access$000 = CloudStorageHelper.getSnapshot();
            if (access$000 == null) {
                return Boolean.FALSE;
            }
            access$000.getSnapshotContents().writeBytes(bArr[0]);
            try {
                int length = access$000.getSnapshotContents().readFully().length;
                SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
                builder.fromMetadata(access$000.getMetadata());
                builder.setDescription("Your Flow Free Save Data");
                builder.setPlayedTimeMillis(60000);
                builder.setProgressValue(access$000.getMetadata().getProgressValue() + 1);
                Games.getSnapshotsClient(NoodlecakeGameActivity.getContext(), GoogleSignIn.getLastSignedInAccount(NoodlecakeGameActivity.getContext())).commitAndClose(access$000, builder.build());
                return Boolean.TRUE;
            } catch (IOException unused) {
                return Boolean.FALSE;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            CloudStorageHelper.cloudDataSaved();
        }
    }

    public static class CloudLoadTask extends AsyncTask<byte[], Void, Void> {
        /* access modifiers changed from: protected */
        public void onCancelled() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(byte[]... bArr) {
            if (NoodlecakeGameActivity.isGoogleAPIConnected()) {
                boolean unused = CloudStorageHelper.loadOnConnection = false;
                Snapshot access$000 = CloudStorageHelper.getSnapshot();
                if (access$000 != null) {
                    try {
                        SnapshotContents snapshotContents = access$000.getSnapshotContents();
                        if (snapshotContents != null) {
                            byte[] readFully = snapshotContents.readFully();
                            String access$300 = CloudStorageHelper.TAG;
                            Log.v(access$300, "Loaded cloud data. Size : " + readFully.length);
                            CloudStorageHelper.nativeResolveData(readFully);
                            boolean unused2 = CloudStorageHelper.isLoadedSuccessfully = true;
                            byte[] unused3 = CloudStorageHelper.cloudDataToSave = null;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                boolean unused4 = CloudStorageHelper.loadOnConnection = true;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            CloudStorageHelper.cloudDataLoaded();
        }
    }

    /* access modifiers changed from: private */
    public static Snapshot getSnapshot() {
        return getSnapshot("Flow_Main_Save");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.games.snapshot.Snapshot getSnapshot(java.lang.String r6) {
        /*
            java.lang.String r0 = ")"
            java.lang.String r1 = "Failed to get snapshot. ("
            r2 = 0
            android.content.Context r3 = com.noodlecake.noodlenews.NoodlecakeGameActivity.getContext()     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            android.content.Context r4 = com.noodlecake.noodlenews.NoodlecakeGameActivity.getContext()     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r4 = com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(r4)     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            com.google.android.gms.games.SnapshotsClient r3 = com.google.android.gms.games.Games.getSnapshotsClient(r3, r4)     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            r4 = 1
            r5 = 3
            com.google.android.gms.tasks.Task r6 = r3.open(r6, r4, r5)     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            java.lang.Object r6 = com.google.android.gms.tasks.Tasks.await(r6)     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            com.google.android.gms.games.SnapshotsClient$DataOrConflict r6 = (com.google.android.gms.games.SnapshotsClient.DataOrConflict) r6     // Catch:{ ExecutionException -> 0x003f, InterruptedException -> 0x0022 }
            goto L_0x005c
        L_0x0022:
            r6 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r6 = r6.getMessage()
            r4.append(r6)
            r4.append(r0)
            java.lang.String r6 = r4.toString()
            android.util.Log.w(r3, r6)
            goto L_0x005b
        L_0x003f:
            r6 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r6 = r6.getMessage()
            r4.append(r6)
            r4.append(r0)
            java.lang.String r6 = r4.toString()
            android.util.Log.w(r3, r6)
        L_0x005b:
            r6 = r2
        L_0x005c:
            if (r6 == 0) goto L_0x0065
            java.lang.Object r6 = r6.getData()
            r2 = r6
            com.google.android.gms.games.snapshot.Snapshot r2 = (com.google.android.gms.games.snapshot.Snapshot) r2
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noodlecake.flow.utils.CloudStorageHelper.getSnapshot(java.lang.String):com.google.android.gms.games.snapshot.Snapshot");
    }

    public static boolean hasLoadedSuccessfully() {
        return isLoadedSuccessfully;
    }

    public static boolean shouldLoadOnConnection() {
        return loadOnConnection;
    }
}
