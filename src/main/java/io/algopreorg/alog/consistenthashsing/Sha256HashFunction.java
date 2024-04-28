package io.algopreorg.alog.consistenthashsing;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256HashFunction implements HashFunction {
    public static final String SHA_256 = "SHA-256";

    @Override
    public int hash(String key) {
        try {
            var md = MessageDigest.getInstance(SHA_256);
            byte[] hashBytes = md.digest(key.getBytes());
            return bytesToInt(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            return key.hashCode();
        }
    }

    private static int bytesToInt(byte[] bytes) {
        return new BigInteger(1, bytes).intValue();
    }
}
