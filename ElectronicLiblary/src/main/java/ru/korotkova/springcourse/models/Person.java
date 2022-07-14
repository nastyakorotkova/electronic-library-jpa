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

    @NotEmpty(message = "Fio should not be empty")
    @Size(min = 2, max = 100, message = "Fio should be between 2 and 30 characters")
    private String fio;

    @Min(1900)
    private int birthOfYear;

    public Person() {

    }

    public Person(int id, String fio, int birthOfYear) {
        this.id = id;
        this.fio = fio;
        this.birthOfYear = birthOfYear;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
