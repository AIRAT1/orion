package spring3.zoo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring3.zoo.event.AnimalIsHungryEvent;
import spring3.zoo.impl.Cat;
import spring3.zoo.impl.Dog;

@Component
public class EventListenerExample {
    @EventListener
    public void catIsHungryEventListener(AnimalIsHungryEvent<Cat> catAnimalIsHungryEvent) {
        System.out.println("catIsHungryEventListener");
    }

    @EventListener
    public void dogIsHungryEventListener(AnimalIsHungryEvent<Dog> dogAnimalIsHungryEvent) {
        System.out.println("dogIsHungryEventListener");
    }

    @EventListener
    public void anyAnimalIsHungryEventListener(AnimalIsHungryEvent anyAnimalIsHungryEvent) {
        System.out.println("anyAnimalIsHungryEventListener");
    }
}
