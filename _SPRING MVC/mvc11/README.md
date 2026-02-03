# ВАЛИДАЦИЯ ФОРМ (проверка значений полей)
#### зависимость для валидации
```<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.1.6.Final</version>
    <scope>compile</scope>
</dependency>
```
#### используем аннотации на полях класса персон, так как он сязан с формами
<img width="862" height="376" alt="image" src="https://github.com/user-attachments/assets/0b2c9370-25ee-4106-bb21-0396384e9786" />

#### в методе перед классом персон указываем аннотацию и теперь будут отрабатывать аннотации из полей класса персон
<img width="715" height="310" alt="image" src="https://github.com/user-attachments/assets/9aa32b5a-9d08-4158-8833-cc7e1a867525" />

**аргумент BindingResult прописывается сразу после аргумента с аннотацией @Valid и в нем будут храниться все ошибки валидации**

#### в форме в xml файле добавляем строку ч текстом об ошибках
<img width="1120" height="502" alt="image" src="https://github.com/user-attachments/assets/ef05438d-e750-4b40-b08e-de87539b2231" />

**th:if = "${#fields.hasErrors('email')}** ----> если есть ошибка в емеил, то выводит ошибки из аннотаций в Person ----> **th:errors ="*{email}"**

```
   <div style="color: red" th:if = "${#fields.hasErrors('email')}" th:errors ="*{email}">Email error</div>
```
<img width="420" height="268" alt="image" src="https://github.com/user-attachments/assets/eb9bb647-0af9-4303-8c47-a9cc0077fa8e" />
