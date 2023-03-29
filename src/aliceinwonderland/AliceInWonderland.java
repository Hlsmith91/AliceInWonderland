package aliceinwonderland;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Collections;




public class AliceInWonderland {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        String delim = "\\n";
        String field ="";
        File inFile = new File("AliceInWonderland.txt");
        //File inFile = new File("Afile.txt");
        Scanner input = new Scanner(inFile);
        Map<String, Integer> wordMap = new TreeMap<>();
        boolean hello = input.hasNextLine();
        //System.out.println("Alice is here.");
        while (hello) {
                  // System.out.println("Each line");

            field = input.nextLine();
            String[] words = field.split(" ");
//            System.out.println(field);
            field = field.replaceAll("[^a-zA-Z0-9]", "");
            field = field.toLowerCase();
            
            //Map<String, Integer> wordMap = new TreeMap<>();
            int count = 0;
            for (String word : words) {
                if (wordMap.containsKey(word)) {
                    count = wordMap.get(word);
                    count++;
                    wordMap.put(word, count);
                } else {
                    wordMap.put(word, 1);
                }
            }
        }

        String[] sorted = new String[wordMap.size()];
        int psn = 0;
        for (Map.Entry entry : wordMap.entrySet()) {
            String sValue = String.valueOf(entry.getValue());
            String elem = sValue + " " + entry.getKey();
            sorted[psn] = elem;
            psn++;
        }

        Arrays.sort(sorted, Collections.reverseOrder());
        System.out.println("Word count and words");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }

        System.out.println("\nsorted.length = " + sorted.length);
    }
}
