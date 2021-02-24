package admin.kangjungu.com.web.Dto;

import admin.kangjungu.com.web.dto.HelloResponceDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponceDtoTest
{
    @Test
    public void 롬복_기능_테스트()
    {
        String name = "test";
        int amount = 1000;

        HelloResponceDto dto = new HelloResponceDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);//assertThat 메소드내 isEqualTo와 같은 값일 경우에만 성공한다

    }
}

