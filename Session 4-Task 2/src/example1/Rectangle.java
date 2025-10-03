package example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Rectangle implements Shape {

    private DrawShape drawShape;
    private int height;
    private int width;

    public Rectangle() {
    }

    @Override
    public void draw() {
       drawShape.Draw(getShapeName());

    }

    @Override
    public String getShapeName() {
        return "rectangle";
    }
@Autowired
    public void setDrawShape(DrawShape drawShape) {
        this.drawShape = drawShape;
    }

    public DrawShape getDrawShape() {
        return drawShape;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}