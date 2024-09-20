package gr.codehub.dp.service;

import java.util.ArrayList;
import java.util.List;

public class ScreenWriterBuilder {
    private List<String> lines = new ArrayList<>();
    private String filename = "*** FILENAME MISSING ****";
    
    public ScreenWriterBuilder lines(List<String> lines){
        this.lines.addAll(lines);
        return this;
    }

    public ScreenWriterBuilder filename(String filename){
        this.filename = filename;
        return this;
    }
    
    public ScreenWriter build() {
        ScreenWriter writer = new ScreenWriter();
        writer.setFilename(filename);
        writer.setLines(lines);
        return writer;
    }
}
