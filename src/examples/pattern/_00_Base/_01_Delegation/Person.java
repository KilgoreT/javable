package examples.pattern._00_Base._01_Delegation;


/**
 * Класс Delegator {@link Person}. Использует различные Delegatee.
 * В этом примере, {@link Pilot} выступает как Delegatee.
 * {@link Drinker} тоже выступает как Delegatee.
 * {@link Person} может и летать, и бухать. Возможно, одновременно.
 */
public class Person {
    private Pilot pilot;
    private Drinker drinker;
    private Passenger passenger;
    private boolean isFlying;

    public Person() {
        this.pilot = new Pilot();
        this.drinker = new Drinker();
        this.passenger = new Passenger();
        this.isFlying = false;
    }

    /**
     * Метод использует Delegatee {@link Pilot} и вызывает его метод.
     * При этом, можно использовать тоже название метода.
     * @param high высота полета
     */
    public void fly(int high) {
        isFlying = true;
        pilot.fly(high);
    }

    /**
     * Когда {@link Person} не летает, он бухает.
     * @param typeOfDrink вид бухла
     */
    public void drink(String typeOfDrink) {
        if (isFlying) {
            System.out.println("Pilot cannot drink!");
        } else {
            drinker.drink(typeOfDrink);
        }
    }

    /**
     * Чтобы бухать, {@link Person} должен стать {@link Passenger}
     */
    public void becomePassenger() {
        isFlying = false;
        passenger.becomePassenger();
    }
}
