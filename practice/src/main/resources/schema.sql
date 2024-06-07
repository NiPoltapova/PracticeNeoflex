
create table if not exists ResultOfCalculation
(
    id integer auto_increment,
    expression varchar(200) not null unique,
    result integer not null,
    CONSTRAINT idMemory PRIMARY KEY (id)
);