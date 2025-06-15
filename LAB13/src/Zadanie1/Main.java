package Zadanie1;

import java.util.Scanner;

class SumThread extends Thread {
    private int n;
    private long sum;

    public SumThread(int n) {
        this.n = n;
    }

    public void run() {
        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            try {
                Thread.sleep(100); // Delikatne opóźnienie, aby lepiej widzieć działanie równoległe
            } catch (InterruptedException e) {
                System.out.println("SumThread przerwany");
            }
        }
    }

    public long getSum() {
        return sum;
    }
}

class FactorialThread extends Thread {
    private int n;
    private long factorial = 1;

    public FactorialThread(int n) {
        this.n = n;
    }

    public void run() {
        factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            try {
                Thread.sleep(150); // Opóźnienie, aby pokazać równoległość
            } catch (InterruptedException e) {
                System.out.println("FactorialThread przerwany");
            }
        }
    }

    public long getFactorial() {
        return factorial;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę N: ");
        int n = scanner.nextInt();

        SumThread sumThread = new SumThread(n);
        FactorialThread factorialThread = new FactorialThread(n);

        sumThread.start();
        factorialThread.start();

        try {
            sumThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            System.out.println("Główny wątek przerwany");
        }

        System.out.println("Suma liczb od 1 do " + n + " wynosi: " + sumThread.getSum());
        System.out.println("Silnia liczby " + n + " wynosi: " + factorialThread.getFactorial());

        scanner.close();
    }
}

