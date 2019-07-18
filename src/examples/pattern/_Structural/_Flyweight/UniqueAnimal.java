package examples.pattern._Structural._Flyweight;

/**
 * Объект с уникальным состоянием.
 * Содержит в себе "Легковес"
 */
public class UniqueAnimal {

    private int longCall;
    private TypeAnimal typeAnimal;

    public UniqueAnimal(int longCall, TypeAnimal typeAnimal) {
        this.longCall = longCall;
        this.typeAnimal = typeAnimal;
    }

    public void showAll() {
        typeAnimal.makeCall(longCall);
    }
}
