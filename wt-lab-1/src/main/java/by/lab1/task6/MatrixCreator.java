package by.lab1.task6;

public class MatrixCreator {
    public double[][] create(double[] initValues) {
        double[][] matrix = new double[initValues.length][initValues.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = initValues[(j + i) % initValues.length];
            }
        }

        return matrix;
    }
}
