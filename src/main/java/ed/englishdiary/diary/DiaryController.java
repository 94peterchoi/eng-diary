package ed.englishdiary.diary;

import ed.englishdiary.diary.domain.Account;
import ed.englishdiary.diary.service.DiaryService;
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
    private final DiaryService diaryService;

    public DiaryController(MessageSourceAccessor messageSource, DiaryService diaryService) {
        this.messageSource = messageSource;
        this.diaryService = diaryService;
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
        Account account = new Account();
        account.setId(1L);
        diaryService.saveDiary(account);

        return "diary/writeDiary";
    }

    @GetMapping("/detail/{diaryId}")
    public String getDiaryDetail(@PathVariable("diaryId") Integer diaryId, HttpServletRequest request) {

        System.out.println("id => " + diaryId);

        return "diary/diaryDetail";
    }

}
