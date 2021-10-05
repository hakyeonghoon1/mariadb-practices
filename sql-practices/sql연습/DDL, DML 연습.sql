drop table member;
create table member
(
	no			int(11)			not null	auto_increment,
    email		varchar(200)	not	null,
    password	varchar(64)		not	null,
    name		varchar(100)	not null,
    department	varchar(200),
    primary key(no)
);
show tables;
desc member;

alter table member add juminbunho char(13) not null after email;
alter table member drop juminbunho;
alter table member add join_date datetime not null;
alter table member change department dept varchar(100) not null;
alter table member add self_intro text;
-- insert
insert into member values (null,'skyhoon7@naver.com',password('1234'),'하경훈','개발팀',now(),null);

select * from member;

-- update
update member
set	email='skyhoon8@naver.com',
	password = password('5678')
where no = 1;

-- delete
delete 
from member
where no = 1;

-- transaction
select @@autocommit;

set autocommit=1;	-- 1 = 오토커밋

insert into member values (null,'skyhoon7@naver.com',password('1234'),'하경훈2','개발팀2',now(),null);
commit;
