Create database profile;
use profile;

CREATE TABLE Customer_data (
ID varchar(8) not null  primary key,
LastName varchar(15) not null,
FirstName varchar(15) not null,
MiddleName varchar(15) not null,
Address varchar(30) not null,
Sex varchar(20) not null,
CivilStatus varchar(15)

);








CREATE TABLE student (
ID varchar(8) not null  primary key,
LastName varchar(20) null,
FirstName varchar(20) null,
MiddleName varchar(20) null,
StudentYear varchar(10) null,
Section varchar(7) null,
Course varchar(20) null,
ImageName varChar(255) null,
Image longblob null,
About Text null,
Active varchar(50) null,
CurrentDate varchar(50) null,
Enrolled varchar(20) null,
Request varchar(20)null,
Username varchar(255),
StudentPass varchar(255)

);









