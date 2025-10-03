package example1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("circle")
@Scope("singleton")
public class Circle implements Shape {

private DrawShape drawShape;
private int radius;

@Autowired
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
