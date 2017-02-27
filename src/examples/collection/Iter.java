package examples.collection;

import java.util.Iterator;

/**
 * Использование Iterarable.
 */
public class Iter {
    public static void main(String[] args) {
           Fridge fridge = new Fridge();
           Food[] food = {new Food("apple"), new Food("pineapple"), new Food("cake")};
           fridge.setFood(food);

        /**
         * Так как Fridge имплементирован Iterable,
         * и в реализован метод iterator,
         * в который возвращает класс-наследник от i Iterator,
         * который в свою очередь реализует методы:
         * hasNext() и next(),
         * то foreach будет работать.
         */
        System.out.println("Использование foreach:");
        for (Food f: fridge) {
               System.out.println(f);
        }

        /**
         * Собственно, можно перечисление элементов
         * построить и через сам iterator.
         */
        System.out.println("\nИспользование iterator:");
        Iterator<Food> iterator = fridge.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * Благодаря имплементации Iterable
 * элементы Food класса Fridge
 * можно запросить через foreach.
 */
class Fridge implements Iterable<Food> {
    private Food[] food = new Food[0];
    void setFood(Food[] food) {
        this.food = food;
    }

    /**
     * Для имплементации нужно реализовать метод iterator,
     * который возвращает класс,
     * унаследованный от i Iterator.
     */
    @Override
    public Iterator<Food> iterator() {
        return new ArrayIterator<>(food);
    }
}

/**
 * Класс, унаследованный от i Iterator.
 * должен реализовать как минимум 2 метода:
 *  - hasNext() - возвращает boolean о том, закончился ли массив.
 *  - next() - возвращает следующий элемент массива.
 */
class ArrayIterator<T> implements Iterator<T> {
    private final T[] data;
    private int index = 0;

    public ArrayIterator(T[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public T next() {
        return data[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

class Food {
    public String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
