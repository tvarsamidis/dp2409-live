package gr.codehub.dp.service;

import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseConverter {
    public static List<String> convertData(List<String> lines) {
        return lines.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
