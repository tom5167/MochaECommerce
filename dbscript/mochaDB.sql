DROP DATABASE mochaDB; 
CREATE DATABASE mochaDB;
USE mochaDB;

DROP TABLE IF EXISTS Shoes;
CREATE TABLE Shoes (
itemId int NOT NULL auto_increment primary key,
itemName varchar(50) NOT NULL,
category varchar(10) NOT NULL,
shoesize varchar(5) NOT NULL,
quantity int NOT NULL,
price decimal(7,2) NOT NULL,
content varchar(100) NOT NULL
);

CREATE TABLE Cart (
itemId int NOT NULL auto_increment primary key,
itemName varchar(50) NOT NULL,
category varchar(10) NOT NULL,
shoesize varchar(5) NOT NULL,
quantity int NOT NULL,
price decimal(7,2) NOT NULL
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
orderId int NOT NULL auto_increment primary key,
itemId int NOT NULL,
customerId int NOT NULL,
shoesize varchar(5) NOT NULL,
quantity int NOT NULL,
price decimal(7,2) NOT NULL,
orderStatus varchar(60) NOT NULL,
orderdate date NOT NULL
); 

CREATE TABLE Customers ( 
customerNo int NOT NULL auto_increment primary key,
customerId varchar(60) NOT NULL,
username varchar(30) NOT NULL,
userpwd	varchar(30) NOT NULL,
firstname varchar(30) NOT NULL,
lastname varchar(30) NOT NULL,
address varchar(100) NULL,
city varchar(30) NULL,
postalCode varchar(10) NULL
);

CREATE TABLE CSR (
csrNo int NOT NULL auto_increment primary key,
employeeId	varchar(60) NOT NULL,
username varchar(30) NOT NULL,
userpwd	varchar(30) NOT NULL,
firstname varchar(30) NOT NULL,
lastname varchar(30) NOT NULL 
);