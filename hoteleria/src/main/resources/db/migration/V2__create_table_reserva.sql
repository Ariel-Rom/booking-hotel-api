create table reserva(
    id bigint not null auto_increment,
    nombre_cliente varchar(100) not null,
    dia_ingreso DATETIME not null,
    dia_egreso DATETIME not null,
    cantidad_huespedes bigint not null,
    created_at DATETIME,
    updated_at DATETIME,
    user_id bigint not null,
    hotel_id bigint not null,
    primary key (id),

    constraint fk_user_id foreign key (user_id) references cliente(id)
);