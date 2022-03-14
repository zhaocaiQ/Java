package blog.blogProject.validator;

import blog.blogProject.dto.MemberDto;
import blog.blogProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component //doValidate를 구현해 검증로직을 작성하고 bean으로 등록될 수 있도록 사용
public class EmailCheckValidator extends AbstractValidator<MemberDto> {
    private final MemberRepository memberRepository;
    @Override protected void doValidate(MemberDto dto, Errors errors) {
        if (memberRepository.existsByEmail(dto.getEmail())) {
            errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일 입니다.");
        }
    }
}
