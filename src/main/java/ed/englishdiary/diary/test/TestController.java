package ed.englishdiary.diary.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test/auth/login")
    public String authTest() {

        return "test/authTest";
    }

}
