![](images/my-strip-top.svg)
# Cinema app welcomes you!
The cinema is the most important of all the arts, one historical figure had proclaimed. Our app is made to 
keep up and multiply this art's greatness.

The application offers a cinema ticket service. Its' implementation utilizes such a frameworks 
as Hibernate and Spring and is based on SOLID and REST architectural principles.

### Features

This app stores info about users and everything related to their orders in database using Hibernate. 
Also we have a simple Spring-based authentication here with two roles: User and Admin. 
Admin gets user role by default. 
The application utilizes DTO mapping/unmapping for both requests and responses with all needed 
checks for request DTO i.e. email and password consistency via regexp etc.

##### Entities list and their fields:

* User (email, password (encrypted), role)
* Order (tikets list, order time, user)
* Shopping cart (tickets list, user)
* Role (enum role name: USER or ADMIN)
* Movie (title, description)
* Cinema hall (capacity, description)
* Movie session (movie, cinema hall, show time)
* Ticket (movie session, user)

### Users and admins privilleges according to endpoint and request type

POST: /login - without authentication

##### Users and admins can:

GET: /cinema-halls<br>
GET: /movies<br>
GET: /movie-sessions/available<br>
GET: /movie-sessions/{id}<br>
GET: /orders<br>
POST: /orders/complete<br>
PUT: /shopping-carts/movie-sessions<br>
GET: /shopping-carts/by-user<br>

##### Admins can:

GET: /users/by-email<br>
POST: /cinema-halls<br>
POST: /movies<br>
POST: /movie-sessions<br>
PUT: /movie-sessions/{id}<br>
DELETE: /movie-sessions/{id}<br>

### Technologies used

* Java
* Hibernate
* Spring Framework
* REST
* MySQL
* Regex
* Apache Tomcat

### Important notes on how to start

To start the app you need to have Apache Tomcat and MySQL installed and configured.

Edit the following fields in db.properties file to match your own: 

```
#MySQL properties
db.driver=YOUR_DRIVER
db.url=YOUR_DATABASE_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD
```

#### Then please take your seat and enjoy the screening!
![](images/my-strip-bottom.svg)   