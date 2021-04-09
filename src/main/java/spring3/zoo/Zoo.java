package spring3.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private Animal animal1;
    private Animal animal2;
    private List<Animal> animals;

//    @Autowired(required = false)
//    public Zoo() {
//    }

//    public Zoo(Animal animal1, Animal animal2, List<Animal> animals) {
//        this.animal1 = animal1;
//        this.animal2 = animal2;
//        this.animals = animals;
//    }

    @Autowired
    public Zoo(@Qualifier("catQualifier") Animal cat, @Qualifier("dogQualifier") Animal dog) {
        this.animal1 = cat;
        this.animal2 = dog;
    }

    public Animal getAnimal1() {
        return animal1;
    }

    public void setAnimal1(Animal animal1) {
        this.animal1 = animal1;
    }

    public Animal getAnimal2() {
        return animal2;
    }

    public void setAnimal2(Animal animal2) {
        this.animal2 = animal2;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Autowired
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
