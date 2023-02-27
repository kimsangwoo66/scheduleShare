package com.example.recard.config;


import com.example.recard.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈등록: 스프링 IOC 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration //빈등록 IOC로 관리
@EnableWebSecurity// 시큐리티 필터가 등록됨 = 스프링 시큐리티가 활성화가 되어있는데 어떤 설정을 해당 파일에서 함 (securityConfig에서)
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;


    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()//csrf 토큰 비활성화 (테스트시 걸어야함)
            .authorizeRequests()
            .antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
            .permitAll()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
            .loginPage("/auth/login") //인증이 필요한 곳으로 요청이오면 자동으로 로그인 페이지 나오게 설정
            .loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당주소로 요청 오는 로그인을 가로채서 대신 로그인
            .defaultSuccessUrl("/main");//로그인 성공시 기본 페이지
    }
}
