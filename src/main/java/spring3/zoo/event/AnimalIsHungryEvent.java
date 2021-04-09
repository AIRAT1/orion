package spring3.zoo.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import spring3.zoo.Animal;

@Getter
@Setter
public class AnimalIsHungryEvent<T extends  Animal> extends ApplicationEvent {
    private T animal;

    public AnimalIsHungryEvent(T animal) {
        super(animal);
        this.animal = animal;
    }
}
