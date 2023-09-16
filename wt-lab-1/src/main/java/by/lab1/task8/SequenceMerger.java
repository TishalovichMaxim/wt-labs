package by.lab1.task8;

public class SequenceMerger {
    private boolean checkOnEqualsElements(int[] first, int[] second) {
        int firstPointer = 0;
        int secondPointer = 0;

        int prevItem;
        int currItem;

        if (first.length == 0 && second.length == 0) {
            return true;
        } else if (first.length == 0) {
            prevItem = second[0];
            secondPointer += 1;
        } else if (second.length == 0) {
            prevItem = first[0];
            firstPointer += 1;
        } else if (first[0] > second[0]) {
            prevItem = second[0];
            secondPointer += 1;
        } else {
            prevItem = first[0];
            firstPointer += 1;
        }

        for (int i = 1; i < first.length + second.length; i++) {
            if (firstPointer == first.length) {
                currItem = second[secondPointer];
                secondPointer += 1;
            } else if (secondPointer == second.length) {
                currItem = first[firstPointer];
                firstPointer += 1;
            } else {
                if (first[firstPointer] > second[secondPointer]) {
                    currItem = second[secondPointer];
                    secondPointer += 1;
                } else {
                    currItem = first[firstPointer];
                    firstPointer += 1;
                }
            }

            if (prevItem == currItem) {
                return false;
            }

            prevItem = currItem;
        }

        return true;
    }

    public int[] mergeSequences(int[] first, int[] second) {
        if (!checkOnEqualsElements(first, second)) {
            return null;
        }

        int[] results = new int[second.length];
        int firstPointer = 0;
        int actualPointer = 0;

        for (int secondPointer = 0; secondPointer < second.length;
             secondPointer++) {
            while ((firstPointer != first.length)
                    && (second[secondPointer] > first[firstPointer])) {
                firstPointer += 1;
                actualPointer += 1;
            }

            results[secondPointer] = actualPointer;
            actualPointer += 1;
        }

        return results;
    }
}
