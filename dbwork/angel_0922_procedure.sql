/*
���ν��� (procedure)
= �ڹ��� �޼��� �ڹٽ�ũ��Ʈ�� ���

����

create : ���� ����, ���� ���ν����� ���� ��� �����߻�
create or replace : ���� ����, �ٵ� ���� ���ν����� ������ �����

create [or replace] procedure ���ν����� 
    [�Ķ���� ��� ������Ÿ��, ....]
is
    ��������
begin
    �ڵ�;
end;

ȣ�� : exec ���ν�����
         exec ���ν�����(��..)

*/

--���� 1

--�ʰ��� ���ν��� �����غ���
create or replace PROCEDURE mytest 
is 
begin
    dbms_output.put_line('ù ���ν��� ����');
end;
/

--ȣ��
exec mytest;


/*
cmd������ ȣ��

SQL> exec mytest;

PL/SQL ó���� ���������� �Ϸ�Ǿ����ϴ�.

SQL> set serveroutput on
SQL> exec mytest;
ù ���ν��� ����

PL/SQL ó���� ���������� �Ϸ�Ǿ����ϴ�.
*/

--���� 2: ���ڸ� ���ڸ� ������ ������ ���

create or replace PROCEDURE gugu(dan number)
is
begin
    if dan<2 or dan>9 then
            dbms_output.put_line('�߸��� �����Դϴ�. 2-9���̰� �䱸');
        else
            dbms_output.put_line(' **'||dan||'�� **');
            for a in 1..9 loop
                dbms_output.put_line(dan||'x'||a||'='||dan*a);
            end loop;
        end if;
end;
/
--����
exec gugu(11);
exec gugu(3);


--shop�� ������ �߰��ϱ�- ������
insert into shop values (seq_shop.nextval, '���̽����콺',23000,'white');

--shop�� sang_color Ÿ�� ���� ����
alter table shop modify sang_color varchar2(30);

--����3 : ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ�� ����ϱ�
create or replace PROCEDURE sangpum(sang varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%'||sang||'%';
    
    --�˻��� ��ǰ ������ ���� ����
    v_cnt number(2);
begin
select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
if v_cnt=0 then
    dbms_output.put_line(sang||'��Ͽ� �����ϴ�');
    else
    dbms_output.put_line(sang||'��ǰ ��ȸ�ϱ�');
    dbms_output.put_line('�� '||v_cnt||'�� ��ȸ');
    dbms_output.put_line('��ǰ��ȣ  ��ǰ�� ����  ����');
    dbms_output.put_line('----------------------------------');
    for s in s1 loop
        dbms_output.put_line(s.sang_no||'    '||s.sang_name||'   '||
        s.sang_price||'   '||s.sang_color);
        exit when s1%notfound;
    end loop;
    end if;
end;
/
exec sangpum('����');
exec sangpum('û����');
exec sangpum('�Ѻ�');

--���� 4
/*
exec addupdate('���̽�����',45000,'black'); --�ش��ǰ�� ������ �߰�
                                                --������ ���� ����

*/
create or replace PROCEDURE addupdate(sang varchar2, price number, color varchar2)
is
    Cursor s2
    is
    select * from shop where sang_name like '%'||sang||'%';
    
    --�˻��� ��ǰ ������ ���� ����
    v_cnt2 number(2);
begin
select count(*) into v_cnt2 from shop where sang_name like '%'||sang||'%';
if v_cnt2=0 then
    dbms_output.put_line(sang||'��Ͽ� �����ϴ�');
    insert into shop values (seq_shop.nextval, sang,price,color);
    dbms_output.put_line(sang||'��ǰ�� �߰��߽�    �ϴ�.');
    else
    update shop set sang_color=color,sang_price=price where sang_name=sang; 
    dbms_output.put_line(sang||'��ǰ�� ������ �����Ͽ����ϴ�');
    end if;
end;
/
exec addupdate('����',34000,'purple');

exec addupdate('�纹����',150000,'blue');

