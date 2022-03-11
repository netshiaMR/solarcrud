-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
-- Netshia Rendani
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2022 at 12:03 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11
-- Question 2

-- 1. Write a query to Join the meter table to meter_data table.
SELECT  `meter`.`meter_id`, 
		`meter`.`meter_name`,
		`mtd`.`t_stamp`, 
		`mtd`.`impwh`, 
		`mtd`.`expwh`,
		`mtd`.`q1varh`, 
		`mtd`.`q2varh`,
		`mtd`.`q3varh`, 
		`mtd`.`q4varh`, 
		`mtd`.`vah`, 
		`mtd`.`ptot`,
		`mtd`.`qtot`, 
		`mtd`.`stot`, 
		`mtd`.`difference_imp_kwh`, 
		`mtd`.`difference_exp_kwh`, 
		`mtd`.`expkvarh`, 
		`mtd`.`impkvarh`, 
		`mtd`.`derived_data`, 
		`mtd`.`epoch_tstamp`, 
		`mtd`.`kwh`, 
		`mtd`.`rate_per_kwh`, 
		`mtd`.`cost`
	FROM `meter`
	LEFT OUTER JOIN `meter_data` `mtd`
	ON `meter`.`meter_id` = `mtd`.`meter_id`;
	
-- 2. Write a query that will per meter, per day calculate the sum of kwh and max kwh for the solar. 
-- Query must display the name of each meter
-- 
SELECT meter_id, meter_name , t_stamp
     - INTERVAL EXTRACT(MINUTE FROM t_stamp) MINUTE
     - INTERVAL EXTRACT(SECOND FROM t_stamp) SECOND AS date_hour,
      SUM(kwh) as sum_of_daily_kwh, 
      MAX(kwh) as max_kwh 
	FROM  meter_data_view
   GROUP BY meter_name


--3 . Write a query that gives an hourly summary of the meter_data table for each meter containing at least the 
--      fields (t_stamp, meter_id, kwh, cost
SELECT 	hour(meter_data.t_stamp) as hours, 
		meter_data.t_stamp,
        meter_data.meter_id, 
        meter_data.kwh,
		meter_data.cost,
        AVG(meter_data.kwh) as avgkwh, 
        AVG(meter_data.cost ) as avgcost
  FROM meter_data_view  meter_data
 where meter_data.meter_id 
 		in  (SELECT 
             meter.meter_id 
             FROM meter)
 GROUP BY hour(meter_data.t_stamp);


