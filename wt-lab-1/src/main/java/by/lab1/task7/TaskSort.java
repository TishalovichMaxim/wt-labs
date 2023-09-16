package by.lab1.task7;

public class TaskSort {
    private void swap(double[] arr, int a, int b) {
        double val = arr[a];
        arr[a] = arr[b];
        arr[b] = val;
    }

    public void sort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while ((j != -1) && (arr[j] > arr[j + 1])) {
                swap(arr, j, j + 1);
                j -= 1;
            }
        }
    }
}
