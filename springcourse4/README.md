ЧЕРЕЗ СЕТЕР
в таком способе спринг ищет метод под названием set + Name и в классе должен быть сеттер 
<img width="523" height="140" alt="image" src="https://github.com/user-attachments/assets/87372013-ec73-4c88-8388-b636c8dde068" />

установка знаечний в методы setName and setVolume
<img width="460" height="61" alt="image" src="https://github.com/user-attachments/assets/97d10940-ab58-400e-8ae6-1eb9b66bbcda" />

ЧЕРЕЗ ФАЙЛ
создаем отдельный файл с разрешением .properties и импортируем его в applicationContext.xml
img width="443" height="118" alt="image" src="https://github.com/user-attachments/assets/062f9a0f-d535-46f3-a2e0-96caf7d45ab7" />
прописываем путь к файлу в context:property-placeholder через classpath и в занчениех методов set ставим `${}` - берет значения из файла по названию внутри
<img width="791" height="381" alt="image" src="https://github.com/user-attachments/assets/2150130a-6546-4c10-80ee-8a969e3e32c0" />
