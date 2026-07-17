create table usuario(
    id bigint not null auto_increment,
    email varchar(100) not null unique,
    password varchar(255) not null,
    activo boolean not null ,
    created_at datetime,
    updated_at datetime,
    rol_id bigint not null,
    primary key (id),

    constraint fk_rol_id foreign key (rol_id) references role(id)
);