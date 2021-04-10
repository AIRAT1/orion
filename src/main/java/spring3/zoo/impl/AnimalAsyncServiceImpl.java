package spring3.zoo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import spring3.zoo.Animal;
import spring3.zoo.AnimalAsyncService;
import spring3.zoo.AnimalService;
import spring3.zoo.food.Food;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AnimalAsyncServiceImpl implements AnimalAsyncService {
    private final List<Animal> animals;
    private final AnimalService animalService;

    @Autowired
    public AnimalAsyncServiceImpl(List<Animal> animals, AnimalService animalService) {
        this.animals = animals;
        this.animalService = animalService;
    }

    @Override
    @Async("taskExecutor")
    public void feedAnimal(Food food, Animal animal) {
        System.out.println("Feed thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animalService.feedAnimal(food, animal);
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<Double> getAverageAnimalsAge() {
        System.out.println("Average age thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(
                animals.stream()
                .mapToInt(Animal::getAge)
                .average()
                .orElse(0)
        );
    }
}
