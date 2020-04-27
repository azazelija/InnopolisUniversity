package lesson2.task3;

/**
 * @author 18395435
 * @created_at 27/04/2020 - 21:56
 * @project InnopolisUniversity
 */

/**
 * Класс-сущность пользователя
 */
public class Person implements Comparable<Person>{
    private int age;
    private String name;
    private Sex sex;

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        if (o.sex == this.sex)
            return 0;
        return o.sex == Sex.MALE ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
