create table student (
    no number(9) constraint student_pk_no primary key,
    name varchar2(20),
    mail varchar2(50) constraint student_uk_mail unique,
    hp varchar2(50),
    address varchar2(10) constraint student_ck_address check(address in('����','���','�λ�','����','����'))    
);

create SEQUENCE stu_seq1 start with 230910001 INCREMENT by 1;

------
drop SEQUENCE stu_seq1;
------


insert into student values(stu_seq1.nextval, '������', 'aaa@naver.com', '010-7706-0000', '���');
insert into student values(stu_seq1.nextval, '�ʰ���', '12121@naver.com', '010-0000-0000', '����');
insert into student values(stu_seq1.nextval, '��̶�', '212121@naver.com', '010-0000-1234', '����');
insert into student values(stu_seq1.nextval, 'ī�̻�', '21211@naver.com', '010-1234-0000', '�λ�');
insert into student values(stu_seq1.nextval, '�ǿ���', '13141@naver.com', '010-1111-1222', '����');


create table subject (
    code number(3) constraint subject_pk_code primary key,
    name varchar2(20),
    credit number(1)
);
create SEQUENCE sub_seq1 start with 001 INCREMENT by 1;

create table regist (
    
    no number(9),
    code number(3),
    Serial number(2) constraint regist_pk_no primary key

);
 
drop table regist;
 
 alter table regist add CONSTRAINT regist_fk_code foreign key(code) references subject(code);
 alter table regist add CONSTRAINT regist_fk_no foreign key(no) references student(no);

create SEQUENCE reg_seq1 start with 01 INCREMENT by 1;

insert into subject values(sub_seq1.nextval, 'java', 5);
insert into subject values(sub_seq1.nextval, 'javascript', 3);
insert into subject values(sub_seq1.nextval, 'spring', 9);
insert into subject values(sub_seq1.nextval, 'db', 3);


insert into regist values(230910001,001,reg_seq1.nextval);
--insert into regist values(230910001,002,reg_seq1.nextval);
--insert into regist values(230910001,003,reg_seq1.nextval);
--insert into regist values(230910001,004,reg_seq1.nextval);
--insert into regist values(230910010,002,reg_seq1.nextval);
insert into regist values(230910011,003,reg_seq1.nextval);
insert into regist values(230910010,001,reg_seq1.nextval);
------

select * from student;
select * from subject;
select * from regist;

commit;


select
    stu.no �й�, stu.name �̸�, sub.name �����, sub.credit ����
from 
    subject sub, regist reg, student stu
--    regist reg

where 
    stu.no=reg.no(+);


