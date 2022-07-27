package ru.korotkova.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.korotkova.springcourse.models.Book;
import ru.korotkova.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

/**
 * @author Anastasiia Korotkova
 */
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Book> getBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book where personid = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fullname, birthofyear) VALUES(?, ?)", person.getFullName(), person.getBirthOfYear());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET FullName=?, birthofyear=? WHERE id=?", updatedPerson.getFullName(),
                updatedPerson.getBirthOfYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getPersonByFIO(String fio) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE FullName = ?", new Object[]{fio},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

}
