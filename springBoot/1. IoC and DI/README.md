<img width="1340" height="749" alt="image" src="https://github.com/user-attachments/assets/425f0a28-cf17-4ca4-9f0b-e6619b41f13e" /># IOC. Способы создания бинов

### 1.
<img width="1667" height="784" alt="image" src="https://github.com/user-attachments/assets/b5012c32-a035-4739-95ac-4860737ec563" />

когда спринг видит эти аннотации, он понимает, что нужно создать класс в Application Context

**@Autowired** - показывает. что нужно подтянуть бины из Application Context(если конструктор 1, то указывать необязательно)

**@Component** - базовая аннотация 

<img width="1843" height="915" alt="image" src="https://github.com/user-attachments/assets/301d375f-24db-44da-882f-9b2c8fd67707" />

### 3.
<img width="1838" height="891" alt="image" src="https://github.com/user-attachments/assets/00af622b-d577-4b54-9261-166c3e89526e" />

# DI

<img width="1705" height="734" alt="image" src="https://github.com/user-attachments/assets/16d27f8c-3831-4cba-a823-26695eb67360" />

## IOC. Способы создания бинов

<img width="1476" height="94" alt="image" src="https://github.com/user-attachments/assets/37a0facc-6df7-4331-b432-e2df7d8ab474" />

### 1. Field Injection(не рекомендуется)
<img width="1041" height="409" alt="image" src="https://github.com/user-attachments/assets/7f7879f7-7a4e-44aa-b88f-904e3a5e8471" />

указываем над полем аннотацию

### 2. Setter Injection
<img width="1340" height="749" alt="image" src="https://github.com/user-attachments/assets/fc44799c-6e2b-4a57-918c-0095cb10e8d1" />

через сеттер

### 3. Constructor Injection (самый простой и понятный)

<img width="1295" height="562" alt="image" src="https://github.com/user-attachments/assets/0b73f830-1823-4a02-aa89-63d2b9db0212" />

