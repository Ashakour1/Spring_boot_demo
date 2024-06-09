package com.example.demoPersonInfo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
    private final JdbcTemplate jdbcTemplate;

    public PersonServices(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPersons(){
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Person.class));
    }

       public void insertData(Person person){
        String sql = "INSERT INTO person(id, name , phone_number) VALUES(?,?,?)";
        jdbcTemplate.update(sql,person.getId(),person.getName(),person.getPhone_number());
    }


    public void updatePerson(Person person){
        String sql = "UPDATE person SET name = ? , phone_number = ?  WHERE id = ?";
        jdbcTemplate.update(sql,person.getName(),person.getPhone_number(),person.getId());
    }
    public void DeletePerson(int id){
        String sql = "DELETE FROM  person WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }



}
