package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataSender;


public class SenderSelector {
    public static DataSender select(){
        if (mustSaveFile()) {
            return new FileDataWriter();
        } else {
            return new ScreenWriter();
        }
    }

    private static boolean mustSaveFile() {
        return Math.random() >= 0.5;
    }
}