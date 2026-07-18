create table pago(
    id bigint not null auto_increment,
    total_a_pagar decimal(10,2) not null ,
    metodo_pago varchar(100),
    estado varchar(100),
    fecha_pago DATETIME,
    reserva_id bigint not null ,
    primary key (id),

    constraint fk_reserva_id foreign key (reserva_id) references reserva(id)
);