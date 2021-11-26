package androidx.media2.player.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaFormat;
import android.net.Uri;
import androidx.core.util.Preconditions;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.CallbackMediaItem;
import androidx.media2.common.FileMediaItem;
import androidx.media2.common.MediaItem;
import androidx.media2.common.UriMediaItem;
import androidx.media2.exoplayer.external.ExoPlaybackException;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.ParserException;
import androidx.media2.exoplayer.external.PlaybackParameters;
import androidx.media2.exoplayer.external.SeekParameters;
import androidx.media2.exoplayer.external.audio.AudioAttributes;
import androidx.media2.exoplayer.external.extractor.DefaultExtractorsFactory;
import androidx.media2.exoplayer.external.extractor.ExtractorsFactory;
import androidx.media2.exoplayer.external.mediacodec.MediaFormatUtil;
import androidx.media2.exoplayer.external.source.ExtractorMediaSource;
import androidx.media2.exoplayer.external.source.MediaSource;
import androidx.media2.exoplayer.external.source.hls.HlsMediaSource;
import androidx.media2.exoplayer.external.upstream.DataSource;
import androidx.media2.exoplayer.external.upstream.HttpDataSource;
import androidx.media2.exoplayer.external.upstream.RawResourceDataSource;
import androidx.media2.exoplayer.external.util.MimeTypes;
import androidx.media2.exoplayer.external.util.Util;
import androidx.media2.player.PlaybackParams;
import java.io.IOException;
import java.net.SocketTimeoutException;

@SuppressLint({"RestrictedApi"})
class ExoPlayerUtils {
    private static final ExtractorsFactory sExtractorsFactory;

    static {
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        defaultExtractorsFactory.setAdtsExtractorFlags(1);
        sExtractorsFactory = defaultExtractorsFactory;
    }

    public static MediaSource createUnclippedMediaSource(Context context, DataSource.Factory factory, MediaItem mediaItem) {
        int i;
        if (mediaItem instanceof UriMediaItem) {
            Uri uri = ((UriMediaItem) mediaItem).getUri();
            if (Util.inferContentType(uri) == 2) {
                HlsMediaSource.Factory factory2 = new HlsMediaSource.Factory(factory);
                factory2.setTag(mediaItem);
                return factory2.createMediaSource(uri);
            }
            if ("android.resource".equals(uri.getScheme())) {
                String path = uri.getPath();
                Preconditions.checkNotNull(path);
                String str = path;
                boolean z = true;
                if (uri.getPathSegments().size() != 1 || !uri.getPathSegments().get(0).matches("\\d+")) {
                    String str2 = "";
                    String replaceAll = str.replaceAll("^/", str2);
                    String host = uri.getHost();
                    StringBuilder sb = new StringBuilder();
                    if (host != null) {
                        str2 = host + ":";
                    }
                    sb.append(str2);
                    sb.append(replaceAll);
                    i = context.getResources().getIdentifier(sb.toString(), "raw", context.getPackageName());
                } else {
                    i = Integer.parseInt(uri.getPathSegments().get(0));
                }
                if (i == 0) {
                    z = false;
                }
                Preconditions.checkState(z);
                uri = RawResourceDataSource.buildRawResourceUri(i);
            }
            ExtractorMediaSource.Factory factory3 = new ExtractorMediaSource.Factory(factory);
            factory3.setExtractorsFactory(sExtractorsFactory);
            factory3.setTag(mediaItem);
            return factory3.createMediaSource(uri);
        } else if (mediaItem instanceof FileMediaItem) {
            ExtractorMediaSource.Factory factory4 = new ExtractorMediaSource.Factory(factory);
            factory4.setExtractorsFactory(sExtractorsFactory);
            factory4.setTag(mediaItem);
            return factory4.createMediaSource(Uri.EMPTY);
        } else if (mediaItem instanceof CallbackMediaItem) {
            ExtractorMediaSource.Factory factory5 = new ExtractorMediaSource.Factory(DataSourceCallbackDataSource.getFactory(((CallbackMediaItem) mediaItem).getDataSourceCallback()));
            factory5.setExtractorsFactory(sExtractorsFactory);
            factory5.setTag(mediaItem);
            return factory5.createMediaSource(Uri.EMPTY);
        } else {
            throw new IllegalStateException();
        }
    }

    public static AudioAttributes getAudioAttributes(AudioAttributesCompat audioAttributesCompat) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setContentType(audioAttributesCompat.getContentType());
        builder.setFlags(audioAttributesCompat.getFlags());
        builder.setUsage(audioAttributesCompat.getUsage());
        return builder.build();
    }

    public static AudioAttributesCompat getAudioAttributesCompat(AudioAttributes audioAttributes) {
        AudioAttributesCompat.Builder builder = new AudioAttributesCompat.Builder();
        builder.setContentType(audioAttributes.contentType);
        builder.setFlags(audioAttributes.flags);
        builder.setUsage(audioAttributes.usage);
        return builder.build();
    }

    public static PlaybackParameters getPlaybackParameters(PlaybackParams playbackParams) {
        Float speed = playbackParams.getSpeed();
        Float pitch = playbackParams.getPitch();
        float f = 1.0f;
        float floatValue = speed != null ? speed.floatValue() : 1.0f;
        if (pitch != null) {
            f = pitch.floatValue();
        }
        return new PlaybackParameters(floatValue, f);
    }

    public static SeekParameters getSeekParameters(int i) {
        if (i == 0) {
            return SeekParameters.PREVIOUS_SYNC;
        }
        if (i == 1) {
            return SeekParameters.NEXT_SYNC;
        }
        if (i == 2) {
            return SeekParameters.CLOSEST_SYNC;
        }
        if (i == 3) {
            return SeekParameters.EXACT;
        }
        throw new IllegalArgumentException();
    }

    public static int getError(ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException.type != 0) {
            return 1;
        }
        IOException sourceException = exoPlaybackException.getSourceException();
        if (sourceException instanceof ParserException) {
            return -1007;
        }
        return (!(sourceException instanceof HttpDataSource.HttpDataSourceException) || !(sourceException.getCause() instanceof SocketTimeoutException)) ? -1004 : -110;
    }

    @SuppressLint({"InlinedApi"})
    public static MediaFormat getMediaFormat(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        String str = format.sampleMimeType;
        mediaFormat.setString("mime", str);
        int trackType = MimeTypes.getTrackType(str);
        int i = 1;
        if (trackType == 1) {
            mediaFormat.setInteger("channel-count", format.channelCount);
            mediaFormat.setInteger("sample-rate", format.sampleRate);
            String str2 = format.language;
            if (str2 != null) {
                mediaFormat.setString("language", str2);
            }
        } else if (trackType == 2) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "width", format.width);
            MediaFormatUtil.maybeSetInteger(mediaFormat, "height", format.height);
            MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
            MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
            MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        } else if (trackType == 3) {
            int i2 = format.selectionFlags;
            int i3 = i2 == 4 ? 1 : 0;
            int i4 = i2 == 1 ? 1 : 0;
            if (i2 != 2) {
                i = 0;
            }
            mediaFormat.setInteger("is-autoselect", i3);
            mediaFormat.setInteger("is-default", i4);
            mediaFormat.setInteger("is-forced-subtitle", i);
            String str3 = format.language;
            if (str3 == null) {
                mediaFormat.setString("language", "und");
            } else {
                mediaFormat.setString("language", str3);
            }
            if ("application/cea-608".equals(str)) {
                mediaFormat.setString("mime", "text/cea-608");
            } else if ("application/cea-708".equals(str)) {
                mediaFormat.setString("mime", "text/cea-708");
            }
        }
        return mediaFormat;
    }
}
