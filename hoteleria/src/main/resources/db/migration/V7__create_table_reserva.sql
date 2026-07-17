create table reserva(
    id bigint not null auto_increment,
    dia_ingreso date not null,
    dia_egreso date not null,
    cantidad_huespedes bigint not null,
    activo boolean,
    created_at datetime,
    updated_at datetime,
    cliente_id bigint not null ,
    hotel_id bigint not null ,
    habitacion_id bigint not null ,
    estado varchar(50) not null ,
    primary key (id),

    constraint fk_user_id foreign key (cliente_id) references cliente(id),
    constraint fk_hotel_id foreign key (hotel_id) references hotel(id),
    constraint fk_habitacion_id foreign key (habitacion_id) references habitacion(id)
);