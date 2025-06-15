package Zadanie1.WersjaStarsza;

import Zadanie1.Pesel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PeselAnalyzerOld {
    public static void main(String[] args) {
        File inputFile = new File("pesele.txt");
        File outputFile = new File("wyniki.txt");

        List<Pesel> pesels = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty() && line.length() == 11) {
                    pesels.add(new Pesel(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku.");
            e.printStackTrace();
            return;
        }

        int womenCount = 0, menCount = 0;
        List<Pesel> group1 = new ArrayList<>();
        List<Pesel> group2 = new ArrayList<>();
        List<Pesel> group3 = new ArrayList<>();

        for (Pesel p : pesels) {
            if (p.getGender() == 'F') womenCount++;
            else menCount++;

            int year = p.getBirthDate().getYear();
            if (year >= 1950 && year <= 1980) group1.add(p);
            else if (year >= 1981 && year <= 2000) group2.add(p);
            else if (year >= 2001 && year <= 2025) group3.add(p);
        }

        System.out.println("Kobiet: " + womenCount);
        System.out.println("Mężczyzn: " + menCount);
        System.out.println("Osoby urodzone 1950-1980: " + group1.size());
        System.out.println("Osoby urodzone 1981-2000: " + group2.size());
        System.out.println("Osoby urodzone 2001-2025: " + group3.size());

        System.out.println("Średni wiek 1950-1980: " + averageAge(group1));
        System.out.println("Średni wiek 1981-2000: " + averageAge(group2));
        System.out.println("Średni wiek 2001-2025: " + averageAge(group3));

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Pesel p : pesels) {
                writer.write(p.getFormattedBirthDate() + "\n");
            }
            System.out.println("Daty urodzenia zapisano do " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku.");
            e.printStackTrace();
        }
    }

    private static double averageAge(List<Pesel> list) {
        if (list.isEmpty()) return 0;
        int sum = 0;
        for (Pesel p : list) {
            sum += p.getAge();
        }
        return (double) sum / list.size();
    }
}

