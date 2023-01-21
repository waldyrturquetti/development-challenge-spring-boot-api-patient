## Goal

- To develop a Rest API using Spring Boot. The API will receive the following data by JSON (Patient's name, birth date, email and address) and persist those fields on a relational database of your choice.

## Required

- You need to develop the Rest API using Spring Boot.
- You need to develop an API operation to query records (Patient's name, birth date, email and address) by patient email.
- The API need to have validation by a password or other validation method of your choice. 

## What should be applied:

- Clean and organized code (naming, etc.)
- Knowledge of patterns (PSRs, design patterns, SOLID)
- Be consistent and know how to argue your choices
- Present solutions you master
- Data Modeling
- Code maintainability
- Error handling
- Architecture (structuring thought before writing)
- Affection in decoupling components (other layers, service, repository)


# For Execute the project

- You must a creat e projet in Firebase and habilit the Authentication by Email/Password
- Catch a API KEY in Firebase and put in `firabase.api.key` in `application.properties` in project.
- Take the json file that contains the private key in Firebase, change the name to `firebase-config.json` and place it in the `resources/firebase` directory.  
