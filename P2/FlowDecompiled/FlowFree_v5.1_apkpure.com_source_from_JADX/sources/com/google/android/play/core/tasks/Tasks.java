package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C2075ax;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class Tasks {
    /* renamed from: a */
    public static <ResultT> Task<ResultT> m5430a(ResultT resultt) {
        C2176m mVar = new C2176m();
        mVar.mo22199a(resultt);
        return mVar;
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        C2075ax.m5194d(task, "Task must not be null");
        if (task.isComplete()) {
            return m5432c(task);
        }
        C2177n nVar = new C2177n((byte[]) null);
        m5433d(task, nVar);
        nVar.mo22203a();
        return m5432c(task);
    }

    /* renamed from: b */
    public static <ResultT> Task<ResultT> m5431b(Exception exc) {
        C2176m mVar = new C2176m();
        mVar.mo22201c(exc);
        return mVar;
    }

    /* renamed from: c */
    private static <ResultT> ResultT m5432c(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: d */
    private static void m5433d(Task<?> task, C2177n nVar) {
        Executor executor = TaskExecutors.f5299a;
        task.addOnSuccessListener(executor, nVar);
        task.addOnFailureListener(executor, nVar);
    }
}
