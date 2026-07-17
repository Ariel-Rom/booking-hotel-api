create table tipo_habitacion (
    id bigint not null auto_increment,
    tipo_habitacion varchar(100) not null ,
    precio_base decimal(10,2) not null ,
    capacidad bigint not null ,
    primary key (id)

);