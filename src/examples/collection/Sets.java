package examples.collection;

import java.util.*;


public class Sets {
    public static void main(String[] args) {

        Random rand = new Random(0);

        // TreeSet из String работает и сортирует.
        SortedSet<String> ssString = new TreeSet();
        ssString.add("Z");
        ssString.add("A");
        ssString.add("M");
        System.out.println(ssString.toString());

        // Класс внутри должен быть Comparable.
        // иначе вылетит ClassCastException.
        // в
        SortedSet<User> ssUser = new TreeSet<>();
        ssUser.add(new User("user1", 4));
        ssUser.add(new User("user2", 2));
        System.out.println(ssUser.toString());

        /**
         *  Admin не имплементирует i Comporable
         *  но в конструкторе стоит класс,
         *  имплементирующий i Comporator.
         *  Этих классов может быть много,
         *  так как критериев сравнения может быть много.
         *  Comporator имеет больше веса, чем Comporable,
         *  если указаны оба.
         */
        SortedSet<Admin> ssAdmin = new TreeSet<>(new NameComparator());
        ssAdmin.add(new Admin("adm1", 7));
        ssAdmin.add(new Admin("adm2", 2));
        ssAdmin.add(new Admin("megaadmin", 1));
        System.out.println(ssAdmin.toString());

        /**
         * NavigableSet для реализации взятия подмножества:
         * subset, headset, tailset
         */
        NavigableSet<Integer> nsInteger = new TreeSet<>();
        for (int i = 0; i < 200; i++) {
            nsInteger.add(rand.nextInt(1000));
        }
        for (int i = 0; i < 10; i++) {
            int fromElement = 100 * i;
            int toElement = 100 * (i + 1);
            NavigableSet<Integer> subset = nsInteger.subSet(fromElement, true, toElement, false);
            System.out.println("[" + fromElement + " " + toElement + "):" + subset.toString());
        }
        Map<Integer, Integer> histogram = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            int fromElement = 100 * i;
            int toElement = 100 * (i + 1);
            NavigableSet<Integer> subset = nsInteger.subSet(fromElement, true, toElement, false);
            histogram.put(i, subset.size());
        }
        System.out.println(histogram);

    }
}

class User implements Comparable<User>{
    protected String name;
    protected int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * метод compareTo наследуется от i Comparable
     * реализующий сортировку по критерию:
     *  отрицательное число - критерий меньше
     *  ноль - критерии объектов равны
     *  положительное число - критерий больше
     */
    @Override
    public int compareTo(User that) {
        //return this.age - that.age;
        return this.name.compareTo(that.name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


// не имплементирует i Comporable
class Admin {
    protected String name;
    protected int age;

    public Admin(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
* класс Comporator, реализующий сортировку
* по полю age в методе compare.
*/
class AgeComparator implements Comparator<Admin> {

    @Override
    public int compare(Admin admin1, Admin admin2) {
        return admin1.age - admin2.age;
    }
}


/**
 * класс Comporator, реализующий сортировку
 * по полю name в методе compare.
 */
class NameComparator implements Comparator<Admin> {

    @Override
    public int compare(Admin admin1, Admin admin2) {
        return admin1.name.compareTo(admin2.name);
    }
}