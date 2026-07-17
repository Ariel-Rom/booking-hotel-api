create table cliente(
    id bigint not null auto_increment,
    nombre varchar(20) not null,
    apellido varchar(30) not null,
    dni varchar(20) not null unique,
    activo boolean,
    created_at datetime,
    updated_at datetime,
    usuario_id bigint not null unique,
    primary key(id),

    constraint fk_usuario_id foreign key (usuario_id) references usuario(id)
);