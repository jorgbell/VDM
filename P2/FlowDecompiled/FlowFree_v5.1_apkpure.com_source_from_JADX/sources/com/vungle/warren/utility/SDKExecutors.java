package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SDKExecutors implements Executors {
    private static final ThreadPoolExecutor API_EXECUTOR;
    private static final ExecutorService BACKGROUND_EXECUTOR;
    private static final ExecutorService IO_EXECUTOR;
    private static final ExecutorService JOB_EXECUTOR;
    private static final ExecutorService LOGGER_EXECUTOR;
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService UI_EXECUTOR;

    static {
        C30691 r0 = new AbstractExecutorService() {
            private final Handler UIHandler = new Handler(Looper.getMainLooper());

            public boolean awaitTermination(long j, TimeUnit timeUnit) {
                return false;
            }

            public boolean isShutdown() {
                return false;
            }

            public boolean isTerminated() {
                return false;
            }

            public void shutdown() {
            }

            public List<Runnable> shutdownNow() {
                return null;
            }

            public void execute(Runnable runnable) {
                this.UIHandler.post(runnable);
            }
        };
        int i = NUMBER_OF_CORES;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1, timeUnit, new PriorityBlockingQueue(), new NamedThreadFactory("vng_jr"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        TimeUnit timeUnit2 = timeUnit;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 5, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 5, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_logger"));
        threadPoolExecutor3.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
        threadPoolExecutor4.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_api"));
        threadPoolExecutor5.allowCoreThreadTimeOut(true);
        UI_EXECUTOR = r0;
        JOB_EXECUTOR = threadPoolExecutor;
        IO_EXECUTOR = threadPoolExecutor2;
        BACKGROUND_EXECUTOR = threadPoolExecutor4;
        API_EXECUTOR = threadPoolExecutor5;
        LOGGER_EXECUTOR = threadPoolExecutor3;
    }

    public ExecutorService getUIExecutor() {
        return UI_EXECUTOR;
    }

    public ExecutorService getBackgroundExecutor() {
        return BACKGROUND_EXECUTOR;
    }

    public ExecutorService getIOExecutor() {
        return IO_EXECUTOR;
    }

    public ExecutorService getJobExecutor() {
        return JOB_EXECUTOR;
    }

    public ExecutorService getApiExecutor() {
        return API_EXECUTOR;
    }

    public ExecutorService getLoggerExecutor() {
        return LOGGER_EXECUTOR;
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private AtomicInteger atomicInteger = new AtomicInteger(0);
        private final String name;
        private ThreadFactory threadFactory = Executors.defaultThreadFactory();

        public NamedThreadFactory(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = this.threadFactory.newThread(runnable);
            newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
            return newThread;
        }
    }
}
