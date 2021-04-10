package spring3.zoo.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import spring3.zoo.Animal;
import spring3.zoo.AnimalAsyncService;
import spring3.zoo.food.Food;

@Service
public class AnimalAsyncServiceImpl implements AnimalAsyncService {
    @Override
    @Async
    public void feedAnimal(Food food, Animal animal) {

    }
}
