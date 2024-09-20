package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataChecker;

public class CheckerSelector {
    
    private static DataChecker chosenChecker = null;
    
    public static DataChecker select() {
        if (chosenChecker == null) {
            chosenChecker = selectNext();
        }
        return chosenChecker;
    }
    
    private static DataChecker selectNext(){
        if (mustUseEnglish()) {
            return new EnglishChecker();
        } else {
            return new GreekChecker();
        }
    }

    private static boolean mustUseEnglish() {
        return Math.random() >= 0.00000001;
    }
}
