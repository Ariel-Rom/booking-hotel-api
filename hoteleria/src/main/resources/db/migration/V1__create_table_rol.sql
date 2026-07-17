create table role(
    id bigint not null auto_increment,
    nombre varchar(255) not null unique,
    primary key (id)
);

insert into role(nombre) values ('ROLE_ADMIN'), ('ROLE_CLIENTE')