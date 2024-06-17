package ru.netology;

import java.util.OptionalInt;

public class PersonBuilder {
    public String name = null;
    public String surname = null;
    public OptionalInt age = null;
    public String address = null;
    Person person;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        try {
            if (surname == null || name == null) {
                throw new IllegalArgumentException("Не передан один из основных  параметров имя или фамилия");
            }
            if (age == null) {
                person = new Person(name, surname);
            } else {
                int intAge = age.getAsInt();
                if (intAge < 0) {
                    throw new IllegalArgumentException("Возраст не может быть отрицательным");
                } else {
                    person = new Person(name, surname, age);
                }
            }
            if (address != null && !address.isEmpty()) {
                person.setAddress(address);
            }
            return person;

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }


}
