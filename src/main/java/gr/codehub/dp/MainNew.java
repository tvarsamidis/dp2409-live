package gr.codehub.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return lines.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static void handleError() {
        System.out.println("No english text, no processing done");
        System.exit(1);
    }

    private static boolean checkData(List<String> lines) {
        final String firstOriginal = lines.get(0);
        final String firstLower = firstOriginal.toLowerCase();
        return firstLower.contains("e")
                || firstLower.contains("t")
                || firstLower.contains("a")
                || firstLower.contains("o");
    }

    private static void sendData(List<String> lines, String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filename)));
        for (String s : lines) {
            writer.write(s + "\n");
        }
        writer.close();
    }

    private static List<String> receiveData(String filename) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
