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
-- delete 
delete from member;
delete from category;
delete from book;
delete from cart;

ALTER TABLE member AUTO_INCREMENT=1;
ALTER TABLE category AUTO_INCREMENT=1;
ALTER TABLE book AUTO_INCREMENT=1;