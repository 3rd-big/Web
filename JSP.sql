create table member2(
    id varchar2(10) primary key,
    pwd varchar2(20),
    name varchar2(10),
    email varchar2(40)
    );
    
drop table member2;
    
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




create table board(
    num number primary key,
    writer varchar2(20) references member(id) on delete cascade,
    w_date date,
    title varchar2(50) not null,
    content varchar2(500)
);

create sequence seq_board;


