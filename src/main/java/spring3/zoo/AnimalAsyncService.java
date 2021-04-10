package spring3.zoo;

import spring3.zoo.food.Food;

import java.util.concurrent.CompletableFuture;

public interface AnimalAsyncService {
    void feedAnimal(Food food, Animal animal);
    CompletableFuture<Double> getAverageAnimalsAge();
}
