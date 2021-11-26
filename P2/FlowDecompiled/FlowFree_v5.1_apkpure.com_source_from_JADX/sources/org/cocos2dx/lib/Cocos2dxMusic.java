package org.cocos2dx.lib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

public class Cocos2dxMusic {
    private static final String TAG = "Cocos2dxMusic";
    private MediaPlayer mBackgroundMediaPlayer;
    private Context mContext;
    private String mCurrentPath;
    private boolean mIsPaused;
    private float mLeftVolume;
    private float mRightVolume;

    public Cocos2dxMusic(Context context) {
        this.mContext = context;
        initData();
    }

    public void preloadBackgroundMusic(String str) {
        String str2 = this.mCurrentPath;
        if (str2 == null || !str2.equals(str)) {
            createMediaplayerFromAssets(str);
            this.mCurrentPath = str;
        }
    }

    public void playBackgroundMusic(String str, boolean z) {
        Log.e(TAG, "playBackgroundMusic: trying to play: " + str);
        String str2 = this.mCurrentPath;
        if (str2 == null) {
            createMediaplayerFromAssets(str);
            this.mCurrentPath = str;
        } else if (!str2.equals(str)) {
            createMediaplayerFromAssets(str);
            this.mCurrentPath = str;
        }
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "playBackgroundMusic: background media player is null");
            return;
        }
        mediaPlayer.stop();
        this.mBackgroundMediaPlayer.setLooping(z);
        try {
            this.mBackgroundMediaPlayer.prepare();
            this.mBackgroundMediaPlayer.seekTo(0);
            this.mBackgroundMediaPlayer.start();
            this.mIsPaused = false;
        } catch (Exception unused) {
            Log.e(TAG, "playBackgroundMusic: error state");
        }
    }

    public void stopBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mIsPaused = false;
        }
    }

    public void pauseBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mBackgroundMediaPlayer.pause();
            this.mIsPaused = true;
        }
    }

    public void resumeBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null && this.mIsPaused) {
            mediaPlayer.start();
            this.mIsPaused = false;
        }
    }

    public void rewindBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            try {
                this.mBackgroundMediaPlayer.prepare();
                this.mBackgroundMediaPlayer.seekTo(0);
                this.mBackgroundMediaPlayer.start();
                this.mIsPaused = false;
            } catch (Exception unused) {
                Log.e(TAG, "rewindBackgroundMusic: error state");
            }
        }
    }

    public boolean isBackgroundMusicPlaying() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public void end() {
        initData();
    }

    public float getBackgroundVolume() {
        if (this.mBackgroundMediaPlayer != null) {
            return (this.mLeftVolume + this.mRightVolume) / 2.0f;
        }
        return 0.0f;
    }

    public void setBackgroundVolume(float f) {
        this.mRightVolume = f;
        this.mLeftVolume = f;
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    private void initData() {
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer == null) {
            this.mBackgroundMediaPlayer = new MediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        this.mIsPaused = false;
        this.mCurrentPath = null;
    }

    private void createMediaplayerFromAssets(String str) {
        try {
            AssetFileDescriptor openFd = this.mContext.getAssets().openFd(str);
            this.mBackgroundMediaPlayer.reset();
            this.mBackgroundMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            this.mBackgroundMediaPlayer.prepare();
            this.mBackgroundMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
        } catch (Exception e) {
            this.mBackgroundMediaPlayer = null;
            Log.e(TAG, "error: " + e.getMessage(), e);
        }
    }
}
