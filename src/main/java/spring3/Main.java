package spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring3.configuration.AnnotationConfiguration;
import spring3.configuration.BeanConfiguration;
import spring3.zoo.Animal;
import spring3.zoo.AnimalService;
import spring3.zoo.Zoo;
import spring3.zoo.food.Food;
import spring3.zoo.food.FoodType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = getXmlContext();
        ApplicationContext context = getAnnotationContext("annotationConfiguration");
//        Zoo zoo = context.getBean("zoo", Zoo.class);
//        zoo.getAnimal1().voice();
//        zoo.getAnimal2().voice();
//        zoo.getAnimals().forEach(Animal::voice);
//        System.out.println(zoo.getName());

//        zoo.doAllAnimalsHungry();
//        System.out.println(context.getEnvironment());

//        AnimalService animalService = context.getBean("animalServiceImpl", AnimalService.class);
//        Animal cat = context.getBean("cat", Animal.class);
//        animalService.feedAnimal(
//                Food.builder().foodType(FoodType.FISH).
//                        expiredDate(LocalDateTime.now().plusHours(3L)).
//                        value(BigDecimal.valueOf(10)).build(), cat);
//        cat.getAge();
//        cat.throwException();
    }

    private static ApplicationContext getAnnotationContext(String profile) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles(profile);
        annotationConfigApplicationContext.register(AnnotationConfiguration.class, BeanConfiguration.class);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }

    private static ApplicationContext getXmlContext() {
        return new ClassPathXmlApplicationContext("XmlApplicationContext.xml");
    }
}
