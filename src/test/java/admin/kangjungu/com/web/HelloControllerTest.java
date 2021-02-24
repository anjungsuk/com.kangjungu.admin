package admin.kangjungu.com.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //@Test와 Junit 사이에 연결자 역활을 한다.
@WebMvcTest(controllers = HelloController.class) //해당 컨트롤러가 정상적으로 작동하는지 확인할때 사용하는 어노테이
public class HelloControllerTest
{
    @Autowired //Spring이 관리하는 Bean을 자동으로 주입 받는다 해당 부분에선 MockMvc의 의존성을 주입받는다.
    private MockMvc mvc; // HelloControllerTest 클래스내 MockMvc mvc 객체 생성

    @Test
    public void hello가_리턴된다() throws Exception
    {
        String hello = "hello"; //문자열 hello 변수 생성
        mvc.perform(get("/hello")) //MockMvc를 통해 /hello를 통한 GET파라미터를 요청한다.
                .andExpect(status().isOk()) //HTTP status 상태를 검증하는 부분
                .andExpect(content().string(hello)); //controller에서 리턴 하기전 해당 값이 맞는지 검증한다.
    }
    @Test
    public void hello_dto_가리턴된다() throws Exception
    {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
            .param("name", name)
            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
