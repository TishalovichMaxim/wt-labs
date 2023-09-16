package by.lab1.task4;

import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final double EPS = 0.0001;

    public boolean[] getPrimes(int maxNum) {
        if (maxNum == 0) {
            return new boolean[] {false};
        }
        if (maxNum == 1) {
            return new boolean[] {false, false};
        }

        boolean[] nums = new boolean[maxNum + 1];
        Arrays.fill(nums, true);
        nums[0] = false;
        nums[1] = false;

        int bound = (int) (Math.sqrt(maxNum + EPS)) + 1;
        int primeIndex = 2;

        while (primeIndex != bound) {
            for (int i = primeIndex + primeIndex; i <= maxNum;
                 i += primeIndex) {
                nums[i] = false;
            }

            primeIndex += 1;
            while (primeIndex != bound && !nums[primeIndex]) {
                primeIndex += 1;
            }
        }

        return nums;
    }
}
