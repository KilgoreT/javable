package examples.pattern._Structural._Flyweight;

/**
 * Легковес, содержащий общее состояние нескольких объектов
 * type - биологический вид
 * typedCall - крик, например, "кря" или "хуяк-хуяк и в продакшн", и это поле занимает очень много памяти
 */
public class TypeAnimal {

    private String type;
    private String typedCall;

    public TypeAnimal(String type, String typedCall) {
        this.type = type;
        this.typedCall = typedCall;
    }

    public void makeCall(int longCall) {
        System.out.println(typedCall.repeat(longCall));
    }
}
