package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return OptionalInt.empty().isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            int currentAge = age.getAsInt();
            age = OptionalInt.of(currentAge + 1);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Имя  = " + name + '\n' +
                "Фамилия = " + surname + '\n' +
                "Возраст = " + age + '\n' +
                "Адрес = " + address + "\n";
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname());
    }
}
