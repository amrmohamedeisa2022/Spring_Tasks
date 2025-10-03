package example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component // create bean from Tringle to inject it into triangle class
public class Triangle implements Shape {

    @Autowired // Spring will search for bean of type DrawShape
    private DrawShape drawShape;


    @Override
    public void draw() {
        drawShape.Draw(getShapeName());
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }
}
