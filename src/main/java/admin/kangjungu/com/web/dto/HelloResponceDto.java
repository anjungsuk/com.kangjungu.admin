package admin.kangjungu.com.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 자동으로 get 파라미터를 자동 생성 어노테이션
@RequiredArgsConstructor // final로 선언된 객체에 대해 생성자를 생성 한다.
public class HelloResponceDto
{
    private final String name;
    private final int amount;

}
