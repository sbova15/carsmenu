create database if not exists cars;
use cars;
drop table if exists cars;


create table cars(
id int(20) not null auto_increment,
make varchar(20) not null,
model varchar(20),
color varchar(20),
year year,
price int(7),
primary key (id)
);

insert into cars
values(1,'Toyota','Camry','Blue','2022', 25000);

insert into cars
Values(2,'Honda','Civic','Red','2010',8000);

insert into cars (make, model, color, year, price)
values('Kia','Soul','Yellow','2015', 10000);
