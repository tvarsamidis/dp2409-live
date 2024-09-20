package gr.codehub.dp;

import gr.codehub.dp.interfaces.DataChecker;
import gr.codehub.dp.interfaces.DataSender;
import gr.codehub.dp.service.CheckerSelector;
import gr.codehub.dp.service.FileDataReader;
import gr.codehub.dp.service.SenderSelector;
import gr.codehub.dp.service.UpperCaseConverter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MainNew {

    private static final String ROOT = "data\\";

    public static void main(String[] args) throws IOException {
        setup();
        doProcessing();
        closeDown();
    }

    private static void closeDown() {
        System.out.println("Processing completed");
    }

    private static void setup() {
        System.out.println("Processing started");
    }

    private static void doProcessing() throws IOException {
        List<String> lines = receiveData(ROOT + "input.txt");
        if (!checkData(lines)) {
            handleError();
        }
        List<String> linesUpper = convertData(lines);
        sendData(linesUpper, ROOT + "output.txt");
    }

    private static List<String> convertData(List<String> lines) {
        List<String> newLines = UpperCaseConverter.convertData(lines);
        return newLines;
    }

    private static void handleError() {
        System.out.println("No english text, no processing done");
        System.exit(1);
    }

    private static boolean checkData(List<String> lines) {
        DataChecker checker = CheckerSelector.select();
        boolean ok = checker.checkData(lines);
        return ok;
    }

    private static void sendData(List<String> lines, String filename) throws IOException {
        DataSender sender = SenderSelector.select();
        sender.setFilename(filename);
        sender.setLines(lines);
        sender.sendData(); // execute
        System.out.println(sender.getLines()); // review
    }

    private static List<String> receiveData(String filename) throws IOException, FileNotFoundException {
        List<String> lines = FileDataReader.receiveData(filename);
        return lines;
    }
}
