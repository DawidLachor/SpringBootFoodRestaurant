#Spring Boot Food Restaurant
This program is web application for order food. We can order food and manage orders. The application is built on Spring Boot and database is PostgreSQL.

![Index page](src/main/resources/static/image/IndexPage.png)

![Order page](src/main/resources/static/image/OrdersPage.png)

##Table of contents
* [Setup](#setup)
* [Technologies](#technologies)
* [Features](#features)
* [Sources](#sources)

##Setup

1. Download or Clone project:
```
https://github.com/DawidLachor/SpringBootFoodRestaurant.git
```
2. Run SpringmvcApplication.class
3. Run a browser and go to url: 
```
http://localhost:8080
```
4. When you want to enter the manage orders, enter the url:
```
http://localhost:8080/panel/orders
```

##Technologies
Project is created with:

* Java 11
* Spring Boot 2.4.1
* Spring/Bean Validation
* Spring Data
* Spring MVC  
* PostgreSQL

##Features

* order products
* manage orders `localhost:8080/panel/orders`
    * edit status order
    * filtration orders by status

##Sources
This app is based on tutorial from [JavaStart](https://javastart.pl)