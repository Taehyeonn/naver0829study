--PL-SQL�̶� ?

-- SQL�� ������ ����Ҹ� ���ؼ� ���α׷����� ���� PL-SQL�̶�� �Ѵ�

-- ����1

DECLARE
    --���� �����ϴ� ����
    v_no number(4,1); -- 4�ڸ��� �Ҽ������� 1�ڸ� ���� �ִ� ���� ����
    
BEGIN
    --sql �����̳� pl-sql ������ �ڵ��ϴ� ����( =�񱳿�����, := ���Կ�����)
    
    v_no := 12.7;
    DBMS_output.put_line(v_no); -- ���
   
end;
/

--����-> DBMS��� -> +������ ���̺� ����

-----------------------
--����2
DECLARE
    vname varchar2(20);
    vban varchar2(20);
BEGIN
    select 
        name, ban
        into vname, vban
    from student 
    where num=1;
    
    DBMS_output.put_line(vname||'���� '||vban||'�Դϴ�');
end;
/

-- person�� food ���̺��� �����Ͽ� person_num�� 9�� �礿���� �̸�, �ֹ��� �޴� ���� ���

DECLARE
    vname varchar2(20);
    vmenu varchar2(20);
    vprice number(7);
    
BEGIN
select person_name, vmenu, vprice
    into vname, vmenu, vprice
from person, food
where food.food_num=person.food_num and person.person_num=12;
    
    DBMS_output.put_line(vname);
    DBMS_output.put_line(vmenu);
    DBMS_output.put_line(vprice);
end;
/


---------------------------------
--����4
--��ǰ���� ������ ������ �� 
DECLARE
    vsangpum varchar2(20) := 'üũ����';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
BEGIN
select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999'))
into vprice, vcolor, vprice2
from shop 
where sang_name=vsangpum;
    DBMS_output.put_line('��ǰ�� '||vsangpum);
    DBMS_output.put_line('��  �� '||vcolor);
    DBMS_output.put_line('��  �� '||vprice);
    DBMS_output.put_line('��  �� '||vprice2);
end;
/

/*
if ���ǽ� then
    ����1;
else
    ����2;
end if;

���� if��
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    . . .
end if;
*/



----------------------------
--���� 5
--�⵵�� �´� �� ���ϱ�

--Ű����� �⵵�� �ް��� �� ���
accept year prompt '�¾ �⵵�� �Է��ϼ���';

DECLARE
 --   v_year number(4) := 2023;
    v_year number(4) := '&year';
    v_mod number(2) := mod(v_year,12);
    v_ddi varchar2(10); --�� ������ ����
BEGIN
    if v_mod=0 then v_ddi:='������';
    elsif v_mod=1 then v_ddi:='��';
    elsif v_mod=2 then v_ddi:='��';
    elsif v_mod=3 then v_ddi:='����';
    elsif v_mod=4 then v_ddi:='��';
    elsif v_mod=5 then v_ddi:='��';
    elsif v_mod=6 then v_ddi:='ȣ����';
    elsif v_mod=7 then v_ddi:='�䳢';
    elsif v_mod=8 then v_ddi:='��';
    elsif v_mod=9 then v_ddi:='��';
    elsif v_mod=10 then v_ddi:='��';
    elsif v_mod=11 then v_ddi:='��';
    end if;
        DBMS_output.put_line(v_year||'����� '||v_ddi||'�� �Դϴ�');
end;
/


-------
--db�÷��� Ÿ���� �������� ��� type

accept iname prompt 'name?';
DECLARE
    v_name student.name%type :='&iname';
    v_height student.height%type;
    v_java student.java%type;
    v_spring student.spring%type;
BEGIN
    select height, java, spring
    into v_height, v_java, v_spring
    from student 
    where name=v_name;
    
        DBMS_output.put_line('�л���:'||v_name);
        DBMS_output.put_line('Ű:'||v_height);
        DBMS_output.put_line('�ڹ�����:'||v_java);
        DBMS_output.put_line('����������:'||v_spring);
        DBMS_output.put_line('����:'||(v_java+v_spring));
        
end;
/



-----

/*

�ݺ��� : loop

loop
    �����;
    exit when ����;
end loop;

*/

--------------------
--1~10 ���
DECLARE
    v_no number(2) := 0;

BEGIN
    loop
        v_no := v_no+1;
        DBMS_output.put_line('No='||v_no);
        exit when v_no=10; --10�϶� Ż��
    end loop;
end;
/


-------
-- ���� �Է��ϸ� �ش� ���� ����ϼ���

accept dan prompt '�ܸ� �Է��ϼ��� (1~9)';
DECLARE
    v_dan number(2) := '&dan';
    v_su number(2) := 0;
BEGIN
    loop
    v_su := v_su+1;
     DBMS_output.put_line(v_dan||'x'||v_su||'='||(v_dan*v_su));
    exit when v_su=9;
    end loop;
end;
/


----------------

--����9 exceptionó��(����4 ����)
--��ǰ���� ������ ������ �� 
accept sangpum prompt '��ǰ���� �Է��ϼ���?';
DECLARE
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
BEGIN
select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999'))
into vprice, vcolor, vprice2
from shop 
where sang_name=vsangpum;
    DBMS_output.put_line('��ǰ�� '||vsangpum);
    DBMS_output.put_line('��  �� '||vcolor);
    DBMS_output.put_line('��  �� '||vprice);
    DBMS_output.put_line('��  �� '||vprice2);
    
    
    --����� ���ų� 2���̻��̸� ���� �߻�.
    --����Ŭ���� ����ó�� �ϴ� ���
    EXCEPTION
        when no_data_found then
            DBMS_output.put_line(vsangpum||'��ǰ�� db�� �����ϴ�');
        when too_many_rows then
            DBMS_output.put_line(vsangpum||'��ǰ�� db�� 2�� �̻� �����մϴ�');
        when OTHERS then
            DBMS_output.put_line(vsangpum||'��ǰ�� ���� ���� �߻�');
    
    
end;
/


/*

�ݺ���
for ���� in [reverse]���۰�.. ������ loop
    �����;
end loop;


*/

-----����10 for������ ����
accept dan prompt '�ܸ� �Է��ϼ��� (1~9)';
DECLARE
    v_dan number(2) := '&dan';
    v_su number(2) := 0;
BEGIN
    DBMS_output.put_line(v_dan||'��');
    for v_su in 1..9 loop
      DBMS_output.put_line(v_dan||'x'||v_su||'='||(v_dan*v_su));
    end loop;
end;
/


---���ڵ� ������ ������ ��������
DECLARE 
    v_num student.num%type :=1;
    v_stu angel.student%rowtype; --���ڵ� ������ �о�� ���
BEGIN
    select * 
    into v_stu
    from student
    where num=v_num;
        DBMS_output.put_line('�̸�: '||v_stu.name);
        DBMS_output.put_line('Ű: '||v_stu.height);
        DBMS_output.put_line('�ڹ�: '||v_stu.java);
        DBMS_output.put_line('������: '||v_stu.spring);
        DBMS_output.put_line('��: '||v_stu.ban);
end;
/

------DB�� ���� �����͸� ��ȸ�� ���
/*
    Cursor : sql���� �����Ҷ����� ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ���� 
    Ư���� �޸� ������ ����ϴµ� �� ������ �����ϴ� ���� Ŀ����

    select ������ ���� ������ ��ȸ�� ����ϴ� ��ü

    Ŀ�� �Ӽ�
    sql%rowcount : ����� ���� ��ȯ
    sql%found : ���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �ذ�� true
    sql%notfound : ������� ���� ���
    sql%ispopen : �׻� false(�׻� close�� �ϱ� ������ �׻� false)
*/



----------���� 12
DECLARE
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype; --������� �������� ?
BEGIN
    select *
    into v_shop
    from shop
    where sang_no=v_sno;

        DBMS_output.put_line('��ǰ��:'||v_shop.sang_name);
        DBMS_output.put_line('��ȸ�� ���హ��:'||sql%rowcount);
    --student�� java ���� �����ϱ�
    update student 
    set java=99;
    DBMS_output.put_line('���� ���హ��:'||sql%rowcount);
end;
/


---���� ���ڵ� ��ȸ
--���� 13
DECLARE
    Cursor c
    is 
    select *
    from shop;
BEGIN
        DBMS_output.put_line('��ǰ��ȣ  ��ǰ�� ����  ����');
        DBMS_output.put_line('-+-------------------------------');
        for s in c loop
            exit when c%notfound; -- ���̻� �����Ͱ� ������ ����������
            DBMS_output.put_line(s.sang_no||'   '||s.sang_name||'   '||s.sang_color||'  '||s.sang_price);
        end loop;
end;
/

-----���� 14
--��ǰ��, ����, ������ �Է��ϸ� shop db�� �߰��ϱ�
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
DECLARE
    v_sang shop.sang_name%type := '&isang';
    v_color shop.sang_color%type := '&icolor';
    v_price shop.sang_price%type := '&iprice';
    
BEGIN
    insert into shop values (seq_shop.nextval, v_sang, v_price, v_color);
    commit;
        DBMS_output.put_line('��ǰ������ �߰��߽��ϴ�');
end;
/




-----------
--���� : food ���̺�
/*
    fname, fprice, no �Է��� �޾Ƽ�
    no�� 1�̸� fname, fprice�� ������ �߰��� �ϰ� 
    no�� 2�� food ��ü ������ ��� (if��)
*/


accept fname prompt 'name?';
accept fprice prompt 'price?';
accept no prompt 'no?';
DECLARE
    v_name food.fname%type := '&fname';
    v_price food.fprice%type := '&fprice';
    v_no number(1) := '&no';
    
    Cursor f
    is
    select *
    from food;
BEGIN
    if v_no=1 then
        insert into food values (seq_food.nextval, v_name, v_price);
        DBMS_output.put_line('��ǰ������ �߰��߽��ϴ�');
    elsif v_no=2 then
        DBMS_output.put_line(��ȣ||'   '||���ĸ�||'   '||����);
        for v in f loop
            exit when f%notfound; -- ���̻� �����Ͱ� ������ ����������
             DBMS_output.put_line(v.food_num||'   '||v.fname||'   '||v.fprice);
        end loop;
    end if;
end;
/


/*
if ���ǽ� then
    ����1;
else
    ����2;
end if;

���� if��
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    . . .
end if;
*/
