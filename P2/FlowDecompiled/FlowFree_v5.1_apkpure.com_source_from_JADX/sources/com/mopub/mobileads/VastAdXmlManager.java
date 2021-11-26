package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class VastAdXmlManager {
    private final Node mAdNode;

    VastAdXmlManager(Node node) {
        Preconditions.checkNotNull(node);
        this.mAdNode = node;
    }

    /* access modifiers changed from: package-private */
    public VastInLineXmlManager getInLineXmlManager() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mAdNode, "InLine");
        if (firstMatchingChildNode != null) {
            return new VastInLineXmlManager(firstMatchingChildNode);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public VastWrapperXmlManager getWrapperXmlManager() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mAdNode, "Wrapper");
        if (firstMatchingChildNode != null) {
            return new VastWrapperXmlManager(firstMatchingChildNode);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getSequence() {
        return XmlUtils.getAttributeValue(this.mAdNode, "sequence");
    }
}
