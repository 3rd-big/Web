create table member2(
    id varchar2(10) primary key,
    pwd varchar2(20),
    name varchar2(10),
    email varchar2(40)
    );
    
drop table member2;
drop table board;
    
insert into member(id, password, name, address)
values('java', '1234', '손연재', '수서');

insert into member(id, password, name, address)
values('jdbc', 'abcd', '백박사', '판교');

select * from member;

select id, password, name, address from member;

commit;
-------------------------------------------------------------


create table p_product(
    pno number primary key,
    pname varchar2(20) not null,
    pmaker varchar2(20) not null,
    pprice varchar2(20) not null,
    pdetail varchar2(2000) 
);

create sequence s_pno
nocache
start with 1
increment by 1;


create table p_product(
    pno number primary key,
    pname varchar2(20) not null,
    pmaker varchar2(20) not null,
    pprice varchar2(20) not null,
    pdetail varchar2(2000) 
);

create sequence s_pno
nocache
start with 1
increment by 1;

-------------------------------------------------------------
create table board(
num number primary key, 
writer varchar2(20) references member2(id) on delete cascade, 
w_date date, 
title varchar2(50) not null, 
content varchar2(500)
);

create sequence seq_board; 

------------------------------------------------------------- ImgBoard 

create table shop_product(
    num number primary key,
    name varchar2(500) not null,
    quantity number not null,
    price number not null,
    img varchar2(500),
    content varchar2(500)
);

create sequence seq_shop_product;

------------------------------------------------------------- ImgRep2

create table img(
    num number primary key,
    writer varchar2(20),
    title varchar2(50),
    path varchar2(500),
    u_date date
);

create sequence seq_img;

create table reps(
    num number primary key,
    writer varchar2(20),
    content varchar2(20),
    img_num number references img(num) on delete cascade
);

create sequence seq_reps;

select * from img;

------------------------------------------------------------- shop
create table shop_member(
    id varchar2(20) primary key,
    pwd varchar2(20),
    name varchar2(20),
    email varchar2(20),
    addr varchar2(20),
    type number
);