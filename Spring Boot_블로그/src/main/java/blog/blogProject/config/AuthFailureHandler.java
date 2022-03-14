package blog.blogProject.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException{
        System.out.println("hadler start");
        String msg = "";
        if(exception instanceof UsernameNotFoundException) {
            msg = "계정이 존재하지 않습니다."; // 계정이 존재하지 않습니다.
        }else if(exception instanceof BadCredentialsException) {
            msg = "아이디 혹은 비밀번호를 잘못 입력했습니다."; // 아이디 혹은 비밀번호를 잘못 입력했습니다.
        }else if(exception instanceof DisabledException) {
            msg = "인증되지 않은 계정입니다."; // 인증되지 않은 계정입니다.(계정 비활성화)
        }else if(exception instanceof SessionAuthenticationException) {
            msg = "중복로그인"; // 중복로그인
        }

        setDefaultFailureUrl("/login?error=true&exception=" + msg);
        super.onAuthenticationFailure(request, response, exception);

    }
}