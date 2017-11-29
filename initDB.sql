drop database contrader;
create database contrader;

create table contrader.users(
	idUsers int(20) NOT NULL auto_increment,
	username varchar(50),
    password varchar(50),
    firstname varchar(50),
    lastname varchar(50),
    dateofBirth varchar(20),
    cf varchar(50),
    businessname varchar(50),
    vat varchar(50),
    municipality varchar(50),
    postecode varchar(20),
    city varchar(20),
    address varchar(20),
    telephone varchar(20),
    role varchar(20),
    primary key (idUsers)
);

create table contrader.gomme(
	idGomme int(20) NOT NULL auto_increment,
    model varchar(50),
    manufacturer varchar(50),
    price float,
    width float,
    height float,
    diameter float,
    weight float,
    speed varchar(50),
    season varchar(20),
    typevehicle varchar(20),
    primary key(idGomme)
);

create table contrader.vehicle(
	idVehicle int(20) NOT NULL auto_increment,
	brand varchar(50),
    model varchar(50),
    fuel varchar(50),
    version varchar(50),
    capacity varchar(50),
    primary key (idVehicle)

);

create table contrader.compatibility(
	idVehicle int(20),
	idGomme int(20),
    foreign key (idVehicle) references contrader.vehicle(idVehicle),
    foreign key (idGomme) references contrader.gomme(idGomme)
);

insert into contrader.users (username, password, role) values ('pippo', 'paperino','admin');
insert into contrader.users (username, password, role) values ('ciccio', 'bello','user');
insert into contrader.gomme (model, manufacturer, price, typevehicle) values ('Trelleborg-B50', 'Trelleborg', 321.13, 'moto');
insert into contrader.gomme (model, manufacturer, price, typevehicle) values ('Trelleborg-B50', 'Trelleborg', 321.13, 'moto');
insert into contrader.gomme (model, manufacturer, price, typevehicle) values ('SuperG-876 ', 'Super Gomme', 213.176,'auto');


