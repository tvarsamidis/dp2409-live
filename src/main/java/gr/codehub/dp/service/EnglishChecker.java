package gr.codehub.dp.service;

import java.util.List;

public class EnglishChecker {
    public static boolean checkData(List<String> lines) {
        final String firstOriginal = lines.get(0);
        final String firstLower = firstOriginal.toLowerCase();
        return firstLower.contains("e")
                || firstLower.contains("t")
                || firstLower.contains("a")
                || firstLower.contains("o");
    }
}
