package blog.blogProject.validator;

import blog.blogProject.dto.MemberDto;
import blog.blogProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class NicknameCheckValidator extends AbstractValidator<MemberDto> {
    private final MemberRepository memberRepository;
    @Override protected void doValidate(MemberDto dto, Errors errors) {
        if (memberRepository.existsByNickname(dto.getNickname())) {
            errors.rejectValue("nickname", "닉네임 중복 오류", "이미 사용중인 닉네임 입니다.");
        }
    }
}

