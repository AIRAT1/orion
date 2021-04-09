package spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring3.configuration.AnnotationConfiguration;
import spring3.zoo.Animal;
import spring3.zoo.Zoo;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = getXmlContext();
        ApplicationContext context = getAnnotationContext();
        Zoo zoo = context.getBean("zoo", Zoo.class);
        zoo.getAnimal1().voice();
        zoo.getAnimal2().voice();
        zoo.getAnimals().forEach(Animal::voice);
        System.out.println(zoo.getName());
    }

    private static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }

    private static ApplicationContext getXmlContext() {
        return new ClassPathXmlApplicationContext("XmlApplicationContext.xml");
    }
}
