package androidx.media2.widget;

import android.view.Surface;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.SessionCommandGroup;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

class PlayerWrapper {
    private final SessionCommandGroup mAllCommands;
    SessionCommandGroup mAllowedCommands;
    private boolean mCallbackAttached;
    private final Executor mCallbackExecutor;
    final MediaController mController;
    private final MediaControllerCallback mControllerCallback;
    MediaMetadata mMediaMetadata;
    final SessionPlayer mPlayer;
    private final SessionPlayerCallback mPlayerCallback;
    int mSavedPlayerState = 0;
    final PlayerCallback mWrapperCallback;

    PlayerWrapper(MediaController mediaController, Executor executor, PlayerCallback playerCallback) {
        Objects.requireNonNull(mediaController, "controller must not be null");
        Objects.requireNonNull(executor, "executor must not be null");
        Objects.requireNonNull(playerCallback, "callback must not be null");
        this.mCallbackExecutor = executor;
        this.mWrapperCallback = playerCallback;
        this.mControllerCallback = new MediaControllerCallback(this);
        this.mPlayer = null;
        this.mPlayerCallback = null;
        this.mAllCommands = null;
    }

    PlayerWrapper(SessionPlayer sessionPlayer, Executor executor, PlayerCallback playerCallback) {
        Objects.requireNonNull(sessionPlayer, "player must not be null");
        Objects.requireNonNull(executor, "executor must not be null");
        Objects.requireNonNull(playerCallback, "callback must not be null");
        this.mPlayer = sessionPlayer;
        this.mCallbackExecutor = executor;
        this.mWrapperCallback = playerCallback;
        this.mPlayerCallback = new SessionPlayerCallback();
        this.mControllerCallback = null;
        SessionCommandGroup.Builder builder = new SessionCommandGroup.Builder();
        builder.addAllPredefinedCommands(1);
        this.mAllCommands = builder.build();
    }

    /* access modifiers changed from: package-private */
    public boolean hasDisconnectedController() {
        MediaController mediaController = this.mController;
        return mediaController != null && !mediaController.isConnected();
    }

    /* access modifiers changed from: package-private */
    public void attachCallback() {
        if (!this.mCallbackAttached) {
            MediaController mediaController = this.mController;
            if (mediaController == null) {
                SessionPlayer sessionPlayer = this.mPlayer;
                if (sessionPlayer != null) {
                    sessionPlayer.registerPlayerCallback(this.mCallbackExecutor, this.mPlayerCallback);
                }
                updateAndNotifyCachedStates();
                this.mCallbackAttached = true;
                return;
            }
            mediaController.registerExtraCallback(this.mCallbackExecutor, this.mControllerCallback);
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public void detachCallback() {
        if (this.mCallbackAttached) {
            MediaController mediaController = this.mController;
            if (mediaController == null) {
                SessionPlayer sessionPlayer = this.mPlayer;
                if (sessionPlayer != null) {
                    sessionPlayer.unregisterPlayerCallback(this.mPlayerCallback);
                }
                this.mCallbackAttached = false;
                return;
            }
            mediaController.unregisterExtraCallback(this.mControllerCallback);
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isPlaying() {
        return this.mSavedPlayerState == 2;
    }

    /* access modifiers changed from: package-private */
    public long getCurrentPosition() {
        if (this.mSavedPlayerState == 0) {
            return 0;
        }
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            long currentPosition = sessionPlayer != null ? sessionPlayer.getCurrentPosition() : 0;
            if (currentPosition < 0) {
                return 0;
            }
            return currentPosition;
        }
        mediaController.getCurrentPosition();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public long getBufferPercentage() {
        if (this.mSavedPlayerState == 0) {
            return 0;
        }
        long durationMs = getDurationMs();
        if (durationMs == 0) {
            return 0;
        }
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            long bufferedPosition = sessionPlayer != null ? sessionPlayer.getBufferedPosition() : 0;
            if (bufferedPosition < 0) {
                return 0;
            }
            return (bufferedPosition * 100) / durationMs;
        }
        mediaController.getBufferedPosition();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int getPlayerState() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getPlayerState();
            }
            return 0;
        }
        mediaController.getPlayerState();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public boolean canPause() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(10001);
    }

    /* access modifiers changed from: package-private */
    public boolean canSeekBackward() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(40001);
    }

    /* access modifiers changed from: package-private */
    public boolean canSeekForward() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(40000);
    }

    /* access modifiers changed from: package-private */
    public boolean canSkipToNext() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(10009);
    }

    /* access modifiers changed from: package-private */
    public boolean canSkipToPrevious() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(10008);
    }

    /* access modifiers changed from: package-private */
    public boolean canSeekTo() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(10003);
    }

    /* access modifiers changed from: package-private */
    public boolean canSelectDeselectTrack() {
        SessionCommandGroup sessionCommandGroup = this.mAllowedCommands;
        return sessionCommandGroup != null && sessionCommandGroup.hasCommand(11001) && this.mAllowedCommands.hasCommand(11002);
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.pause();
                return;
            }
            return;
        }
        mediaController.pause();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void play() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.play();
                return;
            }
            return;
        }
        mediaController.play();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void seekTo(long j) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.seekTo(j);
                return;
            }
            return;
        }
        mediaController.seekTo(j);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void skipToNextItem() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.skipToNextPlaylistItem();
                return;
            }
            return;
        }
        mediaController.skipToNextPlaylistItem();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void skipToPreviousItem() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.skipToPreviousPlaylistItem();
                return;
            }
            return;
        }
        mediaController.skipToPreviousPlaylistItem();
        throw null;
    }

    private float getPlaybackSpeed() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getPlaybackSpeed();
            }
            return 1.0f;
        }
        mediaController.getPlaybackSpeed();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void setPlaybackSpeed(float f) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.setPlaybackSpeed(f);
                return;
            }
            return;
        }
        mediaController.setPlaybackSpeed(f);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void selectTrack(SessionPlayer.TrackInfo trackInfo) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.selectTrackInternal(trackInfo);
                return;
            }
            return;
        }
        mediaController.selectTrack(trackInfo);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void deselectTrack(SessionPlayer.TrackInfo trackInfo) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                sessionPlayer.deselectTrackInternal(trackInfo);
                return;
            }
            return;
        }
        mediaController.deselectTrack(trackInfo);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public long getDurationMs() {
        if (this.mSavedPlayerState == 0) {
            return 0;
        }
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            long duration = sessionPlayer != null ? sessionPlayer.getDuration() : 0;
            if (duration < 0) {
                return 0;
            }
            return duration;
        }
        mediaController.getDuration();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getTitle() {
        MediaMetadata mediaMetadata = this.mMediaMetadata;
        if (mediaMetadata == null || !mediaMetadata.containsKey("android.media.metadata.TITLE")) {
            return null;
        }
        return this.mMediaMetadata.getText("android.media.metadata.TITLE");
    }

    /* access modifiers changed from: package-private */
    public CharSequence getArtistText() {
        MediaMetadata mediaMetadata = this.mMediaMetadata;
        if (mediaMetadata == null || !mediaMetadata.containsKey("android.media.metadata.ARTIST")) {
            return null;
        }
        return this.mMediaMetadata.getText("android.media.metadata.ARTIST");
    }

    /* access modifiers changed from: package-private */
    public MediaItem getCurrentMediaItem() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getCurrentMediaItem();
            }
            return null;
        }
        mediaController.getCurrentMediaItem();
        throw null;
    }

    private SessionCommandGroup getAllowedCommands() {
        MediaController mediaController = this.mController;
        if (mediaController != null) {
            return mediaController.getAllowedCommands();
        }
        if (this.mPlayer != null) {
            return this.mAllCommands;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void updateAndNotifyCachedStates() {
        boolean z;
        MediaMetadata mediaMetadata;
        int playerState = getPlayerState();
        boolean z2 = true;
        if (this.mSavedPlayerState != playerState) {
            this.mSavedPlayerState = playerState;
            z = true;
        } else {
            z = false;
        }
        SessionCommandGroup allowedCommands = getAllowedCommands();
        if (this.mAllowedCommands != allowedCommands) {
            this.mAllowedCommands = allowedCommands;
        } else {
            z2 = false;
        }
        MediaItem currentMediaItem = getCurrentMediaItem();
        if (currentMediaItem == null) {
            mediaMetadata = null;
        } else {
            mediaMetadata = currentMediaItem.getMetadata();
        }
        this.mMediaMetadata = mediaMetadata;
        if (z) {
            this.mWrapperCallback.onPlayerStateChanged(this, playerState);
        }
        if (allowedCommands != null && z2) {
            this.mWrapperCallback.onAllowedCommandsChanged(this, allowedCommands);
        }
        this.mWrapperCallback.onCurrentMediaItemChanged(this, currentMediaItem);
        notifyNonCachedStates();
    }

    /* access modifiers changed from: package-private */
    public VideoSize getVideoSize() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getVideoSizeInternal();
            }
            return new VideoSize(0, 0);
        }
        mediaController.getVideoSize();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public List<SessionPlayer.TrackInfo> getTrackInfo() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getTrackInfoInternal();
            }
            return Collections.emptyList();
        }
        mediaController.getTrackInfo();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getSelectedTrackInternal(i);
            }
            return null;
        }
        mediaController.getSelectedTrack(i);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<? extends BaseResult> setSurface(Surface surface) {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.setSurfaceInternal(surface);
            }
            return null;
        }
        mediaController.setSurface(surface);
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int getPreviousMediaItemIndex() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getPreviousMediaItemIndex();
            }
            return -1;
        }
        mediaController.getPreviousMediaItemIndex();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int getNextMediaItemIndex() {
        MediaController mediaController = this.mController;
        if (mediaController == null) {
            SessionPlayer sessionPlayer = this.mPlayer;
            if (sessionPlayer != null) {
                return sessionPlayer.getNextMediaItemIndex();
            }
            return -1;
        }
        mediaController.getNextMediaItemIndex();
        throw null;
    }

    private class MediaControllerCallback extends MediaController.ControllerCallback {
        MediaControllerCallback(PlayerWrapper playerWrapper) {
        }
    }

    private void notifyNonCachedStates() {
        this.mWrapperCallback.onPlaybackSpeedChanged(this, getPlaybackSpeed());
        List<SessionPlayer.TrackInfo> trackInfo = getTrackInfo();
        if (trackInfo != null) {
            this.mWrapperCallback.onTrackInfoChanged(this, trackInfo);
        }
        MediaItem currentMediaItem = getCurrentMediaItem();
        if (currentMediaItem != null) {
            this.mWrapperCallback.onVideoSizeChanged(this, currentMediaItem, getVideoSize());
        }
    }

    private class SessionPlayerCallback extends SessionPlayer.PlayerCallback {
        SessionPlayerCallback() {
        }

        public void onPlayerStateChanged(SessionPlayer sessionPlayer, int i) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            if (playerWrapper.mSavedPlayerState != i) {
                playerWrapper.mSavedPlayerState = i;
                playerWrapper.mWrapperCallback.onPlayerStateChanged(playerWrapper, i);
            }
        }

        public void onPlaybackSpeedChanged(SessionPlayer sessionPlayer, float f) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onPlaybackSpeedChanged(playerWrapper, f);
        }

        public void onSeekCompleted(SessionPlayer sessionPlayer, long j) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onSeekCompleted(playerWrapper, j);
        }

        public void onCurrentMediaItemChanged(SessionPlayer sessionPlayer, MediaItem mediaItem) {
            PlayerWrapper.this.mMediaMetadata = mediaItem == null ? null : mediaItem.getMetadata();
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onCurrentMediaItemChanged(playerWrapper, mediaItem);
        }

        public void onPlaylistChanged(SessionPlayer sessionPlayer, List<MediaItem> list, MediaMetadata mediaMetadata) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onPlaylistChanged(playerWrapper, list, mediaMetadata);
        }

        public void onPlaybackCompleted(SessionPlayer sessionPlayer) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onPlaybackCompleted(playerWrapper);
        }

        public void onVideoSizeChangedInternal(SessionPlayer sessionPlayer, MediaItem mediaItem, VideoSize videoSize) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onVideoSizeChanged(playerWrapper, mediaItem, videoSize);
        }

        public void onSubtitleData(SessionPlayer sessionPlayer, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onSubtitleData(playerWrapper, mediaItem, trackInfo, subtitleData);
        }

        public void onTrackInfoChanged(SessionPlayer sessionPlayer, List<SessionPlayer.TrackInfo> list) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onTrackInfoChanged(playerWrapper, list);
        }

        public void onTrackSelected(SessionPlayer sessionPlayer, SessionPlayer.TrackInfo trackInfo) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onTrackSelected(playerWrapper, trackInfo);
        }

        public void onTrackDeselected(SessionPlayer sessionPlayer, SessionPlayer.TrackInfo trackInfo) {
            PlayerWrapper playerWrapper = PlayerWrapper.this;
            playerWrapper.mWrapperCallback.onTrackDeselected(playerWrapper, trackInfo);
        }
    }

    static abstract class PlayerCallback {
        /* access modifiers changed from: package-private */
        public void onAllowedCommandsChanged(PlayerWrapper playerWrapper, SessionCommandGroup sessionCommandGroup) {
        }

        /* access modifiers changed from: package-private */
        public abstract void onCurrentMediaItemChanged(PlayerWrapper playerWrapper, MediaItem mediaItem);

        /* access modifiers changed from: package-private */
        public void onPlaybackCompleted(PlayerWrapper playerWrapper) {
        }

        /* access modifiers changed from: package-private */
        public void onPlaybackSpeedChanged(PlayerWrapper playerWrapper, float f) {
        }

        /* access modifiers changed from: package-private */
        public abstract void onPlayerStateChanged(PlayerWrapper playerWrapper, int i);

        /* access modifiers changed from: package-private */
        public void onPlaylistChanged(PlayerWrapper playerWrapper, List<MediaItem> list, MediaMetadata mediaMetadata) {
        }

        /* access modifiers changed from: package-private */
        public void onSeekCompleted(PlayerWrapper playerWrapper, long j) {
        }

        /* access modifiers changed from: package-private */
        public void onSubtitleData(PlayerWrapper playerWrapper, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
        }

        /* access modifiers changed from: package-private */
        public abstract void onTrackDeselected(PlayerWrapper playerWrapper, SessionPlayer.TrackInfo trackInfo);

        /* access modifiers changed from: package-private */
        public abstract void onTrackInfoChanged(PlayerWrapper playerWrapper, List<SessionPlayer.TrackInfo> list);

        /* access modifiers changed from: package-private */
        public abstract void onTrackSelected(PlayerWrapper playerWrapper, SessionPlayer.TrackInfo trackInfo);

        /* access modifiers changed from: package-private */
        public abstract void onVideoSizeChanged(PlayerWrapper playerWrapper, MediaItem mediaItem, VideoSize videoSize);

        PlayerCallback() {
        }
    }
}
