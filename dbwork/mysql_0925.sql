SELECT * FROM bit701.sawon;


insert into sawon values(null, '테스트',10,'여자','홍보부');


update sawon set name='김태현', score=20, buseo='교육부' where no=11;


create table student (
	num smallint auto_increment,
    name varchar(20),
    blood char(2),
    phone varchar(20),
    writeday datetime,
    constraint stu_pk_num primary key(num),
    constraint stu_ck_blood check (blood in('A','B','O',"AB"))
);