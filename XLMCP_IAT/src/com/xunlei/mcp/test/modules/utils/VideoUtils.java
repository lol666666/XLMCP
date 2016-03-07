package com.xunlei.mcp.test.modules.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class VideoUtils {

	public static String calcGcid(String path) {
        File file = new File(path);
        long fileSize = file.length();
        long blockSize = calcBlockSize(fileSize);

        byte[] buffer = new byte[8192];
        int len;
        int total = 0;
        MessageDigest gcidDigest;
        MessageDigest bcidDigest = null;
        InputStream is = null;
        try {
            gcidDigest = MessageDigest.getInstance("SHA-1");
            is = new FileInputStream(file);
            while ((len = is.read(buffer)) != -1) {
                if (bcidDigest == null) {
                    bcidDigest = MessageDigest.getInstance("SHA-1");
                }
                bcidDigest.update(buffer, 0, len);
                total += len;
                if (total >= blockSize) {
                    gcidDigest.update(bcidDigest.digest());
                    bcidDigest = null;
                    total = 0;
                }
            }
            if (total > 0) {
                gcidDigest.update(bcidDigest.digest());
            }

            return byteArrayToHexString(gcidDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static long calcBlockSize(long fileSize) {
        if (fileSize >= 0 && fileSize <= (128 << 20)) {
            return 256 << 10;
        } else if (fileSize > (128 << 20) && fileSize <= (256 << 20)) {
            return 512 << 10;
        } else if (fileSize > (256 << 20) && fileSize <= (512 << 20)) {
            return 1024 << 10;
        } else {
            return 2048 << 10;
        }
    }
	
	private final static String[] hexDigits = {
        "0", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "a", "b", "c", "d", "e", "f"};
	
	 private static String byteArrayToHexString(byte[] b) {
	        StringBuilder resultSb = new StringBuilder();
	        for (int i = 0; i < b.length; i++) {
	            resultSb.append(byteToHexString(b[i]));
	        }
	        return resultSb.toString();
	    }

	 private static String byteToHexString(byte b) {
	        int n = b;
	        if (n < 0)
	            n = 256 + n;
	        int d1 = n >>> 4 & 0xf;
	        int d2 = n & 0xf;
	        return hexDigits[d1] + hexDigits[d2];
	    }
}
