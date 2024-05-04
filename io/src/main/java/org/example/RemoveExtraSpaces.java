package org.example;

import java.io.*;

public class RemoveExtraSpaces {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Borodino.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("BorodinoResult.txt"));

            String line;

            while ((line = in.readLine()) != null) {
                line = line.replaceAll("\\s+", " ");
                out.write(line + "\n");
            }

            in.close();
            out.close();

            System.out.println("Лишние пробелы удалены. Результат сохранен в файл BorodinoResult.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
