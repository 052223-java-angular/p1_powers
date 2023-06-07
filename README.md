# Hiking Buddy

## Introduction

This is a web-based application that will allow users to log into an account, view hiking trails near them, rate the difficulty of the trails that they hiked, find new trails to hike, 
view a map that traces the route of the hike that they are looking at, and allows them to search for trails to hike
## User Stories

- **As a user**, I want to be able to log in and see the trails that i've hiked
- **As a user**, I want to be able to create an account
- **As a user**, I want to be able to search for new hiking trails in my area
- **As a user**, I want to be able to check off trails that I have hiked and leave ratings on their difficulty.
- **As a user**, I want to be able to view a map to get directions to the trailhead
- **As a user**, I want to be able to see other people's ratings for the trail
- **As a user**, I want to be able to search for trails to hike
- **As a user**, I want to be able to see a map that traces the hike's route







## MVP (Minimum Viable Product)

- User Login and registration
- Ability to search for new trails in my area
- Ability to rate trails that I have hiked for difficulty
- Ability to get directions to the trailhead 
- Ability to see a map that traces the trail's route
- Ability to see what other ratings people have left for the trails
- Ability to filter for trails by country
- Ability to have a profile picture
- Ability to recommend trails based on difficulty


## Stretch Goals

- Implementing a setting that allows the user to filter for trails based on aggregate 
  ratings of difficulty
- Implement a star rating system that allows users to rate the trail on other qualities 
  rather than difficulty
- Ability to see weather conditions on the trails






## Tech Stacks

- **Java**: The main programming language used for building the backend service.
- **PostgreSQL**: Used as the database to store user and trail data as well as difficulty rating data.
- **Maven or Gradle**: Used for managing project dependencies on the backend.
- **JUnit, Mockito, and PowerMock**: A testing framework for Java applications, used to ensure the backend code works as expected.
- **BCrypt**: A Java library for hashing and checking passwords for security.
- **TrailAPI** For getting GPX data and showing the user the route of the trail
- **Weather API** For showing the user the weather conditions of the trail
- **Git and GitHub**: Used for version control.
- **HTML and CSS** For designing the frontend web page
- **JavaScript** For enhancing the webpage and giving it more functionality than a traditional static webpage
- **Spring Boot** For creating the embedded server infrastructure and simplifying the database creation process
- **jQuery** For enhancing the javascript and for simplifying the flow of data from the frontend to the backend




## Requirements

- **Clean Codebase**: All code should be clean and well-documented. The repository should not include any unnecessary files or folders such as the `target/`, `.DS_Store`, etc. All files and directories should be appropriately named and organized.

- **Database Design**: The database should be designed following the principles of the 3rd Normal Form (3NF) to ensure data integrity and efficiency. An Entity Relationship Diagram (ERD) should be included in the documentation.

- **Secure**: All sensitive user data such as passwords must be securely hashed before storing it in the database. The application should not display any sensitive information in error messages.

- **Error Handling**: The application should handle potential errors gracefully and provide clear and helpful error messages to the users.

- **Testing**: The application should have a high test coverage. Unit tests and integration tests should be implemented using JUnit, Mockito, and PowerMock.

- **Version Control**: The application should be developed using a version control system, preferably Git, with regular commits denoting progress.

- **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.

- **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.

