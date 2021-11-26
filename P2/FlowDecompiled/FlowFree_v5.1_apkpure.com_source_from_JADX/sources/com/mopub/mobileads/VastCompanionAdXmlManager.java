package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

class VastCompanionAdXmlManager {
    private final Node mCompanionNode;
    private final VastResourceXmlManager mResourceXmlManager;

    VastCompanionAdXmlManager(Node node) {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        this.mCompanionNode = node;
        this.mResourceXmlManager = new VastResourceXmlManager(node);
    }

    /* access modifiers changed from: package-private */
    public Integer getWidth() {
        return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, "width");
    }

    /* access modifiers changed from: package-private */
    public Integer getHeight() {
        return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, "height");
    }

    /* access modifiers changed from: package-private */
    public VastResourceXmlManager getResourceXmlManager() {
        return this.mResourceXmlManager;
    }

    /* access modifiers changed from: package-private */
    public String getClickThroughUrl() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "CompanionClickThrough"));
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getClickTrackers() {
        ArrayList arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.mCompanionNode, "CompanionClickTracking");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node nodeValue : matchingChildNodes) {
            String nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker.Builder(nodeValue2).build());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getCompanionCreativeViewTrackers() {
        ArrayList arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node nodeValue : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
            String nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (nodeValue2 != null) {
                arrayList.add(new VastTracker.Builder(nodeValue2).build());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean hasResources() {
        return !TextUtils.isEmpty(this.mResourceXmlManager.getStaticResource()) || !TextUtils.isEmpty(this.mResourceXmlManager.getHTMLResource()) || !TextUtils.isEmpty(this.mResourceXmlManager.getIFrameResource());
    }
}
