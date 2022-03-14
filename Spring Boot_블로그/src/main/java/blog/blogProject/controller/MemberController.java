package blog.blogProject.controller;

import blog.blogProject.dto.MemberDto;
import blog.blogProject.entity.Member;
import blog.blogProject.service.MemberService;
import blog.blogProject.validator.EmailCheckValidator;
import blog.blogProject.validator.NicknameCheckValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final NicknameCheckValidator nicknameCheckValidator;
    private final EmailCheckValidator emailCheckValidator;

    /* 커스텀 유효성 검증을 위해 추가 */
    @InitBinder //특정 컨트롤러에서 바인딩 또는 검증 설정을 변경하고 싶을 때 사용
    //WebDataBinder binder : HTTP 요청 정보를 컨트롤러 메소드의 파라미터나 모델에 바인딩할 때 사용되는 바인딩 객체
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(nicknameCheckValidator);
        binder.addValidators(emailCheckValidator);
    }

    //회원가입 페이지
    @GetMapping("/signup")
    public String memberForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "login/signup";
    }

    //회원가입
    @PostMapping("/signup")
    public String memberForm(@Valid MemberDto memberDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            /* 회원가입 실패시 입력 데이터 값을 유지 */
            model.addAttribute("memberDto", memberDto);
            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            /* 회원가입 페이지로 다시 리턴 */
            return "login/signup";
        }
        /* 중복검사 */
        memberService.checkNicknameDuplication(memberDto);
        memberService.checkEmailDuplication(memberDto);
        Member member = Member.createMember(memberDto, passwordEncoder);
        memberService.saveMember(member);
        return "/login/login";
    }

//    //로그인페이지 이동
//    @GetMapping("/login")
//    public String login(){
//        return "login/login";
//    }

    // 폼 불러오는 용도
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false)String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/login/login";
    }

}
