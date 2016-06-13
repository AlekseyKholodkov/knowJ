package _java8;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void lambdaTest() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aleksey", 31));
        persons.add(new Person("Anny", 31));
        persons.add(new Person("Vladimir", 3));
        persons.add(new Person("Andrey", 36));
        persons.add(new Person("Tatiana", 25));

        int sumAge = 0;
        int adultPersons = 0;
        double averageAge = 0;
        for (Person person : persons) {
            if (person.getAge() >= 18) {
                sumAge += person.getAge();
                adultPersons++;
            }
        }
        averageAge = (double) sumAge / adultPersons;
        System.out.println(averageAge);

        double averageAgeLambda = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(averageAgeLambda);
    }

    @Test
    public void depthTest() {

    }
}