package by.lab1.task9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BasketAnalyzerTest {
    @Test
    void testGetBallsWeight() {
        Basket basket = new Basket();
        Ball ball1 = new Ball(Color.BLUE, 2);
        Ball ball2 = new Ball(Color.RED, 3);
        Ball ball3 = new Ball(Color.GREEN, 4);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        BasketAnalyzer basketAnalyzer = new BasketAnalyzer();
        assertTrue(Math.abs(
                basketAnalyzer.getBallsWeight(basket) - 9) < 0.0001);
    }

    @Test
    void testGetBallsWithColor() {
        Basket basket = new Basket();
        Ball ball1 = new Ball(Color.BLUE, 2);
        Ball ball2 = new Ball(Color.RED, 3);
        Ball ball3 = new Ball(Color.RED, 4);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        BasketAnalyzer basketAnalyzer = new BasketAnalyzer();
        assertEquals(2, basketAnalyzer.getBallsWithColor(basket, Color.RED));
    }
}
