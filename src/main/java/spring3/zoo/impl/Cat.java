package spring3.zoo.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring3.zoo.Animal;

@Component
@Qualifier("catQualifier")
public class Cat implements Animal {
    @Override
    public void voice() {
        System.out.println("mi");
    }
}
