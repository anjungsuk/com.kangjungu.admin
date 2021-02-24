package admin.kangjungu.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//SpringBootApplication 어노테이션을 통한 스프링부트 자동설정, Bean 읽기와 생성을 자동으로 한다.
@SpringBootApplication
//프로젝트 메인 클래스
public class Application
{
    public static void main(String[] args)
    {
        //SpringApplication.run메소드로 웹 애플리케이션 서버를 실행한다.
        SpringApplication.run(Application.class, args);
    }
}
