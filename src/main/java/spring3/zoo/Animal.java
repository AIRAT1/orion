package spring3.zoo;

import spring3.zoo.food.Food;

public interface Animal {
    void voice();
    void feed(Food food);
    Integer getAge();
    void throwException();
}
