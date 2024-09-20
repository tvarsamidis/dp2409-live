package gr.codehub.dp.interfaces;

import java.io.IOException;
import java.util.List;

public interface DataSender {

    void setLines(List<String> lines);

    void setFilename(String filename);

    void sendData() throws IOException;

    public List<String> getLines();

}
