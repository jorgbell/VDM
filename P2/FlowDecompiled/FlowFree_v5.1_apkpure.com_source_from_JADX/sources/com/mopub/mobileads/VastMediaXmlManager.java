package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class VastMediaXmlManager {
    private final Node mMediaNode;

    VastMediaXmlManager(Node node) {
        Preconditions.checkNotNull(node, "mediaNode cannot be null");
        this.mMediaNode = node;
    }

    /* access modifiers changed from: package-private */
    public Integer getWidth() {
        return XmlUtils.getAttributeValueAsInt(this.mMediaNode, "width");
    }

    /* access modifiers changed from: package-private */
    public Integer getHeight() {
        return XmlUtils.getAttributeValueAsInt(this.mMediaNode, "height");
    }

    /* access modifiers changed from: package-private */
    public String getType() {
        return XmlUtils.getAttributeValue(this.mMediaNode, "type");
    }

    /* access modifiers changed from: package-private */
    public String getMediaUrl() {
        return XmlUtils.getNodeValue(this.mMediaNode);
    }

    /* access modifiers changed from: package-private */
    public Integer getBitrate() {
        Integer attributeValueAsInt = XmlUtils.getAttributeValueAsInt(this.mMediaNode, "bitrate");
        if (attributeValueAsInt != null) {
            return attributeValueAsInt;
        }
        Integer attributeValueAsInt2 = XmlUtils.getAttributeValueAsInt(this.mMediaNode, "minBitrate");
        Integer attributeValueAsInt3 = XmlUtils.getAttributeValueAsInt(this.mMediaNode, "maxBitrate");
        if (attributeValueAsInt2 == null || attributeValueAsInt3 == null) {
            return attributeValueAsInt2 != null ? attributeValueAsInt2 : attributeValueAsInt3;
        }
        return Integer.valueOf((attributeValueAsInt2.intValue() + attributeValueAsInt3.intValue()) / 2);
    }
}
