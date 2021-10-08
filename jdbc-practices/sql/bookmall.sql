desc member;
desc category;
desc book;
desc ord_book;
desc cart;
desc `order`;

-- insert
insert into member values(null, '홍길동', '010-0000-0000', 'abcd@gmail.com','1234');
insert into category values(null, '수필');
insert into book values (null, '달러구트 꿈 백화점2',13800,1);
insert into cart values (1,2,30);
-- insert into `order` values(null, 'a0001', );
insert into ord_book values ();

select * from cart;
select * from ord_book;

-- select
select no, name, tel, email, password from member;
select no, name from category;
select no, name, price, category_no from book;
select book_no, member_no, qty from cart;
select no, ord_no, pay, addr, member_no from `order`;
select book_no, order_no, qty, price from ord_book;
select * from ord_book;


-- update
update member
set name = ifnull('수정',name),
	tel = ifnull(null, tel),
    email = ifnull(null, email),
    password = ifnull(null, password)
where no = 8;

update book
set name = ifnull('333333', name),
	price = ifnull(null, price),
    category_no = ifnull(null,category_no)
where no = 12;

    

-- delete 
delete from member;
delete from category;
delete from book;
delete from cart;
delete from ord_book;
delete from `order`;

delete from member where no = 7;

--
ALTER TABLE member AUTO_INCREMENT=1;
ALTER TABLE category AUTO_INCREMENT=1;
ALTER TABLE book AUTO_INCREMENT=1;
ALTER TABLE `order` AUTO_INCREMENT=1;