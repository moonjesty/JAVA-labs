package org.example.model;

import java.util.Objects;

// Абстрактний клас для представлення людини
public abstract class Human {
    private String firstName;  // Ім'я людини
    private String lastName;   // Прізвище людини
    private String middleName; // По батькові людини
    private Sex sex;           // Стать людини (чоловіча або жіноча)

    // Конструктор для створення людини з її ім'ям, прізвищем, по батькові та статтю
    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;  // Ініціалізація поля firstName
        this.lastName = lastName;    // Ініціалізація поля lastName
        this.middleName = middleName; // Ініціалізація поля middleName
        this.sex = sex;              // Ініціалізація поля sex
    }

    // Геттер для отримання імені людини
    public String getFirstName() {
        return firstName;
    }

    // Геттер для отримання прізвища людини
    public String getLastName() {
        return lastName;
    }

    // Геттер для отримання по батькові людини
    public String getMiddleName() {
        return middleName;
    }

    // Геттер для отримання статі людини
    public Sex getSex() {
        return sex;
    }

    // Переозначення методу equals для порівняння двох об'єктів типу Human
    @Override
    public boolean equals(Object o) {
        // Перевірка, чи це той самий об'єкт
        if (this == o) return true;

        // Перевірка, чи є об'єкт о типом Human
        if (!(o instanceof Human)) return false;

        // Приведення об'єкта до типу Human для порівняння
        Human human = (Human) o;

        // Порівняння полів firstName, lastName, middleName, і sex
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(middleName, human.middleName) &&
                sex == human.sex;
    }

    // Переозначення методу hashCode для генерації хеш-коду на основі полів класу
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, sex);
    }

    // Перелічення для статі: чоловіча або жіноча
    public enum Sex {
        MALE, FEMALE
    }
}
