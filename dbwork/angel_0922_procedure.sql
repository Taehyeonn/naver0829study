/*
프로시져 (procedure)
= 자바의 메서드 자바스크립트의 펑션

형식

create : 새로 생성, 기존 프로시져가 있을 경우 오류발생
create or replace : 새로 생성, 근데 기존 프로시져가 있으면 덮어쓴다

create [or replace] procedure 프로시져명 
    [파라미터 모드 데이터타입, ....]
is
    변수선언
begin
    코드;
end;

호출 : exec 프로시져명
         exec 프로시져명(값..)

*/

--예제 1

--초간단 프로시저 생성해보기
create or replace PROCEDURE mytest 
is 
begin
    dbms_output.put_line('첫 프로시저 생성');
end;
/

--호출
exec mytest;


/*
cmd에서의 호출

SQL> exec mytest;

PL/SQL 처리가 정상적으로 완료되었습니다.

SQL> set serveroutput on
SQL> exec mytest;
첫 프로시저 생성

PL/SQL 처리가 정상적으로 완료되었습니다.
*/

--예제 2: 숫자를 인자를 보내면 구구단 출력

create or replace PROCEDURE gugu(dan number)
is
begin
    if dan<2 or dan>9 then
            dbms_output.put_line('잘못된 숫자입니다. 2-9사이값 요구');
        else
            dbms_output.put_line(' **'||dan||'단 **');
            for a in 1..9 loop
                dbms_output.put_line(dan||'x'||a||'='||dan*a);
            end loop;
        end if;
end;
/
--실행
exec gugu(11);
exec gugu(3);


--shop에 데이터 추가하기- 연습용
insert into shop values (seq_shop.nextval, '레이스블라우스',23000,'white');

--shop의 sang_color 타입 길이 변경
alter table shop modify sang_color varchar2(30);

--예제3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기
create or replace PROCEDURE sangpum(sang varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%'||sang||'%';
    
    --검색된 상품 갯수를 구할 변수
    v_cnt number(2);
begin
select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
if v_cnt=0 then
    dbms_output.put_line(sang||'목록에 없습니다');
    else
    dbms_output.put_line(sang||'상품 조회하기');
    dbms_output.put_line('총 '||v_cnt||'개 조회');
    dbms_output.put_line('상품번호  상품명 가격  색상');
    dbms_output.put_line('----------------------------------');
    for s in s1 loop
        dbms_output.put_line(s.sang_no||'    '||s.sang_name||'   '||
        s.sang_price||'   '||s.sang_color);
        exit when s1%notfound;
    end loop;
    end if;
end;
/
exec sangpum('조끼');
exec sangpum('청바지');
exec sangpum('한복');

--예제 4
/*
exec addupdate('레이스조끼',45000,'black'); --해당상품이 없으면 추가
                                                --있으면 색상 수정

*/
create or replace PROCEDURE addupdate(sang varchar2, price number, color varchar2)
is
    Cursor s2
    is
    select * from shop where sang_name like '%'||sang||'%';
    
    --검색된 상품 갯수를 구할 변수
    v_cnt2 number(2);
begin
select count(*) into v_cnt2 from shop where sang_name like '%'||sang||'%';
if v_cnt2=0 then
    dbms_output.put_line(sang||'목록에 없습니다');
    insert into shop values (seq_shop.nextval, sang,price,color);
    dbms_output.put_line(sang||'상품을 추가했습    니다.');
    else
    update shop set sang_color=color,sang_price=price where sang_name=sang; 
    dbms_output.put_line(sang||'상품의 색상을 변경하였습니다');
    end if;
end;
/
exec addupdate('조끼',34000,'purple');

exec addupdate('양복정장',150000,'blue');

