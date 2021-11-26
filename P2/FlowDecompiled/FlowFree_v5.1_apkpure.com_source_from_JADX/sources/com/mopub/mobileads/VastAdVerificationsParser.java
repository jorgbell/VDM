package com.mopub.mobileads;

import com.mopub.common.ViewabilityVendor;
import com.mopub.mobileads.util.XmlUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

class VastAdVerificationsParser {
    private final Set<ViewabilityVendor> viewabilityVendors = new HashSet();

    VastAdVerificationsParser(Node node) {
        if (node != null) {
            parse(node);
        }
    }

    private void parse(Node node) {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(XmlUtils.getFirstMatchingChildNode(node, "AdVerifications"), "Verification");
        if (matchingChildNodes != null && !matchingChildNodes.isEmpty()) {
            for (Node next : matchingChildNodes) {
                Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(next, "JavaScriptResource", "apiFramework", Collections.singletonList("omid"));
                if (firstMatchingChildNode != null) {
                    Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(XmlUtils.getFirstMatchingChildNode(next, "TrackingEvents"), "Tracking", "event", Collections.singletonList("verificationNotExecuted"));
                    Node firstMatchingChildNode3 = XmlUtils.getFirstMatchingChildNode(next, "VerificationParameters");
                    ViewabilityVendor.Builder builder = new ViewabilityVendor.Builder(XmlUtils.getNodeValue(firstMatchingChildNode));
                    builder.withApiFramework("omid").withVendorKey(XmlUtils.getAttributeValue(next, "vendor")).withVerificationParameters(XmlUtils.getNodeValue(firstMatchingChildNode3)).withVerificationNotExecuted(XmlUtils.getNodeValue(firstMatchingChildNode2));
                    ViewabilityVendor build = builder.build();
                    if (build != null) {
                        this.viewabilityVendors.add(build);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Set<ViewabilityVendor> getViewabilityVendors() {
        return this.viewabilityVendors;
    }
}
