package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataSender;
import java.io.IOException;
import java.util.List;

public class ScreenWriter implements DataSender {
    public void sendData(List<String> lines, String filename) throws IOException {
        System.out.println("Using ScreenWriter");
        lines.forEach(System.out::println);
    }
}
