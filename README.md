# 백엔드 시작하기
## 1. 프로젝트 관리 툴 선택
## 2. 의존성 추가
- Spring Web
  - 풀스택 개발을 위한 옵션
  - 임베디드 톰캣 서버 포함
  - 로깅에 쓸 수 있는 로그백 포함
    - application.properties에
```
logging.levle.root=DEBUG
# DEBUG 로깅 수준과 그 이상에 해당하는 메세지 
```
- Spring Boot DevTools 
  - 자동 재시작 기능( 변경 내용을 저장할 때마다 애플리케이션이 자동으로 재시작)

### 어노테이션
- **@SpringBootApplication**
  - 여러 어노테이션이 조합
  - @EnableAutoConfiguration : 스프링부트 자동 구성 활성화
  - @ComponentScan : 스프링 부트 컴포넌트 검색으로 애플리케이션의 모든 컴포넌트 찾기
  - @Configuration : 빈 정의의 원본으로 쓸 수 있는 클래스 정의
- **의존성 주입 관련 어노테이션**
  - @Autowired : 스프링이 빈을 자동으로 주입하도록 지시. 생성자, 필드, 또는 메서드 사용 가능
  - @Component : 기본적인 빈으로 등록
  - @Service : 비즈니스 로직을 처리하는 서비스 클래스로 사용
  - @Repository : 데이터 액세스 계층에서 사용
  - @Controller : 웹 계층의 컨트롤러로 사용하여 HTTP 요청 처리
- **웹 계층 관련 어노테이션**
  - @RestController : RESTful 웹 서비스를 쉽게 만들 수 있도록 지원
    - 모든 메서드의 반환값이 JSON 또는 XML로 변환
  - @RequestMapping (Get/Post/Put/Delete Mapping)
    - HTTP 요청 메서드에 대해 특정 URL 패턴에 매핑
    - RequestMapping은 모든 HTTP 메서드를 지원하며, 특정 메서드와 매핑할 때는 각각의 어노테이션 사용
  - @PathVariable : URL 경로의 변수 값을 파라미터로 받아온다.
    - 예 : /items/{id}
  - @RequestParam : HTTP 요청의 쿼리 파라미터 값을 파라미터로 받아온다.
  - RequestBody : HTTP 요청 본문에 있는 JSON, XML, 또는 기타 형식의 데이터를 객체로 변환해 파라미터로 받아온다.
  - @ResponseBody : 메서드의 반환값을 JSON 또는 XML 형식으로 변환해 HTTP 응답 본문으로 반환

### h2 database 웹 기반 콘솔 이용
application.properties에   
```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

웹 브라우저에서 localhost:8081/h2-console 이동   
JDBC URL에 url 입력하고 password 비워두기 -> Connect
