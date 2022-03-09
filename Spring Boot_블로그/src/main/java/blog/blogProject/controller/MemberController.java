package blog.blogProject.controller;

import blog.blogProject.dto.MemberDto;
import blog.blogProject.entity.Member;
import blog.blogProject.repository.MemberRepository;
import blog.blogProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //회원가입 페이지
    @GetMapping("/signup")
    public String memberForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "login/signup";
    }

    //회원가입
    @PostMapping("/signup")
    public String memberForm(@Valid MemberDto memberDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login/signup";
        }
        try{
            Member member = Member.createMember(memberDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login/signup";
        }
        return "/login/login";
    }

    //로그인페이지 이동
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    //로그인페이지 이동
    @GetMapping("/login/loginSuccess")
    public String loginSuccess(){
        return "redirect:/";
    }

}
