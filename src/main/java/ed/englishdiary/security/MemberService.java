package ed.englishdiary.security;

public interface MemberService {

    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;

}
