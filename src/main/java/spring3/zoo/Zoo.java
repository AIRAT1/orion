package spring3.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import spring3.zoo.event.AnimalIsHungryEvent;

import java.util.List;

@Component
public class Zoo {
    private final Animal animal1;
    private final Animal animal2;
    private final List<Animal> animals;
    @Value("${name}")
    private String name;
    private final ApplicationEventPublisher eventPublisher;

//    @Autowired(required = false)
//    public Zoo() {
//    }

//    public Zoo(Animal animal1, Animal animal2, List<Animal> animals) {
//        this.animal1 = animal1;
//        this.animal2 = animal2;
//        this.animals = animals;
//    }

    @Autowired
    public Zoo(
            @Qualifier("catQualifier") Animal cat,
            @Qualifier("dogQualifier") Animal dog,
            List<Animal> animals,
            ApplicationEventPublisher eventPublisher) {
        this.animal1 = cat;
        this.animal2 = dog;
        this.animals = animals;
        this.eventPublisher = eventPublisher;
    }

    public void doAllAnimalsHungry() {
        animals.forEach(animal -> eventPublisher.publishEvent(new AnimalIsHungryEvent<>(animal)));
    }

    public Animal getAnimal1() {
        return animal1;
    }

    public Animal getAnimal2() {
        return animal2;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }
}
