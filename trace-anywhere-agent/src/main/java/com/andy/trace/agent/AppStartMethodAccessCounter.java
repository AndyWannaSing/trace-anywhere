package com.andy.trace.agent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppStartMethodAccessCounter {
    private static Map<String, Integer> LAST_ACCESS_COUNT_MAP = new HashMap<>();
    private static Map<String, Integer> ACCESS_COUNT_MAP = new HashMap<>();

    private static final String LAST_ACCESS_COUNT_FILE = "D:\\tmp\\trace-anywhere-tmp\\AppStartMethodAccessInfo.txt";
    private static final String LAST_ACCESS_COUNT_FILE_BAK = "D:\\tmp\\trace-anywhere-tmp\\AppStartMethodAccessInfo_bak.txt";

    static {
        LAST_ACCESS_COUNT_MAP.putAll(FileAccessHelper.readMapFromFile(LAST_ACCESS_COUNT_FILE_BAK));
        LAST_ACCESS_COUNT_MAP.putAll(FileAccessHelper.readMapFromFile(LAST_ACCESS_COUNT_FILE));
    }

    public static void count(String apiName) {
        ACCESS_COUNT_MAP.put(apiName, ACCESS_COUNT_MAP.getOrDefault(apiName, 0) + 1);
    }

    public static void finishCount() {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(ACCESS_COUNT_MAP.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        FileAccessHelper.writeMapToFile(ACCESS_COUNT_MAP, LAST_ACCESS_COUNT_FILE);
        ACCESS_COUNT_MAP.clear();
    }


    public static int lastAccessCount(String apiName) {
        return LAST_ACCESS_COUNT_MAP.getOrDefault(apiName, 0);
    }


    public static void main(String[] args) {
        AppStartMethodAccessCounter counter = new AppStartMethodAccessCounter();
        counter.count("api1");
        counter.count("api2");
        counter.count("api1");
        counter.count("api3");
        counter.count("api2");
        counter.count("api2");

        counter.finishCount();
    }
}
