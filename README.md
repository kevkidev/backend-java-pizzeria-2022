# About
This is a POC/MVP project to let me use my JAVA et programming skills.

## Skills used (not exhaustive):
- Java 8
- JDBC
- JPA / Hibernate
- Spring IOC
- Spring ORM
- Spring transtation
- Spring Data
- Posgres
- Eclipse
- reading .properties file using annotations
- ... (coming soon)

## Designs/principals/Architectures (not exhaustive):
- SOLID
- DRY
- ACID
- OOP
- functionnal programming (stream)
- ... (coming soon)

# Config

## Database
- You have to install postgres
- sync the password present into the `persistence.xml` and the role one:
	- use this SQL : `ALTER USER postgres PASSWORD 'my_postgres_password';`
- create a database named `pizzeria` and a schema named `schema1`

## Java xml formater
- import this formatter into eclispe : https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml
- tab policy = spaces only
- indetation size = 2
- tab size = 1
- activate save action : formater all lines and organize imports