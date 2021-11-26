package androidx.media2.session;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaUtils {
    private static final Map<String, String> METADATA_COMPAT_KEY_TO_METADATA_KEY;
    private static final Map<String, String> METADATA_KEY_TO_METADATA_COMPAT_KEY = new HashMap();

    static {
        new MediaBrowserServiceCompat.BrowserRoot("androidx.media2.session.MediaLibraryService", (Bundle) null);
        HashMap hashMap = new HashMap();
        METADATA_COMPAT_KEY_TO_METADATA_KEY = hashMap;
        hashMap.put("android.media.metadata.ADVERTISEMENT", "androidx.media2.metadata.ADVERTISEMENT");
        hashMap.put("android.media.metadata.BT_FOLDER_TYPE", "androidx.media2.metadata.BROWSABLE");
        hashMap.put("android.media.metadata.DOWNLOAD_STATUS", "androidx.media2.metadata.DOWNLOAD_STATUS");
        for (Map.Entry entry : hashMap.entrySet()) {
            Map<String, String> map = METADATA_KEY_TO_METADATA_COMPAT_KEY;
            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), entry.getKey());
            } else {
                throw new RuntimeException("Shouldn't map to the same value");
            }
        }
    }

    public static MediaItem upcastForPreparceling(MediaItem mediaItem) {
        if (mediaItem == null || mediaItem.getClass() == MediaItem.class) {
            return mediaItem;
        }
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.setStartPosition(mediaItem.getStartPosition());
        builder.setEndPosition(mediaItem.getEndPosition());
        builder.setMetadata(mediaItem.getMetadata());
        return builder.build();
    }

    public static List<MediaItem> convertParcelImplListSliceToMediaItemList(ParcelImplListSlice parcelImplListSlice) {
        if (parcelImplListSlice == null) {
            return null;
        }
        List<ParcelImpl> list = parcelImplListSlice.getList();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ParcelImpl parcelImpl = list.get(i);
            if (parcelImpl != null) {
                arrayList.add((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl));
            }
        }
        return arrayList;
    }

    public static ParcelImplListSlice convertMediaItemListToParcelImplListSlice(List<MediaItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MediaItem mediaItem = list.get(i);
            if (mediaItem != null) {
                arrayList.add(MediaParcelUtils.toParcelable(mediaItem));
            }
        }
        return new ParcelImplListSlice((List<ParcelImpl>) arrayList);
    }
}
