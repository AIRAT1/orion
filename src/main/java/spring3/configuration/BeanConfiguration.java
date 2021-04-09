package spring3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring3.zoo.Animal;
import spring3.zoo.Zoo;
import spring3.zoo.impl.Cat;
import spring3.zoo.impl.Dog;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeanConfiguration {
    @Bean(name = "cat")
    @Scope("prototype")
    public Cat createCat() {
        return new Cat();
    }

    @Bean(name = "dog")
    public Dog createDog() {
        return new Dog();
    }

    @Bean(name = "animals")
    public List<Animal> createAnimals() {
        return Arrays.asList(createCat(), createDog());
    }

    @Bean(name = "animalsUseParams")
    public List<Animal> createAnimals(Animal cat, Animal dog) {
        return Arrays.asList(cat, dog);
    }

    @Bean(name = "zoo")
    public Zoo createZoo() {
        Zoo zoo = new Zoo(createCat(), createDog(), createAnimals());
        return zoo;
    }
}
