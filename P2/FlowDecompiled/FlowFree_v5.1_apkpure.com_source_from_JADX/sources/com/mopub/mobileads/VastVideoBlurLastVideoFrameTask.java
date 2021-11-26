package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {
    private Bitmap mBlurredLastVideoFrame;
    private final ImageView mBlurredLastVideoFrameImageView;
    private Bitmap mLastVideoFrame;
    private final MediaMetadataRetriever mMediaMetadataRetriever;
    private int mVideoDuration;

    public VastVideoBlurLastVideoFrameTask(MediaMetadataRetriever mediaMetadataRetriever, ImageView imageView, int i) {
        this.mMediaMetadataRetriever = mediaMetadataRetriever;
        this.mBlurredLastVideoFrameImageView = imageView;
        this.mVideoDuration = i;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return Boolean.FALSE;
        }
        try {
            this.mMediaMetadataRetriever.setDataSource(strArr[0]);
            Bitmap frameAtTime = this.mMediaMetadataRetriever.getFrameAtTime((long) ((this.mVideoDuration * 1000) - 200000), 3);
            this.mLastVideoFrame = frameAtTime;
            if (frameAtTime == null) {
                return Boolean.FALSE;
            }
            this.mBlurredLastVideoFrame = ImageUtils.applyFastGaussianBlurToBitmap(frameAtTime, 4);
            return Boolean.TRUE;
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Failed to blur last video frame", e);
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Boolean bool) {
        if (isCancelled()) {
            onCancelled();
        } else if (bool != null && bool.booleanValue()) {
            this.mBlurredLastVideoFrameImageView.setImageBitmap(this.mBlurredLastVideoFrame);
            this.mBlurredLastVideoFrameImageView.setImageAlpha(100);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "VastVideoBlurLastVideoFrameTask was cancelled.");
    }
}
