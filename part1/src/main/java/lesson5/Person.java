package lesson5;

import java.util.Objects;

/**
 * @author 18395435
 * @created_at 03/05/2020 - 16:00
 * @project InnopolisUniversity
 */

/**
 * Класс-сущность человека
 */
public class Person implements Comparable<Person> {
    /**
     * Имя
     */
    private String username;

    /**
     * Возраст
     */
    private int age;

    /**
     * Пол
     */
    private Sex sex;

    public enum Sex {
        FEMALE,
        MALE
    }

    public Person(String username, int age, Sex sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        return this.getUsername().compareTo(o.getUsername());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(username, person.username) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age, sex);
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
