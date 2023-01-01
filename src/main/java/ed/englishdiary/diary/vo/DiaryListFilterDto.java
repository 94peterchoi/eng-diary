package ed.englishdiary.diary.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DiaryListFilterDto {

    @NotNull
    private String subject;

    private String target;
    private String orderBy;
    private Integer countPerPage;

}
