package spring3.zoo.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring3.zoo.Animal;

@Component
@Qualifier("dogQualifier")
public class Dog implements Animal {
    private Integer age;

    @Override
    public void voice() {
        System.out.println("gav");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
