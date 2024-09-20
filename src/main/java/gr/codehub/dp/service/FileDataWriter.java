package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataSender;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileDataWriter implements DataSender {
    
    private List<String> lines;
    private String filename;
    
    public void setLines(List<String> lines) {
        this.lines = new ArrayList(lines);
    }

    public void setFilename(String filename){
        this.filename = filename;
    }
    
    public void sendData() throws IOException {
        System.out.println("Using FileDataWriter");
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filename)));
        for (String s : lines) {
            writer.write(s + "\n");
        }
        writer.close();
    }
    
    public List<String> getLines() {
        return lines;
    }
}
