package example1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vehiclesSystem.config.AppConfig;

public class Main1 {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

       Circle circle = (Circle) context.getBean("circle");
        circle.draw();


      Rectangle rectangle = (Rectangle) context.getBean("rectangle");
      rectangle.draw();


      Triangle triangle = (Triangle) context.getBean("triangle");
      triangle.draw();

    }

    }
