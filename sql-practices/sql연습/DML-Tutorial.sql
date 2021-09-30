-- Basic Query

create table pet
(
	name	varchar(20),
    owner	varchar(20),
    species	varchar(20),
    gender	char(1),
    birth	date,
    death	date
);

desc pet;