package ed.englishdiary.diary;

import ed.englishdiary.diary.vo.DiaryListFilterDto;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    private final MessageSourceAccessor messageSource;

    public DiaryController(MessageSourceAccessor messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String getDiaryList(@Validated @ModelAttribute final DiaryListFilterDto diaryListFilterDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println("유효성 검증 에러");
        }

        String test = messageSource.getMessage("test");
        System.out.println(test);

        return "diary/diaryList";
    }

    @GetMapping("/write")
    public String writeDiary() {

        return "diary/writeDiary";
    }

    @GetMapping("/detail/{diaryId}")
    public String getDiaryDetail(@PathVariable("diaryId") Integer diaryId, HttpServletRequest request) {

        System.out.println("id => " + diaryId);

        return "diary/diaryDetail";
    }

}
