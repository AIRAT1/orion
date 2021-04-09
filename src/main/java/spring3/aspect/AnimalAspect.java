package spring3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnimalAspect {
    @Pointcut("execution(* spring3.zoo.Animal.voice())")
    public void voicePoint() {

    }

    @Before(value = "voicePoint()")
    public void beforeVoice() {
        System.out.println("beforeVoice");
    }
}
