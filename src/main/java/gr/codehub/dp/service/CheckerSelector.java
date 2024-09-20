package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataChecker;

public class CheckerSelector {
    public static DataChecker select(){
        if (mustUseEnglish()) {
            return new EnglishChecker();
        } else {
            return new GreekChecker();
        }
    }

    private static boolean mustUseEnglish() {
        return Math.random() >= 0.5;
    }
}
