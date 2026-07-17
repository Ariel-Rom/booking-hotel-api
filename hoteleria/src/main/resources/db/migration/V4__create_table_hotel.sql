create table hotel(
    id bigint not null auto_increment,
    hotel_api_id bigint not null unique ,
    nombre varchar(100) not null,
    ciudad varchar(100) not null,
    direccion varchar(100) not null,
    calificacion bigint,
    comodidades varchar(100),

    primary key (id)
);