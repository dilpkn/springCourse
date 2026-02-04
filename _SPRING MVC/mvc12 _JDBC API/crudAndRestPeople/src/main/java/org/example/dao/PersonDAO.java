package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/PersonCRUD_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "div3";

    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement() ; //объект, который содержит в себе скл запрос. на объекте коннектион созадем скл запрос к базе данных
            String SQL ="select * from person"; //пишем отдельно скл запрос, не обязательно

//            то, что вернулось из бд, будет храниться в ResultSet
            ResultSet resultSet = statement.executeQuery(SQL); // выполняем на статементе скл запрос

//            теперь каждую из строк придется вручную перевести в джава объект
            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

//    public Person show(int id){
//            return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//    }

    public void save(Person person)  {
        try {
            Statement statement = connection.createStatement();
            String SQL ="insert into person values(" +1 +", " + "'" +person.getName()+"'" + ", " + person.getAge()+ ", " + "'" +person.getEmail()+"'" + ")"; //так делать нехорошо, потом будет лучше
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(int id, Person updatePerson){
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
//        personToBeUpdated.setAge(updatePerson.getAge());
    }

    public void delete(int id){
     //   people.removeIf(person -> person.getId() == id);
    }

}
