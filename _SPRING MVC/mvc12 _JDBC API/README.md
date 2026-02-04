# JDBC API

<img width="1404" height="1070" alt="image" src="https://github.com/user-attachments/assets/c53de064-7b4f-47c3-b160-c84f3eb0a0c9" />

<img width="1397" height="1069" alt="image" src="https://github.com/user-attachments/assets/528409d4-3637-46be-856c-4d947bf56983" />

<img width="1413" height="1076" alt="image" src="https://github.com/user-attachments/assets/ed8d0181-8ba7-4099-8c08-30321d8b0792" />

**с помощью DDL мы создаем сущности, а с помощью DML - манипулируем данными**

<img width="1422" height="1079" alt="image" src="https://github.com/user-attachments/assets/6d921c82-ecad-4e80-9a74-9b1d5f90339b" />

#### для подключения зависимости для базы данных
```
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.9</version>
    <scope>compile</scope>
</dependency>
```


``` private static final String URL = "jdbc:postgresql://localhost:5432/person"; //данные для подключения к базе данных, обычно пишется в отдельном файле, тут для примера 
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "div3";

    private static Connection connection;  //для подключения к базе данных 

    static{
        try {
            Class.forName("org.postgresql.Driver"); //подгрузили драйвер для подключения, в новых версия это делается автоматически
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //подключение к базе данных
        } catch (ClassNotFoundException | SQLException e) { //исключение для первой строчки и для второй
            e.printStackTrace();
        }
    }
```

из-за JDBC любая ошибка связанная с базой данных будет SQLException, так так точно нельзя опеределить что за ошибка

```
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
```
