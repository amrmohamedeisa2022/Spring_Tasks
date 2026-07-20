package session_2_task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        Shape shape=new Circle(5);
//        shape.draw();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle = (Shape) context.getBean("circle");
        System.out.println("Area of Circle = : "+circle.getArea());
        Shape rectangle = (Shape) context.getBean("rectangle");
        System.out.println("Area of Circle = : "+rectangle.getArea());

    }
}
