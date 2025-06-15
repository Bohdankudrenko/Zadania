package Zadanie1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pesel {
    private String pesel;
    private LocalDate birthDate;
    private char gender; // 'M' or 'F'

    public Pesel(String pesel) {
        this.pesel = pesel;
        this.birthDate = extractBirthDate(pesel);
        this.gender = extractGender(pesel);
    }

    private LocalDate extractBirthDate(String pesel) {
        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        if (month > 80) {
            year += 1800;
            month -= 80;
        } else if (month > 60) {
            year += 2200;
            month -= 60;
        } else if (month > 40) {
            year += 2100;
            month -= 40;
        } else if (month > 20) {
            year += 2000;
            month -= 20;
        } else {
            year += 1900;
        }
        return LocalDate.of(year, month, day);
    }

    private char extractGender(String pesel) {
        int genderDigit = Character.getNumericValue(pesel.charAt(9));
        return (genderDigit % 2 == 0) ? 'F' : 'M';
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getFormattedBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

