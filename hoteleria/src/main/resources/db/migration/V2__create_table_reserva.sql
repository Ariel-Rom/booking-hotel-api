create table reserva(
    id bigint not null auto_increment,
    dia_ingreso date not null,
    dia_egreso date not null,
    cantidad_huespedes bigint not null,
    activo boolean,
    created_at DATETIME,
    updated_at DATETIME,
    user_id bigint ,
    hotel_id bigint ,
    primary key (id),

    constraint fk_user_id foreign key (user_id) references cliente(id)
);