package javalabs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MagicApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String beanName = args[0];
        Magician magician = (Magician) context.getBean(beanName);
        magician.doMagic();
    }

}
