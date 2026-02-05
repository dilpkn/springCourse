# JDBS Template

<img width="1414" height="1025" alt="image" src="https://github.com/user-attachments/assets/36c3b920-8318-41ca-ad5e-154c0292a3e8" />

<img width="1394" height="1079" alt="image" src="https://github.com/user-attachments/assets/1cfebb03-e8e7-49c2-9e23-7591563532cb" />

<img width="1397" height="1070" alt="image" src="https://github.com/user-attachments/assets/9f0b8f85-099f-4831-896f-9449ea73f98a" />

<img width="1416" height="1074" alt="image" src="https://github.com/user-attachments/assets/5d027b8a-9f9e-435e-b07c-52f0b12ae2e9" />
**используется зависимость**
```
<dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
      <scope>compile</scope>
    </dependency>
```

#### в SpringConfig создаем для jdbc бины
```
 @Bean
    public DataSource dataSours(){  //этот бин нужен jdbc template чтобы описать базу данных, чтобы он знал, куда подключаться
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        
        dataSource.setUrl("jdbc:postgresql://localhost:5432/PersonCRUD_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("div3");
        
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(){    //для работы с бд
        return new JdbcTemplate(dataSours())
    }
```

#### внедрение jdbc
<img width="528" height="242" alt="image" src="https://github.com/user-attachments/assets/0e6573e7-ca51-47d0-9f0c-0c8bca225e35" />

#### изменение методов с использование jdbc
```
   public List<Person> index() {
       return jdbcTemplate.query("select * from person", new PersonMapper());
               //первый аргумент sql запрос, второй роумаппер - отображает строки из таблицы в сущности(здесь в персон)
    }
```

```

    public Person show(int id){                                         //список элементов, которые заменяются на вопросы
        return jdbcTemplate.query("select * from person where id = ?",  new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);  //если нет такого айди, то будет возвращаться нулл

    }
```
**необходимо создать специальный класс, как будут данные получатся из базы в сущности(имплементирующий RowMapper)**
```
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}
```

#### либо если перевод в сущность очень тривиальный как у нас, чтобы не создавать RowMapper используем встроенный в jdbs - BeanPropertyRowMapper

```
  public List<Person> index() {
       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
               //первый аргумент sql запрос, второй роумаппер - отображает строки из таблицы в сущности(здесь в персон)
    }

    public Person show(int id){                                         //список элементов, которые заменяются на вопросы
        return jdbcTemplate.query("select * from person where id = ?",  new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);

    }

    
    public void save(Person person)  {                          //по другому синтаксис вставки и не нужен роумаппер
        jdbcTemplate.update("insert into person values(1,?,?,?)", person.getName(),person.getAge(),person.getEmail());
    }

```
### query - для получения
### update - для сохранения
