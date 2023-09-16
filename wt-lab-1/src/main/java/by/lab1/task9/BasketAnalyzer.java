package by.lab1.task9;

public class BasketAnalyzer {
    public double getBallsWeight(Basket basket) {
        return basket.getBalls().stream().mapToDouble(Ball::weight).sum();
    }

    public long getBallsWithColor(Basket basket, Color color) {
        return basket.getBalls().stream()
                                .filter(ball -> ball.color() == color)
                                .count();
    }
}
