package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataSender;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter implements DataSender {
    public void sendData(List<String> lines, String filename) throws IOException {
        System.out.println("Using FileDataWriter");
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filename)));
        for (String s : lines) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
