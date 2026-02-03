package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<Person>();

        people.add(new Person(++PEOPLE_COUNT,"Tom",24,"tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Anya",52,"anya@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Sam",34,"sam@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Alisa",72,"alisa@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setEmail(updatePerson.getEmail());
        personToBeUpdated.setAge(updatePerson.getAge());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }

}
