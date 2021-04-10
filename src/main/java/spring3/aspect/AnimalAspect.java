package spring3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import spring3.zoo.food.Food;

@Aspect
@Component
public class AnimalAspect {
//    @Pointcut("execution(* spring3.zoo.Animal.voice())")
//    public void voicePoint() {
//
//    }
//
//    @Before(value = "voicePoint()")
//    public void beforeVoice() {
//        System.out.println("beforeVoice");
//    }

    @Pointcut("@annotation(spring3.aspect.annotationMarker.Marker)")
    public void annotationPointcut() {
    }

    @Pointcut("within(spring3.aspect.annotationMarker.Marker)")
    public void annotationWithinPointcut() {
    }

    @Pointcut("execution(* spring3.zoo.Animal.*(..))")
    public void anyAnimalMethod() {
    }

    @Pointcut("within(spring3.zoo.*)")
    public void anyAnimalMethodWithin() { // check only package
    }

    @Pointcut("args(food)")
    public void withArgs(Food food) {
    }

    @Before(value = "execution(* spring3.zoo.Animal.voice())")
    public void beforeVoice(JoinPoint joinPoint) {
        System.out.println("beforeVoice");
    }

    @Before(value = "anyAnimalMethod() && withArgs(food)", argNames = "food")
    public void beforeSetFood(Food food) {
        System.out.println(food.toString());
    }

    @Before(value = "annotationPointcut()")
    public void beforeServiceCall(JoinPoint joinPoint) {
        System.out.println("beforeVoice");
    }

    @AfterReturning(value = "execution(* spring3.zoo.Animal.getAge())", returning = "age")
    public void afterReturningExample(Integer age) {
        System.out.println("afterReturningExample " + age);
    }

    @AfterThrowing(value = "execution(* spring3.zoo.Animal.throwException())", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("afterThrowing " + e);
    }

    @Around(value = "anyAnimalMethod() && withArgs(food)", argNames = "joinPoint ,food")
    public Object around(ProceedingJoinPoint joinPoint, Food food) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        return result;
    }
}
