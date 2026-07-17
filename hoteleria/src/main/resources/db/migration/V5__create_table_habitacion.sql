create table habitacion(
    id bigint not null auto_increment ,
    numero bigint unique not null ,
    tipo_habitacion_id bigint ,
    hotel_id bigint ,
    primary key (id),

    constraint fk_hotel_id foreign key (hotel_id) references hotel(id),
    constraint fk_tipo_habitacion_id foreign key (tipo_habitacion_id) references tipo_habitacion(id)
)