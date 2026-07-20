package session_2_task;

public class Circle implements Shape {

    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
}
