package examples.pattern._00_Base._07_Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Данный пример показывает, как создать заменитель для {@link Map}
 * который клонирует себя для избежания блокировки объекта в многопоточности.
 * Но заменитель не сразу клонирует объект, а делает это только в тех случаях,
 * когда это необходимо, например, перед тем,
 * как вызываются изменяющие {@link Map} методы.
 * Если базовый объект не изменялся - то не возникает затрат на клонирование.
 */

public class LazyCloneMap implements Map, Cloneable {

    /**
     * Класс заместитель {@link LazyCloneMap} ссылается
     * на базовый класс {@link Map} - underlyingMap
     */
    private Map underlyingMap;
    /**
     * Объекты {@link LazyCloneMap} знают,
     * когда они совместно используют базовый {@link Map}
     * с помощью счетчика refCount,
     * вычисляющий количество ссылок на {@link Map}.
     */
    private MutableInteger refCount;
    /**
     * {@link Map} clone() - защищенный.
     * Поэтому доступ только через java.lang.reflect.{@link Method};
     */
    private Method cloneMethod;
    private static Class[] cloneParams = new Class[0];

    /**
     * Конструктор
     * @param underlyingMap - базовый объект {@link Map}
     * @throws NoSuchMethodException - если базовый {@link Map} не содержит clone().
     * @throws InvocationTargetException - если метод clone() генерит исключение,
     * то getCause() базового возвращается через это ислючение.
     */
    public LazyCloneMap(Map underlyingMap) throws NoSuchMethodException, InvocationTargetException {
        Class mapClass = underlyingMap.getClass();
        cloneMethod = mapClass.getMethod("clone", cloneParams);
        try {
            this.underlyingMap = (Map)cloneMethod.invoke(underlyingMap, null);
        } catch (IllegalAccessException e) {
            // do not do this way!
        }
        refCount = new MutableInteger(1);

    }


    /**
     * Метод clone() не копирует базовый класс.
     * А лишь наращивает счетчик ссылок на базовый класс.
     * Если refCount > 1, значит объекты {@link LazyCloneMap}
     * совместно используют общий объект {@link Map}
     * @return - возвращает ссылку на тот же самый объект.
     */
    @Override
    protected Object clone() {
        LazyCloneMap theClone;
        try {
            Cloneable original = (Cloneable) underlyingMap;
            theClone = (LazyCloneMap) super.clone();
        } catch (CloneNotSupportedException e) {
            //
            theClone = null;
        }
        refCount.setValue(1 + refCount.getValue());
        return theClone;
    }

    /**
     * Вызывается открытыми методами, которые меняют базовый объект {@link Map}
     *
     */
    private void ensureUnderlyingMapNotShared() {
        // если базовый объект шарится между другими LazyCloneMap
        if (refCount.getValue() > 1) {
            try {
                // то создается своя собственная копия базового объекта,
                // которая уже не совместно используемая
                underlyingMap = (Map) cloneMethod.invoke(underlyingMap, null);
                // поэтому уменьшаем счетчик у других объектов LazyCloneMap
                refCount.setValue(refCount.getValue() - 1);
                // а себе создаем новый, со значением 1.
                refCount = new MutableInteger(1);
            } catch (IllegalAccessException e) {
                //
            } catch (InvocationTargetException e) {
                // если нас постигла неудачка, сообщаем причину.
                Throwable cause = e.getCause();
                throw new RuntimeException("clone failed", cause);
            }
        }
    }

    /**
     * Остальные методы делегируют свои функции методам базового класса.
     */
    @Override
    public int size() {
        return underlyingMap.size();
    }

    @Override
    public boolean isEmpty() {
        return underlyingMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return underlyingMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return underlyingMap.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return underlyingMap.get(key);
    }

    /**
     * А когда вызываем метод, который меняет базовый объект,
     * вызываем ensureUnderlyingMapNotShared,
     * чтобы быть уверенными, что изменяем не совместный базовый объект.
     */
    @Override
    public Object put(Object key, Object value) {
        ensureUnderlyingMapNotShared();
        return underlyingMap.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        ensureUnderlyingMapNotShared();
        return underlyingMap.remove(key);
    }

    @Override
    public void putAll(Map m) {
        ensureUnderlyingMapNotShared();
        underlyingMap.putAll(m);

    }

    @Override
    public void clear() {
        ensureUnderlyingMapNotShared();
        underlyingMap.clear();
    }

    @Override
    public Set keySet() {
        return underlyingMap.keySet();
    }

    @Override
    public Collection values() {
        return underlyingMap.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return underlyingMap.entrySet();
    }
}
