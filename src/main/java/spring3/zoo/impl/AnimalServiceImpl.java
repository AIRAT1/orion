package spring3.zoo.impl;

import org.springframework.stereotype.Service;
import spring3.aspect.annotationMarker.Marker;
import spring3.zoo.Animal;
import spring3.zoo.AnimalService;
import spring3.zoo.food.Food;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Override
    @Marker
    public void feedAnimal(Food food, Animal animal) {
        animal.feed(food);
    }
}
