
# Spring Boot

## Spring vs Spring Boot vs Spring MVC

**Spring:** The main feature of the Spring Framework is dependency Injection or Inversion of Control (IoC). We can develop a loosely coupled application. It is better to use if application type or characteristics are purely defined.

**Spring Boot:** Spring Boot is a module of Spring Framework. It allows us to build a stand-alone application with minimal or zero configurations. It is better to use if we want to develop a simple Spring-based application or RESTful services.  It hides a lot of complexity behind the scene so that the developer can quickly get started and develop Spring-based applications easily.

**Spring MVC:** Spring MVC is a Web MVC Framework for building web applications. It contains a lot of configuration files for various capabilities. It is an HTTP oriented web application development framework.

**Spring**
* Spring Framework is a widely used Java EE framework for building applications. 
* It aims to simplify Java EE development that makes developers more productive.
* The primary feature of the Spring Framework is dependency injection.
* It helps to make things simpler by allowing us to develop loosely coupled applications.
* The developer writes a lot of code (boilerplate code) to do the minimal task.
* To test the Spring project, we need to set up the sever explicitly.
* It does not provide support for an in-memory database.
* Developers manually define dependencies for the Spring project in pom.xml.

**---vs---**	

**Spring Boot**
* Spring Boot Framework is widely used to develop REST APIs.
* It aims to shorten the code length and provide the easiest way to develop Web Applications.
* The primary feature of Spring Boot is Autoconfiguration. It automatically configures the classes based on the requirement.
* It helps to create a stand-alone application with less configuration.
* It reduces boilerplate code.
* Spring Boot offers embedded server such as Jetty and Tomcat, etc.
* It offers several plugins for working with an embedded and in-memory database such as H2.
* Spring Boot comes with the concept of starter in pom.xml file that internally takes care of downloading the dependencies JARs based on Spring Boot Requirement.
-------------------------
---------------------------
* Spring Boot is a module of Spring for packaging the Spring-based application with sensible defaults.
* It provides default configurations to build Spring-powered framework.
* There is no need to build configuration manually.
* There is no requirement for a deployment descriptor.
* It avoids boilerplate code and wraps dependencies together in a single unit.
* It reduces development time and increases productivity.

**---vs---**

**Spring MVC**
* Spring MVC is a model view controller-based web framework under the Spring framework.
* It provides ready to use features for building a web application.
* It requires build configuration manually.
* A Deployment descriptor is required.
* It specifies each dependency separately.
* It takes more time to achieve the same.
	

## Architecture
Spring Boot is a module of the Spring Framework. It is used to create stand-alone, production-grade Spring Based Applications with minimum efforts. It is developed on top of the core Spring Framework.

Spring Boot follows a layered architecture in which each layer communicates with the layer directly below or above (hierarchical structure) it. Its has 4 layers as follows.

* **Presentation Layer** - The presentation layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business layer. In short, it consists of **views** i.e., frontend part.

* **Business Layes** - The business layer handles all the **business logic**. It consists of service classes and uses services provided by data access layers. It also performs **authorization and validation**.

* **Persistence Layer** - The persistence layer contains all the **storage logic** and translates business objects from and to database rows.

* **Database Layer** - In the database layer, **CRUD** (create, retrieve, update, delete) operations are performed.

https://static.javatpoint.com/springboot/images/spring-boot-architecture.png


## Project Components:-

### Annotations
Spring Boot Annotations is a form of metadata that provides data (ie. supplemental information) about a program. 

**@Required**: It applies to the **bean** setter method. It indicates that the annotated bean must be populated at configuration time with the required property, else it throws an exception **BeanInitilizationException**.
```java
public class Machine   
{  
    private Integer cost;  
    @Required  
    public void setCost(Integer cost)   
    {  
        this.cost = cost;  
    }  
    public Integer getCost()   
    {  
        return cost;  
    }     
}
```
**@Autowired**: Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring bean on setter methods, instance variable, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.
```java
@Component  
public class Customer  
{  
    private Person person;  
    @Autowired  
    public Customer(Person person)   
    {   
        this.person=person;  
    }  
}  
```
**@Configuration**: It is a class-level annotation. The class annotated with @Configuration used by Spring Containers as a source of bean definitions.
```java
@Configuration  
public class Vehicle  
{  
    @BeanVehicle engine()  
    {  
        return new Vehicle();  
    }  
}  
```
**@ComponentScan**: It is used when we want to scan a package for beans. It is used with the annotation @Configuration. We can also specify the base packages to scan for Spring Components.
```java
@ComponentScan(basePackages = "com.demo")  
@Configuration  
public class ScanComponent  
{  
// ...  
}  
```
**@Bean**: It is a method-level annotation. It is an alternative of XML <bean> tag. It tells the method to produce a bean to be managed by Spring Container.
```java
@Bean  
public BeanExample beanExample()   
{  
    return new BeanExample ();  
}  
```
----------------------------------------------------------------------------------
**@Component**: It is a class-level annotation. It is used to mark a Java class as a bean. A Java class annotated with @Component is found during the classpath. The Spring Framework pick it up and configure it in the application context as a Spring Bean.
```java
@Component  
public class Student  
{  
.......  
}  
```

**@Controller**: The @Controller is a class-level annotation. It is a specialization of @Component. It marks a class as a web request handler. It is often used to serve web pages. By default, it returns a string that indicates which route to redirect. It is mostly used with @RequestMapping annotation.
```java
@Controller  
@RequestMapping("books")  
public class BooksController   
{  
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)  
    public Employee getBooksByName()   
    {  
        return booksTemplate;  
    }  
}  
```
**@Service**: It is also used at class level. It tells the Spring that class contains the business logic.
```java
@Service  
public class TestService  
{  
    public void service1()  
    {  
    //business code  
    }  
}  
```
**@Repository**: It is a class-level annotation. The repository is a DAOs (Data Access Object) that access the database directly. The repository does all the operations related to the database.
```java
@Repository   
public class TestRepository  
{  
    public void delete()  
    {     
    //persistence code  
    }  
}  
```

**Spring Boot Annotation-**

Spring Boot auto-configuration automatically configures the Spring application based on the jar dependencies that we have added.

For example, if the H2 database Jar is present in the classpath and we have not configured any beans related to the database manually, the Spring Boot's auto-configuration feature automatically configures it in the project. We can enable the auto-configuration feature by using the annotation @EnableAutoConfiguration.
* **@EnableAutoConfiguration**: It auto-configures the bean that is present in the classpath and configures it to run the methods. The use of this annotation is reduced in Spring Boot 1.2.0 release because developers provided an alternative of the annotation, i.e. **@SpringBootApplication**.
* **@SpringBootApplication**: It is a combination of three annotations **@EnableAutoConfiguration, @ComponentScan, and @Configuration**.

                @SpringBootApplication = @ComponentScan + @EnableAutoConfiguration + @Configuration

* Disable the specific auto-configuration classes, if we do not want to be applied. We use the exclude attribute of the annotation @EnableAutoConfiguration to disable the auto-configuration classes. For example:
```java
import org.springframework.boot.autoconfigure.*;  
import org.springframework.boot.autoconfigure.jdbc.*;  
import org.springframework.context.annotation.*;  
@Configuration(proxyBeanMethods = false)  
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})  
public class MyConfiguration   
{  
}  
```


**Spring MVC and REST Annotations-**

* **@RequestMapping**: It is used to map the web requests. It has many optional elements like **consumes, header, method, name, params, path, produces, and value**. We use it with the class as well as the method.
```java
@Controller  
public class BooksController   
{  
    @RequestMapping("/computer-science/books")  
    public String getAllBooks(Model model)  
    {  
        //application code  
        return "bookList";  
    }
}  
```
* **@GetMapping**: It maps the HTTP GET requests on the specific handler method. It is used to create a web service endpoint that fetches It is used instead of using: **@RequestMapping(method = RequestMethod.GET)**

* **@PostMapping**: It maps the HTTP POST requests on the specific handler method. It is used to create a web service endpoint that creates It is used instead of using: **@RequestMapping(method = RequestMethod.POST)**

* **@PutMapping**: It maps the HTTP PUT requests on the specific handler method. It is used to create a web service endpoint that creates or updates It is used instead of using: **@RequestMapping(method = RequestMethod.PUT)**

* **@DeleteMapping**: It maps the HTTP DELETE requests on the specific handler method. It is used to create a web service endpoint that deletes a resource. It is used instead of using: **@RequestMapping(method = RequestMethod.DELETE)**

* **@PatchMapping**: It maps the HTTP PATCH requests on the specific handler method. It is used instead of using: **@RequestMapping(method = RequestMethod.PATCH)**

* **@RequestBody**: It is used to bind HTTP request with an object in a method parameter. Internally it uses HTTP MessageConverters to convert the body of the request. When we annotate a method parameter with @RequestBody, the Spring framework binds the incoming HTTP request body to that parameter.

* **@ResponseBody**: It binds the method return value to the response body. It tells the Spring Boot Framework to serialize a return an object into JSON and XML format.

* **@PathVariable**: It is used to extract the values from the URI. It is most suitable for the RESTful web service, where the URL contains a path variable. We can define multiple @PathVariable in a method.

* **@RequestParam**: It is used to extract the query parameters form the URL. It is also known as a query parameter. It is most suitable for web applications. It can specify default values if the query parameter is not present in the URL.

* **@RequestHeader**: It is used to get the details about the HTTP request headers. We use this annotation as a method parameter. The optional elements of the annotation are name, required, value, defaultValue. For each detail in the header, we should specify separate annotations. We can use it multiple time in a method.

* **@RestController**: It can be considered as a combination of **@Controller and @ResponseBody** annotations. The @RestController annotation is itself annotated with the @ResponseBody annotation. It eliminates the need for annotating each method with @ResponseBody.

* **@RequestAttribute**: It binds a method parameter to request attribute. It provides convenient access to the request attributes from a controller method. With the help of @RequestAttribute annotation, we can access objects that are populated on the server-side.

## Dependency Managment
Spring Boot manages dependencies and configuration automatically. Each release of Spring Boot provides a list of dependencies that it supports. The list of dependencies is available as a part of the Bills of Materials (spring-boot-dependencies) that can be used with Maven. So, we need not to specify the version of the dependencies in our configuration. Spring Boot manages itself. Spring Boot upgrades all dependencies automatically in a consistent way when we update the Spring Boot version.

* It provides the centralization of dependency information by specifying the Spring Boot version in one place. It helps when we switch from one version to another.
* It avoids mismatch of different versions of Spring Boot libraries.
* We only need to write a library name with specifying the version. It is helpful in multi-module projects.
* Spring Boot also allows overriding of dependencies version, if required.

The Maven project inherits the following features from **spring-boot-starter-parent**:

* The default **Java compiler version**
* **UTF-8** source encoding
* It inherits a **Dependency Section** from the **spring-boot-dependency-pom**. It manages the version of common dependencies. It ignores the <version> tag for that dependencies.
* Dependencies, inherited from the spring-boot-dependencies POM
* Sensible **resource filtering**
* Sensible **plugin configuration**

The following spring-boot-starter-parent inherits automatically when we configure the project.
```xml
<parent>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-parent</artifactId>  
<version>2.2.2.BUILD-SNAPSHOT</version>      <!-- lookup parent from repository -->  
<relativePath/>   
</parent>
```  
Note: In the above dependency, we have specified only the Spring Boot version. If we want to add additional starters, simply remove the <version> tag. Similarly, we can also override the individual dependency by overriding a property in our project.

For example, if we want to add another dependency with the same artifact that we have injected already, inject that dependency again inside the <properties> tag to override the previous one.

Change the Java version by using the <java.version> tag.
```xml
<properties>    
<java.version>1.8</java.version>    
</properties>  
```
Add Maven plugin in pom.xml file. It wraps the project into an executable jar file.
```xml
<build>    
<plugins>    
<plugin>    
<groupId>org.springframework.boot</groupId>    
<artifactId>spring-boot-maven-plugin</artifactId>    
</plugin>    
</plugins>    
</build>   
```
The spring-boot-starter-parent dependency inherit from the **spring-boot-dependencies**, it shares all these characteristics as well. Hence the Spring Boot manages the list of the dependencies as the part of the dependency management. Spring Boot Starter without Parent in pom.xml but want to handle dependancy manager then we can do it by adding <scope>.

Scopes
- **compile**: This is the default [no need to mention scope tage for this] scope when no other scope is provided.
    Dependencies with compile scope are available on the classpath of the project in all build tasks. They are also propagated to the dependent projects. 
- **runtime**: The dependencies with this scope are required at runtime. 
    Runtime scope will be present in the runtime and test classpath, but they will be missing from the compile classpath. A JDBC driver is a good example of dependencies that should use the runtime scope

- **provided** : dependencies that should be provided at runtime by JDK or a container. 
    A web application deployed in some container, where the container already provides some libraries itself. For example, this could be a web server that already provides the Servlet API at runtime.
- **test**: Test dependencies aren’t transitive and are only present for test and execution classpaths.
- **system**: System scope is very similar to the provided scope.\
    The main difference is that system requires us to directly point to a specific jar on the system. Point remember is that building the project with system scope dependencies may fail on different machines if dependencies aren’t present or are located in a different place than the one systemPath points to
- **import**: It’s only available for the dependency type pom.

```xml
<dependencyManagement>  
<dependencies>  
<dependency>  
<!-- Import dependency management from Spring Boot -->  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-dependencies</artifactId>  
<version>2.1.1.RELEASE</version>  
<type>pom</type>  
<scope>import</scope>  
</dependency>  
</dependencies>  
</dependencyManagement>  
```

## Spring Application properties

## Spring Boot Starter

| Type     | Description                       |
| :------- | :-------------------------------- |
| `spring-boot-starter-web-services` | It is used for **Spring Web Services**. |
| `spring-boot-starter-web` | It is used for building the web application, including **RESTful applications** using **Spring MVC**. It uses Tomcat as the default embedded container. |
| `spring-boot-starter-test	` | It is used to **test Spring Boot applications** with libraries, including **JUnit, Hamcrest, and Mockito**. |
| `spring-boot-starter-jdbc` | 	It is used for JDBC with the **Tomcat JDBC connection pool**. |
| `spring-boot-starter-validation` | It is used for **Java Bean Validation with Hibernate Validator**. |
| `spring-boot-starter-data-ldap` | It is used for **Spring Data LDAP**. |
| `spring-boot-starter-aop` | It is used for **aspect-oriented programming with Spring AOP and AspectJ**.|
| `spring-boot-starter-data-jpa` |	It is used for **Spring Data JPA with Hibernate**.|
| `spring-boot-starter` |	It is used for core starter, including **auto-configuration support, logging, and YAML**.	|
| `spring-boot-starter-cloud-connectors` |	It is used for **Spring Cloud Connectors** that simplifies connecting to services in cloud platforms like **Cloud Foundry and Heroku**.|
| `spring-boot-starter-data-rest` |	It is used for exposing **Spring Data repositories over REST using Spring Data REST**.|
| `spring-boot-starter-actuator` |	It is used for **Spring Boot's Actuator** that provides production-ready features to help you monitor and manage your application.|


Starter of Spring web uses Spring MVC, REST and Tomcat as a default embedded server. The single spring-boot-starter-web dependency transitively pulls in all dependencies related to web development. It also reduces the build dependency count. The spring-boot-starter-web transitively depends on the following:
* org.springframework.boot:spring-boot-starter
* org.springframework.boot:spring-boot-starter-tomcat
* org.springframework.boot:spring-boot-starter-validation
* com.fasterxml.jackson.core:jackson-databind
* org.springframework:spring-web
* org.springframework:spring-webmvc

In short spring-boot-starter-web container
* spring-boot-starter
* jackson
* spring-core
* spring-mvc
* spring-boot-starter-tomcat


The spring-boot-starter-web auto-configures the following things that are required for the web development:
* Dispatcher Servlet
* Error Page
* Web JARs for managing the static dependencies
* Embedded servlet container

Embedded server is embedded as a part of deployable application. The advantage of embedded server is, we do not require pre-installed server in the environment. With Spring Boot, default embedded server is Tomcat. Spring Boot also supports another two embedded servers:
    - Jetty Server
    - Undertow Server
    
```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
    <exclusions>  
        <exclusion>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-tomcat</artifactId>  
        </exclusion>  
    </exclusions>  
</dependency>  
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-jetty</artifactId>  
</dependency>  
```
While using Jetty / Undertow server in the application, make sure that the default Tomcat server is excluded from the spring-boot-starter-web. It avoids the conflict between servers contains.

**spring-boot-starter-tomcat** contains everything related to Tomcat server.
* core
* el
* logging
* websocket

## Spring Data JPA, Spring JPA
Spring Data is a high-level Spring Source project. Its purpose is to unify and easy access to the different kinds of persistence stores, **both relational database systems, and NoSQL data** stores. When we implement a new application, we should focus on the business logic instead of **technical complexity and boilerplate code**. 

```xml
<dependency>  
<groupId>org.springframework.data</groupId>  
<artifactId>spring-data-jpa</artifactId>  
<version>2.2.3.RELEASE</version>  
</dependency>  
```

**No code repository**: It is the most popular persistence-related pattern. It enables us to implement our business code on a higher abstraction level.

Spring Data JPA adds a layer on the top of JPA. It means, Spring Data JPA uses all features defined by JPA specification, especially the entity, association mappings, and JPA's query capabilities. Spring Data JPA adds its own features such as the no-code implementation of the repository pattern and the creation of database queries from the method name.

Spring Data JPA handles most of the complexity of JDBC-based database access and ORM (Object Relational Mapping). It reduces the boilerplate code required by JPA. It makes the implementation of your persistence layer easier and faster.

Spring Data JPA is the **generation of database queries** based on the method name. If the query is not too complex, we need to define a method on our repository interface with the name that starts with findBy. After defining the method, Spring parses the method name and creates a query for it. For example:
```java
public interface EmployeeRepository extends CrudRepository<Employee, Long>   
{  // The Employee is the entity that is to be managed, and Long is the data type of primary key
Employee findByName(String name);  
}  
```

Spring internally generates a **JPQL (Java Persistence Query Language)** query based on the method name. The query is derived from the method signature. It sets the bind parameter value, execute the query, and returns the result. There are some other features are as follows:
* It can integrate custom repository code.
* It is a powerful repository and custom object-mapping abstraction.
* It supports transparent auditing.
* It implements a domain base class that provides basic properties.
* It supports several modules such as Spring Data JPA, Spring Data MongoDB, Spring Data REST, Spring Data Cassandra, etc.

    1. **CrudRepository**: It offers standard **create, read, update, and delete It contains method like findOne(), findAll(), save(), delete(), etc**.
        The CRUD operation can be defined as user interface conventions that allow view, search, and modify information through computer-based forms and reports. CRUD is data-oriented and the standardized use of HTTP action verbs. HTTP has a few important verbs.
    - POST: Creates a new resource
    - GET: Reads a resource
    - PUT: Updates an existing resource
    - DELETE: Deletes a resource

    ```java
        public interface CrudRepository<T,ID> extends Repository<T,ID>  {}
    ```

    Spring Boot provides an interface called CrudRepository that contains methods for CRUD operations. It is defined in the package org.springframework.data.repository. It extends the Spring Data Repository interface. It provides generic Crud operation on a repository. If we want to use CrudRepository in an application, we have to create an interface and extend the CrudRepository. 
    
    It works as a marker interface. It is used when we do not need the functions provided by JpaRepository and PagingAndSortingRepository. It is used when we do not need the functions provided by JpaRepository and PagingAndSortingRepository.

    2. **PagingAndSortingRepository**: It **extends the CrudRepository** and adds the **findAll** methods. It allows us to **sort and retrieve** the data in a paginated way.

    3. **JpaRepository**: It is a **JPA specific repository** It is defined in **Spring Data Jpa**. It extends the both repository CrudRepository and PagingAndSortingRepository. It adds the JPA-specific methods, like **flush()** to trigger a flush on the persistence context. JpaRepository provides JPA related methods such as flushing, persistence context, and deletes a record in a batch. It is defined in the package org.springframework.data.jpa.repository. JpaRepository extends both CrudRepository and PagingAndSortingRepository. 
    
    JpaRepository extends both CrudRepository and PagingAndSortingRepository. JpaRepository extends both CrudRepository and PagingAndSortingRepository. It is used when we want to implement pagination and sorting functionality in an application.

https://static.javatpoint.com/springboot/images/spring-boot-crud-operations.png

* The interfaces allow Spring to find the repository interface and create proxy objects for that.
* It provides methods that allow us to perform some common operations. We can also define custom methods as well.

#### Example:
```xml
<dependency>  
<groupId>org.springframework.data</groupId>  
<artifactId>spring-boot-crud-opration</artifactId>  
<version>2.2.3.RELEASE</version>  
</dependency>  
```
a model class with the name Books. In the Books class, we have done the following:
- Define four variable bookid, bookname, author, and Generate Getters and Setters.
- Mark the class as an Entity by using the annotation @Entity.
- Mark the class as Table name by using the annotation @Table.
- Define each variable as Column by using the annotation @Column.
```java - Bean
package com.demo.model;  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
// mark class as an Entity   
@Entity  
// defining class name as Table name  
@Table  
public class Books  
{  
    // Defining book id as primary key  
    @Id  
    @Column  
    private int bookid;  
    @Column  
    private String bookname;  
    @Column  
    private String author;  
    @Column  
    private int price;  
    // Right-click on the file -> Source -> Generate Getters and Setters.
}
```

- Mark the class as RestController by using the annotation @RestController.
- Autowire the BooksService class by using the annotation @Autowired.
- Define the following methods:
  * getAllBooks(): It returns a List of all Books.
  * getBooks(): It returns a book detail that we have specified in the path variable. We have passed bookid as an argument by using the annotation @PathVariable. The annotation indicates that a method parameter should be bound to a URI template variable.
  * deleteBook(): It deletes a specific book that we have specified in the path variable.
  * saveBook(): It saves the book detail. The annotation @RequestBody indicates that a method parameter should be bound to the body of the web request.
  * update(): The method updates a record. We must specify the record in the body, which we want to update. To achieve the same, we have used the annotation @RequestBody.

```java - controller
public class BooksController   
{  
    //autowire the BooksService class  
    @Autowired  
    BooksService booksService;  

    //creating a get mapping that retrieves all the books detail from the database   
    @GetMapping("/book")  
    private List<Books> getAllBooks()   
    {  
        return booksService.getAllBooks();  
    }  
    //creating a get mapping that retrieves the detail of a specific book  
    @GetMapping("/book/{bookid}")  
    private Books getBooks(@PathVariable("bookid") int bookid)   
    {  
        return booksService.getBooksById(bookid);  
    }  
    //creating a delete mapping that deletes a specified book  
    @DeleteMapping("/book/{bookid}")  
    private void deleteBook(@PathVariable("bookid") int bookid)   
    {  
        booksService.delete(bookid);  
    }  
    //creating post mapping that post the book detail in the database  
    @PostMapping("/books")  
    private int saveBook(@RequestBody Books books)   
    {  
        booksService.saveOrUpdate(books);  
        return books.getBookid();  
    }  
    //creating put mapping that updates the book detail   
    @PutMapping("/books")  
    private Books update(@RequestBody Books books)   
    {  
        booksService.saveOrUpdate(books);  
        return books;  
    }  
}  
```

```java - service
package com.demo.service;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.demo.model.Books;  
import com.demo.repository.BooksRepository;  
//defining the business logic  
@Service  
public class BooksService   
{  
    @Autowired  
    BooksRepository booksRepository;  

    //getting all books record by using the method findaAll() of CrudRepository  
    public List<Books> getAllBooks()   
    {  
        List<Books> books = new ArrayList<Books>();  
        booksRepository.findAll().forEach(books1 -> books.add(books1));  
        return books;  
    }  
    //getting a specific record by using the method findById() of CrudRepository  
    public Books getBooksById(int id)   
    {  
        return booksRepository.findById(id).get();  
    }  
    //saving a specific record by using the method save() of CrudRepository  
    public void saveOrUpdate(Books books)   
    {  
        booksRepository.save(books);  
    }  
    //deleting a specific record by using the method deleteById() of CrudRepository  
    public void delete(int id)   
    {  
        booksRepository.deleteById(id);  
    }  
    //updating a record  
    public void update(Books books, int bookid)   
    {  
        booksRepository.save(books);  
    } 
}  
```
```java - repository
package com.demo.repository;  
import org.springframework.data.repository.CrudRepository;  
import com.demo.model.Books;  
//repository that extends CrudRepository  
public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
}  
```

#### Spring Boot Starter Data JPA

Spring Boot provides **spring-boot-starter-data-jpa** dependency to connect Spring application with relational database efficiently.The spring-boot-starter-data-jpa internally uses the **spring-boot-jpa** dependency (since Spring Boot version 1.5.3).
```xml
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-data-jpa</artifactId>  
<version>2.2.2.RELEASE</version>  
</dependency>  
```
The databases are designed with tables/relations. Earlier approaches (JDBC) involved writing SQL queries.  In the JPA, we will store the data from objects into table and vice-versa. However, JPA evolved as a result of a different thought process.

Before JPA, ORM was the term more commonly used to refer to these frameworks. It is the reason Hibernate is called the **ORM framework**.

JPA allows us to map application classes to table in the database.

- **Entity Manager**: Once we define the mapping, it handles all the interactions with the database.
- **JPQL (Java Persistence Query Language)**: It provides a way to write queries to execute searches against entities. It is different from the SQL queries. JPQL queries already understand the mapping that is defined between entities. We can add additional conditions if required.
- **Criteria API**: It defines a Java-based API to execute searches against the database.

#### Spring JPA
Spring Boot JPA is a Java specification for managing relational data in Java applications. It allows us to access and persist data between Java object/ class and relational database. JPA follows Object-Relation Mapping (ORM). It is a set of interfaces. It also provides a runtime EntityManager API for processing queries and transactions on the objects against the database. It uses a platform-independent object-oriented query language JPQL (Java Persistent Query Language).

JPA is suitable for non-performance oriented complex applications. The main advantage of JPA over JDBC is that, in JPA, data is represented by objects and classes while in JDBC data is represented by tables and records. It uses POJO to represent persistent data that simplifies database programming. 

#### Advantages of JPA:
- JPA avoids writing DDL in a database-specific dialect of SQL. Instead of this, it allows mapping in XML or using Java annotations.
- JPA allows us to save and load Java objects and graphs without any DML language at all.
- When we need to perform queries JPQL, it allows us to express the queries in terms of Java entities rather than the (native) SQL table and columns.

https://static.javatpoint.com/springboot/images/spring-boot-jpa1.png

**Object-Relation Mapping (ORM)**
In ORM, the mapping of Java objects to database tables, and vice-versa is called Object-Relational Mapping. The ORM mapping works as a bridge between a relational database (tables and records) and Java application (classes and objects).

#### Hibernate vs. JPA
* Hibernate is an ORM framework that deals with data persistence.
* It provides implementation classes.
* It uses its own query language called HQL (Hibernate Query Language).
* It is defined in org.hibernate package.
* Hibernate is the provider of JPA.
* In Hibernate uses Session for handling the persistence of data.
* Hibernate understands the mapping that we add between objects and tables. It ensures that data is retrieved/ stored from the database based on the mapping. It also provides additional features on the top of the JPA.
---vs---
* JPA is a Java specification for mapping relation data in Java application.	
* JPA does not provide any implementation classes.	
* It uses platform-independent query language called JPQL (Java Persistence Query Language).	
* It is defined in javax.persistence package.	
* It is implemented in various ORM tools like Hibernate, EclipseLink, etc.	
* JPA uses EntityManager for handling the persistence of data.	


#### Spring Boot JDBC vs Spring JDBC
Spring Boot JDBC	
- There is only a spring-boot-starter-jdbc dependency is required.	
- It automatically configures Datasource bean, if not maintain explicitly. If we do not want to use the bean, we can set a property spring.datasource.initialize to false.	
- We do not need to register Template beans because Spring Boot automatically registers beans.	
- Any db initialization scripts stored in .sql file gets executed automatically.	
--- vs ---
Spring JDBC
- In Spring JDBC, multiple dependencies need to be configured like spring-jdbc and spring-context.
- In Spring JDBC, it is necessary to create a database bean either using XML or javaconfig.
- The Template beans such as PlatformTransactionManager, JDBCTemplate, NamedParameterJdbcTemplate must be registered.
- If any db initialization scripts like dropping or creation of tables are created in SQL file, this info needs to be given explicitly in the configuration.

```
#--- application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb  
spring.datasource.username=root  
spring.datasource.password=mysql  
spring.jpa.hibernate.ddl-auto=create-drop  
```

#### JDBC vs. Hibernate
JDBC	
- JDBC is a technology.	
- the user is responsible for creating and closing the connections.	
- It does not support lazy loading.	
- It does not support associations (the connection between two separate classes).	
--- vs ---
Hibernate
- Hibernate is an ORM framework.
- the run time system takes care of creating and closing the connections.
- It supports lazy loading that offers better performance.
- It supports associations.


## Spring Boot Actuator
Spring Boot Actuator is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live). We can use HTTP and JMX endpoints to manage and monitor the Spring Boot application. If we want to get production-ready features in an application, we should use the Spring Boot actuator.
```
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-actuator</artifactId>  
</dependency>  
```

#### Spring Boot Actuator Features
- **Endpoints**\
    The actuator endpoints allows us to monitor and interact with the application. Spring Boot provides a number of built-in endpoints. We can also create our own endpoint. We can enable and disable each endpoint individually. Most of the application choose **HTTP**, where the Id of the endpoint, along with the prefix of /actuator, is mapped to a URL.

    For example, the **/health** endpoint provides the basic health information of an application. The actuator, by default, mapped it to **/actuator/health**.  

- **Metrics**\
    Spring Boot Actuator provides dimensional metrics by integrating with the micrometer. The micrometer is integrated into Spring Boot. It is the instrumentation library powering the delivery of application metrics from Spring. It provides vendor-neutral interfaces for **timers, gauges, counters, distribution summaries, and long task timers** with a dimensional data model.

- **Audit**\
    Spring Boot provides a flexible audit framework that publishes events to an **AuditEventRepository**. It automatically publishes the authentication events if spring-security is in execution.

Injecting the dependency spring-boot-starter-actuator in the pom.xml file to enable the actuator.

Spring Boot enables security for all actuator endpoints. It uses form-based authentication that provides user Id as the user and a randomly generated password. We can also access actuator-restricted endpoints by customizing basicauth security to the endpoints. We need to override this configuration by **management.security.roles** property. For example:
```
management.security.enabled=true  
management.security.roles=ADMIN  
security.basic.enabled=true  
security.user.name=admin  
security.user.passowrd=admin  
```

#### Steps to check Actuator
1. The application.properties file and disable the security feature of the actuator by adding the following statement.
```
# application.properties
management.security.enabled=false  
```
2. Run the SpringBootActuatorExampleApplication.java file.

3. Open the browser and invoke the URL http://localhost:8080/actuator. It returns the following page:
```
{"_links":{"self":{"href":"http://localhost:8080/actuator","templated":false},
"health":{"href":"http://localhost:8080/actuator/health","templated":false},
"health-path":{"href":"http://localhost:8080/actuator/health/{*path}","templated":true},
"info":{"href":"http://localhost:8080/actuator/info","templated":false}}}  
```
**HAL Browser** is use to shows the details of all the beans that are auto-configured, and those are not. In the pom.xml file  add the HAL Browser dependency.
```
<dependency>  
<groupId>org.springframework.data</groupId>  
<artifactId>spring-data-rest-hal-browser</artifactId>  
</dependency>  
```
To access the HAL browser, type http://localhost:8080 in the browser and hit the enter key. Type /actuator in the Explorer's text box and click on the Go button.


## Spring Boot Test

The **spring-boot-starter-test** is the primary dependency for the test. It contains the majority of elements required for our tests. There are several different types of tests that we can write to help test and automate the health of an application. 
```
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-test</artifactId>  
<version>2.2.2.RELEASE</version>  
<scope>test</scope>  
</dependency>

<!-- If you are adding test dependency manually, add it to the bottom of the pom.xml file. -->
```
It pulls all the dependencies related to test. After adding it, we can build up a simple unit test.

It includes the scope of test <scope>test</scope>. It means when the application is bundled and packaged for deployment, any dependency that is declared with the test scopes is ignored. The test scope dependencies are only available when running in the development and Maven test modes.

When we create a simple Spring Boot application, by default, it contains the test dependency in the pom.xml file and ApplicationNameTest.java file under in the folder src/test/java.
```
package com.demo.springboottestexample;  
import org.junit.jupiter.api.Test;  
import org.springframework.boot.test.context.SpringBootTest;  

@SpringBootTest  
class SpringBootTestExampleApplicationTests   
{  
    @Test  
    void contextLoads()   
    {  
    }  
}  
```
**@SpringBootTest**: It applies on a Test Class that runs Spring Boot based tests. It provides the following features over and above the regular Spring TestContext Framework:
- It uses **SpringBootContextLoader** as the default ContextLoader if no specific @ContextConfiguration(loader=...) is defined.
- It automatically searches for a **@SpringBootConfiguration** when nested @Configuartion is not used, and no explicit classes are specified.
- It provides support for different **WebEnvironment** modes.
- It registers a **TestRestTemplate or WebTestClient** bean for use in web tests that are using the webserver.
- It allows application arguments to be defined using the **args attribute**.

## Spring Boot DevTool
Aim is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application. Provide below features:
- Property Defaults
- Automatic Restart
- LiveReload
- Remote Debug Tunneling
- Remote Update and Restart

## AOP - Aspect-Oriented Programming
The application is generally developed with multiple layers. 
* **Web Layer:** It exposes the services using the REST or web application.
* **Business Layer:** It implements the business logic of an application.
* **Data Layer:** It implements the persistence logic of the application.
The responsibility of each layer is different, but there are a few common aspects that apply to all layers are Logging, Security, validation, caching, etc. These common aspects are called **cross-cutting concerns**.

If we implement these concerns in each layer separately, the code becomes more difficult to maintain. To overcome this problem, **Aspect-Oriented Programming (AOP)** provides a solution to implement **cross-cutting concerns**.

* Implement the cross-cutting concern as an aspect.
* Define pointcuts to indicate where the aspect has to be applied.

**AOP (Aspect-Oriented Programming)** is a programming pattern that increases modularity by allowing the separation of the cross-cutting concern. These cross-cutting concerns are different from the main business logic. We can add additional behavior to existing code without modification of the code itself. The cross-cutting concern is a concern that we want to implement in multiple places in an application. It affects the entire application.

Using AOP, we define common functionality in one place. We are free to define how and where this functionality is applied without modifying the class to which we are applying the new feature. The cross-cutting concern can now be modularized into special classes, called **aspect**.

There are two benefits of aspects:

- First, the logic for each concern is now in one place instead of scattered all over the codebase.
- Second, the business modules only contain code for their primary concern. The secondary concern has been moved to the aspect.
The aspects have the responsibility that is to be implemented, called advice. We can implement an aspect's functionality into a program at one or more join points.

**Benefits:**
- It is implemented in pure Java.
- There is no requirement for a special compilation process.
- It supports only method execution Join points.
- Only run time weaving is available.
- Two types of AOP proxy is available: JDK dynamic proxy and CGLIB proxy.

```
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-aop</artifactId>  
    <version>2.2.2.RELEASE</version>  
</dependency>  
```

#### AOP Terminology
- **Aspect:** An aspect is a module that encapsulates **advic**e and **pointcuts** and provides cross-cutting An application can have any number of aspects. We can implement an aspect using regular class annotated with **@Aspect** annotation.

- **Pointcut:** A pointcut is an expression that selects **one or more join points** where advice is executed. We can define pointcuts using expressions or patterns. It uses different kinds of expressions that matched with the join points. In Spring Framework, **AspectJ pointcut expression language** is used.

- **Join point:** A join point is a point in the application where we apply an AOP aspect. Or it is a specific execution instance of an advice. In AOP, join point can be a **method execution, exception handling, changing object variable value**, etc.

- **Advice:** The advice is an action that we take either before or after the method execution. The action is a piece of code that invokes during the program execution. There are five types of advices in the Spring AOP framework: **before, after, after-returning, after-throwing, and around advice**. Advices are taken for a particular join point. We will discuss these advices further in this section.
    * @Before** - executes before a join point means before advice.
    * @After - execute after a join point means after advice.
    * Arround Advice - an advice executes before and after of join point.
    * After Throwing Advice: An advice that executes when a join point throws an exception.
    * After Returning Advice: An advice that executes when a method executes successfully.

- **Target object:** An object on which **advices are applied**, is called the target object. Target objects are always a proxied It means a subclass is created at run time in which the target method is overridden, and advices are included based on their configuration.

- **Weaving:** It is a process of linking aspects with other application types. We can perform weaving at **run time, load time, and compile time**.

- **Proxy:** It is an object that is **created after applying advice to a target object** is called proxy. The Spring AOP implements the **JDK dynamic proxy** to create the proxy classes with target classes and advice invocations. These are called AOP proxy classes.

The differences between AOP and OOP are as follows:

AOP	
- Aspect: A code unit that encapsulates pointcuts, advices, and attributes.	
- Pointcut: It defines the set of entry points in which advice is executed.	
- Advice: It is an implementation of cross-cutting concerns.	
- Waver: It constructs code (source or object) with advice.	

-- vs-- https://static.javatpoint.com/springboot/images/pring-boot-aop.png

OOPs:
- Class: A code unit that encapsulates methods and attributes.
- Method signature: It defines the entry points for the execution of method bodies.
- Method bodies: It is an implementation of the business logic concerns.
- Compiler: It converts source code to object code.

``` java
package com.demo.aspect;  
import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.stereotype.Component;  
@Aspect  
@Component  
public class EmployeeServiceAspect   
{  
    @Before(value = "execution(* com.demo.service.EmployeeService.*(..)) and args(empId, fname, sname)")  
    public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {  
        System.out.println("Before method:" + joinPoint.getSignature());  
        System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);  
    }  

    @After(value = "execution(* com.javatpoint.service.EmployeeService.*(..)) and args(empId, fname, sname)")  
    public void afterAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {  
        System.out.println("After method:" + joinPoint.getSignature());  
        System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);  
    }  

    //Displays all the available methods i.e. the advice will be called for all the methods  
    @Pointcut(value= "execution(* com.javatpoint.service.BankService.*(..))")  
    private void logDisplayingBalance()   
    {   
    }  

    //Declares the around advice that is applied before and after the method matching with a pointcut expression  
    @Around(value= "logDisplayingBalance()")  
    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable   
    {  
        System.out.println("The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");  
        try   
        {  
            jp.proceed();  
        }   
        finally   
        {  
        
        }  
        System.out.println("The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");  
    }  
}
```
* execution(expression): The expression is a method on which advice is to be applied.
* @Before: It marks a function as an advice to be executed before method that covered by PointCut.
* To check after run look at the console. We see that before invoking the createEmployee() method of EmployeeService class, the method beforeAdvice() of EmployeeServiceAspect class invokes

## Deploy Spring Boot Project
In the pom.xml file add the servlet container (Tomcat)
```
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-tomcat</artifactId>  
<scope>provided</scope>  
</dependency>    
```
To deploy WAR file so change the package type to WAR 
```
<packaging>war</packaging> 
```
The final WAR file name by using the <finalName> tag to avoid including the version numbers. We have created a WAR file with the name web-services.
```
<finalName>web-services</finalName>
```
``` xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
    <modelVersion>4.0.0</modelVersion>  
    <groupId>com.demo</groupId>  
    <artifactId>spring-boot-war-deployment-example</artifactId>  
    <version>0.0.1-SNAPSHOT</version>  
    <packaging>war</packaging>  <!-- WAR -->
    <name>spring-boot-war-deployment-example</name>  
    <description>Demo project for Spring Boot</description>  
    <parent>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-parent</artifactId>  
        <version>2.2.2.RELEASE</version>  
        <relativePath/> <!-- lookup parent from repository -->  
    </parent>  
    <properties>  
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>  
        <java.version>1.8</java.version>  
    </properties>  
    <dependencies>  
        <dependency>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-web</artifactId>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-tomcat</artifactId>  <!-- WAR -->
            <scope>provided</scope>  
        </dependency>    
        <dependency>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-test</artifactId>  
            <scope>test</scope>  
        </dependency>  
    </dependencies>  
    <build>  
        <finalName>web-services</finalName>  <!-- WAR -->
        <plugins>  
            <plugin>  
                <groupId>org.springframework.boot</groupId>  
                <artifactId>spring-boot-maven-plugin</artifactId>  
            </plugin>  
        </plugins>       
    </build>  
</project>  
```

## packaging

### WAR
WAR stands for Web Archive. WAR file represents the web application. Web module contains servlet classes, JSP files, HTML files, JavaScripts, etc. are packaged as a JAR file with .war extension. It contains a special directory called WEB-INF.

WAR is a module that loads into a web container of the Java Application Server. The Java Application Server has two containers: Web Container and EJB Container.

The Web Container hosts the web applications based on Servlet API and JSP. The web container requires the web module to be packaged as a WAR file. It is a WAR file special JAR file that contains a web.xmlv file in the WEB-INF folder.

An EJB Container hosts Enterprise Java beans based on EJB API. It requires EJB modules to be packaged as a JAR file. It contains an ejb-jar.xml file in the META-INF folder.

The advantage of the WAR file is that it can be deployed easily on the client machine in a Web server environment. To execute a WAR file, a Web server or Web container is required. For example, Tomcat, Weblogic, and Websphere.

### JAR
JAR stands for Java Archive. An EJB (Enterprise Java Beans) module that contains bean files (class files), a manifest, and EJB deployment descriptor (XML file) are packaged as JAR files with the extension .jar. It is used by software developers to distribute Java classes and various metadata.

In other words, A file that encapsulates one or more Java classes, a manifest, and descriptor is called JAR file. It is the lowest level of the archive. It is used in J2EE for packaging EJB and client-side Java Applications. It makes the deployment easy.

### EAR
EAR stands for Enterprise Archive. EAR file represents the enterprise application. The above two files are packaged as a JAR file with the .ear extension. It is deployed into the Application Server. It can contain multiple EJB modules (JAR) and Web modules (WAR). It is a special JAR that contains an application.xml file in the META-INF folder.


## Logs
logging.level.org.springframework: DEBUG  

# Web Services?
Web services are the types of internet software that uses standardized messaging protocol over the distributed environment. It integrates the web-based application using the REST, SOAP, WSDL, and UDDI over the network. For example, Java web service can communicate with .Net application.

**Web services features are **
- it designed for application to application interaction. 
- It should be interoperable. 
- It should allow communication over the network.

**Components of Web Services are:**
- The web service must be accessible over the internet.
- The web service is discoverable through a common mechanism like UDDI.
- It must be interoperable over any programming language or Operating System.
**Uses of Web Services**
- Web services are used for reusing the code and connecting the existing program.
- Web services can be used to link data between two different platforms.
- It provides interoperability between disparate applications.

**How does data exchange between applications?**
Suppose, we have an Application A which create a request to access the web services. The web services offer a list of services. The web service process the request and sends the response to the Application A. The input to a web service is called a request, and the output from a web service is called response. The web services can be called from different platforms.
https://static.javatpoint.com/tutorial/restful-web-services/images/what-is-web-services.png

There are two popular formats for request and response XML and JSON. JSON is supported by wide variety of platform. JSON is a readable format for structuring data. It is used for transiting data between server and web application.

**Service defination** is use to identify the request and response offered by Web service.
- Request/ Response format: Defines the request format made by consumer and response format made by web service.
- Request Structure: Defines the structure of the request made by the application.
- Response Structure: Defines the structure of response returned by the web service.
- Endpoint: Defines where the services are available.

**Key Terminology of Web Services**
- **Request and Response:** Request is the input to a web service, and the response is the output from a web service.
- **Message Exchange Format:** It is the format of the request and response. There are two popular message exchange formats: XML and JSON.
- **Service Provider or Server:** Service provider is one which hosts the web service.
- **Service Consumer or Client:** Service consumer is one who is using the web service.
- **Service Definition:** Service definition is the contract between the service provider and service consumer. Service definition defines the format of request and response, request structure, response structure, and endpoint.
- **Transport:** Transport defines how a service is called. There is two popular way of calling a service: **HTTP and Message Queue (MQ)**. By tying the URL of service, we can call the service over the internet. MQ communicates over the queue. The service requester puts the request in the queue. As soon as the service provider listens to the request. It takes the request, process the request, and create a response, and put the response back into MQ. The service requester gets the response from the queue. The communication happens over the queue.
https://static.javatpoint.com/tutorial/restful-web-services/images/key-terminology-of-web-services.png

**Characteristics of Web Services**
1. **XML-based** - A web service uses XML at information representation and record transportation layer. Using XML, there is no need of networking, operating system, or platform binding. Web offering based application is highly interoperable application at their middle level.

2. **Loosely Coupled** - A web service supports loosely coupled connections between systems. It communicates by passing XML message to each other via a web API. Web API adds a layer of abstraction to the environment that makes the connection adaptable and flexible.

3. **Capability to be synchronous and asynchronous** - 

    Synchronous Web services are invoked over existing Web protocols by a client who waits for a response. Synchronous Web services are served by RPC-oriented messaging.
    
    Asynchronous Web services are invoked over existing Web protocols by a client who does not wait for a response. The document-oriented messaging often used for asynchronous Web services. Asynchronous Web Service is a crucial factor in enabling loosely coupled system.

    Servlets, HTTP, and XML/SOAP are used to implement synchronous or asynchronous endpoints.

4. **Supports RPC** - A web service supports RPC through offering services of its personal, equivalent to those of a traditional aspect.
    * A web service is a web resource. We can access a web service using platform-independent and language-neutral web protocols, such as HTTP. HTTP ensures easy integration of heterogeneous environment.
    * A web service is typically registered. It can be located through a web service registry. A registry enables service consumers to find service that matches their needs. The service consumers may be human or other application.
    * A web service provides an interface (a web API) that can be called from another program. The application-to-application programming can be invoked from any application.

## Web Service Architecture
The Web Services architecture describes how to instantiate the elements and implement the operations in an interoperable manner.

The architecture of web service interacts among three roles: service provider, service requester, and service registry. The interaction involves the three operations: publish, find, and bind. These operations and roles act upon the web services artifacts. The web service artifacts are the web service software module and its description.

### Web Service Implementation Lifecycle

A web service implementation lifecycle refers to the phases for developing web services from the requirement to development. An Implementation lifecycle includes the following phases:

Requirements Phase, Analysis Phase, Design Phase, Coding Phase, Test Phase, Deployment Phase

## Types of Web Services
- RESTful Web Servies: (REpresentational State Transfer)
- SOAP Web Services
### RESTfill Web Services

RESTful Web Services are client and server applications that communicate over the WWW uses REST Architecture based Web Services in which everything is a resource. RESTful Web Services provides communication between software applications running on different platforms and frameworks. We can consider web services as code on demand. A RESTful Web Service is a function or method which can be called by sending an HTTP request to a URL, and the service returns the result as the response. 

It does not define the standard message exchange format. We can build REST services with both XML and JSON. JSON is more popular format with REST. The key abstraction is a resource in REST. A resource can be anything. It can be accessed through a Uniform Resource Identifier (URI). For example:

The resource has representations like XML, HTML, and JSON. The current state is captured by representational resource. When we request a resource, we provide the representation of the resource. The important methods of HTTP are:
- GET: It reads a resource.
- PUT: It updates an existing resource.
- POST: It creates a new resource.
- DELETE: It deletes the resource.

For example, if we want to perform the following actions in the social media application, we get the corresponding results.

* POST /users: It creates a user.
* GET /users/{id}: It retrieve the detail of one user.
* GET /users: It retrieve the detail of all users.
* DELETE /users: It delete all users.
* DELETE /users/{id}: It delete a user.
* GET /users/{id}/posts/post_id: It retrieve the detail of a specific post.
* POST / users/{id}/ posts: It creates a post for a user.
* GET /users/{id}/post: Retrieve all posts for a user

#### HTTP standad status code
- 404: RESOURCE NOT FOUND
- 200: SUCCESS
- 201: CREATED
- 401: UNAUTHORIZED
- 500: SERVER ERROR

#### RESTful Service Constraints
- There must be a service producer and service consumer.
- The service is stateless.
- The service result must be cacheable.
- The interface is uniform and exposing resources.
- The service should assume a layered architecture.

#### Advantages of RESTful web services
- RESTful web services are platform-independent.
- It can be written in any programming language and can be executed on any platform.
- It provides different data format like JSON, text, HTML, and XML.
- It is fast in comparison to SOAP because there is no strict specification like SOAP.
- These are reusable.
- These are language neutral.

**SOAP Protocol:** 
- SOAP is a protocol.	
- SOAP acronym for Simple Object Access Protocol.	
- In SOAP, the data exchange format is always XML.	
- XML is the most popular data exchange format in SOAP web services.	
- SOAP uses Web Service Definition Language (WSDL).	
- SOAP does not pose any restrictions on transport. We can use either HTTP or MQ.	
- SOAP web services are typical to implement.	
- SOAP web services use the JAX-WS API.	
- SOAP protocol defines too many standards.	
- SOAP cannot use RESTful services because it is a protocol.	
- SOAP reads cannot be cached.	

---vs---	

**RESTful Web Services:**
- REST is an architectural approach.
- REST acronym for REpresentational State Transfer.
- There is no strict data exchange format. We can use JSON, XML, etc.
- JSON is the most popular data exchange format in RESTful web services.
- REST does not have any standard definition language.
- RESTful services use the most popular HTTP protocol.
- RESTful services are easier to implement than SOAP.
- RESTful web services use the JAX-RS API.
- RESTful services do not emphasis on too many standards.
- RESTful service can use SOAP web services because it is an architectural approach that can use any protocol like HTTP and SOAP.
- REST reads can be cached.

## Spring Boot Auto Configuration and Dispatcher Servlet
Background functionality of the application:

- What is dispatcher servlet?
- Who is configuring dispatcher servlet?
- What does dispatcher servlet do?
- How does the HelloWorldBean object gets converted to JSON?
- Who is configuring the error mapping?

### Spring Boot Auto Configuration
- Spring Boot automatically configures a spring application based on dependencies present or not present in the classpath as a jar, beans, properties, etc.
- It makes development easier and faster as there is no need to define certain beans that are included in the auto-configuration classes.
- A typical MVC database driven Spring MVC application requires a lot of configuration such as dispatcher servlet, a view resolver, Jackson, data source, transaction manager, among many others.
    - Spring Boot auto-configures a Dispatcher Servlet if Spring MVC jar is on the classpath.
    - Auto-configures the Jackson if Jackson jar is on the classpath.
    - Auto-configures a Data Source if Hibernate jar is on the classpath.
- Auto-configuration can be enabled by adding @SpringBootApplication or @EnableAutoConfiguration annotation in startup class. - It indicates that it is a spring context file.
- It enables something called auto-configuration.
- It enable something called components scan. It is the features of Spring where it will start automatically scanning classes in the package and sub package for any bean file.
- There is some example of auto configuration done by Spring Boot:
- DispatcherServletAutoConfiguration
- DataSourceAutoConfiguration
- JacksonAutoConfiguration
- ErrorMvcAutoConfiguration (#basicErrorController)
- We can see the auto-configuration done by Spring Boot in the AUTO-CONFIGURATION REPORT or CONDITIONS EVALUATION REPORT.
- Classes can be excluded from auto-configuration by adding:
```java
@SpringBootApplication (exclude={JacksonAutoConfiguration.class, JmxAutoConfiguration.class})  
```
Or add the following statement in the application.properties file.
```
spring.autoconfiguration.exclude=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration  
```
We exclude classes form the auto-configuration for faster startup and better performance of the application.
    - AUTO-CONFIGURATION REPORT generated by enabling debug mode. Open the application.properties file and add the following statement:
```
logging.level.org.springframework=debug  
```
Run RestfulWebServiceApplication.java file. It shows the Positive matches, Negative matches, Exclusions, and Unconditional classes under the CONDITIONS EVALUATION REPORT.
```
-----------------------------------------------  
CONDITIONS EVALUATION REPORT  
-----------------------------------------------  
Positive matches:  
----------------------  
ActiveMQAutoConfiguration matched:  
- @ConditionalOnClass found required classes 'javax.jms.ConnectionFactory', 'org.apache.activemq.ActiveMQConnectionFactory' (OnClassCondition)  
- @ConditionalOnMissingBean (types: javax.jms.ConnectionFactory; SearchStrategy: all) did not find any beans (OnBeanCondition)  
------------------  
------------------  
------------------  
Negative matches:  
-------------------------  
ActiveMQConnectionFactoryConfiguration.PooledConnectionFactoryConfiguration: Did not match:  
-@ConditionalOnClass did not find required classes 'org.messaginghub.pooled.jms.JmsPoolConnectionFactory','org.apache.commons.pool2.PooledObject' (OnClassCondition)  
----------------  
----------------  
----------------  
Exclusions:  
---------------  
None  
Unconditional classes:  
-----------------------------    org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration  
org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration  
```
There is a lot of information inside the report, so it is not possible to show all the detail. If we scroll down the report and have a closure look at auto configuration log, we found DispatcherServletAutoConfiguration matched.
```
DispatcherServletAutoConfiguration matched:  
-@ConditionalOnClass found required class 'org.springframework.web.servlet.DispatcherServlet' (OnClassCondition)  
- found 'session' scope (OnWebApplicationCondition)  
```
It is because, the dependency spring-boot-starter-web depends on spring-webmvc dependency. Therefore we get the DispatcherServlet class in our classpath.

#### Dispatcher Servlet
In Spring MVC all incoming requests go through a single servlet is called Dispatcher Servlet (front controller). The front controller is a design pattern in web application development. A single servlet receives all the request and transfers them to all other components of the application.

https://static.javatpoint.com/tutorial/restful-web-services/images/spring-boot-auto-configure.png

Spring Boot Auto Configuration and Dispatcher Servlet
The job of DispatcherServlet is to take an incoming URI and find the right combination of handlers (Controller classes) and views (usually JSPs). When the DispatcherServlet determines the view, it renders it as the response. Finally, the DispatcherServlet returns the Response Object to back to the client. In short, the Dispatcher Servlet plays the key role.

The other thing to notice is that ErrorMvcAutoConfiguration:
```
ErrorMvcAutoConfiguration matched:  
-@ConditionalOnClass found required classes 'javax.servlet.Servlet', 'org.springframework.web.servlet.DispatcherServlet' (OnClassCondition)- found 'session' scope (OnWebApplicatiossssnCondition)  
```
It configures the basicErrorController, errorAttributes, ErrorMvcAutoConfiguration, and DefaultErrorViewResolverConfiguration. 

It creates the default error page which is known as Whitelabel Error Page. https://static.javatpoint.com/tutorial/restful-web-services/images/spring-boot-auto-configure2.png

The other thing which is auto-configured HttpMessageConvertersAutoConfiguration. These message converter automatically converts the message.
```
HttpMessageConvertersAutoConfiguration matched:  
-@ConditionalOnClass found required class 'org.springframework.http.converter.HttpMessageConverter' (OnClassCondition)  
----------------  
-----------------  
JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration matched: - @ConditionalOnClass found required class 'org.springframework.http.converter.json.Jackson2ObjectMapperBuilder'(OnClassCondition)  
```
It initializes the Jackson bean and the message converter. The Jackson2ObjectMapper does the conversion from bean to JSON and JSON to bean.

## Implementing the GET Method
### PathVariable
The @PathVariable annotation is used to extract the value from the URI. It is most suitable for the RESTful web service where the URL contains some value. Spring MVC allows us to use multiple @PathVariable annotations in the same method. A path variable is a critical part of creating rest resources.

```java
package com.demo.server.main;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.context.annotation.Configuration;  
@Configuration  
//Controller  
@RestController  
public class HelloWorldController   
{  
    //using get method and hello-world URI  
    @GetMapping(path="/hello-world")  
    public String helloWorld()  
    {  
        return "Hello World";  
    }  
    @GetMapping(path="/hello-world-bean")  
    //method- which returns "Hello World"  
    public HelloWorldBean helloWorldBean()  
    {  
        return new HelloWorldBean("Hello World");//constructor of HelloWorldBean  
    }  
    //passing a path variable  
    @GetMapping(path="/hello-world/path-variable/{name}")   // http://localhost:8080/hello-world/path-variable/Anubhav
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)  
    {  
        return new HelloWorldBean(String.format("Hello World, %s", name)); //%s replace the name  
    }  
}  
```

## Implementing the POST Method
### @ResponseBody
The @RequestBody annotation maps body of the web request to the method parameter. The body of the request is passed through an HttpMessageConverter. It resolves the method argument depending on the content type of the request. Optionally, automatic validation can be applied by annotating the argument with @Valid.
### @PathMapping
The @PathMapping annotation is the specialized version of the @RequestMapping annotation which acts as a shortcut for @RequestMapping(method=RequestMethod=POST). @PostMapping method handles the Http POST requests matched with the specified URI.
### Enhancing POST Method to Return Correct HTTP Code and Status Location
**ResponseEntity Class**
The ResponseEntity is a class which extends HttpEntity and HttpStatus class. It is defined in org.springframework.http.RequestEntity.
    - It is used in RestTemplate and @Controller methods.
    - It is used as parameter in getForEntity() and exchange() method.
    - It is also used in Spring MVC, as a parameter in a @Controller method.

The **ServletUriComponentsBuilder** is a class which is defined in org.springframework.web.servlet.support.ServletUriComponentsBuilder. It extends UriComponentsBuilder class. It has additional static factory methods to create a link based on the current HttpServletRequest.

**fromCurrentRequest() method:** It is similar to fromRequest(HttpServletRequest) method except the request is obtained through RequestContextHolder.

**path() method:** The path() is the method of UriComponentsBuilder class. It appends the given path to the existing path of this builder. The given path may contain URI template variable.

**buildAndExpand() method:** It builds UriComponents instance and replaces URI template variables with the values obtained from an array. It is the shortcut method which combines calls to build() and then UriComponents.expand(Object... uriVariableValues).

**build() method:** It builds UriComponents instance from the various components contained in the builder.

### Creating User Bean and User Service @Component
```java
package com.javatpoint.server.main.user;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class UserResource   
{  
    @Autowired  
    private UserDaoService service;  
    @GetMapping("/users")  // localhost:8080/users
    public List<User> retriveAllUsers()  
    {  
        return service.findAll();  
    }  
    //retrieves a specific user detail  
    @GetMapping("/users/{id}")  // localhost:8080/users/{id}
    public User retriveUser(@PathVariable int id)  
    {  
        return service.findOne(id);  
    }  
    //method that posts a new user detail   
    @PostMapping("/users")  
    public void createUser(@RequestBody User user)  
    {  
        User sevedUser=service.save(user);    
    }  
    
    //method that posts a new user detail and returns the status of HTTP and location of the user resource  
    @PostMapping("/users_status")  
    public ResponseEntity<Object> createUserWithStatus(@RequestBody User user)  
    {  
        User sevedUser=service.save(user);    
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();  
        return ResponseEntity.created(location).build();  // check response in Headers of postman tool
    }  
}  
```
```java
// Note:- User.java bean created with attributes and setter-getter methods.

package com.demo.server.main.user;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
import org.springframework.stereotype.Component;  
@Component  
public class UserDaoService   
{  
    public static int usersCount=5;  
    //creating an instance of ArrayList  
    private static List<User> users=new ArrayList<>();  
    //static block   
    static  
    {  
        //adding users to the list  
        users.add(new User(1, "John", new Date()));  
        users.add(new User(2, "Robert", new Date()));  
        users.add(new User(3, "Adam", new Date()));  
        users.add(new User(4, "Andrew", new Date()));  
        users.add(new User(5, "Jack", new Date()));  
    }  
    //method that retrieve all users from the list  
    public List<User> findAll()  
    {  
        return users;  
    }  
    //method that add the user in the list   
    public User save(User user)  
    {  
        if(user.getId()==null)  
        {  
            //increments the user id  
            user.setId(++usersCount);  
        }  
        users.add(user);  
        return user;  
    }  
    //method that find a particular user from the list  
    public User findOne(int id)  
    {  
        for(User user:users)  
        {  
            if(user.getId()==id)  
            return user;  
        }  
        return null;  
    }  
} 
```

It displaying in the default timestamp format --> "dob": "1500370250075"
```
# application.properties file. Remove the debug configuration and add the following configuration:

spring.jackson.serialization.write-dates-as-timestamps=false  
```

# Hibernate
- Hibernate is an open-source and lightweight ORM tool that is used to store, manipulate, and retrieve data from the database. 

- ORM is an acronym for Object/Relational mapping. It is a programming strategy to map object with the data stored in the database. It simplifies data creation, data manipulation, and data access.

- Hibernate architecture comprises of many interfaces such as Configuration, SessionFactory, Session, Transaction, etc.\
    https://www.javatpoint.com/images/hibernate/architecture.jpg

- Classes whose objects are stored in a database table are called as persistent classes.

- The core interfaces of Hibernate framework are:
    * Configuration
    * SessionFactory
    * Session
    * Query
    * Criteria
    * Transaction
    These are also key component of hibernate.

- SessionFactory provides the instance of Session. It is a factory of Session. It holds the data of second level cache that is not enabled by default. SessionFactory is a thread-safe object, many threads cannot access it simultaneously.

- Session maintains a connection between the hibernate application and database.\
    It provides methods to store, update, delete or fetch data from the database such as persist(), update(), delete(), load(), get() etc. It is a factory of Query, Criteria and Transaction i.e. it provides factory methods to return these instances.
    Session is not a thread-safe object, many threads can access it simultaneously. In other words, you can share it between threads.

- ORM has the following advantages over JDBC:
    * application development is fast.
    * Management of transaction.
    * Generates key automatically.
    * Details of SQL queries are hidden.

- The objects of criteria are used for the creation and execution of the object-oriented criteria queries. A criterion is added to a SQL query by using the ""Session.createCriteria**.

- Some of the databases supported by Hibernate are: DB2, MySQL, Oracle, Sybase SQL Server, Informix Dynamic Server, HSQL, PostgreSQL, FrontBase

- Components of Hibernate configuration object  
    - Database connection
    - Class Mapping Setup

- The SQL query is created with the help of **Session.createSQLQuery**

- HQL is Hibernate Query Language. The HQL query is created with the help of **Session.createQuery**


- save()	
    - returns the identifier (Serializable) of the instance.	
    - Syntax: public Serializable save(Object o)

- persist()
    - Return nothing because its return type is void.
	- Syntax: public void persist(Object o)

- get()	
    - Returns null if an object is not found.	
    - get() method always hit the database.
    - It returns the real object, not the proxy.
    - It should be used if you are not sure about the existence of instance.

- load()
    - Throws ObjectNotFoundException if an object is not found.
    - load() method doesn't hit the database.
    - It returns proxy object.
    - It should be used if you are sure that instance exists.

- update()
    - Update means to edit something.
    - update() should be used if the session doesn't contain an already persistent state with the same id. It means an update should be used inside the session only. After closing the session, it will throw the error.

- merge() 
    - Merge means to combine something.
    - merge() should be used if you don't know the state of the session, means you want to make the modification at any time.

```java
SessionFactory factory = cfg.buildSessionFactory();  
Session session1 = factory.openSession();  
   
Employee e1 = (Employee) session1.get(Employee.class, Integer.valueOf(101));//passing id of employee  
session1.close();  
   
e1.setSalary(70000);  
   
Session session2 = factory.openSession();  
Employee e2 = (Employee) session1.get(Employee.class, Integer.valueOf(101));//passing same id  
  
Transaction tx=session2.beginTransaction();  
session2.merge(e1);  
  
tx.commit();  
session2.close();  

// After closing session1, e1 is in detached state. It will not be in the session1 cache. So if you call update() method, it will throw an error.
// Then, we opened another session and loaded the same Employee instance. If we call merge in session2, changes of e1 will be merged in e2.
```

- There are 3 states of the object (instance) in hibernate.
    - **Transient:** The object is in a transient state if it is just created but has no primary key (identifier) and not associated with a session.
    - **Persistent:** The object is in a persistent state if a session is open, and you just saved the instance in the database or retrieved the instance from the database.
    - **Detached:** The object is in a detached state if a session is closed. After detached state, the object comes to persistent state if you call lock() or update() method.

- If you mark a class as mutable="false", the class will be treated as an immutable class. By default, it is mutable="true".

- 
Sabrina Iacaruso <breens@meta.com>
12:41 PM (3 hours ago)
to me

Hi Ankita -

I received your application for the Software Engineer, Systems ML role, but wanted to set up some time for us to connect about a similar role Software Engineer, Machine Learning. I'd like to learn more about your experience and tell you more about opportunities here in more detail.

Please feel free to select a date and time that works best using my the calendar link below.

I look forward to connecting.

- There are 3 ways of **inheritance mapping in hibernate**.
    - **Table per hierarchy**\
            In table per hierarchy mapping, single table is required to map the whole hierarchy, an extra column (known as discriminator column) is added to identify the class. But nullable values are stored in the table .
    - **Table per concrete class**\
            tables are created as per class. But duplicate column is added in subclass tables.
    - **Table per subclass**\
            tables are created as per class but related by foreign key. So there are no duplicate columns.

Example Table per hierarchy
```xml
<!-- pom.xml-->
<dependency>  
    <groupId>org.hibernate</groupId>  
    <artifactId>hibernate-core</artifactId>  
    <version>5.3.1.Final</version>  
</dependency>  
      
<dependency>  
    <groupId>com.oracle</groupId>  
    <artifactId>ojdbc14</artifactId>  
    <version>10.2.0.4.0</version>  
</dependency>  

<!--hibernate.cgf.xml file, and add entries of entity classes like this:-->
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE hibernate-configuration PUBLIC  
        "-//Hibernate/Hibernate Configuration DTD 5.3//EN"  
        "http://www.hibernate.org/dtd/hibernate-configuration-5.3.dtd">  
<hibernate-configuration>  
    <session-factory>  
            
    <property name="hbm2ddl.auto">update</property>    
        <property name="dialect">org.hibernate.dialect.Oracle9Dialect</property>    
        <property name="connection.url">jdbc:oracle:thin:@localhost:1521:xe</property>    
        <property name="connection.username">system</property>    
        <property name="connection.password">jtp</property>    
        <property name="connection.driver_class">oracle.jdbc.driver.OracleDriver</property>   
       
        <mapping class="com.javatpoint.mypackage.Employee"/>  
        <mapping class="com.javatpoint.mypackage.Regular_Employee"/>  
        <mapping class="com.javatpoint.mypackage.Contract_Employee"/>  
          
    </session-factory>  
</hibernate-configuration> 
```
```java
//File: Employee.java
package com.javatpoint.mypackage;  
import javax.persistence.*;  
  
@Entity  
@Table(name = "employee101")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="employee")  
  
public class Employee {  
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)  
      
@Column(name = "id")  
private int id;  
  
@Column(name = "name")  
private String name;  
  
//setters and getters  
}  

//File: Regular_Employee.java
package com.javatpoint.mypackage;  
import javax.persistence.*;  
  
@Entity  
@DiscriminatorValue("regularemployee")  
public class Regular_Employee extends Employee{  
      
@Column(name="salary")    
private float salary;  
  
@Column(name="bonus")     
private int bonus;  
  
//setters and getters  
}  

// File: Contract_Employee.java
package com.demo.mypackage;  
import javax.persistence.Column;  
import javax.persistence.DiscriminatorValue;  
import javax.persistence.Entity;  
  
@Entity  
@DiscriminatorValue("contractemployee")  
public class Contract_Employee extends Employee{  
      
    @Column(name="pay_per_hour")  
    private float pay_per_hour;  
      
    @Column(name="contract_duration")  
    private String contract_duration;  
  
    //setters and getters  
}  

// StoreTest.java
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class StoreTest {  
  
    public static void main(String args[])  
    {  
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
         Transaction t=session.beginTransaction();    
            
            Employee e1=new Employee();    
            e1.setName("Gaurav Chawla");    
                
            Regular_Employee e2=new Regular_Employee();    
            e2.setName("Vivek Kumar");    
            e2.setSalary(50000);    
            e2.setBonus(5);    
                
            Contract_Employee e3=new Contract_Employee();    
            e3.setName("Arjun Kumar");    
            e3.setPay_per_hour(1000);    
            e3.setContract_duration("15 hours");    
                
            session.persist(e1);    
            session.persist(e2);    
            session.persist(e3);    
                
            t.commit();    
            session.close();    
            System.out.println("success");        
    }  
}  
```