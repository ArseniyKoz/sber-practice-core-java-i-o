package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortNames {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("listNames.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("sortedNames.txt"));

            ArrayList<String> names = new ArrayList<>();

            String line;

            while ((line = in.readLine()) != null) {
                StringTokenizer  st = new StringTokenizer(line," \t\n\r,.");

                while(st.hasMoreTokens()){
                    String token = st.nextToken();
                    names.add(token);
                }
            }

            Collections.sort(names);

            for (String name : names) {
                out.write(name + "\n");
            }

            in.close();
            out.close();

            System.out.println("Имена отсортированы по алфавиту. Результат сохранен в файл sortedNames.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
