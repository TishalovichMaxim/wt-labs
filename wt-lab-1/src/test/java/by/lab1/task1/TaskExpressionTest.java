package by.lab1.task1;


import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TaskExpressionTest {
    private static final double EPS = 0.0001;

    @Test
    void testExpressionGetValue() {
        TaskExpression taskExpression = new TaskExpression();
        assertTrue(abs(taskExpression.getValue(0,
                2) - 0.913410905215903) < EPS);
        assertTrue(abs(taskExpression.getValue(3.1234,
                0) - 3.3186474794339604) < EPS);
        assertTrue(abs(taskExpression.getValue(1.2344,
                2.5544) - 1.6875940310701842) < EPS);
    }
}
