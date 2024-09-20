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

public class MainNew {

    private static final String ROOT = "data\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            List<String> lines = readFile();
            if (!isEnglish(lines)) {
                handleIncorrectLanguage();
            }
            writeFile(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }

    private static void handleIncorrectLanguage() {
        System.out.println("No english text, no processing done");
        System.exit(1);
    }

    private static boolean isEnglish(List<String> lines) {
        final String firstOriginal = lines.get(0);
        final String firstLower = firstOriginal.toLowerCase();
        return firstLower.contains("e")
                || firstLower.contains("t")
                || firstLower.contains("a")
                || firstLower.contains("o");
    }

    private static void writeFile(List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(ROOT + "output.txt")));
        for (String s : lines) {
            writer.write(s.toUpperCase() + "\n");
        }
        writer.close();
    }

    private static List<String> readFile() throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(ROOT + "input.txt")));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
