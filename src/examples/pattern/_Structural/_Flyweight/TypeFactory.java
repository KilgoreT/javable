package examples.pattern._Structural._Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика легковесов
 */
public class TypeFactory {

    static Map<String, TypeAnimal> allTypes = new HashMap<>();

    public static TypeAnimal getTypedProps(String type, String call) {

        TypeAnimal result = allTypes.get(type);

        if (result == null) {
            result = new TypeAnimal(type, call);
            allTypes.put(type, result);
        }
        return result;
    }

}
