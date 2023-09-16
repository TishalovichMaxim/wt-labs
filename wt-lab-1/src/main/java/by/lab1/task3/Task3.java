package by.lab1.task3;

import java.util.List;

public class Task3 {
    private double[][] convertPointList(List<Point> points) {
        double[][] result = new double[2][];
        double[] x = points.stream().mapToDouble(Point::x).toArray();
        double[] y = points.stream().mapToDouble(Point::y).toArray();

        result[0] = x;
        result[1] = y;

        return result;
    }

    public double[][] solve(double a, double b, double h) {
        FuncCutter funcCutter = new FuncCutter();
        List<Point> points = funcCutter.cut(Math::tan, a, b, h);
        if (points == null) {
            return null;
        }
        return convertPointList(points);
    }
}
