# naver0829study
네이버 클라우드 과정 3기 수업

git-bash

1. git init // 연동할 폴더 초기화
2. git remote add origin https://github.com/Taehyeonn/naver0829study.git // 연결
3. 오류나서 새로운 깃 저장소와 연결ㅇ ㅣ안될 경우  
    git remote set-url origin https://github.com/Taehyeonn/naver0829study.git // 연결
5. git branch // branch 조회
6. git add . 또는 git add 파일명 // 해당 파일들을 로컬 저장소에 추가
7. git commit -m "메세지" // 해당 메세지와 함께 위의 파일들을 로컬저장소에 커밋
8. git push origin master // 원격 저장소의 master 브랜치에 소스 보내기
9. git pull origin 브랜치명 // 원격 저장소의 수정된 내용을 가져올 경우

ls // 브랜치 내 파일 조회
cat 파일명.확장자 // 파일 열기


최초설정  

$ git config --global user.name "John Doe"  

$ git config --global user.email johndoe@example.com

