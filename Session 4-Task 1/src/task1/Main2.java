package task1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle1 = (Circle) context.getBean("circle");
      System.out.println(circle1);

        Circle circle2 = (Circle) context.getBean("circle");
        System.out.println(circle2);

   System.out.println("============================");
    Square square1 = (Square) context.getBean("square");
    System.out.println(square1);
    Square square2 = (Square) context.getBean("square");
    System.out.println(square2);

    context.close();

    }
}
