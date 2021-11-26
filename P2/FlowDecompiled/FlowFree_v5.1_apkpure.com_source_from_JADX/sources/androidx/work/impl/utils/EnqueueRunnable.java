package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation = new OperationImpl();
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean z2 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z2 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.getIds())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01a4 A[LOOP:6: B:107:0x019e->B:109:0x01a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01cd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r19, java.util.List<? extends androidx.work.WorkRequest> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.ExistingWorkPolicy r23) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r19.getWorkDatabase()
            r8 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.model.WorkSpecDao r7 = r6.workSpecDao()
            androidx.work.impl.model.WorkSpec r7 = r7.getWorkSpec(r15)
            if (r7 != 0) goto L_0x0045
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.error(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r7 = r7.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.SUCCEEDED
            if (r7 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.FAILED
            if (r7 != r15) goto L_0x0055
            r13 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.CANCELLED
            if (r7 != r15) goto L_0x005a
            r14 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r7 = android.text.TextUtils.isEmpty(r22)
            r7 = r7 ^ r8
            if (r7 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x00ca
            androidx.work.impl.model.WorkSpecDao r10 = r6.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x00ca
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 != r11) goto L_0x00cc
            androidx.work.impl.model.DependencyDao r3 = r6.dependencyDao()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x008d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00be
            java.lang.Object r11 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            java.lang.String r15 = r11.f22id
            boolean r15 = r3.hasDependents(r15)
            if (r15 != 0) goto L_0x00bc
            androidx.work.WorkInfo$State r15 = r11.state
            androidx.work.WorkInfo$State r8 = androidx.work.WorkInfo$State.SUCCEEDED
            if (r15 != r8) goto L_0x00a9
            r8 = 1
            goto L_0x00aa
        L_0x00a9:
            r8 = 0
        L_0x00aa:
            r8 = r8 & r12
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo$State.FAILED
            if (r15 != r12) goto L_0x00b1
            r13 = 1
            goto L_0x00b6
        L_0x00b1:
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo$State.CANCELLED
            if (r15 != r12) goto L_0x00b6
            r14 = 1
        L_0x00b6:
            java.lang.String r11 = r11.f22id
            r9.add(r11)
            r12 = r8
        L_0x00bc:
            r8 = 1
            goto L_0x008d
        L_0x00be:
            java.lang.Object[] r1 = r9.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r3 = r1.length
            if (r3 <= 0) goto L_0x00c9
            r9 = 1
            goto L_0x00ca
        L_0x00c9:
            r9 = 0
        L_0x00ca:
            r3 = 0
            goto L_0x0111
        L_0x00cc:
            androidx.work.ExistingWorkPolicy r8 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r8) goto L_0x00ec
            java.util.Iterator r3 = r10.iterator()
        L_0x00d4:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x00ec
            java.lang.Object r8 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r8 = (androidx.work.impl.model.WorkSpec.IdAndState) r8
            androidx.work.WorkInfo$State r8 = r8.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo$State.ENQUEUED
            if (r8 == r11) goto L_0x00ea
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo$State.RUNNING
            if (r8 != r11) goto L_0x00d4
        L_0x00ea:
            r3 = 0
            return r3
        L_0x00ec:
            r3 = 0
            androidx.work.impl.utils.CancelWorkRunnable r8 = androidx.work.impl.utils.CancelWorkRunnable.forName(r2, r0, r3)
            r8.run()
            androidx.work.impl.model.WorkSpecDao r8 = r6.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00fc:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x010e
            java.lang.Object r11 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            java.lang.String r11 = r11.f22id
            r8.delete(r11)
            goto L_0x00fc
        L_0x010e:
            r16 = 1
            goto L_0x0113
        L_0x0111:
            r16 = 0
        L_0x0113:
            java.util.Iterator r8 = r20.iterator()
        L_0x0117:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x01d2
            java.lang.Object r10 = r8.next()
            androidx.work.WorkRequest r10 = (androidx.work.WorkRequest) r10
            androidx.work.impl.model.WorkSpec r11 = r10.getWorkSpec()
            if (r9 == 0) goto L_0x013e
            if (r12 != 0) goto L_0x013e
            if (r13 == 0) goto L_0x0132
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.FAILED
            r11.state = r15
            goto L_0x0146
        L_0x0132:
            if (r14 == 0) goto L_0x0139
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.CANCELLED
            r11.state = r15
            goto L_0x0146
        L_0x0139:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo$State.BLOCKED
            r11.state = r15
            goto L_0x0146
        L_0x013e:
            boolean r15 = r11.isPeriodic()
            if (r15 != 0) goto L_0x0149
            r11.periodStartTime = r4
        L_0x0146:
            r17 = r4
            goto L_0x014f
        L_0x0149:
            r17 = r4
            r3 = 0
            r11.periodStartTime = r3
        L_0x014f:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 < r4) goto L_0x015d
            r4 = 25
            if (r3 > r4) goto L_0x015d
            tryDelegateConstrainedWorkSpec(r11)
            goto L_0x016c
        L_0x015d:
            r4 = 22
            if (r3 > r4) goto L_0x016c
            java.lang.String r3 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r3 = usesScheduler(r0, r3)
            if (r3 == 0) goto L_0x016c
            tryDelegateConstrainedWorkSpec(r11)
        L_0x016c:
            androidx.work.WorkInfo$State r3 = r11.state
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo$State.ENQUEUED
            if (r3 != r4) goto L_0x0174
            r16 = 1
        L_0x0174:
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            r3.insertWorkSpec(r11)
            if (r9 == 0) goto L_0x0196
            int r3 = r1.length
            r4 = 0
        L_0x017f:
            if (r4 >= r3) goto L_0x0196
            r5 = r1[r4]
            androidx.work.impl.model.Dependency r11 = new androidx.work.impl.model.Dependency
            java.lang.String r15 = r10.getStringId()
            r11.<init>(r15, r5)
            androidx.work.impl.model.DependencyDao r5 = r6.dependencyDao()
            r5.insertDependency(r11)
            int r4 = r4 + 1
            goto L_0x017f
        L_0x0196:
            java.util.Set r3 = r10.getTags()
            java.util.Iterator r3 = r3.iterator()
        L_0x019e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01bb
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.model.WorkTagDao r5 = r6.workTagDao()
            androidx.work.impl.model.WorkTag r11 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r10.getStringId()
            r11.<init>(r4, r15)
            r5.insert(r11)
            goto L_0x019e
        L_0x01bb:
            if (r7 == 0) goto L_0x01cd
            androidx.work.impl.model.WorkNameDao r3 = r6.workNameDao()
            androidx.work.impl.model.WorkName r4 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r10.getStringId()
            r4.<init>(r2, r5)
            r3.insert(r4)
        L_0x01cd:
            r4 = r17
            r3 = 0
            goto L_0x0117
        L_0x01d2:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            String str = workSpec.workerClassName;
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input);
            builder.putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    private static boolean usesScheduler(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }
}
