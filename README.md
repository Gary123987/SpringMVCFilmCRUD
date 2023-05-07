## Spring MVC Film C.R.U.D. Project

#Description
Web based application that makes queries, additions, updates and permitted deletes to a locally hosted database of films.

#Technologies Used
- Java
- Spring Boot
- SQL
- JSP
- MAMP
- Gradle
- Apache Tomcat
- Git

#Lessons Learned
Initial setup included constructing classes based on the tables to be accessed within MySQL (Film, Actor). The classes contain private fields matched to each row of data in the SQL tables. Each class also consisted of various constructors including a no-arg, getters and setters for each field, a toString() based on initial fields as well as hashCode() and equals() methods.

The DatbaseAccessor is an interface implemented by the DatabaseAccessorObject("DAO") class, methods for the DAO are declared in the interface.

DAO is the only class that accesses the database. URL and MySQL login criteria are assigned as private fields. Methods in this class contain all logic within try catch blocks to handle SQL Exceptions. Methods include searching by film and actor ID, searching by keyword in film title or description; creating, deleting and updating films and actors. There is also methods to get the film language and category which are held in separate tables and joined by their respective ID's.

Controller...

JSPs...
	Each page includes basic Bootstrap for a cleaner user interface. The bottom of every page (except home) contains a duplicate navigation menu with options to move to other functionalities of site.

Viewers...

Web.xml...

Film-servlet.xml...