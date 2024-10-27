# 백엔드 시작하기
## 1. 프로젝트 관리 툴 선택
## 2. 의존성 추가
- **Spring Web**
  - 풀스택 개발을 위한 옵션
  - 임베디드 톰캣 서버 포함
  - 로깅에 쓸 수 있는 로그백 포함
    - application.properties에
```
logging.levle.root=DEBUG
# DEBUG 로깅 수준과 그 이상에 해당하는 메세지 
```
- **Spring Boot DevTools** 
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

## 3. JPA 엔티티 만들기
- JPA 엔티티는 데이터베이스 테이브르이 구조를 나타내는 자바 클래스
- 엔티티 클래스는 JPA의 @Entity 어노테이션을 사용하는 자바 클래스
  - 엔티티 패키지에 엔티티 클래스 만들기 (엔티티 패키지는 루트 패키지에)
  - 기본 키는 @Id로 정의
  - @GeneratedValue는 데이터베이스가 자동으로 ID를 생성하도록 지정
    - 자동으로 ID를 생성하도록 했으므로 생성자에 ID 필드는 필요없다.
- JPA에는 CRUD 작업을 위한 CrudRepository 인터페이스가 있어야 한다.
  - @Query 를 이용하면 SQL문으로 쿼리를 만들 수 있다.
- 테이블 간의 관계 추가
  - @ManyToOne - 기본키가 있는 엔티티 클래스에서 정의
    - 소유자 필드에 대한 getter, setter 추가
    - 연관관계 FetchType.Lazy (대다_toMany관계에서는 기본값)
      - EAGER : 즉시 검색 ,LAZY : 지연 검색

## 4. 데이터베이스 설정
### h2 database 웹 기반 콘솔 이용
application.properties에   
```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

웹 브라우저에서 localhost:8081/h2-console 이동   
JDBC URL에 url 입력하고 password 비워두기 -> Connect
---

- 의존성 추가
```xml
<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
			<version>8.0.33</version>
		</dependency>
```
- application.properties 에 추가
```
spring.datasource.url=jdbc:mysql://localhost:3306/[데이터베이스이름]
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 5. RESTful 웹 서비스 만들기- 스프링 데이터 REST 이용
- 의존성 추가
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
```
  - 기본적으로 애플리케이션에서 모든 공용 레포지터리를 찾고 엔티티를 위한 RESTful 웹 서비스를 자동으로 생성한다.
- application.properties에 엔드포인트 정의
```
spring.data.rest.basePath=/api
```