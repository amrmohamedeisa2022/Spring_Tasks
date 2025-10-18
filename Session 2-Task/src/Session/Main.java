package Session;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        Session.ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = (Circle) context.getBean("circle");

        circle.draw();


       Rectangle rectangle = (Rectangle) context.getBean("rectangle");
        rectangle.draw();


    }

    }
