# naver0829study
네이버 클라우드 과정 3기 수업

jdk 설치 후 환경변수 설정  
1. %JAVA_HOME%
2. path


git-bash

최초설정  
$ git config --global user.name "John Doe"  
$ git config --global user.email johndoe@example.com  

1. git init // 연동할 폴더 초기화
2. git remote add origin https://github.com/Taehyeonn/naver0829study.git // 연결
3. 오류나서 새로운 깃 저장소와 연결이 안될 경우  
    git remote set-url origin https://github.com/Taehyeonn/naver0829study.git // 연결
4. git branch // branch 조회
5. git add . 또는 git add 파일명 // 해당 파일들을 로컬 저장소에 추가
6. git commit -m "메세지" // 해당 메세지와 함께 위의 파일들을 로컬저장소에 커밋
7. git push origin 브랜치명(master) // 원격 저장소의 master 브랜치에 소스 보내기
8. git pull origin 브랜치명 // 원격 저장소의 수정된 내용 가져오기 (깃헙 내용 변경시 필수. 안할시 PUSH 할때 오류)
 
ls // 브랜치 내 파일 조회  
cat 파일명.확장자 // 파일 열기  


cmd  
d: //  드라이브 변경  
cd 폴더주소 // 이동  
cd \ // 최상위 디렉토리로 이동  
dir //  디렉토리 확인  
javac 파일명.java // .java를 .class로 컴파일  
java 파일명 // .class 실행  


git add . //  
git commit -m "JAVA 첫 예제"  
git push origin main // 깃헙에 올리기  
(오류시 git pull origin main)  
















