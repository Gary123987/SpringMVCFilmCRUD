## Spring MVC Film C.R.U.D. Project

## Description
Web based application that makes queries, additions, updates and permitted deletes to a locally hosted film database.

## Technologies Used
- Java
- Spring MVC
- SQL
- JSP
- MAMP
- Gradle
- Apache Tomcat
- Git

## Lessons Learned
Initial setup included constructing classes based on the tables to be accessed within MySQL (Film, Actor). The classes contain private fields matched to each row of data in the SQL tables. Each class also consisted of various constructors including a no-arg, getters and setters for each field, a toString() based on initial fields as well as hashCode() and equals() methods.

The DatbaseAccessor is an interface implemented by the DatabaseAccessorObject("DAO") class, methods for the DAO are declared in the interface.

DAO is the only class that accesses the database. URL and MySQL login criteria are assigned as private fields. Methods in this class contain all logic within try catch blocks to handle SQL Exceptions. Methods include searching by film and actor ID, searching by keyword in film title or description; creating, deleting and updating films and actors. There is also methods to get the film language and category which are held in separate tables and joined by their respective ID's.

The controller is essentially a middleman between the front end and back end. We were able to map requests from the front end, and use the input given with our java methods, then return data back to the front end. The best strategy seems to be to keep your controllers relatively simple, and do most of the heavy lifting in the DAO, using the controllers to call methods from the DAO.

JSPs, making multiple JSPs was an effective strategy. depending on what the user wanted to do, we could easily route them to a page that would display everything they needed. 

Each page includes basic Bootstrap for a cleaner user interface. The bottom of every page (except home) contains a duplicate navigation menu with options to move to other functionalities of the site.

Film Viewer logic is contained in a c:choose / c:when statement that executes a for each loop to iterate through a list of films and display every film and their full details, including category and list of actors. If a single film object is sent just one film is displayed in the same format and error message if the film is not in the database. The AddFilmViewer and DeletedFilmViewer copy most of this logic as well.

Overall, this project came together relatively quickly given our limited experience with web apps up to this point. We probably could have benefited from planning more so there was less confusion with git push/pulls. Whenever something surprised us we stopped and walked through it together to make sure both of us were on the same page and avoided unnecessary errors.