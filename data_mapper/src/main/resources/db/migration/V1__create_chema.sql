create table client
(
    id   bigserial primary key,
    name varchar(60) not null,
    age  integer     not null
)