package org.cocos2dx.lib;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class Cocos2dxSound {
    private static final int MAX_SIMULTANEOUS_STREAMS_DEFAULT = 12;
    private static final int SOUND_PRIORITY = 1;
    private static final int SOUND_QUALITY = 0;
    private static final float SOUND_RATE = 1.0f;
    private static final String TAG = "Cocos2dxSound";
    private final int INVALID_SOUND_ID = -1;
    private final int INVALID_STREAM_ID = -1;
    private Context mContext;
    private float mLeftVolume;
    private HashMap<String, Integer> mPathSoundIDMap;
    private float mRightVolume;
    private HashMap<Integer, Integer> mSoundIdStreamIdMap;
    private SoundPool mSoundPool;

    public Cocos2dxSound(Context context) {
        this.mContext = context;
        initData();
    }

    public int preloadEffect(String str) {
        if (this.mPathSoundIDMap.get(str) != null) {
            return this.mPathSoundIDMap.get(str).intValue();
        }
        int createSoundIdFromAsset = createSoundIdFromAsset(str);
        if (createSoundIdFromAsset != -1) {
            this.mSoundIdStreamIdMap.put(Integer.valueOf(createSoundIdFromAsset), -1);
            this.mPathSoundIDMap.put(str, Integer.valueOf(createSoundIdFromAsset));
        }
        return createSoundIdFromAsset;
    }

    public void unloadEffect(String str) {
        Integer remove = this.mPathSoundIDMap.remove(str);
        if (remove != null) {
            this.mSoundPool.unload(remove.intValue());
            this.mSoundIdStreamIdMap.remove(remove);
        }
    }

    public int playEffect(String str, boolean z) {
        Integer num = this.mPathSoundIDMap.get(str);
        if (num != null) {
            this.mSoundPool.stop(num.intValue());
            this.mSoundIdStreamIdMap.put(num, Integer.valueOf(this.mSoundPool.play(num.intValue(), this.mLeftVolume, this.mRightVolume, 1, z ? -1 : 0, 1.0f)));
        } else {
            num = Integer.valueOf(preloadEffect(str));
            if (num.intValue() == -1) {
                return -1;
            }
            playEffect(str, z);
        }
        return num.intValue();
    }

    public void stopEffect(int i) {
        Integer num = this.mSoundIdStreamIdMap.get(Integer.valueOf(i));
        if (num != null && num.intValue() != -1) {
            this.mSoundPool.stop(num.intValue());
            this.mPathSoundIDMap.remove(Integer.valueOf(i));
        }
    }

    public void pauseEffect(int i) {
        Integer num = this.mSoundIdStreamIdMap.get(Integer.valueOf(i));
        if (num != null && num.intValue() != -1) {
            this.mSoundPool.pause(num.intValue());
            this.mPathSoundIDMap.remove(Integer.valueOf(i));
        }
    }

    public void resumeEffect(int i) {
        Integer num = this.mSoundIdStreamIdMap.get(Integer.valueOf(i));
        if (num != null && num.intValue() != -1) {
            this.mSoundPool.resume(num.intValue());
            this.mPathSoundIDMap.remove(Integer.valueOf(i));
        }
    }

    public void pauseAllEffects() {
        pauseOrResumeAllEffects(true);
    }

    public void resumeAllEffects() {
        pauseOrResumeAllEffects(false);
    }

    public void stopAllEffects() {
        for (Map.Entry<Integer, Integer> key : this.mSoundIdStreamIdMap.entrySet()) {
            stopEffect(((Integer) key.getKey()).intValue());
        }
    }

    public float getEffectsVolume() {
        return (this.mLeftVolume + this.mRightVolume) / 2.0f;
    }

    public void setEffectsVolume(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.mRightVolume = f;
        this.mLeftVolume = f;
        for (Map.Entry<Integer, Integer> value : this.mSoundIdStreamIdMap.entrySet()) {
            this.mSoundPool.setVolume(((Integer) value.getValue()).intValue(), this.mLeftVolume, this.mRightVolume);
        }
    }

    public void end() {
        this.mSoundPool.release();
        this.mPathSoundIDMap.clear();
        this.mSoundIdStreamIdMap.clear();
        initData();
    }

    public int createSoundIdFromAsset(String str) {
        try {
            return this.mSoundPool.load(this.mContext.getAssets().openFd(str), 0);
        } catch (Exception e) {
            Log.e(TAG, "error: " + e.getMessage(), e);
            return -1;
        }
    }

    private void initData() {
        this.mSoundIdStreamIdMap = new HashMap<>();
        this.mSoundPool = new SoundPool(12, 3, 0);
        this.mPathSoundIDMap = new HashMap<>();
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
    }

    private void pauseOrResumeAllEffects(boolean z) {
        for (Map.Entry<Integer, Integer> key : this.mSoundIdStreamIdMap.entrySet()) {
            int intValue = ((Integer) key.getKey()).intValue();
            if (z) {
                pauseEffect(intValue);
            } else {
                resumeEffect(intValue);
            }
        }
    }
}
