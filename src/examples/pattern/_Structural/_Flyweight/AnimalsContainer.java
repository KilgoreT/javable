package examples.pattern._Structural._Flyweight;

import java.util.ArrayList;
import java.util.List;

public class AnimalsContainer {

    List<UniqueAnimal> list = new ArrayList<>();

    public void addProps(String title, String call, int longCall) {
        TypeAnimal typeAnimal = TypeFactory.getTypedProps(title, call);
        UniqueAnimal uniqueAnimal = new UniqueAnimal(longCall, typeAnimal);
        list.add(uniqueAnimal);
    }

    public void boooo() {
        for (UniqueAnimal item : list) {
            item.showAll();
        }
    }
}
