package task1;

public class Square implements Shape{

private int length;
private Draw2d draw2d;
private Draw3d draw3d;


    public void setDraw2d(Draw2d draw2d) {
        this.draw2d = draw2d;
    }



    public void setDraw3d(Draw3d draw3d) {
        this.draw3d = draw3d;
    }


    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void drawShape() {
        draw2d.Draw(getShapeName());
        draw3d.Draw(getShapeName());
    }

    @Override
    public String getShapeName() {
        return "Square";
    }
}
