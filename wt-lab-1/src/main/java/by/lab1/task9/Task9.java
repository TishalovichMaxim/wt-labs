package by.lab1.task9;

public class Task9 {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Ball ball1 = new Ball(Color.BLUE, 2);
        Ball ball2 = new Ball(Color.RED, 3);
        Ball ball3 = new Ball(Color.RED, 4);
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        BasketAnalyzer basketAnalyzer = new BasketAnalyzer();

        System.out.println("Number of balls with blue color = "
                + basketAnalyzer.getBallsWithColor(basket, Color.BLUE));

        System.out.println("Basket weight = "
                + basketAnalyzer.getBallsWeight(basket)
                + "kg");
    }
}
