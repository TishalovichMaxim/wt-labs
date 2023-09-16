package by.lab1.task9;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Ball> balls = new ArrayList<>();

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
