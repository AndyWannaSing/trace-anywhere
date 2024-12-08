package com.andy.trace.agent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileAccessHelper {

    public static void writeListMapToFile(List<Map<String, Integer>> listMap, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map<String, Integer> map : listMap) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    writer.println(entry.getKey() + ":" + entry.getValue());
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Integer>> readListMapFromFile(String filePath) {
        List<Map<String, Integer>> listMap = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Integer> map = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    listMap.add(map);
                    map = new HashMap<>();
                } else {
                    String[] parts = line.split(":");
                    map.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
            listMap.add(map); // Add the last map
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listMap;
    }

    public static void writeMapToFile(Map<String, Integer> map, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
            sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (Map.Entry<String, Integer> entry : sortedList) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readMapFromFile(String filePath) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                map.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


}
