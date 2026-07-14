create table cliente(
    id bigint not null auto_increment,
    nombre varchar(20) not null,
    apellido varchar(30) unique not null,
    dni varchar(20) not null unique,
    created_at date not null,
    primary key(id)
);