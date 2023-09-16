package by.lab1.task4;

import java.util.Arrays;

public class Task4 {
    public void solve(int[] array) {
        if (array.length == 0) {
            return;
        }

        int maxValue = Arrays.stream(array).max().getAsInt();
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] trueIfPrime = sieveOfEratosthenes.getPrimes(maxValue);

        for (int i = 0; i < array.length; i++) {
            if ((array[i] > 1) && trueIfPrime[array[i]]) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
}
