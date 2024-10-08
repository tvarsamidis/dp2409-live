package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataChecker;
import java.util.List;

public class EnglishChecker implements DataChecker {
    public boolean checkData(List<String> lines) {
        final String firstOriginal = lines.get(0);
        final String firstLower = firstOriginal.toLowerCase();
        return firstLower.contains("e")
                || firstLower.contains("t")
                || firstLower.contains("a")
                || firstLower.contains("o");
    }
}
