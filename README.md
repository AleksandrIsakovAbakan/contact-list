# contact-list
# 3.8 Practical work

Приложение "Список контактов" разработано в рамках практической работы по курсу Разработка на Spring Framework (раздел "Web application with database").

Описание работы приложения:

1. Выводит все контакты в таблице.

2. Добавляет новый контакт через форму.

3. Редактирует существующие контакты через форму.

4. Удалять конкретный контакт через кнопку в списке контактов.


Настройки работы программы осуществляются через изменение application.properties.

- server.port=8085 - настройка порта для страницы запуска приложения в браузере (пример: http://localhost:8085/)

- spring.datasource.url=jdbc:postgresql://localhost:5434/postgres - настройка порта доступа к базе данных.

- spring.datasource.username=postgres - настройка имени пользователя для доступа к базе данных.

- spring.datasource.password=postgres - настройка пароля пользователя для доступа к базе данных.

Настройка базы данных осуществляется через изменение docker-compose.yml.
Имя пользователя, пароль и название базы данных в параметрах docker-compose.yml должно соответствовать данным в application.properties.

image: postgres:12.3 - версия postgres.

ports:
      - 5434:5432 - порты для работы базы данных в контейнере (правый порт должен соответствовать порту в
application.properties spring.datasource.url).

environment: - переменные для работы базы данных.

- POSTGRES_USER=postgres - имя пользователя для доступа к базе данных.

- POSTGRES_PASSWORD=postgres - пароль пользователя для доступа к базе данных.

- POSTGRES_DB=postgres - имя рабочей базы данных.

volumes:
- ./init.sql:/docker-entrypoint-initdb.d/init.sql - настройка инициализации базы данных (создание таблицы).