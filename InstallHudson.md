# 개요 #
본 문서는 윈도우에 Hudson을 설치하는 문서이다.
Hudson 설치 전에 JDK 1.6 이상, JUnit이 설치되어 있다고 가정한다.

# 설치 파일 다운로드 #
  * http://eclipse.org/hudson/download.php 이동
  * Choose a Distribution - WAR File (generic distribution) 다운로드


# Hudson 설치 #

  * 적당한 폴더에 다운로드 받은 파일을 이동(예. e:\Hudson\)
  * 시작->실행->cmd
```
    > e:
    > cd Hudson
    > java -jar hudson.war --httpPort=8080
```

  * 여기서 httpPort 는 웹서버의 포트이다. 또한 hudson.war는 다운받은 파일의 이름이다.(실제로는 다를 수 있다.)
  * 웹브라우저에서 http://localhost:8080 접속
  * Please wait while Hudson is getting ready to work 라는 메시지가 나오다가 초기화 완료되면 시작 화면이 나온다.

# Hudson 윈도우 서비스 등록 #
  * 좌측 메뉴에서 Hudson 관리 클릭
  * Install as Windows Service 클릭
  * Installation Directory 설정(예. E:\hudson\home)
  * Install button 클릭
  * Installation Complete 메시지가 나오면 Yes 버튼을 눌러 Hudson 재시작

# Hudson 플러그인 설치 #
  * 좌측 메뉴에서 Hudson 관리 클릭
  * 설치 가능 탭 클릭
  * 필요한 플러그인 체크버튼을 체크하고 맨 아래 설치 버튼 클릭
  * 유용한 플러그인
    * Google Calendar Plugin
    * JUnit Attachments Plugin
    * Google Code Plugin
    * Status View Plugin
  * 설치 후 restart when no jobs are running 버튼 클릭

# 새작업 만들기 #
  * 좌측 메뉴에서 새작업 클릭
  * 작업명 입력
  * project 타입 설정( Build a free-style software project 등)
  * Google code website 설정
  * Source Code Management 설정 - Google Code (automatic configuration) 설정 가능
  * Build Triggers 설정
  * 기타 설정 후 save 버튼 클릭