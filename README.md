![](images/my-strip-top.svg)
# Cinema app welcomes you!
The cinema is the most important of all the arts, one historical figure had proclaimed. Our app is made to 
keep up and multiply this art's greatness.

The application offers a cinema ticket service. Its' implementation utilizes such frameworks 
as Hibernate and Spring and is based on SOLID and REST architectural principles.

### Features

This app stores info about users and everything related to their orders in database using Hibernate. 
Also we have a simple Spring-based authentication here with two roles: User and Admin. 
Admin gets user role by default. 
The application utilizes DTO mapping/unmapping for both requests and responses with all needed 
checks for request DTO i.e. email and password consistency via regexp etc.

##### Entities list and their fields:

* User (email, password (encrypted), role)
* Order (tickets list, order time, user)
* Shopping cart (tickets list, user)
* Role (enum role name: USER or ADMIN)
* Movie (title, description)
* Cinema hall (capacity, description)
* Movie session (movie, cinema hall, show time)
* Ticket (movie session, user)

### Users and admins privilleges according to endpoint and request type

##### Without authentication

```POST: /login``` — login page<br>
```POST: /register``` — registration page

##### Users and admins can:

```GET: /cinema-halls``` — display all the cinema halls<br>
```GET: /movies``` — display all the movies we have<br>
```GET: /movie-sessions/available``` — display all the available movie sessions<br>
```GET: /orders``` — display all the orders of the currently logged user<br>
```POST: /orders/complete``` — complete the current order<br>
```PUT: /shopping-carts/movie-sessions``` — add movie session to the shopping cart<br>
```GET: /shopping-carts/by-user``` — display the contents of the currently logged user's shopping cart<br>

##### Admins can:

```GET: /users/by-email``` — find user by email<br>
```POST: /cinema-halls```— add new cinema hall<br>
```POST: /movies```— add new movie<br>
```POST: /movie-sessions```— add new movie session<br>
```PUT: /movie-sessions/{id}```— update movie session with specified id<br>
```DELETE: /movie-sessions/{id}```— delete movie session by id<br>

### Technologies used

* Java
* Hibernate
* Spring Framework
* REST
* MySQL
* Maven
* Apache Tomcat

### Important notes on how to start

To start the app you need to have Apache Tomcat and MySQL installed and configured.
Create 'cinema_app' MySQL schema
Edit the following fields in db.properties file to match your own: 

```
#MySQL properties
db.driver=YOUR_DRIVER
db.url=YOUR_DATABASE_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD
```

Use this url: ```http://localhost:8080/inject``` to inject mock data.<br>
Before that you can edit emails and passwords in file ```cinema/controller/InjectController``` to your own taste.

#### Then please take your seat and enjoy the screening!
![](images/my-strip-bottom.svg)   