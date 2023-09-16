package by.lab1.task1;

import static java.lang.Math.abs;
import static java.lang.Math.sin;

public class TaskExpression {
    public double getValue(double x, double y) {
        return ((1 + sin(x + y) * sin(x + y)))
                / (2 + abs(x - (2 * x) / (1 + x * x * y * y)))
                + x;
    }
}
