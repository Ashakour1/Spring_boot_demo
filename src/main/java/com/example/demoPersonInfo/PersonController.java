package com.example.demoPersonInfo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping("/all")
    public List<Person> getAllPersons(){
        return personServices.getAllPersons();
    }

    @PostMapping("/add")
    public void insertData(@RequestBody Person person){
        personServices.insertData(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Person person){
        person.setId(id);
        personServices.updatePerson(person);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        personServices.DeletePerson(id);
    }





}









