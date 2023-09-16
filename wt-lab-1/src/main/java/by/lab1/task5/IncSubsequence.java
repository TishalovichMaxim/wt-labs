package by.lab1.task5;

import java.util.Arrays;

public class IncSubsequence {
    public int getCorrectionNum(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, Integer.MAX_VALUE);
        int maxSeqLen = 0;
        for (int num :
                nums) {
            int pos = Arrays.binarySearch(mem, 0, maxSeqLen, num);
            if (pos < 0) {
                pos = -pos - 1;
                if (mem[pos] > num) {
                    mem[pos] = num;
                    maxSeqLen = Math.max(maxSeqLen, pos + 1);
                }
            }
        }

        return nums.length - maxSeqLen;
    }
}
