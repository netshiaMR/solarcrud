# RENDANI NETSHIA INTERVIEW CRUD PROJECT 
** Terra Firma Software Developer Technical Assessment **  </br>

This project have two project which one is SPRING BOOT MAVEN and the second one is SPRING BOOT GRAILS.
SPRING BOOT MAVEN contains a full MVC CRUD Operations. and the second one contains SPRING BOOT GRAILS only provide a full rest api for crud operation.

Everything in this project is based on the following Questions.
	
 ** Question 1**
NB: All query statements created must be submitted
1. Import the 3 tabs of data into 3 tables with the same names as the tabs.
2. Identify and setup any key relationships that exist.
   ** Question 2 **
NB: All query statements created must be submitted
1. Write a query to Join the meter table to meter_data table.
2. Write a query that will per meter, per day calculate the sum of kwh and max kwh for the solar. Query must 
display the name of each meter
3. Write a query that gives an hourly summary of the meter_data table for each meter containing at least the 
fields (t_stamp, meter_id, kwh, cost)
P a g e | 2
   ** Question 3 **
1. Create a grails 3 project using the above database with basic CRUD functionality for each of the 4 tables.

  ** Question 4**
Use the database you created above to do the following in your grails project
1. For each Meter calculate the amount of energy produced per hour
2. For each Meter calculate the cost per hour
3. Find the Meter that has produced the max energy (kWp) per hour
4. Find the Meter that has produced the min energy (kWp) per hour
   **Question 5**
1. Create a job that will periodical check into the 5 minute table if there is new data that has arrived

   **Question 6 **
Using the results you have calculated on question 4 and the javascript library highcharts 
(https://www.highcharts.com/)
1. For each meter show a graph that shows the amount of energy produced per hour
2. For each meter show a graph that shows the cost of energy produced per hour


## Software requirements 
 - Java JDK 11 or higher
 - [Maven 3.8.0] (https://maven.apache.org/install.html)  
 
 
  


## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `com.solar.crud.solarcrud.SolarcrudApplication` class from your IDE.
	http://localhost:8080

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

This Spring boot MVC SOLERCRUD part of the project is deployed to Heroku Running at this URL https://solarcrud.herokuapp.com

```shell
mvn spring-boot:run

