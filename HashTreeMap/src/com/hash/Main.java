package com.hash;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        Peak peak1 = new Peak("Эверест", 8848);
        Peak peak2 = new Peak("Аконкагуа", 6962);
        Peak peak3 = new Peak("Мак-Кинли", 6194);
        Peak peak4 = new Peak("Килиманджаро", 5895);
        Peak peak5 = new Peak("Эльбрус", 5642);

        hashMap.put(peak1.peakName, peak1.height);
        hashMap.put(peak2.peakName, peak2.height);
        hashMap.put(peak3.peakName, peak3.height);
        hashMap.put(peak4.peakName, peak4.height);
        hashMap.put(peak5.peakName, peak5.height);

        treeMap.put(peak1.peakName, peak1.height);
        treeMap.put(peak2.peakName, peak2.height);
        treeMap.put(peak3.peakName, peak3.height);
        treeMap.put(peak4.peakName, peak4.height);
        treeMap.put(peak5.peakName, peak5.height);

        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap);

        System.out.println();

        System.out.println(treeMap);
        System.out.println(treeMap.subMap("Килиманджаро", "Эльбрус"));
    }
}