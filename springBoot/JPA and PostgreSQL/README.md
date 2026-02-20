<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/3bde2921-9979-4364-9d6c-053e0dffdb2e" />

<img width="1755" height="685" alt="image" src="https://github.com/user-attachments/assets/66578cf4-e204-44d3-b220-e8f414f936fe" />



```
spring.datasource.url=jdbc:postgresql://localhost:5555/postgres
spring.datasource.username=postgres
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

<img width="1786" height="1079" alt="image" src="https://github.com/user-attachments/assets/3100d25a-e34b-410d-a677-ccecc0105e6e" />


<img width="1473" height="792" alt="image" src="https://github.com/user-attachments/assets/a58662bd-f96c-446b-bf0f-be418d490ed3" />

<img width="1919" height="842" alt="image" src="https://github.com/user-attachments/assets/00a39cea-cd87-4308-a965-b9ea4fb779e6" />

```

    @Query("select r from ReservationEntity r where r.reservationStatus = :reservationStatus")
      List<ReservationEntity> findAllByStatusIs(ReservationStatus reservationStatus);
```

### тут используется JPQL, но если хотим писать на голом скл, то нужно написать после заапроса в скобках SQL

```
@Query(value = "select * from ReservationEntity r where r.reservationStatus = :reservationStatus", nativeQuery = true)
      List<ReservationEntity> findAllByStatusIs(ReservationStatus reservationStatus);
```

### если запрос обновляющий, то добавляем аннотацию @Modifying, и еще необходимо добавить @Transactional так так есть обновление 
