package admin.kangjungu.com.web;

import admin.kangjungu.com.web.dto.HelloResponceDto;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON 타입으로 반환하는 컨트롤러를 생성
public class HelloController {
    @GetMapping("/hello") //Hello 라는 Get 방식 리퀘스트 요청이 왔을시 api를 생성한다.
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/hello/dto") // "/hello/dto Get 방식 리퀘스트 요청시 api 생
    public HelloResponceDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) //HelloResponceDto 외부에서 api로 넘긴 파라미터를 가져온다.
    {
        return new HelloResponceDto(name, amount);
    }
}
