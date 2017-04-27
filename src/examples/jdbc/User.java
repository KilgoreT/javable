package examples.jdbc;

/**
 * Created by apomazkin on 27.04.2017.
 */
public class User {
    int id;
    String login;
    int age;

    public User(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", age=" + age +
                '}';
    }
}
