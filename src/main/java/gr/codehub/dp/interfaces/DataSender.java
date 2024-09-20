package gr.codehub.dp.interfaces;

import java.io.IOException;
import java.util.List;

public interface DataSender {

    void sendData(List<String> lines, String filename) throws IOException;
}
