--PL-SQL이란 ?

-- SQL언어에 절차적 언어요소를 축해서 프로그래밍한 것을 PL-SQL이라고 한다

-- 예제1

DECLARE
    --변수 선언하는 영역
    v_no number(4,1); -- 4자리에 소숫점이하 1자리 값을 넣는 변수 선언
    
BEGIN
    --sql 구문이나 pl-sql 문으로 코딩하는 영역( =비교연산자, := 대입연산자)
    
    v_no := 12.7;
    DBMS_output.put_line(v_no); -- 출력
   
end;
/

--보기-> DBMS출력 -> +누르고 테이블 선택

-----------------------
--예제2
DECLARE
    vname varchar2(20);
    vban varchar2(20);
BEGIN
    select 
        name, ban
        into vname, vban
    from student 
    where num=1;
    
    DBMS_output.put_line(vname||'님은 '||vban||'입니다');
end;
/

-- person과 food 테이블을 조인하여 person_num이 9인 사ㅏㅁ의 이름, 주문한 메뉴 가격 출력

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
--예제4
--상품명을 변수로 지정한 후 
DECLARE
    vsangpum varchar2(20) := '체크자켓';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
BEGIN
select sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999'))
into vprice, vcolor, vprice2
from shop 
where sang_name=vsangpum;
    DBMS_output.put_line('상품명 '||vsangpum);
    DBMS_output.put_line('색  상 '||vcolor);
    DBMS_output.put_line('단  가 '||vprice);
    DBMS_output.put_line('단  가 '||vprice2);
end;
/

/*
if 조건식 then
    문장1;
else
    문장2;
end if;

다중 if문
if 조건식1 then
    문장1;
elsif 조건2 then
    문장2;
    . . .
end if;
*/



----------------------------
--예제 5
--년도에 맞는 띠 구하기

--키보드로 년도를 받고자 할 경우
accept year prompt '태어난 년도를 입력하세요';

DECLARE
 --   v_year number(4) := 2023;
    v_year number(4) := '&year';
    v_mod number(2) := mod(v_year,12);
    v_ddi varchar2(10); --띠 저장할 변수
BEGIN
    if v_mod=0 then v_ddi:='원숭이';
    elsif v_mod=1 then v_ddi:='닭';
    elsif v_mod=2 then v_ddi:='개';
    elsif v_mod=3 then v_ddi:='돼지';
    elsif v_mod=4 then v_ddi:='쥐';
    elsif v_mod=5 then v_ddi:='소';
    elsif v_mod=6 then v_ddi:='호랑이';
    elsif v_mod=7 then v_ddi:='토끼';
    elsif v_mod=8 then v_ddi:='용';
    elsif v_mod=9 then v_ddi:='뱀';
    elsif v_mod=10 then v_ddi:='말';
    elsif v_mod=11 then v_ddi:='양';
    end if;
        DBMS_output.put_line(v_year||'년생은 '||v_ddi||'띠 입니다');
end;
/


-------
--db컬럼의 타입을 가져오는 방법 type

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
    
        DBMS_output.put_line('학생명:'||v_name);
        DBMS_output.put_line('키:'||v_height);
        DBMS_output.put_line('자바점수:'||v_java);
        DBMS_output.put_line('스프링점수:'||v_spring);
        DBMS_output.put_line('총점:'||(v_java+v_spring));
        
end;
/



-----

/*

반복문 : loop

loop
    문장들;
    exit when 조건;
end loop;

*/

--------------------
--1~10 출력
DECLARE
    v_no number(2) := 0;

BEGIN
    loop
        v_no := v_no+1;
        DBMS_output.put_line('No='||v_no);
        exit when v_no=10; --10일때 탈출
    end loop;
end;
/


-------
-- 단을 입력하면 해당 단을 출력하세요

accept dan prompt '단를 입력하세요 (1~9)';
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

--예제9 exception처리(예제4 복사)
--상품명을 변수로 지정한 후 
accept sangpum prompt '상품명을 입력하세요?';
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
    DBMS_output.put_line('상품명 '||vsangpum);
    DBMS_output.put_line('색  상 '||vcolor);
    DBMS_output.put_line('단  가 '||vprice);
    DBMS_output.put_line('단  가 '||vprice2);
    
    
    --결과가 없거나 2개이상이면 오류 발생.
    --오라클에서 예외처리 하는 방법
    EXCEPTION
        when no_data_found then
            DBMS_output.put_line(vsangpum||'상품은 db에 없습니다');
        when too_many_rows then
            DBMS_output.put_line(vsangpum||'상품은 db에 2개 이상 존재합니다');
        when OTHERS then
            DBMS_output.put_line(vsangpum||'상품에 대한 오류 발생');
    
    
end;
/


/*

반복문
for 변수 in [reverse]시작값.. 최종값 loop
    문장들;
end loop;


*/

-----예제10 for문으로 변경
accept dan prompt '단를 입력하세요 (1~9)';
DECLARE
    v_dan number(2) := '&dan';
    v_su number(2) := 0;
BEGIN
    DBMS_output.put_line(v_dan||'단');
    for v_su in 1..9 loop
      DBMS_output.put_line(v_dan||'x'||v_su||'='||(v_dan*v_su));
    end loop;
end;
/


---레코드 단위로 데이터 가져오기
DECLARE 
    v_num student.num%type :=1;
    v_stu angel.student%rowtype; --레코드 단위로 읽어올 경우
BEGIN
    select * 
    into v_stu
    from student
    where num=v_num;
        DBMS_output.put_line('이름: '||v_stu.name);
        DBMS_output.put_line('키: '||v_stu.height);
        DBMS_output.put_line('자바: '||v_stu.java);
        DBMS_output.put_line('스프링: '||v_stu.spring);
        DBMS_output.put_line('반: '||v_stu.ban);
end;
/

------DB의 여러 데이터를 조회할 경우
/*
    Cursor : sql문을 실행할때마다 명령이 분석되고 실행되어 결과를 보관하기 위한 
    특별한 메모리 영역을 사용하는데 이 영역을 참조하는 것이 커서다

    select 문에서 여러 데이터 조회시 사용하는 객체

    커서 속성
    sql%rowcount : 실행된 갯수 반환
    sql%found : 가장 최근의 sql문이 하나 이상의 행에 영향을 준경우 true
    sql%notfound : 결과행이 없는 경우
    sql%ispopen : 항상 false(항상 close를 하기 때문에 항상 false)
*/



----------예제 12
DECLARE
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype; --행단위로 가져오기 ?
BEGIN
    select *
    into v_shop
    from shop
    where sang_no=v_sno;

        DBMS_output.put_line('상품명:'||v_shop.sang_name);
        DBMS_output.put_line('조회된 실행갯수:'||sql%rowcount);
    --student의 java 점수 변경하기
    update student 
    set java=99;
    DBMS_output.put_line('수정 실행갯수:'||sql%rowcount);
end;
/


---여러 레코드 조회
--예제 13
DECLARE
    Cursor c
    is 
    select *
    from shop;
BEGIN
        DBMS_output.put_line('상품번호  상품명 색상  가격');
        DBMS_output.put_line('-+-------------------------------');
        for s in c loop
            exit when c%notfound; -- 더이상 데이터가 없으면 빠져나간다
            DBMS_output.put_line(s.sang_no||'   '||s.sang_name||'   '||s.sang_color||'  '||s.sang_price);
        end loop;
end;
/

-----예제 14
--상품명, 색상, 가격을 입력하면 shop db에 추가하기
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
        DBMS_output.put_line('상품정보를 추가했습니다');
end;
/




-----------
--문제 : food 테이블
/*
    fname, fprice, no 입력을 받아서
    no가 1이면 fname, fprice로 데이터 추가를 하고 
    no가 2면 food 전체 데이터 출력 (if문)
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
        DBMS_output.put_line('상품정보를 추가했습니다');
    elsif v_no=2 then
        DBMS_output.put_line(번호||'   '||음식명||'   '||가격);
        for v in f loop
            exit when f%notfound; -- 더이상 데이터가 없으면 빠져나간다
             DBMS_output.put_line(v.food_num||'   '||v.fname||'   '||v.fprice);
        end loop;
    end if;
end;
/


/*
if 조건식 then
    문장1;
else
    문장2;
end if;

다중 if문
if 조건식1 then
    문장1;
elsif 조건2 then
    문장2;
    . . .
end if;
*/
