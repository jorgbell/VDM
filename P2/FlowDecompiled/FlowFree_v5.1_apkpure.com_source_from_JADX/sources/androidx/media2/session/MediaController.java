package androidx.media2.session;

import android.view.Surface;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.versionedparcelable.VersionedParcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

public class MediaController implements AutoCloseable {

    public static abstract class ControllerCallback {
    }

    public ListenableFuture<SessionResult> deselectTrack(SessionPlayer.TrackInfo trackInfo) {
        throw null;
    }

    public SessionCommandGroup getAllowedCommands() {
        throw null;
    }

    public long getBufferedPosition() {
        throw null;
    }

    public MediaItem getCurrentMediaItem() {
        throw null;
    }

    public long getCurrentPosition() {
        throw null;
    }

    public long getDuration() {
        throw null;
    }

    public int getNextMediaItemIndex() {
        throw null;
    }

    public float getPlaybackSpeed() {
        throw null;
    }

    public int getPlayerState() {
        throw null;
    }

    public int getPreviousMediaItemIndex() {
        throw null;
    }

    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        throw null;
    }

    public List<SessionPlayer.TrackInfo> getTrackInfo() {
        throw null;
    }

    public VideoSize getVideoSize() {
        throw null;
    }

    public boolean isConnected() {
        throw null;
    }

    public ListenableFuture<SessionResult> pause() {
        throw null;
    }

    public ListenableFuture<SessionResult> play() {
        throw null;
    }

    public void registerExtraCallback(Executor executor, ControllerCallback controllerCallback) {
        throw null;
    }

    public ListenableFuture<SessionResult> seekTo(long j) {
        throw null;
    }

    public ListenableFuture<SessionResult> selectTrack(SessionPlayer.TrackInfo trackInfo) {
        throw null;
    }

    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        throw null;
    }

    public ListenableFuture<SessionResult> setSurface(Surface surface) {
        throw null;
    }

    public ListenableFuture<SessionResult> skipToNextPlaylistItem() {
        throw null;
    }

    public ListenableFuture<SessionResult> skipToPreviousPlaylistItem() {
        throw null;
    }

    public void unregisterExtraCallback(ControllerCallback controllerCallback) {
        throw null;
    }

    public static final class PlaybackInfo implements VersionedParcelable {
        AudioAttributesCompat mAudioAttrsCompat;
        int mControlType;
        int mCurrentVolume;
        int mMaxVolume;
        int mPlaybackType;

        PlaybackInfo() {
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mPlaybackType), Integer.valueOf(this.mControlType), Integer.valueOf(this.mMaxVolume), Integer.valueOf(this.mCurrentVolume), this.mAudioAttrsCompat);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlaybackInfo)) {
                return false;
            }
            PlaybackInfo playbackInfo = (PlaybackInfo) obj;
            if (this.mPlaybackType == playbackInfo.mPlaybackType && this.mControlType == playbackInfo.mControlType && this.mMaxVolume == playbackInfo.mMaxVolume && this.mCurrentVolume == playbackInfo.mCurrentVolume && ObjectsCompat.equals(this.mAudioAttrsCompat, playbackInfo.mAudioAttrsCompat)) {
                return true;
            }
            return false;
        }
    }
}
