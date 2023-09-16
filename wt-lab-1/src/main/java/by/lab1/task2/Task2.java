package by.lab1.task2;

public class Task2 {
    public boolean isPointInRect(Point point, Rectangle rectangle) {
        return (rectangle.cornerLeftUp().x() <= point.x()
                && rectangle.cornerLeftUp().y() >= point.y()
                && rectangle.cornerLeftUp().x() + rectangle.width() >= point.x()
                && rectangle.cornerLeftUp().y() - rectangle.height()
                    <= point.y());
    }

    public void solve(Point point) {
        Rectangle rectangle1 = new Rectangle(new Point(-4, 5), 8, 5);
        Rectangle rectangle2 = new Rectangle(new Point(-6, 0), 12, 3);

        boolean result = isPointInRect(point, rectangle1)
                || isPointInRect(point, rectangle2);

        System.out.print(result);
    }
}
