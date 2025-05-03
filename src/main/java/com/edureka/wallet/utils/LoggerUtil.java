package com.edureka.wallet.utils;

import java.time.LocalDateTime;

public class LoggerUtil {
    public static void logInfo(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " - " + message);
    }

    public static void logWarn(String message) {
        System.out.println("[WARN] " + LocalDateTime.now() + " - " + message);
    }

    public static void logError(String message) {
        System.out.println("[ERROR] " + LocalDateTime.now() + " - " + message);
    }
}
