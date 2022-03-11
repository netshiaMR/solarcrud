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
 
 ## Steps to Setup the Spring Boot Back end app (spacebank_api)

1. **Clone the application**

	```bash
	git clone https://github.com/netshiaMR/solarcrud.git
	cd solarcrud
	```

2. **Create MySQL database**

	```bash
CREATE DATABASE IF NOT EXISTS `terra_firma_assessmentdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `terra_firma_assessmentdb`; 

or Import terra_firma_assessmentdb.sql to you mysql db
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8080.

	You can also package the application in the form of a `jar` file and then run it like so -

	```bash
	mvn package
	java -jar target
  


## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `com.solar.crud.solarcrud.SolarcrudApplication` class from your IDE.
	http://localhost:8080

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

This Spring boot MVC SOLERCRUD part of the project is deployed to Heroku Running at this URL https://solarcrud.herokuapp.com
https://www.youtube.com/watch?v=9q3VcKxjnk0


```shell
mvn spring-boot:run



List of URI to Test with 


Working with Meter Object
	
	URI 
	http://localhost:8080/api/meters used to get all meter from the db HTTP METHOD GET
	http://localhost:8080/api/meters/{id} user to get meter by id  from the db HTTP METHOD GET

	http://localhost:8080/api/meters/{id} user to delete meter by id HTTP METHOD DELETE 
	
	http://localhost:8080/api/meters/ user for create new meter in db HTTP METHOD POST
		{
			"meterId": "replace with value",
			"meterName": "replace with value"
		}
	http://localhost:8080/api/meters/ user for updating exiting meter in db HTTP METHOD PUT
		{
			"meterId": "replace with value",
			"meterName": "replace with value"
		}	

	http://localhost:8080/api/meterdata used to get all meterdata from the db HTTP METHOD GET
	http://localhost:8080/api/meterdata/{id} user to get meterdata by id  from the db HTTP METHOD GET

	http://localhost:8080/api/meterdata/{id} user to delete meterdata by id HTTP METHOD DELETE 
	
	http://localhost:8080/api/meterdata/ user for create new meterdata in db HTTP METHOD POST
						{
						  "ratePerKwh": {
							"type": "string"
						  },
						  "expwh": {
							"type": "string"
						  },
						  "kwh": {
							"type": "string"
						  },
						  "cost": {
							"type": "string"
						  },
						  "vah": {
							"type": "string"
						  },
						  "differenceImpKwh": {
							"type": "string"
						  },
						  "id": {
							"type": "integer"
						  },
						  "expkvarh": {
							"type": "string"
						  },
						  "meter": {
							"type": "integer"
						  },
						  "impwh": {
							"type": "string"
						  },
						  "q3varh": {
							"type": "string"
						  },
						  "derivedData": {
							"type": "string"
						  },
						  "tStamp": {
							"type": "object",
							"properties": {
							  "timezoneOffset": {
								"type": "integer"
							  },
							  "day": {
								"type": "integer"
							  },
							  "hours": {
								"type": "integer"
							  },
							  "minutes": {
								"type": "integer"
							  },
							  "year": {
								"type": "integer"
							  },
							  "time": {
								"type": "integer"
							  },
							  "seconds": {
								"type": "integer"
							  },
							  "date": {
								"type": "integer"
							  },
							  "month": {
								"type": "integer"
							  }
							}
						  },
						  "ptot": {
							"type": "string"
						  },
						  "stot": {
							"type": "string"
						  },
						  "epochTstamp": {
							"type": "string"
						  },
						  "differenceExpKwh": {
							"type": "string"
						  },
						  "impkvarh": {
							"type": "string"
						  },
						  "q4varh": {
							"type": "string"
						  },
						  "q1varh": {
							"type": "string"
						  },
						  "qtot": {
							"type": "string"
						  },
						  "q2varh": {
							"type": "string"
						  }
						}
	http://localhost:8080/api/meters/ user for updating exiting meterdata in db HTTP METHOD PUT
		{
		  "ratePerKwh": {
			"type": "string"
		  },
		  "expwh": {
			"type": "string"
		  },
		  "kwh": {
			"type": "string"
		  },
		  "cost": {
			"type": "string"
		  },
		  "vah": {
			"type": "string"
		  },
		  "differenceImpKwh": {
			"type": "string"
		  },
		  "id": {
			"type": "integer"
		  },
		  "expkvarh": {
			"type": "string"
		  },
		  "meter": {
			"type": "integer"
		  },
		  "impwh": {
			"type": "string"
		  },
		  "q3varh": {
			"type": "string"
		  },
		  "derivedData": {
			"type": "string"
		  },
		  "tStamp": {
			"type": "object",
			"properties": {
			  "timezoneOffset": {
				"type": "integer"
			  },
			  "day": {
				"type": "integer"
			  },
			  "hours": {
				"type": "integer"
			  },
			  "minutes": {
				"type": "integer"
			  },
			  "year": {
				"type": "integer"
			  },
			  "time": {
				"type": "integer"
			  },
			  "seconds": {
				"type": "integer"
			  },
			  "date": {
				"type": "integer"
			  },
			  "month": {
				"type": "integer"
			  }
			}
		  },
		  "ptot": {
			"type": "string"
		  },
		  "stot": {
			"type": "string"
		  },
		  "epochTstamp": {
			"type": "string"
		  },
		  "differenceExpKwh": {
			"type": "string"
		  },
		  "impkvarh": {
			"type": "string"
		  },
		  "q4varh": {
			"type": "string"
		  },
		  "q1varh": {
			"type": "string"
		  },
		  "qtot": {
			"type": "string"
		  },
		  "q2varh": {
			"type": "string"
		  }
		}	
		
	http://localhost:8080/api/meterdata/hourly/MeterEnergyCost HTTP METHOD GET
	[{"hours":0,"timeStamp":"2022-10-03T19:32:28.000+00:00","meterid":4582,"meterName":"MeterG","kwh":"1","cost":"1","min_cost":1.0,"max_cost":1.0,"avgcost":0.0,"total_cost":1,"min_kwh":1.0,"max_kwh":1.0,"avgkwh":0.0,"total_kwh":1},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":0,"timeStamp":"2022-11-03T08:31:36.000+00:00","meterid":7746,"meterName":"MeterR","kwh":"1","cost":"1","min_cost":1.0,"max_cost":1.0,"avgcost":0.0,"total_cost":1,"min_kwh":1.0,"max_kwh":1.0,"avgkwh":0.0,"total_kwh":1}]
	
	http://localhost:8080/api/meterdata/hourly/MeterEnergyCost/{id} HTTP METHOD GET
	[{"hours":1,"timeStamp":"2019-05-31T22:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":2,"timeStamp":"2019-05-31T23:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":3,"timeStamp":"2019-06-01T00:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":4,"timeStamp":"2019-06-01T01:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":5,"timeStamp":"2019-06-01T02:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":6,"timeStamp":"2019-06-01T03:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":7,"timeStamp":"2019-06-01T04:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":8,"timeStamp":"2019-06-01T05:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0,208","cost":"0,1872","min_cost":0.0,"max_cost":4.0,"avgcost":1.167,"total_cost":14,"min_kwh":0.0,"max_kwh":4.0,"avgkwh":1.333,"total_kwh":16},{"hours":9,"timeStamp":"2019-06-01T06:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"5,971","cost":"5,3739","min_cost":10.0,"max_cost":9.0,"avgcost":7.917,"total_cost":95,"min_kwh":10.0,"max_kwh":9.0,"avgkwh":8.833,"total_kwh":106},{"hours":10,"timeStamp":"2019-06-01T07:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"12,891","cost":"11,6019","min_cost":11.0,"max_cost":15.0,"avgcost":13.0,"total_cost":156,"min_kwh":12.0,"max_kwh":16.0,"avgkwh":14.417,"total_kwh":173},{"hours":11,"timeStamp":"2019-06-01T08:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"17,231","cost":"15,5079","min_cost":15.0,"max_cost":18.0,"avgcost":16.583,"total_cost":199,"min_kwh":17.0,"max_kwh":20.0,"avgkwh":18.5,"total_kwh":222},{"hours":12,"timeStamp":"2019-06-01T09:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"20,738","cost":"18,6642","min_cost":18.0,"max_cost":19.0,"avgcost":18.833,"total_cost":226,"min_kwh":20.0,"max_kwh":21.0,"avgkwh":20.833,"total_kwh":250},{"hours":13,"timeStamp":"2019-06-01T10:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"21,586","cost":"19,4274","min_cost":18.0,"max_cost":19.0,"avgcost":18.583,"total_cost":223,"min_kwh":20.0,"max_kwh":21.0,"avgkwh":20.667,"total_kwh":248},{"hours":14,"timeStamp":"2019-06-01T11:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"20,185","cost":"18,1665","min_cost":15.0,"max_cost":18.0,"avgcost":16.667,"total_cost":200,"min_kwh":17.0,"max_kwh":20.0,"avgkwh":18.5,"total_kwh":222},{"hours":15,"timeStamp":"2019-06-01T12:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"17,167","cost":"15,4503","min_cost":11.0,"max_cost":15.0,"avgcost":13.083,"total_cost":157,"min_kwh":12.0,"max_kwh":17.0,"avgkwh":14.5,"total_kwh":174},{"hours":16,"timeStamp":"2019-06-01T13:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"12,122","cost":"10,9098","min_cost":10.0,"max_cost":9.0,"avgcost":7.75,"total_cost":93,"min_kwh":10.0,"max_kwh":9.0,"avgkwh":8.667,"total_kwh":104},{"hours":17,"timeStamp":"2019-06-01T14:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"5,597","cost":"5,0373","min_cost":0.0,"max_cost":5.0,"avgcost":2.167,"total_cost":26,"min_kwh":0.0,"max_kwh":5.0,"avgkwh":2.25,"total_kwh":27},{"hours":18,"timeStamp":"2019-06-01T15:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0,475","cost":"0,4275","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":19,"timeStamp":"2019-06-01T16:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":20,"timeStamp":"2019-06-01T17:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":21,"timeStamp":"2019-06-01T18:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":22,"timeStamp":"2019-06-01T19:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":23,"timeStamp":"2019-06-01T20:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0},{"hours":24,"timeStamp":"2019-06-01T21:00:00.000+00:00","meterid":5117,"meterName":"MeterB","kwh":"0","cost":"0","min_cost":0.0,"max_cost":0.0,"avgcost":0.0,"total_cost":0,"min_kwh":0.0,"max_kwh":0.0,"avgkwh":0.0,"total_kwh":0}]
	
	http://localhost:8080/api/meterdata/daily/MeterEnergyProduced/{id} HTTP METHOD GET
	[{"meter_id":5117,"meterName":"MeterB","datehour":"2019-05-31T22:00:00.000+00:00","min":0.0,"max":9.0,"avg":4.823,"total":1389},{"meter_id":4582,"meterName":"MeterG","datehour":"2022-10-03T19:00:00.000+00:00","min":1.0,"max":1.0,"avg":1.0,"total":1},{"meter_id":7746,"meterName":"MeterR","datehour":"2022-11-03T08:00:00.000+00:00","min":1.0,"max":1.0,"avg":1.0,"total":1}]
	
	http://localhost:8080/api/meterdata/daily/MeterCostProduced/{id} HTTP METHOD GET
	[{"meter_id":5117,"meterName":"MeterB","datehour":"2019-05-31T22:00:00.000+00:00","min":0.0,"max":9.0,"avg":5.354,"total":1542},{"meter_id":4582,"meterName":"MeterG","datehour":"2022-10-03T19:00:00.000+00:00","min":1.0,"max":1.0,"avg":1.0,"total":1},{"meter_id":7746,"meterName":"MeterR","datehour":"2022-11-03T08:00:00.000+00:00","min":1.0,"max":1.0,"avg":1.0,"total":1}]
