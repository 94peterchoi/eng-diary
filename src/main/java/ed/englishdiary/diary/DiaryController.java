package ed.englishdiary.diary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @RequestMapping("/list")
    public String getDiaryList() {

        return "diary/diaryList";
    }

    @RequestMapping("/write")
    public String writeDiary() {

        return "diary/writeDiary";
    }

    @RequestMapping("/detail/{diaryId}")
    public String getDiaryDetail(@PathVariable("diaryId") Integer diaryId, HttpServletRequest request) {

        System.out.println("id => " + diaryId);

        return "diary/diaryDetail";
    }

}
