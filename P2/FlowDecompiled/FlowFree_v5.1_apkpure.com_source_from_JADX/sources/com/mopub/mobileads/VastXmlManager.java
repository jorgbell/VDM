package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class VastXmlManager {
    private Document mVastDoc;

    VastXmlManager() {
    }

    /* access modifiers changed from: package-private */
    public void parseVastXml(String str) throws ParserConfigurationException, IOException, SAXException {
        Preconditions.checkNotNull(str, "xmlString cannot be null");
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        newInstance.setExpandEntityReferences(false);
        this.mVastDoc = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader("<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>")));
    }

    /* access modifiers changed from: package-private */
    public List<VastAdXmlManager> getAdXmlManagers() {
        ArrayList arrayList = new ArrayList();
        Document document = this.mVastDoc;
        if (document == null) {
            return arrayList;
        }
        NodeList elementsByTagName = document.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new VastAdXmlManager(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public VastTracker getErrorTracker() {
        Document document = this.mVastDoc;
        if (document == null) {
            return null;
        }
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(document, "Error");
        if (TextUtils.isEmpty(firstMatchingStringData)) {
            return null;
        }
        return new VastTracker.Builder(firstMatchingStringData).build();
    }

    /* access modifiers changed from: package-private */
    public List<VastTracker> getMoPubImpressionTrackers() {
        List<String> stringDataAsList = XmlUtils.getStringDataAsList(this.mVastDoc, "MP_TRACKING_URL");
        ArrayList arrayList = new ArrayList(stringDataAsList.size());
        for (String builder : stringDataAsList) {
            arrayList.add(new VastTracker.Builder(builder).build());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String getCustomCtaText() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.mVastDoc, "MoPubCtaText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 15) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* access modifiers changed from: package-private */
    public String getCustomSkipText() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.mVastDoc, "MoPubSkipText");
        if (firstMatchingStringData == null || firstMatchingStringData.length() > 8) {
            return null;
        }
        return firstMatchingStringData;
    }

    /* access modifiers changed from: package-private */
    public String getCustomCloseIconUrl() {
        return XmlUtils.getFirstMatchingStringData(this.mVastDoc, "MoPubCloseIcon");
    }
}
