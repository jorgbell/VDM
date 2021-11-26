package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastAbsoluteProgressTracker;
import com.mopub.mobileads.VastFractionalProgressTracker;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

class VastLinearXmlManager {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";
    private final Node mLinearNode;

    VastLinearXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.mLinearNode = node;
    }

    /* access modifiers changed from: package-private */
    public List<VastFractionalProgressTracker> getFractionalProgressTrackers() {
        ArrayList arrayList = new ArrayList();
        addQuartileTrackerWithFraction(arrayList, getVideoTrackersByAttribute("firstQuartile"), 0.25f);
        addQuartileTrackerWithFraction(arrayList, getVideoTrackersByAttribute("midpoint"), 0.5f);
        addQuartileTrackerWithFraction(arrayList, getVideoTrackersByAttribute("thirdQuartile"), 0.75f);
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node next : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(next, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    if (VastFractionalProgressTracker.Companion.isPercentageTracker(trim)) {
                        String nodeValue = XmlUtils.getNodeValue(next);
                        try {
                            float parseFloat = Float.parseFloat(trim.replace("%", "")) / 100.0f;
                            if (parseFloat >= 0.0f) {
                                arrayList.add(new VastFractionalProgressTracker.Builder(nodeValue, parseFloat).build());
                            }
                        } catch (NumberFormatException unused) {
                            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("Failed to parse VAST progress tracker %s", new Object[]{trim}));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastAbsoluteProgressTracker> getAbsoluteProgressTrackers() {
        ArrayList arrayList = new ArrayList();
        for (String builder : getVideoTrackersByAttribute("start")) {
            arrayList.add(new VastAbsoluteProgressTracker.Builder(builder, 0).build());
        }
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node next : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(next, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    String trim = attributeValue.trim();
                    VastAbsoluteProgressTracker.Companion companion = VastAbsoluteProgressTracker.Companion;
                    if (companion.isAbsoluteTracker(trim)) {
                        String nodeValue = XmlUtils.getNodeValue(next);
                        try {
                            Integer parseAbsoluteOffset = companion.parseAbsoluteOffset(trim);
                            if (parseAbsoluteOffset != null && parseAbsoluteOffset.intValue() >= 0) {
                                arrayList.add(new VastAbsoluteProgressTracker.Builder(nodeValue, parseAbsoluteOffset.intValue()).build());
                            }
                        } catch (NumberFormatException unused) {
                            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("Failed to parse VAST progress tracker %s", new Object[]{trim}));
                        }
                    }
                }
            }
            for (Node nodeValue2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
                String nodeValue3 = XmlUtils.getNodeValue(nodeValue2);
                if (nodeValue3 != null) {
                    arrayList.add(new VastAbsoluteProgressTracker.Builder(nodeValue3, 0).build());
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getVideoCompleteTrackers() {
        return getVideoTrackersByAttributeAsVastTrackers("complete");
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getPauseTrackers() {
        List<String> videoTrackersByAttribute = getVideoTrackersByAttribute("pause");
        ArrayList arrayList = new ArrayList();
        for (String builder : videoTrackersByAttribute) {
            arrayList.add(new VastTracker.Builder(builder).isRepeatable(true).build());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getResumeTrackers() {
        List<String> videoTrackersByAttribute = getVideoTrackersByAttribute("resume");
        ArrayList arrayList = new ArrayList();
        for (String builder : videoTrackersByAttribute) {
            arrayList.add(new VastTracker.Builder(builder).isRepeatable(true).build());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getVideoCloseTrackers() {
        List<VastTracker> videoTrackersByAttributeAsVastTrackers = getVideoTrackersByAttributeAsVastTrackers("close");
        videoTrackersByAttributeAsVastTrackers.addAll(getVideoTrackersByAttributeAsVastTrackers("closeLinear"));
        return videoTrackersByAttributeAsVastTrackers;
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getVideoSkipTrackers() {
        return getVideoTrackersByAttributeAsVastTrackers("skip");
    }

    /* access modifiers changed from: package-private */
    public String getClickThroughUrl() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, "ClickThrough"));
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getClickTrackers() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node nodeValue : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "ClickTracking")) {
            String nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (nodeValue2 != null) {
                arrayList.add(new VastTracker.Builder(nodeValue2).build());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String getSkipOffset() {
        String attributeValue = XmlUtils.getAttributeValue(this.mLinearNode, "skipoffset");
        if (attributeValue != null && !attributeValue.trim().isEmpty()) {
            return attributeValue.trim();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<VastMediaXmlManager> getMediaXmlManagers() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "MediaFiles");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node vastMediaXmlManager : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "MediaFile")) {
            arrayList.add(new VastMediaXmlManager(vastMediaXmlManager));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastIconXmlManager> getIconXmlManagers() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, ICONS);
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node vastIconXmlManager : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, ICON)) {
            arrayList.add(new VastIconXmlManager(vastIconXmlManager));
        }
        return arrayList;
    }

    private List<VastTracker> getVideoTrackersByAttributeAsVastTrackers(String str) {
        List<String> videoTrackersByAttribute = getVideoTrackersByAttribute(str);
        ArrayList arrayList = new ArrayList(videoTrackersByAttribute.size());
        for (String builder : videoTrackersByAttribute) {
            arrayList.add(new VastTracker.Builder(builder).build());
        }
        return arrayList;
    }

    private List<String> getVideoTrackersByAttribute(String str) {
        Preconditions.checkNotNull(str);
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mLinearNode, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node nodeValue : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList(str))) {
            String nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (nodeValue2 != null) {
                arrayList.add(nodeValue2);
            }
        }
        return arrayList;
    }

    private void addQuartileTrackerWithFraction(List<VastFractionalProgressTracker> list, List<String> list2, float f) {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list2, "urls cannot be null");
        for (String builder : list2) {
            list.add(new VastFractionalProgressTracker.Builder(builder, f).build());
        }
    }
}
