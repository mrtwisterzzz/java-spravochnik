package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static final String[] STRING_ARRAY = {"name", "region", "district", "population", "foundation"};


    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter("\\;");
            int counter = 0;
            while (rowScanner.hasNext()) {

                String str = rowScanner.next();
                if (counter == 0) {
                    counter++;
                    continue;
                }
                values.add(str);
                map.put(STRING_ARRAY[counter-1], str);
                counter++;
            }
            System.out.println(map);
        }
        return values;
    }

    public static void main(String[] args) {

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Задача ВС Java Сбер.csv"));) {
            while (scanner.hasNextLine()) {
                getRecordFromLine(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}