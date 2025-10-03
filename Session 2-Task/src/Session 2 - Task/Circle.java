package Session;

public class Circle implements Shape {

private DrawShape drawShape;
private int radius;


public Circle(DrawShape drawShape)
{
    this.drawShape=drawShape;

}

public Circle(){}


    @Override
    public void draw() {
        drawShape.Draw(getShapeName());
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}
