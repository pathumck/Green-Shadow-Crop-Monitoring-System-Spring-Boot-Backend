package lk.ijse.greenshadow.util;

import java.util.Base64;

public class AppUtil {
    public static String imageToBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }
}
