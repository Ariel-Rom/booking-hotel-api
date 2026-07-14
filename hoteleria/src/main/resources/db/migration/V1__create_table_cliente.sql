create table cliente(
    id bigint not null auto_increment,
    nombre varchar(20) not null,
    apellido varchar(30) unique not null,
    dni varchar(20) not null unique,
    activo boolean,
    created_at DATETIME,
    updated_at DATETIME,
    primary key(id)
);