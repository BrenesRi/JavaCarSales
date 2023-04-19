DROP DATABASE IF EXISTS SSA;
CREATE DATABASE SSA;

USE SSA;

create table Usuario (
  cedula varchar(10) not null,
  clave varchar(10),
  tipo integer,
  Primary key(cedula)
);

create table Cliente (
  cedula varchar(10) not null,
  nombre varchar(30),
  telefono varchar(15),
  correo varchar(20),
  tarjeta varchar(20),
  usuario varchar(10),
  Primary key(cedula)
);

create table Poliza (
  numero int auto_increment PRIMARY KEY,
  placa varchar(10) not null,
  valor double,
  auto varchar(30),
  fecha date,
  cliente varchar(10),
  Unique key(placa)
  );

create table Marca (
  id integer auto_increment not null,
  nombre varchar(30) not null,
  Primary key(id)
  );

create table Modelo (
  id integer auto_increment not null,
  descripcion varchar(30) not null,
  marca integer not null,
  Primary Key(id)
);

alter table Cliente add foreign key (usuario) references Usuario(cedula);
alter table Poliza add foreign key (cliente) references Cliente(cedula);
alter table Modelo add foreign key (marca) references Marca(id);

insert into Usuario (cedula,clave,tipo) 
	values ("111","111",1);

insert into Usuario (cedula,clave,tipo) 
	values ("222","222",1);

insert into Usuario (cedula,clave,tipo) 
	values ("333","333",2);

insert into Cliente (cedula,nombre,telefono,correo,tarjeta,usuario) 
	values ("111","J.Perez","57892345","perez@gmail.com","11112345",'111');

insert into Cliente (cedula,nombre,telefono,correo,tarjeta,usuario) 
	values ("222","B.Banner","84567834","banner@gmail.com","22212345",'222');

insert into Cliente (cedula,nombre,telefono,correo,tarjeta,usuario) 
	values ("333","A.Chacon","98674561","chacon@gmail.com","33312345",'333');

insert into Poliza (placa,valor,auto,fecha,cliente) 
	values ("1-111-11",100,"Toyota - Corolla","2008-7-04","111");

Insert Into Marca (nombre)
        values ("Toyota");

Insert Into Marca (nombre)
        values ("Nissan");

Insert Into Modelo (descripcion, marca) 
        values ("Corolla", 1);

Insert Into Modelo (descripcion, marca) 
        values ("Sentra", 2);

Insert Into Modelo (descripcion, marca) 
        values ("Hilux", 1);

Insert Into Modelo (descripcion, marca) 
        values ("Skyline", 2);


