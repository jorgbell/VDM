package androidx.media2.player.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.SubtitleData;
import androidx.media2.player.MediaPlayer2;
import androidx.media2.player.MediaTimestamp;
import androidx.media2.player.PlaybackParams;
import androidx.media2.player.TimedMetaData;
import androidx.media2.player.exoplayer.ExoPlayerWrapper;
import androidx.media2.player.futures.ResolvableFuture;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@SuppressLint({"RestrictedApi"})
public final class ExoPlayerMediaPlayer2Impl extends MediaPlayer2 implements ExoPlayerWrapper.Listener {
    Task mCurrentTask;
    private Pair<Executor, MediaPlayer2.EventCallback> mExecutorAndEventCallback;
    private HandlerThread mHandlerThread;
    final Object mLock = new Object();
    final ArrayDeque<Task> mPendingTasks = new ArrayDeque<>();
    final ExoPlayerWrapper mPlayer;
    private final Handler mTaskHandler;
    final Object mTaskLock = new Object();

    private interface Mp2EventNotifier {
        void notify(MediaPlayer2.EventCallback eventCallback);
    }

    public ExoPlayerMediaPlayer2Impl(Context context) {
        HandlerThread handlerThread = new HandlerThread("ExoMediaPlayer2Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        ExoPlayerWrapper exoPlayerWrapper = new ExoPlayerWrapper(context.getApplicationContext(), this, this.mHandlerThread.getLooper());
        this.mPlayer = exoPlayerWrapper;
        this.mTaskHandler = new Handler(exoPlayerWrapper.getLooper());
        resetPlayer();
    }

    public void clearPendingCommands() {
        synchronized (this.mTaskLock) {
            this.mPendingTasks.clear();
        }
    }

    public boolean cancel(Object obj) {
        boolean remove;
        synchronized (this.mTaskLock) {
            remove = this.mPendingTasks.remove(obj);
        }
        return remove;
    }

    private Object addTask(Task task) {
        synchronized (this.mTaskLock) {
            this.mPendingTasks.add(task);
            processPendingTask();
        }
        return task;
    }

    /* access modifiers changed from: package-private */
    public void processPendingTask() {
        if (this.mCurrentTask == null && !this.mPendingTasks.isEmpty()) {
            Task removeFirst = this.mPendingTasks.removeFirst();
            this.mCurrentTask = removeFirst;
            this.mTaskHandler.post(removeFirst);
        }
    }

    public void setEventCallback(Executor executor, MediaPlayer2.EventCallback eventCallback) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(eventCallback);
        synchronized (this.mLock) {
            this.mExecutorAndEventCallback = Pair.create(executor, eventCallback);
        }
    }

    public void clearEventCallback() {
        synchronized (this.mLock) {
            this.mExecutorAndEventCallback = null;
        }
    }

    public void setDrmEventCallback(Executor executor, MediaPlayer2.DrmEventCallback drmEventCallback) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(drmEventCallback);
        synchronized (this.mLock) {
            Pair.create(executor, drmEventCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyMediaPlayer2Event(final Mp2EventNotifier mp2EventNotifier) {
        Pair<Executor, MediaPlayer2.EventCallback> pair;
        synchronized (this.mLock) {
            pair = this.mExecutorAndEventCallback;
        }
        if (pair != null) {
            Executor executor = (Executor) pair.first;
            final MediaPlayer2.EventCallback eventCallback = (MediaPlayer2.EventCallback) pair.second;
            try {
                executor.execute(new Runnable(this) {
                    public void run() {
                        mp2EventNotifier.notify(eventCallback);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Log.w("ExoPlayerMediaPlayer2", "The given executor is shutting down. Ignoring the player event.");
            }
        }
    }

    public Object setMediaItem(final MediaItem mediaItem) {
        C03314 r0 = new Task(19, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setMediaItem(mediaItem);
            }
        };
        addTask(r0);
        return r0;
    }

    public MediaItem getCurrentMediaItem() {
        return (MediaItem) runPlayerCallableBlocking(new Callable<MediaItem>() {
            public MediaItem call() throws Exception {
                return ExoPlayerMediaPlayer2Impl.this.mPlayer.getCurrentMediaItem();
            }
        });
    }

    public Object prepare() {
        C03396 r0 = new Task(6, true) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.prepare();
            }
        };
        addTask(r0);
        return r0;
    }

    public Object play() {
        C03407 r0 = new Task(5, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.play();
            }
        };
        addTask(r0);
        return r0;
    }

    public Object pause() {
        C03418 r0 = new Task(4, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.pause();
            }
        };
        addTask(r0);
        return r0;
    }

    public Object seekTo(long j, int i) {
        final long j2 = j;
        final int i2 = i;
        C03429 r0 = new Task(14, true) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.seekTo(j2, i2);
            }
        };
        addTask(r0);
        return r0;
    }

    public long getCurrentPosition() {
        return ((Long) runPlayerCallableBlocking(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getCurrentPosition());
            }
        })).longValue();
    }

    public long getDuration() {
        return ((Long) runPlayerCallableBlocking(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getDuration());
            }
        })).longValue();
    }

    public long getBufferedPosition() {
        return ((Long) runPlayerCallableBlocking(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getBufferedPosition());
            }
        })).longValue();
    }

    public Object skipToNext() {
        C031115 r0 = new Task(29, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.skipToNext();
            }
        };
        addTask(r0);
        return r0;
    }

    public Object setNextMediaItem(final MediaItem mediaItem) {
        C031216 r0 = new Task(22, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setNextMediaItem(mediaItem);
            }
        };
        addTask(r0);
        return r0;
    }

    public Object setAudioAttributes(final AudioAttributesCompat audioAttributesCompat) {
        C031318 r0 = new Task(16, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setAudioAttributes(audioAttributesCompat);
            }
        };
        addTask(r0);
        return r0;
    }

    public AudioAttributesCompat getAudioAttributes() {
        return (AudioAttributesCompat) runPlayerCallableBlocking(new Callable<AudioAttributesCompat>() {
            public AudioAttributesCompat call() throws Exception {
                return ExoPlayerMediaPlayer2Impl.this.mPlayer.getAudioAttributes();
            }
        });
    }

    public Object setPlaybackParams(final PlaybackParams playbackParams) {
        C031623 r0 = new Task(24, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setPlaybackParams(playbackParams);
            }
        };
        addTask(r0);
        return r0;
    }

    public PlaybackParams getPlaybackParams() {
        return (PlaybackParams) runPlayerCallableBlocking(new Callable<PlaybackParams>() {
            public PlaybackParams call() throws Exception {
                return ExoPlayerMediaPlayer2Impl.this.mPlayer.getPlaybackParams();
            }
        });
    }

    public int getVideoWidth() {
        return ((Integer) runPlayerCallableBlocking(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getVideoWidth());
            }
        })).intValue();
    }

    public int getVideoHeight() {
        return ((Integer) runPlayerCallableBlocking(new Callable<Integer>() {
            public Integer call() throws Exception {
                return Integer.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getVideoHeight());
            }
        })).intValue();
    }

    public Object setSurface(final Surface surface) {
        C032027 r0 = new Task(27, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setSurface(surface);
            }
        };
        addTask(r0);
        return r0;
    }

    public Object setPlayerVolume(final float f) {
        C032128 r0 = new Task(26, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.setVolume(f);
            }
        };
        addTask(r0);
        return r0;
    }

    public float getPlayerVolume() {
        return ((Float) runPlayerCallableBlocking(new Callable<Float>() {
            public Float call() throws Exception {
                return Float.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getVolume());
            }
        })).floatValue();
    }

    public List<MediaPlayer2.TrackInfo> getTrackInfo() {
        return (List) runPlayerCallableBlocking(new Callable<List<MediaPlayer2.TrackInfo>>() {
            public List<MediaPlayer2.TrackInfo> call() throws Exception {
                return ExoPlayerMediaPlayer2Impl.this.mPlayer.getTrackInfo();
            }
        });
    }

    public int getSelectedTrack(final int i) {
        return ((Integer) runPlayerCallableBlocking(new Callable<Integer>() {
            public Integer call() {
                return Integer.valueOf(ExoPlayerMediaPlayer2Impl.this.mPlayer.getSelectedTrack(i));
            }
        })).intValue();
    }

    public Object selectTrack(final int i) {
        C032532 r0 = new Task(15, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.selectTrack(i);
            }
        };
        addTask(r0);
        return r0;
    }

    public Object deselectTrack(final int i) {
        C032633 r0 = new Task(2, false) {
            /* access modifiers changed from: package-private */
            public void process() {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.deselectTrack(i);
            }
        };
        addTask(r0);
        return r0;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reset() {
        /*
            r2 = this;
            r2.clearPendingCommands()
            java.lang.Object r0 = r2.mTaskLock
            monitor-enter(r0)
            androidx.media2.player.exoplayer.ExoPlayerMediaPlayer2Impl$Task r1 = r2.mCurrentTask     // Catch:{ all -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x001a
            monitor-enter(r1)
        L_0x000c:
            boolean r0 = r1.mDone     // Catch:{ InterruptedException -> 0x0016 }
            if (r0 != 0) goto L_0x0016
            r1.wait()     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x000c
        L_0x0014:
            r0 = move-exception
            goto L_0x0018
        L_0x0016:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            goto L_0x001a
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r0
        L_0x001a:
            android.os.Handler r0 = r2.mTaskHandler
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            androidx.media2.player.exoplayer.ExoPlayerMediaPlayer2Impl$36 r0 = new androidx.media2.player.exoplayer.ExoPlayerMediaPlayer2Impl$36
            r0.<init>()
            r2.runPlayerCallableBlocking(r0)
            return
        L_0x0029:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x002c:
            throw r1
        L_0x002d:
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.player.exoplayer.ExoPlayerMediaPlayer2Impl.reset():void");
    }

    public void close() {
        clearEventCallback();
        synchronized (this.mLock) {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                this.mHandlerThread = null;
                runPlayerCallableBlocking(new Callable<Void>() {
                    public Void call() {
                        ExoPlayerMediaPlayer2Impl.this.mPlayer.close();
                        return null;
                    }
                });
                handlerThread.quit();
            }
        }
    }

    public void onPrepared(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 100);
        synchronized (this.mTaskLock) {
            Task task = this.mCurrentTask;
            if (task != null && task.mMediaCallType == 6 && ObjectsCompat.equals(task.mDSD, mediaItem)) {
                Task task2 = this.mCurrentTask;
                if (task2.mNeedToWaitForEventToComplete) {
                    task2.sendCompleteNotification(0);
                    this.mCurrentTask = null;
                    processPendingTask();
                }
            }
        }
    }

    public void onMetadataChanged(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 802);
    }

    public void onSeekCompleted() {
        synchronized (this.mTaskLock) {
            Task task = this.mCurrentTask;
            if (task != null && task.mMediaCallType == 14 && task.mNeedToWaitForEventToComplete) {
                task.sendCompleteNotification(0);
                this.mCurrentTask = null;
                processPendingTask();
            }
        }
    }

    public void onBufferingStarted(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 701);
    }

    public void onBufferingEnded(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 702);
    }

    public void onBufferingUpdate(MediaItem mediaItem, int i) {
        notifyOnInfo(mediaItem, 704, i);
    }

    public void onBandwidthSample(MediaItem mediaItem, int i) {
        notifyOnInfo(mediaItem, 703, i);
    }

    public void onVideoRenderingStart(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 3);
    }

    public void onVideoSizeChanged(final MediaItem mediaItem, final int i, final int i2) {
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onVideoSizeChanged(ExoPlayerMediaPlayer2Impl.this, mediaItem, i, i2);
            }
        });
    }

    public void onSubtitleData(final MediaItem mediaItem, final int i, final SubtitleData subtitleData) {
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onSubtitleData(ExoPlayerMediaPlayer2Impl.this, mediaItem, i, subtitleData);
            }
        });
    }

    public void onTimedMetadata(final MediaItem mediaItem, final TimedMetaData timedMetaData) {
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onTimedMetaDataAvailable(ExoPlayerMediaPlayer2Impl.this, mediaItem, timedMetaData);
            }
        });
    }

    public void onMediaItemStartedAsNext(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 2);
    }

    public void onMediaItemEnded(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 5);
    }

    public void onLoop(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 7);
    }

    public void onMediaTimeDiscontinuity(final MediaItem mediaItem, final MediaTimestamp mediaTimestamp) {
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onMediaTimeDiscontinuity(ExoPlayerMediaPlayer2Impl.this, mediaItem, mediaTimestamp);
            }
        });
    }

    public void onPlaybackEnded(MediaItem mediaItem) {
        notifyOnInfo(mediaItem, 6);
    }

    public void onError(final MediaItem mediaItem, final int i) {
        synchronized (this.mTaskLock) {
            Task task = this.mCurrentTask;
            if (task != null && task.mNeedToWaitForEventToComplete) {
                task.sendCompleteNotification(Integer.MIN_VALUE);
                this.mCurrentTask = null;
                processPendingTask();
            }
        }
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onError(ExoPlayerMediaPlayer2Impl.this, mediaItem, i, 0);
            }
        });
    }

    private void notifyOnInfo(MediaItem mediaItem, int i) {
        notifyOnInfo(mediaItem, i, 0);
    }

    private void notifyOnInfo(final MediaItem mediaItem, final int i, final int i2) {
        notifyMediaPlayer2Event(new Mp2EventNotifier() {
            public void notify(MediaPlayer2.EventCallback eventCallback) {
                eventCallback.onInfo(ExoPlayerMediaPlayer2Impl.this, mediaItem, i, i2);
            }
        });
    }

    private void resetPlayer() {
        runPlayerCallableBlocking(new Callable<Void>() {
            public Void call() throws Exception {
                ExoPlayerMediaPlayer2Impl.this.mPlayer.reset();
                return null;
            }
        });
    }

    private <T> T runPlayerCallableBlocking(final Callable<T> callable) {
        T t;
        final ResolvableFuture create = ResolvableFuture.create();
        Preconditions.checkState(this.mTaskHandler.post(new Runnable(this) {
            public void run() {
                try {
                    create.set(callable.call());
                } catch (Throwable th) {
                    create.setException(th);
                }
            }
        }));
        boolean z = false;
        while (true) {
            try {
                t = create.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            try {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                Log.e("ExoPlayerMediaPlayer2", "Internal player error", new RuntimeException(cause));
                throw new IllegalStateException(cause);
            }
        }
        return t;
    }

    private abstract class Task implements Runnable {
        MediaItem mDSD;
        boolean mDone;
        final int mMediaCallType;
        final boolean mNeedToWaitForEventToComplete;

        /* access modifiers changed from: package-private */
        public abstract void process() throws IOException, MediaPlayer2.NoDrmSchemeException;

        Task(int i, boolean z) {
            this.mMediaCallType = i;
            this.mNeedToWaitForEventToComplete = z;
        }

        public void run() {
            boolean z;
            int i = 0;
            if (this.mMediaCallType == 14) {
                synchronized (ExoPlayerMediaPlayer2Impl.this.mTaskLock) {
                    Task peekFirst = ExoPlayerMediaPlayer2Impl.this.mPendingTasks.peekFirst();
                    z = peekFirst != null && peekFirst.mMediaCallType == 14;
                }
            } else {
                z = false;
            }
            if (!z) {
                try {
                    if (this.mMediaCallType == 1000 || !ExoPlayerMediaPlayer2Impl.this.mPlayer.hasError()) {
                        process();
                    } else {
                        i = 1;
                    }
                } catch (IllegalStateException unused) {
                } catch (IllegalArgumentException unused2) {
                    i = 2;
                } catch (SecurityException unused3) {
                    i = 3;
                } catch (IOException unused4) {
                    i = 4;
                } catch (Exception unused5) {
                    i = Integer.MIN_VALUE;
                }
            } else {
                i = 5;
            }
            this.mDSD = ExoPlayerMediaPlayer2Impl.this.mPlayer.getCurrentMediaItem();
            if (!this.mNeedToWaitForEventToComplete || i != 0 || z) {
                sendCompleteNotification(i);
                synchronized (ExoPlayerMediaPlayer2Impl.this.mTaskLock) {
                    ExoPlayerMediaPlayer2Impl exoPlayerMediaPlayer2Impl = ExoPlayerMediaPlayer2Impl.this;
                    exoPlayerMediaPlayer2Impl.mCurrentTask = null;
                    exoPlayerMediaPlayer2Impl.processPendingTask();
                }
            }
            synchronized (this) {
                this.mDone = true;
                notifyAll();
            }
        }

        /* access modifiers changed from: package-private */
        public void sendCompleteNotification(final int i) {
            if (this.mMediaCallType < 1000) {
                ExoPlayerMediaPlayer2Impl.this.notifyMediaPlayer2Event(new Mp2EventNotifier() {
                    public void notify(MediaPlayer2.EventCallback eventCallback) {
                        Task task = Task.this;
                        eventCallback.onCallCompleted(ExoPlayerMediaPlayer2Impl.this, task.mDSD, task.mMediaCallType, i);
                    }
                });
            }
        }
    }
}
