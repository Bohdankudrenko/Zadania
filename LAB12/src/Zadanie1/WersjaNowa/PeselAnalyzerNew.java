package Zadanie1.WersjaNowa;

import Zadanie1.Pesel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PeselAnalyzerNew {
    public static void main(String[] args) {
        Path inputPath = Paths.get("pesele.txt");
        Path outputPath = Paths.get("wyniki.txt");

        List<Pesel> pesels = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath);
            for (String line : lines) {
                line = line.trim();
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

        // Zapis do pliku
        List<String> birthDates = new ArrayList<>();
        for (Pesel p : pesels) {
            birthDates.add(p.getFormattedBirthDate());
        }

        try {
            Files.write(outputPath, birthDates);
            System.out.println("Daty urodzenia zapisano do " + outputPath.getFileName());
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
