## 개발환경
이 프로젝트는 다음 환경에서 개발되었습니다.

```
MacOS 10.15 Catalina
Android Studio
Android 9.0 Pie, minimum 6.0

Android 10.0 Q 이상의 환경에서는 저장소 권한이 강화되어 정상 작동하지 않습니다.
```

## 구현내용

```
1. 첫번째 화면(Relative Layout, 로그인)
  - 아이디와 비밀번호를 저장할 txt파일을 찾고, 없다면 새로 생성합니다.
  - 로그인 버튼을 누를때마다 파일에서 아이디를 검색후 비밀번호가 맞는지 검사합니다.
  - 로그인에 실패할때는 토스트 메시지로 실패 문구를 띄웁니다.
```

```
2. 두번째 화면(Linear Layout, 회원가입)
  - 아이디, 비밀번호, 이름, 전화번호, 주소를 계정정보로 받습니다.
  - 아이디는 중복검사를 합니다
  - 비밀번호는 8자리 이상 특수문자, 영어, 숫자가 섞여 있어야합니다.
  - 회원가입 버튼을 누를때 위의 검사한 내용중 미비한 부분이있으면 토스트 메세지를 이용해 경고장을 띄워줍니다.
  - 이름, 전화번호, 주소는 공란인 경우만 검사하며, 이용약관 동의는  라디오 박스를 통해 동의 여부를 검사하고 이용약관의 내용은 생략했습니다. 아무 문제가 없을 경우 회원 txt파일에 저장합니다.
```

```
3. 세번째 화면(Grid Layout, 계산기)
  - 2개의 수를 사칙연산 기호와 입력받고 입력받은 식을 계산합니다 
  - 수는 2개만 입력 가능합니다.
  - 버튼은 1~9까지 있으며 초기화 버튼을 누르면 식 입력칸과 결과값 칸이 null 상태로 최기화되며 식이 이상하게 입력될경우 로그인 페이지로 돌아갑니다.
```
