package task1;

public class Circle implements Shape{

    private double radius;
    private Draw2d draw2d;
    private Draw3d draw3d;

    public Circle(double radius) {
        this.radius = radius;

    }


    public Circle(Draw2d draw2d, Draw3d draw3d) {
        this.draw2d = draw2d;
        this.draw3d = draw3d;
    }


    @Override
    public void drawShape() {
        draw2d.Draw(getShapeName());
        draw3d.Draw(getShapeName());
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}
