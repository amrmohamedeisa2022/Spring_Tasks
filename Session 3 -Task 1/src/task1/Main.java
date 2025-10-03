package task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle = (Circle) context.getBean("circle");
        circle.drawShape();

        Square square = (Square) context.getBean("square");
        square.drawShape();

    }
}
