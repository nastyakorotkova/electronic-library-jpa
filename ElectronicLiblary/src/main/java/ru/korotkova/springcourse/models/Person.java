package ru.korotkova.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;

/**
 * @author Anastasiia Korotkova
 */
public class Person {
    private int id;

    @NotEmpty(message = "ФИО не может быит пустым")
    @Size(min = 2, max = 100, message = "Длина поля ФИО должна быть от 2 от 100 символов")
    private String fullName;

    @Min(value = 1900, message = "Некорректный год рождения")
    private int birthOfYear;

    public Person() {

    }

    public Person(String fio, int birthOfYear) {
        this.fullName = fio;
        this.birthOfYear = birthOfYear;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fio) {
        this.fullName = fio;
    }

    public int getBirthOfYear() {
        return birthOfYear;
    }

    public void setBirthOfYear(int birthOfYear) {
        this.birthOfYear = birthOfYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
