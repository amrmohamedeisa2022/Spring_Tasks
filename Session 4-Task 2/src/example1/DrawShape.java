package example1;

import org.springframework.stereotype.Component;

@Component
public class DrawShape {

    public void Draw(String shapeName)
    {
        System.out.printf("%s is now drawing\n",shapeName);
    }


}
