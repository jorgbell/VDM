package androidx.media2.player.exoplayer;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import androidx.core.util.Preconditions;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.Player;
import androidx.media2.exoplayer.external.source.TrackGroupArray;
import androidx.media2.exoplayer.external.trackselection.DefaultTrackSelector;
import androidx.media2.exoplayer.external.trackselection.MappingTrackSelector;
import androidx.media2.exoplayer.external.trackselection.TrackSelection;
import androidx.media2.exoplayer.external.trackselection.TrackSelectionArray;
import androidx.media2.player.MediaPlayer2;
import androidx.media2.player.common.TrackInfoImpl;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
final class TrackSelector {
    private final List<MediaPlayer2.TrackInfo> mAudioTrackInfos = new ArrayList();
    private final DefaultTrackSelector mDefaultTrackSelector;
    private final List<InternalTextTrackInfo> mInternalTextTrackInfos = new ArrayList();
    private final List<MediaPlayer2.TrackInfo> mMetadataTrackInfos = new ArrayList();
    private boolean mPendingMetadataUpdate;
    private int mPlayerTextTrackIndex = -1;
    private int mSelectedAudioTrackIndex = -1;
    private int mSelectedMetadataTrackIndex = -1;
    private int mSelectedTextTrackIndex = -1;
    private int mSelectedVideoTrackIndex = -1;
    private final TextRenderer mTextRenderer;
    private final List<MediaPlayer2.TrackInfo> mTextTrackInfos = new ArrayList();
    private final List<MediaPlayer2.TrackInfo> mVideoTrackInfos = new ArrayList();

    TrackSelector(TextRenderer textRenderer) {
        this.mTextRenderer = textRenderer;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector();
        this.mDefaultTrackSelector = defaultTrackSelector;
        DefaultTrackSelector.ParametersBuilder parametersBuilder = new DefaultTrackSelector.ParametersBuilder();
        parametersBuilder.setSelectUndeterminedTextLanguage(true);
        parametersBuilder.setRendererDisabled(3, true);
        defaultTrackSelector.setParameters(parametersBuilder);
    }

    public DefaultTrackSelector getPlayerTrackSelector() {
        return this.mDefaultTrackSelector;
    }

    public void handlePlayerTracksChanged(Player player) {
        int i;
        int i2;
        int i3;
        this.mPendingMetadataUpdate = true;
        DefaultTrackSelector defaultTrackSelector = this.mDefaultTrackSelector;
        DefaultTrackSelector.ParametersBuilder buildUponParameters = defaultTrackSelector.buildUponParameters();
        buildUponParameters.clearSelectionOverrides();
        defaultTrackSelector.setParameters(buildUponParameters);
        int i4 = -1;
        this.mSelectedAudioTrackIndex = -1;
        this.mSelectedVideoTrackIndex = -1;
        this.mSelectedMetadataTrackIndex = -1;
        this.mPlayerTextTrackIndex = -1;
        this.mSelectedTextTrackIndex = -1;
        this.mAudioTrackInfos.clear();
        this.mVideoTrackInfos.clear();
        this.mMetadataTrackInfos.clear();
        this.mInternalTextTrackInfos.clear();
        this.mTextRenderer.clearSelection();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mDefaultTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(1);
            for (int i5 = 0; i5 < trackGroups.length; i5++) {
                this.mAudioTrackInfos.add(new TrackInfoImpl(2, ExoPlayerUtils.getMediaFormat(trackGroups.get(i5).getFormat(0))));
            }
            TrackGroupArray trackGroups2 = currentMappedTrackInfo.getTrackGroups(0);
            for (int i6 = 0; i6 < trackGroups2.length; i6++) {
                this.mVideoTrackInfos.add(new TrackInfoImpl(1, ExoPlayerUtils.getMediaFormat(trackGroups2.get(i6).getFormat(0))));
            }
            TrackGroupArray trackGroups3 = currentMappedTrackInfo.getTrackGroups(3);
            for (int i7 = 0; i7 < trackGroups3.length; i7++) {
                this.mMetadataTrackInfos.add(new TrackInfoImpl(5, ExoPlayerUtils.getMediaFormat(trackGroups3.get(i7).getFormat(0))));
            }
            TrackSelectionArray currentTrackSelections = player.getCurrentTrackSelections();
            TrackSelection trackSelection = currentTrackSelections.get(1);
            if (trackSelection == null) {
                i = -1;
            } else {
                i = trackGroups.indexOf(trackSelection.getTrackGroup());
            }
            this.mSelectedAudioTrackIndex = i;
            TrackSelection trackSelection2 = currentTrackSelections.get(0);
            if (trackSelection2 == null) {
                i2 = -1;
            } else {
                i2 = trackGroups2.indexOf(trackSelection2.getTrackGroup());
            }
            this.mSelectedVideoTrackIndex = i2;
            TrackSelection trackSelection3 = currentTrackSelections.get(3);
            if (trackSelection3 == null) {
                i3 = -1;
            } else {
                i3 = trackGroups3.indexOf(trackSelection3.getTrackGroup());
            }
            this.mSelectedMetadataTrackIndex = i3;
            TrackGroupArray trackGroups4 = currentMappedTrackInfo.getTrackGroups(2);
            for (int i8 = 0; i8 < trackGroups4.length; i8++) {
                Format format = trackGroups4.get(i8).getFormat(0);
                Preconditions.checkNotNull(format);
                Format format2 = format;
                InternalTextTrackInfo internalTextTrackInfo = new InternalTextTrackInfo(i8, getTextTrackType(format2.sampleMimeType), format2, -1);
                this.mInternalTextTrackInfos.add(internalTextTrackInfo);
                this.mTextTrackInfos.add(internalTextTrackInfo.mTrackInfo);
            }
            TrackSelection trackSelection4 = currentTrackSelections.get(2);
            if (trackSelection4 != null) {
                i4 = trackGroups4.indexOf(trackSelection4.getTrackGroup());
            }
            this.mPlayerTextTrackIndex = i4;
        }
    }

    public void handleTextRendererChannelAvailable(int i, int i2) {
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mInternalTextTrackInfos.size()) {
                break;
            }
            InternalTextTrackInfo internalTextTrackInfo = this.mInternalTextTrackInfos.get(i3);
            if (internalTextTrackInfo.mType == i && internalTextTrackInfo.mChannel == -1) {
                this.mInternalTextTrackInfos.set(i3, new InternalTextTrackInfo(internalTextTrackInfo.mPlayerTrackIndex, i, internalTextTrackInfo.mFormat, i2));
                if (this.mSelectedTextTrackIndex == i3) {
                    this.mTextRenderer.select(i, i2);
                }
                z = true;
            } else {
                i3++;
            }
        }
        if (!z) {
            InternalTextTrackInfo internalTextTrackInfo2 = new InternalTextTrackInfo(this.mPlayerTextTrackIndex, i, (Format) null, i2);
            this.mInternalTextTrackInfos.add(internalTextTrackInfo2);
            this.mTextTrackInfos.add(internalTextTrackInfo2.mTrackInfo);
            this.mPendingMetadataUpdate = true;
        }
    }

    public boolean hasPendingMetadataUpdate() {
        boolean z = this.mPendingMetadataUpdate;
        this.mPendingMetadataUpdate = false;
        return z;
    }

    public int getSelectedTrack(int i) {
        int size;
        int i2;
        if (i == 1) {
            size = this.mAudioTrackInfos.size();
            i2 = this.mSelectedVideoTrackIndex;
        } else if (i == 2) {
            return this.mSelectedAudioTrackIndex;
        } else {
            if (i == 4) {
                size = this.mAudioTrackInfos.size() + this.mVideoTrackInfos.size() + this.mMetadataTrackInfos.size();
                i2 = this.mSelectedTextTrackIndex;
            } else if (i != 5) {
                return -1;
            } else {
                size = this.mAudioTrackInfos.size() + this.mVideoTrackInfos.size();
                i2 = this.mSelectedMetadataTrackIndex;
            }
        }
        return size + i2;
    }

    public List<MediaPlayer2.TrackInfo> getTrackInfos() {
        ArrayList arrayList = new ArrayList(this.mVideoTrackInfos.size() + this.mAudioTrackInfos.size() + this.mMetadataTrackInfos.size() + this.mInternalTextTrackInfos.size());
        arrayList.addAll(this.mVideoTrackInfos);
        arrayList.addAll(this.mAudioTrackInfos);
        arrayList.addAll(this.mMetadataTrackInfos);
        arrayList.addAll(this.mTextTrackInfos);
        return arrayList;
    }

    public void selectTrack(int i) {
        Preconditions.checkArgument(i >= this.mVideoTrackInfos.size(), "Video track selection is not supported");
        int size = i - this.mVideoTrackInfos.size();
        if (size < this.mAudioTrackInfos.size()) {
            this.mSelectedAudioTrackIndex = size;
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mDefaultTrackSelector.getCurrentMappedTrackInfo();
            Preconditions.checkNotNull(currentMappedTrackInfo);
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(1);
            int i2 = trackGroups.get(size).length;
            int[] iArr = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = i3;
            }
            DefaultTrackSelector.SelectionOverride selectionOverride = new DefaultTrackSelector.SelectionOverride(size, iArr);
            DefaultTrackSelector defaultTrackSelector = this.mDefaultTrackSelector;
            DefaultTrackSelector.ParametersBuilder buildUponParameters = defaultTrackSelector.buildUponParameters();
            buildUponParameters.setSelectionOverride(1, trackGroups, selectionOverride);
            defaultTrackSelector.setParameters(buildUponParameters.build());
            return;
        }
        int size2 = size - this.mAudioTrackInfos.size();
        if (size2 < this.mMetadataTrackInfos.size()) {
            this.mSelectedMetadataTrackIndex = size2;
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo2 = this.mDefaultTrackSelector.getCurrentMappedTrackInfo();
            Preconditions.checkNotNull(currentMappedTrackInfo2);
            TrackGroupArray trackGroups2 = currentMappedTrackInfo2.getTrackGroups(3);
            DefaultTrackSelector.SelectionOverride selectionOverride2 = new DefaultTrackSelector.SelectionOverride(size2, 0);
            DefaultTrackSelector defaultTrackSelector2 = this.mDefaultTrackSelector;
            DefaultTrackSelector.ParametersBuilder buildUponParameters2 = defaultTrackSelector2.buildUponParameters();
            buildUponParameters2.setRendererDisabled(3, false);
            buildUponParameters2.setSelectionOverride(3, trackGroups2, selectionOverride2);
            defaultTrackSelector2.setParameters(buildUponParameters2.build());
            return;
        }
        int size3 = size2 - this.mMetadataTrackInfos.size();
        Preconditions.checkArgument(size3 < this.mInternalTextTrackInfos.size());
        InternalTextTrackInfo internalTextTrackInfo = this.mInternalTextTrackInfos.get(size3);
        if (this.mPlayerTextTrackIndex != internalTextTrackInfo.mPlayerTrackIndex) {
            this.mTextRenderer.clearSelection();
            this.mPlayerTextTrackIndex = internalTextTrackInfo.mPlayerTrackIndex;
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo3 = this.mDefaultTrackSelector.getCurrentMappedTrackInfo();
            Preconditions.checkNotNull(currentMappedTrackInfo3);
            TrackGroupArray trackGroups3 = currentMappedTrackInfo3.getTrackGroups(2);
            DefaultTrackSelector.SelectionOverride selectionOverride3 = new DefaultTrackSelector.SelectionOverride(this.mPlayerTextTrackIndex, 0);
            DefaultTrackSelector defaultTrackSelector3 = this.mDefaultTrackSelector;
            DefaultTrackSelector.ParametersBuilder buildUponParameters3 = defaultTrackSelector3.buildUponParameters();
            buildUponParameters3.setSelectionOverride(2, trackGroups3, selectionOverride3);
            defaultTrackSelector3.setParameters(buildUponParameters3.build());
        }
        int i4 = internalTextTrackInfo.mChannel;
        if (i4 != -1) {
            this.mTextRenderer.select(internalTextTrackInfo.mType, i4);
        }
        this.mSelectedTextTrackIndex = size3;
    }

    public void deselectTrack(int i) {
        boolean z = false;
        Preconditions.checkArgument(i >= this.mVideoTrackInfos.size(), "Video track deselection is not supported");
        int size = i - this.mVideoTrackInfos.size();
        Preconditions.checkArgument(size >= this.mAudioTrackInfos.size(), "Audio track deselection is not supported");
        int size2 = size - this.mAudioTrackInfos.size();
        if (size2 < this.mMetadataTrackInfos.size()) {
            this.mSelectedMetadataTrackIndex = -1;
            DefaultTrackSelector defaultTrackSelector = this.mDefaultTrackSelector;
            DefaultTrackSelector.ParametersBuilder buildUponParameters = defaultTrackSelector.buildUponParameters();
            buildUponParameters.setRendererDisabled(3, true);
            defaultTrackSelector.setParameters(buildUponParameters);
            return;
        }
        if (size2 - this.mMetadataTrackInfos.size() == this.mSelectedTextTrackIndex) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.mTextRenderer.clearSelection();
        this.mSelectedTextTrackIndex = -1;
    }

    private static int getTextTrackType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1004728940:
                if (str.equals("text/vtt")) {
                    c = 0;
                    break;
                }
                break;
            case 1566015601:
                if (str.equals("application/cea-608")) {
                    c = 1;
                    break;
                }
                break;
            case 1566016562:
                if (str.equals("application/cea-708")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2;
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                throw new IllegalArgumentException("Unexpected text MIME type " + str);
        }
    }

    public static final class InternalTextTrackInfo {
        public final int mChannel;
        public final Format mFormat;
        public final int mPlayerTrackIndex;
        public final TrackInfoImpl mTrackInfo;
        public final int mType;

        InternalTextTrackInfo(int i, int i2, Format format, int i3) {
            String str;
            this.mPlayerTrackIndex = i;
            int i4 = 1;
            if (i2 == 0 && i3 == 0) {
                i4 = 5;
            } else if (!(i2 == 1 && i3 == 1)) {
                i4 = format == null ? 0 : format.selectionFlags;
            }
            if (format == null) {
                str = "und";
            } else {
                str = format.language;
            }
            this.mTrackInfo = getTrackInfo(i2, str, i4);
            this.mType = i2;
            this.mChannel = i3;
            this.mFormat = format;
        }

        static TrackInfoImpl getTrackInfo(int i, String str, int i2) {
            MediaFormat mediaFormat = new MediaFormat();
            int i3 = 1;
            if (i == 0) {
                mediaFormat.setString("mime", "text/cea-608");
            } else if (i == 1) {
                mediaFormat.setString("mime", "text/cea-708");
            } else if (i == 2) {
                mediaFormat.setString("mime", "text/vtt");
            } else {
                throw new IllegalStateException();
            }
            mediaFormat.setString("language", str);
            int i4 = 0;
            mediaFormat.setInteger("is-forced-subtitle", (i2 & 2) != 0 ? 1 : 0);
            mediaFormat.setInteger("is-autoselect", (i2 & 4) != 0 ? 1 : 0);
            if ((i2 & 1) == 0) {
                i3 = 0;
            }
            mediaFormat.setInteger("is-default", i3);
            if (i != 2) {
                i4 = 4;
            }
            return new TrackInfoImpl(i4, mediaFormat);
        }
    }
}
