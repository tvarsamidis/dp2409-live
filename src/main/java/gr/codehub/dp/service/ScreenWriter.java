package gr.codehub.dp.service;

import gr.codehub.dp.interfaces.DataSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScreenWriter implements DataSender {
    private List<String> lines;
    
    public void setLines(List<String> lines) {
        this.lines = new ArrayList(lines);
    }

    public void setFilename(String filename){
        System.out.println("WARNING: No filename to set!");
    }

    public void sendData() throws IOException {
        System.out.println("Using ScreenWriter");
        lines.forEach(System.out::println);
    }
    
        public List<String> getLines() {
        return lines;
    }

}
