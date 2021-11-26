package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastExtensionXmlManager {

    /* renamed from: ID */
    public static final String f5554ID = "id";
    public static final String TYPE = "type";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";
    final Node mExtensionNode;

    public VastExtensionXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.mExtensionNode = node;
    }

    /* access modifiers changed from: package-private */
    public VideoViewabilityTracker getVideoViewabilityTracker() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mExtensionNode, VIDEO_VIEWABILITY_TRACKER);
        if (firstMatchingChildNode == null) {
            return null;
        }
        VideoViewabilityTrackerXmlManager videoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(firstMatchingChildNode);
        Integer viewablePlaytimeMS = videoViewabilityTrackerXmlManager.getViewablePlaytimeMS();
        Integer percentViewable = videoViewabilityTrackerXmlManager.getPercentViewable();
        String videoViewabilityTrackerUrl = videoViewabilityTrackerXmlManager.getVideoViewabilityTrackerUrl();
        if (viewablePlaytimeMS == null || percentViewable == null || TextUtils.isEmpty(videoViewabilityTrackerUrl)) {
            return null;
        }
        return new VideoViewabilityTracker.Builder(videoViewabilityTrackerUrl, viewablePlaytimeMS.intValue(), percentViewable.intValue()).build();
    }

    /* access modifiers changed from: package-private */
    public String getType() {
        return XmlUtils.getAttributeValue(this.mExtensionNode, "type");
    }
}
