package examples.pattern._00_Base;

import examples.pattern._00_Base._01_Delegation.Person;

/**
 * Мотив 1:
 * Если наследование описывает отношения "is a kind of",
 * то делегирование описывает отношения "is a role played by".
 * Т.е. при делегировании экземпляры класса могут примерять на себя несколько ролей сразу,
 * в отличии от наследования, где отношение не меняется со временем.
 * Мотив 2:
 * при наследовании сложно скрыть реализацию унаследованного от super,
 * при делегировании, все очень хорошо скрывается.
 * Мотив 3:
 * "функциональный класс" не должен быть подклассом вспомогательного класса.
 *
 * Человек может работать пилотом, может быть пассажиром и может бухать.
 * При этом, эти роли могут быть разные в разное время.
 * Быть пилотом, противоречит остальным двум ролям,
 * при этом две оставшиеся роли не противоречат друг другу.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.fly(5000);
        person.drink("vine");
        person.becomePassenger();
        person.drink("vine");

    }
}

/**
 * Недостатки:
 *  - меньшая структурированность, чем при наследовании;
 *  - отношения между классами менее очевидны;
 *  - приходится писать больше кода;
 */
