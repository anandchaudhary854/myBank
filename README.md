# Simple Java Servlets API Demo
This repository contains a small Java project demonstrating the usage of Servlets to create simple GET and POST APIs. Throughout the development process, the project explores the concepts of Servlets, Dependency Injection, and the significance of the pom.xml file.

## Servlets Overview
Servlets are Java classes that handle HTTP requests and responses. In this project, we have implemented two Servlets in MyfirstServlet.java one for GET requests and one for POST requests.

## Dependency Injection
The project explores the concept of Dependency Injection, a design pattern that promotes loose coupling by injecting dependencies into an object rather than allowing the object to create its dependencies. This improves testability and maintainability.

## Contributing
Contributions are welcome! Please feel free to open issues or submit pull requests.

# Here are the changes 10 dec 2023:-

1. Added maven dependency for spring 6
2. Made a configuration class to replace the old application class.
3. Added configuration annotation so that spring uses it bean definations.
4. Defined beans that we will use later for in servletClass.
5. Annotated transactionService and userService with component so that spring creates beans for this automatically.
6. Defined a init method in myServlet class and passed the configuration class to anotationConfiger.
7. Used getBean method to get the beans that are defined in ioc container by spring to use it in our project.

# Here are the learnings for 10 dec 2023:-
1. Learned the role of configuration annotation in spring ioc.
2. Learned how spring does dependency injection using beans.
3. Learned how spring uses @component and @componentScan to pick up and define beans to make it easy to use and manageable.
4. Learned default behaviour of @bean that it uses singleton pattern to define and manage objects
5. You can also change the default behaviour of @bean to prototype or request in which it will generate different objects on each call or each http request respectively.
6. You can do dependency injection in three ways that is constructer injection, field injection and setter injection.