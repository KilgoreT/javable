package examples.pattern._01_Creational._03_Builder._00_Theory;

/**
 * Интерфейс {@link PathIF}
 * обязывает некие объекты реализовывать некие методы.
 * Весь смысл паттерна Builder заключается в том,
 * чтобы на выходе появлялись реализации {@link PathIF},
 * с реализованными методами которых
 * можно будет работать без оглядки на конкретную реализацию.
 * См. далее реализацию {@link examples.pattern._01_Creational._03_Builder._00_Theory.Paths.HuiPath}
 */
public interface PathIF {
    void send();
}
