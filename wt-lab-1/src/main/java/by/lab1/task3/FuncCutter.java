package by.lab1.task3;

import java.util.ArrayList;
import java.util.List;

public class FuncCutter {
    private static final double EPS = 0.0001;

    public List<Point> cut(Function function, double left,
                           double right, double step) {
        if (left > right) {
            return null;
        }

        List<Point> result = new ArrayList<>();
        result.add(new Point(left, function.getY(left)));

        double currX = left + step;
        while (currX < right) {
            result.add(new Point(currX, function.getY(currX)));
            currX += step;
        }

        return result;
    }
}
