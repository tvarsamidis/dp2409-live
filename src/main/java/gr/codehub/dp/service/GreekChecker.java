package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataChecker;
import java.util.List;

public class GreekChecker implements DataChecker {
    public boolean checkData(List<String> lines) {
        final String firstOriginal = lines.get(0);
        final String firstLower = firstOriginal.toLowerCase();
        return firstLower.contains("α")
                || firstLower.contains("ε")
                || firstLower.contains("σ")
                || firstLower.contains("τ");
    }
}
