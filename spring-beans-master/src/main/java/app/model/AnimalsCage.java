package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class AnimalsCage {

    private final Animal animal;
    private final Animal animal1;
    private final Timer timer;

    @Autowired
    public AnimalsCage(@Qualifier("dog") Animal animal, @Qualifier("cat") Animal animal1, @Qualifier("timer") Timer timer) {
        this.animal = animal;
        this.animal1 = animal1;
        this.timer = timer;

    }



    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString());
        System.out.println("At:");
        System.out.println(timer.getTime());
        System.out.println("________________________");
    }

    public Timer getTimer() {
        return timer;
    }
}
