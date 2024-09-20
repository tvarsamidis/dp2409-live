package gr.codehub.dp.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter {
    public static void sendData(List<String> lines, String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filename)));
        for (String s : lines) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
