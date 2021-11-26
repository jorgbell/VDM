package com.mopub.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressUtils {
    private static InetAddress sMockInetAddress;

    public static InetAddress getInetAddressByName(String str) throws UnknownHostException {
        InetAddress inetAddress = sMockInetAddress;
        if (inetAddress != null) {
            return inetAddress;
        }
        return InetAddress.getByName(str);
    }

    private InetAddressUtils() {
    }
}
